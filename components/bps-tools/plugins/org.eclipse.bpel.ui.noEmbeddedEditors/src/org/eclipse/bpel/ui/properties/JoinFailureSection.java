/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.properties;

import org.eclipse.bpel.common.ui.details.FocusContext;
import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.details.IValue;
import org.eclipse.bpel.common.ui.details.RadioButtonIValue;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;

/**
 * JoinFailureDetails provides viewing and editing of the suppressJoinFailure
 * attribute of Process and Activity elements.
 */
public class JoinFailureSection extends BPELPropertySection {
	
	protected Button yesRadio, noRadio, sameAsParentRadio;

	Composite fComposite;
	
	EditController fRadioController;
	
	IValue fContext ;
	
	@Override
	protected MultiObjectAdapter[] createAdapters() {
		
		return new MultiObjectAdapter[] {
		/* model object */
		new MultiObjectAdapter() {
			@Override
			public void notify (Notification n) {
				
				Object notifier = n.getNotifier();
				
				if (notifier instanceof Activity  == false || getInput() instanceof Activity == false) {
					return; 
				}
				
				Activity activity = (Activity) notifier;
				Activity myInput  = getModel();
				
				if (n.getFeature() == BPELPackage.eINSTANCE.getActivity_Targets() ) {
					// Check if our targets have changed.
					if (myInput == activity) {
						updateActivity( myInput );
					}
				} else if (n.getFeature() == BPELPackage.eINSTANCE.getActivity_SuppressJoinFailure()) {
					// if another activit's SuppressJoinFailure feature had changed, we may have to change the label.
					if (activity != myInput) {
						updateActivity( myInput );
					}
				}
				
			}
		}, };
	}

	@Override
	protected void addAllAdapters() {
		super.addAllAdapters();
		// Also add adapter[0] to each object in our eContainer() chain which
		// supports it.
		// This is to cover the case where a suppressJoinFailure change in an
		// ancestor changes the meaning of our default setting.
		EObject p = getInput();
		if (p == null) {
			return ;
		}
		
		for (p = p.eContainer(); p != null; p = p.eContainer()) {
			if (p instanceof Activity || p instanceof Process) {			
				fAdapters[0].addToObject(p);
			}
		}
		
	}


	
	protected boolean inheritSuppressed ( Activity activity ) {
		
		Boolean result = null;
		for (EObject p = activity.eContainer(); p != null && result == null ; p = p.eContainer() ) {
			if (p instanceof Activity) {
				Activity a = (Activity) p;
				result = a.getSuppressJoinFailure();
			} else if (p instanceof Process) {
				Process process = (Process) p;
				result = process.getSuppressJoinFailure();
			}
		}
		
		if (result == null) {
			return false;
		}
		return result.booleanValue();
	}

	

	protected void createSuppressJoinFailureWidgets (Composite composite) {
		FlatFormData data;

		Label suppressLabel = fWidgetFactory.createLabel(composite,
				Messages.JoinFailureDetails_Suppress_Join_Failure__1);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0,IDetailsAreaConstants.HSPACE);
		data.top  = new FlatFormAttachment(0,IDetailsAreaConstants.VSPACE);
		suppressLabel.setLayoutData(data);
				
		yesRadio = fWidgetFactory.createButton(composite,
				Messages.JoinFailureDetails_Yes_2, SWT.RADIO);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(
				suppressLabel, STANDARD_LABEL_WIDTH_LRG));
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		yesRadio.setLayoutData(data);
		yesRadio.setData(RadioButtonIValue.VALUE, Boolean.TRUE );
		
		noRadio = fWidgetFactory.createButton(composite,
				Messages.JoinFailureDetails_No_3, SWT.RADIO);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(yesRadio,
				IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(yesRadio, 0, SWT.CENTER);
		noRadio.setLayoutData(data);
		noRadio.setData(RadioButtonIValue.VALUE, Boolean.FALSE );
		
		sameAsParentRadio = fWidgetFactory.createButton(composite,
				Messages.JoinFailureDetails_Use_Same_Value_as_Parent_4,
				SWT.RADIO);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(noRadio,
				IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(yesRadio, 0, SWT.CENTER);
		sameAsParentRadio.setLayoutData(data);
		sameAsParentRadio.setData(RadioButtonIValue.VALUE, RadioButtonIValue.UNSET_VALUE );
				
		fContext = new FocusContext(yesRadio,noRadio,sameAsParentRadio);
	}

	protected void createControllers  () {
		fRadioController = createEditController();
		fRadioController.setViewIValue (new RadioButtonIValue(yesRadio, noRadio,sameAsParentRadio) );
		fRadioController.startListeningTo( yesRadio, noRadio,sameAsParentRadio );
	}
	
	@Override
	protected void createClient(Composite parent) {
		fComposite = createFlatFormComposite(parent);
		createSuppressJoinFailureWidgets(fComposite);
		createControllers();
    PlatformUI.getWorkbench().getHelpSystem().setHelp(fComposite, IHelpContextIds.PROPERTY_PAGE_JOIN_FAILURE);
	}
	
	@Override
	protected void basicSetInput(EObject newInput) {
		
		if (newInput instanceof Process) {
			fRadioController.setFeature( BPELPackage.eINSTANCE.getProcess_SuppressJoinFailure());
			fRadioController.setInput(newInput);
			sameAsParentRadio.setEnabled(false);			
			
		} else if (newInput instanceof Activity) {
			fRadioController.setFeature( BPELPackage.eINSTANCE.getActivity_SuppressJoinFailure());
			fRadioController.setInput(newInput);			
			updateActivity( (Activity) newInput );
		} 				
	}
	
	protected void updateActivity ( Activity activity ) {
		
		boolean bEnable = activity.getTargets() != null;
		
		fComposite.setEnabled( bEnable ) ;
		yesRadio.setEnabled(bEnable);
		noRadio.setEnabled(bEnable);
		sameAsParentRadio.setEnabled(bEnable);
		
		String newDefault = inheritSuppressed( activity ) ? Messages.JoinFailureDetails_Use_Same_Value_as_Parent__Yes__5
				: Messages.JoinFailureDetails_Use_Same_Value_as_Parent__No__6;
		
		if (!sameAsParentRadio.getText().equals(newDefault)) {
			sameAsParentRadio.setText(newDefault);
			sameAsParentRadio.getParent().layout(true);
		}
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getUserContext()
	 */
	@Override
	public Object getUserContext() {
		return fContext.get();
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#restoreUserContext(java.lang.Object)
	 */
	@Override
	public void restoreUserContext(Object userContext) {
		fContext.set(userContext);
	}
}

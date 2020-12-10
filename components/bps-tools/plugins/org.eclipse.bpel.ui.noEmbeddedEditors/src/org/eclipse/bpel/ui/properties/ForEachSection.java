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

import org.eclipse.bpel.common.ui.details.ButtonIValue;
import org.eclipse.bpel.common.ui.details.DelegateIValue;
import org.eclipse.bpel.common.ui.details.FocusContext;
import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.details.IValue;
import org.eclipse.bpel.common.ui.details.TextIValue;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.factories.BPELUIObjectFactory;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.XSDUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

/**
 * Details section for the ForEach activity
 */
public class ForEachSection extends BPELPropertySection {

	Text				fCounterNameText;
	Composite			counterNameVariableComposite;
	Button				fIsParallelCheckbox;
	Composite			isParallelComposite;
	
	EditController fParallelExecutionController ;
	EditController fVariableNameController;
	
	IValue fContext;
	
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
	public void restoreUserContext (Object userContext) {
		fContext.set(userContext);
	}

	
	@Override
	protected void basicSetInput(EObject newInput) {		
		super.basicSetInput(newInput);
		
		fParallelExecutionController.setInput(newInput);
		fVariableNameController.setInput(newInput);
	}

	void createChangeTrackers() {
		
		/** Parallel execution setting/un-setting */
		fParallelExecutionController = createEditController();
		fParallelExecutionController.setFeature( BPELPackage.eINSTANCE.getForEach_Parallel() );
		fParallelExecutionController.setViewIValue( new ButtonIValue( fIsParallelCheckbox ));
		fParallelExecutionController.startListeningTo( fIsParallelCheckbox );
		
	
		/** Variable name setting/un-setting */
		fVariableNameController = createEditController();				
		
		fVariableNameController.setFeature( BPELPackage.eINSTANCE.getForEach_CounterName() );
		fVariableNameController.setViewIValue( new DelegateIValue( new TextIValue ( fCounterNameText ) ) {
			@Override
			public Object get() {
				String name = (String) fDelegate.get();
				if (name.length() == 0) {
					return null;
				}
				/** Convert text to variable for insertion into for each */
				Variable variable =  BPELFactory.eINSTANCE.createVariable(); 
				variable.setName(name);
				variable.setType( XSDUtils.getPrimitive(BPELUIObjectFactory.FOR_EACH_COUNTER_VARIABLE_TYPE) );
				return variable;
			}

			@Override
			public void set( Object object ) {
				if( object == null )
					fDelegate.set( null );
				else
					fDelegate.set(((Variable) object).getName());
			}
			
		});
		fVariableNameController.startListeningTo(fCounterNameText);
		
		
	}

	private void createCounterNameWidgets(Composite parentComposite) {
		FlatFormData data;

		counterNameVariableComposite = createFlatFormComposite(parentComposite);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.top = new FlatFormAttachment(isParallelComposite,
				IDetailsAreaConstants.VSPACE);
		data.right = new FlatFormAttachment(100, 0);
		counterNameVariableComposite.setLayoutData(data);

		Label variableLabel = fWidgetFactory
				.createLabel(
						counterNameVariableComposite,
						Messages.ForEachSection_COUNTER_NAME);

		fCounterNameText = fWidgetFactory.createText(counterNameVariableComposite,EMPTY_STRING);
		data = new FlatFormData();
		data.top = new FlatFormAttachment(0, 0);
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(
				variableLabel, STANDARD_LABEL_WIDTH_AVG));
		data.right = new FlatFormAttachment(100, 0);
		fCounterNameText.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(fCounterNameText,
				-IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(fCounterNameText, 0, SWT.CENTER);
		variableLabel.setLayoutData(data);

	}

	private void createIsParallelWidgets(Composite parentComposite) {
		FlatFormData data;

		isParallelComposite = createFlatFormComposite(parentComposite);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.top = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		isParallelComposite.setLayoutData(data);

		fIsParallelCheckbox = fWidgetFactory
				.createButton(
						isParallelComposite,
						Messages.ForEachSection_IS_PARALLEL,
						SWT.CHECK);
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.top = new FlatFormAttachment(0, 0);
		fIsParallelCheckbox.setLayoutData(data);
	}

	
	@Override
	protected void createClient(Composite parent) {
		Composite parentComposite = createFlatFormComposite(parent);
		createIsParallelWidgets(parentComposite);
		createCounterNameWidgets(parentComposite);
		fContext = new FocusContext ( fIsParallelCheckbox, fCounterNameText );
		
		createChangeTrackers();
		
    PlatformUI.getWorkbench().getHelpSystem().setHelp(
      parentComposite, IHelpContextIds.PROPERTY_PAGE_FOR_EACH);
	}
}

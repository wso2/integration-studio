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

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.details.IValue;
import org.eclipse.bpel.common.ui.details.TextIValue;
import org.eclipse.bpel.common.ui.details.widgets.DecoratedLabel;
import org.eclipse.bpel.common.ui.details.widgets.StatusLabel2;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.INamedElement;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;


/**
 * Details section for the "name" property (which is common to most BPEL elements).
 */

@SuppressWarnings("boxing")
public class NameSection extends BPELPropertySection {
	
	protected Text fNameText;
	
	protected StatusLabel2 statusLabel;

	protected EditController fNameEditController;

	INamedElement fNamedElement;
		
	
	@Override
	protected MultiObjectAdapter[] createAdapters() {
		return new MultiObjectAdapter[] {
			/* model object */
			new MultiObjectAdapter() {
				
				@Override
				public void notify (Notification n) {
					if (markersHaveChanged(n)) {
						updateMarkers();
						return ;
					}
				}
			},
		};
	}

	@Override
	protected void basicSetInput (EObject input) {
		super.basicSetInput(input);

		fNamedElement = BPELUtil.adapt(input,INamedElement.class);
		
		fNameEditController.setInput(input);
	}
	

	protected void createNameWidgets(Composite composite) {
		FlatFormData data;

		DecoratedLabel nameLabel = new DecoratedLabel(composite,SWT.LEFT);
		fWidgetFactory.adapt(nameLabel);		
		nameLabel.setText(Messages.NameDetails_BPEL_Name__3); 
		statusLabel = new StatusLabel2( nameLabel );		
		
		fNameText = fWidgetFactory.createText(composite, EMPTY_STRING);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(nameLabel, STANDARD_LABEL_WIDTH_AVG));
		data.right = new FlatFormAttachment(100, (-2) * IDetailsAreaConstants.HSPACE );
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE );
		fNameText.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(fNameText, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(fNameText, 0, SWT.CENTER);
		nameLabel.setLayoutData(data);
				
		
		
	}
	
	protected void createChangeTrackers() {
			
		
//		fChangeHelper = new ChangeHelper ( getCommandFramework() ) {
//			public String getLabel() {
//				return IBPELUIConstants.CMD_EDIT_NAME;
//			}
//			public Command createApplyCommand() {
//									
//				final String newName = fNameText.getText().trim();
//				
//				if (newName.length() == 0 || newName.equals(namedElement.getName(getModel()))) {
//					return null; // there is nothing to be done
//				}
//				
//				return wrapInShowContextCommand(
//						new UpdateModelCommand(getInput(), getLabel() ) {							
//							@Override
//							public void doExecute() {
//								namedElement.setName(fTarget, newName);
//							}													
//						});						
//			}
//			
//			public void restoreOldState() {
//				updateNameWidgets();
//			}			
//		};
//		
//		fChangeHelper.startListeningTo(fNameText);
//		
		
		/** TODO: Empty Name should never be set */
		
		fNameEditController = new EditController(getCommandFramework()) {
			@Override
			public boolean checkNotification (Notification notification) {
				return fNamedElement != null && fNamedElement.isNameAffected(fNameEditController.getInput(), notification);				
			}
			@Override
			public Command createApplyCommand() {
				return wrapInShowContextCommand( super.createApplyCommand() );
			}
			
		};		
		fNameEditController.setLabel( BPELPackage.eINSTANCE.getActivity_Name().getName() );
		
		fNameEditController.setViewIValue(new TextIValue ( fNameText )) ;
		fNameEditController.setModeIValue(new IValue () {
			public Object get() {			
				return fNamedElement != null ? fNamedElement.getName( fNameEditController.getInput() ) : null;
			}
			public void set (Object object) {				
				if (fNamedElement != null) {
					fNamedElement.setName(fNameEditController.getInput(),object.toString() );								
				}
			}			
		});
		
		fNameEditController.startListeningTo(fNameText);
	
	}
	
	@Override
	protected void createClient(Composite parent) {
		Composite composite = createFlatFormComposite(parent);
		createNameWidgets(composite);
		createChangeTrackers();
		PlatformUI.getWorkbench().getHelpSystem().setHelp(
			composite, IHelpContextIds.PROPERTY_PAGE_NAME);
	}

	
	
	@Override
	protected void updateMarkers () {				
		statusLabel.clear();		
		for(IMarker m : getMarkers(getInput())) {
			statusLabel.addStatus( BPELUtil.adapt(m, IStatus.class) );
		}		
	}
	
	
	protected IStatus validate() {
		// IStatus status = ValidationHelper.validateXML_NCName(nameText.getText());
		//if (status.isOK())
			return validate(getInput());
		//else
		//   return status;
	}

	protected IStatus validate (Object currentElement ) {
		
		if (currentElement instanceof EObject) { // i.e. PartnerLink,Variable, Correlation Set, etc.
			
			EObject elm = (EObject) currentElement;
			
			EObject elmContainer = elm.eContainer();
			
			if (elmContainer != null) {				
				EList el = elmContainer.eContents();
				for(int i=0, j=el.size() ; i < j; i++) {
					Object next = el.get(i);
					if ((next instanceof EObject) == false) {
						continue;
					}
					EObject loopElement = (EObject) next;

                    EAttribute eAttribute = getNAMEAttribute(loopElement.eClass().getEAllAttributes() );
            
                    if (eAttribute != null) {
                        Object name = loopElement.eGet(eAttribute);
                        if (name != null) {
                            // is there another element with the same name?
                            if (name.equals(fNameText.getText()) && !loopElement.equals(currentElement)) {   
                                String message = NLS.bind(Messages.NameDetails_RenameErrorMessage, (new Object[] {fNameText.getText()})); 
                                return new Status( IStatus.ERROR, BPELUIPlugin.PLUGIN_ID, IStatus.ERROR, message, null);
                            } 
                        }
                    }					
				}
			}
		}
        return new Status( IStatus.OK, BPELUIPlugin.PLUGIN_ID, IStatus.OK, "Hi There", null); //$NON-NLS-1$
	} 
    
	
	
	protected EAttribute getNAMEAttribute(EList list) {
		
		if (list != null) {
			for (int i = 0; i < list.size();i++) {
				EObject eo = (EObject)list.get(i);
				
				if (eo instanceof EAttribute) {
					EAttribute ea = (EAttribute)eo;
					
					if (ea.getName().equalsIgnoreCase("name")) { //$NON-NLS-1$
						return (EAttribute)eo;
					}
				}
			}
		}
		return null;					
	}
	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getUserContext()
	 */
	@Override
	public Object getUserContext() {
		return null;
	}
	
	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#restoreUserContext(java.lang.Object)
	 */
	@Override
	public void restoreUserContext(Object userContext) {
		fNameText.setFocus();
	}

	/**
	 * Goto the specific marker. This is only called when isValidMarker
	 * returns true.
	 * 
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#gotoMarker(org.eclipse.core.resources.IMarker)
	 */
	
	@Override
	public void gotoMarker (IMarker marker) {
		fNameText.setFocus() ;		
	}

	/**
	 * 
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#isValidMarker(org.eclipse.core.resources.IMarker)
	 */
	
	@Override
	public boolean isValidMarker (IMarker marker) {
		String context = null;
		try {
			context = (String) marker.getAttribute("href.context");
		} catch (Exception ex) {
			return false;
		}
		return "name".equals (context);
	}	
}

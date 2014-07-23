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
import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.common.ui.flatui.FlatFormLayout;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Pick;
import org.eclipse.bpel.model.Receive;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;


/**
 * Details section for the "createInstance" property of Receive and Pick activities.
 */
public class CreateInstanceSection extends BPELPropertySection  {

	Button fCreateInstanceButton;	
	EditController fCreteInstanceController ;


	protected void createChangeTrackers() {	
		fCreteInstanceController = createEditController();
		fCreteInstanceController.setViewIValue(new ButtonIValue(fCreateInstanceButton));
		fCreteInstanceController.startListeningTo(fCreateInstanceButton);
	}

	@Override
	protected void basicSetInput(EObject newInput) {

		super.basicSetInput(newInput);
		
		if (newInput instanceof Receive) {
			fCreteInstanceController.setFeature(BPELPackage.eINSTANCE.getReceive_CreateInstance());
			fCreteInstanceController.setInput(newInput);
		} else if (newInput instanceof Pick) {
			fCreteInstanceController.setFeature(BPELPackage.eINSTANCE.getPick_CreateInstance());
			fCreteInstanceController.setInput(newInput);
		} else {
			fCreteInstanceController.setFeature( null );		
			fCreteInstanceController.setInput(newInput);
		}
	}

	protected void createCreateInstanceWidgets(Composite composite) {
		FlatFormData data;
		
		Composite parent = fWidgetFactory.createComposite(composite);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		
		parent.setLayoutData(data);
		parent.setLayout(new FillLayout());

		fCreateInstanceButton = fWidgetFactory.createButton(parent, Messages.CreateInstanceDetails_Create_a_new_Process_instance_if_one_does_not_already_exist_1, SWT.CHECK); 
	}
	
	@Override
	protected void createClient(Composite parent) {
		Composite composite = createFlatFormComposite(parent);
		// HACK: the checkbox by itself looks cramped..give it a little extra space
		((FlatFormLayout)composite.getLayout()).marginHeight += 3;

		createCreateInstanceWidgets(composite);
		createChangeTrackers();

		PlatformUI.getWorkbench().getHelpSystem().setHelp(
			composite, IHelpContextIds.PROPERTY_PAGE_PICK_IMPLEMENTATION);
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
		fCreateInstanceButton.setFocus();
		
	}
	
	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#shouldUseExtraSpace()
	 */
	@Override
	public boolean shouldUseExtraSpace () {
		return false;
	}
	
	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#getMinimumHeight()
	 */
	@Override
	public int getMinimumHeight () {
		return 40;
	}
}

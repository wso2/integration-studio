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
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.common.ui.flatui.FlatFormLayout;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;


/**
 * ScopeImplDetails provides specifying variable access serialization
 */
public class ScopeImplSection extends BPELPropertySection {

	protected Button fIsolatedButton;
	protected EditController fIsolatedController ;
	
	protected Composite parentComposite;
	
	protected void createChangeTrackers() {		
		fIsolatedController = createEditController();
		fIsolatedController.setFeature( BPELPackage.eINSTANCE.getScope_Isolated());
		fIsolatedController.setViewIValue( new ButtonIValue( fIsolatedButton ) );
		fIsolatedController.startListeningTo(fIsolatedButton);
		
	}

	protected void createScopeWidgets(Composite composite) {
		FlatFormData data;
		
		 // serializable
		 data = new FlatFormData();
		 fIsolatedButton = fWidgetFactory.createButton(composite, Messages.VariableImplDetails_Isolated__6, SWT.CHECK); 
		 data.left = new FlatFormAttachment(0, 0);
		 fIsolatedButton.setLayoutData(data);
	}

	@Override
	protected void createClient(Composite parent) {
		Composite composite = parentComposite = fWidgetFactory.createComposite(parent, SWT.NONE);
		FlatFormLayout layout = new FlatFormLayout();
		layout.marginWidth = layout.marginHeight = 0;
		composite.setLayout(layout);

		createScopeWidgets(composite);
		createChangeTrackers();

		PlatformUI.getWorkbench().getHelpSystem().setHelp(
			parentComposite, IHelpContextIds.PROPERTY_PAGE_SCOPE_IMPLEMENTATION);
	}
	
	

	@Override
	protected void basicSetInput(EObject newInput) {
		super.basicSetInput(newInput);
		
		fIsolatedController.setInput(newInput);
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
	public void restoreUserContext (Object userContext) {
		fIsolatedButton.setFocus();
	}
}

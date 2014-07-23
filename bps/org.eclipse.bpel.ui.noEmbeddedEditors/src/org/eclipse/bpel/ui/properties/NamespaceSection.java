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

import org.eclipse.bpel.common.ui.details.DelegateIValue;
import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.details.TextIValue;
import org.eclipse.bpel.common.ui.details.widgets.StatusLabel2;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.NamespaceUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;


/**
 * @author Original Contribution by IBM
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 26, 2007
 *
 */
public class NamespaceSection extends BPELPropertySection {


	protected Text namespaceText;
	protected StatusLabel2 statusLabel;
	
	protected EditController fNamspaceEditHelper;
	

	protected void createNamespaceWidgets(Composite composite) {
		FlatFormData data;

		Label namespaceLabel = fWidgetFactory.createLabel(composite, Messages.NamespaceSection_Target_namespace_1); 
	
		namespaceText = fWidgetFactory.createText(composite, EMPTY_STRING);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(namespaceLabel, STANDARD_LABEL_WIDTH_AVG));
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(0, 0);
		namespaceText.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(namespaceText, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(namespaceText, 0, SWT.CENTER);
		namespaceLabel.setLayoutData(data);
	}
	
	protected void createChangeTrackers() {
		
		fNamspaceEditHelper = createEditController() ;
		fNamspaceEditHelper.setFeature( BPELPackage.eINSTANCE.getProcess_TargetNamespace() );
		fNamspaceEditHelper.setViewIValue(new DelegateIValue( new TextIValue ( namespaceText )) {
			@Override
			public String get() {
				String text = fDelegate.get().toString();
				return EMPTY_STRING.equals(text) ? null : NamespaceUtils.convertNamespaceToUri(text);
			}
			@Override
			public void set (Object object) {
				if (object == null) {
					fDelegate.set(EMPTY_STRING);
					return;
				}							
				fDelegate.set( NamespaceUtils.convertUriToNamespace( object.toString() ) );
			}			
		});		
		fNamspaceEditHelper.startListeningTo(namespaceText);
		
	}
	
	
	
	@Override
	protected void createClient(Composite parent) {
		Composite composite = createFlatFormComposite(parent);
		createNamespaceWidgets(composite);
		createChangeTrackers();
		PlatformUI.getWorkbench().getHelpSystem().setHelp(composite, IHelpContextIds.PROPERTY_PAGE_NAMESPACE);
	}

	@Override
	protected void basicSetInput(EObject newInput) {		
		super.basicSetInput(newInput);
		fNamspaceEditHelper.setInput (newInput);
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
		namespaceText.setFocus();
	}
}

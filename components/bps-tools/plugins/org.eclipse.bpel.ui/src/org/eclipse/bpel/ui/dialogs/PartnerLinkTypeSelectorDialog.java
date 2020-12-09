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
package org.eclipse.bpel.ui.dialogs;


import java.util.List;

import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.details.providers.CompositeContentProvider;
import org.eclipse.bpel.ui.details.providers.GatedContentProvider;
import org.eclipse.bpel.ui.details.providers.ModelLabelProvider;
import org.eclipse.bpel.ui.details.providers.PartnerLinkTypeContentProvider;
import org.eclipse.bpel.ui.details.providers.PartnerLinkTypeTreeContentProvider;
import org.eclipse.bpel.ui.details.providers.PortTypeContentProvider;
import org.eclipse.bpel.ui.details.providers.WSDLDefinitionFromResourceContentProvider;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.bpel.ui.wizards.CreatePartnerLinkWizard;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.PortType;


/**
 * Browse for partner link types available and choose that partner link type.
 * 
 * In BPEL, partner link types are extensions on the WSDL definitions.  
 * 
 * When browsing for partner link types, two modes are supported by this dialog.
 * 1) Browsing partner link types which exist in imported WSDLs.
 * 2) Browsing for available partner links. This includes partner 
 * link types visible in the workspace.
 * 
 * In addition, one can arbitrarily add an import to the process if the WSDL
 * representing the partner links is somewhere else (URL, outside file, etc).
 * 
 *  @author Michal Chmielewski (michal.chmielewski@oracle.com)   
 */


public class PartnerLinkTypeSelectorDialog extends BrowseSelectorDialog {	
	
	private static final int BID_SHOW_PORT_TYPES = IDialogConstants.CLIENT_ID + 200;

	private static final String SHOW_PORT_TYPES = Messages.PartnerLinkTypeSelectorDialog_0;
	
	private boolean showPortTypes = false;
	
	GatedContentProvider portTypeContentProvider;

	PartnerLinkType fPartnerLinkType;

	/** Show port types check box button */
	Button fShowPortTypes;
	

	/**
	 * Create a brand new shiny Partner Link Type Selector dialog.
	 * 
	 * @param parent the parent shell
	 * @param eObj a BPEL model object
	 */
	
	public PartnerLinkTypeSelectorDialog (Shell parent, EObject eObj ) {
		super(parent, new ModelLabelProvider(eObj));
		
		this.modelObject = eObj;		
		
		portTypeContentProvider = new GatedContentProvider ( new PortTypeContentProvider () );
		
		// This content provider sets up elements in the list
		CompositeContentProvider ccp = new CompositeContentProvider ();
		ccp.add ( new PartnerLinkTypeContentProvider() );
		ccp.add ( portTypeContentProvider );
		 
		
		contentProvider = ccp;
		
		// This content provider sets up WSDLDefinitions resources
		resourceContentProvider = new WSDLDefinitionFromResourceContentProvider( modelObject.eResource().getResourceSet() );
		// that's for the tree view
		treeContentProvider = new PartnerLinkTypeTreeContentProvider(true);
		
		setTitle(Messages.PartnerLinkTypeSelectorDialog_1);

		setLowerViewLabel(Messages.PartnerLinkTypeSelectorDialog_2);	
		setBrowseFromLabel(Messages.PartnerLinkTypeSelectorDialog_3);
		
		IDialogSettings settings = getDialogSettings();
		try {
			showPortTypes = settings.getBoolean(SHOW_PORT_TYPES);
		} catch (Exception ex) {
			showPortTypes = false;
		}		
		portTypeContentProvider.setEnabled( showPortTypes );
	}
	

	@Override
	protected Control createContents(Composite parent) {
		
		Control control = super.createContents(parent);
					
		refresh();		

		return control;
	}


	@Override
	protected void saveSettings () {
		super.saveSettings();		
		IDialogSettings settings = getDialogSettings();				
		settings.put ( SHOW_PORT_TYPES, showPortTypes);		
	}	
	
	/**
	 * Handle the check button and radio button callbacks.
	 * 
	 * @param id
	 * @param checked
	 * @param bRefresh perform refresh at the end 
	 */
	
	@Override
	protected void buttonPressed (int id, boolean checked, boolean bRefresh ) {
		
		switch (id) {

		case BID_SHOW_PORT_TYPES :
			showPortTypes = checked;
			portTypeContentProvider.setEnabled( showPortTypes );
			break;
							
		default :
			super.buttonPressed(id, checked, bRefresh );			
			return ;
		}

		
		if (bRefresh) {			
			refresh();
		}
	}
		
	
	@Override
	protected void computeResult() {
		
		if (fPartnerLinkType != null) {
			setResult(0, fPartnerLinkType);
		} else {
			super.computeResult();
		}
    }
	  
	
	@Override
	protected void okPressed() {
		
		computeResult();
		
		Object obj = getFirstResult();
		
		if (obj instanceof PortType) {
		
			PortType pt = (PortType) obj;
			CreatePartnerLinkWizard wizard = new CreatePartnerLinkWizard();
			wizard.setMandatoryPortType( pt );
			
			wizard.setBPELEditor( ModelHelper.getBPELEditor( pt ) );
			WizardDialog dialog = new WizardDialog(getShell(), wizard);
			
			if (dialog.open() == Window.CANCEL) {
				return ;
			}
			
			fPartnerLinkType = wizard.getPartnerLinkType();
			if (fPartnerLinkType == null) { 
				return ;
			}		
			if (!checkNamespace(fPartnerLinkType)){
				return;
			}
			
			super.okPressed();
						
			return ;
		}
		
		
		if (obj instanceof PartnerLinkType) {			
			if (!checkNamespace((PartnerLinkType)obj)){
				return;
			}
			
			super.okPressed();
			return;
		}
		// 
		
		throw new IllegalStateException(Messages.PartnerLinkTypeSelectorDialog_4);
	}
	
	private boolean checkNamespace(PartnerLinkType obj) {
		// Now check if the target namespace has a prefix mappings.
		String targetNamespace = obj.getEnclosingDefinition().getTargetNamespace();
		
		String prefix = BPELUtils.getNamespacePrefix (modelObject, targetNamespace);
		if (prefix != null) {
			return true;
		}
		
		// We have to map the namespace to a prefix. 
		NamespaceMappingDialog dialog = new NamespaceMappingDialog(getShell(), modelObject);
		dialog.setNamespace( targetNamespace );
		
		if (dialog.open() == Window.CANCEL) {
			return false;
		}
		
		// define the prefix
		BPELUtils.setPrefix(BPELUtils.getProcess(modelObject), targetNamespace, dialog.getPrefix());
		return true;
	}


	@Override
	protected void createBrowseFilterGroupButtons ( Group  group ) {
        
		fShowPortTypes = createCheckButton(group,Messages.PartnerLinkTypeSelectorDialog_5, 
				BID_SHOW_PORT_TYPES, 
				showPortTypes  );
		
		super.createBrowseFilterGroupButtons( group );
	}
	
	
	/**
	 * Add an import using an explicit import dialog selection. 
	 * 
	 * We safeguard against adding duplicate types to the BPEL model here as well.
	 * 
	 */
	@Override
	protected void handleAddImport() {
	
		SchemaImportDialog dialog = new SchemaImportDialog(getShell(),modelObject);
		dialog.configureAsWSDLImport();
		
		if (dialog.open() == Window.CANCEL) {
			return ;
		}
		Object obj = dialog.getFirstResult();		
		if (obj == null) {
			return ;
		}		
		if (handleAddImport( obj )) {
			showImportedTypes();
			refresh();
		}
	}
	
	@Override
	protected void showImportedTypes () {	
		fShowPortTypes.setSelection(true);
		buttonPressed(BID_SHOW_PORT_TYPES,true, false);		
		super.showImportedTypes();
	}
	
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, 
				BID_ADD_IMPORT,
				Messages.PartnerLinkTypeSelectorDialog_6, 
				false);		
		super.createButtonsForButtonBar(parent);
	}
	
	/**
	 * In the case of partner link types, we need to see a few more levels
	 *  
	 */
	
	@Override
	protected int getAutoExpandLevel () {
		return 5;
	}
	
	
	
	@Override
	protected List<Definition> collectItemsFromImports ( ) {
		return ModelHelper.getDefinitions(modelObject);
	}
			
}

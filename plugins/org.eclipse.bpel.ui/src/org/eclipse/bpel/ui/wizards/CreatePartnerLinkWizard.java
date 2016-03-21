/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.wizards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.common.ui.editmodel.EditModel;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypeFactory;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.commands.AddWSDLImportCommand;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.CreatePartnerLinkTypeCommand;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.PortType;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 14, 2006
 *
 */
public class CreatePartnerLinkWizard extends Wizard {

	CreatePartnerLinkTypeWizardNamePage fFirstPage;
	CreatePartnerLinkTypeWizardRolePage fRolePage1;
	CreatePartnerLinkTypeWizardRolePage fRolePage2;
	PortType fMandatoryPortType;
	PartnerLinkType fPartnerLinkType;
	
	BPELEditor fEditor;

	
	public CreatePartnerLinkWizard () {
		setNeedsProgressMonitor(true);
		setDialogSettings(BPELUIPlugin.INSTANCE.getDialogSettingsFor(this));		
		setHelpAvailable(false);
		setWindowTitle(Messages.CreatePartnerLinkWizard_0);
	}
	
	public PartnerLinkType getPartnerLinkType () {
		return fPartnerLinkType;
	}
	
	public void setMandatoryPortType (PortType pt) {
		fMandatoryPortType = pt;
	}
	
	public void setBPELEditor ( BPELEditor editor ) {
		fEditor = editor;
	}

	@Override
	public void addPages() {
		fFirstPage = new CreatePartnerLinkTypeWizardNamePage("name.page"); //$NON-NLS-1$
		fFirstPage.setTitle(Messages.CreatePartnerLinkWizard_2);
		fFirstPage.setDescription(Messages.CreatePartnerLinkWizard_3);
		fFirstPage.setImageDescriptor(BPELUIPlugin.INSTANCE.getImageDescriptor(
				IBPELUIConstants.ICON_WIZARD_BANNER));
		fFirstPage.setDefinitions ( fEditor.getArtifactsDefinition() );
		
		fRolePage1 = new CreatePartnerLinkTypeWizardRolePage ("role.1"); //$NON-NLS-1$
		fRolePage1.setTitle(Messages.CreatePartnerLinkWizard_5);
		fRolePage1.setDescription(Messages.CreatePartnerLinkWizard_6);
		fRolePage1.setImageDescriptor(BPELUIPlugin.INSTANCE.getImageDescriptor(
				IBPELUIConstants.ICON_WIZARD_BANNER));		
		fRolePage1.setMandatoryDefinition( fMandatoryPortType.getEnclosingDefinition() );
		
		
		fRolePage2 = new CreatePartnerLinkTypeWizardRolePage ("role.2"); //$NON-NLS-1$
		fRolePage2.setTitle(Messages.CreatePartnerLinkWizard_8);
		fRolePage2.setDescription(Messages.CreatePartnerLinkWizard_9);
		fRolePage2.setImageDescriptor(BPELUIPlugin.INSTANCE.getImageDescriptor(
				IBPELUIConstants.ICON_WIZARD_BANNER));
		
		IFile file = EditModel.getIFileForURI(fMandatoryPortType.eResource().getURI());
		if (file==null)
			// Bugzilla 324164
			// if WSDL is not a file (e.g. http://service.com?WSDL) use editor's input file project
			file = ((FileEditorInput)fEditor.getEditorInput()).getFile();
		
		if (file!=null)
			fRolePage2.setOptionalDefinitions( getOptionalDefinitions(file.getProject()) );
		fRolePage2.setOptional(true);
		
		
		fRolePage1.setOtherRolePage ( fRolePage2 );
		fRolePage2.setOtherRolePage ( fRolePage1 );
		
		addPage(fFirstPage);
		addPage(fRolePage1);
		addPage(fRolePage2);
		
		fRolePage1.setPreviousPage( fFirstPage );
		fRolePage2.setPreviousPage (fRolePage1);
	}

	
	
	private List<Definition> getOptionalDefinitions(IProject project) {
		final List<Definition> wsdlDefinitions = new ArrayList<Definition>();	
		final List<IFile> wsdlFiles = new ArrayList<IFile>();
		IResourceVisitor visitor = new IResourceVisitor() {
			public boolean visit(org.eclipse.core.resources.IResource resource) throws org.eclipse.core.runtime.CoreException {
				if (resource.getType() == IResource.FILE && "wsdl".equalsIgnoreCase(resource.getFileExtension())) {
					
					IFile artifactFile = EditModel.getIFileForURI(fEditor.getArtifactsDefinition().eResource().getURI());
					if (artifactFile==null || !(artifactFile.getFullPath().equals(((IFile)resource).getFullPath()))) {
						//filter artifacts WSDL
						wsdlFiles.add((IFile)resource);
					}
				}
				return true;
			}
		};
		try {
			project.accept(visitor);
		} 
		catch (CoreException e) {
			e.printStackTrace();
		}
		
		for (Iterator<IFile> iterator = wsdlFiles.iterator(); iterator.hasNext();) {
			IFile iFile = iterator.next();
			IPath fullPath = iFile.getFullPath();
			URI uri = URI.createPlatformResourceURI(fullPath.toString(), false);
			Resource wsdlResource = fEditor.getResource().getResourceSet().getResource(uri, true);

			EcorePackage instance = EcorePackage.eINSTANCE;
			instance.eAdapters();

			try {
				wsdlResource.load(Collections.EMPTY_MAP);
				EList<EObject> contents = wsdlResource.getContents();
				if (!contents.isEmpty()) {
					Definition def = (Definition) contents.get(0);
					wsdlDefinitions.add(def);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return wsdlDefinitions;
	}

	/**
	 * Create and return the partner link type that this wizard gathered information 
	 * about.  
	 * 
	 * @return
	 */
	PartnerLinkType createPLT () {
		
		PartnerLinkType plt = PartnerlinktypeFactory.eINSTANCE.createPartnerLinkType();
		plt.setName( fFirstPage.getPartnerLinkTypeName() );
		
		// Element doc = plt.getDocumentationElement();		
		// doc.setNodeValue("Generated by CreatePartnerLinkWizard");
		
		Role role1 =  PartnerlinktypeFactory.eINSTANCE.createRole();
		role1.setName ( fRolePage1.getRoleName() );
		role1.setPortType( fRolePage1.getMandatoryPortType() );
		plt.getRole().add(role1);
		
		if (fRolePage2.isSpecified()) {
			Role role2 = PartnerlinktypeFactory.eINSTANCE.createRole();
			role2.setName ( fRolePage2.getRoleName() );
			role2.setPortType( fRolePage2.getOptionalPortType() );
			plt.getRole().add(role2);
		}		
		return plt;
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
	
		fPartnerLinkType = createPLT();
						
		Definition artifactsDefinition = fEditor.getArtifactsDefinition();
		
		CompoundCommand cmd = new CompoundCommand();
		// We add the import into the artifacts now, because code relies on diving through
		// WSDL imports to find portTypes etc. 
		
		// 1. Add WSDL import to the artifacts file (again, this is a noop if already exists).
		cmd.add( new AddWSDLImportCommand ( artifactsDefinition, fMandatoryPortType ));
		
		// 2. Create the new Partner Link Type in the artifacts file.
		cmd.add( new CreatePartnerLinkTypeCommand(artifactsDefinition, fPartnerLinkType) );
				
		fEditor.getCommandFramework().execute( cmd );
		
		return true;
	}

	@Override
	public boolean canFinish() {		
		return super.canFinish();
	}
}

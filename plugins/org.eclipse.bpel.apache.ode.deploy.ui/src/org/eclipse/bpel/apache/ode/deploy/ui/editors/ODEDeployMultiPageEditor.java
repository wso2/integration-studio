/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation, University of Stuttgart (IAAS) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation, University of Stuttgart (IAAS) - initial API and implementation
 *******************************************************************************/

package org.eclipse.bpel.apache.ode.deploy.ui.editors;

import java.io.IOException;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Vector;

import org.eclipse.bpel.apache.ode.deploy.model.dd.DocumentRoot;
import org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TDeployment;
import org.eclipse.bpel.apache.ode.deploy.model.dd.util.ddResourceFactoryImpl;
import org.eclipse.bpel.apache.ode.deploy.ui.messages.ODEDeployUIMessages;
import org.eclipse.bpel.apache.ode.deploy.ui.pages.ProcessPage;
import org.eclipse.bpel.apache.ode.deploy.ui.util.DeployUtils;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;

/**
 * A multipage editor for Apache ODE deployment descriptors.
 * 
 * @author Tammo van Lessen (IAAS)
 * @author Simon Moser (IBM)
 */
public class ODEDeployMultiPageEditor extends FormEditor implements IEditingDomainProvider {

	private boolean readOnly = false;
	// https://jira.jboss.org/jira/browse/JBIDE-6230
	// if BPEL processes were added or deleted, DD model is not in sync and needs to be saved 
	private boolean modelInSync = true;
	protected TDeployment deployDescriptor = null;	
	
	protected AdapterFactoryEditingDomain editingDomain;
	protected ComposedAdapterFactory adapterFactory;

	
	/**
	 * Creates a multi-page editor example.
	 */
	public ODEDeployMultiPageEditor() {
		super();
		initializeEditingDomain();
	}
	
	/**
	 * Saves the deployment descriptor
	 */
	public void doSave(IProgressMonitor monitor) {
		commitPages(true);
		saveDeploymentDescriptor();
		((BasicCommandStack)editingDomain.getCommandStack()).saveIsDone();
		modelInSync = true;
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}
	
	/**
	 * SaveAs is not supported.
	 */
	public void doSaveAs() {
		throw new UnsupportedOperationException(ODEDeployUIMessages.ODEDeployEditor_No_SaveAs);
	}
	
	/**
	 * The implementation of this method checks that the input is an 
	 * instance of <code>IFileEditorInput</code> and creates the data model.
	 */
	public void init(IEditorSite site, IEditorInput editorInput) throws PartInitException {
		super.init(site, editorInput);
		setPartName(editorInput.getName());
		
		if (!(editorInput instanceof IFileEditorInput)) {
			throw new PartInitException(ODEDeployUIMessages.ODEDeployEditor_InvalidInput);
		}
		
		createModel();
	}

	public boolean isSaveAsAllowed() {
		return false;
	}

	public void saveDeploymentDescriptor() {
		try {			
			// Bugzilla 320545:
			// editor will be "read only" if there are no BPEL resources to process
			if (!readOnly)
			deployDescriptor.eResource().save(null);
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	protected org.eclipse.bpel.model.Process loadBPEL(IFile bpelFile) {
		IPath fullProcessPath = bpelFile.getFullPath();
		URI uri = URI.createPlatformResourceURI(fullProcessPath.toString(), false);
		Resource bpelResource = editingDomain.getResourceSet().getResource(uri, true);

		try {
			bpelResource.load(Collections.EMPTY_MAP);
			EList<EObject> contents = bpelResource.getContents();
			if (!contents.isEmpty()) {
				return (org.eclipse.bpel.model.Process) contents.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	protected void addPages() {		
		try {
			for (ProcessType pt : deployDescriptor.getProcess()) {
				addPage(new ProcessPage(this, pt));
			}
		} 
		catch (PartInitException e) {
			// ~
		}
	}
	
	public TDeployment getDeploymentModel(){
		return deployDescriptor;
	}

	protected void initializeEditingDomain() {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		// Create the command stack that will notify this editor as commands are executed.
		BasicCommandStack commandStack = new BasicCommandStack();

		// Add a listener to set the most recent command's affected objects to be the selection of the viewer with focus.
		commandStack.addCommandStackListener
			(new CommandStackListener() {
				 public void commandStackChanged(final EventObject event) {
					 getContainer().getDisplay().asyncExec
						 (new Runnable() {
							  public void run() {
								  editorDirtyStateChanged();
							  }
						  });
				 }
			 });

		// Create the editing domain with a special command stack.
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
	}

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	@Override
	public boolean isDirty() {
		return !readOnly && // Bugzilla 320545:
			(
					((BasicCommandStack) editingDomain.getCommandStack()).isSaveNeeded() ||
					!modelInSync
			);
	}
	
	@Override
	public void setFocus() {
		if (getActivePage() != -1 && getControl(getActivePage()) != null) {
			getControl(getActivePage()).setFocus();
		}
	}
	
	protected void createModel() throws PartInitException {
		URI resourceURI = EditUIUtil.getURI(getEditorInput());
		Resource resource = null;

		ddResourceFactoryImpl fac = new ddResourceFactoryImpl();
		resource = fac.createResource(resourceURI);
		editingDomain.getResourceSet().getResources().add(resource);
		try {
			resource.load(Collections.EMPTY_MAP);
			
			EList<EObject> contents = resource.getContents();
			if (!contents.isEmpty() && contents.get(0) instanceof DocumentRoot) {
				deployDescriptor = ((DocumentRoot) contents.get(0)).getDeploy();
				
				populateModel();
			}
		} catch (CoreException e) {
			throw new PartInitException(e.getStatus());
		} catch (IOException e) {
			throw new PartInitException(e.getMessage(), e);
		}
		if (deployDescriptor.getProcess().isEmpty()) {
			// https://jira.jboss.org/jira/browse/JBIDE-6006
			// add a process stub to DD so the editor doesn't crash
			org.eclipse.bpel.model.Process p = BPELFactory.eINSTANCE.createProcess();
			p.setName(ODEDeployUIMessages.ODEDeployEditor_NO_PROCESSES_FOUND);
			ProcessType pt = DeployUtils.createProcessStub(p);
			deployDescriptor.getProcess().add(pt);
			// set model
			pt.setModel(p);
			readOnly = true; // can't save editor anyway
			modelInSync = true; // so it might as well be in sync
		}
	}

	public void populateModel() throws CoreException {
		final Vector<ProcessType> processesFound = new Vector<ProcessType>();
		((IFileEditorInput)getEditorInput()).getFile().getProject().accept(new IResourceVisitor() {
			public boolean visit(IResource bpelfile) throws CoreException {
				// Bugzilla 320545:
				if (DeployUtils.isBPELFile(bpelfile)) {
					org.eclipse.bpel.model.Process p = DeployUtils.loadBPEL((IFile)bpelfile, editingDomain.getResourceSet());
					if (p != null) {
						// add process to DD unless it is not already there.
						ProcessType pt = DeployUtils.findProcessTypeInDD(p, deployDescriptor); 
						if (pt == null) {
							pt = DeployUtils.createProcessStub(p);
							deployDescriptor.getProcess().add(pt);
							modelInSync = false; // need to do a save
						}
						// set model
						pt.setModel(p);
						
						processesFound.add(pt);
					}
				}
				return true;
			}
		});
		// Bugzilla 320545:
		// figure out which BPEL processes are missing from the workspace
		// and remove them from the DD model
		Vector<ProcessType> processesToDelete = new Vector<ProcessType>();
		for(ProcessType pt : deployDescriptor.getProcess())
		{
			if (!processesFound.contains(pt))
				processesToDelete.add(pt);
		}
		if ( processesToDelete.size()>0)
		{
			deployDescriptor.getProcess().removeAll(processesToDelete);
			modelInSync = false; // need to do a save
		}
	}
}

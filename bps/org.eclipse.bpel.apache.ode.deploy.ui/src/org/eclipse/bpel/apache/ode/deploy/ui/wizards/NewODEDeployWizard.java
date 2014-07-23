/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.apache.ode.deploy.ui.wizards;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.apache.ode.deploy.model.dd.DocumentRoot;
import org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TDeployment;
import org.eclipse.bpel.apache.ode.deploy.model.dd.ddFactory;
import org.eclipse.bpel.apache.ode.deploy.model.dd.util.ddResourceFactoryImpl;
import org.eclipse.bpel.apache.ode.deploy.model.dd.util.ddResourceImpl;
import org.eclipse.bpel.apache.ode.deploy.ui.Activator;
import org.eclipse.bpel.apache.ode.deploy.ui.messages.ODEDeployUIMessages;
import org.eclipse.bpel.apache.ode.deploy.ui.util.DeployUtils;
import org.eclipse.bpel.model.Process;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

/**
 * Wizard that enables creating new deployment descriptors for Apache ODE.
 * 
 * @author Simon Moser (IBM)
 * @author Tammo van Lessen (IAAS)
 */
public class NewODEDeployWizard extends Wizard implements INewWizard {
	private ODEDeployWizardPage page;
	private ISelection selection;

	/**
	 * Constructor for NewODEDeployWizard.
	 */
	public NewODEDeployWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new ODEDeployWizardPage(selection);
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	public boolean performFinish() {
		final String containerName = page.getContainerName();
		final String fileName = page.getFileName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(containerName, fileName, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * The worker method. It will find the container, create the
	 * file if missing or just replace its contents, and open
	 * the editor on the newly created file.
	 */

	private void doFinish(
		String containerName,
		String fileName,
		IProgressMonitor monitor)
		throws CoreException {
		
		// create a sample file
		monitor.beginTask("Creating " + fileName, 2);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(new Path(containerName));
		if (!resource.exists() || !(resource instanceof IContainer)) {
			throwCoreException("Container \"" + containerName + "\" does not exist.");
		}
		IContainer container = (IContainer) resource;
		final IFile file = container.getFile(new Path(fileName));
		
		try {			
			Resource emfResource = createBaseDeploymentDescriptor(file);
			emfResource.save(null);
		} 
		catch (IOException e) {
			throwCoreException(e.getMessage());
		}
		
		monitor.worked(1);
		monitor.setTaskName(ODEDeployUIMessages.NewODEDeployWizard_Task_Running);
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page =
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, Activator.EDITOR_ID, true);
				} catch (PartInitException e) {
				}
			}
		});
		monitor.worked(1);
	}
	

	/**
	 * Purpose of this method is to create a new empty deployment descriptor 
	 * in the targetDir 
	 */
	public Resource createBaseDeploymentDescriptor(IFile file)
	{
		URI fileURI = URI.createURI(file.getFullPath().toString());
		
		//generate Resource Factory
		ddResourceFactoryImpl fac = new ddResourceFactoryImpl();
		//URI ddFileLocation = URI.createFileURI(this.deployDirectory + System.getProperty("file.separator") + DD_FILENAME );
		
		ddResourceImpl ddResource = (ddResourceImpl) fac.createResource(fileURI);
		ddResource.setEncoding("UTF-8");
		DocumentRoot rootElm = ddFactory.eINSTANCE.createDocumentRoot();	
		TDeployment deployElement = ddFactory.eINSTANCE.createTDeployment();
		rootElm.setDeploy(deployElement);
		ddResource.getContents().add(rootElm);
		
		//bugzilla 250057: parse the project, and if we find a BPEL file, create 
		//a base "process" tag that has 
		//    <active>true</active>
	    //    <retired>false</retired>
		IProject project  = file.getProject();
		List<Process> processes = DeployUtils.loadAllBPELFromProject(project, new ResourceSetImpl());
		for (Iterator<Process> iterator = processes.iterator(); iterator.hasNext();) {
			Process process = (Process) iterator.next();
			ProcessType pt = DeployUtils.createProcessStub(process);	
			pt.setActive(true);
			pt.setRetired(false);			
			pt.setModel(process);
			deployElement.getProcess().add(pt);			
		}		
	
		return ddResource;
	}

	private void throwCoreException(String message) throws CoreException {
		IStatus status =
			new Status(IStatus.ERROR, "org.eclipse.bpel.apache.ode.deploy.ui", IStatus.OK, message, null);
		throw new CoreException(status);
	}

	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialize from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}
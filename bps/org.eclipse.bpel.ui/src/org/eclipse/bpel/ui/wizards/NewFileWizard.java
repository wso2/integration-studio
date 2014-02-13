/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation
 *******************************************************************************/

package org.eclipse.bpel.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.Templates.Template;
import org.eclipse.core.internal.resources.Folder;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.eclipse.wst.common.componentcore.ComponentCore;
import org.eclipse.wst.common.componentcore.ModuleCoreNature;
import org.eclipse.wst.common.componentcore.resources.IVirtualComponent;

/**
 * Wizard for the new process template.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * 
 */

public class NewFileWizard extends Wizard implements INewWizard {

	/** The id of our BPEL editor */
	static protected final String BPEL_EDITOR_ID = "org.eclipse.bpel.ui.bpeleditor"; //$NON-NLS-1$

	/** The container where the file(s) will be created */
	private IContainer mContainer;

	private IWorkbench fWorkbench;

	/** The 1st page of the wizard */
	private NewFileWizardPage1 fMainPage;

	/** The 2nd page of the wizard */
	private NewFileWizardPage2 fContainerPage;

	/** The 3nd page of the wizard */
	private WSDLCustomPage wsdlPage;

	/**
	 * Create a brand new shining Create Project Wizard for BPEL.
	 */

	public NewFileWizard() {

		setNeedsProgressMonitor(true);
		setDialogSettings(BPELUIPlugin.INSTANCE.getDialogSettingsFor(this));
		setHelpAvailable(false);
		this.setWindowTitle(Messages.NewFileWizard_1);

	}

	/**
	 * Initialize the wizard object through the normal eclipse initialization
	 * mechanism.
	 * 
	 * @param workbench
	 *            the workbench reference
	 * @param currentSelection
	 *            the current selection reference
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */

	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		fWorkbench = workbench;
		mContainer = getBPELContainer(currentSelection.getFirstElement());
	}

	protected void selectAndReveal(IResource newResource) {
		BasicNewResourceWizard.selectAndReveal(newResource, fWorkbench
				.getActiveWorkbenchWindow());
	}

	protected void openResource(final IFile resource) {
		if (resource.getType() != IResource.FILE) {
			return;
		}

		IWorkbenchWindow window = fWorkbench.getActiveWorkbenchWindow();
		if (window == null) {
			return;
		}

		final IWorkbenchPage activePage = window.getActivePage();
		if (activePage != null) {
			final Display display = getShell().getDisplay();
			display.asyncExec(new Runnable() {
				public void run() {
					try {
						IDE.openEditor(activePage, resource, BPEL_EDITOR_ID,
								true);
						// IDE.openEditor(activePage, resource, true);
					} catch (PartInitException e) {
						BPELUIPlugin.log(e);
					}
				}
			});
			BasicNewResourceWizard.selectAndReveal(resource, activePage
					.getWorkbenchWindow());
		}
	}

	/**
	 * Perform cancel. Close the wizard and don't do anything else.
	 * 
	 * @return true if canceled
	 */
	
	public boolean performCancel() {
		return super.performCancel();
	}

	/**
	 * Add pages to the Open project wizard.
	 * 
	 */

	
	public void addPages() {

		fMainPage = new NewFileWizardPage1(Messages.NewFileWizardPage1_Name);
		fContainerPage = new NewFileWizardPage2(
				Messages.NewFileWizardPage2_Name);
		wsdlPage = new WSDLCustomPage(
				Messages.NewFileWizard_WSDLCustomPage_Name);

		addPage(fMainPage);
		addPage(wsdlPage);
		addPage(fContainerPage);
		wsdlPage.setPreviousPage(fMainPage);
		fContainerPage.setPreviousPage(wsdlPage);
	}

	/**
	 * Perform the finish operation of the create project wizard.
	 * 
	 * @return true on success, false on failure
	 * 
	 * @see Wizard#performFinish
	 */

	
	public boolean performFinish() {

		BPELCreateOperation runnable = new BPELCreateOperation();

		// The container either comes from the 2nd page, explicitely defined
		// or it comes as the context in the current selection.

		IContainer container = fContainerPage.getResourceContainer();
		if (container == null) {
			container = mContainer;
		}

		runnable.setContainer(container);
		runnable.setTemplate(fMainPage.getSelectedTemplate());
		
		Map<String, Object> map = fMainPage.getArgs();
		map.putAll(wsdlPage.getMap());
		runnable.setArgs(map);

		try {
			getContainer().run(false, true, runnable);
		} catch (InvocationTargetException e) {
			BPELUIPlugin.log(e);
			return false;
		} catch (InterruptedException e) {
			BPELUIPlugin.log(e);
			return false;
		}

		IFile res = (IFile) runnable.getElementToOpen();
		if (res != null && res.exists()) {
			openResource(res);
		}
		return true;
	}

	/**
	 * Return the BPEL files container in which we can generate process from the
	 * template.
	 * 
	 * @return the BPEL files IContainer
	 */

	IContainer getBPELContainer(Object obj) {

		IContainer bpelContent = null;
		
		if (obj == null) {
			return null;
		}
		IProject project = null;
		if (obj instanceof IFile) {
			IFile file = (IFile) obj;
			project = file.getProject();
		}
		if (obj instanceof IContainer) {
			IContainer container = (IContainer) obj;
			project = container.getProject();
		}
		if (project != null) {
			// https://issues.jboss.org/browse/JBIDE-8591
			// if not a faceted project, still allow resources to be created
			IPath rootPath = getWebContentRootPath(project);
			if (rootPath!=null && !rootPath.isEmpty()) {
				bpelContent = project.getFolder(rootPath);
			}
		}
		if (bpelContent == null) {
			// https://issues.jboss.org/browse/JBIDE-8591
			// use folder or project
			if (obj instanceof IContainer)
				bpelContent = (IContainer)obj;
			else
				bpelContent = project;
		}
		return bpelContent;
	}

		static IPath getWebContentRootPath(IProject project) {
				if (project == null)
					return null;
		
				if (!ModuleCoreNature.isFlexibleProject(project))
					return null;
		
				IPath path = null;
				IVirtualComponent component = ComponentCore.createComponent(project);
				if (component != null && component.exists()) {
					path = component.getRootFolder().getProjectRelativePath();
				}
				return path;
			}
	
	// https://issues.jboss.org/browse/JBIDE-8591
	// added to allow first and last page access to resource container
	public IContainer getBPELContainer() {
		return mContainer;
	}
	
	public void setBPELContainer(IContainer container) {
		mContainer = container;
	}
	
	/**
	 * @return the currently selected Template
	 * @see https://jira.jboss.org/browse/JBIDE-7165
	 */
	public Template getSelectedTemplate()
	{
		return fMainPage.getSelectedTemplate();
	}
	
	/**
	 * 
	 * Final condition for the wizard to finish
	 */

	
	public boolean canFinish() {
		return (fMainPage.isPageComplete() && wsdlPage.isPageComplete() && fContainerPage.isPageComplete() && mContainer != null)
				|| super.canFinish();
	}

}

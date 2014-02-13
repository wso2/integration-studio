package org.wso2.developerstudio.eclipse.humantask.editor.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.core.runtime.*;
import org.eclipse.jface.operation.*;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import java.io.*;
import org.eclipse.ui.*;
import org.eclipse.ui.ide.IDE;
import org.wso2.tools.humantask.model.ht.DocumentRoot;
import org.wso2.tools.humantask.model.ht.HTFactory;
import org.wso2.tools.humantask.model.ht.THumanInteractions;
import org.wso2.tools.humantask.model.ht.TLogicalPeopleGroups;
import org.wso2.tools.humantask.model.ht.util.HTResourceFactoryImpl;
import org.wso2.tools.humantask.model.ht.util.HTResourceImpl;

/**
 * This is a sample new wizard. Its role is to create a new file resource in the
 * provided container. If the container resource (a folder or a project) is
 * selected in the workspace when the wizard is opened, it will accept it as the
 * target container. The wizard creates one file with the extension "mpe". If a
 * sample multi-page editor (also available as a template) is registered for the
 * same extension, it will be able to open it.
 */

public class NewHumanInteractionWizard extends Wizard implements INewWizard {
	private NewHumanInteractionWizardPage page;
	private ISelection selection;

	/**
	 * Constructor for SampleNewWizard.
	 */
	public NewHumanInteractionWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new NewHumanInteractionWizardPage(selection);
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in the wizard. We
	 * will create an operation and run it using wizard as execution context.
	 */
	public boolean performFinish() {
		final String containerName = page.getContainerName();
		final String fileName = page.getFileName();
		final String targetNameSpace = page.getHumanInteractionsFileTargetNamespace();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException {
				try {
					doFinish(containerName, fileName, targetNameSpace, monitor);
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
			MessageDialog.openError(getShell(), "Error", realException
					.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * The worker method. It will find the container, create the file if missing
	 * or just replace its contents, and open the editor on the newly created
	 * file.
	 */

	private void doFinish(String containerName, String fileName, String targetNamespace, 
			IProgressMonitor monitor) throws CoreException {
		// create a sample file
		monitor.beginTask("Creating " + fileName, 2);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(new Path(containerName));
		if (!resource.exists() || !(resource instanceof IContainer)) {
			throwCoreException("Container \"" + containerName
					+ "\" does not exist.");
		}
		IContainer container = (IContainer) resource;
		final IFile file = container.getFile(new Path(fileName));
		try {
			Resource emfResource = createHumanInteractionsFile(file, targetNamespace);
			emfResource.save(null);
		} catch (IOException e) {
		}
		monitor.worked(1);
		monitor.setTaskName("Opening file for editing...");
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, true);
				} catch (PartInitException e) {
				}
			}
		});
		monitor.worked(1);
	}

	private Resource createHumanInteractionsFile(IFile file, String targetNamespace) {
		URI fileURI = URI.createURI(file.getFullPath().toString());

		// generate Resource Factory
		HTResourceFactoryImpl fac = new HTResourceFactoryImpl();
		// URI ddFileLocation = URI.createFileURI(this.deployDirectory +
		// System.getProperty("file.separator") + DD_FILENAME );

		HTResourceImpl htResource = (HTResourceImpl) fac
				.createResource(fileURI);
		htResource.setEncoding("UTF-8");
		DocumentRoot rootElm = HTFactory.eINSTANCE.createDocumentRoot();
		THumanInteractions humanInteractionElement = HTFactory.eINSTANCE.createTHumanInteractions();
		humanInteractionElement.setTargetNamespace(targetNamespace);
		TLogicalPeopleGroups logicalPeopleGroups = HTFactory.eINSTANCE.createTLogicalPeopleGroups();
		humanInteractionElement.setLogicalPeopleGroups(logicalPeopleGroups);
		rootElm.setHumanInteractions(humanInteractionElement);
		htResource.getContents().add(rootElm);
		

		return htResource;
	}

	private void throwCoreException(String message) throws CoreException {
		IStatus status = new Status(IStatus.ERROR,
				"org.wso2.developerstudio.eclipse.humantask.m.editor", IStatus.OK, message, null);
		throw new CoreException(status);
	}

	/**
	 * We will accept the selection in the workbench to see if we can initialize
	 * from it.
	 * 
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}

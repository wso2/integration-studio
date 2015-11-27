package org.eclipse.bpel.extensionssample.ui.popup.actions;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Process;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;

public class PopupAction implements IObjectActionDelegate {

	private Shell shell = null;

	private ResourceSet resourceSet = new ResourceSetImpl();

	private IFile bpelFile = null;
	private Resource bpelResource = null;

	public PopupAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		IWorkbenchPartSite site = targetPart.getSite();
		shell = site.getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {

		// load BPEL,WSDL,XSDs
		Process process = loadBPEL();

		if (process != null) {
			EList<Import> imports = process.getImports();
			Iterator<Import> importIterator = imports.iterator();
			while (importIterator.hasNext()) {
				Import current = importIterator.next();
				String relPath = current.getLocation();
			}
		}


		MessageDialog.openInformation(shell, "BPEL Extensions UI Sample Plug-in",
				"Sample Popup Action was executed. Process: " + process.getName());
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof StructuredSelection) {
			StructuredSelection sSel = (StructuredSelection) selection;
			bpelFile = (IFile) sSel.getFirstElement();
		}
	}

	protected Process loadBPEL() {

		IPath fullProcessPath = bpelFile.getFullPath();
		URI uri = URI.createPlatformResourceURI(fullProcessPath.toString(), false);
		bpelResource = getResourceSet().getResource(uri, true);

		EcorePackage instance = EcorePackage.eINSTANCE;
		instance.eAdapters();

		try {
			bpelResource.load(Collections.EMPTY_MAP);
			EList<EObject> contents = bpelResource.getContents();
			if (!contents.isEmpty()) {
				return (Process) contents.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

}

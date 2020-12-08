package org.wso2.developerstudio.eclipse.artifact.registry.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;


public class ResourceEditorAction implements IActionDelegate{

	private IStructuredSelection selection;
	
	public void run(IAction action) {
		try {
			 if(selection != null){
				    IProject project = (IProject)selection.getFirstElement(); 
				    IFile arifactXml = project.getFile("artifact.xml");
			        IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		            IWorkbenchPage page = window.getActivePage();
		      	    page.openEditor(new FileEditorInput(arifactXml), "org.wso2.developerstudio.eclipse.artifact.registry.editor"); 
			 }
			 
		} catch (Exception e) {
		   e.printStackTrace();
		}
	}

	
	public void selectionChanged(IAction action, ISelection selection) {

		 if(selection instanceof IStructuredSelection){
			 this.selection = (IStructuredSelection) selection;
		 }
	}

}

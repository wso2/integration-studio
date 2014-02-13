package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils.COMPLEX_ENDPOINT_RESOURCE_DIR;

import java.util.Date;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ParentEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorUtil;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class ComplexFiguredAbstractEndpoint extends AbstractEndpoint{
	
	private static IDeveloperStudioLog log = Logger
	.getLog("org.wso2.developerstudio.eclipse.gmf.esb.diagram");

	public ComplexFiguredAbstractEndpoint(View view) {
		super(view);
	}
	
	protected NodeFigure createMainFigure() {
		return null;
	}
	
	public void openPage(){

		final EObject endpoint = (ParentEndPoint) ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) getModel())
				.getElement();
		String name;

		
	      long lDateTime = new Date().getTime();
	      final String endpointName = String.valueOf(lDateTime);
	      
		if ((((ParentEndPoint) endpoint).getName() == null)
				|| ((ParentEndPoint) endpoint).getName().trim().equals("")) {
			
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					SetRequest setRequest = new SetRequest(getEditingDomain(),
							endpoint, EsbPackage.eINSTANCE
									.getParentEndPoint_Name(), endpointName);
					SetValueCommand operation = new SetValueCommand(
							setRequest) {

						public boolean canUndo() {
							return true;
						}

						public boolean canRedo() {
							return true;
						}
					};

					getEditDomain().getCommandStack().execute(
							new ICommandProxy(operation));
				}
			});

			name=endpointName;
			createFiles(name, "complex_endpoint_" + name + ".esb_diagram", "complex_endpoint_"
					+ name + ".esb");
		} else {
			name=((ParentEndPoint) endpoint).getName();
			createFiles(name, "complex_endpoint_" + name + ".esb_diagram", "complex_endpoint_"
					+ name + ".esb");
		}
	}
	
	public boolean createFiles(String name, String fileURI1, String fileURI2) {
		Resource diagram;
		IProject currentProject=getActiveProject();

		String basePath = "platform:/resource/" + currentProject.getName()
				+ "/" + COMPLEX_ENDPOINT_RESOURCE_DIR  + "/";
		IFile file = currentProject.getFile(COMPLEX_ENDPOINT_RESOURCE_DIR + "/"
				+ fileURI1);

		if (!file.exists()) {
			diagram = EsbDiagramEditorUtil.createDiagram(
					URI.createURI(basePath + fileURI1),
					URI.createURI(basePath + fileURI2),
					new NullProgressMonitor(), "complex_endpoint", name, null);
			try {
				EsbDiagramEditorUtil.openDiagram(diagram);

			} catch (PartInitException e) {
				log.error("Cannot init editor", e);
			}
			return diagram != null;
		}

		else {
			IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();
			IEditorDescriptor desc = PlatformUI.getWorkbench()
					.getEditorRegistry().getDefaultEditor(file.getName());
			try {
				page.openEditor(new FileEditorInput(file), desc.getId());
			} catch (PartInitException e) {
				log.error("Cannot init editor", e);
			}
			return true;
		}
	}
	
	private IProject getActiveProject() {
		IEditorPart editorPart = null;
		IProject activeProject = null;
		IEditorReference editorReferences[] = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences();
		for (int i = 0; i < editorReferences.length; i++) {
			IEditorPart editor = editorReferences[i].getEditor(false);

			if (editor != null) {
				editorPart = editor.getSite().getWorkbenchWindow()
						.getActivePage().getActiveEditor();
			}

			if (editorPart != null) {
				IFileEditorInput input = (IFileEditorInput) editorPart
						.getEditorInput();
				IFile file = input.getFile();
				activeProject = file.getProject();
			}
		}
		return activeProject;
	}

}

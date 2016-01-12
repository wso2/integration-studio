package org.wso2.developerstudio.datamapper.diagram.navigator;

import java.io.File;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.DataMapperRootEditPart;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry;
import org.wso2.developerstudio.datamapper.diagram.part.Messages;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
//import org.wso2.developerstudio.eclipse.logging.core.Logger;
//import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
//import org.wso2.developerstudio.eclipse.platform.ui.startup.DataMapperEditor;
//import org.wso2.developerstudio.eclipse.platform.ui.startup.ESBGraphicalEditor;
//import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.developerstudio.eclipse.platform.ui.startup.DataMapperEditor;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

/**
 * @generated
 */
public class DataMapperNavigatorActionProvider extends CommonActionProvider {

	/**
	 * @generated
	 */
	private boolean myContribute;

	/**
	 * @generated
	 */
	private OpenDiagramAction myOpenDiagramAction;

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * @generated
	 */
	public void init(ICommonActionExtensionSite aSite) {
		super.init(aSite);
		if (aSite.getViewSite() instanceof ICommonViewerWorkbenchSite) {
			myContribute = true;
			makeActions((ICommonViewerWorkbenchSite) aSite.getViewSite());
		} else {
			myContribute = false;
		}
	}

	/**
	 * @generated
	 */
	private void makeActions(ICommonViewerWorkbenchSite viewerSite) {
		myOpenDiagramAction = new OpenDiagramAction(viewerSite);
	}

	/**
	 * @generated NOT
	 */
	public void fillActionBars(IActionBars actionBars) {
		/*		if (!myContribute) {
		 return;
		 }
		 IStructuredSelection selection = (IStructuredSelection) getContext()
		 .getSelection();
		 myOpenDiagramAction.selectionChanged(selection);
		 if (myOpenDiagramAction.isEnabled()) {
		 actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN,
		 myOpenDiagramAction);
		 }*/

		IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();
		if (selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) selection;
			Object firstElement = treeSelection.getFirstElement();
			if (firstElement instanceof IFile) {
				IFile file = (IFile) firstElement;
				try {
					IContentDescription contentDescription = file.getContentDescription();
					if (contentDescription != null) {
						IContentType contentType = contentDescription.getContentType();
						if (contentType.getId() != null) {
							if ("org.wso2.developerstudio.eclipse.datamapper.contenttype.datamapperconfig"
									.equals(contentType.getId())) {
								myOpenDiagramAction.setSelection(file);
								actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN,
										myOpenDiagramAction);
							}
						}
					}

				} catch (CoreException e) {
					/* ignore */
				}
			}
		}
	}

	/**
	 * @generated
	 */
	public void fillContextMenu(IMenuManager menu) {
	}

	/**
	 * @generated
	 */
	private static class OpenDiagramAction extends Action {

		/**
		 * @generated
		 */
		private Diagram myDiagram;

		private IFile selection;

		/**
		 * @generated
		 */
		private ICommonViewerWorkbenchSite myViewerSite;

		/**
		 * @generated
		 */
		public OpenDiagramAction(ICommonViewerWorkbenchSite viewerSite) {
			super(Messages.NavigatorActionProvider_OpenDiagramActionName);
			myViewerSite = viewerSite;
		}

		/**
		 * @generated
		 */
		public final void selectionChanged(IStructuredSelection selection) {
			myDiagram = null;
			if (selection.size() == 1) {
				Object selectedElement = selection.getFirstElement();
				if (selectedElement instanceof DataMapperNavigatorItem) {
					selectedElement = ((DataMapperNavigatorItem) selectedElement).getView();
				} else if (selectedElement instanceof IAdaptable) {
					selectedElement = ((IAdaptable) selectedElement).getAdapter(View.class);
				}
				if (selectedElement instanceof Diagram) {
					Diagram diagram = (Diagram) selectedElement;
					if (DataMapperRootEditPart.MODEL_ID.equals(DataMapperVisualIDRegistry
							.getModelID(diagram))) {
						myDiagram = diagram;
					}
				}
			}
			setEnabled(myDiagram != null);
		}

		/**
		 * @generated NOT
		 */
		public void run() {
			/*			if (myDiagram == null || myDiagram.eResource() == null) {
			 return;
			 }

			 IEditorInput editorInput = getEditorInput(myDiagram);
			 IWorkbenchPage page = myViewerSite.getPage();
			 try {
			 page.openEditor(editorInput,
			 org.wso2.developerstudio.datamapper.diagram.part.DataMapperDiagramEditor.ID);
			 } catch (PartInitException e) {
			 org.wso2.developerstudio.datamapper.diagram.part.DataMapperDiagramEditorPlugin
			 .getInstance().logError(
			 "Exception while openning diagram", e); //$NON-NLS-1$
			 }*/

			openDataMapperDiagram(selection);
		}

		public static void openDataMapperDiagram(IFile selection) {
			IFile fileTobeOpen = null;
			//String synFilePath = selection.getFullPath().toOSString();
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();
			Path path = new Path(getGraphicalResource(selection));
			try {
				if (selection.getWorkspace().getRoot().getFile(path).exists()) {
					fileTobeOpen = selection.getWorkspace().getRoot().getFile(path);
					IDE.openEditor(page, fileTobeOpen);
				} else {
					String location = selection.getLocation().toOSString();
					String source = FileUtils.getContentAsString(new File(location));
					String name = selection.getName().split("\\.")[0];
					String fullPath = selection.getFullPath().removeLastSegments(1).toOSString()
							+ "/";
					Openable openable = DataMapperEditor.getOpenable();
					openable.editorOpen(name, null, fullPath, source);
				}
			} catch (Exception e) {
				log.error("Can't open " + fileTobeOpen, e);
			}
		}

		private static String getGraphicalResource(IFile selection) {
			String synFilePath = selection.getFullPath().toOSString();
			synFilePath = synFilePath.replaceAll(Pattern.quote("\\"), "/");
			String graphicalResource = synFilePath.replaceAll(".dmc$", ".datamapper_diagram");
			return graphicalResource;
		}

		/**
		 * @generated
		 */
		private static IEditorInput getEditorInput(Diagram diagram) {
			Resource diagramResource = diagram.eResource();
			for (EObject nextEObject : diagramResource.getContents()) {
				if (nextEObject == diagram) {
					return new FileEditorInput(WorkspaceSynchronizer.getFile(diagramResource));
				}
				if (nextEObject instanceof Diagram) {
					break;
				}
			}
			URI uri = EcoreUtil.getURI(diagram);
			String editorName = uri.lastSegment() + '#'
					+ diagram.eResource().getContents().indexOf(diagram);
			IEditorInput editorInput = new URIEditorInput(uri, editorName);
			return editorInput;
		}

		public void setSelection(IFile selection) {
			this.selection = selection;
		}

	}

}

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.part;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.editparts.ZoomListener;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.internal.ui.palette.editparts.DrawerEditPart;
import org.eclipse.gef.internal.ui.palette.editparts.ToolEntryEditPart;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DiagramGraphicalViewerKeyHandler;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DirectEditKeyHandler;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.PaletteToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.gef.ui.palette.customize.PaletteDrawerState;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.IShowInTargetList;
import org.eclipse.ui.part.ShowInContext;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.extensions.CustomPaletteToolTransferDropTargetListener;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.extensions.CustomZoomListener;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.navigator.EsbNavigatorItem;

/**
 * @generated
 */
public class EsbDiagramEditor extends DiagramDocumentEditor implements IGotoMarker {

	private EsbMultiPageEditor esbEditor;
	/**
	 * @generated
	 */
	public static final String ID = "org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String CONTEXT_ID = "org.wso2.developerstudio.eclipse.gmf.esb.diagram.ui.diagramContext"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public EsbDiagramEditor() {
		super(true);
	}

	/**
	 * @generated NOT
	 */
	public EsbDiagramEditor(EsbMultiPageEditor esbEditor) {
		super(true);
		this.esbEditor = esbEditor;
	}

	/**
	 * @generated
	 */
	protected String getContextID() {
		return CONTEXT_ID;
	}

	/**
	 * @generated
	 */
	protected PaletteRoot createPaletteRoot(PaletteRoot existingPaletteRoot) {
		PaletteRoot root = super.createPaletteRoot(existingPaletteRoot);
		new EsbPaletteFactory().fillPalette(root);
		return root;
	}

	/**
	 * @generated
	 */
	protected PreferencesHint getPreferencesHint() {
		return EsbDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	/**
	 * @generated
	 */
	public String getContributorId() {
		return EsbDiagramEditorPlugin.ID;
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class type) {
		if (type == IShowInTargetList.class) {
			return new IShowInTargetList() {
				public String[] getShowInTargetIds() {
					return new String[] { ProjectExplorer.VIEW_ID };
				}
			};
		}
		return super.getAdapter(type);
	}

	/**
	 * @generated NOT
	 */
	protected IDocumentProvider getDocumentProvider(IEditorInput input) {
		if (input instanceof IFileEditorInput || input instanceof URIEditorInput || input instanceof EsbEditorInput) {
			return EsbDiagramEditorPlugin.getInstance().getDocumentProvider();
		}
		return super.getDocumentProvider(input);
	}

	/**
	 * @generated NOT
	 */
	public TransactionalEditingDomain getEditingDomain() {
		IDocument document = null;
		if (getDocumentProvider() != null) {
			document = getEditorInput() != null ? getDocumentProvider().getDocument(getEditorInput()) : null;
		} else {
			document = getEditorInput() != null ? getDocumentProvider(getEditorInput()).getDocument(getEditorInput())
					: null;
		}
		if (document instanceof IDiagramDocument) {
			return ((IDiagramDocument) document).getEditingDomain();
		}
		return super.getEditingDomain();
	}

	/**
	 * @generated NOT
	 */
	protected void setDocumentProvider(IEditorInput input) {
		if (input instanceof IFileEditorInput || input instanceof URIEditorInput || input instanceof EsbEditorInput) {
			setDocumentProvider(EsbDiagramEditorPlugin.getInstance().getDocumentProvider());
		} else {
			super.setDocumentProvider(input);
		}
	}

	/**
	 * @generated
	 */
	public void gotoMarker(IMarker marker) {
		MarkerNavigationService.getInstance().gotoMarker(this, marker);
	}

	public void doSave(IProgressMonitor progressMonitor) {
		IDocumentProvider p = getDocumentProvider();
		if (p == null) {
			return;
		}
		updateState(getEditorInput());
		validateState(getEditorInput());
		performSave(false, progressMonitor);
	}

	/**
	 * @generated NOT
	 */
	public boolean isSaveAsAllowed() {
		return false;
	}

	/**
	 * @generated
	 */
	public void doSaveAs() {
		performSaveAs(new NullProgressMonitor());
	}

	/**
	 * @generated
	 */
	protected void performSaveAs(IProgressMonitor progressMonitor) {
		Shell shell = getSite().getShell();
		IEditorInput input = getEditorInput();
		SaveAsDialog dialog = new SaveAsDialog(shell);
		IFile original = input instanceof IFileEditorInput ? ((IFileEditorInput) input).getFile() : null;
		if (original != null) {
			dialog.setOriginalFile(original);
		}
		dialog.create();
		IDocumentProvider provider = getDocumentProvider();
		if (provider == null) {
			// editor has been programmatically closed while the dialog was open
			return;
		}
		if (provider.isDeleted(input) && original != null) {
			String message = NLS.bind(Messages.EsbDiagramEditor_SavingDeletedFile, original.getName());
			dialog.setErrorMessage(null);
			dialog.setMessage(message, IMessageProvider.WARNING);
		}
		if (dialog.open() == Window.CANCEL) {
			if (progressMonitor != null) {
				progressMonitor.setCanceled(true);
			}
			return;
		}
		IPath filePath = dialog.getResult();
		if (filePath == null) {
			if (progressMonitor != null) {
				progressMonitor.setCanceled(true);
			}
			return;
		}
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IFile file = workspaceRoot.getFile(filePath);
		final IEditorInput newInput = new FileEditorInput(file);
		// Check if the editor is already open
		IEditorMatchingStrategy matchingStrategy = getEditorDescriptor().getEditorMatchingStrategy();
		IEditorReference[] editorRefs = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences();
		for (int i = 0; i < editorRefs.length; i++) {
			if (matchingStrategy.matches(editorRefs[i], newInput)) {
				MessageDialog.openWarning(shell, Messages.EsbDiagramEditor_SaveAsErrorTitle,
						Messages.EsbDiagramEditor_SaveAsErrorMessage);
				return;
			}
		}
		boolean success = false;
		try {
			provider.aboutToChange(newInput);
			getDocumentProvider(newInput).saveDocument(progressMonitor, newInput,
					getDocumentProvider().getDocument(getEditorInput()), true);
			success = true;
		} catch (CoreException x) {
			IStatus status = x.getStatus();
			if (status == null || status.getSeverity() != IStatus.CANCEL) {
				ErrorDialog.openError(shell, Messages.EsbDiagramEditor_SaveErrorTitle,
						Messages.EsbDiagramEditor_SaveErrorMessage, x.getStatus());
			}
		} finally {
			provider.changed(newInput);
			if (success) {
				setInput(newInput);
			}
		}
		if (progressMonitor != null) {
			progressMonitor.setCanceled(!success);
		}
	}

	/**
	 * @generated
	 */
	public ShowInContext getShowInContext() {
		return new ShowInContext(getEditorInput(), getNavigatorSelection());
	}

	/**
	 * @generated
	 */
	private ISelection getNavigatorSelection() {
		IDiagramDocument document = getDiagramDocument();
		if (document == null) {
			return StructuredSelection.EMPTY;
		}
		Diagram diagram = document.getDiagram();
		if (diagram == null || diagram.eResource() == null) {
			return StructuredSelection.EMPTY;
		}
		IFile file = WorkspaceSynchronizer.getFile(diagram.eResource());
		if (file != null) {
			EsbNavigatorItem item = new EsbNavigatorItem(diagram, file, false);
			return new StructuredSelection(item);
		}
		return StructuredSelection.EMPTY;
	}

	/**
	 * @generated NOT
	 */
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		IDiagramGraphicalViewer viewer = getDiagramGraphicalViewer();
		KeyHandler viewerKeyHandler = new CustomDiagramGraphicalViewerKeyHandler(this, viewer);

		KeyHandler parentHandler = getKeyHandler();

		/*		// CTRL + '=' disable zoom in 
		 parentHandler.remove(KeyStroke.getPressed('=', 0x3d, SWT.CTRL));
		 // CTRL + '-' * disable zoom out
		 parentHandler.remove(KeyStroke.getPressed('-', 0x2d, SWT.CTRL));*/

		viewerKeyHandler.setParent(getKeyHandler());
		viewer.setKeyHandler(new DirectEditKeyHandler(viewer).setParent(viewerKeyHandler));

		// Define key handler for palette viewer.
		PaletteViewer paletteViewer = getPaletteViewerProvider().getEditDomain().getPaletteViewer();
		KeyHandler paletteViewerKeyHandler = new CustomPaletteViewerKeyHandler(paletteViewer);
		paletteViewer.setKeyHandler(paletteViewerKeyHandler);

		//This enables the property view to be informed of selection changes in our graphical view, 
		//when our view is the active workbench part.
		esbEditor.getSite().setSelectionProvider(viewer);

		DiagramEditorContextMenuProvider provider = new DiagramEditorContextMenuProvider(this,
				getDiagramGraphicalViewer());
		getDiagramGraphicalViewer().setContextMenu(provider);
		getSite().registerContextMenu(ActionIds.DIAGRAM_EDITOR_CONTEXT_MENU, provider, getDiagramGraphicalViewer());
		getDiagramGraphicalViewer().addDropTargetListener(
				new CustomPaletteToolTransferDropTargetListener(getGraphicalViewer()));

		// Adding zoom listener 
		ZoomManager zoomManager = (ZoomManager) getGraphicalViewer().getProperty(ZoomManager.class.toString());
		zoomManager.addZoomListener(new CustomZoomListener(esbEditor));
	}

	protected int getInitialDockLocation() {
		return PositionConstants.WEST;
	}

	protected int getInitialPaletteSize() {
		return 240;
	}

	public void focusToolBar() {

		PaletteViewer paletteViewer = getPaletteViewerProvider().getEditDomain().getPaletteViewer();
		DrawerEditPart mediatorsGroupEditpart = null;
		//ToolEntryEditPart callMediatorToolEntryEditpart = null;
		Boolean mediatorsGroupFound = false;
		//Boolean callMediatorFound = false;

		for (Iterator ite = paletteViewer.getEditPartRegistry().values().iterator(); ite.hasNext();) {

			Object ep = ite.next();
			if (ep instanceof DrawerEditPart && !mediatorsGroupFound) {

				mediatorsGroupEditpart = (DrawerEditPart) ep;
				if (mediatorsGroupEditpart.getModel() instanceof PaletteDrawer) {
					PaletteDrawer paletteDrawer = (PaletteDrawer) mediatorsGroupEditpart.getModel();
					if (paletteDrawer.getId().equals("createMediators2Group")) {
						mediatorsGroupFound = true;
					}
				}
			} /*else if (ep instanceof ToolEntryEditPart && !callMediatorFound) {
				
				callMediatorToolEntryEditpart = (ToolEntryEditPart)ep;
				ToolEntry paletteDrawer = (ToolEntry) callMediatorToolEntryEditpart.getModel();
				//search for call mediator which is the first mediator listed under mediaotrs
				if (paletteDrawer.getId().equals("createCallMediator45CreationTool")) {
					callMediatorFound = true;
				}
				}*/
		}

		if (mediatorsGroupFound) { // we only need to enable this shortcut for mediators group

			if (!mediatorsGroupEditpart.isExpanded()) {
				mediatorsGroupEditpart.setExpanded(true);
			}

			paletteViewer.select(mediatorsGroupEditpart);
			paletteViewer.setFocus(mediatorsGroupEditpart);
			//paletteViewer.setActiveTool((ToolEntry)callMediatorToolEntryEditpart.getModel());
			paletteViewer.getControl().forceFocus();
			if (paletteViewer.getKeyHandler() instanceof CustomPaletteViewerKeyHandler) {
				CustomPaletteViewerKeyHandler customKeyHandler = (CustomPaletteViewerKeyHandler) paletteViewer
						.getKeyHandler();
				customKeyHandler.resetSerchString();
			}
		}
	}

}
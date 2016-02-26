package org.wso2.developerstudio.datamapper.diagram.part;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.avro.Schema;
import org.apache.avro.SchemaParseException;
import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DirectEditKeyHandler;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.IShowInTargetList;
import org.eclipse.ui.part.ShowInContext;
import org.wso2.developerstudio.datamapper.DataMapperRoot;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.custom.exception.DataMapperException;
import org.wso2.developerstudio.datamapper.diagram.custom.part.CustomDiagramGraphicalViewerKeyHandler;
import org.wso2.developerstudio.datamapper.diagram.custom.persistence.AvroSchemaTransformer;
import org.wso2.developerstudio.datamapper.diagram.custom.persistence.DataMapperModelTransformer;
import org.wso2.developerstudio.datamapper.diagram.custom.util.EditorUtils;
import org.wso2.developerstudio.datamapper.diagram.navigator.DataMapperNavigatorItem;
import org.wso2.developerstudio.datamapper.impl.DataMapperRootImpl;
import org.wso2.developerstudio.datamapper.impl.TreeNodeImpl;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * @generated
 */
public class DataMapperDiagramEditor extends DiagramDocumentEditor implements IGotoMarker {

    /**
     * @generated NOT
     */
    private static final String INPUT_SCHEMA_ID = "Input-Schema"; //$NON-NLS-1$

    /**
     * @generated NOT
     */
    private static final String OUTPUT_SCHEMA_ID = "Output-Schema"; //$NON-NLS-1$

    /**
     * @generated NOT
     */
    private static final String ERROR_WRITING_SCHEMA_FILE = Messages.DataMapperMultiPageEditor_errorWritingSchemaFile;

    /**
     * @generated NOT
     */
    private static final String ERROR_PARSING_THE_SCHEMA = "Error parsing the schema";

    /**
     * @generated
     */
    public static final String ID = "org.wso2.developerstudio.datamapper.diagram.part.DataMapperDiagramEditorID"; //$NON-NLS-1$

    /**
     * @generated
     */
    public static final String CONTEXT_ID = "org.wso2.developerstudio.datamapper.diagram.ui.diagramContext"; //$NON-NLS-1$

    /**
     * @generated NOT
     */

    public DataMapperDiagramEditor() {
        super(true);
        IWorkbench workbench = PlatformUI.getWorkbench();
        IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
        try {
            workbench.showPerspective("org.wso2.developerstudio.datamapper.diagram.custom.perspective", window); //$NON-NLS-1$
        } catch (WorkbenchException e) {
        }
    }

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

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
        new DataMapperPaletteFactory().fillPalette(root);
        return root;
    }

    /**
     * @generated
     */
    protected PreferencesHint getPreferencesHint() {
        return DataMapperDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
    }

    /**
     * @generated
     */
    public String getContributorId() {
        return DataMapperDiagramEditorPlugin.ID;
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
     * @generated
     */
    protected IDocumentProvider getDocumentProvider(IEditorInput input) {
        if (input instanceof IFileEditorInput || input instanceof URIEditorInput) {
            return DataMapperDiagramEditorPlugin.getInstance().getDocumentProvider();
        }
        return super.getDocumentProvider(input);
    }

    /**
     * @generated
     */
    public TransactionalEditingDomain getEditingDomain() {
        IDocument document = getEditorInput() != null ? getDocumentProvider().getDocument(getEditorInput()) : null;
        if (document instanceof IDiagramDocument) {
            return ((IDiagramDocument) document).getEditingDomain();
        }
        return super.getEditingDomain();
    }

    /**
     * @generated
     */
    protected void setDocumentProvider(IEditorInput input) {
        if (input instanceof IFileEditorInput || input instanceof URIEditorInput) {
            setDocumentProvider(DataMapperDiagramEditorPlugin.getInstance().getDocumentProvider());
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

    /**
     * @generated NOT
     */
    public boolean isSaveAsAllowed() {
        return false;
    }

    /**
     * @generated NOT
     */
    public void doSaveAs() {
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
            String message = NLS.bind(Messages.DataMapperDiagramEditor_SavingDeletedFile, original.getName());
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
                MessageDialog.openWarning(shell, Messages.DataMapperDiagramEditor_SaveAsErrorTitle,
                        Messages.DataMapperDiagramEditor_SaveAsErrorMessage);
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
                ErrorDialog.openError(shell, Messages.DataMapperDiagramEditor_SaveErrorTitle,
                        Messages.DataMapperDiagramEditor_SaveErrorMessage, x.getStatus());
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
            DataMapperNavigatorItem item = new DataMapperNavigatorItem(diagram, file, false);
            return new StructuredSelection(item);
        }
        return StructuredSelection.EMPTY;
    }

    /**
     * @generated
     */
    protected void configureGraphicalViewer() {
        super.configureGraphicalViewer();

        IDiagramGraphicalViewer viewer = getDiagramGraphicalViewer();
        KeyHandler viewerKeyHandler = new CustomDiagramGraphicalViewerKeyHandler(this, viewer);

        viewerKeyHandler.setParent(getKeyHandler());
        viewer.setKeyHandler(new DirectEditKeyHandler(viewer).setParent(viewerKeyHandler));

        // This enables the property view to be informed of selection changes in our graphical view,
        // when our view is the active workbench part.
        this.getSite().setSelectionProvider(viewer);

        org.wso2.developerstudio.datamapper.diagram.part.DiagramEditorContextMenuProvider provider = new org.wso2.developerstudio.datamapper.diagram.part.DiagramEditorContextMenuProvider(
                this, getDiagramGraphicalViewer());
        getDiagramGraphicalViewer().setContextMenu(provider);
        getSite().registerContextMenu(ActionIds.DIAGRAM_EDITOR_CONTEXT_MENU, provider, getDiagramGraphicalViewer());

    }

    @Override
    public void init(org.eclipse.ui.IEditorSite site, IEditorInput input) throws org.eclipse.ui.PartInitException {
        super.init(site, input);
        setTitleOfDataMapperDiagramConfiguration(input.getName());
    }

    private void setTitleOfDataMapperDiagramConfiguration(String name) {
        String title = name.replace("datamapper_diagram", "dmc"); //$NON-NLS-1$ //$NON-NLS-2$
        setTitle(title);
    }

    @Override
    public void doSave(IProgressMonitor monitor) {
        updateAvroSchema();
        updateAssociatedConfigFile(monitor);
        super.doSave(monitor);
    }

    private void updateAvroSchema() {
        // Get model root of the active DataMapperDiagramEditor
        EObject modelRoot = this.getDiagram().getElement();
        DataMapperRootImpl datamapperRoot = (DataMapperRootImpl) modelRoot;

        // Model root of input schema tree
        EList<TreeNode> inputTreeNodesList = ((DataMapperRoot) datamapperRoot).getInput().getTreeNode();
        // If a tree node is found, continue saving
        if (null != inputTreeNodesList && !inputTreeNodesList.isEmpty()) {
            TreeNodeImpl inputTreeNode = (TreeNodeImpl) inputTreeNodesList.get(0);
            // This traverses input tree view and returns the updated avro
            // schema
            AvroSchemaTransformer avroSchemaTransformer = new AvroSchemaTransformer();
            Schema inputAvroSchema = avroSchemaTransformer.transform(inputTreeNode);
            updateSchemaFile(INPUT_SCHEMA_ID, inputAvroSchema);
        }
        // Empty tree node, clear the file
        else {
            updateSchemaFile(INPUT_SCHEMA_ID, null);
        }

        // Model root of output schema tree
        EList<TreeNode> outputTreeNodesList = ((DataMapperRoot) datamapperRoot).getOutput().getTreeNode();
        // If a tree node is found, continue saving
        if (null != outputTreeNodesList && !outputTreeNodesList.isEmpty()) {
            TreeNodeImpl outputTreeNode = (TreeNodeImpl) outputTreeNodesList.get(0);
            // This traverses output tree view and returns the updated avro
            // schema
            AvroSchemaTransformer avroSchemaTransformer = new AvroSchemaTransformer();
            Schema outputAvroSchema = avroSchemaTransformer.transform(outputTreeNode);
            updateSchemaFile(OUTPUT_SCHEMA_ID, outputAvroSchema);
        }
        // Empty tree node, clear the file
        else {
            updateSchemaFile(OUTPUT_SCHEMA_ID, null);
        }

    }

    private void updateAssociatedConfigFile(IProgressMonitor monitor) {
        IEditorInput editorInput = this.getEditorInput();

        if (editorInput instanceof IFileEditorInput) {
            IFile diagramFile = ((FileEditorInput) editorInput).getFile();
            String configFilePath = diagramFile.getFullPath().toString();
            configFilePath = configFilePath.replaceAll(".datamapper_diagram$", ".dmc"); //$NON-NLS-1$ //$NON-NLS-2$
            IFile configFile = diagramFile.getWorkspace().getRoot().getFile(new Path(configFilePath));
            InputStream is = null;
            try {
                DataMapperRoot rootDiagram = (DataMapperRoot) this.getDiagram().getElement();
                String source = DataMapperModelTransformer.getInstance().transform(rootDiagram);
                if (source == null) {
                    log.warn("Could get source"); //$NON-NLS-1$
                    return;
                }
                is = new ByteArrayInputStream(source.getBytes());
                if (configFile.exists()) {
                    configFile.setContents(is, true, true, monitor);
                } else {
                    configFile.create(is, true, monitor);
                }

            } catch (DataMapperException e) {
                log.warn(e.getMessage(), e);
            } catch (Exception e) {
                log.warn("Could not save file " + configFile +" : "+e); //$NON-NLS-1$
                e.printStackTrace();
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        // ignore.
                    }
                }
            }
        }
    }

    private void updateSchemaFile(String schemaType, Schema schema) {
        // Schema file location is identified using editor input
        IFile graphicalFile = ((IFileEditorInput) getEditorInput()).getFile();
        String configName = graphicalFile.getName().substring(0,
                graphicalFile.getName().indexOf(EditorUtils.DIAGRAM_FILE_EXTENSION));

        String graphicalFileDirPath = graphicalFile.getParent().getProjectRelativePath().toString();
        if (graphicalFileDirPath != null && !"".equals(graphicalFileDirPath)) { //$NON-NLS-1$
            graphicalFileDirPath += File.separator;
        }

        String newFilePath;
        IFile newSchemaIFile;
        // Schema type can only be either input or output
        if (INPUT_SCHEMA_ID.equals(schemaType)) {
            newFilePath = graphicalFileDirPath + configName + EditorUtils.INPUT_SCHEMA_FILE_SUFFIX
                    + EditorUtils.AVRO_SCHEMA_FILE_EXTENSION;
            newSchemaIFile = graphicalFile.getProject().getFile(newFilePath);
        } else {
            newFilePath = graphicalFileDirPath + configName + EditorUtils.OUTPUT_SCHEMA_FILE_SUFFIX
                    + EditorUtils.AVRO_SCHEMA_FILE_EXTENSION;
            newSchemaIFile = graphicalFile.getProject().getFile(newFilePath);
        }
        File newSchemaFile = newSchemaIFile.getRawLocation().makeAbsolute().toFile();

        String fileContent = "";
        // Becomes null when tree is cleared. Write empty string
        if (null != schema) {
            try {
                fileContent = schema.toString(true);
            } catch (SchemaParseException e) {
                log.error(ERROR_PARSING_THE_SCHEMA, e);
                IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
                ErrorDialog.openError(getSite().getShell(), ERROR_PARSING_THE_SCHEMA, null, status);
                return;
            }
        }

        try {
            FileUtils.writeStringToFile(newSchemaFile, fileContent);
        } catch (IOException e) {
            log.error(ERROR_WRITING_SCHEMA_FILE + newSchemaIFile.getName(), e);
            IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
            ErrorDialog.openError(getSite().getShell(), ERROR_WRITING_SCHEMA_FILE + newSchemaIFile.getName(), null,
                    status);
            return;
        }

    }

}

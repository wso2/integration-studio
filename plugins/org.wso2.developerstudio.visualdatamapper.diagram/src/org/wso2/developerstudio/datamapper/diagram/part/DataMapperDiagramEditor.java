/*
 * Copyright (c) 2014-2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.datamapper.diagram.part;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.commons.io.IOUtils;
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
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.IShowInTargetList;
import org.eclipse.ui.part.ShowInContext;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.wso2.developerstudio.datamapper.DataMapperRoot;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.custom.CustomPaletteViewerKeyHandler;
import org.wso2.developerstudio.datamapper.diagram.custom.exception.DataMapperException;
import org.wso2.developerstudio.datamapper.diagram.custom.persistence.DataMapperModelTransformer;
import org.wso2.developerstudio.datamapper.diagram.custom.util.EditorUtils;
import org.wso2.developerstudio.datamapper.diagram.navigator.DataMapperNavigatorItem;
import org.wso2.developerstudio.datamapper.diagram.tree.generator.ISchemaTransformer;
import org.wso2.developerstudio.datamapper.diagram.tree.generator.SchemaTransformerRegistry;
import org.wso2.developerstudio.datamapper.diagram.xslt.XSLTStyleSheetGenerationHandler;
import org.wso2.developerstudio.datamapper.impl.DataMapperRootImpl;
import org.wso2.developerstudio.datamapper.impl.TreeNodeImpl;
import org.wso2.developerstudio.datamapper.servlets.DataMapperConfigHolder;
import org.wso2.developerstudio.datamapper.views.RealtimeDatamapperView;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.project.presentation.ProjectPresentation;
import org.xml.sax.SAXException;

/**
 * @generated
 */
public class DataMapperDiagramEditor extends DiagramDocumentEditor implements IGotoMarker {
	RealtimeDatamapperView realtimeDatamapperView = null;
    private static final String DATA_MAPPER_TEST_VIEW = "org.wso2.developerstudio.datamapper.views.RealtimeDatamapperView";
    private static final String DATA_MAPPER_PERSPECTIVE = "org.wso2.developerstudio.datamapper.diagram.custom.perspective";
    private static final String DATA_MAPPER_META_INPUT_TYPE = "inputType";
    private static final String DATA_MAPPER_META_OUTPUT_TYPE = "outputType";
    private static final String DOT_REPRESENTATION = "_DOT_";
    private static final String DOT = ".";
    private String inputSchemaType = "XML";
    private String outputSchemaType = "XML";
	
    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        super.dispose();
        // Closing the datamapper test view when editor view is closed.
        IWorkbenchPage wp = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        IViewPart myView = wp.findView(DATA_MAPPER_TEST_VIEW);
        wp.hideView(myView);
    }
	   
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
	private static final String INPUT_SAMPLE_ID = "Input-Sample"; //$NON-NLS-1$

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
        final IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
        try {
            workbench.showPerspective(DATA_MAPPER_PERSPECTIVE, window); // $NON-NLS-1$
            ProjectPresentation.setHierarchicalProjectPresentation();
            PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
                @Override
                public void run() {
                   try {
                        realtimeDatamapperView = (RealtimeDatamapperView) PlatformUI.getWorkbench()
                                .getActiveWorkbenchWindow().getActivePage().showView(DATA_MAPPER_TEST_VIEW);
                        realtimeDatamapperView.setURL();
                    } catch (PartInitException e) {
                        
                    }
                }
            });
        } catch (WorkbenchException e) {
        }

        // Listener to detect events on datamapper editor part
        IPartListener2 pl = new IPartListener2() {
            public void partActivated(IWorkbenchPartReference ref) {

            }

            @Override
            public void partBroughtToTop(IWorkbenchPartReference partRef) {

            }

            @Override
            public void partClosed(IWorkbenchPartReference partRef) {
                // TODO Auto-generated method stub

            }

            @Override
            public void partDeactivated(IWorkbenchPartReference partRef) {
                // TODO Auto-generated method stub

            }

            @Override
            public void partOpened(IWorkbenchPartReference partRef) {
            }

            @Override
            public void partHidden(IWorkbenchPartReference partRef) {
                // TODO Auto-generated method stub

            }

            // Changing the browser contents when the active datamapper editor window changed
            @Override
            public void partVisible(final IWorkbenchPartReference partRef) {
                loadContentTypes(); //This can be ommited if schema files are read from js side
                IWorkbenchPart part = partRef.getPart(false);
                if (partRef.getPage().getActiveEditor() instanceof DataMapperDiagramEditor) {
                    DataMapperDiagramEditor temp = (DataMapperDiagramEditor) partRef.getPage().getActiveEditor();
                    if (part == window.getActivePage().getActiveEditor()) {
                        temp.loadInitialConfigFileLocations();
                        reloadDataMapperTestWindow(getInputSchemaType(), getOutputSchemaType());
                    }
                }

            }

            @Override
            public void partInputChanged(IWorkbenchPartReference partRef) {
                // TODO Auto-generated method stub

            }
        };
        window.getActivePage().addPartListener(pl);
    }
    
    /**
     * Show datamapper test window and reload web page
     * @param inputSchemaType type of input payload to be sent to JS side
     * @param outputSchemaType type of output payload to be sent to JS side
     */
    private void reloadDataMapperTestWindow(String inputSchemaType, String outputSchemaType) {
        final String inputScheme = inputSchemaType;
        final String outputScheme = outputSchemaType;
        PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
            @Override
            public void run() {
                try {
                    realtimeDatamapperView = (RealtimeDatamapperView) PlatformUI.getWorkbench()
                            .getActiveWorkbenchWindow().getActivePage().showView(DATA_MAPPER_TEST_VIEW);
                    realtimeDatamapperView.setURL(inputScheme,outputScheme);
                } catch (PartInitException e) {

                }
            }
        });
    }

	// load inputSchema / outputSchema and DMC file locations and update the singleton class.
    private void loadInitialConfigFileLocations() {

        File inputSchemaFile = createSchemaFile(INPUT_SCHEMA_ID);
        DataMapperConfigHolder.getInstance().setInputSchemaPath(inputSchemaFile.getAbsolutePath());
        File outputSchemaFile = createSchemaFile(OUTPUT_SCHEMA_ID);
        DataMapperConfigHolder.getInstance().setOutputSchemaPath(outputSchemaFile.getAbsolutePath());
        File inputSampleFile = createSchemaFile(INPUT_SAMPLE_ID);
        DataMapperConfigHolder.getInstance().setInputFile(inputSampleFile.getAbsolutePath());
        
        IEditorInput editorInput = this.getEditorInput();

        if (editorInput instanceof IFileEditorInput) {
            IFile diagramFile = ((FileEditorInput) editorInput).getFile();
            String configFilePath = diagramFile.getFullPath().toString();
            configFilePath = configFilePath.replaceAll(".datamapper_diagram$", ".dmc");
            IFile configFile = diagramFile.getWorkspace().getRoot().getFile(new Path(configFilePath));
            String absolutePath = configFile.getLocation().toFile().getAbsoluteFile().getPath();
            DataMapperConfigHolder.getInstance().setDmcPath(absolutePath);
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
	 * @generated NOT
	 */
	protected int getInitialDockLocation() {
		return PositionConstants.WEST;
	}

	protected int getInitialPaletteSize() {
		return 200;
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
	 * @generated NOT
	 */
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		// Define key handler for palette viewer.
		PaletteViewer paletteViewer = getPaletteViewerProvider().getEditDomain().getPaletteViewer();
		KeyHandler paletteViewerKeyHandler = new CustomPaletteViewerKeyHandler(paletteViewer);
		paletteViewer.setKeyHandler(paletteViewerKeyHandler);

		DiagramEditorContextMenuProvider provider = new DiagramEditorContextMenuProvider(this,
				getDiagramGraphicalViewer());
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
		updateSchema();
		boolean success = updateAssociatedConfigFile(monitor);
		//Fixing DEVTOOLESB-651
		if (success) {
			super.doSave(monitor);
			updateAssociatedXsltFile(monitor);
		}
	}

	private void updateSchema() {
		// Get model root of the active DataMapperDiagramEditor
		EObject modelRoot = this.getDiagram().getElement();
		DataMapperRootImpl datamapperRoot = (DataMapperRootImpl) modelRoot;
		ISchemaTransformer schemaTransformer = null;
		try {
			schemaTransformer = SchemaTransformerRegistry.getInstance().getSchemaTransformer().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			log.error(e);
		}
		// Model root of input schema tree
		EList<TreeNode> inputTreeNodesList = ((DataMapperRoot) datamapperRoot).getInput().getTreeNode();
		File schemaFile = null;
		String content = null;
		// If a tree node is found, continue saving
		if (null != inputTreeNodesList && !inputTreeNodesList.isEmpty()) {
			TreeNodeImpl inputTreeNode = (TreeNodeImpl) inputTreeNodesList.get(0);
			// This traverses input tree view and returns the updated avro
			// schema
			schemaFile = createSchemaFile(INPUT_SCHEMA_ID);
			content = schemaTransformer.getSchemaContentFromModel(inputTreeNode, schemaFile, true, inputSchemaType);
		}
		// Empty tree node, clear the file
		else {
			schemaFile = createSchemaFile(INPUT_SCHEMA_ID);
			content = "";
            // Clear the content of the sample input file
            clearInputSampleFile();
		}

        // Before saving the schema changes, check whether the schema is changed. If it has, clear the input sample file
        // because the original input values may not apply thereafter
        if (hasInputSchemaChanged(content)) {
            // Clear the content of the sample input file
            clearInputSampleFile();
        }

		DataMapperConfigHolder.getInstance().setInputSchemaPath(schemaFile.getAbsolutePath());
		schemaTransformer.updateSchemaFile(content.replace(DOT_REPRESENTATION, DOT), schemaFile);

		// Model root of output schema tree
		EList<TreeNode> outputTreeNodesList = ((DataMapperRoot) datamapperRoot).getOutput().getTreeNode();
		// If a tree node is found, continue saving
		if (null != outputTreeNodesList && !outputTreeNodesList.isEmpty()) {
			TreeNodeImpl outputTreeNode = (TreeNodeImpl) outputTreeNodesList.get(0);
			// This traverses output tree view and returns the updated avro
			// schema
			schemaFile = createSchemaFile(OUTPUT_SCHEMA_ID);
			content = schemaTransformer.getSchemaContentFromModel(outputTreeNode, schemaFile, false, outputSchemaType);
		}
		// Empty tree node, clear the file
		else {
			schemaFile = createSchemaFile(OUTPUT_SCHEMA_ID);            
			content = "";
		}
		DataMapperConfigHolder.getInstance().setOutputSchemaPath(schemaFile.getAbsolutePath());
		schemaTransformer.updateSchemaFile(content.replace(DOT_REPRESENTATION, DOT), schemaFile);
		
		// reload the datamapper test window once the new schema is saved.
		reloadDataMapperTestWindow(getInputSchemaType(), getOutputSchemaType());
	}
	
	/**
	 * Compares the schema before updating with the new schema to check whether there are any changes
	 * 
	 * @param modifiedSchema
	 * @return true if the input schema has changed and false if not
	 */
    private boolean hasInputSchemaChanged(String modifiedSchema) {
        try {
            if (null != DataMapperConfigHolder.getInstance().getInputSchemaPath()) {
                String prevSchema = new String(
                        Files.readAllBytes(Paths.get(DataMapperConfigHolder.getInstance().getInputSchemaPath())));
                JSONObject prevSchemaJson = (JSONObject) new JSONParser().parse(prevSchema);
                JSONObject modifiedSchemaJson = (JSONObject) new JSONParser().parse(modifiedSchema);
                prevSchemaJson.remove("inputType");

                // Compare whether the schema has any changes
                if (prevSchemaJson != null && modifiedSchema != null && !prevSchemaJson.equals(modifiedSchemaJson)) {
                    return true;
                }
            }
        } catch (ParseException | IOException e) {
            log.error("Failed to compare the new schema with the previous schema to identify changes!", e);
        }
        return false;
    }

    /**
     * Clears input sample file
     */
    private void clearInputSampleFile() {
        File sampleInputFile = createSchemaFile(INPUT_SAMPLE_ID);
        PrintWriter writer;
        try {
            writer = new PrintWriter(sampleInputFile);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            log.error("Input sample file not found!", e);
        }
    }

	private File createSchemaFile(String schemaType) {
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
            // TODO handle the extension of the file despite the schemaType
            newFilePath = graphicalFileDirPath + configName + EditorUtils.INPUT_SCHEMA_FILE_SUFFIX
                    + EditorUtils.AVRO_SCHEMA_FILE_EXTENSION;
            newSchemaIFile = graphicalFile.getProject().getFile(newFilePath);
        } else if (INPUT_SAMPLE_ID.equals(schemaType)) {
            newFilePath = graphicalFileDirPath + configName + EditorUtils.INPUT_SAMPLE_FILE_SUFFIX
                    + EditorUtils.TEXT_FILE_EXTENSION;
            newSchemaIFile = graphicalFile.getProject().getFile(newFilePath);
        } else {
            newFilePath = graphicalFileDirPath + configName + EditorUtils.OUTPUT_SCHEMA_FILE_SUFFIX
                    + EditorUtils.AVRO_SCHEMA_FILE_EXTENSION;
            newSchemaIFile = graphicalFile.getProject().getFile(newFilePath);
        }
		File newSchemaFile = newSchemaIFile.getRawLocation().makeAbsolute().toFile();
		return newSchemaFile;
	}

	private boolean updateAssociatedConfigFile(IProgressMonitor monitor) {
		IEditorInput editorInput = this.getEditorInput();

		if (editorInput instanceof IFileEditorInput) {
			IFile diagramFile = ((FileEditorInput) editorInput).getFile();
			String configFilePath = diagramFile.getFullPath().toString();
			configFilePath = configFilePath.replaceAll(".datamapper_diagram$", ".dmc"); //$NON-NLS-1$ //$NON-NLS-2$
			IFile configFile = diagramFile.getWorkspace().getRoot().getFile(new Path(configFilePath));
			String absolutePath = configFile.getLocation().toFile().getAbsoluteFile().getPath();
			DataMapperConfigHolder.getInstance().setDmcPath(absolutePath);
			InputStream is = null;
			try {
				DataMapperRoot rootDiagram = (DataMapperRoot) this.getDiagram().getElement();
				String source = DataMapperModelTransformer.getInstance().transform(rootDiagram);
				if (source == null) {
					log.warn("Could not found source"); //$NON-NLS-1$
					return false;
				}
				is = new ByteArrayInputStream(source.getBytes());
				if (configFile.exists()) {
					configFile.setContents(is, true, true, monitor);
				} else {
					configFile.create(is, true, monitor);
				}

			} catch (DataMapperException e) {
				log.warn(e.getMessage(), e);
				popupErrorDialogBox(e);
				return false;
			} catch (Exception e) {
				log.warn("Could not save file " + configFile + " : " + e); //$NON-NLS-1$
				popupErrorDialogBox(e);
				return false;
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
		return true;
	}
	
	private void updateAssociatedXsltFile(IProgressMonitor monitor) {
		IEditorInput editorInput = this.getEditorInput();
        if (editorInput instanceof IFileEditorInput) {
            IFile diagramFile = ((FileEditorInput) editorInput).getFile();
            String diagramFilePath = diagramFile.getFullPath().toString();
            String schemaFilePath = diagramFilePath.replaceAll(".datamapper_diagram$", ".datamapper");
            String xsltStyleSheetFilePath = diagramFilePath.replaceAll(".datamapper_diagram$", "_xsltStyleSheet.xml");
            IFile schemaFile = diagramFile.getWorkspace().getRoot().getFile(new Path(schemaFilePath));
            IFile xsltStyleSheetFile = diagramFile.getWorkspace().getRoot().getFile(new Path(xsltStyleSheetFilePath));
            if (xsltStyleSheetFile.exists() && schemaFile.exists()) {
                try (InputStream schemaInPutStream = schemaFile.getContents()) {
                    String schemaContent = IOUtils.toString(schemaInPutStream, "UTF-8");
                    if (schemaContent.contains(DOT_REPRESENTATION)) {
                    	schemaContent = schemaContent.replace(DOT_REPRESENTATION, DOT);
                    	schemaFile.setContents(new ByteArrayInputStream(schemaContent.getBytes()), true, true, monitor);
                    }
                    InputStream replacedSchemaStream = IOUtils.toInputStream(schemaContent);
                    String source = XSLTStyleSheetGenerationHandler.getInstance().generate(replacedSchemaStream);
                    xsltStyleSheetFile.setContents(new ByteArrayInputStream(source.getBytes()), true, true, monitor);
                } catch (CoreException | TransformerException | SAXException | IOException | ParserConfigurationException e) {
                    log.error("Could not save file " + xsltStyleSheetFilePath + " : " + e);
                    popupErrorDialogBox(e);
                }
            }
        }
        
	}

	private void popupErrorDialogBox(Exception e) {
		final String simpleMessage = e.getMessage();
		final IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, simpleMessage);
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				ErrorDialog.openError(Display.getDefault().getActiveShell(), "Data Mapper Error Message", "",
						editorStatus);
			}
		});
	}

    public String getInputSchemaType() {
        return inputSchemaType;
    }

    public void setInputSchemaType(String inputSchemaType) {
        this.inputSchemaType = inputSchemaType;
    }

    public String getOutputSchemaType() {
        return outputSchemaType;
    }

    public void setOutputSchemaType(String outputSchemaType) {
        this.outputSchemaType = outputSchemaType;
    }

    /**
     * Get given schema files IFile objecy
     * @param schemaType input or output schema
     * @return IFile object of given schema file
     */
    private IFile getSchemaFile(String schemaType) {
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
        return newSchemaIFile;
    }

    /**
     * Reads given schema file and outputs its JSONObject
     * @param schemaTypeID input or output schema
     * @return JSONObject of the schema file read
     */
    private JSONObject readSchemaFile(String schemaTypeID) {
        IEditorInput editorInput = this.getEditorInput();
        String str = "";
        StringBuffer buf = new StringBuffer();

        if (editorInput instanceof IFileEditorInput) {
            IFile diagramFile = ((FileEditorInput) editorInput).getFile();
            IFile schemaFile = diagramFile.getWorkspace().getRoot().getFile(getSchemaFile(schemaTypeID).getFullPath());
            InputStream contentStream;

            try {
                contentStream = schemaFile.getContents(true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(contentStream));

                if (contentStream != null) {
                    while ((str = reader.readLine()) != null) {
                        buf.append(str + "\n");
                    }
                }
            } catch (CoreException | IOException e) {
                log.error("Could not read schema file" + e);
            }
        }

        JSONParser parser = new JSONParser();
        JSONObject json = null;
        try {
            json = (JSONObject) parser.parse(buf.toString());
        } catch (ParseException e) {
            log.error("Could not parse schema json : " + e);
        }
        return json;
    }

    /**
     * Reads schema files and sets input schema type and output schema type
     * params
     */
    private void loadContentTypes() {
        JSONObject inputJsonObj = readSchemaFile(INPUT_SCHEMA_ID);

        if (inputJsonObj != null) {
            String inputType = (String) inputJsonObj.get(new String(DATA_MAPPER_META_INPUT_TYPE));
            if (inputType != null && !inputType.isEmpty()) {
                setInputSchemaType(inputType);
            }
        }

        JSONObject outputJsonObj = readSchemaFile(OUTPUT_SCHEMA_ID);
        if (outputJsonObj != null) {
            String outputType = (String) outputJsonObj.get(new String(DATA_MAPPER_META_OUTPUT_TYPE));
            if (outputType != null && !outputType.isEmpty()) {
                setOutputSchemaType(outputType);
            }
        }
    }

}

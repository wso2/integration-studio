/*******************************************************************************
 * Copyright (c) 2000, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.part;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils.SEQUENCE_RESOURCE_DIR;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.io.IOUtils;
import org.apache.synapse.SynapseException;
import org.apache.synapse.commons.SynapseCommonsException;
import org.apache.synapse.config.xml.rest.APIFactory;
import org.apache.synapse.mediators.builtin.LogMediator;
import org.apache.synapse.rest.API;
import org.apache.synapse.task.SynapseTaskException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.wso2.carbon.mediator.service.MediatorException;
import org.wso2.carbon.rest.api.service.RestApiAdmin;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEsbEditorInput;
import org.wso2.developerstudio.eclipse.esb.project.control.graphicalproject.GMFPluginDetails;
import org.wso2.developerstudio.eclipse.esb.project.control.graphicalproject.IUpdateGMFPlugin;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbElement;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequences;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ExceptionMessageMapper;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.cloudconnector.CloudConnectorDirectoryTraverser;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.AbstractEsbNodeDeserializer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.Deserializer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.Deserializer.DeserializeStatus;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.dialogs.RegistryResourcesUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.DeserializerException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.DummyAPIFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.MediatorFactoryUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.UpdateGMFPlugin;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.ESBDebuggerException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.swagger.EsbSwaggerEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator.ProcessSourceView;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator.SourceError;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator.ValidationException;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbModelTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.SequenceInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.event.EsbEditorEvent;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioProviderData;
import org.wso2.developerstudio.eclipse.platform.core.project.presentation.ProjectPresentation;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryFile;
import org.wso2.developerstudio.esb.form.editors.article.rcp.ESBFormEditor;
import org.wso2.developerstudio.esb.form.editors.mockservice.MockServiceFormToSourceTransformer;
import org.wso2.developerstudio.esb.form.editors.mockservice.MockServiceSourceToFormDeserializer;
import org.wso2.developerstudio.esb.form.editors.unittest.SynapseUnitTestFormToSourceTransformer;
import org.wso2.developerstudio.esb.form.editors.unittest.SynapseUnitTestSourceToFormDeserializer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.DefaultEsbModelExporter;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.DataMapperMediatorEditPart;

/**
 * The main editor class which contains design view and source view
 * <ul>
 * <li>page 0 graphical view
 * <li>page 1 source view
 * </ul>
 */
public class EsbMultiPageEditor extends MultiPageEditorPart implements IGotoMarker, IDiagramWorkbenchPart {

    /** Our all new graphical editor */
    private EsbDiagramEditor graphicalEditor;
    
    /** Our all new swagger editor */
    private EsbSwaggerEditor swaggerlEditor;

    /**
     * {@link ModelObject} source editor.
     */
    private EsbObjectSourceEditor sourceEditor;

    /**
     * {@link ModelObject} form editor.
     */
    private ESBFormEditor formEditor;

    /**
     * Name of the directory which holds temporary files.
     */
    public static final String TEMPORARY_RESOURCES_DIRECTORY = ".org.wso2.developerstudio.eclipse.esb";

    /**
     * Design view page index.
     */
    private static final int DESIGN_VIEW_PAGE_INDEX = 0;

    /**
     * Source view page index.
     */
    private static final int SOURCE_VIEW_PAGE_INDEX = 1;
    
    /**
     * Source view page index.
     */
    private static final int SWAGGER_VIEW_PAGE_INDEX = 2;

    private static final String SOURCE_VIEW_ERROR = "SOURCE_VIEW_ERROR";
    
    private static final String MOCK_SERVICE = "MOCK_SERVICE";
    
    private static final String SYNAPSE_UNIT_TEST = "SYNAPSE_UNIT_TEST";

    private static final String CONFIG_ERROR = "org.wso2.developerstudio.eclipse.gmf.esb.diagram.synapseerror";

    private static final String ESB_GRAPHICAL_PERSPECTIVE_ID = "org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.perspective";
    
    private static final String CONNECTOR_ADDED_KEY = "ConnectorAdded";

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /* source editor dirty state */
    private boolean sourceDirty;
    public static EsbMultiPageEditor currentEditor;
    private ArtifactType currArtifactType;

    private double zoom = 1.0;
    private String fileName;
    private String validationMessage;
    private String oldSwaggerSource;
    boolean initialPageLoad;
    boolean isFormEditor;

    private IFile file;
    private static final List<IFile> files = new ArrayList<>();
    private static final List<IFile> artifactXMLFiles = new ArrayList<>();
    private static String swaggerSource;
    private static int lastActivePage = 0;

    /**
     * Creates a multi-page editor
     */
    public EsbMultiPageEditor() {
        super();
    }

    private void setArtifactType() {
        IEditorInput editorInput = getEditorInput();
        if (editorInput instanceof FileEditorInput) {
            IFile file = ((FileEditorInput) editorInput).getFile();
            fileName = file.getName();
            try (InputStream inputStream = file.getContents(); Scanner scanner = new Scanner(inputStream)) {
                final String source = scanner.useDelimiter("\\A").next();
                currArtifactType = Deserializer.getInstance().getArtifactType(source);
            } catch (Exception e) {
                log.error("Error in retrieving the artifact type for editor generation", e);
            }
        }
    }

    /**
     * Creates page 0 of the multi-page editor, which contains a out graphical
     * diagram
     */
    void createPage0() {
        DiagramUIPlugin.getInstance().getPreferenceStore().setValue("org.eclipse.gmf.pdock", PositionConstants.EAST);
        deleteMarkers();

        GMFPluginDetails.setiUpdateGMFPlugin(new UpdateGMFPlugin());
        currentEditor = this;
        graphicalEditor = new EsbDiagramEditor(this);
        IEditorInput editorInput = getEditorInput();
        if (editorInput instanceof FileEditorInput) {
            IFile file = ((FileEditorInput) editorInput).getFile();
            fileName = file.getName();
            
            try (InputStream inputStream = file.getContents(); Scanner scanner = new Scanner(inputStream)) {
                final String source = scanner.useDelimiter("\\A").next();
                final Deserializer deserializer = Deserializer.getInstance();
                editorInput = new EsbEditorInput(null, file, deserializer.getArtifactType(source).getLiteral());

                addPage(DESIGN_VIEW_PAGE_INDEX, graphicalEditor, editorInput);

                Display.getDefault().asyncExec(new Runnable() {
                    @Override
                    public void run() {
                        ESBDebuggerUtil.setPageCreateOperationActivated(true);
                        try {
                            DeserializeStatus deserializeStatus = deserializer.isValidSynapseConfig(source, true, false);
                            deleteMarkers();
                            if (deserializeStatus.isValid()
                                    || deserializeStatus.getExecption() instanceof SynapseException
                                    || deserializeStatus.getExecption() instanceof MediatorException) {

                                if (!deserializeStatus.isValid()) {
                                    SourceError sourceError = ProcessSourceView.validateSynapseContent(source);

                                    if (sourceError == null) {
                                        sourceError = new SourceError(deserializeStatus.getExecption().getMessage(), 0,
                                                0, 2);
                                    }
                                    addMarker(sourceError);
                                }

                                deserializer.updateDesign(source, graphicalEditor, false);
                                Display.getDefault().asyncExec(new Runnable() {
                                    @Override
                                    public void run() {
                                        doSave(new NullProgressMonitor());
                                    }
                                });

                            } else if (deserializeStatus.getExecption() instanceof NullPointerException) {
                                addMarker(new SourceError("Invalid mediator configuration: "
                                        + deserializeStatus.getExecption().getMessage(), 0, 0, 2));

                            } else {
                                setActivePage(SOURCE_VIEW_PAGE_INDEX);
                                sourceEditor.getDocument().set(source);

                                addMarker(ProcessSourceView.validateXMLContent(source));
                            }
                        } catch (Exception e) {
                            log.error("Error while generating diagram from source", e);
                        } finally {
                            ESBDebuggerUtil.setPageCreateOperationActivated(false);
                        }
                    }
                });
            } catch (PartInitException e) {
                ErrorDialog.openError(getSite().getShell(), "ErrorCreatingNestedEditor", null, e.getStatus());
            } catch (Exception e) {
                log.error("Error while generating diagram from source", e);
            }
            setTitle(file.getName());
        }

        setPageText(DESIGN_VIEW_PAGE_INDEX, "Design");

        /*
         * This must be altered. 'addDefinedSequences' and 'addDefinedEndpoints' methods
         * should not exist inside EsbPaletteFactory class. Creating new instance of
         * 'EsbPaletteFactory' must be avoided.
         */
        EsbPaletteFactory esbPaletteFactory = new EsbPaletteFactory();
        esbPaletteFactory.addDefinedSequences(getEditor(0));
        esbPaletteFactory.addDefinedEndpoints(getEditor(0));

        EsbEditorInput input = (EsbEditorInput) getEditor(0).getEditorInput();
        IProject activeProject = input.getXmlResource().getProject();

        new Thread( new Runnable() {
            
            @Override
            public void run() {
                // TODO Auto-generated method stub
                if (CloudConnectorDirectoryTraverser.getInstance().validate(activeProject)) {
                    String connectorDirectory = activeProject.getLocation().toOSString() + File.separator + "cloudConnectors";
                    try {
                        File directory = new File(connectorDirectory);
                        if (directory.isDirectory()) {
                            File[] children = directory.listFiles();
                            for (int i = 0; i < children.length; ++i) {
                                if (children[i].isDirectory()) {
                                    esbPaletteFactory.addCloudConnectorOperations(getEditor(0), children[i].getName());
                                }
                            }
                        }
                    } catch (Exception e1) {
                        MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                                "Developer studio Error", "Error while loading the Connectors" + e1.getMessage());
                    }
                }
                
            }
        }).run();
   

        String pathName = activeProject.getLocation().toOSString() + File.separator + "resources";

        Properties prop = new Properties();
        File cloudConFile = new File(pathName, "cloudConnector.properties");
        if (cloudConFile.exists()) {
            try (FileInputStream inStream = new FileInputStream(cloudConFile)) {
                prop.load(inStream);
            } catch (FileNotFoundException e) {
                log.error("File is not available.", e);
            } catch (IOException e) {
                log.error("Error occurred while trying to load properties", e);
            }
        }

        esbPaletteFactory.updateToolPaletteItems(graphicalEditor);

        EditorUtils.setLockmode(graphicalEditor, false);

        // change editor title when a file rename occurs
        getEditor(0).addPropertyListener(new IPropertyListener() {

            @Override
            public void propertyChanged(Object source, int propId) {
                setInput(getEditor(0).getEditorInput());
                EsbEditorInput editorInp = (EsbEditorInput) getEditor(0).getEditorInput();
                setTitle(editorInp.getXmlResource().getName());
            }
        });
    }

    /**
     * Creates page 1 of the multi-page editor, which allows you to edit the xml.
     */
    void createPage1() {
        deleteMarkers();
        try {
            file = getTemporaryFile("xml");
            sourceEditor = new EsbObjectSourceEditor(file);
            addPage(SOURCE_VIEW_PAGE_INDEX, sourceEditor.getEditor(), sourceEditor.getInput());
            setPageText(SOURCE_VIEW_PAGE_INDEX, "Source");
            sourceEditor.getDocument().addDocumentListener(new IDocumentListener() {

                public void documentAboutToBeChanged(final DocumentEvent event) {
                    // nothing to do
                }

                public void documentChanged(final DocumentEvent event) {
                    sourceDirty = true;
                    firePropertyChange(PROP_DIRTY);
                }
            });

        } catch (Exception e) {
            log.error("Error while initializing source viewer control.", e);
        }

    }

    /**
     * Creates page 2 of the multi-page editor, which shows the sorted text.
     */
    void createPage2() {
        deleteMarkers();

        Composite composite = new Composite(getContainer(), SWT.NONE);
        GridLayout layout = new GridLayout();
        composite.setLayout(layout);
        layout.numColumns = 2;
        GridData gd = new GridData(GridData.BEGINNING);
        gd.horizontalSpan = 2;
        setPageText(addPage(composite), "Properties");
    }

    private void createPageForm(final ArtifactType artifactType) {
        deleteMarkers();

        IEditorInput editorInput = getEditorInput();
        currentEditor = this;
        formEditor = new ESBFormEditor(artifactType);
        isFormEditor = true;
        try {
            if (editorInput instanceof FileEditorInput) {
                IFile file = ((FileEditorInput) editorInput).getFile();
                fileName = file.getName();
                final Deserializer deserializer = Deserializer.getInstance();
                isFormEditor = true;
                currArtifactType = artifactType;
                try (InputStream inputStream = file.getContents(); Scanner scanner = new Scanner(inputStream)) {
                    final String source = scanner.useDelimiter("\\A").next();
                    editorInput = new EsbEditorInput(null, file, artifactType.getLiteral());
                    Display.getDefault().asyncExec(new Runnable() {
                        @Override
                        public void run() {
                            ESBDebuggerUtil.setPageCreateOperationActivated(true);
                            try {
                                DeserializeStatus deserializeStatus = deserializer.isValidSynapseConfig(source, true, false);

                                if (deserializeStatus.isValid()) {
                                    deserializer.updateDesign(source, formEditor, currArtifactType, true);
                                    Display.getDefault().asyncExec(new Runnable() {
                                        @Override
                                        public void run() {
                                            doSave(new NullProgressMonitor());
                                        }
                                    });
                                } else {
                                    setActivePage(SOURCE_VIEW_PAGE_INDEX);
                                    sourceEditor.getDocument().set(source);
                                    deleteMarkers();

                                    printHandleDesignViewActivatedEventErrorMessageSimple(
                                            deserializeStatus.getExecption(), deserializeStatus);
                                }

                            } catch (Exception e) {
                                log.error("Error while generating diagram from source", e);
                            } finally {
                                ESBDebuggerUtil.setPageCreateOperationActivated(false);
                            }
                        }
                    });
                } catch (Exception e) {
                    log.error("Error while generating diagram from source", e);
                }
                setTitle(file.getName());
            }
            addPage(DESIGN_VIEW_PAGE_INDEX, formEditor, editorInput);
            setPageText(DESIGN_VIEW_PAGE_INDEX, "Form"); //$NON-NLS-1$

            EditorUtils.updateToolpalette();
        } catch (PartInitException e) {
        }
    }

	/**
	 * Creates the swagger design editor page.
	 */
	void createSwaggerEditorPage() {
		swaggerlEditor = new EsbSwaggerEditor(this);
		try {
			addPage(SWAGGER_VIEW_PAGE_INDEX, swaggerlEditor, getEditorInput());
			setPageText(SWAGGER_VIEW_PAGE_INDEX, "Swagger Editor");
		} catch (PartInitException e) {
			ErrorDialog.openError(getSite().getShell(), "Error Creating Swagger Editor", null, e.getStatus());
		}
	}
    /**
     * Utility method for obtaining a reference to a temporary file with the given
     * extension.
     *
     * @param extension
     *            extension of the temporary file.
     * @return {@link IFile} instance corresponding to the specified temporary file.
     * @throws Exception
     *             if a temporary file cannot be created.
     */
    private IFile getTemporaryFile(String extension) throws Exception {
        String fileName = String.format("%s.%s", UUID.randomUUID().toString(), extension);
        IFile tempFile = getTemporaryDirectory().getFile(fileName);
        if (!tempFile.exists()) {
            tempFile.create(new ByteArrayInputStream(new byte[0]), true, null);
        }
        return tempFile;
    }

    /**
     * Utility method for obtaining a reference to the temporary files directory.
     *
     * @return reference to the temporary files directory inside the current
     *         project.
     * @throws Exception
     *             if an error occurs while creating the temporary resources
     *             directory.
     */
    private IFolder getTemporaryDirectory() throws Exception {
        IEditorInput editorInput = getEditorInput();
        if (editorInput instanceof IFileEditorInput || editorInput instanceof FileStoreEditorInput
                || editorInput instanceof EsbEditorInput) {

            IProject tempProject = ResourcesPlugin.getWorkspace().getRoot().getProject(".tmp");

            if (!tempProject.exists()) {
                tempProject.create(new NullProgressMonitor());
            }

            if (!tempProject.isOpen()) {
                tempProject.open(new NullProgressMonitor());
            }

            if (!tempProject.isHidden()) {
                tempProject.setHidden(true);
            }

            IFolder folder = tempProject.getFolder(TEMPORARY_RESOURCES_DIRECTORY);

            if (!folder.exists()) {
                folder.create(true, true, new NullProgressMonitor());
            }

            return folder;
        } else {
            throw new Exception("Unable to create temporary resources directory.");
        }
    }

    /**
     * Creates the pages of the multi-page editor.
     */
    protected void createPages() {
        setArtifactType();
        initialPageLoad = true;
        switch (currArtifactType) {
        case COMPLEX_ENDPOINT:
            break;
        case LOCAL_ENTRY:
        case MESSAGE_PROCESSOR:
        case MESSAGE_STORE:
        case TASK:
        case ENDPOINT:
        case TEMPLATE_ENDPOINT:
        case TEMPLATE_ENDPOINT_DEFAULT:
        case TEMPLATE_ENDPOINT_ADDRESS:
        case TEMPLATE_ENDPOINT_WSDL:
        case TEMPLATE_ENDPOINT_HTTP:
        case ENDPOINT_ADDRESS:
        case ENDPOINT_DEFAULT:
        case ENDPOINT_HTTP:
        case ENDPOINT_WSDL:
        case ENDPOINT_LOADBALANCE:
        case ENDPOINT_FAILOVER:
        case ENDPOINT_RECIPIENTLIST:
        case MOCK_SERVICE:
        case SYNAPSE_UNIT_TEST:	
            createPageForm(currArtifactType);
            break;
        default:
            break;
        }
        if (!isFormEditor) {
            createPage0();
        }
        createPage1();
		if (currArtifactType.equals(org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType.API)) {
			createSwaggerEditorPage();
		}
        if (graphicalEditor != null) {
            EditorUtils.setLockmode(graphicalEditor, false);
        }
    }

    /**
     * This is used to track the active viewer. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     */

    protected void pageChange(int pageIndex) {
        super.pageChange(pageIndex);
        // Fixing TOOLS-2958
        setContextClassLoader();

        // Invoke the appropriate handler method.
        switch (pageIndex) {
		case DESIGN_VIEW_PAGE_INDEX: {
			if (lastActivePage == SWAGGER_VIEW_PAGE_INDEX && isSwaggerDirty()) {
				// Update the design view when the user switch from Swagger editor
				String currentSource = sourceEditor.getDocument().get();
				try {
					RestApiAdmin restAPIAdmin = new RestApiAdmin();
					OMElement element = AXIOMUtil.stringToOM(currentSource);
					API api = APIFactory.createAPI(element);
					String updatedAPI = restAPIAdmin.generateUpdatedAPIFromSwagger(getSource(), api);
					sourceEditor.getDocument().set(updatedAPI);
				} catch (Exception e) {
					log.error("Unable to generate API from the swagger definition", e);
				}
			}
			ESBDebuggerUtil.setPageChangeOperationActivated(true);
            MediatorFactoryUtils.registerFactories();
            String source = sourceEditor.getDocument().get();
            SourceError sourceError = null;

            if (!source.isEmpty()) {
                DeserializeStatus deserializeStatus = Deserializer.getInstance().isValidSynapseConfig(source, false, true);

                if (!deserializeStatus.isValid()) {

                    deleteMarkers();
                    if (!(deserializeStatus.getExecption() instanceof SynapseException
                            || deserializeStatus.getExecption() instanceof MediatorException)) {
                        setActivePage(SOURCE_VIEW_PAGE_INDEX);
                        sourceEditor.getDocument().set(source);

                        try {
                        	sourceError = ProcessSourceView.validateXMLContent(source);
                            if (sourceError != null) {
                                addMarker(sourceError);
                                return;
                            }
                        } catch (ValidationException e) {
                            // ignore
                        }
                    } else if (deserializeStatus.getExecption() instanceof NullPointerException
                            || deserializeStatus.getExecption() instanceof TransformerException) {
                    	sourceError = new SourceError(
                                "Invalid mediator configuration: " + deserializeStatus.getExecption().getMessage(), 0,
                                0, 2);

                    } else {
                        sourceError = ProcessSourceView.validateSynapseContent(source);
                        if (sourceError == null) {
                            sourceError = new SourceError(deserializeStatus.getExecption().getMessage(), 0, 0, 2);
                        }
                    }
                }

            }

            try {

                deleteMarkers();
                
                if (currArtifactType.toString().equals(MOCK_SERVICE) || 
                		currArtifactType.toString().equals(SYNAPSE_UNIT_TEST)) {
                	sourceError = null;
                }
                
                if (sourceError != null) {
                    sourceDirty = true;
                }

                if (isFormEditor) {
                    handleFormViewActivatedEvent(false);
                } else {
                    handleDesignViewActivatedEvent(false);
                    Display.getCurrent().asyncExec(new Runnable() {

                        @Override
                        public void run() {
                            EditorUtils.setLockmode(graphicalEditor, true);
                            // save on initial page load, but not in other cases
                            if (initialPageLoad && isDirty()) {
                                getEditor(0).doSave(new NullProgressMonitor());
                                firePropertyChange(PROP_DIRTY);
                                initialPageLoad = false;
                            }

                            try {
                                EsbDiagram diagram = (EsbDiagram) graphicalEditor.getDiagram().getElement();
                                EsbServer server = diagram.getServer();
                                IEditorInput editorInput = getEditorInput();
                                ESBDebuggerUtil.addDesignViewDebugPoints(server, editorInput);
                            } catch (ESBDebuggerException e) {
                                log.error("Error while adding debug points to design view when page loading : "
                                        + e.getMessage(), e);
                            }

                            // Fixing DEVTOOLESB-711
                            Display.getDefault().asyncExec(new Runnable() {
                                @Override
                                public void run() {
                                    EditorUtils.setLockmode(graphicalEditor, false);
                                }
                            });
                        }
                    });
                }
            } catch (Exception e) {
                setActivePage(SOURCE_VIEW_PAGE_INDEX);
                sourceEditor.getDocument().set(source);
            } finally {
                AbstractEsbNodeDeserializer.cleanupData();
                firePropertyChange(PROP_DIRTY);
                ESBDebuggerUtil.setPageChangeOperationActivated(false);
            }

            break;
        }
		case SOURCE_VIEW_PAGE_INDEX: {
			if (lastActivePage == SWAGGER_VIEW_PAGE_INDEX) {
				// Update the source view when the user switch from Swagger editor
				if (isSwaggerDirty()) {
					String currentSource = sourceEditor.getDocument().get();
					try {
						RestApiAdmin restAPIAdmin = new RestApiAdmin();
						OMElement element = AXIOMUtil.stringToOM(currentSource);
						API api = APIFactory.createAPI(element);
						String updatedAPI = restAPIAdmin.generateUpdatedAPIFromSwagger(getSource(), api);
						sourceEditor.getDocument().set(DefaultEsbModelExporter.format(updatedAPI));
					} catch (Exception e) {
						MessageDialog.openError(Display.getCurrent().getActiveShell(),
								"Could not update the source view from swagger editor", e.getMessage());
					}
				}
			} else {
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						try {
							if (isFormEditor) {
								if (currArtifactType != null) {
									sourceEditor.update(formEditor.getFormPageForArtifact(currArtifactType),
											currArtifactType);
									sourceDirty = false;
									firePropertyChange(PROP_DIRTY);
								}
							} else {
								deleteMarkers();
								updateSequenceDetails();
								handleSourceViewActivatedEvent();
								String source = sourceEditor.getDocument().get();
								SourceError tempError = ProcessSourceView.validateSynapseContent(source);
								if (tempError != null) {
									addMarker(tempError);
									sourceDirty = true;
								}
							}
						} catch (NumberFormatException nfe) {
							log.error("Cannot update source view", nfe);
							String simpleMessage = ExceptionMessageMapper.getNonTechnicalMessage(nfe.getMessage());
							handleSourceUpdateError(simpleMessage, nfe);
							setActivePage(DESIGN_VIEW_PAGE_INDEX);
						} catch (TransformerException te) {
							sourceDirty = true;
							log.error("Error while saving the diagram", te);
							String errorMsgHeader = "Save failed. Following error(s) have been detected."
									+ " Please see the error log for more details";
							handleSourceUpdateError(errorMsgHeader, te);
						} catch (DeserializerException de) {
							sourceDirty = true;
							log.error("Error while saving the diagram", de);
							String errorMsgHeader = "Save failed. Following error(s) have been detected."
									+ " Please see the error log for more details.";
							handleSourceUpdateError(errorMsgHeader, de);
						} catch (Exception e) {
							log.error("Cannot update source view", e);
							String simpleMessage = ExceptionMessageMapper.getNonTechnicalMessage(e.getMessage());
							handleSourceUpdateError(simpleMessage, e);
							setActivePage(DESIGN_VIEW_PAGE_INDEX);
						}
					}
				});
			}
			break;
		}
		case SWAGGER_VIEW_PAGE_INDEX: {
			if (lastActivePage == SOURCE_VIEW_PAGE_INDEX) {
				try {
					String currentSource = sourceEditor.getDocument().get();
					RestApiAdmin restAPIAdmin = new RestApiAdmin();
					OMElement element = AXIOMUtil.stringToOM(currentSource);
					API api = APIFactory.createAPI(element);
					String swaggerDefinition = restAPIAdmin.generateSwaggerFromSynapseAPI(api);
					setOldSwaggerSource(swaggerDefinition);
					setSwaggerSource(swaggerDefinition);
					swaggerlEditor.getBrowser().refresh();

				} catch (Exception e) {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error Details",
		                    "Error in loading associated XML : " + e.getMessage());
					setActivePage(lastActivePage);
				}
			}
			else {
				try {
					EsbDiagram diagram = (EsbDiagram) graphicalEditor.getDiagram().getElement();
					EsbServer server = diagram.getServer();
					String currentSource = EsbModelTransformer.instance.designToSource(server);
					RestApiAdmin restAPIAdmin = new RestApiAdmin();
					OMElement element = AXIOMUtil.stringToOM(currentSource);
					API api = APIFactory.createAPI(element);
					String swaggerDefinition = restAPIAdmin.generateSwaggerFromSynapseAPI(api);
					setSwaggerSource(swaggerDefinition);
					setOldSwaggerSource(swaggerDefinition);
					swaggerlEditor.getBrowser().refresh();
					updateSourceEditor();
				} catch (Exception e) {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error Details",
							"Error in loading associated XML : " + e.getMessage());
					setActivePage(lastActivePage);
				}

			}
		}
		}
		lastActivePage = getActivePage();
	}

    /**
     * Performs necessary house-keeping tasks whenever the design view is activated.
     * 
     * @throws Exception
     */
    private void handleDesignViewActivatedEvent(boolean withSynapse) throws Exception {

        if (sourceEditor != null) {
            String xmlSource = sourceEditor.getDocument().get();
            if (xmlSource != null && sourceDirty) {
                if (!xmlSource.trim().isEmpty()) {
                    rebuildModelObject(xmlSource, withSynapse);
                }
            }
        }

    }

    /**
     * Performs necessary house-keeping tasks whenever the form view is activated.
     * 
     * @throws Exception
     */
    private void handleFormViewActivatedEvent(boolean withSynapse) throws Exception {
        if (sourceEditor != null) {
            String xmlSource = sourceEditor.getDocument().get();
            if (xmlSource != null && sourceDirty) {// source dirty is coming as false
                if (!xmlSource.trim().isEmpty()) {
                	if (currArtifactType.toString().equals(MOCK_SERVICE)) {
                		MockServiceSourceToFormDeserializer.generateFormView((FormPage)formEditor.getActivePageInstance(), xmlSource, false);
                	} else if (currArtifactType.toString().equals(SYNAPSE_UNIT_TEST)) {
                		SynapseUnitTestSourceToFormDeserializer.generateFormView((FormPage)formEditor.getActivePageInstance(), xmlSource, false);
                	} else {
                		Deserializer.getInstance().updateDesign(xmlSource, formEditor, currArtifactType, withSynapse);
                	}
                    
                    final EsbMultiPageEditor tempEditor = this;
                    Display.getDefault().asyncExec(new Runnable() {
                        public void run() {
                            IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                            page.activate(tempEditor);

                        }
                    });
                }
            }
        }
    }

    /**
     * Error dialog is generated by this method when HandleDesignViewActivatedEvent
     * method throws an Exception.
     */
    private void printHandleDesignViewActivatedEventErrorMessage(Exception e) {
        sourceDirty = true;
        // if rebuild fails editor should be marked as dirty
        log.error("Error while generating diagram from source", e);
        String errorMsgHeader = "Error occurred while building design view."
                + " Any changes you made in the source view will be discarded."
                + " Please see the log for more details.";
        String simpleMessage = ExceptionMessageMapper.getNonTechnicalMessage(e.getMessage());
        IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, simpleMessage);
        ErrorDialog.openError(Display.getCurrent().getActiveShell(), "Error", errorMsgHeader, editorStatus);
    }

    private void printHandleDesignViewActivatedEventErrorMessageSimple(Exception e,
            DeserializeStatus deserializeStatus) {
        String topStackTrace = e.getStackTrace()[0].toString();
        String errorMsgHeader = fileName + " has some syntax errors";
        if (topStackTrace.contains("MediatorFactoryFinder.getMediator")) {
            errorMsgHeader = fileName + " has some syntax errors";
        }

        MessageDialog dialog = new MessageDialog(Display.getCurrent().getActiveShell(), "Error Dialog", null,
                errorMsgHeader, MessageDialog.ERROR, new String[] { "OK", "Show Details" }, 0);
        if (dialog.open() == 1) {
            String source = deserializeStatus.getsource();
            DocumentBuilderFactory domParserFactory = DocumentBuilderFactory.newInstance();
            domParserFactory.setValidating(true);
            DocumentBuilder builder;
            try {
                builder = domParserFactory.newDocumentBuilder();
                builder.parse(new InputSource(new StringReader(source)));

                final OMElement element = AXIOMUtil.stringToOM(source);
                try {
                    new ProgressMonitorDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell()).run(true, true,
                            new IRunnableWithProgress() {
                                public void run(IProgressMonitor monitor)
                                        throws InvocationTargetException, InterruptedException {
                                    monitor.beginTask("Generating Error Report", 100);
                                    monitor.worked(IProgressMonitor.UNKNOWN);
                                    validationMessage = Deserializer.getInstance().validate(element, element, true);
                                    monitor.done();

                                }
                            });
                } catch (InvocationTargetException | InterruptedException exception) {
                    log.error("Error while validating synapse syntax", exception);
                }
                MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Error Details",
                        validationMessage);

            } catch (IOException | ParserConfigurationException | XMLStreamException | SAXException exception) {
                MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Error Details",
                        "Errors in XML formatting: " + exception.getMessage());
            }
        }
    }

    /**
     * Performs necessary house-keeping tasks whenever the source view is activated.
     * 
     * @throws Exception
     */
    private void handleSourceViewActivatedEvent() throws Exception {
        updateSourceEditor();
    }

    private void updateSourceEditor() throws Exception {
        EsbDiagram diagram = (EsbDiagram) graphicalEditor.getDiagram().getElement();
        EsbServer server = diagram.getServer();

        sourceEditor.update(server);
        sourceDirty = false;
        firePropertyChange(PROP_DIRTY);
    }

    private IFile updateAssociatedXMLFile(IProgressMonitor monitor) throws Exception {

        IFile xmlFile = null;
        String source = null;
        if (isFormEditor) {
            FormPage formEditorPage = formEditor.getFormPageForArtifact(currArtifactType);
            if (currArtifactType.toString().equals(MOCK_SERVICE)) {
            	source = MockServiceFormToSourceTransformer.generateMockServiceTemplate(formEditorPage);
            } else if (currArtifactType.toString().equals(SYNAPSE_UNIT_TEST)) {
            	source = SynapseUnitTestFormToSourceTransformer.generateUnitTestTemplate(formEditorPage);
            } else {
            	source = EsbModelTransformer.instance.formToSource(formEditorPage, currArtifactType);
            }

        } else {
            EsbDiagram diagram = (EsbDiagram) graphicalEditor.getDiagram().getElement();
            EsbServer server = diagram.getServer();
            source = EsbModelTransformer.instance.designToSource(server);
        }
        xmlFile = ((EsbEditorInput) getEditor(0).getEditorInput()).getXmlResource();
        if (source == null) {
            log.warn("Could not get the source");
            return null;
        }
        InputStream is = new ByteArrayInputStream(source.getBytes());
        if (xmlFile.exists()) {
            xmlFile.setContents(is, true, true, monitor);
        } else {
            xmlFile.create(is, true, monitor);
        }

        artifactXMLFiles.add(xmlFile);
        xmlFile.deleteMarkers(SOURCE_VIEW_ERROR, false, 1);
        if (getActivePage() == SOURCE_VIEW_PAGE_INDEX && file.findMarkers(CONFIG_ERROR, false, 1).length > 0) {
            xmlFile.createMarker(SOURCE_VIEW_ERROR);
        }
        return xmlFile;
    }

    private void handleSourceUpdateError(String errorMsgHeader, Exception e) {
        MessageDialog dialog = new MessageDialog(Display.getCurrent().getActiveShell(), "Error", null,
                errorMsgHeader + "\n\n" + e.getMessage() + "\n\n"
                        + "Would you like to rollback to the last saved state ?",
                MessageDialog.ERROR, new String[] { "Yes", "No" }, 0);
        int result = dialog.open();
        if (result == 0) {
            sourceEditor.getDocument().set(getContentFromAssociatedXMLFile());
        } else {
            sourceEditor.getDocument().set("");
            setActivePage(DESIGN_VIEW_PAGE_INDEX);
        }
    }

    private String getContentFromAssociatedXMLFile() {
        IFile xmlFile = null;
        String source = null;
        xmlFile = ((EsbEditorInput) getEditor(0).getEditorInput()).getXmlResource();
        try (InputStream inputStream = xmlFile.getContents(); Scanner scanner = new Scanner(inputStream)) {
            source = scanner.useDelimiter("\\A").next();
        } catch (CoreException exception) {
            MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error Details",
                    "Error in loading associated XML : " + exception.getMessage());
        } catch (IOException e) {
            log.error("Error while reading xml file conetent for artifact", e);
        }

        return source;
    }

    /**
     * Saves the multi-page editor's document.
     */
    public void doSave(final IProgressMonitor monitor) {

        // Fixing DEVTOOLESB-596
        if (!isFormEditor) {
            try {
                ESBDebuggerUtil.updateModifiedDebugPoints(true);
                ESBDebuggerUtil.setPageSaveOperationActivated(true);
            } catch (Exception e) {
                log.error("An error has occurred while trying to modify the debug points", e);
            }
        }
        MediatorFactoryUtils.registerFactories();
        // Fixing TOOLS-2958
        setContextClassLoader();
        boolean isSaveAllow = true;
        if (getActivePage() == SOURCE_VIEW_PAGE_INDEX) {
            try {
                String xmlSource = sourceEditor.getDocument().get();
                final Deserializer deserializer = Deserializer.getInstance();
                DeserializeStatus deserializeStatus = deserializer.isValidSynapseConfig(xmlSource, true, true);

                deleteMarkers();
                if (deserializeStatus.isValid()) {
                    SourceError sourceError;
                    
                    if (currArtifactType.toString().equals(MOCK_SERVICE) || 
                    		currArtifactType.toString().equals(SYNAPSE_UNIT_TEST)) {
                    	sourceError = null;
                    } else {
                    	sourceError = ProcessSourceView.validateSynapseContent(xmlSource);
                    }
                    
                    if (sourceError != null) {
                        if (!sourceError.getException().contains("Invalid mediator")) {
                            addMarker(sourceError);
                        }

                    } else {
                        if (isFormEditor) {
                            sourceDirty = true;
                            handleFormViewActivatedEvent(true);
                        } else {
                            handleDesignViewActivatedEvent(true);
                        }
                    }
                } else {
                    if (!(deserializeStatus.getExecption() instanceof SynapseException
                            || deserializeStatus.getExecption() instanceof MediatorException
                            || deserializeStatus.getExecption() instanceof NullPointerException
                            || deserializeStatus.getExecption() instanceof SynapseTaskException
                            || deserializeStatus.getExecption() instanceof TransformerException
                            || deserializeStatus.getExecption() instanceof SynapseCommonsException)) {

                        addMarker(ProcessSourceView.validateXMLContent(xmlSource));
                        return;

                    } else if (deserializeStatus.getExecption() instanceof NullPointerException
                            || deserializeStatus.getExecption() instanceof TransformerException) {
                        addMarker(new SourceError(
                                "Invalid mediator configuration: " + deserializeStatus.getExecption().getMessage(), 0,
                                0, 2));
                        return;

                    } else {
                        SourceError sourceError = ProcessSourceView.validateSynapseContent(xmlSource);
                        if (sourceError == null) {
                            sourceError = new SourceError(deserializeStatus.getExecption().getMessage(), 0, 0, 2);
                        }

                        addMarker(sourceError);

                        if (isFormEditor) {
                            sourceDirty = true;
                            handleFormViewActivatedEvent(false);
                        } else {
                            handleDesignViewActivatedEvent(false);
                        }
                    }

                }
            } catch (ValidationException e) {
                isSaveAllow = false;
                IEditorInput editorInput = getEditorInput();
                IFile file = ((FileEditorInput) editorInput).getFile();
                printHandleDesignViewActivatedEventErrorMessage(e);

                if (MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), "Error in Configuration",
                        "There are errors in source configuration, Save anyway?")) {
                    saveForcefully(sourceEditor.getDocument().get(), file, monitor);
                    sourceDirty = false;
                    firePropertyChange(PROP_DIRTY);
                }

            } catch (Exception e) {
                isSaveAllow = false;
                printHandleDesignViewActivatedEventErrorMessage(e);

            } finally {
                AbstractEsbNodeDeserializer.cleanupData();
                firePropertyChange(PROP_DIRTY);

            }
        }

        if (isSaveAllow) {
            sourceDirty = false;
        }

        getEditor(0).doSave(monitor);
        // Since Complex endpoint type editors dose not have associated xml
        // file do not need to call this.
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                try {
                    IFile updateAssociatedXMLFile = updateAssociatedXMLFile(monitor);
                    IEventBroker iEventBroker = EsbEditorEvent.getiEventBroker();
                    if (iEventBroker != null) {

                        iEventBroker.send(EsbEditorEvent.EVENT_TOPIC_SAVE_EDITORS,
                                updateAssociatedXMLFile.getLocation().toOSString());
                    }
                    if (files.isEmpty()) {
                        InputStream inputStream = updateAssociatedXMLFile.getContents();

                        StringWriter writer = new StringWriter();

                        // Copy to string, use the file's encoding
                        IOUtils.copy(inputStream, writer, file.getCharset());

                        // Done with input
                        inputStream.close();

                        String theString = writer.toString();
                        SourceError sourceError;
                        
                        if (currArtifactType.toString().equals(MOCK_SERVICE) || 
                        		currArtifactType.toString().equals(SYNAPSE_UNIT_TEST)) {
                        	sourceError = null;
                        } else {
                        	sourceError = ProcessSourceView.validateSynapseContent(theString);
                        }

                        if (sourceError != null) {
                            addMarker(sourceError);
                        }

                    }
                } catch (NumberFormatException | TransformerException | DeserializerException nfe) {
                    sourceDirty = true;
                    log.error("Error while saving the diagram", nfe);
                    String errorMsgHeader = "Save failed. Following error(s) have been detected."
                            + " Please see the error log for more details.";
                    String simpleMessage = ExceptionMessageMapper.getNonTechnicalMessage(nfe.getMessage());
                    IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, simpleMessage);
                    ErrorDialog.openError(Display.getCurrent().getActiveShell(), "Error", errorMsgHeader, editorStatus);
                } catch (Exception e) {
                    sourceDirty = true;
                    log.error("Error while saving the diagram", e);
                    String errorMsgHeader = "Save failed. Following error(s) have been detected."
                            + " Please see the error log for more details.";
                    String simpleMessage = ExceptionMessageMapper.getNonTechnicalMessage(e.getMessage());
                    IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, simpleMessage);
                    if (simpleMessage != null && !simpleMessage
                            .equals("Invalid DataMapper mediator. Configuration registry key is required")) {
                        ErrorDialog.openError(Display.getCurrent().getActiveShell(), "Error", errorMsgHeader,
                                editorStatus);
                    }
                }
                if (!isFormEditor) {
                    EditorUtils.setLockmode(graphicalEditor, true);

                    getEditor(0).doSave(monitor);
                    ESBDebuggerUtil.setPageSaveOperationActivated(false);
                    EditorUtils.setLockmode(graphicalEditor, false);
                }
            }
        });
    }

    private void deleteMarkers() {
        // remove markers from temporary xml files
        try {
            for (IFile iFile : files) {
                iFile.deleteMarkers(CONFIG_ERROR, false, 1);
            }
        } catch (Exception e) {
            // ignore
        }
        files.clear();

        // remove markers from artifact xml iFiles
        try {
            for (IFile iFile : artifactXMLFiles) {
                iFile.deleteMarkers(SOURCE_VIEW_ERROR, false, 1);
            }
        } catch (CoreException e) {
            // ignore
        }
        artifactXMLFiles.clear();
    }

    private void addMarker(SourceError sourceError) {
        try {
            if (sourceError != null) {
                files.add(file);
                IMarker marker = file.createMarker(CONFIG_ERROR);

                marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
                marker.setAttribute(IMarker.MESSAGE, sourceError.getException());
                MarkerUtilities.setLineNumber(marker, sourceError.getLineNumber());
                marker.setAttribute(IMarker.CHAR_START, sourceError.getStartChar());

                if (sourceError.getStartChar() != sourceError.getEndChar()) {
                    marker.setAttribute(IMarker.CHAR_END, sourceError.getEndChar());
                } else {
                    marker.setAttribute(IMarker.CHAR_END, sourceError.getEndChar() + 1);
                }
            }

        } catch (Exception e) {
            // ignore
        }
    }

    public boolean isDirty() {
        if (getEditor(0) instanceof EsbDiagramEditor) {
            return getEditor(0).isDirty() || sourceDirty;
        } else if (getEditor(0) instanceof ESBFormEditor) {
            return getEditor(0).isDirty() || sourceDirty;
        }
        return super.isDirty();
    }

    /**
     * Saves the multi-page editor's document as another file. Also updates the text
     * for page 0's tab, and updates this multi-page editor's input to correspond to
     * the nested editor's.
     */
    public void doSaveAs() {
        if (getActivePage() == SOURCE_VIEW_PAGE_INDEX) {
            try {
                handleDesignViewActivatedEvent(true);
            } catch (Exception e) {
                printHandleDesignViewActivatedEventErrorMessage(e);
            } finally {
                AbstractEsbNodeDeserializer.cleanupData();
                firePropertyChange(PROP_DIRTY);
            }
        }
        sourceDirty = false;
        IEditorPart editor = getEditor(0);
        editor.doSaveAs();
        setPageText(0, editor.getTitle());
        setInput(editor.getEditorInput());
    }

    /**
     * The <code>MultiPageEditorExample</code> implementation of this method checks
     * that the input is an instance of <code>IFileEditorInput</code>.
     */
    public void init(IEditorSite site, IEditorInput editorInput) throws PartInitException {

        if (!(editorInput instanceof IFileEditorInput || editorInput instanceof IEsbEditorInput))
            throw new PartInitException("InvalidInput"); //$NON-NLS-1$

        super.init(site, editorInput);
        String name = editorInput.getName();
        setTitle(name);
    }

    /*
     * (non-Javadoc) Method declared on IEditorPart.
     */
    public boolean isSaveAsAllowed() {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.ide.IGotoMarker
     */
    public void gotoMarker(IMarker marker) {
        setActivePage(DESIGN_VIEW_PAGE_INDEX);
        IDE.gotoMarker(graphicalEditor, marker);
    }

    private void updateSequenceDetails() throws Exception {

        IProject activeProject = null;
        IEditorReference editorReferences[] = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                .getEditorReferences();
        for (int i = 0; i < editorReferences.length; i++) {
            IEditorPart editor = editorReferences[i].getEditor(false);

            IEditorPart editorPart = null;
            if (editor != null) {
                editorPart = editor.getSite().getWorkbenchWindow().getActivePage().getActiveEditor();
            }

            if (editorPart != null) {
                IFile file = null;
                if (editorPart.getEditorInput() instanceof EsbEditorInput) {
                    EsbEditorInput input = (EsbEditorInput) editorPart.getEditorInput();
                    file = input.getXmlResource();
                } else if (editorPart.getEditorInput() instanceof FileEditorInput) {
                    FileEditorInput input = (FileEditorInput) editorPart.getEditorInput();
                    file = input.getFile();
                }
                activeProject = file.getProject();
            }

        }

        List<Sequence> childNodes = new ArrayList<Sequence>();

        for (int i = 0; i < graphicalEditor.getDiagramEditPart().getViewer().getEditPartRegistry().size(); ++i) {

            EditPart element = (EditPart) graphicalEditor.getDiagramEditPart().getViewer().getEditPartRegistry()
                    .values().toArray()[i];
            if (element instanceof SequenceEditPart) {
                if (((NodeImpl) ((SequenceEditPart) element).getModel()).getElement() instanceof Sequence) {
                    childNodes.add((Sequence) ((NodeImpl) ((SequenceEditPart) element).getModel()).getElement());
                }
            }
        }

        for (Sequence childNode : childNodes) {
            String name = childNode.getName();
            IPath location = new Path(SEQUENCE_RESOURCE_DIR + "/" + "sequence_" + name + ".esb_diagram");
            IFile file = activeProject.getFile(location);

            ResourceSet resourceSet = new ResourceSetImpl();
            Resource resource = null;

            File f = new File(file.getLocationURI().getPath());
            URI uri = URI.createFileURI(f.getAbsolutePath());

            if (f.exists()) {

                resource = resourceSet.getResource(uri, true);

                EsbDiagram s = (EsbDiagram) ((org.eclipse.gmf.runtime.notation.impl.DiagramImpl) resource.getContents()
                        .get(0)).getElement();
                EList<EsbElement> children = s.getServer().getChildren();
                for (EsbElement esbElement : children) {
                    if (esbElement instanceof Sequences) {
                        Sequences sequence = (Sequences) esbElement;
                        EsbLink incomingLink = sequence.getOutputConnector().getOutgoingLink();
                        SequenceInfo.sequenceMap.put(name, incomingLink);
                    }
                }
            }
        }
    }

    /**
     * @throws Exception
     */

    void rebuildModelObject(final String xml, boolean withSynapse) throws Exception {

        Deserializer.getInstance().updateDesign(xml, graphicalEditor, withSynapse);

        final EsbMultiPageEditor tempEditor = this;
        Display.getDefault().asyncExec(new Runnable() {
            public void run() {
                IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                page.activate(tempEditor);

            }
        });
    }

    // There is a class loading issue in Mac OS with Java 7u55 and later
    // updates.
    // Root cause for this issue is returning null value for
    // Thread.currentThread().getContextClassLoader().
    // This method will set the ContextClassLoader for current thread if
    // ContextClassLoader has not been set. See
    // https://wso2.org/jira/browse/TOOLS-2958 for more details.
    private void setContextClassLoader() {
        Thread thread = Thread.currentThread();
        ClassLoader ctxClassLoader = thread.getContextClassLoader();
        if (ctxClassLoader == null) {
            thread.setContextClassLoader(LogMediator.class.getClassLoader());
        }
    }

    public IDiagramGraphicalViewer getDiagramGraphicalViewer() {
        if (graphicalEditor != null) {
            return graphicalEditor.getDiagramGraphicalViewer();
        } else {
            return null;
        }
    }

    public IDiagramEditDomain getDiagramEditDomain() {
        if (graphicalEditor != null) {
            return graphicalEditor.getDiagramEditDomain();
        } else {
            return null;
        }
    }

    public Diagram getDiagram() {
        if (graphicalEditor != null) {
            return graphicalEditor.getDiagram();
        } else {
            return null;
        }
    }

    public DiagramEditPart getDiagramEditPart() {
        if (graphicalEditor != null) {
            return graphicalEditor.getDiagramEditPart();
        } else {
            return null;
        }

    }

    public EsbDiagramEditor getGraphicalEditor() {
        if (graphicalEditor != null) {
            return graphicalEditor;
        } else {
            return null;
        }
    }

    public void focusToolbar() {
        if (graphicalEditor != null) {
            graphicalEditor.focusToolBar();
        }
    }

    public double getZoom() {
        return zoom;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
    }

    // 20150929
    private void saveForcefully(String source, IFile xmlFile, IProgressMonitor monitor) {
        try (InputStream is = new ByteArrayInputStream(source.getBytes())) {
            if (xmlFile.exists()) {
                xmlFile.setContents(is, true, true, monitor);
            } else {
                xmlFile.create(is, true, monitor);
            }
        } catch (CoreException | IOException e) {
            log.error("Error occurred while saving " + e.getMessage());
        }
    }

    @Override
    public void setFocus() {
        super.setFocus();
        String currentPerspective = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getPerspective().getLabel();
        try {
            if(!"debug".equalsIgnoreCase(currentPerspective))
            PlatformUI.getWorkbench().showPerspective(ESB_GRAPHICAL_PERSPECTIVE_ID,
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow());
            ProjectPresentation.setHierarchicalProjectPresentation();
        } catch (WorkbenchException e) {
            log.error("Error occurred while switching to ESB perspective " + e.getMessage());
        }
        
        // If CONNECTOR_ADDED_KEY is set to true, update all editors.
        IEclipsePreferences rootNode = Platform.getPreferencesService().getRootNode();
        if (rootNode.get(CONNECTOR_ADDED_KEY, String.valueOf(false)).equals(String.valueOf(true))) {
        	IUpdateGMFPlugin updateGMFPlugin = GMFPluginDetails.getiUpdateGMFPlugin();
        	if (updateGMFPlugin != null) {
        		updateGMFPlugin.updateOpenedEditors();
        	}
        	rootNode.put(CONNECTOR_ADDED_KEY, String.valueOf(false));
        }
    }

	public String getSource() {
		return swaggerSource;
	}

	public void setSwaggerSource(String source) {
		swaggerSource = source;
	}

	/**
	 * Set the existing swagger definition before switching to swagger view.
	 * 
	 * @param source
	 */
	public void setOldSwaggerSource(String source) {
		oldSwaggerSource = source;
	}

	/**
	 * Check if the swagger definition has been changed.
	 * 
	 * @return state
	 */
	public boolean isSwaggerDirty() {
		if (swaggerSource != null && oldSwaggerSource != null) {
			return !oldSwaggerSource.equals(swaggerSource);
		}
		return false;
	}

	/*
	 * This method will get the swagger resource path from the given api and return
	 * the swagger file as a string
	 * 
	 * @param api Synapse API
	 * 
	 * @return Swagger File content as a String
	 */
	public static String getSwaggerJsonFromRegistry(API api) {
		String swaggerJsonFile = null;

		try {
			String swaggerRegistryPath = api.getSwaggerResourcePath();
			IDeveloperStudioProviderData[] providerProjectsList = RegistryResourcesUtils
					.loadProviderProjectsList(new Class[] { IRegistryFile.class });
			Map<String, List<String>> filters = new HashMap<String, List<String>>();
			String mediaTypeKey = CSProviderConstants.FILTER_MEDIA_TYPE;
			List<String> types = new ArrayList<String>();
			types.add("application/yaml");
			types.add("application/json");
			filters.put(mediaTypeKey, types);

			String swaggerName = swaggerRegistryPath.substring(swaggerRegistryPath.lastIndexOf("/") + 1,
					swaggerRegistryPath.length());

			String pathForSwagger = DataMapperMediatorEditPart.getConfigurationLocalPath(providerProjectsList, filters,
					swaggerName);

			// Copy to string, use the file's encoding
			Path path = new Path(pathForSwagger);
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			InputStream inputStream = file.getContents();
			StringWriter writer = new StringWriter();

			IOUtils.copy(inputStream, writer, file.getCharset());
			inputStream.close();
			swaggerJsonFile = writer.toString();

		} catch (IOException e) {
			log.error("IO Exceprion occured while trying to retrieve swagger file", e);
		} catch (CoreException e) {
			log.error("Eclipse Core exception occured while trying to retrieve swagger file", e);
		} catch (Exception e) {
			log.error("Error occured while trying to retrieve swagger file", e);
		}

		return swaggerJsonFile;
	}

}

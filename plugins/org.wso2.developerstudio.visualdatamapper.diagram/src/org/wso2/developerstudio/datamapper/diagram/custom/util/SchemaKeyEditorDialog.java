/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.datamapper.diagram.custom.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.custom.action.Messages;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutputEditPart;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperDiagramEditor;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperSchemaEditorUtil;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.CAppEnvironment;
import org.wso2.developerstudio.eclipse.capp.core.model.RegistryConnection;
import org.wso2.developerstudio.eclipse.general.project.dialogs.NewResourceTemplateDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.cloudconnector.CloudConnectorDirectoryTraverser;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.DeveloperStudioElementProviderDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.EmbeddedEntriesDialog;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryConnection;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryData;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryFile;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryHandler;
import org.wso2.developerstudio.datamapper.diagram.schemagen.util.*;
import org.wso2.developerstudio.datamapper.servlets.DataMapperConfigHolder;

public class SchemaKeyEditorDialog extends Dialog {

    private static final String NO_SUCH_RESOURCE_EXISTS =
            Messages.SchemaKeyEditorFialog_NoSuchResource;
    private static final String RESGISTRY_RESOURCE_RETRIVING_ERROR =
            Messages.SchemaKeyEditorDialog_ErrorRetreivingResource;
    private static final String FILE_DIALOG_TITLE = "Select File";
    private IWorkbenchPart workBenchPart;
    private Text schemaKeyTextField;
    private Label lblSchemaTypeLabel;
    private Label lblDelimiterLabel;
    private Text delimiterTextField;
    private Combo schemaTypeCombo;
    private EditPart selectedEP;
    private IFile inputFile;
    private String schemaType;
    private Label lblConnector;
    private Combo cmbConnector;
    private Label lblConnectorOperation;
    private Combo cmbConnectorOperation;
    private Link link;
    private Group grpPropertyKey;
    private Button generateSchema;
    private String dynamicSchemaObject;
    private File file;
    private SchemaGeneratorHelper schemaGeneratorHelper;
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static final String FILE_NAME_VALUE = "tempSchemaContnt";
    private static final String DEFAULT_REGISTRY_URL = "https://localhost:9443/registry"; //$NON-NLS-1$
    private static final String REGISTRY_BROWSER = Messages.SchemaKeyEditorDialog_RegistryBrowser;
    private static final String SELECT_REGISTRY_RESOURCE =
            Messages.SchemaKeyEditorDialog_SelectRegistryResource;
    private static final String TEMP_REG_RESOURCE_LOC = "tempRegRrsourceGenLocation";
    private static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
    private static final String tempOutput = System.getProperty(JAVA_IO_TMPDIR) + File.separator +
            TEMP_REG_RESOURCE_LOC;
    private static final String NEW_RESOURCE = Messages.SchemaKeyEditorDialog_NewResource;
    private static final String WORKSPACE_ELEMENT_PROVIDERS =
            Messages.SchemaKeyEditorDialog_WorkspaceElementProviders;
    private static final String EMBEDDED_RESOURCES =
            Messages.SchemaKeyEditorDialog_EmbeddedResources;
    private static final String G_REG_PATH_PREFIX = "/_system/governance/"; //$NON-NLS-1$
    private static final String C_REG_PATH_PREFIX = "/_system/config/"; //$NON-NLS-1$
    private static final String C_REG_PREFIX = "conf:%s"; //$NON-NLS-1$
    private static final String G_REG_PREFIX = "gov:%s"; //$NON-NLS-1$

    private static final String LOCAL_ENTRIES = "local entries"; //$NON-NLS-1$
    private static final String WORKSPACE = "workspace"; //$NON-NLS-1$
    private static final String REGISTRY = "registry"; //$NON-NLS-1$
    private static final String FILE_SYSTEM = "file system"; //$NON-NLS-1$
    
    private static final String DELIMITER = "delimiter";
    private static final String DEFAULT_DELIMITER = ",";

    private static final String ERROR_MSG_HEADER = Messages.SchemaKeyEditorDialog_ErrorMsgHeader;
    private static final String SCHEMA_KEY_EDITOR_DIALOG_TEXT =
            Messages.SchemaKeyEditorDialog_SchemaKeyEditorDialogMessage +
                    FILE_SYSTEM + "</a> or <a>" + //$NON-NLS-1$
                    REGISTRY + "</a> or <a>" + //$NON-NLS-1$
                    WORKSPACE + "</a>";

    private static final String ERROR_OPENING_FILE =
            Messages.SchemaKeyEditorDialog_ErrorOpeningFile;
    private static final String WARN_CONNECTOR_OPERATIONS =
            Messages.SchemaKeyEditorDialog_WarnConnectorOperation;
    private static final String REASON_OPENING_FILE =
            Messages.SchemaKeyEditorDialog_ReasonOpeningFile;
    private static final String ERROR_REGISTRY_BROWSER =
            Messages.SchemaKeyEditorDialog_ErrorRegistryBrowser;
    private static final String REASON_REGISTRY_BROWSER =
            Messages.SchemaKeyEditorDialog_ReasonRegistryBrowser;
    private static final String ERROR_REGISTRY_URL =
            Messages.SchemaKeyEditorDialog_ErrorRegistryURL;
    private static final String REASON_REGISTRY_URL =
            Messages.SchemaKeyEditorDialog_ReasonRegistryURL;
    private static final String SELECT_SCHEMA_SOURCE =
            Messages.SchemaKeyEditorDialog_SelecSchemaSource;
    private static final String ENTER_DELIMITER = 
    		Messages.SchemaKeyEditorDialog_EnterDelimiter;
    private static final String ERROR_DIALOG_VISIBILITY =
            Messages.SchemaKeyEditorFialog_VisibilityError; // $NON-NLS-1$
    private static final String SELECT_CONNECTOR = Messages.SchemaKeyEditorDialog_SelectConnector;
    private static final String SELECT_CONNECTOR_OPERATION =
            Messages.SchemaKeyEditorDialog_SelectConnectorOperation;
    private static final String REASON_FILE_TYPE_MISMATCH =
            Messages.SchemaKeyEditorDialog_ReasonRegistryBrowser_IncompatibleFileTypes;
    private static final String ERROR_WORKSPACE_IMPORT =
            Messages.SchemaKeyEditorDialog_ErrorWorkspaceImport;
    private static final String SELECT_GENERATE_SCHEMA =
            Messages.SchemaKeyEditorDialog_GenerateSchema;
    private static final String SELECT_GENERATE_DYNAMIC_SCHEMA =
            Messages.SchemaKeyEditorDialog_GenerateDynamicSchema;
    private static final String SCHEMA_TYPE_INPUT = Messages.LoadInputSchemaAction_SchemaTypeInput;
    private static final String SCHEMA_TYPE_OUTPUT = Messages.LoadOutputSchemaAction_SchemaTypeOutput;

    private static String rootWorkspaceLocation = ResourcesPlugin.getWorkspace().getRoot()
            .getLocation().toOSString() +
            File.separator + "temp";

    private String schemaFileLocation;
    private String inputFileLocation;
    
    public SchemaKeyEditorDialog(Shell parent, EditPart selectedEP, IWorkbenchPart workbenchPart,
                                 String schemaType) {
        super(parent);
        this.selectedEP = selectedEP;
        this.schemaType = schemaType;
        this.workBenchPart = workbenchPart;
        schemaGeneratorHelper = new SchemaGeneratorHelper();
        IEditorPart editorPart = workbenchPart.getSite().getWorkbenchWindow().getActivePage()
                .getActiveEditor();
        if (editorPart != null) {
            IFileEditorInput input = (IFileEditorInput) editorPart.getEditorInput();
            inputFile = input.getFile();
        }
    }

    private void hide() {
        changeVisibility(false);
    }

    private void show() {
        changeVisibility(true);
    }

    private void changeVisibility(boolean visible) {
        try {
            if (this.getShell() != null) {
                this.getShell().setVisible(visible);
            }
        } catch (Exception e) {
            log.error(ERROR_DIALOG_VISIBILITY, e);
        }
    }

    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        FillLayout fl_container = new FillLayout(SWT.HORIZONTAL);
        fl_container.marginHeight = 5;
        fl_container.marginWidth = 5;
        fl_container.spacing = 10;
        container.setLayout(fl_container);

        grpPropertyKey = new Group(container, SWT.None);

        FormLayout fl_grpPropertyKey = new FormLayout();
        fl_grpPropertyKey.marginHeight = 10;
        fl_grpPropertyKey.marginWidth = 10;
        grpPropertyKey.setLayout(fl_grpPropertyKey);

        GridData gridDataCombo = new GridData();
        gridDataCombo.grabExcessHorizontalSpace = true;
        gridDataCombo.horizontalAlignment = GridData.FILL;

        // initialize components
        lblSchemaTypeLabel = new Label(grpPropertyKey, SWT.NORMAL);
        schemaTypeCombo = new Combo(grpPropertyKey, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.BORDER);
        
        lblDelimiterLabel = new Label(grpPropertyKey,SWT.NORMAL);
        delimiterTextField = new Text(grpPropertyKey,SWT.BORDER);
        
        lblConnector = new Label(grpPropertyKey, SWT.NORMAL);
        lblConnectorOperation = new Label(grpPropertyKey, SWT.NORMAL);
        cmbConnector = new Combo(grpPropertyKey, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.BORDER);
        cmbConnectorOperation =
                new Combo(grpPropertyKey, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.BORDER);
        link = new Link(grpPropertyKey, SWT.NONE);
        schemaKeyTextField = new Text(grpPropertyKey, SWT.BORDER);
        generateSchema = new Button(grpPropertyKey, SWT.PUSH);

        schemaTypeCombo.setLayoutData(gridDataCombo);
        cmbConnector.setLayoutData(gridDataCombo);
        cmbConnectorOperation.setLayoutData(gridDataCombo);

        FormData lableLayoutData = new FormData();

        lblSchemaTypeLabel.setText(SELECT_SCHEMA_SOURCE);
        lblSchemaTypeLabel.setLayoutData(lableLayoutData);

        FormData comboLayoutData = new FormData();
        comboLayoutData.left = new FormAttachment(lblSchemaTypeLabel, 10, SWT.RIGHT);
        schemaTypeCombo.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                if (FileType.CONNECTOR.toString().equals(schemaTypeCombo.getText())) {
                    lblConnector.setVisible(true);
                    lblConnectorOperation.setVisible(true);
                    cmbConnector.setVisible(true);
                    cmbConnectorOperation.setVisible(true);
                    generateSchema.setVisible(false);
                    link.setVisible(false);
                    schemaKeyTextField.setVisible(false);
                    lblDelimiterLabel.setVisible(false);
                    delimiterTextField.setVisible(false);
                    grpPropertyKey.redraw();
                } else if (FileType.CSV.toString().equals(schemaTypeCombo.getText())) {
                    lblConnector.setVisible(false);
                    lblConnectorOperation.setVisible(false);
                    cmbConnector.setVisible(false);
                    cmbConnectorOperation.setVisible(false);
                    generateSchema.setVisible(false);
                    link.setVisible(true);
                    schemaKeyTextField.setVisible(true);
                    lblDelimiterLabel.setVisible(true);
                    delimiterTextField.setVisible(true);
                    grpPropertyKey.redraw();
                } else {
                    lblConnector.setVisible(false);
                    lblConnectorOperation.setVisible(false);
                    cmbConnector.setVisible(false);
                    cmbConnectorOperation.setVisible(false);
                    generateSchema.setVisible(false);
                    link.setVisible(true);
                    schemaKeyTextField.setVisible(true);
                    lblDelimiterLabel.setVisible(false);
                    delimiterTextField.setVisible(false);
                    grpPropertyKey.redraw();
                }
            }
        });
        int optionsLenght = FileType.values().length;
        String[] options = new String[optionsLenght];
        for (int i = 0; i < optionsLenght; i++) {
            options[i] = FileType.values()[i].name();
        }
        schemaTypeCombo.setItems(options);
        schemaTypeCombo.select(0);
        schemaTypeCombo.setLayoutData(comboLayoutData);
        
        FormData delimiterLabelLayout = new FormData();
        delimiterLabelLayout.left = new FormAttachment(schemaTypeCombo, 10, SWT.RIGHT);
        lblDelimiterLabel.setText(ENTER_DELIMITER);
        lblDelimiterLabel.setLayoutData(delimiterLabelLayout);
        
        FormData delimiterTextFieldLayout = new FormData();
        delimiterTextFieldLayout.left = new FormAttachment(lblDelimiterLabel, 10, SWT.RIGHT);
        delimiterTextField.setLayoutData(delimiterTextFieldLayout);
        delimiterTextField.setText(DEFAULT_DELIMITER);
        
        FormData connectorLabelLayoutData = new FormData();
        connectorLabelLayoutData.top = new FormAttachment(lblSchemaTypeLabel, 20, SWT.BOTTOM);

        lblConnector.setText(SELECT_CONNECTOR);
        lblConnector.setLayoutData(connectorLabelLayoutData);

        FormData connectorComboLayoutData = new FormData();
        connectorComboLayoutData.left = new FormAttachment(lblConnector, 10, SWT.RIGHT);
        connectorComboLayoutData.top = new FormAttachment(schemaTypeCombo, 10, SWT.BOTTOM);

        cmbConnector.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                String[] connector_operations = getConnectorOperations(cmbConnector.getText());
                cmbConnectorOperation.setItems(connector_operations);
                cmbConnectorOperation.select(0);
            }
        });

        String[] connectors = getConnectors();

        cmbConnector.setItems(connectors);
        cmbConnector.select(0);
        cmbConnector.setLayoutData(connectorComboLayoutData);

        FormData connectorOperationLabelLayoutData = new FormData();
        connectorOperationLabelLayoutData.top = new FormAttachment(lblConnector, 20, SWT.BOTTOM);
        lblConnectorOperation.setText(SELECT_CONNECTOR_OPERATION);
        lblConnectorOperation.setLayoutData(connectorOperationLabelLayoutData);

        FormData connectorOperationComboLayoutData = new FormData();
        connectorOperationComboLayoutData.left = new FormAttachment(lblConnectorOperation, 10,
                SWT.RIGHT);
        connectorOperationComboLayoutData.top = new FormAttachment(cmbConnector, 10, SWT.BOTTOM);

        cmbConnectorOperation.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                if (FileType.CONNECTOR.toString().equals(schemaTypeCombo.getText()) && getConnectorOperationIsDynamic(cmbConnectorOperation.getText()).equals("true") &&
                        (!getConnectorOperationLoadClasses(cmbConnectorOperation.getText()).equals(""))) {
                    generateSchema.setVisible(true);
                    grpPropertyKey.redraw();
                } else {
                    generateSchema.setVisible(false);
                    grpPropertyKey.redraw();
                }
            }
        });

        String[] operations = getConnectorOperations(cmbConnector.getText());

        cmbConnectorOperation.setItems(operations);
        cmbConnectorOperation.select(0);
        cmbConnectorOperation.setLayoutData(connectorOperationComboLayoutData);

        FormData fd_link = new FormData();
        fd_link.top = new FormAttachment(lblSchemaTypeLabel, 20);
        link.setLayoutData(fd_link);
        link.setText(SCHEMA_KEY_EDITOR_DIALOG_TEXT);

        link.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                String selectedCommand = e.text;
                if (FILE_SYSTEM.equals(selectedCommand)) {
                    openFileBrowser();
                } else if (REGISTRY.equals(selectedCommand)) {
                    openRegistryBrowser();
                } else if (WORKSPACE.equals(selectedCommand)) {
                    openRegistryResourceProviderDialog();
                }
            }
        });

        // Selected schema key to be appeared here OR typed
        schemaKeyTextField.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                saveConfiguration();
            }
        });
        {
            FormData schemaKeyTextFieldLayoutData = new FormData();
            schemaKeyTextFieldLayoutData.top = new FormAttachment(link, 20);
            schemaKeyTextFieldLayoutData.left = new FormAttachment(0, 5);
            schemaKeyTextFieldLayoutData.right = new FormAttachment(100, -5);
            schemaKeyTextField.setLayoutData(schemaKeyTextFieldLayoutData);
        }

        FormData createSchemaButtonLayoutData = new FormData();
        createSchemaButtonLayoutData.top = new FormAttachment(cmbConnectorOperation, 0, SWT.TOP);
        createSchemaButtonLayoutData.left =
                new FormAttachment(cmbConnectorOperation, 10, SWT.RIGHT);
        generateSchema.setLayoutData(createSchemaButtonLayoutData);
        generateSchema.setText(SELECT_GENERATE_SCHEMA);

        generateSchema.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                openGenerateSchemaDialog();
            }
        });

        loadConfiguration();
        return container;
    }

    /**
     * Create new GenerateSchemaDialog dialog
     *
     * @throws Exception
     * @throws IOException
     */
    protected void openGenerateSchemaDialog() {
        hide();
        FileOutputStream fileOutput = null;
        try {
            Class<?> loadClass =
                    Class.forName(getConnectorOperationLoadClasses(cmbConnectorOperation.getText()));
            Constructor<?> cons = loadClass.getConstructor(Shell.class);
            Object object = cons.newInstance(getParentShell());
            Method method = object.getClass().getMethod("getResponse", new Class<?>[0]);
            ((Dialog) object).create();
            ((Window) object).getShell().setText(SELECT_GENERATE_DYNAMIC_SCHEMA);
            ((Window) object).open();

            if (((Window) object).getReturnCode() == Window.OK) {
                dynamicSchemaObject = (String) method.invoke(object);
                file = new File(rootWorkspaceLocation);
                fileOutput = new FileOutputStream(file);

                if (!file.exists()) {
                    file.createNewFile();
                    file.getAbsolutePath();
                }
                byte[] contentInBytes = dynamicSchemaObject.getBytes();
                fileOutput.write(contentInBytes);
                fileOutput.flush();
            }
        } catch (IOException e) {
            log.error("Error occurred while reading selected response file", e);
        } catch (ClassNotFoundException e) {
            MessageDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
                    "ClassNotFoundException",
                    "Miss the feature installation of Dynamic Schema Creation for the Operation. \n" +
                            "Install the feature and add the plugin via MANIFEST.MF -> dependency tab -> Add -> plugin for dynamic schema generation for connector");
        } catch (NoSuchMethodException e) {
            MessageDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
                    "NoSuchMethodException",
                    "Miss the operation to getting the response to create the dynamic operation");
        } catch (SecurityException e) {
            MessageDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
                    "SecurityException", "Error thrown by the Security Manager.");
        } catch (IllegalAccessException e) {
            MessageDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
                    "IllegalAccessException", "Error while creating an Instance.");
        } catch (IllegalArgumentException e) {
            MessageDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
                    "IllegalArgumentException",
                    "Error in the calling of invoke() method in the generic part of Dynamic Schema Creation.");
        } catch (InvocationTargetException e) {
            MessageDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
                    "InvocationTargetException",
                    "Error in the invoked method to generate the dynamic Schema.");
        } catch (InstantiationException e) {
            MessageDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
                    "InstantiationException",
                    "Error in the constructor in Dynamic Schema Creation Class for the Operation.");
        } finally {
            try {
                if (fileOutput != null) {
                    fileOutput.close();
                }
            } catch (IOException e) {
                log.error("Error occurred while closing OutputStream: ", e);
            }
            show();
        }
    }

    private String[] getConnectorOperations(String connectorName) {
        if (StringUtils.isEmpty(connectorName)) {
            return new String[]{};
        }

        IWorkspace workspace = ResourcesPlugin.getWorkspace();

        String connectorPath = workspace.getRoot().getLocation().toOSString() + File.separator +
                CloudConnectorDirectoryTraverser.connectorPathFromWorkspace +
                File.separator + connectorName;
        Set<String> cloudConnectorOperations;
        try {
            cloudConnectorOperations = CloudConnectorDirectoryTraverser.getInstance(connectorPath)
                    .getOperationsMap().keySet();
            return cloudConnectorOperations.toArray(new String[cloudConnectorOperations.size()]);
        } catch (Exception e) {
            log.warn(WARN_CONNECTOR_OPERATIONS, e);
            return new String[]{};
        }

    }

    private String[] getConnectors() {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();

        if (CloudConnectorDirectoryTraverser.getInstance().validate(workspace)) {
            String connectorDirectory = workspace.getRoot().getLocation().toOSString() +
                    File.separator +
                    CloudConnectorDirectoryTraverser.connectorPathFromWorkspace;
            File directory = new File(connectorDirectory);
            List<String> connectorsList = null;
            if (directory.isDirectory()) {
                File[] children = directory.listFiles();
                connectorsList = new ArrayList<String>();
                for (int i = 0; i < children.length; ++i) {
                    if (children[i].isDirectory()) {
                        connectorsList.add(children[i].getName());
                    }
                }
            }

            return connectorsList.toArray(new String[connectorsList.size()]);
        }
        return new String[]{};
    }

    private String getConnectorOperationLoadClasses(String connectorOperation) {
        String className = null;
        try {
            if (Messages.LoadInputSchemaAction_SchemaTypeInput.equals(schemaType)) {
                className =
                        CloudConnectorDirectoryTraverser.getInstance()
                                .getCloudConnectorOperationInputLoadClass(connectorOperation);
            } else if (Messages.LoadOutputSchemaAction_SchemaTypeOutput.equals(schemaType)) {
                className =
                        CloudConnectorDirectoryTraverser.getInstance()
                                .getCloudConnectorOperationOutputLoadClass(connectorOperation);
            }
        } catch (Exception e) {
            log.warn("Error loading connector operations Load Class", e);
        }
        return className;
    }

    private String getConnectorOperationIsDynamic(String connectorOperation) {
        String isDynamic = null;
        try {
            isDynamic =
                    CloudConnectorDirectoryTraverser.getInstance()
                            .getCloudConnectorOperationIsDynamic(connectorOperation);
        } catch (Exception e) {
            log.warn("Error loading connector operations type", e);
        }
        return isDynamic;
    }

    /**
     * Retrieve from model and set to text field
     */
    private void loadConfiguration() {
        // TODO Get schema key value from model and set to text field
        /*
		 * if (!StringUtils.isBlank(schemaKey.getKeyValue())) {
		 * schemaKeyTextField.setText(schemaKey.getKeyValue()); }
		 */
    }

    @Override
    protected void okPressed() {
        if (FileType.CONNECTOR.toString().equals(schemaTypeCombo.getText())) {
            String connectorOperation = cmbConnectorOperation.getText();
            if (!StringUtils.isEmpty(connectorOperation)) {
                loadSchemaFromConnectorOperation(connectorOperation);
            }
        }
        saveConfiguration();
        updateEditorInputTypes(); //update payload types
        super.okPressed();
    }

    /**
     * Update input type and output type parameters in Datamapper editor diagram
     * This will be persisted to schema files on diagram save
     */
    private void updateEditorInputTypes() {
        IEditorPart editorPart = workBenchPart.getSite().getWorkbenchWindow().getActivePage().getActiveEditor();
        if(editorPart instanceof DataMapperDiagramEditor) {
            if(SCHEMA_TYPE_INPUT.equals(this.schemaType)) {
                ((DataMapperDiagramEditor)editorPart).setInputSchemaType(schemaTypeCombo.getText());
            } else if (SCHEMA_TYPE_OUTPUT.equals(this.schemaType)){
                ((DataMapperDiagramEditor)editorPart).setOutputSchemaType(schemaTypeCombo.getText());
            }
        }
    }
    private void loadSchemaFromConnectorOperation(String connectorOperation) {
        try {
            String schemaFilePath = null;
            if (Messages.LoadInputSchemaAction_SchemaTypeInput.equals(schemaType)) {
                schemaFilePath =
                        CloudConnectorDirectoryTraverser.getInstance()
                                .getCloudConnectorOperationOutputSchemaFilePath(connectorOperation);
            } else if (Messages.LoadOutputSchemaAction_SchemaTypeOutput.equals(schemaType)) {
                schemaFilePath =
                        CloudConnectorDirectoryTraverser.getInstance()
                                .getCloudConnectorOperationInputSchemaFilePath(connectorOperation);
            }

            String schema = schemaGeneratorHelper.getSchemaContent(FileType.JSONSCHEMA,
                    schemaFilePath, null);
            DataMapperSchemaEditorUtil schemaEditorUtil = new DataMapperSchemaEditorUtil(inputFile);
            if (schema != null) {
                String schemaSaveFilePath = schemaEditorUtil.createDiagram(schema, schemaType);
                if (!schemaSaveFilePath.isEmpty()) {
                    setSelectedPathForConnector(schemaSaveFilePath);
                    saveInputOutputSchema(schemaSaveFilePath);
                }
            } else if (getConnectorOperationIsDynamic(cmbConnectorOperation.getText()).equals("true") &&
                    (!getConnectorOperationLoadClasses(cmbConnectorOperation.getText()).equals(""))) {
                DataMapperSchemaEditorUtil schemaEditorUtil1 =
                        new DataMapperSchemaEditorUtil(inputFile);
                String schema1 = schemaGeneratorHelper.getSchemaContent(FileType.XML,
                        rootWorkspaceLocation, null);
                file.delete();
                if (schema1 != null) {
                    String schemaSaveFilePath1 =
                            schemaEditorUtil1.createDiagram(schema1, schemaType);
                    if (!schemaSaveFilePath1.isEmpty()) {
                        setSelectedPathForConnector(schemaSaveFilePath1);
                        saveInputOutputSchema(schemaSaveFilePath1);
                    }
                }
            } else {
                MessageDialog.openWarning(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
                        "Error Loading Schema from Connector Operation",
                        "Schema definition cannot be found for connector operation");
            }
        } catch (Exception e) {
            log.error(ERROR_OPENING_FILE, e);
            displayUserError(REASON_OPENING_FILE, ERROR_OPENING_FILE);
        } finally {
            show();
        }
    }

    /**
     * Write from design to model
     */
    private void saveConfiguration() {
    }

    /**
     * browser for in-workspace local-entries
     */
    protected void openEmbeddedEntryBrowser() {
        hide();
        try {
            EmbeddedEntriesDialog embeddedEntriesDialog =
                    new EmbeddedEntriesDialog(getParentShell(),
                            null);
            embeddedEntriesDialog.create();
            embeddedEntriesDialog.getShell().setText(EMBEDDED_RESOURCES);
            embeddedEntriesDialog.open();
            if (embeddedEntriesDialog.getReturnCode() == Window.OK) {
                setSelectedPath(embeddedEntriesDialog.getSelectedItem().trim());
            }
        } finally {
            show();
        }
    }

    /**
     * Create new resource dialog
     */
    protected void openNewResourceTemplateDialog() {
        hide();
        try {
            NewResourceTemplateDialog newResourceTemplateDialog =
                    new NewResourceTemplateDialog(getParentShell(),
                            null);
            newResourceTemplateDialog.create();
            newResourceTemplateDialog.getShell().setText(NEW_RESOURCE);
            newResourceTemplateDialog.open();
            if (newResourceTemplateDialog.getReturnCode() == Window.OK) {
                setSelectedPath(newResourceTemplateDialog.getSelectedPath());
            }
        } finally {
            show();
        }
    }

    /**
     * Import schema from projects in workspace
     */
    private void openRegistryResourceProviderDialog() {
        hide();
        try {
            DataMapperSchemaEditorUtil schemaEditorUtil = new DataMapperSchemaEditorUtil(inputFile);
            RegistryKeyProperty registryPropertyKey =
                    EsbFactory.eINSTANCE.createRegistryKeyProperty();
            @SuppressWarnings("unchecked")
            DeveloperStudioElementProviderDialog registryResourceProviderSelector =
                    new DeveloperStudioElementProviderDialog(getParentShell(),
                            new Class[]{IRegistryFile.class},
                            (Map<String, List<String>>) registryPropertyKey.getFilters());
            registryResourceProviderSelector.create();
            registryResourceProviderSelector.getShell().setText(WORKSPACE_ELEMENT_PROVIDERS);
            registryResourceProviderSelector.open();
            if (registryResourceProviderSelector.getReturnCode() == Window.OK) {
                FileType fileType =
                        extractFileTypeFromFileExtension(registryResourceProviderSelector.getSelectedPath());
                if (fileType == null) {
                    // throw a user message saying not an accepted file type
                    return;
                }

                String[] getFileName = registryResourceProviderSelector.getSelectedPath()
                        .split(File.separator);
                String resourceFile = retrieveWorkSpaceFileLoc(getFileName[getFileName.length - 1]);

                boolean isCompatible = checkFileExtensionAgainstTheSchemaType(fileType);
                if (isCompatible) {
                    String schema = 
                    		schemaGeneratorHelper.getSchemaContent(fileType, resourceFile, delimiterTextField.getText());
                    String schemaFilePath = null;
                    try {
                        schemaFilePath = schemaEditorUtil.createDiagram(schema, schemaType);
                    } catch (Exception e) {
                        // log the error
                    }

                    if (!schemaFilePath.isEmpty()) {
                        setSelectedPath(schemaFilePath);
                        saveInputOutputSchema(schemaFilePath);
                    }

                } else {
                    String selectedType =
                            FileType.values()[schemaTypeCombo.getSelectionIndex()].toString()
                                    .toLowerCase();
                    displayUserError(REASON_FILE_TYPE_MISMATCH + " " + selectedType,
                            ERROR_WORKSPACE_IMPORT);
                }
            } else {
                return;
            }
        } finally {
            show();
        }
    }

    /**
     * retrieve the local path of the registry resource user selected from the
     * workspace, iterate through all the registry resource projects check if
     * the resource exist in some project, if so return the local file path to
     * that resource
     *
     * @param fileName
     * @return
     */
    private String retrieveWorkSpaceFileLoc(String fileName) {
        ArrayList<String> regResourceProjects = loadRegistryResourceProjects();
        boolean fileExists = false;
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        String folder = workspace.getRoot().getLocation().toFile().getPath().toString();
        String resourceFilePath = null;
        for (String regResourceProject : regResourceProjects) {
            resourceFilePath = folder + File.separator + regResourceProject + File.separator +
                    fileName;
            File resourceFile = new File(resourceFilePath);
            if (resourceFile.exists()) {
                fileExists = true;
                break;
            }
        }
        if (!fileExists) {
            displayUserError(RESGISTRY_RESOURCE_RETRIVING_ERROR, NO_SUCH_RESOURCE_EXISTS);
        }
        return resourceFilePath;
    }

    private FileType extractFileTypeFromFileExtension(String selectedPath) {
        if (selectedPath.endsWith(".xsd")) {
            return FileType.XSD;
        } else if (selectedPath.endsWith(".xml")) {
            return FileType.XML;
        } else if (selectedPath.endsWith(".jschema")) {
            return FileType.JSONSCHEMA;
        } else if (selectedPath.endsWith(".csv")) {
            return FileType.CSV;
        } else if (selectedPath.endsWith(".json")) {
            return FileType.JSON;
        } else {
            return null;
        }
    }

    /**
     * Open Registry browser
     */
    private void openRegistryBrowser() {
        hide();
        try {
            DataMapperSchemaEditorUtil schemaEditorUtil = new DataMapperSchemaEditorUtil(inputFile);
            IRegistryConnection[] registryConnections = CAppEnvironment.getRegistryHandler()
                    .getRegistryConnections();
            if (registryConnections.length == 0) {
                RegistryConnection registryConnection = new RegistryConnection();
                try {
                    registryConnection.setURL(new URL(DEFAULT_REGISTRY_URL));
                } catch (MalformedURLException e) {
                    log.error(ERROR_REGISTRY_URL, e);

                    displayUserError(REASON_REGISTRY_URL, ERROR_REGISTRY_URL);
                }
                registryConnection.setPath(C_REG_PATH_PREFIX);
            }
            IRegistryData selectedPathData =
                    CAppEnvironment.getRegistryHandler()
                            .selectRegistryPath(registryConnections,
                                    REGISTRY_BROWSER,
                                    SELECT_REGISTRY_RESOURCE,
                                    IRegistryHandler.SELECTED_REGISTRY_RESOURCE);
            if (selectedPathData == null) {
                return;
            }
            // String mediaType = selectedPathData.getMediaType();
            String mediaType = "xml"; // TODO need to replace this with the
            // above commented out line when the new
            // kernel version is available
            // FileType fileType =
            // extractFileTypeFromRegistryResource(mediaType);
            FileType fileType = extractFileTypeFromFileExtension(selectedPathData.getPath());

            String fileName = FILE_NAME_VALUE + "." + fileType.toString().toLowerCase();
            File outputDirectory = new File(tempOutput);
            if (!outputDirectory.exists()) {
                outputDirectory.mkdir();
            }
            File outputFile = new File(tempOutput + File.separator + fileName);
            if (outputFile.exists()) {
                outputFile.delete();
                outputFile.createNewFile();
            }
            CAppEnvironment.getRegistryHandler().importRegistryResourceToFileSystem(
                    (IRegistryData) selectedPathData,
                    outputFile);

            boolean isCompatible = checkFileExtensionAgainstTheSchemaType(fileType);
            if (isCompatible) {
                String schema =
                        schemaGeneratorHelper.getSchemaContent(FileType.values()[schemaTypeCombo.getSelectionIndex()],
                                outputFile.getAbsolutePath(),delimiterTextField.getText());
                outputDirectory.deleteOnExit();
                String schemaFilePath = schemaEditorUtil.createDiagram(schema, schemaType);

                if (!schemaFilePath.isEmpty()) {
                    setSelectedPath(schemaFilePath);
                    saveInputOutputSchema(schemaFilePath);
                }
            } else {
                String selectedType =
                        FileType.values()[schemaTypeCombo.getSelectionIndex()].toString()
                                .toLowerCase();
                displayUserError(REASON_FILE_TYPE_MISMATCH + " " + selectedType,
                        ERROR_REGISTRY_BROWSER);
            }

        } catch (Exception e) {
            log.error(ERROR_REGISTRY_BROWSER, e);

            displayUserError(REASON_REGISTRY_BROWSER, ERROR_REGISTRY_BROWSER);
        } finally {
            show();
        }
    }

    private boolean checkFileExtensionAgainstTheSchemaType(FileType fileType) {
        String selectedType = FileType.values()[schemaTypeCombo.getSelectionIndex()].toString();
        if (selectedType.equals(fileType.toString())) {
            return true;
        }
        return false;
    }

    private void displayUserError(String reason, String message) {
        IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, reason);
        ErrorDialog.openError(Display.getCurrent().getActiveShell(), ERROR_MSG_HEADER, message,
                editorStatus);
    }

    private int displayUserMssg(String header, String message) {
        MessageDialog dialog = new MessageDialog(Display.getDefault().getActiveShell(), header,
                null, message, MessageDialog.INFORMATION,
                new String[]{"OK", "Cancel"}, 0);
        return dialog.open();
    }

    /**
     * Pre-processing registry path
     */
    private void setSelectedPath(String selectedPath) {
        if (selectedPath.startsWith(G_REG_PATH_PREFIX)) {
            selectedPath = String.format(G_REG_PREFIX,
                    selectedPath.substring(G_REG_PATH_PREFIX.length()));
        } else if (selectedPath.startsWith(C_REG_PATH_PREFIX)) {
            selectedPath = String.format(C_REG_PREFIX,
                    selectedPath.substring(C_REG_PATH_PREFIX.length()));
        }

        schemaKeyTextField.setText(selectedPath);
        if (selectedPath != null && !selectedPath.trim().equals("")) { //$NON-NLS-1$
            okPressed();
        }
    }

    private void setSelectedPathForConnector(String selectedPath) {
        if (selectedPath.startsWith(G_REG_PATH_PREFIX)) {
            selectedPath = String.format(G_REG_PREFIX,
                    selectedPath.substring(G_REG_PATH_PREFIX.length()));
        } else if (selectedPath.startsWith(C_REG_PATH_PREFIX)) {
            selectedPath = String.format(C_REG_PREFIX,
                    selectedPath.substring(C_REG_PATH_PREFIX.length()));
        }
    }

    /**
     * Open file browser
     */
    private void openFileBrowser() {
        hide();
        schemaFileLocation = null;
        try {
            DataMapperSchemaEditorUtil schemaEditorUtil = new DataMapperSchemaEditorUtil(inputFile);
            FileType option = FileType.values()[schemaTypeCombo.getSelectionIndex()];
            FileDialog fid = new FileDialog(Display.getDefault().getActiveShell());
            if (option != FileType.JSONSCHEMA) {
                fid.setFilterExtensions(new String[]{fileExtensionForFileType(option)});
            }
            fid.setText(FILE_DIALOG_TITLE);
            schemaFileLocation = fid.open();
            if (schemaFileLocation == null) {
                return;
            }

            String configFileName = inputFile.getName().substring(0,
                    inputFile.getName().indexOf(EditorUtils.DIAGRAM_FILE_EXTENSION));
            String graphicalFileDirPath = inputFile.getParent().getLocation().toString();
            if (graphicalFileDirPath != null && !"".equals(graphicalFileDirPath)) {
                graphicalFileDirPath += File.separator;
            }

            inputFileLocation = graphicalFileDirPath + configFileName + "_inputSample"
                    + EditorUtils.TEXT_FILE_EXTENSION;

            String schema = schemaGeneratorHelper.getSchemaContent(
                    FileType.values()[schemaTypeCombo.getSelectionIndex()], schemaFileLocation,
                    delimiterTextField.getText());
            if (schema != null) {
                String schemaFilePath = schemaEditorUtil.createDiagram(schema, schemaType);
                if (!schemaFilePath.isEmpty()) {
                    setSelectedPath(schemaFilePath);

                    saveInputOutputSchema(schemaFilePath);
                }
            }

        } catch (Exception e) {
            log.error(ERROR_OPENING_FILE, e);

            displayUserError(REASON_OPENING_FILE, ERROR_OPENING_FILE);
        } finally {
            show();
        }

    }

    private void saveInputOutputSchema(String schemaFilePath) {
        if (Messages.LoadInputSchemaAction_SchemaTypeInput.equals(schemaType)) {
            if (selectedEP.getChildren().isEmpty()) {
                InputEditPart iep = (InputEditPart) selectedEP;
                iep.resetInputTreeFromFile(schemaFilePath);
                // Copy input file content
                copyInputFile(schemaFileLocation, inputFileLocation);
                DataMapperConfigHolder.getInstance().setInputFile(inputFileLocation);
            } else {
                if (displayUserMssg("Input Schema will be overwritten",
                        "The current Input Schema will be overwritten with the new schema loading, you want to proceed ? ") == 0) {
                    InputEditPart iep = (InputEditPart) selectedEP;
                    iep.resetInputTreeFromFile(schemaFilePath);
                    
                    copyInputFile(schemaFileLocation, inputFileLocation);
                    DataMapperConfigHolder.getInstance().setInputFile(inputFileLocation);
                }
            }
        } else if (Messages.LoadOutputSchemaAction_SchemaTypeOutput.equals(schemaType)) {
            if (selectedEP.getChildren().isEmpty()) {
                OutputEditPart iep = (OutputEditPart) selectedEP;
                iep.resetOutputTreeFromFile(schemaFilePath);
            } else {
                if (displayUserMssg("Output Schema will be overwritten",
                        "The current Output Schema will be overwritten with the new schema loading, you want to proceed ? ") == 0) {
                    OutputEditPart iep = (OutputEditPart) selectedEP;
                    iep.resetOutputTreeFromFile(schemaFilePath);
                }
            }
        }
    }

    /**
     * Copies a file to a given destination
     * 
     * @param originalFilePath path to the source file
     * @param destinationFilePath path of the destination
     */
    private void copyInputFile(String originalFilePath, String destinationFilePath) {
        String inputType = ((DataMapperDiagramEditor) workBenchPart.getSite().getWorkbenchWindow().getActivePage()
                .getActiveEditor()).getInputSchemaType();

        if (null != originalFilePath && null != destinationFilePath
                && (inputType.equals("XML") || inputType.equals("JSON") || inputType.equals("CSV"))) {
            File originalFile = new File(originalFilePath);
            File copiedFile = new File(destinationFilePath);
            try {
                FileUtils.copyFile(originalFile, copiedFile);
                assert (copiedFile).exists();
				assert (Files.readAllLines(originalFile.toPath(), Charset.defaultCharset())
						.equals(Files.readAllLines(copiedFile.toPath(), Charset.defaultCharset())));
            } catch (IOException e) {
                log.error("IO error occured while saving the datamapper input file!", e);
            }
        } else if (null != destinationFilePath) {
            clearContent(new File(destinationFilePath));
        }
    }
    
    /**
     * Clears the content of a given file
     * 
     * @param file
     */
    private void clearContent(File file) {
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            log.error("Datamapper input sample file " + file.getName() + "cannot be found!", e);
        }
    }
    
    private String fileExtensionForFileType(FileType option) {
        switch (option) {
            case XSD:
                return "*.xsd";
            case XML:
                return "*.xml";
            case JSON:
                return "*.json";
            case CSV:
                return "*.csv";
            default:
                return "*.jschema";// this is not used since we are not adding
            // any filter to json schema files

        }
    }

    private static FileType extractFileTypeFromRegistryResource(String mediaType) {
        if (mediaType.contains("xml")) {
            return FileType.XML;
        } else if (mediaType.contains("xsd")) {
            return FileType.XSD;
        } else if (mediaType.contains("json")) {
            return FileType.JSON;
        } else if (mediaType.contains("csv")) {
            return FileType.CSV;
        } else {
            return FileType.XML;
        }
    }

    private ArrayList<String> loadRegistryResourceProjects() {
        IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
        ArrayList<String> registryProjectList = new ArrayList<String>();
        for (IProject project : projects) {
            try {
                if (project.hasNature(Constants.GENERAL_PROJECT_NATURE)) {
                    registryProjectList.add(project.getName());
                }
            } catch (Exception e) {
				/* ignore */
            }
        }
        return registryProjectList;
    }

}
/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.wizard.mockservice;

import java.io.File;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.component.CustomUpdateWizardDialog;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.component.CustomWizardDialog;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.component.ReferenceTable;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.constant.Constants;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.MockService;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.MockServiceResource;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.wizard.mockresource.ResourceCreationWizard;

/**
 * Class responsible for creation of wizard page for mock service details.
 */
public class MockServiceDetailPage extends WizardPage {

    private static final String DIALOG_TITLE = "Create a new Mock Service";
    private static final String DESCRIPTION = "Create a new Mock Service";
    private static final String UNIT_TEST_SUITE_NAME = "Name of the Mock Service:";
    private static final String UNIT_TEST_SUITE_SAVE_PATH = "Save Location:";
    private static final String SERVICE_GROUP_TITLE = "Mock Service Details";
    private static final String EMPTY_STRING = "";

    private static final String SERVICE_NAME = "Mocking Endpoint Name:";
    private static final String SERVICE_PORT = "Mock Service Port:";
    private static final String SERVICE_CONTEXT = "Mock Service Context:";
    private static final String ADD_MOCK_SERVICE_RESOURCES = "Add Service Resources:";

    private IProject selectedProject;

    private String suiteName = EMPTY_STRING;
    private String suiteExportPath = EMPTY_STRING;
    private String initialSuiteName = EMPTY_STRING;

    private String serviceName = EMPTY_STRING;
    private String servicePort = EMPTY_STRING;
    private String serviceContext = EMPTY_STRING;

    private Text txtSuiteExportPath;
    private Text txtSuiteName;
    private Text txtServiceName;
    private Text txtServicePort;
    private Text txtServiceContext;
    private IStructuredSelection projSelection;
    private Button mockServiceRemoveButton;
    private Button mockServiceAddButton;
    private Table mockServiceTable;
    private TableViewer mockServiceTableViewer;

    MockService mockServiceDataHolder;
    private boolean isPageDirty;

    /**
     * Class constructor.
     */
    protected MockServiceDetailPage(IWorkbench wb, IStructuredSelection selection, IProject project,
            MockService mockService) {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);
        setDescription(DESCRIPTION);

        projSelection = selection;
        mockServiceDataHolder = mockService;
        mockServiceDataHolder.clearAllTemporalDataHolders();
        this.selectedProject = project;
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new FormLayout());

        Label lblName = new Label(container, SWT.NONE);
        FormData data = new FormData();
        data.top = new FormAttachment(5);
        data.left = new FormAttachment(3);
        data.width = 300;
        lblName.setLayoutData(data);
        lblName.setText(UNIT_TEST_SUITE_NAME);

        txtSuiteName = new Text(container, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(5);
        data.left = new FormAttachment(lblName, 5);
        data.right = new FormAttachment(97);
        txtSuiteName.setLayoutData(data);
        initialSuiteName = getSuiteName();
        txtSuiteName.setText(initialSuiteName);

        txtSuiteName.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent evt) {
                setSuiteName(txtSuiteName.getText());
                validate();
            }
        });

        Label lblExportDestination = new Label(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblName, 14);
        data.left = new FormAttachment(3);
        data.width = 300;
        lblExportDestination.setLayoutData(data);
        lblExportDestination.setText(UNIT_TEST_SUITE_SAVE_PATH);

        txtSuiteExportPath = new Text(container, SWT.READ_ONLY | SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(lblName, 14);
        data.left = new FormAttachment(lblExportDestination, 5);
        data.right = new FormAttachment(97);
        txtSuiteExportPath.setLayoutData(data);
        txtSuiteExportPath.setBackground(new Color(null, 229, 236, 253));
        suiteExportPath = selectedProject.getName() + File.separator + Constants.TEST_FOLDER + File.separator
                + Constants.SERVICE_RESOURCES + File.separator + Constants.MOCK_SERVICES;
        txtSuiteExportPath.setText(suiteExportPath);

        // Create a horizontal separator
        Label separator = new Label(container, SWT.HORIZONTAL | SWT.SEPARATOR);
        data = new FormData();
        data.top = new FormAttachment(txtSuiteExportPath, 25);
        data.left = new FormAttachment(2);
        data.left = new FormAttachment(2);
        data.right = new FormAttachment(98);
        separator.setLayoutData(data);

        // Create UI for the Mock Service Details
        Group grpServiceData = new Group(container, SWT.NONE);
        grpServiceData.setText(SERVICE_GROUP_TITLE);
        Font boldFont = new Font(null, new FontData("Arial", 10, SWT.BOLD));
        grpServiceData.setFont(boldFont);
        data = new FormData();
        data.top = new FormAttachment(separator, 20);
        data.left = new FormAttachment(3);
        data.right = new FormAttachment(97);
        data.bottom = new FormAttachment(98);
        grpServiceData.setLayoutData(data);
        grpServiceData.setLayout(new FormLayout());

        Label lblServiceName = new Label(grpServiceData, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblExportDestination, 10);
        data.left = new FormAttachment(3);
        data.width = 250;
        lblServiceName.setLayoutData(data);
        lblServiceName.setText(SERVICE_NAME);

        txtServiceName = new Text(grpServiceData, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(lblExportDestination, 10);
        data.left = new FormAttachment(lblServiceName, 0);
        data.right = new FormAttachment(97);
        txtServiceName.setLayoutData(data);

        txtServiceName.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setServiceName(txtServiceName.getText());
                validate();
            }
        });

        Label lblServicePort = new Label(grpServiceData, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblServiceName, 12);
        data.left = new FormAttachment(3);
        data.width = 250;
        lblServicePort.setLayoutData(data);
        lblServicePort.setText(SERVICE_PORT);

        txtServicePort = new Text(grpServiceData, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(lblServiceName, 12);
        data.left = new FormAttachment(lblServicePort, 0);
        data.right = new FormAttachment(97);
        txtServicePort.setLayoutData(data);

        txtServicePort.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setServicePort(txtServicePort.getText());
                validate();
            }
        });

        Label lblServiceContext = new Label(grpServiceData, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblServicePort, 12);
        data.left = new FormAttachment(3);
        data.width = 250;
        lblServiceContext.setLayoutData(data);
        lblServiceContext.setText(SERVICE_CONTEXT);

        txtServiceContext = new Text(grpServiceData, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(lblServicePort, 12);
        data.left = new FormAttachment(lblServiceContext, 0);
        data.right = new FormAttachment(97);
        txtServiceContext.setLayoutData(data);

        txtServiceContext.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setServiceContext(txtServiceContext.getText());
                validate();
            }
        });

        Label lblAddMockResources = new Label(grpServiceData, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(txtServiceContext, 20);
        data.left = new FormAttachment(3);
        lblAddMockResources.setLayoutData(data);
        lblAddMockResources.setText(ADD_MOCK_SERVICE_RESOURCES);

        ReferenceTable referenceTable = new ReferenceTable();
        mockServiceRemoveButton = referenceTable.createRemoveButton(grpServiceData, EMPTY_STRING, SWT.PUSH);
        mockServiceAddButton = referenceTable.createAddButton(grpServiceData, EMPTY_STRING, SWT.PUSH);
        mockServiceTable = referenceTable.createReferenceTable(grpServiceData, mockServiceRemoveButton.getStyle());
        mockServiceTableViewer = referenceTable.createTableViewer(mockServiceTable);

        data = new FormData();
        data.top = new FormAttachment(lblAddMockResources, -13);
        data.right = new FormAttachment(98);
        mockServiceRemoveButton.setLayoutData(data);

        data = new FormData();
        data.top = new FormAttachment(lblAddMockResources, -13);
        data.right = new FormAttachment(mockServiceRemoveButton, -3);
        mockServiceAddButton.setLayoutData(data);
        mockServiceAddButton.setEnabled(false);

        data = new FormData();
        data.height = 200;
        data.top = new FormAttachment(mockServiceRemoveButton, 5);
        data.left = new FormAttachment(1);
        data.bottom = new FormAttachment(98);
        data.right = new FormAttachment(99);
        mockServiceTable.setLayoutData(data);
        mockServiceTable.setLinesVisible(true);
        mockServiceTable.setHeaderVisible(true);

        TableColumn subContextColumn = new TableColumn(mockServiceTable, SWT.CENTER);
        subContextColumn.setText("Sub Context");

        TableColumn methodColumn = new TableColumn(mockServiceTable, SWT.CENTER);
        methodColumn.setText("Method");

        grpServiceData.addControlListener(new ControlAdapter() {
            public void controlResized(ControlEvent e) {
                Rectangle area = grpServiceData.getClientArea();
                int width = area.width;
                methodColumn.setWidth(width / 3);
                subContextColumn.setWidth(width - methodColumn.getWidth());
            }
        });

        mockServiceAddButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                mockServiceDataHolder.setMockServiceResourceUpdate(false);

                ResourceCreationWizard wizard = new ResourceCreationWizard(mockServiceDataHolder, getServiceContext());
                wizard.init(PlatformUI.getWorkbench(), projSelection);
                CustomWizardDialog resourceWizardDialog = new CustomWizardDialog(getShell(), wizard);
                resourceWizardDialog.setHelpAvailable(false);
                resourceWizardDialog.setPageSize(580, 620);
                resourceWizardDialog.open();

                refreshResourceTable();
                validate();
            }
        });

        mockServiceRemoveButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                if (mockServiceTable.getSelectionIndex() >= 0) {
                    String resourceKey = mockServiceTable.getItem(mockServiceTable.getSelectionIndex()).getText();
                    mockServiceDataHolder.removeMockResource(resourceKey);
                    mockServiceTable.remove(mockServiceTable.getSelectionIndices());
                    mockServiceRemoveButton.setEnabled(false);

                    validate();
                }
            }
        });

        mockServiceTable.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                TableItem selectedItem = (TableItem) event.item;
                if (selectedItem != null) {
                    mockServiceTable.setSelection(mockServiceTable.indexOf(selectedItem));
                    mockServiceRemoveButton.setEnabled(true);
                } else {
                    mockServiceRemoveButton.setEnabled(false);
                }

                validate();
            }
        });

        mockServiceTableViewer.addDoubleClickListener(new IDoubleClickListener() {
            @Override
            public void doubleClick(DoubleClickEvent event) {
                TableItem tableItem = mockServiceTable.getSelection()[0];

                if (tableItem != null) {
                    String resourceKey = tableItem.getText(0) + tableItem.getText(1);
                    mockServiceDataHolder.setMockServiceResourceUpdate(true);
                    mockServiceDataHolder.setSelectedMockResourceKey(resourceKey);

                    ResourceCreationWizard wizard = new ResourceCreationWizard(mockServiceDataHolder,
                            getServiceContext());
                    wizard.init(PlatformUI.getWorkbench(), projSelection);
                    CustomUpdateWizardDialog resourceWizardDialog = new CustomUpdateWizardDialog(getShell(), wizard);
                    resourceWizardDialog.setHelpAvailable(false);
                    resourceWizardDialog.setPageSize(580, 620);
                    resourceWizardDialog.open();

                    refreshResourceTable();
                    validate();
                }
            }
        });

        validate();
        setPageComplete(false);
    }

    /**
     * Method for validations of wizard page. If validation fails set page as dirty
     * and not complete
     */
    private void validate() {
        if (getSuiteName() == null || getSuiteName().equals(EMPTY_STRING)) {
            setErrorMessage("Please specify a name for the mock service suite");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (getServiceName() == null || getServiceName().equals(EMPTY_STRING)) {
            setErrorMessage("Please specify a name of the end point which want to mock");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (getServicePort() == null || getServicePort().equals(EMPTY_STRING)) {
            setErrorMessage("Please specify a port to the mock service");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (!getServicePort().matches("-?\\d+(\\.\\d+)?")) {
            setErrorMessage("Please specify a port valid port to start service");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (getServicePort().matches("-?\\d+(\\.\\d+)?") && Integer.parseInt(getServicePort()) > 65535) {
            setErrorMessage("Please specify a valid port less than or equal to 65535");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (getServiceContext() == null || getServiceContext().equals(EMPTY_STRING)) {
            setErrorMessage("Please specify a context of the mock service");
            setPageComplete(false);
            setPageDirty(true);
            mockServiceAddButton.setEnabled(false);
            return;
        } else if (!getServiceContext().startsWith(Constants.PATH_PREFIX)) {
            setErrorMessage("Please specify a context path starts with / symbol");
            setPageComplete(false);
            setPageDirty(true);
            mockServiceAddButton.setEnabled(false);
            return;
        } else if (getSuiteName().contains(Constants.SPACE_STRING)) {
            setErrorMessage("Please specify a mock service file name without whitespaces");
            setPageComplete(false);
            return;
        } else if (getServiceContext().contains(Constants.SPACE_STRING)) {
            setErrorMessage("Please specify a service context without whitespaces");
            setPageComplete(false);
            return;
        } else if (getServiceName().contains(Constants.SPACE_STRING)) {
            setErrorMessage("Please specify a end point name which want to mock without whitespaces");
            setPageComplete(false);
            return;
        } else if (getServiceContext().endsWith(Constants.PATH_PREFIX)) {
            setErrorMessage("Please specify service context without having '/' in the end");
            setPageComplete(false);
            return;
        } else if (getServiceContext().matches(Constants.CONTEXT_VALIDATE_REGEX)) {
            setErrorMessage("Please specify service context without having '/' repeatedly");
            setPageComplete(false);
            return;
        } else {
            int resourceCount = mockServiceDataHolder.getMockResources().size();
            if (resourceCount == 0) {
                setErrorMessage("Please add atleast one mock service resource to complete");
                setPageComplete(false);
                setPageDirty(true);
                mockServiceAddButton.setEnabled(true);
                return;
            } else {
                IWorkspaceRoot wroot = ResourcesPlugin.getWorkspace().getRoot();
                IContainer unitTestsLocation = wroot.getFolder(new Path(getSuiteExportPath()));
                IFile unitTestFile = unitTestsLocation
                        .getFile(new Path(getSuiteName() + "." + Constants.XML_EXTENSION));
                if (unitTestFile.exists()) {
                    setErrorMessage(getSuiteName() + " file name is already exists in saving location");
                    setPageComplete(false);
                    return;
                }
            }
        }

        setErrorMessage(null);
        setPageDirty(false);
        setPageComplete(true);
    }

    /**
     * Method for refreshing the resources table.
     */
    private void refreshResourceTable() {
        mockServiceTable.removeAll();

        for (Map.Entry<String, MockServiceResource> resource : mockServiceDataHolder.getMockResources().entrySet()) {
            TableItem item = new TableItem(mockServiceTable, SWT.NONE);
            item.setText(0, resource.getValue().getSubContext());
            item.setText(1, resource.getValue().getMethod());
        }
    }

    public void setSelectedProject(IProject selectedProject) {
        this.selectedProject = selectedProject;
    }

    public void setSuiteExportPath(String path) {
        this.suiteExportPath = path;
    }

    public String getSuiteExportPath() {
        return suiteExportPath;
    }

    public Text getSuiteExportPatht() {
        return txtSuiteExportPath;
    }

    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }

    public String getSuiteName() {
        return suiteName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServicePort() {
        return servicePort;
    }

    public void setServicePort(String servicePort) {
        this.servicePort = servicePort;
    }

    public String getServiceContext() {
        return serviceContext;
    }

    public void setServiceContext(String serviceContext) {
        this.serviceContext = serviceContext;
    }

    public boolean isPageDirty() {
        return isPageDirty;
    }

    public void setPageDirty(boolean isPageDirty) {
        this.isPageDirty = isPageDirty;
    }
}

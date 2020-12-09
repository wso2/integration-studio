/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.wizard.mockresource;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
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
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.component.CustomUpdateWizardDialog;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.component.CustomWizardDialog;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.component.ReferenceTable;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.component.SyntaxHighlightTextBox;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.constant.Constants;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.MockService;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.MockServiceResource;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.utils.ComboItems;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.utils.CommonUtil;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.wizard.mockheader.HeaderCreationWizard;

/**
 * Class responsible for creation of wizard page for mock service resource
 * requests.
 */
public class ResourcesRequestDetailPage extends WizardPage {

    private static final String DIALOG_TITLE = "Mock Service - Resource Details";
    private static final String SECTION_TITLE = "Expected Request to the Mock Service Resource";
    private static final String EMPTY_STRING = "";

    private static final String SERVICE_SUB_CONTEXT = "Service Sub Context:";
    private static final String SERVICE_METHOD = "Service Method:";
    private static final String SERVICE_REQUEST_PAYLOAD = "Expected Request Payload:";
    private static final String ADD_REQUEST_HEADERS = "Expected Request Headers:";
    private static final String DESCRIPTION = "Add sub resource with expected request and response data";
    private static final String ADD_REQUEST_NOTICE = "Note - Request must be matched with the entered request headers or payload to send the response";
    private static final String TYPE_REQUEST = "REQUEST";

    private String serviceSubContext = EMPTY_STRING;
    private String serviceMethod = EMPTY_STRING;
    private String serviceRequestPayload = EMPTY_STRING;
    private String mainServiceContext = EMPTY_STRING;

    private Text txtServiceSubContext;
    private StyledText txtServiceRequestPayload;
    private Button requestHeaderRemoveButton;
    private Button requestHeaderAddButton;
    private Table requestHeaderTable;
    private TableViewer requestHeaderTableViewer;
    private Section serviceRequestSection;
    private FormToolkit toolkit;
    private Combo comboServiceMethod;

    private IStructuredSelection projSelection;
    private boolean isPageDirty;

    private MockServiceResource selectedResource;
    private MockService serviceResourceHolder;

    /**
     * Class constructor.
     */
    protected ResourcesRequestDetailPage(IWorkbench wb, IStructuredSelection selection, MockService resourceHolder,
            String context) {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);
        setDescription(DESCRIPTION);
        projSelection = selection;
        serviceResourceHolder = resourceHolder;
        mainServiceContext = context;

        // check page loading for update status
        if (serviceResourceHolder.isMockServiceResourceUpdate()) {
            String resourceKey = serviceResourceHolder.getSelectedMockResourceKey();
            selectedResource = serviceResourceHolder.getMockResource(resourceKey);
            fillUpdateResourceData(selectedResource);
        }
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new FormLayout());
        container.setSize(580, 500);
        FormData data;

        Label lblServiceSubContext = new Label(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(2);
        data.left = new FormAttachment(3);
        data.width = 250;
        lblServiceSubContext.setLayoutData(data);
        lblServiceSubContext.setText(SERVICE_SUB_CONTEXT);

        Label lblSubContextPrefixName = new Label(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(2);
        data.left = new FormAttachment(lblServiceSubContext, 3);
        data.width = 9 * mainServiceContext.length();
        data.height = 25;
        lblSubContextPrefixName.setLayoutData(data);
        lblSubContextPrefixName.setText(" " + mainServiceContext);
        lblSubContextPrefixName.setBackground(new Color(null, 229, 236, 253));
        Font boldFont = new Font(null, new FontData("Arial", 12, SWT.BOLD));
        lblSubContextPrefixName.setFont(boldFont);

        txtServiceSubContext = new Text(container, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(2);
        data.left = new FormAttachment(lblSubContextPrefixName, 0);
        data.right = new FormAttachment(97);
        data.width = 350;
        txtServiceSubContext.setLayoutData(data);
        if (getServiceSubContext() != null && !getServiceSubContext().isEmpty()) {
            txtServiceSubContext.setText(getServiceSubContext());
        }

        txtServiceSubContext.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setServiceSubContext(txtServiceSubContext.getText());
                validate();
            }
        });

        Label lblServiceMethod = new Label(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblServiceSubContext, 12);
        data.left = new FormAttachment(3);
        data.width = 250;
        lblServiceMethod.setLayoutData(data);
        lblServiceMethod.setText(SERVICE_METHOD);

        comboServiceMethod = new Combo(container, SWT.READ_ONLY | SWT.DROP_DOWN);
        data = new FormData();
        data.top = new FormAttachment(lblServiceSubContext, 12);
        data.left = new FormAttachment(lblServiceMethod, 0);
        data.right = new FormAttachment(97);
        data.width = 400;
        comboServiceMethod.setItems(ComboItems.getRestTypes());
        if (!getServiceMethod().isEmpty()) {
            comboServiceMethod.setText(getServiceMethod());
        } else {
            comboServiceMethod.setText(ComboItems.getRestTypes()[0]);
        }
        comboServiceMethod.setLayoutData(data);
        setServiceMethod(comboServiceMethod.getText());

        comboServiceMethod.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                setServiceMethod(comboServiceMethod.getText());
                validate();
                requestPayloadVisibility();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        toolkit = new FormToolkit(parent.getDisplay());
        createResourceRequestSection(container);

        refreshRequestHeaderTable();
        validate();
    }

    /**
     * Method for create resource request section in the wizard page.
     *
     * @param container
     *            Composite layout
     */
    private void createResourceRequestSection(Composite container) {
        FormData data = new FormData();

        serviceRequestSection = toolkit.createSection(container, Section.TWISTIE | Section.EXPANDED);
        toolkit.createCompositeSeparator(serviceRequestSection);
        serviceRequestSection.setText(SECTION_TITLE);

        Composite requestSectionClient = toolkit.createComposite(serviceRequestSection);
        requestSectionClient.setLayout(new FormLayout());

        data.left = new FormAttachment(2);
        data.top = new FormAttachment(comboServiceMethod, 30);
        data.right = new FormAttachment(98);
        serviceRequestSection.setLayoutData(data);
        serviceRequestSection.setClient(requestSectionClient);

        Label lblNotice = new Label(requestSectionClient, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(serviceRequestSection, 5);
        data.left = new FormAttachment(1);
        lblNotice.setLayoutData(data);
        lblNotice.setText(ADD_REQUEST_NOTICE);
        FontData[] fontData = lblNotice.getFont().getFontData();
        fontData[0].setHeight(11);
        lblNotice.setFont(new Font(null, fontData[0]));

        Group grpRequestData = new Group(requestSectionClient, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblNotice, 5);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        data.bottom = new FormAttachment(99);
        grpRequestData.setLayoutData(data);
        grpRequestData.setLayout(new FormLayout());

        Label lblAddHeaders = new Label(grpRequestData, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(grpRequestData, 10);
        data.left = new FormAttachment(1);
        lblAddHeaders.setLayoutData(data);
        lblAddHeaders.setText(ADD_REQUEST_HEADERS);

        ReferenceTable referenceTable = new ReferenceTable();
        requestHeaderRemoveButton = referenceTable.createRemoveButton(grpRequestData, EMPTY_STRING, SWT.PUSH);
        requestHeaderAddButton = referenceTable.createAddButton(grpRequestData, EMPTY_STRING, SWT.PUSH);
        requestHeaderTable = referenceTable.createReferenceTable(grpRequestData, requestHeaderRemoveButton.getStyle());
        requestHeaderTableViewer = referenceTable.createTableViewer(requestHeaderTable);

        data = new FormData();
        data.top = new FormAttachment(lblAddHeaders, -13);
        data.right = new FormAttachment(99);
        requestHeaderRemoveButton.setLayoutData(data);
        requestHeaderRemoveButton.setEnabled(false);

        data = new FormData();
        data.top = new FormAttachment(lblAddHeaders, -13);
        data.right = new FormAttachment(requestHeaderRemoveButton, -3);
        requestHeaderAddButton.setLayoutData(data);

        data = new FormData();
        data.height = 140;
        data.top = new FormAttachment(requestHeaderRemoveButton, 5);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        requestHeaderTable.setLayoutData(data);
        requestHeaderTable.setLinesVisible(true);
        requestHeaderTable.setHeaderVisible(true);

        TableColumn headerNamecolumn = new TableColumn(requestHeaderTable, SWT.CENTER);
        headerNamecolumn.setText("Header Name");

        TableColumn headerValcolumn = new TableColumn(requestHeaderTable, SWT.CENTER);
        headerValcolumn.setText("Header Value");

        grpRequestData.addControlListener(new ControlAdapter() {
            public void controlResized(ControlEvent e) {
                Rectangle area = grpRequestData.getClientArea();
                int width = area.width;
                headerNamecolumn.setWidth(width / 2);
                headerValcolumn.setWidth(width / 2);
            }
        });

        requestHeaderAddButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                serviceResourceHolder.setMockServiceRequestHeaderUpdate(false);

                HeaderCreationWizard wizard = new HeaderCreationWizard(serviceResourceHolder, TYPE_REQUEST);
                wizard.init(PlatformUI.getWorkbench(), projSelection);
                CustomWizardDialog headerWizardDialog = new CustomWizardDialog(getShell(), wizard);
                headerWizardDialog.setHelpAvailable(false);
                headerWizardDialog.setPageSize(580, 30);
                headerWizardDialog.open();

                refreshRequestHeaderTable();
                validate();
            }
        });

        requestHeaderRemoveButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                if (requestHeaderTable.getSelectionIndex() >= 0) {
                    String headerKey = requestHeaderTable.getItem(requestHeaderTable.getSelectionIndex()).getText(0);

                    if (selectedResource != null && selectedResource.getRequestHeaders().containsKey(headerKey)) {
                        selectedResource.removeRequestHeader(headerKey);
                    } else if (serviceResourceHolder.getTemporalRequestHeaders().containsKey(headerKey)) {
                        serviceResourceHolder.removeTemporalRequestHeaders(headerKey);
                    }

                    requestHeaderTable.remove(requestHeaderTable.getSelectionIndices());
                    requestHeaderRemoveButton.setEnabled(false);
                }

                validate();
            }
        });

        requestHeaderTable.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                TableItem selectedItem = (TableItem) event.item;
                if (selectedItem != null) {
                    requestHeaderTable.setSelection(requestHeaderTable.indexOf(selectedItem));
                    requestHeaderRemoveButton.setEnabled(true);
                } else {
                    requestHeaderRemoveButton.setEnabled(false);
                }
            }
        });

        requestHeaderTableViewer.addDoubleClickListener(new IDoubleClickListener() {
            @Override
            public void doubleClick(DoubleClickEvent event) {
                TableItem tableItem = requestHeaderTable.getSelection()[0];

                String headerKey = null;
                if (tableItem != null) {
                    headerKey = tableItem.getText(0);
                }

                if (headerKey != null) {
                    serviceResourceHolder.setMockServiceRequestHeaderUpdate(true);
                    serviceResourceHolder.setSelectedRequestHeaderKey(headerKey);
                    HeaderCreationWizard wizard = new HeaderCreationWizard(serviceResourceHolder, TYPE_REQUEST);

                    wizard.init(PlatformUI.getWorkbench(), projSelection);
                    CustomUpdateWizardDialog headerWizardDialog = new CustomUpdateWizardDialog(getShell(), wizard);
                    headerWizardDialog.setHelpAvailable(false);
                    headerWizardDialog.setPageSize(580, 30);
                    headerWizardDialog.open();

                    refreshRequestHeaderTable();
                    validate();
                }
            }
        });

        Label lblServiceRequestPayload = new Label(grpRequestData, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(requestHeaderTable, 20);
        data.left = new FormAttachment(1);
        lblServiceRequestPayload.setLayoutData(data);
        lblServiceRequestPayload.setText(SERVICE_REQUEST_PAYLOAD);

        SyntaxHighlightTextBox syntaxStyler = new SyntaxHighlightTextBox();
        txtServiceRequestPayload = syntaxStyler.getStyledTextBox(grpRequestData);
        data = new FormData();
        data.top = new FormAttachment(lblServiceRequestPayload, 10);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        data.bottom = new FormAttachment(96);
        data.height = 130;
        txtServiceRequestPayload.setLayoutData(data);
        if (getServiceRequestPayload() != null && !getServiceRequestPayload().isEmpty()) {
            txtServiceRequestPayload.setText(CommonUtil.removeCDATAFromPayload(getServiceRequestPayload()));
            syntaxStyler.chooseSyntaxHighlighter(txtServiceRequestPayload.getText(), false);
        }

        txtServiceRequestPayload.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setServiceRequestPayload(CommonUtil.removeCDATAFromPayload(txtServiceRequestPayload.getText()));
                syntaxStyler.chooseSyntaxHighlighter(txtServiceRequestPayload.getText(), false);
                validate();
            }
        });

        requestPayloadVisibility();
    }

    /**
     * Method for validations of wizard page. If validation fails set page as dirty
     * and not complete
     */
    private void validate() {
        if (getServiceSubContext() == null || getServiceSubContext().isEmpty()) {
            setErrorMessage("Please specify a sub context for the mock service");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (getServiceMethod() == null || getServiceMethod().isEmpty()) {
            setErrorMessage("Please specify a method for the mock service");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (!getServiceSubContext().startsWith(Constants.PATH_PREFIX)) {
            setErrorMessage("Please specify a sub context path starts with / symbol or base path /");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (getServiceSubContext().contains(Constants.SPACE_STRING)) {
            setErrorMessage("Please specify a service sub context without whitespaces");
            setPageComplete(false);
            return;
        } else if (getServiceSubContext().endsWith(Constants.PATH_PREFIX) && getServiceSubContext().length() > 1) {
            setErrorMessage("Please specify service sub context without having '/' in the end");
            setPageComplete(false);
            return;
        } else if (getServiceSubContext().matches(Constants.CONTEXT_VALIDATE_REGEX)) {
            setErrorMessage("Please specify service sub context without having '/' repeatedly");
            setPageComplete(false);
            return;
        }

        setPageDirty(false);
        setErrorMessage(null);
        setPageComplete(true);
    }

    /**
     * Method for filling updating data to wizard page.
     *
     * @param resource
     *            Mock service resource data
     */
    private void fillUpdateResourceData(MockServiceResource resource) {
        setServiceSubContext(resource.getSubContext());
        setServiceMethod(resource.getMethod());
        setServiceRequestPayload(resource.getRequestPayload());
    }

    /**
     * Method for get enable the payload box according to the method type.
     */
    private void requestPayloadVisibility() {
        if (getServiceMethod().equals(ComboItems.getRestTypes()[0])) {
            txtServiceRequestPayload.setEnabled(false);
            txtServiceRequestPayload.setBackground(new Color(null, 249, 249, 249));
        } else {
            txtServiceRequestPayload.setEnabled(true);
            txtServiceRequestPayload.setBackground(new Color(null, 255, 255, 255));
        }
    }

    /**
     * Method for refreshing the request header table.
     */
    private void refreshRequestHeaderTable() {
        requestHeaderTable.removeAll();

        LinkedHashMap<String, String> existsRequestHeaders = new LinkedHashMap<>();
        if (serviceResourceHolder.isMockServiceResourceUpdate()) {
            existsRequestHeaders = selectedResource.getRequestHeaders();
        }

        for (Map.Entry<String, String> entry : existsRequestHeaders.entrySet()) {
            TableItem item = new TableItem(requestHeaderTable, SWT.NONE);
            item.setText(0, entry.getKey());
            item.setText(1, entry.getValue());
        }

        for (Map.Entry<String, String> entry : serviceResourceHolder.getTemporalRequestHeaders().entrySet()) {
            TableItem item = new TableItem(requestHeaderTable, SWT.NONE);
            item.setText(0, entry.getKey());
            item.setText(1, entry.getValue());
        }
    }

    /**
     * Method for getting current project from IStructuredSelection.
     *
     * @param obj
     *            IStructuredSelection as an object
     * @return IProject
     */
    public static IProject getSelectedProject(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }

        if (obj instanceof IResource) {
            return ((IResource) obj).getProject();
        } else if (obj instanceof IStructuredSelection) {
            return getSelectedProject(((IStructuredSelection) obj).getFirstElement());
        }
        return null;
    }

    public String getServiceSubContext() {
        return serviceSubContext;
    }

    public void setServiceSubContext(String serviceSubContext) {
        this.serviceSubContext = serviceSubContext;
    }

    public String getServiceMethod() {
        return serviceMethod;
    }

    public void setServiceMethod(String serviceMethod) {
        this.serviceMethod = serviceMethod;
    }

    public String getServiceRequestPayload() {
        return serviceRequestPayload;
    }

    public void setServiceRequestPayload(String serviceRequestPayload) {
        this.serviceRequestPayload = serviceRequestPayload;
    }

    public boolean isPageDirty() {
        return isPageDirty;
    }

    public void setPageDirty(boolean isPageDirty) {
        this.isPageDirty = isPageDirty;
    }
}

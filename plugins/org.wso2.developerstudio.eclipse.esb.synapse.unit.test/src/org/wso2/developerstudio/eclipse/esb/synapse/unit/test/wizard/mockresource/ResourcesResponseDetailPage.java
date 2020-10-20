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
package org.wso2.developerstudio.eclipse.esb.synapse.unit.test.wizard.mockresource;

import java.util.LinkedHashMap;
import java.util.Map;

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
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.component.CustomUpdateWizardDialog;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.component.CustomWizardDialog;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.component.ReferenceTable;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.component.SyntaxHighlightTextBox;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.MockService;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.MockServiceResource;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.utils.ComboItems;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.utils.CommonUtil;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.wizard.mockheader.HeaderCreationWizard;

/**
 * Class responsible for creation of wizard page for mock service resource
 * response.
 */
public class ResourcesResponseDetailPage extends WizardPage {

    private static final String DIALOG_TITLE = "Mock Service - Resource Details";
    private static final String SECTION_TITLE = "Response Send Out from the Mock Service Resource";
    private static final String EMPTY_STRING = "";
    private static final String SERVICE_RESPONSE_PAYLOAD = "Send out Response Payload:";
    private static final String ADD_RESPONSE_HEADERS = "Send out Response Headers:";
    private static final String DESCRIPTION = "Add sub resource with expected response data";
    private static final String TYPE_RESPONSE = "RESPONSE";
    private static final String STATUS_CODE = "Response Status Code:";

    private String serviceResponsePayload = EMPTY_STRING;
    private String statusCode = EMPTY_STRING;

    private StyledText txtServiceResponsePayload;
    private Button responseHeaderRemoveButton;
    private Button responseHeaderAddButton;
    private Table responseHeaderTable;
    private TableViewer responseHeaderTableViewer;
    private Section serviceResponseSection;
    private FormToolkit toolkit;

    private IStructuredSelection projSelection;
    private boolean isPageDirty;

    private MockServiceResource selectedResource;
    private MockService serviceResourceHolder;

    /**
     * Class constructor.
     */
    protected ResourcesResponseDetailPage(IWorkbench wb, IStructuredSelection selection, MockService resourceHolder) {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);
        setDescription(DESCRIPTION);
        projSelection = selection;
        serviceResourceHolder = resourceHolder;

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

        toolkit = new FormToolkit(parent.getDisplay());
        createResourceResponseSection(container);

        refreshResponseHeaderTable();
    }

    /**
     * Method for create resource response section in the wizard page.
     *
     * @param container
     *            Composite layout
     */
    private void createResourceResponseSection(Composite container) {
        FormData data = new FormData();

        serviceResponseSection = toolkit.createSection(container, Section.TWISTIE | Section.EXPANDED);
        toolkit.createCompositeSeparator(serviceResponseSection);
        serviceResponseSection.setText(SECTION_TITLE);

        Composite responseSectionClient = toolkit.createComposite(serviceResponseSection);
        responseSectionClient.setLayout(new FormLayout());

        data.left = new FormAttachment(2);
        data.top = new FormAttachment(2);
        data.right = new FormAttachment(98);
        serviceResponseSection.setLayoutData(data);
        serviceResponseSection.setClient(responseSectionClient);

        Group grpResponseData = new Group(responseSectionClient, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(serviceResponseSection, 5);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        data.bottom = new FormAttachment(99);
        grpResponseData.setLayoutData(data);
        grpResponseData.setLayout(new FormLayout());

        Label lblStatusCode = new Label(grpResponseData, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(grpResponseData, 10);
        data.left = new FormAttachment(1);
        data.width = 250;
        lblStatusCode.setLayoutData(data);
        lblStatusCode.setText(STATUS_CODE);

        Combo statusCodesCombo = new Combo(grpResponseData, SWT.READ_ONLY | SWT.DROP_DOWN);
        data = new FormData();
        data.top = new FormAttachment(grpResponseData, 10);
        data.left = new FormAttachment(lblStatusCode, 0);
        data.right = new FormAttachment(99);
        data.width = 400;
        statusCodesCombo.setItems(ComboItems.getStatusCodes());
        if (!getStatusCode().isEmpty()) {
            statusCodesCombo.setText(getStatusCode());
        } else {
            statusCodesCombo.setText(ComboItems.getStatusCodes()[3]);
            setStatusCode(statusCodesCombo.getText());
        }
        statusCodesCombo.setLayoutData(data);

        statusCodesCombo.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                setStatusCode(statusCodesCombo.getText());
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        // Begin of Request/Response Headers Table
        Label lblAddHeaders = new Label(grpResponseData, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblStatusCode, 20);
        data.left = new FormAttachment(1);
        lblAddHeaders.setLayoutData(data);
        lblAddHeaders.setText(ADD_RESPONSE_HEADERS);

        ReferenceTable referenceTable = new ReferenceTable();
        responseHeaderRemoveButton = referenceTable.createRemoveButton(grpResponseData, EMPTY_STRING, SWT.PUSH);
        responseHeaderAddButton = referenceTable.createAddButton(grpResponseData, EMPTY_STRING, SWT.PUSH);
        responseHeaderTable = referenceTable.createReferenceTable(grpResponseData,
                responseHeaderRemoveButton.getStyle());
        responseHeaderTableViewer = referenceTable.createTableViewer(responseHeaderTable);

        data = new FormData();
        data.top = new FormAttachment(lblAddHeaders, -13);
        data.right = new FormAttachment(99);
        responseHeaderRemoveButton.setLayoutData(data);
        responseHeaderRemoveButton.setEnabled(false);

        data = new FormData();
        data.top = new FormAttachment(lblAddHeaders, -13);
        data.right = new FormAttachment(responseHeaderRemoveButton, -3);
        responseHeaderAddButton.setLayoutData(data);

        data = new FormData();
        data.height = 140;
        data.top = new FormAttachment(responseHeaderRemoveButton, 5);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        responseHeaderTable.setLayoutData(data);
        responseHeaderTable.setLinesVisible(true);
        responseHeaderTable.setHeaderVisible(true);

        TableColumn headerNamecolumn = new TableColumn(responseHeaderTable, SWT.CENTER);
        headerNamecolumn.setText("Header Name");

        TableColumn headerValcolumn = new TableColumn(responseHeaderTable, SWT.CENTER);
        headerValcolumn.setText("Header Value");

        grpResponseData.addControlListener(new ControlAdapter() {
            public void controlResized(ControlEvent e) {
                Rectangle area = grpResponseData.getClientArea();
                int width = area.width;
                headerNamecolumn.setWidth(width / 2);
                headerValcolumn.setWidth(width / 2);
            }
        });

        responseHeaderAddButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                serviceResourceHolder.setMockServiceResponseHeaderUpdate(false);

                HeaderCreationWizard wizard = new HeaderCreationWizard(serviceResourceHolder, TYPE_RESPONSE);
                wizard.init(PlatformUI.getWorkbench(), projSelection);
                CustomWizardDialog headerWizardDialog = new CustomWizardDialog(getShell(), wizard);
                headerWizardDialog.setHelpAvailable(false);
                headerWizardDialog.setPageSize(580, 30);
                headerWizardDialog.open();

                refreshResponseHeaderTable();
            }
        });

        responseHeaderRemoveButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                if (responseHeaderTable.getSelectionIndex() >= 0) {
                    String headerKey = responseHeaderTable.getItem(responseHeaderTable.getSelectionIndex()).getText(0);

                    if (selectedResource != null && selectedResource.getResponseHeaders().containsKey(headerKey)) {
                        selectedResource.removeResponseHeader(headerKey);
                    } else if (serviceResourceHolder.getTemporalResponseHeaders().containsKey(headerKey)) {
                        serviceResourceHolder.removeTemporalResponseHeaders(headerKey);
                    }

                    responseHeaderTable.remove(responseHeaderTable.getSelectionIndices());
                    responseHeaderRemoveButton.setEnabled(false);
                }

            }
        });

        responseHeaderTable.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                TableItem selectedItem = (TableItem) event.item;
                if (selectedItem != null) {
                    responseHeaderTable.setSelection(responseHeaderTable.indexOf(selectedItem));
                    responseHeaderRemoveButton.setEnabled(true);
                } else {
                    responseHeaderRemoveButton.setEnabled(false);
                }
            }
        });

        responseHeaderTableViewer.addDoubleClickListener(new IDoubleClickListener() {
            @Override
            public void doubleClick(DoubleClickEvent event) {
                TableItem tableItem = responseHeaderTable.getSelection()[0];

                String headerKey = null;
                if (tableItem != null) {
                    headerKey = tableItem.getText(0);
                }

                if (headerKey != null) {
                    serviceResourceHolder.setMockServiceResponseHeaderUpdate(true);
                    serviceResourceHolder.setSelectedResponseHeaderKey(headerKey);
                    HeaderCreationWizard wizard = new HeaderCreationWizard(serviceResourceHolder, TYPE_RESPONSE);

                    wizard.init(PlatformUI.getWorkbench(), projSelection);
                    CustomUpdateWizardDialog headerWizardDialog = new CustomUpdateWizardDialog(getShell(), wizard);
                    headerWizardDialog.setHelpAvailable(false);
                    headerWizardDialog.setPageSize(580, 30);
                    headerWizardDialog.open();

                    refreshResponseHeaderTable();
                }
            }
        });

        Label lblServiceResponsePayload = new Label(grpResponseData, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(responseHeaderTable, 20);
        data.left = new FormAttachment(1);
        lblServiceResponsePayload.setLayoutData(data);
        lblServiceResponsePayload.setText(SERVICE_RESPONSE_PAYLOAD);

        SyntaxHighlightTextBox syntaxStyler = new SyntaxHighlightTextBox();
        txtServiceResponsePayload = syntaxStyler.getStyledTextBox(grpResponseData);
        data = new FormData();
        data.top = new FormAttachment(lblServiceResponsePayload, 10);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        data.bottom = new FormAttachment(98);
        data.height = 140;
        txtServiceResponsePayload.setLayoutData(data);
        if (getServiceResponsePayload() != null && !getServiceResponsePayload().isEmpty()) {
            txtServiceResponsePayload.setText(CommonUtil.removeCDATAFromPayload(getServiceResponsePayload()));
            syntaxStyler.chooseSyntaxHighlighter(txtServiceResponsePayload.getText(), false);
        }

        txtServiceResponsePayload.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setServiceResponsePayload(txtServiceResponsePayload.getText());
                syntaxStyler.chooseSyntaxHighlighter(txtServiceResponsePayload.getText(), false);
            }
        });
    }

    /**
     * Method for filling updating data to wizard page.
     *
     * @param resource
     *            Mock service resource data
     */
    private void fillUpdateResourceData(MockServiceResource resource) {
        setServiceResponsePayload(resource.getResponsePayload());

        String statusCode = Integer.toString(resource.getStatusCode());
        for (int x = 0; x < ComboItems.getStatusCodes().length; x++) {
            if (ComboItems.getStatusCodes()[x].contains(statusCode)) {
                setStatusCode(ComboItems.getStatusCodes()[x]);
                break;
            }
        }
    }

    /**
     * Method for refreshing the response header table.
     */
    private void refreshResponseHeaderTable() {
        responseHeaderTable.removeAll();

        LinkedHashMap<String, String> existsResponseHeaders = new LinkedHashMap<>();
        if (serviceResourceHolder.isMockServiceResourceUpdate()) {
            existsResponseHeaders = selectedResource.getResponseHeaders();
        }

        for (Map.Entry<String, String> entry : existsResponseHeaders.entrySet()) {
            TableItem item = new TableItem(responseHeaderTable, SWT.NONE);
            item.setText(0, entry.getKey());
            item.setText(1, entry.getValue());
        }

        for (Map.Entry<String, String> entry : serviceResourceHolder.getTemporalResponseHeaders().entrySet()) {
            TableItem item = new TableItem(responseHeaderTable, SWT.NONE);
            item.setText(0, entry.getKey());
            item.setText(1, entry.getValue());
        }
    }

    public String getServiceResponsePayload() {
        return serviceResponsePayload;
    }

    public void setServiceResponsePayload(String serviceResponsePayload) {
        this.serviceResponsePayload = serviceResponsePayload;
    }

    public boolean isPageDirty() {
        return isPageDirty;
    }

    public void setPageDirty(boolean isPageDirty) {
        this.isPageDirty = isPageDirty;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}

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
package org.wso2.developerstudio.esb.form.editors.mockservice;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.component.CustomUpdateWizardDialog;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.component.CustomWizardDialog;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.component.ReferenceTable;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.MockService;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.MockServiceResource;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.wizard.mockresource.ResourceCreationWizard;
import org.wso2.developerstudio.esb.forgm.editors.article.FormArticlePlugin;
import org.wso2.developerstudio.esb.form.editors.article.rcp.AbstractEsbFormPage;

/**
 * Class responsible for maintain the form page of mock service suite.
 */
public class MockServiceFormPage extends AbstractEsbFormPage {

    private String FORM_TITLE = "Mock Service";
    private String BASIC_DATA_SECTION = "Basic Mock Service Details";
    private String MOCKING_ENDPOINT_NAME = "Mocking Endpoint Name:";
    private String SERVICE_PORT = "Service Port:";
    private String SERVICE_CONTEXT = "Service Context:";
    private String SERVICE_RESOURCES = "Mock Service Resources";

    protected ScrolledForm form;
    protected FormToolkit toolkit;

    private Text txtSuiteName;
    private Text txtServicePort;
    private Text txtServiceContext;

    private Section basicDetailSection;
    private Section resourceDetailSection;

    private Button resourceRemoveButton;
    private Button resourceAddButton;
    private Table resourceTable;
    private TableViewer resourceTableViewer;

    private static final String EMPTY_STRING = "";
    private String serviceName = EMPTY_STRING;
    private String servicePort = EMPTY_STRING;
    private String serviceContext = EMPTY_STRING;

    private MockService resourceHolder = new MockService();

    public MockServiceFormPage(FormEditor editor) {
        super(editor, "mockServiceForm", "Mock Service Suite");
        importMockServiceData(editor);
    }

    @Override
    protected void createFormContent(IManagedForm managedForm) {
        form = managedForm.getForm();
        toolkit = managedForm.getToolkit();
        form.setText(FORM_TITLE);
        form.setBackgroundImage(FormArticlePlugin.getDefault().getImage(FormArticlePlugin.IMG_FORM_BG));
        form.getBody().setLayout(new FormLayout());

        createMockBasicDetailSection();
        createMockResourcesSection();
    }

    /**
     * Method of creating mock service basic details section.
     */
    private void createMockBasicDetailSection() {
        FormData data = new FormData();

        basicDetailSection = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.EXPANDED);
        basicDetailSection.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
        basicDetailSection.setToggleColor(toolkit.getColors().getColor(IFormColors.SEPARATOR));
        toolkit.createCompositeSeparator(basicDetailSection);
        basicDetailSection.setText(BASIC_DATA_SECTION);

        Composite basicSectionClient = toolkit.createComposite(basicDetailSection);
        basicSectionClient.setLayout(new FormLayout());

        data.left = new FormAttachment(2);
        data.top = new FormAttachment(2);
        data.right = new FormAttachment(98);
        basicDetailSection.setLayoutData(data);
        basicDetailSection.setClient(basicSectionClient);

        Label lblName = new Label(basicSectionClient, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(10);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        lblName.setLayoutData(data);
        lblName.setText(MOCKING_ENDPOINT_NAME);

        txtSuiteName = new Text(basicSectionClient, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(lblName, 5);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        txtSuiteName.setBackground(new Color(null, 229, 236, 253));
        txtSuiteName.setLayoutData(data);
        if (!getServiceName().isEmpty()) {
            txtSuiteName.setText(getServiceName());
        }

        txtSuiteName.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                changePageState();
                setServiceName(txtSuiteName.getText());
            }
        });

        Label lblServicePort = new Label(basicSectionClient, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(txtSuiteName, 10);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        lblServicePort.setLayoutData(data);
        lblServicePort.setText(SERVICE_PORT);

        txtServicePort = new Text(basicSectionClient, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(lblServicePort, 5);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        txtServicePort.setLayoutData(data);
        txtServicePort.setBackground(new Color(null, 229, 236, 253));
        if (!getServicePort().isEmpty()) {
            txtServicePort.setText(getServicePort());
        }

        txtServicePort.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                changePageState();
                setServicePort(txtServicePort.getText());
            }
        });

        Label lblServiceContext = new Label(basicSectionClient, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(txtServicePort, 10);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        lblServiceContext.setLayoutData(data);
        lblServiceContext.setText(SERVICE_CONTEXT);

        txtServiceContext = new Text(basicSectionClient, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(lblServiceContext, 5);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        txtServiceContext.setLayoutData(data);
        txtServiceContext.setBackground(new Color(null, 229, 236, 253));
        if (!getServiceContext().isEmpty()) {
            txtServiceContext.setText(getServiceContext());
        }

        txtServiceContext.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                changePageState();
                setServiceContext(txtServiceContext.getText());
            }
        });
    }

    /**
     * Method of creating mock service resources section.
     */
    private void createMockResourcesSection() {
        FormData data = new FormData();

        resourceDetailSection = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.EXPANDED);
        resourceDetailSection.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
        resourceDetailSection.setToggleColor(toolkit.getColors().getColor(IFormColors.SEPARATOR));
        toolkit.createCompositeSeparator(resourceDetailSection);
        resourceDetailSection.setText(SERVICE_RESOURCES);

        Composite resourceSectionClient = toolkit.createComposite(resourceDetailSection);
        resourceSectionClient.setLayout(new FormLayout());

        data.left = new FormAttachment(2);
        data.top = new FormAttachment(basicDetailSection, 25);
        data.right = new FormAttachment(98);
        resourceDetailSection.setLayoutData(data);
        resourceDetailSection.setClient(resourceSectionClient);

        // creating mock service resource table
        ReferenceTable referenceTable = new ReferenceTable();
        resourceRemoveButton = referenceTable.createRemoveButton(resourceSectionClient, "", SWT.PUSH);
        resourceAddButton = referenceTable.createAddButton(resourceSectionClient, "", SWT.PUSH);
        resourceTable = referenceTable.createReferenceTable(resourceSectionClient, resourceRemoveButton.getStyle());
        resourceTableViewer = referenceTable.createTableViewer(resourceTable);

        data = new FormData();
        data.top = new FormAttachment(5);
        data.left = new FormAttachment(1);
        resourceAddButton.setLayoutData(data);

        data = new FormData();
        data.top = new FormAttachment(5);
        data.left = new FormAttachment(resourceAddButton, 3);
        resourceRemoveButton.setLayoutData(data);

        data = new FormData();
        data.height = 200;
        data.top = new FormAttachment(resourceRemoveButton, 5);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        resourceTable.setLayoutData(data);
        resourceTable.setLinesVisible(true);
        resourceTable.setHeaderVisible(true);

        TableColumn columnURI = new TableColumn(resourceTable, SWT.CENTER);
        columnURI.setText("URI");

        TableColumn columnSubContext = new TableColumn(resourceTable, SWT.CENTER);
        columnSubContext.setText("Sub Context");

        TableColumn columnMethod = new TableColumn(resourceTable, SWT.CENTER);
        columnMethod.setText("Method");

        // add button, remove button and table listners
        form.addControlListener(new ControlAdapter() {
            public void controlResized(ControlEvent e) {
                Rectangle area = txtServiceContext.getClientArea();
                int width = area.width;
                columnURI.setWidth(width / 3);
                columnSubContext.setWidth(width / 3);
                columnMethod.setWidth(width / 3);
            }
        });

        resourceAddButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                resourceHolder.setMockServiceResourceUpdate(false);

                ResourceCreationWizard wizard = new ResourceCreationWizard(resourceHolder, getServiceContext());
                wizard.init(PlatformUI.getWorkbench(), null);
                CustomWizardDialog resourceWizardDialog = new CustomWizardDialog(form.getShell(), wizard);
                resourceWizardDialog.setHelpAvailable(false);
                resourceWizardDialog.setPageSize(580, 620);
                resourceWizardDialog.open();

                refreshResourceTable();
                changePageState();
            }
        });

        resourceRemoveButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                if (resourceTable.getSelectionIndex() >= 0) {
                    String resourceKey = resourceTable.getItem(resourceTable.getSelectionIndex()).getText(1);
                    resourceHolder.removeMockResource(resourceKey);
                    resourceTable.remove(resourceTable.getSelectionIndices());
                    resourceRemoveButton.setEnabled(false);

                    changePageState();
                }
            }
        });

        resourceTable.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                TableItem selectedItem = (TableItem) event.item;
                if (selectedItem != null && resourceTable.getItemCount() > 1) {
                    resourceTable.setSelection(resourceTable.indexOf(selectedItem));
                    resourceRemoveButton.setEnabled(true);
                } else {
                    resourceRemoveButton.setEnabled(false);
                }
            }
        });

        resourceTableViewer.addDoubleClickListener(new IDoubleClickListener() {
            @Override
            public void doubleClick(DoubleClickEvent event) {
                TableItem tableItem = resourceTable.getSelection()[0];

                if (tableItem != null) {
                    String resourceKey = tableItem.getText(1) + tableItem.getText(2);
                    resourceHolder.setMockServiceResourceUpdate(true);
                    resourceHolder.setSelectedMockResourceKey(resourceKey);

                    ResourceCreationWizard wizard = new ResourceCreationWizard(resourceHolder, getServiceContext());
                    wizard.init(PlatformUI.getWorkbench(), null);
                    CustomUpdateWizardDialog resourceWizardDialog = new CustomUpdateWizardDialog(form.getShell(),
                            wizard);
                    resourceWizardDialog.setHelpAvailable(false);
                    resourceWizardDialog.setPageSize(580, 620);
                    resourceWizardDialog.open();

                    refreshResourceTable();
                    changePageState();
                }
            }
        });

        refreshResourceTable();
    }

    /**
     * Method of importing mock service data from the selected file.
     * 
     * @param editor
     *            ESB editor currently using
     */
    private void importMockServiceData(FormEditor editor) {
        IFile mockFile = ((FileEditorInput) editor.getEditorInput()).getFile();
        MockServiceSourceToFormDeserializer.generateFormView(this, mockFile, true);
    }

    /**
     * Method of refreshing mock resources table.
     */
    public void refreshResourceTable() {
        resourceTable.removeAll();

        for (Map.Entry<String, MockServiceResource> resource : resourceHolder.getMockResources().entrySet()) {
            TableItem item = new TableItem(resourceTable, SWT.NONE);
            String subContext = resource.getValue().getSubContext();
            String enteredUrl = "http://localhost:" + getServicePort() + getServiceContext() + subContext;
            item.setText(0, enteredUrl);
            item.setText(1, subContext);
            item.setText(2, resource.getValue().getMethod());
        }
    }

    /**
     * Method of reloading form page.
     */
    public void reloadFormPage() {
        if (getServiceName() != null && !getServiceName().isEmpty()) {
            txtSuiteName.setText(getServiceName());
        }

        if (getServicePort() != null && !getServicePort().isEmpty()) {
            txtServicePort.setText(getServicePort());
        }

        if (getServiceContext() != null && !getServiceContext().isEmpty()) {
            txtServiceContext.setText(getServiceContext());
        }

        refreshResourceTable();
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

    public MockService getResourceDataHolder() {
        return this.resourceHolder;
    }

    private void changePageState() {
        setSave(true);
        updateDirtyState();
    }

}

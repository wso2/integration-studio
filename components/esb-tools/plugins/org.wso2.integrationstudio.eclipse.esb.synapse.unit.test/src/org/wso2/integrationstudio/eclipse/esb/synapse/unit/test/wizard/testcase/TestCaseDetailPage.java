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
package org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.wizard.testcase;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.text.WordUtils;
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
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.Assertion;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.InputProperty;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.SynapseUnitTest;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.TestCase;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.utils.ComboItems;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.utils.CommonUtil;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.wizard.assertion.AssertionCreationWizard;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.wizard.inputproperty.InputPropertyCreationWizard;

/**
 * Class responsible for creation of wizard page for test cases.
 */
public class TestCaseDetailPage extends WizardPage {

    private static final String DIALOG_TITLE = "Add Input Payload, Properties and Assertion Details";
    private static final String INPUT_SECTION_TITLE = "Input Payload and Properties";
    private static final String ASSERTION_SECTION_TITLE = "Assertions";
    private static final String INPUT_PAYLOAD = "Input Payload:";
    private static final String INPUT_PROPERTIES = "Input Properties:";
    private static final String RESOURCE_PATH = "Resource Path:";
    private static final String TESTCASE_NAME = "Test Case Name:";
    private static final String RESOURCE_METHOD = "Resource Method:";
    private static final String EMPTY_STRING = "";
    private static final String PATH_PREFIX = "/";

    private Section inputAndPropertiesSection;
    private Section assertionSection;
    private FormToolkit toolkit;
    private Text txtApiRequestPath;
    private Text txtTestCaseName;
    private StyledText styledTextInputPayload;
    private Button propertyRemoveButton;
    private Button assertionRemoveButton;
    private Button propertyAddButton;
    private Button assertionAddButton;
    private Table propertyTable;
    private Table assertionTable;
    private TableViewer propertyTableViewer;
    private TableViewer assertionTableViewer;

    private String resourcePath = EMPTY_STRING;
    private String resourceMethod = EMPTY_STRING;
    private String inputPayload = EMPTY_STRING;
    private String testArtifactType = EMPTY_STRING;
    private String testCaseName = EMPTY_STRING;

    private SynapseUnitTest synapseTestDataHolder;
    private boolean isPageDirty;
    private int testCaseKey;
    private TestCase selectedTestCase;

    /**
     * Class constructor.
     */
    protected TestCaseDetailPage(IWorkbench wb, IStructuredSelection selection, SynapseUnitTest synapseTestData) {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);
        setDescription("Enter input and assertion details which you want to test");
        this.synapseTestDataHolder = synapseTestData;
        this.testArtifactType = synapseTestDataHolder.getTestArtifactType();

        // check page loading for update status
        if (synapseTestData.isTestCaseUpdate()) {
            testCaseKey = synapseTestDataHolder.getSelectedTestCaseKey();
            selectedTestCase = synapseTestDataHolder.getSelectedTestCase(testCaseKey);
            fillUpdatingTestCaseData();
        }
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        setControl(container);
        container.setLayout(new FormLayout());
        toolkit = new FormToolkit(parent.getDisplay());

        FormData data = new FormData();
        Label lblTestCaseName = new Label(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(2);
        data.left = new FormAttachment(3);
        data.width = 175;
        lblTestCaseName.setLayoutData(data);
        lblTestCaseName.setText(TESTCASE_NAME);

        txtTestCaseName = new Text(container, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(2);
        data.left = new FormAttachment(lblTestCaseName, 0);
        data.right = new FormAttachment(96);
        data.width = 400;
        txtTestCaseName.setLayoutData(data);
        if (getTestCaseName() != null && !getTestCaseName().isEmpty()) {
            txtTestCaseName.setText(getTestCaseName());
        }

        txtTestCaseName.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setTestCaseName(txtTestCaseName.getText());
                validate();
            }
        });

        createInputAndPropertiesSection(container);
        createAssertionSection(container);

        validate();
    }

    /**
     * Method for create test case input section in the wizard page.
     * 
     * @param container
     *            Composite layout
     */
    private void createInputAndPropertiesSection(Composite container) {
        FormData data = new FormData();

        inputAndPropertiesSection = toolkit.createSection(container, Section.TWISTIE | Section.EXPANDED);
        toolkit.createCompositeSeparator(inputAndPropertiesSection);
        inputAndPropertiesSection.setText(INPUT_SECTION_TITLE);

        Composite inputSectionClient = toolkit.createComposite(inputAndPropertiesSection);
        inputSectionClient.setLayout(new FormLayout());

        data.left = new FormAttachment(2);
        data.top = new FormAttachment(8);
        data.right = new FormAttachment(98);
        inputAndPropertiesSection.setLayoutData(data);
        inputAndPropertiesSection.setClient(inputSectionClient);

        Group grpInputData = new Group(inputSectionClient, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(inputAndPropertiesSection, 5);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        grpInputData.setLayoutData(data);
        grpInputData.setLayout(new FormLayout());

        if (synapseTestDataHolder.getTestArtifactType().equals(Constants.API_ARTIFACT)) {
            createApiResourceSection(grpInputData);
        }

        Label lblInputPayload = new Label(grpInputData, SWT.NONE);
        data = new FormData();
        if (synapseTestDataHolder.getTestArtifactType().equals(Constants.API_ARTIFACT)) {
            data.top = new FormAttachment(20);
        } else {
            data.top = new FormAttachment(2);
        }

        data.left = new FormAttachment(1);
        data.width = 160;
        lblInputPayload.setLayoutData(data);
        lblInputPayload.setText(INPUT_PAYLOAD);

        SyntaxHighlightTextBox syntaxStyler = new SyntaxHighlightTextBox();
        styledTextInputPayload = syntaxStyler.getStyledTextBox(grpInputData);
        data = new FormData();
        if (synapseTestDataHolder.getTestArtifactType().equals(Constants.API_ARTIFACT)) {
            data.top = new FormAttachment(20);
        } else {
            data.top = new FormAttachment(2);
        }
        data.left = new FormAttachment(lblInputPayload, 0);
        data.right = new FormAttachment(99);
        data.width = 400;
        data.height = 100;
        styledTextInputPayload.setLayoutData(data);
        if (getInputPayload() != null && !getInputPayload().isEmpty()) {
            styledTextInputPayload.setText(CommonUtil.removeCDATAFromPayload(getInputPayload()));
            syntaxStyler.chooseSyntaxHighlighter(styledTextInputPayload.getText(), false);
        }

        styledTextInputPayload.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setInputPayload(styledTextInputPayload.getText());
                syntaxStyler.chooseSyntaxHighlighter(styledTextInputPayload.getText(), false);
                validate();
            }
        });

        Label lblAddProperties = new Label(grpInputData, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(styledTextInputPayload, 12);
        data.left = new FormAttachment(1);
        lblAddProperties.setLayoutData(data);
        lblAddProperties.setText(INPUT_PROPERTIES);

        ReferenceTable referenceTable = new ReferenceTable();
        propertyRemoveButton = referenceTable.createRemoveButton(grpInputData, EMPTY_STRING, SWT.PUSH);
        propertyAddButton = referenceTable.createAddButton(grpInputData, EMPTY_STRING, SWT.PUSH);
        propertyTable = referenceTable.createReferenceTable(grpInputData, propertyRemoveButton.getStyle());
        propertyTableViewer = referenceTable.createTableViewer(propertyTable);

        data = new FormData();
        data.top = new FormAttachment(lblAddProperties, -2);
        data.right = new FormAttachment(99);
        propertyRemoveButton.setLayoutData(data);

        data = new FormData();
        data = new FormData();
        data.top = new FormAttachment(lblAddProperties, -2);
        data.right = new FormAttachment(propertyRemoveButton, -3);
        propertyAddButton.setLayoutData(data);

        data = new FormData();
        data.height = 100;
        data.top = new FormAttachment(propertyRemoveButton, 5);
        data.left = new FormAttachment(1);
        data.bottom = new FormAttachment(98);
        data.right = new FormAttachment(99);
        propertyTable.setLayoutData(data);
        propertyTable.setLinesVisible(true);
        propertyTable.setHeaderVisible(true);

        TableColumn columnScope = new TableColumn(propertyTable, SWT.CENTER);
        columnScope.setText("Scope");

        TableColumn columnName = new TableColumn(propertyTable, SWT.CENTER);
        columnName.setText("Name");

        TableColumn columnValue = new TableColumn(propertyTable, SWT.CENTER);
        columnValue.setText("Value");

        grpInputData.addControlListener(new ControlAdapter() {
            public void controlResized(ControlEvent e) {
                Rectangle area = grpInputData.getClientArea();
                int width = area.width;
                columnScope.setWidth(width / 3);
                columnName.setWidth(width / 3);
                columnValue.setWidth(width / 3);
            }
        });

        propertyAddButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                synapseTestDataHolder.setPropertyUpdate(false);

                InputPropertyCreationWizard wizard = new InputPropertyCreationWizard(synapseTestDataHolder);
                wizard.init(PlatformUI.getWorkbench(), null);
                CustomWizardDialog inputPropertyWizardDialog = new CustomWizardDialog(getShell(), wizard);
                inputPropertyWizardDialog.setHelpAvailable(false);
                inputPropertyWizardDialog.setPageSize(580, 120);
                inputPropertyWizardDialog.open();

                refreshPropertyTable();
            }
        });

        propertyRemoveButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                if (propertyTable.getSelectionIndex() >= 0) {
                    String propertyKey = propertyTable.getItem(propertyTable.getSelectionIndex()).getText(1);

                    if (selectedTestCase != null && selectedTestCase.getPropertyMap().containsKey(propertyKey)) {
                        selectedTestCase.removeSelectedProperty(propertyKey);
                    } else if (synapseTestDataHolder.getTemporaryPropertyMap().containsKey(propertyKey)) {
                        synapseTestDataHolder.removeSelectedTemporalProperty(propertyKey);
                    }

                    propertyTable.remove(propertyTable.getSelectionIndices());
                    propertyRemoveButton.setEnabled(false);
                }
            }
        });

        propertyTableViewer.addDoubleClickListener(new IDoubleClickListener() {
            @Override
            public void doubleClick(DoubleClickEvent event) {
                TableItem tableItem = propertyTable.getSelection()[0];
                if (tableItem != null) {
                    String propertyKey = tableItem.getText(1);

                    synapseTestDataHolder.setPropertyUpdate(true);
                    synapseTestDataHolder.setSelectedPropertyKey(propertyKey);
                    InputPropertyCreationWizard wizard = new InputPropertyCreationWizard(synapseTestDataHolder);
                    wizard.init(PlatformUI.getWorkbench(), null);
                    CustomUpdateWizardDialog inputPropertyWizardDialog = new CustomUpdateWizardDialog(getShell(),
                            wizard);
                    inputPropertyWizardDialog.setHelpAvailable(false);
                    inputPropertyWizardDialog.setPageSize(580, 120);
                    inputPropertyWizardDialog.open();

                    refreshPropertyTable();
                }
            }
        });

        propertyTable.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                TableItem selectedItem = (TableItem) event.item;
                if (selectedItem != null) {
                    propertyTable.setSelection(propertyTable.indexOf(selectedItem));
                    propertyRemoveButton.setEnabled(true);
                } else {
                    propertyRemoveButton.setEnabled(false);
                }
            }
        });
    }

    /**
     * Method for create API path/method phase in input section in the wizard page.
     * 
     * @param grpInputData
     *            layout
     */
    private void createApiResourceSection(Group grpInputData) {
        FormData data = new FormData();
        Label lblRequestPathName = new Label(grpInputData, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(1);
        data.left = new FormAttachment(1);
        data.width = 160;
        lblRequestPathName.setLayoutData(data);
        lblRequestPathName.setText(RESOURCE_PATH);

        txtApiRequestPath = new Text(grpInputData, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(1);
        data.left = new FormAttachment(lblRequestPathName, 0);
        data.right = new FormAttachment(99);
        data.width = 400;
        txtApiRequestPath.setLayoutData(data);
        if (getResourcePath() != null && !getResourcePath().isEmpty()) {
            txtApiRequestPath.setText(getResourcePath());
        }

        txtApiRequestPath.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setResourcePath(txtApiRequestPath.getText());
                validate();
            }
        });

        Label lblRequestMethod = new Label(grpInputData, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblRequestPathName, 12);
        data.left = new FormAttachment(1);
        data.width = 160;
        lblRequestMethod.setLayoutData(data);
        lblRequestMethod.setText(RESOURCE_METHOD);

        final Combo combo = new Combo(grpInputData, SWT.READ_ONLY | SWT.DROP_DOWN);
        data = new FormData();
        data.top = new FormAttachment(lblRequestPathName, 12);
        data.left = new FormAttachment(lblRequestMethod, 0);
        data.right = new FormAttachment(99);
        data.width = 400;
        combo.setItems(ComboItems.getRestTypes());
        combo.setLayoutData(data);
        if (getResourceMethod() != null && !getResourceMethod().isEmpty()) {
            combo.setText(getResourceMethod());
        } else {
            setResourceMethod(ComboItems.getRestTypes()[0]);
            combo.setText(ComboItems.getRestTypes()[0]);
        }

        combo.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                setResourceMethod(combo.getText());
                validate();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
    }

    /**
     * Method for create assertion section in the wizard page.
     * 
     * @param container
     *            layout
     */
    private void createAssertionSection(Composite container) {
        FormData data = new FormData();

        assertionSection = toolkit.createSection(container, Section.TWISTIE | Section.EXPANDED);
        toolkit.createCompositeSeparator(assertionSection);
        assertionSection.setText(ASSERTION_SECTION_TITLE);

        Composite inputSectionClient = toolkit.createComposite(assertionSection);
        inputSectionClient.setLayout(new FormLayout());

        data.left = new FormAttachment(2);
        data.top = new FormAttachment(inputAndPropertiesSection, 10);
        data.right = new FormAttachment(98);
        data.height = 220;
        assertionSection.setLayoutData(data);
        assertionSection.setClient(inputSectionClient);

        Group grpAssertionData = new Group(inputSectionClient, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(assertionSection, 5);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        grpAssertionData.setLayoutData(data);
        grpAssertionData.setLayout(new FormLayout());

        ReferenceTable referenceTable = new ReferenceTable();
        assertionRemoveButton = referenceTable.createRemoveButton(grpAssertionData, EMPTY_STRING, SWT.PUSH);
        assertionAddButton = referenceTable.createAddButton(grpAssertionData, EMPTY_STRING, SWT.PUSH);
        assertionTable = referenceTable.createReferenceTable(grpAssertionData, assertionRemoveButton.getStyle());
        assertionTableViewer = referenceTable.createTableViewer(assertionTable);

        data = new FormData();
        data.top = new FormAttachment(grpAssertionData, 5);
        data.right = new FormAttachment(99);
        assertionRemoveButton.setLayoutData(data);

        data = new FormData();
        data = new FormData();
        data.top = new FormAttachment(grpAssertionData, 5);
        data.right = new FormAttachment(assertionRemoveButton, -3);
        assertionAddButton.setLayoutData(data);

        data = new FormData();
        data.height = 100;
        data.top = new FormAttachment(assertionRemoveButton, 5);
        data.left = new FormAttachment(1);
        data.bottom = new FormAttachment(96);
        data.right = new FormAttachment(99);
        assertionTable.setLayoutData(data);
        assertionTable.setLinesVisible(true);
        assertionTable.setHeaderVisible(true);

        TableColumn columnAssertType = new TableColumn(assertionTable, SWT.CENTER);
        columnAssertType.setText("Assertion Type");

        TableColumn columnAssertProperty = new TableColumn(assertionTable, SWT.CENTER);
        columnAssertProperty.setText("Assert Property");

        grpAssertionData.addControlListener(new ControlAdapter() {
            public void controlResized(ControlEvent e) {
                Rectangle area = grpAssertionData.getClientArea();
                int width = area.width;
                columnAssertType.setWidth(width / 2);
                columnAssertProperty.setWidth(width / 2);
            }
        });

        assertionAddButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                synapseTestDataHolder.setAssertionUpdate(false);

                AssertionCreationWizard wizard = new AssertionCreationWizard(synapseTestDataHolder);
                wizard.init(PlatformUI.getWorkbench(), null);
                CustomWizardDialog assertionWizardDialog = new CustomWizardDialog(getShell(), wizard);
                assertionWizardDialog.setHelpAvailable(false);
                assertionWizardDialog.setPageSize(580, 320);
                assertionWizardDialog.open();

                refreshAssertionTable();
                validate();
            }
        });

        assertionRemoveButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                String assertKey = null;
                String assertType = null;

                if (assertionTable.getSelectionIndex() >= 0) {
                    assertKey = assertionTable.getItem(assertionTable.getSelectionIndex()).getText(1);
                    assertType = assertionTable.getItem(assertionTable.getSelectionIndex()).getText(0);
                }

                String storeAssertKey = assertType + "-" + assertKey;
                if (selectedTestCase != null && selectedTestCase.getAssertions().containsKey(storeAssertKey)) {
                    selectedTestCase.removeSelectedAssertion(storeAssertKey);
                } else if (synapseTestDataHolder.getTemporaryAssertions().containsKey(storeAssertKey)) {
                    synapseTestDataHolder.removeSelectedTemporalAssertion(storeAssertKey);
                }
                assertionTable.remove(assertionTable.getSelectionIndices());
                assertionRemoveButton.setEnabled(false);
                validate();
            }
        });

        assertionTable.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                TableItem selectedItem = (TableItem) event.item;
                if (selectedItem != null) {
                    assertionTable.setSelection(assertionTable.indexOf(selectedItem));
                    assertionRemoveButton.setEnabled(true);
                } else {
                    assertionRemoveButton.setEnabled(false);
                }
            }
        });

        assertionTableViewer.addDoubleClickListener(new IDoubleClickListener() {
            @Override
            public void doubleClick(DoubleClickEvent event) {
                TableItem tableItem = assertionTable.getSelection()[0];

                if (tableItem != null) {
                    String assertionType = tableItem.getText(0);
                    String assertionKey = tableItem.getText(1);

                    String storeAssertKey = assertionType + "-" + assertionKey;
                    synapseTestDataHolder.setAssertionUpdate(true);
                    synapseTestDataHolder.setSelectedAssertionKey(storeAssertKey);

                    AssertionCreationWizard wizard = new AssertionCreationWizard(synapseTestDataHolder);
                    wizard.init(PlatformUI.getWorkbench(), null);
                    CustomUpdateWizardDialog assertionWizardDialog = new CustomUpdateWizardDialog(getShell(), wizard);
                    assertionWizardDialog.setHelpAvailable(false);
                    assertionWizardDialog.setPageSize(580, 320);
                    assertionWizardDialog.open();

                    refreshAssertionTable();
                    validate();
                }
            }
        });

        refreshPropertyTable();
        refreshAssertionTable();
    }

    /**
     * Method for validations of wizard page. If validation fails set page as dirty
     * and not complete
     */
    private void validate() {
        if (getTestCaseName() == null || getTestCaseName().isEmpty()) {
            setErrorMessage("Please specify a name for the test case");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (getTestCaseName().contains(Constants.SPACE_STRING)) {
            setErrorMessage("Please specify a name for the test case without whitespaces");
            setPageComplete(false);
            return;
        } else if (testArtifactType.equals(Constants.API_ARTIFACT)
                && (getResourcePath() == null || getResourcePath().isEmpty())) {
            setErrorMessage("Please specify a resource invoking path for the API");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (testArtifactType.equals(Constants.API_ARTIFACT)
                && (getResourceMethod() == null || getResourceMethod().isEmpty())) {
            setErrorMessage("Please specify a resource invoking method for the API");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (testArtifactType.equals(Constants.API_ARTIFACT) && !getResourcePath().startsWith(PATH_PREFIX)) {
            setResourcePath(PATH_PREFIX + getResourcePath());
        } else {
            int temporaryAssertMapSize = synapseTestDataHolder.getTemporaryAssertions().size();
            int existAssertMapSize = 0;
            if (synapseTestDataHolder.isTestCaseUpdate()) {
                int testCaseKey = synapseTestDataHolder.getSelectedTestCaseKey();
                TestCase selectedTestCase = synapseTestDataHolder.getSelectedTestCase(testCaseKey);
                existAssertMapSize = selectedTestCase.getAssertions().size();
            }
            if (temporaryAssertMapSize == 0 && existAssertMapSize == 0) {
                setErrorMessage("Please add atleast one Assertion to complete this test case");
                setPageComplete(false);
                setPageDirty(true);
                return;
            }
        }

        setPageDirty(false);
        setErrorMessage(null);
        setPageComplete(true);
    }

    /**
     * Method for filling updating data to wizard page.
     */
    private void fillUpdatingTestCaseData() {
        setTestCaseName(selectedTestCase.getTestCaseName());
        setResourcePath(selectedTestCase.getRequestPath());
        setResourceMethod(selectedTestCase.getRequestMethod());
        setInputPayload(selectedTestCase.getInputPayload());
    }

    /**
     * Method for refreshing property table in wizard page.
     */
    private void refreshPropertyTable() {
        propertyTable.removeAll();

        LinkedHashMap<String, InputProperty> existsProperties = new LinkedHashMap<>();
        if (synapseTestDataHolder.isTestCaseUpdate()) {
            existsProperties = synapseTestDataHolder.getSelectedTestCase(testCaseKey).getPropertyMap();
        }

        for (Map.Entry<String, InputProperty> entry : existsProperties.entrySet()) {
            TableItem item = new TableItem(propertyTable, SWT.NONE);
            item.setText(0, WordUtils.capitalizeFully(entry.getValue().getScope()));
            item.setText(1, entry.getValue().getName());
            item.setText(2, entry.getValue().getValue());
        }

        for (Map.Entry<String, InputProperty> entry : synapseTestDataHolder.getTemporaryPropertyMap().entrySet()) {
            TableItem item = new TableItem(propertyTable, SWT.NONE);
            item.setText(0, WordUtils.capitalizeFully(entry.getValue().getScope()));
            item.setText(1, entry.getValue().getName());
            item.setText(2, entry.getValue().getValue());
        }
    }

    /**
     * Method for refreshing assertion table in wizard page.
     */
    private void refreshAssertionTable() {
        assertionTable.removeAll();

        LinkedHashMap<String, Assertion> existsAssertions = new LinkedHashMap<>();
        if (synapseTestDataHolder.isTestCaseUpdate()) {
            existsAssertions = synapseTestDataHolder.getSelectedTestCase(testCaseKey).getAssertions();
        }

        for (Map.Entry<String, Assertion> entry : existsAssertions.entrySet()) {
            TableItem item = new TableItem(assertionTable, SWT.NONE);
            item.setText(0, entry.getValue().getAssertType());
            item.setText(1, entry.getValue().getActual());
        }

        for (Map.Entry<String, Assertion> entry : synapseTestDataHolder.getTemporaryAssertions().entrySet()) {
            TableItem item = new TableItem(assertionTable, SWT.NONE);
            item.setText(0, entry.getValue().getAssertType());
            item.setText(1, entry.getValue().getActual());
        }
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getResourceMethod() {
        return resourceMethod;
    }

    public void setResourceMethod(String resourceMethod) {
        this.resourceMethod = resourceMethod;
    }

    public String getInputPayload() {
        return inputPayload;
    }

    public void setInputPayload(String inputPayload) {
        this.inputPayload = inputPayload;
    }

    public boolean isPageDirty() {
        return isPageDirty;
    }

    public void setPageDirty(boolean isPageDirty) {
        this.isPageDirty = isPageDirty;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }
}

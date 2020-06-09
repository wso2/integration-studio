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
package org.wso2.developerstudio.esb.form.editors.unittest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
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
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.component.DependencyTree;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.Assertion;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.SynapseUnitTest;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.TestCase;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.wizard.mockservice.MockServiceSuiteCreationWizard;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.wizard.testcase.TestCaseCreationWizard;
import org.wso2.developerstudio.esb.forgm.editors.article.FormArticlePlugin;
import org.wso2.developerstudio.esb.form.editors.article.rcp.AbstractEsbFormPage;
import org.wso2.developerstudio.esb.form.editors.unittest.commons.Constants;

/**
 * Class responsible for maintain the form page of unit test suite.
 */
public class SynapseUnitTestFormPage extends AbstractEsbFormPage {

    private String FORM_TITLE = "Unit Test Suite";
    private String SUPPORTIVE_ARTIFACT_SECTION_TITLE = "Supportive Artifacts Details";
    private String TEST_CASES_SECTION_TITLE = "Test Artifact, Test Cases and Assertion Details";
    private String MOCK_SERVICE_SECTION_TITLE = "Mock Service Details";
    private String SUPPORTIVE_ARTIFACTS_TYPE = "SUPPORTIVE_ARTIFACTS";
    private String MOCK_SERVICE_TYPE = "MOCK_SERVICE";
    private String SUPPORTIVE_ARTIFACTS_FILES = "Supportive Artifact Files:";
    private String MOCK_SERVICE_FILES = "Mock Service Files:";
    private String SUPPORTIVE_ARTIFACTS = "Supportive Artifacts";
    private String MOCK_SERVICES = "Mock Services";

    SynapseUnitTest unitTestDataHolder = new SynapseUnitTest();
    private DependencyTree resourceTree;
    private DependencyTree mockServiceTree;

    private IProject currentProject;
    protected ScrolledForm form;
    protected FormToolkit toolkit;

    private Section artifactsDetailSection;
    private Section testCasesDetailSection;
    private Section mockServicesDetailSection;

    private Text txtTestArtifactFile;
    private String testArtifactPath;

    private Button removeTestCaseButton;
    private Button addTestCaseButton;
    private Button addMockServiceButton;
    private Button refreshMockServicesButton;
    private Table testCaseTable;
    private TableViewer testCaseTableViewer;

    private Tree trDependencies;
    private Tree trServiceDependencies;
    private ReferenceTable referenceTable;

    public SynapseUnitTestFormPage(FormEditor editor) {
        super(editor, "synapseUnitTestForm", "Unit Test Suite");
        importSynapseUnitTestData(editor);
    }

    @Override
    protected void createFormContent(IManagedForm managedForm) {
        form = managedForm.getForm();
        toolkit = managedForm.getToolkit();
        form.setText(FORM_TITLE);
        form.setBackgroundImage(FormArticlePlugin.getDefault().getImage(FormArticlePlugin.IMG_FORM_BG));
        Composite body = form.getBody();
        body.setLayout(new FormLayout());

        // Add page refresh button
        referenceTable = new ReferenceTable();
        refreshMockServicesButton = referenceTable.createRefreshButton(body, "", SWT.PUSH);
        FormData data = new FormData();
        data.top = new FormAttachment(2);
        data.right = new FormAttachment(97);
        refreshMockServicesButton.setLayoutData(data);

        refreshMockServicesButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                refreshAction();
            }
        });
        
        createTestCasesSection();
        createArtifactsSection();
        createMockServicesSection();

        // Test cases, supportive artifacts and mock services table boxes width listner
        form.addControlListener(new ControlAdapter() {
            public void controlResized(ControlEvent e) {
                Rectangle area = txtTestArtifactFile.getClientArea();
                int width = area.width - 35;

                TableColumn[] testColumns = testCaseTable.getColumns();
                testColumns[0].setWidth(width);

                TreeColumn[] artifactsColumns = trDependencies.getColumns();
                artifactsColumns[0].setWidth(width / 3);
                artifactsColumns[1].setWidth(width * 2 / 3);

                TreeColumn[] mockColumns = trServiceDependencies.getColumns();
                mockColumns[0].setWidth(width / 3);
                mockColumns[1].setWidth(width * 2 / 3);
            }
        });
    }

    /**
     * Method of creating supportive artifact section.
     */
    private void createArtifactsSection() {
        FormData data = new FormData();

        artifactsDetailSection = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.EXPANDED);
        artifactsDetailSection.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
        artifactsDetailSection.setToggleColor(toolkit.getColors().getColor(IFormColors.SEPARATOR));
        toolkit.createCompositeSeparator(artifactsDetailSection);
        artifactsDetailSection.setText(SUPPORTIVE_ARTIFACT_SECTION_TITLE);

        Composite artifactSectionClient = toolkit.createComposite(artifactsDetailSection);
        artifactSectionClient.setLayout(new FormLayout());
        data.left = new FormAttachment(2);
        data.top = new FormAttachment(testCasesDetailSection, 20);
        data.right = new FormAttachment(98);
        artifactsDetailSection.setLayoutData(data);
        artifactsDetailSection.setClient(artifactSectionClient);

        Label supportiveArtifactlblName = new Label(artifactSectionClient, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(artifactSectionClient, 7);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        supportiveArtifactlblName.setLayoutData(data);
        supportiveArtifactlblName.setText(SUPPORTIVE_ARTIFACTS_FILES);

        resourceTree = new DependencyTree(unitTestDataHolder, null, SUPPORTIVE_ARTIFACTS_TYPE);
        trDependencies = resourceTree.createResourcesTree(artifactSectionClient, SUPPORTIVE_ARTIFACTS);
        resourceTree.setCheckedElemets(unitTestDataHolder.getSupportiveArtifacts());
        resourceTree.setRegistryCheckedElemets(unitTestDataHolder.getRegistryResource());
        resourceTree.setConnectorCheckedElemets(unitTestDataHolder.getConnectorFiles());
        data = new FormData();
        data.top = new FormAttachment(supportiveArtifactlblName, 10);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        data.height = 200;
        trDependencies.setLayoutData(data);

        // resource tree listner
        trDependencies.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent evt) {
                final TreeItem item = (TreeItem) evt.item;
                if (evt.detail == SWT.CHECK && item != null) {
                    setSave(true);
                    updateDirtyState();
                    resourceTree.handleTreeItemChecked(item);
                }
            }

            public void widgetDefaultSelected(SelectionEvent evt) {

            }
        });

        artifactsDetailSection.setExpanded(false);
    }

    /**
     * Method of creating test case section.
     */
    private void createTestCasesSection() {
        FormData data = new FormData();

        testCasesDetailSection = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.EXPANDED);
        testCasesDetailSection.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
        testCasesDetailSection.setToggleColor(toolkit.getColors().getColor(IFormColors.SEPARATOR));
        toolkit.createCompositeSeparator(testCasesDetailSection);
        testCasesDetailSection.setText(TEST_CASES_SECTION_TITLE);

        Composite testCaseSectionClient = toolkit.createComposite(testCasesDetailSection);
        testCaseSectionClient.setLayout(new FormLayout());
        data.left = new FormAttachment(2);
        data.top = new FormAttachment(2);
        data.right = new FormAttachment(98);
        testCasesDetailSection.setLayoutData(data);
        testCasesDetailSection.setClient(testCaseSectionClient);

        Label testArtifactlblName = new Label(testCaseSectionClient, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(2);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        testArtifactlblName.setLayoutData(data);
        testArtifactlblName.setText("Test Artifact File:");

        txtTestArtifactFile = new Text(testCaseSectionClient, SWT.BORDER | SWT.READ_ONLY);
        data = new FormData();
        data.top = new FormAttachment(testArtifactlblName, 5);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        txtTestArtifactFile.setBackground(new Color(null, 229, 236, 253));
        txtTestArtifactFile.setLayoutData(data);
        if (!unitTestDataHolder.getTestArtifact().isEmpty()) {
            txtTestArtifactFile.setText(unitTestDataHolder.getTestArtifact());
        }
        setTestArtifactPath(txtTestArtifactFile.getText());

        txtTestArtifactFile.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                changePageState();
                setTestArtifactPath(txtTestArtifactFile.getText());
            }
        });

        ReferenceTable referenceTable = new ReferenceTable();
        removeTestCaseButton = referenceTable.createRemoveButton(testCaseSectionClient, "", SWT.PUSH);
        addTestCaseButton = referenceTable.createAddButton(testCaseSectionClient, "", SWT.PUSH);
        testCaseTable = referenceTable.createReferenceTable(testCaseSectionClient, removeTestCaseButton.getStyle());
        testCaseTableViewer = referenceTable.createTableViewer(testCaseTable);
        testCaseTable.setLinesVisible(false);

        data = new FormData();
        data = new FormData();
        data.top = new FormAttachment(txtTestArtifactFile, 10);
        data.left = new FormAttachment(1);
        addTestCaseButton.setLayoutData(data);

        data = new FormData();
        data.top = new FormAttachment(txtTestArtifactFile, 10);
        data.left = new FormAttachment(addTestCaseButton, 3);
        removeTestCaseButton.setLayoutData(data);

        data = new FormData();
        data.height = 200;
        data.top = new FormAttachment(removeTestCaseButton, 5);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        testCaseTable.setLayoutData(data);
        testCaseTable.setLinesVisible(true);
        testCaseTable.setHeaderVisible(true);

        TableColumn column = new TableColumn(testCaseTable, SWT.LEFT);
        column.setText("Test Case Details");

        addTestCaseButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                unitTestDataHolder.setTestCaseUpdate(false);
                TestCaseCreationWizard wizard = new TestCaseCreationWizard(unitTestDataHolder);
                wizard.init(PlatformUI.getWorkbench(), null);
                CustomWizardDialog unitTestWizardDialog = new CustomWizardDialog(form.getShell(), wizard);
                unitTestWizardDialog.setHelpAvailable(false);
                unitTestWizardDialog.open();

                refreshTestCasesTable();
            }
        });

        removeTestCaseButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                int tableIndex = testCaseTable.getSelectionIndex();
                int testCaseCode = unitTestDataHolder.getTestCaseCodeFromTableMapping(tableIndex);

                unitTestDataHolder.removeSelectedTestCase(testCaseCode);
                testCaseTable.remove(testCaseTable.getSelectionIndices());
                removeTestCaseButton.setEnabled(false);

                changePageState();
            }
        });

        testCaseTable.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                TableItem selectedItem = (TableItem) event.item;
                if (selectedItem != null) {
                    testCaseTable.setSelection(testCaseTable.indexOf(selectedItem));
                    removeTestCaseButton.setEnabled(true);
                } else {
                    removeTestCaseButton.setEnabled(false);
                }
            }
        });

        testCaseTableViewer.addDoubleClickListener(new IDoubleClickListener() {
            @Override
            public void doubleClick(DoubleClickEvent event) {
                int tableIndex = testCaseTable.getSelectionIndex();
                int testCaseCode = unitTestDataHolder.getTestCaseCodeFromTableMapping(tableIndex);

                unitTestDataHolder.setTestCaseUpdate(true);
                unitTestDataHolder.setSelectedTestCaseKey(testCaseCode);

                TestCaseCreationWizard wizard = new TestCaseCreationWizard(unitTestDataHolder);
                wizard.init(PlatformUI.getWorkbench(), null);
                CustomUpdateWizardDialog testCaseWizardDialog = new CustomUpdateWizardDialog(form.getShell(), wizard);
                testCaseWizardDialog.setHelpAvailable(false);
                testCaseWizardDialog.open();

                refreshTestCasesTable();
            }
        });

        refreshTestCasesTable();
    }

    /**
     * Method of creating mock service section.
     */
    private void createMockServicesSection() {
        FormData data = new FormData();

        mockServicesDetailSection = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.EXPANDED);
        mockServicesDetailSection.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
        mockServicesDetailSection.setToggleColor(toolkit.getColors().getColor(IFormColors.SEPARATOR));
        toolkit.createCompositeSeparator(mockServicesDetailSection);
        mockServicesDetailSection.setText(MOCK_SERVICE_SECTION_TITLE);

        Composite mockServicesSectionClient = toolkit.createComposite(mockServicesDetailSection);
        mockServicesSectionClient.setLayout(new FormLayout());
        data.left = new FormAttachment(2);
        data.top = new FormAttachment(artifactsDetailSection, 15);
        data.right = new FormAttachment(98);
        mockServicesDetailSection.setLayoutData(data);
        mockServicesDetailSection.setClient(mockServicesSectionClient);

        Label mockServiceslblName = new Label(mockServicesSectionClient, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(mockServicesDetailSection, 10);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        mockServiceslblName.setLayoutData(data);
        mockServiceslblName.setText(MOCK_SERVICE_FILES);

        addMockServiceButton = referenceTable.createAddButton(mockServicesSectionClient, "", SWT.PUSH);
        data = new FormData();
        data = new FormData();
        data.top = new FormAttachment(mockServiceslblName, 5);
        data.left = new FormAttachment(1);
        addMockServiceButton.setLayoutData(data);

        mockServiceTree = new DependencyTree(unitTestDataHolder, null, MOCK_SERVICE_TYPE);
        trServiceDependencies = mockServiceTree.createResourcesTree(mockServicesSectionClient, MOCK_SERVICES);
        mockServiceTree.setCheckedElemets(unitTestDataHolder.getMockServices());
        data = new FormData();
        data.top = new FormAttachment(addMockServiceButton, 5);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        data.bottom = new FormAttachment(90);
        data.height = 150;
        trServiceDependencies.setLayoutData(data);

        trServiceDependencies.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent evt) {
                final TreeItem item = (TreeItem) evt.item;
                if (evt.detail == SWT.CHECK && item != null) {
                    setSave(true);
                    updateDirtyState();
                    mockServiceTree.handleTreeItemChecked(item);
                }
            }

            public void widgetDefaultSelected(SelectionEvent evt) {

            }
        });

        addMockServiceButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                MockServiceSuiteCreationWizard wizard = new MockServiceSuiteCreationWizard(currentProject);
                wizard.init(PlatformUI.getWorkbench(), null);
                CustomWizardDialog mockServiceWizardDialog = new CustomWizardDialog(form.getShell(), wizard);
                mockServiceWizardDialog.setHelpAvailable(false);
                mockServiceWizardDialog.open();

                mockServiceTree.createTreeContent();
                mockServiceTree.expandParentNodes();
            }
        });

        mockServicesDetailSection.setExpanded(false);
    }

    /**
     * Method of refreshing unit test suite.
     */
    private void refreshAction() {
        mockServiceTree.createTreeContent();
        mockServiceTree.expandParentNodes();
        resourceTree.createTreeContent();
        resourceTree.expandParentNodes();
        reloadFormPage();
    }
    
    /**
     * Method of refreshing test case table.
     */
    private void refreshTestCasesTable() {
        testCaseTable.removeAll();
        unitTestDataHolder.clearTestCaseTableMapping();

        LinkedHashMap<Integer, TestCase> existsTestCases = unitTestDataHolder.getTestCases();

        for (Map.Entry<Integer, TestCase> testEntry : existsTestCases.entrySet()) {
            TableItem item = new TableItem(testCaseTable, SWT.NONE);
            String rowElement = testEntry.getValue().getTestCaseName() + " Test Case ";
            StringBuilder builder = new StringBuilder(rowElement);

            int assertEqualsCount = 0;
            int assertNotNullCount = 0;
            for (Map.Entry<String, Assertion> assertEntry : testEntry.getValue().getAssertions().entrySet()) {
                if (assertEntry.getValue().getAssertType().equals(Constants.ASSERT_EQUAL_TYPE)) {
                    assertEqualsCount++;
                } else if (assertEntry.getValue().getAssertType().equals(Constants.ASSERT_NOTNULL_TYPE)) {
                    assertNotNullCount++;
                }
            }

            builder.append("(" + Constants.ASSERT_EQUAL_TYPE + "-" + assertEqualsCount + ", "
                    + Constants.ASSERT_NOTNULL_TYPE + "-" + assertNotNullCount + ")");
            item.setText(0, builder.toString());

            int itemIndex = testCaseTable.indexOf(item);
            int testCaseCode = testEntry.getValue().getTestCaseCode();
            unitTestDataHolder.addTestCaseTableMapping(itemIndex, testCaseCode);
        }

        changePageState();
    }

    /**
     * Method of importing synapse unit test data from the selected file.
     * 
     * @param editor
     *            ESB editor currently using
     */
    private void importSynapseUnitTestData(FormEditor editor) {
        IFile unitTestFile = ((FileEditorInput) editor.getEditorInput()).getFile();
        currentProject = unitTestFile.getProject();
        unitTestDataHolder.getSupportiveArtifacts().clear();

        SynapseUnitTestSourceToFormDeserializer.generateFormView(this, unitTestFile, true);
    }

    /**
     * Method of reloading form page.
     */
    public void reloadFormPage() {
        resourceTree.setCheckedElemets(unitTestDataHolder.getSupportiveArtifacts());
        resourceTree.setRegistryCheckedElemets(unitTestDataHolder.getRegistryResource());
        resourceTree.setConnectorCheckedElemets(unitTestDataHolder.getConnectorFiles());
        mockServiceTree.setCheckedElemets(unitTestDataHolder.getMockServices());

        unitTestDataHolder.clearTestCaseTableMapping();
        refreshTestCasesTable();
    }

    public SynapseUnitTest getUnitTestDataHolder() {
        return unitTestDataHolder;
    }

    public String getTestArtifactPath() {
        return testArtifactPath;
    }

    public void setTestArtifactPath(String testArtifactPath) {
        this.testArtifactPath = testArtifactPath;
    }

    private void changePageState() {
        setSave(true);
        updateDirtyState();
    }
}

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
package org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.wizard.unittest;

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbench;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.component.DependencyTree;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.constant.Constants;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.SynapseUnitTest;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.propertytester.UnitTestResourceTester;

/**
 * Class responsible for creation of wizard page for unit test details.
 */
public class UnitTestSuiteDetailPage extends WizardPage {

    private static final String DIALOG_TITLE = "Unit Test Suite";
    private static final String DESCRIPTION = "Create a new Unit Test Suite";
    private static final String UNIT_TEST_SUITE_NAME = "Name of the Unit Test Suite:";
    private static final String UNIT_TEST_SUITE_SAVE_PATH = "Save Location:";
    private static final String SELECT_TEST_ARTIFACT_LABEL = "Select an artifact file which want to test:";
    private static final String EMPTY_STRING = "";
    private static final String SPACE_STRING = " ";

    private IProject selectedProject;

    private String suiteName = EMPTY_STRING;
    private String suiteExportPath = EMPTY_STRING;
    private String initialSuiteName = EMPTY_STRING;
    private boolean isPageSelectionFromTester;

    private Text txtSuiteExportPath;
    private Text txtSuiteName;
    private DependencyTree resourceTree;
    private Tree trDependencies;

    private SynapseUnitTest unitTestDataHolder;

    /**
     * Class constructor.
     */
    protected UnitTestSuiteDetailPage(IWorkbench wb, IStructuredSelection selection, SynapseUnitTest unitTestData,
            IProject project, boolean isPageSelection) {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);
        setDescription(DESCRIPTION);
        this.isPageSelectionFromTester = isPageSelection;

        setSelectedProject(project);
        this.unitTestDataHolder = unitTestData;
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new FormLayout());

        Label lblName = new Label(container, SWT.NONE);
        FormData data = new FormData();
        data.top = new FormAttachment(5);
        data.left = new FormAttachment(2);
        data.width = 250;
        lblName.setLayoutData(data);
        lblName.setText(UNIT_TEST_SUITE_NAME);

        txtSuiteName = new Text(container, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(5);
        data.left = new FormAttachment(lblName);
        data.right = new FormAttachment(98);
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
        data.top = new FormAttachment(lblName, 20);
        data.left = new FormAttachment(2);
        data.width = 250;
        lblExportDestination.setLayoutData(data);
        lblExportDestination.setText(UNIT_TEST_SUITE_SAVE_PATH);

        txtSuiteExportPath = new Text(container, SWT.READ_ONLY | SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(lblName, 20);
        data.left = new FormAttachment(lblExportDestination);
        data.right = new FormAttachment(98);
        data.width = 350;
        txtSuiteExportPath.setLayoutData(data);
        suiteExportPath = File.separator + selectedProject.getName() + File.separator + Constants.TEST_FOLDER;
        txtSuiteExportPath.setBackground(new Color(null, 229, 236, 253));
        txtSuiteExportPath.setText(suiteExportPath);

        txtSuiteExportPath.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                setSuiteExportPath(txtSuiteExportPath.getText());
                validate();
            }
        });

        if (suiteExportPath != null) {
            txtSuiteExportPath.setText(suiteExportPath);
        } else {
            setPageComplete(false);
        }

        if (!isPageSelectionFromTester) {
            createTestArtifactFileSelectionSection(container);
        }
    }

    /**
     * Method for create select test artifact section in the wizard page.
     *
     * @param container
     *            Composite layout
     */
    private void createTestArtifactFileSelectionSection(Composite container) {
        // Create a horizontal separator
        Label separator = new Label(container, SWT.HORIZONTAL | SWT.SEPARATOR);
        FormData data = new FormData();
        data.top = new FormAttachment(txtSuiteExportPath, 25);
        data.left = new FormAttachment(2);
        data.left = new FormAttachment(2);
        data.right = new FormAttachment(98);
        separator.setLayoutData(data);

        // Create UI for the Mock Service Details
        Group grpServiceData = new Group(container, SWT.NONE);
        Font boldFont = new Font(null, new FontData("Arial", 12, SWT.BOLD));
        grpServiceData.setFont(boldFont);
        grpServiceData.setText(SELECT_TEST_ARTIFACT_LABEL);
        data = new FormData();
        data.top = new FormAttachment(separator, 20);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        data.bottom = new FormAttachment(99);
        data.height = 320;
        grpServiceData.setLayoutData(data);
        grpServiceData.setLayout(new FormLayout());

        resourceTree = new DependencyTree(unitTestDataHolder, selectedProject, "TEST_ARTIFACT");
        trDependencies = resourceTree.createResourcesTree(grpServiceData, "Test Artifacts");
        data = new FormData();
        data.top = new FormAttachment(grpServiceData, 7);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        data.bottom = new FormAttachment(97);
        trDependencies.setLayoutData(data);

        trDependencies.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent evt) {
                final TreeItem item = (TreeItem) evt.item;
                if (evt.detail == SWT.CHECK && item != null) {
                    resourceTree.selectArtifactFile(item);
                    validate();
                }
            }

            public void widgetDefaultSelected(SelectionEvent evt) {

            }
        });
    }

    /**
     * Method for validations of wizard page. If validation fails set page as dirty
     * and not complete
     */
    private void validate() {
        if (getSuiteName() == null || getSuiteName().equals(EMPTY_STRING)) {
            setErrorMessage("Please specify a name to the unit test suite");
            setPageComplete(false);
            return;
        } else if ((getSuiteExportPath() == null || getSuiteExportPath().equals(EMPTY_STRING))) {
            setErrorMessage("Please specify the unit test suite save destination");
            setPageComplete(false);
            return;
        } else if (getSuiteName().contains(SPACE_STRING)) {
            setErrorMessage("Please specify a name without whitespaces to the unit test suite");
            setPageComplete(false);
            return;
        } else if (!isPageSelectionFromTester
                && (unitTestDataHolder.getTestArtifact() == null || unitTestDataHolder.getTestArtifact().isEmpty())) {
            setErrorMessage("Please select one test artifact file which want to test");
            setPageComplete(false);
            return;
        } else {
            IWorkspaceRoot wroot = ResourcesPlugin.getWorkspace().getRoot();
            IContainer unitTestsLocation = wroot.getFolder(new Path(getSuiteExportPath()));
            IFile unitTestFile = unitTestsLocation.getFile(new Path(getSuiteName() + "." + Constants.XML_EXTENSION));
            if (unitTestFile.exists()) {
                setErrorMessage(getSuiteName() + " file name is already exists in saving location");
                setPageComplete(false);
                return;
            }
        }

        setErrorMessage(null);
        setPageComplete(true);

        if (isPageSelectionFromTester) {
            unitTestDataHolder.setTestArtifact(UnitTestResourceTester.getSelectedFilePath());
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
}

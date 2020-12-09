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
package org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.wizard.mockservice;

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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.constant.Constants;

/**
 * Class responsible for creation of wizard page for mock service file import.
 */
public class MockServiceImportPage extends WizardPage {

    private static final String BROWSE_LABEL_TEXT = "Browse";
    private static final String DIALOG_TITLE = "Import a Mock Service";
    private static final String IMPORT_MOCK_SERVICE_SUITE = "Import Mock Service file:";
    private static final String MOCK_SERVICE_SUITE_SAVE_PATH = "Save Location:";
    private static final String EMPTY_STRING = "";

    private IProject selectedProject;

    private String suiteImportPath = EMPTY_STRING;
    private String suiteExportPath = EMPTY_STRING;

    private Text txtSuiteExportPath;
    private Text txtSuiteImportPath;

    /**
     * Class constructor.
     */
    protected MockServiceImportPage(IWorkbench wb, IStructuredSelection selection, IProject project) {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);

        this.selectedProject = project;
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new FormLayout());
        container.setSize(500, 1000);

        Label lblName = new Label(container, SWT.NONE);
        FormData fd = new FormData();
        fd.top = new FormAttachment(5);
        fd.left = new FormAttachment(2);
        fd.width = 300;
        lblName.setLayoutData(fd);
        lblName.setText(IMPORT_MOCK_SERVICE_SUITE);

        txtSuiteImportPath = new Text(container, SWT.READ_ONLY | SWT.BORDER);
        fd = new FormData();
        fd.top = new FormAttachment(5);
        fd.left = new FormAttachment(lblName);
        fd.width = 350;
        fd.right = new FormAttachment(88);
        fd.width = 300;
        txtSuiteImportPath.setLayoutData(fd);

        Button importBtnBrowse = new Button(container, SWT.NONE);
        fd = new FormData();
        fd.top = new FormAttachment(4);
        fd.left = new FormAttachment(txtSuiteImportPath);
        fd.right = new FormAttachment(98);
        importBtnBrowse.setLayoutData(fd);
        importBtnBrowse.setText(BROWSE_LABEL_TEXT);

        importBtnBrowse.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                FileDialog fileDlg = new FileDialog(getShell());
                String[] filterExt = { "*.xml;*.XML" };
                fileDlg.setFilterExtensions(filterExt);
                String importFile = fileDlg.open();
                if (importFile != null) {
                    txtSuiteImportPath.setText(importFile);
                    setSuiteImportPath(importFile);
                }
                validate();
            }
        });

        if (suiteImportPath == null || suiteImportPath.isEmpty()) {
            setPageComplete(false);
        }

        Label lblExportDestination = new Label(container, SWT.NONE);
        fd = new FormData();
        fd.top = new FormAttachment(lblName, 20);
        fd.left = new FormAttachment(2);
        fd.width = 300;
        lblExportDestination.setLayoutData(fd);
        lblExportDestination.setText(MOCK_SERVICE_SUITE_SAVE_PATH);

        txtSuiteExportPath = new Text(container, SWT.READ_ONLY | SWT.BORDER);
        fd = new FormData();
        fd.top = new FormAttachment(lblName, 20);
        fd.left = new FormAttachment(lblExportDestination);
        fd.width = 350;
        fd.right = new FormAttachment(98);
        txtSuiteExportPath.setLayoutData(fd);
        txtSuiteExportPath.setBackground(new Color(null, 229, 236, 253));
        if (selectedProject != null) {
            suiteExportPath = selectedProject.getName() + File.separator + Constants.TEST_FOLDER + File.separator
                    + Constants.SERVICE_RESOURCES + File.separator + Constants.MOCK_SERVICES;
        }
        txtSuiteExportPath.setText(suiteExportPath);

        validate();
    }

    /**
     * Method for validations of wizard page. If validation fails set page as dirty
     * and not complete
     */
    private void validate() {
        if ((getSuiteImportPath() == null || getSuiteImportPath().equals(EMPTY_STRING))) {
            setErrorMessage("Please select a mock service suite file");
            setPageComplete(false);
            return;
        } else {
            IWorkspaceRoot wroot = ResourcesPlugin.getWorkspace().getRoot();
            IContainer unitTestsLocation = wroot.getFolder(new Path(getSuiteExportPath()));
            String[] filePathSplitter = getSuiteImportPath().split(File.separator);
            String fileName = filePathSplitter[filePathSplitter.length - 1].toLowerCase();
            IFile unitTestFile = unitTestsLocation.getFile(new Path(fileName));
            if (unitTestFile.exists()) {
                setErrorMessage(fileName + " file is already exists in saving location");
                setPageComplete(false);
                return;
            }
        }

        setErrorMessage(null);
        setPageComplete(true);
    }

    public void setSelectedProject(IProject selectedProject) {
        this.selectedProject = selectedProject;
    }

    public String getSuiteImportPath() {
        return suiteImportPath;
    }

    public void setSuiteImportPath(String suiteImportPath) {
        this.suiteImportPath = suiteImportPath;
    }

    public String getSuiteExportPath() {
        return suiteExportPath;
    }

    public void setSuiteExportPath(String suiteExportPath) {
        this.suiteExportPath = suiteExportPath;
    }
}

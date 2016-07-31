/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.humantaskeditor.wizards;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

public class HumanTaskExportWizardPage extends WizardPage {
    private String fileLocation;
    private Text deployInWorkspaceText;
    private IProject selectedProject;
    private String projectToArchive = null;

    protected HumanTaskExportWizardPage(String pageName, IProject p) {
        super(pageName);
        setTitle("Human Task Distribution");
        if (p != null) {
            selectedProject = p;
        }
        TrayDialog.setDialogHelpAvailable(true);
    }

    public void createControl(Composite parent) {
        GridData gd;
        Label label;
        Button deployInWorkspaceBrowseButton;

        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 3;
        layout.verticalSpacing = 9;

        getShell().setText("Combo box");
        getShell().setLayout(layout);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;

        Label projectListLabel = new Label(container, SWT.NULL);
        projectListLabel.setText("Project: ");
        final Combo projectListcombo = new Combo(container, SWT.VERTICAL | SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
        projectListcombo.setLayoutData(gd);
        gd = new GridData(GridData.FILL_HORIZONTAL);

        label = new Label(container, SWT.NULL);
        label.setLayoutData(gd);
        label.setText("Export Location");

        deployInWorkspaceText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        deployInWorkspaceText.setLayoutData(gd);
        deployInWorkspaceText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                handleDeployInWorkspaceText();
            }
        });

        deployInWorkspaceBrowseButton = new Button(container, SWT.PUSH);
        deployInWorkspaceBrowseButton.setText("Browse");
        deployInWorkspaceBrowseButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                handledeployInWorkspaceBrowseButton();
            }
        });
        IProject[] projectList;
        projectList = getProjects();
        if (projectList.length != 0) {
            for (int i = 0; i < projectList.length; i++) {
                projectListcombo.add(projectList[i].getName());
                if (selectedProject == null) {
                    projectListcombo.select(0);
                    setProjectToArchive(projectListcombo.getItem(0));
                } else {
                    if (selectedProject.getName().equals(projectList[i].getName())) {
                        projectListcombo.select(i);
                        setProjectToArchive(projectListcombo.getItem(i));
                    }
                }
            }
            if (projectListcombo.getSelectionIndex() == -1) {
                projectListcombo.select(0);
            }
        } else {
            String msg = "There are no projects in the current workspace";
            deployInWorkspaceText.setEnabled(false);
            deployInWorkspaceBrowseButton.setEnabled(false);
            setErrorMessage(msg);
            setPageComplete(false);
        }

        projectListcombo.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                setProjectToArchive(projectListcombo.getText());
            }
        });
        setControl(parent);
    }

    public String getProjectToArchive() {
        return projectToArchive;
    }

    private void setProjectToArchive(String projectToArchive) {
        this.projectToArchive = projectToArchive;
    }

    private void handledeployInWorkspaceBrowseButton() {
        String fileName = getSavePath();
        if (fileName != null)
            deployInWorkspaceText.setText(fileName);
    }

    private void handleDeployInWorkspaceText() {
        this.setFileLocation(deployInWorkspaceText.getText());
        String msg = null;
        File file = new File(getFileLocation());
        if (!file.exists())
            msg = "Invalid path specified";

        setErrorMessage(msg);
        setPageComplete(msg == null);
    }

    private String getSavePath() {
        String fileName = null;
        DirectoryDialog dlg = new DirectoryDialog(getShell());
        // dlg.setFilterExtensions(new String[]{".zip"});
        boolean done = false;

        while (!done) {
            // Open the File Dialog
            fileName = dlg.open();
            if (fileName == null) {
                done = true;
            } else {
                File file = new File(fileName);
                done = file.exists();
            }
        }
        return fileName;
    }

    private void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public IProject[] getProjects() {
        return ResourcesPlugin.getWorkspace().getRoot().getProjects();
    }

    @Override
    public void performHelp() {
        PlatformUI.getWorkbench().getHelpSystem().displayHelp("hteditor");
    }
}

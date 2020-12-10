/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *  http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.integrationstudio.eclipse.esb.dashboard.templates.maven.wizard;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateProjectWizardPage extends WizardPage {

    private Text containerText;

    private ISelection selection;

    /**
     * Constructor for Human Task Wizard Page.
     *
     * @param pageName
     */
    public TemplateProjectWizardPage(ISelection selection, String title) {
        super(TemplateProjectConstants.WIZARD_PAGE_NAME);
        if (title == null) {
            return;
        }
        setTitle("Create " + title + " Sample");
        setDescription(TemplateProjectConstants.PROJECT_WIZARD_PAGE_TITLE + title + " sample");
        this.selection = selection;
    }

    public static boolean isValidArtifactName(String name) {
        Pattern pattern = Pattern.compile("^[^/\\ \\\\:@%\\^+;,=\\[\\{\\]\\}*#\\$?\"<>|\\(\\)]+$");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    /**
     * @see IDialogPage#createControl(Composite)
     */
    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 2;
        layout.verticalSpacing = 9;
        Label label = new Label(container, SWT.NULL);
        label.setText(TemplateProjectConstants.WIZARD_PROJECT_NAME_LABEL);

        containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        containerText.setLayoutData(gd);
        containerText.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });

        initialize();
        dialogChanged();
        setControl(container);
    }

    /**
     * Tests if the current workbench selection is a suitable container to use.
     */
    private void initialize() {
        if (selection != null && !selection.isEmpty() && selection instanceof IStructuredSelection) {
            IStructuredSelection structuredSelection = (IStructuredSelection) selection;
            if (structuredSelection.size() > 1) {
                return;
            }
            Object obj = structuredSelection.getFirstElement();
            if (obj instanceof IResource) {
                containerText.setText(TemplateProjectConstants.WIZARD_PAGE_TEXT);
            }
        }
    }

    /**
     * Ensures that both text fields are set.
     */
    private void dialogChanged() {
        updateStatus(validateContainerName(getContainerName()));
    }

    private String validateContainerName(Object value) {

        if (value == null) {
            return "Project name cannot be empty";
        }

        String projectName = value.toString();

        if (projectName.trim().equals("")) {
            return "Project name cannot be empty";
        } else {
            if (projectName.indexOf(0x20) != -1) {
                return "Project name cannot contain spaces";
            } else {
                if (!isValidArtifactName(projectName)) {
                    return "Project name cannot contain invalid characters(^/ : ; * # $ ? \" <> + $)";
                }
            }
        }

        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
        if (project.exists()) {
            return "Project with the name '" + projectName + "' already exists";
        }

        return null;
    }

    private void updateStatus(String message) {
        setErrorMessage(message);
        setPageComplete(message == null);
    }

    public String getContainerName() {
        return containerText.getText();
    }

}

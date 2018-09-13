/*
 *     Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *     WSO2 Inc. licenses this file to you under the Apache License,
 *     Version 2.0 (the "License"); you may not use this file except
 *     in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing,
 *    software distributed under the License is distributed on an
 *    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *    KIND, either express or implied.  See the License for the
 *    specific language governing permissions and limitations
 *    under the License.
 */
package org.wso2.developerstudio.eclipse.esb.dashboard.templates.wizard;

import org.eclipse.core.resources.IResource;
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
import org.eclipse.ui.PlatformUI;

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
        setTitle(title);
        setDescription(TemplateProjectConstants.PROJECT_WIZARD_PAGE_DESCRIPTION);
        this.selection = selection;
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
        PlatformUI.getWorkbench().getHelpSystem()
                .setHelp(container, TemplateProjectConstants.NEW_ARTIFACT_HELP_CONTEXT_ID);
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

        if (getContainerName().length() == 0) {
            updateStatus(TemplateProjectConstants.FILE_CONTAINER_MUST_BE_SPECIFIED_MESSAGE);
            return;
        }
        updateStatus(null);
    }

    private void updateStatus(String message) {
        setErrorMessage(message);
        setPageComplete(message == null);
    }

    public String getContainerName() {
        return containerText.getText();
    }

}

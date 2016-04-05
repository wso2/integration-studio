/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.humantaskeditor.wizards;

import org.eclipse.core.resources.IContainer;
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
import org.wso2.developerstudio.humantaskeditor.HumantaskEditorConstants;

public class HumanTaskProjectWizardPage extends WizardPage {

    private Text containerText;

    private Text fileText;

    private ISelection selection;

    /**
     * Constructor for Human Task Wizard Page.
     *
     * @param pageName
     */
    public HumanTaskProjectWizardPage(ISelection selection) {
        super(HumantaskEditorConstants.WIZARD_PAGE_NAME);
        setTitle(HumantaskEditorConstants.PROJECT_WIZARD_PAGE_TITLE);
        setDescription(HumantaskEditorConstants.PROJECT_WIZARD_PAGE_DESCRIPTION);
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
        label.setText("&Project Name:");

        containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        containerText.setLayoutData(gd);
        containerText.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });

        label = new Label(container, SWT.NULL);
        label.setText("&File name:");

        fileText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        fileText.setLayoutData(gd);
        fileText.addModifyListener(new ModifyListener() {
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
        if (selection != null && selection.isEmpty() == false && selection instanceof IStructuredSelection) {
            IStructuredSelection ssel = (IStructuredSelection) selection;
            if (ssel.size() > 1) {
                return;
            }
            Object obj = ssel.getFirstElement();
            if (obj instanceof IResource) {
                IContainer container;
                if (obj instanceof IContainer) {
                    container = (IContainer) obj;
                } else {
                    container = ((IResource) obj).getParent();
                }
                containerText.setText(HumantaskEditorConstants.WIZARD_PAGE_TEXT);
            }
        }
        fileText.setText(HumantaskEditorConstants.NEW_HT_FILE_NAME);
    }

    /**
     * Ensures that both text fields are set.
     */

    private void dialogChanged() {
        String fileName = getFileName();

        if (getContainerName().length() == 0) {
            updateStatus(HumantaskEditorConstants.FILE_CONTAINER_MUST_BE_SPECIFIED_MESSAGE);
            return;
        }
        /*
         * if (container == null
         * || (container.getType() & (IResource.PROJECT | IResource.FOLDER)) == 0) {
         * updateStatus("File container must exist");
         * return;
         * }
         */
        /*
         * if (!container.isAccessible()) {
         * updateStatus("Project must be writable");
         * return;
         * }
         */
        if (fileName.length() == 0) {
            updateStatus(HumantaskEditorConstants.FILE_NAME_MUST_BE_SPECIFIED_MESSAGE);
            return;
        }
        if (fileName.replace('\\', '/').indexOf('/', 1) > 0) {
            updateStatus(HumantaskEditorConstants.FILE_NAME_MUST_BE_VALID_MESSAGE);
            return;
        }
        int dotLoc = fileName.lastIndexOf('.');
        if (dotLoc != -1) {
            String ext = fileName.substring(dotLoc + 1);
            if (ext.equalsIgnoreCase("ht") == false) {
                updateStatus(HumantaskEditorConstants.FILE_EXTENSION_MUST_BE_HT_MESSAGE);
                return;
            }
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

    public String getFileName() {
        return fileText.getText();
    }
}
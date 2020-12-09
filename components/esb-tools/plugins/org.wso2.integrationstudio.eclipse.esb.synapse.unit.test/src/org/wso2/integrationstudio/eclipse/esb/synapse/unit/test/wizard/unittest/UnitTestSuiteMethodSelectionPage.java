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

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;

/**
 * Class responsible for creation of wizard page for select unit test import or
 * new options.
 */
public class UnitTestSuiteMethodSelectionPage extends WizardPage {

    private static final String DIALOG_TITLE = "Creation of Unit Test Suite";
    private static final String SELECTION_CREATE_METHOD = "Create a New Unit Test Suite";
    private static final String SELECTION_IMPORT_METHOD = "Import an Unit Test Suite";
    boolean isCreateNewSuiteChecked = true;
    boolean isImportSuiteChecked = false;

    protected UnitTestSuiteMethodSelectionPage(IWorkbench wb, IStructuredSelection selection) {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new FormLayout());

        Button createNewSuiteBtn = new Button(container, SWT.RADIO);
        createNewSuiteBtn.setSelection(true);
        FormData fd = new FormData();
        fd.top = new FormAttachment(5);
        fd.left = new FormAttachment(3);
        createNewSuiteBtn.setLayoutData(fd);
        createNewSuiteBtn.setText(SELECTION_CREATE_METHOD);

        Button importSuiteBtn = new Button(container, SWT.RADIO);
        fd = new FormData();
        fd.top = new FormAttachment(createNewSuiteBtn, 10);
        fd.left = new FormAttachment(3);
        importSuiteBtn.setLayoutData(fd);
        importSuiteBtn.setText(SELECTION_IMPORT_METHOD);

        createNewSuiteBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source = (Button) e.getSource();
                if (source.getSelection()) {
                    setCreateNewSuiteChecked(true);
                    setImportSuiteChecked(false);
                }
            }
        });

        importSuiteBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source = (Button) e.getSource();
                if (source.getSelection()) {
                    setImportSuiteChecked(true);
                    setCreateNewSuiteChecked(false);
                }
            }
        });

        setPageComplete(true);
    }

    public boolean isCreateNewSuiteChecked() {
        return isCreateNewSuiteChecked;
    }

    public void setCreateNewSuiteChecked(boolean isCreateNewSuiteChecked) {
        this.isCreateNewSuiteChecked = isCreateNewSuiteChecked;
    }

    public boolean isImportSuiteChecked() {
        return isImportSuiteChecked;
    }

    public void setImportSuiteChecked(boolean isImportSuiteChecked) {
        this.isImportSuiteChecked = isImportSuiteChecked;
    }
}

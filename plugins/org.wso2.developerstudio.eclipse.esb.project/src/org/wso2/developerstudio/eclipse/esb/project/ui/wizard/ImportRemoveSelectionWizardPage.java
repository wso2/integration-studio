/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.esb.project.ui.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class ImportRemoveSelectionWizardPage extends WizardPage {

	private Button removeRadioButton;
	private Button importRadioButton;

	protected ImportRemoveSelectionWizardPage(IStructuredSelection selection) {
		super("import");
		setTitle("Add or Remove Connectors/Modules");
		setDescription("Select option");
	}

	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new FormLayout());
		FormData data;
		
		importRadioButton = new Button(container, SWT.RADIO);
		importRadioButton.setText("Add connector/module");
		importRadioButton.setSelection(true);
		data = new FormData();
		data.top = new FormAttachment(5);
        data.left = new FormAttachment(3);
        importRadioButton.setLayoutData(data);
        
		removeRadioButton = new Button(container, SWT.RADIO);
		removeRadioButton.setText("Remove connector/module");
		data = new FormData();
        data.top = new FormAttachment(importRadioButton, 10);
        data.left = new FormAttachment(3);
        removeRadioButton.setLayoutData(data);
        
		importRadioButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setPageComplete(true);
			}
		});

		removeRadioButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setPageComplete(true);
			}
		});
	}

	@Override
	public IWizardPage getNextPage() {
		WizardPage wizardPage = null;
		if (importRadioButton.getSelection()) {
			wizardPage = ((CloudConnectorImportWizard) getWizard()).getStoreWizardPage();
		} else if (removeRadioButton.getSelection()) {
			wizardPage = ((CloudConnectorImportWizard) getWizard()).getRemoveWizardPage();
		}
		return wizardPage;
	}

}

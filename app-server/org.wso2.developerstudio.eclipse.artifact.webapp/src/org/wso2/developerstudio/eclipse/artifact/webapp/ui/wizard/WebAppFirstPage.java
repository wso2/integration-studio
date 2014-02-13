/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.artifact.webapp.ui.wizard;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.wso2.developerstudio.eclipse.artifact.webapp.model.WebAppModel;


public class WebAppFirstPage  extends WizardPage {

	private WebAppModel model;
	private DynamicWebAppCreationWizard wizard;
	protected WebAppFirstPage(String pageName, WebAppModel model,DynamicWebAppCreationWizard wizard) {
		super(pageName);
		setTitle("Web Application Creation Options");
		setDescription("Select how you would like to create your new project");
		this.model = model;
		this.wizard = wizard;
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		FillLayout fl_container = new FillLayout(SWT.HORIZONTAL);
		fl_container.marginWidth = 10;
		fl_container.marginHeight = 10;
		container.setLayout(fl_container);

		Composite composite = new Composite(container, SWT.NONE);
		GridLayout gl_group = new GridLayout(1, false);
		gl_group.marginLeft = 20;
		composite.setLayout(gl_group);
			Button btnRadioButton = new Button(composite, SWT.RADIO);
			btnRadioButton.setText("Create New Web Application");
			btnRadioButton.setSelection(true);
			btnRadioButton.addSelectionListener(new SelectionListener() {
				
				public void widgetDefaultSelected(SelectionEvent event) {
					 model.setNewWebApp(true);
					 wizard.addPages();
				}
				public void widgetSelected(SelectionEvent event) {
					widgetDefaultSelected(event);
				}
			});
			Button btnRadioButton2 = new Button(composite, SWT.RADIO);
			btnRadioButton2.setText("Import Web Application");
			btnRadioButton2.addSelectionListener(new SelectionListener() {
				
				public void widgetDefaultSelected(SelectionEvent event) {
					 model.setNewWebApp(false);
					 wizard.addPages();
				}

				
				public void widgetSelected(SelectionEvent event) {
					widgetDefaultSelected(event);
				}
			});
			 
		Label lblA = new Label(composite, SWT.NONE);
		lblA.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		TrayDialog.setDialogHelpAvailable(false);
	}
}

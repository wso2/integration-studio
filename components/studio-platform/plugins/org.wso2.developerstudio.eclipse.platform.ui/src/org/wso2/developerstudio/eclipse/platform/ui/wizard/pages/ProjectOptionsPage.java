/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.ui.wizard.pages;

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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.Activator;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectOption;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectWizardSettings;

public class ProjectOptionsPage extends WizardPage {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private ProjectOption selectedProjectOption;
	private ProjectDataModel dataModel;
	private ProjectWizardSettings settings;

	/**
	 * Create the wizard.
	 */
	public ProjectOptionsPage(ProjectWizardSettings settings, ProjectDataModel dataModel) {
		super("wizardPage");
		setTitle(settings.getProjectOptionsTitle());
		setDescription(settings.getProjectOptionsDescription());
		setDataModel(dataModel);
		setSettings(settings);
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
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

		for (ProjectOption projectOption : getSettings().getProjectOptions()) {
			Button btnRadioButton = new Button(composite, SWT.RADIO);
			btnRadioButton.setText(projectOption.getLabel());
			btnRadioButton.setData(projectOption);
			btnRadioButton.addSelectionListener(new SelectionListener() {

				public void widgetDefaultSelected(SelectionEvent event) {
					setSelectedProjectOption((ProjectOption) ((Control) event.getSource()).getData());
				}

				public void widgetSelected(SelectionEvent event) {
					widgetDefaultSelected(event);
				}
			});
			if (projectOption.isDefault()) {
				btnRadioButton.setSelection(true);
				setSelectedProjectOption(projectOption);
			}
		}

		Label lblA = new Label(composite, SWT.NONE);
		lblA.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		TrayDialog.setDialogHelpAvailable(false);
	}

	public void setSelectedProjectOption(ProjectOption selectedProjectOption) {
		this.selectedProjectOption = selectedProjectOption;
		try {
			getDataModel().setSelectedOption(selectedProjectOption.getId());
		} catch (ObserverFailedException e) {
			log.error("ObserverFailed", e);
		}
	}

	public ProjectOption getSelectedProjectOption() {
		return selectedProjectOption;
	}

	public void setDataModel(ProjectDataModel dataModel) {
		this.dataModel = dataModel;
	}

	public ProjectDataModel getDataModel() {
		return dataModel;
	}

	public void setSettings(ProjectWizardSettings settings) {
		this.settings = settings;
	}

	public ProjectWizardSettings getSettings() {
		return settings;
	}
}

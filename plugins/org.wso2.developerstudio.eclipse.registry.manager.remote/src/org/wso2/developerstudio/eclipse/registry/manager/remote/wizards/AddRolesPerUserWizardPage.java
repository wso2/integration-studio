/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.registry.manager.remote.wizards;

import java.util.ArrayList;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUserContainer;
import org.wso2.developerstudio.eclipse.registry.manager.remote.Activator;
import org.wso2.developerstudio.eclipse.usermgt.remote.UserManager;

public class AddRolesPerUserWizardPage extends WizardPage {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private RegistryUserContainer regUserContainer;
	private UserManager um;
	private String[] initialRoles;
	private ArrayList<String> selectedRoleList;
	private AddUserWizard wizard;
	private ArrayList<Button> checkBoxes;

	protected AddRolesPerUserWizardPage(String pageName, AddUserWizard wizard) {
		super(pageName);
		this.wizard = wizard;
		this.regUserContainer = wizard.getRegUserContainer();
		if (this.regUserContainer != null) {
			this.um = regUserContainer.getRegistryUserManagerContainer()
					.getUserManager();
		} else {
			um = wizard.getRegData().getUserManagerContent().getUserManager();
		}
		checkBoxes = new ArrayList<Button>();
		setPageComplete(true);
		setDescription("Specify roles to the user");
	}

	public void createControl(Composite parent) {
		selectedRoleList = new ArrayList<String>();
		selectedRoleList.add("everyone");

		Composite container = new Composite(parent, SWT.BORDER);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);
		layout.verticalSpacing = 10;
		GridData gd = new GridData(GridData.FILL_BOTH);
		container.setLayoutData(gd);

		Group group1 = new Group(container, SWT.NONE);
		group1.setLayout(new GridLayout());
		group1.setText("Credentials");
		group1.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
				| GridData.HORIZONTAL_ALIGN_FILL));

		Group group2 = new Group(container, SWT.NONE);
		group2.setLayout(new GridLayout());
		group2.setText("Roles");
		group2.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
				| GridData.HORIZONTAL_ALIGN_FILL));

		initialRoles = getRoles();
		if (initialRoles != null) {
			for (int i = 0; i < initialRoles.length; i++) {
				createCheckBoxes(group1, initialRoles[i]);
			}
		}
		if (!wizard.isNew) {
			try {
				String[] selectedRoles = um.getRolesPerUser(wizard.getRegUser()
						.getUserName());
				for (int i = 0; i < selectedRoles.length; i++) {
					setCheckBoxesSelected(selectedRoles[i]);
				}
			} catch (Exception e) {
				log.error(e);
			}
		}

		createRolesInfo(group2);

		setControl(container);
	}

	public String[] getRoles() {
		if (um != null) {
			return um.getRoles("*");
		}
		return null;

	}

	public void createRolesInfo(Group group2) {

	}

	public void setCheckBoxesSelected(String role) {

		for (int i = 0; i < checkBoxes.size(); i++) {
			if (checkBoxes.get(i).getText().equals(role)) {
				checkBoxes.get(i).setSelection(true);
			}
		}
	}

	public void createCheckBoxes(Group group1, String role) {
		Button button;
		if (role.equals("everyone")) {
			button = new Button(group1, SWT.CHECK | SWT.SELECTED);
			button.setText(role);
			button.setSelection(true);
			if (!checkBoxes.contains(button)) {
				checkBoxes.add(button);
			}
		} else {
			button = new Button(group1, SWT.CHECK);
			button.setText(role);
			if (!checkBoxes.contains(button)) {
				checkBoxes.add(button);
			}
		}
		button.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent event) {
				String role = ((Button) (event.widget)).getText();
				boolean b = ((Button) (event.widget)).getSelection();
				if (b) {
					if (!selectedRoleList.contains(role)) {
						selectedRoleList.add(role);
					}
				} else {
					selectedRoleList.remove(role);
				}

				for (int i = 0; i < checkBoxes.size(); i++) {
					if (checkBoxes.get(i).getText().equals("everyone")) {
						checkBoxes.get(i).setSelection(true);
					}
				}
			}

			public void widgetDefaultSelected(SelectionEvent event) {

			}
		});
	}

	public ArrayList<String> getSelectedRoleList() {
		return selectedRoleList;
	}

	public void setSelectedRoleList(ArrayList<String> selectedRoleList) {
		this.selectedRoleList = selectedRoleList;
	}

	public String[] getRolesPerUser(String userName) throws Exception {
		return um.getRolesPerUser(userName);
	}

}

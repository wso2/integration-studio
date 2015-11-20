package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.platform.ui.utils.UserManagerUtils;

public abstract class UserRolesDialog extends Dialog {
	
	protected Object object;

	private Label serverUrlLabel;
	private Label userNameLabel;
	private Label passwordLabel;
	private Label roleNamePatternLabel;
	private Label rolesLabel;
	private Label inlineUserRolesLabel;
	private Label rolesFromServerLabel;

	private Text inlineUserRolesText;
	private Text serverUrlText;
	private Text userNameText;
	private Text passwordText;
	private Text roleNamePatternText;

	private Button inlineRadioButton;
	private Button fromServerRadioButton;
	private Button getRolesButton;

	private Table userRolesTable;
	private String userRoles;
	
	private static final String ALLOW_ROLES = "allowRoles";

	private static List<String> selectedRoles;

	public UserRolesDialog(Shell parentShell, List<String> roles) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.selectedRoles = roles;
	}

	public UserRolesDialog(Shell parentShell, Object object) {
		super(parentShell);
		this.object = object;
	}
	
	/*
	public UserRolesDialog(Shell parentShell,DataService dataService, String a) {
		super(parentShell);
		this.dataService = dataService;
	}*/

	/**
	 * {@inheritDoc}
	 */
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		// Set title.
		newShell.setText("User Roles");
	}

	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);

		inlineRadioButton = new Button(container, SWT.RADIO);
		{
			inlineRadioButton.setText("Define Inline");
			FormData inlineRadioButtonLayoutData = new FormData();
			inlineRadioButtonLayoutData.top = new FormAttachment(0, 5);
			inlineRadioButtonLayoutData.left = new FormAttachment(0);
			inlineRadioButton.setLayoutData(inlineRadioButtonLayoutData);
			inlineRadioButton.setSelection(true);

			inlineRadioButton.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					updateUI(event);
				}
			});
		}

		fromServerRadioButton = new Button(container, SWT.RADIO);
		{
			fromServerRadioButton.setText("Get from Server");
			FormData fromServerRadioButtonLayoutData = new FormData();
			fromServerRadioButtonLayoutData.top = new FormAttachment(0, 5);
			fromServerRadioButtonLayoutData.left = new FormAttachment(
					inlineRadioButton, 50);
			fromServerRadioButtonLayoutData.right = new FormAttachment(100, -5);
			fromServerRadioButton
					.setLayoutData(fromServerRadioButtonLayoutData);

			fromServerRadioButton.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					updateUI(event);
				}
			});
		}

		inlineUserRolesText = new Text(container, SWT.SINGLE | SWT.BORDER);
		{
			FormData inlineUserRolesTextLayoutData = new FormData(100,
					SWT.DEFAULT);
			inlineUserRolesTextLayoutData.top = new FormAttachment(
					fromServerRadioButton, 20);
			inlineUserRolesTextLayoutData.left = new FormAttachment(
					fromServerRadioButton, 40, SWT.LEFT);
			inlineUserRolesTextLayoutData.right = new FormAttachment(100, -5);
			inlineUserRolesText.setLayoutData(inlineUserRolesTextLayoutData);
		}

		inlineUserRolesLabel = new Label(container, SWT.NONE);
		{
			inlineUserRolesLabel.setText("Inline User Roles: ");
			FormData inlineUserRolesLabelLayoutData = new FormData(20,
					SWT.DEFAULT);
			inlineUserRolesLabelLayoutData.top = new FormAttachment(
					inlineUserRolesText, 0, SWT.CENTER);
			inlineUserRolesLabelLayoutData.right = new FormAttachment(
					inlineUserRolesText, -5);
			inlineUserRolesLabelLayoutData.left = new FormAttachment(0);
			inlineUserRolesLabel.setLayoutData(inlineUserRolesLabelLayoutData);
		}

		serverUrlText = new Text(container, SWT.SINGLE | SWT.BORDER);
		{
			FormData serverUrlTextLayoutData = new FormData(100, SWT.DEFAULT);
			serverUrlTextLayoutData.top = new FormAttachment(
					inlineUserRolesText, 25);
			serverUrlTextLayoutData.left = new FormAttachment(
					inlineUserRolesText, 0, SWT.LEFT);
			serverUrlTextLayoutData.right = new FormAttachment(100, -5);
			serverUrlText.setLayoutData(serverUrlTextLayoutData);
		}

		serverUrlLabel = new Label(container, SWT.NONE);
		{
			serverUrlLabel.setText("URL: ");
			FormData serverUrlLabelLayoutData = new FormData(20, SWT.DEFAULT);
			serverUrlLabelLayoutData.top = new FormAttachment(serverUrlText, 0,
					SWT.CENTER);
			serverUrlLabelLayoutData.right = new FormAttachment(serverUrlText,
					-5);
			serverUrlLabelLayoutData.left = new FormAttachment(0);
			serverUrlLabel.setLayoutData(serverUrlLabelLayoutData);
		}

		userNameText = new Text(container, SWT.SINGLE | SWT.BORDER);
		{
			FormData userNameTextLayoutData = new FormData(100, SWT.DEFAULT);
			userNameTextLayoutData.top = new FormAttachment(serverUrlText, 5);
			userNameTextLayoutData.left = new FormAttachment(serverUrlText, 0,
					SWT.LEFT);
			userNameTextLayoutData.right = new FormAttachment(100, -5);
			userNameText.setLayoutData(userNameTextLayoutData);
		}

		userNameLabel = new Label(container, SWT.NONE);
		{
			userNameLabel.setText("Username: ");
			FormData userNameLabelLayoutData = new FormData(25, SWT.DEFAULT);
			userNameLabelLayoutData.top = new FormAttachment(userNameText, 0,
					SWT.CENTER);
			userNameLabelLayoutData.right = new FormAttachment(userNameText, -5);
			userNameLabelLayoutData.left = new FormAttachment(0);
			userNameLabel.setLayoutData(userNameLabelLayoutData);
		}

		passwordText = new Text(container, SWT.SINGLE | SWT.BORDER
				| SWT.PASSWORD);
		{
			FormData passwordTextLayoutData = new FormData(100, SWT.DEFAULT);
			passwordTextLayoutData.top = new FormAttachment(userNameText, 5);
			passwordTextLayoutData.left = new FormAttachment(userNameText, 0,
					SWT.LEFT);
			passwordTextLayoutData.right = new FormAttachment(100, -5);
			passwordText.setLayoutData(passwordTextLayoutData);
		}

		passwordLabel = new Label(container, SWT.None);
		{
			passwordLabel.setText("Password: ");
			FormData passwordLabelLayoutData = new FormData(25, SWT.DEFAULT);
			passwordLabelLayoutData.top = new FormAttachment(passwordText, 0,
					SWT.CENTER);
			passwordLabelLayoutData.right = new FormAttachment(passwordText, -5);
			passwordLabelLayoutData.left = new FormAttachment(0);
			passwordLabel.setLayoutData(passwordLabelLayoutData);
		}

		roleNamePatternText = new Text(container, SWT.SINGLE | SWT.BORDER);
		{
			FormData roleNamePatternTextLayoutData = new FormData(100,
					SWT.DEFAULT);
			roleNamePatternTextLayoutData.top = new FormAttachment(
					passwordText, 5);
			roleNamePatternTextLayoutData.left = new FormAttachment(
					passwordText, 0, SWT.LEFT);
			roleNamePatternTextLayoutData.right = new FormAttachment(100, -5);
			roleNamePatternText.setLayoutData(roleNamePatternTextLayoutData);
		}

		roleNamePatternLabel = new Label(container, SWT.NONE);
		{
			roleNamePatternLabel.setText("Role name pattern (* for all):");
			FormData roleNamePatternLabelLayoutData = new FormData(25,
					SWT.DEFAULT);
			roleNamePatternLabelLayoutData.top = new FormAttachment(
					roleNamePatternText, 0, SWT.CENTER);
			roleNamePatternLabelLayoutData.right = new FormAttachment(
					roleNamePatternText, -5);
			roleNamePatternLabelLayoutData.left = new FormAttachment(0);
			roleNamePatternLabel.setLayoutData(roleNamePatternLabelLayoutData);
		}

		rolesLabel = new Label(container, SWT.NONE);
		{
			rolesLabel.setText("Roles:");
			FormData rolesLabelLayoutData = new FormData(25, SWT.DEFAULT);
			rolesLabelLayoutData.top = new FormAttachment(roleNamePatternText,
					10);
			rolesLabelLayoutData.left = new FormAttachment(0);
			rolesLabelLayoutData.right = new FormAttachment(100, -5);
			rolesLabel.setLayoutData(rolesLabelLayoutData);
		}

		getRolesButton = new Button(container, SWT.NONE);
		{
			getRolesButton.setText("Get Roles");
			FormData getRolesButtonLayoutData = new FormData(80, SWT.DEFAULT);
			getRolesButtonLayoutData.top = new FormAttachment(rolesLabel, 10);
			getRolesButtonLayoutData.right = new FormAttachment(100, -5);
			getRolesButton.setLayoutData(getRolesButtonLayoutData);

			getRolesButton.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					listRoles();
				}
			});

		}

		userRolesTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.HIDE_SELECTION | SWT.CHECK);
		{
			TableColumn nameColumn = new TableColumn(userRolesTable, SWT.CENTER);
			TableColumn typeColumn = new TableColumn(userRolesTable, SWT.LEFT);

			nameColumn.setText("Select");
			nameColumn.setWidth(80);
			typeColumn.setText("Name");
			typeColumn.setWidth(200);

			userRolesTable.setHeaderVisible(true);
			userRolesTable.setLinesVisible(true);

			Listener tblPropertiesListener = new Listener() {

				public void handleEvent(Event evt) {
					if (null != evt.item) {
						if (evt.item instanceof TableItem) {
							TableItem item = (TableItem) evt.item;
							// editItem(item);
						}
					}
				}
			};

			userRolesTable.addListener(SWT.Selection, tblPropertiesListener);

			FormData userRolesTableLayoutData = new FormData(500, 150);
			userRolesTableLayoutData.top = new FormAttachment(getRolesButton,
					0, SWT.TOP);
			userRolesTableLayoutData.left = new FormAttachment(0);
			userRolesTableLayoutData.right = new FormAttachment(getRolesButton,
					-5);
			userRolesTableLayoutData.bottom = new FormAttachment(100);
			userRolesTable.setLayoutData(userRolesTableLayoutData);
		}
		
		loadConfiguration();

		{
			// Set default values.
			serverUrlText.setText("https://localhost:9443/");
			userNameText.setText("admin");
			passwordText.setText("admin");
			roleNamePatternText.setText("*");

			updateServerRolesUI(false);
		}

		return container;
	}

	private void loadConfiguration() {
//		if (object instanceof DataService) {
//			if (((DataService) object).getFeatureAllowRoles() != null
//					&& !StringUtils.isEmpty(((DataService) object)
//							.getFeatureAllowRoles().getValue())) {
//				userRoles = ((DataService) object).getFeatureAllowRoles()
//						.getValue();
//				if (!StringUtils.isEmpty(userRoles)) {
//					inlineUserRolesText.setText(userRoles);
//				}
//			}
//		}
	}

	private void listRoles() {
		// clear table.
		userRolesTable.removeAll();

		if (StringUtils.isNotBlank(serverUrlText.getText())
				&& StringUtils.isNotBlank(userNameText.getText())
				&& StringUtils.isNotBlank(passwordText.getText())) {
			UserManagerUtils.getInstance().init(serverUrlText.getText().trim(),
					userNameText.getText().trim(),
					passwordText.getText().trim());
			String filter;
			if (StringUtils.isNotBlank(roleNamePatternText.getText())) {
				filter = roleNamePatternText.getText().trim();
			} else {
				filter = "*";
			}

			String[] roles = UserManagerUtils.getInstance().getRoles(filter, 1000);

			if (roles != null && roles.length > 0) {
				for (String role : roles) {
					if (!role.equals("false")) {
						TableItem item = new TableItem(userRolesTable, SWT.NONE);
						item.setText(new String[] { "", role });
					}

				}
			}
		}
	}

	@Override
	protected void okPressed() {
		selectedRoles = new ArrayList<String>();
		if (inlineRadioButton.getSelection()) {
			String inlineUserRoles = inlineUserRolesText.getText();
			if (StringUtils.isNotBlank(inlineUserRoles)) {
				String[] role = inlineUserRoles.split(",");
				for (int i = 0; i < role.length; i++) {
					if (StringUtils.isNotBlank(role[i])) {
						selectedRoles.add(role[i].trim());
					}
				}
			}
		} else {
			for (TableItem item : userRolesTable.getItems()) {
				if (item.getChecked()) {
					selectedRoles.add(item.getText(1));
				}
			}
		}
		updateModel();
		super.okPressed();
	}

	private void updateUI(Event event) {
		if (((Button) event.widget).getText().equals("Define Inline")) {
			inlineUserRolesText.setEnabled(true);
			updateServerRolesUI(false);

		} else {
			updateServerRolesUI(true);
			inlineUserRolesText.setEnabled(false);
		}
	}

	private void updateServerRolesUI(boolean enable) {
		serverUrlText.setEnabled(enable);
		userNameText.setEnabled(enable);
		passwordText.setEnabled(enable);
		roleNamePatternText.setEnabled(enable);
		userRolesTable.setEnabled(enable);
		getRolesButton.setEnabled(enable);
	}

	public abstract void updateModel();

	public static List<String> getSelectedUserRoles() {
		return selectedRoles;
	}

}

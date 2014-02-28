/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.qos.project.ui.dialog;

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
import org.wso2.developerstudio.eclipse.qos.project.utils.UserManagerUtils;

public class UserRolesDialog extends Dialog {

	private Label serverUrlLabel;
	private Label userNameLabel;
	private Label passwordLabel;
	private Label roleNamePatternLabel;
	private Label rolesLabel;

	private Text serverUrlText;
	private Text userNameText;
	private Text passwordText;
	private Text roleNamePatternText;

	private Button getRolesButton;

	private Table userRolesTable;

	private List<String> selectedRoles;

	public UserRolesDialog(Shell parentShell, List<String> roles) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.selectedRoles = roles;
	}

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

		serverUrlLabel = new Label(container, SWT.NONE);
		{
			serverUrlLabel.setText("URL: ");
			FormData serverUrlLabelLayoutData = new FormData();
			serverUrlLabelLayoutData.top = new FormAttachment(0, 5);
			serverUrlLabelLayoutData.left = new FormAttachment(0);
			serverUrlLabel.setLayoutData(serverUrlLabelLayoutData);
		}

		serverUrlText = new Text(container, SWT.SINGLE | SWT.BORDER);
		{
			FormData serverUrlTextLayoutData = new FormData(100, SWT.DEFAULT);
			serverUrlTextLayoutData.top = new FormAttachment(serverUrlLabel, 0, SWT.CENTER);
			serverUrlTextLayoutData.left = new FormAttachment(serverUrlLabel, 170);
			serverUrlTextLayoutData.right = new FormAttachment(100, -5);
			serverUrlText.setLayoutData(serverUrlTextLayoutData);
		}

		userNameText = new Text(container, SWT.SINGLE | SWT.BORDER);
		{
			FormData userNameTextLayoutData = new FormData(100, SWT.DEFAULT);
			userNameTextLayoutData.top = new FormAttachment(serverUrlText, 5);
			userNameTextLayoutData.left = new FormAttachment(serverUrlText, 0, SWT.LEFT);
			userNameTextLayoutData.right = new FormAttachment(100, -5);
			userNameText.setLayoutData(userNameTextLayoutData);
		}

		userNameLabel = new Label(container, SWT.NONE);
		{
			userNameLabel.setText("Username: ");
			FormData userNameLabelLayoutData = new FormData(25, SWT.DEFAULT);
			userNameLabelLayoutData.top = new FormAttachment(userNameText, 0, SWT.CENTER);
			userNameLabelLayoutData.right = new FormAttachment(userNameText, -5);
			userNameLabelLayoutData.left = new FormAttachment(0);
			userNameLabel.setLayoutData(userNameLabelLayoutData);
		}

		passwordText = new Text(container, SWT.SINGLE | SWT.BORDER | SWT.PASSWORD);
		{
			FormData passwordTextLayoutData = new FormData(100, SWT.DEFAULT);
			passwordTextLayoutData.top = new FormAttachment(userNameText, 5);
			passwordTextLayoutData.left = new FormAttachment(userNameText, 0, SWT.LEFT);
			passwordTextLayoutData.right = new FormAttachment(100, -5);
			passwordText.setLayoutData(passwordTextLayoutData);
		}

		passwordLabel = new Label(container, SWT.None);
		{
			passwordLabel.setText("Password: ");
			FormData passwordLabelLayoutData = new FormData(25, SWT.DEFAULT);
			passwordLabelLayoutData.top = new FormAttachment(passwordText, 0, SWT.CENTER);
			passwordLabelLayoutData.right = new FormAttachment(passwordText, -5);
			passwordLabelLayoutData.left = new FormAttachment(0);
			passwordLabel.setLayoutData(passwordLabelLayoutData);
		}

		roleNamePatternText = new Text(container, SWT.SINGLE | SWT.BORDER);
		{
			FormData roleNamePatternTextLayoutData = new FormData(100, SWT.DEFAULT);
			roleNamePatternTextLayoutData.top = new FormAttachment(passwordText, 5);
			roleNamePatternTextLayoutData.left = new FormAttachment(passwordText, 0, SWT.LEFT);
			roleNamePatternTextLayoutData.right = new FormAttachment(100, -5);
			roleNamePatternText.setLayoutData(roleNamePatternTextLayoutData);
		}

		roleNamePatternLabel = new Label(container, SWT.NONE);
		{
			roleNamePatternLabel.setText("Role name pattern (* for all):");
			FormData roleNamePatternLabelLayoutData = new FormData(25, SWT.DEFAULT);
			roleNamePatternLabelLayoutData.top = new FormAttachment(roleNamePatternText, 0,
					SWT.CENTER);
			roleNamePatternLabelLayoutData.right = new FormAttachment(roleNamePatternText, -5);
			roleNamePatternLabelLayoutData.left = new FormAttachment(0);
			roleNamePatternLabel.setLayoutData(roleNamePatternLabelLayoutData);
		}

		rolesLabel = new Label(container, SWT.NONE);
		{
			rolesLabel.setText("Roles:");
			FormData rolesLabelLayoutData = new FormData(25, SWT.DEFAULT);
			rolesLabelLayoutData.top = new FormAttachment(roleNamePatternText, 10);
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

		userRolesTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION | SWT.HIDE_SELECTION
				| SWT.CHECK);
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
			userRolesTableLayoutData.top = new FormAttachment(getRolesButton, 0, SWT.TOP);
			userRolesTableLayoutData.left = new FormAttachment(0);
			userRolesTableLayoutData.right = new FormAttachment(getRolesButton, -5);
			userRolesTableLayoutData.bottom = new FormAttachment(100);
			userRolesTable.setLayoutData(userRolesTableLayoutData);
		}

		{
			// Set default values. 
			serverUrlText.setText("https://localhost:9443/");
			userNameText.setText("admin");
			passwordText.setText("admin");
			roleNamePatternText.setText("*");
		}

		return container;
	}

	private void listRoles() {		
		// clear table.
		userRolesTable.removeAll();
		
		if (StringUtils.isNotBlank(serverUrlText.getText())
				&& StringUtils.isNotBlank(userNameText.getText())
				&& StringUtils.isNotBlank(passwordText.getText())) {
			UserManagerUtils.getInstance().init(serverUrlText.getText().trim(),
					userNameText.getText().trim(), passwordText.getText().trim());
			String filter;
			if (StringUtils.isNotBlank(roleNamePatternText.getText())) {
				filter = roleNamePatternText.getText().trim();
			} else {
				filter = "*";
			}

			String[] roles = UserManagerUtils.getInstance().getRoles(filter, 1000);

			if (roles != null && roles.length > 0) {
				for (String role : roles) {
					TableItem item = new TableItem(userRolesTable, SWT.NONE);
					item.setText(new String[] { "", role });
				}
			}
		}
	}

	@Override
	protected void okPressed() {

		for (TableItem item : userRolesTable.getItems()) {
			if (item.getChecked()) {
				selectedRoles.add(item.getText(1));
			}
		}
		super.okPressed();
	}
}

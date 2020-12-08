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

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUserRoleContainer;
import org.wso2.developerstudio.eclipse.registry.manager.remote.Activator;
import org.wso2.developerstudio.eclipse.usermgt.remote.UserManager;

import java.util.ArrayList;

/**
 *
 */
public class AddRoleWizardPage1 extends WizardPage{

	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private String[] initialUsers;
	private ArrayList<String> selectedUserList;
	private AddRoleWizard wizard;
	private ArrayList<Button> checkBoxes;
	private RegistryUserRoleContainer regUserRoleContainer;
	private String roleName;
	Text userNameText;
	private UserManager um;

	protected AddRoleWizardPage1(String pageName, AddRoleWizard wizard) {
		super(pageName);
		this.wizard = wizard;
		this.regUserRoleContainer = wizard.getRegUserRoleContainer();
		if (this.regUserRoleContainer != null) {
			this.um = regUserRoleContainer.getRegistryUserManagerContainer()
					.getUserManager();
		} else {
			um = regUserRoleContainer.getConnectionInfo().getUserManagerContent().getUserManager();
		}
		setDescription("Add Role information");
		setPageComplete(false);
	}

	public void createControl(Composite parent) {
		selectedUserList = new ArrayList<String>();
//		selectedUserList.add("admin");
		checkBoxes = new ArrayList<Button>();
		Composite container = new Composite(parent, SWT.BORDER);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);
		GridData gd = new GridData(GridData.FILL_BOTH);
		container.setLayoutData(gd);

		Group group1 = new Group(container, SWT.NONE);
		layout = new GridLayout();
		layout.numColumns = 2;
		layout.verticalSpacing = 10;
		group1.setLayout(layout);
		group1.setText("Users");
		group1.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
				| GridData.HORIZONTAL_ALIGN_FILL));

		Group group2 = new Group(container, SWT.NONE);
		group2.setLayout(new GridLayout());
		group2.setText("Users");
		group2.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
				| GridData.HORIZONTAL_ALIGN_FILL));

		fillGroup1Data(group1);
		fillGroup2Data(group2);

		setControl(container);
	}

	public void fillGroup1Data(Group group1) {
		GridData gd = new GridData();
		Label userNameLabel = new Label(group1, SWT.NULL);
		userNameLabel.setText("Role Name");
		gd = new GridData();
		userNameLabel.setLayoutData(gd);
		userNameText = new Text(group1, SWT.NULL | SWT.BORDER);

		if (userNameText != null) {
			gd = new GridData(GridData.FILL_HORIZONTAL);
			userNameText.setLayoutData(gd);
			userNameText.addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent event) {
					Text text = (Text) event.widget;
					roleName = text.getText();
					setRoleName(roleName);
					if(getRoleName() != null && !"".equals(getRoleName())){
						setPageComplete(true);
					}else{
						setPageComplete(false);
					}
				}
			});
		}

//		Label pwdLabel = new Label(group1, SWT.NULL);
//		pwdLabel.setText("Password");
//		gd = new GridData();
//		pwdLabel.setLayoutData(gd);

//		pwdText = new Text(group1, SWT.PASSWORD | SWT.BORDER);
//		gd = new GridData(GridData.FILL_HORIZONTAL);
//		pwdText.setLayoutData(gd);
//
//		pwdText.addModifyListener(new ModifyListener() {
//
//			public void modifyText(ModifyEvent event) {
//				Text text = (Text) event.widget;
//				pwd = text.getText();
//				setPwd(pwd);
//				if (!isPWDStrong(pwd)) {
//					String msg = "Passwords should be more than 6 characters long";
//					setErrorMessage(msg);
//					setPageComplete(msg == null);
//				} else {
//
//					setErrorMessage(null);
//					setPageComplete(true);
//				}
//			}
//		});

//		Label repeatPwdLabel = new Label(group1, SWT.NULL);
//		repeatPwdLabel.setText("Password Repeat");
//		gd = new GridData();
//		repeatPwdLabel.setLayoutData(gd);
//
//		Text repPwdText = new Text(group1, SWT.PASSWORD | SWT.BORDER);
//		gd = new GridData(GridData.FILL_HORIZONTAL);
//		repPwdText.setLayoutData(gd);
//
//		repPwdText.addModifyListener(new ModifyListener() {
//
//			public void modifyText(ModifyEvent event) {
//				Text text = (Text) event.widget;
//				repeatPwd = text.getText();
//				setRepeatPwd(repeatPwd);
//				if (!passwordMatch(getPwd(), getRepeatPwd())) {
//					String msg = "Passwords do not match. Please re-type passwords.";
//					setErrorMessage(msg);
//					setPageComplete(msg == null);
//				} else {
//					setErrorMessage(null);
//					setPageComplete(true);
//				}
//			}
//		});
	}

	public void fillGroup2Data(Group group2) {
		initialUsers = getUsers();
		if (initialUsers != null) {
			for (int i = 0; i < initialUsers.length; i++) {
				createCheckBoxes(group2, initialUsers[i]);
			}
		}
//			try {
//				String[] selectedUsers = um.getUsers();
//				for (int i = 0; i < selectedUsers.length; i++) {
//					setCheckBoxesSelected(selectedUsers[i]);
//				}
//			} catch (Exception e) {
//				log.error(e);
//			}
	}

	public void setCheckBoxesSelected(String userN) {

		for (int i = 0; i < checkBoxes.size(); i++) {
			if (checkBoxes.get(i).getText().equals(userN)) {
				checkBoxes.get(i).setSelection(true);
			}
		}
	}

	public void createCheckBoxes(Group group2, String userN) {
//			try {
//				String[] selectedUsers = um.getUsers();
//				// selectedRoleList = new ArrayList<String>();
//				for (int i = 0; i < selectedUsers.length; i++) {
//					if (!selectedUserList.contains(selectedUsers[i])
//							&& selectedUsers[i] != null) {
//						selectedUserList.add(selectedUsers[i]);
//					}
//				}
//			} catch (Exception e) {
//				log.error(e);
//			}
		Button button;
		if (userN.equals("everyone")) {
			button = new Button(group2, SWT.CHECK | SWT.SELECTED);
			button.setText(userN);
			button.setSelection(true);
			if (!checkBoxes.contains(button)) {
				checkBoxes.add(button);
			}
		} else {
			button = new Button(group2, SWT.CHECK);
			button.setText(userN);
			if (!checkBoxes.contains(button)) {
				checkBoxes.add(button);
			}
		}
		button.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent event) {
				String role = ((Button) (event.widget)).getText();
				// selectedRoleList.add("everyone");
				boolean b = ((Button) (event.widget)).getSelection();
				if (b) {
					if (!selectedUserList.contains(role)) {
						selectedUserList.add(role);
					}
				} else {
					selectedUserList.remove(role);
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
		return selectedUserList;
	}

	public void setSelectedRoleList(ArrayList<String> selectedRoleList) {
		this.selectedUserList = selectedRoleList;
	}

	public String[] getRolesPerUser(String userName) throws Exception {
		return um.getRolesPerUser(userName);
	}

//	public boolean passwordMatch(String pwd, String repeatPwd) {
//		if (pwd != null && repeatPwd != null) {
//			if (pwd.equals(repeatPwd)) {
//				return true;
//			}
//		}
//		return false;
//	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
//
//	public String getPwd() {
//		return pwd;
//	}
//
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}
//
//	public String getRepeatPwd() {
//		return repeatPwd;
//	}
//
//	public void setRepeatPwd(String repeatPwd) {
//		this.repeatPwd = repeatPwd;
//	}

//	public boolean isPWDStrong(String pwd) {
//		if (pwd.length() > 5) {
//			return true;
//		} else {
//			return false;
//		}
//	}

	public String[] getUsers() {
		if (um != null) {
			return um.getUsers();
		}
		return null;

	}

}

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

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUserRole;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUserRoleContainer;
import org.wso2.developerstudio.eclipse.registry.base.ui.dialog.UserPermissionDialog.RoleData;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.ImageUtils;
import org.wso2.developerstudio.eclipse.registry.manager.remote.Activator;
import org.wso2.developerstudio.eclipse.registry.resource.authorization.ResourceAdmin;
import org.wso2.developerstudio.eclipse.registry.resource.authorization.ResourceAdmin.Role;
import org.eclipse.swt.widgets.List;


/**
 *
 */
public class SetPermissionWizardPage2 extends WizardPage{

	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private AddRoleWizardPage1 page1;
	private SetPermissionWizardPage1 setPermissionWizardPage1;
	private ArrayList<RoleData> selectedPermissions;
	private String[] permissionList = { "Read", "Write", "Delete", "Authorize" };
	private RegistryUserRoleContainer regUserRole;
	private RoleData roleData;
	public static final String READ = "Read";
	public static final String WRITE = "Write";
	public static final String DELETE = "Delete";
	public static final String AUTHORIZE = "Authorize";
	private ArrayList<RegistryResourceNode> selectedIemList;
	private ArrayList<Button> checkBoxes;

	Text textArea;
	Button check;
	List list;

	protected SetPermissionWizardPage2(String pageName,
	                                   RegistryUserRoleContainer regUsrRole, AddRoleWizardPage1 page1,SetPermissionWizardPage1 wizPage1) {
		super(pageName);
		setPageComplete(true);
		setDescription("Select permissions you want to grant");
		this.regUserRole = regUsrRole;
		this.page1=page1;
		this.setPermissionWizardPage1 = wizPage1;
		setImageDescriptor(ImageUtils
				.getImageDescriptor(ImageUtils.ACTION_MODIFY_PERMISSION_ROLE));
	}

	public void createControl(Composite parent) {
		selectedPermissions = new ArrayList<RoleData>();
		GridData gd;
		Composite container = new Composite(parent, SWT.NULL);
		checkBoxes = new ArrayList<Button>();
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 1;
		layout.verticalSpacing = 10;
		gd = new GridData(GridData.FILL_HORIZONTAL);
		try {
			loadData();
		} catch (RemoteException e) {
			log.error(e);
		} catch (Exception e) {
			log.error(e);
		}
		for (int i = 0; i < permissionList.length; i++) {
			if (roleData != null) {
				createCheckbox(permissionList[i], gd, container, i, roleData);
			}
		}

		gd = new GridData(GridData.FILL_HORIZONTAL);
		Label label = new Label(container, SWT.NULL);
		label.setText("Selected Resource paths");
		label.setLayoutData(gd);
		list = new List(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		gd = new GridData(GridData.FILL_BOTH);
		list.setLayoutData(gd);
		selectedIemList = new ArrayList<RegistryResourceNode>();
		fillTextArea(selectedIemList);
		setControl(container);
	}

	private RoleData getRoleData(String roleName, String resourcePath) {
		return new RoleData(roleName, resourcePath);
	}

	public void loadData() throws RemoteException, Exception {
		ResourceAdmin rsAd = regUserRole.getRegistryUserManagerContainer().getRegistryData()
				.getResourceAdmin();
		if (setPermissionWizardPage1 != null) {
			ArrayList<RegistryResourceNode> list = (ArrayList<RegistryResourceNode>) setPermissionWizardPage1
					.selectedItemList();
			for (int i = 0; i < list.size(); i++) {
				ArrayList<Role> resourceInfo = rsAd
						.getPermissionPerResource(list.get(i)
								.getRegistryResourcePath());
				for (int j = 0; j < resourceInfo.size(); j++) {
					roleData = getRoleData(resourceInfo.get(j).getRole(), list
							.get(i).getRegistryResourcePath());
					ArrayList<String> permissionListPerRole = resourceInfo.get(
							j).getAssignedPermission();
					for (int k = 0; k < permissionListPerRole.size(); k++) {

						if (permissionListPerRole.get(k).equals("Read")) {
							roleData.setReadPerm(true);
						}
						if (permissionListPerRole.get(k).equals("Write")) {
							roleData.setWritePerm(true);
						}
						if (permissionListPerRole.get(k).equals("Delete")) {
							roleData.setDeletePerm(true);
						}
						if (permissionListPerRole.get(k).equals("Authorize")) {
							roleData.setAuthPerm(true);
						}

					}

				}
			}
		}
	}

	private void createCheckbox(String textString, GridData gd,
			Composite container, int type, RoleData roleData) {
		boolean value = false;
		String permission = "";

		check = new Button(container, SWT.CHECK);
		if (!checkBoxes.contains(check)) {
			checkBoxes.add(check);
		}
		if (type == 0) {
			permission = READ;
			value = roleData.isReadPerm();
		}
		if (type == 1) {
			permission = WRITE;
			value = roleData.isWritePerm();
		}
		if (type == 2) {
			permission = DELETE;
			value = roleData.isDeletePerm();
		}
		if (type == 3) {
			permission = AUTHORIZE;
			value = roleData.isAuthPerm();
		}

		check.setText(textString);
		check.setSelection(value);

		check.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent event) {
				int readCount = 0;
				int writeCount = 0;
				int deleteCount = 0;
				int authCount = 0;

//				String selectedRole = regUserRole.getUserRoleName();
				if (setPermissionWizardPage1 != null) {
					ArrayList<RegistryResourceNode> list = (ArrayList<RegistryResourceNode>) setPermissionWizardPage1
							.selectedItemList();
					if (!selectedPermissions.isEmpty()) {
						for (int c = 0; c < selectedPermissions.size(); c++) {
							RoleData roleD = selectedPermissions.get(c);
							if (roleD.isReadPerm()) {
								readCount++;
							}
							if (roleD.isWritePerm()) {
								writeCount++;
							}
							if (roleD.isDeletePerm()) {
								deleteCount++;
							}
							if (roleD.isAuthPerm()) {
								authCount++;
							}
						}
					}

					String permission = ((Button) (event.widget)).getText();
					boolean g = ((Button) (event.widget)).getSelection();
					for (int i = 0; i < selectedPermissions.size(); i++) {
						RoleData roleData = selectedPermissions.get(i);

						if (g) {
							if (permission.equals(READ)) {
								roleData.setReadPerm(true);
								readCount++;
							} else if (permission.equals(WRITE)) {
								roleData.setWritePerm(true);
								writeCount++;
							} else if (permission.equals(DELETE)) {
								roleData.setDeletePerm(true);
								deleteCount++;
							} else {
								roleData.setAuthPerm(true);
								authCount++;
							}
						} else {
							if (permission.equals(READ)) {
								roleData.setReadPerm(false);
								readCount--;
							} else if (permission.equals(WRITE)) {
								roleData.setWritePerm(false);
								writeCount--;
							} else if (permission.equals(DELETE)) {
								roleData.setDeletePerm(false);
								deleteCount--;
							} else {
								roleData.setAuthPerm(false);
								authCount--;
							}
						}
						selectedPermissions.remove(i);
						selectedPermissions.add(i, roleData);
					}

					if (readCount != 0 && readCount != list.size()) {
						setGrayedCheckBox(event);
					} else if (readCount == list.size()) {
						for (int k = 0; k < checkBoxes.size(); k++) {
							if (checkBoxes.get(k).getText().equals("Read")) {
								checkBoxes.get(k).setGrayed(false);
								checkBoxes.get(k).setSelection(true);
							}
						}
					} else {
						for (int k = 0; k < checkBoxes.size(); k++) {
							if (checkBoxes.get(k).getText().equals("Read")) {
								checkBoxes.get(k).setGrayed(false);
								checkBoxes.get(k).setSelection(false);
							}
						}
					}

					if (writeCount != 0 && writeCount != list.size()) {
						setGrayedCheckBox(event);
					} else if (writeCount == list.size()) {
						for (int k = 0; k < checkBoxes.size(); k++) {
							if (checkBoxes.get(k).getText().equals("Write")) {
								checkBoxes.get(k).setGrayed(false);
								checkBoxes.get(k).setSelection(true);
							}
						}
					} else {
						for (int k = 0; k < checkBoxes.size(); k++) {
							if (checkBoxes.get(k).getText().equals("Write")) {
								checkBoxes.get(k).setGrayed(false);
								checkBoxes.get(k).setSelection(false);
							}
						}
					}

					if (deleteCount != 0 && deleteCount != list.size()) {
						setGrayedCheckBox(event);
					} else if (deleteCount == list.size()) {
						for (int k = 0; k < checkBoxes.size(); k++) {
							if (checkBoxes.get(k).getText().equals("Delete")) {
								checkBoxes.get(k).setGrayed(false);
								checkBoxes.get(k).setSelection(true);
							}
						}
					} else {
						for (int k = 0; k < checkBoxes.size(); k++) {
							if (checkBoxes.get(k).getText().equals("Delete")) {
								checkBoxes.get(k).setGrayed(false);
								checkBoxes.get(k).setSelection(false);
							}
						}
					}

					if (authCount != 0 && authCount != list.size()) {
						setGrayedCheckBox(event);
					} else if (authCount == list.size()) {
						for (int k = 0; k < checkBoxes.size(); k++) {
							if (checkBoxes.get(k).getText().equals("Authorize")) {
								checkBoxes.get(k).setGrayed(false);
								checkBoxes.get(k).setSelection(true);
							}
						}
					} else {
						for (int k = 0; k < checkBoxes.size(); k++) {
							if (checkBoxes.get(k).getText().equals("Authorize")) {
								checkBoxes.get(k).setGrayed(false);
								checkBoxes.get(k).setSelection(false);
							}
						}
					}

				}
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});
	}

	public void setGrayedCheckBox(SelectionEvent event) {
		boolean g = ((Button) (event.widget)).getGrayed();
		boolean s = ((Button) (event.widget)).getSelection();
		((Button) (event.widget)).setSelection(s ^ g);
		((Button) (event.widget)).setGrayed(s && !g);
	}

	public boolean canFlipToNextPage() {
		selectedIemList = (ArrayList<RegistryResourceNode>) setPermissionWizardPage1.selectedItemList();
		fillTextArea(selectedIemList);
		try {
			setAssignedPermissionsToRole();
		} catch (Exception e) {
			log.error(e);
		}
		return false;
	}

	public void setAssignedPermissionsToRole() throws Exception {
		int readCount = 0;
		int writeCount = 0;
		int deleteCount = 0;
		int authCount = 0;
		String selectedRole = page1.getRoleName();
		ResourceAdmin rsAd = regUserRole.getRegistryUserManagerContainer().getRegistryData()
				.getResourceAdmin();
		if (setPermissionWizardPage1 != null) {
			ArrayList<RegistryResourceNode> list = (ArrayList<RegistryResourceNode>) setPermissionWizardPage1
					.selectedItemList();
			for (int i = 0; i < list.size(); i++) {
				ArrayList<String> permissionAssigned = rsAd
						.getPermissionListPerResource(list.get(i)
								.getRegistryResourcePath(), selectedRole);
				RoleData roleD = new RoleData(selectedRole, list.get(i)
						.getRegistryResourcePath());
				for (int j = 0; j < permissionAssigned.size(); j++) {
					if (permissionAssigned.get(j).equals("Read")) {
						readCount++;
						roleD.setReadPerm(true);
					}

					if (permissionAssigned.get(j).equals("Write")) {
						writeCount++;
						roleD.setWritePerm(true);
					}

					if (permissionAssigned.get(j).equals("Delete")) {
						deleteCount++;
						roleD.setDeletePerm(true);
					}

					if (permissionAssigned.get(j).equals("Authorize")) {
						authCount++;
						roleD.setAuthPerm(true);
					}
				}
				if (selectedPermissions.isEmpty()) {
					selectedPermissions.add(roleD);
				} else {
					for (int j = 0; j < selectedPermissions.size(); j++) {
						if (selectedPermissions.get(j).getResourcePath()
								.equals(list.get(i).getRegistryResourcePath())) {
							selectedPermissions.remove(j);
							selectedPermissions.add(j, roleD);
						} else {
							selectedPermissions.add(roleD);
						}
					}
				}
			}
			if (readCount == list.size()) {
				for (int k = 0; k < checkBoxes.size(); k++) {
					if (checkBoxes.get(k).getText().equals("Read")) {
						checkBoxes.get(k).setGrayed(false);
						checkBoxes.get(k).setSelection(true);
					}
				}
			} else if (readCount == 0) {
				for (int k = 0; k < checkBoxes.size(); k++) {
					if (checkBoxes.get(k).getText().equals("Read")) {
						checkBoxes.get(k).setGrayed(false);
						checkBoxes.get(k).setSelection(false);
					}
				}

			} else {
				for (int k = 0; k < checkBoxes.size(); k++) {
					if (checkBoxes.get(k).getText().equals("Read")) {
						checkBoxes.get(k).setGrayed(true);
						checkBoxes.get(k).setSelection(true);
					}
				}
			}

			if (writeCount == list.size()) {
				for (int k = 0; k < checkBoxes.size(); k++) {
					if (checkBoxes.get(k).getText().equals("Write")) {
						checkBoxes.get(k).setGrayed(false);
						checkBoxes.get(k).setSelection(true);
					}
				}
			} else if (writeCount == 0) {
				for (int k = 0; k < checkBoxes.size(); k++) {
					if (checkBoxes.get(k).getText().equals("Write")) {
						checkBoxes.get(k).setGrayed(false);
						checkBoxes.get(k).setSelection(false);
					}
				}
			} else {
				for (int k = 0; k < checkBoxes.size(); k++) {
					if (checkBoxes.get(k).getText().equals("Write")) {
						checkBoxes.get(k).setGrayed(true);
						checkBoxes.get(k).setSelection(true);
					}
				}
			}

			if (deleteCount == list.size()) {
				for (int k = 0; k < checkBoxes.size(); k++) {
					if (checkBoxes.get(k).getText().equals("Delete")) {
						checkBoxes.get(k).setGrayed(false);
						checkBoxes.get(k).setSelection(true);
					}
				}
			} else if (deleteCount == 0) {
				for (int k = 0; k < checkBoxes.size(); k++) {
					if (checkBoxes.get(k).getText().equals("Delete")) {
						checkBoxes.get(k).setGrayed(false);
						checkBoxes.get(k).setSelection(false);
					}
				}

			} else {
				for (int k = 0; k < checkBoxes.size(); k++) {
					if (checkBoxes.get(k).getText().equals("Delete")) {
						checkBoxes.get(k).setGrayed(true);
						checkBoxes.get(k).setSelection(true);

					}
				}
			}

			if (authCount == list.size()) {
				for (int k = 0; k < checkBoxes.size(); k++) {
					if (checkBoxes.get(k).getText().equals("Authorize")) {
						checkBoxes.get(k).setGrayed(false);
						checkBoxes.get(k).setSelection(true);
					}
				}
			} else if (authCount == 0) {
				for (int k = 0; k < checkBoxes.size(); k++) {
					if (checkBoxes.get(k).getText().equals("Authorize")) {
						checkBoxes.get(k).setGrayed(false);
						checkBoxes.get(k).setSelection(false);
					}
				}
			} else {
				for (int k = 0; k < checkBoxes.size(); k++) {
					if (checkBoxes.get(k).getText().equals("Authorize")) {
						checkBoxes.get(k).setGrayed(true);
						checkBoxes.get(k).setSelection(true);

					}
				}
			}

		}

	}

	public void fillTextArea(ArrayList<RegistryResourceNode> itemsList) {
		if (setPermissionWizardPage1 != null) {
			if (!itemsList.isEmpty()) {
				list.removeAll();
				for (int i = 0; i < itemsList.size(); i++) {
					list.add(itemsList.get(i).getRegistryResourcePath());
				}

			}
		}
	}

}

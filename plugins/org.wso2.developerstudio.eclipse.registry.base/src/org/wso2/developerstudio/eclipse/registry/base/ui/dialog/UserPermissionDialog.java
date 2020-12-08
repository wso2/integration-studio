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

package org.wso2.developerstudio.eclipse.registry.base.ui.dialog;

import org.apache.axis2.AxisFault;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.base.Activator;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.util.BaseConstants;
import org.wso2.developerstudio.eclipse.registry.resource.authorization.ResourceAdmin;
import org.wso2.developerstudio.eclipse.registry.resource.authorization.ResourceAdmin.Role;
import org.wso2.developerstudio.eclipse.usermgt.remote.UserManager;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserPermissionDialog extends Dialog {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private String[] titles = { "Role", "Read", "Write", "Delete", "Authorize" };
	private Table table;
	private RegistryResourceNode regResourceNode;
	private Button check = null;

	/**
	 * UserPermissionDialog constructor
	 * @param parentShell
	 * @param regNode
	 */
	public UserPermissionDialog(Shell parentShell,RegistryResourceNode regNode) {
		super(parentShell);
		this.regResourceNode = regNode;
	}

	/**
	 * create dialog
	 */
	public void create() {
		super.create();

	}

	/**
	 * create dialog area for the user permission dialog
	 */
	protected Control createDialogArea(final Composite parent) {
		parent.getShell().setText("Permissions for " +
								  regResourceNode.getConnectionInfo().getUrl().toString() + 
								  regResourceNode.getRegistryResourcePath());

		GridLayout gridLayout = new GridLayout(1, true);
		gridLayout.marginWidth = 5;
		parent.setLayout(gridLayout);

		Group group = new Group(parent, SWT.FILL);
		group.setLayoutData(new GridData(GridData.FILL_BOTH));
		gridLayout = new GridLayout(1, true);
		group.setLayout(gridLayout);

		createTable(group);
		try {
			loadData();
		} catch (RemoteException e) {
			log.error(e);
		} catch (Exception e) {
			log.error(e);
		}

		return super.createDialogArea(parent);
	}

	/**
	 * create table 
	 * @param composite
	 */
	public void createTable(Composite composite) {
		table = new Table(composite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		table.setHeaderVisible(false);
		table.setLinesVisible(false);
		GridData data = new GridData(GridData.FILL_BOTH);
		table.setLayoutData(data);
		createTableColumns();
	}

	/**
	 * create table columns with checkbox
	 */
	public void createTableColumns() {
		TableLayout tableLayout = new TableLayout();
		table.setLayout(tableLayout);
		tableLayout.addColumnData(new ColumnWeightData(10, 150, true));
		TableColumn column = new TableColumn(table, SWT.NONE | SWT.DM_FILL_NONE);

		column.setText(titles[0]);
		column.setAlignment(SWT.LEFT);
		for (int i = 1; i < titles.length; i++) {
			tableLayout.addColumnData(new ColumnWeightData(10, 80, false));
			column = new TableColumn(table, SWT.NONE);
			column.setText(titles[i]);
			column.setAlignment(SWT.CENTER);
		}

		column.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent event) {
			}

			public void widgetDefaultSelected(SelectionEvent event) {

			}
		});
	}

	private Map<String,Role> getRolePermissionMap(List<Role> roles){
		Map<String,Role> roleMap=new HashMap<String, ResourceAdmin.Role>();
		for (Role role : roles) {
	        roleMap.put(role.getRole(),role);
        }
		return roleMap;
	}
	
	/**
	 * load data for table
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void loadData() throws RemoteException, Exception {
		ResourceAdmin rsAd = regResourceNode.getConnectionInfo().getResourceAdmin();
		ArrayList<Role> resourceInfo = rsAd.getPermissionPerResource(regResourceNode
																		.getRegistryResourcePath());
		ArrayList<String> string=new ArrayList<String>();
		string.addAll(Arrays.asList(regResourceNode.getConnectionInfo().getUserManagerContent().getUserManager().getRoles("*")));
		
		table.removeAll();
		Map<String, Role> rolePermissionMap = getRolePermissionMap(resourceInfo);
		for (String roleName : string) {
			if (roleName.equals("admin")){
				continue;
			}
			TableItem tableItem=null;
			RoleData roleData=null;
			if (rolePermissionMap.containsKey(roleName)){
				Role role=rolePermissionMap.get(roleName);
				ArrayList<String> permissionListPerRole = role.getAssignedPermission();
				roleData = getRoleData(role.getRole(),regResourceNode.getRegistryResourcePath());

				tableItem = new TableItem(table, SWT.NULL);
				for (int j = 0; j < permissionListPerRole.size(); j++) {
					if (permissionListPerRole.get(j).equals(BaseConstants.READ)) {
						roleData.setReadPerm(true);
					}
					if (permissionListPerRole.get(j).equals(BaseConstants.WRITE)) {
						roleData.setWritePerm(true);
					}
					if (permissionListPerRole.get(j).equals(BaseConstants.DELETE)) {
						roleData.setDeletePerm(true);
					}
					if (permissionListPerRole.get(j).equals(BaseConstants.AUTHORIZE)) {
						roleData.setAuthPerm(true);
					}
				}
			}else{
				roleData = getRoleData(roleName,regResourceNode.getRegistryResourcePath());
		        tableItem = new TableItem(table, SWT.NULL);
			}
			tableItem.setText(roleData.role);
			createTable(tableItem, roleData);
        }
//		for (int i = 0; i < resourceInfo.size(); i++) {
//			
//			string.remove(resourceInfo.get(i).getRole());
//			
//			ArrayList<String> permissionListPerRole = resourceInfo.get(i).getAssignedPermission();
//			RoleData roleData = getRoleData(resourceInfo.get(i).getRole(),
//											regResourceNode.getRegistryResourcePath());
//
//			TableItem tableItem = new TableItem(table, SWT.NULL);
//			tableItem.setText(resourceInfo.get(i).getRole());
//			for (int j = 0; j < permissionListPerRole.size(); j++) {
//				if (permissionListPerRole.get(j).equals(BaseConstants.READ)) {
//					roleData.setReadPerm(true);
//				}
//				if (permissionListPerRole.get(j).equals(BaseConstants.WRITE)) {
//					roleData.setWritePerm(true);
//				}
//				if (permissionListPerRole.get(j).equals(BaseConstants.DELETE)) {
//					roleData.setDeletePerm(true);
//				}
//				if (permissionListPerRole.get(j).equals(BaseConstants.AUTHORIZE)) {
//					roleData.setAuthPerm(true);
//				}
//
//			}
//			createTable(tableItem, roleData);
//		}
//		
//		for (Iterator iterator = string.iterator(); iterator.hasNext();) {
//	        String string2 = (String) iterator.next();
//	        RoleData roleData = getRoleData(string2,
//											regResourceNode.getRegistryResourcePath());
//	        TableItem tableItem = new TableItem(table, SWT.NULL);
//			tableItem.setText(string2);
//			createTable(tableItem, roleData);
//        }
	}
	
	private void createTable(TableItem tableItem,RoleData roleData){

		
		tableItem.setData(roleData);
		createCheckBoxes(1, tableItem, 0, roleData);
		createCheckBoxes(2, tableItem, 1, roleData);
		createCheckBoxes(3, tableItem, 2, roleData);
		createCheckBoxes(4, tableItem, 3, roleData);
	}

	/**
	 * get role data 
	 * @param roleName
	 * @param resourcePath
	 * @return
	 */
	private RoleData getRoleData(String roleName, String resourcePath) {
		return new RoleData(roleName, resourcePath);
	}

	/**
	 * create check boxes
	 * @param tableIndex
	 * @param tabItem
	 * @param type
	 * @param roleData
	 */
	private void createCheckBoxes(int tableIndex, 
								  TableItem tabItem, 
								  int type,
								  RoleData roleData) {
		TableEditor editor = new TableEditor(table);
		boolean value = false;
		String permission = "";

		if (roleData.role.equals(BaseConstants.ADMIN)) {
			check = new Button(table, SWT.CHECK | SWT.READ_ONLY);
			value = true;
			if (type == 0) {
				permission = BaseConstants.READ;
			}
			if (type == 1) {
				permission = BaseConstants.WRITE;
			}
			if (type == 2) {
				permission = BaseConstants.DELETE;
			}
			if (type == 3) {
				permission = BaseConstants.AUTHORIZE;
			}
		} else {
			check = new Button(table, SWT.CHECK);
			if (type == 0) {
				permission = BaseConstants.READ;
				value = roleData.readPerm;
			}
			if (type == 1) {
				permission = BaseConstants.WRITE;
				value = roleData.writePerm;
			}
			if (type == 2) {
				permission = BaseConstants.DELETE;
				value = roleData.deletePerm;
			}
			if (type == 3) {
				permission = BaseConstants.AUTHORIZE;
				value = roleData.authPerm;
			}
		}
		check.setBackground(table.getBackground());
		editor.grabHorizontal = true;
		editor.setEditor(check, tabItem, tableIndex);
		check.setText(permission);
		check.setSelection(value);
		editor.layout();

		check.addSelectionListener(new RolePermissionSelectionListener(roleData));
	}

	/**
	 * RolePermissionSelectionListener inner class
	 * 
	 *
	 */
	public class RolePermissionSelectionListener implements SelectionListener {
		RoleData roleData;
		int type;

		/**
		 * RolePermissionSelectionListener constructor
		 * set the type variable according to the permission type
		 * @param roleData
		 */
		public RolePermissionSelectionListener(RoleData roleData) {
			this.roleData = roleData;
			int type;
			if (roleData.readPerm) {
				type = 0;
			} else if (roleData.writePerm) {
				type = 1;
			} else if (roleData.deletePerm) {
				type = 2;
			} else if (roleData.authPerm) {
				type = 3;
			} else {
				type = -1;
			}
		}

		/**
		 * triggered when check box is selected or de-selected
		 */
		public void widgetSelected(SelectionEvent event) {

			boolean b = ((Button) (event.widget)).getSelection();
			String permission = ((Button) (event.widget)).getText();

			if (permission == BaseConstants.READ) {
				roleData.setReadPerm(b);
				type = 0;
			} else if (permission == BaseConstants.WRITE) {
				roleData.setWritePerm(b);
				type = 1;
			} else if (permission == BaseConstants.DELETE) {
				roleData.setDeletePerm(b);
				type = 2;
			} else if (permission == BaseConstants.AUTHORIZE) {
				roleData.setAuthPerm(b);
				type = 3;
			}

			try {
				grantPermissionToRole(roleData);
			} catch (AxisFault e) {
				log.error(e);
			} catch (RemoteException e) {
				log.error(e);
			} catch (Exception e) {
				log.error(e);
			}

		}

		public void widgetDefaultSelected(SelectionEvent event) {

		}
	}

	/**
	 * grant permission to the role
	 * @param roleData
	 * @throws Exception
	 */
			
	private void grantPermissionToRole(RoleData roleData) throws Exception {
		String permission = null;

		RegistryNode regNode = regResourceNode.getConnectionInfo();
		ResourceAdmin resourceAdmin = regNode.getResourceAdmin();
		if (roleData.isReadPerm()) {
			permission = BaseConstants.READ;
			resourceAdmin.setPermissionPerResource(regResourceNode.getRegistryResourcePath(), 
												   permission, 
												   roleData.role, 
												   "1");
		}

		if (roleData.isWritePerm()) {
			permission = BaseConstants.WRITE;
			resourceAdmin.setPermissionPerResource(regResourceNode.getRegistryResourcePath(), 
													permission, 
													roleData.role, 
													"1");
		}

		if (roleData.isDeletePerm()) {
			permission = BaseConstants.DELETE;
			resourceAdmin.setPermissionPerResource(regResourceNode.getRegistryResourcePath(), 
												   permission, 
												   roleData.role, 
												   "1");
		}
		if (roleData.isAuthPerm()) {
			permission = BaseConstants.AUTHORIZE;
			resourceAdmin.setPermissionPerResource(regResourceNode.getRegistryResourcePath(), 
												   permission, 
												   roleData.role, 
												   "1");
		}
	}

	/**
	 * ok pressed event of the dialog
	 */
	protected void okPressed() {
		super.okPressed();
	}

	/**
	 * get roles for the user
	 * @return
	 */
	public String[] getRolesPerUser() {
		UserManager um = regResourceNode.getConnectionInfo().getUserManagerContent().getUserManager();
		String[] roles = um.getRoles("*");
		return roles;
	}

	/**
	 * get roles for the selected resource
	 * @return
	 */
	public ArrayList<String> getRolesPerResource() {
		String[] allRoles = getRolesPerUser();
		ArrayList<String> validRoles = new ArrayList<String>();
		for (int i = 0; i < allRoles.length; i++) {
			if (!allRoles[i].equals("admin")) {
				validRoles.add(allRoles[i]);
			}
		}
		return validRoles;
	}

	/**
	 * 
	 * inner class to represent role
	 *
	 */
	public static class RoleData {
		public String role;
		String[] allRoles;
		String[] allPermList;
		String[] selectedPermissionList;
		RegistryNode regData;
		String resourcePath;

		private boolean readPerm = false;
		private boolean writePerm = false;
		private boolean deletePerm = false;
		private boolean authPerm = false;

		public RoleData(String role, String resourcePath) {
			this.role = role;
			this.resourcePath = resourcePath;
		}

		public String getResourcePath() {
			return resourcePath;
		}

		public void setResourcePath(String resourcePath) {
			this.resourcePath = resourcePath;
		}

		public boolean isReadPerm() {
			return readPerm;
		}

		public void setReadPerm(boolean readPerm) {
			this.readPerm = readPerm;
		}

		public boolean isWritePerm() {
			return writePerm;
		}

		public void setWritePerm(boolean writePerm) {
			this.writePerm = writePerm;
		}

		public boolean isDeletePerm() {
			return deletePerm;
		}

		public void setDeletePerm(boolean deletePerm) {
			this.deletePerm = deletePerm;
		}

		public boolean isAuthPerm() {
			return authPerm;
		}

		public void setAuthPerm(boolean authPerm) {
			this.authPerm = authPerm;
		}

	}
}

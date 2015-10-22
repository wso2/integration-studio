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
import java.util.List;

import org.eclipse.jface.wizard.Wizard;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUserRole;
import org.wso2.developerstudio.eclipse.registry.base.ui.dialog.UserPermissionDialog.RoleData;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.ImageUtils;
import org.wso2.developerstudio.eclipse.registry.manager.remote.Activator;
import org.wso2.developerstudio.eclipse.registry.resource.authorization.ResourceAdmin;

public class ChangePermissionWizard extends Wizard {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private ChangePermissionWizardPage1 changePerWizPage1;
	private ChangePermissionWizardPage2 changePerWizPage2;
	private RegistryUserRole regUsrRole;
	private RegistryResourceNode regResPathData;
	protected boolean wsizPage1Completed = false;
	protected boolean wsizPage2Completed = false;
	private String[] initialPermList = { "Read", "Write", "Delete", "Authorize" };

	public ChangePermissionWizard(RegistryUserRole regUserRole,
			RegistryResourceNode regResPathData) {
		super();
		this.regUsrRole = regUserRole;
		this.regResPathData = regResPathData;
		setNeedsProgressMonitor(true);
		setWindowTitle("Change Role Permissions");
		setDefaultPageImageDescriptor(ImageUtils
				.getImageDescriptor(ImageUtils.WIZARD_ICON_SPECIFY_PERMISSION));
	}

	public boolean performFinish() {
		try {
			doFinish();
		} catch (Exception e) {
			log.error(e);
			return false;
		}

		return true;
	}

	public void doFinish() throws Exception {
		List<RoleData> permissionList = changePerWizPage2.selectedPermissions;

		ArrayList<String> permList = new ArrayList<String>();
		RegistryNode regData = regUsrRole.getRegistryUserRoleContent()
				.getRegistryUserManagerContainer().getRegistryData();
		ResourceAdmin resourceAdmin = regData.getResourceAdmin();

		for (int i = 0; i < permissionList.size(); i++) {
			for (int j = 0; j < initialPermList.length; j++) {
				resourceAdmin.setPermissionPerResource(permissionList.get(i)
						.getResourcePath(), initialPermList[j], regUsrRole
						.getUserRoleName(), "0");
			}

			if (permissionList.get(i).isReadPerm()) {
				permList.add("Read");
			}
			if (permissionList.get(i).isWritePerm()) {
				permList.add("Write");
			}
			if (permissionList.get(i).isDeletePerm()) {
				permList.add("Delete");
			}
			if (permissionList.get(i).isAuthPerm()) {
				permList.add("Authorize");
			}

			if (!permList.isEmpty()) {
				for (int j = 0; j < permList.size(); j++) {
					resourceAdmin.setPermissionPerResource(permissionList
							.get(i).getResourcePath(), permList.get(j),
							regUsrRole.getUserRoleName(), "1");
				}
			}
		}

	}

	public void addPages() {
		changePerWizPage1 = new ChangePermissionWizardPage1(
				"Change Permission", regUsrRole);
		addPage(changePerWizPage1);
		changePerWizPage2 = new ChangePermissionWizardPage2(
				"Change Permission", regUsrRole, changePerWizPage1);
		addPage(changePerWizPage2);
	}

}

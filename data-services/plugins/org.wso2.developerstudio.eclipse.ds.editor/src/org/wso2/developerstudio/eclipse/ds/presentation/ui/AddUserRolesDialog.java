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
package org.wso2.developerstudio.eclipse.ds.presentation.ui;

import java.util.List;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.ds.DataService;
import org.wso2.developerstudio.eclipse.ds.DataServiceParameter;
import org.wso2.developerstudio.eclipse.ds.DsFactory;
import org.wso2.developerstudio.eclipse.ds.DsPackage;
import org.wso2.developerstudio.eclipse.platform.ui.dialogs.UserRolesDialog;

public class AddUserRolesDialog extends UserRolesDialog {

	private DataService dataService;
	private List<String> selectedRoles;
	private String roleSet;
	private EditingDomain editingDomain;
	private Composite detailsclient;
	private DataServiceParameter parameter;

	private static final String ALLOW_ROLES = "allowRoles";

	public AddUserRolesDialog(Shell parentShell, DataService selectedObj,
			EditingDomain editingDomain, Composite composite) {
		super(parentShell, selectedObj);
		this.dataService = selectedObj;
		this.editingDomain = editingDomain;
		this.detailsclient = composite;
	}

	/**
	 * Updates the model
	 */
	@Override
	public void updateModel() {
		selectedRoles = UserRolesDialog.getSelectedUserRoles();

		StringBuilder commaSepValueBuilder = new StringBuilder();
		for (int i = 0; i < selectedRoles.size(); i++) {
			commaSepValueBuilder.append(selectedRoles.get(i));
			if (i != selectedRoles.size() - 1) {
				commaSepValueBuilder.append(",");
			}
			roleSet = commaSepValueBuilder.toString();
		}

		parameter = DsFactory.eINSTANCE.createDataServiceParameter();
		parameter.setName(ALLOW_ROLES);
		parameter.setValue(roleSet);
		updateSource(parameter);
		updateRolesField();
	}

	/**
	 * Updates the role field
	 * 
	 * @param roleSet
	 *            roleset
	 */
	private void updateRolesField() {
		Control[] children = detailsclient.getChildren();
		for (Control child : children) {
			if (child instanceof Text) {
				if (roleSet != null) {
					((Text) child).setText(roleSet);
				} else {
					((Text) child).setText("");
				}
			}
		}
	}

	/**
	 * Updates the source
	 * 
	 * @param parameter
	 *            DataService parameter
	 * @param roleSet
	 *            roleset
	 */
	private void updateSource(DataServiceParameter parameter) {

		SetCommand setCmd = new SetCommand(editingDomain, dataService,
				DsPackage.Literals.DATA_SERVICE__FEATURE_ALLOW_ROLES,
				parameter);
		if (setCmd.canExecute()) {
			editingDomain.getCommandStack().execute(setCmd);
		}
	}
}

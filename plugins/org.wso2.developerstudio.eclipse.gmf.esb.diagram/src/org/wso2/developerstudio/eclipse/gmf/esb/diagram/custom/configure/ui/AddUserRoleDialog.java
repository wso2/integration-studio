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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceParameter;

public class AddUserRoleDialog extends UserRolesDialog {

	private List<String> selectedRoles;
	private String roleSet;
	private TransactionalEditingDomain editingDomain;
	private CompoundCommand resultCommand;
	private static final String ALLOW_ROLES = "allowRoles";
	private ProxyService proxyService;

	public AddUserRoleDialog(Shell parentShell, ProxyService selectedObj) {
		super(parentShell, selectedObj);
		this.proxyService= selectedObj;
		this.editingDomain = TransactionUtil.getEditingDomain(proxyService);
	}

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
		
		ProxyServiceParameter parameter = EsbFactory.eINSTANCE
				.createProxyServiceParameter();
		parameter.setName(ALLOW_ROLES);
		parameter.setValue(roleSet);

		AddCommand addCmd = new AddCommand(editingDomain, proxyService,
				EsbPackage.Literals.PROXY_SERVICE__SERVICE_PARAMETERS,
				parameter);
		getResultCommand().append(addCmd);

		// Apply changes.
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
		}
	}

	private CompoundCommand getResultCommand() {
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
	}

}

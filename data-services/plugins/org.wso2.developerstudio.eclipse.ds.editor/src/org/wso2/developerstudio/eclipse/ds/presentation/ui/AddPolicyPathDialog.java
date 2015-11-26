/*
 * Copyright 2015 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.ds.presentation.ui;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.ds.DataService;
import org.wso2.developerstudio.eclipse.ds.DsFactory;
import org.wso2.developerstudio.eclipse.ds.DsPackage;
import org.wso2.developerstudio.eclipse.ds.RegistryKeyProperty;

public class AddPolicyPathDialog {

	private DataService dataService;
	private EditingDomain editingDomain;
	private Composite detailsclient;
	private Shell parentShell;
	private RegistryKeyProperty rkProperty;

	public AddPolicyPathDialog(Shell parentShell, DataService selectedObj,
			EditingDomain editingDomain, Composite composite) {
		this.dataService = selectedObj;
		this.editingDomain = editingDomain;
		this.detailsclient = composite;
		this.parentShell = parentShell;

	}

	/**
	 * Updates the model
	 */
	public void updateModel() {

		if (dataService.getPolicy() != null) {
			// Creates a RegistryKeyProperty when policykey is null
			if (StringUtils.isBlank(dataService.getPolicy().getKey())) {
				rkProperty = DsFactory.eINSTANCE.createRegistryKeyProperty();
			} else {
				// Assign the policy object when policy key is available
				rkProperty = dataService.getPolicy();
			}
		} else {
			// Creates a RegistryKeyProperty when dataservice object doesn't
			// contains a policy- Initial time of creating a dataservice
			rkProperty = DsFactory.eINSTANCE.createRegistryKeyProperty();
		}

		RegistryResourceBrowserDialog dialog = new RegistryResourceBrowserDialog(
				parentShell, SWT.NULL, rkProperty,
				new ArrayList<NamedEntityDescriptor>());
		dialog.open();
		rkProperty = dialog.getPolicyKey();

		updateSource();
		updatePolicyField();

	}

	/**
	 * Updates the source
	 * 
	 * @param rkProperty
	 *            Registry Key property
	 */
	private void updateSource() {
		SetCommand setCmd = new SetCommand(editingDomain, dataService,
				DsPackage.Literals.DATA_SERVICE__POLICY, rkProperty);
		if (setCmd.canExecute()) {
			editingDomain.getCommandStack().execute(setCmd);
		}
	}

	/**
	 * Updates the policy field in the editor
	 */
	private void updatePolicyField() {
		Control[] children = detailsclient.getChildren();
		for (Control child : children) {
			if (child instanceof Text) {
				if (rkProperty.getKey() != null
						&& !rkProperty.getKey().isEmpty()) {
					((Text) child).setText(rkProperty.getKey());
				} else {
					((Text) child).setText("");
				}
			}
		}
	}

}

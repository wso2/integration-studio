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

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.wso2.developerstudio.eclipse.registry.base.logger.ExceptionHandler;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUserRole;
import org.wso2.developerstudio.eclipse.registry.base.ui.controls.RegistryTreeViewer;

public class ChangePermissionWizardPage1 extends WizardPage {

	private RegistryResourceNode selectedRegResourcePathData;
	private RegistryNode regData;
	private RegistryUserRole regUsrRole;
	public RegistryTreeViewer r;
	private List<RegistryResourceNode> selectedItemsList;

	protected ChangePermissionWizardPage1(String pageName,
			RegistryUserRole regUserRole) {
		super(pageName);
		this.regUsrRole = regUserRole;
		setPageComplete(true);
		setDescription("Select resources you want to set permission");
	}

	public void createControl(Composite parent) {

		Composite container = new Composite(parent, SWT.BORDER);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);
		// layout.verticalSpacing = 10;
		GridData gd = new GridData(GridData.FILL_BOTH);
		container.setLayoutData(gd);

		r = new RegistryTreeViewer(container, SWT.MULTI | SWT.BORDER,
				new ExceptionHandler());
		regData = regUsrRole.getRegistryUserRoleContent()
				.getRegistryUserManagerContainer().getRegistryData();
		URL regUrl = regData.getUrl();
		regData.setEnabled(true);
		r.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
		RegistryNode regData2 = r.addRegistry(regUrl, regData
				.getRegistryContainer().getRegistryContent().get(0)
				.getRegistryResourcePath(), regData.getUsername(), regData
				.getPassword(), false);
		r.expandTree(regData2, regData.getRegistryContainer()
				.getRegistryContent().get(0).getRegistryResourcePath());

		setControl(container);
	}

	public void savePageInfo() {
		List<RegistryResourceNode> selectedCollectionList = r
				.getSelectedRegistryPathCollections();
		List<RegistryResourceNode> selectedResourceList = r
				.getSelectedRegistryPathResources();
	}

	public ArrayList<RegistryResourceNode> selectedItemList() {
		ArrayList<RegistryResourceNode> list = new ArrayList();
		for (int i = 0; i < r.getSelectedRegistryPathCollections().size(); i++) {
			list.add(r.getSelectedRegistryPathCollections().get(i));
		}
		for (int i = 0; i < r.getSelectedRegistryPathResources().size(); i++) {
			list.add(r.getSelectedRegistryPathResources().get(i));
		}
		return list;
	}

	public boolean canFlipToNextPage() {
		selectedItemsList = selectedItemList();
		if (!selectedItemsList.isEmpty()) {
			return true;
		}

		return false;
	}

}

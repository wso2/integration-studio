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

package org.wso2.developerstudio.eclipse.carbon.uibundle.ui;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.pde.internal.ui.wizards.plugin.AbstractFieldData;
import org.eclipse.pde.internal.ui.wizards.plugin.NewProjectCreationPage;
import org.eclipse.swt.widgets.Composite;

@SuppressWarnings("restriction")
public class NewCarbonUIProjectCreationPage extends NewProjectCreationPage {

	public NewCarbonUIProjectCreationPage(String pageName,
			AbstractFieldData data, boolean fragment,
			IStructuredSelection selection) {
		super(pageName, data, fragment, selection);
	}
	
	public IDialogSettings getDialogSettings() {
		return super.getDialogSettings();
	}

	public void createControl(Composite parent) {
		getDialogSettings().put("osgiProject", true);
		super.createControl(parent);
	}
}

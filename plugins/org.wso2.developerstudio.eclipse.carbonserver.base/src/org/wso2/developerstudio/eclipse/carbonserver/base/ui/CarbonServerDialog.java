/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.carbonserver.base.ui;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerInformation;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.ICarbonOperationManager;

public class CarbonServerDialog extends Dialog {
	CarbonServerInformation wsasServerInformation;
	int[] operationsToSupport;

	public String getSelectedServerId() {
		return wsasServerInformation.getServerId();
	}

	public CarbonServerDialog(Shell parent, int[] operationsToSupport) {
		super(parent);
		this.operationsToSupport = operationsToSupport;
	}

	protected Control createDialogArea(final Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 1;

		wsasServerInformation = new CarbonServerInformation();

		CarbonServerUIUtil.createWSASServerCombo(container, 3, operationsToSupport, wsasServerInformation);

		return super.createDialogArea(parent);
	}

}

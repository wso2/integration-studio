/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.ui.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TrustCertificateDialog extends Dialog {

	public static final int TEMP_ALLOW_ID = IDialogConstants.NO_TO_ALL_ID + 1;
	private String certInfo = null;

	public TrustCertificateDialog(Shell parentShell, String certInfo) {
		super(parentShell);
		setCertInfo(certInfo);
	}

	protected Control createDialogArea(final Composite parent) {
		parent.getShell().setText("Untrusted certificate");
		new Label(parent, SWT.MULTI | SWT.WRAP).setText("The following certificate appears to be untrusted. Do you want to add this to the list of trusted certificates?");
		Text certData = new Text(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.MULTI | SWT.READ_ONLY);
		certData.setLayoutData(new GridData(GridData.FILL_BOTH));
		certData.setText(getCertInfo());
		return super.createDialogArea(parent);
	}

	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.NO_ID, IDialogConstants.NO_LABEL, false);
		createButton(parent, IDialogConstants.YES_ID, IDialogConstants.YES_LABEL, true);
		createButton(parent, TEMP_ALLOW_ID, "Allow this once", false);
	}

	public void setCertInfo(String certInfo) {
		this.certInfo = certInfo;
	}

	public String getCertInfo() {
		return certInfo;
	}

}

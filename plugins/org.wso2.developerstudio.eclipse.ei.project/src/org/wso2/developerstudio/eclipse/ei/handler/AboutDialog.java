/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.ei.handler;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.platform.core.utils.ResourceManager;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;

public class AboutDialog extends Dialog {

	private static final String VERSION = "Version : 7.0.0";
	private static final String LICENSED = "Licensed under the Apache License, Version 2.0";
	private static final String URL = "https://wso2.com/integration/";
	private static final String EXT_POINT = "org.wso2.developerstudio.aboutDialog.contributor";
	private int logoWidth;
	private int logoHeight;

	public AboutDialog(Shell parentShell) {
		super(parentShell);
		setDefaultImage(ResourceManager.getPluginImage("org.wso2.developerstudio.eclipse.platform.ui",
                "icons/carbon-studio-small-logo.gif"));
    }

	protected Point getInitialSize() {
		return new Point(logoWidth + 60, logoHeight * 4 - 90);
	}

	@Override
	protected boolean isResizable() {
		// TODO Auto-generated method stub
		return true;
	}
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("About WSO2 Enterprise Integrator Tooling");
	}

	protected Control createDialogArea(Composite parent) {

		Image logoImage =
                ResourceManager.getPluginImage("org.wso2.developerstudio.eclipse.platform.ui",
                                               "icons/ei-tooling-logo.png");
		logoWidth = logoImage.getImageData().width;
		logoHeight = logoImage.getImageData().height;

		parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		Composite dialogArea = (Composite) super.createDialogArea(parent);
		dialogArea.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		dialogArea.setSize(new Point(logoWidth, logoHeight * 4 - 60));

		Composite composite = new Composite(dialogArea, SWT.BORDER);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite.setLayout(new GridLayout(1, false));
		composite.setSize(new Point(logoWidth + 45, logoHeight * 4 - 60));
		
		GridData gd_composite = new GridData(SWT.CENTER, SWT.TOP, true, true, 1, 1);
		gd_composite.widthHint = logoWidth + 45;
		gd_composite.heightHint = logoHeight * 4 - 60;
		 
		composite.setLayoutData(gd_composite);

		Label lblDevsLogo = new Label(composite, SWT.NONE);
		lblDevsLogo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblDevsLogo.setImage(logoImage);
		GridData gdDevsLogo = new GridData(SWT.CENTER, SWT.TOP, false, false, 1, 1);
		gdDevsLogo.widthHint = logoWidth;
		gdDevsLogo.heightHint = logoHeight;
		lblDevsLogo.setLayoutData(gdDevsLogo);

		Label lblVersion = new Label(composite, SWT.NONE);
		GridData versionGrid = new GridData();
		versionGrid.horizontalIndent = 25;
		lblVersion.setLayoutData(versionGrid);
		lblVersion.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
		lblVersion.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblVersion.setText(VERSION);
		
		Label lblLicense = new Label(composite, SWT.NONE);
		GridData licenseGrid = new GridData();
		licenseGrid.horizontalIndent = 25;
		lblLicense.setLayoutData(licenseGrid);
		lblLicense.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblLicense.setText(LICENSED);

		Link linkDevStudioUrl = new Link(composite, SWT.NONE);
		GridData urlGrid = new GridData();
		urlGrid.horizontalIndent = 25;
		linkDevStudioUrl.setLayoutData(urlGrid);
		linkDevStudioUrl.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		linkDevStudioUrl.setText("Visit :<a>" + URL + "</a>");
		linkDevStudioUrl.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				org.eclipse.swt.program.Program.launch(URL);
			}
		});

		addProductIcons(composite);
		return dialogArea;
	}

	private void addProductIcons(Composite parent) {

		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXT_POINT);
		for (IConfigurationElement element : config) {
			IExtension extension = element.getDeclaringExtension();
			if ("product".equals(element.getName())) {

				String version = element.getAttribute("version");
				String icon = element.getAttribute("icon");
				String name = element.getAttribute("name");
				String bundle_id = element.getAttribute("bundle_id");

				Image logoImage = ResourceManager.getPluginImage(bundle_id, icon);
				Label iconLable = new Label(parent, SWT.NONE);
				iconLable.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				iconLable.setImage(logoImage);
				iconLable.setTouchEnabled(true);
				iconLable.setToolTipText(name + " " + version);
			}

		}

	}
	
	protected void createButtonsForButtonBar(Composite parent) {
		parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		Button button = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		button.setFocus();
	}

}


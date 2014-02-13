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

package org.wso2.developerstudio.eclipse.greg.manager.remote.dialog;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.greg.base.logger.ExceptionHandler;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryURLNode;
import org.wso2.developerstudio.eclipse.greg.manager.remote.views.RegistryBrowserView;

public class RegistryInfoDialog extends Dialog {

	private String serverUrl;
	private String path;
	private String userName;
	private String passwd;
	private RegistryBrowserView view;
	private Shell mainShell;
	private RegistryURLNode regURLData;
	private boolean savePassword;

	private ExceptionHandler exceptionHandler;
	private ArrayList<RegistryNode> URLInfoList;
	private boolean dialogStatus = true;

	public RegistryInfoDialog(Shell parentShell, RegistryURLNode regUrlData) {
		super(parentShell);
		mainShell = parentShell;
		this.regURLData = regUrlData;
	}

	public void create() {
		super.create();
	}

	protected Control createDialogArea(final Composite parent) {
		parent.getShell().setText("Add Registry");
		GridData gd;
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		container.setLayout(layout);
		gd = new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_FILL);
		container.setLayoutData(gd);
		Label urlLabel = new Label(container, SWT.NONE);
		urlLabel.setText("URL: ");
		gd = new GridData();
		urlLabel.setLayoutData(gd);

		Text urlText = new Text(container, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		urlText.setLayoutData(gd);

		urlText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				Text url = (Text) event.widget;
				serverUrl = url.getText();
				setServerUrl(serverUrl);
			}
		});

		Label pathLabel = new Label(container, SWT.NONE);
		pathLabel.setText("Path: ");
		gd = new GridData();
		pathLabel.setLayoutData(gd);

		Text pathText = new Text(container, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		pathText.setLayoutData(gd);

		pathText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				Text url = (Text) event.widget;
				path = url.getText();
				setPath(path);
			}
		});
		Label userNameLabel = new Label(container, SWT.NONE);
		userNameLabel.setText("User Name: ");

		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 100;
		Text userNameText = new Text(container, SWT.BORDER);
		userNameText.setLayoutData(gd);
		userNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				Text uName = (Text) event.widget;
				userName = uName.getText();
				setUserName(userName);
			}
		});

		Label pwdLabel = new Label(container, SWT.NONE);
		pwdLabel.setText("Password: ");

		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 100;
		Text pwdText = new Text(container, SWT.PASSWORD | SWT.BORDER);
		pwdText.setLayoutData(gd);
		pwdText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent event) {
				Text pwd = (Text) event.widget;
				passwd = pwd.getText();
				setPasswd(passwd);

			}
		});

		final Button button = new Button(container, SWT.CHECK);
		button.setText("Save Credentials");
		button.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent arg0) {
				setSavePassword(button.getSelection());
			}

			public void widgetSelected(SelectionEvent arg0) {
				widgetDefaultSelected(arg0);

			}

		});

		urlText.setText("https://localhost:9443/");
		userNameText.setText("admin");
		pwdText.setText("admin");
		pathText.setText("/");
		return super.createDialogArea(parent);
	}

	protected void okPressed() {
		exceptionHandler = new ExceptionHandler();
		try {
			doFinish();
		} catch (MalformedURLException e) {
			dialogStatus = exceptionHandler.showMessage(mainShell,
					"Cannot establish the connection with given URL");
		} catch (URISyntaxException e) {
			dialogStatus = exceptionHandler.showMessage(mainShell,
					"Cannot establish the connection with given URL");
		} catch (Exception e) {
			dialogStatus = exceptionHandler.showMessage(mainShell,
					"Cannot establish the connection with given URL");
		}

		if (dialogStatus == true) {
			super.okPressed();
		}

	}

	public boolean isAllDatavalid() {
		return false;
	}

	public void doFinish() throws URISyntaxException, MalformedURLException {
		URI pathUri = new URI(getServerUrl());
		URL path = pathUri.toURL();
	}
	
	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String pwd) {
		this.passwd = pwd;
	}

	public RegistryURLNode getRegURLData() {
		return regURLData;
	}

	public void setRegURLData(RegistryURLNode regURLData) {
		this.regURLData = regURLData;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setSavePassword(boolean savePassword) {
		this.savePassword = savePassword;
	}

	public boolean isSavePassword() {
		return savePassword;
	}
}

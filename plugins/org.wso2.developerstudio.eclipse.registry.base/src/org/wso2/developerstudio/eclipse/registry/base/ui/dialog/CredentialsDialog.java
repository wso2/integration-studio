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

package org.wso2.developerstudio.eclipse.registry.base.ui.dialog;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URI;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
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
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.base.Activator;
import org.wso2.developerstudio.eclipse.registry.base.logger.ExceptionHandler;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryCredentialData;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryUrlStore;
import org.wso2.developerstudio.eclipse.registry.resource.authorization.ResourceAdmin;

public class CredentialsDialog extends Dialog {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private String userName;
	private String passwd;
	private boolean savePassword;
	private String registryUrl;
	private static final int RESET_ID = IDialogConstants.NO_TO_ALL_ID + 1;
	private Text usernameField;
	private Text passwordField;
    private String oldUsername;
	/**
	 * CredentialsDialog constructor
	 * @param parentShell
	 * @param registryUrl
	 * @param username
	 */
	public CredentialsDialog(Shell parentShell, String registryUrl,String username) {
		super(parentShell);
		if ("null".equals(username)) {
			userName = "admin";
		} else {
			userName = username;
		}
		oldUsername = username;
		this.registryUrl = registryUrl;
	}

	/**
	 * create dialog
	 * method inherited by Dialog super class
	 */
	public void create() {
		super.create();

	}

	/**
	 * create dialog area
	 * method inherited by Dialog super class
	 */
	protected Control createDialogArea(final Composite parent) {
		parent.getShell().setText("Registry Credentials: " + registryUrl);
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		container.setLayout(layout);

		Label usernameLabel = new Label(container, SWT.RIGHT);
		usernameLabel.setText("Username: ");

		usernameField = new Text(container, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		usernameField.setLayoutData(data);

		Label passwordLabel = new Label(container, SWT.RIGHT);
		passwordLabel.setText("Password: ");

		passwordField = new Text(container, SWT.BORDER | SWT.PASSWORD);
		data = new GridData(GridData.FILL_HORIZONTAL);
		passwordField.setLayoutData(data);

		usernameField.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				setUserName(usernameField.getText());
			}
		});

		passwordField.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				setPasswd(passwordField.getText());

			}
		});

		new Label(container, SWT.RIGHT);
		final Button button = new Button(container, SWT.CHECK | SWT.RIGHT);
		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_END;
		button.setLayoutData(gd);
		button.setText("Save Credentials");
		button.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent arg0) {
				setSavePassword(button.getSelection());
			}

			public void widgetSelected(SelectionEvent arg0) {
				widgetDefaultSelected(arg0);
			}
		});

		usernameField.setText(getUserName());
		if (usernameField.getText().equals(""))
			usernameField.setFocus();
		else
			passwordField.setFocus();
		return super.createDialogArea(parent);
	}

	/**
	 * check whether information entered in the dialog is valid
	 * @return
	 */
	public boolean isAllDatavalid() {
		return false;
	}

	/**
	 * get UserName
	 * @return
	 */
	public String getUserName() {
		if (userName==null){
			userName="admin";
		}
		return userName;
	}

	/**
	 * set UserName
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 *  get password
	 * @return
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * set password
	 * @param pwd
	 */
	public void setPasswd(String pwd) {
		this.passwd = pwd;
	}

	/**
	 * set save password
	 * @param savePassword
	 */
	public void setSavePassword(boolean savePassword) {
		this.savePassword = savePassword;
	}

	/**
	 * check whether save password option is set
	 * @return
	 */
	public boolean isSavePassword() {
		return savePassword;
	}

	/**
	 * create buttons for the dialog
	 */
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		createButton(parent, RESET_ID, "Reset All", false);
	}

	/**
	 * action to do if "Reset All" button is pressed
	 */
	protected void buttonPressed(int buttonId) {
		if (buttonId == RESET_ID) {
			usernameField.setText("");
			passwordField.setText("");
		} else {
			super.buttonPressed(buttonId);
		}
	}
	
	protected void okPressed() {
		URL hostUrl=null;
		ExceptionHandler exceptionHandler = new ExceptionHandler();
        try {
	        hostUrl = new URL(getServerUrl());
//	        if(urlValid(hostUrl)){
			ResourceAdmin rsAdmin = new ResourceAdmin(getServerUrl(),
					getUserName(), getPasswd());
			if (rsAdmin.isUserAuthenticate(getUserName(), getPasswd(), hostUrl)) {
				if (oldUsername==null || !userName.equals(oldUsername)) {
					RegistryUrlStore.getInstance().modifyRegistryUrl(
							registryUrl, userName, oldUsername);
				}
				super.okPressed();
				// }
				// if(passwd.equals(RegistryCredentialData.getInstance().getPassword(registryUrl))){
				// super.okPressed();
			} else {
				exceptionHandler.showMessage(getShell(),
						"Incorrect credentials");
				// usernameField.setText("");
				passwordField.setText("");
			}
//	        }else{
//	        	exceptionHandler.showMessage(getShell(), "Cannot establish the connection with given URL.");
//	        }
        } catch (MalformedURLException e) {
	        log.error(e);
			exceptionHandler.showMessage(getShell(), "Specified Remote Server is not running.");
			this.close();
        } catch (Exception e) {
        	log.error(e);
			exceptionHandler.showMessage(getShell(), "Specified Remote Server is not running.");
			this.close();
		} 
		
		
	}
	
	/**
	 * get server url 
	 * @return
	 */
	public String getServerUrl() {
		URL url=null;
        try {
        	url = new URL(registryUrl);
        } catch (MalformedURLException e) {
	        log.error(e);
        }
//		URL url = getUrl();
        StringBuffer sb=new StringBuffer();
        sb.append(url.toString().replaceAll("/$","").concat("/").replaceAll("/carbon/|/registry/","/"));
    /*    sb.append(url.getProtocol()).append("://").append(url.getHost()).append(":").append(url.getPort()).append("/");
		String[] pathSegments = url.getPath().split("/");
		for (int i = 0; i < pathSegments.length - 1; i++) {
			String pathSegment = pathSegments[i];
			if (!pathSegment.trim().equalsIgnoreCase("")){
				sb.append(pathSegment).append("/");
			}
		}*/
		return sb.toString();
	}
	
	public boolean urlValid(URL url){
		try {
			int status = ((HttpURLConnection) url.openConnection()).getResponseCode();
			if(status > 0){
				return true;
			}
		} catch (IOException e1) {
			return false;
		}
		return false;
	}
}

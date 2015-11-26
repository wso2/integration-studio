/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.appfactory.ui.actions;

import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.appfactory.core.authentication.Authenticator;
import org.wso2.developerstudio.appfactory.core.authentication.UserPasswordCredentials;
import org.wso2.developerstudio.appfactory.core.client.CloudAdminServiceClient;
import org.wso2.developerstudio.appfactory.core.client.HttpsJaggeryClient;
import org.wso2.developerstudio.appfactory.core.jag.api.JagApiProperties;
import org.wso2.developerstudio.appfactory.ui.Activator;
import org.wso2.developerstudio.appfactory.ui.preference.AppFactoryPreferencePage;
import org.wso2.developerstudio.appfactory.ui.views.PasswordDialog;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class LoginAction {
	 private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	 private String username="";
	 private String password="";
/*	 private Authenticator authenticator;
	 private UserPasswordCredentials credentials;*/
	 private Shell activeShell;
	 private IPreferenceStore preferenceStore;
	 private boolean isCansel;
	 private boolean isSave;
	 private boolean isAppCloud;
	 
	 public IPreferenceStore getPreferenceStore() {
		return preferenceStore;
	}

	public void setPreferenceStore(IPreferenceStore preferenceStore) {
		this.preferenceStore = preferenceStore;
	}

	public Shell getActiveShell() {
		return activeShell;
	}

	public void setActiveShell(Shell activeShell) {
		this.activeShell = activeShell;
	}

	public LoginAction() throws Exception{
		 preferenceStore = Activator.getDefault().getPreferenceStore();
	//	 authenticator = Authenticator.getInstance();
		 activeShell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
		 if(preferenceStore.getString(AppFactoryPreferencePage.APP_FACTORY_LOCATION).isEmpty()){
			 preferenceStore.setDefault(AppFactoryPreferencePage.APP_FACTORY_LOCATION, JagApiProperties.getDomain());
		 }
		 setLoginUrl(preferenceStore.getString(AppFactoryPreferencePage.APP_FACTORY_LOCATION));
		 setUsername(preferenceStore.getString(AppFactoryPreferencePage.APP_FACTORY_USERNAME));
		 setPassword(preferenceStore.getString(AppFactoryPreferencePage.APP_FACTORY_PASSWORD));
		 String val = preferenceStore.getString(AppFactoryPreferencePage.APP_FACTORY_SAVE);
		 HttpsJaggeryClient.setSotimeout(preferenceStore.getInt(AppFactoryPreferencePage.SO_TIME_OUT));
		 HttpsJaggeryClient.setRetryDelay(preferenceStore.getInt(AppFactoryPreferencePage.RETRY_DELAY));
		 if("true".equals(val)){
			 setSave(true);
		 }else{
			 setSave(false);
		 }
		 String isCloud = preferenceStore.getString(AppFactoryPreferencePage.APP_CLOUD_LOGIN);
		 
		 if(isCloud.equals("true") || isCloud.isEmpty()){
			 isAppCloud = true;
		 }else if(isCloud.equals("false")){
			 isAppCloud = false;
		 }
	 }
	
	public boolean login(boolean isFromDashboad,boolean logoutAndLogin) {
		boolean val = true;
		try { 
			
			if(!isSave){
				showLoginDialog(isFromDashboad);
			}else if(logoutAndLogin){
				showLoginDialog(isFromDashboad);
			}else{
				
				Authenticator.getInstance().setServerURL(JagApiProperties.getLoginUrl());
				Authenticator.getInstance().setCredentials(new UserPasswordCredentials(getUsername()
						, getPassword()));
			}
			if(isCansel){
				return false;
			}
		    if(!val){
                setCursorNormal();
		    }
		    if((isSave())&& (Authenticator.getInstance().getCredentials()!=null)){
				  preferenceStore.setValue(AppFactoryPreferencePage.APP_FACTORY_LOCATION, JagApiProperties.getDomain());
				  preferenceStore.setValue(AppFactoryPreferencePage.APP_FACTORY_USERNAME,getUsername());
				  preferenceStore.setValue(AppFactoryPreferencePage.APP_FACTORY_PASSWORD,getPassword());
				  preferenceStore.setValue(AppFactoryPreferencePage.APP_FACTORY_SAVE,"true");
				  
				  if(isAppCloud()){
					  preferenceStore.setValue(AppFactoryPreferencePage.APP_CLOUD_LOGIN,"true");
				  }else{
					  preferenceStore.setValue(AppFactoryPreferencePage.APP_CLOUD_LOGIN,"false");
				  }
			}
		} catch (Exception e) {
			log.error("Login fail", e);
	        return false;
		} 
		return val;
	}

	private void setCursorNormal() {
		try {
			Display.getCurrent()
			.getActiveShell()
			.setCursor(
					(new Cursor(Display.getCurrent(), SWT.CURSOR_ARROW)));
		} catch (Throwable e) {
         /*safe to ignore*/
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLoginUrl(String loginUrl) {
		JagApiProperties.setDomain(loginUrl);
	}
	
	private void showLoginDialog(boolean isFromDashboad){
		  PasswordDialog dialog = new PasswordDialog(activeShell, this);
		  dialog.setHost(JagApiProperties.getDomain());
		  dialog.setUser(getUsername());
		  dialog.setPassword(getPassword());
		  dialog.setIsfromDashboad(isFromDashboad);
		  dialog.setAppCloud(isAppCloud);
		  
		 if (dialog.open() == Window.OK) {
			  setUsername(dialog.getUser());
			  setPassword(dialog.getPassword());
			  setLoginUrl(dialog.getHost());
			  setSave(dialog.isSave());
			  setAppCloud(dialog.isAppCloud());
		 }else {
			   this.setCansel(true);
		 } 
	}

	public boolean isCansel() {
		return isCansel;
	}

	public void setCansel(boolean isCansel) {
		this.isCansel = isCansel;
	}
	public boolean isSave() {
		return isSave;
	}

	public void setSave(boolean isSave) {
		this.isSave = isSave;
	}
	public boolean isAppCloud() {
		return isAppCloud;
	}

	public void setAppCloud(boolean isAppCloud) {
		this.isAppCloud = isAppCloud;
	}
	static final String DASHBOARD_VIEW_ID = "org.wso2.developerstudio.eclipse.dashboard";

}

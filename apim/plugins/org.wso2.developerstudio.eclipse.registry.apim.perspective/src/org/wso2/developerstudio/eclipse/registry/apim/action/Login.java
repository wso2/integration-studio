/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.registry.apim.action;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.apim.perspective.Activator;
import org.wso2.developerstudio.eclipse.registry.apim.preferance.ApimPreferencePage;


public class Login {
	
	 private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	 private String username="";
	 private String password="";
	 private String url="";
	 private String regpath="";
	public Login() throws Exception{
		
         IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
		 PlatformUI.getWorkbench().getDisplay().getActiveShell();
		
		if (preferenceStore.getString(ApimPreferencePage.APIM_URL).isEmpty()) {
			preferenceStore.setDefault(ApimPreferencePage.APIM_URL, ApimPreferencePage.APIM_DEFAULT_URL);
		}
		if (preferenceStore.getString(ApimPreferencePage.APIM_USERNAME).isEmpty()) {
			preferenceStore.setDefault(ApimPreferencePage.APIM_USERNAME, ApimPreferencePage.APIM_DEFAULT_USERNAME);
		}
		if (preferenceStore.getString(ApimPreferencePage.APIM_PASSWORD).isEmpty()) {
			preferenceStore.setDefault(ApimPreferencePage.APIM_PASSWORD, ApimPreferencePage.APIM_DEFAULT_PASSWORD);
		}
		if (preferenceStore.getString(ApimPreferencePage.APIM_REG_DEFAULT_PATH).isEmpty()) {
			preferenceStore.setDefault(ApimPreferencePage.APIM_REG_DEFAULT_PATH,
					ApimPreferencePage.APIM_CUSTOMSEQUENCES_PATH);
		}
		  
		 setUrl(preferenceStore.getString(ApimPreferencePage.APIM_URL));
		 setUsername(preferenceStore.getString(ApimPreferencePage.APIM_USERNAME));
		 setPassword(preferenceStore.getString(ApimPreferencePage.APIM_PASSWORD));
		 setRegpath(preferenceStore.getString(ApimPreferencePage.APIM_REG_DEFAULT_PATH));

	 }
	public static IDeveloperStudioLog getLog() {
		return log;
	}
	public static void setLog(IDeveloperStudioLog log) {
		Login.log = log;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRegpath() {
		return regpath;
	}
	public void setRegpath(String regpath) {
		this.regpath = regpath;
	}

}

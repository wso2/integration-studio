/* Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.appfactory.core.authentication;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.appfactory.core.Activator;
import org.wso2.developerstudio.appfactory.core.client.HttpsJaggeryClient;
import org.wso2.developerstudio.appfactory.core.jag.api.JagApiProperties;
import org.wso2.developerstudio.appfactory.core.model.ErrorType;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class Authenticator {
	
	private String serverURL;
	private static Authenticator authanticator = null;
	private UserPasswordCredentials credentials;
	private String result;
	private boolean loginCancel;
	private ErrorType errorcode;
    private String errormsg;
    private boolean fromDashboad;
    private boolean loaded;
    private boolean isAppCloud;
    private String selectedTenant;

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	protected Authenticator() {

	}
	public static Authenticator getInstance() {
		if (authanticator == null) {
			authanticator = new Authenticator();
		}
		return authanticator;
	}

	public boolean Authenticate(String serverUrl,UserPasswordCredentials credentials) throws
	Exception {
	    ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(
	    		Display.getDefault().getActiveShell());
		progressMonitorDialog.create();
		progressMonitorDialog.open();
		progressMonitorDialog.run(true, false, new LoginToAppFacPerfectiveJob(
				credentials,serverUrl,this));
		
		while(true){
			if("true".equals(this.result)){
				this.setServerURL(serverUrl);
				this.credentials = credentials;
				return true;
			}else if("false".equals(this.result)){
				return false;
			}
		}
		
	}
	
	public boolean reLogin()
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("action", "login");
		params.put("userName", credentials.getUser());
		params.put("password", credentials.getPassword());
		String value = HttpsJaggeryClient.httpPostLogin(JagApiProperties.getLoginUrl(), params);
		if (!"false".equals(value)) {
			 return true;
		}else{
			 return false;
		}
			 
	}

	public UserPasswordCredentials getCredentials() {
		return credentials;
	}

	public void setCredentials(UserPasswordCredentials credentials) {
		this.credentials = credentials;
	}

	public boolean isLoginCancel() {
		return loginCancel;
	}

	public void setLoginCancel(boolean loginCancel) {
		this.loginCancel = loginCancel;
	}

	public ErrorType getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(ErrorType errorcode) {
		this.errorcode = errorcode;
	}

	public boolean isFromDashboad() {
		return fromDashboad;
	}

	public void setFromDashboad(boolean fromDashboad) {
		this.fromDashboad = fromDashboad;
	}

	public boolean isLoaded() {
		return loaded;
	}

	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

	public String getServerURL() {
		return serverURL;
	}

	public void setServerURL(String serverURL) {
		this.serverURL = serverURL;
	}

	public boolean isAppCloud() {
		return isAppCloud;
	}

	public void setAppCloud(boolean isAppCloud) {
		this.isAppCloud = isAppCloud;
	}

	public String getSelectedTenant() {
		return selectedTenant;
	}

	public void setSelectedTenant(String selectedTenant) {
		this.selectedTenant = selectedTenant;
	}

	private class LoginToAppFacPerfectiveJob implements IRunnableWithProgress {
		private IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
		UserPasswordCredentials credentials;
		String serverUrl;
		Authenticator authenticator;
		
	 public LoginToAppFacPerfectiveJob(UserPasswordCredentials credentials,String serverUrl,
			 Authenticator authenticator) {
		 this.credentials = credentials;
		 this.serverUrl = serverUrl;
		 this.authenticator = authenticator;
	}
	  
		@Override
		public void run(IProgressMonitor monitor) {
			String operationText="fetching data from App Factory "+JagApiProperties.getDomain();
			monitor.beginTask(operationText, 100);
			try{
				operationText="Sending login request...";
				monitor.subTask(operationText);
				monitor.worked(20);
				Map<String, String> params = new HashMap<String, String>();
				params.put("action", "login");
				params.put("userName", credentials.getUser());
				params.put("password", credentials.getPassword());
				String value = HttpsJaggeryClient.httpPostLogin(serverUrl, params);
				if (!"false".equals(value)) {
					authenticator.setResult("true");
				}else{
					authenticator.setResult("false");	
				}
				monitor.subTask(operationText);
				monitor.worked(80);
			}catch(Exception e){
				log.error("Login process has been failed", e) ;
				authenticator.setResult("false");
							operationText=e.getMessage();
				monitor.beginTask(operationText, 100);
				monitor.worked(0);
				monitor.setCanceled(true);
			}
			
			monitor.worked(100);
			monitor.done();
		}
	}
 
}

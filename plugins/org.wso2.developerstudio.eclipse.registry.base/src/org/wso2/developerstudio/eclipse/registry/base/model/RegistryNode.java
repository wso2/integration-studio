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

package org.wso2.developerstudio.eclipse.registry.base.model;

import java.net.URL;

import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.registry.base.core.Registry;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryCredentialData;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryURLInfo;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryCredentialData.Credentials;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.SWTControlUtils;
import org.wso2.developerstudio.eclipse.registry.resource.authorization.ResourceAdmin;

public class RegistryNode {
	private String username;
	private String password;
	private RegistryContentContainer registryContent;
	private RegistryUserManagerContainer userManagerContent;
	private Registry registry;
	private RegistryURLInfo registryUrlInfo;
	private RegistryURLNode regUrlData;
	private boolean iterativeRefresh;
	private ResourceAdmin resourceAdmin;
	private boolean connectionValid=false;
	private boolean enabled=true;
	private boolean userEnabled=true;
	private boolean isFirstTimeEnableAccess=true;
	
	/**
	 * RegistryData constructor
	 * set registry content object and usermanagerContainer object
	 * @param registryUrlInfo
	 * @param password
	 * @param regUrlData
	 */
	public RegistryNode(RegistryURLInfo registryUrlInfo, 
						String password,
						RegistryURLNode regUrlData) {
		this.setRegistryUrlInfo(registryUrlInfo);
		this.password = password;
		this.username = registryUrlInfo.getUsername();
		this.regUrlData = regUrlData;
		setRegistryContent(new RegistryContentContainer());
		setUserManagerContent(new RegistryUserManagerContainer(this));
		getRegistryContainer().addRegistryContent(new RegistryResourceNode(this, 
																		registryUrlInfo.getPath(),
																		null));
	}

	/**
	 * get remote registry url
	 * @return
	 */
	public URL getUrl() {
		return getRegistryUrlInfo().getUrl();
	}

	/**
	 * set remote registry url
	 * @param url
	 */
	public void setUrl(URL url) {
		getRegistryUrlInfo().setUrl(url);
	}

	/**
	 * get the username. if the username is null, get the user name from RegistryCredentialData or
	 * RegistryUrlInfo
	 * @return
	 */
	public String getUsername() {
		if (username == null || username.equalsIgnoreCase(""))
			username = RegistryCredentialData.getInstance().getUsername(getUrl().toString());
		if (username == null || username.equalsIgnoreCase(""))
			username = getRegistryUrlInfo().getUsername();
		return username;
	}

	/**
	 * set the user name of the RegistryUrlInfo class and username variable
	 * @param username
	 */
	public void setUsername(String username) {
		getRegistryUrlInfo().setUsername(username);
		this.username = username;
	}

	/**
	 * get the password of the user
	 * @return
	 */
	public String getPassword() {
		if (getUsername()==null){
			password=null;
		}else {if (password == null && 
						getUsername().equals(RegistryCredentialData.getInstance().getUsername(getUrl().toString()))){
				password = RegistryCredentialData.getInstance().getPassword(getUrl().toString());
			}
		}
		return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * caption for the registry tree view
	 */
	public String toString() {
		return getCaption();
	}

	/**
	 * caption for the registry tree view
	 * @return
	 */
	public String getCaption() {
		String caption = getUrl().toString();
		if (getUsername()!=null && !getUsername().equals("")){
			if(!getUsername().equals("null")){
				caption = getUsername() + "@" + caption;
			}
		}
		return caption;
	}

	/**
	 * set registry object
	 * @param registry
	 */
	public void setRegistry(Registry registry) {
		this.registry = registry;
	}

	/**
	 * get the registry instance
	 * if the registry is null, create a new instance of registry with the info from Credentials
	 * @return
	 */
	public Registry getRegistry() {
		if (registry == null) {
			Credentials credentials = getCredentials();
			if (credentials == null){
				setConnectionValid(false);
				return null;
			}
			setUsername(credentials.getUsername());
			setPassword(credentials.getPassword());
			Registry registryConnection = new Registry(getUsername(), getPassword(), getUrl().toString());
			setConnectionValid(true);
			registry=registryConnection;
		}
		return registry;
	}
	

	/**
	 * get the credentials for the user
	 * @return
	 */
	public Credentials getCredentials() {
		Credentials credentials = null;
		if (getPassword() == null) {
			try {
				CredentialRequester credentialRequester = new CredentialRequester();
				Display.getDefault().syncExec(credentialRequester);
				credentials=credentialRequester.getCredentials();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			credentials = new Credentials(getUsername(), getPassword());
		}
		return credentials;
	}

	private class CredentialRequester implements Runnable{
		private Credentials credentials;
		
		public void run() {
			credentials = SWTControlUtils.requestCredentials(Display.getDefault().getActiveShell(), 
					 getUrl().toString(),
					 getUsername());
		}
		
		public Credentials getCredentials(){
			return credentials;
		}
	}
	/**
	 * set RegistryURLData object
	 * @param regUrlData
	 */
	public void setRegUrlData(RegistryURLNode regUrlData) {
		this.regUrlData = regUrlData;
	}

	/**
	 * get RegistryURLData object
	 * @return
	 */
	public RegistryURLNode getRegUrlData() {
		return regUrlData;
	}

	/**
	 * set iterative refresh if enabled
	 * @param enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled=enabled;
		if (enabled){
			getRegistryContainer().setIterativeRefresh(true);
		}else{
			resetAllConnections();
		}
	}

	public void setPersistantEnabled(boolean enabled) {
		registryUrlInfo.setEnabled(enabled);
		setEnabled(enabled);
	}
	
	private void resetAllConnections() {
		resetRegistryConnection();
		resetUserManager();
	}

	private void resetUserManager() {
		getUserManagerContent().resetUserManager();
	}

	private void resetRegistryConnection() {
		registry = null;
	}
	

	/**
	 * 
	 * @return
	 */
	public boolean isEnabled() {
		if (isFirstTimeEnableAccess){
			enabled=registryUrlInfo.isEnabled();
			setUserEnabled(enabled);
			isFirstTimeEnableAccess=false;
		}
		return enabled;
	}

	public void setUserEnabled(boolean userEnabled) {
		this.userEnabled = userEnabled;
	}

	public boolean isUserEnabled() {
		return userEnabled;
	}

	/**
	 * 
	 * @param registryUrlInfo
	 */
	public void setRegistryUrlInfo(RegistryURLInfo registryUrlInfo) {
		this.registryUrlInfo = registryUrlInfo;
	}

	/**
	 * 
	 * @return
	 */
	public RegistryURLInfo getRegistryUrlInfo() {
		return registryUrlInfo;
	}

	public String getRegistryStartingPath(){
		return getRegistryUrlInfo().getPath();
	}
	
	/**
	 * 
	 * @param registryContent
	 */
	public void setRegistryContent(RegistryContentContainer registryContent) {
		this.registryContent = registryContent;
	}

	/**
	 * 
	 * @return
	 */
	public RegistryContentContainer getRegistryContainer() {
		return registryContent;
	}

	public void setIterativeRefresh(boolean iterativeRefresh) {
		this.iterativeRefresh = iterativeRefresh;
		if (iterativeRefresh) {
			resetAllConnections();
			getRegistryContainer().setIterativeRefresh(true);
			getUserManagerContent().setIterativeRefresh(true);
		}
	}

	/**
	 * get value of iterative refresh variable
	 * @return
	 */
	public boolean isIterativeRefresh() {
		return iterativeRefresh;
	}

	/**
	 * 
	 * @param userManagerContent
	 */
	public void setUserManagerContent(RegistryUserManagerContainer userManagerContent) {
		this.userManagerContent = userManagerContent;
	}

	/**
	 * get the RegistryUserManagerContainer instance
	 * @return
	 */
	public RegistryUserManagerContainer getUserManagerContent() {
		if (userManagerContent == null) {
			userManagerContent = new RegistryUserManagerContainer(this);
		}
		return userManagerContent;
	}

	/**
	 * get the ResourceAdmin instance
	 * @return
	 */
	public ResourceAdmin getResourceAdmin() {
		if (resourceAdmin == null) {
			resourceAdmin = new ResourceAdmin(getServerUrl().toString(),
					getCredentials().getUsername(), getCredentials()
							.getPassword());
		}
		return resourceAdmin;
	}

	/**
	 * get server url 
	 * @return
	 */
	public String getServerUrl() {
		URL url = getUrl();
		StringBuffer sb=new StringBuffer();
	    sb.append(url.toString().replaceAll("/$","").concat("/").replaceAll("/carbon/","/"));
		/*sb.append(url.getProtocol()).append("://").append(url.getHost()).append(":").append(url.getPort()).append("/");
		String[] pathSegments = url.getPath().split("/");
		for (int i = 0; i < pathSegments.length - 1; i++) {
			String pathSegment = pathSegments[i];
			if (!pathSegment.trim().equalsIgnoreCase("")){
				sb.append(pathSegment).append("/");
			}
		} */
		return sb.toString();
	}
	
	public void setConnectionValid(boolean connectionValid) {
		if (!this.connectionValid && connectionValid){
			this.connectionValid = connectionValid;
			setIterativeRefresh(true);
			getRegUrlData().refreshViewer(true);
			
		}
		this.connectionValid = connectionValid;
	}

	public boolean isConnectionValid() {
		return connectionValid;
	}
}

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

import java.util.List;

import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryCredentialData.Credentials;
import org.wso2.developerstudio.eclipse.usermgt.remote.UserManager;

public class RegistryUserManagerContainer {
	private static final String USER_STORE = "UserStore";
	private RegistryUserContainer userContent;
	private RegistryUserRoleContainer userRoleContent;
	private RegistryNode registryNode;
	
	public RegistryNode getRegistryNode() {
		return registryNode;
	}

	private UserManager userManager;
	private boolean iterativeRefresh = false;
	

	
	/**
	 * RegistryUserManagerContainer constructor
	 * @param registryNode
	 */
	public RegistryUserManagerContainer(RegistryNode registryNode) {
		setRegistryNode(registryNode);
	}

	/**
	 * return RegistryUserContainer
	 * @return
	 */
	public RegistryUserContainer getUserContent() {
		if (userContent == null) {
			userContent = new RegistryUserContainer(this);
		}
		return userContent;
	}

	/**
	 * return RegistryUserRoleContainer
	 * @return
	 */
	public RegistryUserRoleContainer getUserRoleContent() {
		if (userRoleContent == null) {
			userRoleContent = new RegistryUserRoleContainer(this);
		}
		return userRoleContent;
	}

	/**
	 * set RegistryNode instance
	 * @param registryND
	 */
	public void setRegistryNode(RegistryNode registryND) {
		this.registryNode = registryND;
	}

	/**
	 * get RegistryNode instance
	 * @return
	 */
	public RegistryNode getRegistryData() {
		return registryNode;
	}

	/**
	 * get the caption for the top level registry tree
	 * @return
	 */
	public String getCaption() {
		return USER_STORE;
	}

	/**
	 * get the user name caption
	 */
	public String toString() {
		return getCaption();
	}

	/**
	 * get credentials
	 * @return
	 */
	public Credentials getCredentials() {
		return getRegistryData().getCredentials();
	}

	/**
	 * get user manager instance
	 * @return
	 */
	public UserManager getUserManager() {
		if (userManager == null) {
			Credentials credentials = getCredentials();
			userManager = new UserManager(registryNode.getServerUrl(),
										  credentials.getUsername(), 
										  credentials.getPassword());
		}
		return userManager;
	}
	
	public void resetUserManager(){
		userManager=null;
	}

	/**
	 * set IterativeRefresh
	 * @param iterativeRefresh
	 */
	public void setIterativeRefresh(boolean iterativeRefresh) {
		this.iterativeRefresh = iterativeRefresh;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isIterativeRefresh() {
		if (iterativeRefresh) {
			getUserRoleContent().setIterativeRefresh(true);
			getUserContent().setIterativeRefresh(true);
		}
		return iterativeRefresh;
	}

	/**
	 * get RegistryUser instance
	 * @param username
	 * @return
	 */
	public RegistryUser getUser(String username) {
		List<RegistryUser> users = getUserContent().getUsers();
		for (RegistryUser registryUser : users) {
			if (registryUser.getUserName().equals(username))
				return registryUser;
		}
		return null;
	}
}

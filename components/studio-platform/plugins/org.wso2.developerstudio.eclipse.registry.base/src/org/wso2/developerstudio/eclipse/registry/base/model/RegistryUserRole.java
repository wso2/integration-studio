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

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class RegistryUserRole implements Observer {
	private String userRoleName;
	private List<RegistryUser> users;
	private boolean iterativeRefresh = false;
	private RegistryUserRoleContainer registryUserRoleContent;
	private RegistryNode connectionInfo;

	

	public RegistryNode getConnectionInfo() {
		return connectionInfo;
	}

	public void setConnectionInfo(RegistryNode connectionInfo) {
		this.connectionInfo = connectionInfo;
	}

	/**
	 * RegistryUserRole constructor
	 * represent roles in usermanager 
	 * @param userRoleName
	 * @param registryUserRoleContent
	 */
	public RegistryUserRole(String userRoleName,
							RegistryUserRoleContainer registryUserRoleContent) {
		setUserRoleName(userRoleName);
		setRegistryUserRoleContent(registryUserRoleContent);
	}

	/**
	 * set UserRoleName 
	 * @param userRoleName
	 */
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	/**
	 * get UserRoleName 
	 * @return
	 */
	public String getUserRoleName() {
		return userRoleName;
	}

	/**
	 * set users
	 * @param users
	 */
	public void setUsers(List<RegistryUser> users) {
		this.users = users;
	}

	/**
	 * get users
	 * @return RegistryUsers list
	 */
	public List<RegistryUser> getUsers() {
		if (users == null || isIterativeRefresh()) {
			users = new ArrayList<RegistryUser>();
			String[] usersForRoles = getRegistryUserRoleContent()
									.getRegistryUserManagerContainer().getUserManager()
									.getUsersForRoles(getUserRoleName());
			for (String usersRole : usersForRoles) {
				RegistryUser user = getRegistryUserRoleContent().getRegistryUserManagerContainer()
																				.getUser(usersRole);
				if (user != null) {
					users.add(user);
					user.addObserver(this);
				}
			}
		}
		return users;
	}

	/**
	 * set IterativeRefresh
	 * @param iterativeRefresh
	 */
	public void setIterativeRefresh(boolean iterativeRefresh) {
		this.iterativeRefresh = iterativeRefresh;
	}

	/**
	 * get the iterativeRefresh instance
	 * @return
	 */
	public boolean isIterativeRefresh() {
		return iterativeRefresh;
	}

	/**
	 * set RegistryUserRoleContent
	 * @param registryUserRoleContent
	 */
	public void setRegistryUserRoleContent(
			RegistryUserRoleContainer registryUserRoleContent) {
		this.registryUserRoleContent = registryUserRoleContent;
	}

	/**
	 * get RegistryUserRoleContainer instance
	 * @return
	 */
	public RegistryUserRoleContainer getRegistryUserRoleContent() {
		return registryUserRoleContent;
	}

	/**
	 * get the user role
	 */
	public String toString() {
		return getUserRoleName();
	}

	/**
	 * update the observers
	 */
	public void update(Observable o, Object arg) {
		setIterativeRefresh(true);
	}
}

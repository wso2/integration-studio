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

import org.wso2.developerstudio.eclipse.usermgt.remote.UserManager;

public class RegistryUserRoleContainer {
	private List<RegistryUserRole> userRoles;
	private RegistryUserManagerContainer registryUserManagerContainer;
	private boolean iterativeRefresh = false;
	

	public RegistryNode getConnectionInfo() {
		return registryUserManagerContainer.getRegistryNode();
	}

	

	/**
	 * RegistryUserRoleContainer constructor
	 * represent all the roles in the server
	 * @param registryUserManagerContainer
	 */
	public RegistryUserRoleContainer(RegistryUserManagerContainer registryUserManagerContainer) {
		setRegistryUserManagerContainer(registryUserManagerContainer);
	}

	/**
	 * get all roles of the server
	 * @return RegistryUserRole list
	 */
	public List<RegistryUserRole> getUserRoles() {
		if (userRoles == null || isIterativeRefresh()) {
			UserManager userManager = getRegistryUserManagerContainer().getUserManager();
			userRoles = new ArrayList<RegistryUserRole>();
			String[] roles = userManager.getRoles("*");
			for (String role : roles) {
				userRoles.add(new RegistryUserRole(role, this));
			}
		}
		return userRoles;
	}

	/**
	 * set RegistryUserManagerContainer
	 * @param registryUserManagerContainer
	 */
	public void setRegistryUserManagerContainer(
										RegistryUserManagerContainer registryUserManagerContainer) {
		this.registryUserManagerContainer = registryUserManagerContainer;
	}

	/**
	 * get RegistryUserManagerContainer
	 * @return 
	 */
	public RegistryUserManagerContainer getRegistryUserManagerContainer() {
		return registryUserManagerContainer;
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
		return iterativeRefresh;
	}

	/**
	 * get caption for roles to view in the tree view
	 * @return
	 */
	public String getCaption() {
		return "Roles";
	}

	/**
	 * get the caption
	 */
	public String toString() {
		return getCaption();
	}

}

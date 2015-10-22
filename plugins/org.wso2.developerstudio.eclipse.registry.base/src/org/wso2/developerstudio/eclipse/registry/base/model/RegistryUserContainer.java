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

import org.wso2.developerstudio.eclipse.usermgt.remote.UserManager;

public class RegistryUserContainer implements Observer {
	private List<RegistryUser> users;
	private RegistryUserManagerContainer registryUserManagerContainer;
	private boolean iterativeRefresh = false;

	/**
	 * RegistryUserContainer constructor
	 * @param registryUserManagerContainer
	 */
	public RegistryUserContainer(RegistryUserManagerContainer registryUserManagerContainer) {
		setRegistryUserManagerContainer(registryUserManagerContainer);
	}

	/**
	 * get users from user manager 
	 * @return
	 */
	public List<RegistryUser> getUsers() {
		if (users == null || isIterativeRefresh()) {
			UserManager userManager = getRegistryUserManagerContainer().getUserManager();
			users = new ArrayList<RegistryUser>();
			String[] userList = userManager.getUsers();
			for (String user : userList) {
				RegistryUser registryUser = new RegistryUser(user);
				registryUser.addObserver(this);
				users.add(registryUser);
			}
		}
		return users;
	}

	/**
	 * 
	 * @param iterativeRefresh
	 */
	public void setIterativeRefresh(boolean iterativeRefresh) {
		this.iterativeRefresh = iterativeRefresh;
	}

	/**
	 * check for availability of iterativeRefresh 
	 * @return
	 */
	public boolean isIterativeRefresh() {
		return iterativeRefresh;
	}

	/**
	 * set RegistryUserManagerContainer instance
	 * @param registryUserManagerContainer
	 */
	public void setRegistryUserManagerContainer(
										RegistryUserManagerContainer registryUserManagerContainer) {
		this.registryUserManagerContainer = registryUserManagerContainer;
	}

	/**
	 * get RegistryUserManagerContainer instance
	 * @return
	 */
	public RegistryUserManagerContainer getRegistryUserManagerContainer() {
		return registryUserManagerContainer;
	}

	/**
	 * get the caption to the top level tree node
	 * @return
	 */
	public String getCaption() {
		return "Users";
	}

	/**
	 * get the user name for the caption
	 */
	public String toString() {
		return getCaption();
	}

	/**
	 * update observers
	 */
	public void update(Observable o, Object arg) {
		setIterativeRefresh(true);
		registryUserManagerContainer.getRegistryData().getRegUrlData().dataChanged(true);
	}
}

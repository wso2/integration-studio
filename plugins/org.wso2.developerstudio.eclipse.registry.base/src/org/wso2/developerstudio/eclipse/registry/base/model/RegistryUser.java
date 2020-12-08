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

import java.util.Observable;

public class RegistryUser extends Observable {
	private String userName;
	private RegistryNode connectionInfo;

	public RegistryNode getConnectionInfo() {
		return connectionInfo;
	}

	public void setConnectionInfo(RegistryNode connectionInfo) {
		this.connectionInfo = connectionInfo;
	}

	/**
	 * RegistryUser constructor
	 * @param userName
	 */
	public RegistryUser(String userName) {
		setUserName(userName);
	}

	/**
	 * set user name
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * get UserName
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * get the caption for the user
	 */
	public String toString() {
		return getUserName();
	}

	/**
	 * 
	 */
	public void changed() {
		setChanged();
		notifyObservers();
	}
}

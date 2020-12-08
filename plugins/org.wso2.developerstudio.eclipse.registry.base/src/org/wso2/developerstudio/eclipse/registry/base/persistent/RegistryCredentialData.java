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

package org.wso2.developerstudio.eclipse.registry.base.persistent;

import org.eclipse.jface.preference.IPreferenceStore;
import org.wso2.developerstudio.eclipse.registry.base.Activator;

public class RegistryCredentialData {
	private static RegistryCredentialData instance;
	private IPreferenceStore preferenceStore;
	private static final String USERNAME_SUFFIX = "_USERNAME";
	private static final String PASSWORD_SUFFIX = "_PASSWORD";

	/**
	 * RegistryCredentialData constructor
	 */
	private RegistryCredentialData() {
		preferenceStore = Activator.getDefault().getPreferenceStore();
	}

	/**
	 * getInstance of the RegistryCredentialData
	 * if the instance is null, create a new instance
	 * @return
	 */
	public static RegistryCredentialData getInstance() {
		if (instance == null){
			instance = new RegistryCredentialData();
		}
		return instance;
	}

	/**
	 * get Username
	 * @param registryUrl
	 * @return
	 */
	public String getUsername(String registryUrl) {
		return preferenceStore.getString(getUsernameKey(registryUrl));
	}

	/**
	 * get the password of the user
	 * @param registryUrl
	 * @return
	 */
	public String getPassword(String registryUrl) {
		return preferenceStore.getString(getPasswordKey(registryUrl));
	}

	/**
	 * set credentials for the user
	 * @param registryUrl
	 * @param username
	 * @param password
	 */
	public void setCredentials(String registryUrl, String username, String password) {
		if (registryUrl != null) {
			if (username != null){
				preferenceStore.setValue(getUsernameKey(registryUrl), username);
			}
			if (password != null){
				preferenceStore.setValue(getPasswordKey(registryUrl), password);
			}
		}
	}

	/**
	 * set credentials
	 * @param registryUrl
	 * @param credentials
	 */
	public void setCredentials(String registryUrl, Credentials credentials) {
		setCredentials(registryUrl, 
					   credentials.getUsername(), 
					   credentials.getPassword());
	}

	/**
	 * get user name key
	 * @param registryUrl
	 * @return
	 */
	private String getUsernameKey(String registryUrl) {
		return registryUrl + USERNAME_SUFFIX;
	}

	/**
	 * get password key
	 * @param registryUrl
	 * @return
	 */
	private String getPasswordKey(String registryUrl) {
		return registryUrl + PASSWORD_SUFFIX;
	}

	/**
	 * get credentials for the registry instance
	 * @param registryUrl
	 * @return
	 */
	public Credentials getCredentials(String registryUrl) {
		String username = getUsername(registryUrl);
		String password = getPassword(registryUrl);
		if (username != null && 
			password != null && 
			!username.equals("") && 
			!password.equals("")){
			return new Credentials(username, password);
		}else{
			return null;
		}
	}

	/**
	 * Credentials class including username and password info
	 * 
	 *
	 */
	public static class Credentials {
		private String username;
		private String password;

		public Credentials() {
		}

		public Credentials(String username, String password) {
			setUsername(username);
			setPassword(password);
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getUsername() {
			return username;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPassword() {
			return password;
		}
	}
}

/* Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

public class UserPasswordCredentials {
	private final String user;
	private final String password;

	/**
	 * @param user
	 * @param password
	 */
	public UserPasswordCredentials(String user, String password) {
		this.user = user;
		this.password = password;
	}

	/**
	 * @return user
	 */
	public String getUser() {
		
		if(Authenticator.getInstance().isAppCloud()){
			
			String userName = user.replaceFirst("@", ".");
			userName += "@" + Authenticator.getInstance().getSelectedTenant();
			
			return userName;			
		}
		
		return user;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	public String getGitUser() {
		return user;
	}

	public String getCloudUserName() {
		
		return user.replace("@", ".");
	}
}

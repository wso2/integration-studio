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

package org.wso2.developerstudio.appfactory.core.model;

public class AppUserInfo {

	private String userName;
	private String[] roles;
	private String[] displayRoles;
	private String displayName;
	private String firstName;
	private String lastName;
	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String[] getRoles() {
		return roles;
	}

	public String[] getDisplayroles() {
		return displayRoles;
	}

	public void setDisplayroles(String[] displayroles) {
		this.displayRoles = displayroles;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		if (email == null) {
			return " NA ";
		}
		return email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayRolesAsString() {
		StringBuilder builder = new StringBuilder();
		if (displayRoles != null) {
			for (String role : displayRoles) {
				if (role != null) {
					builder.append(role);
					builder.append(", ");
				}
			}
		}

		return builder.toString();
	}
}

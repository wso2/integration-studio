/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.platform.ui.utils;

import org.wso2.developerstudio.eclipse.usermgt.remote.UserManager;

public class UserManagerUtils {

	private static UserManagerUtils instance;

	private UserManager userManager;

	private UserManagerUtils() {

	}

	public static UserManagerUtils getInstance() {
		if (instance == null) {
			instance = new UserManagerUtils();
		}

		return instance;
	}

	public void init(String url, String username, String password) {
		userManager = new UserManager(url, username, password);
	}

	public String[] getRoles(String filter, int limit) {
		if (userManager != null) {
			return userManager.getRoles(filter);
		}

		return new String[] {};
	}
}

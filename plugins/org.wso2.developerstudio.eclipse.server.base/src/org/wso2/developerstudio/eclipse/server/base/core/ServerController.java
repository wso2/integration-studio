/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.server.base.core;

public class ServerController {
	private IServerManager serverManager;
	private static ServerController INSTANCE;

	private ServerController() {
	}

	public void registerServerManager(IServerManager newServerManager) {
		if (serverManager == null)
			serverManager = newServerManager;
	}

	public void unregisterServerManager(IServerManager newServerManager) {
		serverManager = null;
	}

	public IServerManager getServerManager() {
		return serverManager;
	}

	public static ServerController getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServerController();
		}
		return INSTANCE;
	}
}

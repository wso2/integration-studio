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

package org.wso2.developerstudio.eclipse.carbonserver.base.manager;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.wst.server.core.ServerPort;

public class CarbonServerInformation {
	private ServerPort[] serverPorts;
	private String serverWorkspacePath = "";
	private String serverId = "";
	private List<IProject> changedProjects;

	public void setServerPorts(ServerPort[] serverPorts) {
		this.serverPorts = serverPorts;
	}

	public ServerPort[] getServerPorts() {
		return serverPorts;
	}

	public void setServerLocalWorkspacePath(String serverWorkspacePath) {
		this.serverWorkspacePath = serverWorkspacePath;
	}

	public String getServerLocalWorkspacePath() {
		return serverWorkspacePath;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public String getServerId() {
		return serverId;
	}

	public List<IProject> getChangedProjects() {
		if (changedProjects == null) {
			changedProjects = new ArrayList<IProject>();
		}
		return changedProjects;
	}
}

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

import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerPort;

public interface IServerManager {
	public static final int STATE_UNKNOWN = 0;
	public static final int STATE_STARTING = 1;
	public static final int STATE_STARTED = 2;
	public static final int STATE_STOPPING = 3;
	public static final int STATE_STOPPED = 4;

	public String getRuntimeServerIdForProject(IProject project);

	public IPath getServerHome(String serverId);

	public Object executeOperationOnServer(String serverId, Map<String, Object> operation) throws Exception;

	public Object executeOperationOnServer(IServer server, Map<String, Object> operation) throws Exception;

	public IProject[] getProjectsUsedByRuntime(String serverId);

	public boolean startServer(String serverId, Object shell);

	public boolean stopServer(String serverId);

	public boolean restartServer(String serverId);

	public int getServerStatus(String serverId);

	public String[] getServerIds();

	public String[] getServerLibraryPaths(String serverId) throws Exception;

	public String[] getServerCodegenLibraries(String serverId) throws Exception;

	public String[] getServerCodegenLibrariesFromRuntimeId(String runtimeId, String runtimePath) throws Exception;

	public String[] getServerAxis2Libraries(String serverTypeId, String wsasHome) throws Exception;

	public String[] getServerRelativeLibraryPaths(String serverTypeId) throws Exception;

	public Map<String, Integer> getServerPorts(String serverId) throws Exception;

	public ServerPort[] getServerPorts(IServer server);

	public boolean publishServiceModule(String serverId, String webTempPath, String projectName);

	public boolean hotUpdateServiceModule(String serverId, String webTempPath, String projectName);

	public boolean redeployServiceModule(String serverId, String webTempPath, String projectName);

	public boolean unpublishServiceModule(String serverId, String webTempPath, String projectName);

	public IProject[] getPublishedProjects(String serverId);

	public IProject[] getPublishedProjectsFromAllServers();

	public Map<IFolder, IProject> getPublishedPaths(String serverId);

	public String getServerRuntimeId(String serverId);

	public boolean isRuntimeIdPresent(String runtimeId);

	public String getServerTypeIdForRuntimeId(String runtimeId);
}

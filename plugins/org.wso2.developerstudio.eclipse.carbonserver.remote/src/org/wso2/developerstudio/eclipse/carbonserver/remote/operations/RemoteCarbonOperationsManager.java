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

package org.wso2.developerstudio.eclipse.carbonserver.remote.operations;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.IServerListener;
import org.wso2.developerstudio.eclipse.carbonserver.base.exception.NoSuchCarbonOperationDefinedException;
import org.wso2.developerstudio.eclipse.carbonserver.base.impl.CarbonServer;
import org.wso2.developerstudio.eclipse.carbonserver.base.interfaces.ICarbonServerMonitor;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.ICarbonOperationManager;
import org.wso2.developerstudio.eclipse.carbonserver.remote.monitor.CarbonServerListener;
import org.wso2.developerstudio.eclipse.carbonserver.remote.util.RemoteCarbonServerUtils;

public class RemoteCarbonOperationsManager implements ICarbonOperationManager {

	private static final String RUNTIME_ID = "org.wso2.developerstudio.eclipse.carbon.runtime31";

	public String getRuntimeId() {
		return RUNTIME_ID;
	}

	public Object executeOperation(Map<String, Object> operation) throws Exception {
		if (operation.containsKey(ICarbonOperationManager.PARAMETER_TYPE)) {
			try {
				int opType = Integer.parseInt(operation.get(ICarbonOperationManager.PARAMETER_TYPE).toString());
				Object result = null;
				IServer server = null;
				if (operation.containsKey(ICarbonOperationManager.PARAMETER_SERVER))
					server = (IServer) operation.get(ICarbonOperationManager.PARAMETER_SERVER);
				switch (opType) {
					case ICarbonOperationManager.OPERATION_PUBLISH_MODULE:
						if (server != null)
							if (operation.containsKey(ICarbonOperationManager.PARAMETER_PROJECT)) {
								IProject project = (IProject) operation.get(ICarbonOperationManager.PARAMETER_PROJECT);
								ServiceModuleOperations serviceModuleOperations =
								                                                  new ServiceModuleOperations(project,
								                                                                              server);
								String path = null;
								serviceModuleOperations.publishServiceModule(path, null);
							}
						break;
					case ICarbonOperationManager.OPERATION_UNPUBLISH_MODULE:
						if (server != null)
							if (operation.containsKey(ICarbonOperationManager.PARAMETER_PROJECT)) {
								IProject project = (IProject) operation.get(ICarbonOperationManager.PARAMETER_PROJECT);
								ServiceModuleOperations serviceModuleOperations =
								                                                  new ServiceModuleOperations(project,
								                                                                              server);
								String path = null;
								serviceModuleOperations.unpublishServiceModule(path, null);
							}
						break;
					case ICarbonOperationManager.OPERATION_HOT_UPDATE_MODULE:
						if (server != null)
							if (operation.containsKey(ICarbonOperationManager.PARAMETER_PROJECT)) {
								IProject project = (IProject) operation.get(ICarbonOperationManager.PARAMETER_PROJECT);
								ServiceModuleOperations serviceModuleOperations =
								                                                  new ServiceModuleOperations(project,
								                                                                              server);
								serviceModuleOperations.hotUpdateModule();
							}
						break;
					case ICarbonOperationManager.OPERATION_REDEPLOY_MODULE:
						if (server != null)
							if (operation.containsKey(ICarbonOperationManager.PARAMETER_PROJECT)) {
								IProject project = (IProject) operation.get(ICarbonOperationManager.PARAMETER_PROJECT);
								ServiceModuleOperations serviceModuleOperations =
								                                                  new ServiceModuleOperations(project,
								                                                                              server);
								serviceModuleOperations.redeployModule();
							}
						break;
					case ICarbonOperationManager.OPERATION_GET_PUBLISHED_SERVICES:
						if (server != null) {
							ServiceModuleOperations serviceModuleOperations;
							if (operation.containsKey(ICarbonOperationManager.PARAMETER_PROJECT)) {
								IProject project = (IProject) operation.get(ICarbonOperationManager.PARAMETER_PROJECT);
								serviceModuleOperations = new ServiceModuleOperations(project, server);
							} else {
								serviceModuleOperations = new ServiceModuleOperations(null, server);
							}
							return serviceModuleOperations.getServicesList();
						}
						break;
					case ICarbonOperationManager.OPERATION_GET_SERVER_CREDENTIALS:
						Map<String, String> serverCredentials = null;
						if (server != null) {
							serverCredentials = RemoteCarbonServerUtils.getServerCredentials(server);
						}
						result = serverCredentials;
						break;
					case ICarbonOperationManager.OPERATION_GET_SERVER_AUTHENTICATED_COOKIE:
						String cookie = null;
						if (server != null) {
							if (operation.containsKey(ICarbonOperationManager.PARAMETER_SERVER_PORT)) {
								String serverPort =
								                    (String) operation.get(ICarbonOperationManager.PARAMETER_SERVER_PORT);
								cookie = RemoteCarbonServerUtils.getServerCookie(server, serverPort);
							}
						}
						result = cookie;
						break;
					case ICarbonOperationManager.OPERATION_INITIALIZE_SERVER_CONFIGURATIONS:
						break;
					case ICarbonOperationManager.OPERATION_SERVER_URL:
						result = RemoteCarbonServerUtils.getServerURL(server);
						break;
					case ICarbonOperationManager.OPERATION_CLEANUP_SERVER_CONFIGURATIONS:
						if (server != null)
							cleanupTheServer(server);
						break;
					default:
						throw new NoSuchCarbonOperationDefinedException();
				}

				return result;
			} catch (Exception ex) {
				throw ex;
			}
		} else {
			throw new NoSuchCarbonOperationDefinedException();
		}
	}

	public boolean isOperationSupported(int operation) {
		boolean result = false;
		switch (operation) {
			case OPERATION_SUPPORTED_OPERATIONS:
			case OPERATION_GET_SERVER_CREDENTIALS:
			case OPERATION_SERVER_URL:
			case OPERATION_REDEPLOY_MODULE:
				result = true;
				break;
			default:
				result = false;
		}
		return result;
	}

	public void initializeTheServer(IServer server) throws CoreException {
		List<ICarbonServerMonitor> serverMonitors = CarbonServer.getServerMonitors(server);
		IServerListener serverListener = new CarbonServerListener(serverMonitors);
		server.addServerListener(serverListener);
	}

	public void cleanupTheServer(IServer server) {
		unpublishAllModules(server);
	}

	private void unpublishAllModules(IServer server) {
		IModule[] modules = server.getModules();
		for (IModule module : modules) {
			ServiceModuleOperations serviceModuleOperation = new ServiceModuleOperations(module.getProject(), server);
			serviceModuleOperation.unpublishServiceModule(null, null);
		}
	}
}

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

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jst.server.generic.core.internal.GenericServer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerCore;
import org.eclipse.wst.server.core.ServerPort;
import org.wso2.developerstudio.eclipse.carbonserver.base.Activator;
import org.wso2.developerstudio.eclipse.carbonserver.base.exception.NoSuchCarbonOperationDefinedException;
import org.wso2.developerstudio.eclipse.carbonserver.base.impl.Credentials;
import org.wso2.developerstudio.eclipse.carbonserver.base.interfaces.ICredentials;
import org.wso2.developerstudio.eclipse.carbonserver.base.monitor.CarbonServerLifeCycleListener;
import org.wso2.developerstudio.eclipse.carbonserver.base.utils.CarbonServerUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.server.base.core.IServerManager;
import org.wso2.developerstudio.eclipse.server.base.core.ServerController;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

@SuppressWarnings("restriction")
public final class CarbonServerManager implements IServerManager {
	private static final String CARBON_SERVER_TYPE_REMOTE = "org.wso2.developerstudio.eclipse.carbon.server.remote";
	private static final String RESOURCE = "resource";
	private static final String RESOURCE_CHANGE_KIND = "resourceChangeKind";

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static List<IServer> servers;
	private static Map<String, ICarbonOperationManager> serverPlugins;
	private static Map<String, String> serverRuntimePlugins;

	private static CarbonServerManager instance;
	private static Map<IServer, CarbonServerInformation> appServerInformation;
	private static CarbonServerLifeCycleListener carbonServerLifeCycleListener;

	private static boolean isServerAdded;
	private IProject rootProject;
	private int resourceChngeKind;

	private CarbonServerManager() {
		init();
	}

	public static CarbonServerManager getInstance() {
		if (instance == null)
			instance = new CarbonServerManager();
		return instance;
	}

	private static Map<String, ICarbonOperationManager> getServerPlugin() {
		if (serverPlugins == null)
			serverPlugins = new HashMap<String, ICarbonOperationManager>();
		if (serverRuntimePlugins == null)
			serverRuntimePlugins = new HashMap<String, String>();
		return serverPlugins;
	}

	private static Map<String, String> getServerRuntimeIdPlugin() {
		if (serverRuntimePlugins == null)
			serverRuntimePlugins = new HashMap<String, String>();
		return serverRuntimePlugins;
	}

	public static List<IServer> getServers() {
		if (servers == null)
			servers = new ArrayList<IServer>();
		return servers;
	}

	public static void serverAdded(IServer server) {
		ICarbonOperationManager serverOperationManager = getServerOperationManager(server);
		if (serverOperationManager != null) {
			getServers().add(server);
			isServerAdded = true;
			IServerManager wsasServerManager = ServerController.getInstance().getServerManager();
			HashMap<String, Object> operationParameters = new HashMap<String, Object>();
			operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
			                        ICarbonOperationManager.OPERATION_GET_SERVER_PORTS);
			Object r;
			CarbonServerInformation serverInformation = new CarbonServerInformation();
			serverInformation.setServerId(server.getId());
			ServerPort[] wsasPorts = new ServerPort[] {};
			try {
				r = wsasServerManager.executeOperationOnServer(server, operationParameters);
				if (r instanceof ServerPort[])
					wsasPorts = (ServerPort[]) r;
				CarbonServerUtils.setServicePath(server);
			} catch (NoSuchCarbonOperationDefinedException e) {
				// ports cannot be retrieved
			} catch (Exception e) {
				log.error(e);
			}
			serverInformation.setServerPorts(wsasPorts);
			// The localrepo path is for now is the bin distribution path. this
			// needs to be fixed in order to be set inside the workspace path
			// String workspaceRootPath =
			// ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
			// String serverPath=FileUtils.addNodesToPath(workspaceRootPath, new
			// String[]{".metadata",".carbon",server.getId()});
			IPath serverHome = getServerHome(server);
			if (serverHome != null) {
				String serverPath = serverHome.toOSString();
				(new File(serverPath)).mkdirs();
				serverInformation.setServerLocalWorkspacePath(serverPath);
			}
			getAppServerInformation().put(server, serverInformation);
			try {
				initializeServerConfigurations(server);
			} catch (Exception e) {
				log.error(e);
			}
		}
	}

	public static void serverRemoved(IServer server) {
		if (getServers().contains(server)) {
			try {
				cleanupServerConfigurations(server);
			} catch (Exception e) {
				log.error(e);
			}
			getServers().remove(server);
			if (getAppServerInformation().containsKey(server))
				getAppServerInformation().remove(server);
		}
	}

	public static void serverStateChanged(IServer server) {

	}

	public static void registerAppServerPlugin(String serverId, ICarbonOperationManager opManager) {
		if (!getServerPlugin().containsKey(serverId)) {
			getServerPlugin().put(serverId, opManager);
			getServerRuntimeIdPlugin().put(opManager.getRuntimeId(), serverId);
			addExistingServers();
		}
	}

	public static void unregisterAppServerPlugin(String serverId) {
		if (getServerPlugin().containsKey(serverId))
			serverPlugins.remove(serverId);
	}

	public static ICarbonOperationManager getServerOperationManager(IServer server) {
		return getServerOperationManager(server.getId());
	}

	public static ICarbonOperationManager getServerOperationManager(String serverId) {
		IServer server = getServer(serverId);
		if (getServerPlugin().containsKey(server.getServerType().getId()))
			return getServerPlugin().get(server.getServerType().getId());
		else {
			return null;
		}
	}

	public static ICarbonOperationManager getServerOperationManagerByServerType(String serverTypeId) {
		if (getServerPlugin().containsKey(serverTypeId))
			return getServerPlugin().get(serverTypeId);
		else {
			return null;
		}
	}

	public Object executeOperationOnServer(IServer server, Map<String, Object> operation) throws Exception {
		return executeOperationOnServer(server.getId(), operation);
	}

	public Object executeOperationOnServer(String serverId, Map<String, Object> operation) throws Exception {
		ICarbonOperationManager serverOperationManager = getServerOperationManager(serverId);
		if (!operation.containsKey(ICarbonOperationManager.PARAMETER_SERVER))
			addServerToParameters(operation, getServer(serverId));
		if (serverOperationManager == null)
			return null;
		else
			return serverOperationManager.executeOperation(operation);
	}

	public static IServer getServer(String serverId) {
		IServer server = null;
		for (IServer s : getServers()) {
			if (s.getId().equalsIgnoreCase(serverId)) {
				server = s;
				break;
			}
		}
		if (server == null) {
			IServer[] s = ServerCore.getServers();
			for (IServer aserver : s) {
				if (aserver.getId().equals(serverId)) {
					server = aserver;
					break;
				}
			}
		}
		return server;
	}

	public IProject[] getProjectsUsedByRuntime(String serverId) {
		return null;
	}

	public String getRuntimeServerIdForProject(IProject project) {
		// for(IServer server:getServers()){
		// for(IModule module:server.getModules()){
		// if (module.getProject()==project){
		// break;
		// }
		// }
		// }
		return null;
	}

	public static String[] getServerIdForProject(IProject project) {
		List<String> serverIds = new ArrayList<String>();
		IServer[] serversForProject = getServersForProject(project);
		for (IServer server : serversForProject) {
			serverIds.add(server.getId());
		}
		return serverIds.toArray(new String[] {});
	}

	public static IServer[] getServersForProject(IProject project) {
		List<IServer> serverIds = new ArrayList<IServer>();
		for (IServer server : getServers()) {
			for (IModule module : server.getModules()) {
				if (module.getProject() == project) {
					serverIds.add(server);
				}
			}
		}
		return serverIds.toArray(new IServer[] {});
	}

	public IPath getServerHome(String serverId) {
		IServer server = getServer(serverId);
		return getServerHome(server);
	}

	public static IPath getServerHome(IServer server) {
		IPath location = null;
		if (server != null) {
			IServerManager wsasServerManager = getInstance();
			HashMap<String, Object> operationParameters = new HashMap<String, Object>();
			operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
			                        ICarbonOperationManager.OPERATION_GET_SERVER_HOME);
			Object r;
			try {
				r = wsasServerManager.executeOperationOnServer(server, operationParameters);
				if (r instanceof IPath)
					location = (IPath) r;
			} catch (NoSuchCarbonOperationDefinedException e) {
				return null;
			} catch (Exception e) {
				log.error(e);
			}
		}

		return location;
	}

	public int getServerStatus(String serverId) {
		IServer server = getServer(serverId);
		if (server == null)
			return 0;
		else
			return server.getServerState();
	}

	public boolean restartServer(String serverId) {
		IServer server = getServer(serverId);
		if (server == null)
			return false;
		else {
			// TODO the restart a server
			return false;
		}
	}

	public boolean startServer(String serverId, Object shell) {
		IServer server = getServer(serverId);
		if (server == null)
			return false;
		else {
			try {
				if (server.getServerState() != IServer.STATE_STARTING) {
					server.start("run", (IProgressMonitor) null);
				}
				if (shell == null)
					return true;
				else {
					if (shell instanceof Shell)
						return waitUntilTheServerStarts(server, (Shell) shell);
					else
						return true;
				}
			} catch (CoreException e) {
				return false;
			}
		}
	}

	public static IServer getRunningServer() {
		IServer server = null;
		for (IServer s : getServers()) {
			if (s.getServerState() == IServer.STATE_STARTED) {
				server = s;
				break;
			}
		}
		return server;
	}

	public boolean stopServer(String serverId) {
		IServer server = getServer(serverId);
		if (server == null)
			return false;
		else {
			server.stop(false);
			return true;
		}
	}

	public static void initiateAppServerManagementOperations() {
		carbonServerLifeCycleListener = new CarbonServerLifeCycleListener();
		ServerCore.addServerLifecycleListener(carbonServerLifeCycleListener);
	}

	public static void deInitiateAppServerManagementOperations() {
		if (carbonServerLifeCycleListener != null) {
			ServerCore.removeServerLifecycleListener(carbonServerLifeCycleListener);
		}
	}

	private static void addExistingServers() {
		IServer[] s = ServerCore.getServers();
		for (IServer server : s) {
			if (!getServers().contains(server))
				serverAdded(server);
		}
	}

	public String[] getServerIds() {
		List<String> list = new ArrayList<String>();
		for (IServer server : getServers()) {
			list.add(server.getId());
		}
		return list.toArray(new String[] {});
	}

	public String[] getServerLibraryPaths(String serverId) throws Exception {
		IServer server = getServer(serverId);
		return getServerLibraryPaths(server);
	}

	public static String[] getServerLibraryPaths(IServer server) throws Exception {
		String[] result = null;
		if (server != null) {
			IServerManager wsasServerManager = ServerController.getInstance().getServerManager();
			HashMap<String, Object> operationParameters = new HashMap<String, Object>();
			operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
			                        ICarbonOperationManager.OPERATION_GET_LIBRARY_PATHS);
			Object r = wsasServerManager.executeOperationOnServer(server, operationParameters);// getWSDLConversionResultUrl(resourceFile);
			if (r instanceof String[]) {
				result = (String[]) r;
				IPath serverLocation = getServerHome(server);
				for (int i = 0; i < result.length; i++) {
					result[i] = FileUtils.addAnotherNodeToPath(serverLocation.toOSString(), result[i]);
				}
			}
		}
		return result;
	}

	public static URL getServiceWSDLUrl(IServer server, String serviceName) throws Exception {
		URL result = null;
		if (server != null) {
			IServerManager wsasServerManager = ServerController.getInstance().getServerManager();
			HashMap<String, Object> operationParameters = new HashMap<String, Object>();
			operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
			                        ICarbonOperationManager.OPERATION_GET_SERVICE_WSDL_URL);
			operationParameters.put(ICarbonOperationManager.PARAMETER_SERVICE_NAME, serviceName);
			Object r = wsasServerManager.executeOperationOnServer(server, operationParameters);// getWSDLConversionResultUrl(resourceFile);
			if (r instanceof URL) {
				result = (URL) r;
			}
		}
		return result;
	}

	public static URL getServiceTryItUrl(IServer server, String serviceName) throws Exception {
		URL result = null;
		if (server != null) {
			IServerManager wsasServerManager = ServerController.getInstance().getServerManager();
			HashMap<String, Object> operationParameters = new HashMap<String, Object>();
			operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
			                        ICarbonOperationManager.OPERATION_GET_SERVICE_TRY_IT_URL);
			operationParameters.put(ICarbonOperationManager.PARAMETER_SERVICE_NAME, serviceName);
			Object r = wsasServerManager.executeOperationOnServer(server, operationParameters);// getWSDLConversionResultUrl(resourceFile);
			if (r instanceof URL) {
				result = (URL) r;
			}
		}
		return result;
	}

	public static Map<IServer, CarbonServerInformation> getAppServerInformation() {
		if (appServerInformation == null)
			appServerInformation = new HashMap<IServer, CarbonServerInformation>();
		return appServerInformation;
	}

	public ServerPort[] getServerPorts(IServer server) {
		GenericServer gserver = (GenericServer) server.getAdapter(GenericServer.class);
		return gserver.getServerPorts();
	}

	public static String getServerLocalWorkspacePath(IServer server) {
		if (getAppServerInformation().containsKey(server)) {
			return getAppServerInformation().get(server).getServerLocalWorkspacePath();
		} else
			return null;
	}

	public Map<String, Integer> getServerPorts(String serverId) throws Exception {
		Map<String, Integer> result = new HashMap<String, Integer>();
		IServer server = getServer(serverId);
		if (server != null) {
			ServerPort[] serverPorts2 = getServerPorts(server);
			if (serverPorts2 != null)
				for (ServerPort s : serverPorts2) {
					result.put(s.getProtocol(), s.getPort());
				}
		}
		return result;
	}

	public static void addServerToParameters(Map<String, Object> properties, IServer server) {
		properties.put(ICarbonOperationManager.PARAMETER_SERVER, server);
	}

	public static boolean isOperationSupported(IServer server, int operation) throws Exception {
		IServerManager wsasServerManager = ServerController.getInstance().getServerManager();
		HashMap<String, Object> operationParameters = new HashMap<String, Object>();
		operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
		                        ICarbonOperationManager.OPERATION_SUPPORTED_OPERATIONS);
		operationParameters.put(ICarbonOperationManager.PARAMETER_OP_TYPES, operation);
		Object r = wsasServerManager.executeOperationOnServer(server, operationParameters);
		if (r instanceof Boolean) {
			return (Boolean) r;
		}
		return false;
	}

	public static void initializeServerConfigurations(IServer server) throws Exception {
		IServerManager wsasServerManager = ServerController.getInstance().getServerManager();
		HashMap<String, Object> operationParameters = new HashMap<String, Object>();
		operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
		                        ICarbonOperationManager.OPERATION_INITIALIZE_SERVER_CONFIGURATIONS);
		wsasServerManager.executeOperationOnServer(server, operationParameters);
	}

	public static void cleanupServerConfigurations(IServer server) throws Exception {
		IServerManager wsasServerManager = ServerController.getInstance().getServerManager();
		HashMap<String, Object> operationParameters = new HashMap<String, Object>();
		operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
		                        ICarbonOperationManager.OPERATION_CLEANUP_SERVER_CONFIGURATIONS);
		wsasServerManager.executeOperationOnServer(server, operationParameters);
	}

	public boolean publishServiceModule(String serverId, String webTempPath, String projectName) {
		IServer server = getServer(serverId);
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		IServerManager wsasServerManager = ServerController.getInstance().getServerManager();
		HashMap<String, Object> operationParameters = new HashMap<String, Object>();
		operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
		                        ICarbonOperationManager.OPERATION_PUBLISH_MODULE);
		operationParameters.put(ICarbonOperationManager.PARAMETER_WebTempPath, webTempPath);
		operationParameters.put(ICarbonOperationManager.PARAMETER_PROJECT, project);
		try {
			wsasServerManager.executeOperationOnServer(server, operationParameters);
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}

	}

	public boolean hotUpdateServiceModule(String serverId, String webTempPath, String projectName) {
		IServer server = getServer(serverId);
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		CarbonServerManager wsasServerManager = this;
		HashMap<String, Object> operationParameters = new HashMap<String, Object>();
		operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
		                        ICarbonOperationManager.OPERATION_HOT_UPDATE_MODULE);
		operationParameters.put(ICarbonOperationManager.PARAMETER_WebTempPath, webTempPath);
		operationParameters.put(ICarbonOperationManager.PARAMETER_PROJECT, project);
		try {
			wsasServerManager.executeOperationOnServer(server, operationParameters);
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}

	public boolean hotUpdateWebApp(String serverId, IResource resource, String projectName) {

		IServer server = getServer(serverId);
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		CarbonServerManager wsasServerManager = this;
		HashMap<String, Object> operationParameters = new HashMap<String, Object>();
		operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
		                        ICarbonOperationManager.OPERATION_HOT_UPDATE_MODULE);
		operationParameters.put(ICarbonOperationManager.PARAMETER_WebTempPath, "");
		operationParameters.put(ICarbonOperationManager.PARAMETER_PROJECT, project);
		operationParameters.put(RESOURCE, resource);
		operationParameters.put(RESOURCE_CHANGE_KIND, new Integer(resourceChngeKind));
		try {
			wsasServerManager.executeOperationOnServer(server, operationParameters);
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}

	public boolean redeployServiceModule(String serverId, String webTempPath, String projectName) {
		IServer server = getServer(serverId);
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		CarbonServerManager wsasServerManager = this;
		HashMap<String, Object> operationParameters = new HashMap<String, Object>();
		operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
		                        ICarbonOperationManager.OPERATION_REDEPLOY_MODULE);
		operationParameters.put(ICarbonOperationManager.PARAMETER_WebTempPath, webTempPath);
		operationParameters.put(ICarbonOperationManager.PARAMETER_PROJECT, project);
		try {
			wsasServerManager.executeOperationOnServer(server, operationParameters);
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}

	}

	public boolean unpublishServiceModule(String serverId, String webTempPath, String projectName) {
		IServer server = getServer(serverId);
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		CarbonServerManager wsasServerManager = this;
		HashMap<String, Object> operationParameters = new HashMap<String, Object>();
		operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
		                        ICarbonOperationManager.OPERATION_UNPUBLISH_MODULE);
		operationParameters.put(ICarbonOperationManager.PARAMETER_WebTempPath, webTempPath);
		operationParameters.put(ICarbonOperationManager.PARAMETER_PROJECT, project);
		try {
			wsasServerManager.executeOperationOnServer(server, operationParameters);
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}

	}

	public static boolean waitForServerToChangeState(IServer server, Shell shell, int changeStateFrom,
	                                                 int changeStateTo, String msg) {
		ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(shell);
		CarbonServerStateChange serverStateChange =
		                                            new CarbonServerStateChange(server, changeStateFrom, changeStateTo,
		                                                                        180000, msg);
		progressMonitorDialog.setBlockOnOpen(false);
		try {
			progressMonitorDialog.run(true, true, serverStateChange);
			return progressMonitorDialog.getReturnCode() != ProgressMonitorDialog.CANCEL;
		} catch (InvocationTargetException e) {
			log.error(e);
		} catch (InterruptedException e) {
			log.error(e);
		}
		return false;
	}

	public static boolean waitUntilTheServerStarts(IServer server, Shell shell) {
		return waitForServerToChangeState(server, shell, IServer.STATE_STOPPED, IServer.STATE_STARTED,
		                                  "Starting WSAS Server " + server.getId() + "...");
	}

	public Map<IFolder, IProject> getPublishedPaths(String serverId) {
		return getPublishedPaths(getServer(serverId));
	}

	public static Map<IFolder, IProject> getPublishedPaths(IServer server) {
		if (server == null)
			return null;
		IServerManager wsasServerManager = ServerController.getInstance().getServerManager();
		HashMap<String, Object> operationParameters = new HashMap<String, Object>();
		operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
		                        ICarbonOperationManager.OPERATION_GET_PUBLISHED_SERVICES);
		try {
			Object result = wsasServerManager.executeOperationOnServer(server, operationParameters);
			if (result instanceof Map) {
				return (Map<IFolder, IProject>) result;
			}
			return null;
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}

	public IProject[] getPublishedProjects(String serverId) {
		return null;
	}

	public IProject[] getPublishedProjectsFromAllServers() {
		return null;
	}

	public String getServerRuntimeId(String serverId) {
		return getServerOperationManager(serverId).getRuntimeId();
	}

	public boolean isRuntimeIdPresent(String runtimeId) {
		return getServerRuntimeIdPlugin().containsKey(runtimeId);
	}

	public String getServerTypeIdForRuntimeId(String runtimeId) {
		if (getServerRuntimeIdPlugin().containsKey(runtimeId))
			return getServerRuntimeIdPlugin().get(runtimeId);
		else
			return null;
	}

	public String[] getServerRelativeLibraryPaths(String serverTypeId) throws Exception {
		String[] result = null;
		ICarbonOperationManager serverOperationManager = getServerOperationManagerByServerType(serverTypeId);
		HashMap<String, Object> operationParameters = new HashMap<String, Object>();
		operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
		                        ICarbonOperationManager.OPERATION_GET_LIBRARY_PATHS);
		Object r = serverOperationManager.executeOperation(operationParameters);
		if (r instanceof String[]) {
			result = (String[]) r;
		}
		return result;
	}

	public String[] getServerCodegenLibraries(String serverId) throws Exception {

		IServer server = getServer(serverId);
		return getServerCodegenLibraries(server);
	}

	public static String[] getServerCodegenLibraries(IServer server) throws Exception {
		String[] result = null;
		if (server != null) {
			IServerManager wsasServerManager = ServerController.getInstance().getServerManager();
			HashMap<String, Object> operationParameters = new HashMap<String, Object>();
			operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
			                        ICarbonOperationManager.OPERATION_GET_CODEGEN_LIBRARIES);
			Object r = wsasServerManager.executeOperationOnServer(server, operationParameters);// getWSDLConversionResultUrl(resourceFile);
			if (r instanceof String[]) {
				result = (String[]) r;
			}
		}
		return result;
	}

	public String[] getServerAxis2Libraries(String serverTypeId, String wsasHome) throws Exception {
		String[] result = null;
		ICarbonOperationManager serverOperationManager = getServerOperationManagerByServerType(serverTypeId);
		HashMap<String, Object> operationParameters = new HashMap<String, Object>();
		operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
		                        ICarbonOperationManager.OPERATION_GET_AXIS2_LIBRARIES);
		operationParameters.put(ICarbonOperationManager.PARAMETER_PATH, wsasHome);
		Object r = serverOperationManager.executeOperation(operationParameters);
		if (r instanceof String[]) {
			result = (String[]) r;
		}
		return result;
	}

	private void init() {
		createWorkspaceListener();
	}

	private void createWorkspaceListener() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();

		IResourceChangeListener listener = new IResourceChangeListener() {
			public void resourceChanged(IResourceChangeEvent event) {
				IResourceDelta projectDelta;
				if (isServerAdded) {
					IResourceDelta resourceDelta = event.getDelta();
					for (IResourceDelta modifideResourceDelta : resourceDelta.getAffectedChildren()) {
						rootProject = (IProject) modifideResourceDelta.getResource();
						projectDelta = modifideResourceDelta;
						IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
							public boolean visit(IResourceDelta delta) throws CoreException {
								IResource resource = delta.getResource();
								resourceChngeKind = delta.getKind();
								if (resource.getType() == IResource.FILE || resource.getType() == IResource.FOLDER) {
									IServer[] serversForProject = getServersForProject(rootProject);
									for (IServer server : serversForProject) {
										if (!CARBON_SERVER_TYPE_REMOTE.equalsIgnoreCase(server.getServerType().getId())) {
											CarbonServerInformation serverInformation =
											                                            getAppServerInformation().get(server);
											if (!serverInformation.getChangedProjects().contains(rootProject)) {
												serverInformation.getChangedProjects().add(rootProject);
												hotUpdateWebApp(server.getId(), resource, rootProject.getName());
											}
										}
									}
								}
								return true;
							}
						};
						try {
							projectDelta.accept(visitor);
						} catch (CoreException e) {
							log.error(" adding IResourceDeltaVisitor to projectDelta was failed " + e);
						}

					}

				}
			}

		};
		workspace.addResourceChangeListener(listener, IResourceChangeEvent.POST_BUILD);
	}

	public String[] getServerCodegenLibrariesFromRuntimeId(String runtimeId, String runtimePath) throws Exception {
		String serverTypeId = getServerTypeIdForRuntimeId(runtimeId);
		String[] result = null;
		HashMap<String, Object> operationParameters = new HashMap<String, Object>();
		operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
		                        ICarbonOperationManager.OPERATION_GET_CODEGEN_LIBRARIES);
		operationParameters.put(ICarbonOperationManager.PARAMETER_RUNTIME, runtimeId);
		operationParameters.put(ICarbonOperationManager.PARAMETER_PATH, runtimePath);
		ICarbonOperationManager wsasOperationManager = getServerOperationManagerByServerType(serverTypeId);
		Object r = wsasOperationManager.executeOperation(operationParameters);// getWSDLConversionResultUrl(resourceFile);
		if (r instanceof String[]) {
			result = (String[]) r;
		}
		return result;
	}

	public static ICredentials getServerCredentials(IServer server) throws Exception {
		Map<String, String> result = null;
		if (server != null) {
			IServerManager esbServerManager = ServerController.getInstance().getServerManager();
			HashMap<String, Object> operationParameters = new HashMap<String, Object>();
			operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
			                        ICarbonOperationManager.OPERATION_GET_SERVER_CREDENTIALS);
			Object r = esbServerManager.executeOperationOnServer(server, operationParameters);// getWSDLConversionResultUrl(resourceFile);
			if (r instanceof Map) {
				result = (Map<String, String>) r;
			}
		}
		Credentials credentials = null;
		if (result != null) {
			credentials = new Credentials(result.get("esb.username"), result.get("esb.password"));
		}
		return credentials;
	}

	public static URL getServerURL(IServer server) throws Exception {
		if (server != null) {
			IServerManager esbServerManager = ServerController.getInstance().getServerManager();
			HashMap<String, Object> operationParameters = new HashMap<String, Object>();
			operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
			                        ICarbonOperationManager.OPERATION_SERVER_URL);
			Object serverURL = esbServerManager.executeOperationOnServer(server, operationParameters);
			if (serverURL instanceof URL) {
				String serverId = server.getServerType().getId();
				URL urlWithContextRoot = (URL) serverURL;
				if (!CARBON_SERVER_TYPE_REMOTE.equals(serverId)) {
					urlWithContextRoot = new URL(urlWithContextRoot, CarbonServerUtils.getWebContextRoot(server));
				}
				return urlWithContextRoot;
			}
		}
		return null;
	}

	public static String getServerAuthenticatedCookie(IServer server, String httpsPort) throws Exception {
		String result = null;
		if (server != null) {
			IServerManager esbServerManager = ServerController.getInstance().getServerManager();
			HashMap<String, Object> operationParameters = new HashMap<String, Object>();
			operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
			                        ICarbonOperationManager.OPERATION_GET_SERVER_AUTHENTICATED_COOKIE);
			operationParameters.put(ICarbonOperationManager.PARAMETER_SERVER_PORT, httpsPort);
			Object r = esbServerManager.executeOperationOnServer(server, operationParameters);
			if (r instanceof String) {
				result = (String) r;
			}
		}
		return result;
	}

	public static String getServerAuthenticatedCookie(IServer server) throws Exception {
		String result = null;
		if (server != null) {
			ServerPort[] serverPorts = getInstance().getServerPorts(server);
			String httpsPort = "9443";
			for (ServerPort port : serverPorts) {
				if (port.getProtocol().equalsIgnoreCase("https")) {
					httpsPort = Integer.toString(port.getPort());
				}
			}
			result = getServerAuthenticatedCookie(server, httpsPort);
		}
		return result;
	}

	public static String getServerCarbonVersion(IServer server) {
		String result = null;
		if (server != null) {
			IServerManager wsasServerManager = ServerController.getInstance().getServerManager();
			HashMap<String, Object> operationParameters = new HashMap<String, Object>();
			operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE,
			                        ICarbonOperationManager.OPERATION_SERVER_VERSION);
			Object r = null;
			try {
				r = wsasServerManager.executeOperationOnServer(server, operationParameters);
			} catch (Exception e) {
				log.error(e);
			}
			result = (String) r;
		}
		return result;
	}

}

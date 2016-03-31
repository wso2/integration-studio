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

package org.wso2.developerstudio.eclipse.carbonserver.remote.internal;

import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.model.ServerBehaviourDelegate;
import org.wso2.developerstudio.eclipse.carbonfeatures.Activator;
import org.wso2.developerstudio.eclipse.carbonserver.remote.operations.ServiceModuleOperations;

public class RemoteCarbonServerBehavior extends ServerBehaviourDelegate {
	private CarbonPingThread ping;

	protected void initialize(IProgressMonitor monitor) {
		super.initialize(monitor);
		startPingThread();
	}

	public IStatus canStop() {
		return Status.CANCEL_STATUS;
	}

	public IStatus canRestart(String mode) {
		return Status.CANCEL_STATUS;
	}

	public void stop(boolean force) {
		stopPingThread();
	}

	public IStatus canStart(String launchMode) {
		return Status.CANCEL_STATUS;
	}

	public void setupLaunchConfiguration(ILaunchConfigurationWorkingCopy workingCopy, IProgressMonitor monitor)
	                                                                                                           throws CoreException {
		if (isRemote()) {
			return;
		}
	}

	protected void stopPingThread() {
		if (ping != null) {
			ping.stop();
			ping = null;
		}
		setServerStopped();
	}

	protected void startPingThread() {
		try {
			if (ping != null) {
				ping.stop();
			}
			setServerState(IServer.STATE_STARTING);
			RemoteCarbonServer rcs = (RemoteCarbonServer) getServer().loadAdapter(RemoteCarbonServer.class, null);
			URL serverURL = rcs.getServerURL();
			URL pingURL = new URL(serverURL.toString() + "/carbon");
			ping = new CarbonPingThread(pingURL, this);
			ping.startPing();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean isRemote() {
		return true;
	}

	public void setServerStarted() {
		setServerState(IServer.STATE_STARTED);
	}

	public void setServerStopped() {
		setServerState(IServer.STATE_STOPPED);
	}

	public boolean isServerStarted() {
		return getServer().getServerState() == IServer.STATE_STARTED;
	}

	public boolean isServerStarting() {
		return getServer().getServerState() == IServer.STATE_STARTING;
	}

	public boolean isServerStopped() {
		return getServer().getServerState() == IServer.STATE_STOPPED;
	}

	public void publishModule(int kind, int deltaKind, IModule[] module, IProgressMonitor monitor) throws CoreException {
		IModule m = module[module.length - 1];
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(m.getName());
		ServiceModuleOperations serviceModuleOperations = new ServiceModuleOperations(project, getServer());
		if (deltaKind == ADDED) {
			checkClosed(module);
			serviceModuleOperations.publishServiceModule(null, null);
		} else if (deltaKind == REMOVED) {
			serviceModuleOperations.unpublishServiceModule(null, null);
		} else {
			checkClosed(module);
			serviceModuleOperations.hotUpdateModule();
		}
		setModulePublishState(module, null);
	}

	private void setModulePublishState(IModule[] module, IStatus[] status) throws CoreException {
		if (module == null) {
			return;
		}
		for (int i = 0; i < module.length; i++) {
			if (status == null || status.length < i || status[i] == null || status[i].getSeverity() == IStatus.OK) {
				setModulePublishState(module, IServer.PUBLISH_STATE_NONE);
			} else {
				if (IStatus.ERROR == status[i].getSeverity()) {
					setModulePublishState(module, IServer.PUBLISH_STATE_UNKNOWN);
					throw new CoreException(status[i]);
				}
			}
		}
	}

	private void checkClosed(IModule[] modules) throws CoreException {
		for (IModule module : modules) {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(module.getName());
			if (!project.exists() || !project.isOpen()) {
				IStatus status =
				                 new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0,
				                            NLS.bind("Module does not exists or module closed", module.getName()), null);
				throw new CoreException(status);
			}
		}
	}
}

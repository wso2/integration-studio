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

package org.wso2.developerstudio.eclipse.carbonserver42.monitor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.runtime.IPath;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.IServerListener;
import org.eclipse.wst.server.core.ServerEvent;
import org.wso2.developerstudio.eclipse.carbonserver.base.console.CarbonServerConsole;
import org.wso2.developerstudio.eclipse.carbonserver.base.interfaces.ICarbonServerMonitor;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerManager;
import org.wso2.developerstudio.eclipse.carbonserver42.Activator;
import org.wso2.developerstudio.eclipse.carbonserver42.util.CarbonServer42Utils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class CarbonServerListener implements IServerListener {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private final List<ICarbonServerMonitor> serverMonitors;

	private CarbonServer42Utils carbonServer42Utils = new CarbonServer42Utils();

	public CarbonServerListener(List<ICarbonServerMonitor> serverMonitors) {
		this.serverMonitors = serverMonitors;
	}

	public void serverChanged(ServerEvent event) {
		switch (event.getState()) {
			case IServer.STATE_STARTING:
				triggerStarting(event.getServer());
				break;
			case IServer.STATE_STARTED:
				triggerStarted(event.getServer());
				break;
			case IServer.STATE_STOPPING:
				triggerStopping(event.getServer());
				break;
			case IServer.STATE_STOPPED:
				triggerStopped(event.getServer());
				break;
		}
	}

	private void triggerStarting(IServer server) {
		File cappMonitorBundle = carbonServer42Utils .getCappMonitorBundle();
		IPath dropins =
		                CarbonServerManager.getServerHome(server).append("repository").append("components")
		                                   .append("dropins");
		try {
			FileUtils.copyFileToDirectory(cappMonitorBundle, new File(dropins.toOSString()));
		} catch (IOException e1) {
			log.error(e1);
		}
		for (ICarbonServerMonitor monitor : serverMonitors) {
			try {
				monitor.starting(server);
			} catch (Exception e) {
				log.error(e);
			}
		}
	}

	private void triggerStarted(IServer server) {
		for (ICarbonServerMonitor monitor : serverMonitors) {
			try {
				monitor.started(server);
			} catch (Exception e) {
				log.error(e);
			}
		}
	}

	private void triggerStopping(IServer server) {
		for (ICarbonServerMonitor monitor : serverMonitors) {
			try {
				monitor.stopping(server);
			} catch (Exception e) {
				log.error(e);
			}
		}
		// Displaying message that carbon server is about to shutdown
		CarbonServerConsole console = new CarbonServerConsole();
		console.printMessageInConsole(server.getName(), "Carbon Server " + server.getName() + " is shutting down...\n");
	}

	private void triggerStopped(IServer server) {
		// Displaying message that carbon server is about to shutdown
		CarbonServerConsole console = new CarbonServerConsole();
		console.printMessageInConsole(server.getName(), "Carbon Server " + server.getName() + " has shut down...\n");
		File cappMonitorBundle = carbonServer42Utils.getCappMonitorBundle();
		IPath dropins =
		                CarbonServerManager.getServerHome(server).append("repository").append("components")
		                                   .append("dropins").append(cappMonitorBundle.getName());
		File cappMonitorFile = new File(dropins.toOSString());
		if (cappMonitorFile.exists()) {
			cappMonitorFile.delete();
		}
		for (ICarbonServerMonitor monitor : serverMonitors) {
			try {
				monitor.stopped(server);
			} catch (Exception e) {
				log.error(e);
			}
		}
	}
}

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

package org.wso2.developerstudio.eclipse.carbonserver.base.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jst.server.generic.core.internal.GenericServer;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IServer;
import org.wso2.developerstudio.eclipse.carbonfeatures.FeatureDefinition;
import org.wso2.developerstudio.eclipse.carbonserver.base.Activator;
import org.wso2.developerstudio.eclipse.carbonserver.base.interfaces.ICarbonServer;
import org.wso2.developerstudio.eclipse.carbonserver.base.interfaces.ICarbonServerModulePublisher;
import org.wso2.developerstudio.eclipse.carbonserver.base.interfaces.ICarbonServerMonitor;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class CarbonServer extends GenericServer implements ICarbonServer {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public IStatus canModifyModules(IModule[] arg0, IModule[] arg1) {
		return Status.OK_STATUS;
	}

	public List<FeatureDefinition> getAvailableFeatures() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}

	public URL getURL() {
		// TODO Auto-generated method stub
		return null;
	}

	public void startServer() {
		// TODO Auto-generated method stub

	}

	public void stopServer(boolean force) {
		// TODO Auto-generated method stub

	}

	private static final String CARBON_SERVER_MODULE_PUBLISHER_EXTENSION =
	                                                                       "org.wso2.developerstudio.eclipse.carbonserver.publisher";
	private static final String CARBON_SERVER_MONITOR_EXTENSION =
	                                                              "org.wso2.developerstudio.eclipse.carbonserver.monitor";

	public static List<ICarbonServerModulePublisher> getProjectPublishers(IServer server) {
		List<ICarbonServerModulePublisher> publishers = new ArrayList<ICarbonServerModulePublisher>();
		IConfigurationElement[] config =
		                                 Platform.getExtensionRegistry()
		                                         .getConfigurationElementsFor(CARBON_SERVER_MODULE_PUBLISHER_EXTENSION);
		for (IConfigurationElement e : config) {
			try {
				if (e.getAttribute("serverid").equals(server.getServerType().getId())) {
					publishers.add((ICarbonServerModulePublisher) e.createExecutableExtension("class"));
				}
			} catch (Exception ex) {
				log.error(ex);
			}
		}
		return publishers;
	}

	public static List<ICarbonServerMonitor> getServerMonitors(IServer server) {
		List<ICarbonServerMonitor> publishers = new ArrayList<ICarbonServerMonitor>();
		IConfigurationElement[] config =
		                                 Platform.getExtensionRegistry()
		                                         .getConfigurationElementsFor(CARBON_SERVER_MONITOR_EXTENSION);
		for (IConfigurationElement e : config) {
			try {
				if (e.getAttribute("serverId").equals(server.getServerType().getId())) {
					publishers.add((ICarbonServerMonitor) e.createExecutableExtension("class"));
				}
			} catch (Exception ex) {
				log.error(ex);
			}
		}
		return publishers;
	}
}

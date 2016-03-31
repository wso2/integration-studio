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

package org.wso2.developerstudio.eclipse.carbonserver.base.ui.actions;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.wst.server.core.IRuntime;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.ui.IServerModule;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerManager;

import java.util.List;

/**
 * This class is used to test property for visibility of option Redeploy for
 * Carbon modules in Carbon Servers.
 *
 */
public class ServerModuleVisibilityPropertyTester extends PropertyTester {

	private static final String WSO2_CARBON_MODULE = "org.wso2.developerstudio.eclipse.carbon.module";

	public boolean test(Object arg0, String arg1, Object[] arg2, Object arg3) {

		if (arg0 instanceof IServerModule) {
			List<IServer> servers = CarbonServerManager.getServers();
			for (IServer iServer : servers) {
				IRuntime serverRuntime = ((IServerModule) arg0).getServer().getRuntime();
				if (iServer.getRuntime() != null && serverRuntime != null &&
				    iServer.getRuntime().getRuntimeType().equals(serverRuntime.getRuntimeType())) {
					return true;
				} else if (iServer.getServerType().getId()
				                  .equals(((IServerModule) arg0).getServer().getServerType().getId())) {
					return true;
				}
			}

		}
		return false;
	}

}

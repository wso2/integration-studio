/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.carbonserver44microei.register.product.servers;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jst.server.generic.core.internal.GenericServer;
import org.eclipse.jst.server.generic.servertype.definition.Property;
import org.eclipse.jst.server.generic.servertype.definition.ServerRuntime;
import org.eclipse.wst.server.core.IRuntime;
import org.eclipse.wst.server.core.IRuntimeType;
import org.eclipse.wst.server.core.IRuntimeWorkingCopy;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.IServerType;
import org.eclipse.wst.server.core.IServerWorkingCopy;
import org.eclipse.wst.server.core.ServerCore;
import org.wso2.developerstudio.eclipse.carbonserver44microei.ServerProperties;
import org.wso2.developerstudio.eclipse.carbonserver44microei.internal.CarbonServerBehavior44microei;

public class MicroIntegratorInstance {

	private static MicroIntegratorInstance instance;
	private IServer microIntegratorServer;

	private MicroIntegratorInstance() {
		setupServer();
	}

	public static MicroIntegratorInstance getInstance() {
		if (instance == null) {
			instance = new MicroIntegratorInstance();
		}
		return instance;
	}

	private void setupServer() {

		IRuntimeType runtimeType = ServerCore
				.findRuntimeType("org.wso2.developerstudio.eclipse.carbon.runtime44microei");
		IServerType serverType = ServerCore
				.findServerType("org.wso2.developerstudio.eclipse.carbon.server44microei");

		try {

			NullProgressMonitor progressMonitor = new NullProgressMonitor();

			IRuntimeWorkingCopy runtime = runtimeType.createRuntime("org.wso2.micro.integrator.runtime",
					progressMonitor);
			runtime.setName("Micro Integrator Runtime");
			runtime.setLocation(new Path("/temp/runTime/profile/wso2ei-6.4.0/wso2/micro-integrator"));

			IRuntime microIntegratorRuntime = runtime.save(true, progressMonitor);

			IServerWorkingCopy server = serverType.createServer("org.wso2.micro.integrator.server", null,
					microIntegratorRuntime, progressMonitor);
			server.setName("Micro Integrator Server");

			readConfigs(server);

			microIntegratorServer = server.saveAll(false, progressMonitor);

		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private void readConfigs(IServerWorkingCopy server) throws CoreException {
		GenericServer dl = (GenericServer) server.loadAdapter(GenericServer.class, null);
		Map temserverInstanceProperties = dl.getServerInstanceProperties();
		IRuntime runtime = server.getRuntime();
		String location = runtime.getLocation().toOSString();
		Map<String, String> serverInstanceProperties = new ServerProperties().getServerInstanceProperties(location);

		for (Map.Entry<String, String> entry : serverInstanceProperties.entrySet()) {
			temserverInstanceProperties.put(entry.getKey(), entry.getValue());
		}
		dl.setServerInstanceProperties(temserverInstanceProperties);
		dl.saveConfiguration(new NullProgressMonitor());
	}

	public void start() throws CoreException {
		microIntegratorServer.start(ILaunchManager.RUN_MODE, new NullProgressMonitor());
	}

	public void stop() {
		microIntegratorServer.stop(true);
	}

	public int getOffset() {
		GenericServer dl = (GenericServer) microIntegratorServer.loadAdapter(GenericServer.class, null);
		Map<String, String> serverInstanceProperties = dl.getServerInstanceProperties();
		int offset = Integer.parseInt(serverInstanceProperties.get("carbon.offset"));
		return offset;
	}

}

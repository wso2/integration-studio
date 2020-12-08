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

package org.wso2.developerstudio.eclipse.carbonserver44.operations;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerPort;
import org.wso2.developerstudio.eclipse.carbon.server.model.operations.CommonCarbonServerOperations;
import org.wso2.developerstudio.eclipse.carbon.server.model.util.CarbonServerCommonConstants;
import org.wso2.developerstudio.eclipse.carbonserver44.Activator;
import org.wso2.developerstudio.eclipse.carbonserver44.util.CarbonServer44Utils;
import org.wso2.developerstudio.eclipse.server.base.core.ServerController;

@SuppressWarnings("restriction")
public class CommonOperations extends CommonCarbonServerOperations{

	private static CarbonServer44Utils carbonServer44Utils = new CarbonServer44Utils();


	public String getLocalServerPort(IServer server) {
		ServerPort[] serverPorts = ServerController.getInstance().getServerManager().getServerPorts(server);
		int httpPort = 0;
		int offSet = 0;
		for (ServerPort p : serverPorts) {
			int i = CarbonServerCommonConstants.getPortcaptions(Activator.PLUGIN_ID).indexOf(p.getName());
			if (i != -1 && CarbonServerCommonConstants.getPortids(Activator.PLUGIN_ID).get(i).equals("carbon.http")) {
				httpPort = p.getPort();
			} else if (i != -1 && CarbonServerCommonConstants.getPortids(Activator.PLUGIN_ID).get(i).equals("carbon.offset")) {
				offSet = p.getPort();
			}
		}
		return "http://" + server.getHost() + ":" + (httpPort + offSet);
	}

	public String getAnyFileUploaderUrl(IServer server) {
		return getLocalServerPort(server) + CarbonServerCommonConstants.getAnyFileUploaderUrl(Activator.PLUGIN_ID);
	}

	public String getToolsUploadUrl(IServer server) {
		return getLocalServerPort(server) + CarbonServerCommonConstants.getToolsFileUploaderUrl(Activator.PLUGIN_ID);
	}

	public String getValidatorFileUploaderUrl(IServer server) {
		return getLocalServerPort(server) + CarbonServerCommonConstants.getValidatorFileUploaderUrl(Activator.PLUGIN_ID);
	}

	public String getToolsAnyFileUploaderUrl(IServer server) {
		return getLocalServerPort(server) + CarbonServerCommonConstants.getToolsAnyFileUploadUrl(Activator.PLUGIN_ID);
	}

	public IPath getWSASHome(IServer server) {
		return new Path(carbonServer44Utils.resolveProperties(server, "carbon.home"));
	}
}

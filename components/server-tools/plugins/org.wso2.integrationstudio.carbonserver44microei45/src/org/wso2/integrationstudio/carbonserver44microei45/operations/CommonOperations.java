/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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

package org.wso2.integrationstudio.carbonserver44microei45.operations;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerPort;
import org.wso2.integrationstudio.carbon.server.model.operations.CommonCarbonServerOperations;
import org.wso2.integrationstudio.carbon.server.model.util.CarbonServerCommonConstants;
import org.wso2.integrationstudio.carbonserver44microei45.Activator;
import org.wso2.integrationstudio.carbonserver44microei45.util.CarbonServer44eiUtils;
import org.wso2.integrationstudio.carbonserver44microei45.util.ServerConstants;
import org.wso2.integrationstudio.server.base.core.ServerController;

public class CommonOperations extends CommonCarbonServerOperations {

    private static CarbonServer44eiUtils carbonServer44eiUtils = new CarbonServer44eiUtils();

    public String getLocalServerPort(IServer server) {
        ServerPort[] serverPorts = ServerController.getInstance().getServerManager().getServerPorts(server);
        int httpPort = 0;
        int offSet = 0;
        for (ServerPort p : serverPorts) {
            int i = CarbonServerCommonConstants.getPortcaptions(Activator.PLUGIN_ID).indexOf(p.getName());
            if (i != -1 && CarbonServerCommonConstants.getPortids(Activator.PLUGIN_ID).get(i).equals("carbon.http")) {
                httpPort = p.getPort();
            } else if (i != -1
                    && CarbonServerCommonConstants.getPortids(Activator.PLUGIN_ID).get(i).equals("carbon.offset")) {
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
        return getLocalServerPort(server)
                + CarbonServerCommonConstants.getValidatorFileUploaderUrl(Activator.PLUGIN_ID);
    }

    public String getToolsAnyFileUploaderUrl(IServer server) {
        return getLocalServerPort(server) + CarbonServerCommonConstants.getToolsAnyFileUploadUrl(Activator.PLUGIN_ID);
    }

    public IPath getWSASHome(IServer server) {
        return new Path(carbonServer44eiUtils.resolveProperties(server, ServerConstants.PROP_CARBON_HOME));
    }
}

/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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

package org.wso2.developerstudio.eclipse.carbonserver44microei12;

import net.consensys.cava.toml.TomlParseResult;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.IProperties;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.Activator;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.util.CarbonServer44eiUtils;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.util.ServerConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import java.util.HashMap;
import java.util.Map;

public class ServerProperties implements IProperties {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static CarbonServer44eiUtils carbonServer44eiUtils = new CarbonServer44eiUtils();

    public ServerProperties() {

    }

    public Map<String, String> getServerInstanceProperties(String serverPath) {
        Map<String, String> serverInstanceProperties = null;

        try {
            serverInstanceProperties = new HashMap<String, String>();
            TomlParseResult tomlResults = carbonServer44eiUtils.getTomlResults(serverPath);

            String offset = carbonServer44eiUtils.readTomlValue(tomlResults, ServerConstants.TOML_PORTOFFSET, "10");
            String passthroughHttpPort = carbonServer44eiUtils.readTomlValue(tomlResults,
                    ServerConstants.TOML_HTTP_LISTENER, "8280");
            String passthroughHttpsPort = carbonServer44eiUtils.readTomlValue(tomlResults,
                    ServerConstants.TOML_HTTPS_LISTENER, "8243");
            String hotDeplymentEnabled = carbonServer44eiUtils.readTomlValue(tomlResults,
                    ServerConstants.TOML_HOT_DEPLOYMENT, "true");

            serverInstanceProperties.put(ServerConstants.PROP_OFFSET, offset);
            serverInstanceProperties.put(ServerConstants.PROP_HTTP_PORT, passthroughHttpPort);
            serverInstanceProperties.put(ServerConstants.PROP_HTTPS_PORT, passthroughHttpsPort);
            serverInstanceProperties.put(ServerConstants.PROP_CARBON_HOME, serverPath);
            serverInstanceProperties.put(ServerConstants.PROP_HOT_DEPLOYMENT, hotDeplymentEnabled);
        } catch (Exception e) {
            log.error("Error occured while setting the server properties.", e);
        }
        return serverInstanceProperties;
    }
}

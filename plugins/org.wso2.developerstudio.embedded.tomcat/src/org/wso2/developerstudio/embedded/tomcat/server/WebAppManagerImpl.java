/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.embedded.tomcat.server;

import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.embedded.tomcat.EmbeddedTomcatPlugin;
import org.wso2.developerstudio.embedded.tomcat.api.ITomcatServer;
import org.wso2.developerstudio.embedded.tomcat.api.IWebAppManager;

public class WebAppManagerImpl implements IWebAppManager {
	
	private static IDeveloperStudioLog log = Logger.getLog(EmbeddedTomcatPlugin.PLUGIN_ID);

	ITomcatServer serverInstance;
	
	public WebAppManagerImpl() {
		serverInstance = EmbeddedTomcatPlugin.getDefault().getServer();
	}

	@Override
	public void addWebApp(String appID, String context, String docBase){
		if (serverInstance != null) {
			try {
				serverInstance.addWebApp(appID, context, docBase);
			} catch (Exception e) {
				log.error("Error deploying web application. AppID: " + appID, e);
			}
		} else {
			log.error("Error deploying web application. AppID: " + appID
					+ ". Tomcat server instance is not found.");
		}
	}

	@Override
	public String getAppURL(String appID) {
		if(serverInstance != null){
			return serverInstance.getAppURL(appID);
		}
		return null;
	}

}

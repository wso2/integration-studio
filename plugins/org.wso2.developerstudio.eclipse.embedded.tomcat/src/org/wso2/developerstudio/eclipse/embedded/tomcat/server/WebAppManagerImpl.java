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
package org.wso2.developerstudio.eclipse.embedded.tomcat.server;

import org.wso2.developerstudio.eclipse.embedded.tomcat.EmbeddedTomcatPlugin;
import org.wso2.developerstudio.eclipse.embedded.tomcat.api.IWebAppManager;
import org.wso2.developerstudio.eclipse.embedded.tomcat.exception.EmbeddedTomcatException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class WebAppManagerImpl implements IWebAppManager {
	
	private static IDeveloperStudioLog log = Logger.getLog(EmbeddedTomcatPlugin.PLUGIN_ID);

	@Override
	public void addWebApp(String appID, String context, String docBase) throws EmbeddedTomcatException{
		EmbeddedTomcatPlugin.getDefault().getServer().addWebApp(appID, context, docBase);
	}

	@Override
	public String getAppURL(String appID) throws EmbeddedTomcatException {
		return EmbeddedTomcatPlugin.getDefault().getServer().getAppURL(appID);
	}

}

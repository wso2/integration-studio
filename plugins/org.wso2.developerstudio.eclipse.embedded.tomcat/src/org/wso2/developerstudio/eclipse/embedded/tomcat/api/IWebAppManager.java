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
package org.wso2.developerstudio.eclipse.embedded.tomcat.api;

import org.wso2.developerstudio.eclipse.embedded.tomcat.exception.EmbeddedTomcatException;

public interface IWebAppManager {

	/**
	 * Method to add a web application to server.
	 * 
	 * @param appID
	 *            A unique ID for the app.
	 * @param context
	 *            Deploying context.
	 * @param docBase
	 *            Root folder of the application.
	 * @throws Exception
	 */
	void addWebApp(String appID, String context, String docBase) throws EmbeddedTomcatException;

	/**
	 * Method to get full URL to access a particular web application.
	 * 
	 * @param appID
	 *            Unique ID of the web application.
	 * 
	 * @return complete URL to access given web application.
	 */
	String getAppURL(String appID) throws EmbeddedTomcatException;
}

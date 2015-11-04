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
package org.wso2.developerstudio.embedded.tomcat;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.wso2.developerstudio.embedded.tomcat.messages"; //$NON-NLS-1$

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

	public static String EmbeddedTomcatMsg_0;
	public static String INFO_startingTomcat;
	public static String INFO_tomcatStarted;
	public static String ERROR_tomcatStartupError;
	public static String ERROR_tomcatShutdownError;
	public static String ERROR_bundleShutdownError;
	public static String ERROR_bundleStartupError;
	public static String ERROR_serverNotFound;
	public static String ERROR_duplicateContext;
	public static String ERROR_appNotFound;
	public static String ERROR_bundleEarlyStartupError;
	public static String ERROR_duplicateAppID;
	public static String INFO_appAddedSuccessfully;
	public static String ERROR_errorAddingWebApp;
	public static String ERROR_resolvingResourcesFailed;
	public static String ERROR_failedCreatingTmpDirs;
	public static String ERROR_extractingWarFailed;
	public static String ERROR_appDeploymentFailed;
	public static String ERROR_missingRequiredConfig;
}

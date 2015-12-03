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
package org.wso2.developerstudio.eclipse.embedded.tomcat;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.embedded.tomcat.Messages"; //$NON-NLS-1$

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

	public static String INFO_STARTING_TOMCAT;
	public static String INFO_TOMCAT_STARTED;
	public static String ERROR_TOMCAT_STARTUP_ERROR;
	public static String ERROR_TOMCAT_INIT_ERROR;
	public static String ERROR_TOMCAT_SHUTDOWN_ERROR;
	public static String ERROR_BUNDLE_SHUTDOWN_ERROR;
	public static String ERROR_BUNDLE_STARTUP_ERROR;
	public static String ERROR_SERVER_NOT_FOUND;
	public static String ERROR_DUPLICATE_CONTEXT;
	public static String ERROR_APP_NOT_FOUND;
	public static String ERROR_EARLY_STARTUP_ERROR;
	public static String ERROR_DUPLICATE_APP_ID;
	public static String INFO_APP_ADDED_SUCCESSFULLY;
	public static String ERROR_ADDING_WEBAPP_FAILED;
	public static String ERROR_RESOLVING_RESOURCES_FAILED;
	public static String ERROR_TMP_FILE_CREATION_FAILED;
	public static String ERROR_WAR_EXTRACTION_FAILED;
	public static String ERROR_APP_DEPLOYMENT_FAILED;
	public static String ERROR_MISSING_REQUIRED_CONFIG;
}

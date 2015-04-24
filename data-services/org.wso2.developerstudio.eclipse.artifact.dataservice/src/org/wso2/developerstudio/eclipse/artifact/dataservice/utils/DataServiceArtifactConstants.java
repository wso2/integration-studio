/*
 * Copyright (c) 2011-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.artifact.dataservice.utils;

import org.eclipse.osgi.util.NLS;


public class DataServiceArtifactConstants extends NLS {

	public static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.artifact.dataservice.utils.dataserviceartifactconstants";
	
	//project wizard page properties
	public static String WIZARD_OPTION_PROJECT_NAME;
	public static String WIZARD_OPTION_SERVICE_NAME;
	public static String WIZARD_OPTION_SERVICE_GROUP;
	public static String WIZARD_OPTION_SERVICE_NS;
	public static String WIZARD_OPTION_SERVICE_DESCRIPTION;
	public static String WIZARD_OPTION_IMPORT_FILE;
	public static String WIZARD_OPTION_NEW_DSPROJECT;
	public static String WIZARD_OPTION_IMPORT_DSPROJECT;
	public static String WIZARD_OPTION_SERVICE_SECPOLICY;
	public static String DS_WIZARD_WINDOW_TITLE;
	public static String DS_PROJECT_DATASERVICE_FOLDER;
	public static String WIZARD_OPTION_SAVE_NAME;
	public static String CREATE_DS_PROJECT;
	public static String WIZARD_OPTION_SAVE_FILE;


	public static String WARNING_MESSAGE;
	public static String ERROR_MESSAGE_FILE_OPEN;
	public static String ERROR_MESSAGE_CORE_EXCEPTION;
	public static String ERROR_MESSAGE_UNEXPECTED_ERROR;
	public static String ERROR_DBS_LOCATION;
	public static String ERROR_DBS_FILE;
	public static String ERROR_DS_NAME;
	public static String ERROR_SAVE_FILE;
	public static String ERROR_CONNECTION;
	public static String ERROR_DRIVERCLASS;
	public static String ERROR_DS_PROJECT;
	public static String ERROR_DS_PROJECT_PATH;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, DataServiceArtifactConstants.class);
	}
	
	public DataServiceArtifactConstants() {
		
	}
}

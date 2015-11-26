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

package org.wso2.developerstudio.eclipse.artifact.dataserviceProject.utils;

import org.eclipse.osgi.util.NLS;

public class DataServiceProjectConstants extends NLS {

	public static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.artifact.dataserviceProject.utils.dataserviceprojectconstants";
	
	public static String WIZARD_OPTION_PROJECT_NAME;
	public static String WIZARD_OPTION_IMPORT_FILE;
	public static String SERVICE_NAME;
	public static String DS_WIZARD_WINDOW_TITLE;
	public static String DS_PROJECT_DATASERVICE_FOLDER;
	
	public static String ERROR_MESSAGE_CORE_EXCEPTION;
	public static String ERROR_MESSAGE_UNEXPECTED_ERROR;
	public static String ERROR_DBS_LOCATION;
	public static String ERROR_DBS_FILE;
	public static String ERROR_DS_NAME;
	
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, DataServiceProjectConstants.class);
	}
	
	public DataServiceProjectConstants() {
		
	}
}

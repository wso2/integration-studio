/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.localentry.utils;

import org.eclipse.osgi.util.NLS;

public final class LocalEntryArtifactConstants extends NLS{
	public static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.artifact.localentry.utils.localentryartifactconstants";
	public static  String LE_WIZARD_WINDOW_TITLE;
	public static  String ESB_PROJECT_NATURE;
	
	//project wizard page properties
	public static String WIZARD_OPTION_NEW_LE;
	public static String WIZARD_OPTION_LE_TYPE;
	public static String WIZARD_OPTION_SAVE_LOCATION;
	public static String WIZARD_OPTION_IMPORT_OPTION;
	public static String WIZARD_OPTION_IMPORT_FILE_PATH;
	public static String WIZARD_OPTION_CREATE_ESB_PROJECT;
	public static String WIZARD_OPTION_LE_NAME;
	public static String WIZARD_OPTION_AVAILABLE_LES;
	public static String WIZARD_OPTION_IN_LINE_TEXT_LE_VALUE;;
	public static String WIZARD_OPTION_IN_LINE_XML_LE_VALUE;
	public static String WIZARD_OPTION_IMPORT_SOURC_URL_LE_URL;
	public static String TYPE_IN_LINE_TEXT_LE;
	public static String TYPE_IN_LINE_XML_LE;
	public static String TYPE_SOURCE_URL_LE;
	
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, LocalEntryArtifactConstants.class);
	}
	
	private LocalEntryArtifactConstants(){
		
	}
}

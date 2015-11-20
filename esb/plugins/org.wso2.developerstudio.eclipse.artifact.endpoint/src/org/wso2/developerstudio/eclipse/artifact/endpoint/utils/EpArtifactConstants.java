/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.endpoint.utils;

import org.eclipse.osgi.util.NLS;

public final class EpArtifactConstants extends NLS{
	public static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.artifact.endpoint.utils.epartifactconstants";
	public static  String EP_WIZARD_WINDOW_TITLE;
	public static  String ADDRESS_EP;
	public static  String WSDL_EP;
	public static  String DEFAULT_EP;
	public static  String FAIL_OVER_EP;
	public static  String HTTP_EP;
	public static  String LOAD_BALANCE_EP;
	public static  String TEMPLATE_EP;
	public static  String ESB_PROJECT_NATURE;
	
	//project wizard page properties
	public static String WIZARD_OPTION_EP_TYPE;
	public static String WIZARD_OPTION_DYNAMIC_EP;
	public static String WIZARD_OPTION_REGISTRY_TYPE;
	public static String WIZARD_OPTION_REGISTRY_PATH;
	public static String WIZARD_OPTION_SAVE_LOCATION;
	public static String WIZARD_OPTION_IMPORT_OPTION;
	public static String WIZARD_OPTION_CREATE_ESB_PROJECT;
	public static String WIZARD_OPTION_EP_NAME;
	public static String WIZARD_OPTION_IMPORT_FILE;
	public static String WIZARD_OPTION_TEMPLATE_ADDRESS_EP_URL;
	public static String WIZARD_OPTION_TEMPLATE_WSDL_EP_URL;
	public static String WIZARD_OPTION_TEMPLATE_WSDL_EP_SERVICE;
	public static String WIZARD_OPTION_TEMPLATE_WSDL_EP_SERVICE_PORT;
	public static String WIZARD_OPTION_TEMPLATE_TEMP_EP_URL;
	public static String WIZARD_OPTION_TEMPLATE_TEMP_TARGET;
	public static String WIZARD_OPTION_TEMPLATE_AVAILABLE;
	public static String WIZARD_OPTION_AVAILABLE_EPS;
	public static String WIZARD_OPTION_HTTP_EP_URITEMPLATE;
	public static String WIZARD_OPTION_HTTP_EP_METHOD;
	public static String WIZARD_OPTION_STATIC_EP;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, EpArtifactConstants.class);
	}
	
	private EpArtifactConstants(){
		
	}
}
/*
 * Copyright (c) 2011-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.registry.utils;

import java.util.Arrays;
import java.util.List;

import org.eclipse.osgi.util.NLS;

public class RegistryArtifactConstants extends NLS {
	public static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.artifact.registry.utils.registryartifactconstants";
	
	public static final int REGISTRY_RESOURCE = 0; 
	public static final int REGISTRY_COLLECTION = 1; 
	public static final int REGISTRY_DUMP = 2; 
	public static final int REGISTRY_UNDEFINED=-1;
	
	public static  String OPTION_NEW_RESOURCE;
	public static  String OPTION_IMPORT_RESOURCE;
	public static  String OPTION_IMPORT_DUMP;
	public static  String OPTION_CHECKOUT_PATH;
	public static  String DATA_RESOURCE_NAME;
	public static  String DATA_RESOURCE_TYPE;
	public static  String DATA_REG_LOCATION;
	public static  String DATA_REG_PARTITION;
	public static  String DATA_CREATE_PRJ;
	public static  String DATA_SAVE_FILE;
	public static  String DATA_IMPORT_FILE;
	public static  String DATA_COPY_CONTENT;
	public static String DATA_CHECKOUT_PATH;
	public static String JAVA_PROJECT_NATURE;
	public static String GENERAL_PROJECT_NATURE;
	public static  String SEQUENCE_TEMPL_ID;
	public static String LOCAL_ENTRY_TEMPL_ID;
	public static  String DEFAULT_EP_TEMPL_ID;
	public static  String ADDRESS_EP_TEMPL_ID;
	public static  String ADDRESS_EP_TEMPLATE_ID ;
	public static  String DEFAULT_EP_TEMPLATE_ID;
	public static  String WSDL_EP_TEMPLATE_ID;
	public static  String HTTP_EP_TEMPLATE_ID;
	public static  String WSDL_EP_TEMPL_ID;
	public static  String FAIL_OVER_ENDPOINT_TEMPL_ID;
	public static  String LB_ENDPOINT_TEMPL_ID;
	public static  String HTTP_EP_TEMPL_ID;
	public static  String RECIPIENTLIST_EP_TEMPL_ID;
	public static  String TEMPLATE_ENDPOINT_TEMPL_ID;	
	public static  String TEMPLATE_SEQUENCE_TEMPL_ID;	
	public static  String SMOOKS_TEMPL_ID;
	public static  String TRANSFORMER_PROXY_TEMPL_ID;
	public static  String LOGGING_PROXY_TEMPL_ID;
	public static  String PASS_THROUGH_PROXY_TEMPL_ID;
	public static  String WSDL_BASED_PROXY_TEMPL_ID;
	public static  String SECURE_PROXY_TEMPL_ID;
	public static  String CUSTOM_PROXY_TEMPL_ID;
	public static  String CSS_TEMPL_ID;
	public static  String HTML_TEMPL_ID;
	public static  String JS_TEMPL_ID;
	public static  String SQL_TEMPL_ID;
	public static  String XSL_TEMPL_ID;
	public static  String XSLT_TEMPL_ID;
	public static  String WSDL_TEMPL_ID;
	public static String STATIC_PATHS;
	//Constant for WS-Policy
	public static String WS_POLICY;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, RegistryArtifactConstants.class);
	}
	
	private static List<String> staticPathList;
	public static List<String> getStaticPath(){
		if (staticPathList==null){
			staticPathList = Arrays.asList(STATIC_PATHS.split(","));
		}
		return staticPathList;
	}

}

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

package org.wso2.developerstudio.eclipse.artifact.proxyservice.utils;

import org.eclipse.osgi.util.NLS;

public final class PsArtifactConstants extends NLS{
	public static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.artifact.proxyservice.utils.psartifactconstants";
	public static  String PS_WIZARD_WINDOW_TITLE;
	public static  String PASS_THROUGH_PROXY;
	public static  String SECURE_PROXY;
	public static  String WSDL_BASED_PROXY;
	public static  String LOGGING_PROXY;
	public static  String TRANSFORMER_PROXY;
	public static  String CUSTOM_PROXY;
	public static  String ESB_PROJECT_NATURE;
	
	//project wizard page properties
	public static String WIZARD_OPTION_PS_TYPE;
	public static String WIZARD_OPTION_IMPORT_FILE;
	public static String WIZARD_OPTION_SAVE_LOCATION;
	public static String WIZARD_OPTION_IMPORT_OPTION;
	public static String WIZARD_OPTION_CREATE_ESB_PROJECT;
	public static String WIZARD_OPTION_PS_NAME;
	public static String WIZARD_OPTION_AVAILABLE_PS;
	public static String WIZARD_OPTION_TEMPL_COMMON_PS_PICKFROMREG;
	public static String WIZARD_OPTION_TEMPL_COMMON_PS_ENTERURL;
	public static String WIZARD_OPTION_TEMPL_COMMON_PS_EPURL;
	public static String WIZARD_OPTION_TEMPL_COMMON_PS_EPKEY;
	public static String WIZARD_OPTION_TEMPL_SECURE_PS_SECPOLICY;
	public static String WIZARD_OPTION_TEMPL_WSDL_PS_WSDLURL;
	public static String WIZARD_OPTION_TEMPL_WSDL_PS_WSDLSERVICE;
	public static String WIZARD_OPTION_TEMPL_WSDL_PS_WSDLPORT;
	public static String WIZARD_OPTION_TEMPL_WSDL_PS_PUBLISHSAME;
	public static String WIZARD_OPTION_TEMPL_LOGGING_PS_REQLOGLEVEL;
	public static String WIZARD_OPTION_TEMPL_LOGGING_PS_RESLOGLEVEL;
	public static String WIZARD_OPTION_TEMPL_TRANSFORMER_PS_XSLT;
	public static String WIZARD_OPTION_TEMPL_TRANSFORMER_PS_RESXSLT;
	public static String WIZARD_OPTION_TEMPL_TRANSFORMER_PS_TRANSFORMRESPONSES;
	public static String WIZARD_OPTION_TEMPL_COMMON_PS_PREDEFINED;
	public static String WIZARD_OPTION_TEMPL_COMMON_PS_EPLIST;
	
	//proxy template IDs
	public static  String TRANSFORMER_PROXY_TEMPL_ID;
	public static  String LOGGING_PROXY_TEMPL_ID;
	public static  String PASS_THROUGH_PROXY_TEMPL_ID;
	public static  String WSDL_BASED_PROXY_TEMPL_ID;
	public static  String SECURE_PROXY_TEMPL_ID;
	public static  String CUSTOM_PROXY_TEMPL_ID;

	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, PsArtifactConstants.class);
	}
	
	private PsArtifactConstants(){
		
	}
}

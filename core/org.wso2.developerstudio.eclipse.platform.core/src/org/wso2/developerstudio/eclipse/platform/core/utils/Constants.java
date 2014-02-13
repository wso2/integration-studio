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

package org.wso2.developerstudio.eclipse.platform.core.utils;

import org.eclipse.osgi.util.NLS;

import java.util.ArrayList;
import java.util.List;

public class Constants extends NLS{
	public static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.platform.core.utils.constants";
	
	public static final String POM_FILE_NAME = "pom";
	public static final String POM_FILE_EXTENSION = "xml";
	public static final String ARTIFACT_XML = "artifact.xml";
	
	public static final String JAVA_PROJECT_NATURE ="org.eclipse.jdt.core.javanature"; 
	public static String AXIS2_PROJECT_NATURE;
	public static String BPEL_PROJECT_NATURE;
	public static String DS_PROJECT_NATURE;
	public static String DS_VALIDATOR_PROJECT_NATURE;
	public static String JAXWS_PROJECT_NATURE;
	public static String JAXRS_PROJECT_NATURE;
	public static String WEBAPP_PROJECT_NATURE;
	public static String ESB_PROJECT_NATURE;
	public static String GADGET_PROJECT_NATURE;
	public static String LIBRARY_PROJECT_NATURE;
	public static String MEDIATOR_PROJECT_NATURE;
	public static String REGISTRY_FILTER_PROJECT_NATURE;
	public static String REGISTRY_HANDLER_PROJECT_NATURE;
	public static String GENERAL_PROJECT_NATURE;
	public static String CARBON_UI_PROJECT_NATURE;
	public static String DISTRIBUTION_PROJECT_NATURE;
	public static String CEP_PROJECT_NATURE;
	public static String BRS_PROJECT_NATURE ;
	public static String JAGGERY_NATURE;
	public static String SERVICE_META_PROJECT_NATURE;
	
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Constants.class);
	}
	
	public static List<String> getAllNatures(){
		List<String> list=new ArrayList<String>();
		
		list.add(AXIS2_PROJECT_NATURE);
		list.add(BPEL_PROJECT_NATURE);
		list.add(DS_PROJECT_NATURE);
		list.add(DS_VALIDATOR_PROJECT_NATURE);
		list.add(JAXWS_PROJECT_NATURE);
		list.add(WEBAPP_PROJECT_NATURE);
		list.add(ESB_PROJECT_NATURE);
		list.add(GADGET_PROJECT_NATURE);
		list.add(LIBRARY_PROJECT_NATURE);
		list.add(MEDIATOR_PROJECT_NATURE);
		list.add(REGISTRY_FILTER_PROJECT_NATURE);
		list.add(REGISTRY_HANDLER_PROJECT_NATURE);
		list.add(GENERAL_PROJECT_NATURE);
		list.add(CARBON_UI_PROJECT_NATURE);
		list.add(DISTRIBUTION_PROJECT_NATURE);
		list.add(CEP_PROJECT_NATURE);
		list.add(BRS_PROJECT_NATURE);
		list.add(JAGGERY_NATURE);
		return list;
	}
}

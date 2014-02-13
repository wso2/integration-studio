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

package org.wso2.developerstudio.eclipse.artifact.registry.handler.util;

import org.eclipse.osgi.util.NLS;

public class Constants extends NLS{
	public static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.artifact.registry.handler.util.constants";
	
	public static String REGISTRY_HANDLER_PROJECT_NATURE;
	public static String PROJECT_DEPENDENCIES;
	public static String DEPENDENCY_DELIMITER;
	public static String OPT_NEW_HANDLER_CLASS;
	public static String OPT_IMPORT_HANDLER_CLASS_FROM_WS;
	public static String OPT_IMPORT_HANDLER_CLASS_FROM_FS;
	public static String NEW_HANDLER_CLASS_TEXT;
	public static String IMPORT_HANDLER_CLASS_FROM_WS_TEXT;
	public static String IMPORT_HANDLER_CLASS_FROM_FS_TEXT;
	public static String HANDLER_PROJECT_NAME;
	public static String FROM_EXISTING_FILTER_CLASS;
	public static String NEW_FILTER_CLASS;
	public static String JAVA_NATURE_ID;
	public static String FILTER_SUPER_CLASSNAME;
	public static String HANDLER_SUPER_CLASSNAME;
	public static String METHOD_INFO_GET;
	public static String METHOD_INFO_PUT;
	public static String METHOD_INFO_IMPORT;
	public static String METHOD_INFO_MOVE;
	public static String METHOD_INFO_COPY;
	public static String METHOD_INFO_RENAME;
	public static String METHOD_INFO_CREATE_LINK;
	public static String METHOD_INFO_REMOVE_LINK;
	public static String METHOD_INFO_DELETE;		                             
	public static String METHOD_INFO_PUT_CHILD;	                             
	public static String METHOD_INFO_IMPORT_CHILD;
	public static String METHOD_INFO_INVOKE_ASPECT;
	public static String METHOD_INFO_ADD_ASSOCIATION;
	public static String METHOD_INFO_REMOVE_ASSOCIATION;
	public static String METHOD_INFO_GET_ALL_ASSOCIATIONS;
	public static String METHOD_INFO_GET_ASSOCIATIONS;
	public static String METHOD_INFO_APPLY_TAG;
	public static String METHOD_INFO_REMOVE_TAG;
	public static String METHOD_INFO_RATE_RESOURCE;
	public static String METHOD_INFO_RESTORE_VERSION;
	public static String METHOD_INFO_CREATE_VERSION;
	public static String METHOD_INFO_EDIT_COMMENT;
	public static String METHOD_INFO_ADD_COMMENT;
	public static String METHOD_INFO_REMOVE_COMMENT;
	public static String METHOD_INFO_GET_COMMENTS;
	public static String METHOD_INFO_GET_AVERAGE_RATING;
	public static String METHOD_INFO_GET_RATING;
	public static String METHOD_INFO_GET_VERSIONS;
	public static String METHOD_INFO_GET_TAGS;
	public static String METHOD_INFO_GET_RESOURCE_PATHS_WITH_TAG;
	public static String METHOD_INFO_EXECUTE_QUERY;
	public static String METHOD_INFO_SEARCH_CONTENT;
	public static String METHOD_INFO_RESOURCE_EXISTS;
	public static String METHOD_INFO_DUMP;
	public static String METHOD_INFO_RESTORE;
	public static String CLASS_FQN_URL_MATCHER;
	public static String CLASS_FQN_MEDIA_TYPE_MATCHER;
	
	
	

	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Constants.class);
	}
}

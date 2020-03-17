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

package org.wso2.developerstudio.eclipse.artifact.synapse.api.util;

import org.eclipse.osgi.util.NLS;

public class ArtifactConstants extends NLS {
	private static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.artifact.synapse.api.util.constants"; //$NON-NLS-1$
	
	//control IDs
	public static String ID_API_CONTEXT;
	public static String ID_API_NAME;
	public static String ID_API_HOSTNAME;
	public static String ID_API_PORT;
	public static String ID_CREATE_PRJ;
	public static String ID_CREATE_REG_PRJ;
	public static String ID_SAVE_LOCATION;
	public static String ID_SWAGGER_FILE_REGISTRY_LOCATION;
	public static String ID_API_VERSIONTYPE;
	public static String ID_API_VERSION;
	public static String ID_API_PUBLISHSWAGGER;
	public static String ID_API_SWAGGER_FILE;
	
	//Messages
	public static String ERRMSG_SAVE_LOCATION;
	public static String ERRMSG_API_CONTEXT;
	public static String ERRMSG_API_PORT;
	public static String ERRMSG2_API_CONTEXT;
	
	//API version types
	public static String API_VERSION_TYPE_NONE;
	public static String API_VERSION_TYPE_CONTEXT;
	public static String API_VERSION_TYPE_URL;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, ArtifactConstants.class);
	}

	private ArtifactConstants() {
	}
}

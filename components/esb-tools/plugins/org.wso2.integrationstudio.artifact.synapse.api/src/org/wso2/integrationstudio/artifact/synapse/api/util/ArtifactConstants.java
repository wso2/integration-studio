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

package org.wso2.integrationstudio.artifact.synapse.api.util;

import org.eclipse.osgi.util.NLS;

public class ArtifactConstants extends NLS {
	private static final String BUNDLE_NAME = "org.wso2.integrationstudio.artifact.synapse.api.util.constants"; //$NON-NLS-1$
	
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
	public static String ID_SWAGGER_API_NAME;
	public static String WIZARD_OPTION_APIM_API;
	
	//Messages
	public static String ERRMSG_SAVE_LOCATION;
	public static String ERRMSG_API_CONTEXT;
	public static String ERRMSG_API_PORT;
	public static String ERRMSG2_API_CONTEXT;
	
	//API version types
	public static String API_VERSION_TYPE_NONE;
	public static String API_VERSION_TYPE_CONTEXT;
	public static String API_VERSION_TYPE_URL;
	
	/**
     * Holds common header values.
     */
    public static class HEADERS {
        public static final String APPLICATION_JSON = "application/json";
        public static final String TEXT_JSON = "text/json";
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String AUTHORIZATION = "Authorization";
        public static final String BASIC = "Basic ";
        public static final String BEARER = "Bearer ";
        public static final String ACCEPT = "Accept";
        public static final String UTF_8 = "UTF-8";
        public static final String APPLICATION_FORM_URL_ENCODED = "application/x-www-form-urlencoded";
        public static final String MULTI_PART_FORM_DATA = "multipart/form-data";
    }
    
    public static class Errors {
        public static final String CONNECTION_FAILS = "Cannot connect to the host.";
        public static final String HTTP_ERROR_SENDING_REQUEST = "An error occured while trying to send request!";
        public static final String AUTH_FAILED = "Authentication Failed.";
        public static final String INVALID_CREDENTIAL = "Invalid Login details.";
        public static final String REFRSH_FAIL = "Failed to refresh the connection, Please login agian";
    }
    
    public static class Common {
        public static final String EMPTY_STRING = "";
        public static final String SLASH = "/";
        public static final String COLON = ":";
        public static final String HTTPS = "https";
    }
    
    public static class PublisherAPI {
        public static final String getAPis = "/api/am/publisher/v2/apis";

    }
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, ArtifactConstants.class);
	}

	private ArtifactConstants() {
	}
}

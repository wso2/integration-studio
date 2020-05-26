/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.apim.endpoint.central.resources;

import org.eclipse.osgi.util.NLS;

/**
 * Constants for operations.
 */
public class EndpointCentralConstants extends NLS {

    public static final String PROPERTIES_FILE_BASE_NAME =
            "org.wso2.developerstudio.eclipse.apim.endpoint.central.resources.endpointcentralconstants";
    public static final String ARTIFACT_XML = "artifact.xml";
    public static final String XML = ".xml";
    public static final String SLASH = "/";
    public static final String POM_XML = "pom.xml";
    public static final String SYNAPSE_API = "synapse/api";
    public static final String ORG_WSO2_MAVEN = "org.wso2.maven";
    public static final String WSO2_API_PLUGIN = "wso2-esb-api-plugin";
    public static final String SYNAPSE_API_PATH = "src/main/synapse-config/api";
    public static final String API = "api";
    public static final String DOT = ".";
    public static final String LINE_BREAK = "\n";
    public static final String TAB_SPACES = "    ";
    public static final String NULL_STRING = "null";
    public static final String CLOSE_BRACKET = "}";

    // Create registry entry defaults
    public static String DEFUALT_SERVICE_URL;
    public static String DEFAULT_SERVICE_TYPE;
    public static String DEFAULT_DEFINITION_TYPE;
    public static String DEFAULT_SERVICE_CATEGORY;
    public static String DEFAULT_METADATA;

    // Register client application defaults
    public static String DEFAULT_CLENT_NAME;
    public static String DEFAULT_CALL_BACK_URL;
    public static String DEFAULT_GRANT_TYPE;

    // Obtain token defaults
    public static String DEFAULT_SCOPE;
    public static String DEFAULT_TOKEN_GRANT_TYPE;
    public static String DEFAULT_REGISTRY_NAME;
    
    // Create registry defaults
    public static String DEFAULT_REGISTRY_TYPE;
    public static String DEFAULT_MODE;

    static {
        // initialize resource bundle, this will load all constants from
        // PROPERTIES_FILE_BASE_NAME file to this class
        NLS.initializeMessages(PROPERTIES_FILE_BASE_NAME, EndpointCentralConstants.class);
    }
}

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
package org.wso2.integrationstudio.eclipse.apim.endpoint.central.resources;

/**
 * Holds constants related to Endpoint central Servlet.
 */
public class EndpointCentralServletConstants {
    
    public static final String EMBEDDED_SERVER_PORT = "7774";
    public static final String SERVLET_HOST = "http://127.0.0.1:";
    
    /**
     * Holds request header constants.
     */
    public static class RequestHeaders {
        public static final String HEADER_OPERATION_TYPE = "x-operation-type";
        public static final String LOGIN = "login";
        public static final String LOGOUT = "logout";
        public static final String PROFILE_DATA = "profile-data";
        public static final String CHECK_LOGIN = "check-login";
        public static final String CREATE_REGISTRY_ENTRY = "create-registry-entry";
        public static final String GET_REGISTRY_ENTRIES = "get-registry-entries";
        public static final String GET_PROJECTS = "get-projects";
        public static final String IMPORT_API = "import-api";
        public static final String APPLICATION_JSON = "application/json";
    }
    
    /**
     * Holds request header constants of APIM CTL.
     */
    public static class APIMCTLRequestHeaders {
        public static final String LOGIN = "apim-ctl-login";
        public static final String PUSH_API = "apim-ctl-push-api";
    }

    /**
     * Holds error messages for the response.
     */
    public static class ResponseMessages {
        public static final String NOT_LOGGED = "Not logged";
        public static final String LOGGED = "logged";
        public static final String TRUE_STRING = "true";
        public static final String ERROR = "error";
        public static final String LOGIN_DETAILS_MISSING = "Loging details are missing.";
    }
    
    /**
     * Holds constants of the servlet startup.
     */
    public static class Startup {
        public static final String WEB_APP_LOCATION = "WebAppContent";
        public static final String ENDPOINT_CENTRAL_CONTEXT_PATH = "/endpointcentral";
        public static final String SERVLET_PATH = "/service";
        public static final String ROOT_PATH = "/";
        public static final String APIM_CTL_LOGIN_PATH = "/login_apim_ctl.html";
    }
}

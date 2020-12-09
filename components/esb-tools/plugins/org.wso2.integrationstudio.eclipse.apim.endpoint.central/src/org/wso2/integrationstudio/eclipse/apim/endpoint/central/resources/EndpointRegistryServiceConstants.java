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

import java.io.File;

/**
 * Holds constants related to the registry service.
 */
public class EndpointRegistryServiceConstants {
    
    public static final String CLIENT_REGISTRATION_PATH_PREFIX = "/client-registration/";
    public static final String CLIENT_REGISTRATION_PATH_SUFFIX = "/register";
    public static final String ENDPOINT_REGISTRY_PATH_PREFIX = "/api/am/endpoint-registry/";
    public static final String ENDPOINT_REGISTRY_PATH_SUFFIX = "/registries";
    public static final String ENDPOINT_REGISTRY_ENTRIES_PATH = "/entries";
    public static final String ENDPOINT_REGISTRY_ENTRY_PATH = "/entry";
    public static final String ENDPOINT_REGISTRY_DEFINITION_PATH = "/definition-file";
    public static final String TOKEN_PATH = "/oauth2/token";
    public static final String REGISTRY_ENTRY = "registryEntry";
    public static final String DEFINITION_FILE = "definitionFile";

    public static String getClientRegistrationUrl(String baseUrl, String version) {
        return baseUrl + CLIENT_REGISTRATION_PATH_PREFIX + version + CLIENT_REGISTRATION_PATH_SUFFIX;
    }
    
    public static String getEndpointRegistryUrl(String baseUrl, String version) {
        return baseUrl + ENDPOINT_REGISTRY_PATH_PREFIX + version + ENDPOINT_REGISTRY_PATH_SUFFIX;
    }
    
    public static String getTokenUrl(String baseUrl) {
        return baseUrl + TOKEN_PATH;
    }

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
    
    public static class ClientRegistrationPayload {
        public static final String CALL_BACK_URL = "callbackUrl";
        public static final String CLIENT_NAME = "clientName";
        public static final String OWNER = "owner";
        public static final String GRANT_TYPE = "grantType";
        public static final String SAAS_APP = "saasApp";
    }
    
    public static class ClientRegistrationResult {
        public static final String CLIENT_ID = "clientId";
        public static final String CLIENT_SECRET = "clientSecret";
    }
    
    public static class TokenGenerationParams {
        public static final String GRANT_TYPE = "grant_type";
        public static final String USERNAME = "username";
        public static final String PASSWORD = "password";
        public static final String SCOPE = "scope";
    }
    
    public static class TokenGenerationResults {
        public static final String ACCESS_TOKEN = "access_token";
        public static final String REFRESH_TOKEN = "refresh_token";
    }
    
    public static class Credentials {
        public static final String ACCESS_TOKEN = "accessToken";
        public static final String REFRESH_TOKEN = "refreshToken";
        public static final String REGISTRY_ID = "registryId";
        public static final String REGISTRY_NAME = "registryName";
        public static final String ENDPOINT_REG_VERSION = "endpointRegistryVersion";
        public static final String BASE_URL = "baseUrl";
        public static final String ENDCODED_CLIENT_ID_SECRET = "encodedClientIdSecret";
        public static final String USER_NAME = "userName";
        public static final String CREDENTIAL_FILE_PATH = File.separator + ".metadata" + File.separator
                + "endpoint-credentials.properties";
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
}

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
 * Constants related to APIM Controller.
 */
public class APIMCTLConstants {
    public static final String APICTL_FOLDER = "apictl";
    public static final String TOOLING_PATH_MAC = "/Applications/IntegrationStudio.app/Contents/Eclipse";
    public static final String TOKEN_PATH = "/oauth2/token";
    public static final String APICTL = "apictl";
    public static final String APICTL_EXE = "apictl.exe";
    public static final String EMPTY_STRING = "";
    public static final String QUOTES = "\"";

    public static final class Commands {
        public static final String ADD_ENV = "add-env";
        public static final String LOGIN = "login";
        public static final String LIST = "list";
        public static final String IMPORT_API = "import-api";
        public static final String ENVIRONMENTS = "envs";
        public static final String APIS = "apis";
    }

    public static final class Params {
        public static final String FILE = "-f";
        public static final String ENVIRONMENT = "-e";
        public static final String USERNAME = "-u";
        public static final String PASSWORD = "-p";
        public static final String MINUS_K = "-k";
        public static final String APIM_ENDPOINT = "--apim";
        public static final String TOKEN_ENDPOINT = "--token";
        public static final String FORMAT = "--format";
        public static final String JSON_FORMAT = "\"{{ json . }}\"";
    }

    public static final class Environment {
        public static final String DEFAULT_ENV_NAME = "default-environment";
        public static final String NAME = "Name";
        public static final String API_MANAGER_ENDPOINT = "ApiManagerEndpoint";
        public static final String TOKEN_ENDPOINT = "TokenEndpoint";
    }

    public static final class CTLResponses {
        public static final String SUCCESSFULLY_ADDED_ENVIRONMENT = "Successfully added environment";
        public static final String LOGGED_IN = "Logged into";
        public static final String WARNING = "Warning:";
    }
}

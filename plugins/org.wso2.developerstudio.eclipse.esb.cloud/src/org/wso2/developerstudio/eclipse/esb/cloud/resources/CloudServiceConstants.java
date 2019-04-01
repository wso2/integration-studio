/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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

package org.wso2.developerstudio.eclipse.esb.cloud.resources;

/**
 * Contains string values used for Cloud API related tasks
 *
 */
public class CloudServiceConstants {

    // Integration Cloud Domain
    public static final String DOMAIN_URL = "https://integration.cloud.wso2.com/appmgt/site/blocks/";

    // Integration Cloud Endpoints
    public static class ServiceEndpoints {
        public static final String LOGIN_URL = DOMAIN_URL + "user/login/ajax/login.jag";
        public static final String APPLICATION_URL = DOMAIN_URL + "application/application.jag";
        public static final String INDEX_URL = DOMAIN_URL + "index/ajax/index.jag";
    }

    // Integration Cloud Environment Configurations
    public static class AppConfigs {
        public static final String ESB = "wso2esb";
        public static final String RUNTIME = "24";
        public static final String CON_SPEC = "5";
        public static final String APP_CREATION_METHOD = "default";
        public static final String SET_DEFAULT_VERSION = "true";
        public static final String IS_FILE_ATTACHED = "true";
        public static final String RUNTIME_PROPERTIES = "[]";
    }

    // Integration Cloud API actions
    public static class Actions {
        public static final String LOGIN = "login";
        public static final String GET_APPLICATION_LIST = "getApplicationList";
        public static final String GET_APPLICATION = "getApplication";
        public static final String LOAD_ENDPOINTS = "loadEndpoints";
        public static final String CREATE_APPLICATION = "createApplication";
        public static final String GET_RUNTIMES = "getRuntimesForAppType";
    }

    // Integration Cloud response messages
    public static class ResponseMessages {
        public static final String USER_SUCCESSFULLY_LOGGED_IN = "User successfully logged in";
        public static final String NO_RESOURCES_ERROR = "Application creation request not accepted as there are no resources available to create a new application/version";
        public static final String VERSION_EXISTS_ERROR = "applicationRevision is required!";
        public static final String APP_REVISION_ERROR = "Bad request : applicationRevision is required!";
        public static final String APP_EXISTS_ERROR = "Bad request : Application with same name and version already exists!";
    }

    // Integration Cloud parameters
    public static class Parameters {
        public static final String PARAM_FILE = "fileupload";
        public static final String PARAM_ICON = "appIcon";
        public static final String PARAM_ACTION = "action";
        public static final String PARAM_APP_NAME = "applicationName";
        public static final String PARAM_APP_DESCRIPTION = "applicationDescription";
        public static final String PARAM_APP_TYPE_NAME = "appTypeName";
        public static final String PARAM_APP_REVISION = "applicationRevision";
        public static final String PARAM_FILE_NAME = "uploadedFileName";
        public static final String PARAM_RUNTIME_PROPERTIES = "runtimeProperties";
        public static final String PARAM_TAGS = "tags";
        public static final String PARAM_IS_FILE_ATTACHED = "isFileAttached";
        public static final String PARAM_CON_SPEC = "conSpec";
        public static final String PARAM_IS_NEW_VERSION = "isNewVersion";
        public static final String PARAM_APP_CREATION_METHOD = "appCreationMethod";
        public static final String PARAM_SET_DEFAULT_VERSION = "setDefaultVersion";
        public static final String PARAM_RUNTIME = "runtime";
        public static final String PARAM_APP_TYPE = "appType";
        public static final String PARAM_DEPLOYMENT_URL = "deploymentURL";
        public static final String PARAM_VERSION_ID = "versionId";
        public static final String PARAM_USERNAME = "userName";
        public static final String PARAM_PASSWORD = "password";
    }
}

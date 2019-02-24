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

public class CloudServiceConstants {
    
    public static class ServiceEndpoints {
        public static final String LOGIN_URL = "https://integration.cloud.wso2.com/appmgt/site/blocks/user/login/ajax/login.jag";
        public static final String APPLICATION_URL = "https://integration.cloud.wso2.com/appmgt/site/blocks/application/application.jag";
    }
    
    public static class AppConfigs {
        public static final String ESB = "wso2esb";
        public static final String RUNTIME = "24";
    }
    
    public static class ErrorMessages {
        public static final String DEPLOY_TO_CLOUD_FAILED_MESSAGE = "Could not deploy the Application to the Integration Cloud.";
        public static final String DEPLOY_TO_CLOUD_FAILED_TITLE = "Error deploying the application";
        public static final String DEPLOY_TO_CLOUD_INTERNAL_ERROR_MSG = "Could not deploy application because of an internal error.";

        }

    public static class SuccessMessages {
        public static final String SUCCESSFUL_TITLE = "Successful";
        public static final String DEPLOY_TO_CLOUD_SUCCESS_MESSAGE = "Application Deployed to Cloud Successfully! \n Test";
    }
}

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
 * Constants related to Cloud deployment wizard.
 *
 */
public class CloudDeploymentWizardConstants {

    public static final String DIALOG_TITLE_TEXT = "WSO2 Platform Distribution - Deploy to Integration Cloud";
    public static final String EMPTY_STRING = "";
    
    public static final String CAR_FILE_SUFFIX = ".car$";
    public static final String CAR_FILE_NAME_PLACEHOLDER = "%s_%s.car";
    
    public static class ErrorMessages {
        public static final String DEPLOY_TO_CLOUD_FAILED_MESSAGE = "Could not deploy the Application to the Integration Cloud.";
        public static final String DEPLOY_TO_CLOUD_FAILED_TITLE = "Error deploying the application";
        public static final String DEPLOY_TO_CLOUD_INTERNAL_ERROR_MSG = "Could not deploy application because of an internal error.";
        public static final String DEPLOY_TO_CLOUD_REQUEST_ERROR_MSG = "Could not complete request.";
        public static final String ERROR_CREATING_CAR_FILE_MSG = "An error occured while deploying the application";
        public static final String SELECT_VALID_CARBON_APP_MESSAGE = "Please select a valid carbon application project";
   }

    public static class SuccessMessages {
        public static final String SUCCESSFUL_TITLE = "Successful";
        public static final String DEPLOY_TO_CLOUD_SUCCESS_MESSAGE = "Application Deployed to Cloud Successfully!";
        public static final String SUCCESS_CREATING_APPLICATION_MSG = "Please wait while your application is being deployed to the cloud. You will be notified once it is ready.";
    }

}

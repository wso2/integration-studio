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

package org.wso2.integrationstudio.eclipse.docker.distribution.resources;

import java.io.File;

/**
 * Constants related to Docker image export wizard.
 *
 */
public class ExportImageWizardConstants {

    public static final String DIALOG_TITLE_TEXT = "WSO2 Platform Distribution - Generate Docker Image";
    public static final String SELECT_VALID_CARBON_APP_MESSAGE = "Please select a valid carbon application project";
    public static final String ERROR_CREATING_CAR_FILE_MSG = "An error occured while creating the carbon archive file";
    public static final String EMPTY_STRING = "";

    public static final String EI_DISTRIBUTION_NAME = "wso2ei-7.0.0";
    public static final String MICRO_EI_DISTRIBUTION_REL_PATH = "runtime" + File.separator + "microesb";
    public static final String DEPLOYMENT_DIR_REL_PATH = "repository" + File.separator + "deployment" + File.separator
            + "server" + File.separator + "carbonapps";

    public static final String EI_TOOLING_HOME_MACOS = "/Applications/IntegrationStudio.app/Contents/Eclipse";
    public static final String OS_TYPE_DARWIN = "darwin";
    public static final String OS_TYPE_MAC = "mac";
    public static final String DOCKER_IMAGE_TEMPORARY_DIR_NAME = "dockerTempDir";

    public static final String OS_NAME = "os.name";
    public static final String SYSTEM_PROPERTY_TYPE_GENERIC = "generic";

    public static final String CAR_FILE_SUFFIX = ".car$";
    public static final String CAR_FILE_NAME_PLACEHOLDER = "%s_%s.car";

}

/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.docker.distribution.utils;

import org.eclipse.osgi.util.NLS;

public class DockerProjectConstants extends NLS {

    public static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.docker.distribution.utils.dockerprojectconstants";

    public static String WIZARD_OPTION_PROJECT_NAME;
    public static String WIZARD_OPTION_IMPORT_FILE;
    public static String SERVICE_NAME;
    public static String DS_WIZARD_WINDOW_TITLE;
    public static String DS_PROJECT_DATASERVICE_FOLDER;

    public static String ERROR_MESSAGE_CORE_EXCEPTION;
    public static String ERROR_MESSAGE_UNEXPECTED_ERROR;
    public static String ERROR_DBS_LOCATION;
    public static String ERROR_DBS_FILE;
    public static String ERROR_DS_NAME;

    public static String EXTENTION_POINT_NAME;
    public static String DOCKER_NATURE;
    public static String DOCKER_EDITOR;
    public static String DOCKER_FILE_EDITOR;
    public static String DOCKER_FILE_NAME;

    public static String CARBON_APP_FOLDER;
    public static String LIBS_FOLDER;
    public static String CARBON_APP_FOLDER_LOCATION;
    public static String LIBS_FOLDER_LOCATION;

    public static String MAVEN_DEPENDENCY_PLUGIN_VERSION;
    public static String SPOTIFY_DOCKER_PLUGIN_VERSION;

    public static String PLUGIN_ID;

    public static String DOCKER_REPOSITORY_KEY;
    public static String DOCKER_TAG_KEY;
    public static String DOCKER_REMOTE_REPOSITORY_KEY;
    public static String DOCKER_REMOTE_TAG_KEY;

    public static String DOCKER_DEFAULT_REPOSITORY;
    public static String DOCKER_DEFAULT_TAG;

    public static final String DOCKER_REPOSITORY = "repository";
    public static final String DOCKER_TAG = "tag";

    public static final String UNIX_DEFAULT_DOCKER_HOST = "unix:///var/run/docker.sock";
    public static final String WINDOWS_DEFAULT_DOCKER_HOST = "tcp://localhost:2375";
    public static final String DOCKER_IMAGE_GEN_SUCCESS_MESSAGE = "Docker image successfully generated. \nImage ID: ";
    public static final String DOCKER_IMAGE_GEN_FAILED_MESSAGE = "Docker image generaton failed";
    public static final String DOCKER_CONNECTION_FAILED_MESSAGE = "Failed to connect with docker in the local machine";
    public static final String MESSAGE_BOX_TITLE = "Docker image exporter";
    public static final String OS_NAME = "os.name";
    public static final String WINDOWS = "win";

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, DockerProjectConstants.class);
    }

    public DockerProjectConstants() {

    }
}

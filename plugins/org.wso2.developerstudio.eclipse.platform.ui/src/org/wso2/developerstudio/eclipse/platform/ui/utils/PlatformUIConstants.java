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
package org.wso2.developerstudio.eclipse.platform.ui.utils;

public class PlatformUIConstants {
    public static final String NO_TARGET_REPO_MESSAGE = "Specify a target repository for the Docker container project";
    public static final String INVALID_TARGET_REPO_MESSAGE = "Target repository is invalid. Please correct the repository name";
    public static final String NO_TARGET_TAG_MESSAGE = "Specify a target tag for the Docker project";
    public static final String INVALID_TARGET_TAG_MESSAGE = "Target tag is invalid. Please correct the tag name";
    public static final String NO_REMOTE_REPOSITORY_MESSAGE = "Specify a remote repository for the Docker container project";
    public static final String NO_REMOTE_TAG_MESSAGE = "Specify a remote tag for the Docker container project";
    public static final String NO_TARGET_TAG_ERROR = "Specify a target tag for the Docker container project";
    public static final String NO_CONTAINER_NAME = "Specify a name for the Integration";
    public static final String NO_KUBE_REMOTE_REPOSITORY = "Specify a remote repository for the Kubernetes deployment";
    public static final String NO_KUBE_REMOTE_TAG = "Specify a remote tag for the Kubernetes deployment";
    public static final String NO_KUBE_TARGET_REPOSITORY = "Specify a target repository for the Kubernetes deployment";
    public static final String TARGET_REPOSITORY_INVALID = "Target Repository should be in {registry-url}/{username}/{repository} or {username}/{repository} pattern";
    public static final String INVALID_REPLICA_COUNT = "Specify number of replicas need for the Kubernetes deployment";
    public static final String INVALID_REPLICA_COUNT_NOT_AS_INT = "Specify a integer value for replicas which need for the Kubernetes deployment";
    public static final String INVALID_PORT = "Specify valid port to expose the Kubernetes container";
    public static final String INVALID_PORT_TYPE = "Specify valid port in integer to expose the Kubernetes container";
    public static final String INVALID_PORT_RANGE = "Specify valid port range to expose the Kubernetes container";
    public static final String DOCKER_REPO_REGEX = "(([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]|"
            + "[a-zA-Z0-9])([.]([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]|[a-zA-Z0-9]))*(:[0-9]+\\/))?"
            + "((([a-z0-9]+)((__|[._]|[-]+)([a-z0-9]+))*)(\\/([a-z0-9]+)((__|[._]|[-]+)([a-z0-9]+))*)*)";
    public static final String DOCKER_TAG_REGEX = "[\\w][\\w.-]{0,127}";
    public static final String DOCKER_DEFAULT_BASE_REPOSITORY = "wso2/wso2mi";
    public static final String DOCKER_DEFAULT_BASE_TAG = "1.2.0";
    public static final String MI_DEPLOYMENT_TOML_TEMPLATE_VERSION = "1.2.0";

}

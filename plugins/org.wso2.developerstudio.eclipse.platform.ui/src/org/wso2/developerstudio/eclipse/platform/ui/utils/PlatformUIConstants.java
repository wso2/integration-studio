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
    public static final String NO_TARGET_REPO_MESSAGE = "Specify a target repository for the Docker project";
    public static final String INVALID_TARGET_REPO_MESSAGE = "Target repository is invalid. Please correct the repository name";
    public static final String NO_TARGET_TAG_MESSAGE = "Specify a target tag for the Docker project";
    public static final String INVALID_TARGET_TAG_MESSAGE = "Target tag is invalid. Please correct the tag name";
    public static final String NO_REMOTE_REPOSITORY_MESSAGE = "Specify a remote repository for the Docker project";
    public static final String NO_REMOTE_TAG_MESSAGE = "Specify a remote tag for the Docker project";
    public static final String DOCKER_REPO_REGEX = "(([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]|"
            + "[a-zA-Z0-9])([.]([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]|[a-zA-Z0-9]))*(:[0-9]+\\/))?"
            + "((([a-z0-9]+)((__|[._]|[-]+)([a-z0-9]+))*)(\\/([a-z0-9]+)((__|[._]|[-]+)([a-z0-9]+))*)*)";
    public static final String DOCKER_TAG_REGEX = "[\\w][\\w.-]{0,127}";

}

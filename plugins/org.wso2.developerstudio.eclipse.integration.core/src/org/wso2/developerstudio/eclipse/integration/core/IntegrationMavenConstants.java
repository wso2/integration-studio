/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.integration.core;

public class IntegrationMavenConstants {

    public static final String WSO2_INTEGRATION_CONNECTION_VERSION = "2.1.0";
    public static final String WSO2_INTEGRATION_INTEGRATION_TEMPLATE_VERSION = "2.1.0";
    public static final String WSO2_INTEGRATION_CONNECTOR_VERSION = "1.0.0";
    public static final String WSO2_INTEGRATION_INTEGRATION_VERSION = "2.1.0";
    public static final String WSO2_GENERAL_PROJECT_VERSION = "2.1.0";
    public static final String PACKAGE_PHASE = "package";
    public static final String INSTALL_PHASE = "install";
    public static final String DEPLOY_PHASE = "deploy";
    public static final String EXEC_GOAL = "exec";
    public static final String EXECUTABLE_TAG = "executable";
    public static final String EXECUTABLE_VALUE = "mvn";
    public static final String WORKING_DIRECTORY_TAG = "workingDirectory";
    public static final String WORKING_DIRECTORY_VALUE = "${project.build.directory}";
    public static final String ARGUMENTS_TAG = "arguments";
    public static final String ARGUMENT_TAG = "argument";
    public static final String ARGUMENT_VALUE_CLEAN = "clean";
    public static final String ARGUMENT_VALUE_SKIP_TESTS = "-Dmaven.test.skip=${maven.test.skip}";
}

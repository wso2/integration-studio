/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.integrationstudio.bpmn.extensions.readTask;

public class ReadTaskConstants {

    // Palette Related constants.
    public static final String PALETTE_WSO2 = "WSO2 Tasks";

    // Icons
    public static final String ICONS_READ_TASK = "icons/rest.png";

    // Rest Task Related constants.
    public static final String READ_TASK_NAME = "READ Task";
    public static final String READ_TASK_CLASS = "org.wso2.carbon.bpmn.extensions.tasks.ReadTask";
    public static final String READ_TASK_HELP = "Execute read task";
    public static final String READ_TASK_HELP_LONG = "Provides read task implementation for reading "
            + "resources from a source and populate it to given variable (by name) ";

    public static final String RESOURCE_LABEL = "Resource";
    public static final String RESOURCE_HELP = "Resource";
    public static final String RESOURCE_HELP_LONG =
            "Resource name (incase if the resource is registry resource, this should be resource path)";

    public static final String ORIGIN_LABEL = "Origin";
    public static final String ORIGIN_HELP = "Origin";
    public static final String ORIGIN_HELP_LONG =
            "origin / source type. Supported sources : REGISTRY, ENVIRONMENT, SYSTEM";

    public static final String ORIGIN_REGISTRY_LABEL = "REGISTRY";
    public static final String ORIGIN_REGISTRY_VALUE = "REGISTRY";
    public static final String ORIGIN_ENVIRONMENT_LABEL = "ENVIRONMENT";
    public static final String ORIGIN_ENVIRONMENT_VALUE = "ENVIRONMENT";
    public static final String ORIGIN_SYSTEM_LABEL = "SYSTEM";
    public static final String ORIGIN_SYSTEM_VALUE = "SYSTEM";

    public static final String TARGET_LABEL = "Target";
    public static final String TARGET_HELP = "Target";
    public static final String TARGET_HELP_LONG =
            "target variable name that should be populated with the content read by this task";

    public static final String TYPE_LABEL = "Type";
    public static final String TYPE_HELP = "Type";
    public static final String TYPE_HELP_LONG =
            "type of the variable name. Content read by this task will be parsed / converted to given type."
            + " Supported types: string, integer, boolean, json, xml";

    public static final String TYPE_STRING_LABEL = "string";
    public static final String TYPE_STRING_VALUE = "string";
    public static final String TYPE_INTEGER_LABEL = "integer";
    public static final String TYPE_INTEGER_VALUE = "integer";
    public static final String TYPE_BOOLEAN_LABEL = "boolean";
    public static final String TYPE_BOOLEAN_VALUE = "boolean";
    public static final String TYPE_JSON_LABEL = "json";
    public static final String TYPE_JSON_VALUE = "json";
    public static final String TYPE_XML_LABEL = "xml";
    public static final String TYPE_XML_VALUE = "xml";
}


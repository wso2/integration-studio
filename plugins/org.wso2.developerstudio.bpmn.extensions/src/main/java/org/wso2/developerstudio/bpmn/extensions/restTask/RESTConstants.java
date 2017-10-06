/**
 * Copyright (c) 2016 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.bpmn.extensions.restTask;

public interface RESTConstants {

    // Palette Related constants.
    public static final String PALETTE_WSO2 = "WSO2 Tasks";

    // Icons
    public static final String ICONS_REST_TASK = "icons/rest.png";

    // Rest Task Related constants.
    public static final String REST_TASK_NAME = "REST Task";
    public static final String REST_TASK_CLASS = "org.wso2.carbon.bpmn.extensions.rest.RESTTask";
    public static final String REST_TASK_HELP = "Invoke Rest API";
    public static final String REST_TASK_HELP_LONG = "Provides REST service invocation support within BPMN processes.";

    public static final String SERVICE_URL_LABEL = "Service URL";
    public static final String SERVICE_URL_HELP = "Service URL";
    public static final String SERVICE_URL_HELP_LONG =
            "This parameter can be used to give a URL of a REST service endpoint, which cannot be changed after " +
                    "deployment. Supports expressions.";

    public static final String BASIC_AUTH_USER_LABEL = "BasicAuth Username";
    public static final String BASIC_AUTH_USER_HELP = "BasicAuth Username";
    public static final String BASIC_AUTH_USER_HELP_LONG =
            "This parameter can be used to provide username for basic authentication for above Service URL. Supports " +
                    "expressions.";

    public static final String BASIC_AUTH_PASSWORD_LABEL = "BasicAuth Password";
    public static final String BASIC_AUTH_PASSWORD_HELP = "BasicAuth Passowrd";
    public static final String BASIC_AUTH_PASSWORD_HELP_LONG =
            "This parameter can be used to provide password for basic authentication for above Service URL. Supports " +
                    "expressions.";

    public static final String EPR_LABEL = "Service Reference (EPR)";
    public static final String EPR_HELP = "Service Reference (EPR)";
    public static final String EPR_HELP_LONG =
            "This parameter can be used to point to a registry location which contains an endpoint reference as " +
                    "mentioned in" +
                    " <a href=\"https://docs.wso2.com/display/EI620/Endpoint+References\" >https://docs.wso2" +
                    ".com/display/EI620/Endpoint+References</a> " +
                    "URLs given in such registry resources can be changed after deployment and the current value of " +
                    "the registry resource will be read before each service invocation.  " +
                    "Supports expressions. When Both Service URL and Service Reference (EPR) are defined, only " +
                    "Service URL will be used. <br/>Eg: conf:/epr/echoService.epr";

    public static final String METHOD_GET_LABEL = "GET";
    public static final String METHOD_GET_VALUE = "GET";
    public static final String METHOD_POST_LABEL = "POST";
    public static final String METHOD_POST_VALUE = "POST";
    public static final String METHOD_PUT_LABEL = "PUT";
    public static final String METHOD_PUT_VALUE = "PUT";
    public static final String METHOD_DELETE_LABEL = "DELETE";
    public static final String METHOD_DELETE_VALUE = "DELETE";
    public static final String METHOD_LABEL = "HTTP method";
    public static final String METHOD_HELP = "HTTP method";
    public static final String METHOD_HELP_LONG =
            "HTTP method that need to be used for Rest service invocation. Support GET, POST, PUT and DELETE";

    public static final String INPUT_LABEL = "Input Payload";
    public static final String INPUT_HELP = "Input Payload";
    public static final String INPUT_HELP_LONG = "Input payload for rest invocation. Support Expressions.";

    public static final String OUTPUT_VARIABLE_LABEL = "Output Variable name";
    public static final String OUTPUT_VARIABLE_HELP = "Output Variable";
    public static final String OUTPUT_VARIABLE_HELP_LONG =
            "Process Variable to store the output received from the REST service (as raw content).";

    public static final String OUTPUT_VARIABLE_MAPPING_LABEL = "Output Variable Mappings";
    public static final String OUTPUT_VARIABLE_MAPPING_HELP = "Output Variable";
    public static final String OUTPUT_VARIABLE_MAPPING_HELP_LONG =
            "Define Parts of the output that need to be mapped to different process variables. When Both Output " +
                    "Variable and Output Variable Mappings are defined, output variable will be used." +
                    "<br/> Support only for JSON. Format: VariableName1:JSON_PATH1,VariableName2:JSON_PATH2" +
                    "<br/> Eg: var2:customer.name,var3:item.price";

    public static final String HEADERS_LABEL = "Transport headers";
    public static final String HEADERS_HELP = "Transport headers";
    public static final String HEADERS_HELP_LONG = "Additional headers. Supports expressions and fixed values.\n" +
            "\n\r The headers should be given in the format : headerName1:headerValue1, headerName2:headerValue2." +
            "\n\r Eg: Content-Type:application/json,Accept:application/json ";
}

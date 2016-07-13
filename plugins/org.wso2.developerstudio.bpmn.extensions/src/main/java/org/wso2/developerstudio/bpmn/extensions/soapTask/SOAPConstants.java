/*
 * Copyright 2005-2015 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.bpmn.extensions.soapTask;

public interface SOAPConstants {

    // Palette Related constants.
    public static final String PALETTE_WSO2 = "WSO2 Tasks";

    // Icons
    public static final String ICONS_SOAP_TASK = "icons/soap.png";

    // SOAP Task Related constants.
    public static final String SOAP_TASK_NAME = "SOAP Task";
    public static final String SOAP_TASK_CLASS = "org.wso2.carbon.bpmn.extensions.soap.SOAPTask";
    public static final String SOAP_TASK_HELP = "Invokes the SOAP client";
    public static final String SOAP_TASK_HELP_LONG = "Provides SOAP service or partner service invocation support " +
            "within BPMN processes.";


    public static final String SERVICE_URL_LABEL = "Service URL";
    public static final String SERVICE_URL_HELP = "Service URL";
    public static final String SERVICE_URL_HELP_LONG =
            "This parameter can be used to give a URL of a SOAP service endpoint, which cannot be changed after " +
                    "deployment. Supports expressions and string values.\n" +
                    "\n\n \r Eg : http://10.100.4.192:9763/services/HelloService";


    public static final String INPUT_LABEL = "Input Payload";
    public static final String INPUT_HELP = "Input Payload";
    public static final String INPUT_HELP_LONG = "Input payload for the SOAP invocation. Supports expressions and " +
            "string values. This payload is attached to the " +
            "SOAP Body when creating the SOAP request. Give the payload as a xml string.";


    public static final String HEADER_BLOCK_LABEL = "SOAP Headers";
    public static final String HEADER_BLOCK_HELP = "SOAP Headers";
    public static final String HEADER_BLOCK_HELP_LONG = "Header block attached to the SOAP Header when creating the " +
            "SOAP request. Supports expressions and fixed values.\n" +
            "Give the payload as a xml string.";


    public static final String OUTPUT_VARIABLE_LABEL = "Output Variable name";
    public static final String OUTPUT_VARIABLE_HELP = "Output Variable";
    public static final String OUTPUT_VARIABLE_HELP_LONG =
            "Process Variable to store the output received from the SOAP service (as raw content).";


    public static final String SOAP_VERSION_LABEL = "Soap version";
    public static final String SOAP_VERSION_HELP = "Soap version";
    public static final String SOAP_VERSION_HELP_LONG =
            "Soap version needed to create the SOAP request message. Select from soap11 or soap12.";


    public static final String HTTP_CONNECTION_LABEL = "HTTP Connection";
    public static final String HTTP_CONNECTION_HELP = "HTTP Connection";
    public static final String HTTP_CONNECTION_HELP_LONG =
            "HTTP Connection attribute value needed for the HTTP transport headers. Control options for the current " +
                    "connection. Supports expressions and fixed values. \n" +
                    " \n\r Defined values for the attribute are :keep-alive (set as the default value), close ";


    public static final String HTTP_TRANSFER_ENCODING_LABEL = "HTTP Transfer Encoding";
    public static final String HTTP_TRANSFER_ENCODING_HELP = "HTTP Transfer Encoding";
    public static final String HTTP_TRANSFER_ENCODING_HELP_LONG =
            "HTTP Transfer Encoding attribute value needed for the HTTP transport headers. Supports expressions and " +
                    "fixed values. \n" +
                    "\n\r Defined values for the attribute are : chunked(set as the default value), compress, " +
                    "deflate, gzip, identity.";


    public static final String SOAP_ACTION_LABEL = "Soap action";
    public static final String SOAP_ACTION_HELP = "Soap action";
    public static final String SOAP_ACTION_HELP_LONG =
            "Soap action attribute value needed for the HTTP transport headers";


    public static final String TRANSPORT_HEADERS_LABEL = "Transport headers";
    public static final String TRANSPORT_HEADERS_HELP = "Transport headers";
    public static final String TRANSPORT_HEADERS_HELP_LONG = "Additional transport headers apart from Connection and " +
            "Transfer-Encoding. Supports expressions and fixed values.\n" +
            "\n\r The additional HTTP headers should be given in the format : headerName1:headerValue1, " +
            "headerName2:headerValue2." +
            "\n\r Eg: Pragma: no-cache,Cache-Control: no-cache ";


    public static final String SOAP11_LABEL = "soap11";
    public static final String SOAP11_VALUE = "soap11";

    public static final String SOAP12_LABEL = "soap12";
    public static final String SOAP12_VALUE = "soap12";

}

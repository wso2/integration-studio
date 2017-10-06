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

import org.activiti.designer.integration.annotation.Help;
import org.activiti.designer.integration.annotation.Property;
import org.activiti.designer.integration.annotation.PropertyItems;
import org.activiti.designer.integration.annotation.Runtime;
import org.activiti.designer.integration.servicetask.AbstractCustomServiceTask;
import org.activiti.designer.integration.servicetask.PropertyType;

/**
 * SOAP Task Activity Designer implementation.
 *
 * @See org.wso2.carbon.bpmn.extensions.soap.SOAPTask
 */
@Runtime(javaDelegateClass = SOAPConstants.SOAP_TASK_CLASS)
@Help(displayHelpShort = SOAPConstants.SOAP_TASK_HELP, displayHelpLong = SOAPConstants.SOAP_TASK_HELP_LONG)
public class SOAPTask extends AbstractCustomServiceTask {

    @Override
    public String getName() {
        return SOAPConstants.SOAP_TASK_NAME;
    }

    @Override
    public String contributeToPaletteDrawer() {
        return SOAPConstants.PALETTE_WSO2;
    }

    @Override
    public String getSmallIconPath() {
        return SOAPConstants.ICONS_SOAP_TASK;
    }

    /**
     * @See SOAPConstants.SERVICE_URL_HELP_LONG
     */
    @Property(type = PropertyType.TEXT, displayName = SOAPConstants.SERVICE_URL_LABEL, required = true)
    @Help(displayHelpShort = SOAPConstants.SERVICE_URL_HELP, displayHelpLong = SOAPConstants.SERVICE_URL_HELP_LONG)
    private String serviceURL;

    /**
     * @See SOAPConstants.EPR_HELP_LONG
     */
    @Property(type = PropertyType.TEXT, displayName = SOAPConstants.EPR_LABEL, required = false)
    @Help(displayHelpShort = SOAPConstants.EPR_HELP, displayHelpLong = SOAPConstants.EPR_HELP_LONG)
    private String serviceRef;

    /**
     * @See SOAPConstants.INPUT_HELP_LONG
     */
    @Property(type = PropertyType.MULTILINE_TEXT, displayName = SOAPConstants.INPUT_LABEL, required = true)

    @Help(displayHelpShort = SOAPConstants.INPUT_HELP, displayHelpLong = SOAPConstants.INPUT_HELP_LONG)
    private String payload;

    /**
     * @See SOAPConstants.HEADER_BLOCK_HELP_LONG
     */
    @Property(type = PropertyType.MULTILINE_TEXT, displayName = SOAPConstants.HEADER_BLOCK_LABEL, required = false)
    @Help(displayHelpShort = SOAPConstants.HEADER_BLOCK_HELP, displayHelpLong = SOAPConstants.HEADER_BLOCK_HELP_LONG)
    private String headers;

    /**
     * @See SOAPConstants.SOAP_VERSION_HELP_LONG
     */
    @Property(type = PropertyType.COMBOBOX_CHOICE, displayName = SOAPConstants.SOAP_VERSION_LABEL, required = false)
    @PropertyItems({SOAPConstants.SOAP11_LABEL, SOAPConstants.SOAP11_VALUE, SOAPConstants.SOAP12_LABEL, SOAPConstants
            .SOAP12_VALUE})
    @Help(displayHelpShort = SOAPConstants.SOAP_VERSION_HELP, displayHelpLong = SOAPConstants.SOAP_VERSION_HELP_LONG)
    private String soapVersion;

    /**
     * @See SOAPConstants.HTTP_CONNECTION_HELP_LONG
     */
    @Property(type = PropertyType.TEXT, displayName = SOAPConstants.HTTP_CONNECTION_LABEL, required = false)
    @Help(displayHelpShort = SOAPConstants.HTTP_CONNECTION_HELP, displayHelpLong = SOAPConstants
            .HTTP_CONNECTION_HELP_LONG)
    private String httpConnection;


    /**
     * @See SOAPConstants.HTTP_TRANSFER_ENCODING_HELP_LONG
     */
    @Property(type = PropertyType.TEXT, displayName = SOAPConstants.HTTP_TRANSFER_ENCODING_LABEL, required = false)
    @Help(displayHelpShort = SOAPConstants.HTTP_TRANSFER_ENCODING_HELP, displayHelpLong = SOAPConstants
            .HTTP_TRANSFER_ENCODING_HELP_LONG)
    private String httpTransferEncoding;

    /**
     * @See SOAPConstants.OUTPUT_VARIABLE_HELP_LONG
     */
    @Property(type = PropertyType.TEXT, displayName = SOAPConstants.OUTPUT_VARIABLE_LABEL, required = false)
    @Help(displayHelpShort = SOAPConstants.OUTPUT_VARIABLE_HELP, displayHelpLong = SOAPConstants
            .OUTPUT_VARIABLE_HELP_LONG)
    private String outputVariable;

    /**
     * @See SOAPConstants.SOAP_ACTION_HELP_LONG
     */
    @Property(type = PropertyType.TEXT, displayName = SOAPConstants.SOAP_ACTION_LABEL, required = false)
    @Help(displayHelpShort = SOAPConstants.SOAP_ACTION_HELP, displayHelpLong = SOAPConstants.SOAP_ACTION_HELP_LONG)
    private String soapAction;

    /**
     * @See SOAPConstants.TRANSPORT_HEADERS_HELP_LONG
     */
    @Property(type = PropertyType.MULTILINE_TEXT, displayName = SOAPConstants.TRANSPORT_HEADERS_LABEL, required = false)
    @Help(displayHelpShort = SOAPConstants.TRANSPORT_HEADERS_HELP, displayHelpLong = SOAPConstants
            .TRANSPORT_HEADERS_HELP_LONG)
    private String transportHeaders;


}

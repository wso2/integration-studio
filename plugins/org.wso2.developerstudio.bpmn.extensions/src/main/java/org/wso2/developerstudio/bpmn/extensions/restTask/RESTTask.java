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

import org.activiti.designer.integration.annotation.Help;
import org.activiti.designer.integration.annotation.Property;
import org.activiti.designer.integration.annotation.PropertyItems;
import org.activiti.designer.integration.annotation.Runtime;
import org.activiti.designer.integration.servicetask.AbstractCustomServiceTask;
import org.activiti.designer.integration.servicetask.PropertyType;

/**
 * REST Task Activity Designer implementation.
 *
 * @See org.wso2.carbon.bpmn.extensions.rest.RESTTask
 */
@Runtime(javaDelegateClass = RESTConstants.REST_TASK_CLASS)
@Help(displayHelpShort = RESTConstants.REST_TASK_HELP, displayHelpLong = RESTConstants.REST_TASK_HELP_LONG)
public class RESTTask extends AbstractCustomServiceTask {

    @Override
    public String getName() {
        return RESTConstants.REST_TASK_NAME;
    }

    @Override
    public String contributeToPaletteDrawer() {
        return RESTConstants.PALETTE_WSO2;
    }

    @Override
    public String getSmallIconPath() {
        return RESTConstants.ICONS_REST_TASK;
    }

    /**
     * @See RESTConstants.SERVICE_URL_HELP_LONG
     */
    @Property(type = PropertyType.TEXT, displayName = RESTConstants.SERVICE_URL_LABEL, required = false)
    @Help(displayHelpShort = RESTConstants.SERVICE_URL_HELP, displayHelpLong = RESTConstants.SERVICE_URL_HELP_LONG)
    private String serviceURL;

    /**
     * @See RESTConstants.BASIC_AUTH_USER_HELP_LONG
     */
    @Property(type = PropertyType.TEXT, displayName = RESTConstants.BASIC_AUTH_USER_LABEL, required = false)
    @Help(displayHelpShort = RESTConstants.BASIC_AUTH_USER_HELP, displayHelpLong = RESTConstants
            .BASIC_AUTH_USER_HELP_LONG)
    private String basicAuthUsername;

    /**
     * @See RESTConstants.BASIC_AUTH_PASSWORD_HELP_LONG
     */
    @Property(type = PropertyType.TEXT, displayName = RESTConstants.BASIC_AUTH_PASSWORD_LABEL, required = false)
    @Help(displayHelpShort = RESTConstants.BASIC_AUTH_PASSWORD_HELP,
            displayHelpLong = RESTConstants.BASIC_AUTH_PASSWORD_HELP_LONG)
    private String basicAuthPassword;

    /**
     * @See RESTConstants.EPR_HELP_LONG
     */
    @Property(type = PropertyType.TEXT, displayName = RESTConstants.EPR_LABEL, required = false)
    @Help(displayHelpShort = RESTConstants.EPR_HELP, displayHelpLong = RESTConstants.EPR_HELP_LONG)
    private String serviceRef;

    /**
     * @See RESTConstants.METHOD_HELP_LONG
     */
    @Property(type = PropertyType.COMBOBOX_CHOICE, displayName = RESTConstants.METHOD_LABEL, required = true)
    @Help(displayHelpShort = RESTConstants.METHOD_HELP, displayHelpLong = RESTConstants.METHOD_HELP_LONG)
    @PropertyItems(
            {RESTConstants.METHOD_GET_LABEL, RESTConstants.METHOD_GET_VALUE, RESTConstants.METHOD_POST_LABEL,
                    RESTConstants.METHOD_POST_VALUE, RESTConstants.METHOD_PUT_LABEL, RESTConstants.METHOD_PUT_VALUE,
                    RESTConstants.METHOD_DELETE_LABEL, RESTConstants.METHOD_DELETE_VALUE})
    private String method;

    /**
     * @See RESTConstants.INPUT_HELP_LONG
     */
    @Property(type = PropertyType.MULTILINE_TEXT, displayName = RESTConstants.INPUT_LABEL, required = false)
    @Help(displayHelpShort = RESTConstants.INPUT_HELP, displayHelpLong = RESTConstants.INPUT_HELP_LONG)
    private String input;

    /**
     * @See RESTConstants.OUTPUT_VARIABLE_HELP_LONG
     */
    @Property(type = PropertyType.TEXT, displayName = RESTConstants.OUTPUT_VARIABLE_LABEL, required = false)
    @Help(displayHelpShort = RESTConstants.OUTPUT_VARIABLE_HELP, displayHelpLong = RESTConstants
            .OUTPUT_VARIABLE_HELP_LONG)
    private String outputVariable;

    /**
     * @See RESTConstants.OUTPUT_VARIABLE_MAPPING_HELP_LONG
     */
    @Property(type = PropertyType.TEXT, displayName = RESTConstants.OUTPUT_VARIABLE_MAPPING_LABEL, required = false)
    @Help(displayHelpShort = RESTConstants.OUTPUT_VARIABLE_MAPPING_HELP,
            displayHelpLong = RESTConstants.OUTPUT_VARIABLE_MAPPING_HELP_LONG)
    private String outputMappings;

    /**
     * @See RESTConstants.TRANSPORT_HEADERS_HELP_LONG
     */
    @Property(type = PropertyType.MULTILINE_TEXT, displayName = RESTConstants.HEADERS_LABEL, required = false)
    @Help(displayHelpShort = RESTConstants.HEADERS_HELP, displayHelpLong = RESTConstants.HEADERS_HELP_LONG)
    private String headers;

}

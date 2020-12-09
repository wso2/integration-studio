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
package org.wso2.developerstudio.bpmn.extensions.readTask;

import org.activiti.designer.integration.annotation.Help;
import org.activiti.designer.integration.annotation.Property;
import org.activiti.designer.integration.annotation.PropertyItems;
import org.activiti.designer.integration.annotation.Runtime;
import org.activiti.designer.integration.servicetask.AbstractCustomServiceTask;
import org.activiti.designer.integration.servicetask.PropertyType;

/**
 * Read Task Activity Designer implementation.
 *
 * @See org.wso2.carbon.bpmn.extensions.tasks.ReadTask
 */
@Runtime(javaDelegateClass = ReadTaskConstants.READ_TASK_CLASS)
@Help(displayHelpShort = ReadTaskConstants.READ_TASK_HELP, displayHelpLong = ReadTaskConstants.READ_TASK_HELP_LONG)
public class ReadTask extends AbstractCustomServiceTask {

    @Override
    public String getName() {
        return ReadTaskConstants.READ_TASK_NAME;
    }

    @Override
    public String contributeToPaletteDrawer() {
        return ReadTaskConstants.PALETTE_WSO2;
    }

    @Override
    public String getSmallIconPath() {
        return ReadTaskConstants.ICONS_READ_TASK;
    }

    /**
     * @See ReadTaskConstants.RESOURCE_HELP_LONG
     */
    @Property(type = PropertyType.TEXT, displayName = ReadTaskConstants.RESOURCE_LABEL, required = true)
    @Help(displayHelpShort = ReadTaskConstants.RESOURCE_HELP, displayHelpLong = ReadTaskConstants.RESOURCE_HELP_LONG)
    private String resource;

    /**
     * @See ReadTaskConstants.ORIGIN_HELP_LONG
     */
    @Property(type = PropertyType.COMBOBOX_CHOICE, displayName = ReadTaskConstants.ORIGIN_LABEL, required = true)
    @Help(displayHelpShort = ReadTaskConstants.ORIGIN_HELP, displayHelpLong = ReadTaskConstants.ORIGIN_HELP_LONG)
    @PropertyItems(
            {ReadTaskConstants.ORIGIN_REGISTRY_LABEL, ReadTaskConstants.ORIGIN_REGISTRY_VALUE,
                ReadTaskConstants.ORIGIN_ENVIRONMENT_LABEL, ReadTaskConstants.ORIGIN_ENVIRONMENT_VALUE,
                ReadTaskConstants.ORIGIN_SYSTEM_LABEL, ReadTaskConstants.ORIGIN_SYSTEM_VALUE})
    private String origin;

    /**
     * @See ReadTaskConstants.TARGET_HELP_LONG
     */
    @Property(type = PropertyType.TEXT, displayName = ReadTaskConstants.TARGET_LABEL, required = true)
    @Help(displayHelpShort = ReadTaskConstants.TARGET_HELP, displayHelpLong = ReadTaskConstants.TARGET_HELP_LONG)
    private String target;

    /**
     * @See ReadTaskConstants.TYPE_HELP_LONG
     */
    @Property(type = PropertyType.COMBOBOX_CHOICE, displayName = ReadTaskConstants.TYPE_LABEL, required = false)
    @Help(displayHelpShort = ReadTaskConstants.TYPE_HELP, displayHelpLong = ReadTaskConstants.TYPE_HELP_LONG)
    @PropertyItems(
            {ReadTaskConstants.TYPE_STRING_LABEL, ReadTaskConstants.TYPE_STRING_VALUE,
                ReadTaskConstants.TYPE_INTEGER_LABEL, ReadTaskConstants.TYPE_INTEGER_VALUE,
                ReadTaskConstants.TYPE_BOOLEAN_LABEL, ReadTaskConstants.TYPE_BOOLEAN_VALUE,
                ReadTaskConstants.TYPE_JSON_LABEL, ReadTaskConstants.TYPE_JSON_VALUE,
                ReadTaskConstants.TYPE_XML_LABEL, ReadTaskConstants.TYPE_XML_VALUE})
    private String type;

}

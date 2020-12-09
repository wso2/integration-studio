/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * 
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.presentation.desc.parser;

public class DescriptorConstants {
    // Root key elements of descriptors
    public static final String CONNECTOR_NAME = "connectorName";
    public static final String CONNECTION_NAME = "connectionName";
    public static final String OPERATION_NAME = "operationName";
    public static final String TITLE = "title";
    public static final String HELP = "help";
    public static final String ELEMENTS = "elements";

    // Keys for objects under elements
    public static final String TYPE = "type";
    public static final String VALUE = "value";

    // Values for objects under elements
    public static final String ATTRIBUTE = "attribute";
    public static final String ATTRIBUTE_GROUP = "attributeGroup";

    // Keys related groups
    public static final String GROUP_NAME = "groupName";

    // Keys related to Attribute
    public static final String NAME = "name";
    public static final String DISPLAY_NAME = "displayName";
    public static final String INPUT_TYPE = "inputType";
    public static final String DEFAULT_VALUE = "defaultValue";
    public static final String REQUIRED = "required";
    public static final String HELP_TIP = "helpTip";
    public static final String ALLOWED_CONNECTION_TYPES = "allowedConnectionTypes";
    public static final String VALIDATION = "attributeGroup";
    public static final String ENABLE_CONDITION = "enableCondition";
    public static final String COMBO_VALUES = "comboValues";
    public static final String COMBO_STRING = "combo";
    public static final String TEXT_STRING = "text";
    public static final String COLUMNS = "columns";
    public static final String ALLOWED_VALUES = "allowedValues";

    // Supported Input Types
    public static final String STRING = "string";
    public static final String STRING_OR_EXPRESSION = "stringOrExpression";
    public static final String TEXTAREA_OR_EXPRESSION = "textAreaOrExpression";
    public static final String BOOLEAN_OR_EXPRESSION = "booleanOrExpression";
    public static final String CONNECTION = "connection";
    public static final String COMBO_OR_EXPRESSION = "comboOrExpression";
    public static final String PASSWORD_TEXT_OR_EXPRESSION = "passwordTextOrExpression";
    public static final String SEARCH_BOX = "searchBox";
    public static final String KEY_VALUE_TABLE = "keyValueTable";

    //Key related to the Connection attribute
    public static final String CONFIG_REF = "configRef";

}

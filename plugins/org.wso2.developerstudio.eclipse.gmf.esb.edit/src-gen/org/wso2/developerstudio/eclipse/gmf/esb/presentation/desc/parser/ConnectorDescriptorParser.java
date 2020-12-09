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
package org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.condition.manager.AndConditionOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.condition.manager.ConditionArgument;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.condition.manager.ConditionOperatorType;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.condition.manager.EnableCondition;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.condition.manager.NotConditionOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.condition.manager.OrConditionOperation;

import java.util.ArrayList;
import java.util.List;

public class ConnectorDescriptorParser {

    public static ConnectorConnectionRoot parseConnectionRoot(String jsonString) throws JSONException {

        ConnectorConnectionRoot root = new ConnectorConnectionRoot();
        JSONObject rootObject = new JSONObject(jsonString);
        String connectionName = rootObject.getString(DescriptorConstants.CONNECTION_NAME);
        root.setConnectionName(connectionName);
        createConnectorRoot(root, jsonString);
        return root;
    }

    public static ConnectorOperationRoot parseOperationRoot(String jsonString) throws JSONException {

        ConnectorOperationRoot root = new ConnectorOperationRoot();
        JSONObject rootObject = new JSONObject(jsonString);
        String connectionName = rootObject.getString(DescriptorConstants.OPERATION_NAME);
        root.setOperationName(connectionName);
        createConnectorRoot(root, jsonString);
        return root;
    }

    public static void createConnectorRoot(ConnectorRoot root, String jsonString) throws JSONException {

        JSONObject rootObject = new JSONObject(jsonString);
        root.setConnectorName(rootObject.getString(DescriptorConstants.CONNECTOR_NAME));
        root.setTitle(rootObject.getString(DescriptorConstants.TITLE));
        root.setHelp(rootObject.getString(DescriptorConstants.HELP));
        JSONArray elementsArray = rootObject.getJSONArray(DescriptorConstants.ELEMENTS);
        for (int i = 0; i < elementsArray.length(); i++) {
            Element element = new Element();
            JSONObject obj = elementsArray.getJSONObject(i);
            element.setType(obj.getString(DescriptorConstants.TYPE));
            if (element.getType().equalsIgnoreCase(DescriptorConstants.ATTRIBUTE)) {
                AttributeValue value = new AttributeValue();
                JSONObject attrObj = obj.getJSONObject(DescriptorConstants.VALUE);
                value.setName(attrObj.getString(DescriptorConstants.NAME));
                if (attrObj.has(DescriptorConstants.DEFAULT_VALUE)) {
                    value.setDefaultValue(attrObj.getString(DescriptorConstants.DEFAULT_VALUE));
                }
                value.setRequired(Boolean.parseBoolean(attrObj.getString(DescriptorConstants.REQUIRED)));
                value.setHelpTip(attrObj.getString(DescriptorConstants.HELP_TIP));
                value.setDisplayName(attrObj.getString(DescriptorConstants.DISPLAY_NAME));
                if (attrObj.has(DescriptorConstants.ENABLE_CONDITION)) {
                    parseEnableCondition(value, attrObj);
                }
                String inputType = attrObj.getString(DescriptorConstants.INPUT_TYPE);

                switch (inputType) {
                    case DescriptorConstants.STRING_OR_EXPRESSION:
                        value.setType(AttributeValueType.STRING);
                        break;
                    case DescriptorConstants.COMBO_OR_EXPRESSION:
                        value.setType(AttributeValueType.COMBO);
                        JSONArray comboArray = attrObj.getJSONArray(DescriptorConstants.COMBO_VALUES);
                        for (int j = 0; j < comboArray.length(); j++) {
                            value.addComboValue(comboArray.getString(j));
                        }
                        break;
                    case DescriptorConstants.BOOLEAN_OR_EXPRESSION:
                        value.setType(AttributeValueType.BOOLEANOREXPRESSION);
                        break;
                    case DescriptorConstants.TEXTAREA_OR_EXPRESSION:
                        value.setType(AttributeValueType.TEXTAREAOREXPRESSION);
                        break;
                    case DescriptorConstants.CONNECTION:

                        value.setType(AttributeValueType.CONNECTION);
                        JSONArray allowedConnectionType = attrObj
                                .getJSONArray(DescriptorConstants.ALLOWED_CONNECTION_TYPES);
                        for (int k = 0; k < allowedConnectionType.length(); k++) {
                            value.addAllowedConnectionType(allowedConnectionType.getString(k));
                        }
                        break;
                    case DescriptorConstants.PASSWORD_TEXT_OR_EXPRESSION:
                        value.setType(AttributeValueType.PASSWORDTEXTOREXPRESSION);
                        break;
                    case DescriptorConstants.SEARCH_BOX:
                        value.setType(AttributeValueType.SEARCHBOX);
                        break;
                    case DescriptorConstants.KEY_VALUE_TABLE:
                        value.setType(AttributeValueType.KEYVALUETABLE);
                        JSONArray columns = attrObj
                                .getJSONArray(DescriptorConstants.COLUMNS);
                        for (int k = 0; k < columns.length(); k++) {
                            KeyValueTableColumn kvtc = new KeyValueTableColumn();
                            JSONObject column = columns.getJSONObject(k);
                            kvtc.setName(column.getString(DescriptorConstants.NAME));
                            kvtc.setType(column.getString(DescriptorConstants.TYPE));
                            if(kvtc.getType().equals(DescriptorConstants.COMBO_STRING)) {
                                JSONArray allowedValues = attrObj
                                        .getJSONArray(DescriptorConstants.ALLOWED_VALUES);
                                for (int l = 0; l < allowedValues.length(); l++) {
                                    kvtc.addAllowedValues(allowedValues.getString(l));
                                }
                            }
                            value.addColumn(kvtc);
                        }
                        break;
                    default:
                        value.setType(AttributeValueType.STRING);
                        break;
                }
                element.setValue(value);
            } else {
                AttributeGroupValue groupValue = new AttributeGroupValue();
                JSONObject attrGroupObj = obj.getJSONObject(DescriptorConstants.VALUE);
                groupValue.setGroupName(attrGroupObj.getString(DescriptorConstants.GROUP_NAME));
                getGroupValuesRecursively(attrGroupObj.getJSONArray(DescriptorConstants.ELEMENTS), groupValue);
                element.setValue(groupValue);
            }
            root.addElement(element);
        }
    }

    public static void getGroupValuesRecursively(JSONArray elementsArray, Value rootValue) throws JSONException {

        for (int i = 0; i < elementsArray.length(); i++) {
            Element element = new Element();
            JSONObject obj = elementsArray.getJSONObject(i);
            element.setType(obj.getString(DescriptorConstants.TYPE));
            if (element.getType().equalsIgnoreCase(DescriptorConstants.ATTRIBUTE)) {
                AttributeValue value = new AttributeValue();
                JSONObject attrObj = obj.getJSONObject(DescriptorConstants.VALUE);
                value.setName(attrObj.getString(DescriptorConstants.NAME));
                if (attrObj.has(DescriptorConstants.DEFAULT_VALUE)) {
                    value.setDefaultValue(attrObj.getString(DescriptorConstants.DEFAULT_VALUE));
                }
                value.setRequired(Boolean.parseBoolean(attrObj.getString(DescriptorConstants.REQUIRED)));
                value.setHelpTip(attrObj.getString(DescriptorConstants.HELP_TIP));
                value.setDisplayName(attrObj.getString(DescriptorConstants.DISPLAY_NAME));
                if (attrObj.has(DescriptorConstants.ENABLE_CONDITION)) {
                    parseEnableCondition(value, attrObj);
                }
                String inputType = attrObj.getString(DescriptorConstants.INPUT_TYPE);
                switch (inputType) {
                    case DescriptorConstants.STRING_OR_EXPRESSION:
                        value.setType(AttributeValueType.STRING);
                        break;
                    case DescriptorConstants.TEXTAREA_OR_EXPRESSION:
                        value.setType(AttributeValueType.TEXTAREAOREXPRESSION);
                        break;
                    case DescriptorConstants.COMBO_OR_EXPRESSION:
                        value.setType(AttributeValueType.COMBO);
                        JSONArray comboArray = attrObj.getJSONArray(DescriptorConstants.COMBO_VALUES);
                        for (int j = 0; j < comboArray.length(); j++) {
                            value.addComboValue(comboArray.getString(j));
                        }
                        break;
                    case DescriptorConstants.BOOLEAN_OR_EXPRESSION:
                        value.setType(AttributeValueType.BOOLEANOREXPRESSION);
                        break;
                    case DescriptorConstants.CONNECTION:

                        value.setType(AttributeValueType.CONNECTION);
                        JSONArray allowedConnectionType = attrObj
                                .getJSONArray(DescriptorConstants.ALLOWED_CONNECTION_TYPES);
                        for (int k = 0; k < allowedConnectionType.length(); k++) {
                            value.addAllowedConnectionType(allowedConnectionType.getString(k));
                        }
                        break;
                    case DescriptorConstants.PASSWORD_TEXT_OR_EXPRESSION:
                        value.setType(AttributeValueType.PASSWORDTEXTOREXPRESSION);
                        break;
                    case DescriptorConstants.SEARCH_BOX:
                        value.setType(AttributeValueType.SEARCHBOX);
                        break;
                    case DescriptorConstants.KEY_VALUE_TABLE:
                        value.setType(AttributeValueType.KEYVALUETABLE);
                        JSONArray columns = attrObj
                                .getJSONArray(DescriptorConstants.COLUMNS);
                        for (int k = 0; k < columns.length(); k++) {
                            KeyValueTableColumn kvtc = new KeyValueTableColumn();
                            JSONObject column = columns.getJSONObject(k);
                            kvtc.setName(column.getString(DescriptorConstants.NAME));
                            kvtc.setType(column.getString(DescriptorConstants.TYPE));
                            if(kvtc.getType().equals(DescriptorConstants.COMBO_STRING) &&
                                    column.has(DescriptorConstants.ALLOWED_VALUES)) {
                                JSONArray allowedValues = column
                                        .getJSONArray(DescriptorConstants.ALLOWED_VALUES);
                                for (int l = 0; l < allowedValues.length(); l++) {
                                    kvtc.addAllowedValues(allowedValues.getString(l));
                                }
                            }
                            value.addColumn(kvtc);
                        }
                        break;
                    default:
                        value.setType(AttributeValueType.STRING);
                        break;
                }

                element.setValue(value);
            } else {
                AttributeGroupValue groupValue = new AttributeGroupValue();
                JSONObject attrGroupObj = obj.getJSONObject(DescriptorConstants.VALUE);
                groupValue.setGroupName(attrGroupObj.getString(DescriptorConstants.GROUP_NAME));
                getGroupValuesRecursively(attrGroupObj.getJSONArray(DescriptorConstants.ELEMENTS), groupValue);
                element.setValue(groupValue);

            }
            if (rootValue instanceof AttributeGroupValue) {
                ((AttributeGroupValue) rootValue).addElement(element);
            }
        }
    }

    private static void parseEnableCondition(AttributeValue value, JSONObject attrObj) throws JSONException {

        JSONArray jsonArray = attrObj.getJSONArray(DescriptorConstants.ENABLE_CONDITION);
        EnableCondition enableCondition;
        Object firstObject = jsonArray.get(0);
        if (firstObject instanceof String) {
            String operationName = (String) firstObject;
            try {
                ConditionOperatorType operatorType = ConditionOperatorType.valueOf(operationName.toUpperCase());
                List<EnableCondition> arguments = new ArrayList<>();
                for (int i = 1; i < jsonArray.length(); i++) {
                    arguments.add(parseConditionArgument(jsonArray.getJSONObject(i)));
                }

                switch (operatorType) {
                    case AND:
                        enableCondition = new AndConditionOperation(arguments);
                        break;
                    case NOT:
                        enableCondition = new NotConditionOperation(arguments);
                        break;
                    default:
                        enableCondition = new OrConditionOperation(arguments);
                }
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid operation type");
            }
        } else if (firstObject instanceof JSONObject) {
            JSONObject currentJsonObject = (JSONObject) firstObject;
            enableCondition = parseConditionArgument(currentJsonObject);
        } else {
            throw new RuntimeException("Invalid type");
        }
        value.setEnableCondition(enableCondition);
    }

    private static ConditionArgument parseConditionArgument(JSONObject jsonObject) throws JSONException {

        if (jsonObject.keys().hasNext()) {
            String key = jsonObject.keys().next().toString();
            String value = jsonObject.get(key).toString();
            return new ConditionArgument(key, value);
        } else {
            throw new RuntimeException("Invalid json");
        }
    }

    public static boolean isConnectorConnection(String jsonString) throws JSONException {

        return new JSONObject(jsonString).has(DescriptorConstants.CONNECTION_NAME);
    }
}

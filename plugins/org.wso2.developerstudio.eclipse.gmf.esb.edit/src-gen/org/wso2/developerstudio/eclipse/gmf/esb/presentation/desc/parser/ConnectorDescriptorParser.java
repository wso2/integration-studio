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

import org.apache.commons.lang3.EnumUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class ConnectorDescriptorParser {
    
    public static ConnectorRoot parse(String jsonString) {
        return new ConnectorRoot();
    }
    
    public static ConnectorRoot demoValue() {
        ConnectorRoot connectorRoot = new ConnectorRoot();
        connectorRoot.setConnectorName("file");
        connectorRoot.setDisplayName("File Append");
        connectorRoot.setHelp("<h1>File Append</h1>");
        Element l1element = new Element();
        l1element.setType("attributeGroup");
        AttributeGroupValue agv = new AttributeGroupValue();
        agv.setGroupName("General");
        Element l2element = new Element();
        l2element.setType("attribute");
        AttributeValue agvl2 = new AttributeValue();
        agvl2.setName("description");
        agvl2.setDefaultValue("");
        
        agv.addElement(l2element);
        l1element.setValue(agv);
        connectorRoot.addElement(l1element);
        return connectorRoot;
    }
    
    public ConnectorRoot createObject(String jsonString) throws JSONException {
        ConnectorRoot connectorRoot = new ConnectorRoot();
        JSONObject rootObject = new JSONObject(jsonString);
        Boolean isConnection = rootObject.has("connectionName");
        if(isConnection) { //Validate with a subclass of connectorRoot
            connectorRoot.setConnectorName(rootObject.getString("connectorName"));
            connectorRoot.setConnectionName(rootObject.getString("connectionName")); 
        } else {
            connectorRoot.setConnectorName(rootObject.getString("connectorName"));
            connectorRoot.setOperationName(rootObject.getString("operationName"));
        }
        connectorRoot.setDisplayName(rootObject.getString("displayName"));
        connectorRoot.setHelp(rootObject.getString("help"));
        JSONArray elementsArray = rootObject.getJSONArray("elements");
        for(int i=0;i<elementsArray.length();i++) {
            Element element = new Element();
            JSONObject obj = elementsArray.getJSONObject(i);
            element.setType(obj.getString("type"));
            if(element.getType().equalsIgnoreCase("attribute")) {
                AttributeValue value = new AttributeValue();
                JSONObject attrObj = obj.getJSONObject("value");
                value.setName(attrObj.getString("name"));
                value.setDefaultValue(attrObj.getString("defaultValue"));
                value.setRequired(Boolean.parseBoolean(attrObj.getString("required")));
                value.setHelpTip(attrObj.getString("helpTip"));
                value.setDisplayName(attrObj.getString("displayName"));
                 // HardCoded
                if(attrObj.getString("type").equalsIgnoreCase("stringOrExpression")) {
                    value.setType(AttributeValueType.STRING); 
                } else if (attrObj.getString("type").equalsIgnoreCase("textOrExpression")) {
                    value.setType(AttributeValueType.STRING); 
                } else if (attrObj.getString("type").equalsIgnoreCase("comboOrExpression")) {
                    value.setType(AttributeValueType.COMBO); 
                    JSONArray comboArray = attrObj.getJSONArray("comboValues");
                    for(int j=0;j<comboArray.length();j++) {
                        value.addComboValue(comboArray.getString(j));
                    }
                } else if (attrObj.getString("type").equalsIgnoreCase("booleanOrExpression")) {
                    value.setType(AttributeValueType.BOOLEANOREXPRESSION); 
                } else if (attrObj.getString("type").equalsIgnoreCase("connection")) {
                    value.setType(AttributeValueType.CONNECTION); 
                    JSONArray allowedConnectionType = attrObj.getJSONArray("allowedConnectionTypes");
                    for(int k = 0; k < allowedConnectionType.length(); k++) {
                        String allowedType = allowedConnectionType.getString(k).split("\\.")[1].toUpperCase();
                        if (EnumUtils.isValidEnum(Connection.class, allowedType)) {
                            value.addAllowedConnectionTypes(Connection.valueOf(allowedType));
                        }
                    }
                } else {
                    value.setType(AttributeValueType.STRING);
                }
                
                element.setValue(value);
            } else {
                AttributeGroupValue groupValue = new AttributeGroupValue();
                JSONObject attrGroupObj = obj.getJSONObject("value");
                groupValue.setGroupName(attrGroupObj.getString("groupName"));
                recursive(attrGroupObj.getJSONArray("elements"), groupValue);
                element.setValue(groupValue);
            }
            connectorRoot.addElement(element);
        }
        
        return connectorRoot;
    }
    
    public void recursive(JSONArray elementsArray, Value rootValue) throws JSONException {
        for(int i=0;i<elementsArray.length();i++) {
            Element element = new Element();
            JSONObject obj = elementsArray.getJSONObject(i);
            element.setType(obj.getString("type"));
            if(element.getType().equalsIgnoreCase("attribute")) {
                AttributeValue value = new AttributeValue();
                JSONObject attrObj = obj.getJSONObject("value");
                value.setName(attrObj.getString("name"));
                value.setDefaultValue(attrObj.getString("defaultValue"));
                value.setRequired(Boolean.parseBoolean(attrObj.getString("required")));
                value.setHelpTip(attrObj.getString("helpTip"));
                value.setDisplayName(attrObj.getString("displayName"));
                if(attrObj.getString("type").equalsIgnoreCase("stringOrExpression")) {
                    value.setType(AttributeValueType.STRING); 
                } else if (attrObj.getString("type").equalsIgnoreCase("textOrExpression")) {
                    value.setType(AttributeValueType.STRING); 
                } else if (attrObj.getString("type").equalsIgnoreCase("comboOrExpression")) {
                    value.setType(AttributeValueType.COMBO); 
                    JSONArray comboArray = attrObj.getJSONArray("comboValues");
                    for(int j=0;j<comboArray.length();j++) {
                        value.addComboValue(comboArray.getString(j));
                    }
                } else if (attrObj.getString("type").equalsIgnoreCase("booleanOrExpression")) {
                    value.setType(AttributeValueType.BOOLEANOREXPRESSION); 
                } else if (attrObj.getString("type").equalsIgnoreCase("connection")) {
                    value.setType(AttributeValueType.CONNECTION); 
                    JSONArray allowedConnectionType = attrObj.getJSONArray("allowedConnectionTypes");
                    for(int k = 0; k < allowedConnectionType.length(); k++) {
                        String allowedType = allowedConnectionType.getString(k).split("\\.")[1].toUpperCase();
                        if (EnumUtils.isValidEnum(Connection.class, allowedType)) {
                            value.addAllowedConnectionTypes(Connection.valueOf(allowedType));
                        }
                    }
                } else {
                    value.setType(AttributeValueType.STRING);
                }
                
                element.setValue(value);
            } else {
                AttributeGroupValue groupValue = new AttributeGroupValue();
                JSONObject attrGroupObj = obj.getJSONObject("value");
                groupValue.setGroupName(attrGroupObj.getString("groupName"));
                recursive(attrGroupObj.getJSONArray("elements"), groupValue);
                element.setValue(groupValue);
                
            }
            if(rootValue instanceof AttributeGroupValue) {
                ((AttributeGroupValue)rootValue).addElement(element);
            }
        }
    }

}

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

import org.wso2.developerstudio.eclipse.gmf.esb.presentation.condition.manager.EnableCondition;

import java.util.ArrayList;
import java.util.List;

public class AttributeValue extends Value {

    String name;
    String displayName;
    AttributeValueType type;
    String defaultValue;
    boolean required;
    String helpTip;
    List<String> allowedConnectionTypes;
    List<KeyValueTableColumn> columns;
    String validation;
    String defaultType; //????
    //String default; ????
    EnableCondition enableCondition;
    List<String> comboValues;

    public AttributeValue() {

        comboValues = new ArrayList<>();
        allowedConnectionTypes = new ArrayList<>();
        columns = new ArrayList<>();
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDisplayName() {

        return displayName;
    }

    public void setDisplayName(String displayName) {

        this.displayName = displayName;
    }

    public AttributeValueType getType() {

        return type;
    }

    public void setType(AttributeValueType type) {

        this.type = type;
    }

    public String getDefaultValue() {

        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {

        this.defaultValue = defaultValue;
    }

    public boolean getRequired() {

        return required;
    }

    public void setRequired(boolean required) {

        this.required = required;
    }

    public String getHelpTip() {

        return helpTip;
    }

    public void setHelpTip(String helpTip) {

        this.helpTip = helpTip;
    }

    public List<String> getAllowedConnectionTypes() {

        return allowedConnectionTypes;
    }

    public void setAllowedConnectionTypes(List<String> allowedConnectionTypes) {

        this.allowedConnectionTypes = allowedConnectionTypes;
    }

    public void addAllowedConnectionType(String allowedConnectionType) {

        this.allowedConnectionTypes.add(allowedConnectionType);
    }

    public List<String> getComboValues() {

        return comboValues;
    }

    public void addComboValue(String comboValue) {

        this.comboValues.add(comboValue);
    }

    public String getValidation() {

        return validation;
    }

    public void setValidation(String validation) {

        this.validation = validation;
    }

    public EnableCondition getEnableCondition() {

        return enableCondition;
    }

    public void setEnableCondition(EnableCondition enableCondition) {

        this.enableCondition = enableCondition;
    }

    public List<KeyValueTableColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<KeyValueTableColumn> columns) {
        this.columns = columns;
    }

    public void addColumn(KeyValueTableColumn column) {
        this.columns.add(column);
    }
}

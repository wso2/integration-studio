/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.response;

import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.IResponseMessage;

import com.google.gson.JsonElement;

/**
 * This class represents the response message from ESB Server Mediation Debugger
 * which contain message properties.
 */
public class PropertyRespondMessage implements IResponseMessage {

    private String scope;
    private JsonElement propertyValues;

    public PropertyRespondMessage(String scope, JsonElement propertyValues) {
        this.setScope(scope);
        this.setPropertyValues(propertyValues);
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public JsonElement getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(JsonElement propertyValues) {
        this.propertyValues = propertyValues;
    }

}

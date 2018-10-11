/*
 * Copyright (c) 2015-2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.views;

/**
 * This enum holds default property values loaded to ESB Debugger Envelope view property table
 *
 */
public enum DefaultPropertyValues {

    TO("To"), FROM("From"), CONTENT_LENGTH("Content-Length"), ACCEPT_ENCODING("Accept-Encoding"), CONNECTION(
            "Connection"), CONTENT_TYPE(
                    "Content-Type"), HOST("Host"), SOAP_ACTION("SOAPAction"), USER_AGENT("User-Agent");
    private String propertyName;

    DefaultPropertyValues(String name) {
        propertyName = name;
    }

    public String getPropertyName() {
        return propertyName;
    }
}

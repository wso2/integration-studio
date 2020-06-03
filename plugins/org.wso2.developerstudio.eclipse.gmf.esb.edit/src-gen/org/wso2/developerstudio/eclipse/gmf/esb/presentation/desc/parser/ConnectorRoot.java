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

import java.util.ArrayList;

public abstract class ConnectorRoot {

    private String connectorName;
    private String title;
    private String help;
    private ArrayList<Element> elements;

    public ConnectorRoot() {
        super();
        setElements(new ArrayList<Element>());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String displayName) {
        this.title = displayName;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    private void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }

    public void addElement(Element element) {
        this.elements.add(element);
    }

    public void removeElement(Element element) {
        this.elements.add(element);
    }

    public String getConnectorName() {
        return connectorName;
    }

    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }

}

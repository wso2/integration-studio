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

public class AttributeGroupValue extends Value{
    
    String groupName;
    ArrayList<Element> elements;
    
    public AttributeGroupValue() {
        super();
        setElements(new ArrayList<Element>());
    }
    
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    private void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }
    
    public void addElement(Element element) {
       getElements().add(element);
    }

    public void removeElement(Element element) {
        getElements().remove(element);
     }
}

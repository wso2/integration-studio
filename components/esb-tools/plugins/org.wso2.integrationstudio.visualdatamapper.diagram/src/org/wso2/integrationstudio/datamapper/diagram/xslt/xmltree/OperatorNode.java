/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.integrationstudio.datamapper.diagram.xslt.xmltree;

import java.util.HashMap;
import org.w3c.dom.Node;

import static org.wso2.integrationstudio.datamapper.diagram.xslt.config.XSLTGeneratorConstants.LEFT_CONTAINER;
import static org.wso2.integrationstudio.datamapper.diagram.xslt.config.XSLTGeneratorConstants.BASIC_CONTAINER;

/**
 * This class represent an operator in the datamapper
 *
 */
public class OperatorNode {

    private final HashMap<String, String> attributes;
    private LeftContainer leftContainer;

    public OperatorNode(Node node) {
        this.attributes = new HashMap<>();
        populate(node);
    }

    /**
     * This method extracts all the properties in the operator
     * 
     * @param node document node that represents the operator
     */
    private void populate(Node node) {
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node basicContainer = node.getChildNodes().item(i);
            if (basicContainer.getAttributes() != null && basicContainer.getNodeName().equals(BASIC_CONTAINER)) {
                for (int j = 0; j < basicContainer.getChildNodes().getLength(); j++) {
                    Node childNode = basicContainer.getChildNodes().item(j);
                    if (childNode.getAttributes() != null && childNode.getNodeName().equals(LEFT_CONTAINER)) {
                        this.leftContainer = new LeftContainer(childNode);
                    }
                }
            }
        }
        for (int i = 0; i < node.getAttributes().getLength(); i++) {
            Node childNode = node.getAttributes().item(i);
            this.attributes.put(childNode.getNodeName(), childNode.getTextContent());
        }
    }

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public LeftContainer getLeftContainer() {
        return leftContainer;
    }

    public String getProperty(String property) {
        return this.attributes.get(property);
    }

}
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

import java.util.ArrayList;
import java.util.HashMap;
import org.w3c.dom.Node;

import static org.wso2.integrationstudio.datamapper.diagram.xslt.config.XSLTGeneratorConstants.KEY;
import static org.wso2.integrationstudio.datamapper.diagram.xslt.config.XSLTGeneratorConstants.NAME;
import static org.wso2.integrationstudio.datamapper.diagram.xslt.config.XSLTGeneratorConstants.LEVEL;
import static org.wso2.integrationstudio.datamapper.diagram.xslt.config.XSLTGeneratorConstants.PROPERTIES;
import static org.wso2.integrationstudio.datamapper.diagram.xslt.config.XSLTGeneratorConstants.VALUE;
import static org.wso2.integrationstudio.datamapper.diagram.xslt.config.XSLTGeneratorConstants.NODE;

/**
 * This class represent a node in the input tree
 *
 */
public class InPutNode extends XMLNode {

    private final String level;
    private final ArrayList<InPutNode> childNodes;
    private final HashMap<String, String> properties;
    private final InPutNode parentNode;
    private final String xPath;

    public String getXPath() {
        return xPath;
    }

    public InPutNode(Node node, InPutNode parentNode, String xPath) {
        this.name = getAttribute(node, NAME);
        this.level = getAttribute(node, LEVEL);
        this.properties = new HashMap<>();
        this.childNodes = new ArrayList<>();
        this.parentNode = parentNode;
        if (xPath.equals("")) {
            this.xPath = xPath + this.name;
        } else {
            this.xPath = xPath + "/" + this.name;
        }
        populate(node);
    }

    public InPutNode getParentNode() {
        return parentNode;
    }

    /**
     * This method extracts all the properties and build child nodes
     * 
     * @param node document node that represents the input node
     */
    private void populate(Node node) {
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node childNode = node.getChildNodes().item(i);
            if (childNode.getAttributes() != null) {
                if (childNode.getNodeName().equals(PROPERTIES)) {
                    this.properties.put(childNode.getAttributes().getNamedItem(KEY).getTextContent(),
                            childNode.getAttributes().getNamedItem(VALUE).getTextContent());
                } else if (childNode.getNodeName().equals(NODE)) {
                    this.childNodes.add(new InPutNode(childNode, this, this.xPath));
                }
            }
        }
    }

    public String getProperty(String property) {
        if (this.properties.containsKey(property)) {
            return this.properties.get(property);
        }
        return null;
    }

    public int getLevel() {
        return Integer.parseInt(level);
    }

    public String getName() {
        return name;
    }

    public ArrayList<InPutNode> getChildNodes() {
        return this.childNodes;
    }

}
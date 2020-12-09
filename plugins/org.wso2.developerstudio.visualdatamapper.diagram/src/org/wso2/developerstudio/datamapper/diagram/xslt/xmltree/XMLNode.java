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
package org.wso2.developerstudio.datamapper.diagram.xslt.xmltree;

import org.w3c.dom.Node;

import static org.wso2.developerstudio.datamapper.diagram.xslt.config.XSLTGeneratorConstants.NODE;
import static org.wso2.developerstudio.datamapper.diagram.xslt.config.XSLTGeneratorConstants.TREE_NODE;

/**
 * This class represent a node in input/output tree
 * 
 */
abstract class XMLNode {
    String name;

    String getAttribute(Node node, String property) {
        if (node.getAttributes() != null && (node.getNodeName().equals(NODE) || node.getNodeName().equals(TREE_NODE))) {

            Node tempProperty = node.getAttributes().getNamedItem(property);
            if (tempProperty != null) {
                return tempProperty.getTextContent();
            }
        }
        return null;
    }

}
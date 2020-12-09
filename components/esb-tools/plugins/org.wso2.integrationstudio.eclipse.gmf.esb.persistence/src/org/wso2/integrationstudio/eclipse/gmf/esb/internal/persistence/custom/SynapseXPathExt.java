/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence.custom;

import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.jaxen.JaxenException;

/**
 * This class is use to create a SynapsePath by skipping the synapse validations.
 * This is useful when building the synapse model from the source to the diagram. 
 * (by skipping the exceptions if certain properties are empty by default)
 *  
 */
public class SynapseXPathExt {

    public static SynapsePath createSynapsePath(String xpathExpr) {
        SynapsePath synPath = null;
        try {
            synPath = new SynapseXPath(xpathExpr);
        } catch (JaxenException e) {
            String defaultString = "/DEFAULT/XPATH";
            try {
                synPath = new SynapseXPath(defaultString);
                synPath.setExpression(xpathExpr);
            } catch (JaxenException e1) {
                // ignore
            }
        }
        return synPath;
    }

    public static SynapseXPath createSynapseXPath(String xpathExpr) {
        SynapseXPath synXPath = null;
        try {
            synXPath = new SynapseXPath(xpathExpr);
        } catch (JaxenException e) {
            String defaultString = "/DEFAULT/XPATH";
            try {
                synXPath = new SynapseXPath(defaultString);
                synXPath.setExpression(xpathExpr);
            } catch (JaxenException e1) {
                // ignore
            }
        }
        return synXPath;
    }
}
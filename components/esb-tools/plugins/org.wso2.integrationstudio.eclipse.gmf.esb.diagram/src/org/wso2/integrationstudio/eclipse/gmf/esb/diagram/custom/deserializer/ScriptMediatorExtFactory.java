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

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.ValueFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.bsf.ScriptMediator;
import org.apache.synapse.mediators.bsf.ScriptMediatorFactory;

public class ScriptMediatorExtFactory extends ScriptMediatorFactory {

    private static final QName INCLUDE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "include");
    
    private static ScriptMediatorExtFactory instance;
    
    private ScriptMediatorExtFactory() {
    }
    
    public static synchronized ScriptMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new ScriptMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator;

        OMAttribute keyAtt = omElement.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "key"));
        OMAttribute langAtt = omElement.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "language"));
        OMAttribute functionAtt = omElement.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "function"));

        Map<Value, Object> includeKeysMap = getIncludeKeysMap(omElement);

        if (keyAtt != null && langAtt != null) {

            ValueFactoryExtended keyFac = new ValueFactoryExtended();
            Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, omElement);

            String functionName = (functionAtt == null ? null : functionAtt.getAttributeValue());
            mediator = new ScriptMediator(langAtt.getAttributeValue(), includeKeysMap, generatedKey, functionName,
                    null);
        } else if (langAtt != null) {
            mediator = new ScriptMediator(langAtt.getAttributeValue(), omElement.getText(), null);
        } else {
            mediator = new ScriptMediator("javascript", omElement.getText(), null);
        }

        processAuditStatus(mediator, omElement);
        addAllCommentChildrenToList(omElement, ((ScriptMediator) mediator).getCommentsList());

        return mediator;
    }

    private Map<Value, Object> getIncludeKeysMap(OMElement elem) {

        Map<Value, Object> includeKeysMap = new LinkedHashMap<Value, Object>();

        Iterator itr = elem.getChildrenWithName(INCLUDE_Q);

        while (itr.hasNext()) {
            OMElement includeElem = (OMElement) itr.next();
            OMAttribute key = includeElem.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "key"));

            ValueFactory keyFac = new ValueFactory();

            Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, includeElem);

            if (key != null) {
                includeKeysMap.put(generatedKey, null);
            }

        }

        return includeKeysMap;
    }

}

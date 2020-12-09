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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.message.processor.MessageProcessor;
import org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence.custom.DummyMessageProcessor;

public class MessageProcessorExtFactory {

    private static final QName CLASS_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "class");
    private static final QName NAME_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "name");
    private static final QName PARAMETER_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "parameter");
    private static final QName MESSAGE_STORE_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "messageStore");
    private static final QName DESCRIPTION_Q = new QName(SynapseConstants.SYNAPSE_NAMESPACE, "description");
    private static final QName TARGET_ENDPOINT_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "targetEndpoint");

    private static final String FORWARDING_PROCESSOR = "org.apache.synapse.message.processor.impl.forwarder.ScheduledMessageForwardingProcessor";

    public static MessageProcessor createMessageProcessor(OMElement elem, Properties properties) {

        MessageProcessor messageProcessor = new DummyMessageProcessor();

        OMAttribute clssAtt = elem.getAttribute(CLASS_Q);
        if (clssAtt != null) {
            ((DummyMessageProcessor) messageProcessor).setClassName(clssAtt.getAttributeValue());
        } else {
            ((DummyMessageProcessor) messageProcessor).setClassName(FORWARDING_PROCESSOR);
        }

        OMAttribute nameAtt = elem.getAttribute(NAME_Q);

        if (nameAtt != null) {
            messageProcessor.setName(nameAtt.getAttributeValue());
        } else {
            messageProcessor.setName("");
        }

        OMAttribute targetSequenceAtt = elem.getAttribute(TARGET_ENDPOINT_Q);

        if (targetSequenceAtt != null) {
            messageProcessor.setTargetEndpoint(targetSequenceAtt.getAttributeValue());
        } else {
            messageProcessor.setTargetEndpoint("");
        }

        OMAttribute storeAtt = elem.getAttribute(MESSAGE_STORE_Q);

        if (storeAtt != null) {
            messageProcessor.setMessageStoreName(storeAtt.getAttributeValue());
        } else {
            messageProcessor.setMessageStoreName("MESSAGE_STORE");
        }

        OMElement descriptionElem = elem.getFirstChildWithName(DESCRIPTION_Q);
        if (descriptionElem != null) {
            messageProcessor.setDescription(descriptionElem.getText());
        }

        messageProcessor.setParameters(getParameters(elem));

        return messageProcessor;
    }

    private static Map<String, Object> getParameters(OMElement elem) {
        Iterator<?> params = elem.getChildrenWithName(PARAMETER_Q);
        Map<String, Object> parameters = new HashMap<String, Object>();

        while (params.hasNext()) {
            Object o = params.next();
            if (o instanceof OMElement) {
                OMElement prop = (OMElement) o;
                OMAttribute paramName = prop.getAttribute(NAME_Q);
                String paramValue = prop.getText();
                if (paramName != null) {
                    parameters.put(paramName.getAttributeValue(), paramValue);
                } else {
                    parameters.put("PARAMETER_NAME", paramValue);
                }
            }
        }
        return parameters;
    }

}

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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.MessageStoreMediatorFactory;
import org.apache.synapse.config.xml.SynapsePathFactory;
import org.apache.synapse.mediators.store.MessageStoreMediator;
import org.jaxen.JaxenException;

public class StoreMediatorExtFactory extends MessageStoreMediatorFactory {
    
    private static StoreMediatorExtFactory instance;
    
    private StoreMediatorExtFactory() {
    }
    
    public static synchronized StoreMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new StoreMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new MessageStoreMediator();

        QName ATT_MESSAGE_STORE = new QName("messageStore");
        QName ATT_SEQUENCE = new QName("sequence");

        processAuditStatus(mediator, omElement);

        OMAttribute nameAtt = omElement.getAttribute(ATT_NAME);
        if (nameAtt != null) {
            ((MessageStoreMediator) mediator).setName(nameAtt.getAttributeValue());
        }

        OMAttribute messageStoreNameAtt = omElement.getAttribute(ATT_MESSAGE_STORE);

        if (messageStoreNameAtt != null) {
            if (checkForExpression(messageStoreNameAtt)) {
                String path = messageStoreNameAtt.getAttributeValue().substring(1,
                        messageStoreNameAtt.getAttributeValue().length() - 1);
                try {
                    ((MessageStoreMediator) mediator)
                            .setMessageStoreExp(SynapsePathFactory.getSynapsePath(omElement, path));
                } catch (JaxenException e) {
                    // ignore
                }
            } else {
                ((MessageStoreMediator) mediator).setMessageStoreName(messageStoreNameAtt.getAttributeValue());
            }
        } else {
            // ignore
        }

        OMAttribute sequenceAtt = omElement.getAttribute(ATT_SEQUENCE);

        if (sequenceAtt != null) {
            ((MessageStoreMediator) mediator).setOnStoreSequence(sequenceAtt.getAttributeValue());
        }
        addAllCommentChildrenToList(omElement, ((MessageStoreMediator) mediator).getCommentsList());

        return mediator;
    }

    private boolean checkForExpression(OMAttribute atr) {
        return ((atr.getAttributeValue().startsWith("{")) && (atr.getAttributeValue().endsWith("}")));
    }

}

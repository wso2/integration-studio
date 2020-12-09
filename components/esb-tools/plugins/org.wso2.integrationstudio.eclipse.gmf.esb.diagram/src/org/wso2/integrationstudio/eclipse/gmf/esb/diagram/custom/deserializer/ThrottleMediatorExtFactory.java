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

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.SequenceMediatorFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.throttle.ThrottleMediator;
import org.apache.synapse.mediators.throttle.ThrottleMediatorFactory;

public class ThrottleMediatorExtFactory extends ThrottleMediatorFactory {
    
    private static ThrottleMediatorExtFactory instance;
    
    private ThrottleMediatorExtFactory() {
    }
    
    public static synchronized ThrottleMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new ThrottleMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new ThrottleMediator();
        OMElement policy = omElement.getFirstChildWithName(new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "policy"));
        if (policy != null) {
            OMAttribute key = policy.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "key"));
            if (key != null) {
                String keyValue = key.getAttributeValue();
                if (keyValue != null && !"".equals(keyValue)) {
                    ((ThrottleMediator) mediator).setPolicyKey(keyValue);
                }
            } else {
                OMElement inLine = policy.getFirstElement();
                if (inLine != null) {
                    ((ThrottleMediator) mediator).setInLinePolicy(inLine);
                }
            }
        }

        processAuditStatus(mediator, omElement);

        String id = omElement.getAttributeValue(new QName(XMLConfigConstants.NULL_NAMESPACE, "id"));
        if (id != null && !"".equals(id)) {
            ((ThrottleMediator) mediator).setId(id.trim());
        }

        SequenceMediatorFactory mediatorFactory = new SequenceMediatorFactory();
        OMAttribute onReject = omElement
                .getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, XMLConfigConstants.ONREJECT));
        if (onReject != null) {
            String onRejectValue = onReject.getAttributeValue();
            if (onRejectValue != null) {
                ((ThrottleMediator) mediator).setOnRejectSeqKey(onRejectValue.trim());
            }
        } else {
            OMElement onRejectMediatorElement = omElement.getFirstChildWithName(
                    new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, XMLConfigConstants.ONREJECT));
            if (onRejectMediatorElement != null) {
                ((ThrottleMediator) mediator)
                        .setOnRejectMediator(mediatorFactory.createAnonymousSequence(onRejectMediatorElement, null));
            }
        }
        OMAttribute onAccept = omElement
                .getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, XMLConfigConstants.ONACCEPT));
        if (onAccept != null) {
            String onAcceptValue = onAccept.getAttributeValue();
            if (onAcceptValue != null) {
                ((ThrottleMediator) mediator).setOnAcceptSeqKey(onAcceptValue);
            }
        } else {
            OMElement onAcceptMediatorElement = omElement.getFirstChildWithName(
                    new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, XMLConfigConstants.ONACCEPT));
            if (onAcceptMediatorElement != null) {
                ((ThrottleMediator) mediator)
                        .setOnAcceptMediator(mediatorFactory.createAnonymousSequence(onAcceptMediatorElement, null));
            }
        }
        addAllCommentChildrenToList(omElement, ((ThrottleMediator) mediator).getCommentsList());

        return mediator;
    }

}

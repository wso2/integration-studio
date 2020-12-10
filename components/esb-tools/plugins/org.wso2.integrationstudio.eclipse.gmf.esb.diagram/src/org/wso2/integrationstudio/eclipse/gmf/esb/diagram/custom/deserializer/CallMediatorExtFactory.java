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

import java.io.File;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.CallMediatorFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.builtin.CallMediator;

public class CallMediatorExtFactory extends CallMediatorFactory {
    
    private static CallMediatorExtFactory instance;
    
    private CallMediatorExtFactory() {
    }
    
    public static synchronized CallMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new CallMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new CallMediator();

        QName ENDPOINT_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "endpoint");
        QName BLOCKING_Q = new QName("blocking");
        QName ATT_INIT_AXIS2_CLIENT_OPTIONS = new QName("initAxis2ClientOptions");
        QName ATT_AXIS2XML = new QName("axis2xml");
        QName ATT_REPOSITORY = new QName("repository");

        processAuditStatus(mediator, omElement);

        OMElement epElement = omElement.getFirstChildWithName(ENDPOINT_Q);
        if (epElement != null) {
            Endpoint endpoint = DummyEndpointFactory.getEndpointFromElement(epElement, true, null);
            if (endpoint != null) {
                ((CallMediator) mediator).setEndpoint(endpoint);
            }
        }

        OMAttribute blockingAtt = omElement.getAttribute(BLOCKING_Q);
        if (blockingAtt != null) {

            ((CallMediator) mediator).setBlocking(Boolean.parseBoolean(blockingAtt.getAttributeValue()));
            if (((CallMediator) mediator).isBlocking()) {
                OMAttribute initAxis2ClientOptions = omElement.getAttribute(ATT_INIT_AXIS2_CLIENT_OPTIONS);
                OMAttribute axis2xmlAttr = omElement.getAttribute(ATT_AXIS2XML);
                OMAttribute repoAttr = omElement.getAttribute(ATT_REPOSITORY);

                if (initAxis2ClientOptions != null) {
                    ((CallMediator) mediator)
                            .setInitClientOptions(Boolean.parseBoolean(initAxis2ClientOptions.getAttributeValue()));
                }

                if (axis2xmlAttr != null && axis2xmlAttr.getAttributeValue() != null) {
                    File axis2xml = new File(axis2xmlAttr.getAttributeValue());
                    if (axis2xml.exists() && axis2xml.isFile()) {
                        ((CallMediator) mediator).setAxis2xml(axis2xmlAttr.getAttributeValue());
                    } else {
                        // ignore
                    }
                }

                if (repoAttr != null && repoAttr.getAttributeValue() != null) {
                    File repo = new File(repoAttr.getAttributeValue());
                    if (repo.exists() && repo.isDirectory()) {
                        ((CallMediator) mediator).setClientRepository(repoAttr.getAttributeValue());
                    } else {
                        // ignore
                    }
                }
            }
        }
        addAllCommentChildrenToList(omElement, ((CallMediator) mediator).getCommentsList());

        return mediator;
    }

}

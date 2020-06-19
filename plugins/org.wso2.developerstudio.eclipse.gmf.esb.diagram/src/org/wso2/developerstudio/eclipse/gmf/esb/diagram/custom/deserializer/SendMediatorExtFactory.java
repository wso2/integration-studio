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

import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.config.xml.SendMediatorFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.config.xml.endpoints.EndpointFactory;
import org.apache.synapse.endpoints.AddressEndpoint;
import org.apache.synapse.endpoints.ClassEndpoint;
import org.apache.synapse.endpoints.DefaultEndpoint;
import org.apache.synapse.endpoints.DynamicLoadbalanceEndpoint;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.FailoverEndpoint;
import org.apache.synapse.endpoints.HTTPEndpoint;
import org.apache.synapse.endpoints.IndirectEndpoint;
import org.apache.synapse.endpoints.LoadbalanceEndpoint;
import org.apache.synapse.endpoints.RecipientListEndpoint;
import org.apache.synapse.endpoints.ResolvingEndpoint;
import org.apache.synapse.endpoints.SALoadbalanceEndpoint;
import org.apache.synapse.endpoints.TemplateEndpoint;
import org.apache.synapse.endpoints.WSDLEndpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.builtin.SendMediator;

public class SendMediatorExtFactory extends SendMediatorFactory {
    
    private static SendMediatorExtFactory instance;
    
    private SendMediatorExtFactory() {
    }
    
    public static synchronized SendMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new SendMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {
        Mediator mediator = new SendMediator();

        // TODO add setting values for specific endpoints
        QName SEND_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "send");
        QName ENDPOINT_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "endpoint");
        QName RECEIVING_SEQUENCE = new QName(XMLConfigConstants.RECEIVE);
        QName BUILD_MESSAGE = new QName("buildmessage");

        processAuditStatus(mediator, omElement);

        OMElement epElement = omElement.getFirstChildWithName(ENDPOINT_Q);

        if (epElement != null) {

            Endpoint endpoint = null;
            try {
                endpoint = EndpointFactory.getEndpointFromElement(epElement, true, null);
            } catch (Exception e) {

                if (omElement.getAttribute(ATT_KEY) != null) {
                    endpoint = new IndirectEndpoint();
                }

                if (omElement.getAttribute(new QName("key-expression")) != null) {
                    endpoint = new ResolvingEndpoint();
                }

                if (omElement.getAttribute(new QName("template")) != null) {
                    endpoint = new TemplateEndpoint();
                }

                if (omElement.getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "address")) != null) {
                    endpoint = new AddressEndpoint();
                }

                if (omElement.getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "wsdl")) != null) {
                    endpoint = new WSDLEndpoint();
                }

                if (omElement.getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "default")) != null) {
                    endpoint = new DefaultEndpoint();
                }

                if (omElement
                        .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "loadbalance")) != null) {

                    if (omElement
                            .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "session")) != null) {
                        endpoint = new SALoadbalanceEndpoint();
                    } else {
                        endpoint = new LoadbalanceEndpoint();
                    }
                }

                if (omElement.getFirstChildWithName(
                        new QName(SynapseConstants.SYNAPSE_NAMESPACE, "dynamicLoadbalance")) != null) {
                    endpoint = new DynamicLoadbalanceEndpoint();
                }

                if (omElement.getFirstChildWithName(
                        new QName(SynapseConstants.SYNAPSE_NAMESPACE, "serviceDynamicLoadbalance")) != null) {
                    // Enable after synapse fix
                    /// endpoint = new ServiceDynamicLoadbalanceEndpoint();
                }

                OMElement foElement = omElement
                        .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "failover"));
                if (foElement != null) {
                    endpoint = new FailoverEndpoint();
                }

                OMElement rcplElement = omElement
                        .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "recipientlist"));
                if (rcplElement != null) {
                    endpoint = new RecipientListEndpoint();
                }

                OMElement httpElement = omElement
                        .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "http"));
                if (httpElement != null) {
                    endpoint = new HTTPEndpoint();
                }

                OMElement classElement = omElement
                        .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "class"));
                if (classElement != null) {
                    endpoint = new ClassEndpoint();
                }
            }

            if (endpoint != null) {
                ((SendMediator) mediator).setEndpoint(endpoint);
            } else {
                endpoint = new AddressEndpoint();
            }
        }

        String receivingSequence = omElement.getAttributeValue(RECEIVING_SEQUENCE);
        if (receivingSequence != null) {
            ValueFactoryExtended valueFactory = new ValueFactoryExtended();
            Value value = valueFactory.createValue(XMLConfigConstants.RECEIVE, omElement);

            ((SendMediator) mediator).setReceivingSequence(value);
        }
        String buildMessage = omElement.getAttributeValue(BUILD_MESSAGE);

        if ("true".equals(buildMessage)) {
            ((SendMediator) mediator).setBuildMessage(true);
        }
        addAllCommentChildrenToList(omElement, ((SendMediator) mediator).getCommentsList());

        return mediator;
    }

}

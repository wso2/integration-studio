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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axis2.clustering.Member;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.config.xml.ValueFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.RecipientListEndpoint;
import org.apache.synapse.mediators.Value;

public class DummyRecipientListEndpointFactory extends DummyEndpointFactory {

    private static DummyRecipientListEndpointFactory instance = new DummyRecipientListEndpointFactory();

    private static final QName MEMBER = new QName(SynapseConstants.SYNAPSE_NAMESPACE, "member");
    private static final QName DYNAMIC_SET = new QName(SynapseConstants.SYNAPSE_NAMESPACE, "endpoints");

    private DummyRecipientListEndpointFactory() {
    }

    public static DummyRecipientListEndpointFactory getInstance() {
        return instance;
    }

    @Override
    protected Endpoint createEndpoint(OMElement epConfig, boolean anonymousEndpoint, Properties properties) {

        OMElement recipientListElement = epConfig
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "recipientlist"));

        if (recipientListElement != null) {

            RecipientListEndpoint recipientListEndpoint = new RecipientListEndpoint();

            OMAttribute name = epConfig
                    .getAttribute(new QName(org.apache.synapse.config.xml.XMLConfigConstants.NULL_NAMESPACE, "name"));

            if (name != null) {
                recipientListEndpoint.setName(name.getAttributeValue());
            }

            if (recipientListElement.getFirstChildWithName(XMLConfigConstants.ENDPOINT_ELT) != null) {

                List<Endpoint> endpoints = getEndpoints(recipientListElement, recipientListEndpoint, properties);
                recipientListEndpoint.setChildren(endpoints);

            } else if (recipientListElement.getFirstChildWithName(MEMBER) != null) {

                List<Member> members = getMembers(recipientListElement);
                recipientListEndpoint.setMembers(members);
                OMElement dynamicSetElement = recipientListElement.getFirstChildWithName(DYNAMIC_SET);
                if (dynamicSetElement != null) {
                    Value dynamicEndpointSet = new ValueFactory().createValue("value", dynamicSetElement);
                    String maxStr = dynamicSetElement.getAttributeValue(new QName("max-cache"));

                    int maxCache = -1;
                    try {
                        maxCache = Integer.parseInt(maxStr);
                    } catch (NumberFormatException e) {

                    }
                    recipientListEndpoint = new RecipientListEndpoint(
                            maxCache < 0 ? RecipientListEndpoint.DEFAULT_MAX_POOL : maxCache);

                    if (name != null) {
                        recipientListEndpoint.setName(name.getAttributeValue());
                    }
                    recipientListEndpoint.setDynamicEnpointSet(dynamicEndpointSet);
                }
            }

            processProperties(recipientListEndpoint, epConfig);

            return recipientListEndpoint;
        }

        return null;
    }

    @SuppressWarnings("rawtypes")
    private List<Member> getMembers(OMElement loadbalanceElement) {
        List<Member> members = new ArrayList<Member>();

        for (Iterator memberIter = loadbalanceElement.getChildrenWithName(MEMBER); memberIter.hasNext();) {

            OMElement memberEle = (OMElement) memberIter.next();
            Member member = new Member(memberEle.getAttributeValue(new QName("hostName")), -1);
            String http = memberEle.getAttributeValue(new QName("httpPort"));
            if (http != null) {
                member.setHttpPort(Integer.parseInt(http));
            }
            String https = memberEle.getAttributeValue(new QName("httpsPort"));
            if (https != null && https.trim().length() != 0) {
                member.setHttpsPort(Integer.parseInt(https.trim()));
            }
            members.add(member);
        }
        return members;
    }

}

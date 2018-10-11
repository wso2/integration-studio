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

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axis2.clustering.Member;
import org.apache.axis2.util.JavaUtils;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.config.xml.endpoints.utils.LoadbalanceAlgorithmFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.LoadbalanceEndpoint;
import org.apache.synapse.endpoints.algorithms.LoadbalanceAlgorithm;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Properties;

public class DummyLoadbalanceEndpointFactory extends DummyEndpointFactory {

    private static DummyLoadbalanceEndpointFactory instance = new DummyLoadbalanceEndpointFactory();
    private static final QName MEMBER = new QName(SynapseConstants.SYNAPSE_NAMESPACE, "member");

    private DummyLoadbalanceEndpointFactory() {

    }

    public static DummyLoadbalanceEndpointFactory getInstance() {
        return instance;
    }

    protected Endpoint createEndpoint(OMElement epConfig, boolean anonymousEndpoint, Properties properties) {

        OMElement loadbalanceElement = epConfig
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "loadbalance"));

        if (loadbalanceElement != null) {

            LoadbalanceEndpoint loadbalanceEndpoint = new LoadbalanceEndpoint();

            OMAttribute name = epConfig
                    .getAttribute(new QName(org.apache.synapse.config.xml.XMLConfigConstants.NULL_NAMESPACE, "name"));
            if (name != null) {
                loadbalanceEndpoint.setName(name.getAttributeValue());
            }

            LoadbalanceAlgorithm algorithm = null;
            if (loadbalanceElement.getFirstChildWithName(XMLConfigConstants.ENDPOINT_ELT) != null) {

                List<Endpoint> endpoints = getEndpoints(loadbalanceElement, loadbalanceEndpoint, properties);
                loadbalanceEndpoint.setChildren(endpoints);
                algorithm = LoadbalanceAlgorithmFactory.createLoadbalanceAlgorithm(loadbalanceElement, endpoints);
                algorithm.setLoadBalanceEndpoint(loadbalanceEndpoint);

            } else if (loadbalanceElement.getFirstChildWithName(MEMBER) != null) {

                List<Member> members = getMembers(loadbalanceElement);
                loadbalanceEndpoint.setMembers(members);
                algorithm = LoadbalanceAlgorithmFactory.createLoadbalanceAlgorithm2(loadbalanceElement, members);
                loadbalanceEndpoint.startApplicationMembershipTimer();
            }

            loadbalanceEndpoint.setAlgorithm(algorithm);

            String failover = loadbalanceElement.getAttributeValue(new QName("failover"));
            if (failover != null && failover.equalsIgnoreCase("false")) {
                loadbalanceEndpoint.setFailover(false);
            }

            String buildMessageAtt = loadbalanceElement.getAttributeValue(new QName(XMLConfigConstants.BUILD_MESSAGE));
            if (buildMessageAtt != null) {
                loadbalanceEndpoint.setBuildMessageAttAvailable(true);
                if (JavaUtils.isTrueExplicitly(buildMessageAtt)) {
                    loadbalanceEndpoint.setBuildMessageAtt(true);
                }
            }
            processProperties(loadbalanceEndpoint, epConfig);
            return loadbalanceEndpoint;
        }
        return null;
    }

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

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
import org.apache.axis2.util.JavaUtils;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.config.xml.endpoints.utils.LoadbalanceAlgorithmFactory;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.SALoadbalanceEndpoint;
import org.apache.synapse.endpoints.algorithms.LoadbalanceAlgorithm;
import org.apache.synapse.endpoints.dispatch.Dispatcher;
import org.apache.synapse.endpoints.dispatch.HttpSessionDispatcher;
import org.apache.synapse.endpoints.dispatch.SimpleClientSessionDispatcher;
import org.apache.synapse.endpoints.dispatch.SoapSessionDispatcher;

import javax.xml.namespace.QName;
import java.util.List;
import java.util.Properties;

public class DummySALoadbalanceEndpointFactory extends DummyEndpointFactory {

    private static DummySALoadbalanceEndpointFactory instance = new DummySALoadbalanceEndpointFactory();

    private DummySALoadbalanceEndpointFactory() {
    }

    public static DummySALoadbalanceEndpointFactory getInstance() {
        return instance;
    }

    protected Endpoint createEndpoint(OMElement epConfig, boolean anonymousEndpoint, Properties properties) {

        SALoadbalanceEndpoint loadbalanceEndpoint = new SALoadbalanceEndpoint();

        OMElement sessionElement = epConfig
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "session"));
        if (sessionElement != null) {

            OMElement sessionTimeout = sessionElement
                    .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "sessionTimeout"));

            if (sessionTimeout != null) {
                try {
                    loadbalanceEndpoint.setSessionTimeout(Long.parseLong(sessionTimeout.getText().trim()));
                } catch (NumberFormatException nfe) {
                    loadbalanceEndpoint.setSessionTimeout(1000);
                }
            }

            String type = sessionElement.getAttributeValue(new QName("type"));

            if (type.equalsIgnoreCase("soap")) {
                Dispatcher soapDispatcher = new SoapSessionDispatcher();
                loadbalanceEndpoint.setDispatcher(soapDispatcher);

            } else if (type.equalsIgnoreCase("http")) {
                Dispatcher httpDispatcher = new HttpSessionDispatcher();
                loadbalanceEndpoint.setDispatcher(httpDispatcher);

            } else if (type.equalsIgnoreCase("simpleClientSession")) {
                Dispatcher csDispatcher = new SimpleClientSessionDispatcher();
                loadbalanceEndpoint.setDispatcher(csDispatcher);
            }
        }

        OMAttribute name = epConfig
                .getAttribute(new QName(org.apache.synapse.config.xml.XMLConfigConstants.NULL_NAMESPACE, "name"));

        if (name != null) {
            loadbalanceEndpoint.setName(name.getAttributeValue());
        }

        OMElement loadbalanceElement;
        loadbalanceElement = epConfig
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "loadbalance"));

        if (loadbalanceElement != null) {

            List<Endpoint> endpoints = getEndpoints(loadbalanceElement, loadbalanceEndpoint, properties);
            loadbalanceEndpoint.setChildren(endpoints);

            LoadbalanceAlgorithm algorithm = LoadbalanceAlgorithmFactory.createLoadbalanceAlgorithm(loadbalanceElement,
                    endpoints);
            loadbalanceEndpoint.setAlgorithm(algorithm);

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

}

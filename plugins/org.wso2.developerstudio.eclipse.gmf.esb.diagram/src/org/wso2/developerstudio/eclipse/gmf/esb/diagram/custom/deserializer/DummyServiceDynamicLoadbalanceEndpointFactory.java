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
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.config.xml.endpoints.utils.LoadbalanceAlgorithmFactory;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.ServiceDynamicLoadbalanceEndpoint;
import org.apache.synapse.endpoints.algorithms.LoadbalanceAlgorithm;
import org.apache.synapse.endpoints.dispatch.Dispatcher;
import org.apache.synapse.endpoints.dispatch.HttpSessionDispatcher;
import org.apache.synapse.endpoints.dispatch.SoapSessionDispatcher;

import javax.xml.namespace.QName;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DummyServiceDynamicLoadbalanceEndpointFactory extends DummyEndpointFactory {

    private static DummyServiceDynamicLoadbalanceEndpointFactory instance = new DummyServiceDynamicLoadbalanceEndpointFactory();
    public static final QName SERVICES_QNAME = new QName(SynapseConstants.SYNAPSE_NAMESPACE, "services");
    public static final QName LB_CONFIG_QNAME = new QName(SynapseConstants.SYNAPSE_NAMESPACE, "loadBalancerConfig");

    private DummyServiceDynamicLoadbalanceEndpointFactory() {
    }

    public static DummyServiceDynamicLoadbalanceEndpointFactory getInstance() {
        return instance;
    }

    protected Endpoint createEndpoint(OMElement epConfig, boolean anonymousEndpoint, Properties properties) {

        OMElement loadbalanceElement = epConfig
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "serviceDynamicLoadbalance"));
        if (loadbalanceElement == null) {
            return null;
        }

        String configuration = loadbalanceElement
                .getAttributeValue(new QName(XMLConfigConstants.NULL_NAMESPACE, "configuration"));
        OMElement servicesEle = null;
        if (configuration != null) {
            if (configuration.startsWith("$system:")) {
                configuration = System.getProperty(configuration.substring("$system:".length()));
            }

            StAXOMBuilder builder = null;
            try {
                builder = new StAXOMBuilder(new URL(configuration).openStream());
            } catch (Exception e) {
                // ignore
            }
            servicesEle = builder.getDocumentElement().getFirstChildWithName(SERVICES_QNAME);
        } else {
            OMElement lbConfigEle = loadbalanceElement.getFirstChildWithName(LB_CONFIG_QNAME);
            if (lbConfigEle != null) {
                servicesEle = lbConfigEle.getFirstChildWithName(SERVICES_QNAME);
            }

        }

        Map<String, String> hostDomainMap = new HashMap<String, String>();
        if (servicesEle != null) {
            for (Iterator<OMElement> iter = servicesEle.getChildrenWithLocalName("service"); iter.hasNext();) {
                OMElement serviceEle = iter.next();
                OMElement hostsEle = serviceEle
                        .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "hosts"));
                List<String> hosts = new ArrayList<String>();

                if (hostsEle != null) {
                    for (Iterator<OMElement> hostIter = hostsEle.getChildrenWithLocalName("host"); hostIter
                            .hasNext();) {
                        OMElement hostEle = hostIter.next();
                        String host = hostEle.getText();
                        if (host.trim().length() == 0) {
                            hosts.add("host_name");
                        }
                        hosts.add(host);
                    }
                }

                OMElement domainEle = serviceEle
                        .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "domain"));
                String domain = "domain_name";
                if (domainEle != null) {
                    domain = domainEle.getText();
                }

                for (String host : hosts) {
                    if (!hostDomainMap.containsKey(host)) {
                        hostDomainMap.put(host, domain);
                    }

                }
            }
        }

        LoadbalanceAlgorithm algorithm = LoadbalanceAlgorithmFactory.createLoadbalanceAlgorithm(loadbalanceElement,
                null);

        ServiceDynamicLoadbalanceEndpoint loadbalanceEndpoint = new ServiceDynamicLoadbalanceEndpoint(hostDomainMap,
                algorithm);

        OMAttribute name = epConfig.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "name"));
        if (name != null) {
            loadbalanceEndpoint.setName(name.getAttributeValue());
        }

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

            }

            loadbalanceEndpoint.setSessionAffinity(true);
        }
        loadbalanceEndpoint.setFailover(false);

        return loadbalanceEndpoint;
    }
}

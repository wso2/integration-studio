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

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNode;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.aspects.AspectConfiguration;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.config.xml.endpoints.DefinitionFactory;
import org.apache.synapse.config.xml.endpoints.EndpointFactory;
import org.apache.synapse.config.xml.MediatorPropertyFactory;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.IndirectEndpoint;
import org.apache.synapse.endpoints.EndpointDefinition;
import org.apache.synapse.PropertyInclude;
import org.apache.synapse.mediators.MediatorProperty;
import org.apache.synapse.util.CommentListUtil;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.AddressEndpoint;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.xml.namespace.QName;

public abstract class DummyEndpointFactory {

    private DefinitionFactory customDefnFactory = null;

    protected DummyEndpointFactory() {

    }

    public static final QName ON_FAULT_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "onError");

    private static final QName DESCRIPTION_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "description");

    public static Endpoint getEndpointFromElement(OMElement elem, boolean isAnonymous, Properties properties) {
        if (getEndpointFactory(elem) != null) {
            return getEndpointFactory(elem).createEndpointWithName(elem, isAnonymous, properties);
        } else {
            return new AddressEndpoint();
        }
    }

    public static Endpoint getEndpointFromElement(OMElement elem, DefinitionFactory factory, boolean isAnonymous,
            Properties properties) {
        DummyEndpointFactory fac = getEndpointFactory(elem);
        fac.setEndpointDefinitionFactory(factory);
        return fac.createEndpointWithName(elem, isAnonymous, properties);
    }

    public Object getObjectFromOMNode(OMNode om, Properties properties) {
        if (om instanceof OMElement) {
            return createEndpointWithName((OMElement) om, false, properties);
        }
        return null;
    }

    protected abstract Endpoint createEndpoint(OMElement epConfig, boolean anonymousEndpoint, Properties properties);

    private Endpoint createEndpointWithName(OMElement epConfig, boolean anonymousEndpoint, Properties properties) {

        Endpoint ep = createEndpoint(epConfig, anonymousEndpoint, properties);
        OMElement descriptionElem = epConfig.getFirstChildWithName(DESCRIPTION_Q);
        if (descriptionElem != null) {
            ep.setDescription(descriptionElem.getText());
        }

        if (anonymousEndpoint && ep.getName() == null) {
            if (ep instanceof AbstractEndpoint) {
                ((AbstractEndpoint) ep).setAnonymous(true);
            }
        }

        OMAttribute onFaultAtt = epConfig.getAttribute(ON_FAULT_Q);
        if (onFaultAtt != null) {
            ep.setErrorHandler(onFaultAtt.getAttributeValue());
        }
        CommentListUtil.populateComments(epConfig, ((AbstractEndpoint)ep).getCommentsList());
        
        return ep;
    }

    protected void extractSpecificEndpointProperties(EndpointDefinition definition, OMElement elem) {

    }

    private static DummyEndpointFactory getEndpointFactory(OMElement configElement) {

        if (configElement.getAttribute(new QName("key")) != null) {
            return DummyIndirectEndpointFactory.getInstance();
        }

        if (configElement.getAttribute(new QName("key-expression")) != null) {
            return DummyResolvingEndpointFactory.getInstance();
        }

        if (configElement.getAttribute(new QName("template")) != null) {
            return new DummyTemplateEndpointFactory();
        }

        OMElement addressElement = configElement
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "address"));
        if (addressElement != null) {
            return DummyAddressEndpointFactory.getInstance();
        }

        OMElement wsdlElement = configElement
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "wsdl"));
        if (wsdlElement != null) {
            return DummyWSDLEndpointFactory.getInstance();
        }

        OMElement defaultElement = configElement
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "default"));
        if (defaultElement != null) {
            return DummyDefaultEndpointFactory.getInstance();
        }

        OMElement lbElement = configElement
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "loadbalance"));
        if (lbElement != null) {
            OMElement sessionElement = configElement
                    .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "session"));
            if (sessionElement != null) {
                return DummySALoadbalanceEndpointFactory.getInstance();
            } else {
                return DummyLoadbalanceEndpointFactory.getInstance();
            }
        }

        OMElement dlbElement = configElement
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "dynamicLoadbalance"));
        if (dlbElement != null) {
            return DummyDynamicLoadbalanceEndpointFactory.getInstance();
        }

        OMElement sdlbElement = configElement
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "serviceDynamicLoadbalance"));
        if (sdlbElement != null) {
            return DummyServiceDynamicLoadbalanceEndpointFactory.getInstance();
        }

        OMElement foElement = configElement
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "failover"));
        if (foElement != null) {
            return DummyFailoverEndpointFactory.getInstance();
        }

        OMElement rcplElement = configElement
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "recipientlist"));
        if (rcplElement != null) {
            return DummyRecipientListEndpointFactory.getInstance();
        }

        OMElement httpElement = configElement
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "http"));
        if (httpElement != null) {
            return DummyHTTPEndpointFactory.getInstance();
        }

        OMElement classElement = configElement
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "class"));
        if (classElement != null) {
            return DummyClassEndpointFactory.getInstance();
        }

        return null;
    }

    protected ArrayList<Endpoint> getEndpoints(OMElement listEndpointElement, Endpoint parent, Properties properties) {

        ArrayList<Endpoint> endpoints = new ArrayList<Endpoint>();
        ArrayList<String> keys = new ArrayList<String>();
        Iterator iter = listEndpointElement.getChildrenWithName(XMLConfigConstants.ENDPOINT_ELT);
        while (iter.hasNext()) {
            OMElement endptElem = (OMElement) iter.next();
            Endpoint endpoint = EndpointFactory.getEndpointFromElement(endptElem, true, properties);
            if (endpoint instanceof IndirectEndpoint) {
                String key = ((IndirectEndpoint) endpoint).getKey();
                if (!keys.contains(key)) {
                    keys.add(key);
                }
            }
            endpoint.setParentEndpoint(parent);
            endpoints.add(endpoint);
        }

        return endpoints;
    }

    public void setEndpointDefinitionFactory(DefinitionFactory factory) {
        customDefnFactory = factory;
    }

    public DefinitionFactory getEndpointDefinitionFactory() {
        return customDefnFactory;
    }

    protected void processProperties(PropertyInclude endpoint, OMElement endpointElement) {
        List<MediatorProperty> properties = MediatorPropertyFactory.getMediatorProperties(endpointElement);

        if (properties != null && properties.size() > 0) {
            endpoint.addProperties(properties);
        }
    }

    protected void processAuditStatus(EndpointDefinition definition, String name, OMElement epOmElement) {

        if (name == null || "".equals(name)) {
            name = SynapseConstants.ANONYMOUS_ENDPOINT;
        }
        AspectConfiguration aspectConfiguration = new AspectConfiguration(name);
        definition.configure(aspectConfiguration);
        OMAttribute statistics = epOmElement.getAttribute(new QName(XMLConfigConstants.STATISTICS_ATTRIB_NAME));
        if (statistics != null) {
            String statisticsValue = statistics.getAttributeValue();
            if (statisticsValue != null) {
                if (XMLConfigConstants.STATISTICS_ENABLE.equals(statisticsValue)) {
                    aspectConfiguration.enableStatistics();
                }
            }
        }
        OMAttribute tracing = epOmElement.getAttribute(new QName(XMLConfigConstants.TRACE_ATTRIB_NAME));
        if (tracing != null) {
            String tracingValue = tracing.getAttributeValue();
            if (tracingValue != null) {
                if (XMLConfigConstants.TRACE_ENABLE.equals(tracingValue)) {
                    aspectConfiguration.enableTracing();
                }
            }
        }
    }
}

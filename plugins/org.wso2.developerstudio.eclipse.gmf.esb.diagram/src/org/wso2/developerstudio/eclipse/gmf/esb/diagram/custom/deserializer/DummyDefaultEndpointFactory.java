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
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.aspects.AspectConfiguration;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.config.xml.endpoints.DefinitionFactory;
import org.apache.synapse.config.xml.endpoints.EndpointDefinitionFactory;
import org.apache.synapse.endpoints.DefaultEndpoint;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.EndpointDefinition;

import javax.xml.namespace.QName;
import java.util.Properties;

public class DummyDefaultEndpointFactory extends DummyEndpointFactory {

    private static DummyDefaultEndpointFactory instance = new DummyDefaultEndpointFactory();

    protected DummyDefaultEndpointFactory() {
    }

    public static DummyDefaultEndpointFactory getInstance() {
        return instance;
    }

    protected Endpoint createEndpoint(OMElement epConfig, boolean anonymousEndpoint, Properties properties) {

        DefaultEndpoint defaultEndpoint = new DefaultEndpoint();
        OMAttribute name = epConfig.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "name"));

        if (name != null) {
            defaultEndpoint.setName(name.getAttributeValue());
        }

        OMElement defaultElement = epConfig
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "default"));
        if (defaultElement != null) {
            EndpointDefinition endpoint = createEndpointDefinition(defaultElement);
            defaultEndpoint.setDefinition(endpoint);
            processAuditStatus(endpoint, defaultEndpoint.getName(), defaultElement);
        }

        processProperties(defaultEndpoint, epConfig);

        return defaultEndpoint;
    }

    @Override
    protected void extractSpecificEndpointProperties(EndpointDefinition definition, OMElement elem) {

        OMAttribute format = elem.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "format"));
        if (format != null) {
            String forceValue = format.getAttributeValue().trim().toLowerCase();
            if (SynapseConstants.FORMAT_POX.equals(forceValue)) {
                definition.setForcePOX(true);
                definition.setFormat(SynapseConstants.FORMAT_POX);

            } else if (SynapseConstants.FORMAT_GET.equals(forceValue)) {
                definition.setForceGET(true);
                definition.setFormat(SynapseConstants.FORMAT_GET);

            } else if (SynapseConstants.FORMAT_SOAP11.equals(forceValue)) {
                definition.setForceSOAP11(true);
                definition.setFormat(SynapseConstants.FORMAT_SOAP11);

            } else if (SynapseConstants.FORMAT_SOAP12.equals(forceValue)) {
                definition.setForceSOAP12(true);
                definition.setFormat(SynapseConstants.FORMAT_SOAP12);

            } else if (SynapseConstants.FORMAT_REST.equals(forceValue)) {
                definition.setForceREST(true);
                definition.setFormat(SynapseConstants.FORMAT_REST);

            } else {
                definition.setForcePOX(true);
                definition.setFormat(SynapseConstants.FORMAT_POX);

            }
        }

    }

    public EndpointDefinition createEndpointDefinition(OMElement elem) {
        DefinitionFactory fac = getEndpointDefinitionFactory();
        EndpointDefinition endpointDefinition;
        if (fac == null) {
            fac = new EndpointDefinitionFactory();
            endpointDefinition = fac.createDefinition(elem);
        } else {
            endpointDefinition = fac.createDefinition(elem);
        }
        extractSpecificEndpointProperties(endpointDefinition, elem);
        return endpointDefinition;
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

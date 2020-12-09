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
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.config.xml.endpoints.DefinitionFactory;
import org.apache.synapse.config.xml.endpoints.EndpointDefinitionFactory;
import org.apache.synapse.endpoints.AddressEndpoint;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.EndpointDefinition;

import javax.xml.namespace.QName;
import java.util.Properties;

public class DummyAddressEndpointFactory extends DummyEndpointFactory {

    private static DummyAddressEndpointFactory instance = new DummyAddressEndpointFactory();

    private DummyAddressEndpointFactory() {

    }

    public static DummyAddressEndpointFactory getInstance() {
        return instance;
    }

    @Override
    protected Endpoint createEndpoint(OMElement epConfig, boolean anonymousEndpoint, Properties properties) {

        AddressEndpoint addressEndpoint = new AddressEndpoint();
        OMAttribute name = epConfig.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "name"));

        if (name != null) {
            addressEndpoint.setName(name.getAttributeValue());
        }

        OMElement addressElement = epConfig
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "address"));
        if (addressElement != null) {
            EndpointDefinition definition = createEndpointDefinition(addressElement);
            addressEndpoint.setDefinition(definition);
            processAuditStatus(definition, addressEndpoint.getName(), addressElement);
        }

        processProperties(addressEndpoint, epConfig);

        return addressEndpoint;
    }

    public EndpointDefinition createEndpointDefinition(OMElement elem) {

        OMAttribute address = elem.getAttribute(new QName("uri"));
        DefinitionFactory fac = getEndpointDefinitionFactory();
        EndpointDefinition endpointDefinition;
        if (fac == null) {
            fac = new EndpointDefinitionFactory();
            endpointDefinition = fac.createDefinition(elem);
        } else {
            endpointDefinition = fac.createDefinition(elem);
        }

        if (address != null) {
            endpointDefinition.setAddress(address.getAttributeValue().trim());
        } else {
            endpointDefinition.setAddress("");
        }

        extractSpecificEndpointProperties(endpointDefinition, elem);
        return endpointDefinition;
    }
}

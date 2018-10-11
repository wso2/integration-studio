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
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMNode;
import org.apache.axis2.util.JavaUtils;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.config.SynapseConfigUtils;
import org.apache.synapse.config.xml.endpoints.DefinitionFactory;
import org.apache.synapse.config.xml.endpoints.EndpointDefinitionFactory;
import org.apache.synapse.config.xml.endpoints.utils.WSDL11EndpointBuilder;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.WSDLEndpoint;
import org.apache.synapse.endpoints.EndpointDefinition;

import javax.xml.namespace.QName;
import java.io.File;
import java.net.URL;
import java.util.Properties;

public class DummyWSDLEndpointFactory extends DummyEndpointFactory {

    public static final String SKIP_WSDL_PARSING = "skip.wsdl.parsing";

    private static DummyWSDLEndpointFactory instance = new DummyWSDLEndpointFactory();

    private DummyWSDLEndpointFactory() {

    }

    public static DummyWSDLEndpointFactory getInstance() {
        return instance;
    }

    protected Endpoint createEndpoint(OMElement epConfig, boolean anonymousEndpoint, Properties properties) {

        WSDLEndpoint wsdlEndpoint = new WSDLEndpoint();
        OMAttribute name = epConfig
                .getAttribute(new QName(org.apache.synapse.config.xml.XMLConfigConstants.NULL_NAMESPACE, "name"));

        if (name != null) {
            wsdlEndpoint.setName(name.getAttributeValue());
        }

        OMElement wsdlElement = epConfig.getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "wsdl"));
        if (wsdlElement != null) {

            DefinitionFactory fac = getEndpointDefinitionFactory();
            EndpointDefinition endpoint;
            if (fac == null) {
                fac = new EndpointDefinitionFactory();
                endpoint = fac.createDefinition(wsdlElement);
            } else {
                endpoint = fac.createDefinition(wsdlElement);
            }

            extractSpecificEndpointProperties(endpoint, wsdlElement);
            wsdlEndpoint.setDefinition(endpoint);
            processAuditStatus(endpoint, wsdlEndpoint.getName(), wsdlElement);

            String serviceName = wsdlElement.getAttributeValue(new QName("service"));
            String portName = wsdlElement.getAttributeValue(new QName("port"));
            String wsdlURI = wsdlElement.getAttributeValue(new QName("uri"));

            if (serviceName == null || serviceName.equals("")) {
                wsdlEndpoint.setServiceName("WSDL_Service");
            } else {
                wsdlEndpoint.setServiceName(serviceName);
            }

            if (portName == null || portName.equals("")) {
                wsdlEndpoint.setPortName("8080");
            } else {
                wsdlEndpoint.setPortName(portName);
            }

            String noParsing = properties.getProperty(SKIP_WSDL_PARSING);

            if (wsdlURI != null) {
                wsdlEndpoint.setWsdlURI(wsdlURI.trim());
                if (noParsing == null || !JavaUtils.isTrueExplicitly(noParsing)) {
                    try {
                        OMNode wsdlOM = SynapseConfigUtils.getOMElementFromURL(new URL(wsdlURI).toString(),
                                properties.get(SynapseConstants.SYNAPSE_HOME) != null
                                        ? properties.get(SynapseConstants.SYNAPSE_HOME).toString()
                                        : "");
                        if (wsdlOM != null && wsdlOM instanceof OMElement) {
                            OMElement omElement = (OMElement) wsdlOM;
                            OMNamespace ns = omElement.getNamespace();
                            if (ns != null) {
                                new WSDL11EndpointBuilder().populateEndpointDefinitionFromWSDL(endpoint, wsdlURI.trim(),
                                        omElement, serviceName, portName);
                            }
                        }
                    } catch (Exception e) {
                        // ignore
                    }
                }
            }

            OMElement definitionElement = wsdlElement.getFirstChildWithName(
                    new QName(org.apache.axis2.namespace.Constants.NS_URI_WSDL11, "definitions"));
            if (endpoint == null && definitionElement != null) {
                wsdlEndpoint.setWsdlDoc(definitionElement);

                if (noParsing == null || !JavaUtils.isTrueExplicitly(noParsing)) {
                    String resolveRoot = properties.get(SynapseConstants.RESOLVE_ROOT).toString();
                    String baseUri = "file:./";
                    if (resolveRoot != null) {
                        baseUri = resolveRoot.trim();
                    }
                    if (!baseUri.endsWith(File.separator)) {
                        baseUri = baseUri + File.separator;
                    }
                    new WSDL11EndpointBuilder().populateEndpointDefinitionFromWSDL(endpoint, baseUri, definitionElement,
                            serviceName, portName);
                } else {
                    endpoint = new EndpointDefinition();
                }
            }
        }

        processProperties(wsdlEndpoint, epConfig);

        return wsdlEndpoint;
    }
}

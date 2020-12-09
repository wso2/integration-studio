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

import com.damnhandy.uri.template.UriTemplate;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axis2.Constants;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.config.xml.endpoints.DefinitionFactory;
import org.apache.synapse.config.xml.endpoints.EndpointDefinitionFactory;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.EndpointDefinition;
import org.apache.synapse.endpoints.HTTPEndpoint;
import org.apache.synapse.rest.RESTConstants;

import javax.xml.namespace.QName;
import java.util.Properties;

public class DummyHTTPEndpointFactory extends DummyEndpointFactory {

    private static DummyHTTPEndpointFactory instance = new DummyHTTPEndpointFactory();

    public static DummyHTTPEndpointFactory getInstance() {
        return instance;
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

    @Override
    protected Endpoint createEndpoint(OMElement epConfig, boolean anonymousEndpoint, Properties properties) {
        HTTPEndpoint httpEndpoint = new HTTPEndpoint();
        OMAttribute name = epConfig.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "name"));

        if (name != null) {
            httpEndpoint.setName(name.getAttributeValue());
        }

        OMElement httpElement = epConfig.getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "http"));

        if (httpElement != null) {
            EndpointDefinition definition = createEndpointDefinition(httpElement);

            OMAttribute uriTemplateAttr = httpElement.getAttribute(new QName("uri-template"));
            if (uriTemplateAttr != null) {

                if (uriTemplateAttr.getAttributeValue().startsWith(HTTPEndpoint.legacyPrefix)) {
                    httpEndpoint.setUriTemplate(UriTemplate.fromTemplate(
                            uriTemplateAttr.getAttributeValue().substring(HTTPEndpoint.legacyPrefix.length())));
                    definition.setAddress(
                            uriTemplateAttr.getAttributeValue().substring(HTTPEndpoint.legacyPrefix.length()));
                    httpEndpoint.setLegacySupport(true);

                } else {

                    httpEndpoint.setUriTemplate(UriTemplate.fromTemplate(uriTemplateAttr.getAttributeValue()));
                    definition.setAddress(uriTemplateAttr.getAttributeValue());
                    httpEndpoint.setLegacySupport(false);
                }

            }

            httpEndpoint.setDefinition(definition);
            processAuditStatus(definition, httpEndpoint.getName(), httpElement);

            OMAttribute methodAttr = httpElement.getAttribute(new QName("method"));
            if (methodAttr != null) {
                setHttpMethod(httpEndpoint, methodAttr.getAttributeValue());
            }
        }

        processProperties(httpEndpoint, epConfig);

        return httpEndpoint;
    }

    private void setHttpMethod(HTTPEndpoint httpEndpoint, String httpMethod) {
        if (httpMethod != null) {
            if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_POST)) {
                httpEndpoint.setHttpMethod(Constants.Configuration.HTTP_METHOD_POST);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_GET)) {
                httpEndpoint.setHttpMethod(Constants.Configuration.HTTP_METHOD_GET);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_PUT)) {
                httpEndpoint.setHttpMethod(Constants.Configuration.HTTP_METHOD_PUT);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_DELETE)) {
                httpEndpoint.setHttpMethod(Constants.Configuration.HTTP_METHOD_DELETE);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_HEAD)) {
                httpEndpoint.setHttpMethod(Constants.Configuration.HTTP_METHOD_HEAD);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_PATCH)) {
                httpEndpoint.setHttpMethod(Constants.Configuration.HTTP_METHOD_PATCH);
            } else if (httpMethod.equalsIgnoreCase(RESTConstants.METHOD_OPTIONS)) {
                httpEndpoint.setHttpMethod(RESTConstants.METHOD_OPTIONS);
            }
        }
    }

}

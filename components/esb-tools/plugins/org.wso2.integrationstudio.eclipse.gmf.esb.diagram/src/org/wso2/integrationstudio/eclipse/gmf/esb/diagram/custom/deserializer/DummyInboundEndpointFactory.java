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

import java.util.Iterator;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.synapse.SynapseException;
import org.apache.synapse.aspects.AspectConfiguration;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.inbound.InboundEndpoint;
import org.apache.synapse.inbound.InboundEndpointConstants;

public class DummyInboundEndpointFactory {

    private static final QName ATT_TRACE = new QName("trace");
    private static final QName ATT_STAT = new QName("statistics");
    private static final QName ATT_NAME = new QName(InboundEndpointConstants.INBOUND_ENDPOINT_NAME);
    private static final QName ATT_PROTOCOL = new QName(InboundEndpointConstants.INBOUND_ENDPOINT_PROTOCOL);
    private static final QName ATT_ENDPOINT_CLASS = new QName(InboundEndpointConstants.INBOUND_ENDPOINT_CLASS);
    private static final QName ATT_ENDPOINT_SUSPEND = new QName(InboundEndpointConstants.INBOUND_ENDPOINT_SUSPEND);
    private static final QName ATT_SEQUENCE = new QName(InboundEndpointConstants.INBOUND_ENDPOINT_SEQUENCE);
    private static final QName ATT_ERROR_SEQUENCE = new QName(InboundEndpointConstants.INBOUND_ENDPOINT_ERROR_SEQUENCE);
    private static final String XML_EXTENTION = ".xml";
    private static final String INBOUND_ENDPOINT_NAME_ID = "inbound.endpoint.name";
    private static final String EMPTY_STRING = "";
    private static final Object ENABLE_TAG = "enable";

    public static InboundEndpoint createInboundEndpointDev(OMElement inboundEndpointElem) {

        InboundEndpoint inboundEndpoint = new InboundEndpoint();

        if (inboundEndpointElem.getAttributeValue(ATT_NAME) != null) {
            inboundEndpoint.setName(inboundEndpointElem.getAttributeValue(ATT_NAME));
        } else {
            throw new SynapseException("Attribute \"name\" is not defined for the inbound endpoint. "
                    + "Name should be equal to inbound endpoint artifact .xml file name.");
        }
        inboundEndpoint.configure(new AspectConfiguration(inboundEndpointElem.getAttributeValue(ATT_NAME)));
        if (inboundEndpointElem.getAttributeValue(ATT_TRACE) != null
                && ENABLE_TAG.equals(inboundEndpointElem.getAttributeValue(ATT_TRACE))) {
            inboundEndpoint.getAspectConfiguration().enableStatistics();
        }
        if (inboundEndpointElem.getAttributeValue(ATT_STAT) != null
                && ENABLE_TAG.equals(inboundEndpointElem.getAttributeValue(ATT_STAT))) {
            inboundEndpoint.getAspectConfiguration().enableTracing();
        }
        String protocol = inboundEndpointElem.getAttributeValue(ATT_PROTOCOL);
        if (protocol != null && !protocol.isEmpty()) {
            inboundEndpoint.setProtocol(protocol);
        }
        if (inboundEndpointElem.getAttributeValue(ATT_ENDPOINT_CLASS) != null) {
            inboundEndpoint.setClassImpl(inboundEndpointElem.getAttributeValue(ATT_ENDPOINT_CLASS));
        }
        if (inboundEndpointElem.getAttributeValue(ATT_ENDPOINT_SUSPEND) != null) {
            inboundEndpoint
                    .setSuspend(Boolean.parseBoolean(inboundEndpointElem.getAttributeValue(ATT_ENDPOINT_SUSPEND)));
        } else {
            inboundEndpoint.setSuspend(false);
        }

        String sequence = inboundEndpointElem.getAttributeValue(ATT_SEQUENCE);
        if (sequence != null && !sequence.isEmpty()) {
            inboundEndpoint.setInjectingSeq(sequence);
        } else if (isSequenceMandatoryProtocol(protocol)) {
            throw new SynapseException(
                    "Attribute \"sequence\" is not defined for the Inbound Endpoint configuration. Please define a sequence.");
        }

        String onErrorSequence = inboundEndpointElem.getAttributeValue(ATT_ERROR_SEQUENCE);
        if (onErrorSequence != null && !onErrorSequence.isEmpty()) {
            inboundEndpoint.setOnErrorSeq(onErrorSequence);
        } else if (isSequenceMandatoryProtocol(protocol)) {
            throw new SynapseException(
                    "Attribute \"onError\" is not defined for the Inbound Endpoint configuration. Please define a onError sequence.");
        }

        String nameString = inboundEndpoint.getName();
        if (nameString == null || EMPTY_STRING.equals(nameString)) {
            nameString = INBOUND_ENDPOINT_NAME_ID;
        }

        OMElement parametersElt = inboundEndpointElem.getFirstChildWithName(
                new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, InboundEndpointConstants.INBOUND_ENDPOINT_PARAMETERS));

        if (parametersElt != null) {
            Iterator<?> parameters = parametersElt.getChildrenWithName(new QName(XMLConfigConstants.SYNAPSE_NAMESPACE,
                    InboundEndpointConstants.INBOUND_ENDPOINT_PARAMETER));

            while (parameters.hasNext()) {
                OMElement parameter = (OMElement) parameters.next();
                String paramName = parameter
                        .getAttributeValue(new QName(InboundEndpointConstants.INBOUND_ENDPOINT_PARAMETER_NAME));
                String paramKey = parameter
                        .getAttributeValue(new QName(InboundEndpointConstants.INBOUND_ENDPOINT_PARAMETER_KEY));

                if (paramKey != null) {
                    inboundEndpoint.addParameter(paramName, EMPTY_STRING, paramKey);
                } else if (parameter.getFirstElement() != null) {
                    inboundEndpoint.addParameter(paramName, parameter.getFirstElement().toString());
                } else {
                    inboundEndpoint.addParameter(paramName, parameter.getText());
                }
            }
        }
        inboundEndpoint.setFileName(
                inboundEndpointElem.getAttributeValue(new QName(InboundEndpointConstants.INBOUND_ENDPOINT_NAME))
                        + XML_EXTENTION);
        return inboundEndpoint;
    }

    private static boolean isSequenceMandatoryProtocol(String type) {
        if (type.matches("file|jms|hl7|kafka|mqtt|rabbitmq|wso2_mb|ws|wss")) {
            return true;
        }
        return false;
    }
}

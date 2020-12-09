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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.SynapseXPathFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.jaxen.JaxenException;
import org.wso2.carbon.mediator.publishevent.Property;
import org.wso2.carbon.mediator.publishevent.PublishEventMediator;
import org.wso2.carbon.mediator.publishevent.PublishEventMediatorFactory;

public class PublishEventMediatorExtFactory extends PublishEventMediatorFactory {
    
    private static PublishEventMediatorExtFactory instance;
    
    private PublishEventMediatorExtFactory() {
    }
    
    public static synchronized PublishEventMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new PublishEventMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new PublishEventMediator();

        QName EVENT_SINK_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "eventSink");
        QName STREAM_NAME_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "streamName");
        QName STREAM_VERSION_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "streamVersion");
        QName ATTRIBUTES_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "attributes");
        QName ATTRIBUTE_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "attribute");
        QName META_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "meta");
        QName CORRELATION_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "correlation");
        QName PAYLOAD_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "payload");
        QName ARBITRARY_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "arbitrary");
        QName ATT_ASYNC = new QName("async");
        QName ATT_ASYNC_TIMEOUT = new QName("timeout");

        OMAttribute isAsync = omElement.getAttribute(ATT_ASYNC);
        if ((isAsync != null && !Boolean.parseBoolean(isAsync.getAttributeValue()))) {
            ((PublishEventMediator) mediator).setAsync(false);
        } else {
            OMAttribute asyncTimeout = omElement.getAttribute(ATT_ASYNC_TIMEOUT);
            if (asyncTimeout != null) {
                try {
                    long timeout = Long.parseLong(asyncTimeout.getAttributeValue());
                    if (timeout > 0) {
                        ((PublishEventMediator) mediator).setAsyncTimeout(timeout);
                    }
                } catch (NumberFormatException e) {
                    // ignore
                }
            }
        }

        OMElement streamName = omElement.getFirstChildWithName(STREAM_NAME_QNAME);
        if (streamName != null) {
            ((PublishEventMediator) mediator).setStreamName(streamName.getText());
        }

        OMElement streamVersion = omElement.getFirstChildWithName(STREAM_VERSION_QNAME);
        if (streamVersion != null) {
            ((PublishEventMediator) mediator).setStreamVersion(streamVersion.getText());
        }

        OMElement attributes = omElement.getFirstChildWithName(ATTRIBUTES_QNAME);
        if (attributes != null) {

            OMElement meta = attributes.getFirstChildWithName(META_QNAME);
            if (meta != null) {
                Iterator<OMElement> iterator = meta.getChildrenWithName(ATTRIBUTE_QNAME);
                List<Property> propertyList = generatePropertyList(iterator);
                ((PublishEventMediator) mediator).setMetaProperties(propertyList);
            }
            OMElement correlation = attributes.getFirstChildWithName(CORRELATION_QNAME);
            if (correlation != null) {
                Iterator<OMElement> iterator = correlation.getChildrenWithName(ATTRIBUTE_QNAME);
                List<Property> propertyList = generatePropertyList(iterator);
                ((PublishEventMediator) mediator).setCorrelationProperties(propertyList);
            }
            OMElement payload = attributes.getFirstChildWithName(PAYLOAD_QNAME);
            if (payload != null) {
                Iterator<OMElement> iterator = payload.getChildrenWithName(ATTRIBUTE_QNAME);
                List<Property> propertyList = generatePropertyList(iterator);
                ((PublishEventMediator) mediator).setPayloadProperties(propertyList);
            }
            OMElement arbitrary = attributes.getFirstChildWithName(ARBITRARY_QNAME);
            if (arbitrary != null) {
                Iterator<OMElement> iterator = arbitrary.getChildrenWithName(ATTRIBUTE_QNAME);
                List<Property> propertyList = generatePropertyList(iterator);

                ((PublishEventMediator) mediator).setArbitraryProperties(propertyList);
            }
        }

        OMElement eventSinkElement = omElement.getFirstChildWithName(EVENT_SINK_QNAME);
        if (eventSinkElement != null) {
            ((PublishEventMediator) mediator).setEventSinkName(eventSinkElement.getText());
        }
        addAllCommentChildrenToList(omElement, ((PublishEventMediator) mediator).getCommentsList());

        return mediator;

    }

    private List<Property> generatePropertyList(Iterator<OMElement> iterator) {

        List<Property> propertyList = new ArrayList<Property>();
        while (iterator.hasNext()) {
            OMElement element = iterator.next();
            Property property = new Property();
            OMAttribute nameAttr = element.getAttribute(ATT_NAME);
            if (nameAttr != null) {
                property.setKey(nameAttr.getAttributeValue());
            }

            OMAttribute typeAttr = element.getAttribute(TYPE_QNAME);
            if (typeAttr != null) {
                property.setType(typeAttr.getAttributeValue());
            }

            OMAttribute valueAttr = element.getAttribute(ATT_VALUE);

            if (valueAttr != null) {
                property.setValue(valueAttr.getAttributeValue());
            } else {
                try {
                    property.setExpression(SynapseXPathFactory.getSynapseXPath(element, ATT_EXPRN));
                } catch (JaxenException e) {
                    // ignore
                }
            }

            OMAttribute defaultAtr = element.getAttribute(DEFAULT_QNAME);
            if (defaultAtr != null) {
                property.setDefaultValue(defaultAtr.getAttributeValue());
            }

            propertyList.add(property);
        }
        return propertyList;
    }

}

/*
 * Copyright 2015 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__ARBITRARY_ATTRIBUTES;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__CORRELATION_ATTRIBUTES;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__EVENT_SINK;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__META_ATTRIBUTES;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__PAYLOAD_ATTRIBUTES;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__STREAM_NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__STREAM_VERSION;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.mediators.AbstractMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.carbon.mediator.publishevent.Property;
import org.wso2.developerstudio.eclipse.gmf.esb.AttributeType;
import org.wso2.developerstudio.eclipse.gmf.esb.AttributeValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediatorAttribute;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public class PublishEventMediatorDeserializer extends
		AbstractEsbNodeDeserializer<AbstractMediator, PublishEventMediator> {

	@Override
	public PublishEventMediator createNode(IGraphicalEditPart part, AbstractMediator object) {
		Assert.isTrue(object instanceof org.wso2.carbon.mediator.publishevent.PublishEventMediator,
				"Unsupported mediator passed in for deserialization");
		org.wso2.carbon.mediator.publishevent.PublishEventMediator mediator = (org.wso2.carbon.mediator.publishevent.PublishEventMediator) object;

		PublishEventMediator mediatorModel = (PublishEventMediator) DeserializerUtils.createNode(part,
				EsbElementTypes.PublishEventMediator_3785);
		setElementToEdit(mediatorModel);
		setCommonProperties(mediator, mediatorModel);

		executeSetValueCommand(PUBLISH_EVENT_MEDIATOR__STREAM_NAME, mediator.getStreamName());
		executeSetValueCommand(PUBLISH_EVENT_MEDIATOR__STREAM_VERSION, mediator.getStreamVersion());
		executeSetValueCommand(PUBLISH_EVENT_MEDIATOR__EVENT_SINK, mediator.getEventSinkName());

		// Meta attributes
		EList<PublishEventMediatorAttribute> metaAttributesList = new BasicEList<PublishEventMediatorAttribute>();
		for (Property metaProperty : mediator.getMetaProperties()) {
			PublishEventMediatorAttribute metaAttribute = EsbFactory.eINSTANCE.createPublishEventMediatorAttribute();

			if (StringUtils.isNotEmpty(metaProperty.getKey())) {
				metaAttribute.setAttributeName(metaProperty.getKey());
			}
			if (StringUtils.isNotEmpty(metaProperty.getType())) {
				metaAttribute.setAttributeType(AttributeType.getByName(metaProperty.getType()));
			}
			
			metaAttribute.setDefaultValue(metaProperty.getDefaultValue());
			
			if (metaProperty.getValue() != null) {
				metaAttribute.setAttributeValueType(AttributeValueType.VALUE);
				metaAttribute.setAttributeValue(metaProperty.getValue());
				
			} else if (metaProperty.getExpression() != null) {
				metaAttribute.setAttributeValueType(AttributeValueType.EXPRESSION);
				SynapsePath xpath = metaProperty.getExpression();
				NamespacedProperty namespacedProperty = createNamespacedProperty(xpath);

				metaAttribute.setAttributeExpression(namespacedProperty);
			}

			metaAttributesList.add(metaAttribute);
		}
		executeSetValueCommand(PUBLISH_EVENT_MEDIATOR__META_ATTRIBUTES, metaAttributesList);

		// Correlation attributes
		EList<PublishEventMediatorAttribute> correlationAttributesList = new BasicEList<PublishEventMediatorAttribute>();
		for (Property correlationProperty : mediator.getCorrelationProperties()) {
			PublishEventMediatorAttribute correlationAttribute = EsbFactory.eINSTANCE
					.createPublishEventMediatorAttribute();

			if (StringUtils.isNotEmpty(correlationProperty.getKey())) {
				correlationAttribute.setAttributeName(correlationProperty.getKey());
			}
			if (StringUtils.isNotEmpty(correlationProperty.getType())) {
				correlationAttribute.setAttributeType(AttributeType.getByName(correlationProperty.getType()));
			}
			
			correlationAttribute.setDefaultValue(correlationProperty.getDefaultValue());
			
			if (correlationProperty.getValue() != null) {
				correlationAttribute.setAttributeValueType(AttributeValueType.VALUE);
				correlationAttribute.setAttributeValue(correlationProperty.getValue());
			} else if (correlationProperty.getExpression() != null) {
				correlationAttribute.setAttributeValueType(AttributeValueType.EXPRESSION);
				SynapsePath xpath = correlationProperty.getExpression();
				NamespacedProperty namespacedProperty = createNamespacedProperty(xpath);

				correlationAttribute.setAttributeExpression(namespacedProperty);
			}

			correlationAttributesList.add(correlationAttribute);
		}
		executeSetValueCommand(PUBLISH_EVENT_MEDIATOR__CORRELATION_ATTRIBUTES, correlationAttributesList);

		// Payload attributes
		EList<PublishEventMediatorAttribute> payloadAttributesList = new BasicEList<PublishEventMediatorAttribute>();
		for (Property payloadProperty : mediator.getPayloadProperties()) {
			PublishEventMediatorAttribute payloadAttribute = EsbFactory.eINSTANCE.createPublishEventMediatorAttribute();

			if (StringUtils.isNotEmpty(payloadProperty.getKey())) {
				payloadAttribute.setAttributeName(payloadProperty.getKey());
			}
			if (StringUtils.isNotEmpty(payloadProperty.getType())) {
				payloadAttribute.setAttributeType(AttributeType.getByName(payloadProperty.getType()));
			}
			
			payloadAttribute.setDefaultValue(payloadProperty.getDefaultValue());
			
			if (payloadProperty.getValue() != null) {
				payloadAttribute.setAttributeValueType(AttributeValueType.VALUE);
				payloadAttribute.setAttributeValue(payloadProperty.getValue());
			} else if (payloadProperty.getExpression() != null) {
				payloadAttribute.setAttributeValueType(AttributeValueType.EXPRESSION);
				SynapsePath xpath = payloadProperty.getExpression();
				NamespacedProperty namespacedProperty = createNamespacedProperty(xpath);

				payloadAttribute.setAttributeExpression(namespacedProperty);
			}

			payloadAttributesList.add(payloadAttribute);
		}
		executeSetValueCommand(PUBLISH_EVENT_MEDIATOR__PAYLOAD_ATTRIBUTES, payloadAttributesList);

		// Arbitrary attributes
		EList<PublishEventMediatorAttribute> arbitraryAttributesList = new BasicEList<PublishEventMediatorAttribute>();
		for (Property arbitraryProperty : mediator.getArbitraryProperties()) {
			PublishEventMediatorAttribute arbitraryAttribute = EsbFactory.eINSTANCE
					.createPublishEventMediatorAttribute();

			if (StringUtils.isNotEmpty(arbitraryProperty.getKey())) {
				arbitraryAttribute.setAttributeName(arbitraryProperty.getKey());
			}
			if (StringUtils.isNotEmpty(arbitraryProperty.getType())) {
				arbitraryAttribute.setAttributeType(AttributeType.getByName(arbitraryProperty.getType()));
			}
			
			arbitraryAttribute.setDefaultValue(arbitraryProperty.getDefaultValue());
			
			if (arbitraryProperty.getValue() != null) {
				arbitraryAttribute.setAttributeValueType(AttributeValueType.VALUE);
				arbitraryAttribute.setAttributeValue(arbitraryProperty.getValue());
			} else if (arbitraryProperty.getExpression() != null) {
				arbitraryAttribute.setAttributeValueType(AttributeValueType.EXPRESSION);
				SynapsePath xpath = arbitraryProperty.getExpression();
				NamespacedProperty namespacedProperty = createNamespacedProperty(xpath);

				arbitraryAttribute.setAttributeExpression(namespacedProperty);
			}

			arbitraryAttributesList.add(arbitraryAttribute);
		}
		executeSetValueCommand(PUBLISH_EVENT_MEDIATOR__ARBITRARY_ATTRIBUTES, arbitraryAttributesList);

		return mediatorModel;
	}

}

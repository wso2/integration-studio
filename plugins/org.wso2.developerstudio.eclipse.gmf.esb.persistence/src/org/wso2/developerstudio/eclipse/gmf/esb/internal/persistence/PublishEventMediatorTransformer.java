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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseJsonPath;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.carbon.mediator.publishevent.Property;
import org.wso2.developerstudio.eclipse.gmf.esb.AttributeValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediatorAttribute;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.CustomSynapsePathFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

/**
 * {@link EsbNodeTransformer} responsible for transforming
 * {@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator} model
 * objects into corresponding synapse artifact(s).
 */
public class PublishEventMediatorTransformer extends AbstractEsbNodeTransformer {
	/**
	 * {@inheritDoc}
	 */
	public void transform(TransformationInfo info, EsbNode subject) throws TransformerException {
		// Check subject.
		Assert.isTrue(subject instanceof PublishEventMediator, "Invalid subject.");
		PublishEventMediator visualPublishEvent = (PublishEventMediator) subject;

		try {
			info.getParentSequence().addChild(createPublishEventMediator(visualPublishEvent));
			// Transform the publishEvent mediator output data flow path.
			doTransform(info, visualPublishEvent.getOutputconnector());
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	/**
	 * @param visualPublishEvent
	 * @return org.wso2.carbon.mediator.publishevent.PublishEventMediator
	 * @throws JaxenException
	 */
	private org.wso2.carbon.mediator.publishevent.PublishEventMediator createPublishEventMediator(
			PublishEventMediator visualPublishEvent) throws JaxenException {
		org.wso2.carbon.mediator.publishevent.PublishEventMediator publishEventMediator = new org.wso2.carbon.mediator.publishevent.PublishEventMediator();
		setCommonProperties(publishEventMediator, visualPublishEvent);
		{
			// PublishEvent stream name
			if (StringUtils.isNotBlank(visualPublishEvent.getStreamName())) {
				publishEventMediator.setStreamName(visualPublishEvent.getStreamName());
			}
			// PublishEvent stream version
			if (StringUtils.isNotBlank(visualPublishEvent.getStreamVersion())) {
				publishEventMediator.setStreamVersion(visualPublishEvent.getStreamVersion());
			}
			// PublishEvent event sink name
			if (StringUtils.isNotBlank(visualPublishEvent.getEventSink())) {
				publishEventMediator.setEventSinkName(visualPublishEvent.getEventSink());
			}
			// PublishEvent event attributes
			publishEventMediator.setMetaProperties(getVisualAttributes(visualPublishEvent.getMetaAttributes()));
			publishEventMediator.setCorrelationProperties(getVisualAttributes(visualPublishEvent.getCorrelationAttributes()));
			publishEventMediator.setPayloadProperties(getVisualAttributes(visualPublishEvent.getPayloadAttributes()));
			publishEventMediator.setArbitraryProperties(getVisualAttributes(visualPublishEvent.getArbitraryAttributes()));
		}
		return publishEventMediator;
	}

	private List<Property> getVisualAttributes(EList<PublishEventMediatorAttribute> visualAttributes)
			throws JaxenException {
		List<Property> attributesList = new ArrayList<Property>();
		for (PublishEventMediatorAttribute visualAttribute : visualAttributes) {
			Property attribute = new Property();

			if (StringUtils.isNotEmpty(visualAttribute.getAttributeName())) {
				attribute.setKey(visualAttribute.getAttributeName());
			}
			if (visualAttribute.getAttributeValueType().getLiteral().equals(AttributeValueType.VALUE.getLiteral())) {
				attribute.setValue(visualAttribute.getAttributeValue());
			}
			if (StringUtils.isNotEmpty(visualAttribute.getAttributeType().getLiteral())) {
				attribute.setType(visualAttribute.getAttributeType().getLiteral());
			}
			if (visualAttribute.getAttributeValueType().getLiteral().equals(AttributeValueType.EXPRESSION.getLiteral())) {
				// ESB supports only STRING for attribute type, hence value is set to STRING at any given time
				NamespacedProperty namespacedExpression = visualAttribute.getAttributeExpression();
				if (namespacedExpression != null) {
					SynapsePath propertyExpression = CustomSynapsePathFactory.getSynapsePath(namespacedExpression
							.getPropertyValue());
					if (namespacedExpression.getNamespaces() != null
							&& !(propertyExpression instanceof SynapseJsonPath)) {
						for (Entry<String, String> entry : namespacedExpression.getNamespaces().entrySet()) {
							propertyExpression.addNamespace(entry.getKey(), entry.getValue());
						}
					}
					attribute.setExpression((SynapseXPath) propertyExpression);
				}
			}
			attribute.setDefaultValue(visualAttribute.getDefaultValue());
			attributesList.add(attribute);
		}
		return attributesList;
	}

	public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints) {
		// TODO Auto-generated method stub
	}

	public void transformWithinSequence(TransformationInfo info, EsbNode subject, SequenceMediator sequence)
			throws TransformerException {
		// Check subject
		Assert.isTrue(subject instanceof PublishEventMediator, "Invalid subject.");
		PublishEventMediator visualPublishEvent = (PublishEventMediator) subject;

		try {
			sequence.addChild(createPublishEventMediator(visualPublishEvent));
			doTransformWithinSequence(info, visualPublishEvent.getOutputconnector().getOutgoingLink(), sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}		
	}
}

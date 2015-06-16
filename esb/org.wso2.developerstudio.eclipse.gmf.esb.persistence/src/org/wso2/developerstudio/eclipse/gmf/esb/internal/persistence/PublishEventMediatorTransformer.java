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

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventAttributes;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediatorAttribute;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

/**
 * {@link EsbNodeTransformer} responsible for transforming
 * {@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator} model objects into
 * corresponding synapse artifact(s).
 */
public class PublishEventMediatorTransformer extends AbstractEsbNodeTransformer {
	/**
	 * {@inheritDoc}
	 */
	public void transform(TransformationInfo info, EsbNode subject) throws Exception {
		// Check subject.
		Assert.isTrue(subject instanceof PublishEventMediator, "Invalid subject.");
		PublishEventMediator visualPublishEvent = (PublishEventMediator) subject;
		
		info.getParentSequence().addChild(createPublishEventMediator(visualPublishEvent));
		
		// Transform the publishEvent mediator output data flow path.
		doTransform(info, visualPublishEvent.getOutputconnector());
	}

	/**
	 * @param visualPublishEvent
	 * @return org.wso2.carbon.mediator.publishevent.PublishEventMediator
	 * @throws JaxenException
	 */
	private org.wso2.carbon.mediator.publishevent.PublishEventMediator createPublishEventMediator(PublishEventMediator visualPublishEvent)
			throws JaxenException {
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

			EList<PublishEventMediatorAttribute> attributes = visualPublishEvent.getMetaAttributes();
			EList<PublishEventMediatorAttribute> attributes2 = visualPublishEvent.getCorrelationAttributes();
			EList<PublishEventMediatorAttribute> attributes3 = visualPublishEvent.getPayloadAttributes();
			EList<PublishEventMediatorAttribute> attributes4 = visualPublishEvent.getArbitraryAttributes();
			
			// PublishEvent attributes
			/*for (PublishEventProperty visualProperty : visualPublishEvent.getAttributes()) {
				MediatorProperty mediatorProperty = new MediatorProperty();
				mediatorProperty.setName(visualProperty.getPropertyName());
				
				if(visualProperty.getPropertyValueType().getLiteral().equals("LITERAL")){
					mediatorProperty.setValue(visualProperty.getPropertyValue());
				}
				if (visualProperty.getPropertyValueType().getLiteral().equals("EXPRESSION")) {
					NamespacedProperty namespacedExpression = visualProperty
							.getPropertyExpression();
					if (namespacedExpression != null) {
						SynapsePath propertyExpression = CustomSynapsePathFactory
								.getSynapsePath(namespacedExpression.getPropertyValue());
						if (namespacedExpression.getNamespaces() != null
								&& !(propertyExpression instanceof SynapseJsonPath)) {
							for (Entry<String, String> entry : namespacedExpression.getNamespaces()
									.entrySet()) {
								propertyExpression.addNamespace(entry.getKey(), entry.getValue());
							}
						}

						mediatorProperty.setExpression(propertyExpression);
					}
				}
				publishEventMediator.addProperty(mediatorProperty);
			}*/
		}
		return publishEventMediator;
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// TODO Auto-generated method stub
		
	}
	
	public void transformWithinSequence(TransformationInfo info, EsbNode subject, SequenceMediator sequence) throws Exception{
		// Check subject.
		Assert.isTrue(subject instanceof PublishEventMediator, "Invalid subject.");
		PublishEventMediator visualPublishEvent = (PublishEventMediator) subject;
		
		sequence.addChild(createPublishEventMediator(visualPublishEvent));
		doTransformWithinSequence(info, visualPublishEvent.getOutputconnector().getOutgoingLink(),sequence);
	}
}

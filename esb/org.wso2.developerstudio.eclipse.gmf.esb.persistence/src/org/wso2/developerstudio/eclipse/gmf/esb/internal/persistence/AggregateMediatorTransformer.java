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
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.CompletionMessagesType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class AggregateMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {
		
		try {
			information.getParentSequence().addChild(
					createAggregateMediator(information, subject));			
			/*
			 * Transform the property mediator output data flow path.
			 */
			doTransform(information,
					((AggregateMediator) subject).getOutputConnector());
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {

	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
			throws TransformerException {
		List<EsbNode> transformedMediators = information.getTransformedMediators();
		/* check whether subject transformed by different input link */
		if (transformedMediators.contains(subject))
			return;

		try {
			sequence.addChild(createAggregateMediator(information, subject));
			transformedMediators.add(subject);
			doTransformWithinSequence(information, ((AggregateMediator) subject).getOutputConnector().getOutgoingLink(),
					sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	private org.apache.synapse.mediators.eip.aggregator.AggregateMediator createAggregateMediator(
			TransformationInfo information, EsbNode subject) throws TransformerException, JaxenException{
		/*
		 * Check subject.
		 */
		Assert.isTrue(subject instanceof AggregateMediator, "Invalid subject.");
		AggregateMediator visualAggregate = (AggregateMediator) subject;

		/*
		 * Configure property mediator.
		 */
		org.apache.synapse.mediators.eip.aggregator.AggregateMediator aggregateMediator = new org.apache.synapse.mediators.eip.aggregator.AggregateMediator();
		setCommonProperties(aggregateMediator, visualAggregate);
		{
			aggregateMediator.setCompletionTimeoutMillis(visualAggregate.getCompletionTimeout()*1000 );
			
			if(visualAggregate.getCompletionMinMessagesType().equals(CompletionMessagesType.VALUE)){
				
				String valueString  = Integer.toString(visualAggregate.getCompletionMinMessagesValue());
				Value minMsgValue  = new Value(valueString);
				
				aggregateMediator.setMinMessagesToComplete(minMsgValue);
				
			}else if(visualAggregate.getCompletionMinMessagesType().equals(CompletionMessagesType.EXPRESSION)){
				
				if (visualAggregate.getCompletionMinMessagesExpression() != null
						&& visualAggregate.getCompletionMinMessagesExpression() != null) {

					NamespacedProperty minMsgExp = visualAggregate
							.getCompletionMinMessagesExpression();
					SynapseXPath xpath = new SynapseXPath(
							minMsgExp.getPropertyValue());

					for (Entry<String, String> entry : minMsgExp
							.getNamespaces().entrySet()) {
						xpath.addNamespace(entry.getKey(), entry.getValue());
					}
					Value minMsgValue = new Value(xpath);
					
					aggregateMediator.setMinMessagesToComplete(minMsgValue);
				}
				
			}
			
			if(visualAggregate.getCompletionMaxMessagesType().equals(CompletionMessagesType.VALUE)){
				
				String valueString  = Integer.toString(visualAggregate.getCompletionMaxMessagesValue());
				Value minMsgValue  = new Value(valueString);
				
				aggregateMediator.setMaxMessagesToComplete(minMsgValue);
				
			}else if(visualAggregate.getCompletionMaxMessagesType().equals(CompletionMessagesType.EXPRESSION)){
				
				if (visualAggregate.getCompletionMaxMessagesExpression() != null
						&& visualAggregate.getCompletionMaxMessagesExpression() != null) {

					NamespacedProperty minMsgExp = visualAggregate
							.getCompletionMaxMessagesExpression();
					SynapseXPath xpath = new SynapseXPath(
							minMsgExp.getPropertyValue());

					for (Entry<String, String> entry : minMsgExp
							.getNamespaces().entrySet()) {
						xpath.addNamespace(entry.getKey(), entry.getValue());
					}
					Value minMsgValue = new Value(xpath);
					
					aggregateMediator.setMaxMessagesToComplete(minMsgValue);
				}
				
			}
			
			if (StringUtils.isNotBlank(visualAggregate.getAggregateID())) {
				aggregateMediator.setId(visualAggregate.getAggregateID());
			}
			
			if (visualAggregate.getCorrelationExpression() != null
					&& visualAggregate.getCorrelationExpression()
							.getPropertyValue() != null
					&& !visualAggregate.getCorrelationExpression()
							.getPropertyValue().equals("")) {
				SynapseXPath correlationExpression = new SynapseXPath(visualAggregate
						.getCorrelationExpression().getPropertyValue());
				for(int i=0;i<visualAggregate.getCorrelationExpression().getNamespaces().keySet().size();++i){				
					String prefix=(String)visualAggregate.getCorrelationExpression().getNamespaces().keySet().toArray()[i];
					String namespaceUri=visualAggregate.getCorrelationExpression().getNamespaces().get(prefix);
					correlationExpression.addNamespace(prefix, namespaceUri);
				}
				
				aggregateMediator.setCorrelateExpression(correlationExpression);
			}
			SynapseXPath aggregateExpression = new SynapseXPath(visualAggregate.getAggregationExpression()
					.getPropertyValue());
			for (int i = 0; i < visualAggregate.
					getAggregationExpression().getNamespaces().keySet().size(); ++i) {
				String prefix = (String) visualAggregate
						.getAggregationExpression().getNamespaces().keySet()
						.toArray()[i];
				String namespaceUri = visualAggregate
						.getAggregationExpression()
						.getNamespaces()
						.get(prefix);
				aggregateExpression.addNamespace(prefix, namespaceUri);
			}

			aggregateMediator.setAggregationExpression(aggregateExpression);

			if (visualAggregate.getSequenceType().equals(AggregateSequenceType.REGISTRY_REFERENCE)) {
				aggregateMediator.setOnCompleteSequenceRef(visualAggregate.getSequenceKey()
						.getKeyValue());
			} else {
				/*
				 * onComplete
				 */
				SequenceMediator onCompleteSequence = new SequenceMediator();

				TransformationInfo newOnCompleteInfo = new TransformationInfo();
				newOnCompleteInfo.setTraversalDirection(information.getTraversalDirection());
				newOnCompleteInfo.setSynapseConfiguration(information.getSynapseConfiguration());
				newOnCompleteInfo.setOriginInSequence(information.getOriginInSequence());
				newOnCompleteInfo.setOriginOutSequence(information.getOriginOutSequence());
				newOnCompleteInfo.setCurrentProxy(information.getCurrentProxy());
				newOnCompleteInfo.setParentSequence(onCompleteSequence);
				doTransform(newOnCompleteInfo, visualAggregate.getOnCompleteOutputConnector());

				aggregateMediator.setOnCompleteSequence(onCompleteSequence);
			}
			
			if (StringUtils.isNotBlank(visualAggregate.getEnclosingElementProperty())) {
				aggregateMediator.setEnclosingElementPropertyName(visualAggregate
						.getEnclosingElementProperty());
			}
		}
		return aggregateMediator;
	}

}

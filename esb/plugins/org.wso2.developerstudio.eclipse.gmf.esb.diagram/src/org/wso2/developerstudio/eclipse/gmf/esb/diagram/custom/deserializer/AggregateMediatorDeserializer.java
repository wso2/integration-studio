/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.CompletionMessagesType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class AggregateMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, AggregateMediator> {
	
	@Override
	public AggregateMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {
		
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.eip.aggregator.AggregateMediator, "Invalid Mediator.");
		
		org.apache.synapse.mediators.eip.aggregator.AggregateMediator aggregateMediator = (org.apache.synapse.mediators.eip.aggregator.AggregateMediator) mediator;
		
		org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator visualAggregateMediator = (org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator) DeserializerUtils.createNode(part, EsbElementTypes.AggregateMediator_3525); 
		setElementToEdit(visualAggregateMediator);
		setCommonProperties(aggregateMediator, visualAggregateMediator);
		
		refreshEditPartMap();
		EditPart mediatorFlow=getEditpart(visualAggregateMediator.getMediatorFlow());
		
		//AggregateMediator vishualAggrigate = EsbFactory.eINSTANCE.createAggregateMediator();
		
		//Setting aggregate ID
		if(aggregateMediator.getId() != null && !aggregateMediator.getId().equals("")){
			
			//vishualAggrigate.setAggregateID(aggregateMediator.getId());
			executeSetValueCommand(AGGREGATE_MEDIATOR__AGGREGATE_ID, aggregateMediator.getId());
		}
		
		//Setting completion timeout
		//vishualAggrigate.setCompletionTimeout(aggregateMediator.getCompletionTimeoutMillis());
		executeSetValueCommand(AGGREGATE_MEDIATOR__COMPLETION_TIMEOUT, (aggregateMediator.getCompletionTimeoutMillis()/1000));
		
		//Setting aggregate expression.
		if(aggregateMediator.getAggregationExpression() != null){
			
			SynapseXPath xpath  = aggregateMediator.getAggregationExpression();
			
			NamespacedProperty nsp = EsbFactory.eINSTANCE.createNamespacedProperty();
			
			nsp.setPropertyValue(xpath.toString());
			
			if (xpath.getNamespaces() != null) {

				@SuppressWarnings("unchecked")
				Map<String, String> map = xpath.getNamespaces();

				nsp.setNamespaces(map);
			}
			
			//vishualAggrigate.setAggregationExpression(nsp);
			executeSetValueCommand(AGGREGATE_MEDIATOR__AGGREGATION_EXPRESSION, nsp);
			
		}
		
		if(aggregateMediator.getMaxMessagesToComplete() != null){
			
			Value maxMsg = aggregateMediator.getMaxMessagesToComplete();
			
			if(maxMsg.getKeyValue() != null && DeserializerUtils.isInteger(maxMsg.getKeyValue()) ){
				
				//vishualAggrigate.setCompletionMaxMessagesType(CompletionMessagesType.VALUE);
				executeSetValueCommand(AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_TYPE, CompletionMessagesType.VALUE);
				
				//vishualAggrigate.setCompletionMaxMessagesValue(Integer.parseInt(maxMsg.getKeyValue()));
				executeSetValueCommand(AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_VALUE, Integer.parseInt(maxMsg.getKeyValue()));
				
			}else if(maxMsg.getExpression() != null){
				
				//vishualAggrigate.setCompletionMaxMessagesType(CompletionMessagesType.EXPRESSION);
				executeSetValueCommand(AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES_TYPE, CompletionMessagesType.EXPRESSION);
				
				SynapsePath xpath = maxMsg.getExpression();
				
				NamespacedProperty nsp = EsbFactory.eINSTANCE.createNamespacedProperty();
				
				nsp.setPropertyValue(xpath.toString());
				
				if (xpath.getNamespaces() != null) {

					@SuppressWarnings("unchecked")
					Map<String, String> map = xpath.getNamespaces();

					nsp.setNamespaces(map);
				}
				
				//vishualAggrigate.setCompletionMinMessagesExpression(nsp);
				executeSetValueCommand(AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_EXPRESSION, nsp);
				
			}
		}
		
		if(aggregateMediator.getMinMessagesToComplete() != null){
			
			Value minMsg = aggregateMediator.getMinMessagesToComplete();
			
			if(minMsg.getKeyValue() != null && DeserializerUtils.isInteger(minMsg.getKeyValue())){
				
				//vishualAggrigate.setCompletionMinMessagesType(CompletionMessagesType.VALUE);
				executeSetValueCommand(AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_TYPE, CompletionMessagesType.VALUE);
				
				//vishualAggrigate.setCompletionMinMessagesValue(Integer.parseInt(minMsg.getKeyValue()));
				executeSetValueCommand(AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_VALUE, Integer.parseInt(minMsg.getKeyValue()));
				
			}else if(minMsg.getExpression() != null){
				
				//vishualAggrigate.setCompletionMinMessagesType(CompletionMessagesType.EXPRESSION);
				executeSetValueCommand(AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_TYPE, CompletionMessagesType.EXPRESSION);
				
				SynapsePath xpath = minMsg.getExpression();
				
				NamespacedProperty nsp = EsbFactory.eINSTANCE.createNamespacedProperty();
				
				nsp.setPropertyValue(xpath.toString());
				
				if (xpath.getNamespaces() != null) {

					@SuppressWarnings("unchecked")
					Map<String, String> map = xpath.getNamespaces();

					nsp.setNamespaces(map);
				}
				
				//vishualAggrigate.setCompletionMinMessagesExpression(nsp);
				executeSetValueCommand(AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES_EXPRESSION, nsp);
				
			}
		}
		
		if(aggregateMediator.getCorrelateExpression() != null){
			
			SynapseXPath xpath = aggregateMediator.getCorrelateExpression();
			
			NamespacedProperty nsp = EsbFactory.eINSTANCE.createNamespacedProperty();
			
			nsp.setPropertyValue(xpath.toString());
			
			if (xpath.getNamespaces() != null) {

				@SuppressWarnings("unchecked")
				Map<String, String> map = xpath.getNamespaces();

				nsp.setNamespaces(map);
			}
			
			//vishualAggrigate.setCorrelationExpression(nsp);
			executeSetValueCommand(AGGREGATE_MEDIATOR__CORRELATION_EXPRESSION, nsp);
			
		}
		
		if(aggregateMediator.getOnCompleteSequenceRef() != null){
			
			//vishualAggrigate.setSequenceType(AggregateSequenceType.REGISTRY_REFERENCE);
			executeSetValueCommand(AGGREGATE_MEDIATOR__SEQUENCE_TYPE, AggregateSequenceType.REGISTRY_REFERENCE);
			
			RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
			regkey.setKeyValue(aggregateMediator.getOnCompleteSequenceRef());
			
			//vishualAggrigate.setSequenceKey(regkey);
			executeSetValueCommand(AGGREGATE_MEDIATOR__SEQUENCE_KEY, regkey);
			
		}else if(aggregateMediator.getOnCompleteSequence() != null){
			
			//vishualAggrigate.setSequenceType(AggregateSequenceType.ANONYMOUS);
			executeSetValueCommand(AGGREGATE_MEDIATOR__SEQUENCE_TYPE, AggregateSequenceType.ANONYMOUS);
			
			deserializeSequence((IGraphicalEditPart) mediatorFlow.getChildren().get(0),
					aggregateMediator.getOnCompleteSequence(),
					visualAggregateMediator.getOnCompleteOutputConnector());
			
		}
		
		//Setting Enclosing Element Property 
		if (StringUtils.isNotBlank(aggregateMediator.getEnclosingElementPropertyName())) {
			executeSetValueCommand(AGGREGATE_MEDIATOR__ENCLOSING_ELEMENT_PROPERTY,
					aggregateMediator.getEnclosingElementPropertyName());
		}
		
		return visualAggregateMediator;
		
		
	}

}

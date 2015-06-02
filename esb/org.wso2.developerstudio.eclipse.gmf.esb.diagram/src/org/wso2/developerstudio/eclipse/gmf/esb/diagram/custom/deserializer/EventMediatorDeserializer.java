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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EventTopicType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class EventMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, EventMediator> {

	public EventMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {
		
		Assert.isTrue(mediator instanceof org.wso2.carbon.mediator.event.EventMediator, "Unsupported mediator passed in for deserialization at "+ this.getClass());
		
		org.wso2.carbon.mediator.event.EventMediator eventMediator = (org.wso2.carbon.mediator.event.EventMediator)mediator;
		
		org.wso2.developerstudio.eclipse.gmf.esb.EventMediator VisualEventMediator = (org.wso2.developerstudio.eclipse.gmf.esb.EventMediator) DeserializerUtils.createNode(part, EsbElementTypes.EventMediator_3504);
		setElementToEdit(VisualEventMediator);
		setCommonProperties(eventMediator, VisualEventMediator);
		
		//EventMediator vishualEvent = EsbFactory.eINSTANCE.createEventMediator();
		
		Value topic  = eventMediator.getTopic();
		
		if (topic != null) {
			//For static topic type.
			if(StringUtils.isNotBlank(topic.getKeyValue())){
				
				//vishualEvent.setTopicType(EventTopicType.STATIC);
				executeSetValueCommand(EVENT_MEDIATOR__TOPIC_TYPE, EventTopicType.STATIC);
				
				//vishualEvent.setStaticTopic(topic.getKeyValue());
				executeSetValueCommand(EVENT_MEDIATOR__STATIC_TOPIC, topic.getKeyValue());
			}
			
			//For dynamic topic type.
			if(topic.getExpression() != null){
				
				//vishualEvent.setTopicType(EventTopicType.DYNAMIC);
				executeSetValueCommand(EVENT_MEDIATOR__TOPIC_TYPE, EventTopicType.DYNAMIC);
				
				SynapsePath xpath  = topic.getExpression();
				
				NamespacedProperty nsp = EsbFactory.eINSTANCE.createNamespacedProperty();
				
				if (xpath.getNamespaces() != null) {

					@SuppressWarnings("unchecked")
					Map<String, String> map = xpath.getNamespaces();

					nsp.setNamespaces(map);
				}
				
				nsp.setPropertyValue(xpath.toString());
				
				//vishualEvent.setDynamicTopic(nsp);
				executeSetValueCommand(EVENT_MEDIATOR__DYNAMIC_TOPIC, nsp);				
			}
		}
		
		//For event Expression.
		if(eventMediator.getExpression() != null){
			
			SynapseXPath xpath  = eventMediator.getExpression();
			
			NamespacedProperty nsp = EsbFactory.eINSTANCE.createNamespacedProperty();
			
			if (xpath.getNamespaces() != null) {

				@SuppressWarnings("unchecked")
				Map<String, String> map = xpath.getNamespaces();

				nsp.setNamespaces(map);
			}
			
			nsp.setPropertyValue(xpath.toString());
			
			//vishualEvent.setEventExpression(nsp);
			executeSetValueCommand(EVENT_MEDIATOR__EVENT_EXPRESSION, nsp);
		}
		
		return VisualEventMediator;
	}

}

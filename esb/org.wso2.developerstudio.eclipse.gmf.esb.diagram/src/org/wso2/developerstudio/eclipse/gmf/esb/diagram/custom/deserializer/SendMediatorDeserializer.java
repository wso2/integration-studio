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

import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
//import org.wso2.developerstudio.eclipse.gmf.esb.AddressingEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.ReceivingSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class SendMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, SendMediator> {

	public SendMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {
		
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.builtin.SendMediator, "Unsupported mediator passed in for deserialization at "+ this.getClass());
		
		org.apache.synapse.mediators.builtin.SendMediator sendMediator = (org.apache.synapse.mediators.builtin.SendMediator)mediator;
		
		org.wso2.developerstudio.eclipse.gmf.esb.SendMediator visualSendMediator = (org.wso2.developerstudio.eclipse.gmf.esb.SendMediator) DeserializerUtils.createNode(part, EsbElementTypes.SendMediator_3515);
		setElementToEdit(visualSendMediator);
		setCommonProperties(sendMediator, visualSendMediator);
		
		refreshEditPartMap();
		EditPart mediatorFlow=getEditpart(visualSendMediator.getMediatorFlow());
		
		//SendMediator vishualSend  = EsbFactory.eINSTANCE.createSendMediator();
		
		if(sendMediator.getReceivingSequence() != null){
			
			Value receivingSequenceValue = sendMediator.getReceivingSequence();
		
			//For Static sequence type.
			if(receivingSequenceValue.getKeyValue() != null){
				
				//vishualSend.setReceivingSequenceType(ReceivingSequenceType.STATIC);
				executeSetValueCommand(SEND_MEDIATOR__RECEIVING_SEQUENCE_TYPE, ReceivingSequenceType.STATIC);
				
				RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				regkey.setKeyValue(receivingSequenceValue.getKeyValue());
				
				//vishualSend.setStaticReceivingSequence(regkey);
				executeSetValueCommand(SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE, regkey);
				
			}
			
			//For Dynamic sequence type.
			if(receivingSequenceValue.getExpression() != null){

				executeSetValueCommand(SEND_MEDIATOR__RECEIVING_SEQUENCE_TYPE,ReceivingSequenceType.DYNAMIC);
				
				SynapsePath xpath  = receivingSequenceValue.getExpression();
				executeSetValueCommand(SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE,createNamespacedProperty(xpath));
			}
		}
		
		Endpoint endpoint = sendMediator.getEndpoint();
		if(endpoint!=null){
			@SuppressWarnings("rawtypes")
			IEsbNodeDeserializer deserializer = EsbDeserializerRegistry.getInstance().getDeserializer(endpoint);
			@SuppressWarnings("unchecked")
			//EndPoint visualEndPoint = (EndPoint) deserializer.createNode(getRootCompartment(), endpoint);
			EndPoint visualEndPoint = (EndPoint) deserializer.createNode((IGraphicalEditPart) mediatorFlow.getChildren().get(0), endpoint);
			if(isReversed()){
				executeSetValueCommand(visualEndPoint,END_POINT__REVERSED,true);
			}
			visualSendMediator.setNextNode(visualEndPoint);
			
		} /*safe to remove : not valid in current implementation/UI*/ 
		/*	else if (!(isReversed() || hasInlineEndPoint() || isAddedAddressingEndPoint())){
			AddressingEndpoint visualEndPoint = (AddressingEndpoint) DeserializerUtils.createNode(
					(IGraphicalEditPart) mediatorFlow.getChildren().get(0), EsbElementTypes.AddressingEndpoint_3689);
			if(isReversed()){
				executeSetValueCommand(visualEndPoint,END_POINT__REVERSED,true);
			}
			visualSendMediator.setNextNode(visualEndPoint);
			setAddedAddressingEndPoint(true);
			refreshEditPartMap();
		}*/
			
		executeSetValueCommand(SEND_MEDIATOR__BUILD_MESSAGE_BEFORE_SENDING, sendMediator.isBuildMessage());
		
		return visualSendMediator;
	}
	
}

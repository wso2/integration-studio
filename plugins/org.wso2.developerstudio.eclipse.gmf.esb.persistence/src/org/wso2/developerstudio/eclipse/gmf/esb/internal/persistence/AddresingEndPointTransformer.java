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

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.builtin.SendMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.AddressingEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class AddresingEndPointTransformer extends AbstractEndpointTransformer{

	public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
		// Check subject.
		Assert.isTrue(subject instanceof EndPoint, "Invalid subject");
		AddressingEndpoint visualEP = (AddressingEndpoint) subject;

		// Send the message.
		SendMediator sendMediator = getSendMediator(information); //FIXME: unused variable
/*		if(visualEP.isInLine()){
			information.getCurrentProxy().setTargetInLineEndpoint(create(visualEP,null));
		}else{
			if(sendMediator !=null){
				sendMediator.setEndpoint(create(visualEP,null));
			}
		}*/
		
		if(!information.isEndPointFound){
			information.isEndPointFound=true;
			information.firstEndPoint=visualEP;
		}
		
		if(visualEP.getOutputConnector()!=null){
			if(visualEP.getOutputConnector().getOutgoingLink() !=null){
				InputConnector nextInputConnector=visualEP.getOutputConnector().getOutgoingLink().getTarget();
				if((!(nextInputConnector instanceof SequenceInputConnector))||
						((((Sequence)nextInputConnector.eContainer()).getOutputConnector().get(0).getOutgoingLink()!=null)&&(!(((Sequence)nextInputConnector.eContainer()).getOutputConnector().get(0).getOutgoingLink().getTarget().eContainer() instanceof EndPoint)))){
					information.setParentSequence(information.getOriginOutSequence());
					information.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_OUT);
				}else if(visualEP.getInputConnector().getIncomingLinks().get(0).getSource().eContainer() instanceof Sequence){
					information.setParentSequence(information.getCurrentReferredSequence());
				}
			}
		}

		List<EsbNode> transformedMediators = information.getTransformedMediators();
		if (visualEP.getOutputConnector() != null && visualEP.getOutputConnector().getOutgoingLink()!=null) {
			EsbNode nextElement = (EsbNode) visualEP.getOutputConnector().getOutgoingLink().getTarget().eContainer();
			if (transformedMediators.contains(nextElement)) {
				return;
			}
			transformedMediators.add(nextElement);
		}

		// Transform endpoint output data flow.
		// TODO: find out why this was commented out.
		// might want to check if the flow is connected back to initial proxy
		// service
		doTransform(information, visualEP.getOutputConnector());
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		
	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject,
			SequenceMediator sequence) throws TransformerException {
		
	}

}

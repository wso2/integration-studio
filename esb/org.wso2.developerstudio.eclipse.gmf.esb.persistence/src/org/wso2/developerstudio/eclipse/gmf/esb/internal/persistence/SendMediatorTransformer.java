/*
 * Copyright 2012-2015 WSO2, Inc. (http://wso2.com)
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

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class SendMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
		org.apache.synapse.mediators.builtin.SendMediator sendMediator;
		try {
			sendMediator = createSendMediator(subject);
			if (sendMediator != null) {
				information.getParentSequence().addChild(sendMediator);
			}
			TransformationInfo tmpInformation = new TransformationInfo();
			tmpInformation.setParentSequence(information.getParentSequence());
			tmpInformation.setTraversalDirection(information.getTraversalDirection());
			tmpInformation.setOriginInSequence(information.getOriginInSequence());
			tmpInformation.setOriginOutSequence(information.getOriginOutSequence());
			tmpInformation.setPreviousNode(information.getPreviouNode());
			tmpInformation.setSynapseConfiguration(information.getSynapseConfiguration());
			tmpInformation.setCurrentAPI(information.getCurrentAPI());
			tmpInformation.setCurrentProxy(information.getCurrentProxy());
			tmpInformation.setCurrentReferredSequence(information.getCurrentReferredSequence());
			tmpInformation.setMainSequence(information.getMainSequence());
			doTransform(tmpInformation, ((SendMediator) subject).getEndpointOutputConnector());
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// TODO Auto-generated method stub
		
	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
			throws TransformerException {
		org.apache.synapse.mediators.builtin.SendMediator sendMediator;
		try {
			sendMediator = createSendMediator(subject);
			if (sendMediator != null) {
				sequence.addChild(sendMediator);
			}
			doTransformWithinSequence(information, ((SendMediator) subject).getEndpointOutputConnector()
					.getOutgoingLink(), sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}
	
	private org.apache.synapse.mediators.builtin.SendMediator createSendMediator(EsbNode subject) throws JaxenException{
		// Check subject.
		Assert.isTrue(subject instanceof SendMediator, "Invalid subject.");
		SendMediator visualSend = (SendMediator) subject;
		
		if(visualSend.isSkipSerialization()){
			return null;
		}

		// Configure send mediator.
		org.apache.synapse.mediators.builtin.SendMediator sendMediator = new org.apache.synapse.mediators.builtin.SendMediator();
		setCommonProperties(sendMediator, visualSend);
		{
			if (visualSend.getReceivingSequenceType().getLiteral()
					.equals("Static")) {

				if (visualSend.getStaticReceivingSequence() != null
						&& visualSend.getStaticReceivingSequence()
								.getKeyValue() != null) {

					Value receivingSequence = new Value(visualSend
							.getStaticReceivingSequence().getKeyValue());
					sendMediator.setReceivingSequence(receivingSequence);
				}

			}

			if (visualSend.getReceivingSequenceType().getLiteral()
					.equals("Dynamic")) {

				if (visualSend.getDynamicReceivingSequence() != null
						&& visualSend.getDynamicReceivingSequence()
								.getPropertyValue() != null) {

					SynapseXPath expression = new SynapseXPath(visualSend
							.getDynamicReceivingSequence().getPropertyValue());

					if (visualSend.getDynamicReceivingSequence()
							.getNamespaces() != null) {

						Map<String, String> map = visualSend
								.getDynamicReceivingSequence().getNamespaces();
						Iterator<Map.Entry<String, String>> entries = map
								.entrySet().iterator();

						while (entries.hasNext()) {
							Map.Entry<String, String> entry = entries.next();
							expression.addNamespace(entry.getKey(),
									entry.getValue());
						}

						Value receivingSequence = new Value(expression);
						sendMediator.setReceivingSequence(receivingSequence);
					}
				}

			}
			
			if (visualSend.isBuildMessageBeforeSending()) {
				sendMediator.setBuildMessage(visualSend.isBuildMessageBeforeSending());
			}
			
			return sendMediator;
		}
	}

}

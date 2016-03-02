/*
 * Copyright 2009-2015 WSO2, Inc. (http://wso2.com)
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
import org.apache.synapse.endpoints.IndirectEndpoint;
import org.apache.synapse.endpoints.ResolvingEndpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediatorEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class CallMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {		
		org.apache.synapse.mediators.builtin.CallMediator callMediator;
		try {
			callMediator = createCallMediator(subject);
			if(callMediator!=null){
				information.getParentSequence().addChild(callMediator);
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
			if(((CallMediator) subject).getEndpointType() == CallMediatorEndpointType.INLINE){
				doTransform(tmpInformation, ((CallMediator) subject).getEndpointOutputConnector());  //to transform the mediators inside the mediator
			}
			doTransform(information, ((CallMediator) subject).getOutputConnector()); //continue in normal flow
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// TODO Auto-generated method stub
		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		org.apache.synapse.mediators.builtin.CallMediator callMediator;
		try {
			callMediator = createCallMediator(subject);
			if(callMediator!=null){
				sequence.addChild(callMediator);
			}		
			if(((CallMediator) subject).getEndpointType() == CallMediatorEndpointType.INLINE){
				//to transform the mediators inside the mediator
				doTransformWithinSequence(information,((CallMediator) subject).getEndpointOutputConnector().getOutgoingLink(),sequence);
			}
			// to go in normal flow
			doTransformWithinSequence(information,((CallMediator) subject).getOutputConnector().getOutgoingLink(),sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}		
	}
	
	private org.apache.synapse.mediators.builtin.CallMediator createCallMediator(EsbNode subject) throws TransformerException, JaxenException{
		// Check subject.
		Assert.isTrue(subject instanceof CallMediator, "Invalid subject.");
		CallMediator visualCallMediator = (CallMediator) subject;
		
		// Configure call mediator.
		org.apache.synapse.mediators.builtin.CallMediator synapseCallMediator = new org.apache.synapse.mediators.builtin.CallMediator();
		setCommonProperties(synapseCallMediator, visualCallMediator);
		
		if (visualCallMediator.getEndpointType() == CallMediatorEndpointType.XPATH) {
			NamespacedProperty nameSpacedProperty = visualCallMediator.getEndpointXpath();
			Endpoint resolvingEndpoint = getEndpointFromXpath(nameSpacedProperty);
			synapseCallMediator.setEndpoint(resolvingEndpoint);
		} else if (visualCallMediator.getEndpointType() == CallMediatorEndpointType.REGISRTYKEY) {
			RegistryKeyProperty regKey = visualCallMediator.getEndpointRegistrykey();
			IndirectEndpoint indirectEndpoint = new IndirectEndpoint();
			indirectEndpoint.setKey(regKey.getKeyValue());
			synapseCallMediator.setEndpoint(indirectEndpoint);
		} else {
			synapseCallMediator.setEndpoint(null);
		}
		synapseCallMediator.setBlocking(visualCallMediator.isEnableBlockingCalls());
		return synapseCallMediator;
	}
	
	public ResolvingEndpoint getEndpointFromXpath(NamespacedProperty nameSpacedProperty) throws JaxenException{
				
		SynapseXPath synapseXPath = new SynapseXPath(nameSpacedProperty.getPropertyValue());
		for (int i = 0; i < nameSpacedProperty.getNamespaces().keySet().size(); ++i) {
			String prefix = (String) nameSpacedProperty.getNamespaces().keySet().toArray()[i];
			String namespaceUri = nameSpacedProperty.getNamespaces().get(prefix);
			synapseXPath.addNamespace(prefix, namespaceUri);
		}
		ResolvingEndpoint resolvingEndpoint = new ResolvingEndpoint();
		resolvingEndpoint.setKeyExpression(synapseXPath);
		return resolvingEndpoint;
	}

}

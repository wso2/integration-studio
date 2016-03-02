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
import java.util.Map;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.eip.Target;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class IterateMediatorTransformer extends AbstractEsbNodeTransformer{

	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {
		try {
			information.getParentSequence().addChild(createIterateMediator(information,subject));
			/*
			 *  Transform the property mediator output data flow path.
			 */
			doTransform(information,
					((IterateMediator) subject).getOutputConnector());	
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}	
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		try {
			sequence.addChild(createIterateMediator(information,subject));
			doTransformWithinSequence(information,((IterateMediator) subject).getOutputConnector().getOutgoingLink(),sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}		
	}
	
	private org.apache.synapse.mediators.eip.splitter.IterateMediator createIterateMediator(TransformationInfo information,EsbNode subject) throws JaxenException, TransformerException{
		/*
		 *  Check subject.
		 */
		Assert.isTrue(subject instanceof IterateMediator, "Invalid subject.");
		IterateMediator visualIterate = (IterateMediator) subject;

		/*
		 *  Configure Iterate mediator.
		 */
		org.apache.synapse.mediators.eip.splitter.IterateMediator iterateMediator = new org.apache.synapse.mediators.eip.splitter.IterateMediator();
		setCommonProperties(iterateMediator, visualIterate);
		{	
			NamespacedProperty iterateExp = visualIterate.getIterateExpression();
			
			if(iterateExp != null && !iterateExp.getPropertyValue().equals("")){
				
				SynapseXPath xpath = new SynapseXPath(iterateExp.getPropertyValue());
				Map<String, String> nameSpaceMap = iterateExp.getNamespaces();
				
				
				for(String key : nameSpaceMap.keySet()){
					
					xpath.addNamespace(key, nameSpaceMap.get(key));
				}
				
				iterateMediator.setExpression(xpath);
				
			}
			
			if(visualIterate.isPreservePayload()){
				iterateMediator.setPreservePayload(true);
				NamespacedProperty attachedPath = visualIterate.getAttachPath();
				if(attachedPath != null && !attachedPath.getPropertyValue().equals("")){
					SynapseXPath xpath = new SynapseXPath(attachedPath.getPropertyValue());
					Map<String, String> nameSpaceMap = attachedPath.getNamespaces();
					for(String key : nameSpaceMap.keySet()){
						xpath.addNamespace(key, nameSpaceMap.get(key));
					}
					iterateMediator.setAttachPath(xpath);
				}
			} else{
				iterateMediator.setPreservePayload(false);
			}
			
			iterateMediator.setContinueParent(visualIterate.isContinueParent());
			
			iterateMediator.setId(visualIterate.getIterateID());	
			
			Target target = new Target();
			target.setSoapAction(visualIterate.getTarget().getSoapAction());
			target.setToAddress(visualIterate.getTarget().getToAddress());
			
			switch (visualIterate.getSequenceType()) {
			case ANONYMOUS:
				SequenceMediator targetSequence=new SequenceMediator();
				
				TransformationInfo newInfo = new TransformationInfo();
				newInfo.setTraversalDirection(information.getTraversalDirection());
				newInfo.setSynapseConfiguration(information.getSynapseConfiguration());
				newInfo.setOriginInSequence(information.getOriginInSequence());
				newInfo.setOriginOutSequence(information.getOriginOutSequence());
				newInfo.setCurrentProxy(information.getCurrentProxy());
				newInfo.setParentSequence(targetSequence);
				doTransform(newInfo,visualIterate.getTargetOutputConnector());
				target.setSequence(targetSequence);
				break;
				
			case REGISTRY_REFERENCE:
				target.setSequenceRef(visualIterate.getSequenceKey().getKeyValue());
				break;
				
			case NAMED_REFERENCE:
				target.setSequenceRef(visualIterate.getSequenceName());
				break;
			}
			
			if(visualIterate.isSequentialMediation()) {
				target.setAsynchronous(false);
			}
						
			iterateMediator.setTarget(target);

		}
		return iterateMediator;
	}

}

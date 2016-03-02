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

import org.apache.synapse.Mediator;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.CommentMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SequencesInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbTransformerRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public abstract class AbstractEsbNodeTransformer implements EsbNodeTransformer {
	
	protected final IDeveloperStudioLog log= Logger.getLog(Activator.PLUGIN_ID);
	
	/**
	 * Performs the transformation of the data-flow path begining with the
	 * specified {@link OutputConnector}.
	 * 
	 * @param synapseConfiguration
	 * @param rootService
	 * @param parentMediator
	 * @param outputConnector
	 * @throws TransformerException 
	 * @throws Exception
	 */
	protected void doTransform(TransformationInfo info, OutputConnector outputConnector) throws TransformerException{		
		if (null != outputConnector) {
			EObject previousNode = outputConnector.eContainer();
			info.setPreviousNode(previousNode);
			
			// Adding XML comments into synapse config.
			addXMLCommnets(info, outputConnector.getCommentMediators());
			
			// Process only if there is a link.
			EsbLink outgoingLink = outputConnector.getOutgoingLink();
			if (null != outgoingLink) {
				InputConnector inputConnector = outgoingLink.getTarget();
				Assert.isNotNull(inputConnector, "Input connector should not be null.");

				EObject nextNode = inputConnector.eContainer();
				Assert.isTrue(nextNode instanceof EsbNode, "Unknown target node.");

				EsbNode esbNode = (EsbNode) nextNode;
				EsbNodeTransformer transformer = EsbTransformerRegistry.getInstance().getTransformer(esbNode);
				Assert.isNotNull(transformer, "No registered transformer for given node.");

				transformer.transform(info, esbNode);
			} else {
				// TODO: Might be better to automatically log the message before dropping. 
				if (info.getParentSequence()!=null){ //TODO temp					
				
				}
			}
		} else {
			// TODO: Warn about the fact that output connector is null.
		}
	}
	
	protected void doTransformWithinSequence(TransformationInfo info, EsbLink outgoingLink,SequenceMediator sequence) throws TransformerException {
	
			if (null != outgoingLink) {
				EObject previousNode = outgoingLink.getSource().eContainer();
				info.setPreviousNode(previousNode);
				
				InputConnector inputConnector = outgoingLink.getTarget();
				Assert.isNotNull(inputConnector, "Input connector should not be null.");
				
				EObject nextNode = inputConnector.eContainer();
				Assert.isTrue(nextNode instanceof EsbNode, "Unknown target node.");

				EsbNode esbNode = (EsbNode) nextNode;
				EsbNodeTransformer transformer = EsbTransformerRegistry.getInstance().getTransformer(esbNode);
				Assert.isNotNull(transformer, "No registered transformer for given node.");
				
				if(inputConnector instanceof SequencesInputConnector){
					info.setParentSequence(sequence);					
					// Adding XML comments into synapse config.
					addXMLCommnets(info, outgoingLink.getSource().getCommentMediators());
					transformer.transform(info, esbNode);					
				}
				else{
					// Adding XML comments into synapse config.
					CommentMediatorTransformer commentMediatorTransformer = new CommentMediatorTransformer();
					for(CommentMediator mediator:outgoingLink.getSource().getCommentMediators()){
						commentMediatorTransformer.transformWithinSequence(info, mediator,sequence);
					}
					transformer.transformWithinSequence(info, esbNode,sequence);
				}
			} else {
                    // TODO: Might be better to automatically log the message before dropping. 
			}
		
	}
	
	protected void doTransformFaultSequence(TransformationInfo info,EsbNode originNode) throws TransformerException {
		if(originNode !=null){
		EsbNodeTransformer transformer = EsbTransformerRegistry.getInstance().getTransformer(originNode);
		Assert.isNotNull(transformer, "No registered transformer for given node.");

		transformer.transform(info, originNode);
		}
	}
	
	protected void setCommonProperties(Mediator mediator, org.wso2.developerstudio.eclipse.gmf.esb.Mediator visualElement) {
		mediator.setShortDescription(visualElement.getDescription());
		// FIXME : invoke getCommentsList() from org.apache.synapse.Mediator
		// once it is available.
		((AbstractMediator) mediator).getCommentsList().addAll(visualElement.getCommentsList());
	}
	
	private void addXMLCommnets(TransformationInfo info, EList<CommentMediator> commentMediators){
		CommentMediatorTransformer commentMediatorTransformer = new CommentMediatorTransformer();
		for(CommentMediator mediator:commentMediators){
			commentMediatorTransformer.transform(info, mediator);
		}
	}
	
}

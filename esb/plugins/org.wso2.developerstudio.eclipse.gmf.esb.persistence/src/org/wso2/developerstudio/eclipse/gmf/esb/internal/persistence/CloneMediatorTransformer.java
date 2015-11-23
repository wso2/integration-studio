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

import java.util.ArrayList;
import java.util.List;

import org.apache.synapse.endpoints.AddressEndpoint;
import org.apache.synapse.endpoints.DefaultEndpoint;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.FailoverEndpoint;
import org.apache.synapse.endpoints.HTTPEndpoint;
import org.apache.synapse.endpoints.LoadbalanceEndpoint;
import org.apache.synapse.endpoints.RecipientListEndpoint;
import org.apache.synapse.endpoints.TemplateEndpoint;
import org.apache.synapse.endpoints.WSDLEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.eip.Target;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.AddressEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.DefaultEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.TargetEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.TargetSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.WSDLEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.AddressEndPointImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.DefaultEndPointImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.FailoverEndPointImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.HTTPEndpointImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.LoadBalanceEndPointImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.NamedEndpointImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.RecipientListEndPointImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.TemplateEndpointImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.WSDLEndPointImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class CloneMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {
		try {
			information.getParentSequence().addChild(
					createCloneMediator(information, subject));
			/*
			 * Transform the mediator output data flow path.
			 */
			doTransform(information, ((CloneMediator) subject).getOutputConnector());
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
			sequence.addChild(createCloneMediator(information, subject));
			doTransformWithinSequence(information, ((CloneMediator) subject)
					.getOutputConnector().getOutgoingLink(), sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	private org.apache.synapse.mediators.eip.splitter.CloneMediator createCloneMediator(
			TransformationInfo information, EsbNode subject) throws TransformerException, JaxenException {
		/*
		 * Check subject.
		 */
		Assert.isTrue(subject instanceof CloneMediator, "Invalid subject.");
		CloneMediator visualClone = (CloneMediator) subject;

		/*
		 * Configure Clone mediator.
		 */
		org.apache.synapse.mediators.eip.splitter.CloneMediator cloneMediator = new org.apache.synapse.mediators.eip.splitter.CloneMediator();
		setCommonProperties(cloneMediator, visualClone);
		{
			if (visualClone.getCloneID() != null && !visualClone.getCloneID().isEmpty()) {
				cloneMediator.setId(visualClone.getCloneID());
			}
			cloneMediator.setSequential(visualClone.isSequentialMediation());
			cloneMediator.setContinueParent(visualClone.isContinueParent());

			List<Target> targetList = new ArrayList<Target>();

			for (int i = 0; i < visualClone.getTargets().size(); ++i) {

				CloneTarget visualTarget = visualClone.getTargets().get(i);
				Target target = new Target();
				
				if (visualTarget.getSoapAction()!= null && !visualTarget.getSoapAction().equals("")) {
					target.setSoapAction(visualTarget.getSoapAction()); // set soap action.
				} else {
					target.setSoapAction(null);
				}
				if (visualTarget.getToAddress() != null && !visualTarget.getToAddress().equals("")) {
					target.setToAddress(visualTarget.getToAddress()); // set to address.
				} else {
					target.setToAddress(null);
				}
				
				if (visualTarget.getSequenceType().equals(
						TargetSequenceType.ANONYMOUS)) { // handle if target sequence type anonymous.

					CloneMediatorTargetOutputConnector outputConnector = visualClone
							.getTargetsOutputConnector().get(i);
					SequenceMediator targetSequence = new SequenceMediator();

					TransformationInfo newInfo = new TransformationInfo();
					newInfo.setTraversalDirection(information
							.getTraversalDirection());
					newInfo.setSynapseConfiguration(information
							.getSynapseConfiguration());
					newInfo.setOriginInSequence(information
							.getOriginInSequence());
					newInfo.setOriginOutSequence(information
							.getOriginOutSequence());
					newInfo.setCurrentProxy(information.getCurrentProxy());
					newInfo.setParentSequence(targetSequence);
					doTransform(newInfo, outputConnector);

					target.setSequence(targetSequence);

				} else if (visualTarget.getSequenceType().equals(
						TargetSequenceType.REGISTRY_REFERENCE)) { //handle if target sequence type registry ref.

					target.setSequenceRef(visualTarget.getSequenceKey()
							.getKeyValue());
				}

				if (visualTarget.getEndpointType().equals(
						TargetEndpointType.ANONYMOUS)) {
				
					EObject endpoint = null;
					CloneMediatorTargetOutputConnector outputConnector = visualClone
							.getTargetsOutputConnector().get(i);

					SequenceMediator targetSequence = new SequenceMediator();
					TransformationInfo newInfo = new TransformationInfo();
					newInfo.setTraversalDirection(information
							.getTraversalDirection());
					newInfo.setSynapseConfiguration(information
							.getSynapseConfiguration());
					newInfo.setOriginInSequence(information
							.getOriginInSequence());
					newInfo.setOriginOutSequence(information
							.getOriginOutSequence());
					newInfo.setCurrentProxy(information.getCurrentProxy());
					newInfo.setParentSequence(targetSequence);
					
					doTransform(newInfo, outputConnector);
					

					if (newInfo.isEndPointFound) {
						endpoint = newInfo.getFirstEndpoint();

						if (endpoint instanceof DefaultEndPointImpl) {
							DefaultEndPointTransformer transformer = new DefaultEndPointTransformer();
							DefaultEndpoint synapseEP = transformer.create(
									(DefaultEndPoint) endpoint, null);
							target.setEndpoint(synapseEP);
						} else if (endpoint instanceof AddressEndPointImpl) {
							AddressEndPointTransformer transformer = new AddressEndPointTransformer();
							AddressEndpoint synapseEP = transformer.create(
									(AddressEndPoint) endpoint, null);
							target.setEndpoint(synapseEP);
						} else if (endpoint instanceof FailoverEndPointImpl) {
							FailoverEndPointTransformer transformer = new FailoverEndPointTransformer();
							FailoverEndpoint synapseEP = transformer.create(
									newInfo, (FailoverEndPoint) endpoint, null,
									null);
							target.setEndpoint(synapseEP);
						} else if (endpoint instanceof HTTPEndpointImpl) {
							HTTPEndPointTransformer transformer = new HTTPEndPointTransformer();
							HTTPEndpoint synapseEP = transformer
									.create((org.wso2.developerstudio.eclipse.gmf.esb.HTTPEndpoint) endpoint,
											null);
							target.setEndpoint(synapseEP);
						} else if (endpoint instanceof LoadBalanceEndPointImpl) {
							LoadBalanceEndPointTransformer transformer = new LoadBalanceEndPointTransformer();
							LoadbalanceEndpoint synapseEP = transformer.create(
									newInfo, (LoadBalanceEndPoint) endpoint,
									null, null);
							target.setEndpoint(synapseEP);
						} else if (endpoint instanceof NamedEndpointImpl) {
							NamedEndPointTransformer transformer = new NamedEndPointTransformer();
							@SuppressWarnings("static-access")
							Endpoint synapseEP = transformer.create(
									(NamedEndpoint) endpoint, null);
							target.setEndpoint(synapseEP);
						} else if (endpoint instanceof RecipientListEndPointImpl) {
							RecipientListEndPointTransformer transformer = new RecipientListEndPointTransformer();
							RecipientListEndpoint synapseEP = transformer
									.create(newInfo,
											(RecipientListEndPoint) endpoint,
											null, null);
							target.setEndpoint(synapseEP);
						} else if (endpoint instanceof TemplateEndpointImpl) {
							TemplateEndPointTransformer transformer = new TemplateEndPointTransformer();
							TemplateEndpoint synapseEP = transformer
									.create((org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint) endpoint,
											null);
							target.setEndpoint(synapseEP);
						} else if (endpoint instanceof WSDLEndPointImpl) {
							WSDLEndPointTransformer transformer = new WSDLEndPointTransformer();
							WSDLEndpoint synapseEP = transformer.create(
									(WSDLEndPoint) endpoint, null);
							target.setEndpoint(synapseEP);
						}

					}
				} else if (visualTarget.getEndpointType().equals(
						TargetEndpointType.REGISTRY_REFERENCE)) {

					target.setEndpointRef(visualTarget.getEndpointKey()
							.getKeyValue());
				}

				targetList.add(target);

			}

			cloneMediator.setTargets(targetList);
		}
		return cloneMediator;
	}

	
}

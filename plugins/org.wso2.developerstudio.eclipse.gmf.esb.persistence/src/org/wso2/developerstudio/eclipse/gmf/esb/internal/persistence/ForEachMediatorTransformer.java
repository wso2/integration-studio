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
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class ForEachMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
		try {
			information.getParentSequence().addChild(createForEachMediator(information, subject));
			// Transform mediator output data flow path.
			doTransform(information, ((ForEachMediator) subject).getOutputConnector());
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
			throws TransformerException {
		try {
			sequence.addChild(createForEachMediator(information, subject));
			doTransformWithinSequence(information, ((ForEachMediator) subject).getOutputConnector().getOutgoingLink(),
					sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	private org.apache.synapse.mediators.builtin.ForEachMediator createForEachMediator(TransformationInfo information,
			EsbNode subject) throws JaxenException, TransformerException{
		// Check subject.
		Assert.isTrue(subject instanceof ForEachMediator, "Invalid subject.");
		ForEachMediator visualForEach = (ForEachMediator) subject;

		// Configure ForEach mediator.
		org.apache.synapse.mediators.builtin.ForEachMediator forEachMediator = new org.apache.synapse.mediators.builtin.ForEachMediator();
		setCommonProperties(forEachMediator, visualForEach);

		NamespacedProperty ForEachExp = visualForEach.getForEachExpression();
		if (ForEachExp != null && !ForEachExp.getPropertyValue().equals("")) {
			SynapseXPath xpath = new SynapseXPath(ForEachExp.getPropertyValue());
			Map<String, String> nameSpaceMap = ForEachExp.getNamespaces();

			for (String key : nameSpaceMap.keySet()) {
				xpath.addNamespace(key, nameSpaceMap.get(key));
			}
			forEachMediator.setExpression(xpath);
		}

		forEachMediator.setId(visualForEach.getForEachID());

		switch (visualForEach.getSequenceType()) {
		case ANONYMOUS:
			SequenceMediator targetSequence = new SequenceMediator();

			TransformationInfo newInfo = new TransformationInfo();
			newInfo.setTraversalDirection(information.getTraversalDirection());
			newInfo.setSynapseConfiguration(information.getSynapseConfiguration());
			newInfo.setOriginInSequence(information.getOriginInSequence());
			newInfo.setOriginOutSequence(information.getOriginOutSequence());
			newInfo.setCurrentProxy(information.getCurrentProxy());
			newInfo.setParentSequence(targetSequence);
			doTransform(newInfo, visualForEach.getTargetOutputConnector());
			forEachMediator.setSequence(targetSequence);
			break;

		case REGISTRY_REFERENCE:
			forEachMediator.setSequenceRef(visualForEach.getSequenceKey().getKeyValue());
			break;

		case NAMED_REFERENCE:
			forEachMediator.setSequenceRef(visualForEach.getSequenceName());
			break;
		}
		return forEachMediator;
	}

	public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints)
			throws TransformerException {
	}

}

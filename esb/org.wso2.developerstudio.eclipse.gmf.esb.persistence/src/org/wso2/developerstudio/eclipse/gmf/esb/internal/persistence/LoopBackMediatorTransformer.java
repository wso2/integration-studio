/*
 * Copyright 2013 WSO2, Inc. (http://wso2.com)
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
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.LoopBackMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

/**
 * {@link EsbNodeTransformer} responsible for transforming
 * {@link org.wso2.developerstudio.eclipse.gmf.esb.LoopBackMediator} model
 * objects into corresponding synapse artifact(s).
 */
public class LoopBackMediatorTransformer extends AbstractEsbNodeTransformer {

	/**
	 * {@inheritDoc}
	 */
	public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
		LoopBackMediator visualMediator = (LoopBackMediator) subject;

		information.getParentSequence().addChild(createLoopBackMediator(visualMediator));

		// Transform the loopback mediator output data flow path.
		doTransform(information, visualMediator.getOutputConnector());
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// TODO Auto-generated method stub

	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject,
			SequenceMediator sequence) throws TransformerException {
		LoopBackMediator visualMediator = (LoopBackMediator) subject;

		sequence.addChild(createLoopBackMediator(visualMediator));
		doTransformWithinSequence(information, visualMediator.getOutputConnector()
				.getOutgoingLink(), sequence);
	}

	/**
	 * Create LoopBack mediator from visual mediator.
	 * 
	 * @param visualMediator
	 * @return
	 */
	private org.apache.synapse.mediators.builtin.LoopBackMediator createLoopBackMediator(
			LoopBackMediator visualMediator) {
		org.apache.synapse.mediators.builtin.LoopBackMediator loopBackMediator = new org.apache.synapse.mediators.builtin.LoopBackMediator();
		setCommonProperties(loopBackMediator, visualMediator);
		
		return loopBackMediator;
	}

}

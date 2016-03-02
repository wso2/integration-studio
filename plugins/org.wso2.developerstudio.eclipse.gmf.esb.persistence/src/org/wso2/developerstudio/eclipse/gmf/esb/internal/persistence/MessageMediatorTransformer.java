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
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.builtin.SendMediator;
import org.apache.synapse.mediators.filters.InMediator;
import org.apache.synapse.mediators.filters.OutMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

/**
 * {@link EsbNodeTransformer} responsible for transforming
 * {@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService} model objects into
 * corresponding synapse artifact(s).
 */
public class MessageMediatorTransformer extends AbstractEsbNodeTransformer {

	/** The name of the main sequence for message mediation */
	public static final String MAIN_SEQUENCE_KEY = "main";
	/** The name of the fault sequence to execute on failures during mediation */
	public static final String FAULT_SEQUENCE_KEY = "fault";

	/**
	 * {@inheritDoc}
	 */
	public void transform(TransformationInfo info, EsbNode subject)
			throws TransformerException {
		// Check subject.
		Assert.isTrue(
				subject instanceof org.wso2.developerstudio.eclipse.gmf.esb.MessageMediator,
				"Invalid subject.");
		org.wso2.developerstudio.eclipse.gmf.esb.MessageMediator visualMessage = (org.wso2.developerstudio.eclipse.gmf.esb.MessageMediator) subject;

		// Check start.
		if (info.getTraversalDirection() == TransformationInfo.TRAVERSAL_DIRECTION_IN) {
			// Let's use a dummy service name for now.
			SequenceMediator mainMediator = new SequenceMediator();
			mainMediator.setName(MAIN_SEQUENCE_KEY);
			InMediator inMed = new InMediator();
			mainMediator.addChild(inMed);
			OutMediator outMed = new OutMediator();
			mainMediator.addChild(outMed);			
			info.getSynapseConfiguration().addSequence(MAIN_SEQUENCE_KEY, mainMediator);			
			info.setOriginInSequence(inMed);
			info.setOriginOutSequence(outMed);
			info.setParentSequence(inMed);

			// Transform output data flow.
			doTransform(info, visualMessage.getOutputConnector());
		} else {
			// Round-trip comlplete, send the message back to client.
			// TODO: Need to verify (either here or in the visual model) that
			// this is not a short-cricuit or an illegal message routing
			// operation (attempting to route one proxy service's messages to
			// another).
			info.getOriginOutSequence().addChild(new SendMediator());
		}
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// TODO Auto-generated method stub
		
	}


	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		// TODO Auto-generated method stub
		
	}


}

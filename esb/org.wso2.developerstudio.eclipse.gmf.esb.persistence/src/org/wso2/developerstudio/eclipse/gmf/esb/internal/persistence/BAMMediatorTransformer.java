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


package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.carbon.mediator.bam.config.stream.StreamConfiguration;

public class BAMMediatorTransformer extends AbstractEsbNodeTransformer{

	public void transform(TransformationInfo information, EsbNode subject) throws Exception {
		information.getParentSequence().addChild(
				createBAMMediator(subject, information));

		doTransform(information,
				((BAMMediator) subject).getOutputConnector());	
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {	
	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject,
			SequenceMediator sequence) throws Exception {
		sequence.addChild(createBAMMediator(subject, information));
		doTransformWithinSequence(information, ((BAMMediator) subject)
				.getOutputConnector().getOutgoingLink(), sequence);
		
	}
	
	private org.wso2.carbon.mediator.bam.BamMediator createBAMMediator(
			EsbNode subject, TransformationInfo information) throws Exception {

		/*
		 * Check subject.
		 */
		Assert.isTrue(subject instanceof BAMMediator, "Invalid subject.");
		BAMMediator visualBAMMediator = (BAMMediator) subject;

		org.wso2.carbon.mediator.bam.BamMediator bamMediator = new org.wso2.carbon.mediator.bam.BamMediator();
		setCommonProperties(bamMediator, visualBAMMediator);
		
		bamMediator.setServerProfile(visualBAMMediator.getServerProfile());
		
		StreamConfiguration streamConfiguration = new StreamConfiguration();
		streamConfiguration.setName(visualBAMMediator.getStreamName());
		streamConfiguration.setVersion(visualBAMMediator.getStreamVersion());
		bamMediator.getStream().setStreamConfiguration(streamConfiguration);
		
		return bamMediator;
	}
}

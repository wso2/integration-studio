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

import java.util.List;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.Mediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.RuleMediatorExt;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class RuleMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
		information.getParentSequence().addChild(createRuleMediator(information, subject));
		doTransform(information, ((RuleMediator) subject).getOutputConnector());
	}

	public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints) {

	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
			throws TransformerException {
		sequence.addChild(createRuleMediator(information, subject));
		doTransformWithinSequence(information, ((RuleMediator) subject).getOutputConnector().getOutgoingLink(),
				sequence);
	}

	private RuleMediatorExt createRuleMediator(TransformationInfo information, EsbNode subject){
		// Check subject.
		Assert.isTrue(subject instanceof RuleMediator, "Unsupported mediator passed in for serialization.");
		RuleMediatorExt ruleMediator = new RuleMediatorExt();
		setCommonProperties(ruleMediator, (Mediator) subject);
		ruleMediator.setSubject(subject);
		return ruleMediator;
	}
}

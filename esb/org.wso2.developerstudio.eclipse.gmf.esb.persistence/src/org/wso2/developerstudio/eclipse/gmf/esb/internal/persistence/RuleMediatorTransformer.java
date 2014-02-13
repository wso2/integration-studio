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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.Mediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFact;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFactsConfiguration;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResult;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResultsConfiguration;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.RuleMediatorExt;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

import org.wso2.carbon.rule.common.Fact;
import org.wso2.carbon.rule.common.Input;
import org.wso2.carbon.rule.common.Output;
import org.wso2.carbon.rule.common.Rule;
import org.wso2.carbon.rule.common.RuleSet;
import org.wso2.carbon.rule.common.util.Constants;
import org.wso2.carbon.rule.kernel.engine.RuleEngine;
import org.wso2.carbon.rule.kernel.engine.RuleSession;
import org.wso2.carbon.rule.mediator.config.RuleMediatorConfig;
import org.wso2.carbon.rule.mediator.config.Source;
import org.wso2.carbon.rule.mediator.config.Target;

public class RuleMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject)
			throws Exception {
		information.getParentSequence().addChild(createRuleMediator(information,subject));
		// Transform the Rule mediator output data flow path.
		doTransform(information,
				((RuleMediator) subject).getOutputConnector());		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws Exception {
		sequence.addChild(createRuleMediator(information,subject));
		doTransformWithinSequence(information,((RuleMediator) subject).getOutputConnector().getOutgoingLink(),sequence);
		
	}
	
	private RuleMediatorExt createRuleMediator(
			TransformationInfo information, EsbNode subject) throws Exception {
		// Check subject.
		Assert.isTrue(subject instanceof RuleMediator,
				"Unsupported mediator passed in for serialization.");
		RuleMediatorExt ruleMediator = new RuleMediatorExt();
		setCommonProperties(ruleMediator, (Mediator) subject);
		ruleMediator.setSubject(subject);
		return ruleMediator;
 
	}
	
	
	
/*	private org.wso2.carbon.rule.mediator.RuleMediator createRuleMediator(
			TransformationInfo information, EsbNode subject) throws Exception {
		// Check subject.
		Assert.isTrue(subject instanceof RuleMediator,
				"Unsupported mediator passed in for serialization.");
		RuleMediator visualRule = (RuleMediator) subject;

		RuleMediatorDescription description = new RuleMediatorDescription();

		 RuleSets 
		RuleSetDescription ruleSetDescription = new RuleSetDescription();
		ruleSetDescription.setBindURI(visualRule.getRuleSetURI());
		if (visualRule.getRuleSetSourceType() == RuleSourceType.REGISTRY_REFERENCE) {
			ruleSetDescription.setKey(visualRule.getRuleSetSourceKey().getKeyValue());
		} else {
			OMElement source = AXIOMUtil.stringToOM(visualRule.getRuleSetSourceCode());
			ruleSetDescription.setRuleSource(source);
		}
		for (RuleSetCreationProperty property : visualRule.getRuleSetProperties()) {
			ruleSetDescription.addCreationProperty(new PropertyDescription(property
					.getPropertyName(), property.getPropertyValue()));
		}
		description.setRuleSetDescription(ruleSetDescription);

		 RuleSessions 
		SessionDescription sessionDescription = new SessionDescription();
		sessionDescription
				.setSessionType((visualRule.isStatefulSession()) ? SessionDescription.STATEFUL_SESSION
						: SessionDescription.STATELESS_SESSION);
		for (RuleSessionProperty property : visualRule.getRuleSessionProperties()) {
			sessionDescription.addSessionPropertyDescription(new PropertyDescription(property
					.getPropertyName(), property.getPropertyValue()));
		}
		description.setSessionDescription(sessionDescription);

		 RuleFacts 
		for (RuleFact fact : visualRule.getFactsConfiguration().getFacts()) {
			ResourceDescription resourceDescription = new ResourceDescription();
			resourceDescription.setName(fact.getFactName());
			if (fact.getFactType() == RuleFactType.CUSTOM) {
				resourceDescription.setType(fact.getFactCustomType());
			} else {
				resourceDescription.setType(fact.getFactType().getLiteral());
			}
			if (fact.getValueType() == RuleFactValueType.REGISTRY_REFERENCE) {
				resourceDescription.setKey(fact.getValueKey().getKeyValue());
			} else if (fact.getValueType() == RuleFactValueType.EXPRESSION) {
				NamespacedProperty namespacedProperty = fact.getValueExpression();
				SynapseXPath expression = new SynapseXPath(namespacedProperty.getPropertyValue());
				for (Entry<String, String> entry : namespacedProperty.getNamespaces().entrySet()) {
					expression.addNamespace(entry.getKey(), entry.getValue());
				}
				resourceDescription.setExpression(expression);
			} else {
				resourceDescription.setValue(fact.getValueType());
			}
			description.addFactDescription(resourceDescription);
		}

		 RuleResults 
		for (RuleResult result : visualRule.getResultsConfiguration().getResults()) {
			ResourceDescription resourceDescription = new ResourceDescription();
			resourceDescription.setName(result.getResultName());
			if (result.getResultType() == RuleResultType.CUSTOM) {
				resourceDescription.setType(result.getResultCustomType());
			} else {
				resourceDescription.setType(result.getResultType().getLiteral());
			}
			if (result.getValueType() == RuleResultValueType.REGISTRY_REFERENCE) {
				resourceDescription.setKey(result.getValueKey().getKeyValue());
			} else if (result.getValueType() == RuleResultValueType.EXPRESSION) {
				NamespacedProperty namespacedProperty = result.getValueExpression();
				SynapseXPath expression = new SynapseXPath(namespacedProperty.getPropertyValue());
				for (Entry<String, String> entry : namespacedProperty.getNamespaces().entrySet()) {
					expression.addNamespace(entry.getKey(), entry.getValue());
				}
				resourceDescription.setExpression(expression);
			} else {
				resourceDescription.setValue(result.getValueType());
			}
			description.addResultDescription(resourceDescription);
		}

		org.wso2.carbon.rule.mediator.RuleMediator ruleMediator = new org.wso2.carbon.rule.mediator.RuleMediator(
				description);

		ListMediator childMediatorList = new AnonymousListMediator();
		TransformationInfo newOnCompleteInfo = new TransformationInfo();
		newOnCompleteInfo.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_IN);
		newOnCompleteInfo.setSynapseConfiguration(information.getSynapseConfiguration());
		newOnCompleteInfo.setOriginInSequence(information.getOriginInSequence());
		newOnCompleteInfo.setOriginOutSequence(information.getOriginOutSequence());
		newOnCompleteInfo.setParentSequence(childMediatorList);
		doTransform(newOnCompleteInfo, visualRule.getChildMediatorsOutputConnector());
		ruleMediator.addAll(childMediatorList.getList());

		return ruleMediator;
	}

*/
}

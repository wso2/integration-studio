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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.mediators.AbstractMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.carbon.rule.common.Fact;
import org.wso2.carbon.rule.common.Input;
import org.wso2.carbon.rule.common.Output;
import org.wso2.carbon.rule.common.Rule;
import org.wso2.carbon.rule.common.RuleSet;
import org.wso2.carbon.rule.mediator.config.RuleMediatorConfig;
import org.wso2.carbon.rule.mediator.config.Source;
import org.wso2.carbon.rule.mediator.config.Target;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleActions;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFact;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFactType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResult;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResultType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleSessionProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleSourceType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class RuleMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, RuleMediator> {

	@Override
	public RuleMediator createNode(IGraphicalEditPart part, AbstractMediator object) {
		Assert.isTrue(object instanceof RuleMediatorExt ,"Unsupported mediator passed in for deserialization");
		
		RuleMediatorExt   mediator = (RuleMediatorExt ) object;
		
		RuleMediator mediatorModel = (RuleMediator) DeserializerUtils.createNode(part, EsbElementTypes.RuleMediator_3523); 
		setElementToEdit(mediatorModel);
		setCommonProperties(mediator, mediatorModel);
		
		RuleMediatorConfig ruleMediatorConfig = mediator.getRuleMediatorConfig();
		Input input = ruleMediatorConfig.getInput();
		if(input!=null){
			executeSetValueCommand(RULE_MEDIATOR__INPUT_WRAPPER_NAME, input.getWrapperElementName());
			executeSetValueCommand(RULE_MEDIATOR__INPUT_NAME_SPACE, input.getNameSpace());
			for (Fact fact : input.getFacts()) {
				RuleFact ruleFact = EsbFactory.eINSTANCE.createRuleFact();
		
				if(StringUtils.isNotBlank(fact.getType())) {
					String ruleFactType = fact.getType();
					if(ruleFactType.equals(RuleFactType.MESSAGE.toString())) {
						ruleFact.setFactType(RuleFactType.MESSAGE);
					} else if (ruleFactType.equals(RuleFactType.CONTEXT.toString())) {
						ruleFact.setFactType(RuleFactType.CONTEXT);
					} else if (ruleFactType.equals(RuleFactType.DOM.toString())) {
						ruleFact.setFactType(RuleFactType.DOM);
					} else if (ruleFactType.equals(RuleFactType.MEDIATOR.toString())) {
						ruleFact.setFactType(RuleFactType.MEDIATOR);
					} else if (ruleFactType.equals(RuleFactType.OMELEMENT.toString())) {
						ruleFact.setFactType(RuleFactType.OMELEMENT);
					} else {
						//Custom Type
						ruleFact.setFactCustomType(ruleFactType);
					}
				}			
				if(StringUtils.isNotBlank(fact.getElementName())) {
					ruleFact.setFactName(fact.getElementName());
				}
				if(StringUtils.isNotBlank(fact.getXpath())) {
					ruleFact.setValueExpression(createNamespacedProperty(fact.getXpath(),fact.getPrefixToNamespaceMap()));
				}
				
				executeAddValueCommand(mediatorModel.getFactsConfiguration().getFacts(), ruleFact);
			}
		}

		Output output = ruleMediatorConfig.getOutput();
		if(output!=null){
			executeSetValueCommand(RULE_MEDIATOR__OUTPUT_WRAPPER_NAME, output.getWrapperElementName());
			executeSetValueCommand(RULE_MEDIATOR__OUTPUT_NAME_SPACE, output.getNameSpace());
			for (Fact fact : output.getFacts()) {
				RuleResult ruleResult = EsbFactory.eINSTANCE.createRuleResult();
				ruleResult.setResultName(fact.getElementName());
				if(StringUtils.isNotBlank(fact.getXpath())) {
					ruleResult.setValueExpression(createNamespacedProperty(fact.getXpath(),fact.getPrefixToNamespaceMap()));
				}			
				if(StringUtils.isNotBlank(fact.getType())) {
					String resultFactType = fact.getType();
					if(resultFactType.equals(RuleResultType.MESSAGE.toString())) {
						ruleResult.setResultType(RuleResultType.MESSAGE);
					} else if (resultFactType.equals(RuleResultType.CONTEXT.toString())) {
						ruleResult.setResultType(RuleResultType.CONTEXT);
					} else if (resultFactType.equals(RuleResultType.DOM.toString())) {
						ruleResult.setResultType(RuleResultType.DOM);
					} else if (resultFactType.equals(RuleResultType.MEDIATOR.toString())) {
						ruleResult.setResultType(RuleResultType.MEDIATOR);
					} else if (resultFactType.equals(RuleResultType.OMELEMENT.toString())) {
						ruleResult.setResultType(RuleResultType.OMELEMENT);
					} else {
						//Custom Type
						ruleResult.setResultCustomType(resultFactType);
					}
				}
				
				executeAddValueCommand(mediatorModel.getResultsConfiguration().getResults(), ruleResult);
			}
		}
		
		RuleSet ruleSet = ruleMediatorConfig.getRuleSet();
		if(ruleSet!=null){
			for(Rule rule : ruleSet.getRules()) {
				if("dtable".equals(rule.getResourceType())) {
					executeSetValueCommand(RULE_MEDIATOR__RULE_SET_TYPE, RuleType.DTABLE);
				} else {
					executeSetValueCommand(RULE_MEDIATOR__RULE_SET_TYPE, RuleType.REGULAR);
				}
				
				if("url".equals(rule.getSourceType())) {
					executeSetValueCommand(RULE_MEDIATOR__RULE_SET_SOURCE_TYPE, RuleSourceType.URL);
					executeSetValueCommand(RULE_MEDIATOR__RULE_SET_URL, rule.getValue());			
				} else if("registry".equals(rule.getSourceType())) {
					executeSetValueCommand(RULE_MEDIATOR__RULE_SET_SOURCE_TYPE, RuleSourceType.REGISTRY);
					RegistryKeyProperty ruleSourceKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
					ruleSourceKey.setKeyValue(rule.getValue());
					executeSetValueCommand(RULE_MEDIATOR__RULE_SET_SOURCE_KEY, ruleSourceKey);
				} else {
					executeSetValueCommand(RULE_MEDIATOR__RULE_SET_SOURCE_TYPE, RuleSourceType.INLINE);
					executeSetValueCommand(RULE_MEDIATOR__RULE_SET_SOURCE_CODE, rule.getValue());
				}
			}
			
			// RuleSet Properties.
			EList<RuleSessionProperty> sessionPropertyList = new BasicEList<RuleSessionProperty>();
			for (Map.Entry<String, String> property : ruleSet.getProperties().entrySet()) {
				RuleSessionProperty sessionProperty = EsbFactory.eINSTANCE
						.createRuleSessionProperty();
				sessionProperty.setPropertyName(property.getKey());
				sessionProperty.setPropertyValue(property.getValue());

				sessionPropertyList.add(sessionProperty);
			}

			executeSetValueCommand(RULE_MEDIATOR__RULE_SESSION_PROPERTIES, sessionPropertyList);
		}
		
		Source source = ruleMediatorConfig.getSource();
		if(source!=null){
			executeSetValueCommand(RULE_MEDIATOR__SOURCE_VALUE, source.getValue());
			if(StringUtils.isNotBlank(source.getXpath())) {
				executeSetValueCommand(RULE_MEDIATOR__SOURCE_XPATH,
						createNamespacedProperty(source.getXpath(), source.getPrefixToNamespaceMap()));
			}
		}
		
		Target target = ruleMediatorConfig.getTarget();
		if(target!=null){
			if("child".equals(target.getAction())){
				executeSetValueCommand(RULE_MEDIATOR__TARGET_ACTION, RuleActions.CHILD);
			} else if ("sibling".equals(target.getAction())){
				executeSetValueCommand(RULE_MEDIATOR__TARGET_ACTION, RuleActions.SIBLING);
			} else{
				executeSetValueCommand(RULE_MEDIATOR__TARGET_ACTION, RuleActions.REPLACE);
			}
			
			executeSetValueCommand(RULE_MEDIATOR__TARGET_VALUE, target.getValue());
			
			if(StringUtils.isNotBlank(target.getXpath())) {
				executeSetValueCommand(RULE_MEDIATOR__TARGET_XPATH,
						createNamespacedProperty(target.getXpath(), target.getPrefixToNamespaceMap()));
			}
			
			if(StringUtils.isNotBlank(target.getResultXpath())) {
				executeSetValueCommand(RULE_MEDIATOR__TARGET_RESULT_XPATH,
					createNamespacedProperty(target.getResultXpath(), target.getPrefixToNamespaceMap()));
			}
		}
		return mediatorModel;
	}

}

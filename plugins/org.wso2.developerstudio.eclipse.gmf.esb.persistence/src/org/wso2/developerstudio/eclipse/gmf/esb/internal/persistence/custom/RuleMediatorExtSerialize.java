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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.AbstractMediatorSerializer;
import org.eclipse.emf.common.util.EList;
import org.wso2.carbon.rule.common.Fact;
import org.wso2.carbon.rule.common.Input;
import org.wso2.carbon.rule.common.Output;
import org.wso2.carbon.rule.common.Rule;
import org.wso2.carbon.rule.common.RuleSet;
import org.wso2.carbon.rule.mediator.config.RuleMediatorConfig;
import org.wso2.carbon.rule.mediator.config.Source;
import org.wso2.carbon.rule.mediator.config.Target;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFact;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFactType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFactsConfiguration;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResult;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResultType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResultsConfiguration;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleSessionProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleSourceType;

public class RuleMediatorExtSerialize extends AbstractMediatorSerializer{  

public String getMediatorClassName() {
		// TODO Auto-generated method stub
		return RuleMediatorExt.class.getName();
	}

	@Override
	protected OMElement serializeSpecificMediator(Mediator m) {
		
		RuleMediatorExt mediatorExt = (RuleMediatorExt)m;
		RuleMediator visualRule = (RuleMediator)mediatorExt.getSubject();
		RuleFactsConfiguration factsConfiguration = visualRule.getFactsConfiguration();
		EList<RuleFact> facts = factsConfiguration.getFacts();
		List<Fact> factsList = new ArrayList<Fact>();
		for (RuleFact ruleFact : facts) {
			if(ruleFact != null) {
				Fact fact = new Fact();
				fact.setElementName(ruleFact.getFactName());
				fact.setPrefixToNamespaceMap(ruleFact.getValueExpression().getNamespaces());
				
				if (ruleFact.getFactType().equals(RuleFactType.CUSTOM)) {
					fact.setType(ruleFact.getFactCustomType());
				} else {
					fact.setType(ruleFact.getFactType().getLiteral());
				}		
				
				fact.setTypeClass(ruleFact.getFactType().getClass());
				fact.setXpath(ruleFact.getValueExpression().getPropertyValue());
				fact.setNamespace(visualRule.getInputNameSpace());
				factsList.add(fact);
			}
		}
		
		Input input = new Input();
		input.setFacts(factsList);
		input.setNameSpace(visualRule.getInputNameSpace());
		input.setWrapperElementName(visualRule.getInputWrapperName());
		
        RuleResultsConfiguration resultsConfiguration = visualRule.getResultsConfiguration();
        EList<RuleResult> results = resultsConfiguration.getResults();
        List<Fact> resultfactsList = new ArrayList<Fact>();
        for (RuleResult ruleResult : results) {
        	Fact fact = new Fact();
			fact.setElementName(ruleResult.getResultName());
			fact.setPrefixToNamespaceMap(ruleResult.getValueExpression().getNamespaces());
			
			if (ruleResult.getResultType().equals(RuleResultType.CUSTOM)) {
				fact.setType(ruleResult.getResultCustomType());
			} else {
				fact.setType(ruleResult.getResultType().toString());
			}
			
			fact.setTypeClass(ruleResult.getResultType().getClass());
			fact.setNamespace(visualRule.getOutputNameSpace());
			resultfactsList.add(fact);
        }
        
        Output output = new Output();
        output.setFacts(resultfactsList);
        output.setNameSpace(visualRule.getOutputNameSpace());
        output.setWrapperElementName(visualRule.getOutputWrapperName());
        
        Target target = new Target();
        target.setAction(visualRule.getTargetAction().getName());
        target.setPrefixToNamespaceMap(visualRule.getTargetResultXpath().getNamespaces());
        target.setResultXpath(visualRule.getTargetResultXpath().getPropertyValue());
        target.setValue(visualRule.getTargetValue());
        target.setXpath(visualRule.getTargetXpath().getPropertyValue());
        
        Source source = new Source();
        source.setValue(visualRule.getSourceValue());
        if(StringUtils.isNotBlank(visualRule.getSourceXpath().getPropertyValue())) {
        	source.setPrefixToNamespaceMap(visualRule.getSourceXpath().getNamespaces());
            source.setXpath(visualRule.getSourceXpath().getPropertyValue());
        }
        
        RuleSet ruleSet = new RuleSet();
        
        Map<String,String> rulesetMap = new HashMap<String, String>();
        EList<RuleSessionProperty> ruleSetProperties = visualRule.getRuleSessionProperties();
        for (RuleSessionProperty ruleSetCreationProperty : ruleSetProperties) {
        	 rulesetMap.put(ruleSetCreationProperty.getPropertyName(),ruleSetCreationProperty.getPropertyValue());
		}
        ruleSet.setProperties(rulesetMap);
        
        List<Rule> list = new ArrayList<Rule>();
        Rule rule = new Rule();
        RuleSourceType ruleSetSourceType = visualRule.getRuleSetSourceType();
        rule.setSourceType(ruleSetSourceType.getName());
		if (visualRule.getRuleSetSourceType() == RuleSourceType.REGISTRY) {
			rule.setValue(visualRule.getRuleSetSourceKey().getKeyValue());
		} else if (visualRule.getRuleSetSourceType() == RuleSourceType.URL) {
			rule.setValue(visualRule.getRuleSetURL());
		} else {
			rule.setValue(visualRule.getRuleSetSourceCode());
		}
        rule.setResourceType(visualRule.getRuleSetType().getName());
        list.add(rule);
        ruleSet.setRules(list);
        
		RuleMediatorConfig config = new RuleMediatorConfig();
		config.setInput(input);
		config.setOutput(output);
		config.setRuleSet(ruleSet);
		config.setSource(source);
		config.setTarget(target);
		OMElement om = config.toOM();
		
		return om;
	}

}

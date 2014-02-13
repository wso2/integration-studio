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

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.commons.evaluators.Evaluator;
import org.apache.synapse.commons.evaluators.EvaluatorException;
import org.apache.synapse.commons.evaluators.config.EvaluatorSerializerFinder;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.transform.url.RewriteAction;
import org.apache.synapse.mediators.transform.url.RewriteRule;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleActionType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFragmentType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRule;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;
import org.apache.synapse.commons.evaluators.config.EvaluatorSerializer;

public class URLRewriteMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, URLRewriteMediator>{

	public URLRewriteMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.transform.url.URLRewriteMediator, "Unsupported mediator passed in for deserialization at "+ this.getClass());
		
		org.apache.synapse.mediators.transform.url.URLRewriteMediator urlRewriteMediator = (org.apache.synapse.mediators.transform.url.URLRewriteMediator)mediator;
		
		URLRewriteMediator visualURLRewriteMediator = (URLRewriteMediator) DeserializerUtils.createNode(part, EsbElementTypes.URLRewriteMediator_3620);
		setElementToEdit(visualURLRewriteMediator);
		setCommonProperties(urlRewriteMediator, visualURLRewriteMediator);
		
		executeSetValueCommand(URL_REWRITE_MEDIATOR__IN_PROPERTY, urlRewriteMediator.getInputProperty());
		executeSetValueCommand(URL_REWRITE_MEDIATOR__OUT_PROPERTY, urlRewriteMediator.getOutputProperty());
		
		EList<URLRewriteRule> urlRewriteRules=new BasicEList<URLRewriteRule>();
		for(RewriteRule rewriteRule : urlRewriteMediator.getRules()){
			URLRewriteRule urlRewriteRule=EsbFactory.eINSTANCE.createURLRewriteRule();
			EvaluatorExpressionProperty evaluatorExpressionProperty= EsbFactory.eINSTANCE.createEvaluatorExpressionProperty();
			Evaluator evaluator=rewriteRule.getCondition();			
			if (evaluator!=null) {
				OMFactory fac = OMAbstractFactory.getOMFactory();
				EvaluatorSerializer evaluatorSerializer = EvaluatorSerializerFinder.getInstance()
						.getSerializer(evaluator.getName());
				if (evaluatorSerializer != null) {
					OMElement conditionElem = fac.createOMElement("condition", null);
					try {
						evaluatorSerializer.serialize(conditionElem, evaluator);
						String condition = conditionElem.getFirstOMChild().toString();
						evaluatorExpressionProperty.setEvaluatorValue(condition);
						urlRewriteRule.setUrlRewriteRuleCondition(evaluatorExpressionProperty);
					} catch (EvaluatorException e) {
						getLog().warn("", e);
					}
				}
				
			}
			for(RewriteAction rewriteActions : rewriteRule.getActions()){
				URLRewriteRuleAction urlRewriteRuleAction=EsbFactory.eINSTANCE.createURLRewriteRuleAction();
				if(rewriteActions.getActionType()==0){
					urlRewriteRuleAction.setRuleAction(RuleActionType.SET);
				}else if(rewriteActions.getActionType()==1){
					urlRewriteRuleAction.setRuleAction(RuleActionType.APPEND);
				}else if(rewriteActions.getActionType()==2){
					urlRewriteRuleAction.setRuleAction(RuleActionType.PREPEND);
				}else if(rewriteActions.getActionType()==3){
					urlRewriteRuleAction.setRuleAction(RuleActionType.REPLACE);
					// Only 'Replace' action allows regex.
					if (StringUtils.isNotBlank(rewriteActions.getRegex())) {
						urlRewriteRuleAction.setActionRegex(rewriteActions.getRegex());
					}				
				}else if(rewriteActions.getActionType()==4){
					urlRewriteRuleAction.setRuleAction(RuleActionType.REMOVE);
				}
				
				if(rewriteActions.getFragmentIndex()==0){
					urlRewriteRuleAction.setRuleFragment(RuleFragmentType.PROTOCOL);
				}else if(rewriteActions.getFragmentIndex()==1){
					urlRewriteRuleAction.setRuleFragment(RuleFragmentType.USER);
				}else if(rewriteActions.getFragmentIndex()==2){
					urlRewriteRuleAction.setRuleFragment(RuleFragmentType.HOST);
				}else if(rewriteActions.getFragmentIndex()==3){
					urlRewriteRuleAction.setRuleFragment(RuleFragmentType.PATH);
				}else if(rewriteActions.getFragmentIndex()==4){
					urlRewriteRuleAction.setRuleFragment(RuleFragmentType.QUERY);
				}else if(rewriteActions.getFragmentIndex()==5){
					urlRewriteRuleAction.setRuleFragment(RuleFragmentType.REF);
				}else if(rewriteActions.getFragmentIndex()== -1){
					urlRewriteRuleAction.setRuleFragment(RuleFragmentType.PORT);
				}else if(rewriteActions.getFragmentIndex()== -2){
					urlRewriteRuleAction.setRuleFragment(RuleFragmentType.FULL);
				}
				
				if(rewriteActions.getValue()!=null){
					urlRewriteRuleAction.setRuleOption(RuleOptionType.VALUE);
					urlRewriteRuleAction.setActionValue(rewriteActions.getValue());
				}else{
					urlRewriteRuleAction.setRuleOption(RuleOptionType.EXPRESSION);
					urlRewriteRuleAction.setActionExpression(createNamespacedProperty(rewriteActions.getXpath()));
				}
				urlRewriteRule.getRewriteRuleAction().add(urlRewriteRuleAction);
			}
			urlRewriteRules.add(urlRewriteRule);
		}
		executeSetValueCommand(URL_REWRITE_MEDIATOR__URL_REWRITE_RULES, urlRewriteRules);
		
		return visualURLRewriteMediator;
	}

}

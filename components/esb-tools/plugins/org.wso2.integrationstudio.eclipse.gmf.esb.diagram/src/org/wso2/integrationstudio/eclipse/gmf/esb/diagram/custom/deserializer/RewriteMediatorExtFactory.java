/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.Iterator;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.commons.evaluators.Evaluator;
import org.apache.synapse.commons.evaluators.EvaluatorException;
import org.apache.synapse.commons.evaluators.config.EvaluatorFactoryFinder;
import org.apache.synapse.config.xml.SynapseXPathFactory;
import org.apache.synapse.config.xml.URLRewriteMediatorFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.transform.url.RewriteAction;
import org.apache.synapse.mediators.transform.url.RewriteRule;
import org.apache.synapse.mediators.transform.url.URIFragments;
import org.apache.synapse.mediators.transform.url.URLRewriteMediator;
import org.jaxen.JaxenException;

public class RewriteMediatorExtFactory extends URLRewriteMediatorFactory {

    private static final QName ACTION_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "action");
    private static final QName CONDITION_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "condition");
    private static final QName ATT_TYPE = new QName("type");
    private static final QName ATT_FRAGMENT = new QName("fragment");
    
    private static RewriteMediatorExtFactory instance;
    
    private RewriteMediatorExtFactory() {
    }
    
    public static synchronized RewriteMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new RewriteMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new URLRewriteMediator();

        QName RULE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "rewriterule");

        QName ATT_IN_PROPERTY = new QName("inProperty");
        QName ATT_OUT_PROPERTY = new QName("outProperty");

        Iterator rules = omElement.getChildrenWithName(RULE_Q);
        String inputProperty = omElement.getAttributeValue(ATT_IN_PROPERTY);
        String outputProperty = omElement.getAttributeValue(ATT_OUT_PROPERTY);

        if (inputProperty != null) {
            ((URLRewriteMediator) mediator).setInputProperty(inputProperty);
        }
        if (outputProperty != null) {
            ((URLRewriteMediator) mediator).setOutputProperty(outputProperty);
        }

        while (rules.hasNext()) {
            ((URLRewriteMediator) mediator).addRule(parseRule((OMElement) rules.next()));
        }

        processAuditStatus(mediator, omElement);

        return mediator;
    }

    private RewriteRule parseRule(OMElement ruleElement) {
        Iterator actions = ruleElement.getChildrenWithName(ACTION_Q);

        RewriteRule rule = new RewriteRule();
        while (actions.hasNext()) {
            rule.addRewriteAction(parseAction((OMElement) actions.next()));
        }

        OMElement condition = ruleElement.getFirstChildWithName(CONDITION_Q);
        if (condition != null) {
            OMElement child = condition.getFirstElement();
            if (child != null) {
                try {
                    Evaluator eval = EvaluatorFactoryFinder.getInstance().getEvaluator(child);
                    rule.setCondition(eval);
                } catch (EvaluatorException e) {
                    // ignore
                }
            }
        }

        return rule;
    }

    private RewriteAction parseAction(OMElement actionElement) {
        String value = actionElement.getAttributeValue(ATT_VALUE);
        String xpath = actionElement.getAttributeValue(ATT_XPATH);
        String type = actionElement.getAttributeValue(ATT_TYPE);
        QName xpath_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "xpath");

        RewriteAction action = new RewriteAction();
        if (xpath != null) {
            try {
                action.setXpath(SynapseXPathFactory.getSynapseXPath(actionElement, xpath_Q));
            } catch (JaxenException e) {
                // ignore
            }
        } else if (value != null) {
            action.setValue(value);
        }

        String fragment = actionElement.getAttributeValue(ATT_FRAGMENT);
        if (fragment != null) {
            if (FRAGMENT_PROTOCOL.equals(fragment)) {
                action.setFragmentIndex(URIFragments.PROTOCOL);
            } else if (FRAGMENT_USER_INFO.equals(fragment)) {
                action.setFragmentIndex(URIFragments.USER_INFO);
            } else if (FRAGMENT_HOST.equals(fragment)) {
                action.setFragmentIndex(URIFragments.HOST);
            } else if (FRAGMENT_PORT.equals(fragment)) {
                action.setFragmentIndex(URIFragments.PORT);
            } else if (FRAGMENT_PATH.equals(fragment)) {
                action.setFragmentIndex(URIFragments.PATH);
            } else if (FRAGMENT_QUERY.equals(fragment)) {
                action.setFragmentIndex(URIFragments.QUERY);
            } else if (FRAGMENT_REF.equals(fragment)) {
                action.setFragmentIndex(URIFragments.REF);
            } else if (FRAGMENT_FULL_URI.equals(fragment)) {
                action.setFragmentIndex(URIFragments.FULL_URI);
            }
        }

        if (type != null) {
            if (ACTION_SET.equals(type)) {
                action.setActionType(RewriteAction.ACTION_SET);
            } else if (ACTION_APPEND.equals(type)) {
                action.setActionType(RewriteAction.ACTION_APPEND);
            } else if (ACTION_PREPEND.equals(type)) {
                action.setActionType(RewriteAction.ACTION_PREPEND);
            } else if (ACTION_REPLACE.equals(type)) {
                action.setActionType(RewriteAction.ACTION_REPLACE);
                String regex = actionElement.getAttributeValue(ATT_REGEX);
                if (regex != null) {
                    action.setRegex(regex);
                }
            } else if (ACTION_REMOVE.equals(type)) {
                action.setActionType(RewriteAction.ACTION_REMOVE);
            } else {
                action.setActionType(RewriteAction.ACTION_SET);
            }
        }

        return action;
    }

}

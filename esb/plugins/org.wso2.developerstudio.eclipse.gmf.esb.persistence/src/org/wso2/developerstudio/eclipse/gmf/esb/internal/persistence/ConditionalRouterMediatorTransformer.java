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

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.commons.evaluators.Evaluator;
import org.apache.synapse.commons.evaluators.EvaluatorException;
import org.apache.synapse.commons.evaluators.config.EvaluatorFactoryFinder;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.eip.Target;
import org.apache.synapse.mediators.filters.router.ConditionalRoute;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouteBranch;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

/**
 * Conditional router mediator transformer 
 *
 */
public class ConditionalRouterMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
		try {
			information.getParentSequence().addChild(createConditionalRouterMediator(information, subject));
			doTransform(information,
					((ConditionalRouterMediator) subject).getOutputConnector());
		} catch (XMLStreamException e) {
			throw new TransformerException(e);
		} catch (EvaluatorException e) {
			throw new TransformerException(e);
		}
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		

	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject,
			SequenceMediator sequence) throws TransformerException {
		try {
			sequence.addChild(createConditionalRouterMediator(information, subject));
			doTransformWithinSequence(information, ((ConditionalRouterMediator) subject)
					.getOutputConnector().getOutgoingLink(), sequence);
		} catch (XMLStreamException e) {
			throw new TransformerException(e);
		} catch (EvaluatorException e) {
			throw new TransformerException(e);
		}		
	}
	
	private org.apache.synapse.mediators.filters.router.ConditionalRouterMediator createConditionalRouterMediator(
			TransformationInfo information, EsbNode subject) throws XMLStreamException, EvaluatorException{
		
		Assert.isTrue(subject instanceof ConditionalRouterMediator, "Unsupported mediator passed in for serialization");
		ConditionalRouterMediator routerModel = (ConditionalRouterMediator) subject;
		
		org.apache.synapse.mediators.filters.router.ConditionalRouterMediator router = new org.apache.synapse.mediators.filters.router.ConditionalRouterMediator();
		setCommonProperties(router, routerModel);
		router.setContinueAfter(routerModel.isContinueAfterRoute());
		
		EList<ConditionalRouteBranch> routes = routerModel.getConditionalRouteBranches();
		for (ConditionalRouteBranch route : routes) {
			ConditionalRoute conditionalRoute = new ConditionalRoute();
			conditionalRoute.setBreakRoute(route.isBreakAfterRoute());
			OMElement evaluatorExpressionOM = AXIOMUtil.stringToOM(route.getEvaluatorExpression().getEvaluatorValue());
            Evaluator evaluator = EvaluatorFactoryFinder.getInstance().getEvaluator(
            		evaluatorExpressionOM);
            conditionalRoute.setEvaluator(evaluator);
    		Target target = new Target();
    		target.setSequenceRef(route.getTargetSequence().getKeyValue());
    		conditionalRoute.setTarget(target);
    		router.addRoute(conditionalRoute);
		}
		return router;
	}

}

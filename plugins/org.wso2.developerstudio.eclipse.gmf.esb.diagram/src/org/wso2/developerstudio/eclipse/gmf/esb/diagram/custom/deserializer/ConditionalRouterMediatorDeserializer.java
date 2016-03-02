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
import org.apache.synapse.commons.evaluators.config.EvaluatorSerializer;
import org.apache.synapse.commons.evaluators.config.EvaluatorSerializerFinder;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.filters.router.ConditionalRoute;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouteBranch;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class ConditionalRouterMediatorDeserializer extends
		AbstractEsbNodeDeserializer<AbstractMediator, ConditionalRouterMediator> {

	@Override
	public ConditionalRouterMediator createNode(IGraphicalEditPart part, AbstractMediator object) {
		Assert.isTrue(object instanceof org.apache.synapse.mediators.filters.router.ConditionalRouterMediator,
				"Unsupported mediator passed in for deserialization");

		org.apache.synapse.mediators.filters.router.ConditionalRouterMediator mediator = 
			(org.apache.synapse.mediators.filters.router.ConditionalRouterMediator) object;
		ConditionalRouterMediator mediatorModel = (ConditionalRouterMediator) DeserializerUtils
				.createNode(part, EsbElementTypes.ConditionalRouterMediator_3635);
		setElementToEdit(mediatorModel);
		setCommonProperties(mediator, mediatorModel);

		executeSetValueCommand(CONDITIONAL_ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTE,
				mediator.isContinueAfter());

		for (ConditionalRoute route : mediator.getConditionalRoutes()) {
			ConditionalRouteBranch routeBranch = EsbFactory.eINSTANCE
					.createConditionalRouteBranch();
			routeBranch.setBreakAfterRoute(route.isBreakRoute());
			EvaluatorExpressionProperty evaluatorExpression = EsbFactory.eINSTANCE
					.createEvaluatorExpressionProperty();

			EvaluatorSerializer evaluatorSerializer = EvaluatorSerializerFinder.getInstance()
					.getSerializer(route.getEvaluator().getName());
			if (evaluatorSerializer != null) {
				try {
					OMFactory factory = OMAbstractFactory.getOMFactory();
					OMElement root = factory.createOMElement("root", null);
					evaluatorSerializer.serialize(root, route.getEvaluator());
					evaluatorExpression.setEvaluatorValue(root.toString().replaceAll("^<root>", "")
							.replaceAll("</root>$", ""));
					 routeBranch.setEvaluatorExpression(evaluatorExpression);
				} catch (Exception e) {
					// ignored
				}
			}
			if (route.getTarget() != null) {
				RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				regkey.setKeyValue(route.getTarget().getSequenceRef());
				routeBranch.setTargetSequence(regkey);
			}

			executeAddValueCommand(mediatorModel.getConditionalRouteBranches(), routeBranch);
		}

		return mediatorModel;
	}

}

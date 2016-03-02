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

import java.util.List;

import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.eip.Target;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.carbon.mediators.router.impl.Route;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.TargetEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.TargetSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.RouterMediatorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RouterMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class RouterMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, RouterMediator> {

	@Override
	public RouterMediator createNode(IGraphicalEditPart part, AbstractMediator object) {
		Assert.isTrue(object instanceof org.wso2.carbon.mediators.router.impl.RouterMediator,
				"Unsupported mediator passed in for deserialization");

		org.wso2.carbon.mediators.router.impl.RouterMediator mediator = (org.wso2.carbon.mediators.router.impl.RouterMediator) object;
		RouterMediator routerModel = (RouterMediator) DeserializerUtils.createNode(part, EsbElementTypes.RouterMediator_3628);
		refreshEditPartMap();
		setElementToEdit(routerModel);
		executeSetValueCommand(ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTING, mediator.isContinueAfter());

		List<Route> routes = mediator.getRoutes();
		int count =0;
		for (Route route : routes) {
			RouterTargetContainer targetContainer= null;
			RouterMediatorTargetOutputConnector targetOutputConnector=null;
			
			if(count++ == 0 && routerModel.getRouterContainer().getRouterTargetContainer().size()==1){
				targetContainer = routerModel.getRouterContainer().getRouterTargetContainer().get(0);
				targetOutputConnector = routerModel.getTargetOutputConnector().get(0);
			} else{
				targetContainer = (RouterTargetContainer) DeserializerUtils.createNode(
						(IGraphicalEditPart) getEditpart(routerModel.getRouterContainer()),
						EsbElementTypes.RouterTargetContainer_3633);
				targetOutputConnector = (RouterMediatorTargetOutputConnector) DeserializerUtils
						.createNode((IGraphicalEditPart) getEditpart(routerModel),
								EsbElementTypes.RouterMediatorTargetOutputConnector_3631);
			}
			executeSetValueCommand(targetContainer, ROUTER_TARGET_CONTAINER__BREAK_AFTER_ROUTE,
					route.isBreakRouter());
			executeSetValueCommand(targetContainer, ROUTER_TARGET_CONTAINER__ROUTE_EXPRESSION,
					createNamespacedProperty(route.getExpression()));
			executeSetValueCommand(targetContainer, ROUTER_TARGET_CONTAINER__ROUTE_PATTERN, route
					.getMatch().pattern());

			Target target = route.getTarget();
			RouterTarget routerTarget = targetContainer.getTarget();
			
			if(target.getSequence()!=null){
				executeSetValueCommand(routerTarget,ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE, TargetSequenceType.ANONYMOUS);
				refreshEditPartMap();
				IGraphicalEditPart compartment = (IGraphicalEditPart) getEditpart(targetContainer.getMediatorFlow()).getChildren().get(0);
				deserializeSequence(compartment, target.getSequence(), targetOutputConnector);
			} else if (target.getSequenceRef()!=null){
				executeSetValueCommand(routerTarget,ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE, TargetSequenceType.REGISTRY_REFERENCE);
				RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				regkey.setKeyValue(target.getSequenceRef());
				executeSetValueCommand(routerTarget,ABSTRACT_COMMON_TARGET__SEQUENCE_KEY, regkey);
			}
			
			if(target.getEndpoint()!=null){
				executeSetValueCommand(routerTarget,ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE, TargetEndpointType.ANONYMOUS);
				//this feature does not support in current implementation
			} else if (target.getSequenceRef()!=null){
				executeSetValueCommand(routerTarget,ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE, TargetEndpointType.REGISTRY_REFERENCE);
				RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				regkey.setKeyValue(target.getEndpointRef());
				executeSetValueCommand(routerTarget,ABSTRACT_COMMON_TARGET__SEQUENCE_KEY, regkey);
			}
		}
		EditPart editpart = getEditpart(routerModel);
		if (editpart instanceof RouterMediatorEditPart) {
			if (((RouterMediatorEditPart) editpart).reversed) {
				RouterMediatorUtils.reorderWhenRevered(editpart);
			} else {
				RouterMediatorUtils.reorderWhenForward(editpart);
			}
		}
		return routerModel;
	}

}

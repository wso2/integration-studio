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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RouterMediatorContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RouterMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RouterMediatorTargetOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RouterTargetContainerEditPart;

public class RouterMediatorUtils {

	public static void reorderWhenRevered(EditPart editpart){			
		reorder(editpart,PositionConstants.EAST);
	}
	
	public static void reorderWhenForward(EditPart editpart){
		reorder(editpart,PositionConstants.WEST);
	}
	
	private static void reorder(EditPart editpart,int position) {
		ArrayList<RouterTargetContainerEditPart> targetContainers = new ArrayList<RouterTargetContainerEditPart>();
		List<IFigure> outputConnectors = new ArrayList<IFigure>();
		ArrayList<RouterMediatorTargetOutputConnectorEditPart> targetOutputConnectorsList = new ArrayList<RouterMediatorTargetOutputConnectorEditPart>();
		List<BorderItemLocator> outputLocators = new ArrayList<BorderItemLocator>();

		for (int i = 0; i < editpart.getChildren().size(); ++i) {
			EditPart item = (EditPart) editpart.getChildren().get(i);
			if (item instanceof RouterMediatorTargetOutputConnectorEditPart) {
				RouterMediatorTargetOutputConnectorEditPart targetOutputConnectorEditPart = (RouterMediatorTargetOutputConnectorEditPart) editpart
						.getChildren().get(i);
				targetOutputConnectorsList.add(targetOutputConnectorEditPart);
			} else if (item instanceof RouterMediatorContainerEditPart){
				for (int j = 0; j < item.getChildren().size(); ++j) {
					if (item.getChildren().get(j) instanceof RouterTargetContainerEditPart) {
						RouterTargetContainerEditPart targetContainerEditPart = (RouterTargetContainerEditPart) item.getChildren().get(j);
						targetContainers.add(targetContainerEditPart);
					}
				}
			}
		}

		for (int i = 0; i < targetContainers.size(); ++i) {
			if(targetOutputConnectorsList.size()> i){
			IFigure borderItemFigure = targetOutputConnectorsList.get(i).getFigure();
			outputConnectors.add(borderItemFigure);
			BorderItemLocator locator = new FixedBorderItemLocator(targetContainers.get(i)
					.getFigure(), borderItemFigure, position, 0.5);
			outputLocators.add(locator);
			}
		}

		for (int i = 0; i < outputConnectors.size(); ++i) {
			((RouterMediatorEditPart) editpart).getBorderedFigure().getBorderItemContainer()
					.add(outputConnectors.get(i), outputLocators.get(i));
		}
		targetOutputConnectorsList.clear();
		outputLocators.clear();
		if(((RouterMediatorEditPart)editpart).reversed){
			MediatorFigureReverser.reverse(editpart,true);
		}		
	}
	
	public static void addTargetInitially(EditPart child,TransactionalEditingDomain domain) {
		RouterMediatorEditPart routerMediatorEditPart = (RouterMediatorEditPart) child;
		EObject parentContainer = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (routerMediatorEditPart)
				.getModel()).getElement();
		if (((RouterMediator) parentContainer).getTargetOutputConnector().size() == 0) {
			RouterMediatorTargetOutputConnector targetOutputConnector = EsbFactory.eINSTANCE
					.createRouterMediatorTargetOutputConnector();
			AddCommand addTargetConnectorCmd = new AddCommand(domain, parentContainer,
					EsbPackage.Literals.ROUTER_MEDIATOR__TARGET_OUTPUT_CONNECTOR, targetOutputConnector);
			if (addTargetConnectorCmd.canExecute()) {
				domain.getCommandStack().execute(addTargetConnectorCmd);
			}

			RouterTargetContainer targetContainer = EsbFactory.eINSTANCE.createRouterTargetContainer();
			AddCommand addCmd = new AddCommand(domain,
					((RouterMediator) parentContainer).getRouterContainer(),
					EsbPackage.Literals.ROUTER_MEDIATOR_CONTAINER__ROUTER_TARGET_CONTAINER,
					targetContainer);
			if (addCmd.canExecute()) {
				domain.getCommandStack().execute(addCmd);
			}
		}
	}
	
}

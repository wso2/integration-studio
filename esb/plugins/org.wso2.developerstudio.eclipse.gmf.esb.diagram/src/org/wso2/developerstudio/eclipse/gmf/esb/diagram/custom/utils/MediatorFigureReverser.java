/*
 * Copyright WSO2, Inc. (http://wso2.com)
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
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseParentContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AdditionalOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.AggregateMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CacheMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CallMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloneMediatorContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloneMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloneTargetContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ConditionalRouterMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EntitlementMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FilterMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.IterateMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlow12EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlow14EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlow16EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlow17EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlow20EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlow3EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlow4EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlow13EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlow19EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment12EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment14EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment16EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment17EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment20EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment3EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment4EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment13EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment19EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RouterMediatorContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RouterMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RouterTargetContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RuleMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SendMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchCaseContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchCaseParentContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchDefaultContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchDefaultParentContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchMediatorContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ThrottleMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ValidateMediatorEditPart;

public class MediatorFigureReverser {

	public static void reverse(EditPart editorPart, boolean skipSwap) {
		List childFigures = ((IFigure) ((DefaultSizeNodeFigure) ((AbstractMediator) editorPart)
				.getFigure().getChildren().get(0)).getChildren().get(0)).getChildren();
		if (!skipSwap) {
			/*
			 * Swap mediator container and figure container.
			 */
			if (childFigures.get(0) instanceof RoundedRectangle) {
				RoundedRectangle part1 = (RoundedRectangle) childFigures.get(0);
				DefaultSizeNodeFigure part2 = (DefaultSizeNodeFigure) childFigures.get(1);

				childFigures.remove(0);
				childFigures.remove(0);

				childFigures.add(part2);
				childFigures.add(part1);
			}
		}

		/*
		 * Change the direction of the additonalOutputConnector.
		 */
		for (int i = 0; i < ((AbstractMediator) editorPart).getChildren().size(); ++i) {
			if (((AbstractMediator) editorPart).getChildren().get(i) instanceof AdditionalOutputConnector) {
				NodeFigure figureInput = ((AdditionalOutputConnector) editorPart.getChildren().get(
						i)).getNodeFigureOutput();
				figureInput.removeAll();
				figureInput.add(((AdditionalOutputConnector) editorPart.getChildren().get(i))
						.getPrimaryShapeReverse());
			}
		}

		//List children = null;
		List children = new ArrayList();
		List childrenCaseContainer = new ArrayList();
		List childrenDefaultContainer = null;
		if (editorPart instanceof AggregateMediatorEditPart) {
			arrangeType1Compartment(editorPart,
					((AggregateMediatorEditPart) editorPart).onCompleteOutputConnector,
					childFigures);
			/*
			 * Reverse the mediators inside the Aggregate mediator.
			 */
			children = ((MediatorFlowMediatorFlowCompartment3EditPart) ((MediatorFlow3EditPart) editorPart
					.getChildren().get(4)).getChildren().get(0)).getChildren();
		}
		
		if(editorPart instanceof ValidateMediatorEditPart){
			arrangeType1Compartment(editorPart,
					((ValidateMediatorEditPart) editorPart).onFailOutputConnector,
					childFigures);
			/*
			 * Reverse the mediators inside the Validate mediator.
			 */
			children = ((MediatorFlowMediatorFlowCompartment14EditPart) ((MediatorFlow14EditPart) editorPart
					.getChildren().get(3)).getChildren().get(0)).getChildren();
		}
		
		if(editorPart instanceof CacheMediatorEditPart){
			arrangeType1Compartment(editorPart,
					((CacheMediatorEditPart) editorPart).onHitOutputConnector,
					childFigures);
			/*
			 * Reverse the mediators inside the Cache mediator.
			 */
			children = ((MediatorFlowMediatorFlowCompartment13EditPart) ((MediatorFlow13EditPart) editorPart
					.getChildren().get(4)).getChildren().get(0)).getChildren();
		}
		
		/*if(editorPart instanceof ConditionalRouterMediatorEditPart){
			arrangeType1Compartment(editorPart,
					((ConditionalRouterMediatorEditPart) editorPart).additionalOutputConnector,
					childFigures);
			
			 * Reverse the mediators inside the Conditional Router mediator.
			 
			children = ((MediatorFlowMediatorFlowCompartment16EditPart) ((MediatorFlow16EditPart) editorPart
					.getChildren().get(3)).getChildren().get(0)).getChildren();
		}*/
		
		if(editorPart instanceof RuleMediatorEditPart){
			arrangeType1Compartment(editorPart,
					((RuleMediatorEditPart) editorPart).childMediatorsOutputConnector,
					childFigures);
			/*
			 * Reverse the mediators inside the Rule mediator.
			 */
			children = ((MediatorFlowMediatorFlowCompartment17EditPart) ((MediatorFlow17EditPart) editorPart
					.getChildren().get(3)).getChildren().get(0)).getChildren();
		}
		
		
		if(editorPart instanceof IterateMediatorEditPart){
			arrangeType1Compartment(editorPart,
					((IterateMediatorEditPart) editorPart).targetOutputConnector,
					childFigures);
			/*
			 * Reverse the mediators inside the Iterate mediator.
			 */			
			children = ((MediatorFlowMediatorFlowCompartment12EditPart) ((MediatorFlow12EditPart) editorPart
					.getChildren().get(4)).getChildren().get(0)).getChildren();
		}

		if (editorPart instanceof SendMediatorEditPart) {
			arrangeType1Compartment(editorPart,
					((SendMediatorEditPart) editorPart).endpointOutputConnector, childFigures);
			/*
			 * Reverse the mediators inside the Send mediator.
			 */
			children = ((MediatorFlowMediatorFlowCompartment19EditPart) ((MediatorFlow19EditPart) editorPart
					.getChildren().get(3)).getChildren().get(0)).getChildren();
		}
		
		if (editorPart instanceof CallMediatorEditPart) {
			arrangeType1Compartment(editorPart,
					((CallMediatorEditPart) editorPart).endpointOutputConnector, childFigures);
			/*
			 * Reverse the mediators inside the call mediator.
			 */
			children = ((MediatorFlowMediatorFlowCompartment20EditPart) ((MediatorFlow20EditPart) editorPart
					.getChildren().get(3)).getChildren().get(0)).getChildren();
		}


		if (editorPart instanceof FilterMediatorEditPart) {
			if( ((IFigure) ((DefaultSizeNodeFigure) childFigures.get(0)).getChildren()
					.get(0)).getChildren().size()!=0){
			arrangeType2Compartment(editorPart,
					((FilterMediatorEditPart) editorPart).passOutputConnector,
					((FilterMediatorEditPart) editorPart).failOutputConnector, childFigures);
			/*
			 * Reverse the mediators inside the Filter mediator.
			 */
			List containerList = ((EditPart) editorPart.getChildren()
					.get(5)).getChildren();
				if (containerList.size() > 1) {
					// Fixing TOOLS-2018.
					List passChildren = ((EditPart) ((EditPart) ((EditPart) containerList.get(0))
							.getChildren().get(0)).getChildren().get(0)).getChildren();
					if (passChildren != null && passChildren.size() > 0) {
						children.addAll(passChildren);
					}
					if (((EditPart) containerList.get(1)).getChildren() != null
							&& ((EditPart) containerList.get(1)).getChildren().size() > 0) {
						List failChildren = ((EditPart) ((EditPart) ((EditPart) containerList
								.get(1)).getChildren().get(0)).getChildren().get(0)).getChildren();
						children.addAll(failChildren);
					}
					
				} else {
					children = new ArrayList();
				}

			}
		}

		if (editorPart instanceof ThrottleMediatorEditPart) {
			arrangeType2Compartment(editorPart,
					((ThrottleMediatorEditPart) editorPart).onAcceptOutputConnector,
					((ThrottleMediatorEditPart) editorPart).onRejectOutputConnector, childFigures);
			/*
			 * Reverse the mediators inside the Throttle mediator.
			 */
			List containerList = ((EditPart) editorPart.getChildren()
					.get(5)).getChildren();
			if (containerList.size() > 1) {
				// Fixing TOOLS-2018.
				List onAcceptChildren = ((EditPart) ((EditPart) ((EditPart) containerList.get(0)).getChildren()
						.get(0)).getChildren().get(0)).getChildren();
				if (onAcceptChildren != null && onAcceptChildren.size() > 0) {
					children.addAll(onAcceptChildren);
				}			
				if (((EditPart) containerList.get(1)).getChildren() != null
						&& ((EditPart) containerList.get(1)).getChildren().size() > 0) {
					List onRejectChildren = ((EditPart) ((EditPart) ((EditPart) containerList
							.get(1)).getChildren().get(0)).getChildren().get(0)).getChildren();
					children.addAll(onRejectChildren);
				}
				
			} else {
				children = new ArrayList();
			}
			
		}

		if (editorPart instanceof SwitchMediatorEditPart) {
			if (((IFigure) ((DefaultSizeNodeFigure) childFigures.get(0)).getChildren().get(0))
					.getChildren().size() != 0) {
				// Fixing TOOLS-2018.
				List defaultChildren = ((IFigure) ((DefaultSizeNodeFigure) ((IFigure) ((DefaultSizeNodeFigure) childFigures
						.get(0)).getChildren().get(0)).getChildren().get(1)).getChildren()
						.get(0)).getChildren();
				if (defaultChildren != null && defaultChildren.size() > 0) {
					BorderItemLocator locator = new FixedBorderItemLocator(
							(IFigure) defaultChildren.get(0),
							((SwitchMediatorEditPart) editorPart).defaultOutputConnector,
							PositionConstants.EAST, 0.5);
					((SwitchMediatorEditPart) editorPart).getBorderedFigure().getBorderItemContainer()
							.add(((SwitchMediatorEditPart) editorPart).defaultOutputConnector, locator);
				}
				
				for (int i = 0; ((i < ((SwitchMediatorEditPart) editorPart).caseOutputConnectors
						.size()) && (i < (((IFigure) ((DefaultSizeNodeFigure) ((IFigure) ((DefaultSizeNodeFigure) childFigures
						.get(0)).getChildren().get(0)).getChildren().get(0)).getChildren().get(0))
						.getChildren().size()))); ++i) {

					BorderItemLocator caseLocator = new FixedBorderItemLocator(
							(IFigure) ((IFigure) ((DefaultSizeNodeFigure) ((IFigure) ((DefaultSizeNodeFigure) childFigures
									.get(0)).getChildren().get(0)).getChildren().get(0))
									.getChildren().get(0)).getChildren().get(i),
							((SwitchMediatorEditPart) editorPart).caseOutputConnectors.get(i),
							PositionConstants.EAST, 0.5);
					((SwitchMediatorEditPart) editorPart)
							.getBorderedFigure()
							.getBorderItemContainer()
							.add(((SwitchMediatorEditPart) editorPart).caseOutputConnectors.get(i),
									caseLocator);
				}

				for (int j = 0; j < editorPart.getChildren().size(); ++j) {
					if (editorPart.getChildren().get(j) instanceof SwitchMediatorContainerEditPart) {

						List<SwitchCaseContainerEditPart> switchCaseContainerEditPartList = ((SwitchCaseParentContainerEditPart) ((SwitchMediatorContainerEditPart) editorPart
								.getChildren().get(j)).getChildren().get(0)).getChildren();
						for (int p = 0; p < switchCaseContainerEditPartList.size(); ++p) {
							// Fixing TOOLS-2018.
							List caseEditparts =  ((EditPart) switchCaseContainerEditPartList.get(p)).getChildren();
							if (caseEditparts != null && caseEditparts.size() > 0) {
								List caseChildren = ((EditPart) ((EditPart) caseEditparts.get(0)).getChildren().get(0)).getChildren();
								if (caseChildren != null && caseChildren.size() > 0) {
									childrenCaseContainer.addAll(caseChildren);
								}
							}
						}

						List defaultParentChildren = ((SwitchDefaultParentContainerEditPart) ((SwitchMediatorContainerEditPart) editorPart
								.getChildren().get(j)).getChildren().get(1)).getChildren();
						if (defaultParentChildren != null && defaultParentChildren.size() > 0) {
							SwitchDefaultContainerEditPart switchDefaultContainerEditPart = (SwitchDefaultContainerEditPart)defaultParentChildren.get(0);
							childrenDefaultContainer = ((MediatorFlowMediatorFlowCompartment4EditPart) ((MediatorFlow4EditPart) switchDefaultContainerEditPart
									.getChildren().get(0)).getChildren().get(0)).getChildren();
						}
						
						children = childrenCaseContainer;
						break;
					}
				}
			}
		}
			
		if (editorPart instanceof CloneMediatorEditPart) {

			for (int i = 0; (i < ((CloneMediatorEditPart) editorPart).targetOutputConnectors.size()&&(i < (((IFigure) ((DefaultSizeNodeFigure) childFigures
					.get(0)).getChildren().get(0)).getChildren().size()))); ++i) {
				BorderItemLocator targetLocator = new FixedBorderItemLocator(
						(IFigure) ((IFigure) ((DefaultSizeNodeFigure) childFigures.get(0))
								.getChildren().get(0)).getChildren().get(i),
						((CloneMediatorEditPart) editorPart).targetOutputConnectors.get(i),
						PositionConstants.EAST, 0.5);
				((CloneMediatorEditPart) editorPart)
						.getBorderedFigure()
						.getBorderItemContainer()
						.add(((CloneMediatorEditPart) editorPart).targetOutputConnectors.get(i),
								targetLocator);
			}

			for (int j = 0; j < editorPart.getChildren().size(); ++j) {
				if (editorPart.getChildren().get(j) instanceof CloneMediatorContainerEditPart) {

					List<CloneTargetContainerEditPart> cloneTargetContainerEditPartList = ((CloneMediatorContainerEditPart) editorPart
							.getChildren().get(j)).getChildren();
					for (int p = 0; p < cloneTargetContainerEditPartList.size(); ++p) {
						// Fixing TOOLS-2018.
						List targetEditparts = ((EditPart) cloneTargetContainerEditPartList
								.get(p)).getChildren();
						if (targetEditparts != null && targetEditparts.size() > 0) {
							List targetChildren = ((EditPart) ((EditPart) targetEditparts.get(0)).getChildren().get(0)).getChildren();
							if (targetChildren != null && targetChildren.size() > 0) {
								childrenCaseContainer.addAll(targetChildren);
							}
						}
					}

					children = childrenCaseContainer;
					break;
				}
			}
		}
		
		
		
		if (editorPart instanceof RouterMediatorEditPart) {

			for (int i = 0; (i < ((RouterMediatorEditPart) editorPart).targetOutputConnectors.size()&&(i < (((IFigure) ((DefaultSizeNodeFigure) childFigures
					.get(0)).getChildren().get(0)).getChildren().size()))); ++i) {
				BorderItemLocator targetLocator = new FixedBorderItemLocator(
						(IFigure) ((IFigure) ((DefaultSizeNodeFigure) childFigures.get(0))
								.getChildren().get(0)).getChildren().get(i),
						((RouterMediatorEditPart) editorPart).targetOutputConnectors.get(i),
						PositionConstants.EAST, 0.5);
				((RouterMediatorEditPart) editorPart)
						.getBorderedFigure()
						.getBorderItemContainer()
						.add(((RouterMediatorEditPart) editorPart).targetOutputConnectors.get(i),
								targetLocator);
			}

			for (int j = 0; j < editorPart.getChildren().size(); ++j) {
				if (editorPart.getChildren().get(j) instanceof RouterMediatorContainerEditPart) {

					List<RouterTargetContainerEditPart> routerTargetContainerEditPartList = ((RouterMediatorContainerEditPart) editorPart
							.getChildren().get(j)).getChildren();
					for (int p = 0; p < routerTargetContainerEditPartList.size(); ++p) {
						childrenCaseContainer
								.addAll(((EditPart) ((EditPart) ((EditPart) routerTargetContainerEditPartList
										.get(p)).getChildren().get(0)).getChildren().get(0))
										.getChildren());
					}

					children = childrenCaseContainer;
					break;
				}
			}
		}
		
		if (editorPart instanceof EntitlementMediatorEditPart) {
			arrangeType3Compartment(editorPart,childFigures,((EntitlementMediatorEditPart) editorPart).onRejectOutputConnector,
					((EntitlementMediatorEditPart) editorPart).onAcceptOutputConnector,
					((EntitlementMediatorEditPart) editorPart).adviceOutputConnector,
					((EntitlementMediatorEditPart) editorPart).obligationsOutputConnector);
			/*
			 * Reverse the mediators inside the Entitlement mediator.
			 */
			List containerList = ((EditPart) editorPart.getChildren().get(7)).getChildren();
			if (containerList.size() > 1) {
				List mediatorFlow0 = ((EditPart) containerList.get(0)).getChildren();
				if(mediatorFlow0.size()>0){	
					children = ((EditPart) ((EditPart) mediatorFlow0.get(0)).getChildren().get(0)).getChildren();
				}
				List mediatorFlow1 = ((EditPart) containerList.get(1)).getChildren();
				if(mediatorFlow1.size()>0){
					List onAcceptChildren = ((EditPart) ((EditPart) mediatorFlow1.get(0)).getChildren().get(0)).getChildren();
					children.addAll(onAcceptChildren);
				}
				List mediatorFlow2 = ((EditPart) containerList.get(2)).getChildren();
				if(mediatorFlow2.size()>0){
					List adviceChildren = ((EditPart) ((EditPart) mediatorFlow2.get(0)).getChildren().get(0)).getChildren();
					children.addAll(adviceChildren);
				}
				List mediatorFlow3 = ((EditPart) containerList.get(3)).getChildren();
				if(mediatorFlow3.size()>0){
					List obligationsChildren = ((EditPart) ((EditPart) mediatorFlow3.get(0)).getChildren().get(0)).getChildren();
					children.addAll(obligationsChildren);
				}
			} else {
				children = new ArrayList();
			}
			
		}
		
		
		

		if (children != null) {
			for (int i = 0; i < children.size(); ++i) {
				if (children.get(i) instanceof AbstractMediator) {
					((AbstractMediator) children.get(i))
							.reverse((AbstractMediator) children.get(i));
				} else if (children.get(i) instanceof AbstractEndpoint) {
					((AbstractEndpoint) children.get(i))
							.reverse((AbstractEndpoint) children.get(i));
				}
			}
		}
	}

	private static void arrangeType1Compartment(EditPart editpart,
			IFigure outputConnector, List childFigures) {
		if (childFigures.get(0) instanceof DefaultSizeNodeFigure) {
			BorderItemLocator locator = new FixedBorderItemLocator(
					(IFigure) ((DefaultSizeNodeFigure) childFigures.get(0))
							.getChildren().get(0), outputConnector,
					PositionConstants.EAST, 0.5);
			((AbstractMediator) editpart).getBorderedFigure()
					.getBorderItemContainer().add(outputConnector, locator);
		}
	}

	private static void arrangeType2Compartment(EditPart editpart, IFigure outputConnector1,
			IFigure outputConnector2, List childFigures) {
		List children = ((IFigure) ((DefaultSizeNodeFigure) childFigures.get(0)).getChildren()
						.get(0)).getChildren();
		if(children.size()>1){
			BorderItemLocator locator1 = new FixedBorderItemLocator(
					(IFigure) children.get(0), outputConnector1, PositionConstants.EAST,
					0.5);
			((AbstractMediator) editpart).getBorderedFigure().getBorderItemContainer()
					.add(outputConnector1, locator1);

			BorderItemLocator locator2 = new FixedBorderItemLocator(
					(IFigure) children.get(1), outputConnector2, PositionConstants.EAST,
					0.5);
			((AbstractMediator) editpart).getBorderedFigure().getBorderItemContainer()
					.add(outputConnector2, locator2);
		}		
	}
	
	private static void arrangeType3Compartment(EditPart editpart,List childFigures, IFigure... outputConnector) {
		List children = ((IFigure) ((DefaultSizeNodeFigure) childFigures.get(0)).getChildren()
						.get(0)).getChildren();
		if(children.size()>1){
			
			for(int i=0;i<children.size();++i){
				BorderItemLocator locator = new FixedBorderItemLocator(
						(IFigure) children.get(i), outputConnector[i], PositionConstants.EAST,
						0.5);
				((AbstractMediator) editpart).getBorderedFigure().getBorderItemContainer()
						.add(outputConnector[i], locator);
			}
		}		
	}

}

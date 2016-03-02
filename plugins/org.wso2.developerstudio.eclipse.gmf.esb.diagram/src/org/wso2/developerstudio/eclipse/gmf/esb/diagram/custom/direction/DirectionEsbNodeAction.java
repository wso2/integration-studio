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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.ui.IWorkbenchPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.Mediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.AggregateMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.AggregateMediatorOnCompleteOutputConnectorEditPart;

public class DirectionEsbNodeAction  extends AbstractActionHandler {

	protected DirectionEsbNodeAction(IWorkbenchPart part) {
		super(part);
		// TODO Auto-generated constructor stub
	}

	
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

	
	protected void doRun(IProgressMonitor progressMonitor) {
		// TODO Auto-generated method stub
		
	}
	
	public void setEditorPart(EditPart editorPart_){
		
	}
	
	
	protected void Reverse(EditPart editorPart) {

		AbstractMediator selectedEP = (AbstractMediator) editorPart;
		List<IFigure> inputConnectors = new ArrayList<IFigure>();
		List<BorderItemLocator> inputLocators = new ArrayList<BorderItemLocator>();
		List<IFigure> outputConnectors = new ArrayList<IFigure>();
		List<BorderItemLocator> outputLocators = new ArrayList<BorderItemLocator>();
		IFigure inputConnector;
		IFigure outputConnector;
		float inputCount = 0,outputCount=0;
		float inputPosition=0,outputPosition=0;
		
		
		for (int i = 0; i < selectedEP.getChildren().size(); ++i) {
			if (selectedEP.getChildren().get(i) instanceof AbstractMediatorInputConnectorEditPart) {
				++inputCount;
			}
			}
		
		for (int i = 0; i < selectedEP.getChildren().size(); ++i) {
			if (selectedEP.getChildren().get(i) instanceof AbstractMediatorOutputConnectorEditPart) {
				++outputCount;
			}
			}

		for (int i = 0; i < selectedEP.getChildren().size(); ++i) {
			if (selectedEP.getChildren().get(i) instanceof AbstractMediatorInputConnectorEditPart) {

				inputConnector = ((AbstractMediatorInputConnectorEditPart) selectedEP
						.getChildren().get(i)).getFigure();
				inputConnectors.add(inputConnector);
				NodeFigure figureInput = ((AbstractMediatorInputConnectorEditPart) selectedEP
						.getChildren().get(i)).getNodeFigureInput();				
				inputPosition=inputPosition+(1/(inputCount+1));				
				if (selectedEP.getIsForward()) {
					figureInput.removeAll();
					figureInput.add(((AbstractMediatorInputConnectorEditPart) selectedEP
							.getChildren().get(i)).getPrimaryShapeReverse());

					
					BorderItemLocator inputLocator = new FixedBorderItemLocator(
							selectedEP.getMainFigure(), inputConnector,
							PositionConstants.EAST,inputPosition);

					inputLocators.add(inputLocator);
				}
				
				if(!selectedEP.getIsForward()){
					figureInput.removeAll();
					figureInput.add(((AbstractMediatorInputConnectorEditPart) selectedEP
							.getChildren().get(i)).getPrimaryShapeForward());
					BorderItemLocator inputLocator = new FixedBorderItemLocator(
							selectedEP.getMainFigure(), inputConnector,
							PositionConstants.WEST, inputPosition);
					inputLocators.add(inputLocator);
					
				}
				
			}

			if (selectedEP.getChildren().get(i) instanceof AbstractMediatorOutputConnectorEditPart) {

				outputConnector = ((AbstractMediatorOutputConnectorEditPart) selectedEP
						.getChildren().get(i)).getFigure();
				outputConnectors.add(outputConnector);
				NodeFigure figureOutput = ((AbstractMediatorOutputConnectorEditPart) selectedEP
						.getChildren().get(i)).getNodeFigureOutput();
				
				outputPosition=outputPosition+(1/(outputCount+1));
				

				if (selectedEP.getIsForward()) {
					figureOutput.removeAll();
					figureOutput.add(((AbstractMediatorOutputConnectorEditPart) selectedEP
							.getChildren().get(i)).getPrimaryShapeReverse());

					BorderItemLocator outputLocator = new FixedBorderItemLocator(
							selectedEP.getMainFigure(), outputConnector,
							PositionConstants.WEST, outputPosition);

					outputLocators.add(outputLocator);

				}
				if(!selectedEP.getIsForward()){
					figureOutput.removeAll();
					figureOutput.add(((AbstractMediatorOutputConnectorEditPart) selectedEP
							.getChildren().get(i)).getPrimaryShapeForward());
					BorderItemLocator outputLocator = new FixedBorderItemLocator(
							selectedEP.getMainFigure(), outputConnector,
							PositionConstants.EAST, outputPosition);

					outputLocators.add(outputLocator);
					
					
					
				}
				
			}

		}

		//if (selectedEP.getIsForward()) {
			for (int j = 0; j < inputConnectors.size(); ++j) {
				selectedEP.getBorderedFigure().getBorderItemContainer()
						.remove(inputConnectors.get(j));
				selectedEP.getBorderedFigure().getBorderItemContainer()
				.add(inputConnectors.get(j), inputLocators.get(j));
				
				
			}
			for (int j = 0; j < outputConnectors.size(); ++j) {
				selectedEP.getBorderedFigure().getBorderItemContainer()
						.remove(outputConnectors.get(j));
				selectedEP.getBorderedFigure().getBorderItemContainer()
				.add(outputConnectors.get(j), outputLocators.get(j));
				
		
			}
		
			
			if(selectedEP.getIsForward()){
				setText("Forward");
				selectedEP.setIsForward(false);
				SetCommand command = new SetCommand(selectedEP.getEditingDomain(), (Mediator)((org.eclipse.gmf.runtime.notation.impl.NodeImpl)selectedEP.getModel()).getElement(), EsbPackage.Literals.MEDIATOR__REVERSE, true);				
				if (command.canExecute()){
					selectedEP.getEditingDomain().getCommandStack().execute(command);
				} 
				
			}
			else{
				setText("Reverse");
				selectedEP.setIsForward(true);
				SetCommand command = new SetCommand(selectedEP.getEditingDomain(), (Mediator)((org.eclipse.gmf.runtime.notation.impl.NodeImpl)selectedEP.getModel()).getElement(), EsbPackage.Literals.MEDIATOR__REVERSE, false);				
				if (command.canExecute()){
					selectedEP.getEditingDomain().getCommandStack().execute(command);
				} 
			}

		//}

		/*
		 * IFigure inputConnector=
		 * ((AbstractInputConnector)selectedEP.getChildren
		 * ().get(1)).getFigure();
		 * 
		 * IFigure outputConnector
		 * =((AbstractOutputConnector)selectedEP.getChildren
		 * ().get(2)).getFigure();
		 * 
		 * NodeFigure
		 * figureInput=((AbstractInputConnector)selectedEP.getChildren
		 * ().get(1)).figure_; NodeFigure
		 * figureOutput=((AbstractOutputConnector)
		 * selectedEP.getChildren().get(2)).figure_;
		 * 
		 * 
		 * 
		 * 
		 * AbstractEditPart selectedEP = (AbstractEditPart) editorPart; IFigure
		 * inputConnector=
		 * ((LogMediatorInputConnectorEditPart)selectedEP.getChildren
		 * ().get(1)).getFigure();
		 * 
		 * AbstractGraphicalEditPart
		 * 
		 * else{}
		 */
			if(editorPart instanceof AggregateMediatorEditPart){
				IFigure parent=((IFigure)((IFigure)((AggregateMediatorEditPart)editorPart).getFigure().getChildren().get(0)).getChildren().get(0));
				IFigure temp1=(IFigure) parent.getChildren().get(0);
				IFigure temp2=(IFigure) parent.getChildren().get(1);
				parent.remove(temp1);
				parent.remove(temp2);
				GridData constraintImageRectangle1 = new GridData();
				constraintImageRectangle1.verticalAlignment = GridData.FILL_BOTH;
				constraintImageRectangle1.horizontalAlignment = GridData.END;
				constraintImageRectangle1.horizontalIndent = 0;
				constraintImageRectangle1.horizontalSpan = 0;
				constraintImageRectangle1.verticalSpan = 0;
				constraintImageRectangle1.grabExcessHorizontalSpace = true;
				constraintImageRectangle1.grabExcessVerticalSpace = true;
				parent.add(temp2);				
				
				AggregateMediatorOnCompleteOutputConnectorEditPart onCompleteEditPart=(AggregateMediatorOnCompleteOutputConnectorEditPart) ((AggregateMediatorEditPart)editorPart).getChildren().get(4);
				IFigure borderItemFigure = onCompleteEditPart.getFigure();
				
				NodeFigure figureOutput  =onCompleteEditPart.getNodeFigureOutput();
				figureOutput.removeAll();
				figureOutput.add(onCompleteEditPart.getPrimaryShapeReverse());

				BorderItemLocator locator = new FixedBorderItemLocator(
						temp1,borderItemFigure, PositionConstants.WEST, 0.5);				
				((IFigure)((IFigure)((AggregateMediatorEditPart)editorPart).getBorderedFigure()).getChildren().get(1)).add(borderItemFigure, locator);
								
				parent.add(temp1,constraintImageRectangle1);
			}
		
			
	}
}
 
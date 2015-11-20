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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.layout.XYRepossition;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.HighlightOnSelectionEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment11EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment19EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment20EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment5EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartmentEditPart;

public abstract class AbstractEndpoint extends BorderedBorderItemEditPart implements DroppableElement{

	// activete method is called twice for a mediator. Reason is not detected
	// yet.so that we use this variable to avoid calling reverse method twice.
	public boolean reversed = false;
	public static int FigureWidth = 75;
	public static int FigureHeight = 75;
	
	protected boolean connected;

	protected IFigure primaryShape;
	
	private AbstractEndpoint instance=null;
	
	public int x=0;
	public int y=0;
	
	
	public AbstractEndpoint(View view) {
		super(view);
		instance=this;
		// TODO Auto-generated constructor stub
	}
	public void activate() {
		super.activate();		
		if (!reversed)
			reverse(this);		
	}
	
	public IFigure getFigure() {
		IFigure figure = super.getFigure();
		figure.setMaximumSize(new Dimension(FigureWidth, FigureHeight));
		return figure;
	}
	
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(FigureWidth, FigureHeight);
		result.setMinimumSize(new Dimension(FigureWidth, FigureHeight));
		return result;
	}
	
	public void reverse(EditPart editorPart) {		
		if (!reversed & (/*(editorPart.getParent() instanceof EndpointFlowEndpointCompartmentEditPart)&&*/(editorPart.getParent().getParent().getParent() instanceof AbstractMediator)&&(((AbstractMediator)editorPart.getParent().getParent().getParent()).reversed))){
			
			AbstractEndpoint selectedEP = (AbstractEndpoint) editorPart;
			List<IFigure> inputConnectors = new ArrayList<IFigure>();
			List<BorderItemLocator> inputLocators = new ArrayList<BorderItemLocator>();
			List<IFigure> additionalOutputConnectors = new ArrayList<IFigure>();
			IFigure inputConnector;
			IFigure additionalOutputConnector;
			int inputCount = 0, outputCount = 0 , additionalOutputCount=0;
			float inputPosition = 0, additionalOutputPosition=0;

			for (int i = 0; i < selectedEP.getChildren().size(); ++i) {
				if (selectedEP.getChildren().get(i) instanceof AbstractEndpointInputConnectorEditPart) {
					++inputCount;
				}
				
			}

			for (int i = 0; i < selectedEP.getChildren().size(); ++i) {
				if (selectedEP.getChildren().get(i) instanceof AbstractEndpointOutputConnectorEditPart) {
					++outputCount;
				}
			}
			
			for (int i = 0; i < selectedEP.getChildren().size(); ++i) {
				if (selectedEP.getChildren().get(i) instanceof AbstractEndpointAdditionalOutputConnectorEditPart) {
					++additionalOutputCount;
				}
			}
			
			for (int i = 0; i < selectedEP.getChildren().size(); ++i) {
				if (selectedEP.getChildren().get(i) instanceof AbstractEndpointInputConnectorEditPart) {

					inputConnector = ((AbstractEndpointInputConnectorEditPart) selectedEP.getChildren().get(i))
							.getFigure();
					inputConnectors.add(inputConnector);
					NodeFigure figureInput = ((AbstractEndpointInputConnectorEditPart) selectedEP.getChildren()
							.get(i)).getNodeFigureInput();
					inputPosition = (float) 0.5;

					figureInput.removeAll();
					figureInput.add(((AbstractEndpointInputConnectorEditPart) selectedEP.getChildren().get(i))
							.getPrimaryShapeReverse());

					BorderItemLocator inputLocator = new FixedBorderItemLocator(
							selectedEP.getMainFigure(), inputConnector, PositionConstants.EAST,
							inputPosition);

					inputLocators.add(inputLocator);

				}

				if (selectedEP.getChildren().get(i) instanceof AbstractEndpointOutputConnectorEditPart) {
					
					Collection<EObject> collection=new ArrayList<EObject>();
					collection.add(((org.eclipse.gmf.runtime.notation.impl.NodeImpl)((AbstractEndpointOutputConnectorEditPart)selectedEP.getChildren().get(i)).getModel()).getElement());
					DeleteCommand deleteCommand =new DeleteCommand(getEditingDomain(),collection );
					if(deleteCommand.canExecute()){
						getEditingDomain().getCommandStack().execute(deleteCommand);
					}

				}
				
				if (selectedEP.getChildren().get(i) instanceof AbstractEndpointAdditionalOutputConnectorEditPart) {
					additionalOutputConnector = ((AbstractEndpointAdditionalOutputConnectorEditPart) selectedEP.getChildren().get(i))
					.getFigure();					
					additionalOutputConnectors.add(additionalOutputConnector);
					
	/*				
					additionalOutputConnector = ((AbstractEndpointAdditionalOutputConnector) selectedEP.getChildren().get(i))
							.getFigure();
					additionalOutputConnectors.add(additionalOutputConnector);
					NodeFigure figureOutput = ((AbstractEndpointAdditionalOutputConnector) selectedEP.getChildren()
							.get(i)).getNodeFigureOutput();

					additionalOutputPosition = additionalOutputPosition + (1 / (additionalOutputCount + 1));

					figureOutput.removeAll();
					figureOutput.add(((AbstractEndpointAdditionalOutputConnector) selectedEP.getChildren().get(i))
							.getPrimaryShapeReverse());

					BorderItemLocator additionalOutputLocator = new FixedBorderItemLocator(
							selectedEP.getMainFigure(), additionalOutputConnector, PositionConstants.WEST,
							additionalOutputPosition);

					additionalOutputLocators.add(additionalOutputLocator);*/

				}

			}
			for (int j = 0; j < inputConnectors.size(); ++j) {
				selectedEP.getBorderedFigure().getBorderItemContainer()
						.remove(inputConnectors.get(j));
				selectedEP.getBorderedFigure().getBorderItemContainer()
						.add(inputConnectors.get(j), inputLocators.get(j));

			}
			
			for(int j=0;j<additionalOutputConnectors.size();++j){
				IFigure borderItemFigure =additionalOutputConnectors.get(j);
				selectedEP.getBorderedFigure().getBorderItemContainer().add(borderItemFigure,
			               new EvenlyDividedFixedBorderItemLocator(
			                                                       getMainFigure(),
			                                                       borderItemFigure,
			                                                       PositionConstants.WEST,
			                                                       ((DefaultSizeCaseBranchPointerNodeFigure) borderItemFigure).getId(),
			                                                       additionalOutputCount));
			}
			reversed = true;
			
		}
	}
	
	protected void reAllocate(Rectangle bounds){
		Display.getCurrent().asyncExec(new Runnable() {			
			@Override
			public void run() {	
				XYRepossition.resizeContainers((IGraphicalEditPart) instance);
				XYRepossition.reArrange((IGraphicalEditPart) instance);	
			}});
	}
	
	protected void getMostSuitableElementToConnect(){
		if(this.getParent() instanceof MediatorFlowMediatorFlowCompartmentEditPart){ //proxy
			((MediatorFlowMediatorFlowCompartmentEditPart)this.getParent()).connectNormally(this);  
		}else if(this.getParent() instanceof MediatorFlowMediatorFlowCompartment5EditPart){		//sequence
			((MediatorFlowMediatorFlowCompartment5EditPart)this.getParent()).connectNormally(this);  
		}else if(this.getParent() instanceof MediatorFlowMediatorFlowCompartment19EditPart){		//send mediator
			((MediatorFlowMediatorFlowCompartment19EditPart)this.getParent()).connectNormally(this);
		}else if(this.getParent() instanceof MediatorFlowMediatorFlowCompartment20EditPart){		//call mediator
			((MediatorFlowMediatorFlowCompartment20EditPart)this.getParent()).connectNormally(this);
		}else if(this.getParent() instanceof MediatorFlowMediatorFlowCompartment11EditPart){		//clone mediator
			((MediatorFlowMediatorFlowCompartment11EditPart)this.getParent()).connectNormally(this);
		}
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new HighlightOnSelectionEditPolicy()); //selection
	}
	
	@Override
	public EditPolicy getPrimaryDragEditPolicy() {
		return new CustomBorderItemSelectionEditPolicy();
	}
	
	public IFigure getEndPointPrimaryShape() {
		return primaryShape;
	}
	
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
}

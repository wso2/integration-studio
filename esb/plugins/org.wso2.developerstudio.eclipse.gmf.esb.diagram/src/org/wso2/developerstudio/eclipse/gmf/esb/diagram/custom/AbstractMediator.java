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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.BoundsImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.Mediator;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.connections.ConnectionCalculator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.layout.XYRepossition;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.MediatorFigureReverser;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.ESBDebuggerException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceOutSequenceOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.AggregateMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CacheMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CallMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloneMediatorContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloneMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ConditionalRouterMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.DropMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EntitlementMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EsbLinkEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FilterContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FilterMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.IterateMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.LoopBackMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment10EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment11EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment12EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment13EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment14EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment15EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment16EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment17EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment21EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment22EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment23EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment24EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment25EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment26EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment3EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment4EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment5EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment6EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment7EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment8EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment9EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyFaultInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyInSequenceInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyOutSequenceOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RespondMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RouterMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RuleMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SendMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SendMediatorEndpointOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SendMediatorOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequencesOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchCaseParentContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchDefaultParentContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchMediatorContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ThrottleContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ThrottleMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ValidateMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.MediatorFlowMediatorFlowCompartment21CanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.StatusDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.PlatformUI;

public abstract class AbstractMediator extends AbstractBorderedShapeEditPart implements DroppableElement{

	public boolean isForward = true;
	private int i = 0;
	
	private AbstractInputConnectorEditPart connectedInputConnector;
	private AbstractOutputConnectorEditPart connectedOutputConnector;
	private AbstractMediator instance=null;
	
	private boolean breakpointHitStatus = false;
	private boolean isBreakpoint = false;
	private boolean isSkippoint = false;
	
	public int x=0;
	public int y=0;
	
	private String mediatorType= "";
	private String warningAddingMediatorsAfter = "Not allow to add mediators after a ";
	private String warningAddingMediatorsAlreadyAvailableBegin = " Not allow to add a "; 
	private String warningAddingMediatorsAlreadyAvailableEnd = " inside this mediator since there is a send/drop/respond/loopback mediator already presents in the mediator flow";
	private String warningAddingMiddleOfAMediatorFlow = " is not allowed to add in the middle of the mediator flow.";
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	/*
	 * activete method is called twice for a mediator.so that we use this
	 * variable to avoid calling reverse method twice.
	 */
	public boolean reversed = false;

	public AbstractMediator(View view) {
		super(view);
		setIsForward(!((Mediator) view.getElement()).isReverse());
		instance=this;
	}

	/**
	 * 
	 * @return the isBreakpoint
	 */
	public boolean isBreakpoint(){
		return isBreakpoint;
	}
	
	public boolean isSkippoint(){
		return isSkippoint;
	}
	
	/**
	 * 
	 * @param breakpointStatus
	 */
	public void setBreakpointStatus(boolean breakpointStatus) {
		isBreakpoint = breakpointStatus;
	}

	public void setSkippointStatus(boolean skippointStatus) {
		isSkippoint = skippointStatus;

	}
	
	/**
	 * 
	 * @return the breakpointHitStatus
	 */
	public boolean isBreakpointHit(){
		return breakpointHitStatus;
	}
	
	/**
	 * 
	 * @param breakpointHitStatus
	 */
	public void setBreakpointHitStatus(boolean breakpointHitStatus){
		this.breakpointHitStatus=breakpointHitStatus;
	}
	
	protected NodeFigure createMainFigure() {
		return null;
	}

	public boolean getIsForward() {
		return isForward;
	}

	public void setIsForward(boolean isForward_) {
		isForward = isForward_;
	}
	
	public AbstractInputConnectorEditPart getConnectedInputConnector(){
		return connectedInputConnector;
	}
	
	public AbstractOutputConnectorEditPart getConnectedOutputConnector(){
		return connectedOutputConnector;
	}
	
	public void setConnectedInputConnector(AbstractInputConnectorEditPart connectedInputConnector){
		this.connectedInputConnector=connectedInputConnector;
	}
	
	public void setConnectedOutputConnector(AbstractOutputConnectorEditPart connectedOutputConnector){
		this.connectedOutputConnector=connectedOutputConnector;
	}

	public void activate() {
		boolean shouldMoveRight = false;
		super.activate();
		if (!reversed) {
			reverse(this);
		}
		if (i == 0) {
			if (ESBDebuggerUtil.getRecentlyAddedMediator() == null
					&& (!ESBDebuggerUtil.ispageSaveOperationActivated()
							&& !ESBDebuggerUtil
									.isPageChangeOperationActivated() && !ESBDebuggerUtil
								.isPageCreateOperationActivated())) {
				ESBDebuggerUtil.setRecentlyAddedMediator(this);
			} else {

				try {
					if (ESBDebuggerUtil.getRecentlyAddedMediator() != null) {
						ESBDebuggerUtil
								.modifyDebugPointsointsAfterMediatorAddition(ESBDebuggerUtil
										.getRecentlyAddedMediator());
						if (!ESBDebuggerUtil.ispageSaveOperationActivated()
								&& !ESBDebuggerUtil
										.isPageChangeOperationActivated()
								&& !ESBDebuggerUtil
										.isPageCreateOperationActivated()) {
							ESBDebuggerUtil.setRecentlyAddedMediator(this);
						}
					}
				} catch (CoreException | ESBDebuggerException e) {
					log.error("Error while setting recently added mediator : "
							+ e.getMessage(), e);
				}
			}

		}
		/*
		 * activate method is being called twice. At the first time most of the
		 * child figures has not been initialized. So that we should call
		 * MediatorFigureReverser.reverse(EditPart, boolean) at the second time.
		 */
		if ((i == 1)&& this.reversed) {
			MediatorFigureReverser.reverse(this, true);
		}
		if((i == 1)&&(this instanceof SequenceEditPart)) {
			SequenceInputConnectorEditPart seqInputConnectorEditPart=(SequenceInputConnectorEditPart)((SequenceEditPart)this).getChildren().get(1);
			SequenceInputConnector seqInputConnector=(SequenceInputConnector)((org.eclipse.gmf.runtime.notation.impl.NodeImpl)(seqInputConnectorEditPart).getModel()).getElement();
			SequenceOutputConnectorEditPart seqOutputConnectorEditPart=(SequenceOutputConnectorEditPart)((SequenceEditPart)this).getChildren().get(2);
			SequenceOutputConnector seqOutputConnector=(SequenceOutputConnector)((org.eclipse.gmf.runtime.notation.impl.NodeImpl)(seqOutputConnectorEditPart).getModel()).getElement();
			if((seqInputConnector.getIncomingLinks().size() !=0) && (seqInputConnector.getIncomingLinks().get(0).getSource().eContainer() instanceof AbstractEndPoint)){
				if((seqOutputConnector.getOutgoingLink() !=null) && (seqOutputConnector.getOutgoingLink().getTarget().eContainer() instanceof AbstractEndPoint)){
					shouldMoveRight=true;
				}
			}
		}		
		
		if ((i == 1)&& (this instanceof SequenceEditPart)&& shouldMoveRight){
			((SequenceEditPart)this).moveConnectorsRightSide();
		}
		++i;
	}
	
	 public void notifyChanged(Notification notification) {
		 	super.notifyChanged(notification);
		 	if (notification.getFeature() instanceof EAttributeImpl) {
		 		if (notification.getNotifier() instanceof BoundsImpl) {
		 			if (x != 0 && y != 0) {
		 			rePosition(x,y,
		 					((BoundsImpl) notification.getNotifier()).getWidth(),
		 					((BoundsImpl) notification.getNotifier()).getHeight());
		 			FigureCanvas canvas = (FigureCanvas) getViewer().getControl();
		 			canvas.getViewport().repaint();
		 			}
		 		}
		 	}
		 }

	private void rePosition(int x,int y, int width, int height) {
		// TODO Support for other edit parts (proxy)
		//if(!(getParent() instanceof MediatorFlowMediatorFlowCompartmentEditPart)) {
			Rectangle constraints = new Rectangle(x, y, width, height);
			((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), constraints);
		//}
	}
		 
	protected void reAllocate(Rectangle bounds){
		Display.getCurrent().asyncExec(new Runnable() {			
			@Override
			public void run() {	
				XYRepossition.resizeContainers((IGraphicalEditPart) instance);
				XYRepossition.reArrange((IGraphicalEditPart) instance);	
			}});
	}
	
	private boolean shouldReverse() {
		for(int i=0;i<this.getChildren().size();++i){
			if (this.getChildren().get(i) instanceof AbstractMediatorInputConnectorEditPart) {
				AbstractMediatorInputConnectorEditPart inputConnector = (AbstractMediatorInputConnectorEditPart) this.getChildren().get(i);
				if (inputConnector.getTargetConnections().size() != 0) {
					EditPart link = ((EsbLinkEditPart) inputConnector
							.getTargetConnections().get(0)).getSource();
					if ((link instanceof AbstractMediatorOutputConnectorEditPart)
							&& (((AbstractMediatorOutputConnectorEditPart) link).getParent() instanceof AbstractMediator)
							&& (((AbstractMediator) ((AbstractMediatorOutputConnectorEditPart) link)
									.getParent()).reversed)
							|| (link instanceof AbstractEndpointOutputConnectorEditPart) || (link instanceof ProxyOutSequenceOutputConnectorEditPart)
							|| (link instanceof APIResourceOutSequenceOutputConnectorEditPart)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void reverse(EditPart editorPart) {

		if (!reversed
				& (/*(editorPart.getParent() instanceof MediatorFlowMediatorFlowCompartmentEditPart)
						| */(editorPart.getParent() instanceof MediatorFlowMediatorFlowCompartment6EditPart)
						| ((editorPart.getParent() instanceof MediatorFlowMediatorFlowCompartment3EditPart)
								&& (editorPart.getParent().getParent().getParent() instanceof AggregateMediatorEditPart) && (((AbstractMediator) editorPart
								.getParent().getParent().getParent()).reversed))
						| (((editorPart.getParent() instanceof MediatorFlowMediatorFlowCompartment2EditPart) | (editorPart
								.getParent() instanceof MediatorFlowMediatorFlowCompartment4EditPart))
								&& (editorPart.getParent().getParent().getParent().getParent()
										.getParent().getParent() instanceof SwitchMediatorEditPart) && (((AbstractMediator) editorPart
								.getParent().getParent().getParent().getParent().getParent().getParent()).reversed))
						| (((editorPart.getParent() instanceof MediatorFlowMediatorFlowCompartment7EditPart) | (editorPart
								.getParent() instanceof MediatorFlowMediatorFlowCompartment8EditPart))
								&& (editorPart.getParent().getParent().getParent().getParent()
										.getParent() instanceof FilterMediatorEditPart) && (((AbstractMediator) editorPart
								.getParent().getParent().getParent().getParent().getParent()).reversed))								
						| ((editorPart.getParent() instanceof MediatorFlowMediatorFlowCompartment11EditPart)
								&&(editorPart.getParent().getParent().getParent().getParent()
								.getParent() instanceof CloneMediatorEditPart)&&(((AbstractMediator) editorPart
										.getParent().getParent().getParent().getParent().getParent()).reversed))
										
				    	| ((editorPart.getParent() instanceof MediatorFlowMediatorFlowCompartment15EditPart)
								&&(editorPart.getParent().getParent().getParent().getParent()
								.getParent() instanceof RouterMediatorEditPart)&&(((AbstractMediator) editorPart
										.getParent().getParent().getParent().getParent().getParent()).reversed))											
										
						| ((editorPart.getParent() instanceof MediatorFlowMediatorFlowCompartment12EditPart)
								&& (editorPart.getParent().getParent().getParent() instanceof IterateMediatorEditPart) && (((AbstractMediator) editorPart
								.getParent().getParent().getParent()).reversed))										
						| (((editorPart.getParent() instanceof MediatorFlowMediatorFlowCompartment9EditPart) | (editorPart
					        	.getParent() instanceof MediatorFlowMediatorFlowCompartment10EditPart))
					        	&& (editorPart.getParent().getParent().getParent().getParent().getParent() instanceof ThrottleMediatorEditPart) && (((AbstractMediator) editorPart
					                	.getParent().getParent().getParent().getParent().getParent()).reversed))
					    | ((editorPart.getParent() instanceof MediatorFlowMediatorFlowCompartment13EditPart)
					    		&& (editorPart.getParent().getParent().getParent() instanceof CacheMediatorEditPart) && (((AbstractMediator) editorPart
										.getParent().getParent().getParent()).reversed))   
										
						/*| ((editorPart.getParent() instanceof MediatorFlowMediatorFlowCompartment16EditPart)
					    		&& (editorPart.getParent().getParent().getParent() instanceof ConditionalRouterMediatorEditPart) && (((AbstractMediator) editorPart
										.getParent().getParent().getParent()).reversed))*/
										
					    | ((editorPart.getParent() instanceof MediatorFlowMediatorFlowCompartment17EditPart)
					    		&& (editorPart.getParent().getParent().getParent() instanceof RuleMediatorEditPart) && (((AbstractMediator) editorPart
										.getParent().getParent().getParent()).reversed))
										
						| (((editorPart.getParent() instanceof MediatorFlowMediatorFlowCompartment21EditPart) | (editorPart
								.getParent() instanceof MediatorFlowMediatorFlowCompartment22EditPart) | (editorPart.getParent() instanceof MediatorFlowMediatorFlowCompartment23EditPart)
								| (editorPart.getParent() instanceof MediatorFlowMediatorFlowCompartment24EditPart))
								&& (editorPart.getParent().getParent().getParent().getParent()
										.getParent() instanceof EntitlementMediatorEditPart) && (((AbstractMediator) editorPart
								.getParent().getParent().getParent().getParent().getParent()).reversed))										
										
					    | ((editorPart.getParent() instanceof MediatorFlowMediatorFlowCompartment14EditPart)
					    		&& (editorPart.getParent().getParent().getParent() instanceof ValidateMediatorEditPart) && (((AbstractMediator) editorPart
										.getParent().getParent().getParent()).reversed))
					                	|(shouldReverse()))) {

			reverseConnectors(editorPart);		
		}		
	}
	
	/**
	 * Reverse connectors
	 */
	public void reverseConnectors() {
		reverseConnectors(this);
	}

	/**
	 * Reverse connectors
	 * @param editorPart
	 */
	public void reverseConnectors(EditPart editorPart) {
		AbstractMediator selectedEP = (AbstractMediator) editorPart;
		List<IFigure> inputConnectors = new ArrayList<IFigure>();
		List<BorderItemLocator> inputLocators = new ArrayList<BorderItemLocator>();
		List<IFigure> outputConnectors = new ArrayList<IFigure>();
		List<BorderItemLocator> outputLocators = new ArrayList<BorderItemLocator>();
		IFigure inputConnector;
		IFigure outputConnector;
		float inputCount = 0, outputCount = 0;
		float inputPosition = 0, outputPosition = 0;

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

				inputConnector = ((AbstractMediatorInputConnectorEditPart) selectedEP.getChildren().get(i))
						.getFigure();
				inputConnectors.add(inputConnector);
				NodeFigure figureInput = ((AbstractMediatorInputConnectorEditPart) selectedEP.getChildren()
						.get(i)).getNodeFigureInput();
				inputPosition = inputPosition + (1 / (inputCount + 1));

				figureInput.removeAll();
				figureInput.add(((AbstractMediatorInputConnectorEditPart) selectedEP.getChildren().get(i))
						.getPrimaryShapeReverse());

				BorderItemLocator inputLocator = new FixedBorderItemLocator(
						selectedEP.getMainFigure(), inputConnector, PositionConstants.EAST,
						inputPosition);

				inputLocators.add(inputLocator);

			}

			if (selectedEP.getChildren().get(i) instanceof AbstractMediatorOutputConnectorEditPart) {

				outputConnector = ((AbstractMediatorOutputConnectorEditPart) selectedEP.getChildren().get(i))
						.getFigure();
				outputConnectors.add(outputConnector);
				NodeFigure figureOutput = ((AbstractMediatorOutputConnectorEditPart) selectedEP.getChildren()
						.get(i)).getNodeFigureOutput();

				outputPosition = outputPosition + (1 / (outputCount + 1));

				figureOutput.removeAll();
				EsbLink link=((OutputConnector)((Node)((AbstractMediatorOutputConnectorEditPart) selectedEP.getChildren().get(i)).getModel()).getElement()).getOutgoingLink();
				if(link ==null){
				figureOutput.add(((AbstractMediatorOutputConnectorEditPart) selectedEP.getChildren().get(i))
						.getPrimaryShapeReverse());
				}else{
					Figure emptyFigure = new Figure();
					figureOutput.add(emptyFigure);
				}

				BorderItemLocator outputLocator = new FixedBorderItemLocator(
						selectedEP.getMainFigure(), outputConnector, PositionConstants.WEST,
						outputPosition);

				outputLocators.add(outputLocator);

			}

		}

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

		reversed = true;
		if (checkComplexity()) {
			MediatorFigureReverser.reverse(editorPart, false);
		}
		

		if(this instanceof SendMediatorEditPart){
			SendMediator element = (SendMediator) ((Node) ((SendMediatorEditPart) this).getModel()).getElement();
			if (!element.isReverse()) {
				((AbstractMediatorFlowCompartmentEditPart)this.getParent()).removeInSequenceInputConnector((SendMediatorEditPart) this);
				
				SetCommand setCommand = new SetCommand(getEditingDomain(), element,
						EsbPackage.Literals.MEDIATOR__REVERSE, true);
				
				if(setCommand.canExecute()) {
					getEditingDomain().getCommandStack().execute(setCommand);
				}
			}
		}	
	}	

	protected void connectToMostSuitableElement() {

		if(isLockmode()) {
			/*This feature not available in Lock-mode */
			return;
		}
		
		boolean previouslyConnected = false;
		ArrayList<EsbLinkEditPart> esbLinkEditpartList = new ArrayList<EsbLinkEditPart>();
		ArrayList<AbstractConnectorEditPart> outputConnectorEditpartList = new ArrayList<AbstractConnectorEditPart>();
		ArrayList<AbstractConnectorEditPart> inputConnectorEditpartList = new ArrayList<AbstractConnectorEditPart>();
		fillConnectorsLists(esbLinkEditpartList, outputConnectorEditpartList, inputConnectorEditpartList);
		
		EsbLinkEditPart nearestESBLink = ConnectionCalculator.getNearestLinkEditPart(esbLinkEditpartList, this);
		AbstractInputConnectorEditPart nearestInputConnector = (AbstractInputConnectorEditPart)ConnectionCalculator.getNearestConnectorEditPart(inputConnectorEditpartList, this);
		AbstractOutputConnectorEditPart nearestOutputConnector = (AbstractOutputConnectorEditPart)ConnectionCalculator.getNearestConnectorEditPart(outputConnectorEditpartList, this);
		
		AbstractConnectorEditPart nearestEsbLinkOutputConnector = null;
		AbstractConnectorEditPart nearestEsbLinkInputConnector = null;
		if (nearestESBLink != null) {
				nearestEsbLinkOutputConnector = (AbstractConnectorEditPart) nearestESBLink.getSource();
				nearestEsbLinkInputConnector = (AbstractConnectorEditPart) nearestESBLink.getTarget();
		}

		AbstractMediatorInputConnectorEditPart mediatorInputConnector = EditorUtils.getMediatorInputConnector(this);
		AbstractMediatorOutputConnectorEditPart mediatorOutputConnector = EditorUtils.getMediatorOutputConnector(this);
		
		boolean mediatorRestricted = false;
		
		if  (this instanceof SendMediatorEditPart || this instanceof DropMediatorEditPart || this instanceof RespondMediatorEditPart || this instanceof LoopBackMediatorEditPart) {
			EditPart compartment = this.getParent();
//			if (isComplexCompartment(compartment) && restrictAddingOfMediatorInsideComlpexMediators(nearestInputConnector, nearestEsbLinkInputConnector)) {
//					mediatorRestricted = true;
//				if (this instanceof SendMediatorEditPart){
//					mediatorType = "Send Mediator";
//					deleteNewlyAddedMediator(warningAddingMediatorsAlreadyAvailableBegin + mediatorType + warningAddingMediatorsAlreadyAvailableEnd);
//					return;
//					}
//				else if (this instanceof DropMediatorEditPart){
//					mediatorType = "Drop Mediator";
//					deleteNewlyAddedMediator(warningAddingMediatorsAlreadyAvailableBegin + mediatorType + warningAddingMediatorsAlreadyAvailableEnd);
//					return;
//				}
//				else if (this instanceof LoopBackMediatorEditPart){
//					mediatorType = "LoopBack Mediator";
//					deleteNewlyAddedMediator(warningAddingMediatorsAlreadyAvailableBegin + mediatorType + warningAddingMediatorsAlreadyAvailableEnd);
//					return;
//				}			
//			}
			
			if (!mediatorRestricted) {
				if (restrictAddingOfMediator(nearestInputConnector, nearestEsbLinkInputConnector)) {
					mediatorRestricted = true;
				if (this instanceof SendMediatorEditPart){
					mediatorType = "Send Mediator";
					deleteNewlyAddedMediator(mediatorType + warningAddingMiddleOfAMediatorFlow);
					return;
					}
				else if (this instanceof DropMediatorEditPart){
					mediatorType = "Drop Mediator";
					deleteNewlyAddedMediator(mediatorType + warningAddingMiddleOfAMediatorFlow);
					return;
				}
				else if (this instanceof RespondMediatorEditPart){
					mediatorType = "Respond Mediator";
					deleteNewlyAddedMediator(mediatorType + warningAddingMiddleOfAMediatorFlow);
					return;
				}
				else if (this instanceof LoopBackMediatorEditPart){
					mediatorType = "LoopBack Mediator";
					deleteNewlyAddedMediator(mediatorType + warningAddingMiddleOfAMediatorFlow);
					return;
				}
					
				} 
			}
		}
		
		if (!mediatorRestricted) {
			AbstractMediator previousMediator = getPreviousMediator(nearestEsbLinkOutputConnector, nearestOutputConnector);
			if (previousMediator != null && previousMediator != this) {
				AbstractMediator mediator = hasMediator(previousMediator);
				mediatorRestricted = true;
				if (mediator instanceof SendMediatorEditPart){			   
					mediatorType = "Send Mediator";
					deleteNewlyAddedMediator(warningAddingMediatorsAfter + mediatorType);
					return;
				}
				else if (mediator instanceof DropMediatorEditPart){
					mediatorType = "Drop Mediator";
					deleteNewlyAddedMediator(warningAddingMediatorsAfter + mediatorType);
					return;
				}
				else if (mediator instanceof RespondMediatorEditPart){
					EditPart compartment = mediator.getParent();
					if (!isComplexCompartment(compartment)){
					mediatorType = "Respond Mediator";
					deleteNewlyAddedMediator(warningAddingMediatorsAfter + mediatorType);
					return;
					}
				}
				else if (mediator instanceof LoopBackMediatorEditPart){
					mediatorType = "LoopBack Mediator";
					deleteNewlyAddedMediator(warningAddingMediatorsAfter + mediatorType);
					return;
				}
			}
		}

				
		if (nearestESBLink == null) {
			if ((nearestOutputConnector != null)) {
				
				if (nearestOutputConnector instanceof SendMediatorEndpointOutputConnectorEditPart
					|| nearestOutputConnector instanceof SendMediatorOutputConnectorEditPart) {
					if (!mediatorRestricted) {
						mediatorRestricted = true;
						deleteNewlyAddedMediator(null); // restrict mediators after send mediator
						return;
					}
				} else {
					previouslyConnected = connectToNearestConnector(nearestOutputConnector);
					updateCurrentStates(mediatorOutputConnector);
				}
			}

			if ((nearestInputConnector != null)) {
				connectToNearestConnector(nearestInputConnector);
			}
		} 
		
		if (!previouslyConnected) {
			if (nearestESBLink != null) {
				
				if (!isValidMediatorAddition(nearestEsbLinkOutputConnector, nearestEsbLinkInputConnector) && !mediatorRestricted) {
					deleteNewlyAddedMediator(null);
					return;
				}
				
				if ((!(nearestEsbLinkOutputConnector instanceof ProxyOutputConnectorEditPart))
						&& (!(nearestEsbLinkOutputConnector instanceof ProxyOutSequenceOutputConnectorEditPart))
						&& (!(nearestEsbLinkOutputConnector instanceof SequencesOutputConnectorEditPart))
						&&(!(nearestEsbLinkOutputConnector instanceof APIResourceOutputConnectorEditPart))
						&& (!(nearestEsbLinkOutputConnector instanceof APIResourceOutSequenceOutputConnectorEditPart))
						&& (!nearestEsbLinkOutputConnector.getParent().getParent()
								.equals(this.getParent()))
						&&(!EditorUtils.getMediator(nearestEsbLinkOutputConnector).equals(EditorUtils.getMediator(this.getParent())))) {
					nearestESBLink = null;
					connectNormally();
				}
			} else {
				connectNormally();
			}

			if (nearestESBLink != null) {
				Collection col = new ArrayList();
				col.add(((org.eclipse.gmf.runtime.notation.impl.ConnectorImpl) nearestESBLink
						.getModel()).getElement());

				org.eclipse.emf.edit.command.DeleteCommand del = new org.eclipse.emf.edit.command.DeleteCommand(
						getEditingDomain(), col);
				if (del.canExecute()) {
					getEditingDomain().getCommandStack().execute(del);
				}

			}

			if (nearestESBLink != null) {
				DeleteCommand delCmd = new DeleteCommand(nearestESBLink
						.getNotationView());
				CompoundCommand dl = new CompoundCommand("Delete Link");
				dl.add(new ICommandProxy(delCmd));
				if (delCmd.canExecute()) {
					getDiagramEditDomain().getDiagramCommandStack().execute(dl);
				}
			}

			ConnectionUtils.createConnection(mediatorInputConnector, nearestEsbLinkOutputConnector);
			ConnectionUtils.createConnection(nearestEsbLinkInputConnector, mediatorOutputConnector);
		}
	}
	
	
	private void fillConnectorsLists(ArrayList<EsbLinkEditPart> esbLinkEditpartList,
			ArrayList<AbstractConnectorEditPart> outputConnectorEditpartList,
			ArrayList<AbstractConnectorEditPart> inputConnectorEditpartList) {
		for (int i = 0; i < getViewer().getEditPartRegistry().size(); ++i) {

			EditPart element = (EditPart) getViewer().getEditPartRegistry()
					.values().toArray()[i];

			if (element instanceof EsbLinkEditPart) {	
				/*
				 * Fixing TOOLS-1410 
				 */
/*				if((EditorUtils.getMediator(((EsbLinkEditPart)element).getSource())!=null)&&
						(EditorUtils.getMediator(this.getParent())!=null)){
					
					if(!(EditorUtils.getMediator(((EsbLinkEditPart)element).getSource())).equals(EditorUtils.getMediator(this.getParent()))
							||(((EsbLinkEditPart)element).getSource().getParent().getParent().equals(this.getParent()))){
						continue;
					}
				}else*/ if(EditorUtils.getEndpoint((AbstractConnectorEditPart) ((EsbLinkEditPart)element).getSource())!=null){
					if(!((EsbLinkEditPart)element).getSource().getParent().getParent().equals(this.getParent())){
						continue;
					}
				}
				esbLinkEditpartList.add((EsbLinkEditPart) element);
				
			} else if (element instanceof AbstractOutputConnectorEditPart) {

				if (((AbstractOutputConnectorEditPart) element).getParent()
						.getParent().equals(this.getParent())) {
					outputConnectorEditpartList
							.add((AbstractOutputConnectorEditPart) element);

				} else if (((AbstractOutputConnectorEditPart) element)
						.getParent().equals(
								this.getParent().getParent().getParent()
										.getParent().getParent())) {
					/*
					 * for proxy service output Connector
					 */
					outputConnectorEditpartList
							.add((AbstractOutputConnectorEditPart) element);

				} else if (((AbstractOutputConnectorEditPart) element)
						.getParent().equals(
								this.getParent().getParent().getParent())) {
					/*
					 * for sequences output Connector
					 */

					outputConnectorEditpartList
							.add((AbstractOutputConnectorEditPart) element);

				} else if (((AbstractOutputConnectorEditPart) element)
						.getParent().equals(
								this.getParent().getParent().getParent()
										.getParent().getParent().getParent())) {
					/*
					 * Switch mediator case or default branch.
					 * Fixing TOOLS-2347.
					 */
					outputConnectorEditpartList
							.add((AbstractOutputConnectorEditPart) element);

				}
			} else if (element instanceof AbstractInputConnectorEditPart) {
				if (((AbstractInputConnectorEditPart) element).getParent()
						.getParent().equals(this.getParent())) {
					inputConnectorEditpartList
							.add((AbstractInputConnectorEditPart) element);
				} else if (((AbstractInputConnectorEditPart) element)
						.getParent().equals(
								this.getParent().getParent().getParent()
										.getParent().getParent())) {
					/*
					 * for proxy service input Connector
					 */
					if (((this.getParent() instanceof MediatorFlowMediatorFlowCompartment6EditPart) && ((AbstractInputConnectorEditPart) element instanceof ProxyFaultInputConnectorEditPart))
							|| ((this.getParent() instanceof MediatorFlowMediatorFlowCompartmentEditPart) && ((AbstractInputConnectorEditPart) element instanceof ProxyInputConnectorEditPart))
							|| ((this.getParent() instanceof MediatorFlowMediatorFlowCompartmentEditPart) && ((AbstractInputConnectorEditPart) element instanceof APIResourceInputConnectorEditPart))) {
						inputConnectorEditpartList
								.add((AbstractInputConnectorEditPart) element);
					}
				} else if (((AbstractInputConnectorEditPart) element)
						.getParent().equals(
								this.getParent().getParent().getParent())) {
					/*
					 * for sequences input Connector
					 */
					inputConnectorEditpartList
							.add((AbstractInputConnectorEditPart) element);
				}

			}
		}
	}
	
	
	private void connectNormally(){
		if(this.getParent() instanceof MediatorFlowMediatorFlowCompartmentEditPart){
			((MediatorFlowMediatorFlowCompartmentEditPart)this.getParent()).connectNormally(this);
		}else if(this.getParent() instanceof MediatorFlowMediatorFlowCompartment5EditPart){
			((MediatorFlowMediatorFlowCompartment5EditPart)this.getParent()).connectNormally(this);
		}else if(this.getParent() instanceof MediatorFlowMediatorFlowCompartment6EditPart){
			((MediatorFlowMediatorFlowCompartment6EditPart)this.getParent()).connectNormally(this);
		}else if(this.getParent() instanceof MediatorFlowMediatorFlowCompartment25EditPart){
			((MediatorFlowMediatorFlowCompartment25EditPart)this.getParent()).connectNormally(this);
		}else if(this.getParent() instanceof MediatorFlowMediatorFlowCompartment26EditPart){
			((MediatorFlowMediatorFlowCompartment26EditPart)this.getParent()).connectNormally(this);
		}
	}
	
	private void updateCurrentStates(AbstractMediatorOutputConnectorEditPart currentOutputConnector){
		if(this.getParent() instanceof MediatorFlowMediatorFlowCompartmentEditPart){
			((MediatorFlowMediatorFlowCompartmentEditPart)this.getParent()).setOutputConnectorEditPart(currentOutputConnector);
			((MediatorFlowMediatorFlowCompartmentEditPart)this.getParent()).setSourceEditPart(this);
		}else if(this.getParent() instanceof MediatorFlowMediatorFlowCompartment5EditPart){
			((MediatorFlowMediatorFlowCompartment5EditPart)this.getParent()).setOutputConnectorEditPart(currentOutputConnector);
			((MediatorFlowMediatorFlowCompartment5EditPart)this.getParent()).setSourceEditPart(this);
		}
	}

	private boolean checkComplexity() {
		if ((this instanceof AggregateMediatorEditPart) || (this instanceof SwitchMediatorEditPart)
				|| (this instanceof FilterMediatorEditPart)
				|| (this instanceof SendMediatorEditPart)
				|| (this instanceof CallMediatorEditPart)
				|| (this instanceof ThrottleMediatorEditPart)
				|| (this instanceof CacheMediatorEditPart)
				|| (this instanceof CloneMediatorEditPart)
				|| (this instanceof IterateMediatorEditPart)
				|| (this instanceof ValidateMediatorEditPart)
				|| (this instanceof RouterMediatorEditPart)
				//|| (this instanceof ConditionalRouterMediatorEditPart)
				|| (this instanceof EntitlementMediatorEditPart)
				|| (this instanceof RuleMediatorEditPart)) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean connectToNearestConnector(AbstractConnectorEditPart nearestConnector){
		AbstractConnectorEditPart currentInputConnector = null;
		AbstractConnectorEditPart currentOutputConnector=null;
		AbstractConnectorEditPart target=null;
		AbstractConnectorEditPart source=null;
		
		currentInputConnector=EditorUtils.getInputConnector(this);
		currentOutputConnector=EditorUtils.getOutputConnector(this);

		
		if(nearestConnector instanceof AbstractOutputConnectorEditPart){
			source=nearestConnector;
			target=currentInputConnector;
		}else if(nearestConnector instanceof AbstractInputConnectorEditPart){
			source=currentOutputConnector;
			target=nearestConnector;
		}
		
		return ConnectionUtils.createConnection(target, source);
	}
	
	protected boolean isLockmode() {
		return EditorUtils.isLockmode(this);
	}
	
	
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}
	
	private SendMediator getSendMediatorBybackTraverse(AbstractEndpointOutputConnectorEditPart outputConnector) {
		
		SendMediator sendMediator = null;
		AbstractMediator mediator = getSecondLastMediatorBybackTraverse(outputConnector);
		if (mediator != null) {
			if (mediator instanceof SendMediatorEditPart){
				SendMediatorEditPart sendMediatorEditPart = (SendMediatorEditPart)mediator;
				sendMediator = (SendMediator)((Node)sendMediatorEditPart.getModel()).getElement();
			}
		}
		return sendMediator;
	}
	
	private AbstractMediator getSecondLastMediatorBybackTraverse(AbstractEndpointOutputConnectorEditPart outputConnector) {
		
		AbstractMediator mediator = null;
		
		AbstractEndpoint endpoint = EditorUtils.getEndpoint(outputConnector);
		AbstractInputConnectorEditPart endpointInputConnector = EditorUtils.getInputConnector(endpoint);
		List<AbstractGraphicalEditPart> conectedEdbLinkstoInputConnector = endpointInputConnector.getTargetConnections();
		if (conectedEdbLinkstoInputConnector != null && conectedEdbLinkstoInputConnector.size() > 0) {
			
			EsbLinkEditPart linkFromSend = (EsbLinkEditPart)conectedEdbLinkstoInputConnector.get(0); //wrong assumption, what if more than one
			EditPart sendMediatorOutputConnector = linkFromSend.getSource();
			mediator = EditorUtils.getMediator(sendMediatorOutputConnector);
			
		}
		return mediator;
	}
	
	private Sequence getSequenceMediatorFrom(AbstractOutputConnectorEditPart outputConnector) {
		
		EditPart node = (ShapeNodeEditPart) ((EsbLinkEditPart) outputConnector.getSourceConnections().get(0)).getTarget().getParent();
		Sequence sequenceMediator = (Sequence)((Node)node.getModel()).getElement();
		return sequenceMediator;
	}
	
	private Sequence getSequenceMediatorByBackTraverse(AbstractOutputConnectorEditPart outputConnector) {
		
		SequenceEditPart sequenceEditPart = (SequenceEditPart) EditorUtils.getMediator(outputConnector);
		Sequence sequenceMediator = (Sequence)((Node)sequenceEditPart.getModel()).getElement();
		return sequenceMediator;
	}
	
	
	private void deleteNewlyAddedMediator(String reason) {
		if(this instanceof SendMediatorEditPart){
			if(this.getParent() !=null){
				((AbstractMediatorFlowCompartmentEditPart)this.getParent()).removeInSequenceInputConnector((SendMediatorEditPart)this);
			}
		}
		RemoveCommand removeCmd = new RemoveCommand(this.getEditingDomain(), 
													((Node)this.getModel()).getElement().eContainer(),
													EsbPackage.Literals.MEDIATOR_FLOW__CHILDREN, 
													((Node)this.getModel()).getElement());

		if (removeCmd.canExecute()) {
			this.getEditingDomain().getCommandStack().execute(removeCmd);
		}
		
		if (!reason.isEmpty()) {
			showMediatorRestrictionMessage(reason);
		}
	}
	
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}

	
	private boolean restrictAddingOfMediatorInsideComlpexMediators(AbstractInputConnectorEditPart nearestInputConnector, AbstractConnectorEditPart nearestEsbLinkInputConnector) {
		
		boolean restricted = false;
		EditPart compartment = this.getParent();
	
		while (isComplexCompartment(compartment)) {
			EditPart complexMediator = EditorUtils.getComplexMediator(compartment);
			boolean hasNext = hasNextMediator(complexMediator);
			restricted = restricted | hasNext;
			compartment = complexMediator.getParent();
		} 
		return restricted;
	}
	
	private boolean restrictAddingOfMediator(AbstractInputConnectorEditPart nearestInputConnector, AbstractConnectorEditPart nearestEsbLinkInputConnector) {
		boolean restricted = false;
		AbstractMediator nextMmediator;
		if(nearestEsbLinkInputConnector != null){
			nextMmediator = EditorUtils.getMediator(nearestEsbLinkInputConnector);
		}else{
			nextMmediator = EditorUtils.getMediator(nearestInputConnector);
		}
		if (/*nearestInputConnector != null || */nextMmediator != null && nextMmediator!=this) {
			if (!EditorUtils.isAChildOf(nextMmediator, this)) {
				restricted = true;
			}
		}
		return restricted;
	}
	
	boolean isComplexCompartment(EditPart compartment) {
		if(compartment instanceof MediatorFlowMediatorFlowCompartment7EditPart 		// filter pass
				|| compartment instanceof MediatorFlowMediatorFlowCompartment8EditPart		// filter fail
				|| compartment instanceof MediatorFlowMediatorFlowCompartment9EditPart		// throttle onaccept
				|| compartment instanceof MediatorFlowMediatorFlowCompartment10EditPart	// throttle onreject
				|| compartment instanceof MediatorFlowMediatorFlowCompartment2EditPart		// switch case
				|| compartment instanceof MediatorFlowMediatorFlowCompartment4EditPart		// switch default
				|| compartment instanceof MediatorFlowMediatorFlowCompartment11EditPart // clone target
				|| compartment instanceof MediatorFlowMediatorFlowCompartment21EditPart // entitlement onReject
				|| compartment instanceof MediatorFlowMediatorFlowCompartment22EditPart // entitlement onAccept
				|| compartment instanceof MediatorFlowMediatorFlowCompartment23EditPart // entitlement advice
				|| compartment instanceof MediatorFlowMediatorFlowCompartment24EditPart) { // entitlement obligations				
			return true;
		}
		return false;
	}

	private boolean hasNextMediator(EditPart complexMediator) {
		boolean hasNext = false;
		AbstractMediatorOutputConnectorEditPart complexMediatorOutputConnector = 
				(AbstractMediatorOutputConnectorEditPart)EditorUtils.getMediatorOutputConnector((ShapeNodeEditPart)complexMediator);
		if (complexMediatorOutputConnector != null) {
			List conectionsList = complexMediatorOutputConnector.getSourceConnections();
			if (conectionsList.size() > 0) {
				EsbLinkEditPart link = (EsbLinkEditPart)conectionsList.get(0);
				EditPart nextMmediator = link.getTarget().getParent();
				if (nextMmediator != null && nextMmediator instanceof AbstractMediator) {
					hasNext = true;
				}
			}
		}
		return hasNext;
	}
	
 	private void showMediatorRestrictionMessage(String reason) {
		String errorMsgHeader = "Warning !";
		IStatus editorStatus = new Status(IStatus.WARNING, Activator.PLUGIN_ID, reason);
		ErrorDialog.openError(Display.getCurrent().getActiveShell(), "Warning ", errorMsgHeader, editorStatus);
 	}
	
	
	private AbstractMediator getPreviousMediator(AbstractConnectorEditPart nearestEsbLinkOutputConnector, 
			AbstractOutputConnectorEditPart nearestOutputConnector) {
		AbstractMediator previousMediator = null;
		if (nearestEsbLinkOutputConnector != null) {
			if (!(nearestEsbLinkOutputConnector instanceof AdditionalOutputConnector)) {
				previousMediator = EditorUtils.getMediator(nearestEsbLinkOutputConnector);
			}
		} else if (nearestOutputConnector != null) {
			if (!(nearestOutputConnector instanceof AdditionalOutputConnector)) {
				previousMediator = EditorUtils.getMediator(nearestOutputConnector);
			}
		}
		
		//Handle incorrect previous mediator returns 
		//Ignore if previous mediator is parent mediator
		if (previousMediator != null) {
			if (EditorUtils.isAChildOf(previousMediator, this)) {
				previousMediator = null;
			}
		}
		
		return previousMediator;
	}
	
	private AbstractMediator hasMediator(AbstractMediator mediator){
		AbstractMediator existingMediator = null;
		
		//TO DO - Handle for Drop Mediator
		if(mediator instanceof SendMediatorEditPart || mediator instanceof RespondMediatorEditPart || mediator instanceof LoopBackMediatorEditPart){
			existingMediator = mediator;
			return existingMediator;
		}
		else if (mediator instanceof MultipleCompartmentComplexFiguredAbstractMediator) {
			ShapeNodeEditPart childContainer = EditorUtils.getChildContainer((MultipleCompartmentComplexFiguredAbstractMediator)mediator);
			List<EditPart> childEditParts = new ArrayList<EditPart>();
			
			if (childContainer instanceof SwitchMediatorContainerEditPart) {
				List<EditPart> caseEditParts = ((SwitchCaseParentContainerEditPart)childContainer.getChildren().get(0)).getChildren();
				List<EditPart> defaultEditParts = ((SwitchDefaultParentContainerEditPart)childContainer.getChildren().get(1)).getChildren();
				for (EditPart caseEditPart : caseEditParts) {
					childEditParts.add(caseEditPart);
				}
				for (EditPart defaultEditPart : defaultEditParts) {
					childEditParts.add(defaultEditPart);
				}
			} else {
				childEditParts =  childContainer.getChildren();
			}
			
			for (EditPart editPart : childEditParts) {
			IGraphicalEditPart mediatorFlow = (IGraphicalEditPart)editPart.getChildren().get(0);
			IGraphicalEditPart mediatorFlowCompartment = (IGraphicalEditPart)mediatorFlow.getChildren().get(0);
				if (mediatorFlowCompartment.getChildren().size() >= 1) {
					for (int i = 0; i < mediatorFlowCompartment.getChildren().size(); ++i) {
						GraphicalEditPart gep = (GraphicalEditPart) mediatorFlowCompartment.getChildren().get(i);
						//TO DO - Handle for Drop Mediator
						if (gep instanceof SendMediatorEditPart|| gep instanceof RespondMediatorEditPart || gep instanceof LoopBackMediatorEditPart) {
			             return (AbstractMediator) gep;
						} else if (gep instanceof MultipleCompartmentComplexFiguredAbstractMediator) {
							existingMediator = hasMediator((MultipleCompartmentComplexFiguredAbstractMediator)gep);						
							if (existingMediator != null) {
							return existingMediator;
							}
						}
					}
				}
			}
		}
		return existingMediator;
				
	}
	
	private boolean isValidMediatorAddition(
			AbstractConnectorEditPart nearestEsbLinkOutputConnector,
			AbstractConnectorEditPart nearestEsbLinkInputConnector) {
		
		boolean isValid = true;
		if (nearestEsbLinkOutputConnector instanceof SendMediatorOutputConnectorEditPart && nearestEsbLinkInputConnector instanceof AbstractEndpointInputConnectorEditPart) {
			return false;
		}
		
		if (nearestEsbLinkOutputConnector instanceof AbstractEndpointOutputConnectorEditPart && nearestEsbLinkInputConnector instanceof SequenceInputConnectorEditPart) {
			Sequence seq = getSequenceMediatorFrom((AbstractEndpointOutputConnectorEditPart) nearestEsbLinkOutputConnector);
			if (seq.isDuplicate()) {
				return false;
			}
		}
		
		if (nearestEsbLinkOutputConnector instanceof SequenceOutputConnectorEditPart && nearestEsbLinkInputConnector instanceof AbstractEndpointInputConnectorEditPart){
				Sequence seq = getSequenceMediatorByBackTraverse((SequenceOutputConnectorEditPart) nearestEsbLinkOutputConnector);
				if (seq.isDuplicate()) {
					return false;
				}
		}
		
		return isValid;
	}


//	public void resetHasSendMediatorAsaChildProperty() {
//		EditPart compartment = this.getParent();
//		while (isComplexCompartment(compartment)) {
//			AbstractMediator complexMediator = (AbstractMediator)EditorUtils.getComplexMediator(compartment);
//			complexMediator.hasSendMediatorAsaChild = false;
//			compartment = complexMediator.getParent();
//		}
//	}
}

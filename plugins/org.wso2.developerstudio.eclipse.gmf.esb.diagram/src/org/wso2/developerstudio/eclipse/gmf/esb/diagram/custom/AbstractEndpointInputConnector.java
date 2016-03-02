package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractInputConnector.EastPointerFigure;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractInputConnector.WestPointerFigure;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EsbLinkEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SendMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SendMediatorEndpointOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceEditPart;

public abstract class AbstractEndpointInputConnector extends AbstractBorderItemEditPart {

	public NodeFigure figure_;
	protected IFigure primaryShapeForward;
	protected IFigure primaryShapeReverse;
	
	public AbstractEndpointInputConnector(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}
	
	public NodeFigure getNodeFigureInput() {
		return figure_;
	}
	
	protected IFigure createNodeShapeForward() {
		return primaryShapeForward = new EastPointerFigure();
	}

	protected IFigure createNodeShapeReverse() {
		return primaryShapeReverse = new WestPointerFigure();
	}


	public EastPointerFigure getPrimaryShapeForward() {
		return (EastPointerFigure) primaryShapeForward;
	}

	public WestPointerFigure getPrimaryShapeReverse() {
		return (WestPointerFigure) primaryShapeReverse;

	}
	
	public void notifyChanged(Notification notification) {
		int direction=-1;
		super.notifyChanged(notification);
		if(notification.getEventType()==Notification.ADD){
				if(this.getTargetConnections().size()!=0){			
					EditPart link=((EsbLinkEditPart)this.getTargetConnections().get(0)).getSource();
					if((link instanceof AbstractEndpointAdditionalOutputConnector)|(link instanceof SendMediatorEndpointOutputConnectorEditPart)){						
						for(int j=0;j<this.getParent().getChildren().size();++j){
							if(this.getParent().getChildren().get(j) instanceof AbstractEndpointOutputConnector){
								Collection<EObject> collection=new ArrayList<EObject>();
								collection.add(((org.eclipse.gmf.runtime.notation.impl.NodeImpl)((AbstractEndpointOutputConnector)this.getParent().getChildren().get(j)).getModel()).getElement());
								DeleteCommand deleteCommand =new DeleteCommand(getEditingDomain(),collection );
								if(deleteCommand.canExecute()){
									getEditingDomain().getCommandStack().execute(deleteCommand);
								}	
								
								if(((EsbLinkEditPart)this.getTargetConnections().get(0)).getSource().getParent() instanceof SendMediatorEditPart){
									if(((AbstractMediator)((EsbLinkEditPart)this.getTargetConnections().get(0)).getSource().getParent()).reversed){	
										 direction=PositionConstants.EAST;										
									}
									else {
										 direction=PositionConstants.WEST;
									}									
								}
								else{
										 direction=PositionConstants.WEST;
								}
								 if(((EsbLinkEditPart)this.getTargetConnections().get(0)).getSource().getParent() instanceof AbstractEndpoint) {
								    	if(((EsbLinkEditPart)this.getTargetConnections().get(0)).getSource().getParent().getParent().getParent().getParent() instanceof AbstractMediator){
								    	if(((AbstractMediator)((EsbLinkEditPart)this.getTargetConnections().get(0)).getSource().getParent().getParent().getParent().getParent()).reversed){
										 direction=PositionConstants.EAST;
								    	}
								    }
									}
								
								IFigure borderItemFigure=((AbstractEndpointInputConnector) this).getFigure();
								BorderItemLocator locator = new FixedBorderItemLocator(
								((AbstractEndpoint)this.getParent()).getMainFigure(), borderItemFigure, direction,0.5);
								((AbstractEndpoint)this.getParent()).getBorderedFigure().getBorderItemContainer().remove(borderItemFigure);
								((AbstractEndpoint)this.getParent()).getBorderedFigure().getBorderItemContainer().add(borderItemFigure,locator);
								
								break;
							}
						}
					}
					
					
					EditPart sourceOutputConnector = ((EsbLinkEditPart) this.getTargetConnections()
							.get(0)).getSource();
					if((sourceOutputConnector !=null)&&(sourceOutputConnector.getParent() instanceof SequenceEditPart)){
						if(((EsbLinkEditPart)((AbstractInputConnector)sourceOutputConnector.getParent().getChildren().get(1)).getTargetConnections().get(0)).getSource() instanceof AbstractEndpointOutputConnector){
						((SequenceEditPart)sourceOutputConnector.getParent()).moveConnectorsRightSide();
						}
					}
					
				}
				
			}
	}
	
	public class EastPointerFigure extends EastPointerShape {


		public EastPointerFigure() {

			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(12),
					getMapMode().DPtoLP(10)));
		}

	}

	public class WestPointerFigure extends WestPointerShape {

		public WestPointerFigure() {

			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(12),
					getMapMode().DPtoLP(10)));
		}

	}
	
	static final Color THIS_BACK = new Color(null, 50, 50, 50);

}

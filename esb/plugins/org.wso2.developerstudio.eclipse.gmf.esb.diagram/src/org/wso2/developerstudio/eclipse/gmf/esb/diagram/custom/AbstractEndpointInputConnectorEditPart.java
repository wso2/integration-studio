package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorInputConnectorEditPart.EastPointerFigure;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorInputConnectorEditPart.WestPointerFigure;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EsbLinkEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SendMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SendMediatorEndpointOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorPlugin;

public abstract class AbstractEndpointInputConnectorEditPart extends AbstractInputConnectorEditPart {

	public NodeFigure figure_;
	protected IFigure primaryShapeForward;
	protected IFigure primaryShapeReverse;
	
	public AbstractEndpointInputConnectorEditPart(View view) {
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
					if((link instanceof AbstractEndpointAdditionalOutputConnectorEditPart)|(link instanceof SendMediatorEndpointOutputConnectorEditPart)){						
						for(int j=0;j<this.getParent().getChildren().size();++j){
							if(this.getParent().getChildren().get(j) instanceof AbstractEndpointOutputConnectorEditPart){
								Collection<EObject> collection=new ArrayList<EObject>();
								collection.add(((org.eclipse.gmf.runtime.notation.impl.NodeImpl)((AbstractEndpointOutputConnectorEditPart)this.getParent().getChildren().get(j)).getModel()).getElement());
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
								
								IFigure borderItemFigure=((AbstractEndpointInputConnectorEditPart) this).getFigure();
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
						List connections=((AbstractMediatorInputConnectorEditPart)sourceOutputConnector.getParent().getChildren().get(1)).getTargetConnections();
						if(connections.size()>0){
							if(((EsbLinkEditPart)connections.get(0)).getSource() instanceof AbstractEndpointOutputConnectorEditPart){
							((SequenceEditPart)sourceOutputConnector.getParent()).moveConnectorsRightSide();
							}
						}
					}
					
				}
				
			}
	}
	
	public boolean isSelectable() {
		return false;
	}
	
	public class EastPointerFigure extends Figure {
		
	}
	
	public class WestPointerFigure extends Figure {
		
	}
	
	/*public class EastPointerFigure extends RoundedRectangle {


		public EastPointerFigure() {

			
			 * this.setBackgroundColor(THIS_BACK); this.setPreferredSize(new
			 * Dimension(getMapMode().DPtoLP(12), getMapMode().DPtoLP(10)));
			 

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			layoutThis.marginHeight = 0;
			layoutThis.marginWidth = 0;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(1, 1));
			this.setFill(false);
			this.setOutline(false);
			// this.setBackgroundColor(get);
			this.setPreferredSize(new Dimension(30, 30));
			createContents();

		}

		public void createContents() {
			GridData constraintImageRectangle11 = new GridData();
			constraintImageRectangle11.verticalAlignment = GridData.FILL;
			constraintImageRectangle11.horizontalAlignment = GridData.FILL;
			constraintImageRectangle11.horizontalIndent = 0;
			constraintImageRectangle11.horizontalSpan = 1;
			constraintImageRectangle11.verticalSpan = 2;
			constraintImageRectangle11.grabExcessHorizontalSpace = true;
			constraintImageRectangle11.grabExcessVerticalSpace = true;

			ImageDescriptor imgDesc1 = EsbDiagramEditorPlugin
					.getBundledImageDescriptor("icons/ico20/arrowEast.png");
			ImageFigure img1 = new ImageFigure(imgDesc1.createImage());
			img1.setSize(new Dimension(30, 30));

			RectangleFigure imageRectangle11 = new RectangleFigure();
			imageRectangle11.setOutline(false);
			imageRectangle11.setBackgroundColor(new Color(null, 255, 255, 255));
			imageRectangle11.setPreferredSize(new Dimension(30, 30));
			imageRectangle11.add(img1);

			this.add(imageRectangle11, constraintImageRectangle11);

		}

	}

	public class WestPointerFigure extends RoundedRectangle {

		public WestPointerFigure() {

			
			 * this.setBackgroundColor(THIS_BACK); this.setPreferredSize(new
			 * Dimension(getMapMode().DPtoLP(12), getMapMode().DPtoLP(10)));
			 

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			layoutThis.marginHeight = 0;
			layoutThis.marginWidth = 0;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(1, 1));
			this.setFill(false);
			this.setOutline(false);
			// this.setBackgroundColor(get);
			this.setPreferredSize(new Dimension(30, 30));
			createContents();

		}

		public void createContents() {
			GridData constraintImageRectangle11 = new GridData();
			constraintImageRectangle11.verticalAlignment = GridData.FILL;
			constraintImageRectangle11.horizontalAlignment = GridData.FILL;
			constraintImageRectangle11.horizontalIndent = 0;
			constraintImageRectangle11.horizontalSpan = 1;
			constraintImageRectangle11.verticalSpan = 2;
			constraintImageRectangle11.grabExcessHorizontalSpace = true;
			constraintImageRectangle11.grabExcessVerticalSpace = true;

			ImageDescriptor imgDesc1 = EsbDiagramEditorPlugin
					.getBundledImageDescriptor("icons/ico20/arrowWest.png");
			ImageFigure img1 = new ImageFigure(imgDesc1.createImage());
			img1.setSize(new Dimension(30, 30));

			RectangleFigure imageRectangle11 = new RectangleFigure();
			imageRectangle11.setOutline(false);
			imageRectangle11.setBackgroundColor(new Color(null, 255, 255, 255));
			imageRectangle11.setPreferredSize(new Dimension(30, 30));
			imageRectangle11.add(img1);

			this.add(imageRectangle11, constraintImageRectangle11);

		}

	}*/
	
	static final Color THIS_BACK = new Color(null, 50, 50, 50);

}

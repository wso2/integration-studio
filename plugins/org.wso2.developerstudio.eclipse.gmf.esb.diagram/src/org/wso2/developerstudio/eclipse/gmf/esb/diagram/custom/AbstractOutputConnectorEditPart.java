package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;

public abstract class AbstractOutputConnectorEditPart extends
		AbstractConnectorEditPart {
	
	public abstract NodeFigure getNodeFigureOutput();

	public abstract IFigure createNodeShapeReverse();

	public abstract IFigure createNodeShapeForward();

	public AbstractOutputConnectorEditPart(View view) {
		super(view);
	}
		
	public void activate() {
		super.activate();
		toggleVisibility((OutputConnector) ((Node)this.getModel()).getElement());
	}

	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		if (notification.getNotifier() instanceof OutputConnector) {			
			toggleVisibility((OutputConnector)notification.getNotifier());
		}
	}
	
	private void toggleVisibility(OutputConnector outputConnector){		
		if (outputConnector.getOutgoingLink() != null) {
			/*
			 * This will remove the arrow head of output connector if it is
			 * connected to any other input connector.
			 */
			NodeFigure figureInput = this.getNodeFigureOutput();
			figureInput.removeAll();
			Figure emptyFigure = new Figure();
			figureInput.add(emptyFigure);
		} else {
			/*
			 * This will add the arrow head of output connector if it is not
			 * connected to any other input connector.
			 */
			NodeFigure figureInput = this.getNodeFigureOutput();
			figureInput.removeAll();
			if (EditorUtils.getMediator(this) != null) {
				if (EditorUtils.getMediator(this).reversed) {
					figureInput.add(createNodeShapeReverse());
				} else {
					figureInput.add(createNodeShapeForward());
				}
			}else if(EditorUtils.getProxy(this) !=null){
				figureInput.add(createNodeShapeForward());
			}else if(EditorUtils.getEndpoint(this) !=null){
				figureInput.add(createNodeShapeReverse());
			}else if(EditorUtils.getSequence(this) !=null){
				figureInput.add(createNodeShapeForward());
			}else if(EditorUtils.getAPIResource(this) !=null){
				figureInput.add(createNodeShapeForward());
			}else if(EditorUtils.getComplexEndpoint(this) !=null){
				figureInput.add(createNodeShapeForward());
			}else if(EditorUtils.getInboundEndpoint(this) !=null){
				figureInput.add(createNodeShapeForward());
			}
		}		
	}
}

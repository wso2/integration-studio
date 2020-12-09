package org.wso2.developerstudio.datamapper.diagram.edit.parts;

import java.awt.MouseInfo;
import java.awt.Point;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;


public class DMCustomDragDropEditPolicy extends org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy {

	private IFigure feedbackFigure;
	private Image feedbackImage;

	private static final String ALLOW_DROP_ICON_PATH = "/icons/gmf/AttributeIcon.png";
	private static final String NOT_ALLOW_DROP_ICON_PATH = "/icons/gmf/Symbol-warning-small.png";
	
	@Override
	protected Command getDropCommand(ChangeBoundsRequest request) {
		if ((getHost() instanceof ShapeCompartmentEditPart)) {
			/* avoiding drag and drop nodes between compartments. */
			return null;
		}
		return super.getDragCommand(request);
	}
	
	@Override
	public void showTargetFeedback(Request request) {
		super.showTargetFeedback(request);
		
		//if (request instanceof CreateUnspecifiedTypeRequest) {
			if (getHost() instanceof DataMapperRootEditPart) {
				
				DataMapperRootEditPart host = (DataMapperRootEditPart) getHost();
				Command command = host.getCommand(request);
				showFeedBackFigure(true);
//				if (command != null) {
//					System.out.println("showTargetFeedback command" + command.toString());
//					if (command.canExecute()) {
//						showFeedBackFigure(true);
//					} else {
//						showFeedBackFigure(false);
//					}
//				} else {
//					System.out.println("showTargetFeedback command  is null");
//					showFeedBackFigure(false);
//				}
			}
		//}
		
	}
	
	public void eraseTargetFeedback(Request request) {
		if (feedbackFigure != null) {
			removeFeedback(feedbackFigure);
			feedbackFigure = null;
		}
		super.eraseTargetFeedback(request);
	}
	
	private void showFeedBackFigure(boolean allowDrop) {
		Point pointer = MouseInfo.getPointerInfo().getLocation();
		IFigure feedbackFigure = getFeedbackFigure(allowDrop);
		int x = (int) pointer.getX();
		int y = (int) pointer.getY();
		Control ctrl = getHost().getViewer().getControl();
		FigureCanvas canvas = (FigureCanvas) ctrl;
		int horizontal = canvas.getHorizontalBar().getSelection();
		int vertical = canvas.getVerticalBar().getSelection();
		horizontal += 15;
		vertical -= 15;
		org.eclipse.swt.graphics.Point p = canvas.toDisplay(0, 0);
		feedbackFigure.setBounds(new Rectangle((x - p.x) + horizontal, (y - p.y) + vertical,
				feedbackImage.getBounds().width, feedbackImage.getBounds().height));
	}
	
	public IFigure getFeedbackFigure(boolean allowDrop) {
		if (feedbackFigure == null) {
			Image feedbackImage = SWTResourceManager.getImage(this.getClass(),
					(allowDrop) ? ALLOW_DROP_ICON_PATH : NOT_ALLOW_DROP_ICON_PATH);
			IFigure figure = new ImageFigure(feedbackImage);
			addFeedback(figure);
			this.feedbackImage = feedbackImage;
			feedbackFigure = figure;
		}
		return feedbackFigure;
	}
	
	public Command getCommand(Request request) {
		return super.getCommand(request);
	}

}

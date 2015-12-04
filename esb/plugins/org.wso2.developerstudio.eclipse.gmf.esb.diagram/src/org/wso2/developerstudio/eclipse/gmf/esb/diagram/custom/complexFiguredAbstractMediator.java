package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.layout.XYRepossition;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.HighlightOnSelectionEditPolicy;

public class complexFiguredAbstractMediator extends AbstractMediator{

	protected boolean connected=false;
	protected int width=0;

	protected IFigure primaryShape;
	
	public RoundedRectangle getPrimaryShape(){
		//This method should be implemented by sub classes
		return null;
	}
	
	public complexFiguredAbstractMediator(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
			installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new CustomNonResizableEditPolicyEx());  //remove 8 corners
			installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new HighlightOnSelectionEditPolicy()); //selection
	}
	
	public IFigure getComplexFiguredPrimaryShape() {
		return primaryShape;
	}
	
	protected void addLayoutListner(NodeFigure figure){
		 figure.addLayoutListener(new LayoutListener() {
		 	
		 	@Override
		 	public void setConstraint(IFigure child, Object constraint) {
		 		// TODO Auto-generated method stub
		 		
		 	}
		 	
		 	@Override
		 	public void remove(IFigure child) {
		 		// TODO Auto-generated method stub
		 		
		 	}
		 	
		 	@Override
		 	public void postLayout(IFigure container) {
		 		// TODO Auto-generated method stub
		 					
		 		if(width!=container.getBounds().width){
		 			width=container.getBounds().width;
		 			Display.getCurrent().asyncExec(new Runnable() {			
		 				@Override
		 				public void run() {	
		 					XYRepossition.resizeContainers((IGraphicalEditPart) getParent());			
		 					XYRepossition.reArrange((IGraphicalEditPart) getParent());	 
		 					//XYRepossition.resizeContainers((IGraphicalEditPart) ((IGraphicalEditPart)getChildren().get(4)).getChildren().get(0));			
		 					//XYRepossition.reArrange((IGraphicalEditPart) ((IGraphicalEditPart)getChildren().get(4)).getChildren().get(0));
		 				}});
		 		}
		 		
		 	}
		 	
		 	@Override
		 	public boolean layout(IFigure container) {
		 		// TODO Auto-generated method stub
		 		return false;
		 	}
		 	
		 	@Override
		 	public void invalidate(IFigure container) {
		 		// TODO Auto-generated method stub
		 		
		 	}
		 });
	}
}

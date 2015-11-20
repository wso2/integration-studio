package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.EditPart;
import org.eclipse.ui.IWorkbenchPart;

public class DirectionDropMediatorAction extends DirectionEsbNodeAction {

	EditPart editorPart;
	
	public DirectionDropMediatorAction(IWorkbenchPart part) {
		super(part);
		setText("Reverse");
		setToolTipText("Set Direction Drop mediator.");
		// TODO Auto-generated constructor stub
	}
	
	public void setEditorPart(EditPart editorPart_){
		editorPart=editorPart_;		
	}
	
	public void doRun(IProgressMonitor progressMonitor){
		Reverse(editorPart);
		
/*		DropMediatorEditPart selectedEP = (DropMediatorEditPart) editorPart;
		IFigure inputConnector= ((DropMediatorInputConnectorEditPart)selectedEP.getChildren().get(0)).getFigure();
		
		NodeFigure figureInput=((DropMediatorInputConnectorEditPart)selectedEP.getChildren().get(0)).figure_;
		
		if (selectedEP.isForward) {
			
			figureInput.removeAll();
			figureInput.add(((DropMediatorInputConnectorEditPart)selectedEP.getChildren().get(0)).getPrimaryShapeReverse());
			
			
			
			BorderItemLocator inputLocator = new FixedBorderItemLocator(
					selectedEP.getMainFigure(), inputConnector, PositionConstants.EAST,
					0.5);
		
			selectedEP.getBorderedFigure().getBorderItemContainer().remove(inputConnector);
			
			selectedEP.getBorderedFigure().getBorderItemContainer().add(inputConnector, inputLocator);		
			

			setText("Forward");
			selectedEP.isForward = false;

		} else {
			
			figureInput.removeAll();
			figureInput.add(((DropMediatorInputConnectorEditPart)selectedEP.getChildren().get(0)).getPrimaryShapeForward());
			
			
			BorderItemLocator inputLocator = new FixedBorderItemLocator(
					selectedEP.getMainFigure(), inputConnector, PositionConstants.WEST,
					0.5);
			
			selectedEP.getBorderedFigure().getBorderItemContainer().remove(inputConnector);
			
			selectedEP.getBorderedFigure().getBorderItemContainer().add(inputConnector, inputLocator);		
			
			
			
			
			setText("Reverse");
			selectedEP.isForward = true;
		}
		
		*/
		
	}

}

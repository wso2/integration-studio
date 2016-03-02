package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.wso2.developerstudio.eclipse.gmf.esb.LogMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.ConfigureLogMediatorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.LogMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.LogMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.LogMediatorOutputConnectorEditPart;

public class DirectionLogMediatorAction extends DirectionEsbNodeAction {

	EditPart editorPart;
	
	public DirectionLogMediatorAction(IWorkbenchPart part) {
		super(part);
		
		setText("Reverse");
		setToolTipText("Set Direction log mediator.");
		// TODO Auto-generated constructor stub
	}
	
	
	public void setEditorPart(EditPart editorPart_){
		editorPart=editorPart_;		
	}
	
	protected void doRun(IProgressMonitor progressMonitor) {
		Reverse(editorPart);

/*		LogMediatorEditPart selectedEP = (LogMediatorEditPart) editorPart;
		IFigure inputConnector= ((LogMediatorInputConnectorEditPart)selectedEP.getChildren().get(1)).getFigure();
		
		IFigure outputConnector =((LogMediatorOutputConnectorEditPart)selectedEP.getChildren().get(2)).getFigure();

		NodeFigure figureInput=((LogMediatorInputConnectorEditPart)selectedEP.getChildren().get(1)).figure_;
		NodeFigure figureOutput=((LogMediatorOutputConnectorEditPart)selectedEP.getChildren().get(2)).figure_;
		
		if (selectedEP.isForward) {
			
			figureInput.removeAll();
			figureInput.add(((LogMediatorInputConnectorEditPart)selectedEP.getChildren().get(1)).getPrimaryShapeReverse());
			figureOutput.removeAll();
			figureOutput.add(((LogMediatorOutputConnectorEditPart)selectedEP.getChildren().get(2)).getPrimaryShapeReverse());
			
			
			BorderItemLocator inputLocator = new FixedBorderItemLocator(
					selectedEP.getMainFigure(), inputConnector, PositionConstants.EAST,
					0.5);
			BorderItemLocator outputLocator = new FixedBorderItemLocator(
					selectedEP.getMainFigure(), outputConnector, PositionConstants.WEST,
					0.5);
			selectedEP.getBorderedFigure().getBorderItemContainer().remove(inputConnector);
			selectedEP.getBorderedFigure().getBorderItemContainer().remove(outputConnector);
			selectedEP.getBorderedFigure().getBorderItemContainer().add(inputConnector, inputLocator);		
			selectedEP.getBorderedFigure().getBorderItemContainer().add(outputConnector, outputLocator);

			setText("Forward");
			selectedEP.isForward = false;

		} else {
			
			figureInput.removeAll();
			figureInput.add(((LogMediatorInputConnectorEditPart)selectedEP.getChildren().get(1)).getPrimaryShapeForward());
			figureOutput.removeAll();
			figureOutput.add(((LogMediatorOutputConnectorEditPart)selectedEP.getChildren().get(2)).getPrimaryShapeForward());
			
			BorderItemLocator inputLocator = new FixedBorderItemLocator(
					selectedEP.getMainFigure(), inputConnector, PositionConstants.WEST,
					0.5);
			BorderItemLocator outputLocator = new FixedBorderItemLocator(
					selectedEP.getMainFigure(), outputConnector, PositionConstants.EAST,
					0.5);
			selectedEP.getBorderedFigure().getBorderItemContainer().remove(inputConnector);
			selectedEP.getBorderedFigure().getBorderItemContainer().remove(outputConnector);
			selectedEP.getBorderedFigure().getBorderItemContainer().add(inputConnector, inputLocator);		
			selectedEP.getBorderedFigure().getBorderItemContainer().add(outputConnector, outputLocator);
			
			
			
			setText("Reverse");
			selectedEP.isForward = true;
		}
		
		
		
		
			
		
		
		//IFigure i=new EastPointerFigure();
		
		
		
		

		*/
			
		
	}

}

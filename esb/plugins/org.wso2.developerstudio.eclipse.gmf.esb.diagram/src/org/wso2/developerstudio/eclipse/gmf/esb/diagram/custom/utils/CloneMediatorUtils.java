package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneTargetContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloneMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloneMediatorTargetOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloneTargetContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchCaseBranchOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchCaseContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchMediatorEditPart;

public class CloneMediatorUtils {

	public static void reorderWhenRevered(EditPart editpart){			
		reorder(editpart,PositionConstants.EAST);
	}
	
	public static void reorderWhenForward(EditPart editpart){
		reorder(editpart,PositionConstants.WEST);
	}
	
	private static void reorder(EditPart editpart,int position) {
		ArrayList<CloneTargetContainerEditPart> targetContainers = new ArrayList<CloneTargetContainerEditPart>();
		List<IFigure> outputConnectors = new ArrayList<IFigure>();
		ArrayList<CloneMediatorTargetOutputConnectorEditPart> targetOutputConnectorsList = new ArrayList<CloneMediatorTargetOutputConnectorEditPart>();
		List<BorderItemLocator> outputLocators = new ArrayList<BorderItemLocator>();

		for (int i = 0; i < ((EditPart) editpart.getChildren().get(4)).getChildren().size(); ++i) {
			if (((EditPart) editpart.getChildren().get(4)).getChildren().get(i) instanceof CloneTargetContainerEditPart) {
				CloneTargetContainerEditPart targetContainerEditPart = (CloneTargetContainerEditPart) ((EditPart) editpart
						.getChildren().get(4)).getChildren().get(i);
				targetContainers.add(targetContainerEditPart);
			}
		}

		for (int i = 0; i < editpart.getChildren().size(); ++i) {
			if ((EditPart) editpart.getChildren().get(i) instanceof CloneMediatorTargetOutputConnectorEditPart) {
				CloneMediatorTargetOutputConnectorEditPart targetOutputConnectorEditPart = (CloneMediatorTargetOutputConnectorEditPart) editpart
						.getChildren().get(i);
				targetOutputConnectorsList.add(targetOutputConnectorEditPart);
			}
		}

		for (int i = 0; i < targetContainers.size(); ++i) {
			IFigure borderItemFigure = targetOutputConnectorsList.get(i).getFigure();
			outputConnectors.add(borderItemFigure);
			BorderItemLocator locator = new FixedBorderItemLocator(targetContainers.get(i)
					.getFigure(), borderItemFigure, position, 0.5);
			outputLocators.add(locator);
		}

		for (int i = 0; i < outputConnectors.size(); ++i) {
			// ((SwitchMediatorEditPart)editpart).getBorderedFigure()
			// .getBorderItemContainer().remove(outputConnectors.get(i));
			((CloneMediatorEditPart) editpart).getBorderedFigure().getBorderItemContainer()
					.add(outputConnectors.get(i), outputLocators.get(i));
		}
		targetOutputConnectorsList.clear();
		outputLocators.clear();
		if(((CloneMediatorEditPart)editpart).reversed){
			MediatorFigureReverser.reverse(editpart,true);
		}		
	}
	
	public static void addTargetInitially(EditPart child,TransactionalEditingDomain domain) {
		CloneMediatorEditPart cloneMediatorEditPart = (CloneMediatorEditPart) child;
		EObject parentContainer = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (cloneMediatorEditPart)
				.getModel()).getElement();
		if (((CloneMediator) parentContainer).getTargetsOutputConnector().size() == 0) {
			CloneMediatorTargetOutputConnector targetOutputConnector = EsbFactory.eINSTANCE
					.createCloneMediatorTargetOutputConnector();
			AddCommand addTargetConnectorCmd = new AddCommand(domain, parentContainer,
					EsbPackage.Literals.CLONE_MEDIATOR__TARGETS_OUTPUT_CONNECTOR, targetOutputConnector);
			if (addTargetConnectorCmd.canExecute()) {
				domain.getCommandStack().execute(addTargetConnectorCmd);
			}

			CloneTargetContainer targetContainer = EsbFactory.eINSTANCE.createCloneTargetContainer();
			AddCommand addCmd = new AddCommand(domain,
					((CloneMediator) parentContainer).getCloneContainer(),
					EsbPackage.Literals.CLONE_MEDIATOR_CONTAINER__CLONE_TARGET_CONTAINER,
					targetContainer);
			if (addCmd.canExecute()) {
				domain.getCommandStack().execute(addCmd);
			}
		}
		
		if(((CloneMediator) parentContainer).getTargets().size() == 0){
			
			CloneTarget target = EsbFactory.eINSTANCE.createCloneTarget();
			AddCommand addTargetCmd = new AddCommand(domain, parentContainer,
					EsbPackage.Literals.CLONE_MEDIATOR__TARGETS, target);
			if(addTargetCmd.canExecute()){
				domain.getCommandStack().execute(addTargetCmd);
			}
		}
	}
	
}

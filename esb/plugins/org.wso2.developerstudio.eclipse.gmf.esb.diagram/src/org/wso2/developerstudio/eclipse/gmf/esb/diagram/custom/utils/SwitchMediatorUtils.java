package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseBranchOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchDefaultBranchOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchDefaultContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchCaseBranchOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchCaseContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.SwitchDefaultBranchOutputConnectorImpl;

public class SwitchMediatorUtils {
	
	public static void reorderWhenRevered(EditPart editpart){			
		reorder(editpart,PositionConstants.EAST);
	}
	
	public static void reorderWhenForward(EditPart editpart){
		reorder(editpart,PositionConstants.WEST);
	}
	
	private static void reorder(EditPart editpart,int position) {
		ArrayList<SwitchCaseContainerEditPart> caseContainers = new ArrayList<SwitchCaseContainerEditPart>();
		List<IFigure> outputConnectors = new ArrayList<IFigure>();
		ArrayList<SwitchCaseBranchOutputConnectorEditPart> caseOutputConnectorsList = new ArrayList<SwitchCaseBranchOutputConnectorEditPart>();
		List<BorderItemLocator> outputLocators = new ArrayList<BorderItemLocator>();

		for (int i = 0; i < ((EditPart)((EditPart) editpart.getChildren().get(4)).getChildren().get(0)).getChildren().size(); ++i) {
			if (((EditPart)((EditPart) editpart.getChildren().get(4)).getChildren().get(0)).getChildren().get(i) instanceof SwitchCaseContainerEditPart) {
				SwitchCaseContainerEditPart caseContainerEditPart = (SwitchCaseContainerEditPart) ((EditPart) ((EditPart) editpart
						.getChildren().get(4)).getChildren().get(0)).getChildren().get(i);
				caseContainers.add(caseContainerEditPart);
			}
		}

		for (int i = 0; i < editpart.getChildren().size(); ++i) {
			if ((EditPart) editpart.getChildren().get(i) instanceof SwitchCaseBranchOutputConnectorEditPart) {
				SwitchCaseBranchOutputConnectorEditPart caseOutputConnectorEditPart = (SwitchCaseBranchOutputConnectorEditPart) editpart
						.getChildren().get(i);
				caseOutputConnectorsList.add(caseOutputConnectorEditPart);
			}
		}

		for (int i = 0; i < caseContainers.size(); ++i) {
			IFigure borderItemFigure = caseOutputConnectorsList.get(i).getFigure();
			outputConnectors.add(borderItemFigure);
			BorderItemLocator locator = new FixedBorderItemLocator(caseContainers.get(i)
					.getFigure(), borderItemFigure, position, 0.5);
			outputLocators.add(locator);
		}

		for (int i = 0; i < outputConnectors.size(); ++i) {
			// ((SwitchMediatorEditPart)editpart).getBorderedFigure()
			// .getBorderItemContainer().remove(outputConnectors.get(i));
			((SwitchMediatorEditPart) editpart).getBorderedFigure().getBorderItemContainer()
					.add(outputConnectors.get(i), outputLocators.get(i));
		}
		caseOutputConnectorsList.clear();
		outputLocators.clear();
		if(((SwitchMediatorEditPart)editpart).reversed){
			MediatorFigureReverser.reverse(editpart,true);
		}		
	}

	public static void addCaseBranchInitially(EditPart child,
			TransactionalEditingDomain domain) {
		SwitchMediatorEditPart switchMediatorEditPart = (SwitchMediatorEditPart) child;
		EObject parentContainer = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (switchMediatorEditPart)
				.getModel()).getElement();
 		
		if (((SwitchMediator) parentContainer).getCaseBranches().size() == 0) {
			SwitchCaseBranchOutputConnector caseOutputConnector = EsbFactory.eINSTANCE
					.createSwitchCaseBranchOutputConnector();
			AddCommand addCaseConnectorCmd = new AddCommand(domain, parentContainer,
					EsbPackage.Literals.SWITCH_MEDIATOR__CASE_BRANCHES, caseOutputConnector);
			if (addCaseConnectorCmd.canExecute()) {
				domain.getCommandStack().execute(addCaseConnectorCmd);
			}

			SwitchCaseContainer caseContainer = EsbFactory.eINSTANCE.createSwitchCaseContainer();
			AddCommand addCmd = new AddCommand(domain,
					((SwitchMediator) parentContainer).getSwitchContainer().getSwitchCaseParentContainer(),
					EsbPackage.Literals.SWITCH_CASE_PARENT_CONTAINER__SWITCH_CASE_CONTAINER,
					caseContainer);
			if (addCmd.canExecute()) {
				domain.getCommandStack().execute(addCmd);
			}
		}
	}

}

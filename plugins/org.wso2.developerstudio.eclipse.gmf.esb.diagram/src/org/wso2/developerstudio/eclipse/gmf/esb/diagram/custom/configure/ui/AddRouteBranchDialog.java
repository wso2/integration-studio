package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneTargetContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.CloneMediatorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.RouterMediatorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloneMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RouterMediatorEditPart;

public class AddRouteBranchDialog extends Dialog {

	private RouterMediator routerMediator;
	private Label caseCount;
	private Text count;
	private EditPart editpart;
	private TransactionalEditingDomain editingDomain;
	private ArrayList<RouterTargetContainer> targetBranches = new ArrayList<RouterTargetContainer>();
	private ArrayList<RouterMediatorTargetOutputConnector> targetOutputConnectors = new ArrayList<RouterMediatorTargetOutputConnector>();
	private List<RouterTarget> routerTargets = new ArrayList<RouterTarget>();

	public AddRouteBranchDialog(Shell parentShell, RouterMediator routerMediator,
			TransactionalEditingDomain editingDomain, EditPart editpart) {
		super(parentShell);
		this.routerMediator = routerMediator;
		this.editpart = editpart;
		this.editingDomain = editingDomain;
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		// Set title.
		newShell.setText("Add Route Branches.");
	}

	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);

		caseCount = new Label(container, SWT.NONE);
		{
			caseCount.setText("Number of branches: ");
			FormData caseCountLabelLayoutData = new FormData();
			caseCountLabelLayoutData.top = new FormAttachment(0, 5);
			caseCountLabelLayoutData.left = new FormAttachment(0);
			caseCount.setLayoutData(caseCountLabelLayoutData);
		}

		count = new Text(container, SWT.NONE);
		{
			FormData countLayoutData = new FormData();
			countLayoutData.width = 50;
			countLayoutData.top = new FormAttachment(caseCount, 0, SWT.CENTER);
			countLayoutData.left = new FormAttachment(caseCount, 5);
			count.setLayoutData(countLayoutData);
			int i = routerMediator.getRouterContainer().getRouterTargetContainer()
					.size();
			count.setText(Integer.toString(i));
		}

		return container;
	}

	protected void okPressed() {
		int number = Integer.parseInt(count.getText())
				- routerMediator.getRouterContainer().getRouterTargetContainer()
						.size();

		if (number > 0) {

			for (int i = 0; i < number; ++i) {
				RouterTargetContainer targetContainer = EsbFactory.eINSTANCE
						.createRouterTargetContainer();

				AddCommand addCmd = new AddCommand(
						editingDomain,
						routerMediator.getRouterContainer(),
						EsbPackage.Literals.ROUTER_MEDIATOR_CONTAINER__ROUTER_TARGET_CONTAINER,
						targetContainer);

				if (addCmd.canExecute()) {
					editingDomain.getCommandStack().execute(addCmd);
				}

				RouterMediatorTargetOutputConnector targetOutputConnector = EsbFactory.eINSTANCE
						.createRouterMediatorTargetOutputConnector();

				AddCommand addTargetOutputConnectorCommand = new AddCommand(
						editingDomain,
						routerMediator,
						EsbPackage.Literals.ROUTER_MEDIATOR__TARGET_OUTPUT_CONNECTOR,
						targetOutputConnector);

				if (addTargetOutputConnectorCommand.canExecute()) {
					editingDomain.getCommandStack().execute(
							addTargetOutputConnectorCommand);
				}

				RouterTarget target = EsbFactory.eINSTANCE.createRouterTarget();

//				AddCommand addTargetCmd = new AddCommand(editingDomain,
//						routerMediator,
//						EsbPackage.Literals.ROUTER_MEDIATOR__TARGETS, target);
//				if (addTargetCmd.canExecute()) {
//					editingDomain.getCommandStack().execute(addTargetCmd);
//				}

			}
		} else {

			for (int i = 0; i < Math.abs(number); ++i) {
				RouterTargetContainer lastTargetContainer = routerMediator
						.getRouterContainer().getRouterTargetContainer()
						.get(routerMediator.getRouterContainer().getRouterTargetContainer().size() - 1);

				targetBranches.add(lastTargetContainer);

				DeleteCommand deleteCmd = new DeleteCommand(editingDomain,
						targetBranches);

				if (deleteCmd.canExecute()) {
					editingDomain.getCommandStack().execute(deleteCmd);
				}

				targetBranches.remove(lastTargetContainer);

				RouterMediatorTargetOutputConnector lastTargetOutputConnector = routerMediator
						.getTargetOutputConnector().get(
								routerMediator.getTargetOutputConnector()
										.size() - 1);

				targetOutputConnectors.add(lastTargetOutputConnector);

				DeleteCommand deleteTargetOutputConnectorscmd = new DeleteCommand(
						editingDomain, targetOutputConnectors);

				if (deleteTargetOutputConnectorscmd.canExecute()) {
					editingDomain.getCommandStack().execute(
							deleteTargetOutputConnectorscmd);
				}

				targetOutputConnectors.remove(lastTargetOutputConnector);

//				RouterTarget lastCloneTarget = routerMediator.getTargets().get(
//						routerMediator.getTargets().size() - 1);
//
//				routerTargets.add(lastCloneTarget);
//
//				DeleteCommand deleteTarget = new DeleteCommand(editingDomain,
//						routerTargets);
//
//				if (deleteTarget.canExecute()) {
//
//					editingDomain.getCommandStack().execute(deleteTarget);
//				}
//
//				routerTargets.remove(lastCloneTarget);

			}
		}
		if (editpart instanceof RouterMediatorEditPart) {
			if (((RouterMediatorEditPart) editpart).reversed) {
				RouterMediatorUtils.reorderWhenRevered(editpart);
			} else {
				RouterMediatorUtils.reorderWhenForward(editpart);
			}
		}
		super.okPressed();
	}

}

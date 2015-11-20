package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneTargetContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.layout.XYRepossition;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.CloneMediatorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloneMediatorEditPart;

public class AddTargetBranchDialog extends Dialog {

	private CloneMediator cloneMediator;
	private Label caseCount;
	private Text count;
	private EditPart editpart;
	private TransactionalEditingDomain editingDomain;
	private ArrayList<CloneTargetContainer> targetBranches=new ArrayList<CloneTargetContainer>();
	private ArrayList<CloneMediatorTargetOutputConnector> targetOutputConnectors=new ArrayList<CloneMediatorTargetOutputConnector>();
	private List<CloneTarget> cloneTargets = new ArrayList<CloneTarget>();



	public AddTargetBranchDialog(Shell parentShell, CloneMediator cloneMediator,
	                           TransactionalEditingDomain editingDomain, EditPart editpart) {
		super(parentShell);
		this.cloneMediator=cloneMediator;
		this.editpart=editpart;
		this.editingDomain=editingDomain;
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		// Set title.
		newShell.setText("Add Target Branches.");
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
			int i =cloneMediator.getCloneContainer().getCloneTargetContainer().size();
			count.setText(Integer.toString(i));
		}

		return container;
	}
	
	
	
	protected void okPressed() {		
		int number = Integer.parseInt(count.getText())
				- cloneMediator.getCloneContainer().getCloneTargetContainer()
						.size();

		if (number > 0) {

			for (int i = 0; i < number; ++i) {
				CloneTargetContainer targetContainer = EsbFactory.eINSTANCE
						.createCloneTargetContainer();

				AddCommand addCmd = new AddCommand(
						editingDomain,
						cloneMediator.getCloneContainer(),
						EsbPackage.Literals.CLONE_MEDIATOR_CONTAINER__CLONE_TARGET_CONTAINER,
						targetContainer);

				if (addCmd.canExecute()) {
					editingDomain.getCommandStack().execute(addCmd);
				}

				CloneMediatorTargetOutputConnector targetOutputConnector = EsbFactory.eINSTANCE
						.createCloneMediatorTargetOutputConnector();

				AddCommand addTargetOutputConnectorCommand = new AddCommand(
						editingDomain,
						cloneMediator,
						EsbPackage.Literals.CLONE_MEDIATOR__TARGETS_OUTPUT_CONNECTOR,
						targetOutputConnector);

				if (addTargetOutputConnectorCommand.canExecute()) {
					editingDomain.getCommandStack().execute(
							addTargetOutputConnectorCommand);
				}

				CloneTarget target = EsbFactory.eINSTANCE.createCloneTarget();

				AddCommand addTargetCmd = new AddCommand(editingDomain,
						cloneMediator,
						EsbPackage.Literals.CLONE_MEDIATOR__TARGETS, target);
				if (addTargetCmd.canExecute()) {
					editingDomain.getCommandStack().execute(addTargetCmd);
				}

			}
		} else {

			for (int i = 0; i < Math.abs(number); ++i) {
				CloneTargetContainer lastTargetContainer = cloneMediator
						.getCloneContainer()
						.getCloneTargetContainer()
						.get(cloneMediator.getCloneContainer()
								.getCloneTargetContainer().size() - 1);

				targetBranches.add(lastTargetContainer);

				DeleteCommand deleteCmd = new DeleteCommand(editingDomain,
						targetBranches);

				if (deleteCmd.canExecute()) {
					editingDomain.getCommandStack().execute(deleteCmd);
				}

				targetBranches.remove(lastTargetContainer);

				CloneMediatorTargetOutputConnector lastTargetOutputConnector = cloneMediator
						.getTargetsOutputConnector().get(
								cloneMediator.getTargetsOutputConnector()
										.size() - 1);

				targetOutputConnectors.add(lastTargetOutputConnector);

				DeleteCommand deleteTargetOutputConnectorscmd = new DeleteCommand(
						editingDomain, targetOutputConnectors);

				if (deleteTargetOutputConnectorscmd.canExecute()) {
					editingDomain.getCommandStack().execute(
							deleteTargetOutputConnectorscmd);
				}

				targetOutputConnectors.remove(lastTargetOutputConnector);

				CloneTarget lastCloneTarget = cloneMediator.getTargets().get(
						cloneMediator.getTargets().size() - 1);

				cloneTargets.add(lastCloneTarget);

				DeleteCommand deleteTarget = new DeleteCommand(editingDomain,
						cloneTargets);

				if (deleteTarget.canExecute()) {

					editingDomain.getCommandStack().execute(deleteTarget);
				}

				cloneTargets.remove(lastCloneTarget);

			}
		}
		if (editpart instanceof CloneMediatorEditPart) {
			if (((CloneMediatorEditPart) editpart).reversed) {
				CloneMediatorUtils.reorderWhenRevered(editpart);
			} else {
				CloneMediatorUtils.reorderWhenForward(editpart);
			}
		}
		super.okPressed();
		
		// Rearrange Clone mediator on add or remove of targets.
		reArrange();
	}
	
	/**
	 * Rearrange Clone mediator on add or remove of targets.
	 */
	private void reArrange(){
		Display.getCurrent().asyncExec(new Runnable() {			
			@Override
			public void run() {	
				XYRepossition.resizeContainers((IGraphicalEditPart) editpart);
				XYRepossition.reArrange((IGraphicalEditPart) editpart);	
			}});
	}

}

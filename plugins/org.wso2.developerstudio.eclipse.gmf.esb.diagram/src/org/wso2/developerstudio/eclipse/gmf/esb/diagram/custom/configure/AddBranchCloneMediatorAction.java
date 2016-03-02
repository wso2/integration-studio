package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.AddCaseBranchDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.AddTargetBranchDialog;

public class AddBranchCloneMediatorAction extends ConfigureEsbNodeAction {

	public AddBranchCloneMediatorAction(IWorkbenchPart part) {
		super(part);
		setId("add-branch-clone-mediator-action-id");
		setText("Add/Remove Target..");
		setToolTipText("Add or Remove target branches.");
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();		
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
	}

	
	protected void doRun(IProgressMonitor progressMonitor) {
		EditPart selectedEP = getSelectedEditPart();
		Assert.isNotNull(selectedEP, "Empty selection.");
		
		EObject selectedObj = ((View) selectedEP.getModel()).getElement();
		Assert.isTrue(selectedObj instanceof CloneMediator, "Invalid selection.");
		
		Display display = Display.getDefault();
		Shell shell = new Shell(display);	
		shell.setLocation(300, 200);
		Dialog addBranchDialog = new AddTargetBranchDialog(shell, (CloneMediator) selectedObj,getEditingDomain(),selectedEP);
		addBranchDialog.setBlockOnOpen(true);
		addBranchDialog.open();

/*		CloneMediator parentMediator = (CloneMediator) selectedObj;
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(parentMediator);
		CloneMediatorTargetOutputConnector cb = EsbFactory.eINSTANCE.createCloneMediatorTargetOutputConnector();
		AddCommand addCmd = new AddCommand(domain,parentMediator,EsbPackage.Literals.CLONE_MEDIATOR__TARGETS_OUTPUT_CONNECTOR, cb);
		if (addCmd.canExecute()){
			domain.getCommandStack().execute(addCmd);
		} */
		
	}

}

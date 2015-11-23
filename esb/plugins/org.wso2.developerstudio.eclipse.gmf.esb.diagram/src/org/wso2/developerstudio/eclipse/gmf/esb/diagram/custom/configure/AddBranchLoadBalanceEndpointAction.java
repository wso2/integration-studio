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
import org.eclipse.ui.IWorkbenchPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.AddbranchEndpointDialog;

public class AddBranchLoadBalanceEndpointAction extends ConfigureEsbNodeAction {

	public AddBranchLoadBalanceEndpointAction(IWorkbenchPart part) {
		super(part);
		setId("add-branch-loadBalance-endPoint-action-id");
		setText("Branches");
		setToolTipText("Add a branch to loadBalance-endpoint.");
		// TODO Auto-generated constructor stub
	}

	
	protected void doRun(IProgressMonitor progressMonitor) {
		EditPart selectedEP = getSelectedEditPart();
		Assert.isNotNull(selectedEP, "Empty selection.");
		
		EObject selectedObj = ((View) selectedEP.getModel()).getElement();
		Assert.isTrue(selectedObj instanceof LoadBalanceEndPoint, "Invalid selection.");

		
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setLocation(300, 200);
		Dialog addBranchDialog = new AddbranchEndpointDialog(shell, (EndPoint) selectedObj,getEditingDomain(),selectedEP);
		addBranchDialog.setBlockOnOpen(true);
		addBranchDialog.open();
		
	}

}

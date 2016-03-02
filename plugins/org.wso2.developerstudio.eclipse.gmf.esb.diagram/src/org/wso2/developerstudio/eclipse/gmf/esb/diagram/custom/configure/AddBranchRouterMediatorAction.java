package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.AddRouteBranchDialog;

public class AddBranchRouterMediatorAction extends ConfigureEsbNodeAction{

	public AddBranchRouterMediatorAction(IWorkbenchPart part) {
		super(part);
		setId("add-branch-router-mediator-action-id");
		setText("Add/Remove Route..");
		setToolTipText("Add or Remove Route branches.");
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();		
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
	}

	
	protected void doRun(IProgressMonitor progressMonitor) {
		EditPart selectedEP = getSelectedEditPart();
		Assert.isNotNull(selectedEP, "Empty selection.");
		
		EObject selectedObj = ((View) selectedEP.getModel()).getElement();
		Assert.isTrue(selectedObj instanceof RouterMediator, "Invalid selection.");
		
		Display display = Display.getDefault();
		Shell shell = new Shell(display);	
		shell.setLocation(300, 200);
		Dialog addBranchDialog = new AddRouteBranchDialog(shell, (RouterMediator) selectedObj,getEditingDomain(),selectedEP);
		addBranchDialog.setBlockOnOpen(true);
		addBranchDialog.open();
		
	}

}

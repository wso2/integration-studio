/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.AddCaseBranchDialog;

public class AddBranchSwitchMediatorAction extends ConfigureEsbNodeAction {
	
	public AddBranchSwitchMediatorAction(IWorkbenchPart part) {
		super(part);
		setId("add-case-switch-mediator-action-id");
		setText("Add/Remove Case..");
		setToolTipText("Add or Remove case branches.");
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();		
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doRun(IProgressMonitor progressMonitor) {
		EditPart selectedEP = getSelectedEditPart();
		Assert.isNotNull(selectedEP, "Empty selection.");
		
		EObject selectedObj = ((View) selectedEP.getModel()).getElement();
		Assert.isTrue(selectedObj instanceof SwitchMediator, "Invalid selection.");
		
		Display display = Display.getDefault();
		Shell shell = new Shell(display);	
		shell.setLocation(300, 200);
		Dialog addBranchDialog = new AddCaseBranchDialog(shell, (SwitchMediator) selectedObj,getEditingDomain(),selectedEP);
		addBranchDialog.setBlockOnOpen(true);
		addBranchDialog.open();

	/*	SwitchMediator parentMediator = (SwitchMediator) selectedObj;
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(parentMediator);
		SwitchCaseBranchOutputConnector cb = EsbFactory.eINSTANCE.createSwitchCaseBranchOutputConnector();
		AddCommand addCmd = new AddCommand(domain,parentMediator,EsbPackage.Literals.SWITCH_MEDIATOR__CASE_BRANCHES, cb);
		if (addCmd.canExecute()){
			domain.getCommandStack().execute(addCmd);
		} */
		

	}

}

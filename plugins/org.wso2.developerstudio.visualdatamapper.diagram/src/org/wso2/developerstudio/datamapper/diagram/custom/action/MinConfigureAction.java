/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.datamapper.diagram.custom.action;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.datamapper.Min;
import org.wso2.developerstudio.datamapper.diagram.custom.dialogs.ConfigureMinOperatorDialog;

public class MinConfigureAction extends AbstractActionHandler {

	CompoundCommand resultCommand;

	/**
	 * Creates a new {@link ConfigureSwitchMediatorAction} instance.
	 * 
	 * @param part
	 *            a {@link IWorkbenchPart} instance.
	 */
	public MinConfigureAction(IWorkbenchPart part) {
		super(part);
		setId("configure-min-operator-action-id");
		setText("Configure Min Operator");
		setToolTipText("Configure Min Operator Attributes");
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		EditPart selectedEP = getSelectedEditPart();
		EObject selectedObj = ((View) selectedEP.getModel()).getElement();
		Dialog configureMinDialog = new ConfigureMinOperatorDialog(Display.getDefault().getActiveShell(),
				(Min) selectedObj, getEditingDomain());
		configureMinDialog.create();
		configureMinDialog.open();
	}

	protected EditPart getSelectedEditPart() {
		IStructuredSelection selection = getStructuredSelection();
		if (selection.size() == 1) {
			Object selectedEP = selection.getFirstElement();
			if (selectedEP instanceof EditPart) {
				return (EditPart) selectedEP;
			}
		}

		return null; /* In case of selecting the wrong editpart */
	}

	/**
	 * Utility method for calculating the editing domain.
	 * 
	 * @return editing domain for this action.
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		// try adapting the workbench part
		IWorkbenchPart part = getWorkbenchPart();

		if (part != null) {
			IEditingDomainProvider edProvider = (IEditingDomainProvider) part.getAdapter(IEditingDomainProvider.class);

			if (edProvider != null) {
				EditingDomain domain = edProvider.getEditingDomain();

				if (domain instanceof TransactionalEditingDomain) {
					return (TransactionalEditingDomain) domain;
				}
			}
		}

		return null;
	}

}

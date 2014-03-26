/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package dataMapper.diagram.custom.action;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import dataMapper.diagram.custom.util.SchemaKeyEditorDialog;
import dataMapper.impl.InputImpl;


public class LoadInputSchemaAction extends AbstractActionHandler {

	/**
	 * Creates a new {@link LoadInputSchemaAction} instance.
	 * 
	 * @param part a {@link IWorkbenchPart} instance.
	 */
	
	
	public LoadInputSchemaAction(IWorkbenchPart workbenchPart) {
		super(workbenchPart);
		
		setId("configure-input-schema-action-id");
		setText("Load input schema from file");
		setToolTipText("Load input schema from file.");
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();		
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}

	protected void doRun(IProgressMonitor progressMonitor) {
		EditPart selectedEP = getSelectedEditPart();
		Assert.isNotNull(selectedEP, "Empty selection.");
		
		EObject selectedObj = ((View) selectedEP.getModel()).getElement();
		Assert.isTrue(selectedObj instanceof InputImpl, "Invalid selection.");
		
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		
		//List<String> localEntries = new ArrayList<String>();//edit dialog
		SchemaKeyEditorDialog dialog = new SchemaKeyEditorDialog(shell, selectedEP, getWorkbenchPart(), "input");
		//		getStyle(), null, localEntries);
		dialog.create();
		dialog.getShell().setSize(520,250);
		dialog.getShell().setText("Input schema dialog");
		dialog.open();
		
		if (dialog.getReturnCode()==Window.OK) {
			//propertyDescriptor.setPropertyValue(propertyContainer, registryKeyProperty);
			System.out.println("WINDOW OK");
		}
	}
	
	protected EditPart getSelectedEditPart() {
		IStructuredSelection selection = getStructuredSelection();
		if (selection.size() == 1) {
			Object selectedEP = selection.getFirstElement();
			if (selectedEP instanceof EditPart) {
				return (EditPart) selectedEP;
			}
		}
		return null;
	}
	
}

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

package org.wso2.developerstudio.datamapper.diagram.custom.action;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.datamapper.diagram.custom.util.DialogDisplayUtils;
import org.wso2.developerstudio.datamapper.diagram.custom.util.SchemaKeyEditorDialog;
import org.wso2.developerstudio.datamapper.impl.InputImpl;

/**
 * This class handles context menu action 'load input schema'
 */
public class LoadInputSchemaAction extends AbstractActionHandler {

	private static final int DIALOG_HEIGHT = 250;
	private static final int DIALOG_WIDTH = 520;
	private static final String CONFIGURE_INPUT_SCHEMA_ACTION_ID = "configure-input-schema-action-id"; //$NON-NLS-1$
	private static final String INVALID_SELECTION = "Invalid selection."; //$NON-NLS-1$

	private static final String INPUT_SCHEMA_DIALOG = Messages.LoadInputSchemaAction_InputSchemaDialog;
	private static final String SCHEMA_TYPE_INPUT = Messages.LoadInputSchemaAction_SchemaTypeInput;
	private static final String LOAD_INPUT_SCHEMA_FROM_FILE = Messages.LoadInputSchemaAction_LoadFromFile;

	public LoadInputSchemaAction(IWorkbenchPart workbenchPart) {
		super(workbenchPart);

		setId(CONFIGURE_INPUT_SCHEMA_ACTION_ID);
		setText(LOAD_INPUT_SCHEMA_FROM_FILE);
		setToolTipText(LOAD_INPUT_SCHEMA_FROM_FILE);
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	protected void doRun(IProgressMonitor progressMonitor) {
		EditPart selectedEP = getSelectedEditPart();

		if (selectedEP != null) {
			if (selectedEP.getModel() instanceof View) {
				EObject selectedObj = ((View) selectedEP.getModel()).getElement();
				Assert.isTrue(selectedObj instanceof InputImpl, INVALID_SELECTION);
			}
			Shell shell = new Shell(Display.getDefault());
			// Schema key editor dialog : create/import schema
			SchemaKeyEditorDialog dialog = new SchemaKeyEditorDialog(shell, selectedEP,
					getWorkbenchPart(), SCHEMA_TYPE_INPUT);

			dialog.create();
			dialog.getShell().setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
			dialog.getShell().setText(INPUT_SCHEMA_DIALOG);
			DialogDisplayUtils.setPositionInCenter(dialog.getShell());
			dialog.getShell().forceActive();
			dialog.open(); // This handles loading of input schema
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

		return null; /* In case of selecting the wrong editpart */
	}

	@Override
	public void refresh() {
		/* refresh action. Does not do anything */
	}

}

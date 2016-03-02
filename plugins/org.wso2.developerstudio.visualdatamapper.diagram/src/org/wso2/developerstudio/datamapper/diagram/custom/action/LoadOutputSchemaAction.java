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
import org.wso2.developerstudio.datamapper.Output;
import org.wso2.developerstudio.datamapper.diagram.custom.util.DialogDisplayUtils;
import org.wso2.developerstudio.datamapper.diagram.custom.util.SchemaKeyEditorDialog;

/**
 * This class handles context menu action 'load output schema'
 */
public class LoadOutputSchemaAction extends AbstractActionHandler {

	private static final int DIALOG_HEIGHT = 250;
	private static final int DIALOG_WIDTH = 520;
	private static final String CONFIGURE_OUTPUT_SCHEMA_ACTION_ID = "configure-output-schema-action-id"; //$NON-NLS-1$
	private static final String INVALID_SELECTION = "Invalid selection."; //$NON-NLS-1$

	private static final String OUTPUT_SCHEMA_DIALOG = Messages.LoadOutputSchemaAction_OutputSchemaDialog;
	private static final String SCHEMA_TYPE_OUTPUT = Messages.LoadOutputSchemaAction_SchemaTypeOutput;
	private static final String LOAD_OUTPUT_SCHEMA_FROM_FILE = Messages.LoadOutputSchemaAction_LoadOutputSchemaFromFile;

	public LoadOutputSchemaAction(IWorkbenchPart workbenchPart) {
		super(workbenchPart);

		setId(CONFIGURE_OUTPUT_SCHEMA_ACTION_ID);
		setText(LOAD_OUTPUT_SCHEMA_FROM_FILE);
		setToolTipText(LOAD_OUTPUT_SCHEMA_FROM_FILE);
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	protected void doRun(IProgressMonitor progressMonitor) {
		EditPart selectedEP = getSelectedEditPart();

		if (selectedEP != null) {
			EObject selectedObj = ((View) selectedEP.getModel()).getElement();
			Assert.isTrue(selectedObj instanceof Output, INVALID_SELECTION);

			Display display = Display.getDefault();
			Shell shell = new Shell(display);

			// Schema key editor dialog : create/import schema
			SchemaKeyEditorDialog dialog = new SchemaKeyEditorDialog(shell, selectedEP,
					getWorkbenchPart(), SCHEMA_TYPE_OUTPUT);

			dialog.create();
			dialog.getShell().setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
			dialog.getShell().setText(OUTPUT_SCHEMA_DIALOG);
			DialogDisplayUtils.setPositionInCenter(dialog.getShell());
			dialog.getShell().forceActive();
			dialog.open();
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

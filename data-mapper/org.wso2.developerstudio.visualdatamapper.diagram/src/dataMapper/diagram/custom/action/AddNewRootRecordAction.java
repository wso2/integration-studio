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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.visualdatamapper.diagram.Activator;

import dataMapper.DataMapperFactory;
import dataMapper.DataMapperPackage;
import dataMapper.SchemaDataType;
import dataMapper.TreeNode;
import dataMapper.diagram.edit.parts.InputEditPart;
import dataMapper.diagram.edit.parts.OutputEditPart;

public class AddNewRootRecordAction extends AbstractActionHandler {

	private EditPart selectedEP;
	private static final String OUTPUT_EDITPART = "Output"; //$NON-NLS-1$
	private static final String INPUT_EDITPART = "Input"; //$NON-NLS-1$
	private static final String ADD_NEW_ROOT_RECORD_ACTION_ID = "add-new-root-record-action-id"; //$NON-NLS-1$
	private static final String NEW_ROOT_RECORD_ID = "NewRootRecord"; //$NON-NLS-1$
	private static final String ADD_NEW_ROOT_RECORD = Messages.AddNewRootRecordAction_addNewRoot;
	private static final String ERROR = Messages.AddNewRootRecordAction_errorHeader;
	private static final String ERROR_ADDING_NEW_CHILD = Messages.AddNewRootRecordAction_errorAddChild;

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public AddNewRootRecordAction(IWorkbenchPart workbenchPart) {
		super(workbenchPart);

		setId(ADD_NEW_ROOT_RECORD_ACTION_ID);
		setText(ADD_NEW_ROOT_RECORD);
		setToolTipText(ADD_NEW_ROOT_RECORD);
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		selectedEP = getSelectedEditPart();

		if (null != selectedEP) {
			// FIXME Handle if a root node is already added

			// Returns the TreeNodeImpl object respective to selectedEP
			EObject object = ((Node) selectedEP.getModel()).getElement();

			// Configure the new tree node by setting default values
			TreeNode treeNodeNew = DataMapperFactory.eINSTANCE.createTreeNode();
			treeNodeNew.setName(NEW_ROOT_RECORD_ID);
			treeNodeNew.setLevel(1);
			treeNodeNew.setSchemaDataType(SchemaDataType.RECORD);

			String selectedInputOutputEditPart = getSelectedInputOutputEditPart();
			if (null != selectedInputOutputEditPart) {
				AddCommand addCmd;
				if (selectedInputOutputEditPart.equals(INPUT_EDITPART)) {
					/*
					 * add command is changed to input tree node type when input
					 * editpart is selected. index 0 to add as the first child
					 */
					addCmd = new AddCommand(((GraphicalEditPart) selectedEP).getEditingDomain(),
							object, DataMapperPackage.Literals.INPUT__TREE_NODE, treeNodeNew, 0);
				} else {
					/*
					 * add command is changed to output tree node type when
					 * output editpart is selected. index 0 to add as the first
					 * child
					 */
					addCmd = new AddCommand(((GraphicalEditPart) selectedEP).getEditingDomain(),
							object, DataMapperPackage.Literals.OUTPUT__TREE_NODE, treeNodeNew, 0);
				}

				if (addCmd.canExecute()) {
					((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack()
							.execute(addCmd);
				}
			} else {
				log.error(ERROR_ADDING_NEW_CHILD);
				MessageDialog.openError(Display.getCurrent().getActiveShell(), ERROR,
						ERROR_ADDING_NEW_CHILD);
				return;
			}
		}
	}

	private String getSelectedInputOutputEditPart() {
		if (selectedEP instanceof InputEditPart) {
			return INPUT_EDITPART;
		} else if (selectedEP instanceof OutputEditPart) {
			return OUTPUT_EDITPART;
		}
		// When the selected editpart is not InputEditPart or OutputEditPart
		return null;
	}

	private EditPart getSelectedEditPart() {
		IStructuredSelection selection = getStructuredSelection();
		if (selection.size() == 1) {
			Object selectedEP = selection.getFirstElement();
			if (selectedEP instanceof EditPart) {
				return (EditPart) selectedEP;
			}
		}
		// In case of selecting the wrong editpart
		return null;
	}

	@Override
	public void refresh() {
		// refresh action. Does not do anything
	}
}

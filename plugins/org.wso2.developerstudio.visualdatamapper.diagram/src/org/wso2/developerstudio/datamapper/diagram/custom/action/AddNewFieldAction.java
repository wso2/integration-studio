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

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.DataMapperRoot;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.custom.util.AddNewFieldDialog;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.DataMapperRootEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutputEditPart;
import org.wso2.developerstudio.datamapper.impl.TreeNodeImpl;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryFile;

public class AddNewFieldAction extends AbstractActionHandler {

	private EditPart selectedEP;
	private static final String OUTPUT_EDITPART = "Output"; //$NON-NLS-1$
	private static final String INPUT_EDITPART = "Input"; //$NON-NLS-1$
	private static final String ADD_NEW_FIELD_ACTION_ID = "add-new-field-action-id"; //$NON-NLS-1$
	private static final String ADD_NEW_FIELD = Messages.AddNewFieldAction_addNewField;

	public AddNewFieldAction(IWorkbenchPart workbenchPart) {
		super(workbenchPart);

		setId(ADD_NEW_FIELD_ACTION_ID);
		setText(ADD_NEW_FIELD);
		setToolTipText(ADD_NEW_FIELD);
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		selectedEP = getSelectedEditPart();

		AddNewFieldDialog fieldDialog = new AddNewFieldDialog(Display.getCurrent().getActiveShell(),
				new Class[] { IRegistryFile.class });
		fieldDialog.create();
		fieldDialog.open();

		if (fieldDialog.getName() != null && fieldDialog.getSchemaType() != null) {

			if (null != selectedEP) {
				// Returns the TreeNodeImpl object respective to selectedEP
				EObject object = ((Node) selectedEP.getModel()).getElement();
				// Used to identify the selected resource of the model
				TreeNode selectedNode = (TreeNode) object;

				// Configure the new element by setting default values
				Element elementNew = DataMapperFactory.eINSTANCE.createElement();
				elementNew.setName(fieldDialog.getName());
				elementNew.setLevel(selectedNode.getLevel() + 1);

				switch (fieldDialog.getSchemaType()) {
				case "ARRAY":
					elementNew.setSchemaDataType(SchemaDataType.ARRAY);
					break;
				case "BOOLEAN":
					elementNew.setSchemaDataType(SchemaDataType.BOOLEAN);
					break;
				case "BYTES":
					elementNew.setSchemaDataType(SchemaDataType.BYTES);
					break;
				case "DOUBLE":
					elementNew.setSchemaDataType(SchemaDataType.DOUBLE);
					break;
				case "ENUM":
					elementNew.setSchemaDataType(SchemaDataType.ENUM);
					break;
				case "FIXED":
					elementNew.setSchemaDataType(SchemaDataType.FIXED);
					break;
				case "FLOAT":
					elementNew.setSchemaDataType(SchemaDataType.FLOAT);
					break;
				case "INT":
					elementNew.setSchemaDataType(SchemaDataType.INT);
					break;
				case "LONG":
					elementNew.setSchemaDataType(SchemaDataType.LONG);
					break;
				case "MAP":
					elementNew.setSchemaDataType(SchemaDataType.MAP);
					break;
				case "NULL":
					elementNew.setSchemaDataType(SchemaDataType.NULL);
					break;
				case "RECORD":
					elementNew.setSchemaDataType(SchemaDataType.RECORD);
					break;
				case "STRING":
					elementNew.setSchemaDataType(SchemaDataType.STRING);
					break;
				case "UNION":
					elementNew.setSchemaDataType(SchemaDataType.UNION);
					break;
				default:
					break;
				}

				if (StringUtils.isNotEmpty(fieldDialog.getDoc())) {
					elementNew.setDoc(fieldDialog.getDoc());
				}
				if (fieldDialog.getDefault() != null) {
					elementNew.setDefault(fieldDialog.getDefault().toString());
				}
				if (fieldDialog.getAliases() != null) {
					elementNew.getAliases().addAll(fieldDialog.getAliases());
				}
				if (fieldDialog.getOrder() != null) {
					elementNew.setOrder(fieldDialog.getOrder());
				}

				/*
				 * AddCommand is used to avoid concurrent updating. index 0 to
				 * add as the first child
				 */
				AddCommand addCmd = new AddCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), selectedNode,
						DataMapperPackage.Literals.TREE_NODE__ELEMENT, elementNew, 0);
				if (addCmd.canExecute()) {
					((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack().execute(addCmd);
				}

				// FIXME force refresh root
				String selectedInputOutputEditPart = getSelectedInputOutputEditPart();
				if (null != selectedInputOutputEditPart) {
					if (selectedEP.getParent().getParent().getParent() instanceof InputEditPart) {
						InputEditPart iep = (InputEditPart) selectedEP.getParent().getParent().getParent();
						DataMapperRootEditPart rep = (DataMapperRootEditPart) iep.getParent();
						DataMapperRoot rootDiagram = (DataMapperRoot) ((DiagramImpl) rep.getModel()).getElement();
						if (INPUT_EDITPART.equals(selectedInputOutputEditPart)) {
							EList<TreeNode> inputTreeNodesList = rootDiagram.getInput().getTreeNode();
							if (null != inputTreeNodesList && !inputTreeNodesList.isEmpty()) {
								// keep a temp reference
								TreeNodeImpl inputTreeNode = (TreeNodeImpl) inputTreeNodesList.get(0);
								// remove and add to rectify placing
								RemoveCommand rootRemCmd = new RemoveCommand(
										((GraphicalEditPart) selectedEP).getEditingDomain(), rootDiagram.getInput(),
										DataMapperPackage.Literals.INPUT__TREE_NODE, inputTreeNode);
								if (rootRemCmd.canExecute()) {
									((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack()
											.execute(rootRemCmd);
								}

								AddCommand rootAddCmd = new AddCommand(
										((GraphicalEditPart) selectedEP).getEditingDomain(), rootDiagram.getInput(),
										DataMapperPackage.Literals.INPUT__TREE_NODE, inputTreeNode, 0);
								if (rootAddCmd.canExecute()) {
									((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack()
											.execute(rootAddCmd);
								}
							}
						} else {
							EList<TreeNode> outputTreeNodesList = rootDiagram.getOutput().getTreeNode();
							if (null != outputTreeNodesList && !outputTreeNodesList.isEmpty()) {
								// keep a temp reference
								TreeNodeImpl outputTreeNode = (TreeNodeImpl) outputTreeNodesList.get(0);
								// remove and add to rectify placing
								RemoveCommand rootRemCmd = new RemoveCommand(
										((GraphicalEditPart) selectedEP).getEditingDomain(), rootDiagram.getOutput(),
										DataMapperPackage.Literals.OUTPUT__TREE_NODE, outputTreeNode);
								if (rootRemCmd.canExecute()) {
									((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack()
											.execute(rootRemCmd);
								}

								AddCommand rootAddCmd = new AddCommand(
										((GraphicalEditPart) selectedEP).getEditingDomain(), rootDiagram.getOutput(),
										DataMapperPackage.Literals.OUTPUT__TREE_NODE, outputTreeNode, 0);
								if (rootAddCmd.canExecute()) {
									((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack()
											.execute(rootAddCmd);
								}

							}
						}

					}

				}
			}
		}
	}

	private String getSelectedInputOutputEditPart() {
		EditPart tempEP = selectedEP;
		while (!(tempEP instanceof InputEditPart) && !(tempEP instanceof OutputEditPart)) {
			tempEP = tempEP.getParent();
		}

		if (tempEP instanceof InputEditPart) {
			return INPUT_EDITPART;
		} else if (tempEP instanceof OutputEditPart) {
			return OUTPUT_EDITPART;
		} else {
			// When the selected editpart is not InputEditPart or OutputEditPart
			return null;
		}
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

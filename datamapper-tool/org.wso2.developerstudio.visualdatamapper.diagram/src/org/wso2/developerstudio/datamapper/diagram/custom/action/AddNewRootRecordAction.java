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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.DataMapperRoot;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.custom.util.AddNewRootElementDialog;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.DataMapperRootEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutputEditPart;
import org.wso2.developerstudio.datamapper.impl.TreeNodeImpl;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryFile;

public class AddNewRootRecordAction extends AbstractActionHandler {

	private EditPart selectedEP;
	private static final String OUTPUT_EDITPART = "Output"; //$NON-NLS-1$
	private static final String INPUT_EDITPART = "Input"; //$NON-NLS-1$
	private static final String ADD_NEW_ROOT_RECORD_ACTION_ID = "add-new-root-record-action-id"; //$NON-NLS-1$
	private static final String ADD_NEW_ROOT_RECORD = Messages.AddNewRootRecordAction_addNewRoot;
	private static final String ERROR_ADDING_MULTIPLE_ROOT_ELEMENTS = Messages.AddNewRootRecordAction_addMultipleRootElements;
	private static final String ERROR_ADDING_MULTIPLE_ROOT_ELEMENTS_TITLE = Messages.AddNewRootRecordAction_addMultipleRootElementsTitle;
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
			// Not allow to add multiple root elements
			if (!selectedEP.getChildren().isEmpty() && selectedEP instanceof InputEditPart) {
				MessageDialog.openWarning(Display.getCurrent().getActiveShell(), ERROR_ADDING_MULTIPLE_ROOT_ELEMENTS_TITLE, ERROR_ADDING_MULTIPLE_ROOT_ELEMENTS);
			} else {
				
				AddNewRootElementDialog rootElementDialog = new AddNewRootElementDialog(Display.getCurrent().getActiveShell(), new Class[]{IRegistryFile.class});
				rootElementDialog.create();
				rootElementDialog.open();
				
				if(rootElementDialog.getName()!= null && rootElementDialog.getSchemaType() != null){
					// FIXME Handle if a root node is already added
					// Returns the TreeNodeImpl object respective to selectedEP
					EObject object = ((Node) selectedEP.getModel()).getElement();

					// Configure the new tree node by setting default values
					TreeNode treeNodeNew = DataMapperFactory.eINSTANCE.createTreeNode();
					treeNodeNew.setName(rootElementDialog.getName());
					treeNodeNew.setLevel(1);
					
					switch (rootElementDialog.getSchemaType()) {
					case "ARRAY":
						treeNodeNew.setSchemaDataType(SchemaDataType.ARRAY);
						break;
					case "BOOLEAN":
						treeNodeNew.setSchemaDataType(SchemaDataType.BOOLEAN);
						break;
					case "BYTES":
						treeNodeNew.setSchemaDataType(SchemaDataType.BYTES);
						break;
					case "DOUBLE":
						treeNodeNew.setSchemaDataType(SchemaDataType.DOUBLE);
						break;
					case "ENUM":
						treeNodeNew.setSchemaDataType(SchemaDataType.ENUM);
						break;
					case "FIXED":
						treeNodeNew.setSchemaDataType(SchemaDataType.FIXED);
						break;
					case "FLOAT":
						treeNodeNew.setSchemaDataType(SchemaDataType.FLOAT);
						break;
					case "INT":
						treeNodeNew.setSchemaDataType(SchemaDataType.INT);
						break;
					case "LONG":
						treeNodeNew.setSchemaDataType(SchemaDataType.LONG);
						break;
					case "MAP":
						treeNodeNew.setSchemaDataType(SchemaDataType.MAP);
						break;
					case "NULL":
						treeNodeNew.setSchemaDataType(SchemaDataType.NULL);
						break;
					case "RECORD":
						treeNodeNew.setSchemaDataType(SchemaDataType.RECORD);
						break;
					case "STRING":
						treeNodeNew.setSchemaDataType(SchemaDataType.STRING);
						break;
					case "UNION":
						treeNodeNew.setSchemaDataType(SchemaDataType.UNION);
						break;
					default:
						break;
					}
					
                    if(StringUtils.isNotEmpty(rootElementDialog.getNamespace())){
                    	treeNodeNew.setNamespace(rootElementDialog.getNamespace());
                    }
                    if(StringUtils.isNotEmpty(rootElementDialog.getDoc())){
                    	treeNodeNew.setDoc(rootElementDialog.getDoc());
                    }
                    if(rootElementDialog.getAliases() != null){
                        treeNodeNew.getAliases().addAll(rootElementDialog.getAliases());
                    }
					String selectedInputOutputEditPart = getSelectedInputOutputEditPart();
					if (null != selectedInputOutputEditPart) {
						AddCommand addCmd;
						if (INPUT_EDITPART.equals(selectedInputOutputEditPart)) {
							/*
							 * add command is changed to input tree node type when
							 * input editpart is selected. index 0 to add as the
							 * first child
							 */
							addCmd = new AddCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), object,
									DataMapperPackage.Literals.INPUT__TREE_NODE, treeNodeNew, 0);
						} else {
							/*
							 * add command is changed to output tree node type when
							 * output editpart is selected. index 0 to add as the
							 * first child
							 */
							addCmd = new AddCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), object,
									DataMapperPackage.Literals.OUTPUT__TREE_NODE, treeNodeNew, 0);
						}

						if (addCmd.canExecute()) {
							((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack().execute(addCmd);
						}

						// FIXME force refresh root
						if (null != selectedInputOutputEditPart) {
							if (selectedEP instanceof InputEditPart) {
								DataMapperRootEditPart rep = (DataMapperRootEditPart) selectedEP.getParent();
								DataMapperRoot rootDiagram = (DataMapperRoot) ((DiagramImpl) rep.getModel()).getElement();
								if (INPUT_EDITPART.equals(selectedInputOutputEditPart)) {
									EList<TreeNode> inputTreeNodesList = rootDiagram.getInput().getTreeNode();
									if (null != inputTreeNodesList && !inputTreeNodesList.isEmpty()) {
										// keep a temp reference
										TreeNodeImpl inputTreeNode = (TreeNodeImpl) inputTreeNodesList.get(0);
										// remove and add to rectify placing
										RemoveCommand rootRemCmd = new RemoveCommand(
												((GraphicalEditPart) selectedEP).getEditingDomain(),
												rootDiagram.getInput(), DataMapperPackage.Literals.INPUT__TREE_NODE,
												inputTreeNode);
										if (rootRemCmd.canExecute()) {
											((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack()
													.execute(rootRemCmd);
										}

										AddCommand rootAddCmd = new AddCommand(
												((GraphicalEditPart) selectedEP).getEditingDomain(),
												rootDiagram.getInput(), DataMapperPackage.Literals.INPUT__TREE_NODE,
												inputTreeNode, 0);
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
												((GraphicalEditPart) selectedEP).getEditingDomain(),
												rootDiagram.getOutput(), DataMapperPackage.Literals.OUTPUT__TREE_NODE,
												outputTreeNode);
										if (rootRemCmd.canExecute()) {
											((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack()
													.execute(rootRemCmd);
										}

										AddCommand rootAddCmd = new AddCommand(
												((GraphicalEditPart) selectedEP).getEditingDomain(),
												rootDiagram.getOutput(), DataMapperPackage.Literals.OUTPUT__TREE_NODE,
												outputTreeNode, 0);
										if (rootAddCmd.canExecute()) {
											((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack()
													.execute(rootAddCmd);
										}

									}
								}
							}

						}

					} else {
						log.error(ERROR_ADDING_NEW_CHILD);
						MessageDialog.openError(Display.getCurrent().getActiveShell(), ERROR, ERROR_ADDING_NEW_CHILD);
						return;
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

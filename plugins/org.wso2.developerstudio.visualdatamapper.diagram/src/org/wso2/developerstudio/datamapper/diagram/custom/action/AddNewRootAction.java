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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
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
import org.wso2.developerstudio.datamapper.PropertyKeyValuePair;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.custom.util.AddNewObjectDialog;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.DataMapperRootEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutputEditPart;
import org.wso2.developerstudio.datamapper.impl.TreeNodeImpl;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryFile;

public class AddNewRootAction extends AbstractActionHandler {

	private EditPart selectedEP;
	private static final String OUTPUT_EDITPART = "Output"; //$NON-NLS-1$
	private static final String INPUT_EDITPART = "Input"; //$NON-NLS-1$
	private static final String ADD_NEW_ROOT_RECORD_ACTION_ID = "add-new-root-record-action-id"; //$NON-NLS-1$
	private static final String ADD_NEW_ROOT_RECORD = Messages.AddNewRootRecordAction_addNewRoot;
	private static final String ERROR_ADDING_MULTIPLE_ROOT_ELEMENTS = Messages.AddNewRootRecordAction_addMultipleRootElements;
	private static final String ERROR_ADDING_MULTIPLE_ROOT_ELEMENTS_TITLE = Messages.AddNewRootRecordAction_addMultipleRootElementsTitle;
	private static final String ERROR = Messages.AddNewRootRecordAction_errorHeader;
	private static final String ERROR_ADDING_NEW_CHILD = Messages.AddNewRootRecordAction_errorAddChild;
	private static final String DIALOG_TITLE = "Add new Root Element";

	private static final String JSON_SCHEMA_REQUIRED = "required";
	private static final String JSON_SCHEMA_SCHEMA_VALUE = "$schema";
	private static final String JSON_SCHEMA_ID = "id";
	private static final String JSON_SCHEMA_TYPE = "type";
	private static final String JSON_SCHEMA_NAMESPACES = "namespaces";
	private static final String NAMESPACE_PREFIX = "prefix";
	private static final String NAMESPACE_URL = "url";
	private static final String JSON_SCHEMA_NULLABLE = "nullable";
	private static final String TRUE = "true";
	private static final String FALSE = "false";
	private static final String JSON_SCHEMA_ARRAY = "array";
	private static final String JSON_SCHEMA_ARRAY_ITEMS_ID = "items_id";
	private static final String JSON_SCHEMA_ARRAY_ITEMS_TYPE = "items_type";


	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public AddNewRootAction(IWorkbenchPart workbenchPart) {
		super(workbenchPart);

		setId(ADD_NEW_ROOT_RECORD_ACTION_ID);
		setText(ADD_NEW_ROOT_RECORD);
		setToolTipText(ADD_NEW_ROOT_RECORD);
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	public AddNewRootAction(IWorkbenchPart workbenchPart, EditPart currentlySelectedEP) {
		this(workbenchPart);
		selectedEP = currentlySelectedEP;
	}

	@Override
	public void doRun(IProgressMonitor progressMonitor) {
		if (selectedEP == null) {
			selectedEP = getSelectedEditPart();
		}
		if (null != selectedEP) {
			// Not allow to add multiple root elements
			if (!selectedEP.getChildren().isEmpty() && selectedEP instanceof InputEditPart) {
				MessageDialog.openWarning(Display.getCurrent().getActiveShell(),
						ERROR_ADDING_MULTIPLE_ROOT_ELEMENTS_TITLE, ERROR_ADDING_MULTIPLE_ROOT_ELEMENTS);
			} else {

				AddNewObjectDialog rootElementDialog = new AddNewObjectDialog(Display.getCurrent().getActiveShell(),
						new Class[] { IRegistryFile.class }, selectedEP);
				rootElementDialog.create();
				rootElementDialog.setTitle(DIALOG_TITLE);
				rootElementDialog.setVisibility(DIALOG_TITLE,false);
				rootElementDialog.setType(DIALOG_TITLE);
				rootElementDialog.open();

				EList<PropertyKeyValuePair> propertyValueList = new BasicEList<PropertyKeyValuePair>();

				if (rootElementDialog.getTitle() != null && rootElementDialog.getSchemaType() != null) {
					// Returns the TreeNodeImpl object respective to selectedEP
					EObject object = ((Node) selectedEP.getModel()).getElement();

					TreeNode treeNodeNew = DataMapperFactory.eINSTANCE.createTreeNode();
					if (StringUtils.isNotEmpty(rootElementDialog.getTitle())) {
						if(StringUtils.isNotEmpty(rootElementDialog.getNamespaces())){
						String objectNamespace = createNamespaceArray(rootElementDialog.getNamespaces());
							//Adds the prefix to the object
							String prefix = getNamespacePrefix(objectNamespace);
							String newNodeName = prefix+":"+ rootElementDialog.getTitle();
							treeNodeNew.setName(newNodeName);
						}else{
							treeNodeNew.setName(rootElementDialog.getTitle());
						}
						
					}
					treeNodeNew.setLevel(1);
					if (StringUtils.isNotEmpty(rootElementDialog.getSchemaType())) {
						setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_TYPE,
								rootElementDialog.getSchemaType());
					}
					if (StringUtils.isNotEmpty(rootElementDialog.getSchemaValue())) {
						setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_SCHEMA_VALUE,
								rootElementDialog.getSchemaValue());
					}
					if (StringUtils.isNotEmpty(rootElementDialog.getID())) {
						setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_ID,
								rootElementDialog.getID());
					}
					if (StringUtils.isNotEmpty(rootElementDialog.getRequired())) {
						setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_REQUIRED,
								rootElementDialog.getRequired());
					}
					if (StringUtils.isNotEmpty(rootElementDialog.getNamespaces())) {
						String namespaces = createNamespaceArray(rootElementDialog.getNamespaces());
						setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_NAMESPACES,
								namespaces);
					}
					
					//Sets the nullable value
					String nullableValue = null;
					if(rootElementDialog.getNullable()){
						nullableValue = TRUE;
					}else{
		                nullableValue = FALSE;
					}
					setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_NULLABLE,
							nullableValue);
					
					if(rootElementDialog.getSchemaType().equals(JSON_SCHEMA_ARRAY)){
						//Sets the values for items field which is used for serializing the array
						setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_ARRAY_ITEMS_ID, rootElementDialog.getID()+"/0");
						setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_ARRAY_ITEMS_TYPE, "");
					}
					String selectedInputOutputEditPart = getSelectedInputOutputEditPart();
					if (null != selectedInputOutputEditPart) {
						AddCommand addCmd;
						if (INPUT_EDITPART.equals(selectedInputOutputEditPart)) {
							/*
							 * add command is changed to input tree node type
							 * when input editpart is selected. index 0 to add
							 * as the first child
							 */
							addCmd = new AddCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), object,
									DataMapperPackage.Literals.INPUT__TREE_NODE, treeNodeNew, 0);
						} else {
							/*
							 * add command is changed to output tree node type
							 * when output editpart is selected. index 0 to add
							 * as the first child
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
								DataMapperRoot rootDiagram = (DataMapperRoot) ((DiagramImpl) rep.getModel())
										.getElement();
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

	/**
	 * Gets the namespace prefix
	 * 
	 * @param objectNamespace
	 * @return
	 */
	private String getNamespacePrefix(String objectNamespace) {
		String prefix = null;
		Pattern logEntry = Pattern.compile("\\{(.*?)\\}");
		Matcher matchPattern = logEntry.matcher(objectNamespace);
		while (matchPattern.find()) {
			String namespaceValue = matchPattern.group(1);
			String[] namespaceStringArrs = namespaceValue.split(",");
			for (String namespaceStringArr : namespaceStringArrs) {
				if (namespaceStringArr.contains("=")) {
					String[] namespacearr = namespaceStringArr.split("=");
					String firstElement = namespacearr[0].trim();
					String secondElement = namespacearr[1].trim();
					if (firstElement.contains("\\") || secondElement.contains("\\")) {
						String first = firstElement.replace("\\", "");
						String second = secondElement.replace("\\", "");
						if (first.equals(NAMESPACE_PREFIX)) {
							prefix = second;
							break;
						}

					} else {
						if (firstElement.equals(NAMESPACE_PREFIX)) {
							prefix = secondElement;
							break;
						}
					}
				}
			}

		}
		return prefix;
	}

	/**
	 * Creates namespace array
	 * 
	 * @param namespaces
	 * @return
	 */
	private String createNamespaceArray(String namespaces) {
		ArrayList<String> namespacesList = new ArrayList<String>();
		String[] namespaceArray = namespaces.split(",");
		for (String item : namespaceArray) {
			String[] fullItem = item.split("=");
			String prefix = fullItem[0];
			String url = fullItem[1];
			String prefixItem = NAMESPACE_PREFIX + "=" + prefix;
			String urlItem = NAMESPACE_URL + "=" + url;
			String[] namespaceItem = { prefixItem, urlItem };
			String namespaceArrayAsString = Arrays.toString(namespaceItem).substring(1,
					Arrays.toString(namespaceItem).length() - 1);
			namespacesList.add("{" + namespaceArrayAsString + "}");
		}
		String value = StringUtils.join(namespacesList, ',');
		return value;
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

	/**
	 * Sets the key value pair for tree nodes
	 * 
	 * @param treeNode
	 *            tree node
	 * @param propertyValueList
	 *            list
	 * @param key
	 *            key
	 * @param value
	 *            value
	 */
	private void setPropertyKeyValuePairforTreeNodes(TreeNode treeNode, EList<PropertyKeyValuePair> propertyValueList,
			String key, String value) {
		PropertyKeyValuePair keyValuePair = DataMapperFactory.eINSTANCE.createPropertyKeyValuePair();
		if (treeNode.getProperties().size() > 0) {
			// If the key is already there add the new value
			if (treeNode.getProperties().contains(key)) {
				for (PropertyKeyValuePair keyValue : treeNode.getProperties()) {
					if (keyValue.getKey().equals(key)) {
						keyValue.setValue(value);
						propertyValueList.add(keyValue);
					}
				}
			} else {
				// If the key is not there add a new key value
				keyValuePair.setKey(key);
				keyValuePair.setValue(value);
				propertyValueList.add(keyValuePair);

			}
			treeNode.getProperties().addAll(propertyValueList);
		} else {
			// Initially if there are no properties add the initial property
			keyValuePair.setKey(key);
			keyValuePair.setValue(value);
			propertyValueList.add(keyValuePair);
			treeNode.getProperties().addAll(propertyValueList);
		}
	}
}

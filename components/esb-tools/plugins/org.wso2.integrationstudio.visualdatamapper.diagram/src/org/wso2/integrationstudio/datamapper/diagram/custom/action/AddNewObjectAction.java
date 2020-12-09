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

package org.wso2.integrationstudio.datamapper.diagram.custom.action;

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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.integrationstudio.datamapper.DataMapperFactory;
import org.wso2.integrationstudio.datamapper.DataMapperPackage;
import org.wso2.integrationstudio.datamapper.DataMapperRoot;
import org.wso2.integrationstudio.datamapper.PropertyKeyValuePair;
import org.wso2.integrationstudio.datamapper.TreeNode;
import org.wso2.integrationstudio.datamapper.diagram.custom.util.AddNewObjectDialog;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.DataMapperRootEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OutputEditPart;
import org.wso2.integrationstudio.datamapper.impl.TreeNodeImpl;
import org.wso2.integrationstudio.eclipse.registry.core.interfaces.IRegistryFile;

public class AddNewObjectAction extends AbstractActionHandler {

	private EditPart selectedEP;
	private static final String OUTPUT_EDITPART = "Output"; //$NON-NLS-1$
	private static final String INPUT_EDITPART = "Input"; //$NON-NLS-1$
	private static final String ADD_NEW_RECORD_ACTION_ID = "add-new-record-action-id"; //$NON-NLS-1$
	private static final String ADD_NEW_RECORD = Messages.AddNewObjectAction_addNewObject;
	private static final String DIALOG_TITLE = "Add new Object";

	private static final String JSON_SCHEMA_REQUIRED = "required";
	private static final String JSON_SCHEMA_ID = "id";
	private static final String JSON_SCHEMA_TYPE = "type";
	private static final String JSON_SCHEMA_OBJECT_NAMESPACES = "objectNamespaces";
	private static final String JSON_SCHEMA_ADDED_PROPERTIES_ID = "added_properties_id";
	
	private static final String NAMESPACE_PREFIX = "prefix";
	private static final String NAMESPACE_URL = "url";
	private static final String HAS_PROPERTIES = "hasProperties";
	private static final String JSON_SCHEMA_OBJECT_VALUE_TYPE = "object_value_type";
	private static final String ELEMENT_IDENTIFIER = "type";
	private static final String JSON_SCHEMA_OBJECT_ELEMENT_IDENTIFIERS = "objectElementIdentifiers";
	private static final String JSON_SCHEMA_OBJECT_ELEMENT_IDENTIFIERS_URL = "objectElementIdentifiersURL";
	private static final String JSON_SCHEMA_OBJECT_ELEMENT_IDENTIFIERS_URL_VALUE = "objectElementIdentifiersURLValue";
	private static final String PREFIX = "@";
	private static final String JSON_SCHEMA_ADDED_ATTRIBUTE_ID = "added_attribute_id";
	private static final String JSON_SCHEMA_ADDED_ATTRIBUTE_TYPE = "added_attribute_type";
	private static final String STRING = "string";
	private static final String JSON_SCHEMA_ARRAY_ITEMS_ID = "items_id";
	private static final String JSON_SCHEMA_ARRAY_ITEMS_TYPE = "items_type";
	private static final String JSON_SCHEMA_NULLABLE = "nullable";
	private static final String TRUE = "true";
	private static final String FALSE = "false";

	public AddNewObjectAction(IWorkbenchPart workbenchPart) {
		super(workbenchPart);

		setId(ADD_NEW_RECORD_ACTION_ID);
		setText(ADD_NEW_RECORD);
		setToolTipText(ADD_NEW_RECORD);
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		selectedEP = getSelectedEditPart();

		AddNewObjectDialog objectDialog = new AddNewObjectDialog(Display.getCurrent().getActiveShell(),
				new Class[] { IRegistryFile.class }, selectedEP);
		objectDialog.create();
		objectDialog.setTitle(DIALOG_TITLE);
		objectDialog.setVisibility(DIALOG_TITLE,false);
		objectDialog.setType(DIALOG_TITLE);
		objectDialog.open();

		EList<PropertyKeyValuePair> propertyValueList = new BasicEList<PropertyKeyValuePair>();

		if (objectDialog.getTitle() != null && objectDialog.getSchemaType() != null) {
			if (null != selectedEP) {
				// Returns the TreeNodeImpl object respective to selectedEP
				EObject object = ((Node) selectedEP.getModel()).getElement();
				// Used to identify the selected resource of the model
				TreeNode selectedNode = (TreeNode) object;

				// Configure the new tree node by setting default values
				TreeNode treeNodeNew = DataMapperFactory.eINSTANCE.createTreeNode();
				if (StringUtils.isNotEmpty(objectDialog.getTitle())) {
					if(StringUtils.isNotEmpty(objectDialog.getNamespaces())){
					String objectNamespace = createNamespaceArray(objectDialog.getNamespaces());
						//Adds the prefix to the object
						String prefix = getNamespacePrefix(objectNamespace);
						String newNodeName = prefix+":"+ objectDialog.getTitle();
						treeNodeNew.setName(newNodeName);
					}else{
						treeNodeNew.setName(objectDialog.getTitle());
					}
					
				}
				treeNodeNew.setLevel(selectedNode.getLevel() + 1);

				if (StringUtils.isNotEmpty(objectDialog.getSchemaType())) {
					setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_TYPE,
							objectDialog.getSchemaType());
				}
				if (StringUtils.isNotEmpty(objectDialog.getID())) {
					setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_ID,
							objectDialog.getID());
				}
				if (StringUtils.isNotEmpty(objectDialog.getRequired())) {
					setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_REQUIRED,
							objectDialog.getRequired());
				}
				if (StringUtils.isNotEmpty(objectDialog.getNamespaces())) {
					String namespaces = createNamespaceArray(objectDialog.getNamespaces());
					setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_OBJECT_NAMESPACES,
							namespaces);
				}
				if(StringUtils.isNotEmpty(objectDialog.getIdentifierType())){
					String type = "{"+ ELEMENT_IDENTIFIER + "="+ objectDialog.getIdentifierType()+"}";
					setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_OBJECT_ELEMENT_IDENTIFIERS,
							type);
				}
				if(StringUtils.isNotEmpty(objectDialog.getIdentifierType()) && StringUtils.isNotEmpty(objectDialog.getIdentifierValue())){
					String fullName = objectDialog.getIdentifierType() + "=" + objectDialog.getIdentifierValue();
					treeNodeNew.setName(objectDialog.getTitle()+","+fullName);
				}
				
				if(StringUtils.isNotEmpty(objectDialog.getIdentifierURL()) && StringUtils.isNotEmpty(objectDialog.getIdentifierType())){
					String identifierNamespace = createNamespaceArrayForIdentifiers(objectDialog.getIdentifierType(),objectDialog.getIdentifierURL());
					setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_OBJECT_ELEMENT_IDENTIFIERS_URL,
							identifierNamespace);
				}
				
				if(StringUtils.isNotEmpty(objectDialog.getIdentifierURL())){
					setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_OBJECT_ELEMENT_IDENTIFIERS_URL_VALUE,
							objectDialog.getIdentifierURL());
				}
				
				//If the object adds as a child to an array( root is an array) then enable these properties
				setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_ARRAY_ITEMS_ID, objectDialog.getID()+"/"+ "0");
				setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_ARRAY_ITEMS_TYPE, objectDialog.getSchemaType());
				
				//sets the properties ID to be used in the serialization of the object
				setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_ADDED_PROPERTIES_ID, HAS_PROPERTIES);
				//sets the object's type if object hold a value
				if(StringUtils.isNotEmpty(objectDialog.getValue())){
				setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_OBJECT_VALUE_TYPE,objectDialog.getValue());
				}
				
				//If element contains an element identifier then add it as an attribute(child node)to the tree node
				if(StringUtils.isNotEmpty(objectDialog.getIdentifierType()) && StringUtils.isNotEmpty(objectDialog.getIdentifierValue())){
					EList<PropertyKeyValuePair> propertyValueListChild = new BasicEList<PropertyKeyValuePair>();
					TreeNode treeNodeChild = DataMapperFactory.eINSTANCE.createTreeNode();
					treeNodeChild.setName(PREFIX+objectDialog.getIdentifierType());
					treeNodeChild.setLevel(treeNodeNew.getLevel() + 1);
					//Sets the attribute ID and type to be used in serialization of the attributes
					String[] identifierArray =  null;
					String identifierPrefix = null;
					if(objectDialog.getIdentifierType().contains(":")){
						identifierArray = objectDialog.getIdentifierType().split(":");
						identifierPrefix = identifierArray[0];
					}else{
						identifierPrefix = objectDialog.getIdentifierType();
					}
					setPropertyKeyValuePairforTreeNodes(treeNodeChild, propertyValueListChild, JSON_SCHEMA_ID, objectDialog.getID()+"/"+identifierPrefix);
					setPropertyKeyValuePairforTreeNodes(treeNodeChild, propertyValueListChild, JSON_SCHEMA_TYPE, STRING);
					setPropertyKeyValuePairforTreeNodes(treeNodeChild, propertyValueListChild, JSON_SCHEMA_ADDED_ATTRIBUTE_ID, objectDialog.getID()+"/"+identifierPrefix);
					setPropertyKeyValuePairforTreeNodes(treeNodeChild, propertyValueListChild, JSON_SCHEMA_ADDED_ATTRIBUTE_TYPE,STRING);
					treeNodeNew.getNode().add(treeNodeChild);
				}
				
				//Sets the nullable value
				String nullableValue = null;
				if(objectDialog.getNullable()){
					nullableValue = TRUE;
				}else{
	                nullableValue = FALSE;
				}
				setPropertyKeyValuePairforTreeNodes(treeNodeNew, propertyValueList, JSON_SCHEMA_NULLABLE,
						nullableValue);
				
				/*
				 * AddCommand is used to avoid concurrent updating. index -1 to
				 * add as the first child
				 */

				AddCommand addCmd = new AddCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), selectedNode,
						DataMapperPackage.Literals.TREE_NODE__NODE, treeNodeNew, -1);
				if (addCmd.canExecute()) {
					((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack().execute(addCmd);
				}

				// FIXME force refresh root
				String selectedInputOutputEditPart = getSelectedInputOutputEditPart();
				if (null != selectedInputOutputEditPart) {

					if (selectedEP.getParent() instanceof InputEditPart) {
						InputEditPart iep = (InputEditPart) selectedEP.getParent();
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
	
	/**
	 * Creates namespace array for identifiers
	 * @param identifierType
	 * @param identifierURL
	 * @return
	 */
	private String createNamespaceArrayForIdentifiers(String identifierType, String identifierURL) {
		ArrayList<String> namespacesList = new ArrayList<String>();
		String[] identifierArray = null;
		String identifierPrefix =  null;
		if(identifierType.contains(":")){
			identifierArray = identifierType.split(":");
			identifierPrefix = identifierArray[0];
		}else{
			identifierPrefix = identifierType;
		}
		String prefixItem = NAMESPACE_PREFIX + "=" + identifierPrefix;
		String urlItem = NAMESPACE_URL + "=" + identifierURL;
		String [] namespaceItem = {prefixItem,urlItem};
		String namespaceArrayAsString =Arrays.toString(namespaceItem).substring(1, Arrays.toString(namespaceItem).length()-1);
		namespacesList.add("{"+ namespaceArrayAsString + "}");
		String value = StringUtils.join(namespacesList, ',');
		return value;
	}

	/**
	 * Gets the namespace prefix
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
						if(first.equals(NAMESPACE_PREFIX)){
							prefix = second;
							break;
						}
						
					} else {
						if(firstElement.equals(NAMESPACE_PREFIX)){
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
	 * @param namespaces
	 * @return
	 */
	private String createNamespaceArray(String namespaces) {
		ArrayList<String> namespacesList = new ArrayList<String>();
		String[] namespaceArray = namespaces.split(",");
		for (String item : namespaceArray){
			String[] fullItem = item.split("=");
			String prefix = fullItem[0];
			String url = fullItem[1]; 
			String prefixItem = NAMESPACE_PREFIX + "=" + prefix;
			String urlItem = NAMESPACE_URL + "=" + url;
			String [] namespaceItem = {prefixItem,urlItem};
			String namespaceArrayAsString =Arrays.toString(namespaceItem).substring(1, Arrays.toString(namespaceItem).length()-1);
			namespacesList.add("{"+ namespaceArrayAsString + "}");
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

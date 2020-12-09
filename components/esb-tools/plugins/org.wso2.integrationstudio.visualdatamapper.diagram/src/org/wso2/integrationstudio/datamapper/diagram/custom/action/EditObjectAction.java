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

package org.wso2.integrationstudio.datamapper.diagram.custom.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.integrationstudio.datamapper.DataMapperFactory;
import org.wso2.integrationstudio.datamapper.DataMapperPackage;
import org.wso2.integrationstudio.datamapper.PropertyKeyValuePair;
import org.wso2.integrationstudio.datamapper.TreeNode;
import org.wso2.integrationstudio.datamapper.diagram.custom.util.AddNewObjectDialog;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OutputEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNode2EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNode3EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNodeEditPart;
import org.wso2.integrationstudio.eclipse.registry.core.interfaces.IRegistryFile;

public class EditObjectAction extends AbstractActionHandler {

	private EditPart selectedEP;
	private static final String RENAME_ACTION_ID = "rename-node-action-id"; //$NON-NLS-1$
	private static final String RENAME_FIELD = Messages.EditActions_editObject;
	private static final String DIALOG_TITLE = "Edit Object";
	private static final String JSON_SCHEMA_REQUIRED = "required";
	private static final String JSON_SCHEMA_SCHEMA_VALUE = "$schema";
	private static final String JSON_SCHEMA_ID = "id";
	private static final String JSON_SCHEMA_TYPE = "type";
	private static final String JSON_SCHEMA_TITLE = "title";
	private static final String JSON_SCHEMA_NAMESPACES = "namespaces";
	private static final String JSON_SCHEMA_ADDED_PROPERTIES_ID = "added_properties_id";
	private static final String HAS_PROPERTIES = "hasProperties";
	private static final String JSON_SCHEMA_OBJECT_NAMESPACES = "objectNamespaces";
	private static final String JSON_SCHEMA_OBJECT_VALUE_TYPE = "object_value_type";
	private static final String ELEMENT_IDENTIFIER = "type";
	private static final String JSON_SCHEMA_OBJECT_ELEMENT_IDENTIFIERS = "objectElementIdentifiers";
	private static final String JSON_SCHEMA_OBJECT_ELEMENT_IDENTIFIERS_URL = "objectElementIdentifiersURL";
	private static final String JSON_SCHEMA_OBJECT_ELEMENT_IDENTIFIERS_URL_VALUE = "objectElementIdentifiersURLValue";
	private static final String PREFIX = "@";
	private static final String JSON_SCHEMA_ADDED_ATTRIBUTE_ID = "added_attribute_id";
	private static final String JSON_SCHEMA_ADDED_ATTRIBUTE_TYPE = "added_attribute_type";
	private static final String STRING = "string";
	private static final String JSON_SCHEMA_NULLABLE = "nullable";
	private static final String TRUE = "true";
	private static final String FALSE = "false";
	private static final String JSON_SCHEMA_OBJECT = "object";
	private static final String JSON_SCHEMA_ARRAY = "array";
	private static final String JSON_SCHEMA_ARRAY_NAMESPACES = "arrayNamespaces";
	private static final String JSON_SCHEMA_ARRAY_ITEMS_ID = "items_id";
	private static final String JSON_SCHEMA_ARRAY_ITEMS_TYPE = "items_type";
	private static final String JSON_SCHEMA_ARRAY_ITEMS_VALUE_TYPE = "items_value_type";
	private static final String JSON_SCHEMA_ARRAY_ELEMENT_IDENTIFIERS = "arrayElementIdentifiers";
	private static final String JSON_SCHEMA_ARRAY_ELEMENT_IDENTIFIERS_URL = "arrayElementIdentifiersURL";
	private static final String JSON_SCHEMA_ARRAY_ELEMENT_IDENTIFIERS_URL_VALUE = "arrayElementIdentifiersURLValue";
	private static final String JSON_SCHEMA_ARRAY_INTERREALTED_ELEMENT ="arrayInterrelatedElement";
	private static final String JSON_SCHEMA_FIELD_NAMESPACES = "fieldNamespaces";


	private String title = null;
	private String schemaType = null;
	private String id = null;
	private String schemaValue = null;
	private String namespaces = null;
	private String formatedNamespace = null;
	private String newNamespace = null;
	private String required = null;
	private String name = null;
	private String value = null;
	private String identifierType = null;
	private String identifierValue = null;
	private String identifierURL = null;
	private boolean isNullable = false;
	private String nullableValue = null;
	private static final String NAMESPACE_PREFIX = "prefix";
	private static final String NAMESPACE_URL = "url";
	private static final String JSON_SCHEMA_ARRAY_ROOT_INTERREALTED_ELEMENT = "arrayRootInterrelatedElement";
	boolean hasIdentifier = false;
	private boolean isOutputEditPart = false;
	private String interrelatedElement = null;
	private boolean isRootElement = false;
	private String rootInterrelatedElement;

	public EditObjectAction(IWorkbenchPart workbenchPart) {
		super(workbenchPart);

		setId(RENAME_ACTION_ID);
		setText(RENAME_FIELD);
		setToolTipText(RENAME_FIELD);
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		selectedEP = getSelectedEditPart();

		if (null != selectedEP) {
			// Returns the TreeNodeImpl object respective to selectedEP
			EObject object = ((Node) selectedEP.getModel()).getElement();
			// Used to identify the selected resource of the model
			TreeNode selectedNode = (TreeNode) object;

			title = selectedNode.getName();
			String[] valueofElementIdentifier = null;
			// If the element contains a xsi:type then split from ',' and get
			// the
			// name with the prefix
			if (title.contains(",")) {
				valueofElementIdentifier = title.split(",");
				title = valueofElementIdentifier[0];
				if (title.contains(":")) {
					// If element contains both xsi:type and namespace prefix
					int index = title.indexOf(":");
					name = title.substring(index + 1, title.length());
				} else {
					// If element contains only the xsi:type
					name = title;
				}
			} else if (title.contains(":")) {
				// If element conatains a namespace prefix
				int index = title.indexOf(":");
				name = title.substring(index + 1, title.length());
			} else {
				// If element doesn't contains a namespace prefix or xsi:type
				name = title;
			}

			schemaType = setProperties(selectedNode, JSON_SCHEMA_TYPE);
			id = setProperties(selectedNode, JSON_SCHEMA_ID);
			required = setProperties(selectedNode, JSON_SCHEMA_REQUIRED);
			schemaValue = setProperties(selectedNode, JSON_SCHEMA_SCHEMA_VALUE);
			value = setProperties(selectedNode, JSON_SCHEMA_OBJECT_VALUE_TYPE);
			if (valueofElementIdentifier != null) {
				String[] identifier = valueofElementIdentifier[1].trim().split("=");
				identifierType = identifier[0];
				identifierValue = identifier[1];
			}
			identifierURL = setProperties(selectedNode, JSON_SCHEMA_OBJECT_ELEMENT_IDENTIFIERS_URL_VALUE);
			// gets the objects  namespace when generating the tree
			namespaces = setProperties(selectedNode, JSON_SCHEMA_NAMESPACES);
			if (namespaces == null) {
				// gets the namespaces for objects when creating tree
				namespaces = setProperties(selectedNode, JSON_SCHEMA_OBJECT_NAMESPACES);
			}
			if (namespaces != null) {
				formatedNamespace = formatNamespace(namespaces).toString();
				newNamespace = formatedNamespace.substring(1, formatedNamespace.toString().length() - 1);
			}
			nullableValue = setProperties(selectedNode, JSON_SCHEMA_NULLABLE);
			if (nullableValue.equals(TRUE)) {
				isNullable = true;
			} else {
				isNullable = false;
			}
			//Check if the edit part is an output edit part
			isOutputEditPart  = checkContainer(selectedEP);
			if(isOutputEditPart){
				interrelatedElement = setProperties(selectedNode, JSON_SCHEMA_ARRAY_INTERREALTED_ELEMENT);
			}
			
			//Check if the edit part is an output edit part
			isOutputEditPart  = checkContainer(selectedEP);
			if(isOutputEditPart){
				rootInterrelatedElement = setProperties(selectedNode, JSON_SCHEMA_ARRAY_ROOT_INTERREALTED_ELEMENT);
			}
			
			if(selectedEP instanceof TreeNodeEditPart || selectedNode instanceof TreeNode3EditPart){
				isRootElement = true;
			}
			
			
			openEditRecordDialog(selectedNode, name, schemaType, id, required, schemaValue, newNamespace, value,
					identifierType, identifierValue, identifierURL, isNullable,interrelatedElement,isOutputEditPart,isRootElement, rootInterrelatedElement);

		}
	}

	/**
	 * check if the conatiner is an output edit part
	 * 
	 * @param selectedEP
	 * @return
	 */
	private boolean checkContainer(EditPart selectedEP) {
		if (selectedEP.getParent() instanceof OutputEditPart) {
			return true;
		} else if (selectedEP.getParent() instanceof InputEditPart) {
			return false;
		} else {
			return checkContainer(selectedEP.getParent());
		}
	}
	
	/**
	 * Formats the namespace to the required format
	 * 
	 * @param namespaces
	 *            in {prefix=w, url=r}
	 * @return w=r
	 */
	private ArrayList<String> formatNamespace(String namespaces) {
		Map<String, String> namespaceMap = new HashMap<String, String>();
		ArrayList<String> namespaceArray = new ArrayList<String>();
		String newNamespace = null;
		if (namespaces != null) {
			Pattern logEntry = Pattern.compile("\\{(.*?)\\}");
			Matcher matchPattern = logEntry.matcher(namespaces);
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
							namespaceMap.put(first, second);
						} else {
							namespaceMap.put(firstElement, secondElement);
						}
					}

				}
				newNamespace = namespaceMap.get(NAMESPACE_PREFIX) + "=" + namespaceMap.get(NAMESPACE_URL);
				namespaceArray.add(newNamespace);
			}
		}
		return namespaceArray;
	}

	private String setProperties(TreeNode selectedNode, String key) {
		String value = null;
		for (PropertyKeyValuePair keyValue : selectedNode.getProperties()) {
			if (keyValue.getKey().equals(key)) {
				value = keyValue.getValue();
				break;
			}
		}
		return value;
	}

	/**
	 * Reflects the changes in the tree view
	 * 
	 * @param selectedElem
	 * @param map
	 * @param treeNodeChild
	 * @param newValueMap
	 */
	private void reflectChanges(TreeNode selectedNode, HashMap<String, String> map, TreeNode treeNodeChild,
			HashMap<String, String> newValueMap) {

		// Updates the root element
		executeRemoveCommand(selectedNode);
		renameTitle(map);
		recreateTheTree(selectedNode, map);

		// Adds the new child to the root
		if (treeNodeChild != null) {
			executeAddCommandForChild(selectedNode, treeNodeChild);
			// removes the existing properties of the child node
			executeRemoveCommand(treeNodeChild);
			// Updates the child element
			if (newValueMap.size() > 0) {
				recreateTheTree(treeNodeChild, newValueMap);
			}
		}

		updateConnector(map);

	}

	/**
	 * Creates the tree by adding properties
	 * 
	 * @param selectedNode
	 * @param map
	 */
	private void recreateTheTree(TreeNode selectedNode, HashMap<String, String> map) {
		@SuppressWarnings("rawtypes")
		Iterator entries = map.entrySet().iterator();
		while (entries.hasNext()) {

			@SuppressWarnings("rawtypes")
			Entry thisEntry = (Entry) entries.next();
			Object key = thisEntry.getKey();
			Object value = thisEntry.getValue();
			if (key.equals(JSON_SCHEMA_TITLE)) {
				executeCommand(selectedNode, DataMapperPackage.Literals.TREE_NODE__NAME, map.get(JSON_SCHEMA_TITLE));
			} else {
				PropertyKeyValuePair pair = setPropertyKeyValuePairforTreeNodes(selectedNode, key.toString(),
						value.toString());
				executeAddCommand(selectedNode, pair);
			}
		}
	}

	/**
	 * Executes the add cmd for child
	 * 
	 * @param selectedNode
	 * @param treeNodeChild
	 */
	private void executeAddCommandForChild(TreeNode selectedNode, TreeNode treeNodeChild) {
		AddCommand addCmd = new AddCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), selectedNode,
				DataMapperPackage.Literals.TREE_NODE__NODE, treeNodeChild, 0);
		if (addCmd.canExecute()) {
			((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack().execute(addCmd);
		}
	}

	/**
	 * Updates the connector
	 * 
	 * @param map
	 */
	private void updateConnector(HashMap<String, String> map) {
		if (getSelectedEditPart() instanceof TreeNodeEditPart) {
			((TreeNodeEditPart) getSelectedEditPart()).addFixedChildToNodes(getSelectedEditPart());
			((TreeNodeEditPart) getSelectedEditPart()).recreateContent(map.get(JSON_SCHEMA_TITLE),
					map.get(JSON_SCHEMA_TYPE));
		} else if (getSelectedEditPart() instanceof TreeNode2EditPart) {
			((TreeNode2EditPart) getSelectedEditPart()).addFixedChildToNodes(getSelectedEditPart());
			((TreeNode2EditPart) getSelectedEditPart()).recreateContent(map.get(JSON_SCHEMA_TITLE),
					map.get(JSON_SCHEMA_TYPE));
		} else if (getSelectedEditPart() instanceof TreeNode3EditPart) {
			((TreeNode3EditPart) getSelectedEditPart()).addFixedChildToNodes(getSelectedEditPart());
			((TreeNode3EditPart) getSelectedEditPart()).recreateContent(map.get(JSON_SCHEMA_TITLE),
					map.get(JSON_SCHEMA_TYPE));
		}
	}

	/**
	 * Renames the title
	 * 
	 * @param map
	 */
	private void renameTitle(HashMap<String, String> map) {
		if (map.get(JSON_SCHEMA_TITLE) != null) {
			if (getSelectedEditPart() instanceof TreeNodeEditPart) {
				((TreeNodeEditPart) getSelectedEditPart()).renameElementItem(map.get(JSON_SCHEMA_TITLE),
						map.get(JSON_SCHEMA_TYPE));
			} else if (getSelectedEditPart() instanceof TreeNode2EditPart) {
				((TreeNode2EditPart) getSelectedEditPart()).renameElementItem(map.get(JSON_SCHEMA_TITLE),
						map.get(JSON_SCHEMA_TYPE));
			} else if (getSelectedEditPart() instanceof TreeNode3EditPart) {
				((TreeNode3EditPart) getSelectedEditPart()).renameElementItem(map.get(JSON_SCHEMA_TITLE),
						map.get(JSON_SCHEMA_TYPE));
			}
		}
	}

	/**
	 * Removes the existing properties
	 * 
	 * @param selectedNode
	 *            tree node
	 */
	private void executeRemoveCommand(TreeNode selectedNode) {
		RemoveCommand rootRemCmd = new RemoveCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), selectedNode,
				DataMapperPackage.Literals.TREE_NODE__PROPERTIES, selectedNode.getProperties());
		if (rootRemCmd.canExecute()) {
			((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack().execute(rootRemCmd);
		}

	}

	/**
	 * Saves the properties to tree
	 * 
	 * @param selectedNode
	 * @param keyValPair
	 */
	private void executeAddCommand(TreeNode selectedNode, PropertyKeyValuePair keyValPair) {
		AddCommand addCmd = new AddCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), selectedNode,
				DataMapperPackage.Literals.TREE_NODE__PROPERTIES, keyValPair);
		if (addCmd.canExecute()) {
			((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack().execute(addCmd);
		}
	}

	/**
	 * Save edited values into the model
	 * 
	 * @param selectedNode
	 *            node
	 * @param String
	 *            value
	 */
	private void executeCommand(TreeNode selectedNode, EStructuralFeature feature, String value) {
		SetCommand editComd = new SetCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), selectedNode, feature,
				value);
		if (editComd.canExecute()) {
			((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack().execute(editComd);
		}
	}

	/**
	 * opens the dilaog
	 * 
	 * @param selectedNode
	 *            node
	 * @param title
	 *            title
	 * @param schemaType
	 *            schematype
	 * @param id
	 *            id
	 * @param required
	 *            required
	 * @param schemaValue
	 *            schema value
	 * @param interrelatedElement 
	 * @param rootInterrelatedElement
	 * @param isRootElement2 
	 * @param isNullable2
	 * @param identifierValue2
	 * @param identifierType2
	 */
	private void openEditRecordDialog(TreeNode selectedNode, String title, String schemaType, String id,
			String required, String schemaValue, String namespaces, String value, String identifierType,
			String identifierValue, String identifierURL, boolean isNullable,String interrelatedElement, boolean isOutputEditPart, boolean isRootElement, String rootInterrelatedElement) {
		Shell shell = Display.getDefault().getActiveShell();
		AddNewObjectDialog editTypeDialog = new AddNewObjectDialog(shell, new Class[] { IRegistryFile.class }, selectedEP);

		editTypeDialog.create();
		editTypeDialog.setTypeWhenEditing(schemaType);
		editTypeDialog.setValues(title, schemaType, id, required, schemaValue, namespaces, value, identifierType,
				identifierValue, identifierURL, isNullable,interrelatedElement,isOutputEditPart,isRootElement, rootInterrelatedElement);
		editTypeDialog.setTitle(DIALOG_TITLE);
		editTypeDialog.open();

		if (editTypeDialog.getOkValue()) {
			HashMap<String, String> valueMap = new HashMap<String, String>();
			HashMap<String, String> newValueMap = new HashMap<String, String>();

			if (StringUtils.isNotEmpty(editTypeDialog.getTitle())) {
				if (StringUtils.isNotEmpty(editTypeDialog.getNamespaces())) {
					String objectNamespace = createNamespaceArray(editTypeDialog.getNamespaces());
					// Adds the prefix to the object
					String prefix = getNamespacePrefix(objectNamespace);
					String newNodeName = prefix + ":" + editTypeDialog.getTitle();
					valueMap.put(JSON_SCHEMA_TITLE, newNodeName);
				} else {
					valueMap.put(JSON_SCHEMA_TITLE, editTypeDialog.getTitle());
				}
			}

			valueMap.put(JSON_SCHEMA_TYPE, editTypeDialog.getSchemaType());

			if (StringUtils.isNotEmpty(editTypeDialog.getID())) {
				valueMap.put(JSON_SCHEMA_ID, editTypeDialog.getID());
			}

			if (StringUtils.isNotEmpty(editTypeDialog.getSchemaValue())) {
				valueMap.put(JSON_SCHEMA_SCHEMA_VALUE, editTypeDialog.getSchemaValue());
			}

			if (StringUtils.isNotEmpty(editTypeDialog.getRequired())) {
				valueMap.put(JSON_SCHEMA_REQUIRED, editTypeDialog.getRequired());
			}
			
			if (editTypeDialog.getNullable()) {
				valueMap.put(JSON_SCHEMA_NULLABLE, TRUE);
			} else {
				valueMap.put(JSON_SCHEMA_NULLABLE, FALSE);
			}
			
			//When editing, if the type sets to object
			if(editTypeDialog.getSchemaType().equals(JSON_SCHEMA_OBJECT)){
				setPropertiesForTypeObject(editTypeDialog, valueMap);
			}else if(editTypeDialog.getSchemaType().equals(JSON_SCHEMA_ARRAY)){
				//When editing, if the type sets to object
				setPropertiesForTypeArray(editTypeDialog,valueMap,selectedNode);
			}/*else{
				setPropertiesForTypePrimitive(editTypeDialog,valueMap);
			}*/
		
			// Check for element identifiers
			TreeNode treeNodeChild = getChildTreeNode(identifierType, selectedNode);

			if (hasIdentifier && treeNodeChild != null) {
				removeTreeNode(selectedNode, treeNodeChild);
				hasIdentifier = false;
			}

			TreeNode newChild = updateElementIdentifier(selectedNode, editTypeDialog, valueMap, newValueMap);
			
			//If the object changes to a primitive type then remove the child nodes
			/*if(!editTypeDialog.getSchemaType().equals(JSON_SCHEMA_OBJECT) && !editTypeDialog.getSchemaType().equals(JSON_SCHEMA_ARRAY)){
				EList<TreeNode> nodeList = selectedNode.getNode();
				RemoveCommand rootRemCmd = new RemoveCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), selectedNode,
						DataMapperPackage.Literals.TREE_NODE__NODE, nodeList);
				if (rootRemCmd.canExecute()) {
					((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack().execute(rootRemCmd);
				}
			}*/
			reflectChanges(selectedNode, valueMap, newChild, newValueMap);

		}

	}

	/**
	 * Set the properties belong to type primitive
	 * @param editTypeDialog
	 * @param valueMap
	 */
	private void setPropertiesForTypePrimitive(AddNewObjectDialog editTypeDialog, HashMap<String, String> valueMap) {
		if (StringUtils.isNotEmpty(editTypeDialog.getNamespaces())) {
			String namespacesValue = createNamespaceArray(editTypeDialog.getNamespaces());
			valueMap.put(JSON_SCHEMA_FIELD_NAMESPACES, namespacesValue);
		}
		
	}

	/**
	 * Set the properties belong to type object
	 * @param editTypeDialog
	 * @param valueMap
	 */
	private void setPropertiesForTypeObject(AddNewObjectDialog editTypeDialog, HashMap<String, String> valueMap) {
		// sets the properties ID to be used in serialization
		valueMap.put(JSON_SCHEMA_ADDED_PROPERTIES_ID, HAS_PROPERTIES);
		
		if (StringUtils.isNotEmpty(editTypeDialog.getNamespaces())) {
			String namespacesValue = createNamespaceArray(editTypeDialog.getNamespaces());
			valueMap.put(JSON_SCHEMA_NAMESPACES, namespacesValue);
			valueMap.put(JSON_SCHEMA_OBJECT_NAMESPACES, namespacesValue);
		}
		
		// sets the object's type if object hold a value
		if (StringUtils.isNotEmpty(editTypeDialog.getValue())) {
			valueMap.put(JSON_SCHEMA_OBJECT_VALUE_TYPE, editTypeDialog.getValue());
		}

		if (StringUtils.isNotEmpty(editTypeDialog.getIdentifierType())) {
			String type = "{" + ELEMENT_IDENTIFIER + "=" + editTypeDialog.getIdentifierType() + "}";
			valueMap.put(JSON_SCHEMA_OBJECT_ELEMENT_IDENTIFIERS, type);
		}
		if (StringUtils.isNotEmpty(editTypeDialog.getIdentifierURL())) {
			valueMap.put(JSON_SCHEMA_OBJECT_ELEMENT_IDENTIFIERS_URL_VALUE, editTypeDialog.getIdentifierURL());
		}

		if (StringUtils.isNotEmpty(editTypeDialog.getIdentifierURL())
				&& StringUtils.isNotEmpty(editTypeDialog.getIdentifierType())) {
			String identifierNamespace = createNamespaceArrayForIdentifiers(editTypeDialog.getIdentifierType(),
					editTypeDialog.getIdentifierURL());
			valueMap.put(JSON_SCHEMA_OBJECT_ELEMENT_IDENTIFIERS_URL, identifierNamespace);
		}
	}
	
	
	
	
	/**
	 * Set the properties belong to type array
	 * @param editTypeDialog
	 * @param valueMap
	 */
	private void setPropertiesForTypeArray(AddNewObjectDialog editTypeDialog, HashMap<String, String> valueMap, TreeNode selectedNode) {

		if (StringUtils.isNotEmpty(editTypeDialog.getNamespaces())) {
			String namespacesValue = createNamespaceArray(editTypeDialog.getNamespaces());
			valueMap.put(JSON_SCHEMA_ARRAY_NAMESPACES, namespacesValue);
		}
		// Sets the interrelated element
		if (StringUtils.isNotEmpty(editTypeDialog.getInterrelatedElement())) {
			valueMap.put(JSON_SCHEMA_ARRAY_INTERREALTED_ELEMENT, editTypeDialog.getInterrelatedElement());
		}
		
		// Sets the root interrelated element
		if (StringUtils.isNotEmpty(editTypeDialog.getRootInterrelatedElement())) {
			valueMap.put(JSON_SCHEMA_ARRAY_ROOT_INTERREALTED_ELEMENT, editTypeDialog.getRootInterrelatedElement());
		}

		// Sets the values for items field which is used for serializing the
		// array
		valueMap.put(JSON_SCHEMA_ARRAY_ITEMS_ID, editTypeDialog.getID() + "/0");
		// If the node has children, then set the item type as object
		if (checkForChildren(selectedNode)) {
			valueMap.put(JSON_SCHEMA_ARRAY_ITEMS_TYPE, JSON_SCHEMA_OBJECT);
		} else if (StringUtils.isNotEmpty(editTypeDialog.getValue())) {
			// Else if the array is a primitive type array then set the value as
			// the item type
			valueMap.put(JSON_SCHEMA_ARRAY_ITEMS_TYPE, editTypeDialog.getValue());
		} else {
			valueMap.put(JSON_SCHEMA_ARRAY_ITEMS_TYPE, "");
		}

		// sets the value type if item holds a value
		if (StringUtils.isNotEmpty(editTypeDialog.getValue())) {
			valueMap.put(JSON_SCHEMA_ARRAY_ITEMS_VALUE_TYPE, editTypeDialog.getValue());
		}
		// sets the properties ID to be used in serialization
		valueMap.put(JSON_SCHEMA_ADDED_PROPERTIES_ID, HAS_PROPERTIES);

		if (StringUtils.isNotEmpty(editTypeDialog.getIdentifierType())) {
			String type = "{" + ELEMENT_IDENTIFIER + "=" + editTypeDialog.getIdentifierType() + "}";
			valueMap.put(JSON_SCHEMA_ARRAY_ELEMENT_IDENTIFIERS, type);
		}

		if (StringUtils.isNotEmpty(editTypeDialog.getIdentifierURL())) {
			valueMap.put(JSON_SCHEMA_ARRAY_ELEMENT_IDENTIFIERS_URL_VALUE, editTypeDialog.getIdentifierURL());
		}

		if (StringUtils.isNotEmpty(editTypeDialog.getIdentifierURL())
				&& StringUtils.isNotEmpty(editTypeDialog.getIdentifierType())) {
			String identifierNamespace = createNamespaceArrayForIdentifiers(editTypeDialog.getIdentifierType(),
					editTypeDialog.getIdentifierURL());
			valueMap.put(JSON_SCHEMA_ARRAY_ELEMENT_IDENTIFIERS_URL, identifierNamespace);
		}
	}
	

	private boolean checkForChildren(TreeNode node) {
		EList<TreeNode> nodeList = node.getNode();
		if(nodeList.size() >0){
			return true;
		}else{
			return false;
		}

	}

	/**
	 * Updates the element identifiers
	 * 
	 * @param selectedNode
	 * @param editTypeDialog
	 * @param valueMap
	 * @param newValueMap
	 * @return
	 */
	private TreeNode updateElementIdentifier(TreeNode selectedNode, AddNewObjectDialog editTypeDialog,
			HashMap<String, String> valueMap, HashMap<String, String> newValueMap) {
		TreeNode newChild = null;
		if (StringUtils.isNotEmpty(editTypeDialog.getIdentifierType())
				&& StringUtils.isNotEmpty(editTypeDialog.getIdentifierValue())) {
			newChild = DataMapperFactory.eINSTANCE.createTreeNode();
			String fullName = editTypeDialog.getIdentifierType() + "=" + editTypeDialog.getIdentifierValue();
			valueMap.put(JSON_SCHEMA_TITLE, editTypeDialog.getTitle() + ", " + fullName);
			newChild.setName(PREFIX + editTypeDialog.getIdentifierType());
			newChild.setLevel(selectedNode.getLevel() + 1);
			String[] identifierArray = null;
			String identifierPrefix = null;
			if (editTypeDialog.getIdentifierType().contains(":")) {
				identifierArray = editTypeDialog.getIdentifierType().split(":");
				identifierPrefix = identifierArray[0];
			} else {
				identifierPrefix = editTypeDialog.getIdentifierType();
			}
			// Sets the attribute ID and type to be used in serialization of
			// the attributes
			newValueMap.put(JSON_SCHEMA_ID, editTypeDialog.getID() + "/" + identifierPrefix);
			newValueMap.put(JSON_SCHEMA_TYPE, STRING);
			newValueMap.put(JSON_SCHEMA_ADDED_ATTRIBUTE_ID, editTypeDialog.getID() + "/" + identifierPrefix);
			newValueMap.put(JSON_SCHEMA_ADDED_ATTRIBUTE_TYPE, STRING);
		}
		return newChild;
	}

	/**
	 * Removes the existing element identifier node
	 * 
	 * @param selectedNode
	 * @param treeNodeChild
	 */
	private void removeTreeNode(TreeNode selectedNode, TreeNode treeNodeChild) {
		RemoveCommand rootRemCmd = new RemoveCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), selectedNode,
				DataMapperPackage.Literals.TREE_NODE__NODE, treeNodeChild);
		if (rootRemCmd.canExecute()) {
			((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack().execute(rootRemCmd);
		}
	}

	/**
	 * Gets the child tree node if it already has an element identifier as an
	 * attribute
	 * 
	 * @param identifierType
	 * @param hasIdentifier
	 * @param nodeList
	 * @return child node
	 */
	private TreeNode getChildTreeNode(String identifierType, TreeNode selectedNode) {
		TreeNode childNode = null;
		EList<TreeNode> nodeList = selectedNode.getNode();
		for (TreeNode node : nodeList) {
			if (StringUtils.isNotEmpty(identifierType)) {
				if (node.getName().equals(PREFIX + identifierType)) {
					hasIdentifier = true;
					childNode = node;
					break;
				}
			}
		}
		return childNode;
	}

	/**
	 * Creates namespace array for identifiers
	 * 
	 * @param identifierType
	 * @param identifierURL
	 * @return
	 */
	private String createNamespaceArrayForIdentifiers(String identifierType, String identifierURL) {
		ArrayList<String> namespacesList = new ArrayList<String>();
		String[] identifierArray = null;
		String identifierPrefix = null;
		if (identifierType.contains(":")) {
			identifierArray = identifierType.split(":");
			identifierPrefix = identifierArray[0];
		} else {
			identifierPrefix = identifierType;
		}
		String prefixItem = NAMESPACE_PREFIX + "=" + identifierPrefix;
		String urlItem = NAMESPACE_URL + "=" + identifierURL;
		String[] namespaceItem = { prefixItem, urlItem };
		String namespaceArrayAsString = Arrays.toString(namespaceItem).substring(1,
				Arrays.toString(namespaceItem).length() - 1);
		namespacesList.add("{" + namespaceArrayAsString + "}");
		String value = StringUtils.join(namespacesList, ',');
		return value;
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
	 * sets the property values
	 * 
	 * @param treeNode
	 * @param key
	 * @param value
	 * @return
	 */
	private PropertyKeyValuePair setPropertyKeyValuePairforTreeNodes(TreeNode treeNode, String key, String value) {
		PropertyKeyValuePair keyValuePair = DataMapperFactory.eINSTANCE.createPropertyKeyValuePair();
		keyValuePair.setKey(key);
		keyValuePair.setValue(value);
		return keyValuePair;
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
}

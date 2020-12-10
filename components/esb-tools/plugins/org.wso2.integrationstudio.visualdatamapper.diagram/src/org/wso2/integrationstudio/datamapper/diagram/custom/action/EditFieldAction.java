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
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNode2EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNode3EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNodeEditPart;
import org.wso2.integrationstudio.eclipse.registry.core.interfaces.IRegistryFile;

public class EditFieldAction extends AbstractActionHandler {

	private EditPart selectedEP;
	private static final String RENAME_ACTION_ID = "rename-node-action-id"; //$NON-NLS-1$
	private static final String RENAME_FIELD = Messages.EditActions_editField;
	private static final String DIALOG_TITLE = "Edit Field";
	private static final String JSON_SCHEMA_REQUIRED = "required";
	private static final String JSON_SCHEMA_SCHEMA_VALUE = "$schema";
	private static final String JSON_SCHEMA_ID = "id";
	private static final String JSON_SCHEMA_TYPE = "type";
	private static final String JSON_SCHEMA_TITLE = "title";

	private static final String JSON_SCHEMA_FIELD_NAMESPACES = "fieldNamespaces";
	private static final String JSON_SCHEMA_NAMESPACES = "namespaces";
	private static final String NAMESPACE_PREFIX = "prefix";
	private static final String NAMESPACE_URL = "url";
	private static final String JSON_SCHEMA_NULLABLE = "nullable";
	private static final String TRUE = "true";
	private static final String FALSE = "false";

	private String title = null;
	private String schemaType = null;
	private String id = null;
	private String name = null;
	private String schemaValue = null;
	private String namespaces = null;
	private String required = null;
	private String formatedNamespace = null;	
	private String newNamespace = null;
	private boolean isNullable = false;
	private String nullableValue = null;


	public EditFieldAction(IWorkbenchPart workbenchPart) {
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
			//Gets the element's namespace when generating the tree
			namespaces = setProperties(selectedNode, JSON_SCHEMA_NAMESPACES);
			if (namespaces == null) {
				// gets the namespaces for elements when creating tree
				namespaces = setProperties(selectedNode, JSON_SCHEMA_FIELD_NAMESPACES);
			}
			if (namespaces != null) {
				formatedNamespace = formatNamespace(namespaces).toString();
				newNamespace = formatedNamespace.substring(1, formatedNamespace.toString().length() - 1);
			}
			
			nullableValue = setProperties(selectedNode, JSON_SCHEMA_NULLABLE);
			if(nullableValue.equals(TRUE)){
				isNullable = true;
			}else{
				isNullable = false;
			}
			openEditRecordDialog(selectedNode, name, schemaType, id, required, schemaValue, newNamespace,isNullable);

		}
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
	 */
	private void reflectChanges(TreeNode selectedNode, HashMap<String, String> map) {

		@SuppressWarnings("rawtypes")
		Iterator entries = map.entrySet().iterator();
		executeRemoveCommand(selectedNode);
		renameTitle(map);

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
		updateConnector(map);
	}

	/**
	 * Updates the connector
	 * @param map 
	 */
	private void updateConnector(HashMap<String, String> map) {
		if (getSelectedEditPart() instanceof TreeNodeEditPart) {
			((TreeNodeEditPart) getSelectedEditPart()).addFixedChildToNodes(getSelectedEditPart());
			((TreeNodeEditPart)getSelectedEditPart()).recreateContent(map.get(JSON_SCHEMA_TITLE),
					map.get(JSON_SCHEMA_TYPE));
		} else if (getSelectedEditPart() instanceof TreeNode2EditPart) {
			((TreeNode2EditPart) getSelectedEditPart()).addFixedChildToNodes(getSelectedEditPart());
			((TreeNode2EditPart)getSelectedEditPart()).recreateContent(map.get(JSON_SCHEMA_TITLE),
					map.get(JSON_SCHEMA_TYPE));
		} else if (getSelectedEditPart() instanceof TreeNode3EditPart) {
			((TreeNode3EditPart) getSelectedEditPart()).addFixedChildToNodes(getSelectedEditPart());
			((TreeNode3EditPart)getSelectedEditPart()).recreateContent(map.get(JSON_SCHEMA_TITLE),
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
	 * @param isNullable2 
	 * @param identifierValue2
	 * @param identifierType2
	 */
	private void openEditRecordDialog(TreeNode selectedNode, String title, String schemaType, String id,
			String required, String schemaValue, String namespaces, boolean isNullable) {
		Shell shell = Display.getDefault().getActiveShell();
		AddNewObjectDialog editTypeDialog = new AddNewObjectDialog(shell, new Class[] { IRegistryFile.class }, selectedEP);

		editTypeDialog.create();
		editTypeDialog.setTypeWhenEditing(schemaType);
		editTypeDialog.setValues(title, schemaType, id, required, schemaValue, namespaces, null, null,
				null, null,isNullable,null,false,false, null);
		editTypeDialog.setTitle(DIALOG_TITLE);
		editTypeDialog.open();

		if (editTypeDialog.getOkValue()) {
			HashMap<String, String> valueMap = new HashMap<String, String>();

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

			if (StringUtils.isNotEmpty(editTypeDialog.getNamespaces())) {
				String namespacesValue = createNamespaceArray(editTypeDialog.getNamespaces());
				valueMap.put(JSON_SCHEMA_FIELD_NAMESPACES, namespacesValue);
			}
			
			if(editTypeDialog.getNullable()){
				valueMap.put(JSON_SCHEMA_NULLABLE, TRUE);
			}else{
				valueMap.put(JSON_SCHEMA_NULLABLE, FALSE);
			}

			reflectChanges(selectedNode, valueMap);

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

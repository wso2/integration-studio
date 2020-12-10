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
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
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
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNode2EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNode3EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNodeEditPart;
import org.wso2.integrationstudio.datamapper.impl.TreeNodeImpl;
import org.wso2.integrationstudio.eclipse.registry.core.interfaces.IRegistryFile;

public class EditAttributeAction extends AbstractActionHandler {
	private EditPart selectedEP;
	private static final String RENAME_ACTION_ID = "rename-field-action-id"; //$NON-NLS-1$
	private static final String RENAME_FIELD = Messages.EditActions_editAttribute;
	private static final String DIALOG_TITLE = "Edit Attribute";
	private static final String JSON_SCHEMA_ID = "id";
	private static final String JSON_SCHEMA_TYPE = "type";
	private static final String JSON_SCHEMA_TITLE = "title";
	private static final String PREFIX = "@";
	private static final String NAMESPACE_PREFIX = "prefix";
	private static final String NAMESPACE_URL = "url";
	private static final String JSON_SCHEMA_ATTRIBUTE_NAMESPACES = "attributeNamespaces";
	private static final String JSON_SCHEMA_NAMESPACES = "namespaces";
	private static final String JSON_SCHEMA_ADDED_ATTRIBUTE_ID = "added_attribute_id";
	private static final String JSON_SCHEMA_ADDED_ATTRIBUTE_TYPE = "added_attribute_type";
	private static final String JSON_SCHEMA_NULLABLE = "nullable";
	private static final String TRUE = "true";
	private static final String FALSE = "false";

	private String title = null;
	private String name = null;
	private String schemaType = null;
	private String id = null;
	private String schemaValue = null;
	private String required = null;
	private String namespaces = null;
	private String formatedNamespace = null;
	private String newNamespace = null;
	private boolean isNullable = false;
	private String nullableValue = null;

	public EditAttributeAction(IWorkbenchPart workbenchPart) {
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
			if (title.startsWith(PREFIX) && title.contains(":")) {
				int index = title.indexOf(":");
				name = title.substring(index + 1, title.length());
			} else if (title.startsWith(PREFIX)) {
				name = title.substring(1);
			} else {
				name = title;
			}

			schemaType = setProperties(selectedNode, JSON_SCHEMA_TYPE);
			id = setProperties(selectedNode, JSON_SCHEMA_ID);

			// gets the attribute's namespace when generating the tree
			namespaces = setProperties(selectedNode, JSON_SCHEMA_NAMESPACES);
			if (namespaces == null) {
				// gets the namespaces for attributes when creating tree
				namespaces = setProperties(selectedNode, JSON_SCHEMA_ATTRIBUTE_NAMESPACES);
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
			openEditFieldDialog(selectedNode, name, schemaType, id, required, schemaValue, newNamespace, isNullable);

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
	 * Save edited values into the model
	 * 
	 * @param selectedElem
	 * @param feature
	 * @param value
	 */
	private void executeCommand(TreeNode selectedNode, EStructuralFeature feature, String value) {
		SetCommand renameComd = new SetCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), selectedNode,
				feature, value);
		if (renameComd.canExecute()) {
			((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack().execute(renameComd);
		}
	}

	/**
	 * Opens the dialog
	 * 
	 * @param selectedElem
	 * 
	 * @param editFieldDialog
	 * @param name
	 *            name
	 * @param prefix
	 *            prefix
	 * @param schemaType
	 *            schemaType
	 * @param isNullable2
	 * @param namespace
	 *            namespace
	 * @param aliases
	 *            aliases
	 * @return map
	 */
	private void openEditFieldDialog(TreeNode selectedNode, String title, String schemaType, String id, String required,
			String schemaValue, String namespaces, boolean isNullable) {

		Shell shell = Display.getDefault().getActiveShell();
		AddNewObjectDialog editTypeDialog = new AddNewObjectDialog(shell, new Class[] { IRegistryFile.class }, selectedEP);

		editTypeDialog.create();
		editTypeDialog.setTypeWhenEditing(schemaType);
		editTypeDialog.setValues(title, schemaType, id, required, schemaValue, namespaces, null, null, null, null,
				isNullable,null,false,false, null);
		editTypeDialog.setTitle(DIALOG_TITLE);
		editTypeDialog.open();

		if (editTypeDialog.getOkValue()) {

			HashMap<String, String> valueMap = new HashMap<String, String>();

			if (StringUtils.isNotEmpty(editTypeDialog.getTitle())) {
				if (StringUtils.isNotEmpty(editTypeDialog.getNamespaces())) {
					String objectNamespace = createNamespaceArray(editTypeDialog.getNamespaces());
					// Adds the prefix to the object
					String prefix = getNamespacePrefix(objectNamespace);
					String newNodeName = PREFIX+prefix + ":" + editTypeDialog.getTitle();
					valueMap.put(JSON_SCHEMA_TITLE, newNodeName);
				} else {
					valueMap.put(JSON_SCHEMA_TITLE, PREFIX+editTypeDialog.getTitle());
				}
			}
			valueMap.put(JSON_SCHEMA_TYPE, editTypeDialog.getSchemaType());
			if (StringUtils.isNotEmpty(editTypeDialog.getID())) {
				valueMap.put(JSON_SCHEMA_ID, editTypeDialog.getID());
			}

			if (StringUtils.isNotEmpty(editTypeDialog.getNamespaces())) {
				String namespacesValue = createNamespaceArray(editTypeDialog.getNamespaces());
				valueMap.put(JSON_SCHEMA_ATTRIBUTE_NAMESPACES, namespacesValue);
			}

			// Sets the attribute ID and type to be used in serialization of the
			// attributes
			valueMap.put(JSON_SCHEMA_ADDED_ATTRIBUTE_ID, editTypeDialog.getID());
			valueMap.put(JSON_SCHEMA_ADDED_ATTRIBUTE_TYPE, editTypeDialog.getSchemaType());

			if (editTypeDialog.getNullable()) {
				valueMap.put(JSON_SCHEMA_NULLABLE, TRUE);
			} else {
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

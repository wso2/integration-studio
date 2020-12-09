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

package org.wso2.developerstudio.datamapper.diagram.custom.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.PropertyKeyValuePair;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNode2EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNode3EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNodeEditPart;

public class NullableAction {

	private static final String JSON_SCHEMA_NULLABLE = "nullable";
	private static final String JSON_SCHEMA_TYPE = "type";
	private static final String JSON_SCHEMA_TITLE = "title";

	public static void executeOperation(EditPart selectedEP, String nullableValue) {

		if (null != selectedEP) {
			// Returns the TreeNodeImpl object respective to selectedEP
			EObject object = ((Node) selectedEP.getModel()).getElement();
			// Used to identify the selected resource of the model
			TreeNode selectedNode = (TreeNode) object;

			HashMap<String, String> valueMap = new HashMap<String, String>();

			for (PropertyKeyValuePair keyValue : selectedNode.getProperties()) {
				String key = keyValue.getKey();
				String value = keyValue.getValue();
				if (key.equals(JSON_SCHEMA_NULLABLE)) {
					valueMap.put(key, nullableValue);
				} else {
					valueMap.put(key, value);
				}
			}
			valueMap.put(JSON_SCHEMA_TITLE, selectedNode.getName());
			reflectChanges(selectedNode, valueMap, selectedEP);
		}
	}

	/**
	 * 
	 * Reflects the changes in the tree view
	 * 
	 * @param selectedElem
	 * @param map
	 * @param selectedEP
	 */
	private static void reflectChanges(TreeNode selectedNode, HashMap<String, String> map, EditPart selectedEP) {

		@SuppressWarnings("rawtypes")
		Iterator entries = map.entrySet().iterator();
		executeRemoveCommand(selectedNode, selectedEP);
		renameTitle(map, selectedEP);

		while (entries.hasNext()) {

			@SuppressWarnings("rawtypes")
			Entry thisEntry = (Entry) entries.next();
			Object key = thisEntry.getKey();
			Object value = thisEntry.getValue();
			if (key.equals(JSON_SCHEMA_TITLE)) {
				executeCommand(selectedNode, DataMapperPackage.Literals.TREE_NODE__NAME, map.get(JSON_SCHEMA_TITLE),
						selectedEP);
			} else {
				PropertyKeyValuePair pair = setPropertyKeyValuePairforTreeNodes(selectedNode, key.toString(),
						value.toString());
				executeAddCommand(selectedNode, pair, selectedEP);
			}
		}
		updateContent(map,selectedEP);
	}

	/**
	 * Save edited values into the model
	 * 
	 * @param selectedNode
	 *            node
	 * @param selectedEP
	 * @param String
	 *            value
	 */
	private static void executeCommand(TreeNode selectedNode, EStructuralFeature feature, String value,
			EditPart selectedEP) {
		SetCommand editComd = new SetCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), selectedNode, feature,
				value);
		if (editComd.canExecute()) {
			((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack().execute(editComd);
		}
	}

	/**
	 * Renames the title
	 * 
	 * @param map
	 * @param selectedEP
	 */
	private static void renameTitle(HashMap<String, String> map, EditPart selectedEP) {
		if (map.get(JSON_SCHEMA_TITLE) != null) {
			if (selectedEP instanceof TreeNodeEditPart) {
				((TreeNodeEditPart) selectedEP).renameElementItem(map.get(JSON_SCHEMA_TITLE),
						map.get(JSON_SCHEMA_TYPE));
			} else if (selectedEP instanceof TreeNode2EditPart) {
				((TreeNode2EditPart) selectedEP).renameElementItem(map.get(JSON_SCHEMA_TITLE),
						map.get(JSON_SCHEMA_TYPE));
			} else if (selectedEP instanceof TreeNode3EditPart) {
				((TreeNode3EditPart) selectedEP).renameElementItem(map.get(JSON_SCHEMA_TITLE),
						map.get(JSON_SCHEMA_TYPE));
			}
		}
	}

	/**
	 * Updates the connector
	 * @param map 
	 * 
	 * @param selectedEP
	 */
	private static void updateContent(HashMap<String, String> map, EditPart selectedEP) {
		if (selectedEP instanceof TreeNodeEditPart) {
			((TreeNodeEditPart) selectedEP).addFixedChildToNodes(selectedEP);
			((TreeNodeEditPart)selectedEP).recreateContent(map.get(JSON_SCHEMA_TITLE),
					map.get(JSON_SCHEMA_TYPE));
		} else if (selectedEP instanceof TreeNode2EditPart) {
			((TreeNode2EditPart) selectedEP).addFixedChildToNodes(selectedEP);
			((TreeNode2EditPart)selectedEP).recreateContent(map.get(JSON_SCHEMA_TITLE),
					map.get(JSON_SCHEMA_TYPE));
		} else if (selectedEP instanceof TreeNode3EditPart) {
			((TreeNode3EditPart) selectedEP).addFixedChildToNodes(selectedEP);
			((TreeNode3EditPart)selectedEP).recreateContent(map.get(JSON_SCHEMA_TITLE),
					map.get(JSON_SCHEMA_TYPE));
		}
	}

	/**
	 * Removes the existing properties
	 * 
	 * @param selectedNode
	 *            tree node
	 * @param selectedEP
	 */
	private static void executeRemoveCommand(TreeNode selectedNode, EditPart selectedEP) {
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
	 * @param selectedEP
	 */
	private static void executeAddCommand(TreeNode selectedNode, PropertyKeyValuePair keyValPair, EditPart selectedEP) {
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
	private static PropertyKeyValuePair setPropertyKeyValuePairforTreeNodes(TreeNode treeNode, String key,
			String value) {
		PropertyKeyValuePair keyValuePair = DataMapperFactory.eINSTANCE.createPropertyKeyValuePair();
		keyValuePair.setKey(key);
		keyValuePair.setValue(value);
		return keyValuePair;
	}
}

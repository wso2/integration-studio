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

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.custom.util.AddNewTypeDialog;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutputEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNode2EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNode3EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNodeEditPart;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryFile;

public class EditRecordAction extends AbstractActionHandler {

	private EditPart selectedEP;
	private static final String OUTPUT_EDITPART = "Output"; //$NON-NLS-1$
	private static final String INPUT_EDITPART = "Input"; //$NON-NLS-1$
	private static final String RENAME_ACTION_ID = "rename-node-action-id"; //$NON-NLS-1$
	private static final String RENAME_FIELD = Messages.EditActions_editNode;

	private static final String NAME = "name";
	private static final String PREFIX = "prefix";
	private static final String DOC = "doc";
	private static final String ALAISES = "aliased";
	private static final String SCHEMATYPE = "schemaType";

	private String name;
	private String schemaType;
	private String aliases;
	private String prefix;
	private String namespace;

	public EditRecordAction(IWorkbenchPart workbenchPart) {
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

			name = selectedNode.getName();
			schemaType = selectedNode.getSchemaDataType().toString();
			if (!selectedNode.getProperties().containsKey("aliases")) {
				aliases = null;
			} else {
				aliases = selectedNode.getProperties().get("aliases").toString().replace("[", "").replace("]", "");
			}
		
			prefix = selectedNode.getProperties().get("namespace");
			namespace = selectedNode.getProperties().get("doc");

			openEditRecordDialog(selectedNode, name, prefix, schemaType, namespace, aliases);

		}
	}

	/**
	 * Reflects the changes in the tree view
	 * 
	 * @param selectedElem
	 * @param map
	 */
	private void reflectChanges(TreeNode selectedNode, HashMap<String, String> map) {
		// Serialize the values
		executeCommand(selectedNode, DataMapperPackage.Literals.TREE_NODE__NAME, map.get(NAME));
		//TODO fix this 2016executeCommand(selectedNode, DataMapperPackage.Literals.TREE_NODE__NAMESPACE, map.get(PREFIX));
		executeCommand(selectedNode, DataMapperPackage.Literals.TREE_NODE__SCHEMA_DATA_TYPE, map.get(SCHEMATYPE));
		//TODO fix this 2016 executeCommand(selectedNode, DataMapperPackage.Literals.TREE_NODE__DOC, map.get(DOC));

		Set<String> aliasesMap = getAliasesValue(map.get(ALAISES));
		// Serialize the aliases
		//TODO fix this 2016
//		SetCommand renameComd = new SetCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), selectedNode,
//				DataMapperPackage.Literals.TREE_NODE__ALIASES, aliasesMap);
//		if (renameComd.canExecute()) {
//			((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack().execute(renameComd);
//
//		}
		if (map.get(NAME) != null && map.get(PREFIX) != null) {
			if (getSelectedEditPart() instanceof TreeNodeEditPart) {
				((TreeNodeEditPart) getSelectedEditPart()).renameElementItem(map.get(PREFIX) + ":" + map.get(NAME));
			} else if (getSelectedEditPart() instanceof TreeNode2EditPart) {
				((TreeNode2EditPart) getSelectedEditPart()).renameElementItem(map.get(PREFIX) + ":" + map.get(NAME));
			} else if (getSelectedEditPart() instanceof TreeNode3EditPart) {
				((TreeNode3EditPart) getSelectedEditPart()).renameElementItem(map.get(PREFIX) + ":" + map.get(NAME));
			}
		} else if (map.get(NAME) != null) {
			if (getSelectedEditPart() instanceof TreeNodeEditPart) {
				((TreeNodeEditPart) getSelectedEditPart()).renameElementItem(map.get(NAME));
			} else if (getSelectedEditPart() instanceof TreeNode2EditPart) {
				((TreeNode2EditPart) getSelectedEditPart()).renameElementItem(map.get(NAME));
			} else if (getSelectedEditPart() instanceof TreeNode3EditPart) {
				((TreeNode3EditPart) getSelectedEditPart()).renameElementItem(map.get(NAME));
			}
		}
	}

	/**
	 * Gets the aliases values as a Set
	 * 
	 * @param aliases
	 *            value map
	 * @return Set
	 */
	private Set<String> getAliasesValue(String aliases) {
		Set<String> aliasesMap = null;
		if (StringUtils.isNotEmpty(aliases)) {
			aliasesMap = new HashSet<String>(Arrays.asList(aliases.split("\\s*,\\s*")));
		}
		return aliasesMap;
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
		SetCommand editComd = new SetCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), selectedNode,
				feature, value);
		if (editComd.canExecute()) {
			((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack().execute(editComd);
		}
	}

	/**
	 * Opens the dialog
	 * 
	 * @param selectedNode
	 * 
	 * @param name
	 *            name
	 * @param prefix
	 *            prefix
	 * @param schemaType
	 *            schemaType
	 * @param namespace
	 *            namespace
	 * @param aliases
	 *            aliases
	 * @return map
	 */
	private void openEditRecordDialog(TreeNode selectedNode, String name, String prefix, String schemaType,
			String namespace, String aliases) {
		String newName = null;
		String newPrefix = null;
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		AddNewTypeDialog editTypeDialog = new AddNewTypeDialog(shell, new Class[] { IRegistryFile.class });
		editTypeDialog.create();
		if (StringUtils.isNotEmpty(name)) {
			if (name.contains(":")) {
				String[] fullName = name.split(":");
				newName = fullName[1];
				newPrefix = fullName[0];
			} else {
				newName = name;
				newPrefix = prefix;
			}
		}

		editTypeDialog.setValues(newName, newPrefix, schemaType, namespace, aliases);
		editTypeDialog.open();

		if (editTypeDialog.getOkValue()) {
			HashMap<String, String> valueMap = new HashMap<String, String>();

			if (StringUtils.isNotEmpty(editTypeDialog.getName())) {
				if (editTypeDialog.getName().contains(":")) {
					String[] fullName = editTypeDialog.getName().split(":");
					valueMap.put(NAME, fullName[1]);
					valueMap.put(PREFIX, fullName[0]);
				} else {
					valueMap.put(NAME, editTypeDialog.getName());
				}
			}

			valueMap.put(PREFIX, editTypeDialog.getNamespace());
			valueMap.put(SCHEMATYPE, editTypeDialog.getSchemaType());
			valueMap.put(DOC, editTypeDialog.getDoc());

			if (editTypeDialog.getAliases() != null) {
				valueMap.put(ALAISES, editTypeDialog.getAliases().toString().replace("[", "").replace("]", ""));
			}
			reflectChanges(selectedNode, valueMap);

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

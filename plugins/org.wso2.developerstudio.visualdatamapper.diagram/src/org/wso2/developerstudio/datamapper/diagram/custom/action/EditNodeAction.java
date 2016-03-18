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
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
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
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.PropertyKeyValuePair;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.custom.util.AddNewObjectDialog;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNode2EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNode3EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNodeEditPart;
import org.wso2.developerstudio.datamapper.impl.PropertyKeyValuePairImpl;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryFile;

public class EditNodeAction extends AbstractActionHandler {

	private EditPart selectedEP;
	private static final String RENAME_ACTION_ID = "rename-node-action-id"; //$NON-NLS-1$
	private static final String RENAME_FIELD = Messages.EditActions_editRootElement;

	private static final String JSON_SCHEMA_REQUIRED = "required";
	private static final String JSON_SCHEMA_SCHEMA_VALUE = "$schema";
	private static final String JSON_SCHEMA_ID = "id";
	private static final String JSON_SCHEMA_TYPE = "type";
	private static final String JSON_SCHEMA_TITLE = "title";
	private String title = null;
	private String schemaType = null;
	private String id = null;
	private String schemaValue = null;
	private String required = null;

	public EditNodeAction(IWorkbenchPart workbenchPart) {
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
			schemaType = selectedNode.getProperties().get(JSON_SCHEMA_TYPE);
			if (selectedNode.getProperties().get(JSON_SCHEMA_ID) != null) {
				id = selectedNode.getProperties().get(JSON_SCHEMA_ID);
			}
			if (selectedNode.getProperties().get(JSON_SCHEMA_REQUIRED) != null) {
				required = selectedNode.getProperties().get(JSON_SCHEMA_REQUIRED).toString();
			}
			if (selectedNode.getProperties().get(JSON_SCHEMA_SCHEMA_VALUE) != null) {
				schemaValue = selectedNode.getProperties().get(JSON_SCHEMA_SCHEMA_VALUE);
			}

			openEditRecordDialog(selectedNode, title, schemaType, id, required, schemaValue);

		}
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
		while (entries.hasNext()) {
		  @SuppressWarnings("rawtypes")
		  Entry thisEntry = (Entry) entries.next();
		  Object key = thisEntry.getKey();
		  Object value = thisEntry.getValue();
		  if(key.equals(JSON_SCHEMA_TITLE)){
				executeCommand(selectedNode, DataMapperPackage.Literals.TREE_NODE__NAME, value.toString());  
		  }else{
			PropertyKeyValuePairImpl pkvPair = (PropertyKeyValuePairImpl)DataMapperFactory.eINSTANCE.create(DataMapperPackage.eINSTANCE.getPropertyKeyValuePair());
		  	pkvPair.setKey("id");
		  	pkvPair.setValue("susinda");
		    executeAddCommand(pkvPair);
		  }
		}
		
		if (map.get(JSON_SCHEMA_TITLE) != null) {
			if (getSelectedEditPart() instanceof TreeNodeEditPart) {
				((TreeNodeEditPart) getSelectedEditPart()).renameElementItem(map.get(JSON_SCHEMA_TITLE));
			} else if (getSelectedEditPart() instanceof TreeNode2EditPart) {
				((TreeNode2EditPart) getSelectedEditPart()).renameElementItem(map.get(JSON_SCHEMA_TITLE));
			} else if (getSelectedEditPart() instanceof TreeNode3EditPart) {
				((TreeNode3EditPart) getSelectedEditPart()).renameElementItem(map.get(JSON_SCHEMA_TITLE));
			}
		} 
	}

	/**
	 * Saves the edited values in the map
	 * @param propertyMap map
	 * @param propertyKeyValuePair value
	 * @param pkvPair value
	 */
	private void executeAddCommand(PropertyKeyValuePairImpl pkvPair) {
		EObject object = ((Node) selectedEP.getModel()).getElement();
		TreeNode selectedNode = (TreeNode) object;
		AddCommand editComd = new AddCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), selectedNode,
				DataMapperPackage.Literals.TREE_NODE__PROPERTIES, pkvPair);
		if (editComd.canExecute()) {
			((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack().execute(editComd);
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
		SetCommand editComd = new SetCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), selectedNode,
				feature, value);
		if (editComd.canExecute()) {
			((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack().execute(editComd);
		}
	}
	
	
	/**
	 * opens the dilaog
	 * @param selectedNode node
	 * @param title title
	 * @param schemaType schematype
	 * @param id id
	 * @param required required
	 * @param schemaValue schema value
	 */
	private void openEditRecordDialog(TreeNode selectedNode, String title, String schemaType, String id,
			String required, String schemaValue) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		AddNewObjectDialog editTypeDialog = new AddNewObjectDialog(shell, new Class[] { IRegistryFile.class });
	
		editTypeDialog.create();
		editTypeDialog.setTypeWhenEditing(schemaType);
		editTypeDialog.setValues(title, schemaType, id, required, schemaValue);
		editTypeDialog.open();

		
		if (editTypeDialog.getOkValue()) {
			HashMap<String, String> valueMap = new HashMap<String, String>();

			if (StringUtils.isNotEmpty(editTypeDialog.getTitle())) {
				valueMap.put(JSON_SCHEMA_TITLE, editTypeDialog.getTitle());
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
	
	final class MyEntry<K, V> implements Map.Entry<K, V> {
	    private final K key;
	    private V value;

	    public MyEntry(K key, V value) {
	        this.key = key;
	        this.value = value;
	    }

	    @Override
	    public K getKey() {
	        return key;
	    }

	    @Override
	    public V getValue() {
	        return value;
	    }

	    @Override
	    public V setValue(V value) {
	        V old = this.value;
	        this.value = value;
	        return old;
	    }
	}

}

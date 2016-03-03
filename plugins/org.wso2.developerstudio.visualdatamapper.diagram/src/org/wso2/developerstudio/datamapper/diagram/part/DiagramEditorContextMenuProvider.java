/*
 * Copyright (c) 2014-2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.datamapper.diagram.part;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.ContributionItemService;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchPart;
import org.wso2.developerstudio.datamapper.diagram.custom.action.AddNewAttributeAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.AddNewFieldAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.AddNewTypeAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.AddNewListAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.AddNewRootRecordAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.ConcatManyAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.EditAttributeAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.ExportSchemaAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.LoadInputSchemaAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.LoadOutputSchemaAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.EditFieldAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.EditRecordAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.SchemaFromJsonAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.SplitManyAction;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.ConcatEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.ElementEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutputEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.SplitEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNode2EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNode3EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNodeEditPart;

/**
 * @generated
 */
public class DiagramEditorContextMenuProvider extends DiagramContextMenuProvider {

	private static final String EDIT_GROUP_ID = "editGroup"; //$NON-NLS-1$
	private static final String NAVIGATE_GROUP_ID = "navigateGroup";
	private static final String PROPERTIES_GROUP_ID = "propertiesGroup";
	private static final String MENU_ADDITIONS = "additions";
	private static final String MENU_PROPERTIES = "properties";
	private static final String ERROR_BUILDING_CONTEXT_MENU = Messages.DiagramEditorContextMenuProvider_errorContextMenu;

	/**
	 * @generated
	 */
	private IWorkbenchPart part;

	/**
	 * @generated
	 */
	private DeleteElementAction deleteAction;
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> contextActions;

	// Actions for adding a new root record
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addNewRootRecordContextActions;
	// Actions for adding a new record
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addNewRecordContextActions;
	// Actions for adding a new records list
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addNewRecordsListContextActions;
	// Actions for adding a new field
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addNewFieldContextActions;
	// Actions for adding a new attribute
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addNewAttributeContextActions;
	// Actions for Editing a new record
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addEditNodedActions;
	// Actions for Editin a new field
	Map<Class<? extends AbstractBorderedShapeEditPart>, AbstractActionHandler> addEditFieldActions;
	// Actions for Editin a new field
	Map<Class<? extends AbstractBorderedShapeEditPart>, AbstractActionHandler> addEditAttributeActions;
	
	// Actions for getting schema from data-set
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> schemaFromDatasetActions;
	// Actions for exporting schema
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> exportSchemaActions;

	/**
	 * @generated NOT
	 */
	public DiagramEditorContextMenuProvider(IWorkbenchPart part, EditPartViewer viewer) {
		super(part, viewer);
		this.part = part;
		deleteAction = new org.wso2.developerstudio.datamapper.diagram.part.DeleteElementAction(
				part);
		deleteAction.init();

		contextActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		contextActions.put(InputEditPart.class, new LoadInputSchemaAction(part));
		contextActions.put(OutputEditPart.class, new LoadOutputSchemaAction(part));
		contextActions.put(ConcatEditPart.class, new ConcatManyAction(part));
		contextActions.put(SplitEditPart.class, new SplitManyAction(part));

		// Initialize new root record context sensitive actions.
		addNewRootRecordContextActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New root record actions are added only to input and output editparts
		addNewRootRecordContextActions.put(InputEditPart.class, new AddNewRootRecordAction(part));
		addNewRootRecordContextActions.put(OutputEditPart.class, new AddNewRootRecordAction(part));

		// Initialize new record context sensitive actions.
		addNewRecordContextActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New record actions are added to treenode editparts
		addNewRecordContextActions.put(TreeNodeEditPart.class, new AddNewTypeAction(part));
		addNewRecordContextActions.put(TreeNode2EditPart.class, new AddNewTypeAction(part));
		addNewRecordContextActions.put(TreeNode3EditPart.class, new AddNewTypeAction(part));

		// Initialize new records list context sensitive actions.
		addNewRecordsListContextActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New records list actions are added to treenode editparts
		addNewRecordsListContextActions.put(TreeNodeEditPart.class, new AddNewListAction(
				part));
		addNewRecordsListContextActions.put(TreeNode2EditPart.class, new AddNewListAction(
				part));
		addNewRecordsListContextActions.put(TreeNode3EditPart.class, new AddNewListAction(
				part));

		// Initialize new field context sensitive actions.
		addNewFieldContextActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New field actions are added to treenode editparts
		addNewFieldContextActions.put(TreeNodeEditPart.class, new AddNewFieldAction(part));
		addNewFieldContextActions.put(TreeNode2EditPart.class, new AddNewFieldAction(part));
		addNewFieldContextActions.put(TreeNode3EditPart.class, new AddNewFieldAction(part));
		
		// Initialize new field context sensitive actions.
		addNewAttributeContextActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New attribute actions are added to treenode editparts
		addNewAttributeContextActions.put(TreeNodeEditPart.class, new AddNewAttributeAction(part));
		addNewAttributeContextActions.put(TreeNode2EditPart.class, new AddNewAttributeAction(part));
		addNewAttributeContextActions.put(TreeNode3EditPart.class, new AddNewAttributeAction(part));

		//Initialize renaming action
		// Initialize new field context sensitive actions.
		addEditNodedActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New field actions are added to treenode editparts
		addEditNodedActions.put(TreeNodeEditPart.class, new EditRecordAction(part));
		addEditNodedActions.put(TreeNode2EditPart.class, new EditRecordAction(part));
		addEditNodedActions.put(TreeNode3EditPart.class, new EditRecordAction(part));
		
		//Initialize renaming field action
		// Initialize new field context sensitive actions.
		addEditFieldActions = new HashMap<Class<? extends AbstractBorderedShapeEditPart>, AbstractActionHandler>();
		// New field actions are added to treenode editparts
		addEditFieldActions.put(ElementEditPart.class, new EditFieldAction(part));
		
		
		//Initialize renaming field action
		// Initialize new field context sensitive actions.
		addEditAttributeActions = new HashMap<Class<? extends AbstractBorderedShapeEditPart>, AbstractActionHandler>();
		// New field actions are added to treenode editparts
		addEditAttributeActions.put(ElementEditPart.class, new EditAttributeAction(part));

		// Initialize schema from dataset actions.
		schemaFromDatasetActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		schemaFromDatasetActions.put(InputEditPart.class, new SchemaFromJsonAction(part));
		schemaFromDatasetActions.put(OutputEditPart.class, new SchemaFromJsonAction(part));

		// Initialize export schema actions.
		exportSchemaActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		exportSchemaActions.put(InputEditPart.class, new ExportSchemaAction(part));
		exportSchemaActions.put(OutputEditPart.class, new ExportSchemaAction(part));
	}

	/**
	 * @generated
	 */
	public void dispose() {
		if (deleteAction != null) {
			deleteAction.dispose();
			deleteAction = null;
		}
		super.dispose();
	}

	/**
	 * @generated NOT
	 */
	public void buildContextMenu(final IMenuManager menu) {
		getViewer().flush();
		try {
			TransactionUtil.getEditingDomain((EObject) getViewer().getContents().getModel())
					.runExclusive(new Runnable() {

						public void run() {
							ContributionItemService.getInstance().contributeToPopupMenu(
									DiagramEditorContextMenuProvider.this, part);
							menu.remove(ActionIds.ACTION_DELETE_FROM_MODEL);

							// Fixing TOOLS-2425
							menu.remove(ActionIds.MENU_NAVIGATE);
							menu.remove(ActionIds.MENU_EDIT);
							menu.remove(ActionIds.MENU_FORMAT);
							menu.remove(ActionIds.MENU_FILTERS);
							menu.remove(ActionIds.MENU_FILE);
							menu.remove(MENU_PROPERTIES);
							menu.remove(MENU_ADDITIONS);

							List<?> selectedEPs = getViewer().getSelectedEditParts();
							if (selectedEPs.size() == 1) {
								EditPart selectedEditorPart = (IGraphicalEditPart) selectedEPs
										.get(0);
								EObject contextObj = ((View) selectedEditorPart.getModel())
										.getElement();

								if (contextObj instanceof EObject) {

									// Append new root item to menu
									AbstractActionHandler addNewRootRecordContextAction = addNewRootRecordContextActions
											.get(selectedEditorPart.getClass());
									if (null != addNewRootRecordContextAction) {
										menu.appendToGroup(EDIT_GROUP_ID,
												addNewRootRecordContextAction);
									}

									// Append new record item to menu
									AbstractActionHandler addNewRecordContextAction = addNewRecordContextActions
											.get(selectedEditorPart.getClass());
									if (null != addNewRecordContextAction) {
										menu.appendToGroup(EDIT_GROUP_ID, addNewRecordContextAction);
									}

									// Append new records list item to menu
									AbstractActionHandler addNewRecordsListContextAction = addNewRecordsListContextActions
											.get(selectedEditorPart.getClass());
									if (null != addNewRecordsListContextAction) {
										menu.appendToGroup(EDIT_GROUP_ID,
												addNewRecordsListContextAction);
									}

									// Append new field item to menu
									AbstractActionHandler addNewFieldContextAction = addNewFieldContextActions
											.get(selectedEditorPart.getClass());
									if (null != addNewFieldContextAction) {
										menu.appendToGroup(EDIT_GROUP_ID, addNewFieldContextAction);
									}
									
									// Append new attribute item to menu
									AbstractActionHandler addNewAttributeContextAction = addNewAttributeContextActions
											.get(selectedEditorPart.getClass());
									if (null != addNewAttributeContextAction) {
										menu.appendToGroup(EDIT_GROUP_ID, addNewAttributeContextAction);
									}
									
									// Append edit node item to menu
									AbstractActionHandler addEditNodedAction = addEditNodedActions
											.get(selectedEditorPart.getClass());
									if (null != addEditNodedAction) {
										menu.appendToGroup(EDIT_GROUP_ID, addEditNodedAction);
									}
									
								
									// Append edit field item to menu
									AbstractActionHandler addEditFieldAction = addEditFieldActions
											.get(selectedEditorPart.getClass());
									if (null != addEditFieldAction) {
										menu.appendToGroup(EDIT_GROUP_ID, addEditFieldAction);
									}
									
									// Append edit attribute item to menu
									AbstractActionHandler addEditAttributeAction = addEditAttributeActions
											.get(selectedEditorPart.getClass());
									if (null != addEditAttributeAction) {
										menu.appendToGroup(EDIT_GROUP_ID, addEditAttributeAction);
									}

									// Append Schema from dataset item to menu
									AbstractActionHandler schemaFromDatasetAction = schemaFromDatasetActions
											.get(selectedEditorPart.getClass());
									if (null != schemaFromDatasetAction) {
										menu.appendToGroup(NAVIGATE_GROUP_ID,
												schemaFromDatasetAction);
									}

									// Append load from file item to menu
									AbstractActionHandler contextAction = contextActions
											.get(selectedEditorPart.getClass());
									if (null != contextAction) {
										menu.appendToGroup(NAVIGATE_GROUP_ID, contextAction);
									}

									// Append export schema item to menu
									AbstractActionHandler exportSchemaAction = exportSchemaActions
											.get(selectedEditorPart.getClass());
									if (null != exportSchemaAction) {
										menu.appendToGroup(NAVIGATE_GROUP_ID, exportSchemaAction);
									}
								}

							}

							menu.prependToGroup(PROPERTIES_GROUP_ID, deleteAction);
						}
					});
		} catch (Exception e) {
			org.wso2.developerstudio.datamapper.diagram.part.DataMapperDiagramEditorPlugin
					.getInstance().logError(ERROR_BUILDING_CONTEXT_MENU, e);
		}
	}
}
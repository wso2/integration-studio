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

import javax.swing.Icon;

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
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManagerOverrides;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.wso2.developerstudio.datamapper.diagram.custom.action.AddNewArrayAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.AddNewAttributeAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.AddNewFieldAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.AddNewObjectAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.AddNewRootAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.ConcatManyAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.EditAttributeAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.EditNodeAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.ExportSchemaAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.LoadInputSchemaAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.LoadOutputSchemaAction;
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

	// Actions for adding a new root element
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addNewRootElementContextActions;
	// Actions for adding a new object
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addNewObjectContextActions;
	// Actions for adding a new array
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addNewArrayContextActions;
	// Actions for adding a new field
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addNewFieldContextActions;
	// Actions for adding a new attribute
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addNewAttributeContextActions;
	// Actions for Editing a object, array or field
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addEditNodeActions;
	// Actions for Editing an attribute
	Map<Class<? extends AbstractBorderedShapeEditPart>, AbstractActionHandler> addEditAttributeActions;
	// Actions for exporting schema
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> exportSchemaActions;

	/**
	 * @generated NOT
	 */
	public DiagramEditorContextMenuProvider(IWorkbenchPart part, EditPartViewer viewer) {
		super(part, viewer);
		this.part = part;
		deleteAction = new org.wso2.developerstudio.datamapper.diagram.part.DeleteElementAction(part);
		deleteAction.init();

		contextActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		contextActions.put(InputEditPart.class, new LoadInputSchemaAction(part));
		contextActions.put(OutputEditPart.class, new LoadOutputSchemaAction(part));
		contextActions.put(ConcatEditPart.class, new ConcatManyAction(part));
		contextActions.put(SplitEditPart.class, new SplitManyAction(part));

		// Initialize new root record context sensitive actions.
		addNewRootElementContextActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New root record actions are added only to input and output editparts
		addNewRootElementContextActions.put(InputEditPart.class, new AddNewRootAction(part));
		addNewRootElementContextActions.put(OutputEditPart.class, new AddNewRootAction(part));

		// Initialize new record context sensitive actions.
		addNewObjectContextActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New record actions are added to treenode editparts
		addNewObjectContextActions.put(TreeNodeEditPart.class, new AddNewObjectAction(part));
		addNewObjectContextActions.put(TreeNode2EditPart.class, new AddNewObjectAction(part));
		addNewObjectContextActions.put(TreeNode3EditPart.class, new AddNewObjectAction(part));

		// Initialize new records list context sensitive actions.
		addNewArrayContextActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New records list actions are added to treenode editparts
		addNewArrayContextActions.put(TreeNodeEditPart.class, new AddNewArrayAction(part));
		addNewArrayContextActions.put(TreeNode2EditPart.class, new AddNewArrayAction(part));
		addNewArrayContextActions.put(TreeNode3EditPart.class, new AddNewArrayAction(part));

		// Initialize new field context sensitive actions.
		addNewFieldContextActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New field actions are added to treenode editparts
		addNewFieldContextActions.put(TreeNodeEditPart.class, new AddNewFieldAction(part));
		addNewFieldContextActions.put(TreeNode2EditPart.class, new AddNewFieldAction(part));
		addNewFieldContextActions.put(TreeNode3EditPart.class, new AddNewFieldAction(part));

		// Initialize new field context sensitive actions.
		addNewFieldContextActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New field actions are added to treenode editparts
		addNewFieldContextActions.put(TreeNodeEditPart.class, new AddNewFieldAction(part));
		addNewFieldContextActions.put(TreeNode2EditPart.class, new AddNewFieldAction(part));
		addNewFieldContextActions.put(TreeNode3EditPart.class, new AddNewFieldAction(part));

		//Initialize renaming action
		// Initialize new field context sensitive actions.
		addNewAttributeContextActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New field actions are added to treenode editparts
		addNewAttributeContextActions.put(TreeNodeEditPart.class, new AddNewAttributeAction(part));
		addNewAttributeContextActions.put(TreeNode2EditPart.class, new AddNewAttributeAction(part));
		addNewAttributeContextActions.put(TreeNode3EditPart.class, new AddNewAttributeAction(part));

		// Initialize renaming action
		// Initialize new field context sensitive actions.
		addEditNodeActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New field actions are added to treenode editparts
		addEditNodeActions.put(TreeNodeEditPart.class, new EditNodeAction(part));
		addEditNodeActions.put(TreeNode2EditPart.class, new EditNodeAction(part));
		addEditNodeActions.put(TreeNode3EditPart.class, new EditNodeAction(part));

		//Initialize renaming field action
		// Initialize new field context sensitive actions.
		addEditAttributeActions = new HashMap<Class<? extends AbstractBorderedShapeEditPart>, AbstractActionHandler>();
		// New field actions are added to treenode editparts
		addEditAttributeActions.put(ElementEditPart.class, new EditAttributeAction(part));

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
			TransactionUtil.getEditingDomain((EObject) getViewer().getContents().getModel()).runExclusive(
					new Runnable() {

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
							menu.remove(ActionIds.ACTION_ADD_NOTELINK);
							menu.remove(ActionIds.ACTION_DELETE_FROM_DIAGRAM);

							List<?> selectedEPs = getViewer().getSelectedEditParts();
							if (selectedEPs.size() == 1) {
								EditPart selectedEditorPart = (IGraphicalEditPart) selectedEPs.get(0);
								EObject contextObj = ((View) selectedEditorPart.getModel()).getElement();

								if (contextObj instanceof EObject) {

									// Append new root item to menu
									AbstractActionHandler addNewRootRecordContextAction = addNewRootElementContextActions
											.get(selectedEditorPart.getClass());
									if (selectedEditorPart.getChildren().isEmpty()) {
										if (null != addNewRootRecordContextAction) {
											//menu.appendToGroup(EDIT_GROUP_ID, addNewRootRecordContextAction);
										}
									}
									
									

									// Append new record item to menu
									AbstractActionHandler addNewRecordContextAction = addNewObjectContextActions
											.get(selectedEditorPart.getClass());
									if (null != addNewRecordContextAction) {
										//menu.appendToGroup(EDIT_GROUP_ID, addNewRecordContextAction);
									}

									// Append new records list item to menu
									AbstractActionHandler addNewRecordsListContextAction = addNewArrayContextActions
											.get(selectedEditorPart.getClass());
									if (null != addNewRecordsListContextAction) {
										//menu.appendToGroup(EDIT_GROUP_ID, addNewRecordsListContextAction);
									}

									// Append new field item to menu
									AbstractActionHandler addNewFieldContextAction = addNewFieldContextActions
											.get(selectedEditorPart.getClass());
									if (null != addNewFieldContextAction) {
										//menu.appendToGroup(EDIT_GROUP_ID, addNewFieldContextAction);
									}

									// Append new field item to menu
									AbstractActionHandler addNewAttributeContextAction = addNewAttributeContextActions
											.get(selectedEditorPart.getClass());
									if (null != addNewAttributeContextAction) {
										//menu.appendToGroup(EDIT_GROUP_ID, addNewAttributeContextAction);
									}

									// Append edit field item to menu
									AbstractActionHandler addEditFieldAction = addEditNodeActions
											.get(selectedEditorPart.getClass());
									if (null != addEditFieldAction) {
										//menu.appendToGroup(EDIT_GROUP_ID, addEditFieldAction);
									}

									// Append edit field item to menu
									AbstractActionHandler addEditAttributeAction = addEditAttributeActions
											.get(selectedEditorPart.getClass());
									if (null != addEditAttributeAction) {
										//menu.appendToGroup(EDIT_GROUP_ID, addEditAttributeAction);
									}

									// Append load from file item to menu
									AbstractActionHandler contextAction = contextActions.get(selectedEditorPart
											.getClass());
									if (null != contextAction) {
										menu.appendToGroup(EDIT_GROUP_ID, contextAction);
									}

									// Append export schema item to menu
									AbstractActionHandler exportSchemaAction = exportSchemaActions
											.get(selectedEditorPart.getClass());
									if (null != exportSchemaAction) {
										menu.appendToGroup(EDIT_GROUP_ID, exportSchemaAction);
									}
								}

							}
							menu.prependToGroup(PROPERTIES_GROUP_ID, deleteAction);
						}
					});
		} catch (Exception e) {
			org.wso2.developerstudio.datamapper.diagram.part.DataMapperDiagramEditorPlugin.getInstance().logError(
					ERROR_BUILDING_CONTEXT_MENU, e);
		}
	}
}
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

package org.wso2.integrationstudio.datamapper.diagram.part;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.ContributionItemService;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchPart;
import org.wso2.integrationstudio.datamapper.PropertyKeyValuePair;
import org.wso2.integrationstudio.datamapper.TreeNode;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.ANDConfigureAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.AddConfigureAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.AddNewArrayAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.AddNewAttributeAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.AddNewFieldAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.AddNewObjectAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.AddNewRootAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.CompareConfigureAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.ConcatManyAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.ConfigureAdvancedCustomFunctionAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.ConfigureCustomFunctionAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.ConstantConfigureAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.DisableNullableAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.EditArrayAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.EditAttributeAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.EditFieldAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.EditObjectAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.EnableNullableAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.EndsWithConfigureAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.ExportSchemaAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.GlobalVariableConfigureAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.IfElseConfigureAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.LoadInputSchemaAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.LoadOutputSchemaAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.MatchConfigureAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.MaxConfigureAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.MinConfigureAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.MultiplyConfigureAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.ORConfigureAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.PropertiesConfigureAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.ReplaceConfigureAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.SetPrecisionConfigureAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.SplitManyAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.StartsWithConfigureAction;
import org.wso2.integrationstudio.datamapper.diagram.custom.action.SubstringConfigureAction;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.ANDEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.AddEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.AdvancedCustomFunctionEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.CompareEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.ConcatEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.ConstantEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.CustomFunctionEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.EndsWithEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.GlobalVariableEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.IfElseEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.MatchEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.MaxEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.MinEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.MultiplyEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OREditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OutNodeEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OutputEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.PropertiesEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.ReplaceEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.SetPrecisionEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.SplitEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.StartsWithEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.SubstringEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNode2EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNode3EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNodeEditPart;

/**
 * @generated
 */
public class DiagramEditorContextMenuProvider extends DiagramContextMenuProvider {

	private static final String EDIT_GROUP_ID = "editGroup"; //$NON-NLS-1$
	private static final String NAVIGATE_GROUP_ID = "navigateGroup";
	private static final String PROPERTIES_GROUP_ID = "propertiesGroup";
	private static final String MENU_ADDITIONS = "additions";
	private static final String MENU_PROPERTIES = "properties";
	private static final String JSON_SCHEMA_TYPE = "type";
	private static final String JSON_SCHEMA_ARRAY = "array";
	private static final String JSON_SCHEMA_OBJECT = "object";
	private static final String JSON_SCHEMA_NULLABLE = "nullable";
	private static final String PREFIX = "@";
	private static final String TRUE = "true";
	private static final String FALSE = "false";
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
	// Actions for Editing a object,
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addEditObjectActions;
	// Actions for Editing an array
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addEditArraytActions;
	// Actions for Editing an field
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addEditFieldActions;
	// Actions for Editing an attribute
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addEditAttributeActions;
	// Actions for adding nullable
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> enableNullableActions;
	// Actions for removing nullable
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> disableNullableActions;
	// Actions for exporting schema
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> exportSchemaActions;

	/**
	 * @generated NOT
	 */
	public DiagramEditorContextMenuProvider(IWorkbenchPart part, EditPartViewer viewer) {
		super(part, viewer);
		this.part = part;
		/*
		 * deleteAction = new org.wso2.integrationstudio.datamapper.diagram.part.DeleteElementAction( part);
		 * deleteAction.init();
		 */

		// deleteAction = new
		// org.wso2.integrationstudio.datamapper.diagram.part.DeleteElementAction(part);

		contextActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		contextActions.put(InputEditPart.class, new LoadInputSchemaAction(part));
		contextActions.put(OutputEditPart.class, new LoadOutputSchemaAction(part));
		contextActions.put(ConcatEditPart.class, new ConcatManyAction(part));
		contextActions.put(SplitEditPart.class, new SplitManyAction(part));
		contextActions.put(ConstantEditPart.class, new ConstantConfigureAction(part));
		contextActions.put(AddEditPart.class, new AddConfigureAction(part));
		contextActions.put(ANDEditPart.class, new ANDConfigureAction(part));
		contextActions.put(OREditPart.class, new ORConfigureAction(part));
		contextActions.put(CompareEditPart.class, new CompareConfigureAction(part));
		contextActions.put(CustomFunctionEditPart.class, new ConfigureCustomFunctionAction(part));
		//contextActions.put(IfElseEditPart.class, new IfElseConfigureAction(part));
		contextActions.put(StartsWithEditPart.class, new StartsWithConfigureAction(part));
		contextActions.put(EndsWithEditPart.class, new EndsWithConfigureAction(part));
		contextActions.put(SubstringEditPart.class, new SubstringConfigureAction(part));
		contextActions.put(MultiplyEditPart.class, new MultiplyConfigureAction(part));
		contextActions.put(SetPrecisionEditPart.class, new SetPrecisionConfigureAction(part));
		contextActions.put(PropertiesEditPart.class, new PropertiesConfigureAction(part));
		contextActions.put(MinEditPart.class, new MinConfigureAction(part));
		contextActions.put(MaxEditPart.class, new MaxConfigureAction(part));
		contextActions.put(MatchEditPart.class, new MatchConfigureAction(part));
		contextActions.put(ReplaceEditPart.class, new ReplaceConfigureAction(part));
		contextActions.put(GlobalVariableEditPart.class, new GlobalVariableConfigureAction(part));
		contextActions.put(AdvancedCustomFunctionEditPart.class, new ConfigureAdvancedCustomFunctionAction(part));

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

		// Initialize renaming action
		// Initialize new field context sensitive actions.
		addNewAttributeContextActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New field actions are added to treenode editparts
		addNewAttributeContextActions.put(TreeNodeEditPart.class, new AddNewAttributeAction(part));
		addNewAttributeContextActions.put(TreeNode2EditPart.class, new AddNewAttributeAction(part));
		addNewAttributeContextActions.put(TreeNode3EditPart.class, new AddNewAttributeAction(part));

		// Initialize renaming action
		// Initialize new field context sensitive actions.
		addEditObjectActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New field actions are added to treenode editparts
		addEditObjectActions.put(TreeNodeEditPart.class, new EditObjectAction(part));
		addEditObjectActions.put(TreeNode2EditPart.class, new EditObjectAction(part));
		addEditObjectActions.put(TreeNode3EditPart.class, new EditObjectAction(part));

		// Initialize renaming action
		// Initialize new field context sensitive actions.
		addEditArraytActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New field actions are added to treenode editparts
		addEditArraytActions.put(TreeNodeEditPart.class, new EditArrayAction(part));
		addEditArraytActions.put(TreeNode2EditPart.class, new EditArrayAction(part));
		addEditArraytActions.put(TreeNode3EditPart.class, new EditArrayAction(part));

		// Initialize renaming action
		// Initialize new field context sensitive actions.
		addEditFieldActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New field actions are added to treenode editparts
		addEditFieldActions.put(TreeNodeEditPart.class, new EditFieldAction(part));
		addEditFieldActions.put(TreeNode2EditPart.class, new EditFieldAction(part));
		addEditFieldActions.put(TreeNode3EditPart.class, new EditFieldAction(part));

		// Initialize renaming action
		// Initialize new field context sensitive actions.
		addEditAttributeActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New field actions are added to treenode editparts
		addEditAttributeActions.put(TreeNodeEditPart.class, new EditAttributeAction(part));
		addEditAttributeActions.put(TreeNode2EditPart.class, new EditAttributeAction(part));
		addEditAttributeActions.put(TreeNode3EditPart.class, new EditAttributeAction(part));

		// Enable Nullable field actions added to tree nodes
		enableNullableActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		enableNullableActions.put(TreeNodeEditPart.class, new EnableNullableAction(part));
		enableNullableActions.put(TreeNode2EditPart.class, new EnableNullableAction(part));
		enableNullableActions.put(TreeNode3EditPart.class, new EnableNullableAction(part));

		// Disable Nullable field actions added to tree nodes
		disableNullableActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		disableNullableActions.put(TreeNodeEditPart.class, new DisableNullableAction(part));
		disableNullableActions.put(TreeNode2EditPart.class, new DisableNullableAction(part));
		disableNullableActions.put(TreeNode3EditPart.class, new DisableNullableAction(part));

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
	/*
	 * public void dispose() { if (deleteAction != null) { deleteAction.dispose(); deleteAction = null; }
	 * super.dispose(); }
	 */

	/**
	 * @generated NOT
	 */
	public void buildContextMenu(final IMenuManager menu) {
		getViewer().flush();
		try {
			TransactionUtil.getEditingDomain((EObject) getViewer().getContents().getModel())
					.runExclusive(new Runnable() {

						public void run() {
							ContributionItemService.getInstance()
									.contributeToPopupMenu(DiagramEditorContextMenuProvider.this, part);

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
							menu.remove(ActionIds.ACTION_SHOW_PROPERTIES_VIEW);
							List<?> selectedEPs = getViewer().getSelectedEditParts();
							if (selectedEPs.size() == 1) {
								EditPart selectedEditorPart = (IGraphicalEditPart) selectedEPs.get(0);
								EObject contextObj = ((View) selectedEditorPart.getModel()).getElement();

								if (selectedEditorPart instanceof InputEditPart
										|| selectedEditorPart instanceof OutputEditPart) {
									// DEVTOOLESB-377- removing delete from model from input and output edit parts
									menu.remove(ActionIds.ACTION_DELETE_FROM_MODEL);
								}

								if (contextObj instanceof EObject) {

									// Append load from file item to menu
									AbstractActionHandler contextAction = contextActions
											.get(selectedEditorPart.getClass());
									if (null != contextAction) {
										menu.appendToGroup(EDIT_GROUP_ID, contextAction);
									}

									// Append export schema item to menu
									AbstractActionHandler exportSchemaAction = exportSchemaActions
											.get(selectedEditorPart.getClass());
									if (!selectedEditorPart.getChildren().isEmpty()) {
										if (null != exportSchemaAction) {
											menu.appendToGroup(EDIT_GROUP_ID, exportSchemaAction);
										}
									}

									// Append new root item to menu
									AbstractActionHandler addNewRootRecordContextAction = addNewRootElementContextActions
											.get(selectedEditorPart.getClass());
									if (selectedEditorPart.getChildren().isEmpty()) {
										if (null != addNewRootRecordContextAction) {
											menu.appendToGroup(EDIT_GROUP_ID, addNewRootRecordContextAction);
										}
									}

									// Append new record item to menu
									AbstractActionHandler addNewRecordContextAction = addNewObjectContextActions
											.get(selectedEditorPart.getClass());
									if (null != addNewRecordContextAction) {
										menu.appendToGroup(EDIT_GROUP_ID, addNewRecordContextAction);
									}

									// Append new records list item to menu
									AbstractActionHandler addNewRecordsListContextAction = addNewArrayContextActions
											.get(selectedEditorPart.getClass());
									if (null != addNewRecordsListContextAction) {
										menu.appendToGroup(EDIT_GROUP_ID, addNewRecordsListContextAction);
									}

									// Append new field item to menu
									AbstractActionHandler addNewFieldContextAction = addNewFieldContextActions
											.get(selectedEditorPart.getClass());
									if (null != addNewFieldContextAction) {
										menu.appendToGroup(EDIT_GROUP_ID, addNewFieldContextAction);
									}

									// Append new field item to menu
									AbstractActionHandler addNewAttributeContextAction = addNewAttributeContextActions
											.get(selectedEditorPart.getClass());
									if (null != addNewAttributeContextAction) {
										menu.appendToGroup(EDIT_GROUP_ID, addNewAttributeContextAction);
									}

									String type = null;
									String name = null;
									if (!selectedEditorPart.getChildren().isEmpty()) {
										if (selectedEditorPart instanceof TreeNodeEditPart
												| selectedEditorPart instanceof TreeNode2EditPart
												| selectedEditorPart instanceof TreeNode3EditPart) {
											for (PropertyKeyValuePair keyValue : (((TreeNode) ((View) selectedEditorPart
													.getModel()).getElement()).getProperties())) {
												if (keyValue.getKey().equals(JSON_SCHEMA_TYPE)) {
													type = keyValue.getValue();
													break;
												}
											}
											name = (((TreeNode) ((View) selectedEditorPart.getModel()).getElement())
													.getName());
										}
									}

									if (type != null) {
										if (type.equals(JSON_SCHEMA_OBJECT)) {
											// Append edit object item to menu
											AbstractActionHandler addEditObjectAction = addEditObjectActions
													.get(selectedEditorPart.getClass());
											if (null != addEditObjectAction) {
												menu.appendToGroup(EDIT_GROUP_ID, addEditObjectAction);
											}
										} else if (type.equals(JSON_SCHEMA_ARRAY)) {
											// Append edit array item to menu
											AbstractActionHandler addEditArrayAction = addEditArraytActions
													.get(selectedEditorPart.getClass());
											if (null != addEditArrayAction) {
												menu.appendToGroup(EDIT_GROUP_ID, addEditArrayAction);
											}
										} else {
											if (StringUtils.isNotEmpty(name) && name.startsWith(PREFIX)) {
												// Append edit attribute item to
												// menu
												AbstractActionHandler addEditAttributeAction = addEditAttributeActions
														.get(selectedEditorPart.getClass());
												if (null != addEditAttributeAction) {
													menu.appendToGroup(EDIT_GROUP_ID, addEditAttributeAction);
												}
											} else {
												AbstractActionHandler addEditFieldAction = addEditFieldActions
														.get(selectedEditorPart.getClass());
												if (null != addEditFieldAction) {
													menu.appendToGroup(EDIT_GROUP_ID, addEditFieldAction);
												}

											}
										}
									}

									if (!selectedEditorPart.getChildren().isEmpty()) {
										if (selectedEditorPart instanceof TreeNodeEditPart
												| selectedEditorPart instanceof TreeNode2EditPart
												| selectedEditorPart instanceof TreeNode3EditPart) {
											for (PropertyKeyValuePair keyValue : (((TreeNode) ((View) selectedEditorPart
													.getModel()).getElement()).getProperties())) {
												if (keyValue.getKey().equals(JSON_SCHEMA_NULLABLE)) {
													if (keyValue.getValue().equals(FALSE)) {
														// Append nullable
														// action to menu
														AbstractActionHandler enableNullableAction = enableNullableActions
																.get(selectedEditorPart.getClass());
														if (null != enableNullableAction) {
															menu.appendToGroup(EDIT_GROUP_ID, enableNullableAction);
														}
													} else if (keyValue.getValue().equals(TRUE)) {
														// Append nullable
														// action to menu
														AbstractActionHandler disableNullableAction = disableNullableActions
																.get(selectedEditorPart.getClass());
														if (null != disableNullableAction) {
															menu.appendToGroup(EDIT_GROUP_ID, disableNullableAction);
														}
													}

												}
											}
											name = (((TreeNode) ((View) selectedEditorPart.getModel()).getElement())
													.getName());
										}
									}

								}

							}
							// menu.appendToGroup(EDIT_GROUP_ID, deleteAction);
						}
					});
		} catch (Exception e) {
			org.wso2.integrationstudio.datamapper.diagram.part.DataMapperDiagramEditorPlugin.getInstance()
					.logError(ERROR_BUILDING_CONTEXT_MENU, e);
		}
	}
}
package dataMapper.diagram.part;

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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchPart;

import dataMapper.Split;
import dataMapper.diagram.custom.action.AddNewFieldAction;
import dataMapper.diagram.custom.action.AddNewRecordAction;
import dataMapper.diagram.custom.action.AddNewRecordsListAction;
import dataMapper.diagram.custom.action.AddNewRootRecordAction;
import dataMapper.diagram.custom.action.ConcatManyAction;
import dataMapper.diagram.custom.action.LoadInputSchemaAction;
import dataMapper.diagram.custom.action.LoadOutputSchemaAction;
import dataMapper.diagram.custom.action.SplitManyAction;
import dataMapper.diagram.edit.parts.ConcatEditPart;
import dataMapper.diagram.edit.parts.InputEditPart;
import dataMapper.diagram.edit.parts.OutputEditPart;
import dataMapper.diagram.edit.parts.SplitEditPart;
import dataMapper.diagram.edit.parts.TreeNode2EditPart;
import dataMapper.diagram.edit.parts.TreeNode3EditPart;
import dataMapper.diagram.edit.parts.TreeNodeEditPart;

/**
 * @generated
 */
public class DiagramEditorContextMenuProvider extends DiagramContextMenuProvider {

	private static final String EDIT_GROUP_ID = "editGroup"; //$NON-NLS-1$
	private static final String ERROR_BUILDING_CONTEXT_MENU = Messages.DiagramEditorContextMenuProvider_errorContextMenu;

	/**
	 * @generated
	 */
	private IWorkbenchPart part;

	/**
	 * @generated
	 */
	private dataMapper.diagram.part.DeleteElementAction deleteAction;
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> contextActions;

	// Actions for adding a new root record
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addNewRootRecordContextActions;
	// Actions for adding a new record
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addNewRecordContextActions;
	// Actions for adding a new records list
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addNewRecordsListContextActions;
	// Actions for adding a new field
	Map<Class<? extends ShapeNodeEditPart>, AbstractActionHandler> addNewFieldContextActions;

	/**
	 * @generated NOT
	 */
	public DiagramEditorContextMenuProvider(IWorkbenchPart part, EditPartViewer viewer) {
		super(part, viewer);
		this.part = part;
		deleteAction = new dataMapper.diagram.part.DeleteElementAction(part);
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
		addNewRecordContextActions.put(TreeNodeEditPart.class, new AddNewRecordAction(part));
		addNewRecordContextActions.put(TreeNode2EditPart.class, new AddNewRecordAction(part));
		addNewRecordContextActions.put(TreeNode3EditPart.class, new AddNewRecordAction(part));

		// Initialize new records list context sensitive actions.
		addNewRecordsListContextActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New records list actions are added to treenode editparts
		addNewRecordsListContextActions.put(TreeNodeEditPart.class, new AddNewRecordsListAction(
				part));
		addNewRecordsListContextActions.put(TreeNode2EditPart.class, new AddNewRecordsListAction(
				part));
		addNewRecordsListContextActions.put(TreeNode3EditPart.class, new AddNewRecordsListAction(
				part));

		// Initialize new field context sensitive actions.
		addNewFieldContextActions = new HashMap<Class<? extends ShapeNodeEditPart>, AbstractActionHandler>();
		// New field actions are added to treenode editparts
		addNewFieldContextActions.put(TreeNodeEditPart.class, new AddNewFieldAction(part));
		addNewFieldContextActions.put(TreeNode2EditPart.class, new AddNewFieldAction(part));
		addNewFieldContextActions.put(TreeNode3EditPart.class, new AddNewFieldAction(part));

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
							menu.appendToGroup(EDIT_GROUP_ID, deleteAction);

							List<?> selectedEPs = getViewer().getSelectedEditParts();
							if (selectedEPs.size() == 1) {
								EditPart selectedEditorPart = (IGraphicalEditPart) selectedEPs
										.get(0);
								EObject contextObj = ((View) selectedEditorPart.getModel())
										.getElement();

								if (contextObj instanceof EObject) {
									AbstractActionHandler contextAction = contextActions
											.get(selectedEditorPart.getClass());
									if (null != contextAction) {
										menu.appendToGroup(EDIT_GROUP_ID, contextAction);
									}

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
								}

							}

						}
					});
		} catch (Exception e) {
			dataMapper.diagram.part.DataMapperDiagramEditorPlugin.getInstance().logError(
					ERROR_BUILDING_CONTEXT_MENU, e);
		}
	}
}
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.part;

import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.internal.actions.ZoomContributionItem;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @generated
 */
public class EsbDiagramActionBarContributor extends DiagramActionBarContributor {

	/**
	 * @generated
	 */
	protected Class getEditorClass() {
		return EsbDiagramEditor.class;
	}

	/**
	 * @generated
	 */
	protected String getEditorId() {
		return EsbDiagramEditor.ID;
	}

	/**
	 * @generated NOT
	 */
	public void init(IActionBars bars, IWorkbenchPage page) {
		super.init(bars, page);
		// registering  global save action
		bars.setGlobalActionHandler(GlobalActionId.SAVE, null);
		// print preview
		IMenuManager fileMenu = bars.getMenuManager().findMenuUsingPath(IWorkbenchActionConstants.M_FILE);
		assert fileMenu != null;
		fileMenu.remove("pageSetupAction"); //$NON-NLS-1$
		// Removing Diagram menu from ESB editor.
		IMenuManager diagramMenu = bars.getMenuManager().findMenuUsingPath(ActionIds.MENU_DIAGRAM);
		assert diagramMenu != null;
		bars.getMenuManager().remove("diagramMenu");

		// Remove Diagram toolbar from ESB editor..
		IToolBarManager toolBarManager = bars.getToolBarManager();
		assert toolBarManager != null;
		IContributionItem[] contributionItem = toolBarManager.getItems();
		for (int i = 0; i < contributionItem.length; ++i) {
			// Not removing "zoom" toolbar item.
			if (!(contributionItem[i] instanceof ZoomContributionItem)) {
				toolBarManager.remove(contributionItem[i]);
			}
		}
	}
}

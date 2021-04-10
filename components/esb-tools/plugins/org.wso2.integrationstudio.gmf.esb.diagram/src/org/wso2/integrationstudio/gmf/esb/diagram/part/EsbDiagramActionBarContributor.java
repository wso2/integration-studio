package org.wso2.integrationstudio.gmf.esb.diagram.part;

import org.eclipse.emf.validation.internal.util.Log;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.ContributionItemService;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.common.ui.util.WorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.internal.actions.ZoomContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.wso2.integrationstudio.gmf.esb.diagram.Activator;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;

/**
 * @generated
 */
public class EsbDiagramActionBarContributor extends MultiPageEditorActionBarContributor {

	private IWorkbenchPartDescriptor descriptor;
	private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

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
		descriptor = new WorkbenchPartDescriptor(getEditorId(), getEditorClass(), getPage());
		try {
			ContributionItemService.getInstance().contributeToActionBars(bars, descriptor);
		} catch (Exception e) {
			log.error("Error while creating diagram action items", e);
		}
		bars.updateActionBars();
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

	@Override
	public void setActivePage(IEditorPart activeEditor) {
		IActionBars actionBars = getActionBars();
		if (actionBars != null) {
			if (activeEditor instanceof ITextEditor) {
				ITextEditor editor = (activeEditor instanceof ITextEditor) ? (ITextEditor) activeEditor : null;
				actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(),
						getTextAction(editor, ITextEditorActionConstants.UNDO));
				actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(),
						getTextAction(editor, ITextEditorActionConstants.REDO));
				actionBars.setGlobalActionHandler(ActionFactory.SELECT_ALL.getId(),
						getTextAction(editor, ITextEditorActionConstants.SELECT_ALL));
				actionBars.setGlobalActionHandler(ActionFactory.CUT.getId(),
						getTextAction(editor, ITextEditorActionConstants.CUT));
				actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(),
						getTextAction(editor, ITextEditorActionConstants.COPY));
				actionBars.setGlobalActionHandler(ActionFactory.PASTE.getId(),
						getTextAction(editor, ITextEditorActionConstants.PASTE));
				actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(),
						getTextAction(editor, ITextEditorActionConstants.DELETE));
				actionBars.updateActionBars();
			}
		}
	}

	private static IAction getTextAction(ITextEditor editor, String actionID) {
		return editor == null ? null : editor.getAction(actionID);
	}

}

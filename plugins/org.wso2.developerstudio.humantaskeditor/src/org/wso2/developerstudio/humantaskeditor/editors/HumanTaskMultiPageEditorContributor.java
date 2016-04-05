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

package org.wso2.developerstudio.humantaskeditor.editors;

import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.IDEActionFactory;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.wso2.developerstudio.humantaskeditor.HumantaskEditorConstants;

/**
 * Manages the installation/deinstallation of global actions for multi-page
 * editors. Responsible for the redirection of global actions to the active
 * editor. Multi-page contributor replaces the contributors for the individual
 * editors in the multi-page editor.
 */
public class HumanTaskMultiPageEditorContributor extends MultiPageEditorActionBarContributor {

    private IEditorPart activeEditorPart;
    private Action htAction;

    /**
     * Creates a multi-page contributor.
     */
    public HumanTaskMultiPageEditorContributor() {
        super();
        createActions();
    }

    /**
     * Returns the action registed with the given text editor.
     *
     * @return IAction or null if editor is null.
     */
    protected IAction getAction(ITextEditor editor, String actionID) {
        return editor == null ? null : editor.getAction(actionID);
    }

    /*
     * (non-JavaDoc) Method declared in
     * AbstractMultiPageEditorActionBarContributor.
     */

    @Override
    public void setActivePage(IEditorPart part) {
        if (activeEditorPart == part) {
            return;
        }

        activeEditorPart = part;

        IActionBars actionBars = getActionBars();
        if (actionBars != null) {

            ITextEditor editor = part instanceof ITextEditor ? (ITextEditor) part : null;

            actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(),
                    getAction(editor, ITextEditorActionConstants.DELETE));
            actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(),
                    getAction(editor, ITextEditorActionConstants.UNDO));
            actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(),
                    getAction(editor, ITextEditorActionConstants.REDO));
            actionBars.setGlobalActionHandler(ActionFactory.CUT.getId(),
                    getAction(editor, ITextEditorActionConstants.CUT));
            actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(),
                    getAction(editor, ITextEditorActionConstants.COPY));
            actionBars.setGlobalActionHandler(ActionFactory.PASTE.getId(),
                    getAction(editor, ITextEditorActionConstants.PASTE));
            actionBars.setGlobalActionHandler(ActionFactory.SELECT_ALL.getId(),
                    getAction(editor, ITextEditorActionConstants.SELECT_ALL));
            actionBars.setGlobalActionHandler(ActionFactory.FIND.getId(),
                    getAction(editor, ITextEditorActionConstants.FIND));
            actionBars.setGlobalActionHandler(IDEActionFactory.BOOKMARK.getId(),
                    getAction(editor, IDEActionFactory.BOOKMARK.getId()));
            actionBars.updateActionBars();
        }
    }

    private void createActions() {
        htAction = new Action() {
            @Override
            public void run() {
                MessageDialog.openInformation(null, HumantaskEditorConstants.HUMANTASKEDITOR_DIALOG_BOX_HEADER,
                        HumantaskEditorConstants.CREATE_HUMAN_TASK_FILE_MESSAGE);
            }
        };
        htAction.setText("Create HumanTask File");
        htAction.setToolTipText("Create HumanTask File");
        htAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
                .getImageDescriptor(IDE.SharedImages.IMG_OBJS_TASK_TSK));
    }

    @Override
    public void contributeToMenu(IMenuManager manager) {
        IMenuManager menu = new MenuManager("Editor &Menu");
        manager.prependToGroup(IWorkbenchActionConstants.MB_ADDITIONS, menu);
        menu.add(htAction);
    }

    @Override
    public void contributeToToolBar(IToolBarManager manager) {
        manager.add(new Separator());
        manager.add(htAction);
    }
}

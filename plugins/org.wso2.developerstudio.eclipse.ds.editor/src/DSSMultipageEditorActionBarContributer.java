/*
 *     Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *     WSO2 Inc. licenses this file to you under the Apache License,
 *     Version 2.0 (the "License"); you may not use this file except
 *     in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing,
 *    software distributed under the License is distributed on an
 *    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *    KIND, either express or implied.  See the License for the
 *    specific language governing permissions and limitations
 *    under the License.
 */
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;

public class DSSMultipageEditorActionBarContributer extends MultiPageEditorActionBarContributor {

	public DSSMultipageEditorActionBarContributer() {
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
				actionBars.updateActionBars();
			}
		}
	}

	private static IAction getTextAction(ITextEditor editor, String actionID) {
		return editor == null ? null : editor.getAction(actionID);
	}

}

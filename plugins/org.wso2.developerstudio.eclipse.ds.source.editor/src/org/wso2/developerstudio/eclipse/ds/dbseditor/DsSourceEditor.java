package org.wso2.developerstudio.eclipse.ds.dbseditor;

import java.util.ResourceBundle;

import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;

public class DsSourceEditor extends TextEditor {

	static final String CONTENT_ASSIST = "ContentAssist"; //$NON-NLS-1$
	ColorManager manager;

	public DsSourceEditor() {
		super();
		manager = new ColorManager();
		setSourceViewerConfiguration(new DsSourceViewerConfiguration(getSharedColors(),
		                                                             getPreferenceStore(), this));
		setDocumentProvider(new DsDocumentProvider());
	}

	protected void createActions() {
		super.createActions();
		ResourceBundle bundle = DsEditorMessages.getBundle();
		ContentAssistAction action = new ContentAssistAction(bundle, "contentAssist.", this); //$NON-NLS-1$
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
		setAction(CONTENT_ASSIST, action);
	}

}
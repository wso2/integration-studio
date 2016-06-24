package org.wso2.developerstudio.esb.form.editors.article.rcp;

import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;

public abstract class AbstractEsbFormPage extends FormPage {

	protected EsbNode esbNode;
	
	
	
	public AbstractEsbFormPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
	}

	public EsbNode getEsbNode() {
		return esbNode;
	}

	public void setEsbNode(EsbNode esbNode) {
		this.esbNode = esbNode;
	}

}

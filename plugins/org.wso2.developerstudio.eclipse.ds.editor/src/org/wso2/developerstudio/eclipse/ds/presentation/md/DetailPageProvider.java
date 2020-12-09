package org.wso2.developerstudio.eclipse.ds.presentation.md;

import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IDetailsPageProvider;
import org.wso2.developerstudio.eclipse.ds.presentation.DsEditor;

public class DetailPageProvider implements IDetailsPageProvider {

	protected DsEditor editor;

	public DetailPageProvider(DsEditor editor) {

		this.editor = editor;
	}

	public Object getPageKey(Object object) {

		return object;
	}

	public IDetailsPage getPage(Object key) {

		return new ObjectDetailPage(key, editor);
	}

}

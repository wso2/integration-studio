package org.wso2.developerstudio.eclipse.ds.presentation.md;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.wso2.developerstudio.eclipse.ds.presentation.DsEditor;

/**
 * Master Detail page for the DsEditor form editor
 * this take care of the all tree /property related actions.
 * 
 */

public class MasterDetailsPage extends FormPage {

	private OutlineBlock outLineBlock;

	public MasterDetailsPage(DsEditor editor, ComposedAdapterFactory adapterFactory,
	                         EditingDomain domain) {
		super(editor, "md", "OutlinePage");
		outLineBlock = new OutlineBlock(editor, adapterFactory, domain);
	}

	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		form.setText("Data Service Description");
		outLineBlock.createContent(managedForm);
	}

	public OutlineBlock getOutLineBlock() {
		return outLineBlock;
	}

}

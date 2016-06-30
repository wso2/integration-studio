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


package org.wso2.developerstudio.esb.form.editors.article.rcp;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.*;
import org.eclipse.ui.forms.editor.*;
import org.eclipse.ui.forms.events.*;
import org.eclipse.ui.forms.widgets.*;
import org.wso2.developerstudio.esb.forgm.editors.article.FormArticlePlugin;
/**
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class SecondPage extends FormPage {
	/**
	 * @param id
	 * @param title
	 */
	public SecondPage(FormEditor editor) {
		super(editor, "second", Messages.getString("SecondPage.label")); //$NON-NLS-1$ //$NON-NLS-2$
	}
	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();
		form.setText(Messages.getString("SecondPage.title")); //$NON-NLS-1$
		form.setBackgroundImage(FormArticlePlugin.getDefault().getImage(FormArticlePlugin.IMG_FORM_BG));
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		form.getBody().setLayout(layout);
		createTableSection(form, toolkit, Messages.getString("SecondPage.firstSection")); //$NON-NLS-1$
		createTableSection(form, toolkit, Messages.getString("SecondPage.secondSection"));		 //$NON-NLS-1$
	}
	
	private void createTableSection(final ScrolledForm form, FormToolkit toolkit, String title) {
		Section section =
			toolkit.createSection(
				form.getBody(),
				Section.TWISTIE | Section.DESCRIPTION);
		section.setActiveToggleColor(
			toolkit.getHyperlinkGroup().getActiveForeground());
		section.setToggleColor(
			toolkit.getColors().getColor(FormColors.SEPARATOR));
		toolkit.createCompositeSeparator(section);
		Composite client = toolkit.createComposite(section, SWT.WRAP);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;

		client.setLayout(layout);
		Table t = toolkit.createTable(client, SWT.NULL);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 200;
		gd.widthHint = 100;
		t.setLayoutData(gd);
		toolkit.paintBordersFor(client);
		Button b = toolkit.createButton(client, Messages.getString("SecondPage.add"), SWT.PUSH); //$NON-NLS-1$
		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		b.setLayoutData(gd);
		section.setText(title);
		section.setDescription(Messages.getString("SecondPage.desc")); //$NON-NLS-1$
		section.setClient(client);
		section.setExpanded(true);
		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		gd = new GridData(GridData.FILL_BOTH);
		section.setLayoutData(gd);
	}
}

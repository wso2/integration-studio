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
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.*;
import org.eclipse.ui.forms.events.*;
import org.eclipse.ui.forms.widgets.*;
/**
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class ThirdPage extends FormPage {
	/**
	 * @param id
	 * @param title
	 */
	public ThirdPage(FormEditor editor) {
		super(editor, "third", Messages.getString("ThirdPage.label")); //$NON-NLS-1$ //$NON-NLS-2$
	}
	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		//FormToolkit toolkit = managedForm.getToolkit();
		form.setText(Messages.getString("ThirdPage.title")); //$NON-NLS-1$
		ColumnLayout layout = new ColumnLayout();
		layout.topMargin = 0;
		layout.bottomMargin = 5;
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		layout.horizontalSpacing = 10;
		layout.verticalSpacing = 10;
		layout.maxNumColumns = 4;
		layout.minNumColumns = 1;
		form.getBody().setLayout(layout);
		//form.getBody().setBackground(
		//		form.getBody().getDisplay().getSystemColor(SWT.COLOR_GREEN));
		createSectionWithLinks(managedForm, Messages.getString("ThirdPage.ls1.name"), //$NON-NLS-1$
				Messages.getString("ThirdPage.ls1.desc"), 2); //$NON-NLS-1$
		createSectionWithLinks(managedForm, Messages.getString("ThirdPage.ls2.name"), //$NON-NLS-1$
				Messages.getString("ThirdPage.ls2.desc"), 2); //$NON-NLS-1$
		createMixedSection(managedForm, Messages.getString("ThirdPage.ms1.name"), //$NON-NLS-1$
				Messages.getString("ThirdPage.ms1.desc")); //$NON-NLS-1$
		createSectionWithLinks(managedForm, Messages.getString("ThirdPage.ls3.name"), //$NON-NLS-1$
				Messages.getString("ThirdPage.ls3.desc"), 4); //$NON-NLS-1$
		createSectionWithControls(managedForm, Messages.getString("ThirdPage.cs1.name"), //$NON-NLS-1$
				Messages.getString("ThirdPage.cs1.desc")); //$NON-NLS-1$
		createSectionWithLinks(managedForm, Messages.getString("ThirdPage.ls4.name"), //$NON-NLS-1$
				Messages.getString("ThirdPage.ls4.desc"), 3); //$NON-NLS-1$
		createSectionWithLinks(managedForm, Messages.getString("ThirdPage.ls5.name"), //$NON-NLS-1$
				Messages.getString("ThirdPage.ls5.desc"), 5); //$NON-NLS-1$
		createMixedSection(managedForm, Messages.getString("ThirdPage.ms2.name"), //$NON-NLS-1$
				Messages.getString("ThirdPage.ms2.desc")); //$NON-NLS-1$
		createSectionWithLinks(managedForm, Messages.getString("ThirdPage.l6.name"), //$NON-NLS-1$
				Messages.getString("ThirdPage.l6.desc"), 2); //$NON-NLS-1$
		createSectionWithControls(managedForm, Messages.getString("ThirdPage.cs2.name"), //$NON-NLS-1$
				Messages.getString("ThirdPage.cs2.desc")); //$NON-NLS-1$
		createSectionWithLinks(managedForm, Messages.getString("ThirdPage.l7.name"), //$NON-NLS-1$
				Messages.getString("ThirdPage.l7.desc"), 4); //$NON-NLS-1$
		createSectionWithLinks(managedForm, Messages.getString("ThirdPage.l8.name"), //$NON-NLS-1$
				Messages.getString("ThirdPage.l8.desc"), 2); //$NON-NLS-1$
		createMixedSection(managedForm, Messages.getString("ThirdPage.m3.name"), //$NON-NLS-1$
				Messages.getString("ThirdPage.m3.desc")); //$NON-NLS-1$
		createSectionWithLinks(managedForm, Messages.getString("ThirdPage.l9.name"), //$NON-NLS-1$
				Messages.getString("ThirdPage.l9.desc"), 2); //$NON-NLS-1$
		createSectionWithControls(managedForm, Messages.getString("ThirdPage.c3.name"), //$NON-NLS-1$
				Messages.getString("ThirdPage.c3.desc")); //$NON-NLS-1$
	}
	private void createSectionWithLinks(IManagedForm mform, String title,
			String desc, int nlinks) {
		Composite client = createSection(mform, title, desc, 1);
		FormToolkit toolkit = mform.getToolkit();
		for (int i = 1; i <= nlinks; i++)
			toolkit.createHyperlink(client, Messages.getString("ThirdPage.link") + i, SWT.WRAP); //$NON-NLS-1$
	}
	private void createSectionWithControls(IManagedForm mform, String title,
			String desc) {
		Composite client = createSection(mform, title, desc, 1);
		FormToolkit toolkit = mform.getToolkit();
		toolkit.createButton(client, Messages.getString("ThirdPage.button1"), SWT.RADIO); //$NON-NLS-1$
		toolkit.createButton(client, Messages.getString("ThirdPage.button2"), SWT.RADIO); //$NON-NLS-1$
		toolkit.createButton(client, Messages.getString("ThirdPage.button3"), //$NON-NLS-1$
				SWT.RADIO);
		toolkit.createButton(client, Messages.getString("ThirdPage.checkbox"), SWT.CHECK); //$NON-NLS-1$
	}
	private void createMixedSection(IManagedForm mform, String title, String desc) {
		Composite client = createSection(mform, title, desc, 2);
		FormToolkit toolkit = mform.getToolkit();
		Hyperlink link = toolkit.createHyperlink(client,
				Messages.getString("ThirdPage.longlink"), SWT.WRAP); //$NON-NLS-1$
		GridData gd = new GridData();
		gd.horizontalSpan = 2;
		link.setLayoutData(gd);
		link = toolkit.createHyperlink(client, Messages.getString("ThirdPage.link2"), //$NON-NLS-1$
				SWT.WRAP);
		gd = new GridData();
		gd.horizontalSpan = 2;
		link.setLayoutData(gd);
		toolkit.createLabel(client, Messages.getString("ThirdPage.textLabel")); //$NON-NLS-1$
		Text text = toolkit.createText(client, "", SWT.SINGLE); //$NON-NLS-1$
		gd = new GridData();
		gd.widthHint = 150;
		text.setLayoutData(gd);
		//toolkit.paintBordersFor(client);
	}
	private Composite createSection(IManagedForm mform, String title,
			String desc, int numColumns) {
		final ScrolledForm form = mform.getForm();
		FormToolkit toolkit = mform.getToolkit();
		Section section = toolkit.createSection(form.getBody(), Section.TWISTIE
				| Section.TITLE_BAR | Section.DESCRIPTION | Section.EXPANDED);
		section.setText(title);
		section.setDescription(desc);
		//toolkit.createCompositeSeparator(section);
		Composite client = toolkit.createComposite(section);
		GridLayout layout = new GridLayout();
		layout.marginWidth = layout.marginHeight = 0;
		layout.numColumns = numColumns;
		client.setLayout(layout);
		section.setClient(client);
		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		return client;
	}
}
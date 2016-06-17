/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
import java.io.*;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
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
public class LocalEntryFormPage extends FormPage {
	/**
	 * @param id
	 * @param title
	 */
	public LocalEntryFormPage(FormEditor editor) {
		super(editor, "first", Messages.getString("FreeFormPage.label")); //$NON-NLS-1$ //$NON-NLS-2$
	}
	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();
		form.setText(Messages.getString("FreeFormPage.sectionTitle1")); //$NON-NLS-1$
		form.setBackgroundImage(FormArticlePlugin.getDefault().getImage(FormArticlePlugin.IMG_FORM_BG));
		TableWrapLayout layout = new TableWrapLayout();
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		form.getBody().setLayout(layout);
		TableWrapData td;
		td = new TableWrapData();
		td.align = TableWrapData.LEFT;
		createFormTextSection(form, toolkit);
	}
	
	private void createFormTextSection(final ScrolledForm form, FormToolkit toolkit) {
		Section section =
			toolkit.createSection(
				form.getBody(),
				Section.TWISTIE | Section.DESCRIPTION);
		section.setActiveToggleColor(
			toolkit.getHyperlinkGroup().getActiveForeground());
		section.setToggleColor(
			toolkit.getColors().getColor(FormColors.SEPARATOR));
		toolkit.createCompositeSeparator(section);
		FormText rtext = toolkit.createFormText(section, false);
		section.setClient(rtext);
		loadFormText(rtext, toolkit);

		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		section.setExpanded(true);

		section.setText(Messages.getString("FreeFormPage.sectionTitle2")); //$NON-NLS-1$
		
		GridData data = new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1);
	    
		TableWrapData td = new TableWrapData();
		  td.colspan = 2;
		  td = new TableWrapData(TableWrapData.FILL_GRAB);
		  TableWrapData td1 = new TableWrapData();
		  td1.colspan = 2;
		  td1 = new TableWrapData(TableWrapData.FILL_GRAB);
		  TableWrapData td3 = new TableWrapData();
		  td3.colspan = 2;
		  td3 = new TableWrapData(TableWrapData.FILL_GRAB);
		 
		  Label label = toolkit.createLabel(form.getBody(), "Local Entry Name :");
		  Text text = toolkit.createText(form.getBody(), "");
		  text.setBackground(new Color(null, 229,236,253));
		  text.setLayoutData(td);
		  
		 
		 Label label1 = toolkit.createLabel(form.getBody(), "Local Entry Type :");
		 
		 Combo localEntryTypeCombo = new Combo(form.getBody(), SWT.DROP_DOWN);
		 localEntryTypeCombo.setLayoutData(td1);
		 localEntryTypeCombo.setBackground(new Color(null, 229,236,253));
		 String[] items = {"text value", "xml value", "source URL value"};
		 localEntryTypeCombo.setItems(items);
		  
		    Label label2 = toolkit.createLabel(form.getBody(), "Local Entry Value :");
		  Text text2 = toolkit.createText(form.getBody(), "");
		  text2.setBackground(new Color(null, 229,236,253));
		  text2.setLayoutData(td3);
		 
		section.setLayoutData(td);
	}

	private void loadFormText(final FormText rtext, FormToolkit toolkit) {
		rtext.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {
				MessageDialog.openInformation(rtext.getShell(), Messages.getString("FreeFormPage.mtitle"),  //$NON-NLS-1$
				Messages.getString("FreeFormPage.mtext") + e.getHref()); //$NON-NLS-1$
			}
		});
		rtext.setHyperlinkSettings(toolkit.getHyperlinkGroup());
		rtext.setImage("image1", FormArticlePlugin.getDefault().getImage(FormArticlePlugin.IMG_LARGE)); //$NON-NLS-1$
		InputStream is = LocalEntryFormPage.class.getResourceAsStream("index.xml"); //$NON-NLS-1$
		if (is!=null) {
			rtext.setContents(is, true);
			try {
				is.close();
			}
			catch (IOException e) {
			}
		}
	}
}
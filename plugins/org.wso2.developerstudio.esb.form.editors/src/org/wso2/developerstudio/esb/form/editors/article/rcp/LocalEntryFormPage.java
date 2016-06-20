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


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Color;
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
	
	private String localEntryName;
	private String localEntryValue;
	private String localEntryType;
	
	/**
	 * @param id
	 * @param title
	 */
	
	private Section selectedSection;
	
	public LocalEntryFormPage(FormEditor editor) {
		super(editor, "localEntryForm", Messages.getString("LocalEntryFormPage.label"));
	}

	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();
		form.setText(Messages.getString("Page.heading")); //$NON-NLS-1$
		form.setBackgroundImage(FormArticlePlugin.getDefault().getImage(FormArticlePlugin.IMG_FORM_BG));
		
		ColumnLayout layout = new ColumnLayout();
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		layout.maxNumColumns = 2;
		form.getBody().setLayout(layout);		
		
		createFormBasicSection(form, toolkit);
	}
	
	private void createFormBasicSection(final ScrolledForm form, FormToolkit toolkit) {
		Section section = createSection(form, toolkit, Messages.getString("LocalEntryFormPage.section.basic"));
		
		
		Composite basicSectionClient = toolkit.createComposite(section);
		basicSectionClient.setLayout(new TableWrapLayout());
		
		toolkit.createLabel(basicSectionClient, "Local Entry Name");
		Text localEntryName = toolkit.createText(basicSectionClient, getLocalEntryName());
		localEntryName.setBackground(new Color(null, 229,236,253));
		localEntryName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		  
		 
		toolkit.createLabel(basicSectionClient, "Local Entry Type");
		Combo localEntryType = new Combo(basicSectionClient, SWT.DROP_DOWN);
		localEntryType.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] items = {"In-lined Text Entry", "In-lined XML Entry", "Source URL Entry"};
		localEntryType.setItems(items);
		localEntryType.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				// clear previous selected section
				if (selectedSection != null){
					selectedSection.dispose();
					selectedSection=null;
				}

				if (localEntryType.getText().equals("In-lined Text Entry")) {
					createInlinedTextEntry(form,toolkit);					
				} else if (localEntryType.getText().equals("In-lined XML Entry")) {
					createInlinedXmlEntry(form,toolkit);
				} else if (localEntryType.getText().equals("Source URL Entry")) {
					createSourceUrlEntry(form,toolkit);
				}
			}
		});
		  
	 	section.setClient(basicSectionClient);
	}

	private void createInlinedTextEntry(final ScrolledForm form, FormToolkit toolkit) {
		Section section = createSection(form, toolkit, Messages.getString("LocalEntryFormPage.section.textEntry"));
		
		Composite client = toolkit.createComposite(section);
		client.setLayout(new TableWrapLayout());
		
		toolkit.createLabel(client, "Value Literal");
		Text localEntryTextValue = toolkit.createText(client, getLocalEntryValue());
		localEntryTextValue.setBackground(new Color(null, 229,236,253));
		localEntryTextValue.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		section.setClient(client);
		
		selectedSection = section;
	}
	
	private void createInlinedXmlEntry(final ScrolledForm form, FormToolkit toolkit) {
		Section section = createSection(form, toolkit, Messages.getString("LocalEntryFormPage.section.xmlEntry"));
		
		Composite client = toolkit.createComposite(section);
		client.setLayout(new TableWrapLayout());

		toolkit.createLabel(client, "Value XML");
		Text localEntryXmlValue = toolkit.createText(client, "");
		localEntryXmlValue.setBackground(new Color(null, 229,236,253));
		localEntryXmlValue.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		section.setClient(client);
		
		selectedSection = section;
	}
	
	private void createSourceUrlEntry(final ScrolledForm form, FormToolkit toolkit) {
		Section section = createSection(form, toolkit, Messages.getString("LocalEntryFormPage.section.urlEntry"));

		Composite client = toolkit.createComposite(section);
		client.setLayout(new TableWrapLayout());
		
		toolkit.createLabel(client, "Value URL");
		Text localEntryUrlValue = toolkit.createText(client, "");
		localEntryUrlValue.setBackground(new Color(null, 229,236,253));
		localEntryUrlValue.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		section.setClient(client);
		
		selectedSection = section;
	}
	
	private Section createSection(final ScrolledForm form, FormToolkit toolkit, final String heading) {
		
		Section section = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.EXPANDED);
		section.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		section.setToggleColor(toolkit.getColors().getColor(FormColors.SEPARATOR));
		toolkit.createCompositeSeparator(section);
		
		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		section.setText(heading);
		
		return section;
	}
	
	public synchronized String getLocalEntryName() {
		return localEntryName;
	}

	public synchronized void setLocalEntryName(String localEntryName) {
		this.localEntryName = localEntryName;
	}

	public synchronized String getLocalEntryValue() {
		return localEntryValue;
	}

	public synchronized void setLocalEntryValue(String localEntryValue) {
		this.localEntryValue = localEntryValue;
	}

	public synchronized String getLocalEntryType() {
		return localEntryType;
	}

	public synchronized void setLocalEntryType(String localEntryType) {
		this.localEntryType = localEntryType;
	}
	
}
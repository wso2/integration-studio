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

package org.wso2.integrationstudio.esb.form.editors.article.rcp;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.wso2.integrationstudio.esb.forgm.editors.article.FormArticlePlugin;

/**
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class LocalEntryFormPage extends AbstractEsbFormPage {
	
	public static final String SOURCE_URL_ENTRY = "Source URL Entry";
	public static final String IN_LINED_XML_ENTRY = "In-lined XML Entry";
	public static final String IN_LINED_TEXT_ENTRY = "In-lined Text Entry";
	private Text localEntryNameTxt;
	private Combo localEntryTypeCombo;
	private Text localEntryTextValue;
	private Label localEntryValueLbl;
	
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
		localEntryNameTxt = toolkit.createText(basicSectionClient, "");
		localEntryNameTxt.setBackground(new Color(null, 229,236,253));
		localEntryNameTxt.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		localEntryNameTxt.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});
		  
		 
		toolkit.createLabel(basicSectionClient, "Local Entry Type");
		localEntryTypeCombo = new Combo(basicSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		localEntryTypeCombo.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] items = {IN_LINED_TEXT_ENTRY, IN_LINED_XML_ENTRY, SOURCE_URL_ENTRY};
		localEntryTypeCombo.setItems(items);
		
		localEntryTypeCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				// clear previous selected section
				if (selectedSection != null){
					selectedSection.dispose();
					selectedSection=null;
				}

				if (localEntryTypeCombo.getText().equals(IN_LINED_TEXT_ENTRY)) {
					createInlinedTextEntry(localEntryValueLbl,localEntryTextValue);
				} else if (localEntryTypeCombo.getText().equals(IN_LINED_XML_ENTRY)) {
					createInlinedXmlEntry(localEntryValueLbl,localEntryTextValue);
				} else if (localEntryTypeCombo.getText().equals(SOURCE_URL_ENTRY)) {
					createSourceUrlEntry(localEntryValueLbl,localEntryTextValue);
				}
				setSave(true);
				updateDirtyState();
			}
		});
		
		localEntryTypeCombo.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});
		
		localEntryValueLbl = toolkit.createLabel(basicSectionClient, IN_LINED_TEXT_ENTRY);
		localEntryTextValue = toolkit.createText(basicSectionClient, "", SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.WRAP);
		localEntryTextValue.setBackground(new Color(null, 229,236,253));
        TableWrapData tableWrapData = new TableWrapData(TableWrapData.FILL_GRAB);
        tableWrapData.maxHeight = 300;
        tableWrapData.heightHint = 300;
		localEntryTextValue.setLayoutData(tableWrapData);
		localEntryTextValue.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});
	  
	 	section.setClient(basicSectionClient);
	}
	
	@Override
	public boolean isDirty() {
		return super.isDirty();
	}

	private void createInlinedTextEntry(final Label label, Text textBox) {
		
		label.setText(IN_LINED_TEXT_ENTRY);
		textBox.setText("");
	}
	
	private void createInlinedXmlEntry(final Label label, Text textBox) {
		
		label.setText(IN_LINED_XML_ENTRY);
		textBox.setText("<value/>");
	}
	
	private void createSourceUrlEntry(final Label label, Text textBox) {
		
		label.setText(SOURCE_URL_ENTRY);
		textBox.setText("file:/path/to/sample");
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
	
	public Text getLocalEntryNameTxt() {
		return localEntryNameTxt;
	}

	public void setLocalEntryNameTxt(Text localEntryNameTxt) {
		this.localEntryNameTxt = localEntryNameTxt;
	}
	
	public Combo getLocalEntryTypeCombo() {
		return localEntryTypeCombo;
	}

	public void setLocalEntryTypeCombo(Combo localEntryTypeCombo) {
		this.localEntryTypeCombo = localEntryTypeCombo;
	}

	public Text getLocalEntryTextValue() {
		return localEntryTextValue;
	}

	public void setLocalEntryTextValue(Text localEntryTextValue) {
		this.localEntryTextValue = localEntryTextValue;
	}

	public Section getSelectedSection() {
		return selectedSection;
	}

	public void setSelectedSection(Section selectedSection) {
		this.selectedSection = selectedSection;
	}
	
    public void setLocalEntryValueLabel(String type) {
        switch (type) {
        case "xml":
            this.localEntryValueLbl.setText(IN_LINED_XML_ENTRY);
            break;
        case "text":
            this.localEntryValueLbl.setText(IN_LINED_TEXT_ENTRY);
            break;
        case "uri":
            this.localEntryValueLbl.setText(SOURCE_URL_ENTRY);
            break;
        }
    }
	
}
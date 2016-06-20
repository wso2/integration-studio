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
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.RealEndpointUtils;

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
	public LocalEntryFormPage(FormEditor editor) {
		super(editor, "first", Messages.getString("FreeFormPage.label")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();
		form.setText(Messages.getString("Page.heading")); //$NON-NLS-1$
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
		
		/* Error handling */
		Section errorHandlingSection = createSection(form, toolkit, Messages.getString("Page.heading"));
		
		Composite localEntrySectionClient = toolkit.createComposite(errorHandlingSection);
		localEntrySectionClient.setLayout(new TableWrapLayout());
		
		
		toolkit.createLabel(form.getBody(), "Local Entry Name : ");
		Text endpointSuspendErrorCodes = toolkit.createText(form.getBody(), getLocalEntryName());
		endpointSuspendErrorCodes.setBackground(new Color(null, 229,236,253));
		endpointSuspendErrorCodes.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(form.getBody(), "Local Entry Type :");
		Combo localEntryTypeCombo = new Combo(form.getBody(), SWT.DROP_DOWN);
		localEntryTypeCombo.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		localEntryTypeCombo.setBackground(new Color(null, 229, 236, 253));
		String[] items = { "text value", "xml value", "source URL value" };
		localEntryTypeCombo.setItems(items);
		localEntryTypeCombo.select(0);
		
		
		toolkit.createLabel(form.getBody(), "Local Entry Value : ");
		Text endpointSuspendInitialDuration = toolkit.createText(form.getBody(), getLocalEntryValue());
		endpointSuspendInitialDuration.setBackground(new Color(null, 229,236,253));
		endpointSuspendInitialDuration.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		errorHandlingSection.setClient(localEntrySectionClient);
	}
	
	public static void addSeparator(final ScrolledForm form, FormToolkit toolkit, Composite client) {
		Label padBefore = toolkit.createLabel(client, null);
		TableWrapData padData = new TableWrapData();
		padData.maxWidth = 0;
		padBefore.setLayoutData(padData);
		Label separator = new Label(client, SWT.SEPARATOR + SWT.HORIZONTAL);
		TableWrapData separatorData = new TableWrapData();
		separatorData.align = TableWrapData.FILL;
		separatorData.grabHorizontal = true;
		separatorData.maxHeight = 1;
		separatorData.valign = TableWrapData.MIDDLE;
		separator.setLayoutData(separatorData);
		Label padAfter = toolkit.createLabel(client, null);
		padAfter.setLayoutData(padData);
	}
	
     public static Section createSection(final ScrolledForm form, FormToolkit toolkit, final String heading) {
		
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
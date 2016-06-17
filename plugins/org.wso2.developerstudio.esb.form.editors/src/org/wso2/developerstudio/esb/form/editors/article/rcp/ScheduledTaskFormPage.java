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
public class ScheduledTaskFormPage extends FormPage {
	/**
	 * @param id
	 * @param title
	 */
	public ScheduledTaskFormPage(FormEditor editor) {
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
//		loadFormText(rtext, toolkit);

		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		section.setExpanded(true);

		section.setText(Messages.getString("FreeFormPage.sectionTitle2")); //$NON-NLS-1$
		
	    
		TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB);
		section.setLayoutData(td);	
		
		TableWrapData td1 = new TableWrapData(TableWrapData.FILL_GRAB);
		/* Basic Section */
		Label labelTaskName = toolkit.createLabel(form.getBody(), "Task Name :");
		Text taskName = toolkit.createText(form.getBody(), "");
		taskName.setBackground(new Color(null, 229,236,253));
		taskName.setLayoutData(td1);
		
		TableWrapData td12 = new TableWrapData(TableWrapData.FILL_GRAB);
		Label labelTaskGroup = toolkit.createLabel(form.getBody(), "Task Group :");
		Text taskGroup = toolkit.createText(form.getBody(), "synapse.simple.quartz");
		taskGroup.setBackground(new Color(null, 229,236,253));
		taskGroup.setLayoutData(td12);

		TableWrapData td2 = new TableWrapData(TableWrapData.FILL_GRAB);
//		 Misc. Section 
		Label labelPinnedServers = toolkit.createLabel(form.getBody(), "Pinned Servers :");
		Text pinnedServers = toolkit.createText(form.getBody(), "");
		pinnedServers.setBackground(new Color(null, 229,236,253));
		pinnedServers.setLayoutData(td2);


		TableWrapData td3 = new TableWrapData(TableWrapData.FILL_GRAB);
//		 Task Implementation Section 
		Label labelTaskImpl = toolkit.createLabel(form.getBody(), "Task Implementation :");
		Text taskImpl = toolkit.createText(form.getBody(), "org.apache.synapse.startup.tasks.MessageInjector");
		taskImpl.setBackground(new Color(null, 229,236,253));
		taskImpl.setLayoutData(td3);
		
		TableWrapData td31 = new TableWrapData(TableWrapData.FILL_GRAB);
		Label labelTaskImplProp = toolkit.createLabel(form.getBody(), "Task Implementation Properties :");
		Text taskImplProp = toolkit.createText(form.getBody(), "");
		taskImplProp.setBackground(new Color(null, 229,236,253));
		taskImplProp.setLayoutData(td31);
		
		TableWrapData td4 = new TableWrapData(TableWrapData.FILL_GRAB);
		Label labelType = toolkit.createLabel(form.getBody(), "Task Type :");
		Combo triggerType = new Combo(form.getBody(), SWT.DROP_DOWN);
		triggerType.setLayoutData(td4);
		triggerType.setBackground(new Color(null, 229,236,253));
		String[] triggerTypes = {"Simple", "Cron"};
		triggerType.setItems(triggerTypes);
		
		TableWrapData td5 = new TableWrapData(TableWrapData.FILL_GRAB);
		Label labelCount = toolkit.createLabel(form.getBody(), "Count :");
		Text count = toolkit.createText(form.getBody(), "");
		count.setBackground(new Color(null, 229,236,253));
		count.setLayoutData(td5);
		
		TableWrapData td6 = new TableWrapData(TableWrapData.FILL_GRAB);
		Label labelInterval = toolkit.createLabel(form.getBody(), "Interval :");
		Text interval = toolkit.createText(form.getBody(), "");
		interval.setBackground(new Color(null, 229,236,253));
		interval.setLayoutData(td6);
	}

}
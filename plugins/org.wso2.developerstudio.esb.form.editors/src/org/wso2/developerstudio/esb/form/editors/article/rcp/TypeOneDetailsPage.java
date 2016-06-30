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

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.*;
import org.eclipse.ui.forms.widgets.*;

/**
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class TypeOneDetailsPage implements IDetailsPage {
	private IManagedForm mform;
	private TypeOne input;
	private Button [] choices;
	private Button flag;
	private Text text;
	private static final String RTEXT_DATA =
			"<form><p>An example of a free-form text that should be "+ //$NON-NLS-1$
			"wrapped below the section with widgets.</p>"+ //$NON-NLS-1$
			"<p>It can contain simple tags like <a>links</a> and <b>bold text</b>.</p></form>"; //$NON-NLS-1$
	
	public TypeOneDetailsPage() {
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#initialize(org.eclipse.ui.forms.IManagedForm)
	 */
	public void initialize(IManagedForm mform) {
		this.mform = mform;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	public void createContents(Composite parent) {
		TableWrapLayout layout = new TableWrapLayout();
		layout.topMargin = 5;
		layout.leftMargin = 5;
		layout.rightMargin = 2;
		layout.bottomMargin = 2;
		parent.setLayout(layout);

		FormToolkit toolkit = mform.getToolkit();
		Section s1 = toolkit.createSection(parent, Section.DESCRIPTION|Section.TITLE_BAR);
		s1.marginWidth = 10;
		s1.setText("Type One Details"); //$NON-NLS-1$
		s1.setDescription(Messages.getString("TypeOneDetailsPage.name")); //$NON-NLS-1$
		TableWrapData td = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
		td.grabHorizontal = true;
		s1.setLayoutData(td);
		Composite client = toolkit.createComposite(s1);
		GridLayout glayout = new GridLayout();
		glayout.marginWidth = glayout.marginHeight = 0;
		glayout.numColumns = 2;
		client.setLayout(glayout);
		
		SelectionListener choiceListener = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Integer value = (Integer)e.widget.getData();
				if (input!=null) {
					input.setChoice(value.intValue());
				}
			}
		};
		GridData gd;
		choices = new Button[TypeOne.CHOICES.length];
		for (int i=0; i<TypeOne.CHOICES.length; i++) {
			choices[i] = toolkit.createButton(client, TypeOne.CHOICES[i], SWT.RADIO);
			choices[i].setData(new Integer(i));
			choices[i].addSelectionListener(choiceListener);
			gd = new GridData();
			gd.horizontalSpan = 2;
			choices[i].setLayoutData(gd);
		}
		createSpacer(toolkit, client, 2);
		flag = toolkit.createButton(client, Messages.getString("TypeOneDetailsPage.check"), SWT.CHECK); //$NON-NLS-1$
		flag.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (input!=null)
					input.setFlag(flag.getSelection());
			}
		});
		gd = new GridData();
		gd.horizontalSpan = 2;
		flag.setLayoutData(gd);
		createSpacer(toolkit, client, 2);
		
		toolkit.createLabel(client, Messages.getString("TypeOneDetailsPage.label")); //$NON-NLS-1$
		text = toolkit.createText(client, "", SWT.SINGLE); //$NON-NLS-1$
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (input!=null)
					input.setText(text.getText());
			}
		});
		gd = new GridData(GridData.FILL_HORIZONTAL|GridData.VERTICAL_ALIGN_BEGINNING);
		gd.widthHint = 10;
		text.setLayoutData(gd);
		
		createSpacer(toolkit, client, 2);
		
		FormText rtext = toolkit.createFormText(parent, true);
		rtext.setText(RTEXT_DATA, true, false);
		td = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
		td.grabHorizontal = true;
		rtext.setLayoutData(td);
		
		toolkit.paintBordersFor(s1);
		s1.setClient(client);
	}
	private void createSpacer(FormToolkit toolkit, Composite parent, int span) {
		Label spacer = toolkit.createLabel(parent, ""); //$NON-NLS-1$
		GridData gd = new GridData();
		gd.horizontalSpan = span;
		spacer.setLayoutData(gd);
	}
	private void update() {
		for (int i=0; i<TypeOne.CHOICES.length; i++) {
			choices[i].setSelection(input!=null && input.getChoice()==i);
		}
		flag.setSelection(input!=null && input.getFlag());
		text.setText(input!=null && input.getText()!=null?input.getText():""); //$NON-NLS-1$
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#inputChanged(org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection ssel = (IStructuredSelection)selection;
		if (ssel.size()==1) {
			input = (TypeOne)ssel.getFirstElement();
		}
		else
			input = null;
		update();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#commit()
	 */
	public void commit(boolean onSave) {
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#setFocus()
	 */
	public void setFocus() {
		choices[0].setFocus();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#dispose()
	 */
	public void dispose() {
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#isDirty()
	 */
	public boolean isDirty() {
		return false;
	}
	public boolean isStale() {
		return false;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#refresh()
	 */
	public void refresh() {
		update();
	}
	public boolean setFormInput(Object input) {
		return false;
	}
}

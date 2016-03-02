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
package org.wso2.developerstudio.datamapper.diagram.custom.util;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class AddNewListDialog extends Dialog {

	private Text textRootName;
	private Combo schemaTypeCombo;
	private Composite compositeRecordList;
	
	private String name;
	private String schemaType;
	
	//private String[] DATA_TYPES = { "ARRAY","STRING", "INT","BOOLEAN","BYTES","DOUBLE","ENUM","FIXED","FLOAT","INT","LONG","MAP","NULL","RECORD","UNION"};

	//FIXME only ARRAY is allowed when adding the list
	private String[] DATA_TYPES = { "ARRAY"};
	private static final String DIALOG_TITLE = "Add new Record List";
	private static final String LABEL_NAME = "Name :";
	private static final String LABEL_SCHEMATYPE = "Schema Data Type :";
	private static final String NEW_ROOT_RECORD_ID = "NewList";

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public AddNewListDialog(Shell parentShell, Class<?>[] type) {
		super(parentShell);
		setShellStyle(SWT.CLOSE | SWT.TITLE | SWT.BORDER | SWT.OK | SWT.APPLICATION_MODAL);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		getShell().setText(DIALOG_TITLE);


		compositeRecordList = new Composite(container, SWT.NONE);
		GridData gd_composite_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_2.widthHint = 575;
		compositeRecordList.setLayoutData(gd_composite_2);
		compositeRecordList.setLayout(new GridLayout(5, false));

		Label lblRootNameLabel = new Label(compositeRecordList, SWT.NONE);
		lblRootNameLabel.setText(LABEL_NAME);
		new Label(compositeRecordList, SWT.NONE);
		new Label(compositeRecordList, SWT.NONE);
		new Label(compositeRecordList, SWT.NONE);

		textRootName = new Text(compositeRecordList, SWT.BORDER);
		textRootName.setText(NEW_ROOT_RECORD_ID);
		
		textRootName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				
			}
		});
		textRootName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblSchemaTypeLabel = new Label(compositeRecordList, SWT.NONE);
		lblSchemaTypeLabel.setText(LABEL_SCHEMATYPE);
		new Label(compositeRecordList, SWT.NONE);
		new Label(compositeRecordList, SWT.NONE);
		new Label(compositeRecordList, SWT.NONE);
		
		schemaTypeCombo = new Combo(compositeRecordList, SWT.DROP_DOWN | SWT.READ_ONLY);
		schemaTypeCombo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
			}
		});
		
		schemaTypeCombo.setItems(DATA_TYPES);
		schemaTypeCombo.select(0);
		schemaTypeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(620, 190);
	}

	@Override
	protected void okPressed() {
		setName(textRootName.getText());
		setSchemaType(schemaTypeCombo.getText());
		super.okPressed();
	}
	
	public void setName(String name){
		this.name= name;
	}
	
	public void setSchemaType(String schemaType){
		this.schemaType= schemaType;
	}
	
	public String getName(){
		return name;
	}
	
	public String getSchemaType(){
		return schemaType;
	}

}


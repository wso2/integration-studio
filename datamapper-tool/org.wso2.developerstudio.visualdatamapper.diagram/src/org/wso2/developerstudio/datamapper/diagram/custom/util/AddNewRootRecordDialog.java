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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

public class AddNewRootRecordDialog extends Dialog {

	private Text textRootName;
	private Combo schemaTypeCombo;
	private Text textNamespace;
	private Text textDoc;
	private Text textAliases;
	private Composite compositeRootElement;
	
	private String name;
	private String schemaType;
	private String namespace;
	private String doc;
	private Set<String> aliases;
	
	//private String[] DATA_TYPES = {"RECORD","STRING", "INT", "ARRAY","BOOLEAN","BYTES","DOUBLE","ENUM","FIXED","FLOAT","INT","LONG","MAP","NULL","UNION"};

	//FIXME only RECORD is allowed as the root element
	private String[] DATA_TYPES = {"RECORD"};

	private static final String DIALOG_TITLE = "Add new Root Element";
	private static final String LABEL_NAME = "Name :";
	private static final String LABEL_SCHEMATYPE = "Schema Data Type :";
	private static final String LABEL_NAMESPACE = "Namespace :";
	private static final String LABEL_DOC = "Doc :";
	private static final String LABEL_ALIASES = "Aliases :";
	private static final String NEW_ROOT_RECORD_ID = "NewRootType";

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public AddNewRootRecordDialog(Shell parentShell, Class<?>[] type) {
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


		compositeRootElement = new Composite(container, SWT.NONE);
		GridData gd_composite_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_2.widthHint = 575;
		compositeRootElement.setLayoutData(gd_composite_2);
		compositeRootElement.setLayout(new GridLayout(5, false));

		Label lblRootNameLabel = new Label(compositeRootElement, SWT.NONE);
		lblRootNameLabel.setText(LABEL_NAME);
		new Label(compositeRootElement, SWT.NONE);
		new Label(compositeRootElement, SWT.NONE);
		new Label(compositeRootElement, SWT.NONE);

		textRootName = new Text(compositeRootElement, SWT.BORDER);
		textRootName.setText(NEW_ROOT_RECORD_ID);
		
		textRootName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				
			}
		});
		textRootName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblSchemaTypeLabel = new Label(compositeRootElement, SWT.NONE);
		lblSchemaTypeLabel.setText(LABEL_SCHEMATYPE);
		new Label(compositeRootElement, SWT.NONE);
		new Label(compositeRootElement, SWT.NONE);
		new Label(compositeRootElement, SWT.NONE);
		
		schemaTypeCombo = new Combo(compositeRootElement, SWT.DROP_DOWN | SWT.READ_ONLY);
		schemaTypeCombo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
			}
		});
		
		schemaTypeCombo.setItems(DATA_TYPES);
		schemaTypeCombo.select(0);
		schemaTypeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblNamespaceLabel = new Label(compositeRootElement, SWT.NONE);
		lblNamespaceLabel.setText(LABEL_NAMESPACE);
		new Label(compositeRootElement, SWT.NONE);
		new Label(compositeRootElement, SWT.NONE);
		new Label(compositeRootElement, SWT.NONE);
		
		textNamespace = new Text(compositeRootElement, SWT.BORDER);
		textNamespace.setText("");
		
		textNamespace.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				
			}
		});
		
		textNamespace.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lbldocLabel = new Label(compositeRootElement, SWT.NONE);
		lbldocLabel.setText(LABEL_DOC);
		new Label(compositeRootElement, SWT.NONE);
		new Label(compositeRootElement, SWT.NONE);
		new Label(compositeRootElement, SWT.NONE);
		
		textDoc = new Text(compositeRootElement, SWT.BORDER);
		textDoc.setText("");
		
		textDoc.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
			}
		});
		
		textDoc.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	
		
		Label lblaliasesLabel = new Label(compositeRootElement, SWT.NONE);
		lblaliasesLabel.setText(LABEL_ALIASES);
		new Label(compositeRootElement, SWT.NONE);
		new Label(compositeRootElement, SWT.NONE);
		new Label(compositeRootElement, SWT.NONE);
		
		textAliases = new Text(compositeRootElement, SWT.BORDER);
		textAliases.setText("");
		
		textAliases.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
			}
		});
		
		textAliases.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
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
		return new Point(620, 280);
	}

	@Override
	protected void okPressed() {
		setName(textRootName.getText());
		setSchemaType(schemaTypeCombo.getText());
		setNamespace(textNamespace.getText());
		setDoc(textDoc.getText());
		Set<String> aliasesSet = getAliasesSet();
		setAliases(aliasesSet);
		super.okPressed();
	}

	/**
	 * Gets the Aliases as a set
	 * @return
	 */
	private Set<String> getAliasesSet() {
		String aliases = textAliases.getText();
		String[] aliasesArray= aliases.split(",");
		Set<String> aliasesSet = new HashSet<String>(Arrays.asList(aliasesArray));
		return aliasesSet;
	}
	
	public void setName(String name){
		this.name= name;
	}
	
	public void setSchemaType(String schemaType){
		this.schemaType= schemaType;
	}
	public void setNamespace(String namespace){
		this.namespace= namespace;
	}
	
	public void setDoc(String doc){
		this.doc= doc;
	}
	
	public void setAliases(Set<String> aliases) {
		this.aliases = aliases;
	}
	
	public String getName(){
		return name;
	}
	
	public String getSchemaType(){
		return schemaType;
	}
	
	public String getNamespace(){
		return namespace;
	}
	
	public String getDoc(){
		return doc;
	}
	
	public Set<String> getAliases() {
		if (aliases == null) {
			aliases = new HashSet<String>();
		}
		return aliases;
	}
	
}

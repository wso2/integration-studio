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

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class AddNewTypeDialog extends Dialog {

	private Text textName;
	private Text textSchemaType;
	private Text textNamespace;
	private Text textPrefix;
	private Text textAliases;
	private Composite compositeType;
	
	private String name;
	private String namespace;
	private String schemaType;
	private String doc;
	private Set<String> aliases;

	

	//private String[] DATA_TYPES = { "RECORD","ARRAY","STRING", "INT","BOOLEAN","BYTES","DOUBLE","ENUM","FIXED","FLOAT","INT","LONG","MAP","RECORD","UNION"};
	
	//FIXME only RECORD is allowed when adding the list
	private String DATA_TYPE = "RECORD";
	
	private static final String DIALOG_TITLE_TYPE = "Add new Type";
	private static final String DIALOG_TITLE_ROOT = "Add new Root Element";
	private static final String LABEL_NAME = "Name :";
	private static final String LABEL_SCHEMATYPE = "Schema Data Type :";
	private static final String LABEL_NAMESPACE = "Namespace :";
	private static final String LABEL_NAMESPACE_PREFIX = "Prefix :";
	private static final String LABEL_ALIASES = "Aliases :";
	private static final String NEW_ROOT_RECORD_ID = "NewRootType";
	private static final String NEW_RECORD_ID = "NewType";

	/** 
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public AddNewTypeDialog(Shell parentShell, Class<?>[] type) {
		super(parentShell);
		setShellStyle(SWT.CLOSE | SWT.TITLE | SWT.BORDER | SWT.OK | SWT.APPLICATION_MODAL);
	}
	
	/**
	 * Sets the title
	 * @param title
	 */
	public void setTitle(String title){
		getShell().setText(title);
		//Sets the default value based on the Title
		if(title.equals(DIALOG_TITLE_ROOT)){
			textName.setText(NEW_ROOT_RECORD_ID);
		}else if(title.equals(DIALOG_TITLE_TYPE)){
			textName.setText(NEW_RECORD_ID);
		}
	}
	
	/**
	 * Sets values to be used in edit dialog
	 * @param name
	 * @param namespace
	 * @param schemaType
	 * @param doc
	 * @param aliases
	 */
	public void setValues(String name, String namespace, String schemaType, String doc, String aliases){
		if(StringUtils.isNotEmpty(name)){
			textName.setText(name);
		}if(StringUtils.isNotEmpty(namespace)){
			textPrefix.setText(namespace);
		}if(StringUtils.isNotEmpty(schemaType)){
			textSchemaType.setText(schemaType);
		}if(StringUtils.isNotEmpty(doc)){
			textNamespace.setText(doc);
		}if(StringUtils.isNotEmpty(aliases)){
			textAliases.setText(aliases);
		}

	}
	
	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		compositeType = new Composite(container, SWT.NONE);
		GridData gd_composite_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_2.widthHint = 575;
		compositeType.setLayoutData(gd_composite_2);
		compositeType.setLayout(new GridLayout(4, false));

		Label lblRootNameLabel = new Label(compositeType, SWT.NONE);
		lblRootNameLabel.setText(LABEL_NAME);
		
		textName = new Text(compositeType, SWT.BORDER);
		//textRootName.setText(defaultName);
		
		textName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				
			}
		});
		textName.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 3, 1));
		

		Label lblSchemaTypeLabel = new Label(compositeType, SWT.NONE);
		lblSchemaTypeLabel.setText(LABEL_SCHEMATYPE);
		
		textSchemaType = new Text(compositeType, SWT.READ_ONLY | SWT.BORDER);
		textSchemaType.setText(DATA_TYPE);
		textSchemaType.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
			}
		});
		textSchemaType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
	
		Label lblAliasesLabel = new Label(compositeType, SWT.NONE);
		lblAliasesLabel.setText(LABEL_ALIASES);
		
		textAliases = new Text(compositeType, SWT.BORDER);
		textAliases.setText("");
		
		textAliases.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
			}
		});
		
		textAliases.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		
		Label lblNamespacePrefix = new Label(compositeType, SWT.NONE);
		lblNamespacePrefix.setText(LABEL_NAMESPACE_PREFIX);
		
		
		textPrefix = new Text(compositeType, SWT.BORDER);
		textPrefix.setText("");
		
		textPrefix.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				
			}
		});

		textPrefix.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNamespaceLabel = new Label(compositeType, SWT.NONE);
		lblNamespaceLabel.setText(LABEL_NAMESPACE);

		textNamespace = new Text(compositeType, SWT.BORDER);
		textNamespace.setText("");
		
		textNamespace.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				
			}
		});
		
		textNamespace.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	
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
		//Append a prefix to the name
		if(StringUtils.isNotEmpty(textPrefix.getText())){
			setName(textPrefix.getText() + ":" + textName.getText());
			setNamespace(textPrefix.getText());
		}else{
			setName(textName.getText());
		}	
		setSchemaType(textSchemaType.getText());
		//Sets the xml namespace as the doc value in avro
		setDoc(textNamespace.getText());
		Set<String> aliasesSet = getAliasesSet();
		setAliases(aliasesSet);
		super.okPressed();
	}
	
	/**
	 * Gets the Aliases as a set
	 * @return
	 */
	private Set<String> getAliasesSet() {
		Set<String> aliasesSet = null;
		String aliases = textAliases.getText();
		if(StringUtils.isNotEmpty(aliases)){
			String[] aliasesArray = aliases.split(",");
			aliasesSet = new HashSet<String>(Arrays.asList(aliasesArray));
		}
		
		return aliasesSet;
	}
	
	public void setName(String name){
		this.name= name;
	}
	
	public void setSchemaType(String schemaType){
		this.schemaType= schemaType;
	}
	
	public void setDoc(String doc){
		this.doc= doc;
	}
	
	public void setNamespace(String namespace){
		this.namespace= namespace;
	}
	
	public String getName(){
		return name;
	}
	
	public void setAliases(Set<String> aliases) {
		this.aliases = aliases;
	}
	
	public String getSchemaType(){
		return schemaType;
	}
	
	public String getDoc(){
		return doc;
	}
	
	public String getNamespace(){
		return namespace;
	}
	
	public Set<String> getAliases() {
		return aliases;
	}
	
}



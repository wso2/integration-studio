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

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.datamapper.Input;
import org.wso2.developerstudio.datamapper.PropertyKeyValuePair;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.DataMapperRootEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutputEditPart;
import org.wso2.developerstudio.datamapper.impl.DataMapperRootImpl;
import org.wso2.developerstudio.datamapper.impl.ElementImpl;

public class AddNewObjectDialog extends Dialog {
	

	private Text textTitle;
	private Combo comboSchemaType;
	private Text textSchemaValue;
	private Text textID;
	private Text textNamespaces;
	private Combo comboValue;
	private Text textIdentifierType;
	private Text textIdentifierValue;
	private Text textIdentifierURL;
	private Composite compositeType;
	private Button checkBoxForValue;
	private Button checkBoxForIdentifiers;
	private Button btnNamespaces;
	private Button checkBoxForNullables;
	private Combo textInterrelatedCombo;
	private Combo textRootInterrelatedCombo;
	

	private Label lblTitleLabel;
	private Label lblSchemaTypeLabel;
	private Label lblID;
	private Label lblSchemaValue;
	private Label lblNamespaces;
	private Label lblCheckBoxForValue;
	private Label lblCheckBoxForIdentifiers;
	private Label lblValue;
	private Label lblIdentifierType;
	private Label lblIdentifierValue;
	private Label lblIdentifierURL;
	private Label lblNullables;
	private Label lblInterrelatedElement;
	

	private String title;
	private String schemaType;
	private String schemaValue;
	private String id;
	private String required;
	private String namespaces;
	private String value;
	private String identifierType;
	private String identifierValue;
	private String identifierURL;
	private boolean isNullable = false;
	private String interrelatedElement;
	private String rootInterrelatedElement;
	private boolean isOutputEditpartContainer = false;
	private boolean isRootElementNode = false;

	private String[] DATA_TYPES = { "string", "number", "boolean" };
	private String[] DATA_TYPES_FOR_VALUE = { "","string", "number", "boolean" };
	private String[] ROOT_TYPE = {"object","array"};
	private String[] OBJECT_TYPE = { "object" };
	private String[] ARRAY_TYPE = { "array" };
	/*private String[] ALL_TYPES ={"object","array","string", "number", "boolean", "bytes", "double", "enum", "fixed", "float", "long",
			"map", "union"};*/

	// FIXME only RECORD is allowed when adding the list
	// private String DATA_TYPE = "object";

	private static final String DIALOG_TITLE_ROOT = "Add new Root Element";
	private static final String DIALOG_TITLE_OBJECT = "Add new Object";
	private static final String DIALOG_TITLE_ARRAY = "Add new Array";
	private static final String DIALOG_TITLE_FIELD = "Add new Field";
	private static final String DIALOG_TITLE_ATTRIBUTE = "Add new Attribute";
	private static final String LABEL_TITLE = "Name :";
	private static final String LABEL_SCHEMATYPE = "Schema Type :";
	private static final String LABEL_SCHEMA_VALUE = "Schema Value :";
	private static final String LABEL_CHECKBOX_VALUE = "Object holds a value";
	private static final String LABEL_CHECKBOX_IDENTIFIER = "Object has identifiers";
	private static final String LABEL_REQUIRED = "Required :";
	private static final String LABEL_VALUE = "Value :";
	private static final String LABEL_IDENTIFIER_TYPE = "Identifier Type :";
	private static final String LABEL_IDENTIFIER_VALUE = "Identifier Value :";
	private static final String LABEL_IDENTIFIER_URL = "Identifier URL :";
	private static final String LABEL_ID = "ID :";
	private static final String LABEL_NAMESPACES_URL = "Namespaces :";
	private static final String NEW_ROOT_RECORD_ID = "NewRootType";
	private static final String NEW_OBJECT_ID = "NewObject";
	private static final String NEW_ARRAY_ID = "NewArray";
	private static final String NEW_ELEMENT_ID = "NewElement";
	private static final String NEW_ATTRIBUTE_ID = "NewAttribute";
	private static final String LABEL_NULLABLE = "Is Nullable";
	private static final String LABEL_INTERRELATED_ELEMENT = "Interrelated Input Element :";
	
	private static final String ARRAY = "array";
	private static final String OBJECT = "object";
	private static final String LABEL_ROOT_INTERRELATED_ELEMENT = "Interrelated Root Element :";

	private boolean okPressed = false;
	private Label lblRootInterrelatedElement;
	private InputEditPart inputRootElement;
	private boolean isElementInOutput;
	private EditPart selectedEP;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @param selectedEP TODO
	 */
	public AddNewObjectDialog(Shell parentShell, Class<?>[] type, EditPart selectedEP) {
		super(parentShell);
		setShellStyle(SWT.CLOSE | SWT.TITLE | SWT.BORDER | SWT.OK | SWT.APPLICATION_MODAL);
		this.selectedEP = selectedEP;
		inputRootElement = getInputRootElement(selectedEP);
	}

	private InputEditPart getInputRootElement(EditPart selectedEP) {
		while(!(selectedEP instanceof OutputEditPart)){
			selectedEP=selectedEP.getParent();
			if(selectedEP instanceof DataMapperRootEditPart){
				return null;
			}
		}
		@SuppressWarnings("unchecked")
		List<EditPart> diagramElements = selectedEP.getParent().getChildren();
		for (EditPart editPart : diagramElements) {
			if(editPart instanceof InputEditPart){
				return (InputEditPart) editPart;
			}
		}
		return null;
	}

	/**
	 * Sets the title
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		getShell().setText(title);
		// Sets the default value based on the Title
		if (title.equals(DIALOG_TITLE_ROOT)) {
			textTitle.setText(NEW_ROOT_RECORD_ID);
		}if (title.equals(DIALOG_TITLE_OBJECT)) {
			textTitle.setText(NEW_OBJECT_ID);
		}if (title.equals(DIALOG_TITLE_ARRAY)) {
			textTitle.setText(NEW_ARRAY_ID);
		}if (title.equals(DIALOG_TITLE_FIELD)) {
			textTitle.setText(NEW_ELEMENT_ID);
		}if (title.equals(DIALOG_TITLE_ATTRIBUTE)){
			textTitle.setText(NEW_ATTRIBUTE_ID);
		}
	}

	/**
	 * Sets the visibility
	 * 
	 * @param title
	 * @param isOutputEditPart 
	 */
	public void setVisibility(String title, boolean isOutputEditPart) {
		getShell().setText(title);
		// Sets the visibility based on the type
		if (title.equals(DIALOG_TITLE_ROOT)) {
			lblSchemaValue.setVisible(true);
			textSchemaValue.setVisible(true);
			lblNamespaces.setVisible(true);
			textNamespaces.setVisible(true);
			checkBoxForValue.setVisible(false);
			lblCheckBoxForValue.setVisible(false);
			lblValue.setVisible(false);
			comboValue.setVisible(false);
			checkBoxForIdentifiers.setVisible(false);
			lblCheckBoxForIdentifiers.setVisible(false);
			lblIdentifierType.setVisible(false);
			lblIdentifierValue.setVisible(false);
			textIdentifierType.setVisible(false);
			textIdentifierValue.setVisible(false);
			lblIdentifierURL.setVisible(false);
			textIdentifierURL.setVisible(false);
			checkBoxForNullables.setVisible(true);
			lblNullables.setVisible(true);
			isRootElementNode = true;
		}
		if (title.equals(DIALOG_TITLE_OBJECT)) {
			lblSchemaValue.setVisible(false);
			textSchemaValue.setVisible(false);
			lblNamespaces.setVisible(true);
			textNamespaces.setVisible(true);
			checkBoxForValue.setVisible(true);
			lblCheckBoxForValue.setVisible(true);
			lblValue.setVisible(false);
			comboValue.setVisible(false);
			checkBoxForIdentifiers.setVisible(true);
			lblCheckBoxForIdentifiers.setVisible(true);
			lblIdentifierType.setVisible(false);
			lblIdentifierValue.setVisible(false);
			textIdentifierType.setVisible(false);
			textIdentifierValue.setVisible(false);
			lblIdentifierURL.setVisible(false);
			textIdentifierURL.setVisible(false);
			checkBoxForNullables.setVisible(true);
			lblNullables.setVisible(true);
		}if(title.equals(DIALOG_TITLE_ARRAY)){
			lblSchemaValue.setVisible(false);
			textSchemaValue.setVisible(false);
			lblNamespaces.setVisible(true);
			textNamespaces.setVisible(true);
			checkBoxForValue.setVisible(true);
			lblCheckBoxForValue.setVisible(true);
			lblValue.setVisible(false);
			comboValue.setVisible(false);
			checkBoxForIdentifiers.setVisible(true);
			lblCheckBoxForIdentifiers.setVisible(true);
			lblIdentifierType.setVisible(false);
			lblIdentifierValue.setVisible(false);
			textIdentifierType.setVisible(false);
			textIdentifierValue.setVisible(false);
			lblIdentifierURL.setVisible(false);
			textIdentifierURL.setVisible(false);
			checkBoxForNullables.setVisible(true);
			lblNullables.setVisible(true);
			if (isOutputEditPart && lblInterrelatedElement != null) {
				lblInterrelatedElement.setVisible(true && isElementInOutput);
				lblRootInterrelatedElement.setVisible(true && isElementInOutput);
				textInterrelatedCombo.setVisible(true && isElementInOutput);
				textRootInterrelatedCombo.setVisible(true && isElementInOutput);
			}
				
		} if (title.equals(DIALOG_TITLE_FIELD)) {
			checkBoxForValue.setVisible(false);
			lblCheckBoxForValue.setVisible(false);
			lblValue.setVisible(false);
			comboValue.setVisible(false);
			checkBoxForIdentifiers.setVisible(false);
			lblCheckBoxForIdentifiers.setVisible(false);
			lblIdentifierType.setVisible(false);
			lblIdentifierValue.setVisible(false);
			textIdentifierType.setVisible(false);
			textIdentifierValue.setVisible(false);
			lblIdentifierURL.setVisible(false);
			textIdentifierURL.setVisible(false);
			checkBoxForNullables.setVisible(true);
			lblNullables.setVisible(true);
			lblSchemaValue.setVisible(false);
			textSchemaValue.setVisible(false);
		}if(title.equals(DIALOG_TITLE_ATTRIBUTE)){
			checkBoxForValue.setVisible(false);
			lblCheckBoxForValue.setVisible(false);
			lblValue.setVisible(false);
			comboValue.setVisible(false);
			checkBoxForIdentifiers.setVisible(false);
			lblCheckBoxForIdentifiers.setVisible(false);
			lblIdentifierType.setVisible(false);
			lblIdentifierValue.setVisible(false);
			textIdentifierType.setVisible(false);
			textIdentifierValue.setVisible(false);
			lblIdentifierURL.setVisible(false);
			textIdentifierURL.setVisible(false);
			checkBoxForNullables.setVisible(true);
			lblNullables.setVisible(true);
			lblSchemaValue.setVisible(false);
			textSchemaValue.setVisible(false);
		}
	}
	
	/**
	 * Sets the type when adding
	 * 
	 * @param title
	 */
	public void setType(String title){
			getShell().setText(title);
		    //Sets the visibility based on the type
		    if(title.equals(DIALOG_TITLE_ROOT)){
		    	comboSchemaType.setItems(ROOT_TYPE);                       
                comboSchemaType.select(0);
		    }else if(title.equals(DIALOG_TITLE_OBJECT)){
    		    	comboSchemaType.setItems(OBJECT_TYPE);                       
                    comboSchemaType.select(0);
		    }else if(title.equals(DIALOG_TITLE_ARRAY)){
		    	comboSchemaType.setItems(ARRAY_TYPE);                       
                comboSchemaType.select(0);
		    }else{
		    	comboSchemaType.setItems(DATA_TYPES);                       
                comboSchemaType.select(0);
		    }
	}


	/**
	 * Sets the the schema type
	 * 
	 * @param title
	 */
	public void setTypeWhenEditing(String type) {
		if(type.equals(OBJECT)){
			comboSchemaType.setItems(OBJECT_TYPE);
		}else if(type.equals(ARRAY)){
			comboSchemaType.setItems(ARRAY_TYPE);
		}else{
			comboSchemaType.setItems(DATA_TYPES);
		}
		
	}

	/**
	 * Sets the values
	 * 
	 * @param title
	 *            title
	 * @param schemaType
	 *            schemaType
	 * @param id
	 *            id
	 * @param required
	 *            required
	 * @param schemaValue
	 *            schemaValue
	 * @param isOutputEditPart 
	 * @param isRootElement 
	 * @param rootInterrelatedElement TODO
	 * @param identifierValue2 
	 * @param identifierType2 
	 */
	public void setValues(String title, String schemaType, String id, String required, String schemaValue,
			String namespaces, String value, String identifierType, String identifierValue, String identifierURL,
			boolean nullValue, String interrelatedElement, boolean isOutputEditPart, boolean isRootElement, String rootInterrelatedElement) {
		if (StringUtils.isNotEmpty(title)) {
			textTitle.setText(title);
		}
		if (StringUtils.isNotEmpty(schemaType)) {
			switch (schemaType) {
			case "object":
				comboSchemaType.setItems(ROOT_TYPE);
				comboSchemaType.select(0);
				lblID.setVisible(true);
				textID.setVisible(true);
				lblNamespaces.setVisible(true);
				textNamespaces.setVisible(true);
				checkBoxForNullables.setVisible(true);
				lblNullables.setVisible(true);
				if(isRootElement){
					checkBoxForIdentifiers.setVisible(false);
					lblCheckBoxForIdentifiers.setVisible(false);
					lblIdentifierType.setVisible(false);
					lblIdentifierValue.setVisible(false);
					textIdentifierType.setVisible(false);
					textIdentifierValue.setVisible(false);
					lblIdentifierURL.setVisible(false);
					textIdentifierURL.setVisible(false);
					checkBoxForValue.setVisible(false);
					lblCheckBoxForValue.setVisible(false);
					lblValue.setVisible(false);
					comboValue.setVisible(false);
					lblSchemaValue.setVisible(true);
					textSchemaValue.setVisible(true);
				}else{
					checkBoxForIdentifiers.setVisible(true);
					lblCheckBoxForIdentifiers.setVisible(true);
					lblIdentifierType.setVisible(false);
					lblIdentifierValue.setVisible(false);
					textIdentifierType.setVisible(false);
					textIdentifierValue.setVisible(false);
					lblIdentifierURL.setVisible(false);
					textIdentifierURL.setVisible(false);
					checkBoxForValue.setVisible(true);
					lblCheckBoxForValue.setVisible(true);
					lblValue.setVisible(false);
					comboValue.setVisible(false);
					lblSchemaValue.setVisible(false);
					textSchemaValue.setVisible(false);
				}
				break;
			case "array":
				comboSchemaType.setItems(ROOT_TYPE);
				comboSchemaType.select(1);
				lblID.setVisible(true);
				textID.setVisible(true);
				lblNamespaces.setVisible(true);
				textNamespaces.setVisible(true);
				checkBoxForNullables.setVisible(true);
				lblNullables.setVisible(true);
				if (isOutputEditPart && lblInterrelatedElement != null) {
					lblInterrelatedElement.setVisible(true);
					lblRootInterrelatedElement.setVisible(true);
					textInterrelatedCombo.setVisible(true);
					textRootInterrelatedCombo.setVisible(true);
					if(StringUtils.isNotEmpty(interrelatedElement)){
						textInterrelatedCombo.setText(interrelatedElement);
					}
					if(StringUtils.isNotEmpty(rootInterrelatedElement)){
						textRootInterrelatedCombo.setText(rootInterrelatedElement);
					}
				}
				if(isRootElement){
					checkBoxForIdentifiers.setVisible(false);
					lblCheckBoxForIdentifiers.setVisible(false);
					lblIdentifierType.setVisible(false);
					lblIdentifierValue.setVisible(false);
					textIdentifierType.setVisible(false);
					textIdentifierValue.setVisible(false);
					lblIdentifierURL.setVisible(false);
					textIdentifierURL.setVisible(false);
					checkBoxForValue.setVisible(false);
					lblCheckBoxForValue.setVisible(false);
					lblValue.setVisible(false);
					comboValue.setVisible(false);
					lblSchemaValue.setVisible(true);
					textSchemaValue.setVisible(true);
				}else{
					checkBoxForIdentifiers.setVisible(true);
					lblCheckBoxForIdentifiers.setVisible(true);
					lblIdentifierType.setVisible(false);
					lblIdentifierValue.setVisible(false);
					textIdentifierType.setVisible(false);
					textIdentifierValue.setVisible(false);
					lblIdentifierURL.setVisible(false);
					textIdentifierURL.setVisible(false);
					checkBoxForValue.setVisible(true);
					lblCheckBoxForValue.setVisible(true);
					lblValue.setVisible(false);
					comboValue.setVisible(false);
					lblSchemaValue.setVisible(false);
					textSchemaValue.setVisible(false);
				}
				break;
			case "string":
				comboSchemaType.select(0);
				lblID.setVisible(true);
				textID.setVisible(true);
				lblSchemaValue.setVisible(false);
				textSchemaValue.setVisible(false);
				lblNamespaces.setVisible(true);
				textNamespaces.setVisible(true);
				checkBoxForValue.setVisible(false);
				lblCheckBoxForValue.setVisible(false);
				lblValue.setVisible(false);
				comboValue.setVisible(false);
				checkBoxForIdentifiers.setVisible(false);
				lblCheckBoxForIdentifiers.setVisible(false);
				lblIdentifierType.setVisible(false);
				lblIdentifierValue.setVisible(false);
				textIdentifierType.setVisible(false);
				textIdentifierValue.setVisible(false);
				lblIdentifierURL.setVisible(false);
				textIdentifierURL.setVisible(false);
				checkBoxForNullables.setVisible(true);
				lblNullables.setVisible(true);
				break;
			case "number":
				comboSchemaType.select(1);
				lblID.setVisible(true);
				textID.setVisible(true);
				lblSchemaValue.setVisible(false);
				textSchemaValue.setVisible(false);
				lblNamespaces.setVisible(true);
				textNamespaces.setVisible(true);
				checkBoxForValue.setVisible(false);
				lblCheckBoxForValue.setVisible(false);
				lblValue.setVisible(false);
				comboValue.setVisible(false);
				checkBoxForIdentifiers.setVisible(false);
				lblCheckBoxForIdentifiers.setVisible(false);
				lblIdentifierType.setVisible(false);
				lblIdentifierValue.setVisible(false);
				textIdentifierType.setVisible(false);
				textIdentifierValue.setVisible(false);
				lblIdentifierURL.setVisible(false);
				textIdentifierURL.setVisible(false);
				lblIdentifierURL.setVisible(false);
				textIdentifierURL.setVisible(false);
				checkBoxForNullables.setVisible(true);
				lblNullables.setVisible(true);
				break;
			case "boolean":
				comboSchemaType.select(2);
				lblID.setVisible(true);
				textID.setVisible(true);
				lblSchemaValue.setVisible(false);
				textSchemaValue.setVisible(false);
				lblNamespaces.setVisible(true);
				textNamespaces.setVisible(true);
				checkBoxForValue.setVisible(false);
				lblCheckBoxForValue.setVisible(false);
				lblValue.setVisible(false);
				comboValue.setVisible(false);
				checkBoxForIdentifiers.setVisible(false);
				lblCheckBoxForIdentifiers.setVisible(false);
				lblIdentifierType.setVisible(false);
				lblIdentifierValue.setVisible(false);
				textIdentifierType.setVisible(false);
				textIdentifierValue.setVisible(false);
				lblIdentifierURL.setVisible(false);
				textIdentifierURL.setVisible(false);
				checkBoxForNullables.setVisible(true);
				lblNullables.setVisible(true);
				break;
			default:
				break;
			}
			if (StringUtils.isNotEmpty(value)) {
				checkBoxForValue.setVisible(true);
				checkBoxForValue.setSelection(true);
				lblCheckBoxForValue.setVisible(true);
				lblValue.setVisible(true);
				comboValue.setVisible(true);
				switch (value) {
				case "string":
					comboValue.select(1);
					break;
				case "number":
					comboValue.select(2);
					break;
				case "boolean":
					comboValue.select(3);
					break;
				default:
					break;
				}
				}
		}
		if (StringUtils.isNotEmpty(id)) {
			textID.setText(id);
		}
		if (StringUtils.isNotEmpty(schemaValue)) {
			textSchemaValue.setText(schemaValue);
		}
		if (StringUtils.isNotEmpty(namespaces)) {
			textNamespaces.setText(namespaces);
		}
		if(StringUtils.isNotEmpty(identifierType) && StringUtils.isNotEmpty(identifierValue) && StringUtils.isNotEmpty(identifierURL)){
			checkBoxForIdentifiers.setVisible(true);
			lblCheckBoxForIdentifiers.setVisible(true);
			checkBoxForIdentifiers.setSelection(true);
			lblIdentifierType.setVisible(true);
			lblIdentifierValue.setVisible(true);
			lblIdentifierURL.setVisible(true);
			textIdentifierType.setVisible(true);
			textIdentifierURL.setVisible(true);
			textIdentifierValue.setVisible(true);
			textIdentifierType.setText(identifierType);
			textIdentifierValue.setText(identifierValue);
			textIdentifierURL.setText(identifierURL);
			//TODO when editing the xsi:type display the added URL
		}
		
		if(nullValue){
			checkBoxForNullables.setVisible(true);
			lblNullables.setVisible(true);
			checkBoxForNullables.setSelection(true);
		}else{
			checkBoxForNullables.setVisible(true);
			lblNullables.setVisible(true);
			checkBoxForNullables.setSelection(false);
		}
		if(isOutputEditPart){
			isOutputEditpartContainer = true;
		}
		if(isRootElement){
			isRootElementNode = true;
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
		compositeType.setLayout(new GridLayout(6, false));
	
		lblTitleLabel = new Label(compositeType, SWT.NONE);
		lblTitleLabel.setText(LABEL_TITLE);

		textTitle = new Text(compositeType, SWT.BORDER);

		textTitle.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {

			}
		});
		textTitle.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 5, 1));

		lblSchemaTypeLabel = new Label(compositeType, SWT.NONE);
		lblSchemaTypeLabel.setText(LABEL_SCHEMATYPE);

		comboSchemaType = new Combo(compositeType, SWT.DROP_DOWN | SWT.READ_ONLY);
		comboSchemaType.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(comboSchemaType.getText().equals("object")|| comboSchemaType.getText().equals("array")){
					lblSchemaValue.setVisible(false);
					textSchemaValue.setVisible(false);
					lblNamespaces.setVisible(true);
					textNamespaces.setVisible(true);
					checkBoxForValue.setVisible(true);
					lblCheckBoxForValue.setVisible(true);
					lblValue.setVisible(false);
					comboValue.setVisible(false);
					checkBoxForIdentifiers.setVisible(true);
					lblCheckBoxForIdentifiers.setVisible(true);
					lblIdentifierType.setVisible(false);
					lblIdentifierValue.setVisible(false);
					textIdentifierType.setVisible(false);
					textIdentifierValue.setVisible(false);
					lblIdentifierURL.setVisible(false);
					textIdentifierURL.setVisible(false);
					checkBoxForNullables.setVisible(true);
					lblNullables.setVisible(true);
					if(comboSchemaType.getText().equals("array") && isOutputEditpartContainer){
						lblInterrelatedElement.setVisible(true);
						lblRootInterrelatedElement.setVisible(true);
						textInterrelatedCombo.setVisible(true);
						textRootInterrelatedCombo.setVisible(true);
					}
					if(isRootElementNode){
						checkBoxForValue.setVisible(false);
						lblCheckBoxForValue.setVisible(false);
						lblValue.setVisible(false);
						comboValue.setVisible(false);
						checkBoxForIdentifiers.setVisible(false);
						lblCheckBoxForIdentifiers.setVisible(false);
						lblIdentifierType.setVisible(false);
						lblIdentifierValue.setVisible(false);
						textIdentifierType.setVisible(false);
						textIdentifierValue.setVisible(false);
						lblIdentifierURL.setVisible(false);
						textIdentifierURL.setVisible(false);
						lblSchemaValue.setVisible(true);
						textSchemaValue.setVisible(true);
					}
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		comboSchemaType.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
			}
		});

		comboSchemaType.setItems(DATA_TYPES);
		comboSchemaType.select(0);

		comboSchemaType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));

		lblID = new Label(compositeType, SWT.NONE);
		lblID.setText(LABEL_ID);

		textID = new Text(compositeType, SWT.BORDER);
		textID.setText("");

		textID.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {

			}
		});

		textID.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
		
		
		
		
		
		checkBoxForNullables = new Button(compositeType,SWT.CHECK);
		lblNullables = new Label(compositeType, SWT.NONE);
		lblNullables.setText(LABEL_NULLABLE);
		
		lblNullables.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
	
		checkBoxForNullables.addSelectionListener(new SelectionListener() {
		
			@Override
			public void widgetSelected(SelectionEvent event) {
				
				if (((Button)event.widget).getSelection()) {
				     isNullable = true;
					
				}else{
					 isNullable = false;
				}		
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		lblNamespaces = new Label(compositeType, SWT.NONE);
		lblNamespaces.setText(LABEL_NAMESPACES_URL);

		textNamespaces = new Text(compositeType, SWT.BORDER);
		textNamespaces.setText("");
		textNamespaces.setEditable(false);

		textNamespaces.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {

			}
		});
		textNamespaces.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));

		btnNamespaces = new Button(compositeType, SWT.NONE);
		btnNamespaces.setText("...");
		btnNamespaces.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				NamespacedPropertyEditorDialog dialog = new NamespacedPropertyEditorDialog(Display.getCurrent().getActiveShell());
				dialog.open();	
				String namespaces = getNamespacesAsString(dialog.getNamespaces());
				textNamespaces.setText(namespaces);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		btnNamespaces.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));

		lblSchemaValue = new Label(compositeType, SWT.NONE);
		lblSchemaValue.setText(LABEL_SCHEMA_VALUE);

		textSchemaValue = new Text(compositeType, SWT.BORDER);
		textSchemaValue.setText("http://wso2.org/json-schema/wso2-data-mapper-v5.0.0/schema#");
		textSchemaValue.setEditable(false);

		textSchemaValue.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {

			}
		});

		textSchemaValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
		if (((Node) selectedEP.getModel()).getElement() instanceof TreeNode) {
			TreeNode node = (TreeNode) ((Node) selectedEP.getModel()).getElement();

			if (inputRootElement != null && isArrayElement(node)) {
				GridData dataPropertyConfigText = new GridData();
				dataPropertyConfigText.grabExcessHorizontalSpace = true;
				dataPropertyConfigText.horizontalAlignment = GridData.FILL;
				List<String> arrayInputElements = getArrayElements(inputRootElement);
				isElementInOutput = true;
				lblInterrelatedElement = new Label(compositeType, SWT.NONE);
				lblInterrelatedElement.setText(LABEL_INTERRELATED_ELEMENT);

				textInterrelatedCombo = new Combo(compositeType, SWT.DROP_DOWN | SWT.BORDER);
				textInterrelatedCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
				for (String element : arrayInputElements) {
					textInterrelatedCombo.add(element);
				}

				lblRootInterrelatedElement = new Label(compositeType, SWT.NONE);
				lblRootInterrelatedElement.setText(LABEL_ROOT_INTERRELATED_ELEMENT);

				textRootInterrelatedCombo = new Combo(compositeType, SWT.DROP_DOWN | SWT.BORDER);
				textRootInterrelatedCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
				for (String element : arrayInputElements) {
					textRootInterrelatedCombo.add(element);
				}
			} else {
				isElementInOutput = false;
			}
		}
		
		checkBoxForIdentifiers = new Button(compositeType,SWT.CHECK);
		lblCheckBoxForIdentifiers = new Label(compositeType, SWT.NONE);
		lblCheckBoxForIdentifiers.setText(LABEL_CHECKBOX_IDENTIFIER);
		
		lblCheckBoxForIdentifiers.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
		
		lblIdentifierType = new Label(compositeType, SWT.NONE);
		lblIdentifierType.setText(LABEL_IDENTIFIER_TYPE);
		lblIdentifierType.setVisible(false);

		
		textIdentifierType = new Text(compositeType, SWT.BORDER);
		textIdentifierType.setText("");

		textIdentifierType.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {

			}
		});

		textIdentifierType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		lblIdentifierValue = new Label(compositeType, SWT.NONE);
		lblIdentifierValue.setText(LABEL_IDENTIFIER_VALUE);
		lblIdentifierValue.setVisible(false);

		
		textIdentifierValue = new Text(compositeType, SWT.BORDER);
		textIdentifierValue.setText("");

		textIdentifierValue.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {

			}
		});

		textIdentifierValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		lblIdentifierURL = new Label(compositeType, SWT.NONE);
		lblIdentifierURL.setText(LABEL_IDENTIFIER_URL);
		lblIdentifierURL.setVisible(false);

		
		textIdentifierURL = new Text(compositeType, SWT.BORDER);
		textIdentifierURL.setText("");

		textIdentifierURL.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {

			}
		});

		textIdentifierURL.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	
		checkBoxForIdentifiers.addSelectionListener(new SelectionListener() {
		
			@Override
			public void widgetSelected(SelectionEvent event) {
				
				if (((Button)event.widget).getSelection()) {
					lblIdentifierType.setVisible(true);
					textIdentifierType.setVisible(true);
					lblIdentifierValue.setVisible(true);
					textIdentifierValue.setVisible(true);
					lblIdentifierURL.setVisible(true);
					textIdentifierURL.setVisible(true);
				}else{
					lblIdentifierType.setVisible(false);
					textIdentifierType.setVisible(false);
					lblIdentifierValue.setVisible(false);
					textIdentifierValue.setVisible(false);
					lblIdentifierURL.setVisible(false);
					textIdentifierURL.setVisible(false);
				}		
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		checkBoxForValue = new Button(compositeType,SWT.CHECK);
		lblCheckBoxForValue = new Label(compositeType, SWT.NONE);
		lblCheckBoxForValue.setText(LABEL_CHECKBOX_VALUE);
		
		lblCheckBoxForValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
		
		lblValue = new Label(compositeType, SWT.NONE);
		lblValue.setText(LABEL_VALUE);
		lblValue.setVisible(false);

		
		comboValue = new Combo(compositeType, SWT.DROP_DOWN | SWT.READ_ONLY);
		comboValue.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
			}
		});

		comboValue.setItems(DATA_TYPES_FOR_VALUE);
		comboValue.select(0);
	
		comboValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
	
		checkBoxForValue.addSelectionListener(new SelectionListener() {
		
			@Override
			public void widgetSelected(SelectionEvent event) {
				
				if (((Button)event.widget).getSelection()) {
					lblValue.setVisible(true);
					comboValue.setVisible(true);
				}else{
					lblValue.setVisible(false);
					comboValue.setVisible(false);
					comboValue.select(0);
				}		
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	
		return container;
	}

	private List<String> getArrayElements(InputEditPart inputRootElement) {
		List<String> elementArray = new ArrayList<>();
		DiagramImpl diagram = (DiagramImpl) inputRootElement.getParent().getModel();
		DataMapperRootImpl element = (DataMapperRootImpl) diagram.getElement();
		Input input = element.getInput();
		Stack<EObject> nodeStack = new Stack<>();
		nodeStack.addAll(input.getTreeNode());
		Stack<EObject> parentVariableStack = new Stack<EObject>();
		List<EObject> tempNodeArray = new ArrayList<>();
		while (!nodeStack.isEmpty()) {
			EObject currentNode = nodeStack.pop();
			if (currentNode instanceof TreeNode) {
				TreeNode currentTreeNode = (TreeNode) currentNode;
				if (currentTreeNode.getLevel() <= parentVariableStack.size()) {
					while (parentVariableStack.size() >= currentTreeNode.getLevel()) {
						parentVariableStack.pop();
					}
				} else if (currentTreeNode.getLevel() > (parentVariableStack.size() + 1)) {
					throw new IllegalArgumentException("Illegal element level detected : element level- "
							+ currentTreeNode.getLevel() + " , parents level- " + parentVariableStack.size());
				}
				String variableName = getVariableName(parentVariableStack, currentTreeNode.getName());
				String variableType = getTreeNodeType(currentTreeNode);
				if("array".equals(variableType)){
					elementArray.add(variableName);
				}
				if (currentTreeNode.getLevel() == parentVariableStack.size()) {
					parentVariableStack.pop();
					parentVariableStack.push(currentTreeNode);
				} else if (currentTreeNode.getLevel() > parentVariableStack.size()) {
					parentVariableStack.push(currentTreeNode);
				} else {
					while (parentVariableStack.size() >= currentTreeNode.getLevel()) {
						parentVariableStack.pop();
					}
					parentVariableStack.push(currentTreeNode);
				}
			}
			nodeStack.addAll(((TreeNode) currentNode).getNode());
		}
		// diagram.get
		return elementArray;
	}
	
	private String getVariableName(Stack<EObject> parentVariableStack, String name) {
		String variableName = "input";
		for (EObject eObject : parentVariableStack) {
			if (eObject instanceof TreeNode) {
				variableName = variableName
						+ ScriptGenerationUtil.removeInvalidCharaters(((TreeNode) eObject).getName()) + ".";
			} else if (eObject instanceof ElementImpl) {
				variableName = variableName
						+ ScriptGenerationUtil.removeInvalidCharaters(((ElementImpl) eObject).getName()) + ".";
			} else {
				throw new IllegalArgumentException("Illegal element type found : " + eObject.toString());
			}
		}
		return variableName + ScriptGenerationUtil.removeInvalidCharaters(name);
	}

	private String getTreeNodeType(TreeNode currentTreeNode) {
		EList<PropertyKeyValuePair> propertyList = currentTreeNode.getProperties();
		for (PropertyKeyValuePair propertyKeyValuePair : propertyList) {
			if ("type".equals(propertyKeyValuePair.getKey())) {
				return propertyKeyValuePair.getValue();
			}
		}
		throw new IllegalArgumentException("Type field not found in treeNode");
	}

	private boolean isArrayElement(TreeNode tempElement) {
		EList<PropertyKeyValuePair> properties = tempElement.getProperties();
		for (PropertyKeyValuePair propertyKeyValuePair : properties) {
			if ("type".equals(propertyKeyValuePair.getKey()) && "array".equals(propertyKeyValuePair.getValue())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Get namespaces as a string
	 * @param namespaces
	 * @return
	 */
	protected String getNamespacesAsString(String[] namespaces) {
		StringBuilder builder = new StringBuilder();
		for(String s : namespaces) {
		    builder.append(s);
		    builder.append(",");
		}
		return builder.length() > 0 ? builder.substring(0, builder.length() - 1): "";

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
		return new Point(620, 550);
	}

	@Override
	protected void okPressed() {
		setOkValue(true);
		setTitleValue(textTitle.getText());
		setSchemaType(comboSchemaType.getText());
		setID(textID.getText());
		setSchemaValue(textSchemaValue.getText());
		setNamespaces(textNamespaces.getText());
		setValue(comboValue.getText());
		setIdentifierType(textIdentifierType.getText());
		setIdentifierValue(textIdentifierValue.getText());
		setIdentifierURL(textIdentifierURL.getText());
		setNullable(isNullable);
		if (textInterrelatedCombo != null) {
			setInterrelatedElement(textInterrelatedCombo.getText());
		}
		if (textRootInterrelatedCombo != null) {
			setRootInterrelatedElement(textRootInterrelatedCombo.getText());
		}
		super.okPressed();
	}

	
	public void setInterrelatedElement(String interrelatedElement) {
		this.interrelatedElement = interrelatedElement;
	}
	
	public void setRootInterrelatedElement(String rootInterrelatedElement) {
		this.rootInterrelatedElement = rootInterrelatedElement;
	}

	public void setTitleValue(String title) {
		this.title = title;
	}

	public void setSchemaType(String schemaType) {
		this.schemaType = schemaType;
	}

	public void setID(String id) {
		this.id = id;
	}

	public void setSchemaValue(String schemaValue) {
		this.schemaValue = schemaValue;
	}

	public void setRequired(String required) {
		this.required = required;
	}
	
	public void setNullable(boolean isNullable) {
		this.isNullable = isNullable;
	}
	
	public void setNamespaces(String namespaces) {
		this.namespaces = namespaces;
	}
	
	
	public void setOkValue(boolean okPressed) {
		this.okPressed = okPressed;
	}

	public void setValue(String value){
		this.value = value;
	}
	public void setIdentifierType(String identifierType){
		this.identifierType = identifierType;
	}
	public void setIdentifierValue(String identifierValue){
		this.identifierValue = identifierValue;
	}
	public void setIdentifierURL(String identifierURL){
		this.identifierURL = identifierURL;
	}
	
	public String getInterrelatedElement() {
		return interrelatedElement;
	}
	public String getTitle() {
		return title;
	}

	public String getSchemaType() {
		return schemaType;
	}

	public String getID() {
		return id;
	}
	
	public boolean getNullable(){
		return isNullable;
	}

	public String getSchemaValue() {
		return schemaValue;
	}
	
	
	public String getNamespaces() {
		return namespaces;
	}

	public boolean getOkValue() {
		return okPressed;
	}

	public String getRequired() {
		return required;
	}
	
	public String getValue(){
		return value;
	}
	
	public String getIdentifierType(){
		return identifierType;
	}

	public String getIdentifierValue(){
		return identifierValue;
	}
	
	public String getIdentifierURL(){
		return identifierURL;
	}

	public String getRootInterrelatedElement() {
		return rootInterrelatedElement;
	}
}

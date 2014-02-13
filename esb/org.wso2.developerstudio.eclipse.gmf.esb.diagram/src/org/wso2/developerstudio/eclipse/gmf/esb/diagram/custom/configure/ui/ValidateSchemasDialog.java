/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateSchema;

public class ValidateSchemasDialog extends Dialog {

	private Shell parentShell;

	private Table schemaTable;

	private Button addBtn;

	private Button removeBtn;

	private TableEditor typeEditor;

	private TableEditor keyPropertyEditor;

	private Combo cmbType;

	private PropertyText keyPropertyText;
	
	private ValidateMediator validateMediatoer;

	private TransactionalEditingDomain editingDomain;

	private CompoundCommand resultCommand;

	public ValidateSchemasDialog(Shell parentShell,
			ValidateMediator validateMediator) {
		super(parentShell);

		this.validateMediatoer = validateMediator;
		this.editingDomain = TransactionUtil.getEditingDomain(validateMediator);
		this.parentShell = parentShell;

	}

	protected Control createDialogArea(Composite parent) {

		Composite container = (Composite) super.createDialogArea(parent);
		container.setSize(SWT.DEFAULT, 1000);

		// Set layout for the main container
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);

		// setting up the schema table
		schemaTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.HIDE_SELECTION);

		TableColumn keyTypeColumn = new TableColumn(schemaTable, SWT.LEFT);
		TableColumn staticKey = new TableColumn(schemaTable, SWT.LEFT);

		keyTypeColumn.setText("Key Type");
		keyTypeColumn.setWidth(150);

		staticKey.setText("Schema Key");
		staticKey.setWidth(150);

		schemaTable.setHeaderVisible(true);
		schemaTable.setLinesVisible(true);

		addBtn = new Button(container, SWT.NONE);
		addBtn.setText("Add...");
		addBtn.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {

				TableItem item = bindSchema(EsbFactory.eINSTANCE
						.createValidateSchema());
				schemaTable.select(schemaTable.indexOf(item));

			}
		});

		removeBtn = new Button(container, SWT.NONE);
		removeBtn.setText("Remove");
		removeBtn.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				int selectedIndex = schemaTable.getSelectionIndex();
				if (-1 != selectedIndex) {

					unbindSchema(selectedIndex);

					// Select the next available candidate for deletion.
					if (selectedIndex < schemaTable.getItemCount()) {
						schemaTable.select(selectedIndex);
					} else {
						schemaTable.select(selectedIndex - 1);
					}
				}

			}
		});

		Listener policyEntryTableListner = new Listener() {

			public void handleEvent(Event evt) {
				if (null != evt.item) {
					if (evt.item instanceof TableItem) {

						TableItem item = (TableItem) evt.item;
						editItem(item);

					}
				}
			}
		};

		schemaTable.addListener(SWT.Selection, policyEntryTableListner);

		for (ValidateSchema schema : validateMediatoer.getSchemas()) {

			bindSchema(schema);
		}

		setupTableEditor(schemaTable);

		// Layout related configurations
		FormData schemaTableLayoutData = new FormData(SWT.DEFAULT, 150);
		schemaTableLayoutData.top = new FormAttachment(0, 0);
		schemaTableLayoutData.left = new FormAttachment(0, 0);
		schemaTable.setLayoutData(schemaTableLayoutData);

		FormData frmData = new FormData();
		frmData.left = new FormAttachment(schemaTable, 5);
		frmData.right = new FormAttachment(100, 0);
		addBtn.setLayoutData(frmData);

		frmData = new FormData();
		frmData.top = new FormAttachment(addBtn, 5);
		frmData.left = new FormAttachment(schemaTable, 5);
		removeBtn.setLayoutData(frmData);

		return parent;

	}

	private TableItem bindSchema(ValidateSchema schema) {

		TableItem item = new TableItem(schemaTable, SWT.NONE);

		item.setText(new String[] {
				schema.getValidateSchemaKeyType().toString(),
				schema.getValidateSchemaKeyType() == KeyType.STATIC ? schema
						.getValidateStaticSchemaKey().getKeyValue() : schema
						.getValidateDynamicSchemaKey().getPropertyValue() });

		item.setData(schema);
		item.setData("staticKey",
				EsbFactory.eINSTANCE.copyRegistryKeyProperty(schema.getValidateStaticSchemaKey()));
		item.setData("dynamicKey",
				EsbFactory.eINSTANCE.copyNamespacedProperty(schema.getValidateDynamicSchemaKey()));
		return item;

	}

	private void unbindSchema(int itemIndex) {

		TableItem item = schemaTable.getItem(itemIndex);

		ValidateSchema schema = (ValidateSchema) item.getData();

		if (null != schema.eContainer()) {

			RemoveCommand reoveCmd = new RemoveCommand(editingDomain,
					validateMediatoer,
					EsbPackage.Literals.VALIDATE_MEDIATOR__SCHEMAS, schema);
			getResultCommand().append(reoveCmd);

		}

		schemaTable.remove(schemaTable.indexOf(item));

	}

	private CompoundCommand getResultCommand() {
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
	}

	private void editItem(final TableItem item) {

		final ValidateSchema schema = (ValidateSchema) item.getData();
		NamespacedProperty dynamicKey = (NamespacedProperty)item.getData("dynamicKey");
		RegistryKeyProperty staticKey = (RegistryKeyProperty)item.getData("staticKey"); 

		typeEditor = initTableEditor(typeEditor, item.getParent());
		keyPropertyEditor = initTableEditor(keyPropertyEditor, item.getParent());

		cmbType = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbType.setItems(new String[] { KeyType.STATIC.getLiteral(), KeyType.DYNAMIC.getLiteral() });
		cmbType.setText(item.getText(0));
		cmbType.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {

					item.setText(0,cmbType.getText());
			}
		});

		
		keyPropertyText = new PropertyText(item.getParent(), SWT.NONE, cmbType);
		
		keyPropertyText.addProperties(staticKey,dynamicKey);
		item.getParent().redraw();
		item.getParent().layout();
		
		keyPropertyText.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {

				item.setText(1,keyPropertyText.getText());
				Object property = keyPropertyText.getProperty();
				if(property instanceof NamespacedProperty){
					item.setData("dynamicKey",(NamespacedProperty)property);
				} else if(property instanceof RegistryKeyProperty){
					item.setData("staticKey",(RegistryKeyProperty)property);
				}
			}
		});
		
		typeEditor.setEditor(cmbType, item, 0);
		keyPropertyEditor.setEditor(keyPropertyText, item, 1);
		

	}

	private TableEditor initTableEditor(TableEditor editor, Table table) {
		if (null != editor) {
			Control lastCtrl = editor.getEditor();
			if (null != lastCtrl) {
				lastCtrl.dispose();
			}
		}
		editor = new TableEditor(table);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		return editor;
	}

	private void setupTableEditor(final Table table) {
		final TableEditor cellEditor = new TableEditor(table);
		cellEditor.grabHorizontal = true;
		cellEditor.minimumWidth = 50;
		table.addMouseListener(new MouseAdapter() {
			/**
			 * Setup a new cell editor control at double click event.
			 */
			public void mouseDoubleClick(MouseEvent e) {
				// Dispose the old editor control (if one is setup).
				Control oldEditorControl = cellEditor.getEditor();
				if (null != oldEditorControl)
					oldEditorControl.dispose();

				// Mouse location.
				Point mouseLocation = new Point(e.x, e.y);

				// Grab the selected row.
				TableItem item = (TableItem) table.getItem(mouseLocation);
				if (null == item)
					return;

				// Determine which column was selected.
				int selectedColumn = -1;
				for (int i = 0, n = table.getColumnCount(); i < n; i++) {
					if (item.getBounds(i).contains(mouseLocation)) {
						selectedColumn = i;
						break;
					}
				}

				// Setup a new editor control.
				if (-1 != selectedColumn) {
					Text editorControl = new Text(table, SWT.NONE);
					final int editorControlColumn = selectedColumn;
					editorControl.setText(item.getText(selectedColumn));
					editorControl.addModifyListener(new ModifyListener() {
						public void modifyText(ModifyEvent e) {
							Text text = (Text) cellEditor.getEditor();
							cellEditor.getItem().setText(editorControlColumn,
									text.getText());
						}
					});
					editorControl.selectAll();
					editorControl.setFocus();
					cellEditor.setEditor(editorControl, item, selectedColumn);
				}
			}

			/**
			 * Dispose cell editor control at mouse down (otherwise the control
			 * keep showing).
			 */
			public void mouseDown(MouseEvent e) {
				Control oldEditorControl = cellEditor.getEditor();
				if (null != oldEditorControl)
					oldEditorControl.dispose();
			}
		});
	}

	public void okPressed() {

		for (TableItem item : schemaTable.getItems()) {

			ValidateSchema schema = (ValidateSchema) item.getData();
			NamespacedProperty dynamicKey = (NamespacedProperty)item.getData("dynamicKey");
			RegistryKeyProperty staticKey = (RegistryKeyProperty)item.getData("staticKey"); 

			if (schema.eContainer() == null) {

				if (item.getText(0).equals(KeyType.STATIC.getLiteral())) {

					schema.setValidateSchemaKeyType(KeyType.STATIC);
					//RegistryKeyProperty regKeyProp = EsbFactory.eINSTANCE
					//		.createRegistryKeyProperty();
					//regKeyProp.setKeyValue(item.getText(1));
					schema.setValidateStaticSchemaKey(staticKey);

				} else {

					schema.setValidateSchemaKeyType(KeyType.DYNAMIC);
					//NamespacedProperty nsProp = EsbFactory.eINSTANCE
					//		.createNamespacedProperty();
					//nsProp.setPropertyValue(item.getText(1));
					schema.setValidateDynamicSchemaKey(dynamicKey);

				}

				AddCommand addCmd = new AddCommand(editingDomain,
						validateMediatoer,
						EsbPackage.Literals.VALIDATE_MEDIATOR__SCHEMAS, schema);
				getResultCommand().append(addCmd);

			} else {

				if (item.getText(0).equals(KeyType.STATIC.getLiteral())) {

					SetCommand setTypeCmd = new SetCommand(
							editingDomain,
							schema,
							EsbPackage.Literals.VALIDATE_SCHEMA__VALIDATE_SCHEMA_KEY_TYPE,
							KeyType.STATIC);
					getResultCommand().append(setTypeCmd);

					if (schema.getValidateStaticSchemaKey() != null
							&& !schema.getValidateStaticSchemaKey().equals(staticKey)) {

						SetCommand setCmd = new SetCommand(
								editingDomain,
								schema,
								EsbPackage.Literals.VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY,
								staticKey);
						getResultCommand().append(setCmd);
					}
				} else {

					SetCommand setTypeCmd = new SetCommand(
							editingDomain,
							schema,
							EsbPackage.Literals.VALIDATE_SCHEMA__VALIDATE_SCHEMA_KEY_TYPE,
							KeyType.DYNAMIC);
					getResultCommand().append(setTypeCmd);

					if (schema.getValidateDynamicSchemaKey() != null
							&& !schema.getValidateDynamicSchemaKey().equals(dynamicKey)) {

						SetCommand setCmd = new SetCommand(
								editingDomain,
								schema,
								EsbPackage.Literals.VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY,
								dynamicKey);
						getResultCommand().append(setCmd);
					}

				}

			}
		}

		// Apply changes.
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
		}

		super.okPressed();
	}
	
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Configure Schema Keys.");
	}

}

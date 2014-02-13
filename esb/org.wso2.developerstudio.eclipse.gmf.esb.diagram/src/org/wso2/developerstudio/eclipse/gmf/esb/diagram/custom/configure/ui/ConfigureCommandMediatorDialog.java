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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandPropertyContextAction;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandPropertyMessageAction;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandPropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;

public class ConfigureCommandMediatorDialog extends Dialog{

	private CommandMediator commandMediator;
	private TransactionalEditingDomain editingDomain;
	private Button newCommandPropertyButton;
	private Label commandPropertyLabel;
	private Table commandPropertyTable;
	private Button removeCommandPropertyButton;
	private CompoundCommand resultCommand;
	private TableEditor valueTypeEditor;
	private TableEditor actionEditor;
	private Combo cmbPropertyType;
	private Combo cmbAction;
	
	private static final String LITERAL = "Literal";
	private static final String MESSAGE_ELEMENT = "Message Element";
	private static final String CONTEXT_PROPERTY = "Context Property";
	private static final String READ = "Read";
	private static final String UPDATE = "Update";
	private static final String READ_AND_UPDATE = "Read And Update";

	public ConfigureCommandMediatorDialog(Shell parentShell,
			CommandMediator commandMediator, TransactionalEditingDomain editingDomain) {
		super(parentShell);
		this.commandMediator = commandMediator;
		this.editingDomain = editingDomain;
	}
	
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Command Mediator Configuration");
	}
	
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);
		
		newCommandPropertyButton = new Button(container, SWT.NONE);
		{
			newCommandPropertyButton.setText("New...");
			FormData newCommandPropertyButtonLayoutData = new FormData(80,
					SWT.DEFAULT);
			newCommandPropertyButtonLayoutData.top = new FormAttachment(
					commandPropertyLabel, 10);
			newCommandPropertyButtonLayoutData.right = new FormAttachment(100);
			newCommandPropertyButton.setLayoutData(newCommandPropertyButtonLayoutData);

			newCommandPropertyButton.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					TableItem item = bindCommandProperty(EsbFactory.eINSTANCE
							.createCommandProperty());
					commandPropertyTable.select(commandPropertyTable.indexOf(item));
				}
			});
		}
		
		removeCommandPropertyButton = new Button(container, SWT.NONE);
		{
			removeCommandPropertyButton.setText("Remove");
			FormData removeCommandPropertyButtonLayoutData = new FormData();
			removeCommandPropertyButtonLayoutData.top = new FormAttachment(
					newCommandPropertyButton, 5);
			removeCommandPropertyButtonLayoutData.right = new FormAttachment(100);
			removeCommandPropertyButtonLayoutData.left = new FormAttachment(
					newCommandPropertyButton, 0, SWT.LEFT);
			removeCommandPropertyButton
					.setLayoutData(removeCommandPropertyButtonLayoutData);

			removeCommandPropertyButton.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					int selectedIndex = commandPropertyTable.getSelectionIndex();
					if (-1 != selectedIndex) {
						unbindCommandProperty(selectedIndex);

						// Select the next available candidate for deletion.
						if (selectedIndex < commandPropertyTable.getItemCount()) {
							commandPropertyTable.select(selectedIndex);
						} else {
							commandPropertyTable.select(selectedIndex - 1);
						}
					}
				}
			});
		}
		
		commandPropertyTable = new Table(container, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
		{
			TableColumn nameColumn = new TableColumn(commandPropertyTable,
					SWT.LEFT);		
			TableColumn typeColumn = new TableColumn(commandPropertyTable,
					SWT.LEFT);
			TableColumn valueColumn = new TableColumn(commandPropertyTable,
					SWT.LEFT);
			TableColumn actionColumn = new TableColumn(commandPropertyTable,
					SWT.LEFT);
			
			nameColumn.setText("Name");
			nameColumn.setWidth(150);
			typeColumn.setText("Value  Type");
			typeColumn.setWidth(150);
			valueColumn.setText("Value");
			valueColumn.setWidth(250);
			actionColumn.setText("Action");
			actionColumn.setWidth(100);
			
			commandPropertyTable.setHeaderVisible(true);
			commandPropertyTable.setLinesVisible(true);
			commandPropertyTable.setSize(600, 400);

			Listener tblPropertiesListener = new Listener() {
				
				public void handleEvent(Event evt) {
					if (null != evt.item) {
						if (evt.item instanceof TableItem) {
							TableItem item = (TableItem) evt.item;
							editItem(item);
						}
					} 
				}
			};

			commandPropertyTable
					.addListener(SWT.Selection, tblPropertiesListener);

			// Populate properties.
			for (CommandProperty property : commandMediator.getProperties()) {
				bindCommandProperty(property);
			}

			// In-line editing of properties.
			setupTableEditor(commandPropertyTable);

			// Layout.
			FormData commandPropertyTableLayoutData = new FormData(SWT.DEFAULT,
					150);
			commandPropertyTableLayoutData.top = new FormAttachment(
					newCommandPropertyButton, 0, SWT.TOP);
			commandPropertyTableLayoutData.left = new FormAttachment(0);
			commandPropertyTableLayoutData.right = new FormAttachment(
					newCommandPropertyButton, -5);
			commandPropertyTableLayoutData.bottom = new FormAttachment(100);
			commandPropertyTable.setLayoutData(commandPropertyTableLayoutData);
		}

		return container;
	}
	
	private TableItem bindCommandProperty(CommandProperty property) {
		TableItem item = new TableItem(commandPropertyTable, SWT.NONE);
		if (property.getValueType().equals(CommandPropertyValueType.MESSAGE_ELEMENT)) {
			if(null!=property.getValueMessageElementXpath()){
				item.setText(new String[] { property.getPropertyName(),
						MESSAGE_ELEMENT,
						property.getValueMessageElementXpath().getPropertyValue(),
						getActionCaption(property)});
			}
		} else if (property.getValueType().equals(CommandPropertyValueType.CONTEXT_PROPERTY)) {
			if(null!=property.getValueContextPropertyName()){
				item.setText(new String[] { property.getPropertyName(),
						CONTEXT_PROPERTY,
						property.getValueContextPropertyName(),
						getActionCaption(property)});
			}
		} else {
			item.setText(new String[] { property.getPropertyName(),
					LITERAL,
					property.getValueLiteral()});
		}

		item.setData(property);
		return item;
	}
	
	private String getActionCaption(CommandProperty property) {
		String caption = "";
		if (property.getValueType().equals(CommandPropertyValueType.MESSAGE_ELEMENT)) {
			CommandPropertyMessageAction messageAction = property.getMessageAction();
			if (messageAction.equals(CommandPropertyMessageAction.READ_AND_UPDATE_MESSAGE)) {
				caption = READ_AND_UPDATE;
			} else if (messageAction.equals(CommandPropertyMessageAction.UPDATE_MESSAGE)) {
				caption = UPDATE;
			} else {
				caption = READ;
			}
		} else if (property.getValueType().equals(CommandPropertyValueType.CONTEXT_PROPERTY)) {
			CommandPropertyContextAction contextAction = property.getContextAction();
			if (contextAction.equals(CommandPropertyContextAction.READ_AND_UPDATE_CONTEXT)) {
				caption = READ_AND_UPDATE;
			} else if (contextAction.equals(CommandPropertyContextAction.UPDATE_CONTEXT)) {
				caption = UPDATE;
			} else {
				caption = READ;
			}
		}
		return caption;
	}
	
	private void unbindCommandProperty(int itemIndex) {
		TableItem item = commandPropertyTable.getItem(itemIndex);
		CommandProperty property = (CommandProperty) item.getData();
		if (null != property.eContainer()) {
			RemoveCommand removeCmd = new RemoveCommand(editingDomain,
					commandMediator, EsbPackage.Literals.COMMAND_MEDIATOR__PROPERTIES,
					property);
			getResultCommand().append(removeCmd);
		}
		commandPropertyTable.remove(commandPropertyTable.indexOf(item));
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
	
	private void editItem(final TableItem item) {		
		valueTypeEditor = initTableEditor(valueTypeEditor, item.getParent());
		cmbPropertyType = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbPropertyType.setItems(new String[] { LITERAL, MESSAGE_ELEMENT, CONTEXT_PROPERTY });
		cmbPropertyType.setText(item.getText(1));
		valueTypeEditor.setEditor(cmbPropertyType, item, 1);

		if(!LITERAL.equalsIgnoreCase(item.getText(1))){
			actionEditor = initTableEditor(actionEditor, item.getParent());
			cmbAction = new Combo(item.getParent(), SWT.READ_ONLY);
			cmbAction.setItems(new String[] { READ, UPDATE,
					READ_AND_UPDATE });
			cmbAction.setText(item.getText(3));
			actionEditor.setEditor(cmbAction, item, 3);
			item.getParent().redraw();
			item.getParent().layout();
			
			cmbAction.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event evt) {
					item.setText(3, cmbAction.getText());
				}
			});
		}
		
		cmbPropertyType.addListener(SWT.Selection, new Listener() {			
			public void handleEvent(Event evt) {
				item.setText(1, cmbPropertyType.getText());
				if(LITERAL.equalsIgnoreCase(cmbPropertyType.getText())){
					item.setText(3,"");
					if(cmbAction!=null){
						cmbAction.setEnabled(false);
					}
				} else{
					if(cmbAction!=null){
						cmbAction.setEnabled(true);
					}
				}
			}
		});
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
	
	protected void okPressed() {
		
		for (TableItem item : commandPropertyTable.getItems()) {
			CommandProperty property = (CommandProperty) item.getData();

			// If the property is a new one, add it to the model.
			if (null == property.eContainer()) {
				// Update the log property with the latest data from table row.
				property.setPropertyName(item.getText(0));

				if (CONTEXT_PROPERTY.equalsIgnoreCase(item.getText(1))) {
					property.setValueContextPropertyName(item.getText(2));
					property.setValueType(CommandPropertyValueType.CONTEXT_PROPERTY);
					CommandPropertyContextAction contextAction= CommandPropertyContextAction.READ_CONTEXT;
					if (READ_AND_UPDATE.equalsIgnoreCase(item.getText(3))) {
						contextAction= CommandPropertyContextAction.READ_AND_UPDATE_CONTEXT;
					} else if (UPDATE.equalsIgnoreCase(item.getText(3))) {
						contextAction= CommandPropertyContextAction.UPDATE_CONTEXT;
					}		
					property.setContextAction(contextAction);
					
				} else if (MESSAGE_ELEMENT.equalsIgnoreCase(item.getText(1))) {
					property.setValueType(CommandPropertyValueType.MESSAGE_ELEMENT);
					NamespacedProperty namespaceProperty = EsbFactoryImpl.eINSTANCE
							.createNamespacedProperty();
					namespaceProperty.setPropertyValue(item.getText(2));
					property.setValueMessageElementXpath(namespaceProperty);
					CommandPropertyMessageAction messageAction = CommandPropertyMessageAction.READ_MESSAGE;
					if (READ_AND_UPDATE.equalsIgnoreCase(item.getText(3))) {
						messageAction = CommandPropertyMessageAction.READ_AND_UPDATE_MESSAGE;
					} else if (UPDATE.equalsIgnoreCase(item.getText(3))) {
						messageAction = CommandPropertyMessageAction.UPDATE_MESSAGE;
					} 
					property.setMessageAction(messageAction);
				} else{
					property.setValueType(CommandPropertyValueType.LITERAL);
					property.setValueLiteral(item.getText(2));
				}

				// Record the add operation.
				AddCommand addCmd = new AddCommand(editingDomain, commandMediator,
						EsbPackage.Literals.COMMAND_MEDIATOR__PROPERTIES, property);
				getResultCommand().append(addCmd);
			} else {
				// If the property name needs to be updated.
				if (!property.getPropertyName().equals(item.getText(0))) {
					SetCommand setCmd = new SetCommand(
							editingDomain,
							property,
							EsbPackage.Literals.COMMAND_PROPERTY__PROPERTY_NAME,
							item.getText(0));
					getResultCommand().append(setCmd);
				}
				
				if (CONTEXT_PROPERTY.equalsIgnoreCase(item.getText(1))) {
					SetCommand setCmd = new SetCommand(
							editingDomain,
							property,
							EsbPackage.Literals.COMMAND_PROPERTY__VALUE_TYPE,
							CommandPropertyValueType.CONTEXT_PROPERTY);
					getResultCommand().append(setCmd);
					
					if (!property.getValueContextPropertyName().equals(item.getText(2))) {
						setCmd = new SetCommand(
								editingDomain,
								property,
								EsbPackage.Literals.COMMAND_PROPERTY__VALUE_CONTEXT_PROPERTY_NAME,
								item.getText(2));
						getResultCommand().append(setCmd);
					}
					CommandPropertyContextAction contextAction= CommandPropertyContextAction.READ_CONTEXT;
					if (READ_AND_UPDATE.equalsIgnoreCase(item.getText(3))) {
						contextAction= CommandPropertyContextAction.READ_AND_UPDATE_CONTEXT;
					} else if (UPDATE.equalsIgnoreCase(item.getText(3))) {
						contextAction= CommandPropertyContextAction.UPDATE_CONTEXT;
					} 
					setCmd = new SetCommand(
							editingDomain,
							property,
							EsbPackage.Literals.COMMAND_PROPERTY__CONTEXT_ACTION,
							contextAction);
					getResultCommand().append(setCmd);
					
				} else if (MESSAGE_ELEMENT.equalsIgnoreCase(item.getText(1))) {
					SetCommand setCmd = new SetCommand(
							editingDomain,
							property,
							EsbPackage.Literals.COMMAND_PROPERTY__VALUE_TYPE,
							CommandPropertyValueType.MESSAGE_ELEMENT);
					getResultCommand().append(setCmd);
					
					if (property.getValueMessageElementXpath() == null) {
						NamespacedProperty namespaceProperty = EsbFactoryImpl.eINSTANCE
								.createNamespacedProperty();
						namespaceProperty.setPropertyValue(item.getText(2));
						SetCommand addCmd = new SetCommand(editingDomain, property,
						EsbPackage.Literals.COMMAND_PROPERTY__VALUE_MESSAGE_ELEMENT_XPATH,
						namespaceProperty);
				getResultCommand().append(addCmd);
					} else {
						setCmd = new SetCommand(editingDomain,
								property.getValueMessageElementXpath(),
								EsbPackage.Literals.NAMESPACED_PROPERTY__PROPERTY_VALUE,
								item.getText(2));
						getResultCommand().append(setCmd);
					}
					CommandPropertyMessageAction messageAction = CommandPropertyMessageAction.READ_MESSAGE;
					if (READ_AND_UPDATE.equalsIgnoreCase(item.getText(3))) {
						messageAction = CommandPropertyMessageAction.READ_AND_UPDATE_MESSAGE;
					} else if (UPDATE.equalsIgnoreCase(item.getText(3))) {
						messageAction = CommandPropertyMessageAction.UPDATE_MESSAGE;
					} 
					setCmd = new SetCommand(
							editingDomain,
							property,
							EsbPackage.Literals.COMMAND_PROPERTY__MESSAGE_ACTION,
							messageAction);
					getResultCommand().append(setCmd);
				} else{
					SetCommand setCmd = new SetCommand(
							editingDomain,
							property,
							EsbPackage.Literals.COMMAND_PROPERTY__VALUE_TYPE,
							CommandPropertyValueType.LITERAL);
					getResultCommand().append(setCmd);
					
					if (!property.getValueLiteral().equals(item.getText(2))) {
						setCmd = new SetCommand(
								editingDomain,
								property,
								EsbPackage.Literals.COMMAND_PROPERTY__VALUE_LITERAL,
								item.getText(2));
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
	
	private CompoundCommand getResultCommand() {
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
	}
	
	@Override
	protected Point getInitialSize() {
		return new Point(800,400);
	}



}

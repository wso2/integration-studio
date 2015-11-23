/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
import org.wso2.developerstudio.eclipse.gmf.esb.ClassMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ClassProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

/**
 * Dialog used to configure {@link ClassMediator} nodes.
 */
public class ConfigureClassMediatorDialog extends Dialog {		
	/**
	 * {@link ClassMediator} domain object.
	 */
	private ClassMediator classMediator;
	

	private Label classNameLabel;
	
	/**
	 * Class name text.
	 */
	private Text classNameText;		
	
	/**
	 * Class mediator properties label.
	 */
	private Label classPropertiesLabel;
	
	/**
	 * Button for adding a new property.
	 */
	private Button newClassPropertyButton;
	
	/**
	 * Button for deleting an existing property.
	 */
	private Button removeClassPropertyButton;
	
	/**
	 * Table of properties.
	 */
	private Table classPropertiesTable;	
	
	/**
	 * Editing domain.
	 */
	private TransactionalEditingDomain editingDomain;
	
	/**
	 * Command for recording user operations.
	 */
	private CompoundCommand resultCommand;
	
	/**
	 * Creates a new {@link ConfigureClassMediatorDialog} instance.
	 * 
	 * @param parentShell parent shell.
	 */
	public ConfigureClassMediatorDialog(Shell parentShell, ClassMediator classMediator,
			TransactionalEditingDomain editingDomain) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE); 
		this.classMediator = classMediator;
		this.editingDomain = editingDomain;
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
				
		// Set title.
		newShell.setText("Class Mediator Configuration");
	}

	/**
	 * {@inheritDoc}
	 */
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);		

		
		classNameLabel = new Label(container, SWT.None);
		{
			classNameLabel.setText("Class Name: ");
			FormData classNameLabelLayoutData = new FormData();
			classNameLabelLayoutData.top = new FormAttachment(0,5);
			classNameLabelLayoutData.left = new FormAttachment(0);
			classNameLabel.setLayoutData(classNameLabelLayoutData);
		}	
		
		classNameText = new Text(container, SWT.SINGLE | SWT.BORDER);
		{
			classNameText.setText(classMediator.getClassName());
			FormData classNameTextLayoutData = new FormData(300, SWT.DEFAULT);
			classNameTextLayoutData.top = new FormAttachment(classNameLabel, 0, SWT.CENTER);
			classNameTextLayoutData.left = new FormAttachment(classNameLabel, 5);
			classNameTextLayoutData.right = new FormAttachment(100, -5);
			classNameText.setLayoutData(classNameTextLayoutData);
		}
		
		
		
		classPropertiesLabel = new Label(container, SWT.NONE);
		{
			classPropertiesLabel.setText("Properties:");
			FormData classPropertiesLabelLayoutData = new FormData();
			classPropertiesLabelLayoutData.top = new FormAttachment(classNameText, 10);
			classPropertiesLabelLayoutData.left = new FormAttachment(0);
			classPropertiesLabel.setLayoutData(classPropertiesLabelLayoutData);
		}
		
		newClassPropertyButton = new Button(container, SWT.NONE);
		{
			newClassPropertyButton.setText("New...");
			FormData newClassPropertyButtonLayoutData = new FormData(80, SWT.DEFAULT);
			newClassPropertyButtonLayoutData.top = new FormAttachment(classPropertiesLabel, 10);
			newClassPropertyButtonLayoutData.right = new FormAttachment(100);
			newClassPropertyButton.setLayoutData(newClassPropertyButtonLayoutData);
			
			newClassPropertyButton.addListener(SWT.Selection, new Listener() {				
				public void handleEvent(Event event) {
					TableItem item = bindClassProperty(EsbFactory.eINSTANCE.createClassProperty());					
					classPropertiesTable.select(classPropertiesTable.indexOf(item));
				}
			});
		}
		
		removeClassPropertyButton = new Button(container, SWT.NONE);
		{
			removeClassPropertyButton.setText("Remove");
			FormData removeClassPropertyButtonLayoutData = new FormData();
			removeClassPropertyButtonLayoutData.top = new FormAttachment(newClassPropertyButton, 5);
			removeClassPropertyButtonLayoutData.right = new FormAttachment(100);
			removeClassPropertyButtonLayoutData.left = new FormAttachment(newClassPropertyButton, 0, SWT.LEFT);
			removeClassPropertyButton.setLayoutData(removeClassPropertyButtonLayoutData);
			
			removeClassPropertyButton.addListener(SWT.Selection, new Listener() {				
				public void handleEvent(Event event) {
					int selectedIndex = classPropertiesTable.getSelectionIndex();
					if (-1 != selectedIndex) {
						unbindClassProperty(selectedIndex);
						
						// Select the next available candidate for deletion.
						if (selectedIndex < classPropertiesTable.getItemCount()) {
							classPropertiesTable.select(selectedIndex);
						} else {
							classPropertiesTable.select(selectedIndex - 1);
						}
					}					
				}
			});
		}
		
		classPropertiesTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
		{
			TableColumn nameColumn = new TableColumn(classPropertiesTable, SWT.LEFT);
			TableColumn valueColumn = new TableColumn(classPropertiesTable, SWT.LEFT);
			nameColumn.setText("Name");
			nameColumn.setWidth(150);			
			valueColumn.setText("Value");
			valueColumn.setWidth(200); 			
			classPropertiesTable.setHeaderVisible(true);
			classPropertiesTable.setLinesVisible(true);
			
			// Populate properties.
			for (ClassProperty property : classMediator.getProperties()) {
				bindClassProperty(property);
			}
			
			// In-line editing of properties.
			setupTableEditor(classPropertiesTable);
			
			// Layout.
			FormData classPropertiesTableLayoutData = new FormData(SWT.DEFAULT, 150);
			classPropertiesTableLayoutData.top = new FormAttachment(newClassPropertyButton, 0, SWT.TOP);
			classPropertiesTableLayoutData.left = new FormAttachment(0);
			classPropertiesTableLayoutData.right = new FormAttachment(newClassPropertyButton, -5);
			classPropertiesTableLayoutData.bottom = new FormAttachment(100);
			classPropertiesTable.setLayoutData(classPropertiesTableLayoutData);
		}
		
		return container;
	}	
	
	/**
	 * Sets up a table editor that allows users to edit cell values inline.
	 * 
	 * @param table table against which a table editor is setup.
	 */
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
				if (null != oldEditorControl) oldEditorControl.dispose();					
				
				// Mouse location.
				Point mouseLocation = new Point(e.x, e.y);
				
				// Grab the selected row.					
				TableItem item = (TableItem) table.getItem(mouseLocation);
				if (null == item) return;
				
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
							cellEditor.getItem().setText(editorControlColumn, text.getText());
						}
					});
					editorControl.selectAll();
					editorControl.setFocus();
					cellEditor.setEditor(editorControl, item, selectedColumn);
				}										
			}	
			
			/**
			 * Dispose cell editor control at mouse down (otherwise the control keep showing).
			 */
			public void mouseDown(MouseEvent e) {
				Control oldEditorControl = cellEditor.getEditor();
				if (null != oldEditorControl) oldEditorControl.dispose();		
			}
		});
	}		
	
	/**
	 * {@inheritDoc}
	 */
	protected void okPressed() {		
		
		// Class name.
		String className = classNameText.getText();
		if (!className.equals(classMediator.getClassName())) {
			SetCommand setCmd = new SetCommand(editingDomain, classMediator,
					EsbPackage.Literals.CLASS_MEDIATOR__CLASS_NAME, className);
			getResultCommand().append(setCmd);
		}
		
		// Class properties.
		for (TableItem item : classPropertiesTable.getItems()) {
			ClassProperty property = (ClassProperty) item.getData();
			
			// If the property is a new one, add it to the model.
			if (null == property.eContainer()) {
				// Update the class property with the latest data from table row.
				property.setPropertyName(item.getText(0));
				property.setPropertyValue(item.getText(1));
				
				// Record the add operation.
				AddCommand addCmd = new AddCommand(editingDomain, classMediator,
						EsbPackage.Literals.CLASS_MEDIATOR__PROPERTIES, property);
				getResultCommand().append(addCmd);
			} else {
				// If the property name needs to be updated.
				if (!property.getPropertyName().equals(item.getText(0))) {
					SetCommand setCmd = new SetCommand(editingDomain, property,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_PROPERTY__PROPERTY_NAME, item.getText(0));
					getResultCommand().append(setCmd);
				}
				
				// If the property value needs to be updated.
				if (!property.getPropertyValue().equals(item.getText(1))) {
					SetCommand setCmd = new SetCommand(editingDomain, property,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_PROPERTY__PROPERTY_VALUE, item.getText(1));
					getResultCommand().append(setCmd);
				}
			}
		}
		
		// Apply changes.
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
		}
		
		super.okPressed();
	}

	/**
	 * Utility method for binding a class property into the UI. Note that this
	 * method does not record any commands, it simply adds a new row into the
	 * table and associates the passed {@link ClassProperty} to it.
	 * 
	 * @return {@link TableItem} which was introduced.
	 */
	private TableItem bindClassProperty(ClassProperty property) {
		TableItem item = new TableItem(classPropertiesTable, SWT.NONE);
		item.setText(new String [] {property.getPropertyName(), property.getPropertyValue()});
		item.setData(property);
		return item;
	}

	/**
	 * Removes the corresponding table item from the table and records a command
	 * for detaching the corresponding class property from the model.
	 * 
	 * @param itemIndex index of the row which is to be removed.
	 */
	private void unbindClassProperty(int itemIndex) {
		TableItem item = classPropertiesTable.getItem(itemIndex);
		ClassProperty property = (ClassProperty) item.getData();
		// If the property is part of the model, record a command for getting rid of it.
		if (null != property.eContainer()) {
			RemoveCommand removeCmd = new RemoveCommand(editingDomain, classMediator,
					EsbPackage.Literals.CLASS_MEDIATOR__PROPERTIES, property);
			getResultCommand().append(removeCmd);
		}
		classPropertiesTable.remove(classPropertiesTable.indexOf(item));
	}
	
	/**
	 * Utility method for retrieving the result {@link CompoundCommand} which is
	 * used to record user operations.
	 * 
	 * @return result command.
	 */
	private CompoundCommand getResultCommand() {
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
	}
}

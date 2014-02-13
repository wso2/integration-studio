/*
 * Copyright 2013 WSO2, Inc. (http://wso2.com)
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
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateResource;

public class ConfigureValidateResourceDialog extends Dialog {

	private Table resourcesTable;
	
	private Button addBtn;

	private Button removeBtn;
	
	private TransactionalEditingDomain editingDomain;

	private ValidateMediator validateMediator;
	
	private CompoundCommand resultCommand;
	
	private TableEditor locationEditor;
	
	private TableEditor keyPropertyEditor;
	
	private Text txtLocation;
	
	private PropertyText keyPropertyText;
	
	public ConfigureValidateResourceDialog(Shell parentShell,
			ValidateMediator validateMediator) {
		super(parentShell);
		this.validateMediator = validateMediator;
		this.editingDomain = TransactionUtil.getEditingDomain(validateMediator);
	}
	
	protected Control createDialogArea(Composite parent){
		
		Composite container = (Composite) super.createDialogArea(parent);
		container.setSize(SWT.DEFAULT, 1000);

		// Set layout for the main container
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);

		// setting up the resource table
		resourcesTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.HIDE_SELECTION);

		TableColumn location = new TableColumn(resourcesTable, SWT.LEFT);
		TableColumn staticKey = new TableColumn(resourcesTable, SWT.LEFT);
		
		location.setText("Location");
		location.setWidth(150);
		
		staticKey.setText("Key");
		staticKey.setWidth(150);

		resourcesTable.setHeaderVisible(true);
		resourcesTable.setLinesVisible(true);

		addBtn = new Button(container, SWT.NONE);
		addBtn.setText("Add...");
		addBtn.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {

				TableItem item = bindResource(EsbFactory.eINSTANCE.createValidateResource());
				resourcesTable.select(resourcesTable.indexOf(item));

			}
		});

		removeBtn = new Button(container, SWT.NONE);
		removeBtn.setText("Remove");
		removeBtn.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				int selectedIndex = resourcesTable.getSelectionIndex();
				if (-1 != selectedIndex) {

					initTableEditor(locationEditor, resourcesTable);
					initTableEditor(keyPropertyEditor, resourcesTable);
					
					unbindResource(selectedIndex);

					// Select the next available candidate for deletion.
					if (selectedIndex < resourcesTable.getItemCount()) {
						resourcesTable.select(selectedIndex);
					} else {
						resourcesTable.select(selectedIndex - 1);
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

		resourcesTable.addListener(SWT.Selection, policyEntryTableListner);

		for (ValidateResource resource : validateMediator.getResources()) {

			bindResource(resource);
		}

		setupTableEditor(resourcesTable);

		// Layout related configurations
		FormData schemaTableLayoutData = new FormData(SWT.DEFAULT, 150);
		schemaTableLayoutData.top = new FormAttachment(0, 0);
		schemaTableLayoutData.left = new FormAttachment(0, 0);
		resourcesTable.setLayoutData(schemaTableLayoutData);

		FormData frmData = new FormData();
		frmData.left = new FormAttachment(resourcesTable, 5);
		frmData.right = new FormAttachment(100, 0);
		addBtn.setLayoutData(frmData);

		frmData = new FormData();
		frmData.top = new FormAttachment(addBtn, 5);
		frmData.left = new FormAttachment(resourcesTable, 5);
		removeBtn.setLayoutData(frmData);

		return parent;
		
	}
	
	private TableItem bindResource(ValidateResource resource) {

		TableItem item = new TableItem(resourcesTable, SWT.NONE);
		item.setText(new String[] {resource.getLocation(),resource.getKey().getKeyValue() });
		item.setData(resource);
		item.setData("staticKey",EsbFactory.eINSTANCE.copyRegistryKeyProperty(resource.getKey()));
		return item;
	}
	
	private void unbindResource(int selectedIndex) {

		TableItem item = resourcesTable.getItem(selectedIndex);

		ValidateResource resource = (ValidateResource) item.getData();

		if (null != resource.eContainer()) {

			RemoveCommand reoveCmd = new RemoveCommand(editingDomain,
					validateMediator,
					EsbPackage.Literals.VALIDATE_MEDIATOR__RESOURCES, resource);
			getResultCommand().append(reoveCmd);

		}

		resourcesTable.remove(resourcesTable.indexOf(item));

	}
	
	private CompoundCommand getResultCommand() {
		
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
	}
	
	private void editItem(final TableItem item) {
		
		locationEditor = initTableEditor(locationEditor, item.getParent());
		txtLocation = new Text(item.getParent(), SWT.NONE);
		txtLocation.setText(item.getText(0));
		locationEditor.setEditor(txtLocation, item, 0);
		item.getParent().redraw();
		item.getParent().layout();
		txtLocation.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				item.setText(0,txtLocation.getText());
			}
		});
		
		RegistryKeyProperty staticKey = (RegistryKeyProperty)item.getData("staticKey"); 
		keyPropertyEditor = initTableEditor(keyPropertyEditor, item.getParent());
		
		keyPropertyText = new PropertyText(item.getParent(), SWT.NONE);
		
		keyPropertyText.addProperties(staticKey);
		keyPropertyEditor.setEditor(keyPropertyText, item, 1);
		item.getParent().redraw();
		item.getParent().layout();
		
		keyPropertyText.addModifyListener(new ModifyListener() {		
			public void modifyText(ModifyEvent e) {
				item.setText(1, keyPropertyText.getText());
				Object property = keyPropertyText.getProperty();
				if(property instanceof RegistryKeyProperty){
					item.setData("staticKey",(RegistryKeyProperty)property);
				} 
			}
		});
		
		/*item.setText(1,keyPropertyText.getText());
		Object property = keyPropertyText.getProperty();

		if(property instanceof RegistryKeyProperty){
			item.setData("staticKey",(RegistryKeyProperty)property);
		}
		
		keyPropertyEditor.setEditor(keyPropertyText, item, 1);*/
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
		
		for(TableItem item : resourcesTable.getItems() ){
			
			ValidateResource resource = (ValidateResource)item.getData();
			RegistryKeyProperty staticKey = (RegistryKeyProperty)item.getData("staticKey"); 
			
			if(resource.eContainer() == null){
				
				resource.setLocation(item.getText(0));
				
				resource.setKey(staticKey);
				
				AddCommand addCmd = new AddCommand(editingDomain,
						validateMediator,
						EsbPackage.Literals.VALIDATE_MEDIATOR__RESOURCES,
						resource);
				getResultCommand().append(addCmd);
				
			}else{
				
				if(!item.getText(0).equals(resource.getLocation())){
					SetCommand setTypeCmd = new SetCommand(
							editingDomain,
							resource,
							EsbPackage.Literals.ABSTRACT_LOCATION_KEY_RESOURCE__LOCATION,
							item.getText(0));
					getResultCommand().append(setTypeCmd);
					
				}
				
				if(!item.getText(1).equals(resource.getKey().getKeyValue())){
					
					SetCommand setTypeCmd = new SetCommand(
							editingDomain,
							resource,
							EsbPackage.Literals.ABSTRACT_LOCATION_KEY_RESOURCE__KEY,
							staticKey);
					getResultCommand().append(setTypeCmd);
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
		shell.setText("Configure Resources.");
	}
	
}

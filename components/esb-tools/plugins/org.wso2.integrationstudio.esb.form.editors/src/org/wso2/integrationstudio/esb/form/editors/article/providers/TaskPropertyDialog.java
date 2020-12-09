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

package org.wso2.integrationstudio.esb.form.editors.article.providers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
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
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.TaskProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.TaskPropertyType;

public class TaskPropertyDialog extends Dialog {

	private boolean defaultESBtask;
	private static final String LITERAL = "LITERAL";
	private List<TaskProperty> taskPropertyList = new ArrayList<TaskProperty>();
	private List<TaskProperty> removedPropertyList = new ArrayList<TaskProperty>();
	private boolean newButtonSelected = false;
	/**
	 * Table for add/edit/remove parameters.
	 */
	private Table propertyTable;
	/**
	 * Table Editor for inline property edit
	 */
	private TableEditor propertyTypeEditor;
	/**
	 * Combo box for select parameter type.
	 */
	private Combo cmbPropertyType;
	/**
	 * Button for add new parameter.
	 */
	private Button newPropertyButton;
	/**
	 * Button for remove parameter.
	 */
	private Button removePropertyButton;
	/**
	 * Command for recording user operations.
	 */
	private CompoundCommand resultCommand;

	private String[] properties = {
			"format", "message", "soapAction", "to", "proxyName", "sequenceName", "injectTo", "registryKey"	};

	public TaskPropertyDialog(Shell parentShell, String taskImpel, List<TaskProperty> list) {
		super(parentShell);
		// When updating an existing property, then get the property list
		if (list != null) {
			taskPropertyList = list;
		} else {
			// When adding properties initially, create a new list
			list = new ArrayList<TaskProperty>();
		}
		defaultESBtask = (taskImpel.equals("org.apache.synapse.startup.tasks.MessageInjector"));
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Task Properties");
	}

	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);

		// Button for add new parameter.
		newPropertyButton = new Button(container, SWT.NONE);
		newPropertyButton.setText("New...");
		FormData newTaskPropertyButtonLayoutData = new FormData(80, SWT.DEFAULT);
		newTaskPropertyButtonLayoutData.right = new FormAttachment(100);
		newPropertyButton.setLayoutData(newTaskPropertyButtonLayoutData);

		newPropertyButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				TaskProperty taskProperty = EsbFactory.eINSTANCE.createTaskProperty();
				taskProperty.setPropertyName("New Property");
				TableItem item = bindPram(taskProperty);
				propertyTable.select(propertyTable.indexOf(item));
				newButtonSelected = true;
			}
		});

		// Enable new button
		enableNewButton();

		// Button for remove Property.
		removePropertyButton = new Button(container, SWT.NONE);
		removePropertyButton.setText("Remove");
		FormData removeTaskPropertyButtonLayoutData = new FormData();
		removeTaskPropertyButtonLayoutData.top = new FormAttachment(newPropertyButton, 5);
		removeTaskPropertyButtonLayoutData.right = new FormAttachment(100);
		removeTaskPropertyButtonLayoutData.left = new FormAttachment(newPropertyButton, 0, SWT.LEFT);
		removePropertyButton.setLayoutData(removeTaskPropertyButtonLayoutData);

		removePropertyButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				int selectedIndex = propertyTable.getSelectionIndex();
				if (-1 != selectedIndex) {
					unbindParam(selectedIndex);

					// Select the next available candidate for deletion.
					if (selectedIndex < propertyTable.getItemCount()) {
						propertyTable.select(selectedIndex);
					} else {
						propertyTable.select(selectedIndex - 1);
					}
				}
			}
		});

		// Table for show the parameters.
		propertyTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION | SWT.HIDE_SELECTION);

		TableColumn nameColumn = new TableColumn(propertyTable, SWT.LEFT);
		TableColumn typeColumn = new TableColumn(propertyTable, SWT.LEFT);
		TableColumn valueColumn = new TableColumn(propertyTable, SWT.LEFT);

		nameColumn.setText("Parameter Name");
		nameColumn.setWidth(150);
		valueColumn.setText("Value/Expression");
		valueColumn.setWidth(200);
		typeColumn.setText("Parameter Type");
		typeColumn.setWidth(150);

		propertyTable.setHeaderVisible(true);
		propertyTable.setLinesVisible(true);

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

		propertyTable.addListener(SWT.Selection, tblPropertiesListener);

			// When updating an existing property
		if (taskPropertyList.size() > 0) {
			if (defaultESBtask) {
				List<TaskProperty> missingProperties = getMissingProperties();
				if (missingProperties != null) {
					taskPropertyList.addAll(missingProperties);
				}
			}
			for (TaskProperty property : taskPropertyList) {
				if (!defaultESBtask && taskPropertyList.size() >= properties.length) {
					boolean isExist = false;
					for (int i = 0; i < properties.length; i++) {
						if (properties[i].equals(property.getPropertyName())) {
							isExist = true;
							break;
						}
					}
					if (!isExist) {
						bindPram(property);
					}
				} else {
				    bindPram(property);
				}
			}
		} else if (defaultESBtask) {
			// when adding properties for the first time
			for (int i = 0; i < properties.length; i++) {
				bindPram(properties[i]);
			}
		}

		setupTableEditor(propertyTable);

		FormData taskPropertiesTableLayoutData = new FormData(SWT.DEFAULT, 150);
		taskPropertiesTableLayoutData.top = new FormAttachment(newPropertyButton, 0, SWT.TOP);
		taskPropertiesTableLayoutData.left = new FormAttachment(0);
		taskPropertiesTableLayoutData.right = new FormAttachment(newPropertyButton, -5);
		taskPropertiesTableLayoutData.bottom = new FormAttachment(100);
		propertyTable.setLayoutData(taskPropertiesTableLayoutData);

		return parent;

	}

	/**
	 * Get missing required properties
	 */
	private List<TaskProperty> getMissingProperties() {
		List<TaskProperty> newList = new ArrayList<TaskProperty>();
		for (String prop : properties) {
			boolean isAvailable = false;
			for (TaskProperty property : taskPropertyList) {
				if (prop.equals(property.getPropertyName())) {
					isAvailable = true;
					break;
				}
			}
			if (!isAvailable) {
				TaskProperty tskProperty = createProperty(prop);
				newList.add(tskProperty);
			}
		}
		return newList;
	}

	/**
	 * Creates a new property
	 * 
	 * @param name
	 * @return
	 */
	private TaskProperty createProperty(String name) {
		TaskProperty newPrp = EsbFactory.eINSTANCE.createTaskProperty();
		newPrp.setPropertyName(name);
		newPrp.setPropertyType(TaskPropertyType.LITERAL);
		newPrp.setPropertyValue(null);
		return newPrp;
	}

	/**
	 * Enable and disable the New button based on the property values
	 */
	private void enableNewButton() {
		if (taskPropertyList.size() > 0) {
			String[] checkProperties = new String[taskPropertyList.size()];
			for (int i = 0; i < taskPropertyList.size(); i++) {
				checkProperties[i] = String.valueOf(taskPropertyList.get(i).getPropertyName());
			}
			Arrays.sort(checkProperties);
			Arrays.sort(properties);
			if (!Arrays.equals(checkProperties, properties)) {
				// Enable New button if required properties are missing
				newPropertyButton.setEnabled(true);
				newButtonSelected = true;
			} else {
				newPropertyButton.setEnabled(false);
			}
		} else if (!defaultESBtask) {
			// Enable the button for the custom task
			newPropertyButton.setEnabled(true);
		} else {
			// Disable the button when adding properties for the first time
			newPropertyButton.setEnabled(false);
		}
	}

	protected void okPressed() {

		for (TableItem item : propertyTable.getItems()) {
			TaskProperty param = null;

			if (item.getData() == null) {
				param = EsbFactory.eINSTANCE.createTaskProperty();
				param.setPropertyName(item.getText(0));

				if (item.getText(1).equals(TaskPropertyType.LITERAL.toString())) {
					param.setPropertyValue(item.getText(2));
					param.setPropertyType(TaskPropertyType.LITERAL);
				}

				if (item.getText(1).equals(TaskPropertyType.XML.toString())) {
					param.setPropertyValue(item.getText(2));
					param.setPropertyType(TaskPropertyType.XML);
				}
			} else {
				param = (TaskProperty) item.getData();
				param.setPropertyName(item.getText(0));

				if (item.getText(1).equals(TaskPropertyType.LITERAL.toString())) {
					param.setPropertyValue(item.getText(2));
					param.setPropertyType(TaskPropertyType.LITERAL);
				}

				if (item.getText(1).equals(TaskPropertyType.XML.toString())) {
					param.setPropertyValue(item.getText(2));
					param.setPropertyType(TaskPropertyType.XML);
				}
			}

			for (TaskProperty propertyItem : taskPropertyList) {
				// When updating the existing properties, remove the old
				// property
				if (propertyItem.getPropertyName().equals(param.getPropertyName())) {
					taskPropertyList.remove(propertyItem);
					break;
				}
			}

			taskPropertyList.add(param);
		}
		if (removedPropertyList.size() > 0) {
			removedPropertyList.clear();
		}
		setTaskPropertyList(taskPropertyList);
		finalizeDefaultMessageInjecttorTask();
		super.okPressed();

	}

	public void setTaskPropertyList(List<TaskProperty> taskPropertyList) {
		this.taskPropertyList = taskPropertyList;

	}

	public List<TaskProperty> getTaskPropertyList() {
		return taskPropertyList;
	}

	protected void cancelPressed() {
		finalizeDefaultMessageInjecttorTask();
		if (removedPropertyList.size() > 0) {
			taskPropertyList.addAll(removedPropertyList);
			removedPropertyList.clear();
		}
		super.cancelPressed();
	}

	private TableItem bindPram(String value) {
		TableItem item = new TableItem(propertyTable, SWT.NONE);
		item.setText(new String[] { value, LITERAL, null });
		return item;
	}

	private TableItem bindPram(TaskProperty param) {
		TableItem item = new TableItem(propertyTable, SWT.NONE);

		item.setText(new String[] { param.getPropertyName(), param.getPropertyType().getLiteral(),
				param.getPropertyValue() });
		item.setData(param);
		return item;
	}

	private void unbindParam(int itemIndex) {
		TableItem item = propertyTable.getItem(itemIndex);
		TaskProperty param = (TaskProperty) item.getData();
		removeTaskProperty(param);
		propertyTable.remove(propertyTable.indexOf(item));
	}

	private void removeTaskProperty(TaskProperty param) {
		if (param != null) {
			for (TaskProperty propertyItem : taskPropertyList) {
				if (propertyItem.getPropertyName().equals(param.getPropertyName())) {
					taskPropertyList.remove(propertyItem);
					removedPropertyList.add(propertyItem);
					break;
				}
			}
		}
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
					// for default message-injector-task don't allow
					// to edit the property names
					if (selectedColumn == 0 && !newButtonSelected) {
						return; // for default message-injector-task don't allow
								// to edit the property names
					} else if (selectedColumn == 0 && defaultESBtask) {
						//don't allow to edit the default property names.
						for (int i = 0, n = properties.length; i < n; i++) {
							if (properties[i].equals(item.getText(selectedColumn))) {
								return;
							}
					    }
				    }
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
				if (null != oldEditorControl)
					oldEditorControl.dispose();
			}
		});
	}

	private void editItem(final TableItem item) {
		propertyTypeEditor = initTableEditor(propertyTypeEditor, item.getParent());
		cmbPropertyType = new Combo(item.getParent(), SWT.DROP_DOWN | SWT.READ_ONLY);
		cmbPropertyType.setItems(new String[] { TaskPropertyType.LITERAL.toString(), TaskPropertyType.XML.toString() });
		cmbPropertyType.setText(item.getText(1));
		propertyTypeEditor.setEditor(cmbPropertyType, item, 1);
		item.getParent().redraw();
		item.getParent().layout();
		cmbPropertyType.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event evt) {
				item.setText(1, cmbPropertyType.getText());
			}
		});
		
		cmbPropertyType.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});
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

	private void finalizeDefaultMessageInjecttorTask() {

		resultCommand = null;
		if (defaultESBtask) {

		}

	}

}

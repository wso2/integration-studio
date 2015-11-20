/*
 * Copyright WSO2, Inc. (http://wso2.com)
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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
import org.wso2.developerstudio.eclipse.gmf.esb.APIHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.APIHandlerProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI;

/**
 * API handler configuration dialog. 
 */
public class ConfigureAPIHandlersDialog extends Dialog {

	/**
	 * API model
	 */
	private SynapseAPI api;

	/**
	 * Editing domain
	 */
	private TransactionalEditingDomain editingDomain;

	/**
	 * title label.
	 */
	private Label propertiesLabel;

	/**
	 * Button for adding a new property.
	 */
	private Button newPropertyButton;

	/**
	 * Add new handler
	 */
	private Button newHandlerButton;

	/**
	 * Remove handler.
	 */
	private Button removeHandlerButton;

	/**
	 * Table of property.
	 */
	private Table propertiesTable;

	/**
	 * Handler classes.
	 */
	private Table handlerClassesTale;
	
	/**
	 * Button for deleting an existing Parameter.
	 */
	private Button removePropertyButton;

	/**
	 * Command for recording user operations.
	 */
	private CompoundCommand resultCommand;

	/**
	 * Property table editor
	 */
	private TableEditor propertyEditor;

	/**
	 * Handler class table editor
	 */
	private TableEditor handlerClassEditor;

	private Composite propertyConfig;

	public ConfigureAPIHandlersDialog(Shell parentShell, SynapseAPI api) {
		super(parentShell);
		this.api = api;
		this.editingDomain = TransactionUtil.getEditingDomain(api);
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("API Handlers Configuration");
	}

	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FormLayout());

		Label handlerClassesLabel = new Label(container, SWT.NONE);
		FormData handlerClassesLabelLabelLayoutData = new FormData();
		handlerClassesLabelLabelLayoutData.right = new FormAttachment(0, 138);
		handlerClassesLabelLabelLayoutData.top = new FormAttachment(0, 10);
		handlerClassesLabelLabelLayoutData.left = new FormAttachment(0, 10);
		handlerClassesLabel.setLayoutData(handlerClassesLabelLabelLayoutData);
		handlerClassesLabel.setText("Handler Classes: ");

		handlerClassesTale = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		FormData handlerClassesTaleLayoutData = new FormData();
		handlerClassesTaleLayoutData.top = new FormAttachment(handlerClassesLabel, 9);
		handlerClassesTaleLayoutData.left = new FormAttachment(0, 10);
		handlerClassesTale.setLayoutData(handlerClassesTaleLayoutData);

		TableColumn classNameColumn = new TableColumn(handlerClassesTale, SWT.LEFT);
		classNameColumn.setText("Class Name");
		classNameColumn.setWidth(400);

		handlerClassesTale.setHeaderVisible(true);
		handlerClassesTale.setLinesVisible(true);

		Listener tblHndlerClassesListener = new Listener() {
			public void handleEvent(Event evt) {
				if (null != evt.item) {
					if (evt.item instanceof TableItem) {
						TableItem item = (TableItem) evt.item;
						editHandlerClassItem(item);
						populateProperties((APIHandlerWrapper) item.getData());
					}
				}
			}
		};

		handlerClassesTale.addListener(SWT.Selection, tblHndlerClassesListener);

		// Populate available handlers
		populateHandlers();

		// In-line editing of handler class names.
		setupHandlerClassesTableEditor(handlerClassesTale);

		newHandlerButton = new Button(container, SWT.NONE);
		handlerClassesTaleLayoutData.right = new FormAttachment(newHandlerButton, -6);
		FormData newHandlerButtonLayoutData = new FormData();
		newHandlerButtonLayoutData.top = new FormAttachment(0, 36);
		newHandlerButtonLayoutData.left = new FormAttachment(0, 334);
		newHandlerButton.setLayoutData(newHandlerButtonLayoutData);
		newHandlerButton.setText("Add Handler");
		newHandlerButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				APIHandler handler = EsbFactory.eINSTANCE.createAPIHandler();
				APIHandlerWrapper wrapper = new APIHandlerWrapper(handler.getClassName());
				TableItem item = bindHanler(wrapper);
				item.setText(0, "class" + handlerClassesTale.getItemCount());
				wrapper.setHandler(handler);
				wrapper.setWrapperHandlerClassName(item.getText(0));
				handlerClassesTale.select(handlerClassesTale.indexOf(item));
				populateProperties(wrapper);
			}
		});

		removeHandlerButton = new Button(container, SWT.NONE);
		FormData removeHandlerButtonLayoutData = new FormData();
		removeHandlerButtonLayoutData.top = new FormAttachment(newHandlerButton, 6);
		removeHandlerButtonLayoutData.right = new FormAttachment(newHandlerButton, 0, SWT.RIGHT);
		removeHandlerButtonLayoutData.left = new FormAttachment(0, 334);
		removeHandlerButton.setLayoutData(removeHandlerButtonLayoutData);
		removeHandlerButton.setText("Remove Handler");
		removeHandlerButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				int selectedIndex = handlerClassesTale.getSelectionIndex();
				if (-1 != selectedIndex) {
					unbindHandler(selectedIndex);

					// Select the next available candidate for deletion.
					if (selectedIndex < handlerClassesTale.getItemCount()) {
						handlerClassesTale.select(selectedIndex);
					} else {
						handlerClassesTale.select(selectedIndex - 1);
					}
				}
			}
		});

		Label separatorLabel = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		handlerClassesTaleLayoutData.bottom = new FormAttachment(separatorLabel, -6);
		newHandlerButtonLayoutData.right = new FormAttachment(separatorLabel, 0, SWT.RIGHT);
		FormData separatorLabelLayoutData = new FormData();
		separatorLabelLayoutData.top = new FormAttachment(0, 175);
		separatorLabelLayoutData.right = new FormAttachment(100, -22);
		separatorLabelLayoutData.left = new FormAttachment(0, 10);
		separatorLabel.setLayoutData(separatorLabelLayoutData);

		propertyConfig = new Composite(container, SWT.NONE);
		FormData propertyConfigLayoutData = new FormData();
		propertyConfigLayoutData.bottom = new FormAttachment(100, -10);
		propertyConfigLayoutData.left = new FormAttachment(0, 11);
		propertyConfigLayoutData.right = new FormAttachment(100, -22);
		propertyConfigLayoutData.top = new FormAttachment(0, 177);
		propertyConfig.setLayoutData(propertyConfigLayoutData);
		propertyConfig.setLayout(new GridLayout(3, false));

		propertiesLabel = new Label(propertyConfig, SWT.NONE);
		propertiesLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		propertiesLabel.setText("Properties: ");

		propertiesTable = new Table(propertyConfig, SWT.BORDER | SWT.FULL_SELECTION);

		TableColumn propertyNameColumn = new TableColumn(propertiesTable, SWT.LEFT);
		propertyNameColumn.setText("Name");
		propertyNameColumn.setWidth(150);

		TableColumn propertyValueColumn = new TableColumn(propertiesTable, SWT.LEFT);
		propertyValueColumn.setText("Value");
		propertyValueColumn.setWidth(150);

		propertiesTable.setHeaderVisible(true);
		propertiesTable.setLinesVisible(true);

		Listener tblPropertiesListener = new Listener() {
			public void handleEvent(Event evt) {
				if (null != evt.item) {
					if (evt.item instanceof TableItem) {
						TableItem item = (TableItem) evt.item;
						editPropertyItem(item);
					}
				}
			}
		};

		propertiesTable.addListener(SWT.Selection, tblPropertiesListener);

		// In-line editing of handler properties.
		setupPropertyTableEditor(propertiesTable);

		GridData propertiesTableGrdiData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 2);
		propertiesTableGrdiData.widthHint = 397;
		propertiesTableGrdiData.heightHint = 126;
		propertiesTable.setLayoutData(propertiesTableGrdiData);

		newPropertyButton = new Button(propertyConfig, SWT.NONE);
		newPropertyButton.setText("New...");
		newPropertyButton.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 2, 1));
		newPropertyButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				APIHandlerProperty property = EsbFactory.eINSTANCE.createAPIHandlerProperty();
				WrapperProperty wrapperProperty = new WrapperProperty(property.getName(), property
						.getValue());
				TableItem item = bindProperty(wrapperProperty);
				item.setText(0, "param" + propertiesTable.getItemCount());
				item.setText(1, "value");
				propertiesTable.select(propertiesTable.indexOf(item));
				addHandlerProperty(wrapperProperty, item.getText(0), item.getText(1));
			}
		});

		removePropertyButton = new Button(propertyConfig, SWT.NONE);
		removePropertyButton.setText("Remove");
		removePropertyButton.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
		removePropertyButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				int selectedIndex = propertiesTable.getSelectionIndex();
				if (-1 != selectedIndex) {
					removeHandlerProperty(selectedIndex);

					// Select the next available candidate for deletion.
					if (selectedIndex < propertiesTable.getItemCount()) {
						propertiesTable.select(selectedIndex);
					} else {
						propertiesTable.select(selectedIndex - 1);
					}
				}
			}
		});

		propertyConfig.setEnabled(true);

		return container;
	}

	private void populateHandlers() {
		EList<APIHandler> handlers = api.getHandlers();
		for (APIHandler handler : handlers) {
			APIHandlerWrapper wrapper = new APIHandlerWrapper(handler.getClassName());
			wrapper.setHandler(handler);
			for (APIHandlerProperty property : handler.getProperties()) {
				wrapper.getWrapperHandlerProperties().add(
						new WrapperProperty(property.getName(), property.getValue()));
			}
			bindHanler(wrapper);
		}
	}

	private TableItem bindHanler(APIHandlerWrapper wrapper) {
		TableItem item = new TableItem(handlerClassesTale, SWT.NONE);
		item.setText(new String[] { wrapper.getWrapperHandlerClassName() });
		item.setData(wrapper);
		return item;
	}

	private void unbindHandler(int itemIndex) {
		TableItem item = handlerClassesTale.getItem(itemIndex);
		APIHandlerWrapper wrapper = (APIHandlerWrapper) item.getData();
		APIHandler handler = wrapper.getHandler();
		if (null != handler.eContainer()) {
			RemoveCommand removeCmd = new RemoveCommand(editingDomain, api,
					EsbPackage.Literals.SYNAPSE_API__HANDLERS, handler);
			getResultCommand().append(removeCmd);
		}
		handlerClassesTale.remove(handlerClassesTale.indexOf(item));
		propertiesTable.clearAll();
	}

	private TableItem bindProperty(WrapperProperty property) {
		TableItem item = new TableItem(propertiesTable, SWT.NONE);
		item.setText(new String[] { property.getName(), property.getValue() });
		item.setData(property);
		return item;
	}

	private void editHandlerClassItem(final TableItem item) {
		handlerClassEditor = initTableEditor(handlerClassEditor, item.getParent());
		item.getParent().redraw();
		item.getParent().layout();
	}

	private void editPropertyItem(final TableItem item) {
		propertyEditor = initTableEditor(propertyEditor, item.getParent());
		item.getParent().redraw();
		item.getParent().layout();
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

	/**
	 * Sets up a table editor that allows users to edit cell values inline.
	 * 
	 * @param table
	 */
	private void setupHandlerClassesTableEditor(final Table table) {
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
							cellEditor.getItem().setText(editorControlColumn, text.getText());
							
							// Update changes. 
							TableItem selection = handlerClassesTale.getItem(handlerClassesTale.getSelectionIndex());
							APIHandlerWrapper wrapper = (APIHandlerWrapper) selection.getData();
							wrapper.setWrapperHandlerClassName(text.getText());
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
				if (null != oldEditorControl && !oldEditorControl.isDisposed()) {
					oldEditorControl.dispose();
				}
			}
		});
	}

	/**
	 * Sets up a table editor that allows users to edit cell values inline.
	 * 
	 * @param table
	 */
	private void setupPropertyTableEditor(final Table table) {
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
							cellEditor.getItem().setText(editorControlColumn, text.getText());
							
							// Update changes.
							TableItem handlerClassesTaleItem = handlerClassesTale
									.getItem(handlerClassesTale.getSelectionIndex());
							APIHandlerWrapper wrapperHandler = (APIHandlerWrapper) handlerClassesTaleItem
									.getData();

							if (editorControlColumn == 0) {
								wrapperHandler.getWrapperHandlerProperties().get(propertiesTable.getSelectionIndex())
										.setName(text.getText());
							} else if (editorControlColumn == 1) {
								wrapperHandler.getWrapperHandlerProperties().get(propertiesTable.getSelectionIndex())
										.setValue(text.getText());
							}
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
				if (null != oldEditorControl && !oldEditorControl.isDisposed()) {
					oldEditorControl.dispose();
				}
			}
		});
	}

	private CompoundCommand getResultCommand() {
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
	}

	private void populateProperties(APIHandlerWrapper wrapperHandler) {
		if (wrapperHandler != null) {
			// Clear property table.
			for (TableItem item : propertiesTable.getItems()) {
				propertiesTable.remove(propertiesTable.indexOf(item));
			}

			// Populate selected handler properties.
			for (WrapperProperty property : wrapperHandler.getWrapperHandlerProperties()) {
				if (property != null) {
					bindProperty(property);
				}
			}
		}
	}

	private void addHandlerProperty(WrapperProperty wrapperProperty, String propertyName,
			String propertyValue) {
		int selectedIndex = handlerClassesTale.getSelectionIndex();
		if (selectedIndex != -1) {
			TableItem handlerClassesTaleItem = handlerClassesTale.getItem(selectedIndex);
			APIHandlerWrapper wrapperHandler = (APIHandlerWrapper) handlerClassesTaleItem.getData();
			wrapperProperty.setName(propertyName);
			wrapperProperty.setValue(propertyValue);
			wrapperHandler.getWrapperHandlerProperties().add(wrapperProperty);
		}
	}

	private void removeHandlerProperty(int propertyIndex) {
		int selectedHandlerIndex = handlerClassesTale.getSelectionIndex();
		TableItem propertyTaleItem = propertiesTable.getItem(propertyIndex);
		if (selectedHandlerIndex != -1) {
			TableItem handlerClassesTaleItem = handlerClassesTale.getItem(selectedHandlerIndex);
			WrapperProperty wrapperProperty = (WrapperProperty) propertyTaleItem.getData();
			APIHandlerWrapper handlerWrapper = (APIHandlerWrapper) handlerClassesTaleItem.getData();
			handlerWrapper.getWrapperHandlerProperties().remove(wrapperProperty);
		}

		propertiesTable.remove(propertiesTable.indexOf(propertyTaleItem));
	}

	protected void okPressed() {
		for (TableItem item : handlerClassesTale.getItems()) {
			APIHandlerWrapper wrapperHandler = (APIHandlerWrapper) item.getData();
			APIHandler handler = wrapperHandler.getHandler();
			String wrapperHandlerClassName = wrapperHandler.getWrapperHandlerClassName();

			// If the handler is a new one, add it to the model.
			if (null == handler.eContainer()) {
				if(wrapperHandlerClassName != null && !wrapperHandlerClassName.equals("")) {
					handler.setClassName(wrapperHandler.getWrapperHandlerClassName());
					for (WrapperProperty wrapperProperty : wrapperHandler.getWrapperHandlerProperties()) {
						APIHandlerProperty property = EsbFactory.eINSTANCE.createAPIHandlerProperty();
						property.setName(wrapperProperty.getName());
						property.setValue(wrapperProperty.getValue());
						handler.getProperties().add(property);
					}

					AddCommand addCmd = new AddCommand(editingDomain, api,
							EsbPackage.Literals.SYNAPSE_API__HANDLERS, handler);
					getResultCommand().append(addCmd);
				}
			} else {
				// If the handler class name needs to be updated.
				if (!handler.getClassName().equals(wrapperHandlerClassName)) {
					// If empty class name is given remove the handler. 
					if(wrapperHandlerClassName.equals("")) {
						RemoveCommand removeCmd = new RemoveCommand(editingDomain, api,
								EsbPackage.Literals.SYNAPSE_API__HANDLERS, handler);
						getResultCommand().append(removeCmd);
					} else {
						SetCommand setCmd = new SetCommand(editingDomain, handler,
								EsbPackage.Literals.API_HANDLER__CLASS_NAME,
								wrapperHandler.getWrapperHandlerClassName());
						getResultCommand().append(setCmd);
					}
					
				} 
				
				// Remove all available handler properties.
				for (APIHandlerProperty property : handler.getProperties()) {
					RemoveCommand removeCmd = new RemoveCommand(editingDomain, handler,
							EsbPackage.Literals.API_HANDLER__PROPERTIES, property);
					getResultCommand().append(removeCmd);
				}
				
				// Add properties from wrapper.
				if (!wrapperHandlerClassName.equals("")) {
					for (WrapperProperty wrapperProperty : wrapperHandler
							.getWrapperHandlerProperties()) {
						APIHandlerProperty property = EsbFactory.eINSTANCE
								.createAPIHandlerProperty();
						property.setName(wrapperProperty.getName());
						property.setValue(wrapperProperty.getValue());

						AddCommand addCmd = new AddCommand(editingDomain, handler,
								EsbPackage.Literals.API_HANDLER__PROPERTIES, property);
						getResultCommand().append(addCmd);
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

	class APIHandlerWrapper {
		private APIHandler handler;
		private String wrapperHandlerClassName;
		private List<WrapperProperty> wrapperHandlerProperties;

		public APIHandlerWrapper(String className) {
			this.wrapperHandlerClassName = className;
			wrapperHandlerProperties = new ArrayList<WrapperProperty>();
		}

		public APIHandler getHandler() {
			return handler;
		}

		public void setHandler(APIHandler handler) {
			this.handler = handler;
		}

		public String getWrapperHandlerClassName() {
			return wrapperHandlerClassName;
		}

		public void setWrapperHandlerClassName(String wrapperHandlerClassName) {
			this.wrapperHandlerClassName = wrapperHandlerClassName;
		}

		public List<WrapperProperty> getWrapperHandlerProperties() {
			return wrapperHandlerProperties;
		}

		public void setWrapperHandlerProperties(List<WrapperProperty> wrapperHandlerProperties) {
			this.wrapperHandlerProperties = wrapperHandlerProperties;
		}
	}

	class WrapperProperty {
		private String name;
		private String value;

		public WrapperProperty(String propertyName, String propertyValue) {
			this.name = propertyName;
			this.value = propertyValue;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
}

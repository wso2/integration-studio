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


import org.eclipse.draw2d.MouseEvent;
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
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.LogCategory;
import org.wso2.developerstudio.eclipse.gmf.esb.LogLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.LogMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.LogProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;

/**
 * Dialog used to configure {@link LogMediator} nodes.
 */
public class ConfigureLogMediatorDialog extends Dialog {

	/**
	 * Table widgets
	 */
	private Combo cmbPropertyType;
	private Text txtPropertyName;
	private PropertyText propertyValue;

	/**
	 * Table editors
	 * */
	private TableEditor propertyTypeEditor;
	private TableEditor propertyNameEditor;
	private TableEditor propertyValueEditor;

	/**
	 * {@link LogMediator} domain object.
	 */
	private LogMediator logMediator;

	/**
	 * Log category label.
	 */
	private Label logCategoryLabel;

	/**
	 * Log category combo.
	 */
	private Combo logCategoryCombo;

	/**
	 * Log level label.
	 */
	private Label logLevelLabel;

	/**
	 * Log level combo.
	 */
	private Combo logLevelCombo;

	/**
	 * Log separator label.
	 */
	private Label logSeparatorLabel;

	/**
	 * Log separator text.
	 */
	private Text logSeparatorText;

	/**
	 * Log properties label.
	 */
	private Label logPropertiesLabel;

	/**
	 * Button for adding a new log property.
	 */
	private Button newLogPropertyButton;

	/**
	 * Button for deleting an existing log property.
	 */
	private Button removeLogPropertyButton;

	/**
	 * Table of log properties.
	 */
	private Table logPropertiesTable;

	/**
	 * Editing domain.
	 */
	private TransactionalEditingDomain editingDomain;

	/**
	 * Command for recording user operations.
	 */
	private CompoundCommand resultCommand;

	/**
	 * Creates a new {@link ConfigureLogMediatorDialog} instance.
	 * 
	 * @param parentShell
	 *            parent shell.
	 */
	public ConfigureLogMediatorDialog(Shell parentShell,
			LogMediator logMediator, TransactionalEditingDomain editingDomain) {
		super(parentShell);
		this.logMediator = logMediator;
		this.editingDomain = editingDomain;
	}

	/**
	 * {@inheritDoc}
	 */
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		// Set title.
		newShell.setText("Log Mediator Configuration");
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

		logCategoryLabel = new Label(container, SWT.NONE);
		{
			logCategoryLabel.setText("Log Category: ");
			FormData logCategoryLabelLayoutData = new FormData();
			logCategoryLabelLayoutData.top = new FormAttachment(0, 5);
			logCategoryLabelLayoutData.left = new FormAttachment(0);
			logCategoryLabel.setLayoutData(logCategoryLabelLayoutData);
		}

		logCategoryCombo = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
		{
			// Populate log category values.
			for (LogCategory logCategory : LogCategory.VALUES) {
				logCategoryCombo.add(logCategory.getLiteral());
			}

			// Select current log category.
			logCategoryCombo.select(logMediator.getLogCategory().ordinal());

			FormData logCategoryComboLayoutData = new FormData();
			logCategoryComboLayoutData.top = new FormAttachment(
					logCategoryLabel, 0, SWT.CENTER);
			logCategoryComboLayoutData.left = new FormAttachment(
					logCategoryLabel, 5);
			logCategoryCombo.setLayoutData(logCategoryComboLayoutData);
		}

		logLevelCombo = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
		{
			// Populate combo box values.
			for (LogLevel logLevelConstant : LogLevel.VALUES) {
				logLevelCombo.add(logLevelConstant.getLiteral());
			}

			// Select the appropriate log value.
			logLevelCombo.select(logMediator.getLogLevel().ordinal());

			// Layout.
			FormData logLevelComboLayoutData = new FormData();
			logLevelComboLayoutData.top = new FormAttachment(logCategoryCombo,
					5);
			logLevelComboLayoutData.left = new FormAttachment(logCategoryCombo,
					0, SWT.LEFT);
			logLevelCombo.setLayoutData(logLevelComboLayoutData);
		}

		logLevelLabel = new Label(container, SWT.NONE);
		{
			logLevelLabel.setText("Log Level: ");
			FormData logLevelLabelLayoutData = new FormData();
			logLevelLabelLayoutData.top = new FormAttachment(logLevelCombo, 0,
					SWT.CENTER);
			logLevelLabelLayoutData.right = new FormAttachment(logLevelCombo,
					-5);
			logLevelLabelLayoutData.left = new FormAttachment(0);
			logLevelLabel.setLayoutData(logLevelLabelLayoutData);
		}

		logSeparatorText = new Text(container, SWT.SINGLE | SWT.BORDER);
		{
			if(logMediator.getLogSeparator() != null){
			logSeparatorText.setText(logMediator.getLogSeparator());
			}
			FormData logSeparatorTextLayoutData = new FormData(25, SWT.DEFAULT);
			logSeparatorTextLayoutData.top = new FormAttachment(logLevelCombo,
					5);
			logSeparatorTextLayoutData.left = new FormAttachment(logLevelCombo,
					0, SWT.LEFT);
			logSeparatorText.setLayoutData(logSeparatorTextLayoutData);
		}

		logSeparatorLabel = new Label(container, SWT.None);
		{
			logSeparatorLabel.setText("Log Separator: ");
			FormData logSeparatorLabelLayoutData = new FormData();
			logSeparatorLabelLayoutData.top = new FormAttachment(
					logSeparatorText, 0, SWT.CENTER);
			logSeparatorLabelLayoutData.right = new FormAttachment(
					logSeparatorText, -5);
			logSeparatorLabelLayoutData.left = new FormAttachment(0);
			logSeparatorLabel.setLayoutData(logSeparatorLabelLayoutData);
		}

		logPropertiesLabel = new Label(container, SWT.NONE);
		{
			logPropertiesLabel.setText("Properties:");
			FormData logPropertiesLabelLayoutData = new FormData();
			logPropertiesLabelLayoutData.top = new FormAttachment(
					logSeparatorText, 10);
			logPropertiesLabelLayoutData.left = new FormAttachment(0);
			logPropertiesLabel.setLayoutData(logPropertiesLabelLayoutData);
		}

		newLogPropertyButton = new Button(container, SWT.NONE);
		{
			newLogPropertyButton.setText("New...");
			FormData newLogPropertyButtonLayoutData = new FormData(80,
					SWT.DEFAULT);
			newLogPropertyButtonLayoutData.top = new FormAttachment(
					logPropertiesLabel, 10);
			newLogPropertyButtonLayoutData.right = new FormAttachment(100);
			newLogPropertyButton.setLayoutData(newLogPropertyButtonLayoutData);

			newLogPropertyButton.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					TableItem item = bindLogProperty(EsbFactory.eINSTANCE
							.createLogProperty());
					logPropertiesTable.select(logPropertiesTable.indexOf(item));
				}
			});
		}

		removeLogPropertyButton = new Button(container, SWT.NONE);
		{
			removeLogPropertyButton.setText("Remove");
			FormData removeLogPropertyButtonLayoutData = new FormData();
			removeLogPropertyButtonLayoutData.top = new FormAttachment(
					newLogPropertyButton, 5);
			removeLogPropertyButtonLayoutData.right = new FormAttachment(100);
			removeLogPropertyButtonLayoutData.left = new FormAttachment(
					newLogPropertyButton, 0, SWT.LEFT);
			removeLogPropertyButton
					.setLayoutData(removeLogPropertyButtonLayoutData);

			removeLogPropertyButton.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					int selectedIndex = logPropertiesTable.getSelectionIndex();
					if (-1 != selectedIndex) {
						initTableEditor(propertyNameEditor, logPropertiesTable);
						initTableEditor(propertyTypeEditor, logPropertiesTable);
						initTableEditor(propertyValueEditor, logPropertiesTable);
						unbindLogProperty(selectedIndex);

						// Select the next available candidate for deletion.
						if (selectedIndex < logPropertiesTable.getItemCount()) {
							logPropertiesTable.select(selectedIndex);
						} else {
							logPropertiesTable.select(selectedIndex - 1);
						}
					}
				}
			});
		}

		logPropertiesTable = new Table(container, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
		{
			TableColumn nameColumn = new TableColumn(logPropertiesTable,
					SWT.LEFT);
			TableColumn typeColumn = new TableColumn(logPropertiesTable,
			        SWT.LEFT);
			TableColumn valueColumn = new TableColumn(logPropertiesTable,
					SWT.LEFT);
			
			nameColumn.setText("Name");
			nameColumn.setWidth(150);
			typeColumn.setText("Type");
			typeColumn.setWidth(150);
			valueColumn.setText("Value/Expression");
			valueColumn.setWidth(200);

			logPropertiesTable.setHeaderVisible(true);
			logPropertiesTable.setLinesVisible(true);

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

			logPropertiesTable
					.addListener(SWT.Selection, tblPropertiesListener);

			// Populate properties.
			for (LogProperty property : logMediator.getProperties()) {
				bindLogProperty(property);
			}

			// In-line editing of properties.
			//setupTableEditor(logPropertiesTable);

			// Layout.
			FormData logPropertiesTableLayoutData = new FormData(SWT.DEFAULT,
					150);
			logPropertiesTableLayoutData.top = new FormAttachment(
					newLogPropertyButton, 0, SWT.TOP);
			logPropertiesTableLayoutData.left = new FormAttachment(0);
			logPropertiesTableLayoutData.right = new FormAttachment(
					newLogPropertyButton, -5);
			logPropertiesTableLayoutData.bottom = new FormAttachment(100);
			logPropertiesTable.setLayoutData(logPropertiesTableLayoutData);
		}

		return container;
	}

	private void editItem(final TableItem item) {
		
		NamespacedProperty expression = (NamespacedProperty)item.getData("exp");
		
		propertyNameEditor = initTableEditor(propertyNameEditor, item.getParent());
		txtPropertyName = new Text(item.getParent(), SWT.NONE);
		txtPropertyName.setText(item.getText(0));
		propertyNameEditor.setEditor(txtPropertyName, item, 0);
		item.getParent().redraw();
		item.getParent().layout();
		txtPropertyName.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				item.setText(0,txtPropertyName.getText());
			}
		});
		
		propertyTypeEditor = initTableEditor(propertyTypeEditor,
				item.getParent());
		cmbPropertyType = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbPropertyType.setItems(new String[] { "LITERAL", "EXPRESSION" });
		cmbPropertyType.setText(item.getText(1));
		propertyTypeEditor.setEditor(cmbPropertyType, item, 1);
		item.getParent().redraw();
		item.getParent().layout();
		cmbPropertyType.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event evt) {
				item.setText(1, cmbPropertyType.getText());
			}
		});
		
		propertyValueEditor = initTableEditor(propertyValueEditor,
				item.getParent());
		
		propertyValue = new PropertyText(item.getParent(), SWT.NONE, cmbPropertyType);
		propertyValue.addProperties(item.getText(2),expression);
		propertyValueEditor.setEditor(propertyValue, item, 2);
		item.getParent().redraw();
		item.getParent().layout();
		propertyValue.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {
				item.setText(2,propertyValue.getText());
				Object property = propertyValue.getProperty();
				if(property instanceof NamespacedProperty){
					item.setData("exp",(NamespacedProperty)property);
				} 
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

	/**
	 * Sets up a table editor that allows users to edit cell values inline.
	 * 
	 * @param table
	 *            table against which a table editor is setup.
	 */
	@Deprecated
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

	/**
	 * {@inheritDoc}
	 */
	protected void okPressed() {
		// Log category.
		int selectedIndex = logCategoryCombo.getSelectionIndex();
		if (-1 != selectedIndex) {
			String logCategoryLiteral = logCategoryCombo.getItem(selectedIndex);
			if (!logCategoryLiteral.equals(logMediator.getLogCategory()
					.getLiteral())) {
				SetCommand setCmd = new SetCommand(editingDomain, logMediator,
						EsbPackage.Literals.LOG_MEDIATOR__LOG_CATEGORY,
						LogLevel.get(logCategoryLiteral));
				getResultCommand().append(setCmd);
			}
		}

		// Log level.
		selectedIndex = logLevelCombo.getSelectionIndex();
		if (-1 != selectedIndex) {
			String logLevelLiteral = logLevelCombo.getItem(selectedIndex);
			if (!logLevelLiteral.equals(logMediator.getLogLevel().getLiteral())) {
				SetCommand setCmd = new SetCommand(editingDomain, logMediator,
						EsbPackage.Literals.LOG_MEDIATOR__LOG_LEVEL,
						LogLevel.get(logLevelLiteral));
				getResultCommand().append(setCmd);
			}
		}

		// Log separator.
		String logSeparator = logSeparatorText.getText();
		if (!logSeparator.equals(logMediator.getLogSeparator())) {
			SetCommand setCmd = new SetCommand(editingDomain, logMediator,
					EsbPackage.Literals.LOG_MEDIATOR__LOG_SEPARATOR,
					logSeparator);
			getResultCommand().append(setCmd);
		}

		// Log properties.
		for (TableItem item : logPropertiesTable.getItems()) {
			LogProperty property = (LogProperty) item.getData();
			NamespacedProperty expression = (NamespacedProperty)item.getData("exp");

			// If the property is a new one, add it to the model.
			if (null == property.eContainer()) {
				// Update the log property with the latest data from table row.
				property.setPropertyName(item.getText(0));

				if (item.getText(1).equals("LITERAL")) {
					property.setPropertyValueType(PropertyValueType.LITERAL);
					property.setPropertyValue(item.getText(2));
				}

				if (item.getText(1).equals("EXPRESSION")) {
					property.setPropertyValueType(PropertyValueType.EXPRESSION);
					NamespacedProperty namespaceProperty = EsbFactoryImpl.eINSTANCE
							.createNamespacedProperty();
					namespaceProperty.setPropertyValue(item.getText(2));
					namespaceProperty.setNamespaces(expression.getNamespaces());
					property.setPropertyExpression(namespaceProperty);
				}

				// Record the add operation.
				AddCommand addCmd = new AddCommand(editingDomain, logMediator,
						EsbPackage.Literals.LOG_MEDIATOR__PROPERTIES, property);
				getResultCommand().append(addCmd);
			} else {
				// If the property name needs to be updated.
				if (!property.getPropertyName().equals(item.getText(0))) {
					SetCommand setCmd = new SetCommand(
							editingDomain,
							property,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_NAME,
							item.getText(0));
					getResultCommand().append(setCmd);
				}

				if (item.getText(1).equals("LITERAL")) {

					SetCommand setCmdValueType = new SetCommand(
							editingDomain,
							property,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE_TYPE,
							PropertyValueType.LITERAL);
					getResultCommand().append(setCmdValueType);
					if (!property.getPropertyValue().equals(item.getText(2))) {
						SetCommand setCmd = new SetCommand(
								editingDomain,
								property,
								EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE,
								item.getText(2));
						getResultCommand().append(setCmd);
					}
				}
				if (item.getText(1).equals("EXPRESSION")) {
					SetCommand setCmdValueType = new SetCommand(
							editingDomain,
							property,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE_TYPE,
							PropertyValueType.EXPRESSION);
					getResultCommand().append(setCmdValueType);

					if (property.getPropertyExpression() == null) {
						NamespacedProperty namespaceProperty = EsbFactoryImpl.eINSTANCE
								.createNamespacedProperty();
						namespaceProperty.setPropertyValue(item.getText(2));
						namespaceProperty.setNamespaces(expression.getNamespaces());

						AddCommand addCmd = new AddCommand(
								editingDomain,
								property,
								EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_EXPRESSION,
								namespaceProperty);
						getResultCommand().append(addCmd);
					} else {
						SetCommand setCmd = new SetCommand(
								editingDomain,
								property.getPropertyExpression(),
								EsbPackage.Literals.NAMESPACED_PROPERTY__PROPERTY_VALUE,
								item.getText(2));
						getResultCommand().append(setCmd);
						
						setCmd = new SetCommand(
								editingDomain,
								property.getPropertyExpression(),
								EsbPackage.Literals.NAMESPACED_PROPERTY__NAMESPACES,
								expression.getNamespaces());
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

	/**
	 * Utility method for binding a log property into the UI. Note that this
	 * method does not record any commands, it simply adds a new row into the
	 * table and associates the passed {@link LogProperty} to it.
	 * 
	 * @return {@link TableItem} which was introduced.
	 */
	private TableItem bindLogProperty(LogProperty property) {
		TableItem item = new TableItem(logPropertiesTable, SWT.NONE);
		if (property.getPropertyValueType().getLiteral().equals("LITERAL")) {
			item.setText(new String[] { property.getPropertyName(),
			        property.getPropertyValueType().getLiteral(),
					property.getPropertyValue() });
		}
		if (property.getPropertyValueType().getLiteral().equals("EXPRESSION")) {
			item.setText(new String[] { property.getPropertyName(),
			        property.getPropertyValueType().getLiteral(),
					property.getPropertyExpression().getPropertyValue() });
		}

		item.setData(property);
		item.setData("exp",
				EsbFactory.eINSTANCE.copyNamespacedProperty(property.getPropertyExpression()));
		return item;
	}

	/**
	 * Removes the corresponding table item from the table and records a command
	 * for detaching the corresponding log property from the model.
	 * 
	 * @param itemIndex
	 *            index of the row which is to be removed.
	 */
	private void unbindLogProperty(int itemIndex) {
		TableItem item = logPropertiesTable.getItem(itemIndex);
		LogProperty property = (LogProperty) item.getData();
		// If the property is part of the model, record a command for getting
		// rid of it.
		if (null != property.eContainer()) {
			RemoveCommand removeCmd = new RemoveCommand(editingDomain,
					logMediator, EsbPackage.Literals.LOG_MEDIATOR__PROPERTIES,
					property);
			getResultCommand().append(removeCmd);
		}
		logPropertiesTable.remove(logPropertiesTable.indexOf(item));
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

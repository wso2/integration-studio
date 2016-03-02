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

import org.eclipse.draw2d.MouseEvent;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
import org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MethodArgument;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;

/**
 * Dialog used to configure EJB Mediator method arguments.
 */
public class ConfigureEJBMediatorMethodArgumentsDialog extends Dialog {

	/**
	 * Table widgets
	 */
	private Combo cmbArgumentType;
	private PropertyText argumentValue;

	/**
	 * Table editors
	 * */
	private TableEditor argumentTypeEditor;
	private TableEditor argumentValueEditor;

	/**
	 * {@link EJBMediator} domain object.
	 */
	private EJBMediator ejbMediator;

	/**
	 * Method Arguments label.
	 */
	private Label methodArgumentsLabel;

	/**
	 * Button for adding a new method argument.
	 */
	private Button addArgumentButton;

	/**
	 * Button for deleting an existing method argument.
	 */
	private Button removeArgumentButton;

	/**
	 * Table of method argument.
	 */
	private Table methodArgumentsTable;

	/**
	 * Editing domain.
	 */
	private TransactionalEditingDomain editingDomain;

	/**
	 * Command for recording user operations.
	 */
	private CompoundCommand resultCommand;

	private final static String LITERAL_VALUE = "Value";
	private final static String LITERAL_EXPRESSION = "Expression";

	/**
	 * Creates a new {@link ConfigureLogMediatorDialog} instance.
	 * 
	 * @param parentShell
	 *            parent shell.
	 */
	public ConfigureEJBMediatorMethodArgumentsDialog(Shell parentShell, EJBMediator ejbMediator,
			TransactionalEditingDomain editingDomain) {
		super(parentShell);
		this.ejbMediator = ejbMediator;
		this.editingDomain = editingDomain;
	}

	/**
	 * {@inheritDoc}
	 */
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		// Set title.
		newShell.setText("Method Arguments");
	}

	/**
	 * {@inheritDoc}
	 */
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FormLayout());

		// Method Arguments label.
		methodArgumentsLabel = new Label(container, SWT.NONE);
		methodArgumentsLabel.setText("Method Arguments:");
		FormData methodArgumentsLabelLayoutData = new FormData();
		methodArgumentsLabelLayoutData.top = new FormAttachment(0, 10);
		methodArgumentsLabelLayoutData.left = new FormAttachment(0, 10);
		methodArgumentsLabel.setLayoutData(methodArgumentsLabelLayoutData);

		// Method Arguments table.
		methodArgumentsTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.HIDE_SELECTION);

		FormData methodArgumentsTableLayoutData = new FormData();
		methodArgumentsTableLayoutData.bottom = new FormAttachment(methodArgumentsLabel, 194,
				SWT.BOTTOM);
		methodArgumentsTableLayoutData.top = new FormAttachment(methodArgumentsLabel, 6);
		methodArgumentsTableLayoutData.left = new FormAttachment(0, 10);
		methodArgumentsTableLayoutData.right = new FormAttachment(0, 481);
		methodArgumentsTable.setLayoutData(methodArgumentsTableLayoutData);

		TableColumn typeColumn = new TableColumn(methodArgumentsTable, SWT.NONE);
		TableColumn valueColumn = new TableColumn(methodArgumentsTable, SWT.NONE);

		typeColumn.setText("Type");
		typeColumn.setWidth(120);
		valueColumn.setText("Value/Expression");
		valueColumn.setWidth(250);

		methodArgumentsTable.setHeaderVisible(true);
		methodArgumentsTable.setLinesVisible(true);

		methodArgumentsTable.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (null != e.item) {
					if (e.item instanceof TableItem) {
						TableItem item = (TableItem) e.item;
						editItem(item);
						removeArgumentButton.setEnabled(true);
					}
				} else {
					removeArgumentButton.setEnabled(false);
				}
			}
		});

		// Populate arguments.
		for (MethodArgument argument : ejbMediator.getMethodArguments()) {
			bindMethodArgument(argument);
		}

		// Add Argument.
		addArgumentButton = new Button(container, SWT.NONE);
		addArgumentButton.setText("Add");
		FormData addArgumentButtonLayoutData = new FormData();
		addArgumentButtonLayoutData.left = new FormAttachment(100, -92);
		;
		addArgumentButtonLayoutData.top = new FormAttachment(0, 33);
		addArgumentButtonLayoutData.right = new FormAttachment(100, -10);
		addArgumentButton.setLayoutData(addArgumentButtonLayoutData);

		addArgumentButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				TableItem item = bindMethodArgument(EsbFactory.eINSTANCE.createMethodArgument());
				methodArgumentsTable.select(methodArgumentsTable.indexOf(item));
			}
		});

		// Remove Argument.
		removeArgumentButton = new Button(container, SWT.NONE);
		removeArgumentButton.setText("Remove");
		FormData removeArgumentButtonLayoutData = new FormData();
		removeArgumentButtonLayoutData.left = new FormAttachment(100, -92);
		removeArgumentButtonLayoutData.top = new FormAttachment(addArgumentButton, 9);
		removeArgumentButtonLayoutData.right = new FormAttachment(100, -10);
		removeArgumentButton.setLayoutData(removeArgumentButtonLayoutData);
		removeArgumentButton.setEnabled(false);

		removeArgumentButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				int selectedIndex = methodArgumentsTable.getSelectionIndex();
				if (-1 != selectedIndex) {
					initTableEditor(argumentTypeEditor, methodArgumentsTable);
					initTableEditor(argumentValueEditor, methodArgumentsTable);
					unbindMethodArgument(selectedIndex);

					// Select the next available candidate for deletion.
					if (selectedIndex < methodArgumentsTable.getItemCount()) {
						methodArgumentsTable.select(selectedIndex);
					} else {
						methodArgumentsTable.select(selectedIndex - 1);
					}
				}
			}
		});

		return container;
	}

	private void editItem(final TableItem item) {

		NamespacedProperty expression = (NamespacedProperty) item.getData("exp");

		argumentTypeEditor = initTableEditor(argumentTypeEditor, item.getParent());
		cmbArgumentType = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbArgumentType.setItems(new String[] { LITERAL_VALUE, LITERAL_EXPRESSION });
		cmbArgumentType.setText(item.getText(0));
		argumentTypeEditor.setEditor(cmbArgumentType, item, 0);
		item.getParent().redraw();
		item.getParent().layout();
		cmbArgumentType.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event evt) {
				item.setText(0, cmbArgumentType.getText());
			}
		});

		argumentValueEditor = initTableEditor(argumentValueEditor, item.getParent());

		argumentValue = new PropertyText(item.getParent(), SWT.NONE, cmbArgumentType);
		argumentValue.addProperties(item.getText(1), expression);
		argumentValueEditor.setEditor(argumentValue, item, 1);
		item.getParent().redraw();
		item.getParent().layout();
		argumentValue.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				item.setText(1, argumentValue.getText());
				Object property = argumentValue.getProperty();
				if (property instanceof NamespacedProperty) {
					item.setData("exp", (NamespacedProperty) property);
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
							cellEditor.getItem().setText(editorControlColumn, text.getText());
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
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(597, 329);
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
	 * {@inheritDoc}
	 */
	protected void okPressed() {

		// Method Arguments.
		for (TableItem item : methodArgumentsTable.getItems()) {
			MethodArgument argument = (MethodArgument) item.getData();
			NamespacedProperty expression = (NamespacedProperty) item.getData("exp");

			// If the argument is a new one, add it to the model.
			if (null == argument.eContainer()) {
				// Update the log property with the latest data from table row.
				if (item.getText(0).equals(LITERAL_VALUE)) {
					argument.setPropertyValueType(PropertyValueType.LITERAL);
					argument.setPropertyValue(item.getText(1));
				}

				if (item.getText(0).equals(LITERAL_EXPRESSION)) {
					argument.setPropertyValueType(PropertyValueType.EXPRESSION);
					NamespacedProperty namespaceProperty = EsbFactoryImpl.eINSTANCE
							.createNamespacedProperty();
					namespaceProperty.setPropertyValue(item.getText(1));
					namespaceProperty.setNamespaces(expression.getNamespaces());
					argument.setPropertyExpression(namespaceProperty);
				}

				// Record the add operation.
				AddCommand addCmd = new AddCommand(editingDomain, ejbMediator,
						EsbPackage.Literals.EJB_MEDIATOR__METHOD_ARGUMENTS, argument);
				getResultCommand().append(addCmd);

			} else {
				if (item.getText(0).equals(LITERAL_VALUE)) {

					SetCommand setCmdValueType = new SetCommand(
							editingDomain,
							argument,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE_TYPE,
							PropertyValueType.LITERAL);
					getResultCommand().append(setCmdValueType);
					if (!argument.getPropertyValue().equals(item.getText(2))) {
						SetCommand setCmd = new SetCommand(
								editingDomain,
								argument,
								EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE,
								item.getText(1));
						getResultCommand().append(setCmd);
					}
				}
				if (item.getText(0).equals(LITERAL_EXPRESSION)) {
					SetCommand setCmdValueType = new SetCommand(
							editingDomain,
							argument,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE_TYPE,
							PropertyValueType.EXPRESSION);
					getResultCommand().append(setCmdValueType);

					if (argument.getPropertyExpression() == null) {
						NamespacedProperty namespaceProperty = EsbFactoryImpl.eINSTANCE
								.createNamespacedProperty();
						namespaceProperty.setPropertyValue(item.getText(1));
						namespaceProperty.setNamespaces(expression.getNamespaces());

						AddCommand addCmd = new AddCommand(
								editingDomain,
								argument,
								EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_EXPRESSION,
								namespaceProperty);
						getResultCommand().append(addCmd);
					} else {
						SetCommand setCmd = new SetCommand(editingDomain,
								argument.getPropertyExpression(),
								EsbPackage.Literals.NAMESPACED_PROPERTY__PROPERTY_VALUE,
								item.getText(1));
						getResultCommand().append(setCmd);

						setCmd = new SetCommand(editingDomain, argument.getPropertyExpression(),
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
	 * Utility method for binding a method argument into the UI.
	 */
	private TableItem bindMethodArgument(MethodArgument argument) {
		TableItem item = new TableItem(methodArgumentsTable, SWT.NONE);
		if (argument.getPropertyValueType().getLiteral().equals("LITERAL")) {
			item.setText(new String[] { LITERAL_VALUE,
					argument.getPropertyValue() });
		}
		if (argument.getPropertyValueType().getLiteral().equals("EXPRESSION")) {
			item.setText(new String[] { LITERAL_EXPRESSION,
					argument.getPropertyExpression().getPropertyValue() });
		}

		item.setData(argument);
		item.setData("exp",
				EsbFactory.eINSTANCE.copyNamespacedProperty(argument.getPropertyExpression()));
		return item;
	}

	/**
	 * Removes the corresponding table item from the table and records a command
	 * for detaching the corresponding method argument from the model.
	 * 
	 * @param itemIndex
	 *            index of the row which is to be removed.
	 */
	private void unbindMethodArgument(int itemIndex) {
		TableItem item = methodArgumentsTable.getItem(itemIndex);
		MethodArgument argument = (MethodArgument) item.getData();
		if (null != argument.eContainer()) {
			RemoveCommand removeCmd = new RemoveCommand(editingDomain, ejbMediator,
					EsbPackage.Literals.EJB_MEDIATOR__METHOD_ARGUMENTS, argument);
			getResultCommand().append(removeCmd);
		}
		methodArgumentsTable.remove(methodArgumentsTable.indexOf(item));
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

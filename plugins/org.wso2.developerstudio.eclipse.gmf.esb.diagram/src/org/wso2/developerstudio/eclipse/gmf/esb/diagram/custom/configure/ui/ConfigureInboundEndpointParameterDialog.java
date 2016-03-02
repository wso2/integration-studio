/*
 * Copyright 2015 WSO2, Inc. (http://wso2.com)
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

import org.apache.commons.lang.StringUtils;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointParameter;

public class ConfigureInboundEndpointParameterDialog extends Dialog {

	private InboundEndpoint inboundEndpoint;
	private TransactionalEditingDomain editingDomain;
	/**
	 * Log properties label.
	 */
	private Label inboundEndpointParameterLabel;
	/**
	 * Log separator text.
	 */
	private Text inboundEndpointSeparatorText;
	/**
	 * Button for adding a new log property.
	 */
	private Button newInboundEndpointParameterButton;
	/**
	 * Table of log properties.
	 */
	private Table inboundEndpointParametersTable;
	/**
	 * Button for deleting an existing log property.
	 */
	private Button removeInboundEndpointParameterButton;
	/**
	 * Command for recording user operations.
	 */
	private CompoundCommand resultCommand;

	private TableEditor propertyTypeEditor;

	public ConfigureInboundEndpointParameterDialog(Shell parentShell, InboundEndpoint inboundEndpoint) {
		super(parentShell);
		this.inboundEndpoint = inboundEndpoint;
		this.editingDomain = TransactionUtil.getEditingDomain(inboundEndpoint);
	}

	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);

		inboundEndpointParameterLabel = new Label(container, SWT.NONE);
		{
			inboundEndpointParameterLabel.setText("Parameters:");
			FormData inboundEndpointParameterLabelLayoutData = new FormData();
			inboundEndpointParameterLabelLayoutData.top = new FormAttachment(inboundEndpointSeparatorText, 10);
			inboundEndpointParameterLabelLayoutData.left = new FormAttachment(0);
			inboundEndpointParameterLabel.setLayoutData(inboundEndpointParameterLabelLayoutData);
		}

		newInboundEndpointParameterButton = new Button(container, SWT.NONE);
		{
			newInboundEndpointParameterButton.setText("New...");
			FormData newInboundEndpointParameterButtonLayoutData = new FormData(80, SWT.DEFAULT);
			newInboundEndpointParameterButtonLayoutData.top = new FormAttachment(inboundEndpointParameterLabel, 10);
			newInboundEndpointParameterButtonLayoutData.right = new FormAttachment(100);
			newInboundEndpointParameterButton.setLayoutData(newInboundEndpointParameterButtonLayoutData);

			newInboundEndpointParameterButton.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					TableItem item = bindInboundEndpointParameter(EsbFactory.eINSTANCE.createInboundEndpointParameter());
					inboundEndpointParametersTable.select(inboundEndpointParametersTable.indexOf(item));
				}
			});
		}

		removeInboundEndpointParameterButton = new Button(container, SWT.NONE);
		{
			removeInboundEndpointParameterButton.setText("Remove");
			FormData removeInboundEndpointParameterButtonLayoutData = new FormData();
			removeInboundEndpointParameterButtonLayoutData.top = new FormAttachment(newInboundEndpointParameterButton,
					5);
			removeInboundEndpointParameterButtonLayoutData.right = new FormAttachment(100);
			removeInboundEndpointParameterButtonLayoutData.left = new FormAttachment(newInboundEndpointParameterButton,
					0, SWT.LEFT);
			removeInboundEndpointParameterButton.setLayoutData(removeInboundEndpointParameterButtonLayoutData);

			removeInboundEndpointParameterButton.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					int selectedIndex = inboundEndpointParametersTable.getSelectionIndex();
					if (-1 != selectedIndex) {
						unbindLogProperty(selectedIndex);

						// Select the next available candidate for deletion.
						if (selectedIndex < inboundEndpointParametersTable.getItemCount()) {
							inboundEndpointParametersTable.select(selectedIndex);
						} else {
							inboundEndpointParametersTable.select(selectedIndex - 1);
						}
					}
				}
			});
		}

		inboundEndpointParametersTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
		{
			TableColumn nameColumn = new TableColumn(inboundEndpointParametersTable, SWT.LEFT);
			TableColumn valueColumn = new TableColumn(inboundEndpointParametersTable, SWT.LEFT);
			nameColumn.setText("Name");
			nameColumn.setWidth(150);
			valueColumn.setText("Value");
			valueColumn.setWidth(200);

			inboundEndpointParametersTable.setHeaderVisible(true);
			inboundEndpointParametersTable.setLinesVisible(true);

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

			inboundEndpointParametersTable.addListener(SWT.Selection, tblPropertiesListener);

			// Populate properties.
			for (InboundEndpointParameter parameter : inboundEndpoint.getServiceParameters()) {
				if (!StringUtils.isEmpty(parameter.getValue())) {
					bindInboundEndpointParameter(parameter);
				} else {
					RemoveCommand removeCmd = new RemoveCommand(editingDomain, inboundEndpoint,
							EsbPackage.Literals.INBOUND_ENDPOINT__SERVICE_PARAMETERS, parameter);
					getResultCommand().append(removeCmd);

				}
			}

			// In-line editing of properties.
			setupTableEditor(inboundEndpointParametersTable);

			// Layout.
			FormData inboundEndpointParametersTableLayoutData = new FormData(SWT.DEFAULT, 150);
			inboundEndpointParametersTableLayoutData.top = new FormAttachment(newInboundEndpointParameterButton, 0,
					SWT.TOP);
			inboundEndpointParametersTableLayoutData.left = new FormAttachment(0);
			inboundEndpointParametersTableLayoutData.right = new FormAttachment(newInboundEndpointParameterButton, -5);
			inboundEndpointParametersTableLayoutData.bottom = new FormAttachment(100);
			inboundEndpointParametersTable.setLayoutData(inboundEndpointParametersTableLayoutData);
		}

		return container;
	}

	private TableItem bindInboundEndpointParameter(InboundEndpointParameter property) {
		TableItem item = new TableItem(inboundEndpointParametersTable, SWT.NONE);
		item.setText(new String[] { property.getName(), property.getValue() });
		item.setData(property);
		return item;
	}

	private void unbindLogProperty(int itemIndex) {
		TableItem item = inboundEndpointParametersTable.getItem(itemIndex);
		InboundEndpointParameter property = (InboundEndpointParameter) item.getData();
		// If the property is part of the model, record a command for getting
		// rid of it.
		if (null != property.eContainer()) {
			RemoveCommand removeCmd = new RemoveCommand(editingDomain, inboundEndpoint,
					EsbPackage.Literals.INBOUND_ENDPOINT__SERVICE_PARAMETERS, property);
			getResultCommand().append(removeCmd);
		}
		inboundEndpointParametersTable.remove(inboundEndpointParametersTable.indexOf(item));
	}

	private void editItem(final TableItem item) {
		propertyTypeEditor = initTableEditor(propertyTypeEditor, item.getParent());
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
	 *            table against which a table editor is setup.
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

	protected void okPressed() {
		// Log properties.
		for (TableItem item : inboundEndpointParametersTable.getItems()) {
			InboundEndpointParameter property = (InboundEndpointParameter) item.getData();

			// If the property is a new one, add it to the model.
			if (null == property.eContainer()) {
				// Update the log property with the latest data from table row.
				property.setName(item.getText(0));
				property.setValue(item.getText(1));

				// Record the add operation.
				AddCommand addCmd = new AddCommand(editingDomain, inboundEndpoint,
						EsbPackage.Literals.INBOUND_ENDPOINT__SERVICE_PARAMETERS, property);
				getResultCommand().append(addCmd);
			} else {
				// If the property name needs to be updated.
				if (!property.getName().equals(item.getText(0))) {
					SetCommand setCmd = new SetCommand(editingDomain, property,
							EsbPackage.Literals.INBOUND_ENDPOINT_PARAMETER__NAME, item.getText(0));
					getResultCommand().append(setCmd);
				}

				if (property.getValue() != null) {
					if (!property.getValue().equals(item.getText(1))) {
						SetCommand setCmd = new SetCommand(editingDomain, property,
								EsbPackage.Literals.INBOUND_ENDPOINT_PARAMETER__VALUE, item.getText(1));
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
		shell.setText("Inbound Endpoint Configuration");
	}

	protected Point getInitialSize() {
		return new Point(450, 317);
	}

	private CompoundCommand getResultCommand() {
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
	}

}

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
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.Template;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateParameter;

/**
 * Template parameters configuration dialogBox.
 *
 */
public class ConfigureTemplateParametersDialog extends Dialog {

	/**
	 * Template model
	 */
	private Template template;
	/**
	 * Editing domain
	 */
	private TransactionalEditingDomain editingDomain;
	/**
	 * title label.
	 */
	private Label parameterLabel;
	/**
	 * dummy text.
	 */
	private Text dummy;
	/**
	 * Button for adding a new parameter.
	 */
	private Button newParameterButton;
	/**
	 * Table of parameters.
	 */
	private Table parametersTable;
	/**
	 * Button for deleting an existing Parameter.
	 */
	private Button removeParameterButton;
	/**
	 * Command for recording user operations.
	 */
	private CompoundCommand resultCommand;
	/**
	 * Table editor
	 */
	private TableEditor parameterEditor;
	
	
	public ConfigureTemplateParametersDialog(Shell parentShell, Template template) {
		super(parentShell);
		this.template = template;
		this.editingDomain = TransactionUtil.getEditingDomain(template);
	}
	
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);
		
		
		parameterLabel = new Label(container, SWT.NONE);
		{
			parameterLabel.setText("Parameters:");
			FormData proxyParameterLabelLayoutData = new FormData();
			proxyParameterLabelLayoutData.top = new FormAttachment(
					dummy, 10);
			proxyParameterLabelLayoutData.left = new FormAttachment(0);
			parameterLabel.setLayoutData(proxyParameterLabelLayoutData);
		}

		newParameterButton = new Button(container, SWT.NONE);
		{
			newParameterButton.setText("New...");
			FormData newProxyParameterButtonLayoutData = new FormData(80,
					SWT.DEFAULT);
			newProxyParameterButtonLayoutData.top = new FormAttachment(
					parameterLabel, 10);
			newProxyParameterButtonLayoutData.right = new FormAttachment(100);
			newParameterButton.setLayoutData(newProxyParameterButtonLayoutData);

			newParameterButton.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					TemplateParameter parameter = EsbFactory.eINSTANCE
							.createTemplateParameter();
					parameter.setName("parameter_value");
					TableItem item = bindParameter(parameter);
					parametersTable.select(parametersTable.indexOf(item));
				}
			});
		}

		removeParameterButton = new Button(container, SWT.NONE);
		{
			removeParameterButton.setText("Remove");
			FormData removeProxyParameterButtonLayoutData = new FormData();
			removeProxyParameterButtonLayoutData.top = new FormAttachment(
					newParameterButton, 5);
			removeProxyParameterButtonLayoutData.right = new FormAttachment(100);
			removeProxyParameterButtonLayoutData.left = new FormAttachment(
					newParameterButton, 0, SWT.LEFT);
			removeParameterButton
					.setLayoutData(removeProxyParameterButtonLayoutData);

			removeParameterButton.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					int selectedIndex = parametersTable.getSelectionIndex();
					if (-1 != selectedIndex) {
						unbindParameter(selectedIndex);

						// Select the next available candidate for deletion.
						if (selectedIndex < parametersTable.getItemCount()) {
							parametersTable.select(selectedIndex);
						} else {
							parametersTable.select(selectedIndex - 1);
						}
					}
				}
			});
		}

		parametersTable = new Table(container, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
		{
			TableColumn nameColumn = new TableColumn(parametersTable,
					SWT.LEFT);
			nameColumn.setText("Name");
			nameColumn.setWidth(250);

			parametersTable.setHeaderVisible(true);
			parametersTable.setLinesVisible(true);

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

			parametersTable
					.addListener(SWT.Selection, tblPropertiesListener);

			// Populate template.
			for (TemplateParameter parameter : template.getParameters()) {
				bindParameter(parameter);
			}

			// In-line editing of parameters.
			setupTableEditor(parametersTable);

			// Layout.
			FormData parametersTableLayoutData = new FormData(SWT.DEFAULT,
					150);
			parametersTableLayoutData.top = new FormAttachment(
					newParameterButton, 0, SWT.TOP);
			parametersTableLayoutData.left = new FormAttachment(0);
			parametersTableLayoutData.right = new FormAttachment(
					newParameterButton, -5);
			parametersTableLayoutData.bottom = new FormAttachment(100);
			parametersTable.setLayoutData(parametersTableLayoutData);
		}
		
		
		
		return container;
	}
	
	
	private TableItem bindParameter(TemplateParameter parameter) {
		TableItem item = new TableItem(parametersTable, SWT.NONE);
			item.setText(new String[] { parameter.getName()});
		item.setData(parameter);
		return item;
	}
	
	private void unbindParameter(int itemIndex) {
		TableItem item = parametersTable.getItem(itemIndex);
		TemplateParameter Parameter = (TemplateParameter) item.getData();
		if (null != Parameter.eContainer()) {
			RemoveCommand removeCmd = new RemoveCommand(editingDomain,
					template, EsbPackage.Literals.TEMPLATE__PARAMETERS,
					Parameter);
			getResultCommand().append(removeCmd);
		}
		parametersTable.remove(parametersTable.indexOf(item));
	}
	
	private void editItem(final TableItem item) {
		parameterEditor = initTableEditor(parameterEditor,
				item.getParent());
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
		// parameters.
		for (TableItem item : parametersTable.getItems()) {
			TemplateParameter Parameter = (TemplateParameter) item.getData();

			// If the parameter is a new one, add it to the model.
			if (null == Parameter.eContainer()) {
				// Update the parameter name with the latest data from table row.
				Parameter.setName(item.getText(0));
				
				// Record the add operation.
				AddCommand addCmd = new AddCommand(editingDomain, template,
						EsbPackage.Literals.TEMPLATE__PARAMETERS, Parameter);
				getResultCommand().append(addCmd);
			} else {
				// If the parameter name needs to be updated.
				if (!Parameter.getName().equals(item.getText(0))) {
					SetCommand setCmd = new SetCommand(
							editingDomain,
							Parameter,
							EsbPackage.Literals.TEMPLATE_PARAMETER__NAME,
							item.getText(0));
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
	
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Parameters Configuration");
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

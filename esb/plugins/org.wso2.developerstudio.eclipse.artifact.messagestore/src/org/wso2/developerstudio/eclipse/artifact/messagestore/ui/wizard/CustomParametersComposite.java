/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.messagestore.ui.wizard;

import java.util.Collections;
import java.util.List;
import java.util.Observable;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.artifact.messagestore.model.MessageStoreModel;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractComposite;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectOptionData;


public class CustomParametersComposite extends AbstractComposite {
	private Table tblParameters;
	private Button btnRemove;
	private Button btnAdd;
	private MessageStoreModel model;

	public CustomParametersComposite(Composite parent, int style,
			ProjectDataModel model, ProjectOptionData optionData,
			WizardPage wizardPage) {
		super(parent, style, model, optionData, wizardPage);
		setLayout(new GridLayout(2, false));
		this.model = (MessageStoreModel) model;
		
		Label lblParameters = new Label(this, SWT.NONE);
		lblParameters.setText("Parameters");
		new Label(this, SWT.NONE);
		
		tblParameters = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		GridData gd_tblParameters = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 2);
		gd_tblParameters.widthHint = 439;
		gd_tblParameters.heightHint = 125;
		tblParameters.setLayoutData(gd_tblParameters);
		tblParameters.setHeaderVisible(true);
		tblParameters.setLinesVisible(true);
		
		TableColumn tblclmnName = new TableColumn(tblParameters, SWT.NONE);
		tblclmnName.setWidth(154);
		tblclmnName.setText("Name");
		
		TableColumn tblclmnValue = new TableColumn(tblParameters, SWT.NONE);
		tblclmnValue.setWidth(100);
		tblclmnValue.setText("Value");
		
		btnAdd = new Button(this, SWT.NONE);
		btnAdd.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnAdd.setText("Add");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem item = new TableItem(tblParameters, SWT.NONE);
				item.setText(0,"parameter" + tblParameters.getItemCount());
				item.setText(1,"value");
				tblParameters.select(tblParameters.indexOf(item));
				updateParameters();
			}
		});
		
		btnRemove = new Button(this, SWT.NONE);
		btnRemove.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		btnRemove.setText("Remove");
		btnRemove.setEnabled(false);
		btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tblParameters.getSelectionIndex();
				if (-1 != selectedIndex) {
					tblParameters.remove(selectedIndex);

					// Select the next available candidate for deletion.
					if (selectedIndex < tblParameters.getItemCount()) {
						tblParameters.select(selectedIndex);
					} else {
						tblParameters.select(selectedIndex - 1);
					}
				}
				btnRemove.setEnabled(tblParameters.getItemCount()>0);
				updateParameters();
			}
		});
		
		tblParameters.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnRemove.setEnabled(tblParameters.getItemCount()>0);
			}
		});
		tblParameters.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				updateParameters();
			}
		});
		
		// In-line editing of properties.
		setupTableEditor(tblParameters);

	}

	@Override
	public void update(Observable o, Object arg) {
		// nothing to do

	}


	@Override
	public List<String> getCustomFields() {
		// nothing to do
		return Collections.emptyList();
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
				updateParameters();
			}
		});
	}
	
	private void updateParameters(){
		model.getCustomParameters().clear();
		for (TableItem item : tblParameters.getItems()) {
			model.getCustomParameters().put(item.getText(0), item.getText(1));
		}
	}

}

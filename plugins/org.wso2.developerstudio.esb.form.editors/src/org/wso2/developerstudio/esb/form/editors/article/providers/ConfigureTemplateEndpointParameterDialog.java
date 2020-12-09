 /*
  * Copyright 2016 WSO2, Inc. (http://wso2.com)
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
 
package org.wso2.developerstudio.esb.form.editors.article.providers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpointParameter;

public class ConfigureTemplateEndpointParameterDialog extends Dialog {

	
	/**
	 * Table for add/edit/remove parameters.
	 */
	private Table paramTable;
	/**
	 * Button for add new parameter.
	 */
	private Button newParamButton;
	/**
	 * Button for remove parameter.
	 */
	private Button removeParamButton;

	private TableEditor paramNameEditor;
	private TableEditor paramValueEditor;
	private Text txtParamName;
	private Text paramValue;
	private List<TemplateEndpointParameter> templateParameterList = new ArrayList<TemplateEndpointParameter>();
	private String name = null;
	private String uri = null;

	public ConfigureTemplateEndpointParameterDialog(Shell parentShell, List<TemplateEndpointParameter> list,
			String name, String uri) {
		super(parentShell);

		// When updating an existing property, then get the property list
		if (list != null) {
			templateParameterList = list;
		} else {
			// When adding properties initially, create a new list
			list = new ArrayList<TemplateEndpointParameter>();
		}

		// Assigning name and uri
		if (StringUtils.isNotEmpty(name)) {
			this.name = name;
		}
		if (StringUtils.isNotEmpty(uri)) {
			this.uri = uri;
		}

	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Template Endpoint Parameter Configuration");
	}

	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);

		// Button for add new parameter.
		newParamButton = new Button(container, SWT.NONE);
		newParamButton.setText("New...");
		FormData newLogPropertyButtonLayoutData = new FormData(80, SWT.DEFAULT);
		newLogPropertyButtonLayoutData.right = new FormAttachment(100);
		newParamButton.setLayoutData(newLogPropertyButtonLayoutData);

		newParamButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				TableItem item = bindParam(EsbFactory.eINSTANCE.createTemplateEndpointParameter());
				paramTable.select(paramTable.indexOf(item));
			}
		});

		// Button for remove parameter.
		removeParamButton = new Button(container, SWT.NONE);
		removeParamButton.setText("Remove");
		FormData removeLogPropertyButtonLayoutData = new FormData();
		removeLogPropertyButtonLayoutData.top = new FormAttachment(newParamButton, 5);
		removeLogPropertyButtonLayoutData.right = new FormAttachment(100);
		removeLogPropertyButtonLayoutData.left = new FormAttachment(newParamButton, 0, SWT.LEFT);
		removeParamButton.setLayoutData(removeLogPropertyButtonLayoutData);

		removeParamButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				int selectedIndex = paramTable.getSelectionIndex();
				if (-1 != selectedIndex) {
					initTableEditor(paramNameEditor, paramTable);
					initTableEditor(paramValueEditor, paramTable);
					unbindParam(selectedIndex);

					// Select the next available candidate for deletion.
					if (selectedIndex < paramTable.getItemCount()) {
						paramTable.select(selectedIndex);
					} else {
						paramTable.select(selectedIndex - 1);
					}
				}
			}
		});

		// Table for show the parameters.
		paramTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION | SWT.HIDE_SELECTION);

		TableColumn nameColumn = new TableColumn(paramTable, SWT.LEFT);
		TableColumn valueColumn = new TableColumn(paramTable, SWT.LEFT);
		nameColumn.setText("Name");
		nameColumn.setWidth(150);
		valueColumn.setText("Value");
		valueColumn.setWidth(200);

		paramTable.setHeaderVisible(true);
		paramTable.setLinesVisible(true);

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

		paramTable.addListener(SWT.Selection, tblPropertiesListener);

		// Populate params
		// Adding the name and uri
		
		if (templateParameterList.size() > 0) {
			for (TemplateEndpointParameter property : templateParameterList) {
				bindParam(property);
			}
		}else{
			bindParam(name, uri);
		}

		// setupTableEditor(paramTable);

		FormData logPropertiesTableLayoutData = new FormData(SWT.DEFAULT, 150);
		logPropertiesTableLayoutData.top = new FormAttachment(newParamButton, 0, SWT.TOP);
		logPropertiesTableLayoutData.left = new FormAttachment(0);
		logPropertiesTableLayoutData.right = new FormAttachment(newParamButton, -5);
		logPropertiesTableLayoutData.bottom = new FormAttachment(100);
		paramTable.setLayoutData(logPropertiesTableLayoutData);

		return parent;

	}

	private TableItem bindParam(TemplateEndpointParameter param) {
		TableItem item = new TableItem(paramTable, SWT.NONE);
		item.setText(new String[] { param.getParameterName(), param.getParameterValue() });

		item.setData(param);
		return item;
	}

	private TableItem bindParam(String name, String uri) {
		TableItem item = new TableItem(paramTable, SWT.NONE);
		if (StringUtils.isNotEmpty(name)) {
			item.setText(0, name);
		}
		if (StringUtils.isNotEmpty(uri)) {
			item.setText(1, uri);
		}
		return item;
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

	private void unbindParam(int itemIndex) {
		TableItem item = paramTable.getItem(itemIndex);
		TemplateEndpointParameter param = (TemplateEndpointParameter) item.getData();
		removeTaskProperty(param);
		paramTable.remove(paramTable.indexOf(item));
	}

	private void removeTaskProperty(TemplateEndpointParameter param) {
		if (param != null) {
			for (TemplateEndpointParameter propertyItem : templateParameterList) {
				if (propertyItem.getParameterName().equals(param.getParameterName())) {
					templateParameterList.remove(propertyItem);
					break;
				}
			}
		}
	}

	private void editItem(final TableItem item) {

		paramNameEditor = initTableEditor(paramNameEditor, item.getParent());
		txtParamName = new Text(item.getParent(), SWT.NONE);
		txtParamName.setText(item.getText(0));
		paramNameEditor.setEditor(txtParamName, item, 0);
		item.getParent().redraw();
		item.getParent().layout();
		txtParamName.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				item.setText(0, txtParamName.getText());
			}
		});

		paramValueEditor = initTableEditor(paramValueEditor, item.getParent());
		paramValue = new Text(item.getParent(), SWT.NONE);
		paramValue.setText(item.getText(1));
		paramValueEditor.setEditor(paramValue, item, 1);
		item.getParent().redraw();
		item.getParent().layout();
		paramValue.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				item.setText(1, paramValue.getText());
			}
		});

	}

	protected void okPressed() {
		for (TableItem item : paramTable.getItems()) {

			TemplateEndpointParameter parameter = null;

			if (item.getData() == null) {
				parameter = EsbFactory.eINSTANCE.createTemplateEndpointParameter();
				parameter.setParameterName(item.getText(0));
				parameter.setParameterValue(item.getText(1));					
			} else {
				parameter = (TemplateEndpointParameter) item.getData();
				parameter.setParameterName(item.getText(0));
				parameter.setParameterValue(item.getText(1));	

			}

			for (TemplateEndpointParameter propertyItem : templateParameterList) {
				// When updating the existing properties, remove the old
				// property
				if (propertyItem.getParameterName().equals(parameter.getParameterName())) {
					templateParameterList.remove(propertyItem);
					break;
				}
			}
			templateParameterList.add(parameter);
			
			if(item.getText(0).equals("name")){
				this.name = item.getText(1);
			}
			if(item.getText(0).equals("uri")){
				this.uri = item.getText(1);
			}
			
		}
		setTemplateParameterList(templateParameterList);

		super.okPressed();

	}
	
	public void setTemplateParameterList(List<TemplateEndpointParameter> templateParameterList) {
		this.templateParameterList = templateParameterList;

	}

	public List<TemplateEndpointParameter> getTemplateParameterList() {
		return templateParameterList;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getURI() {
		return uri;
	}

	public void setURI(String uri) {
		this.uri = uri;
	}

}
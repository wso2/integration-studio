/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.registry.base.ui.editor.pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.developerstudio.eclipse.platform.ui.utils.MessageDialogUtils;
import org.wso2.developerstudio.eclipse.registry.base.core.Registry;
import org.wso2.developerstudio.eclipse.registry.base.editor.input.ResourceEditorInput;
import org.wso2.developerstudio.eclipse.registry.base.interfaces.IRegistryFormEditorPage;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.ui.editor.RegistryResourceEditor;
import org.wso2.developerstudio.eclipse.registry.core.exception.InvalidRegistryURLException;
import org.wso2.developerstudio.eclipse.registry.core.exception.UnknownRegistryException;

public class PropertiesEditorPage extends FormPage implements
		IResourceChangeListener, IRegistryFormEditorPage {

	private FormToolkit toolkit;
	private ScrolledForm form;

	private RegistryResourceEditor editor;
	private RegistryResourceNode regResourcePathData;
	private Table table;
	private TableViewer viewer;
	private HashMap<String, String> propertyMap;

	private String name;
	private Registry registry;

	private String value;

	private String key;
	private boolean pageDirty;

	private String[] titles = { "Name", "Value" };
	private ResourceEditorInput editorInput;

	private Button deleteButton;
	private Button btnOk;

	public PropertiesEditorPage(RegistryResourceEditor editor, String id, String title) {
		super(editor, id, title);
		this.editor = editor;
		propertyMap = new HashMap<String, String>();
		editorInput = (ResourceEditorInput) editor.getEditorInput();
	}

	public void resourceChanged(IResourceChangeEvent arg0) {

	}

	protected void createFormContent(IManagedForm managedForm) {
		toolkit = managedForm.getToolkit();
		form = managedForm.getForm();
		toolkit.decorateFormHeading(form.getForm());
		form.getForm();
		form.getBody().setLayout(new GridLayout());

		Composite columnComp = toolkit.createComposite(form.getBody());
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.verticalSpacing = 0;
		layout.horizontalSpacing = 10;
		layout.marginWidth = 10;
		layout.horizontalSpacing = 5;
		layout.verticalSpacing = 10;
		columnComp.setLayout(layout);
		columnComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_FILL));

		deleteButton = toolkit.createButton(columnComp, "Delete Property",
				SWT.PUSH);
		GridData gd = new GridData();
		gd.heightHint = 27;
		gd.widthHint = 200;
		deleteButton.setLayoutData(gd);

		Label hiddenLabel = toolkit.createLabel(columnComp, "");
		hiddenLabel.setVisible(false);
		hiddenLabel.setLayoutData(new GridData());

		table = toolkit.createTable(columnComp, SWT.BORDER | SWT.V_SCROLL
				| SWT.MULTI | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		data.heightHint = 300;
		table.setLayoutData(data);

		TableLayout tableLayout = new TableLayout();
		table.setLayout(tableLayout);

		tableLayout.addColumnData(new ColumnWeightData(10, 100, true));
		TableColumn column = new TableColumn(table, SWT.NONE);
		column.setText(titles[0]);
		column.setAlignment(SWT.LEFT);

		tableLayout.addColumnData(new ColumnWeightData(15, 200, true));
		column = new TableColumn(table, SWT.NONE);
		column.setText(titles[1]);
		column.setAlignment(SWT.LEFT);

		viewer = new TableViewer(table);
		viewer.setColumnProperties(titles);
		viewer.setContentProvider(new TableContentProvider());
		viewer.setLabelProvider(new TableLabelProvider());

		CellEditor[] editors = new CellEditor[2];
		editors[0] = new TextCellEditor(table);
		editors[1] = new TextCellEditor(table);
		
		editors[0].getControl().addTraverseListener(new TraverseListener() {
			
			public void keyTraversed(TraverseEvent evt) {
				if( evt.detail== SWT.TRAVERSE_TAB_NEXT||evt.detail== SWT.TRAVERSE_RETURN){
					evt.doit = true;
					evt.detail = SWT.TRAVERSE_NONE;
					viewer.editElement(viewer.getElementAt(viewer.getTable().getSelectionIndex()),1);
				}
				
			}
		});
		
		editors[1].getControl().addTraverseListener(new TraverseListener() {
			
			public void keyTraversed(TraverseEvent evt) {
				if( evt.detail== SWT.TRAVERSE_TAB_NEXT||evt.detail== SWT.TRAVERSE_RETURN){
					evt.doit = true;
					evt.detail = SWT.TRAVERSE_NONE;
					viewer.editElement(viewer.getElementAt(viewer.getTable().getSelectionIndex()+1),0);
				}
				
			}
		});
		
		viewer.setCellEditors(editors);
		viewer.setCellModifier(new TableCellModifier());

		deleteButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent arg0) {
			}

			public void widgetSelected(SelectionEvent arg0) {
				deleteProperty();
			}
		});

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent arg0) {
				updateDeleteButton();
			}

		});
		updateDeleteButton();
		loadData();
		
		Label lblEmpty=toolkit.createLabel(columnComp, "");
		btnOk=toolkit.createButton(columnComp, " Save ", SWT.BUTTON1 | SWT.BORDER);
		btnOk.addListener(SWT.Selection, new Listener() {
			
			public void handleEvent(Event arg0) {
				try {
	                doFinish();
//	                refreshPage();
                } catch (Exception e) {
	                e.printStackTrace();
                }
			}
		});
		
		btnOk.setEnabled(false);
	}

	private void deleteProperty() {
		if (table.getSelectionIndex() == -1)
			return;
		TableItem item = table.getItem(table.getSelectionIndex());
		PropertyData propertyData = (PropertyData) item.getData();
		if (propertyData.isDeleted) {
			propertyData.isDeleted = false;
		} else {
			propertyData.isDeleted = true;
		}
		updateTableItem(item);
		updateDirtyState();
	}

	private void updateTableItem(TableItem item) {
		PropertyData propertyData = (PropertyData) item.getData();
		if (propertyData.isDeleted) {
			item.setForeground(Display.getDefault().getSystemColor(
					SWT.COLOR_GRAY));
		} else {
			item.setForeground(Display.getDefault().getSystemColor(
					SWT.COLOR_BLACK));
		}
		updateDeleteButton();
	}

	private void loadData() {
		regResourcePathData = editorInput.getResource();
		table.removeAll();
		Resource resource = null;
		try {
			resource = regResourcePathData.getConnectionInfo().getRegistry()
					.getResourcesPerCollection(regResourcePathData.getRegistryResourcePath());
			Properties properties = resource.getProperties();
			for (Enumeration e = properties.keys(); e.hasMoreElements(); /**/) {
				String key = (String) e.nextElement();
				String value = resource.getPropertyValues(key).get(0) == null ? ""
						: resource.getPropertyValues(key).get(0).toString();
				if (!key.startsWith("registry")) {
					PropertyData propData = PropertyData.getPropertyData(key, value, true);
					TableItem tableItem = new TableItem(table, SWT.NONE);
					tableItem.setText(new String[] { key, value });
					tableItem.setData(propData);
				}

			}
			addProperty();
		} catch (Exception e) {
			MessageDialogUtils.error(getSite().getShell(), e);
		}
		
	}

	private void updateDeleteButton() {
		PropertyData currentSelectedPropertyData = getCurrentSelectedPropertyData();
		if (currentSelectedPropertyData == null)
			deleteButton.setEnabled(false);
		else {
			deleteButton.setEnabled(true);
			if (currentSelectedPropertyData.isDeleted)
				deleteButton.setText("Undelete Property");
			else
				deleteButton.setText("Delete Property");
		}
	}

	private PropertyData getCurrentSelectedPropertyData() {
		if (table.getSelectionIndex() == -1)
			return null;
		TableItem item = table.getItem(table.getSelectionIndex());
		if (item != null)
			return (PropertyData) item.getData();
		else
			return null;
	}

	public void doFinish() throws InvalidRegistryURLException, UnknownRegistryException{
		regResourcePathData = editorInput.getResource();
		registry = regResourcePathData.getConnectionInfo().getRegistry();

		String selectedPath = regResourcePathData.getRegistryResourcePath();
		Resource resource = registry.get(selectedPath);

		TableItem[] items = table.getItems();

		Properties properties = resource.getProperties();
		for (Enumeration e = properties.keys(); e.hasMoreElements(); /**/) {
			String key = (String) e.nextElement();
			resource.removeProperty(key);
		}
		for (TableItem tableItem : items) {
			PropertyData propertyData = (PropertyData) tableItem.getData();
			boolean n = propertyData.isNew();
			boolean b = propertyData.isBlank();
			boolean c = propertyData.isChanged();
			boolean d = propertyData.isDeleted;
			boolean dirtyState = !(d || b);
			if (dirtyState)
				resource.addProperty(propertyData.propName,
						propertyData.propVal);
		}
		registry.put(selectedPath, resource);
		loadData();
		updateDirtyState();

	}

	private void updateDirtyState() {
		boolean dirtyState = false;
		TableItem[] items = table.getItems();
		for (TableItem tableItem : items) {
			PropertyData propertyData = (PropertyData) tableItem.getData();
			boolean n = propertyData.isNew();
			boolean b = propertyData.isBlank();
			boolean c = propertyData.isChanged();
			boolean d = propertyData.isDeleted;
			dirtyState = (!n && ((!b && c) || b)) || (n && !b) || (!n && d);
			if (dirtyState)
				break;
		}
		setPageDirty(dirtyState);
		
		// Enabling Save button if delta exists
		if (btnOk != null) {
			btnOk.setEnabled(dirtyState);
		}
	}

	public void validateProperty() throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		for (TableItem item : table.getItems()) {
			PropertyData propertyData = (PropertyData) item.getData();
			if (propertyData.propName == null || propertyData.propVal == null) {
				throw new Exception("Both name and value should be specified.");
			}

			if (!propertyData.isDeleted) {
				String val = propertyData.propName + "$$$$$$$$$$"
						+ propertyData.propVal;
				if (list.contains(val))
					throw new Exception(
							"There are duplicate properties for Name: '"
									+ propertyData.propName + "' and Value: '"
									+ propertyData.propVal + "'");
				else
					list.add(val);
			}
		}
	}

	public void validate() throws Exception {
		validateProperty();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	class TableCellModifier implements ICellModifier {

		public boolean canModify(Object element, String arg1) {
			PropertyData row = (PropertyData) element;
			return !row.isDeleted;
		}

		public Object getValue(Object element, String property) {
			Object result = null;
			PropertyData row = (PropertyData) element;
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < titles.length; i++) {
				list.add(titles[i]);
			}
			int columnIndex = list.indexOf(property);
			switch (columnIndex) {
			case 0:
				result = row.propName;
				break;
			case 1:
				result = row.propVal;
				break;
			}
			return result;
		}

		public void modify(Object element, String property, Object value) {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < titles.length; i++) {
				list.add(titles[i]);
			}
			int columnIndex = list.indexOf(property);

			TableItem tableItem = (TableItem) element;
			PropertyData row = (PropertyData) tableItem.getData();

			switch (columnIndex) {
			case 0:
				String key = (String) value;
				if (key.length() > 0) {
					row.propName = key;

				}
				break;

			case 1:
				String v = (String) value;
				if (v.length() > 0) {
					row.propVal = v;
				}
				break;
			}
			if (row.isBlank()) {
				if (tableItem != table.getItem(table.getItemCount() - 1)) {

				}
			} else {
				TableItem item = table.getItem(table.getItemCount() - 1);
				PropertyData lastPropertyData = (PropertyData) item.getData();
				if (!lastPropertyData.isBlank())
					addProperty();
			}
			updateDirtyState();
			viewer.update(row, null);

		}

	}

	public static class PropertyData {
		String currentName;
		String currentVal;
		String propName = "";
		String propVal = "";
		boolean isDeleted = false;

		public static PropertyData getPropertyData(String cName, String cVal,
				boolean isCurrent) {
			PropertyData propertyData = new PropertyData();
			if (isCurrent) {
				propertyData.currentName = cName;
				propertyData.currentVal = cVal;
			}
			propertyData.propName = cName;
			propertyData.propVal = cVal;
			return propertyData;
		}

		public boolean isNew() {
			return currentName == null || currentVal == null;
		}

		public boolean isChanged() {
			return currentName == null || currentVal == null
					|| !currentName.equals(propName)
					|| !currentVal.equals(propVal);
		}

		public boolean isBlank() {
			return propName.equals("") && propVal.equals("");
		}
	}

	protected boolean canEdit(Object element) {
		return true;
	}

	public RegistryResourceNode getRegResourcePathData() {
		return regResourcePathData;
	}

	public void setRegResourcePathData(
			RegistryResourceNode regResourcePathData) {
		this.regResourcePathData = regResourcePathData;
	}

	public class TableContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object parent) {
			regResourcePathData = editorInput.getResource();

			Resource resource = null;
			try {
				resource = regResourcePathData.getConnectionInfo()
						.getRegistry().getResourcesPerCollection(
								regResourcePathData.getRegistryResourcePath());
				Properties properties = resource.getProperties();
				for (Enumeration e = properties.keys(); e.hasMoreElements(); /**/) {
					String key = (String) e.nextElement();
					String value = resource.getPropertyValues(key).get(0) == null ? ""
							: resource.getPropertyValues(key).get(0).toString();
					propertyMap.put(key, value);
				}
				Collection results = new ArrayList();
				if (parent instanceof Properties) {
					results = ((Properties) parent).values();
				}
				return results.toArray();
			} catch (Exception e) {
				MessageDialogUtils.error(getSite().getShell(), e);
			}
			return null;

		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

	}

	public class TableLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			PropertyData row = (PropertyData) element;

			switch (columnIndex) {
			case 0:
				return row.propName;
			case 1:
				return row.propVal;
			}

			return null;
		}

	}

	public void executeAction(int actionID, Object object) {
		switch (actionID) {
		case IRegistryFormEditorPage.ACTION_ADD_PROPERTY:
			focusToLastRow();
			break;
		}

	}

	private void focusToLastRow() {
		TableItem item = table.getItem(table.getItemCount() - 1);
		PropertyData propData = (PropertyData) item.getData();
		viewer.editElement(propData, 0);
	}

	public int getPageType() {
		return IRegistryFormEditorPage.PAGE_PROPERTIES;
	}

	public void addProperty() {
		PropertyData propertyData = PropertyData.getPropertyData("", "", false);
		viewer.add(propertyData);
		TableItem item = table.getItem(table.getItemCount() - 1);
		item.setData(propertyData);
		table.setTopIndex(table.getItemCount());
		viewer.editElement(propertyData, 0);
	}

	public void setPageDirty(boolean pageDirty) {
		this.pageDirty = pageDirty;
		editor.updateDirtyState();
	}

	public boolean isPageDirty() {
		return pageDirty;
	}

}

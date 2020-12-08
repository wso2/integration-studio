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

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
import org.wso2.carbon.registry.core.Association;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.utils.MessageDialogUtils;
import org.wso2.developerstudio.eclipse.registry.base.Activator;
import org.wso2.developerstudio.eclipse.registry.base.core.Registry;
import org.wso2.developerstudio.eclipse.registry.base.core.RegistryAssociation;
import org.wso2.developerstudio.eclipse.registry.base.editor.input.ResourceEditorInput;
import org.wso2.developerstudio.eclipse.registry.base.interfaces.IRegistryFormEditorPage;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.ui.controls.TextRegistryTreeDialogCellEditor;
import org.wso2.developerstudio.eclipse.registry.base.ui.editor.RegistryResourceEditor;
import org.wso2.developerstudio.eclipse.registry.core.exception.InvalidRegistryURLException;
import org.wso2.developerstudio.eclipse.registry.core.exception.UnknownRegistryException;

public class DependencyEditorPage extends FormPage implements
		IResourceChangeListener, IRegistryFormEditorPage {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private FormToolkit toolkit;
	private ScrolledForm form;
	private RegistryResourceEditor editor;
	private Table table;
	private TableViewer viewer;
	private RegistryResourceNode regResourcePathData;
	private static final String DEPENDENCY_ASSOCIATION_TYPE = "depends";
	String[] titles = { "Dependencies" };
	private Registry registry;
	private ResourceEditorInput editorInput;
	private boolean pageDirty;
	private Button deleteButton;
	private Button btnOk;

	public DependencyEditorPage(RegistryResourceEditor editor, String id, String title) {
		super(editor, id, title);
		this.editor = editor;
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

		deleteButton = toolkit.createButton(columnComp, "Delete Dependency",
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

		viewer = new TableViewer(table);
		viewer.setColumnProperties(titles);
		viewer.setContentProvider(new TableContentProvider());
		viewer.setLabelProvider(new TableLabelProvider());

		CellEditor[] editors = new CellEditor[1];
		RegistryNode registryNode = editorInput.getResource()==null? editorInput.getParentResource().getConnectionInfo():editorInput.getResource().getConnectionInfo();
		editors[0] = new TextRegistryTreeDialogCellEditor(table,new LabelProvider(),registryNode);
		
		TraverseListener traverseListener = new TraverseListener() {
			
			public void keyTraversed(TraverseEvent evt) {
				if( evt.detail== SWT.TRAVERSE_TAB_NEXT||evt.detail== SWT.TRAVERSE_RETURN){
					evt.doit = true;
					try {
						viewer.editElement(viewer.getElementAt(viewer.getTable().getSelectionIndex()+1),0);
						evt.detail = SWT.TRAVERSE_NONE;
					} catch (Exception e) {
						
					}
				}
				
			}
		};
		
		((TextRegistryTreeDialogCellEditor)editors[0]).addTextTraverseListener(traverseListener);
		
		viewer.setCellEditors(editors);
		viewer.setCellModifier(new TableCellModifier());

		deleteButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent arg0) {
			}

			public void widgetSelected(SelectionEvent arg0) {
				deleteDependency();
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

	private void deleteDependency() {
		TableItem item = table.getItem(table.getSelectionIndex());
		DependencyData dependencyData = (DependencyData) item.getData();
		if (dependencyData.isDeleted) {
			dependencyData.isDeleted = false;
		} else {
			dependencyData.isDeleted = true;
		}
		updateTableItem(item);
		updateDirtyState();
	}

	private void updateTableItem(TableItem item) {
		DependencyData dependencyData = (DependencyData) item.getData();
		if (dependencyData.isDeleted) {
			item.setForeground(Display.getDefault().getSystemColor(
					SWT.COLOR_GRAY));
		} else {
			item.setForeground(Display.getDefault().getSystemColor(
					SWT.COLOR_BLACK));
		}
		updateDeleteButton();
	}

	private void updateDeleteButton() {
		DependencyData currentSelectedDepData = getCurrentSelectedDepData();
		if (currentSelectedDepData == null)
			deleteButton.setEnabled(false);
		else {
			deleteButton.setEnabled(true);
			if (currentSelectedDepData.isDeleted)
				deleteButton.setText("Undelete Dependency");
			else
				deleteButton.setText("Delete Dependency");
		}
	}

	private DependencyData getCurrentSelectedDepData() {
		if (table.getSelectionIndex() == -1)
			return null;
		TableItem item = table.getItem(table.getSelectionIndex());
		if (item != null)
			return (DependencyData) item.getData();
		else
			return null;
	}

	private void updateDirtyState() {
		boolean dirtyState = false;
		TableItem[] items = table.getItems();
		for (TableItem tableItem : items) {
			DependencyData depData = (DependencyData) tableItem.getData();
			boolean n = depData.isNew();
			boolean b = depData.isBlank();
			boolean c = depData.isChanged();
			boolean d = depData.isDeleted;
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

	public void validateDependency() throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		for (TableItem item : table.getItems()) {
			DependencyData depData = (DependencyData) item.getData();
			if (depData.dep == null) {
				throw new Exception("Dependency should be specified.");
			}
			if (depData.dep != null) {
				registry = regResourcePathData.getConnectionInfo()
						.getRegistry();
				if (!registry.resourceExists(depData.dep)) {
					URI depUri = new URI(depData.dep);
					URL url = depUri.toURL();
					if(((HttpURLConnection) url.openConnection()).getResponseCode() < 0){
						throw new Exception("Specified dependency path "
											+ depData.dep + " is not valid.");
					}

				}
			}
			if (!depData.isDeleted) {
				String val = depData.dep;
				if (list.contains(val))
					throw new Exception("There are duplicate dependencies '"
							+ depData.dep + "' for path: '"
							+ regResourcePathData.getRegistryResourcePath()
							+ "'");
				else
					list.add(val);
			}
		}
	}

	public void doFinish() throws InvalidRegistryURLException, UnknownRegistryException{
		regResourcePathData = editorInput.getResource();
		registry = regResourcePathData.getConnectionInfo().getRegistry();
		String selectedPath = regResourcePathData.getRegistryResourcePath();

		TableItem[] items = table.getItems();
		RegistryAssociation[] associations = null;
		associations = regResourcePathData.getConnectionInfo()
				.getRegistry().getAssociations(
						(regResourcePathData.getRegistryResourcePath()),
						DEPENDENCY_ASSOCIATION_TYPE);
		for (RegistryAssociation association : associations) {
			registry.removeAssociation(selectedPath, association
					.getDestinationPath(), DEPENDENCY_ASSOCIATION_TYPE);
		}
		for (TableItem tableItem : items) {
			DependencyData depData = (DependencyData) tableItem.getData();
			boolean n = depData.isNew();
			boolean b = depData.isBlank();
			boolean c = depData.isChanged();
			boolean d = depData.isDeleted;
			boolean dirtyState = !(d || b);
			if (dirtyState){
				registry.addAssociation(selectedPath, depData.dep,
						DEPENDENCY_ASSOCIATION_TYPE);
			}
		}
		loadData();
		updateDirtyState();
		
	}
	

	private void loadData() {
		regResourcePathData = editorInput.getResource();
		table.removeAll();
		RegistryAssociation[] associations = null;
		try {
			associations = regResourcePathData.getConnectionInfo()
					.getRegistry().getAssociations(
							(regResourcePathData.getRegistryResourcePath()),
							DEPENDENCY_ASSOCIATION_TYPE);
			for (RegistryAssociation association : associations) {
				if (association.getAssociationType().equals(
						DEPENDENCY_ASSOCIATION_TYPE) && !association.getDestinationPath().equals(regResourcePathData.getRegistryResourcePath())) {
					TableItem tableItem = new TableItem(table, SWT.NONE);
					DependencyData depData = DependencyData.getDependencyData(
							association.getDestinationPath(), true);
					tableItem.setText(new String[] { depData.currentDep });
					tableItem.setData(depData);

				}
			}
			addDependency();
		} catch (Exception e) {
			MessageDialogUtils.error(getSite().getShell(), e);
		}
		
	}

	public RegistryResourceNode getRegResourcePathData() {
		return regResourcePathData;
	}

	public void setRegResourcePathData(
			RegistryResourceNode regResourcePathData) {
		this.regResourcePathData = regResourcePathData;
	}

	public void validate() throws Exception {
		validateDependency();
	}

	public class TableContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object parent) {
			regResourcePathData = editorInput.getResource();

			RegistryAssociation[] associations = null;
			try {
				associations = regResourcePathData
						.getConnectionInfo()
						.getRegistry().getAssociations(
								(regResourcePathData.getRegistryResourcePath()),
								DEPENDENCY_ASSOCIATION_TYPE);
				List<String> results = new ArrayList();
				for (RegistryAssociation association : associations) {
					results.add(association.getDestinationPath());
				}
				if (parent instanceof Association) {
					results.add(((Association)parent).getDestinationPath());
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
			DependencyData row = (DependencyData) element;

			switch (columnIndex) {
			case 0:
				return row.dep;
			}

			return null;
		}

	}

	class TableCellModifier implements ICellModifier {

		public boolean canModify(Object element, String arg1) {
			DependencyData row = (DependencyData) element;
			return !row.isDeleted;
		}

		public Object getValue(Object element, String dependency) {
			Object result = null;
			DependencyData row = (DependencyData) element;
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < titles.length; i++) {
				list.add(titles[i]);
			}
			int columnIndex = list.indexOf(dependency);
			switch (columnIndex) {
			case 0:
				result = row.dep;
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
			DependencyData row = (DependencyData) tableItem.getData();

			switch (columnIndex) {
			case 0:
				String key = (String) value;
				if (key.length() > 0) {
					row.dep = key;
				}
				break;
			}

			if (row.isBlank()) {
				if (tableItem != table.getItem(table.getItemCount() - 1)) {
				}
			} else {
				TableItem item = table.getItem(table.getItemCount() - 1);
				DependencyData lastDepData = (DependencyData) item.getData();
				if (!lastDepData.isBlank())
					addDependency();
			}
			updateDirtyState();
			viewer.update(row, null);
		}

	}

	public void executeAction(int actionID, Object object) {
		switch (actionID) {
		case IRegistryFormEditorPage.ACTION_ADD_DEPENDENCY:
			focusToLastRow();
			break;
		}

	}

	private void focusToLastRow() {
		TableItem item = table.getItem(table.getItemCount() - 1);
		DependencyData depData = (DependencyData) item.getData();
		viewer.editElement(depData, 0);
	}

	public int getPageType() {
		return IRegistryFormEditorPage.PAGE_DEPENDENCY;
	}

	public void addDependency() {
		DependencyData depData = DependencyData.getDependencyData("", false);
		viewer.add(depData);
		TableItem item = table.getItem(table.getItemCount() - 1);
		item.setData(depData);
		table.setTopIndex(table.getItemCount());
		viewer.editElement(depData, 0);
	}

	public void setPageDirty(boolean pageDirty) {
		this.pageDirty = pageDirty;
		editor.updateDirtyState();
	}

	public boolean isPageDirty() {
		return pageDirty;
	}

	public static class DependencyData {
		String currentDep;
		String dep;
		boolean isDeleted = false;

		public static DependencyData getDependencyData(String cDep,
				boolean isCurrent) {
			DependencyData dependencyData = new DependencyData();
			if (isCurrent) {
				dependencyData.currentDep = cDep;
			}
			dependencyData.dep = cDep;
			return dependencyData;
		}

		public boolean isNew() {
			return currentDep == null;
		}

		public boolean isChanged() {
			return currentDep == null || !currentDep.equals(dep);
		}

		public boolean isBlank() {
			return dep.equals("");
		}

	}

}

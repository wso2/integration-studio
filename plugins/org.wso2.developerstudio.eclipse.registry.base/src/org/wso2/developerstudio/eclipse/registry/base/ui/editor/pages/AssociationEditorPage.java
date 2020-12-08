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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
import org.wso2.carbon.registry.core.Association;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.developerstudio.eclipse.platform.ui.utils.MessageDialogUtils;
import org.wso2.developerstudio.eclipse.registry.base.core.Registry;
import org.wso2.developerstudio.eclipse.registry.base.core.RegistryAssociation;
import org.wso2.developerstudio.eclipse.registry.base.editor.input.ResourceEditorInput;
import org.wso2.developerstudio.eclipse.registry.base.interfaces.IRegistryFormEditorPage;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.ui.controls.TextRegistryTreeDialogCellEditor;
import org.wso2.developerstudio.eclipse.registry.base.ui.editor.RegistryResourceEditor;
import org.wso2.developerstudio.eclipse.registry.base.util.EditorConstants;
import org.wso2.developerstudio.eclipse.registry.core.exception.InvalidRegistryURLException;
import org.wso2.developerstudio.eclipse.registry.core.exception.UnknownRegistryException;

public class AssociationEditorPage extends FormPage implements 
												IResourceChangeListener, IRegistryFormEditorPage {

	private FormToolkit toolkit;
	private ScrolledForm form;
	private RegistryResourceEditor editor;
	private ResourceEditorInput editorInput;
	private RegistryResourceNode regResourceNode;
	private Table table;
	private TableViewer viewer;
	private boolean pageDirty;

	private final static String[] titles = { "Path", "Type" };

	private Registry registry;
	private static HashMap<String, String> assocaitionMap;

	private HashMap<String, String> existingAssociationMap;
	private Button deleteButton;
	
	private Button btnOk;

	/**
	 * AssociationEditorPage constructor
	 * @param editor
	 * @param id
	 * @param title
	 */
	public AssociationEditorPage(RegistryResourceEditor editor, String id,String title) {
		super(editor, id, title);
		assocaitionMap = new HashMap<String, String>();
		this.editor = editor;
		editorInput = (ResourceEditorInput) editor.getEditorInput();
	}

	/**
	 * resource Changed
	 */
	public void resourceChanged(IResourceChangeEvent arg0) {

	}

	/**
	 * create Form Content
	 */
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
		columnComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL |
											  GridData.VERTICAL_ALIGN_FILL));

		deleteButton = toolkit.createButton(columnComp, "Delete Association",SWT.PUSH);
		GridData gd = new GridData();
		gd.heightHint = 27;
		gd.widthHint = 200;
		deleteButton.setLayoutData(gd);

		Label hiddenLabel = toolkit.createLabel(columnComp, "");
		hiddenLabel.setVisible(false);
		hiddenLabel.setLayoutData(new GridData());

		table = toolkit.createTable(columnComp, SWT.BORDER | 
												SWT.V_SCROLL | 
												SWT.MULTI | 
												SWT.FULL_SELECTION);
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
		RegistryNode registryNode = editorInput.getResource()==null? editorInput.getParentResource().getConnectionInfo():editorInput.getResource().getConnectionInfo();
		editors[0] = new TextRegistryTreeDialogCellEditor(table,new LabelProvider(),registryNode);
		editors[1] = new TextCellEditor(table);
		
		TraverseListener traverseListener = new TraverseListener() {
			
			public void keyTraversed(TraverseEvent evt) {
				if( evt.detail== SWT.TRAVERSE_TAB_NEXT||evt.detail== SWT.TRAVERSE_RETURN){
					evt.doit = true;
					evt.detail = SWT.TRAVERSE_NONE;
					viewer.editElement(viewer.getElementAt(viewer.getTable().getSelectionIndex()),1);
				}
				
			}
		};
		
		((TextRegistryTreeDialogCellEditor)editors[0]).addTextTraverseListener(traverseListener);
		
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

//		DropTarget dt = new DropTarget(viewer.getTable(), DND.DROP_MOVE);
//		dt.setTransfer(new Transfer[] { TextTransfer.getInstance() });
//
//		dt.addDropListener(new DropTargetAdapter() {
//			public void drop(DropTargetEvent event) {
////				RegistryResourceNode targetRegPathData = (RegistryResourceNode) event.item.getData();
//				System.out.println(event.data);
//				if (event.item instanceof TableItem){
//					TableItem tableItem=(TableItem)event.item;
//					String path = event.data.toString();
//					tableItem.setText(new String[]{path,tableItem.getText(1)});
//					AssociationData data=(AssociationData)tableItem.getData();
//					data.currentPath=path;
//					viewer.getTable().update();
//				}
//			}
//		});

		
		deleteButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent arg0) {
			}

			public void widgetSelected(SelectionEvent arg0) {
				deleteAssociation();
			}
		});

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent arg0) {
				updateDeleteButton();
			}

		});
		updateDeleteButton();
		try {
			loadData();
		} catch (Exception e) {
			MessageDialogUtils.error(getSite().getShell(), e);
		}
		
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

	/**
	 * load data for the form
	 * @throws RegistryException 
	 * @throws UnknownRegistryException 
	 * @throws InvalidRegistryURLException 
	 */
	private void loadData() throws InvalidRegistryURLException, UnknownRegistryException {
		regResourceNode = editorInput.getResource();
		table.removeAll();
		assocaitionMap = new HashMap<String, String>();
		RegistryAssociation[] associations = null;
			associations = regResourceNode.getConnectionInfo()
									.getRegistry().getAllAssociations(regResourceNode.getRegistryResourcePath());
		for (RegistryAssociation association : associations) {
			if (!association.getAssociationType().equalsIgnoreCase(
												EditorConstants.DEPENDENCY_ASSOCIATION_TYPE)) {
				if(!assocaitionMap.containsKey(association.getDestinationPath()) && !association.getDestinationPath().equals(regResourceNode.getRegistryResourcePath())){
					assocaitionMap.put(association.getDestinationPath(),
															association.getAssociationType());
					TableItem tableItem = new TableItem(table, SWT.NONE);
					AssociationData associationData = AssociationData.getAssociationData(
																	association.getDestinationPath(),
																	association.getAssociationType(), 
																	true);
					tableItem.setText(new String[] { associationData.currentPath,
													 associationData.currentType });
					tableItem.setData(associationData);
				}
			}
		}
		addAssociation();

	}

	/**
	 * delete Association
	 */
	private void deleteAssociation() {
		TableItem item = table.getItem(table.getSelectionIndex());
		AssociationData associationData = (AssociationData) item.getData();
		if (associationData.isDeleted) {
			associationData.isDeleted = false;
		} else {
			associationData.isDeleted = true;
		}
		updateTableItem(item);
		updateDirtyState();
	}

	/**
	 * update Table Item
	 * @param item
	 */
	private void updateTableItem(TableItem item) {
		AssociationData associationData = (AssociationData) item.getData();
		if (associationData.isDeleted) {
			item.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_GRAY));
		} else {
			item.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_BLACK));
		}
		updateDeleteButton();
	}

	/**
	 * update Delete Button
	 */
	private void updateDeleteButton() {
		AssociationData currentSelectedAssocationData = getCurrentSelectedAssocationData();
		if (currentSelectedAssocationData == null){
			deleteButton.setEnabled(false);
		}else {
			deleteButton.setEnabled(true);
			if (currentSelectedAssocationData.isDeleted){
				deleteButton.setText("Undelete Association");
			}else{
				deleteButton.setText("Delete Association");
			}
		}
	}

	/**
	 * get Current Selected Assocation Data
	 * @return
	 */
	private AssociationData getCurrentSelectedAssocationData() {
		if (table.getSelectionIndex() == -1){
			return null;
		}
		TableItem item = table.getItem(table.getSelectionIndex());
		if (item != null){
			return (AssociationData) item.getData();
		}else{
			return null;
		}
	}

	/**
	 * update page dirty state
	 */
	private void updateDirtyState() {
		boolean dirtyState = false;
		TableItem[] items = table.getItems();
		for (TableItem tableItem : items) {
			AssociationData associationData = (AssociationData) tableItem.getData();
			boolean n = associationData.isNew();
			boolean b = associationData.isBlank();
			boolean c = associationData.isChanged();
			boolean d = associationData.isDeleted;
			dirtyState = (!n && ((!b && c) || b)) || (n && !b) || (!n && d);
			if (dirtyState){
				break;
			}
		}
		setPageDirty(dirtyState);
		
		// Enabling Save button if delta exists
		if (btnOk != null) {
			btnOk.setEnabled(dirtyState);
		}
	}

	/**
	 * validate Associations
	 * @throws Exception
	 */
	public void validateAssociations() throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		for (TableItem item : table.getItems()) {
			AssociationData associationData = (AssociationData) item.getData();
			if (associationData.path == null || associationData.type == null) {
				throw new Exception("Both path and type should be specified.");
			}
			if (associationData.path != null) {
				registry = regResourceNode.getConnectionInfo().getRegistry();
				Registry remoteReg = registry;
				if (!remoteReg.resourceExists(associationData.path)) {
					URI associationUri = new URI(associationData.path);
					URL url = associationUri.toURL();
					if(((HttpURLConnection) url.openConnection()).getResponseCode() < 0){
						throw new Exception("Specified association path "
											+ associationData.path + " is not valid.");
					}
				}
			}
			if (!associationData.isDeleted) {
				String val = associationData.path + "$$$$$$$$$$" + associationData.type;
				if (list.contains(val)){
					throw new Exception("There are duplicate associations for Path: '" + 
										 associationData.path + 
										 "' and Type: '" + 
										 associationData.type + 
										 "'");
				}else{
					list.add(val);
				}
			}
		}
	}

	/**
	 * get Existing Association List
	 * @return
	 * @throws UnknownRegistryException 
	 * @throws InvalidRegistryURLException 
	 */
	public HashMap<String, String> getExistingAssociationList() throws InvalidRegistryURLException, UnknownRegistryException, RegistryException{
		existingAssociationMap = new HashMap<String, String>();
		regResourceNode = editorInput.getResource();
		registry = regResourceNode.getConnectionInfo().getRegistry();
		RegistryAssociation[] associations = null;
			associations = regResourceNode.getConnectionInfo()
											.getRegistry().getAllAssociations(
													regResourceNode.getRegistryResourcePath());

		for (RegistryAssociation association : associations) {
			if (!association.getAssociationType().equalsIgnoreCase(
													EditorConstants.DEPENDENCY_ASSOCIATION_TYPE)) {
				existingAssociationMap.put(association.getDestinationPath(),
										   association.getAssociationType());
			}
		}

		return existingAssociationMap;

	}

	/**
	 * validate info entered for the page
	 */
	public void validate() throws Exception {
		validateAssociations();
	}

	/**
	 * finish work on assaciation page
	 * @throws UnknownRegistryException 
	 * @throws InvalidRegistryURLException 
	 */
	public void doFinish() throws InvalidRegistryURLException, UnknownRegistryException{
		regResourceNode = editorInput.getResource();
		Registry registry = regResourceNode.getConnectionInfo().getRegistry();

		String selectedPath = regResourceNode.getRegistryResourcePath();
		TableItem[] items = table.getItems();

		RegistryAssociation[] associations = null;
		associations = registry.getAllAssociations(regResourceNode.getRegistryResourcePath());
		for (RegistryAssociation association : associations) {
			if (!association.getAssociationType().equalsIgnoreCase(
													EditorConstants.DEPENDENCY_ASSOCIATION_TYPE)) {
				registry.removeAssociation(selectedPath, 
											 association.getDestinationPath(), 
											 association.getAssociationType());
			}
		}
		for (TableItem tableItem : items) {
			AssociationData associationData = (AssociationData) tableItem.getData();
			boolean n = associationData.isNew();
			boolean b = associationData.isBlank();
			boolean c = associationData.isChanged();
			boolean d = associationData.isDeleted;
			boolean dirtyState = !(d || b);
			if (dirtyState){
				registry.addAssociation(selectedPath, associationData.path,associationData.type);
			}
		}
		loadData();
		updateDirtyState();
	}

	/**
	 * get RegResourceNode
	 * @return
	 */
	public RegistryResourceNode getRegResourceNode() {
		return regResourceNode;
	}

	/**
	 * set RegResourceNode
	 * @param regResourceNode
	 */
	public void setRegResourceNode(RegistryResourceNode regResourceNode) {
		this.regResourceNode = regResourceNode;
	}

	/**
	 * TableCellModifier inner class
	 * 
	 *
	 */
	class TableCellModifier implements ICellModifier {

		public boolean canModify(Object element, String arg1) {
			AssociationData row = (AssociationData) element;
			return !row.isDeleted;
		}

		public Object getValue(Object element, String property) {
			Object result = null;
			AssociationData row = (AssociationData) element;
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < titles.length; i++) {
				list.add(titles[i]);
			}
			int columnIndex = list.indexOf(property);
			switch (columnIndex) {
			case 0:
				result = row.path;
				break;
			case 1:
				result = row.type;
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
			AssociationData row = (AssociationData) tableItem.getData();

			switch (columnIndex) {
			case 0:
				String key = (String) value;
				if (key.length() > 0) {
					row.path = key;
				}
				break;

			case 1:
				String v = (String) value;
				if (v.length() > 0) {
					row.type = v;
				}
				break;
			}
			if (row.isBlank()) {
				if (tableItem != table.getItem(table.getItemCount() - 1)) {
				}
			} else {
				TableItem item = table.getItem(table.getItemCount() - 1);
				AssociationData lastAssociationData = (AssociationData) item.getData();
				if (!lastAssociationData.isBlank()){
					addAssociation();
				}
			}
			updateDirtyState();
			viewer.update(row, null);

		}

	}

	/**
	 * TableContentProvider inner class
	 * 
	 *
	 */
	public class TableContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object parent) {
			assocaitionMap = new HashMap<String, String>();
			regResourceNode = editorInput.getResource();
			RegistryAssociation[] associations = null;
			try {
				associations = regResourceNode.getConnectionInfo()
									.getRegistry().getAllAssociations(
													 regResourceNode.getRegistryResourcePath());
				for (RegistryAssociation association : associations) {
					if (!association.getAssociationType().equalsIgnoreCase(
														EditorConstants.DEPENDENCY_ASSOCIATION_TYPE)) {
						if(!assocaitionMap.containsKey(association.getDestinationPath())){
							assocaitionMap.put(association.getDestinationPath(),
																	association.getAssociationType());
						}
					}
				}
				List<String> results = new ArrayList<String>();
				if (parent instanceof Association) {
					results.add(((Association) parent).getAssociationType());
				}
				return results.toArray();
			} catch (Exception e) {
				MessageDialogUtils.error(getSite().getShell(), e);
				return null;
			}
		}

		public void dispose() {

		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

	}

	/**
	 * Table label provider inner class
	 *
	 */
	public class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			AssociationData row = (AssociationData) element;
			switch (columnIndex) {
			case 0:
				return row.path;
			case 1:
				return row.type;
			}
			return null;
		}

	}

	/**
	 * execute action on the object
	 */
	public void executeAction(int actionID, Object object) {
		switch (actionID) {
		case IRegistryFormEditorPage.ACTION_ADD_ASSOCIATION:
			focusToLastRow();
			break;
		}

	}

	/**
	 * 
	 */
	private void focusToLastRow() {
		TableItem item = table.getItem(table.getItemCount() - 1);
		AssociationData associationData = (AssociationData) item.getData();
		viewer.editElement(associationData, 0);
	}

	/**
	 * get Page Type
	 */
	public int getPageType() {
		return IRegistryFormEditorPage.PAGE_ASSOCIATIONS;
	}

	/**
	 * add Association
	 */
	public void addAssociation() {
		AssociationData associationData = AssociationData.getAssociationData("", "", false);
		viewer.add(associationData);
		TableItem item = table.getItem(table.getItemCount() - 1);
		item.setData(associationData);
		table.setTopIndex(table.getItemCount());
		viewer.editElement(associationData, 0);
	}

	/**
	 * set Page Dirty
	 * @param pageDirty
	 */
	public void setPageDirty(boolean pageDirty) {
		this.pageDirty = pageDirty;
		editor.updateDirtyState();
	}

	/**
	 * 
	 */
	public boolean isPageDirty() {
		return pageDirty;
	}

	/**
	 * AssociationData inner class
	 *
	 */
	public static class AssociationData {
		String currentPath;
		String currentType;
		String path = "";
		String type = "";
		boolean isDeleted = false;

		public static AssociationData getAssociationData(String cpath,
														 String ctype, 
														 boolean isCurrent) {
			AssociationData associationData = new AssociationData();
			if (isCurrent) {
				associationData.currentPath = cpath;
				associationData.currentType = ctype;
			}
			associationData.path = cpath;
			associationData.type = ctype;
			return associationData;
		}

		public boolean isNew() {
			return currentPath == null || currentType == null;
		}

		public boolean isChanged() {
			return currentPath == null || currentType == null
					                   || !currentPath.equals(path) 
					                   || !currentType.equals(type);
		}

		public boolean isBlank() {
			return path.equals("") && type.equals("");
		}
	}

}

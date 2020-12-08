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
import java.util.Date;
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
import org.wso2.carbon.registry.core.Comment;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.utils.MessageDialogUtils;
import org.wso2.developerstudio.eclipse.registry.base.Activator;
import org.wso2.developerstudio.eclipse.registry.base.core.Registry;
import org.wso2.developerstudio.eclipse.registry.base.editor.input.ResourceEditorInput;
import org.wso2.developerstudio.eclipse.registry.base.interfaces.IRegistryFormEditorPage;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.ui.editor.RegistryResourceEditor;
import org.wso2.developerstudio.eclipse.registry.core.exception.InvalidRegistryURLException;
import org.wso2.developerstudio.eclipse.registry.core.exception.UnknownRegistryException;

public class CommentsEditorPage extends FormPage implements
		IResourceChangeListener, IRegistryFormEditorPage {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private FormToolkit toolkit;
	private ScrolledForm form;
	private RegistryResourceEditor editor;
	private Table table;
	private TableViewer viewer;
	private Registry registry;
	private String[] titles = { "Comments" };
	ArrayList<String> commentsList;
	private ResourceEditorInput editorInput;
	private boolean pageDirty;
	private Button deleteButton;
	private Button btnOk;

	private RegistryResourceNode regResourcePathData;

	public CommentsEditorPage(RegistryResourceEditor editor, String id, String title) {
		super(editor, id, title);
		this.editor = editor;
		commentsList = new ArrayList<String>();
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

		deleteButton = toolkit.createButton(columnComp, "Delete Comment",
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
		editors[0] = new TextCellEditor(table);
		
		editors[0].getControl().addTraverseListener(new TraverseListener() {
			
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
		});
		
		viewer.setCellEditors(editors);
		viewer.setCellModifier(new TableCellModifier());

		deleteButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent arg0) {
			}

			public void widgetSelected(SelectionEvent arg0) {
				deleteComment();
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

	private void loadData() {
		regResourcePathData = editorInput.getResource();
		table.removeAll();
		Comment[] comments = null;
		try {
			comments = regResourcePathData.getConnectionInfo().getRegistry().getComments(
							regResourcePathData.getRegistryResourcePath());
			for (Comment comment : comments) {
				TableItem tableItem = new TableItem(table, SWT.NULL);
				CommentsData commentsData = CommentsData.getCommentsData(comment
						.getDescription(), true);
				commentsData.user = comment.getAuthorUserName();
				commentsData.time = comment.getCreatedTime();
				commentsData.commentPath = comment.getPath();
				tableItem.setText(comment.getCreatedTime() + " by "
						+ comment.getAuthorUserName() + "\n"
						+ comment.getDescription());
				tableItem.setData(commentsData);
			}
			addComment();
		} catch (Exception e) {
			MessageDialogUtils.error(getSite().getShell(), e);
		}
		
	}

	public void deleteComment() {
		TableItem item = table.getItem(table.getSelectionIndex());
		CommentsData commentsData = (CommentsData) item.getData();
		if (commentsData.isDeleted) {
			commentsData.isDeleted = false;
		} else {
			commentsData.isDeleted = true;
		}
		updateTableItem(item);
		updateDirtyState();
	}

	private void updateTableItem(TableItem item) {
		CommentsData commentsData = (CommentsData) item.getData();
		if (commentsData.isDeleted) {
			item.setForeground(Display.getDefault().getSystemColor(
					SWT.COLOR_GRAY));
		} else {
			item.setForeground(Display.getDefault().getSystemColor(
					SWT.COLOR_BLACK));
		}
		updateDeleteButton();
	}

	private void updateDeleteButton() {
		CommentsData currentSelectedCommentData = getCurrentSelectedCommentData();
		if (currentSelectedCommentData == null)
			deleteButton.setEnabled(false);
		else {
			deleteButton.setEnabled(true);
			if (currentSelectedCommentData.isDeleted)
				deleteButton.setText("Undelete Comment");
			else
				deleteButton.setText("Delete Comment");
		}
	}

	private CommentsData getCurrentSelectedCommentData() {
		if (table.getSelectionIndex() == -1)
			return null;
		TableItem item = table.getItem(table.getSelectionIndex());
		if (item != null)
			return (CommentsData) item.getData();
		else
			return null;
	}

	private void updateDirtyState() {
		boolean dirtyState = false;
		TableItem[] items = table.getItems();
		for (TableItem tableItem : items) {
			CommentsData commentsData = (CommentsData) tableItem.getData();
			boolean n = commentsData.isNew();
			boolean b = commentsData.isBlank();
			boolean c = commentsData.isChanged();
			boolean d = commentsData.isDeleted;
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

	public void validateComments() throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		for (TableItem item : table.getItems()) {
			CommentsData commentsData = (CommentsData) item.getData();
			if (commentsData.comment == null) {
				throw new Exception("Comment is null");
			}
			if (!commentsData.isDeleted) {
				String val = commentsData.comment;
				list.add(val);
			}
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
		validateComments();
	}

	public void doFinish() throws InvalidRegistryURLException, UnknownRegistryException{
		regResourcePathData = editorInput.getResource();
		registry = regResourcePathData.getConnectionInfo().getRegistry();
		String selectedPath = regResourcePathData.getRegistryResourcePath();

		TableItem[] items = table.getItems();
		
		for (TableItem tableItem : items) {
			CommentsData commentsData = (CommentsData) tableItem.getData();
//			commentsData.commentPath = selectedPath;
			boolean n = commentsData.isNew();
			boolean b = commentsData.isBlank();
			boolean c = commentsData.isChanged();
			boolean d = commentsData.isDeleted;
			if (n && !b){
				registry.addComment(selectedPath, new Comment(
						commentsData.comment));
			}else if ((!n && d) || (!n && b && !d)){
				registry.removeComment(commentsData.commentPath);
			}else if (!n && c){
				registry.editComment(commentsData.commentPath,
						commentsData.comment);
			}else{
				
			}
		}
		loadData();
		updateDirtyState();
	}

	class TableCellModifier implements ICellModifier {

		public boolean canModify(Object element, String arg1) {
			CommentsData row = (CommentsData) element;
			return !row.isDeleted;
		}

		public Object getValue(Object element, String comment) {
			Object result = null;
			CommentsData row = (CommentsData) element;
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < titles.length; i++) {
				list.add(titles[i]);
			}
			int columnIndex = list.indexOf(comment);
			switch (columnIndex) {
			case 0:
				result = row.comment;
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
			CommentsData row = (CommentsData) tableItem.getData();

			switch (columnIndex) {
			case 0:
				String key = (String) value;
				if (key.length() > 0) {
					row.comment = key;
				}
				break;
			}
			if (row.isBlank()) {
				if (tableItem != table.getItem(table.getItemCount() - 1)) {
				}
			} else {
				TableItem item = table.getItem(table.getItemCount() - 1);
				CommentsData lastCommentData = (CommentsData) item.getData();
				if (!lastCommentData.isBlank())
					addComment();
			}
			updateDirtyState();
			viewer.update(row, null);

		}

	}

	public void addComment() {
		CommentsData commentsData = CommentsData.getCommentsData("", false);
		viewer.add(commentsData);
		TableItem item = table.getItem(table.getItemCount() - 1);
		item.setData(commentsData);
		table.setTopIndex(table.getItemCount());
		viewer.editElement(commentsData, 0);
	}

	public class TableContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object parent) {
			regResourcePathData = editorInput.getResource();
			Comment[] comments = null;
			try {
				comments = regResourcePathData.getConnectionInfo()
						.getRegistry().getComments(
								regResourcePathData.getRegistryResourcePath());
				List<String> results = new ArrayList<String>();
				for (Comment comment : comments) {
					results.add(comment.getCreatedTime() + " by "
							+ comment.getAuthorUserName() + "\n"
							+ comment.getDescription());
				}
				if (parent instanceof Comment) {
					Comment comment = (Comment) parent;
					results.add(comment.getCreatedTime() + " by " + comment.getAuthorUserName() +
					            "\n" + comment.getDescription());
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
			CommentsData row = (CommentsData) element;

			switch (columnIndex) {
			case 0:
				if (row.isNew())
					return row.comment;
				else
					return row.time + " by " + row.user + "\n" + row.comment;
			}

			return null;
		}

	}

	public void executeAction(int actionID, Object object) {
		switch (actionID) {
		case IRegistryFormEditorPage.ACTION_ADD_COMMENT:
			focusToLastRow();
			break;
		}

	}

	private void focusToLastRow() {
		TableItem item = table.getItem(table.getItemCount() - 1);
		CommentsData commentsData = (CommentsData) item.getData();
		viewer.editElement(commentsData, 0);
	}

	public int getPageType() {
		return IRegistryFormEditorPage.PAGE_COMMENTS;
	}

	public void setPageDirty(boolean pageDirty) {
		this.pageDirty = pageDirty;
		editor.updateDirtyState();
	}

	public boolean isPageDirty() {
		return pageDirty;
	}

	public static class CommentsData {
		String currentComment;
		String comment;
		boolean isDeleted = false;
		String user;
		Date time;
		String commentPath;

		public static CommentsData getCommentsData(String cComment,
				boolean isCurrent) {
			CommentsData commentsData = new CommentsData();
			if (isCurrent) {
				commentsData.currentComment = cComment;
			}
			commentsData.comment = cComment;
			return commentsData;
		}

		public boolean isNew() {
			return currentComment == null;
		}

		public boolean isChanged() {
			return currentComment == null || !currentComment.equals(comment);
		}

		public boolean isBlank() {
			return comment.equals("");
		}
	}

}

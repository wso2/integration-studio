/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.connector.ui.wizard;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.wso2.developerstudio.eclipse.artifact.connector.Activator;
import org.wso2.developerstudio.eclipse.artifact.connector.model.ConnectorModel;
import org.wso2.developerstudio.eclipse.artifact.connector.ui.dialog.WorkspaceConnectorImportDialog;

public class ConnectorWizardPage extends WizardPage {
	private TableViewer tblLibraryInfoViewer;
	private ConnectorModel model;
	private boolean existingProject;

	public ConnectorWizardPage() {
		super("wizardPage");
		setTitle("Add/Remove connector");
		setDescription("Add/Remove connector");
		this.existingProject = false;
	}

	public ConnectorWizardPage(boolean existingProject) {
		super("wizardPage");
		setTitle("Add/Remove connector");
		setDescription("Add/Remove connector");
		this.existingProject = existingProject;
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		if (!existingProject) {
			model = ((ConnectorCreationWizard) getWizard()).getCustomMediatorModel();
		} else {
			model = ((AddRemoveConnectorWizard) getWizard()).getLibraryModel();
		}

		container.setLayout(new GridLayout(5, false));

		Label lblCreateJavaLibrary = new Label(container, SWT.NONE);
		lblCreateJavaLibrary.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 5, 1));
		lblCreateJavaLibrary.setText("List of connectors to be included");

		tblLibraryInfoViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		Table tblLibraryInfo = tblLibraryInfoViewer.getTable();
		GridData gd_tblLibraryInfo = new GridData(SWT.FILL, SWT.FILL, true, false, 3, 3);
		gd_tblLibraryInfo.heightHint = 250;
		tblLibraryInfo.setLayoutData(gd_tblLibraryInfo);

		tblLibraryInfoViewer.setContentProvider(new ITreeContentProvider() {
			@SuppressWarnings("unchecked")
			public Object[] getChildren(Object obj) {
				if (obj instanceof List) {
					List<Object> list = (List<Object>) obj;
					if (!list.isEmpty()) {
						return list.toArray();
					}
				}
				return new Object[] {};
			}

			public Object getParent(Object arg0) {
				return null;
			}

			@SuppressWarnings("unchecked")
			public boolean hasChildren(Object obj) {
				return (obj instanceof List);
			}

			public Object[] getElements(Object obj) {
				return getChildren(obj);
			}

			public void dispose() {
			}

			public void inputChanged(Viewer viewer, Object obj1, Object obj2) {
				viewer.refresh();
			}
		});
		tblLibraryInfoViewer.setLabelProvider(new ILabelProvider() {
			ILabelProvider lblProvider = WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider();

			public Image getImage(Object obj) {
				if (obj instanceof File || obj instanceof IFile) {
					return AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
							"icons/new-mediator-16x16.png").createImage();
				} else {
					return lblProvider.getImage(obj);
				}
			}

			public String getText(Object obj) {
				if (obj instanceof File) {
					return ((File) obj).toString();
				} else if (obj instanceof IFile) {
					IFile file = (IFile) obj;
					return file.getName() + " [" + file.getParent().getFullPath().toOSString() + "]";
				} else {
					return lblProvider.getText(obj);
				}
			}

			public void addListener(ILabelProviderListener listener) {
			}

			public void dispose() {
			}

			public boolean isLabelProperty(Object obj, String str) {
				return false;
			}

			public void removeListener(ILabelProviderListener listener) {
			}

		});

		tblLibraryInfoViewer.setInput(model.getConnectors());

		//Workspace Button
		Button btbWorkspace = new Button(container, SWT.NONE);
		btbWorkspace.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				WorkspaceConnectorImportDialog dialog = new WorkspaceConnectorImportDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), model, tblLibraryInfoViewer);
				dialog.open();
				tblLibraryInfoViewer.refresh();
				validate();
			}
		});
		GridData gd_btnWorkspace = new GridData(SWT.RIGHT, SWT.TOP, false, false, 2, 1);
		gd_btnWorkspace.widthHint = 90;
		btbWorkspace.setLayoutData(gd_btnWorkspace);
		btbWorkspace.setText("Workspace");		
		
		Button btnFileSystem = new Button(container, SWT.NONE);
		btnFileSystem.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				List<File> files = showFileBrowser();
				if (files != null) {
					for (File file : files) {
						model.getConnectors().add(file);
					}
				}
				tblLibraryInfoViewer.refresh();
				validate();
			}
		});
		GridData gd_btnFileSystem = new GridData(SWT.RIGHT, SWT.TOP, false, false, 2, 1);
		gd_btnFileSystem.widthHint = 90;
		btnFileSystem.setLayoutData(gd_btnFileSystem);
		btnFileSystem.setText("File System");

		Button btnRemove = new Button(container, SWT.NONE);
		btnRemove.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection sel = (IStructuredSelection) tblLibraryInfoViewer.getSelection();
				Object selected = sel.getFirstElement();
				TableItem[] items = tblLibraryInfoViewer.getTable().getItems();
				if (model.getConnectors().contains(selected)) {
					for (TableItem tableItem : items) {
						if (tableItem.getText().equals(selected.toString())) {
							model.getConnectors().remove(selected);
						}
					}
					model.getConnectors().remove(selected);
					tblLibraryInfoViewer.refresh();
				}
				validate();
			}
		});
		GridData gd_btnRemove = new GridData(SWT.RIGHT, SWT.TOP, false, false, 2, 1);
		gd_btnRemove.widthHint = 90;
		btnRemove.setLayoutData(gd_btnRemove);
		btnRemove.setText("Remove");
		setPageComplete(false);
	}

	private List<File> showFileBrowser() {
		List<File> files = new ArrayList<File>();
		FileDialog fld = new FileDialog(this.getShell(), SWT.MULTI);
		fld.setFilterExtensions(new String[] { "*.zip" });
		boolean done = false;
		while (!done) {
			String parentPath = null;
			String[] selectedFiles = null;
			if (fld.open() != null) {
				parentPath = fld.getFilterPath();
				selectedFiles = fld.getFileNames();
			}
			if (selectedFiles == null) {
				done = true;
			} else {
				File file = null;
				for (String fName : selectedFiles) {
					file = new File(parentPath, fName);
					if (file.exists()) {
						done = true;
						files.add(file);
					} else {
						done = false;
					}
				}
			}
		}

		return files;
	}

	private void validate() {
		setPageComplete(isValid());
	}

	public boolean isValid() {
		if (tblLibraryInfoViewer.getTable().getItemCount() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public IWizardPage getNextPage() {
		return null;
	}
}

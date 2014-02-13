/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.library.ui.wizard;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.wso2.developerstudio.eclipse.artifact.library.Activator;
import org.wso2.developerstudio.eclipse.artifact.library.model.LibraryArtifactModel;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;


public class NewJavaLibraryWizardPage extends WizardPage {
	private Text txtBundle;
	private TableViewer tblLibraryInfoViewer;
	private LibraryArtifactModel model;
	private Button chkFragmentBundle;
	private boolean existingProject;

	public NewJavaLibraryWizardPage() {
		super("wizardPage");
		setTitle("New Java Library");
		setDescription("Select Java Library");
		this.existingProject = false;
	}
	
	public NewJavaLibraryWizardPage(boolean existingProject) {
		super("wizardPage");
		setTitle("Add/Remove Java Library");
		setDescription("Select Java Library");
		this.existingProject = existingProject;
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		if (!existingProject){
			model = ((LibraryArtifactCreationWizard)getWizard()).getLibraryModel();
		} else {
			model = ((AddRemoveJavaLibsWizard)getWizard()).getLibraryModel();
		}
		
		
		container.setLayout(new GridLayout(5, false));
		
		Label lblCreateJavaLibrary = new Label(container, SWT.NONE);
		lblCreateJavaLibrary.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 5, 1));
		lblCreateJavaLibrary.setText("Create Java Library from:");
		
		tblLibraryInfoViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		Table tblLibraryInfo = tblLibraryInfoViewer.getTable();
		GridData gd_tblLibraryInfo = new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1);
		gd_tblLibraryInfo.heightHint = 167;
		tblLibraryInfo.setLayoutData(gd_tblLibraryInfo);
		
		tblLibraryInfoViewer.setContentProvider(new ITreeContentProvider(){
            @SuppressWarnings("unchecked")
            public Object[] getChildren(Object obj) {
            	if (obj instanceof List){
            		List<Object> list=(List<Object>)obj;
            		if(!list.isEmpty()){
            			return list.toArray();
            		}
            	}
	            return new Object[]{};
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
            public void dispose() {}
            public void inputChanged(Viewer viewer, Object obj1, Object obj2) {
            	viewer.refresh();
            }
		});
		tblLibraryInfoViewer.setLabelProvider(new ILabelProvider(){
			ILabelProvider lblProvider=WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider();
            public Image getImage(Object obj) {
            	if (obj instanceof File || obj instanceof IFile){
            		return	AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID,"icons/jar-16x16.png").createImage();
            	}else{
            		return lblProvider.getImage(obj);
            	}
            }

            public String getText(Object obj) {
            	if (obj instanceof File){
            		return ((File)obj).toString();
            	}else if (obj instanceof IFile){
            		IFile file=(IFile)obj;
            		return file.getName()+" ["+file.getParent().getFullPath().toOSString()+"]";
            	}else{
            		return lblProvider.getText(obj);
            	}
            }
            public void addListener(ILabelProviderListener listener) {}
            public void dispose() {}
            public boolean isLabelProperty(Object obj, String str) {
	            return false;
            }
            public void removeListener(ILabelProviderListener listener) {}
			
		}); 
		                      
		tblLibraryInfoViewer.setInput(model.getLibraries());
		
		Button btnFileSystem = new Button(container, SWT.NONE);
		btnFileSystem.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				List<File> files = showFileBrowser();
				if (files != null) {
					for (File file : files) {
						model.getLibraries().add(file);
					}
				}
				
				tblLibraryInfoViewer.refresh();
				validate();
			}
		});
		GridData gd_btnFileSystem = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnFileSystem.widthHint = 90;
		btnFileSystem.setLayoutData(gd_btnFileSystem);
		btnFileSystem.setText("File System...");
		new Label(container, SWT.NONE);
		
		Button btnWorkspace = new Button(container, SWT.NONE);
		btnWorkspace.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				showWorkspaceDialog();
				validate();
			}
		});
		GridData gd_btnWorkspace = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnWorkspace.widthHint = 90;
		btnWorkspace.setLayoutData(gd_btnWorkspace);
		btnWorkspace.setText("Workspace...");
		new Label(container, SWT.NONE);
		
		Button btnRemove = new Button(container, SWT.NONE);
		btnRemove.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection sel=(IStructuredSelection)tblLibraryInfoViewer.getSelection();
				Object selected=sel.getFirstElement();
				TableItem[] items = tblLibraryInfoViewer.getTable().getItems();
				if (model.getLibraries().contains(selected)){
					for (TableItem tableItem : items) {
						if(tableItem.getText().equals(selected.toString())){
							model.getLibraries().remove(selected);
						}
					}
					model.getLibraries().remove(selected);
					tblLibraryInfoViewer.refresh();
				}
				validate();
			}
		});
		GridData gd_btnRemove = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnRemove.widthHint = 90;
		btnRemove.setLayoutData(gd_btnRemove);
		btnRemove.setText("Remove");
		
		chkFragmentBundle = new Button(container, SWT.CHECK);
		chkFragmentBundle.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				boolean b = ((Button) (e.widget)).getSelection();
				txtBundle.setEnabled(b);
				model.setFragmentHostBundle(b);
				validate();
			}	
		});
		chkFragmentBundle.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		chkFragmentBundle.setText("Make this a fragment bundle");
			
		new Label(container, SWT.NONE);
		
		txtBundle = new Text(container, SWT.BORDER);
		txtBundle.setEnabled(false);
		txtBundle.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				model.setFragmentHostBundleName(txtBundle.getText());
				validate();
			}
		});
		
		if (existingProject) {
			if (model.isFragmentHostBundle() && !model.getFragmentHostBundleName().isEmpty()){
				chkFragmentBundle.setSelection(true);
				txtBundle.setText(model.getFragmentHostBundleName());
				txtBundle.setEnabled(true);
			}
		}
		
		GridData gd_txtBundle = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtBundle.widthHint = 156;
		txtBundle.setLayoutData(gd_txtBundle);
		setPageComplete(false);
	}
	
	void showWorkspaceDialog() {
		ElementTreeSelectionDialog elementTreeSelectionDialog = new ElementTreeSelectionDialog(
				getShell(),
				WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider(),
				new WorkbenchContentProvider());
		elementTreeSelectionDialog.setInput(ResourcesPlugin.getWorkspace()
				.getRoot());
		if (elementTreeSelectionDialog.open() == Window.OK) {
			elementTreeSelectionDialog.getFirstResult();
			IResource resource = (IResource) elementTreeSelectionDialog.getFirstResult();
			if (model.getLibraries().contains(resource)) {
				return;
			}
			if (resource instanceof IProject) {
				IProject project = (IProject) resource;
				try {
					if (project.hasNature("org.eclipse.jdt.core.javanature")) {
						model.getLibraries().add( resource);
					}
				} catch (CoreException ex) {

				}
			} else if (resource.getFileExtension().equals("jar")) {
				model.getLibraries().add(resource);
			}
			tblLibraryInfoViewer.refresh();
		}
	}
	
	private List<File> showFileBrowser() {
		List<File> files = new ArrayList<File>();
		FileDialog fld = new FileDialog(this.getShell(), SWT.MULTI);
		fld.setFilterExtensions(new String[] { "*.jar" });
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
	
	private void validate(){
			setPageComplete(isValid());
	}
	
	public boolean isValid(){
		if(tblLibraryInfoViewer.getTable().getItemCount()>0){
			if(chkFragmentBundle.getSelection()){
				if(null==txtBundle.getText() || txtBundle.getText().trim().isEmpty()){
					return false;
				} else{
					return true;
				}
			} else{
				return true;
			}
		} else {
			return false;
		}
	}
}

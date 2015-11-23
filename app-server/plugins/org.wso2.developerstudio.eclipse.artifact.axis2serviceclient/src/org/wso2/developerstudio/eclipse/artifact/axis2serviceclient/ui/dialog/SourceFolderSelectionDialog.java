/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.axis2serviceclient.ui.dialog;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.wso2.developerstudio.eclipse.artifact.axis2serviceclient.core.StringConstants;
import org.wso2.developerstudio.eclipse.artifact.axis2serviceclient.utils.Axis2ImageUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;

public class SourceFolderSelectionDialog extends Dialog {
	public static final String CAPP_NATURE_ID = "org.wso2.developerstudio.eclipse.capp.project.nature";

	private IPackageFragmentRoot sourceFolder;

	public SourceFolderSelectionDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	protected Control createDialogArea(Composite parent) {
		parent.getShell().setText("Select source folder for code generation");

		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout(1, false);
		container.setLayout(layout);

		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd.widthHint = 300;
		gd.heightHint = 250;
		container.setLayoutData(gd);

		gd = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		Tree workspaceTree = new Tree(container, SWT.BORDER | SWT.LEFT_TO_RIGHT);
		workspaceTree.setLayoutData(gd);
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
				.getProjects();
		for (int i = 0; i < projects.length; i++) {
			if (projects[i].isOpen()) {
				TreeItem project = new TreeItem(workspaceTree, 0);
				project.setText(projects[i].getName());
				project.setData(projects[i]);
				try {
					if (projects[i].hasNature(JavaCore.NATURE_ID)) {
						project.setImage(Axis2ImageUtils.getInstance()
								.getImageDescriptor(StringConstants.JDT_ICON)
								.createImage());
					} else {
						project.setImage(Axis2ImageUtils
								.getInstance()
								.getImageDescriptor(
										StringConstants.PROJECT_ICON)
								.createImage());
					}
				} catch (CoreException e) {
					e.printStackTrace();
				}
				new TreeItem(project, 0);
			}
		}

		workspaceTree.addListener(SWT.Expand, new Listener() {

			public void handleEvent(Event arg0) {
				TreeItem item = (TreeItem) arg0.item;
				TreeItem[] items = item.getItems();
				for (int i = 0; i < items.length; i++) {
					items[i].dispose();
				}
				IProject project = (IProject) item.getData();
				try {
					if (project.hasNature(JavaCore.NATURE_ID)) {
						IPackageFragmentRoot[] sourceFolders = JavaUtils
								.getSourceFoldersForProject(project);
						for (int i = 0; i < sourceFolders.length; i++) {
							TreeItem sourceFolder = new TreeItem(item, 0);
							sourceFolder.setText(sourceFolders[i].getPath()
									.toOSString()
									.substring(project.getName().length() + 2));
							sourceFolder.setData(sourceFolders[i]);
							sourceFolder
									.setImage(Axis2ImageUtils
											.getInstance()
											.getImageDescriptor(
													StringConstants.JDT_SOURCE_FOLDER_ICON)
											.createImage());
						}
					}
				} catch (JavaModelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		});

		workspaceTree.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event arg0) {
				Object selectedItem = arg0.item;
				if (selectedItem instanceof TreeItem) {
					// Handle this
					TreeItem item = (TreeItem) selectedItem;
					Object selectedItemData = item.getData();

					if (selectedItemData instanceof IProject) {
						// Root Level Node Selection
						changeOkButtonStatus(false);
					} else if (selectedItemData instanceof IPackageFragmentRoot) {
						// Actually Selected a source Folder
						setSourceFolder((IPackageFragmentRoot) selectedItemData);
						changeOkButtonStatus(true);
					}
				}
			}
		});

		// TODO Auto-generated method stub
		return super.createDialogArea(parent);
	}

	private void changeOkButtonStatus(boolean status) {
		this.getButton(OK).setEnabled(status);
	}

	public void setSourceFolder(IPackageFragmentRoot sourceFolder) {
		this.sourceFolder = sourceFolder;
	}

	public IPackageFragmentRoot getSourceFolder() {
		return sourceFolder;
	}

}

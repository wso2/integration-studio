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

package org.wso2.developerstudio.eclipse.registry.manager.local.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.manager.local.Activator;
import org.wso2.developerstudio.eclipse.registry.manager.local.ui.controls.WorkspaceResourceTreeViewer;

public class ResourceCheckoutStateDialog extends Dialog {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	IResource folder;
	List<IResource> allRootResources;

	/**
	 * ResourceCheckoutStateDialog constructor
	 * @param parentShell
	 * @param folder
	 */
	public ResourceCheckoutStateDialog(Shell parentShell, IResource folder) {
		super(parentShell);
		this.folder = folder;
		allRootResources = new ArrayList<IResource>();
		allRootResources.add(folder);
	}

	/**
	 * create Dialog Area
	 */
	protected Control createDialogArea(final Composite parent) {
		parent.getShell().setText("Commit changes to registry");
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		container.setLayout(layout);
		TreeViewer treeViewer = new WorkspaceResourceTreeViewer(parent,
																SWT.MULTI | 
																SWT.H_SCROLL | 
																SWT.V_SCROLL | 
																SWT.BORDER);

		try {
			Tree tree = treeViewer.getTree();
			GridData data = new GridData(GridData.FILL_BOTH);
			data.widthHint = 450;
			data.heightHint = 250;
			tree.setLayoutData(data);
			treeViewer.setInput(allRootResources);
		} catch (Exception e) {
			log.error(e);
		}
		treeViewer.expandAll();
		return super.createDialogArea(parent);
	}

	/**
	 * create Buttons For dialog
	 */
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "Commit", true);
		createButton(parent, 
					 IDialogConstants.CANCEL_ID,
					 IDialogConstants.CANCEL_LABEL, 
					 false);
	}
}

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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryCredentialData;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryURLInfo;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryUrlStore;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryCredentialData.Credentials;
import org.wso2.developerstudio.eclipse.registry.base.ui.dialog.RegistryTreeBrowserDialog;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.ImageUtils;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.SWTControlUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.manager.local.Activator;
import org.wso2.developerstudio.eclipse.registry.manager.local.ui.controls.WorkspaceResourceTreeViewer;

public class CheckingToRegistryDialog extends Dialog {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private String serverUrl;
	private String path;
//	private boolean createPaths;

	private Text urlText;
	private Text pathText;
	private IContainer resContainer;
//	private Button createPathButton;
	private Button buttonBrowseRegistry;
	private WorkspaceResourceTreeViewer treeViewer;
	private Button buttonBrowseRegistryPath;
	
	private String addedServerUserName;
	private String addedServerPWD;
	
	public String getAddedServerUserName() {
		return addedServerUserName;
	}

	public void setAddedServerUserName(String addedServerUserName) {
		this.addedServerUserName = addedServerUserName;
	}

	public String getAddedServerPWD() {
		return addedServerPWD;
	}

	public void setAddedServerPWD(String addedServerPWD) {
		this.addedServerPWD = addedServerPWD;
	}

	

	/**
	 * CheckingToRegistryDialog constructor 
	 * @param parentShell
	 * @param folder
	 */
	public CheckingToRegistryDialog(Shell parentShell, IContainer container) {
		super(parentShell);
		this.resContainer = container;
	}

	/**
	 * create dialog
	 */
	public void create() {
		super.create();
	}

	/**
	 * create dialog area
	 */
	protected Control createDialogArea(final Composite parent) {
		parent.getShell().setText("Check-in to the Registry");
		GridData gd;
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		container.setLayout(layout);
		gd = new GridData(GridData.FILL_HORIZONTAL| GridData.VERTICAL_ALIGN_FILL);
		container.setLayoutData(gd);

		Label urlLabel = new Label(container, SWT.NONE);
		urlLabel.setText("URL: ");
		gd = new GridData();
		urlLabel.setLayoutData(gd);

		urlText = new Text(container, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		urlText.setLayoutData(gd);

		urlText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				updateURL();
			}
		});

		buttonBrowseRegistry = new Button(container, SWT.None);
		buttonBrowseRegistry.setImage(ImageUtils.getImageDescriptor(
														  ImageUtils.ICON_REGISTRY).createImage());
		buttonBrowseRegistry.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent arg0) {
				widgetSelected(arg0);
			}

			public void widgetSelected(SelectionEvent arg0) {
				requestRegistryBrowserWithRegistriesInViewer();
			}

		});
		Label pathLabel = new Label(container, SWT.NONE);
		pathLabel.setText("Path: ");
		gd = new GridData();
		pathLabel.setLayoutData(gd);

		pathText = new Text(container, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		pathText.setLayoutData(gd);

		pathText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				updatePath();
			}
		});
		buttonBrowseRegistryPath = new Button(container, SWT.None);
		buttonBrowseRegistryPath.setImage(ImageUtils.getImageDescriptor(
														ImageUtils.ACTION_ADD_FOLDER).createImage());
		buttonBrowseRegistryPath.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent arg0) {
				widgetSelected(arg0);
			}

			public void widgetSelected(SelectionEvent arg0) {
				requestRegistryBrowserWithRegistryPathsInViewer();
			}

		});
		new Label(container, SWT.NONE);
//		createPathButton = new Button(container, SWT.CHECK);
//		createPathButton.setText("Create the path if it doesn't exist" + "");

//		createPathButton.addSelectionListener(new SelectionListener() {

//			public void widgetDefaultSelected(SelectionEvent arg0) {
//				setCreatePaths(createPathButton.getSelection());
//			}
//
//			public void widgetSelected(SelectionEvent arg0) {
//				widgetDefaultSelected(arg0);
//			}
//
//		});

		treeViewer = new WorkspaceResourceTreeViewer(parent, 
													 SWT.MULTI | 
													 SWT.H_SCROLL | 
													 SWT.V_SCROLL | 
													 SWT.BORDER);

		try {
			Tree tree = treeViewer.getTree();
			GridData data = new GridData(GridData.FILL_BOTH);
			data.widthHint = 450;
			data.heightHint = 250;
			data.horizontalSpan = 3;
			tree.setLayoutData(data);
			List<IResource> allRootResources = new ArrayList<IResource>();
			allRootResources.add(resContainer);
			treeViewer.setInput(allRootResources);
		} catch (Exception e) {
			log.error(e);
		}
		treeViewer.expandAll();

		urlText.setText("");
		pathText.setText("/_system/local/" + resContainer.getName());

		return super.createDialogArea(parent);
	}

	/**
	 * request Registry Browser With Registries In Viewer
	 */
	private void requestRegistryBrowserWithRegistriesInViewer() {
		RegistryTreeBrowserDialog r = new RegistryTreeBrowserDialog(
													Display.getCurrent().getActiveShell(),
													RegistryTreeBrowserDialog.SELECT_REGISTRY |
													RegistryTreeBrowserDialog.SELECT_REGISTRY_PATH);
		r.create();
		List<RegistryURLInfo> allRegistryUrls = RegistryUrlStore.getInstance().getAllRegistryUrls();
		if(!allRegistryUrls.isEmpty()){
			for (RegistryURLInfo registryURLInfo : allRegistryUrls) {
				r.addRegistryNode(registryURLInfo, null);
			}
			
			if (r.open() == Window.OK) {
				if(r.getSelectedRegistryNode() != null){
					urlText.setText(r.getSelectedRegistryNode().getUrl().toString());
				}
				
				if (r.getSelectedRegistryResourceNode() != null){
					urlText.setText(r.getSelectedRegistryResourceNode().getConnectionInfo().getUrl().toString());
					pathText.setText(r.getSelectedRegistryResourceNode().getRegistryResourcePath());
					Credentials credentials = RegistryCredentialData.getInstance().getCredentials(urlText.getText());
					if(credentials == null){
						credentials = new Credentials(r.getSelectedRegistryResourceNode().getConnectionInfo().getUsername(), r.getSelectedRegistryResourceNode().getConnectionInfo().getPassword());
						credentials.setUsername(r.getSelectedRegistryResourceNode().getConnectionInfo().getUsername());
						credentials.setPassword(r.getSelectedRegistryResourceNode().getConnectionInfo().getPassword());
						RegistryCredentialData.getInstance().setCredentials(urlText.getText(), 
								r.getSelectedRegistryResourceNode().getConnectionInfo().getUsername(), 
								r.getSelectedRegistryResourceNode().getConnectionInfo().getPassword());
					}
					setAddedServerUserName(r.getSelectedRegistryResourceNode().getConnectionInfo().getUsername());
					setAddedServerUserName(r.getSelectedRegistryResourceNode().getConnectionInfo().getPassword());
				}
				
			}
		}else{
			MessageDialog.openInformation(this.getShell(), "No Registry Connections", "There are no created registry connections.");
		}

		
	}

	/**
	 * request RegistryBrowser With RegistryPaths In Viewer
	 */
	private void requestRegistryBrowserWithRegistryPathsInViewer() {
		RegistryTreeBrowserDialog r = new RegistryTreeBrowserDialog(
													Display.getCurrent().getActiveShell(),
													RegistryTreeBrowserDialog.SELECT_REGISTRY_PATH);
		try {
			r.create();
			RegistryNode regData = r.addRegistry(new URL(getServerUrl()), "/","", null);
			Credentials credentials = RegistryCredentialData.getInstance().getCredentials(getServerUrl());
			if(credentials == null){
				credentials = SWTControlUtils.requestCredentials(Display.getCurrent().getActiveShell(), 
						   										getServerUrl(), 
						   										"");
				if (credentials == null){
					return;
				}
			}
			regData.setUsername(credentials.getUsername());
			regData.setPassword(credentials.getPassword());
			setAddedServerUserName(credentials.getUsername());
			setAddedServerUserName(credentials.getPassword());
			r.selectRegistryPath(regData, getPath() != null ? getPath() : "/");
			if (r.open() == Window.OK) {
				if(r.getSelectedRegistryNode() != null){
					urlText.setText(r.getSelectedRegistryNode().getUrl().toString());
				}
			
				if (r.getSelectedRegistryResourceNode() != null){
					urlText.setText(r.getSelectedRegistryResourceNode().getConnectionInfo().getUrl().toString());
					pathText.setText(r.getSelectedRegistryResourceNode().getRegistryResourcePath());
				}
				
			}
		} catch (MalformedURLException e) {
			MessageDialog.openError(getShell(), "Error", e.getMessage());
		}
	}

	/**
	 * data valid check
	 * @return
	 */
	public boolean isAllDatavalid() {
		return false;
	}

	/**
	 * get server url
	 * @return
	 */
	public String getServerUrl() {
		return serverUrl;
	}

	/**
	 * set server url
	 * @param serverUrl
	 */
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	/**
	 * set path
	 * @param path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * get path
	 * @return
	 */
	public String getPath() {
		return path;
	}

	/**
	 * set create path
	 * @param createPaths
	 */
//	public void setCreatePaths(boolean createPaths) {
//		this.createPaths = createPaths;
//	}

	/**
	 * create paths check
	 * @return
	 */
//	public boolean isCreatePaths() {
//		return createPaths;
//	}

	/**
	 * registryUrl valid check
	 * @return
	 */
	private boolean isRegistryUrlValid() {
		try {
			new URL(getServerUrl());
		} catch (MalformedURLException e) {
			return false;
		}
		return true;
	}

	/**
	 * check whether the path is valid
	 * @return
	 */
	private boolean isPathValid() {
		return getPath().startsWith("/");
	}

	/**
	 * update url
	 */
	private void updateURL() {
		setServerUrl(urlText.getText());
		if (isRegistryUrlValid()) {
			changeControlStates(true, 
								new Control[] { pathText,
												buttonBrowseRegistryPath, 
//												createPathButton,
												getButton(IDialogConstants.OK_ID) });
			if (isPathValid()){
				changeControlStates(true,
									new Control[] { getButton(IDialogConstants.OK_ID) });
			}
		} else {
			changeControlStates(false, 
								new Control[] { pathText,
												buttonBrowseRegistryPath, 
//												createPathButton,
												getButton(IDialogConstants.OK_ID) });
		}
	}

	/**
	 * update path
	 */
	private void updatePath() {
		setPath(pathText.getText());
		if (isRegistryUrlValid() && isPathValid()) {
			changeControlStates(true,
								new Control[] { getButton(IDialogConstants.OK_ID) });
		} else {
			changeControlStates(false,
								new Control[] { getButton(IDialogConstants.OK_ID) });
		}
	}

	/**
	 * change control states
	 * @param state
	 * @param controls
	 */
	private void changeControlStates(boolean state, Control[] controls) {
		for (Control control : controls) {
			if (control != null){
				control.setEnabled(state);
			}
		}
	}

	/**
	 * create buttons for dialog
	 */
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "Checkin", true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		updateURL();
		updatePath();
	}
}

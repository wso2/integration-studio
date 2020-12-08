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
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.Dialog;
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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.internal.ide.misc.ContainerSelectionGroup;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryURLInfo;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryUrlStore;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryCredentialData.Credentials;
import org.wso2.developerstudio.eclipse.registry.base.ui.dialog.RegistryTreeBrowserDialog;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.ImageUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.manager.local.Activator;

public class RegistryCheckoutDialog extends Dialog implements Listener {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private IFolder folder;
	private Text urlText;
	private Text pathText;
	private Button createPathButton;
	private Button buttonBrowseRegistry;
	private Button buttonBrowseRegistryPath;
	private RegistryNode selectedRegistryData;
	private RegistryResourceNode selectedPath;
	private IPath selectedCheckoutPath;

	private String serverUrl;
	private String path;

	private ContainerSelectionGroup resourceGroup;

	/**
	 * RegistryCheckoutDialog constructor
	 * @param pageName
	 * @param parentShell
	 * @param folder
	 */
	public RegistryCheckoutDialog(String pageName, Shell parentShell,IFolder folder) {
		super(parentShell);
		this.folder = folder;
	}

	/**
	 * create dialog area
	 */
	public Control createDialogArea(Composite parent) {
		GridData gd;
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		container.setLayout(layout);
		gd = new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_FILL);
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
		Composite resourceContainerComposite = new Composite(container,
				SWT.NULL);
		resourceContainerComposite.setLayout(new GridLayout(1, true));
		gd = new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_FILL);
		gd.horizontalSpan = 3;
		resourceContainerComposite.setLayoutData(gd);
		resourceGroup = new ContainerSelectionGroup(resourceContainerComposite,
				this, false, null, false);
		urlText.setText("");
		pathText.setText("/");
		initializePage();
		return super.createDialogArea(parent);

	}

	/**
	 * update registry URL
	 */
	private void updateURL() {
		setServerUrl(urlText.getText());
		if (isRegistryUrlValid()) {
			changeControlStates(true, new Control[] { pathText,
					buttonBrowseRegistryPath, createPathButton });
			if (isPathValid())
				changeControlStates(true, new Control[] {});
		} else {
			changeControlStates(false, new Control[] { pathText,
					buttonBrowseRegistryPath, createPathButton });
		}
	}

	/**
	 * get server Url
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
	 * set Path
	 * @param path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * get Path
	 * @return
	 */
	public String getPath() {
		return path;
	}

	/**
	 * RegistryUrlValid check 
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
	 * change Control States
	 * @param state
	 * @param controls
	 */
	private void changeControlStates(boolean state, Control[] controls) {
		for (Control control : controls) {
			if (control != null)
				control.setEnabled(state);
		}
	}

	/**
	 * PathValid check
	 * @return
	 */
	private boolean isPathValid() {
		return getPath().startsWith("/");
	}

	/**
	 * request RegistryBrowser With Registries In Viewer
	 */
	private void requestRegistryBrowserWithRegistriesInViewer() {
		RegistryTreeBrowserDialog r = new RegistryTreeBrowserDialog(Display
				.getCurrent().getActiveShell(),
				RegistryTreeBrowserDialog.SELECT_REGISTRY
						| RegistryTreeBrowserDialog.SELECT_REGISTRY_PATH);
		r.create();
		List<RegistryURLInfo> allRegistryUrls = RegistryUrlStore.getInstance()
				.getAllRegistryUrls();
		for (RegistryURLInfo registryURLInfo : allRegistryUrls) {
			r.addRegistryNode(registryURLInfo, null);
		}
		if (r.open() == Window.OK) {
			if (r.getSelectedRegistryResourceNode() != null) {
				setSelectedRegistryData(r.getSelectedRegistryResourceNode()
						.getConnectionInfo());
				setSelectedPath(r.getSelectedRegistryResourceNode());
				pathText.setText(getSelectedPath().getRegistryResourcePath());
				;
			} else if (r.getSelectedRegistryNode() != null) {
				setSelectedRegistryData(r.getSelectedRegistryNode());
			}
			urlText.setText(getSelectedRegistryData().getUrl().toString());
		}
	}

	/**
	 * request RegistryBrowser With Registry Paths In Viewer
	 */
	private void requestRegistryBrowserWithRegistryPathsInViewer() {
		RegistryTreeBrowserDialog r = new RegistryTreeBrowserDialog(Display
				.getCurrent().getActiveShell(),
				RegistryTreeBrowserDialog.SELECT_REGISTRY_PATH);
		try {
			r.create();
			RegistryNode regData = r.addRegistry(new URL(getServerUrl()), "/",
					"", null);
			r.selectRegistryPath(regData, getPath() != null ? getPath() : "/");
			if (r.open() == Window.OK) {
				if (r.getSelectedRegistryResourceNode() != null) {
					setSelectedPath(r.getSelectedRegistryResourceNode());
					pathText.setText(getSelectedPath()
							.getRegistryResourcePath());
					;
				}
			}
		} catch (MalformedURLException e) {
			MessageDialog.openError(getShell(), "Error", e.getMessage());
		}
	}

	/**
	 * update Path
	 */
	private void updatePath() {
		setPath(pathText.getText());
		if (isRegistryUrlValid() && isPathValid()) {
			changeControlStates(true, new Control[] {});
		} else {
			changeControlStates(false, new Control[] {});
		}
	}

	/**
	 * handle Event
	 */
	public void handleEvent(Event arg0) {
		int a = 10;
		setSelectedCheckoutPath(resourceGroup.getContainerFullPath());
	}

	/**
	 * ok button pressed
	 */
	protected void okPressed() {
		try {
			validate();
		} catch (Exception e) {
			MessageDialog.openError(getShell(), "Error", e.getMessage());
			return;
		}
		if (getSelectedRegistryData() == null || 
			!getSelectedRegistryData().getUrl().toString().equals(getServerUrl())) {
			RegistryURLInfo registryURLInfo = new RegistryURLInfo();
			registryURLInfo.setPersist(false);
			try {
				registryURLInfo.setUrl(new URL(getServerUrl()));
			} catch (MalformedURLException e) {
				log.error(e);
			}
			registryURLInfo.setPath(getPath());
			RegistryNode registryData = new RegistryNode(registryURLInfo, null,null);
			Credentials credentials = selectedPath.getConnectionInfo().getCredentials();
			if (credentials == null){
				return;
			}
			registryData.setUsername(credentials.getUsername());
			registryData.setPassword(credentials.getPassword());
			setSelectedRegistryData(registryData);
			setSelectedPath(new RegistryResourceNode(getSelectedRegistryData(), getPath(), null));
		} else if (getSelectedPath() == null
				|| !getSelectedPath().getRegistryResourcePath().equals(getPath())) {
			setSelectedPath(new RegistryResourceNode(getSelectedRegistryData(), getPath(), null));
		}
		super.okPressed();
	}

	/**
	 * validate dialog info
	 * @throws Exception
	 */
	private void validate() throws Exception {
		try {
			new URL(getServerUrl());
		} catch (MalformedURLException e) {
			throw new Exception("Registry Url is invalid");
		}
		if (!getPath().startsWith("/")){
			throw new Exception("Registry path seems to be invalid");
		}
		if (getSelectedCheckoutPath() == null){
			throw new Exception("Please select where you want to checkout the registry content");
		}
	}

	/**
	 * initialize page
	 */
	protected void initializePage() {
		resourceGroup.setSelectedContainer((IContainer) folder);
	}

	/**
	 * set selected registry resource node
	 * @param selectedPath
	 */
	public void setSelectedPath(RegistryResourceNode selectedPath) {
		this.selectedPath = selectedPath;
	}

	/**
	 * get selected registry resource node
	 * @return
	 */
	public RegistryResourceNode getSelectedPath() {
		return selectedPath;
	}

	/**
	 * set registryNode
	 * @param selectedRegistryData
	 */
	public void setSelectedRegistryData(RegistryNode selectedRegistryData) {
		this.selectedRegistryData = selectedRegistryData;
	}

	/**
	 * get registryNode
	 * @return
	 */
	public RegistryNode getSelectedRegistryData() {
		return selectedRegistryData;
	}

	/**
	 * set selected checkout path
	 * @param selectedCheckoutPath
	 */
	public void setSelectedCheckoutPath(IPath selectedCheckoutPath) {
		this.selectedCheckoutPath = selectedCheckoutPath;
	}

	/**
	 * get selected checkout path
	 * @return
	 */
	public IPath getSelectedCheckoutPath() {
		return selectedCheckoutPath;
	}

}

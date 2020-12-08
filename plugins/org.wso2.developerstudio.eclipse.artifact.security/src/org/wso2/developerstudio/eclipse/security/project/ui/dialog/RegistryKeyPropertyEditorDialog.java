/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.security.project.ui.dialog;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.CAppEnvironment;
import org.wso2.developerstudio.eclipse.capp.core.model.RegistryConnection;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryConnection;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryData;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryHandler;
import org.wso2.developerstudio.eclipse.security.project.utils.RegistryUtils;

/**
 * A SWT based editor dialog to be used for editing registry key properties.
 */
public class RegistryKeyPropertyEditorDialog extends Dialog {

	/**
	 * Default registry url.
	 */
	private static final String DEFAULT_REGISTRY_URL = "https://localhost:9443/registry";

	/**
	 * Prefix for governance registry paths.
	 */
	private static final String G_REG_PATH_PREFIX = "/_system/governance/";

	/**
	 * Prefix for configuration registry paths.
	 */
	private static final String C_REG_PATH_PREFIX = "/_system/config/";

	/**
	 * Registry key text field.
	 */
	private Text registryKeyText;

	/**
	 * Local named entities.
	 */
	private java.util.List<NamedEntityDescriptor> localNamedEntities;

	/**
	 * registry key text field layout data.
	 */
	private FormData registryKeyTextLayoutData;

	private RegistryKeyProperty registryKeyProperty;
	
	private String selectedRegistryPath;

	/**
	 * Creates a new {@link RegistryKeyPropertyEditorDialog} instance.
	 * 
	 * @param parent
	 *            parent shell.
	 * @param style
	 *            style.
	 * @param property
	 *            {@link RegistryKeyProperty} to be edited.
	 * @param localNamedEntities
	 *            named entities currently defined on the local configuration.
	 */
	public RegistryKeyPropertyEditorDialog(Shell parent, int style,
			java.util.List<NamedEntityDescriptor> localNamedEntities,
			RegistryKeyProperty registryKey) {
		super(parent);
		this.localNamedEntities = localNamedEntities;
		this.registryKeyProperty = registryKey;
	}

	private void hide() {
		changeVisibility(false);
	}

	private void show() {
		changeVisibility(true);
	}

	private void changeVisibility(boolean visible) {
		try {
			this.getShell().setVisible(visible);
		} catch (Exception e) {
			// ignore this
		}
	}

	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FillLayout layout = new FillLayout(SWT.HORIZONTAL);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		layout.spacing = 10;
		container.setLayout(layout);

		Group grpPropertyKey = new Group(container, SWT.None);
		grpPropertyKey.setText("Resource Key");

		FormLayout propertyKeyGroupLayout = new FormLayout();
		propertyKeyGroupLayout.marginHeight = 10;
		propertyKeyGroupLayout.marginWidth = 10;
		grpPropertyKey.setLayout(propertyKeyGroupLayout);

		// Registry key text field.
		registryKeyText = new Text(grpPropertyKey, SWT.BORDER);
		registryKeyText.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// saveConfiguration();
			}
		});

		{
			registryKeyTextLayoutData = new FormData();
			registryKeyTextLayoutData.right = new FormAttachment(100, -8);
			registryKeyText.setLayoutData(registryKeyTextLayoutData);
		}

		Link link = new Link(grpPropertyKey, SWT.NONE);
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String selectedCommand = e.text;
				if (selectedCommand.equals("registry")) {
					openRegistryBrowser();
				} else if (selectedCommand.equals("workspace")) {
					// openRegistryResourceProviderDialog();
				} else if (selectedCommand.equals("local entries")) {
					// openEmbeddedEntryBrowser();
				}
			}
		});

		registryKeyTextLayoutData.top = new FormAttachment(link, 7);
		registryKeyTextLayoutData.left = new FormAttachment(link, 0, SWT.LEFT);

		FormData linkFormData = new FormData();
		linkFormData.right = new FormAttachment(100, -4);
		linkFormData.left = new FormAttachment(0);
		linkFormData.top = new FormAttachment(0, -2);
		linkFormData.bottom = new FormAttachment(0, 15);
		link.setLayoutData(linkFormData);
		link.setText("Type the key or specify from <a>registry</a>");

		return container;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		// Set title.
		newShell.setText("Registry Key Editor");
	}

	private void openRegistryBrowser() {
		// Open registry browser.
		hide();
		try {
			IRegistryConnection[] registryConnections = CAppEnvironment.getRegistryHandler()
					.getRegistryConnections();
			if (registryConnections.length == 0) {
				RegistryConnection registryConnection = new RegistryConnection();
				try {
					registryConnection.setURL(new URL(DEFAULT_REGISTRY_URL));
				} catch (MalformedURLException e) {
					// not gonna happen
				}
				registryConnection.setPath("/_system/config");
			}
			IRegistryData selectedPathData = CAppEnvironment.getRegistryHandler()
					.selectRegistryPath(registryConnections, "Registry Browser",
							"Select Registry Resource:",
							IRegistryHandler.SELECTED_REGISTRY_RESOURCE);

			if (selectedPathData != null) {
				// Convert to prefixed format.
				setSelectedPath(selectedPathData);
			}
		} finally {
			show();
		}
	}

	private void setSelectedPath(IRegistryData registryData) {
		String registryPath = registryData.getPath();
		if (registryPath != null) {
			if (registryPath.startsWith(G_REG_PATH_PREFIX)) {
				registryPath = String.format("gov:%s", registryPath.substring(G_REG_PATH_PREFIX.length()));
			} else if (registryPath.startsWith(C_REG_PATH_PREFIX)) {
				registryPath = String.format("conf:%s", registryPath.substring(C_REG_PATH_PREFIX.length()));
			}

			// deleteTempFiles();

			registryKeyText.setText(registryPath);
			registryKeyProperty.setRegistryData(registryData);
			if (registryData != null && !registryData.getPath().trim().equals("")) {
				okPressed();
			}
		}
	}

	@Override
	protected void okPressed() {
		saveConfiguration();
		//checkoutRegistry();
		super.okPressed();
	}

	private void saveConfiguration() {
		registryKeyProperty.setKeyValue(registryKeyText.getText());
	}
	
	private void checkoutRegistry() {
		RegistryUtils.getInstance().checkoutFromRegistry(registryKeyProperty);
	}
	
	private void deleteTempFiles() {
		RegistryUtils.getInstance().deleteTempFiles(registryKeyProperty);
	}

}

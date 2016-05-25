/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.ds.presentation.ui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.CAppEnvironment;
import org.wso2.developerstudio.eclipse.capp.core.model.RegistryConnection;
import org.wso2.developerstudio.eclipse.ds.presentation.DsEditorPlugin;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryConnection;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryData;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryHandler;

/**
 * A SWT based editor dialog to be used for editing registry key properties.
 */
public class RegistryKeyPropertyEditorDialog extends Dialog {
	/**
	 * A set of known registry urls.
	 */
	private static Set<String> knownRegistryUrls;

	/**
	 * Preference key for storing known registry urls.
	 */
	private static final String REGISTRY_URLS_PREFERENCE_KEY = "registry_urls_preference_key";

	/**
	 * Default registry url.
	 */
	private static final String DEFAULT_REGISTRY_URL = "https://localhost:9443/registry";

	/**
	 * Governance registry string literal.
	 */
	private static final String G_REG_LITERAL = "Governance Registry";

	/**
	 * Prefix for governance registry paths.
	 */
	private static final String G_REG_PATH_PREFIX = "/_system/governance";

	/**
	 * Governance registry list index.
	 */
	private static final int G_REG_INDEX = 0;

	/**
	 * Configuration registry string literal.
	 */
	private static final String C_REG_LITERAL = "Configuration Registry";

	/**
	 * Prefix for configuration registry paths.
	 */
	private static final String C_REG_PATH_PREFIX = "/_system/config";

	/**
	 * Configuration registry list index.
	 */
	private static final int C_REG_INDEX = 1;

	/**
	 * Dialog shell.
	 */
	private Shell dialogShell;

	/**
	 * Registry key label.
	 */
	private Label rkLabel;

	/**
	 * Registry key text field.
	 */
	private Text rkTextField;

	/**
	 * Local entries group box.
	 */
	private Group localEntriesGroupBox;

	/**
	 * Local entries label.
	 */
	private Label localEntriesLabel;

	/**
	 * Local entries list box.
	 */
	private List localEntriesListBox;

	/**
	 * Dummy label used as a spacer.
	 */
	private Label dummyLabel;

	/**
	 * Remote registry group box.
	 */
	private Group remoteRegistryGroupBox;

	/**
	 * Registry url label.
	 */
	private Label registryUrlLabel;

	/**
	 * Registry urls combo box.
	 */
	private Combo registryUrlsComboBox;

	/**
	 * Regsitry type label.
	 */
	private Label registryTypeLabel;

	/**
	 * Registry type combo box.
	 */
	private Combo registryTypeComboBox;

	/**
	 * Browse button.
	 */
	private Button browseButton;

	/**
	 * Cancel button.
	 */
	private Button cancelButton;

	/**
	 * Ok button.
	 */
	private Button okButton;

	/**
	 * Local named entities.
	 */
	private java.util.List<NamedEntityDescriptor> localNamedEntities;

	/**
	 * Status indicating whether this dialog was saved or cancelled.
	 */
	private boolean saved;

	/**
	 * Holds the path
	 */
	private String xsltPathProperty;

	/**
	 * Creates a new {@link RegistryKeyPropertyEditorDialog} instance.
	 * 
	 * @param parent
	 *            parent shell.
	 * @param style
	 *            style.
	 * @param xsltPathProperty
	 *            {@link RegistryKeyProperty} to be edited.
	 * @param localNamedEntities
	 *            named entities currently defined on the local configuration.
	 */
	public RegistryKeyPropertyEditorDialog(Shell parent, int style,
	                                       java.util.List<NamedEntityDescriptor> localNamedEntities) {
		super(parent, style);
		this.localNamedEntities = localNamedEntities;
	}

	/**
	 * Main function used for testing purposes.
	 * 
	 * @param args
	 *            arguments.
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		RegistryKeyPropertyEditorDialog dialog =
		                                         new RegistryKeyPropertyEditorDialog(
		                                                                             shell,
		                                                                             SWT.NULL,
		                                                                             new ArrayList<NamedEntityDescriptor>());
		dialog.open();
	}

	/**
	 * Creates ui components and opens the dialog.
	 */
	public void open() {
		Shell parentShell = getParent();
		dialogShell = new Shell(parentShell, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

		// Configure dialog shell internal layout.
		FormLayout dialogShellLayout = new FormLayout();
		dialogShellLayout.marginHeight = 5;
		dialogShellLayout.marginWidth = 5;
		dialogShell.setLayout(dialogShellLayout);

		// Registry key label.
		rkLabel = new Label(dialogShell, SWT.NONE);
		{
			rkLabel.setText("Key:");
			FormData rkLabelLayoutData = new FormData();
			rkLabelLayoutData.top = new FormAttachment(2); // Otherwise
			                                               // rkTextField
			                                               // aligns to dialog
			                                               // border.
			rkLabelLayoutData.left = new FormAttachment(0);
			rkLabel.setLayoutData(rkLabelLayoutData);
		}

		// Registry key text field.
		rkTextField = new Text(dialogShell, SWT.BORDER);
		{
			FormData rkTextFieldLayoutData = new FormData();
			rkTextFieldLayoutData.top = new FormAttachment(rkLabel, 0, SWT.CENTER);
			rkTextFieldLayoutData.left = new FormAttachment(rkLabel, 5);
			rkTextFieldLayoutData.right = new FormAttachment(100);
			rkTextField.setLayoutData(rkTextFieldLayoutData);
		}

		// OK button.
		okButton = new Button(dialogShell, SWT.NONE);
		{
			okButton.setText("OK");
			FormData okButtonLayoutData = new FormData();
			okButtonLayoutData.right = new FormAttachment(100);
			okButtonLayoutData.bottom = new FormAttachment(100);
			okButtonLayoutData.width = 80;
			okButton.setLayoutData(okButtonLayoutData);
		}

		// Cancel button.
		cancelButton = new Button(dialogShell, SWT.NONE);
		{
			cancelButton.setText("Cancel");
			FormData cancelButtonLayoutData = new FormData();
			cancelButtonLayoutData.right = new FormAttachment(okButton, -5);
			cancelButtonLayoutData.bottom = new FormAttachment(okButton, 0, SWT.CENTER);
			cancelButtonLayoutData.width = 80;
			cancelButton.setLayoutData(cancelButtonLayoutData);
		}

		// Remote registry group box.
		remoteRegistryGroupBox = new Group(dialogShell, SWT.NONE);
		{
			remoteRegistryGroupBox.setText("Browse Remote Registry");
			FormData remoteRegistryGroupBoxLayoutData = new FormData();
			remoteRegistryGroupBoxLayoutData.bottom = new FormAttachment(okButton, -5);
			remoteRegistryGroupBoxLayoutData.right = new FormAttachment(100);
			remoteRegistryGroupBoxLayoutData.left = new FormAttachment(0);
			remoteRegistryGroupBox.setLayoutData(remoteRegistryGroupBoxLayoutData);

			// Remote registry group box internal layout.
			FormLayout remoteRegistryInternalLayout = new FormLayout();
			remoteRegistryInternalLayout.marginHeight = 5;
			remoteRegistryInternalLayout.marginWidth = 5;
			remoteRegistryGroupBox.setLayout(remoteRegistryInternalLayout);

			// Registry url label.
			registryUrlLabel = new Label(remoteRegistryGroupBox, SWT.NONE);
			{
				registryUrlLabel.setText("Registry Url:");
				FormData registryUrlLabelLayoutData = new FormData();
				registryUrlLabelLayoutData.top = new FormAttachment(10);
				registryUrlLabelLayoutData.left = new FormAttachment(0);
				registryUrlLabelLayoutData.width = 100;
				registryUrlLabel.setLayoutData(registryUrlLabelLayoutData);
			}

			// Registry urls combo box.
			registryUrlsComboBox = new Combo(remoteRegistryGroupBox, SWT.BORDER);
			{
				for (String registryUrl : getKnownRegistryUrls()) {
					registryUrlsComboBox.add(registryUrl);
				}

				// Select the most recent entry (assuming registryUrlSet is
				// ordered).
				registryUrlsComboBox.select(registryUrlsComboBox.getItemCount() - 1);

				FormData registryUrlsComboBoxLayoutData = new FormData();
				registryUrlsComboBoxLayoutData.left = new FormAttachment(registryUrlLabel, 5);
				registryUrlsComboBoxLayoutData.top =
				                                     new FormAttachment(registryUrlLabel, 0,
				                                                        SWT.CENTER);
				registryUrlsComboBoxLayoutData.right = new FormAttachment(100);
				registryUrlsComboBox.setLayoutData(registryUrlsComboBoxLayoutData);
			}

			// Registry type combo box.
			registryTypeComboBox = new Combo(remoteRegistryGroupBox, SWT.NONE);
			{
				registryTypeComboBox.add(G_REG_LITERAL, G_REG_INDEX);
				registryTypeComboBox.add(C_REG_LITERAL, C_REG_INDEX);
				registryTypeComboBox.select(0);

				FormData registryTypeComboBoxLayoutData = new FormData();
				registryTypeComboBoxLayoutData.top = new FormAttachment(registryUrlsComboBox, 5);
				registryTypeComboBoxLayoutData.left =
				                                      new FormAttachment(registryUrlsComboBox, 0,
				                                                         SWT.LEAD);
				registryTypeComboBox.setLayoutData(registryTypeComboBoxLayoutData);
			}

			// Registry type label.
			registryTypeLabel = new Label(remoteRegistryGroupBox, SWT.NONE);
			{
				registryTypeLabel.setText("Registry Type:");
				FormData registryTypeLabelLayoutData = new FormData();
				registryTypeLabelLayoutData.top =
				                                  new FormAttachment(registryTypeComboBox, 0,
				                                                     SWT.CENTER);
				registryTypeLabelLayoutData.left = new FormAttachment(0);
				registryTypeLabelLayoutData.right = new FormAttachment(registryTypeComboBox);
				registryTypeLabel.setLayoutData(registryTypeLabelLayoutData);
			}

			// Browse button.
			browseButton = new Button(remoteRegistryGroupBox, SWT.NONE);
			{
				browseButton.setText("Browse");
				FormData browseButtonLayoutData = new FormData();
				browseButtonLayoutData.left = new FormAttachment(registryTypeComboBox, 5);
				browseButtonLayoutData.top =
				                             new FormAttachment(registryTypeComboBox, 0, SWT.CENTER);
				browseButtonLayoutData.width = 80;
				browseButton.setLayoutData(browseButtonLayoutData);
			}
		}

		// Local entries group box.
		if (!localNamedEntities.isEmpty()) {
			localEntriesGroupBox = new Group(dialogShell, SWT.NONE);
			{
				localEntriesGroupBox.setText("Select Local Entry");
				FormData localEntriesGroupBoxLayoutData = new FormData();
				localEntriesGroupBoxLayoutData.top = new FormAttachment(rkTextField, 5);
				localEntriesGroupBoxLayoutData.left = new FormAttachment(0);
				localEntriesGroupBoxLayoutData.right = new FormAttachment(100);
				localEntriesGroupBoxLayoutData.bottom =
				                                        new FormAttachment(remoteRegistryGroupBox,
				                                                           -5);
				localEntriesGroupBox.setLayoutData(localEntriesGroupBoxLayoutData);

				// Local entries group box internal layout.
				FormLayout localEntriesGroupBoxInternalLayout = new FormLayout();
				localEntriesGroupBoxInternalLayout.marginHeight = 5;
				localEntriesGroupBoxInternalLayout.marginWidth = 5;
				localEntriesGroupBox.setLayout(localEntriesGroupBoxInternalLayout);

				// Local entries label.
				localEntriesLabel = new Label(localEntriesGroupBox, SWT.NONE);
				{
					localEntriesLabel.setText("Following local entries are available:");
					FormData localEntriesLabelLayoutData = new FormData();
					localEntriesLabelLayoutData.top = new FormAttachment(0);
					localEntriesLabelLayoutData.left = new FormAttachment(0);
					localEntriesLabel.setLayoutData(localEntriesLabelLayoutData);
				}

				// Local entries list box.
				localEntriesListBox =
				                      new List(localEntriesGroupBox, SWT.BORDER | SWT.V_SCROLL |
				                                                     SWT.H_SCROLL);
				{
					for (NamedEntityDescriptor descriptor : localNamedEntities) {
						localEntriesListBox.add(descriptor.toString());
					}

					FormData localEntriesListBoxLayoutData = new FormData();
					localEntriesListBoxLayoutData.top = new FormAttachment(localEntriesLabel, 5);
					localEntriesListBoxLayoutData.left = new FormAttachment(0);
					localEntriesListBoxLayoutData.bottom = new FormAttachment(100);
					localEntriesListBoxLayoutData.right = new FormAttachment(100);
					localEntriesListBoxLayoutData.height = 100;
					localEntriesListBoxLayoutData.width = 300;
					localEntriesListBox.setLayoutData(localEntriesListBoxLayoutData);
				}
			}
		} else {
			dummyLabel = new Label(dialogShell, SWT.NONE);
			FormData dummyLabelLayoutData = new FormData();
			dummyLabelLayoutData.top = new FormAttachment(rkTextField, 5);
			dummyLabelLayoutData.bottom = new FormAttachment(remoteRegistryGroupBox);
			dummyLabelLayoutData.height = 0;
			dummyLabel.setLayoutData(dummyLabelLayoutData);
		}

		loadConfiguration();
		initActions();
		setTabOrder();

		// Open dialog.
		dialogShell.layout();
		dialogShell.pack();
		centerDialog();
		dialogShell.getShell().setSize(500, 300);
		dialogShell.open();
		Display display = dialogShell.getDisplay();
		while (!dialogShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	private void loadConfiguration() {
		dialogShell.setText(String.format("Registry Key Property Editor", "XSLT Path"));
		if (!StringUtils.isBlank("xsltPath")) {
			rkTextField.setText("");
		}
	}

	private void initActions() {
		if (null != localEntriesListBox) {
			localEntriesListBox.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					String[] selection = localEntriesListBox.getSelection();
					if (selection.length > 0) {
						NamedEntityDescriptor descriptor =
						                                   NamedEntityDescriptor.fromString(selection[0]);
						if (null != descriptor) {
							rkTextField.setText(descriptor.getName());
						}
					}
				}
			});
		}

		browseButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				openRegistryBrowser();
			}
		});

		okButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				try {
					setSaved(true);
					xsltPathProperty = rkTextField.getText();
				} catch (Exception ex) {
					okButton.setEnabled(false);
				}
				dialogShell.dispose();
			}
		});

		cancelButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				setSaved(false);
				dialogShell.dispose();
			}
		});
	}

	private void setTabOrder() {
		Control[] remoteRegistryGroupBoxTabOrder =
		                                           new Control[] { registryUrlsComboBox,
		                                                          registryTypeComboBox,
		                                                          browseButton };
		remoteRegistryGroupBox.setTabList(remoteRegistryGroupBoxTabOrder);

		Control[] globalTabOrder;
		if (null != localEntriesGroupBox) {
			globalTabOrder =
			                 new Control[] { rkTextField, localEntriesGroupBox,
			                                remoteRegistryGroupBox, okButton, cancelButton };
		} else {
			globalTabOrder =
			                 new Control[] { rkTextField, remoteRegistryGroupBox, okButton,
			                                cancelButton };
		}
		dialogShell.setTabList(globalTabOrder);
	}

	private void centerDialog() {
		Rectangle parentBounds = getParent().getBounds();
		Rectangle dialogBounds = dialogShell.getBounds();
		int centerX, centerY;
		centerX = (parentBounds.width - dialogBounds.width) / 2 + parentBounds.x;
		centerY = (parentBounds.height - dialogBounds.height) / 2 + parentBounds.y;
		dialogShell.setLocation(new Point(centerX, centerY));
	}

	private void openRegistryBrowser() {
		// Configure registry connection.
		String currentRegistryUrl = registryUrlsComboBox.getText();
		IRegistryConnection registryConnection = new RegistryConnection();
		registryConnection.setConnectionName("eclipse-esb-tool-registry-connection");
		registryConnection.setId(UUID.randomUUID().toString());
		try {
			registryConnection.setURL(new URL(currentRegistryUrl));
		} catch (MalformedURLException ex) {
			MessageDialog.openError(dialogShell, "Registry Browser", "Invalid Registry URL");
			return;
		}
		String registryName = G_REG_LITERAL;
		registryConnection.setPath(G_REG_PATH_PREFIX);
		if (registryTypeComboBox.getSelectionIndex() == C_REG_INDEX) {
			registryName = C_REG_LITERAL;
			registryConnection.setPath(C_REG_PATH_PREFIX);
		}

		IRegistryData selectedPathData = null;
		// Open registry browser.
		try {
			selectedPathData =
			                   CAppEnvironment.getRegistryHandler()
			                                  .selectRegistryPath(new IRegistryConnection[] { registryConnection },
			                                                      registryName,
			                                                      "Select Registry Resource:",
			                                                      IRegistryHandler.SELECTED_REGISTRY_RESOURCE);
		} catch (Exception e) {

			okButton.setEnabled(false);
		}

		// Convert to prefixed format.
		String selectedPath = selectedPathData.getPath();

		if (selectedPath.startsWith(G_REG_PATH_PREFIX)) {
			selectedPath =
			               String.format("gov:%s",
			                             selectedPath.substring(G_REG_PATH_PREFIX.length()));
		} else if (selectedPath.startsWith(C_REG_PATH_PREFIX)) {
			selectedPath =
			               String.format("conf:%s",
			                             selectedPath.substring(C_REG_PATH_PREFIX.length()));
		}

		// Save current registry url for later use.
		updateKnownRegistryUrls(currentRegistryUrl);

		rkTextField.setText(selectedPath);
	}

	private void setSaved(boolean saved) {
		this.saved = saved;
	}

	public boolean isSaved() {
		return saved;
	}

	/**
	 * @return ordered set of currently known registry urls.
	 */
	private static Set<String> getKnownRegistryUrls() {
		if (null == knownRegistryUrls) {
			knownRegistryUrls = new LinkedHashSet<String>();
			String registryUrlsPrefValue =
			                               DsEditorPlugin.getPlugin().getPreferenceStore()
			                                             .getString(REGISTRY_URLS_PREFERENCE_KEY);
			if (!StringUtils.isBlank(registryUrlsPrefValue)) {
				// Decode.
				for (String registryUrl : registryUrlsPrefValue.split("\n")) {
					if (!StringUtils.isBlank(registryUrl)) {
						knownRegistryUrls.add(registryUrl);
					}
				}
			}
			knownRegistryUrls.add(DEFAULT_REGISTRY_URL);
		}
		return knownRegistryUrls;
	}

	/**
	 * Updates the set of known registry urls with the given value.
	 * 
	 * @param newRegistryUrl
	 *            new registry url.
	 */
	private static void updateKnownRegistryUrls(String newRegistryUrl) {
		if (knownRegistryUrls.add(newRegistryUrl)) {
			// Update the preference value.
			StringBuffer buffer = new StringBuffer();
			for (String registryUrl : knownRegistryUrls) {
				buffer.append(registryUrl).append("\n");
			}
			DsEditorPlugin.getPlugin().getPreferenceStore()
			              .setValue(REGISTRY_URLS_PREFERENCE_KEY, buffer.toString());
		}
	}

	public String getXsltPathProperty() {
		return xsltPathProperty;
	}

}

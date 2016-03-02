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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
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
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.XPathSelectorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator.XpathValidator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;

/**
 * A SWT based editor dialog to be used for editing namespaced properties.
 */
public class NamespacedPropertyEditorDialog extends Dialog {
	/**
	 * Dialog shell.
	 */
	private Shell dialogShell;
	
	/**
	 * Group box for separating property value edit area.
	 */
	private Group propertyGroupBox;
	
	/**
	 * Text field used for manipulating property value.
	 */
	private Text propertyTextField;
	
	/**
	 * Button used to fire up the xpath editor.
	 */
	private Button selectXpathButton;
	
	/**
	 * Group box for separating namespaces edit area.
	 */
	private Group namespacesGroupBox;
	
	/**
	 * Namespace 'Prefix' label.
	 */
	private Label nsPrefixLabel;
	
	/**
	 * Namespace prefix text field.
	 */
	private Text nsPrefixTextField;
	
	/**
	 * Namespace 'URI' label.
	 */
	private Label nsUriLabel;
	
	/**
	 * Namespace URI text field.
	 */
	private Text nsUriTextField;
	
	/**
	 * Namespace list box.
	 */
	private List nsListBox;
	
	/**
	 * Add namespace button.
	 */
	private Button addButton;
	
	/**
	 * Edit namespace button.
	 */
	private Button editButton;
	
	/**
	 * Remove namespace button.
	 */
	private Button removeButton;
	
	/**
	 * Cancel button.
	 */
	private Button cancelButton;
	
	/**
	 * Ok button.
	 */
	private Button okButton;
	
	/**
	 * {@link NamespacedProperty} being edited.
	 */
	private NamespacedProperty nsProperty;
	
	/**
	 * Namespaces collected.
	 */
	private Map<String, String> collectedNamespaces;

	/**
	 * Format string used for displaying namespaces.
	 */
	private static final String namespaceDisplayFormat = "xmlns:%s=\"%s\"";

	/**
	 * Regex pattern used to identify a namespace string.
	 */
	private static final Pattern namespaceDisplayPattern = Pattern.compile("xmlns:([^=]++)=.*+");
	
	/**
	 * Status indicating whether this dialog was saved or cancelled.
	 */
	private boolean saved;
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	/**
	 * Constructs a new dialog.
	 * 
	 * @param parent parent shell.
	 * @param style style.
	 * @param property namespaced property to be manipulated.
	 */
	public NamespacedPropertyEditorDialog(Shell parent, int style, NamespacedProperty property) {
		super(parent, style);
		this.nsProperty = property;
		this.collectedNamespaces = new HashMap<String, String>();
	}
	
	/**
	 * Main function used for testing purposes.
	 * 
	 * @param args arguments.
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		NamespacedPropertyEditorDialog dialog = new NamespacedPropertyEditorDialog(shell, SWT.NULL,
				EsbFactory.eINSTANCE.createNamespacedProperty());
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
		
		// Construct and layout property edit box.
		propertyGroupBox = new Group(dialogShell, SWT.NONE);
		{
			propertyGroupBox.setText("Property");
			FormData groupBoxLayoutData = new FormData();
			groupBoxLayoutData.top = new FormAttachment(0);
			groupBoxLayoutData.left = new FormAttachment(0);
			groupBoxLayoutData.right = new FormAttachment(100);
			propertyGroupBox.setLayoutData(groupBoxLayoutData);

			// Configure group box internal layout.
			FormLayout groupBoxLayout = new FormLayout();
			groupBoxLayout.marginWidth = 5;
			groupBoxLayout.marginHeight = 5;
			propertyGroupBox.setLayout(groupBoxLayout);

			// Xpath editor launch button.
			selectXpathButton = new Button(propertyGroupBox, SWT.NONE);
			selectXpathButton.setText("Select XPath");
			FormData selectXpathButtonLayoutData = new FormData();
			selectXpathButtonLayoutData.right = new FormAttachment(100);
			selectXpathButtonLayoutData.top = new FormAttachment(0);
			selectXpathButton.setLayoutData(selectXpathButtonLayoutData);
			
			// Property editor text field.
			propertyTextField = new Text(propertyGroupBox, SWT.BORDER);
			FormData textFieldLayoutData = new FormData();
			textFieldLayoutData.right = new FormAttachment(selectXpathButton, -5);
			textFieldLayoutData.top = new FormAttachment(selectXpathButton, 0, SWT.CENTER);
			textFieldLayoutData.left = new FormAttachment(0);			
			propertyTextField.setLayoutData(textFieldLayoutData);
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
			cancelButtonLayoutData.top = new FormAttachment(okButton, 0, SWT.CENTER);
			cancelButtonLayoutData.right = new FormAttachment(okButton, -5);
			cancelButtonLayoutData.width = 80;
			cancelButton.setLayoutData(cancelButtonLayoutData);
		}
		
		// Construct and layout namespace edit box.
		namespacesGroupBox = new Group(dialogShell, SWT.NONE);
		{
			namespacesGroupBox.setText("Namespaces");
			FormData groupBoxLayoutData = new FormData();
			groupBoxLayoutData.top = new FormAttachment(propertyGroupBox, 5);
			groupBoxLayoutData.left = new FormAttachment(0);
			groupBoxLayoutData.right = new FormAttachment(100);
			groupBoxLayoutData.bottom = new FormAttachment(okButton, -10);
			namespacesGroupBox.setLayoutData(groupBoxLayoutData);
			
			// Configure group box internal layout.
			FormLayout groupBoxLayout = new FormLayout();
			groupBoxLayout.marginWidth = 5;
			groupBoxLayout.marginHeight = 5;
			namespacesGroupBox.setLayout(groupBoxLayout);
			
			// Namespace prefix label.
			nsPrefixLabel = new Label(namespacesGroupBox, SWT.NONE);
			{
				nsPrefixLabel.setText("Prefix:");
				FormData nsPrefixLabelLayoutData = new FormData();
				nsPrefixLabelLayoutData.top = new FormAttachment(0);
				nsPrefixLabelLayoutData.left = new FormAttachment(0);
				nsPrefixLabel.setLayoutData(nsPrefixLabelLayoutData);
			}
			
			// Namespace prefix text field.
			nsPrefixTextField = new Text(namespacesGroupBox, SWT.BORDER);
			{
				FormData nsPrefixTextFieldLayoutData = new FormData();
				nsPrefixTextFieldLayoutData.top = new FormAttachment(nsPrefixLabel, 0, SWT.CENTER);
				nsPrefixTextFieldLayoutData.left = new FormAttachment(nsPrefixLabel, 5);
				nsPrefixTextFieldLayoutData.width = 100;
				nsPrefixTextField.setLayoutData(nsPrefixTextFieldLayoutData);
			}
			
			// Namespace URI label.
			nsUriLabel = new Label(namespacesGroupBox, SWT.NONE);
			{
				nsUriLabel.setText("URI:");
				FormData nsUriLabelLayoutData = new FormData();
				nsUriLabelLayoutData.top = new FormAttachment(nsPrefixTextField, 0, SWT.CENTER);
				nsUriLabelLayoutData.left = new FormAttachment(nsPrefixTextField, 5);
				nsUriLabel.setLayoutData(nsUriLabelLayoutData);
			}
			
			// Add namespace button.
			addButton = new Button(namespacesGroupBox, SWT.NONE);
			{
				addButton.setText("Add");
				FormData addButtonLayoutData = new FormData();
				addButtonLayoutData.top = new FormAttachment(nsUriLabel, 0, SWT.CENTER);
				addButtonLayoutData.right = new FormAttachment(100);
				addButtonLayoutData.width = 80;
				addButton.setLayoutData(addButtonLayoutData);
			}
			
			// Namespace URI input text field.
			nsUriTextField = new Text(namespacesGroupBox, SWT.BORDER);
			{
				FormData nsUriTextFieldLayoutData = new FormData();
				nsUriTextFieldLayoutData.top = new FormAttachment(nsUriLabel, 0, SWT.CENTER);
				nsUriTextFieldLayoutData.left = new FormAttachment(nsUriLabel, 5);
				nsUriTextFieldLayoutData.right = new FormAttachment(addButton, -5);
				nsUriTextField.setLayoutData(nsUriTextFieldLayoutData);
			}
			
			// Edit namespace button.
			editButton = new Button(namespacesGroupBox, SWT.NONE);
			{
				editButton.setText("Edit");
				FormData editButtonLayoutData = new FormData();
				editButtonLayoutData.top = new FormAttachment(addButton, 10);
				editButtonLayoutData.right = new FormAttachment(100);
				editButtonLayoutData.left = new FormAttachment(addButton, 0, SWT.LEFT);
				editButton.setLayoutData(editButtonLayoutData);
			}
			
			// Remove namespace button.
			removeButton = new Button(namespacesGroupBox, SWT.NONE);
			{
				removeButton.setText("Remove");
				FormData removeButtonLayoutData = new FormData();
				removeButtonLayoutData.top = new FormAttachment(editButton, 5);
				removeButtonLayoutData.right = new FormAttachment(100);
				removeButtonLayoutData.left = new FormAttachment(editButton, 0, SWT.LEFT);
				removeButton.setLayoutData(removeButtonLayoutData);
			}
			
			// Namespaces list box.
			nsListBox = new List(namespacesGroupBox, SWT.BORDER);
			{
				FormData nsListBoxFormData = new FormData();
				nsListBoxFormData.top = new FormAttachment(editButton, 0, SWT.TOP);
				nsListBoxFormData.left = new FormAttachment(0);
				nsListBoxFormData.right = new FormAttachment(addButton, -5);
				nsListBoxFormData.bottom = new FormAttachment(100);
				nsListBox.setLayoutData(nsListBoxFormData);
			}						
		}
	
		loadConfiguration();
		initActions();
		setTabOrder();
	
		// Open dialog.
		dialogShell.layout();
		dialogShell.pack();			
		dialogShell.setSize(640, 415);
		centerDialog();
		dialogShell.open();
		Display display = dialogShell.getDisplay();
		while (!dialogShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	
	private void loadConfiguration() {
		dialogShell.setText(String.format("Namespaced Property Editor", nsProperty.getPrettyName()));
		propertyGroupBox.setText(nsProperty.getPrettyName());
		if (!StringUtils.isBlank(nsProperty.getPropertyValue())) {
			propertyTextField.setText(nsProperty.getPropertyValue());
		}
		
		// Load namespaces.
		for (Entry<String, String> nsEntry : nsProperty.getNamespaces().entrySet()) {
			addNamespace(nsEntry.getKey(), nsEntry.getValue());
		}
	}
	
	private void initActions() {
		selectXpathButton.addListener(SWT.Selection, new Listener() {			
			public void handleEvent(Event event) {			
				XPathSelectorDialog xpathEditorDialog = new XPathSelectorDialog(dialogShell);
				xpathEditorDialog.open();
				if (!StringUtils.isBlank(xpathEditorDialog.getSelectedXpath())) {
					propertyTextField.setText(xpathEditorDialog.getSelectedXpath());
				}
				collectedNamespaces.clear();
				nsListBox.removeAll();
				for (Entry<String, String> nsEntry: xpathEditorDialog.getNameSpaces().entrySet()) {
					addNamespace(nsEntry.getKey(), nsEntry.getValue());
				}
			}
		});
		
		addButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				String prefix = nsPrefixTextField.getText();
				String uri = nsUriTextField.getText();
				if (XpathValidator.isValidNamespace(dialogShell, collectedNamespaces, prefix, uri)) {
					addNamespace(prefix, uri);
					nsPrefixTextField.setText("");
					nsUriTextField.setText("");
					nsPrefixTextField.setFocus();
				}
			}
		});

		removeButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				for (String selection : nsListBox.getSelection()) {
					removeNamespace(selection);
				}
			}
		});

		editButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				String[] selection = nsListBox.getSelection();
				if (selection.length > 0) {
					String selectedNamespace = selection[0];
					String prefix = extractPrefix(selectedNamespace);
					String uri = collectedNamespaces.get(prefix);
					if (null != uri) {
						collectedNamespaces.remove(prefix);
						nsPrefixTextField.setText(prefix);
						nsUriTextField.setText(uri);
						nsPrefixTextField.setFocus();
					}
					nsListBox.remove(selectedNamespace);
				}
			}
		});
		
		okButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				if (XpathValidator.isValidConfiguration(dialogShell, propertyTextField.getText(), collectedNamespaces)) {
					try {
						saveConfiguration();
						setSaved(true);
					} catch (Exception ex) {
						log.error("Error while saving namespace property",ex);
					}
					dialogShell.dispose();
				}
			}
		});
		
		cancelButton.addListener(SWT.Selection, new Listener() {			
			public void handleEvent(Event event) {
				setSaved(false);
				dialogShell.dispose();
			}
		});
	}

	private void addNamespace(String prefix, String uri) {
		collectedNamespaces.put(prefix, uri);
		String namespaceDisplayValue = String.format(namespaceDisplayFormat,
				prefix, uri);
		nsListBox.add(namespaceDisplayValue);
	}

	private void removeNamespace(String namespace) {
		nsListBox.remove(namespace);
		String prefix = extractPrefix(namespace);
		if (!StringUtils.isBlank(prefix)) {
			collectedNamespaces.remove(prefix);
		}
	}

	private String extractPrefix(String namespace) {
		Matcher matcher = namespaceDisplayPattern.matcher(namespace);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}
	
	private void centerDialog() {
		Rectangle parentBounds = getParent().getBounds();
		Rectangle dialogBounds = dialogShell.getBounds();
		int centerX, centerY;
		centerX = (parentBounds.width - dialogBounds.width)/2 + parentBounds.x;
		centerY = (parentBounds.height - dialogBounds.height)/2 + parentBounds.y;
		dialogShell.setLocation(new Point(centerX, centerY));
	}
	
	private void setTabOrder() {
		Control[] tabOrder = new Control[] { propertyTextField, selectXpathButton };
		propertyGroupBox.setTabList(tabOrder);
		
		tabOrder = new Control[] { nsPrefixTextField, nsUriTextField, addButton };
		namespacesGroupBox.setTabList(tabOrder);
		
		tabOrder = new Control[] { propertyGroupBox, namespacesGroupBox, okButton };
		dialogShell.setTabList(tabOrder);
	}
	
	private void saveConfiguration() throws Exception {
		nsProperty.setPropertyValue(propertyTextField.getText());
		nsProperty.getNamespaces().clear();
		nsProperty.getNamespaces().putAll(collectedNamespaces);
	}
	
	private void setSaved(boolean saved) {
		this.saved = saved;
	}
	
	public boolean isSaved() {
		return saved;
	}
}

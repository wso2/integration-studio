package org.wso2.developerstudio.eclipse.esb.presentation.ui;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.wso2.developerstudio.eclipse.esb.ModelObject;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;

public class NamespacedPropertyDecoratorHeaderMediator extends
		NamespacedPropertyEditor {

	CellEditor decoratedEditor;
	NamespacedProperty oldNamespaceProperty;
	String definedURI;
	String prefix;

	public NamespacedPropertyDecoratorHeaderMediator(CellEditor cellEditor,
			Composite parent, NamespacedProperty namespacedProperty,
			Object propertyContainer, IItemPropertyDescriptor propertyDescriptor) {
		super(parent, namespacedProperty, propertyContainer, propertyDescriptor);
		this.decoratedEditor = cellEditor;
		this.oldNamespaceProperty=namespacedProperty;		
	}

	protected Object openDialogBox(Control cellEditorWindow) {
		NamespacedPropertyEditorDialog dialog = new NamespacedPropertyEditorDialog(
				cellEditorWindow.getShell(), getStyle(), namespacedProperty) {
			protected void initActions() {
				//okButton.setEnabled(false);
                if(nsListBox.getItemCount() > 0){
                	addButton.setEnabled(false);
					nsPrefixTextField.setEnabled(false);
					nsUriTextField.setEnabled(false);
                }
				selectXpathButton.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						XPathSelectorDialog xpathEditorDialog = new XPathSelectorDialog(
								dialogShell);
						xpathEditorDialog.open();
						if (!StringUtils.isBlank(xpathEditorDialog
								.getSelectedXpath())) {
							propertyTextField.setText(xpathEditorDialog
									.getSelectedXpath());
						}
					}
				});

				addButton.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						addToListBox();						
					}
				});

				removeButton.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						for (String selection : nsListBox.getSelection()) {
							removeNamespace(selection);
						}
						if (nsListBox.getItemCount() == 0
								| propertyTextField.getText().equals("")) {
							//okButton.setEnabled(false);
							addButton.setEnabled(true);
							nsPrefixTextField.setEnabled(true);
							nsUriTextField.setEnabled(true);
						} else {
							//okButton.setEnabled(true);
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
						if (nsListBox.getItemCount() == 0
								| propertyTextField.getText().equals("")) {
							//okButton.setEnabled(false);
							addButton.setEnabled(true);
							nsPrefixTextField.setEnabled(true);
							nsUriTextField.setEnabled(true);
						} else {
							//okButton.setEnabled(true);
						}
					}
				});

				okButton.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						try {
							addToListBox();
							saveConfiguration();
							setSaved(true);
						} catch (Exception ex) {
							// TODO: Report validation error here.
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

				propertyTextField.addListener(SWT.CHANGED, new Listener() {

					public void handleEvent(Event event) {
						if (propertyTextField.getText().equals("")) {
							okButton.setEnabled(false);
						} else {
							okButton.setEnabled(true);
						}
					}
				});

			}
			
			
			private static final String namespaceDisplayFormat = "xmlns:%s=\"%s\"";
			private void addToListBox(){
				if(!nsPrefixTextField.getText().equals("")){
				 prefix = nsPrefixTextField.getText();
				String uri = nsUriTextField.getText();			
				
				if (!prefix.equals("") & uri.equals("")) {
					if(checkExistingNamespaces(prefix)){
						addNamespace(prefix, definedURI);
						
						
						//String namespaceDisplayValue = String.format(namespaceDisplayFormat,
								//prefix, definedURI);
						//nsListBox.add(namespaceDisplayValue);
						//namespacedProperty.setPropertyName(prefix+":"+propertyTextField);
						nsPrefixTextField.setText("");
						nsUriTextField.setText("");
						nsPrefixTextField.setFocus();
					}
					
				} else if(!prefix.equals("") & !uri.equals("")){
					addNamespace(prefix, uri);
					nsPrefixTextField.setText("");
					nsUriTextField.setText("");
					nsPrefixTextField.setFocus();
				} else{
					//Validation
				}
				if (nsListBox.getItemCount() == 0){
					 
					//okButton.setEnabled(false);
					
				} else {
					if(!propertyTextField.getText().equals("")){
						okButton.setEnabled(true);
					}
					
					addButton.setEnabled(false);
					nsPrefixTextField.setEnabled(false);
					nsUriTextField.setEnabled(false);
				}
			}
			}
			private boolean checkExistingNamespaces(String prefix){				
				ModelObject root = (ModelObject) EcoreUtil.getRootContainer(oldNamespaceProperty);
				int size=root.getAdditionalNamespaces().size();
				for(int i=0;i<size;++i){
					if(root.getAdditionalNamespaces().get(i).getPrefix().equals(prefix)){
						definedURI=root.getAdditionalNamespaces().get(i).getUri();
						return true;
					}
				}				
				return false;
			}
			
		};
		dialog.open();
		if (dialog.isSaved()) {
			propertyDescriptor.setPropertyValue(propertyContainer,
					namespacedProperty);
		}
		return null;
	}
}

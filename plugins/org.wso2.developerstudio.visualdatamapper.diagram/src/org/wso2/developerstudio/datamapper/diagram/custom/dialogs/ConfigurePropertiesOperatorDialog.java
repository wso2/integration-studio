/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.datamapper.diagram.custom.dialogs;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.Properties;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorBasicContainerEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorRectangle;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorRightConnectorEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorRightContainerEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.PropertiesEditPart;
import org.wso2.developerstudio.datamapper.impl.PropertiesImpl;

public class ConfigurePropertiesOperatorDialog extends AbstractConfigureOperatorDialog {

	private String type;
	private String scope;
	PropertiesImpl property = null;
	private TransactionalEditingDomain editingDomain;
	private EditPart editPart;
	private String name;

	public ConfigurePropertiesOperatorDialog(Shell parentShell, Properties constantOperator,
			TransactionalEditingDomain editingDomain, EditPart constantEditPart) {
		super(parentShell);
		this.editingDomain = editingDomain;
		this.editPart = constantEditPart;
		property = (PropertiesImpl) constantOperator;
	}

	@Override
	public void create() {
		super.create();
		setTitle("Configure Properties Operator");
		setMessage("Set properties operator attributes", IMessageProvider.INFORMATION);
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		// Set title.
		newShell.setText("Properties Operator Attributes");
	}

	protected Control createDialogArea(Composite parent) {

		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		Label propertiesTypeLabel = new Label(container, SWT.NULL);
		propertiesTypeLabel.setText("Property Type : ");
		final Combo propertiesTypeDropDown = new Combo(container, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
		propertiesTypeDropDown.setLayoutData(dataPropertyConfigText);
		propertiesTypeDropDown.add("STRING");
		propertiesTypeDropDown.add("NUMBER");
		propertiesTypeDropDown.add("BOOLEAN");
		if (property.getType() != null) {
			propertiesTypeDropDown.setText(property.getType().getLiteral());
		} else {
			propertiesTypeDropDown.setText("STRING");
		}
		type = new String(propertiesTypeDropDown.getText());
		propertiesTypeDropDown.addListener(SWT.Modify, new Listener() {

			public void handleEvent(Event event) {
				try {
					type = new String(propertiesTypeDropDown.getText());
					if (!(StringUtils.isEmpty(type) && StringUtils.isEmpty(scope) && StringUtils.isEmpty(name))) {
						getButton(IDialogConstants.OK_ID).setEnabled(true);
						validate();
					} else {
						getButton(IDialogConstants.OK_ID).setEnabled(false);
					}
				} catch (Exception e) {
					getButton(IDialogConstants.OK_ID).setEnabled(false);
				}
			}
		});

		Label propertyScopeLabel = new Label(container, SWT.NULL);
		propertyScopeLabel.setText("Property Scope : ");

		final Text propertyScope = new Text(container, SWT.BORDER);
		propertyScope.setLayoutData(dataPropertyConfigText);
		if (property.getName() != null) {
			propertyScope.setText(property.getScope());
		} else {
			propertyScope.setText("");
		}
		scope = new String(propertyScope.getText());
		propertyScope.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				try {
					scope = new String(propertyScope.getText());
					if (!(StringUtils.isEmpty(type) && StringUtils.isEmpty(scope) && StringUtils.isEmpty(name))) {
						getButton(IDialogConstants.OK_ID).setEnabled(true);
						validate();
					} else {
						getButton(IDialogConstants.OK_ID).setEnabled(false);
					}
				} catch (Exception e) {
					getButton(IDialogConstants.OK_ID).setEnabled(false);
				}
			}
		});

		Label propertyNameLabel = new Label(container, SWT.NULL);
		propertyNameLabel.setText("Property Name : ");

		final Text propertyName = new Text(container, SWT.BORDER);
		propertyName.setLayoutData(dataPropertyConfigText);
		if (property.getName() != null) {
			propertyName.setText(property.getName());
		} else {
			propertyName.setText("");
		}
		name = new String(propertyName.getText());
		propertyName.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				try {
					name = new String(propertyName.getText());
					if (!(StringUtils.isEmpty(type) && StringUtils.isEmpty(scope) && StringUtils.isEmpty(name))) {
						getButton(IDialogConstants.OK_ID).setEnabled(true);
						validate();
					} else {
						getButton(IDialogConstants.OK_ID).setEnabled(false);
					}
				} catch (Exception e) {
					getButton(IDialogConstants.OK_ID).setEnabled(false);
				}
			}
		});

		return area;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		validate();
	}

	private void validate() {
		boolean isEnabled = false;
		Button okButton = getButton(IDialogConstants.OK_ID);
		if (StringUtils.isNotEmpty(scope) && StringUtils.isNotEmpty(type) && StringUtils.isNotEmpty(name)) {
			isEnabled = true;
		}
		if (okButton != null) {
			okButton.setEnabled(isEnabled);
		}
	}

	protected void okPressed() {

		Properties constantOperatorInstance = property;
		if (StringUtils.isNotEmpty(name)) {
			SetCommand setCmnd = new SetCommand(editingDomain, constantOperatorInstance,
					DataMapperPackage.Literals.PROPERTIES__NAME, name);
			if (setCmnd.canExecute()) {
				editingDomain.getCommandStack().execute(setCmnd);
				((OperatorRectangle) ((PropertiesEditPart) editPart).getPropertiesFigure())
						.changeOperatorHeader("Properties : \"" + property.getScope() + "\\" + name + "\"");
			}
		}
		if (StringUtils.isNotEmpty(scope)) {
			SetCommand setCmnd = new SetCommand(editingDomain, constantOperatorInstance,
					DataMapperPackage.Literals.PROPERTIES__SCOPE, scope);
			if (setCmnd.canExecute()) {
				editingDomain.getCommandStack().execute(setCmnd);
				((OperatorRectangle) ((PropertiesEditPart) editPart).getPropertiesFigure())
						.changeOperatorHeader("Properties : \"" + scope + "\\" + property.getName() + "\"");
			}
		}
		
		if (StringUtils.isNotEmpty(type)) {
			SchemaDataType propertyType = SchemaDataType.get(type.toUpperCase());
			if (propertyType != null) {
				SetCommand setCmnd = new SetCommand(editingDomain, constantOperatorInstance,
						DataMapperPackage.Literals.PROPERTIES__TYPE, propertyType);
				if (setCmnd.canExecute()) {
					editingDomain.getCommandStack().execute(setCmnd);

					@SuppressWarnings("unchecked")
					List<EditPart> childContainers = ((OperatorBasicContainerEditPart) ((PropertiesEditPart) editPart)
							.getChildren().get(0)).getChildren();
					for (EditPart editPart : childContainers) {
						if (editPart instanceof OperatorRightContainerEditPart) {
							OperatorRightConnectorEditPart rightConnector = (OperatorRightConnectorEditPart) ((OperatorRightContainerEditPart) editPart)
									.getChildren().get(0);
							((OperatorRightConnectorEditPart) rightConnector).setPropertyTypeInConnector(propertyType);
						}
					}
				}
			} else {
				throw new IllegalArgumentException("Unknown type found : " + type);
			}

		}
		 
		super.okPressed();
	}

}

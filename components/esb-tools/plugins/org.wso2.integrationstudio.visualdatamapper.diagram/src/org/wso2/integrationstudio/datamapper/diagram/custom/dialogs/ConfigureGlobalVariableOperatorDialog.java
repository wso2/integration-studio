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
package org.wso2.integrationstudio.datamapper.diagram.custom.dialogs;

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
import org.eclipse.ui.actions.GlobalBuildAction;
import org.wso2.integrationstudio.datamapper.Constant;
import org.wso2.integrationstudio.datamapper.DataMapperPackage;
import org.wso2.integrationstudio.datamapper.GlobalVariable;
import org.wso2.integrationstudio.datamapper.OperatorBasicContainer;
import org.wso2.integrationstudio.datamapper.OperatorLeftConnector;
import org.wso2.integrationstudio.datamapper.OperatorRightConnector;
import org.wso2.integrationstudio.datamapper.OperatorRightContainer;
import org.wso2.integrationstudio.datamapper.SchemaDataType;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.ConcatEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.ConstantEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.GlobalVariableEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OperatorBasicContainerEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OperatorLeftConnectorEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OperatorRectangle;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OperatorRightConnectorEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OperatorRightContainerEditPart;
import org.wso2.integrationstudio.datamapper.impl.ConstantImpl;
import org.wso2.integrationstudio.datamapper.impl.GlobalVariableImpl;

public class ConfigureGlobalVariableOperatorDialog extends AbstractConfigureOperatorDialog {

	private String name;
	private String value;
	GlobalVariableImpl gloabalVariable = null;
	private TransactionalEditingDomain editingDomain;
	private EditPart editPart;

	public ConfigureGlobalVariableOperatorDialog(Shell parentShell, GlobalVariable constantOperator,
			TransactionalEditingDomain editingDomain,EditPart constantEditPart) {
		super(parentShell);
		this.editingDomain = editingDomain;
		this.editPart = constantEditPart;
		gloabalVariable = (GlobalVariableImpl) constantOperator;
	}

	@Override
	public void create() {
		super.create();
		setTitle("Configure Global Variable Operator");
		setMessage("Set Global Variable properties", IMessageProvider.INFORMATION);
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		// Set title.
		newShell.setText("Global Variable Operator Properties");
	}

	protected Control createDialogArea(Composite parent) {

		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		Label constantTypeLabel = new Label(container, SWT.NULL);
		constantTypeLabel.setText("Varibale Name : ");

		final Text variableName = new Text(container, SWT.BORDER);
		variableName.setLayoutData(dataPropertyConfigText);
		if (gloabalVariable.getName() != null) {
			variableName.setText(gloabalVariable.getName());
		} else {
			variableName.setText("");
		}
		name = new String(variableName.getText());
		variableName.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				try {
					name = new String(variableName.getText());
					if (!(StringUtils.isEmpty(name) && StringUtils.isEmpty(value))) {
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


		Label constantValueLabel = new Label(container, SWT.NULL);
		constantValueLabel.setText("Default Value : ");

		final Text constantValue = new Text(container, SWT.BORDER);
		constantValue.setLayoutData(dataPropertyConfigText);
		if (gloabalVariable.getDefaultValue() != null) {
			constantValue.setText(gloabalVariable.getDefaultValue());
		} else {
			constantValue.setText("");
		}
		value = new String(constantValue.getText());
		constantValue.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				try {
					value = new String(constantValue.getText());
					if (!(StringUtils.isEmpty(name) && StringUtils.isEmpty(value))) {
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
		if (StringUtils.isNotEmpty(value) && StringUtils.isNotEmpty(name)) {
			isEnabled = true;
		}
		if (okButton != null) {
			okButton.setEnabled(isEnabled);
		}
	}

	protected void okPressed() {

		GlobalVariable constantOperatorInstance = (GlobalVariable) gloabalVariable;
		if (StringUtils.isNotEmpty(value)) {
			SetCommand setCmnd = new SetCommand(editingDomain, constantOperatorInstance,
					DataMapperPackage.Literals.GLOBAL_VARIABLE__DEFAULT_VALUE, value);
			if (setCmnd.canExecute()) {
				editingDomain.getCommandStack().execute(setCmnd);
			}
		}
		if (StringUtils.isNotEmpty(name)) {
			SetCommand setCmnd = new SetCommand(editingDomain, constantOperatorInstance,
					DataMapperPackage.Literals.GLOBAL_VARIABLE__NAME, name);
			if (setCmnd.canExecute()) {
				editingDomain.getCommandStack().execute(setCmnd);
				((OperatorRectangle)((GlobalVariableEditPart)editPart).getGlobalVariableFigure()).changeOperatorHeader("Global Variable : \""+name+"\"");
			}
		}
		super.okPressed();
	}

}

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

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.datamapper.CustomFunction;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.OperatorLeftConnector;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.CustomFunctionEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorRectangle;
import org.wso2.developerstudio.datamapper.impl.CustomFunctionImpl;

public class ConfigureCustomFunctionOperatorDialog extends AbstractConfigureOperatorDialog {

	private String inputCount;
	private TransactionalEditingDomain editingDomain;
	private ArrayList<OperatorLeftConnector> caseOutputConnectors = new ArrayList<OperatorLeftConnector>();
	private CustomFunctionImpl customFunctionImpl;
	private EditPart editPart;
	private String functionName;
	private String functionDefinition;

	public ConfigureCustomFunctionOperatorDialog(Shell parentShell, CustomFunction concatOperator,
			TransactionalEditingDomain editingDomain, EditPart selectedEP) {
		super(parentShell);
		this.customFunctionImpl = (CustomFunctionImpl) concatOperator;
		this.editingDomain = editingDomain;
		this.editPart = selectedEP;
	}

	@Override
	public void create() {
		super.create();
		setTitle("Configure Custom Function Operator");
		setMessage("Set custom function operator properties", IMessageProvider.INFORMATION);
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		// Set title.
		newShell.setText("Configure Custom Function Operator");
	}

	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		Label functionNameLabel = new Label(container, SWT.NULL);
		functionNameLabel.setText("Function Name : ");

		final Text functionNameText = new Text(container, SWT.BORDER);
		functionNameText.setLayoutData(dataPropertyConfigText);
		if (customFunctionImpl.getFunctionName() != null) {
			functionNameText.setText(customFunctionImpl.getFunctionName());
		}
		functionName = functionNameText.getText();

		functionNameText.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				try {
					functionName = new String(functionNameText.getText());
					if (!(StringUtils.isEmpty(inputCount) && StringUtils.isEmpty(functionName)
							&& StringUtils.isEmpty(functionDefinition))) {
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

		Label customFunctionInputConnectorCountLabel = new Label(container, SWT.NULL);
		customFunctionInputConnectorCountLabel.setText("Number of Inputs : ");

		final Text inputConnectorCount = new Text(container, SWT.BORDER);
		inputConnectorCount.setLayoutData(dataPropertyConfigText);
		inputConnectorCount
				.setText(customFunctionImpl.getBasicContainer().getLeftContainer().getLeftConnectors().size() + "");
		inputCount = inputConnectorCount.getText();
		inputConnectorCount.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				try {
					inputCount = new String(inputConnectorCount.getText());
					if (!(StringUtils.isEmpty(inputCount) && StringUtils.isEmpty(functionName)
							&& StringUtils.isEmpty(functionDefinition))) {
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

		Label functionDefinitionLabel = new Label(container, SWT.NULL);
		functionDefinitionLabel.setText("Function Definition : ");

		final Text functionDefinitionText = new Text(container, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		functionDefinitionText.setLayoutData(new GridData(GridData.FILL_BOTH));
		if (customFunctionImpl.getFunctionDefinition() != null) {
			functionDefinitionText.setText(customFunctionImpl.getFunctionDefinition());
		}
		functionDefinition = functionDefinitionText.getText();

		functionDefinitionText.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				try {
					functionDefinition = new String(functionDefinitionText.getText());
					if (!(StringUtils.isEmpty(inputCount) && StringUtils.isEmpty(functionName)
							&& StringUtils.isEmpty(functionDefinition))) {
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
		if (inputCount != null) {
			if (!inputCount.equals("0") && !StringUtils.isEmpty(inputCount)) {
				if (StringUtils.isNotEmpty(functionName) && StringUtils.isNotEmpty(functionDefinition)) {
					isEnabled = true;
				}
			}
		}
		if (okButton != null) {
			okButton.setEnabled(isEnabled);
		}
	}

	protected void okPressed() {

		if (!StringUtils.isEmpty(functionName)) {
			CustomFunction concatOperatorInstance = customFunctionImpl;
			SetCommand setCmnd = new SetCommand(editingDomain, concatOperatorInstance,
					DataMapperPackage.Literals.CUSTOM_FUNCTION__FUNCTION_NAME, functionName);
			if (setCmnd.canExecute()) {
				editingDomain.getCommandStack().execute(setCmnd);
			}
			((OperatorRectangle) ((CustomFunctionEditPart) editPart).getCustomFunctionFigure())
					.changeOperatorHeader("CustomFunction : " + functionName);
		}

		if (!StringUtils.isEmpty(functionDefinition)) {
			CustomFunction concatOperatorInstance = customFunctionImpl;
			SetCommand setCmnd = new SetCommand(editingDomain, concatOperatorInstance,
					DataMapperPackage.Literals.CUSTOM_FUNCTION__FUNCTION_DEFINITION, functionDefinition);
			if (setCmnd.canExecute()) {
				editingDomain.getCommandStack().execute(setCmnd);
			}
		}

		int number = Integer.parseInt(inputCount)
				- customFunctionImpl.getBasicContainer().getLeftContainer().getLeftConnectors().size();
		if (number > 0) {
			for (int i = 0; i < number; ++i) {
				OperatorLeftConnector concatOperatorContainers = DataMapperFactory.eINSTANCE
						.createOperatorLeftConnector();
				AddCommand addCmd = new AddCommand(editingDomain,
						customFunctionImpl.getBasicContainer().getLeftContainer(),
						DataMapperPackage.Literals.OPERATOR_LEFT_CONTAINER__LEFT_CONNECTORS, concatOperatorContainers);
				if (addCmd.canExecute()) {
					editingDomain.getCommandStack().execute(addCmd);
				}

			}
		} else if (number < 0) {

			for (int i = 0; i < Math.abs(number); i++) {
				EList<OperatorLeftConnector> listOfLeftConnectors = customFunctionImpl.getBasicContainer()
						.getLeftContainer().getLeftConnectors();
				OperatorLeftConnector concatOperatorConnector = listOfLeftConnectors
						.get(listOfLeftConnectors.size() - 1);
				caseOutputConnectors.add(concatOperatorConnector);
				DeleteCommand deleteCmd = new DeleteCommand(editingDomain, caseOutputConnectors);
				if (deleteCmd.canExecute()) {
					editingDomain.getCommandStack().execute(deleteCmd);
				}
				caseOutputConnectors.remove(concatOperatorConnector);
			}
		}
		super.okPressed();
	}

}

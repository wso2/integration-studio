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
import org.wso2.developerstudio.datamapper.Constant;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.OperatorBasicContainer;
import org.wso2.developerstudio.datamapper.OperatorLeftConnector;
import org.wso2.developerstudio.datamapper.OperatorRightConnector;
import org.wso2.developerstudio.datamapper.OperatorRightContainer;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.ConcatEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.ConstantEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorBasicContainerEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorLeftConnectorEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorRectangle;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorRightConnectorEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorRightContainerEditPart;
import org.wso2.developerstudio.datamapper.impl.ConstantImpl;

public class ConfigureConstantOperatorDialog extends AbstractConfigureOperatorDialog {

	private String type;
	private String value;
	ConstantImpl constant = null;
	private TransactionalEditingDomain editingDomain;
	private EditPart editPart;

	public ConfigureConstantOperatorDialog(Shell parentShell, Constant constantOperator,
			TransactionalEditingDomain editingDomain,EditPart constantEditPart) {
		super(parentShell);
		this.editingDomain = editingDomain;
		this.editPart = constantEditPart;
		constant = (ConstantImpl) constantOperator;
	}

	@Override
	public void create() {
		super.create();
		setTitle("Configure Constant Operator");
		setMessage("Set constant operator properties", IMessageProvider.INFORMATION);
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		// Set title.
		newShell.setText("Constant Operator Properties");
	}

	protected Control createDialogArea(Composite parent) {

		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		Label constantTypeLabel = new Label(container, SWT.NULL);
		constantTypeLabel.setText("Constant Type : ");
		final Combo constantTypeDropDown = new Combo(container, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
		constantTypeDropDown.setLayoutData(dataPropertyConfigText);
		constantTypeDropDown.add("STRING");
		constantTypeDropDown.add("NUMBER");
		constantTypeDropDown.add("BOOLEAN");
		if (constant.getType() != null) {
			constantTypeDropDown.setText(constant.getType().getLiteral());
		} else {
			constantTypeDropDown.setText("STRING");
		}
		type = new String(constantTypeDropDown.getText());
		constantTypeDropDown.addListener(SWT.Modify, new Listener() {

			public void handleEvent(Event event) {
				try {
					type = new String(constantTypeDropDown.getText());
					if (!(StringUtils.isEmpty(type) && StringUtils.isEmpty(value))) {
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
		constantValueLabel.setText("Constant Value : ");

		final Text constantValue = new Text(container, SWT.BORDER);
		constantValue.setLayoutData(dataPropertyConfigText);
		if (constant.getConstantValue() != null) {
			constantValue.setText(constant.getConstantValue());
		} else {
			constantValue.setText("");
		}
		value = new String(constantValue.getText());
		constantValue.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				try {
					value = new String(constantValue.getText());
					if (!(StringUtils.isEmpty(type) && StringUtils.isEmpty(value))) {
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
		if (StringUtils.isNotEmpty(value) && StringUtils.isNotEmpty(type)) {
			isEnabled = true;
		}
		if (okButton != null) {
			okButton.setEnabled(isEnabled);
		}
	}

	protected void okPressed() {

		Constant constantOperatorInstance = constant;
		if (StringUtils.isNotEmpty(value)) {
			SetCommand setCmnd = new SetCommand(editingDomain, constantOperatorInstance,
					DataMapperPackage.Literals.CONSTANT__CONSTANT_VALUE, value);
			if (setCmnd.canExecute()) {
				editingDomain.getCommandStack().execute(setCmnd);
				((OperatorRectangle)((ConstantEditPart)editPart).getConstantFigure()).changeOperatorHeader("Constant : \""+value+"\"");
			}
		}
		if (StringUtils.isNotEmpty(type)) {
			SchemaDataType constantType = SchemaDataType.get(type.toUpperCase());
			if (constantType != null) {
				SetCommand setCmnd = new SetCommand(editingDomain, constantOperatorInstance,
						DataMapperPackage.Literals.CONSTANT__TYPE, constantType);
				if (setCmnd.canExecute()) {
					editingDomain.getCommandStack().execute(setCmnd);
					@SuppressWarnings("unchecked")
					List<EditPart> childContainers = ((OperatorBasicContainerEditPart)((ConstantEditPart)editPart).getChildren().get(0)).getChildren();
					for (EditPart editPart : childContainers) {
						if(editPart instanceof OperatorRightContainerEditPart){
							OperatorRightConnectorEditPart rightConnector =(OperatorRightConnectorEditPart) ((OperatorRightContainerEditPart)editPart).getChildren().get(0);
							((OperatorRightConnectorEditPart)rightConnector).setConstantTypeInConnector(constantType);
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

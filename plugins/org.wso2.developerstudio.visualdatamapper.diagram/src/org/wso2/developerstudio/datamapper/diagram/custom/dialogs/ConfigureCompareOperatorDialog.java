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
import org.wso2.developerstudio.datamapper.Compare;
import org.wso2.developerstudio.datamapper.ComparisonOperatorType;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.CompareEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorRectangle;
import org.wso2.developerstudio.datamapper.impl.CompareImpl;

public class ConfigureCompareOperatorDialog extends AbstractConfigureOperatorDialog {

	private String type;
	CompareImpl compare = null;
	private TransactionalEditingDomain editingDomain;
	private EditPart editPart;

	public ConfigureCompareOperatorDialog(Shell parentShell, Compare constantOperator,
			TransactionalEditingDomain editingDomain, EditPart constantEditPart) {
		super(parentShell);
		this.editingDomain = editingDomain;
		this.editPart = constantEditPart;
		compare = (CompareImpl) constantOperator;
	}

	@Override
	public void create() {
		super.create();
		setTitle("Configure Compare Operator");
		setMessage("Set compare operator properties", IMessageProvider.INFORMATION);
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		// Set title.
		newShell.setText("Compare Operator Properties");
	}

	protected Control createDialogArea(Composite parent) {

		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		Label compareOperatorTypeLabel = new Label(container, SWT.NULL);
		compareOperatorTypeLabel.setText("Comparison Operator : ");
		final Combo compareTypeDropDown = new Combo(container, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
		compareTypeDropDown.setLayoutData(dataPropertyConfigText);
		compareTypeDropDown.add(getFormattedOperatorName(ComparisonOperatorType.EQUAL_VALUE));
		compareTypeDropDown.add(getFormattedOperatorName(ComparisonOperatorType.EQUAL_VALUE_TYPE));
		compareTypeDropDown.add(getFormattedOperatorName(ComparisonOperatorType.NOT_EQUAL_VALUE));
		compareTypeDropDown.add(getFormattedOperatorName(ComparisonOperatorType.NOT_EQUAL_VALUE_TYPE));
		compareTypeDropDown.add(getFormattedOperatorName(ComparisonOperatorType.GREATER_THAN));
		compareTypeDropDown.add(getFormattedOperatorName(ComparisonOperatorType.GREATER_OR_EQUAL));
		compareTypeDropDown.add(getFormattedOperatorName(ComparisonOperatorType.LOWER_THAN));
		compareTypeDropDown.add(getFormattedOperatorName(ComparisonOperatorType.LOWER_OR_EQUAL));
		if (compare.getComparisonOperator() != null) {
			compareTypeDropDown.setText(getFormattedOperatorName(compare.getComparisonOperator()));
		} else {
			compareTypeDropDown.setText(getFormattedOperatorName(ComparisonOperatorType.EQUAL_VALUE_TYPE));
		}
		type = new String(compareTypeDropDown.getText());
		compareTypeDropDown.addListener(SWT.Modify, new Listener() {

			public void handleEvent(Event event) {
				try {
					type = new String(compareTypeDropDown.getText());
					if (!StringUtils.isEmpty(type)) {
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

	private String getFormattedOperatorName(ComparisonOperatorType comparisonOperatorType) {
		return comparisonOperatorType.getName().replace("_", " ");
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
		if (StringUtils.isNotEmpty(type)) {
			isEnabled = true;
		}
		if (okButton != null) {
			okButton.setEnabled(isEnabled);
		}
	}

	protected void okPressed() {

		Compare constantOperatorInstance = compare;
		if (StringUtils.isNotEmpty(type)) {
			ComparisonOperatorType compareType = ComparisonOperatorType.getByName(type.replace(" ", "_"));
			if (compareType != null) {
				SetCommand setCmnd = new SetCommand(editingDomain, constantOperatorInstance,
						DataMapperPackage.Literals.COMPARE__COMPARISON_OPERATOR, compareType);
				if (setCmnd.canExecute()) {
					editingDomain.getCommandStack().execute(setCmnd);
					((OperatorRectangle) ((CompareEditPart) editPart).getCompareFigure())
							.changeOperatorHeader("Compare : \"" + compareType.getLiteral() + "\"");
				}
			} else {
				throw new IllegalArgumentException("Unknown type found : " + type);
			}

		}
		super.okPressed();
	}

}

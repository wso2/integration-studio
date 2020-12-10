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
import org.wso2.integrationstudio.datamapper.DataMapperPackage;
import org.wso2.integrationstudio.datamapper.Replace;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OperatorRectangle;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.ReplaceEditPart;
import org.wso2.integrationstudio.datamapper.impl.ReplaceImpl;

public class ConfigureReplaceOperatorDialog extends AbstractConfigureOperatorDialog {

	private String target;
	private String replaceWith;
	private TransactionalEditingDomain editingDomain;
	private ReplaceImpl replaceImpl;
	private EditPart editPart;

	public ConfigureReplaceOperatorDialog(Shell parentShell, Replace selectedObj,
			TransactionalEditingDomain editingDomain, EditPart selectedEP) {
		super(parentShell);
		this.replaceImpl = (ReplaceImpl) selectedObj;
		this.editingDomain = editingDomain;
		this.editPart = selectedEP;
	}

	@Override
	public void create() {
		super.create();
		setTitle("Configure Replace Operator");
		setMessage(
				"Configure Target : {$Target}" + " to get it from a linked element" + "\n"
						+ "Configure String Replace : {$Replace}" + " to get it from a linked element",
				IMessageProvider.INFORMATION);
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		// Set title.
		newShell.setText("Configure Replace Operator");
	}

	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		Label matchDelimiterLabel = new Label(container, SWT.NULL);
		matchDelimiterLabel.setText("String Target : ");

		final Combo comboDropDownTargetText = new Combo(container, SWT.DROP_DOWN | SWT.BORDER);
		comboDropDownTargetText.add("{$Target}");
		comboDropDownTargetText.setLayoutData(dataPropertyConfigText);
		if (replaceImpl.getTarget() != null) {
			comboDropDownTargetText.setText(replaceImpl.getTarget());
		} else {
			comboDropDownTargetText.setText("{$Target}");
		}
		target = comboDropDownTargetText.getText();

		comboDropDownTargetText.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				try {
					target = new String(comboDropDownTargetText.getText());
					if (!StringUtils.isEmpty(target)) {
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

		Label matchReplaceLabel = new Label(container, SWT.NULL);
		matchReplaceLabel.setText("String Replace : ");

		final Combo comboDropDownReplaceText = new Combo(container, SWT.DROP_DOWN | SWT.BORDER);
		comboDropDownReplaceText.add("{$Replace}");
		comboDropDownReplaceText.setLayoutData(dataPropertyConfigText);
		if (replaceImpl.getReplaceString() != null) {
			comboDropDownReplaceText.setText(replaceImpl.getReplaceString());
		} else {
			comboDropDownReplaceText.setText("{$Replace}");
		}
		replaceWith = comboDropDownReplaceText.getText();

		comboDropDownReplaceText.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				try {
					replaceWith = new String(comboDropDownReplaceText.getText());
					if (!(StringUtils.isEmpty(target) && StringUtils.isEmpty(replaceWith))) {
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
		if (!StringUtils.isEmpty(target)) {
			isEnabled = true;
		}
		if (!StringUtils.isEmpty(replaceWith)) {
			isEnabled = true;
		}
		if (okButton != null) {
			okButton.setEnabled(isEnabled);
		}
	}

	protected void okPressed() {
		if (!StringUtils.isEmpty(target)) {
			ReplaceImpl matchOperatorInstance = (ReplaceImpl) replaceImpl;
			SetCommand setCmnd = new SetCommand(editingDomain, matchOperatorInstance,
					DataMapperPackage.Literals.REPLACE__TARGET, target);
			if (setCmnd.canExecute()) {
				editingDomain.getCommandStack().execute(setCmnd);
			}
			((OperatorRectangle) ((ReplaceEditPart) editPart).getReplaceFigure()).changeOperatorHeader(
					"Replace : (Target:\"" + target + "\",Replace With : \"" + replaceWith + "\"");
		}
		if (!StringUtils.isEmpty(replaceWith)) {
			ReplaceImpl matchOperatorInstance = (ReplaceImpl) replaceImpl;
			SetCommand setCmnd = new SetCommand(editingDomain, matchOperatorInstance,
					DataMapperPackage.Literals.REPLACE__REPLACE_STRING, replaceWith);
			if (setCmnd.canExecute()) {
				editingDomain.getCommandStack().execute(setCmnd);
			}
			((OperatorRectangle) ((ReplaceEditPart) editPart).getReplaceFigure()).changeOperatorHeader(
					"Replace : (Target:\"" + target + "\",Replace With : \"" + replaceWith + "\"");
		}
		super.okPressed();
	}

}

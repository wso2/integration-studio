/*
 * Copyright 2013 WSO2, Inc. (http://wso2.com)
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

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.Mediator;

public class AbstractMediatorMultiLinePropertyDialog extends Dialog {

	protected Mediator mediator;
	private EStructuralFeature feature;
	private TransactionalEditingDomain editingDomain;
	private CompoundCommand resultCommand;
	private String initialText;
	private String title;
	
	private Text inlineText;

	public AbstractMediatorMultiLinePropertyDialog(String title, Shell parentShell,
			Mediator mediator, EStructuralFeature feature, String initialText) {
		super(parentShell);
		this.mediator = mediator;
		this.editingDomain = TransactionUtil.getEditingDomain(mediator);
		this.initialText = initialText;
		this.feature = feature;
		this.title = title;
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(title);
	}

	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);
		inlineText = createText(container);
		return container;
	}

	private Text createText(Composite composite) {
		Text text = new Text(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		text.setText(initialText);
		FormData formLayoutData = new FormData(360, 90);
		formLayoutData.top = new FormAttachment(0, 8);
		formLayoutData.left = new FormAttachment(0, 8);
		formLayoutData.right = new FormAttachment(100, -8);
		text.setLayoutData(formLayoutData);
		return text;
	}

	@Override
	protected void okPressed() {
		if (isValid(inlineText.getText())) {
			setPropertyValue(inlineText.getText());
			super.okPressed();
		}
	}

	private void setPropertyValue(String multilineString) {
		SetCommand setCmd = new SetCommand(editingDomain, mediator, feature, multilineString);
		getResultCommand().append(setCmd);
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
		}
	}

	protected boolean isValid(String stringContent) {
		return true;
	}

	private CompoundCommand getResultCommand() {
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
	}
}

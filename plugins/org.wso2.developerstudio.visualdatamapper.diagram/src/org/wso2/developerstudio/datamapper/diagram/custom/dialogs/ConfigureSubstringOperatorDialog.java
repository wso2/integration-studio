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
import org.wso2.developerstudio.datamapper.Add;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.OperatorLeftConnector;
import org.wso2.developerstudio.datamapper.Substring;
import org.wso2.developerstudio.datamapper.diagram.custom.exception.DataMapperException;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.EndsWithEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorRectangle;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.SubstringEditPart;
import org.wso2.developerstudio.datamapper.impl.AddImpl;
import org.wso2.developerstudio.datamapper.impl.EndsWithImpl;
import org.wso2.developerstudio.datamapper.impl.SubstringImpl;

public class ConfigureSubstringOperatorDialog extends AbstractConfigureOperatorDialog {

	private static final String EMPTY_STRING = "";
	private String startIndex;
	private String length;
	private TransactionalEditingDomain editingDomain;
	private ArrayList<OperatorLeftConnector> caseOutputConnectors = new ArrayList<OperatorLeftConnector>();
	private SubstringImpl substringImpl;
	private EditPart editPart;

	public ConfigureSubstringOperatorDialog(Shell parentShell, Substring selectedObj,
			TransactionalEditingDomain editingDomain, EditPart editPart) {
		super(parentShell);
		this.substringImpl = (SubstringImpl) selectedObj;
		this.editingDomain = editingDomain;
		this.editPart = editPart;
	}

	@Override
	public void create() {
		super.create();
		setTitle("Configure Substring Operator");
		setMessage("Set substring operator properties", IMessageProvider.INFORMATION);
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		// Set title.
		newShell.setText("Configure Substring Operator");
	}

	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		Label startIndexLabel = new Label(container, SWT.NULL);
		startIndexLabel.setText("Start Index : ");

		final Text startIndexText = new Text(container, SWT.BORDER);
		startIndexText.setLayoutData(dataPropertyConfigText);
		startIndexText.setText(EMPTY_STRING + substringImpl.getStartIndex());
		startIndex = startIndexText.getText();
		startIndexText.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				try {
					startIndex = new String(startIndexText.getText());
					if (!(StringUtils.isEmpty(startIndex))) {
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

		Label endIndexLabel = new Label(container, SWT.NULL);
		endIndexLabel.setText("End Index : ");

		final Text endIndexText = new Text(container, SWT.BORDER);
		endIndexText.setLayoutData(dataPropertyConfigText);
		endIndexText.setText(EMPTY_STRING + substringImpl.getEndIndex());
		length = endIndexText.getText();
		endIndexText.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				try {
					length = new String(endIndexText.getText());
					if (!(StringUtils.isEmpty(length))) {
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
		if (!StringUtils.isEmpty(length) && !StringUtils.isEmpty(startIndex)) {
			try {
				Integer.parseInt(startIndex);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Start index should be a integer. Found :" + startIndex);
			}
			try {
				Integer.parseInt(length);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("End index should be a integer. Found :" + length);
			}
			isEnabled = true;
		} else {
			throw new IllegalArgumentException("Any of start index or end index can not be empty");
		}
		if (okButton != null) {
			okButton.setEnabled(isEnabled);
		}
	}

	protected void okPressed() {
		SubstringImpl substringOperatorInstance = (SubstringImpl) substringImpl;
		if (!StringUtils.isEmpty(startIndex)) {
			Integer startIndexVal = Integer.parseInt(startIndex);
			SetCommand setCmnd = new SetCommand(editingDomain, substringOperatorInstance,
					DataMapperPackage.Literals.SUBSTRING__START_INDEX, startIndexVal);
			if (setCmnd.canExecute()) {
				editingDomain.getCommandStack().execute(setCmnd);
			}
			((OperatorRectangle) ((SubstringEditPart) editPart).getSubstringFigure()).changeOperatorHeader(
					"Substring :(start index : " + startIndex + ", length : " + substringImpl.getEndIndex() + ")");
		}
		if (!StringUtils.isEmpty(length)) {
			Integer endIndexVal = Integer.parseInt(length);
			SetCommand setCmnd = new SetCommand(editingDomain, substringOperatorInstance,
					DataMapperPackage.Literals.SUBSTRING__END_INDEX, endIndexVal);
			if (setCmnd.canExecute()) {
				editingDomain.getCommandStack().execute(setCmnd);
			}
			((OperatorRectangle) ((SubstringEditPart) editPart).getSubstringFigure()).changeOperatorHeader(
					"Substring :(start index : " + substringImpl.getStartIndex() + ", length : " + length + ")");
		}
		super.okPressed();
	}

}

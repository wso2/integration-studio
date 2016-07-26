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

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

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
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.Match;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.MatchEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorRectangle;
import org.wso2.developerstudio.datamapper.impl.MatchImpl;

public class ConfigureMatchOperatorDialog extends AbstractConfigureOperatorDialog {

	public static final String NASHORN = "nashorn";
	public static final String RHINO = "rhino";
	public static final String JAVA_VERSION = "java.version";
	public static final String JAVA_VERSION_7 = "1.7";
	public static final String JAVA_VERSION_6 = "1.6";
	private String pattern;
	private TransactionalEditingDomain editingDomain;
	private MatchImpl matchImpl;
	private EditPart editPart;

	public ConfigureMatchOperatorDialog(Shell parentShell, Match selectedObj, TransactionalEditingDomain editingDomain,
			EditPart selectedEP) {
		super(parentShell);
		this.matchImpl = (MatchImpl) selectedObj;
		this.editingDomain = editingDomain;
		this.editPart = selectedEP;
	}

	@Override
	public void create() {
		super.create();
		setTitle("Configure Match Operator");
		setMessage("Configure Pattern : {$Pattern}" + " to get it from a linked element", IMessageProvider.INFORMATION);
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		// Set title.
		newShell.setText("Configure Match Operator");
	}

	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		Label matchDelimiterLabel = new Label(container, SWT.NULL);
		matchDelimiterLabel.setText("String Pattern : ");

		final Combo comboDropDown = new Combo(container, SWT.DROP_DOWN | SWT.BORDER);
		comboDropDown.add("{$Pattern}");
		comboDropDown.setLayoutData(dataPropertyConfigText);
		if (matchImpl.getPattern() != null) {
			comboDropDown.setText(matchImpl.getPattern());
		} else {
			comboDropDown.setText("{$Pattern}");
		}
		pattern = comboDropDown.getText();

		comboDropDown.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				try {
					pattern = new String(comboDropDown.getText());
					if (!StringUtils.isEmpty(pattern)) {
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
		if (!StringUtils.isEmpty(pattern)) {
			isEnabled = true;
		}
		if (okButton != null) {
			okButton.setEnabled(isEnabled);
		}
	}

	protected void okPressed() {
		if (!StringUtils.isEmpty(pattern)) {
			pattern = validateRegex(pattern);
			MatchImpl matchOperatorInstance = (MatchImpl) matchImpl;
			SetCommand setCmnd = new SetCommand(editingDomain, matchOperatorInstance,
					DataMapperPackage.Literals.MATCH__PATTERN, pattern);
			if (setCmnd.canExecute()) {
				editingDomain.getCommandStack().execute(setCmnd);
			}
			((OperatorRectangle) ((MatchEditPart) editPart).getMatchFigure())
					.changeOperatorHeader("Match : \"" + pattern + "\"");
		}
		super.okPressed();
	}

	private String validateRegex(String input) {
		String output = input;
		String scriptExecutorType = NASHORN;
		String javaVersion = System.getProperty(JAVA_VERSION);
		if (javaVersion.startsWith(JAVA_VERSION_7) || javaVersion.startsWith(JAVA_VERSION_6)) {
			scriptExecutorType = RHINO;
		}
		ScriptEngine engine = new ScriptEngineManager().getEngineByName(scriptExecutorType);
		try {
			engine.eval("function myFunction(input) {\n" + "var sampleString = \"acbdacfac\";\n" + "\n"
					+ "   return sampleString.match(input);\n" + "}\n");
			engine.eval("myFunction(" + input + ");");
		} catch (ScriptException e) {
			output = "\"" + input + "\"";
		}
		return output;
	}

}

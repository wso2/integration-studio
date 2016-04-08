/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.ui.preferences;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.platform.ui.WorkbenchToolkit;

public class ClientTrustStorePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	public static final String TRUST_STORE_PASSWORD = "TRUST_STORE_PASSWORD";
	public static final String SHOW_PLAIN_PASSWORD = "SHOW_PLAIN_PASSWORD";
	public static final String TRUST_STORE_TYPE = "TRUST_STORE_TYPE";
	public static final String TRUST_STORE_LOCATION = "TRUST_STORE_LOCATION";
	private StringFieldEditor stringField1;
	private IPreferenceStore preferenceStore;

	public ClientTrustStorePreferencePage() {
		super(GRID);
	}

	@Override
	public void init(IWorkbench arg0) {
		preferenceStore = WorkbenchToolkit.getPreferenceStore();
		setPreferenceStore(preferenceStore);
		setDescription("WSO2 Developer Studio Custom Client Trust Store Preference.");
		
	}

	@Override
	protected void createFieldEditors() {
		addField(new FileFieldEditor(TRUST_STORE_LOCATION, "&Trust Store Location:", getFieldEditorParent()));
		
		String[][] types = { { "JKS", "JKS" }, { "JCEKS", "JCEKS" }, { "PKCS12", "PKCS12" } };
		ComboFieldEditor editor = new ComboFieldEditor(TRUST_STORE_TYPE, "Trust &Store Type", types,
				getFieldEditorParent());

		addField(editor);
		stringField1 = new StringFieldEditor(TRUST_STORE_PASSWORD, "Trust Store &Password", getFieldEditorParent());
		addField(stringField1);
		BooleanFieldEditor booleanFieldEditor = new BooleanFieldEditor(SHOW_PLAIN_PASSWORD,
				"S&how Password in Plain Text", getFieldEditorParent());
		addField(booleanFieldEditor);
		if (!preferenceStore.getBoolean(SHOW_PLAIN_PASSWORD)) {
			stringField1.getTextControl(getFieldEditorParent()).setEchoChar('*');
		}
		preferenceStore.addPropertyChangeListener(new IPropertyChangeListener() {

			@Override
			public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent arg0) {

				if (SHOW_PLAIN_PASSWORD.equals(arg0.getProperty())) {
					boolean boolean1 = preferenceStore.getBoolean(SHOW_PLAIN_PASSWORD);
					if (boolean1) {
						stringField1.getTextControl(getFieldEditorParent()).setEchoChar('\0');
					} else {
						stringField1.getTextControl(getFieldEditorParent()).setEchoChar('*');
					}
				}

				if (TRUST_STORE_LOCATION.equals(arg0.getProperty())) {
					String string = preferenceStore.getString(TRUST_STORE_LOCATION);
					if (!string.equals("") && !string.endsWith(".jks")) {
						MessageDialog.openError(Display.getCurrent().getActiveShell(), "Developer Studio Error Dialog",
						                        "You cannot set non JKS trust stores from Developer Studio");
					}
				}

			}
		});

	}

	@Override
	public boolean performOk() {
		boolean performOk = super.performOk();
		String message = "You must restart eclipse to apply these changes, Restart Now ?";		 
		if (WorkbenchToolkit.showQuestionMessageDialog("Developer Studio Info", message)) {
			PlatformUI.getWorkbench().restart();
		}
		return performOk;
	}

}

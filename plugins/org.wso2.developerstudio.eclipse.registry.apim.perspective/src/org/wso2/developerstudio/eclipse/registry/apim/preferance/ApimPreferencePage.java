/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.registry.apim.preferance;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.wso2.developerstudio.eclipse.registry.apim.perspective.Activator;

public class ApimPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private static final String WSO2_APIM_PREFERENCES_TITLE = "WSO2 APIManager User Preferences.";
	private static final String LABEL_HOST_URL = "&Host Url :";
	private static final String LABEL_USERNAME = "Username :";
	private static final String LABEL_PASSWORD = "Password :";
	private static final String LABEL_DEFAULT_SEQUENCE_LOCATION = "Default sequence location :";
	
	public static final String APIM_DEFAULT_PASSWORD = "admin";
	public static final String APIM_DEFAULT_URL = "https://localhost:9443/";
	public static final String APIM_DEFAULT_USERNAME = APIM_DEFAULT_PASSWORD;
	
	public static final String APIM_PASSWORD = "APIM_PASSWORD";
	public static final String APIM_USERNAME = "APIM_USERNAME";
	public static final String APIM_URL = "APIM_URL";
	public static final String APIM_REG_DEFAULT_PATH = "APIM_REG_PATH";
	public static final String APIM_CUSTOMSEQUENCES_PATH = "/_system/governance/apimgt/customsequences";
	public static final String APIM_LOGIN = "LOG_IN_FOR_APIM";

	private StringFieldEditor stringField1;
	private StringFieldEditor editor;
	IPreferenceStore preferenceStore;

	public ApimPreferencePage() {
		super(GRID);
	}

	@Override
	public void init(IWorkbench arg0) {
		preferenceStore = Activator.getDefault().getPreferenceStore();
		setPreferenceStore(preferenceStore);
		setDescription(WSO2_APIM_PREFERENCES_TITLE);
	}

	@Override
	protected void createFieldEditors() {

		editor = new StringFieldEditor(APIM_URL, LABEL_HOST_URL, getFieldEditorParent());
		Text textControl = editor.getTextControl(getFieldEditorParent());
		textControl.setText("https://");
		addField(editor);
		addField(new StringFieldEditor(APIM_USERNAME, LABEL_USERNAME, getFieldEditorParent()));
		stringField1 = new StringFieldEditor(APIM_PASSWORD, LABEL_PASSWORD, getFieldEditorParent()) {
			@Override
			protected void doFillIntoGrid(Composite parent, int numColumns) {
				super.doFillIntoGrid(parent, numColumns);
				getTextControl().setEchoChar('*');
			}
		};
		addField(stringField1);
		addField(new StringFieldEditor(APIM_REG_DEFAULT_PATH, LABEL_DEFAULT_SEQUENCE_LOCATION, getFieldEditorParent()));

		preferenceStore.setDefault(APIM_USERNAME, APIM_DEFAULT_USERNAME);
		preferenceStore.setDefault(APIM_URL, APIM_DEFAULT_URL);
		preferenceStore.setDefault(APIM_PASSWORD, APIM_DEFAULT_PASSWORD);
		preferenceStore.setDefault(APIM_REG_DEFAULT_PATH, APIM_CUSTOMSEQUENCES_PATH);
	 
	}

}

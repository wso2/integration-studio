/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package org.wso2.developerstudio.appfactory.ui.preference;


import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.wso2.developerstudio.appfactory.ui.Activator;
import org.wso2.developerstudio.appfactory.ui.utils.Messages;

public class AppFactoryPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public static final String APP_FACTORY_PASSWORD = "APP_FACTORY_PASSWORD";
	public static final String APP_FACTORY_USERNAME = "APP_FACTORY_USERNAME";
	public static final String APP_FACTORY_LOCATION = "APP_FACTORY_LOCATION";
	public static final String APP_FACTORY_SAVE = "SAVE_USER_CREDINTIAL";
	public static final String APP_CLOUD_LOGIN = "LOG_IN_FOR_APP_CLOUD";
	public static final String RETRY_DELAY = "RETRY_DELAY";
	public static final String SO_TIME_OUT = "SO_TIME_OUT";
	private StringFieldEditor stringField1;
	private StringFieldEditor editor;
	IPreferenceStore preferenceStore;

	public AppFactoryPreferencePage() {
		super(GRID);
	}

	@Override
	public void init(IWorkbench arg0) {
		preferenceStore = Activator.getDefault().getPreferenceStore();
		setPreferenceStore(preferenceStore);
		setDescription("WSO2 App Cloud/ App Factory User Preferences.");
	}

	@Override
	protected void createFieldEditors() {

		addField(new RadioGroupFieldEditor(APP_CLOUD_LOGIN, "Connect to :", 1, new String[][] {
				{ "App Cloud", "true" }, { "App Factory", "false" } }, getFieldEditorParent()));

		editor = new StringFieldEditor(APP_FACTORY_LOCATION, "&Host Url:", getFieldEditorParent());

		Text textControl = editor.getTextControl(getFieldEditorParent());
		textControl.setText("https://");
		addField(editor);
		addField(new StringFieldEditor(APP_FACTORY_USERNAME, "Email/ Username", getFieldEditorParent()));
		stringField1 = new StringFieldEditor(APP_FACTORY_PASSWORD, "Password", getFieldEditorParent()) {

			@Override
			protected void doFillIntoGrid(Composite parent, int numColumns) {
				super.doFillIntoGrid(parent, numColumns);

				getTextControl().setEchoChar('*');
			}

		};

		addField(stringField1);
		
		
		
		addField(new IntegerFieldEditor(RETRY_DELAY, "Re-try delay (ms)", getFieldEditorParent()));
		addField(new IntegerFieldEditor(SO_TIME_OUT, "Socket timeout (ms)", getFieldEditorParent()));
		

		preferenceStore.addPropertyChangeListener(new IPropertyChangeListener() {

			@Override
			public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent arg0) {

				if (arg0.getProperty().equals(APP_CLOUD_LOGIN)) {

					if (arg0.getNewValue().toString().equals("true")) {
						preferenceStore.setValue(APP_FACTORY_LOCATION, Messages.APP_CLOUD_URL);
						editor.setStringValue(Messages.APP_CLOUD_URL);
					}
				}
				if (arg0.getProperty().equals(APP_FACTORY_LOCATION)) {
					if (preferenceStore.getString(APP_CLOUD_LOGIN).equals("true")) {
						preferenceStore.setValue(APP_FACTORY_LOCATION, Messages.APP_CLOUD_URL);
						editor.setStringValue(Messages.APP_CLOUD_URL);
					}
				}
				
			 

			}
		});
	}
}

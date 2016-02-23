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

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;

public class UpdateCheckerPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public static final String MONTHLY = "Monthly";
	public static final String WEEKLY = "Weekly";
	public static final String DAILY = "Daily";
	public static final String NO = "No";
	public static final String YES = "Yes";
	public static final String UPDATE_INTAVAL = "UPDATE_INTAVAL";
	public static final String AUTOMATIC_UPDATE_STATUS = "AUTOMATIC_UPATE_STATUS";
	public static final String SET_AUTOMATIC_UPDATE_PREF = "SET_AUTOMATIC_UPDATE_PREF";
	public static final String RELESE_SITE_URL = "RELESE_SITE_URL";
	public static final String UPDATE_SITE_URL = "UPDATE_SITE_URL";
	public static final String PLUGIN_TEMPLATE_URL = "PLUGIN_TEMPLATE_URL";
	public static final String SHOW_HIDDEN_FEATURES = "SHOW_HIDDEN_FEATURES";
	public static final String PREFERENCE_PLUGIN_ID = "org.wso2.developerstudio.eclipse.platform.ui";
	public static final String SELECT_STATUS = "Select";

	private static IPreferenceStore preferenceStore;

	private ComboFieldEditor intervalEditor;
	
	private ComboFieldEditor automaticUpdatePreference;

	@Override
	public void init(IWorkbench workbench) {
		preferenceStore = Activator.getDefault().getPreferenceStore();
		setPreferenceStore(preferenceStore);
		setDescription("WSO2 Developer Studio Check for Updates Preferences");
	}

	@Override
	protected void createFieldEditors() {
		addField(new StringFieldEditor(UPDATE_SITE_URL, "Update site:", getFieldEditorParent()));
		addField(new StringFieldEditor(RELESE_SITE_URL, "Release site:", getFieldEditorParent()));
		addField(new BooleanFieldEditor(SHOW_HIDDEN_FEATURES, "Show hidden features (for plugin developers)", getFieldEditorParent()));
		String[][] updaterEnable = {{ YES, YES }, { SELECT_STATUS, SELECT_STATUS }, { NO, NO }};
		String[][] intervals = {{ DAILY, DAILY }, { WEEKLY, WEEKLY }, { MONTHLY, MONTHLY }};
		automaticUpdatePreference = new ComboFieldEditor(SET_AUTOMATIC_UPDATE_PREF, "Check for updates automatically", updaterEnable, getFieldEditorParent());
		addField(automaticUpdatePreference);
		intervalEditor = new ComboFieldEditor(UPDATE_INTAVAL, "Check for updates ", intervals,
				getFieldEditorParent());
		addField(intervalEditor);
		addField(new StringFieldEditor(PLUGIN_TEMPLATE_URL, "Plug-in template location:", getFieldEditorParent()));

	}	
	
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (SET_AUTOMATIC_UPDATE_PREF.equals(event.getProperty())) {
			String updateEnableVal = preferenceStore
					.getString(SET_AUTOMATIC_UPDATE_PREF);
			boolean isAutomaticUpdateEnabled = false;
			if (updateEnableVal.equals(YES)) {
				isAutomaticUpdateEnabled = true;
			}
			intervalEditor.setEnabled(isAutomaticUpdateEnabled, getFieldEditorParent());
		}
		super.propertyChange(event);
	}
	
	public static void setAutomaticUpdatePreference(String value) {
		preferenceStore.setDefault(SET_AUTOMATIC_UPDATE_PREF, value);
	}

}

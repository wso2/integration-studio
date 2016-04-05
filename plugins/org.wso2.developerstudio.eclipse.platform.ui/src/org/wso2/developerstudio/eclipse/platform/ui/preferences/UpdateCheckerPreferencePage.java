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
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.wso2.developerstudio.eclipse.platform.ui.WorkbenchToolkit;

public class UpdateCheckerPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public static final String PREFERENCE_PLUGIN_ID = "org.wso2.developerstudio.eclipse.platform.ui";

	private static IPreferenceStore preferenceStore;
	private ComboFieldEditor intervalDayEditor;
	private ComboFieldEditor intervalTimeEditor;
	private StringFieldEditor updateSiteURL;
	private StringFieldEditor releaseSiteURL;
	private Composite fieldEditorParent;
	private Composite enableDisableSet;
	private RadioGroupFieldEditor updateInstallationRadioBttn;

	@Override
	public void init(IWorkbench workbench) {
		preferenceStore = WorkbenchToolkit.getPrefernaceStore();
		setPreferenceStore(preferenceStore);
		setDescription("Set Preferences for WSO2 Developer Studio Updates and Install Process ");
		setPreferenceDefaults(preferenceStore);
	}

	public static void setPreferenceDefaults(IPreferenceStore preferenceStore) {
		preferenceStore.setDefault(PreferenceConstants.RELESE_SITE_URL, PreferenceInitializer.DEFAULT_RELEASE_SITE);
		preferenceStore.setDefault(PreferenceConstants.UPDATE_SITE_URL, PreferenceInitializer.DEFAULT_UPDATE_SITE);
		preferenceStore.setDefault(PreferenceConstants.UPDATE_DATE_INTERVAL, PreferenceConstants.DEFAULT_SUNDAY);
		preferenceStore.setDefault(PreferenceConstants.UPDATE_TIME_INTERVAL, PreferenceConstants.DEFAULT_EIGHT_AM);
		preferenceStore.setDefault(PreferenceConstants.ENABLE_AUTOMATIC_UPDATES, true);
	}

	@Override
	protected void createFieldEditors() {
		fieldEditorParent = getFieldEditorParent();

		BooleanFieldEditor enableAutomaticUpdates = new BooleanFieldEditor(PreferenceConstants.ENABLE_AUTOMATIC_UPDATES,
				"Check for updates Automatically", fieldEditorParent);
		addField(enableAutomaticUpdates);
		boolean isUpdatesEnabled = preferenceStore.getBoolean(PreferenceConstants.ENABLE_AUTOMATIC_UPDATES);
		addBlankSeparator(fieldEditorParent);
		setSeparator(fieldEditorParent);

		enableDisableSet = new Composite(fieldEditorParent, SWT.LEFT);
		addBlankSeparator(enableDisableSet);
		String[][] intervals = { { PreferenceConstants.DAILY, PreferenceConstants.DAILY }, { PreferenceConstants.DEFAULT_SUNDAY, PreferenceConstants.DEFAULT_SUNDAY }, { PreferenceConstants.EVERY_MONDAY, PreferenceConstants.EVERY_MONDAY },
				{ PreferenceConstants.EVERY_TUESDAY, PreferenceConstants.EVERY_TUESDAY }, { PreferenceConstants.EVERY_WEDNESDAY, PreferenceConstants.EVERY_WEDNESDAY },
				{ PreferenceConstants.EVERY_THURSDAY, PreferenceConstants.EVERY_THURSDAY }, { PreferenceConstants.EVERY_FRIDAY, PreferenceConstants.EVERY_FRIDAY },
				{ PreferenceConstants.EVERY_SATURDAY, PreferenceConstants.EVERY_SATURDAY } };
		intervalDayEditor = new ComboFieldEditor(PreferenceConstants.UPDATE_DATE_INTERVAL, "Check for updates ", intervals, enableDisableSet);
		addField(intervalDayEditor);
		intervalDayEditor.setEnabled(isUpdatesEnabled, enableDisableSet);

		String[][] timeIntervals = { { PreferenceConstants.MIDNIGHT, PreferenceConstants.MIDNIGHT }, { PreferenceConstants.ONEAM, PreferenceConstants.ONEAM }, {PreferenceConstants.TWOAM, PreferenceConstants.TWOAM }, { PreferenceConstants.THREEAM, PreferenceConstants.THREEAM },
				{ PreferenceConstants.FOURAM, PreferenceConstants.FOURAM }, { PreferenceConstants.FIVEAM, PreferenceConstants.FIVEAM }, { PreferenceConstants.SIXAM, PreferenceConstants.SIXAM }, { PreferenceConstants.SEVENAM, PreferenceConstants.SEVENAM }, { PreferenceConstants.DEFAULT_EIGHT_AM, PreferenceConstants.NINEAM },
				{ PreferenceConstants.TENAM, PreferenceConstants.TENAM }, { PreferenceConstants.ELEVENAM, PreferenceConstants.ELEVENAM }, { PreferenceConstants.TWELEVENOON, PreferenceConstants.TWELEVENOON }, { PreferenceConstants.ONEPM, PreferenceConstants.ONEPM }, { PreferenceConstants.TWOPM, PreferenceConstants.TWOPM },
				{ PreferenceConstants.THREEPM, PreferenceConstants.THREEPM }, { PreferenceConstants.FOURPM, PreferenceConstants.FOURPM }, { PreferenceConstants.FIVEPM, PreferenceConstants.FIVEPM }, { PreferenceConstants.SIXPM, PreferenceConstants.SIXPM }, { PreferenceConstants.SIXPM, PreferenceConstants.SIXPM },
				{ PreferenceConstants.SEVENPM, PreferenceConstants.SEVENPM }, { PreferenceConstants.EIGHTPM, PreferenceConstants.EIGHTPM }, { PreferenceConstants.NINEPM, PreferenceConstants.NINEPM }, { PreferenceConstants.TENPM, PreferenceConstants.TENPM }, { PreferenceConstants.ELEVENPM, PreferenceConstants.ELEVENPM } };
		intervalTimeEditor = new ComboFieldEditor(PreferenceConstants.UPDATE_TIME_INTERVAL, ""
				, timeIntervals,
				enableDisableSet);
		intervalTimeEditor.setEnabled(isUpdatesEnabled, enableDisableSet);
		addField(intervalTimeEditor);

		setSeparator(enableDisableSet);
		addBlankSeparator(enableDisableSet);
		updateInstallationRadioBttn = new RadioGroupFieldEditor(PreferenceConstants.UPDATE_NOTIFICATION_CONFIGURATION,
				"Update Notification and Installation", 1, new String[][] {
						{ PreferenceConstants.NOTIFY_ME_IF_UPDATES_AVAILABLE, PreferenceConstants.NOTIFY_ME }, { PreferenceConstants.DOWNLOAD_UPDATES, PreferenceConstants.INSTALL_AUTOMATICALLY } },
				enableDisableSet);
		addField(updateInstallationRadioBttn);
		updateInstallationRadioBttn.setEnabled(isUpdatesEnabled, enableDisableSet);

		setSeparator(enableDisableSet);

		updateSiteURL = new StringFieldEditor(PreferenceConstants.UPDATE_SITE_URL, "Update site:", enableDisableSet);
		releaseSiteURL = new StringFieldEditor(PreferenceConstants.RELESE_SITE_URL, "Release site:", enableDisableSet);
		updateSiteURL.setEnabled(isUpdatesEnabled, enableDisableSet);
		releaseSiteURL.setEnabled(isUpdatesEnabled, enableDisableSet);
		addField(updateSiteURL);
		addField(releaseSiteURL);
		addBlankSeparator(enableDisableSet);
		setSeparator(fieldEditorParent);

	}

	private void setSeparator(Composite parent) {
		Label label = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 3, 1));
	}

	private void addBlankSeparator(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 3, 1));
	}

	public void propertyChange(PropertyChangeEvent event) {
		FieldEditor fe = (FieldEditor) event.getSource();
		if (PreferenceConstants.ENABLE_AUTOMATIC_UPDATES.equals(fe.getPreferenceName())) {
			boolean isAutomaticUpdateEnabled = (boolean) event.getNewValue();
			intervalDayEditor.setEnabled(isAutomaticUpdateEnabled, enableDisableSet);
			updateSiteURL.setEnabled(isAutomaticUpdateEnabled, enableDisableSet);
			releaseSiteURL.setEnabled(isAutomaticUpdateEnabled, enableDisableSet);
			updateInstallationRadioBttn.setEnabled(isAutomaticUpdateEnabled, enableDisableSet);
			intervalTimeEditor.setEnabled(isAutomaticUpdateEnabled, enableDisableSet);
		} 
		setPreferenceDefaults(preferenceStore);
		super.propertyChange(event);
	}

	public static void setAutomaticUpdatePreference(String value) {
		preferenceStore.setDefault(PreferenceConstants.ENABLE_AUTOMATIC_UPDATES, value);
	}

}

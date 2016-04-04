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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.platform.ui.WorkbenchToolkit;

public class UpdateCheckerPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private static final String INSTALL_AUTOMATICALLY = "AUTOMATIC";
	private static final String NOTIFY_ME = "NOTIFY_ME";
	public static final String MONTHLY = "Monthly";
	public static final String DEFAULT_SUNDAY = "Every Sunday";
	public static final String EVERY_MONDAY = "Every Monday";
	public static final String EVERY_TUESDAY = "Every Tuesday";
	public static final String EVERY_WEDNESDAY = "Every Wednesday";
	public static final String EVERY_THURSDAY = "Every Thursday";
	public static final String EVERY_FRIDAY = "Every Friday";
	public static final String EVERY_SATURDAY = "Every Saturday";

	public static final String MIDNIGHT = "00:00";
	public static final String ONEAM = "01:00";
	public static final String TWOAM = "02:00";
	public static final String THREEAM = "03:00";
	public static final String FOURAM = "04:00";
	public static final String FIVEAM = "05:00";
	public static final String SIXAM = "06:00";
	public static final String SEVENAM = "07:00";
	public static final String DEFAULT_EIGHT_AM = "08:00";
	public static final String NINEAM = "09:00";
	public static final String TENAM = "10:00";
	public static final String ELEVENAM = "11:00";
	public static final String TWELEVENOON = "12:00";
	public static final String ONEPM = "13:00";
	public static final String TWOPM = "14:00";
	public static final String THREEPM = "15:00";
	public static final String FOURPM = "16:00";
	public static final String FIVEPM = "17:00";
	public static final String SIXPM = "18:00";
	public static final String SEVENPM = "19:00";
	public static final String EIGHTPM = "20:00";
	public static final String NINEPM = "21:00";
	public static final String TENPM = "22:00";
	public static final String ELEVENPM = "23:00";

	public static final String DAILY = "Daily";
	public static final String UPDATE_DATE_INTERVAL = "UPDATE_INTAVAL";
	public static final String UPDATE_TIME_INTERVAL = "UPDATE_TIME_INTAVAL";
	public static final String AUTOMATIC_UPDATE_STATUS = "AUTOMATIC_UPATE_STATUS";
	public static final String ENABLE_AUTOMATIC_UPDATES = "ENABLE_AUTOMATIC_UPDATES";

	public static final String DOWNLOAD_UPDATES = "&Install available updates automatically";
	public static final String NOTIFY_ME_IF_UPDATES_AVAILABLE = "&Notify me when updates are available";
	public static final String UPDATE_NOTIFICATION_CONFIGURATION = "UPDATE_NOTIFICATION_CONFIGURATION";

	public static final String RELESE_SITE_URL = "RELESE_SITE_URL";
	public static final String UPDATE_SITE_URL = "UPDATE_SITE_URL";

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
		preferenceStore.setDefault(RELESE_SITE_URL, PreferenceInitializer.DEFAULT_RELEASE_SITE);
		preferenceStore.setDefault(UPDATE_SITE_URL, PreferenceInitializer.DEFAULT_UPDATE_SITE);
		preferenceStore.setDefault(UPDATE_DATE_INTERVAL, DEFAULT_SUNDAY);
		preferenceStore.setDefault(UPDATE_TIME_INTERVAL, DEFAULT_EIGHT_AM);
		preferenceStore.setDefault(ENABLE_AUTOMATIC_UPDATES, true);
	}

	@Override
	protected void createFieldEditors() {
		fieldEditorParent = getFieldEditorParent();

		BooleanFieldEditor enableAutomaticUpdates = new BooleanFieldEditor(ENABLE_AUTOMATIC_UPDATES,
				"Check for updates Automatically", fieldEditorParent);
		addField(enableAutomaticUpdates);
		boolean isUpdatesEnabled = preferenceStore.getBoolean(UpdateCheckerPreferencePage.ENABLE_AUTOMATIC_UPDATES);
		addBlankSeparator(fieldEditorParent);
		setSeparator(fieldEditorParent);

		enableDisableSet = new Composite(fieldEditorParent, SWT.LEFT);
		addBlankSeparator(enableDisableSet);
		String[][] intervals = { { DAILY, DAILY }, { DEFAULT_SUNDAY, DEFAULT_SUNDAY }, { EVERY_MONDAY, EVERY_MONDAY },
				{ EVERY_TUESDAY, EVERY_TUESDAY }, { EVERY_WEDNESDAY, EVERY_WEDNESDAY },
				{ EVERY_THURSDAY, EVERY_THURSDAY }, { EVERY_FRIDAY, EVERY_FRIDAY },
				{ EVERY_SATURDAY, EVERY_SATURDAY } };
		intervalDayEditor = new ComboFieldEditor(UPDATE_DATE_INTERVAL, "Check for updates ", intervals, enableDisableSet);
		addField(intervalDayEditor);
		intervalDayEditor.setEnabled(isUpdatesEnabled, enableDisableSet);

		String[][] timeIntervals = { { MIDNIGHT, MIDNIGHT }, { ONEAM, ONEAM }, { TWOAM, TWOAM }, { THREEAM, THREEAM },
				{ FOURAM, FOURAM }, { FIVEAM, FIVEAM }, { SIXAM, SIXAM }, { SEVENAM, SEVENAM }, { DEFAULT_EIGHT_AM, NINEAM },
				{ TENAM, TENAM }, { ELEVENAM, ELEVENAM }, { TWELEVENOON, TWELEVENOON }, { ONEPM, ONEPM }, { TWOPM, TWOPM },
				{ THREEPM, THREEPM }, { FOURPM, FOURPM }, { FIVEPM, FIVEPM }, { SIXPM, SIXPM }, { SIXPM, SIXPM },
				{ SEVENPM, SEVENPM }, { EIGHTPM, EIGHTPM }, { NINEPM, NINEPM }, { TENPM, TENPM }, { ELEVENPM, ELEVENPM } };
		intervalTimeEditor = new ComboFieldEditor(UPDATE_TIME_INTERVAL, ""
				, timeIntervals,
				enableDisableSet);
		intervalTimeEditor.setEnabled(isUpdatesEnabled, enableDisableSet);
		addField(intervalTimeEditor);

		setSeparator(enableDisableSet);
		addBlankSeparator(enableDisableSet);
		updateInstallationRadioBttn = new RadioGroupFieldEditor(UPDATE_NOTIFICATION_CONFIGURATION,
				"Update Notification and Installation", 1, new String[][] {
						{ NOTIFY_ME_IF_UPDATES_AVAILABLE, NOTIFY_ME }, { DOWNLOAD_UPDATES, INSTALL_AUTOMATICALLY } },
				enableDisableSet);
		addField(updateInstallationRadioBttn);
		updateInstallationRadioBttn.setEnabled(isUpdatesEnabled, enableDisableSet);

		setSeparator(enableDisableSet);

		updateSiteURL = new StringFieldEditor(UPDATE_SITE_URL, "Update site:", enableDisableSet);
		releaseSiteURL = new StringFieldEditor(RELESE_SITE_URL, "Release site:", enableDisableSet);
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
		if (ENABLE_AUTOMATIC_UPDATES.equals(fe.getPreferenceName())) {
			boolean isAutomaticUpdateEnabled = (boolean) event.getNewValue();
			intervalDayEditor.setEnabled(isAutomaticUpdateEnabled, enableDisableSet);
			updateSiteURL.setEnabled(isAutomaticUpdateEnabled, enableDisableSet);
			releaseSiteURL.setEnabled(isAutomaticUpdateEnabled, enableDisableSet);
			updateInstallationRadioBttn.setEnabled(isAutomaticUpdateEnabled, enableDisableSet);
			intervalTimeEditor.setEnabled(isAutomaticUpdateEnabled, enableDisableSet);
		} /*else  {
			preferenceStore.putValue(fe.getPreferenceName(), (String) event.getNewValue());
		}*/
		setPreferenceDefaults(preferenceStore);
		super.propertyChange(event);
	}

	public static void setAutomaticUpdatePreference(String value) {
		preferenceStore.setDefault(ENABLE_AUTOMATIC_UPDATES, value);
	}

}

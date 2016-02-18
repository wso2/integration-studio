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
package org.wso2.developerstudio.eclipse.updater.handler;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IStartup;
import org.osgi.service.prefs.Preferences;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.UpdateCheckerPreferencePage;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;
import org.wso2.developerstudio.eclipse.updater.core.Constants;
import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;
import org.wso2.developerstudio.eclipse.updater.job.UpdateCheckerJob;
import org.wso2.developerstudio.eclipse.updater.job.UpdateCheckerJobListener;
import org.wso2.developerstudio.eclipse.updater.ui.UpdaterDialog.ActiveTab;

public class StartupUpdateHandler implements IStartup {

	private static final String SET_LATER = "Set Later";
	private static final String UPDATER_DIALOG_MESSAGE = "Do you want to run WSO2 updates on Developer Studio startup ? ";
	private static final String TITLE = "Set Automatic Updates Preference";
	protected static final String DAILY = "Daily";
	protected static final String WEEKLY = "Weekly";
	protected static final String MONTHLY = "Monthly";
	protected static final String SELECT = "Select";
	protected static final String YES = "Yes";
	protected static final String NO = "No";
	private static int userResult = 0;

	protected UpdateManager updateManager = new UpdateManager();

	protected static IDeveloperStudioLog log = Logger
			.getLog(UpdaterPlugin.PLUGIN_ID);

	@Override
	public void earlyStartup() {
		// Read updater preferences
		IPreferenceStore prefPage = org.wso2.developerstudio.eclipse.platform.ui.Activator
				.getDefault().getPreferenceStore();
		String isAutomaticUpdate = prefPage
				.getString(UpdateCheckerPreferencePage.SET_AUTOMATIC_UPDATE_PREF);
		String defaultVal = NO;
		if (isAutomaticUpdate.equals(SELECT)) {
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					getUserPreference();
				}
			});
			// evaluate the user information dialog result
			if (userResult == 0) {// yes = 0,
				defaultVal = YES;
			} else if (userResult == 2) {// no =1, set-later = 2
				defaultVal = SELECT;
			}
		}
		// Do not continue if user set automatic updates to false
		if (defaultVal.equals(NO) || defaultVal.equals(SELECT)) {
			prefPage.setValue(
					UpdateCheckerPreferencePage.SET_AUTOMATIC_UPDATE_PREF,
					defaultVal);
			return;
		}
		String updateInterval = prefPage
				.getString(UpdateCheckerPreferencePage.UPDATE_INTAVAL);

		Date today = new Date();
		Preferences bundlePrefs = ConfigurationScope.INSTANCE
				.getNode(Constants.NODE_UPDATE_HANDER);
		long lastPromptTime = bundlePrefs.getLong(
				Constants.PREF_LAST_PROMPT_FOR_UPDATES, today.getTime());

		boolean checkUpdates = true;
		// check duration since last check for updates
		if (lastPromptTime != today.getTime()) {
			long dateDiff = getTimeDiff(lastPromptTime, today.getTime(),
					TimeUnit.DAYS);
			if ((updateInterval.equals(MONTHLY) && dateDiff < 30)
					|| (updateInterval.equals(WEEKLY) && dateDiff < 7)
					|| (updateInterval.equals(DAILY) && dateDiff < 1)) {
				// do not check updates
				checkUpdates = false;
			}
		}
		if (checkUpdates) {
			Job updateJob = new UpdateCheckerJob(updateManager);
			updateJob.schedule();
			updateJob.addJobChangeListener(new UpdateCheckerJobListener(
					updateManager, ActiveTab.UPDATE_FEATURES, true));
		}
		prefPage.setValue(
				UpdateCheckerPreferencePage.SET_AUTOMATIC_UPDATE_PREF,
				defaultVal);
	}

	private void getUserPreference() {
		Display activeDisplay = Display.getDefault();
		MessageDialog dialog = new MessageDialog(new Shell(activeDisplay),
				TITLE, null, UPDATER_DIALOG_MESSAGE, MessageDialog.INFORMATION,
				new String[] { YES, NO, SET_LATER }, 0);
		userResult = dialog.open();
	}

	protected static long getTimeDiff(long date1, long date2, TimeUnit timeUnit) {
		long diffInMillies = date2 - date1;
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}
}

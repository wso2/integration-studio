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
import org.eclipse.jface.preference.IPreferenceStore;
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

	protected static final String DAILY = "Daily";
	protected static final String WEEKLY = "Weekly";
	protected static final String MONTHLY = "Monthly";

	protected UpdateManager updateManager = new UpdateManager();

	protected static IDeveloperStudioLog log = Logger
			.getLog(UpdaterPlugin.PLUGIN_ID);

	@Override
	public void earlyStartup() {
		// Read updater preferences
		IPreferenceStore prefPage = org.wso2.developerstudio.eclipse.platform.ui.Activator
				.getDefault().getPreferenceStore();
		boolean isAutomaticUpdatesEnabled = prefPage
				.getBoolean(UpdateCheckerPreferencePage.ENABLE_AUTOMATIC_UPDATES);
		// Do not continue if automatic updates are disabled
		if (!isAutomaticUpdatesEnabled) {
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
	}

	protected static long getTimeDiff(long date1, long date2, TimeUnit timeUnit) {
		long diffInMillies = date2 - date1;
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}
}

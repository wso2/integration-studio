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

package org.wso2.developerstudio.eclipse.updater.job;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.prefs.Preferences;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.UpdateCheckerPreferencePage;
import org.wso2.developerstudio.eclipse.updater.Messages;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;
import org.wso2.developerstudio.eclipse.updater.core.Constants;
import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;
import org.wso2.developerstudio.eclipse.updater.ui.UpdaterDialog.ActiveTab;

public class UpdateMetaFileReaderJobListener extends JobChangeAdapter {

	private static final String SET_LATER = "Not Now";
	private static final String UPDATER_DIALOG_MESSAGE = "Do you want to update now ?";
	private static final String TITLE = "There are updates for developer studio features you have installed. It is recommended to install these updates";
	protected static final String SELECT = "Select";
	protected static final String YES = "Yes";
	protected static final String NO = "No";
	protected static final String DAILY = "Daily";
	protected static final String WEEKLY = "Weekly";
	protected static final String MONTHLY = "Monthly";

	protected static IDeveloperStudioLog log = Logger.getLog(UpdaterPlugin.PLUGIN_ID);

	protected UpdateManager updateManager;
	protected ActiveTab activeTab;
	protected boolean isAutomaticUpdater;

	public UpdateMetaFileReaderJobListener(UpdateManager updateManager, ActiveTab activeTab,
			boolean isAutomaticUpdater) {
		this.updateManager = updateManager;
		this.activeTab = activeTab;
		this.isAutomaticUpdater = isAutomaticUpdater;
	}

	@Override
	public void done(IJobChangeEvent event) {
		if (event.getResult().isOK()) {
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					try {
						if (getUserPreference(TITLE, UPDATER_DIALOG_MESSAGE) == 0) {
							runUpdaterJob();
						}
					} catch (Exception e) {
						log.error(Messages.UpdatemetaFileReaderJobListener_0, e);
					}
				}

				private void runUpdaterJob() {
					Date today = new Date();
					IPreferenceStore prefPage = PlatformUI.getPreferenceStore();
					String updateInterval = prefPage.getString(UpdateCheckerPreferencePage.UPDATE_INTAVAL);
					Preferences bundlePrefs = ConfigurationScope.INSTANCE.getNode(Constants.NODE_UPDATE_HANDER);
					long lastPromptTime = bundlePrefs.getLong(Constants.PREF_LAST_PROMPT_FOR_UPDATES, today.getTime());
					// check duration since last check for updates
					if (lastPromptTime != today.getTime()) {
						long dateDiff = getTimeDiff(lastPromptTime, today.getTime(), TimeUnit.DAYS);
						if ((updateInterval.equals(MONTHLY) && dateDiff < 30)
								|| (updateInterval.equals(WEEKLY) && dateDiff < 7)
								|| (updateInterval.equals(DAILY) && dateDiff < 1)) {
							// do not check updates
						} else {
							executeUpdateJob();
						}
					} else {
						executeUpdateJob();
					}
				}

				private void executeUpdateJob() {
					Job updateJob = new UpdateCheckerJob(updateManager);
					updateJob.schedule();
					updateJob.addJobChangeListener(
							new UpdateCheckerJobListener(updateManager, ActiveTab.UPDATE_FEATURES, true));
				}
			});
		}
	}

	public static int getUserPreference(String message, String title) {
		// Display activeDisplay = Display.getDefault();
		MessageDialog dialog = new MessageDialog(Display.getDefault().getActiveShell(), title, null, message,
				MessageDialog.INFORMATION, new String[] { YES, NO, SET_LATER }, 0);
		return dialog.open();
	}

	protected static long getTimeDiff(long date1, long date2, TimeUnit timeUnit) {
		long diffInMillies = date2 - date1;
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

}

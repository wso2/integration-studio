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

import java.util.Calendar;
import java.util.concurrent.TimeUnit;


import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.UpdateCheckerPreferencePage;
import org.wso2.developerstudio.eclipse.updater.Messages;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;
import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;
import org.wso2.developerstudio.eclipse.updater.ui.UpdaterDialog.ActiveTab;

public class UpdateMetaFileReaderJobListener extends JobChangeAdapter {

	private static final String SET_LATER = "Not Now";
	private static final String UPDATER_DIALOG_MESSAGE = "Do you want to update now ?";
	private static final String TITLE = "There are updates for developer studio features you have installed. It is recommended to install these updates";
	protected static final String YES = "Yes";
	protected static final String NO = "No";
	protected static final String DAILY = "Daily";
	protected static final String WEEKLY = "Weekly";
	protected static final String MONTHLY = "Monthly";

	protected static IDeveloperStudioLog log = Logger.getLog(UpdaterPlugin.PLUGIN_ID);

	protected UpdateManager updateManager;
	protected ActiveTab activeTab;
	protected boolean isAutomaticUpdater;
	protected static IPreferenceStore prefPage;

	public UpdateMetaFileReaderJobListener(UpdateManager updateManager, ActiveTab activeTab,
			boolean isAutomaticUpdater) {
		this.prefPage = PlatformUI.getPreferenceStore();
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
							runUpdaterJob(false);
						} else if (getUserPreference(TITLE, UPDATER_DIALOG_MESSAGE) == 15) {
							runUpdaterJob(true);// do check user set preference
												// time to install updates
						}
					} catch (Exception e) {
						log.error(Messages.UpdatemetaFileReaderJobListener_0, e);
					}
				}

				private void runUpdaterJob(boolean doCheckTime) {
					Calendar cal = Calendar.getInstance();
					String updateIntervalDay = prefPage.getString(UpdateCheckerPreferencePage.UPDATE_DATE_INTERVAL);
					if (updateIntervalDay == null || updateIntervalDay.isEmpty()) {
						updateIntervalDay = UpdateCheckerPreferencePage.DEFAULT_SUNDAY;
					}
					int intValOfDay = getIntValOfDay(updateIntervalDay);
					String updateIntervalTime = prefPage.getString(UpdateCheckerPreferencePage.UPDATE_TIME_INTERVAL);
					if (updateIntervalTime == null || updateIntervalTime.isEmpty()) {
						updateIntervalTime = UpdateCheckerPreferencePage.DEFAULT_EIGHT_AM;
					}
					if (!doCheckTime) { // if OKed by user, run irrespective of
										// time setting
						executeUpdateJob();
					} else { // if running automatically check
								// if current time is user
								// preferred update time
						if (Math.abs(cal.get(Calendar.DAY_OF_WEEK) - intValOfDay) == 0) {
							// no possibility of being null, hard-coded values
							// from drop down
							String[] hourValFromIntervalTime = updateIntervalTime.split(":");
							Integer intHourVal = Integer.parseInt(hourValFromIntervalTime[0]);
							if (Math.abs(cal.get(Calendar.HOUR_OF_DAY) - intHourVal) == 0
									&& cal.get(Calendar.MINUTE) == 0) {
								executeUpdateJob();
							}
						}
					}
				}

				private int getIntValOfDay(String updateIntervalDay) {
					switch (updateIntervalDay) {
					case (UpdateCheckerPreferencePage.EVERY_MONDAY):
						return Calendar.MONDAY;
					case (UpdateCheckerPreferencePage.EVERY_TUESDAY):
						return Calendar.TUESDAY;
					case (UpdateCheckerPreferencePage.EVERY_WEDNESDAY):
						return Calendar.WEDNESDAY;
					case (UpdateCheckerPreferencePage.EVERY_THURSDAY):
						return Calendar.THURSDAY;
					case (UpdateCheckerPreferencePage.EVERY_FRIDAY):
						return Calendar.FRIDAY;
					case (UpdateCheckerPreferencePage.EVERY_SATURDAY):
						return Calendar.SATURDAY;
					default:
						return Calendar.SUNDAY; // case SUNDAY
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
		String userChoice = prefPage.getString(UpdateCheckerPreferencePage.UPDATE_NOTIFICATION_CONFIGURATION);
		if (userChoice == null || userChoice.isEmpty()) {
			userChoice = UpdateCheckerPreferencePage.NOTIFY_ME_IF_UPDATES_AVAILABLE;
		}
		if (userChoice.equals(UpdateCheckerPreferencePage.NOTIFY_ME_IF_UPDATES_AVAILABLE)) {
			MessageDialog dialog = new MessageDialog(Display.getDefault().getActiveShell(), title, null, message,
					MessageDialog.INFORMATION, new String[] { YES, NO, SET_LATER }, 0);
			return dialog.open();
		}
		return 15;// in case if user configured to install updates automatically
					// with time preference
	}

	protected static long getTimeDiff(long date1, long date2, TimeUnit timeUnit) {
		long diffInMillies = date2 - date1;
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

}

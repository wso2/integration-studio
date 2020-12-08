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

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.PreferenceConstants;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.UpdateCheckerPreferencePage;
import org.wso2.developerstudio.eclipse.updater.Messages;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;
import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;
import org.wso2.developerstudio.eclipse.updater.ui.UpdaterDialog.ActiveTab;

public class UpdateMetaFileReaderJobListener extends JobChangeAdapter {

	private static final int USER_SCHEDULED_AUTOMATIC_INSTALL = 15;
	private static final String SET_LATER = "Not Now";
	private static final String UPDATER_DIALOG_TITLE = Messages.UpdatemetaFileReaderJobListener_1;
	protected static final String YES = "Yes";
	private static org.wso2.developerstudio.eclipse.updater.job.UpdateMetaFileReaderJob UpdateMetaFileReaderJob;

	protected static IDeveloperStudioLog log = Logger.getLog(UpdaterPlugin.PLUGIN_ID);

	protected UpdateManager updateManager;
	protected ActiveTab activeTab;
	protected boolean isAutomaticUpdater;
	protected static IPreferenceStore prefPage = PlatformUI.getPreferenceStore();

	public UpdateMetaFileReaderJobListener(UpdateManager updateManager, ActiveTab activeTab,
			boolean isAutomaticUpdater) {
		this.updateManager = updateManager;
		this.activeTab = activeTab;
		this.isAutomaticUpdater = isAutomaticUpdater;
	}

	@Override
	public void done(IJobChangeEvent event) {

		if (event.getResult().isOK()) {
			UpdateMetaFileReaderJob = ((UpdateMetaFileReaderJob) event.getJob());
			final int count = UpdateMetaFileReaderJob.getUpdateCount();
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					try {
						String displayMsg = String.valueOf(count)
								+ " update(s) available for developer studio. List them now ?";
						int userPref = getUserPreference(UPDATER_DIALOG_TITLE, displayMsg);
						if (userPref == 0 || userPref == USER_SCHEDULED_AUTOMATIC_INSTALL) {
							executeUpdateJob();
						} 
					} catch (Exception e) {
						log.error(Messages.UpdatemetaFileReaderJobListener_0, e);
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

	public static int getUserPreference(String title, String message) {
		// Display activeDisplay = Display.getDefault();
		String userChoice = prefPage.getString(PreferenceConstants.UPDATE_NOTIFICATION_CONFIGURATION);
		if (userChoice == null || userChoice.isEmpty()) {
			userChoice = PreferenceConstants.NOTIFY_ME;
		}
		if (userChoice.equals(PreferenceConstants.NOTIFY_ME)) {
			MessageDialog dialog = new MessageDialog(Display.getDefault().getActiveShell(), title, null, message,
					MessageDialog.INFORMATION, new String[] { YES, SET_LATER }, 0);
			return dialog.open();
		}
		return USER_SCHEDULED_AUTOMATIC_INSTALL;// in case if user configured to
												// install updates automatically
		// with time preference
	}

}

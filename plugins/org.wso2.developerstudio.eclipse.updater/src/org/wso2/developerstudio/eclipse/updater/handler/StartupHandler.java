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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IStartup;
import org.osgi.service.prefs.Preferences;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.UpdateCheckerPreferencePage;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;
import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;
import org.wso2.developerstudio.eclipse.updater.handler.UpdateHandler.UpdateJobCompletedHandler;
import org.wso2.developerstudio.eclipse.updater.ui.ProvisioningWindow;

public class StartupHandler implements IStartup {
	
	protected static IDeveloperStudioLog log = Logger
			.getLog(UpdaterPlugin.PLUGIN_ID);
	protected UpdateManager updateManager = new UpdateManager();

	@Override
	public void earlyStartup() {

		IPreferenceStore prefPage = org.wso2.developerstudio.eclipse.platform.ui.Activator
				.getDefault().getPreferenceStore();
		boolean automaticUpdatesEnabled = prefPage
				.getBoolean(UpdateCheckerPreferencePage.ENABLE_AUTOMATIC_UPDATES);
		if (!automaticUpdatesEnabled) {
			return;
		}
		String updateInterval = prefPage
				.getString(UpdateCheckerPreferencePage.UPDATE_INTAVAL);

		Preferences preferences = ConfigurationScope.INSTANCE
				.getNode("org.wso2.developerstudio.eclipse.updater.handler");
		Date today = new Date();
		long lastPromptTime = preferences.getLong("lastPromptForUpdates",
				today.getTime());

		boolean checkUpdates = true;
		if (lastPromptTime != today.getTime()) {
			long dateDiff = getDateDiff(lastPromptTime, today.getTime(),
					TimeUnit.DAYS);
			if ((updateInterval.equals("Monthly") && dateDiff <= 30)
					|| (updateInterval.equals("Weekly") && dateDiff <= 7)
					|| (updateInterval.equals("Daily") && dateDiff <= 1)) {
				checkUpdates = false;
			}
		}
		if(checkUpdates){
			
			Job updateJob = new Job("Updater checker") {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					try {
						SubMonitor progress = SubMonitor.convert(monitor,
								"Searching for updates.", 2);
						updateManager.checkForAvailableUpdates(progress.newChild(1));
						updateManager.checkForAvailableFeatures(progress.newChild(1));
					} catch (Exception e) {
						log.error("Error while checking updates.", e);

					}
					return Status.OK_STATUS;
				}
			};
			updateJob.schedule();
			updateJob.addJobChangeListener(new UpdateJobCompletedHandler());			
		}

	}

	public static long getDateDiff(long date1, long date2, TimeUnit timeUnit) {
		long diffInMillies = date2 - date1;
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}
	
	class UpdateJobCompletedHandler extends JobChangeAdapter {
		@Override
		public void done(IJobChangeEvent event) {
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					ProvisioningWindow provioningWindow;
					try {
						if(updateManager.getPossibleUpdates().length == 0){
							log.info("No Updates are available.");
							return;
						}
						provioningWindow = new ProvisioningWindow(updateManager);
						// Set last propmt for Updates Timestamp
						Preferences preferences = ConfigurationScope.INSTANCE
								.getNode("org.wso2.developerstudio.eclipse.updater.handler");
						preferences.putLong("lastPromptForUpdates",
								new Date().getTime());
						preferences.flush();
						provioningWindow.open();
					} catch (Exception e) {
						log.error(e);
					}
				}
			});
		}
	}

}

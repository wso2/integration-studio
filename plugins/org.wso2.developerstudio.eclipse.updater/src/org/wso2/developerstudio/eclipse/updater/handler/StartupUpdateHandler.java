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

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.UpdateCheckerPreferencePage;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;
import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;
import org.wso2.developerstudio.eclipse.updater.job.UpdateMetaFileReaderJob;
import org.wso2.developerstudio.eclipse.updater.job.UpdateMetaFileReaderJobListener;
import org.wso2.developerstudio.eclipse.updater.ui.UpdaterDialog.ActiveTab;

public class StartupUpdateHandler implements IStartup {

	protected static final String DAILY = "Daily";
	protected static final String WEEKLY = "Weekly";
	protected static final String MONTHLY = "Monthly";
	protected static final String SELECT = "Select";
	protected static final String YES = "Yes";
	protected static final String NO = "No";

	protected UpdateManager updateManager = new UpdateManager();

	protected static IDeveloperStudioLog log = Logger.getLog(UpdaterPlugin.PLUGIN_ID);

	@Override
	public void earlyStartup() {
		// Read updater preferences
		IPreferenceStore prefPage = PlatformUI.getPreferenceStore();
		String isAutomaticUpdate = prefPage.getString(UpdateCheckerPreferencePage.SET_AUTOMATIC_UPDATE_PREF);
		if (isAutomaticUpdate.equals(NO)) {
			return;
		}
		// before running the update checker job, read the updates meta file and
		// see if it has updates before iterating through the updater
		// repository.
		// UpdateMetaFileReaderJob
		Job readMetaFileJob = new UpdateMetaFileReaderJob(updateManager);
		readMetaFileJob.schedule();
		readMetaFileJob.addJobChangeListener(
				new UpdateMetaFileReaderJobListener(updateManager, ActiveTab.UPDATE_FEATURES, true));
	}
}

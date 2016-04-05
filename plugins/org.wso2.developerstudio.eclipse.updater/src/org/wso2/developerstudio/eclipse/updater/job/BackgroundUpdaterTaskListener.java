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
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;
import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;
import org.wso2.developerstudio.eclipse.updater.ui.UpdaterDialog.ActiveTab;

public class BackgroundUpdaterTaskListener extends JobChangeAdapter {

	protected static IDeveloperStudioLog log = Logger.getLog(UpdaterPlugin.PLUGIN_ID);

	protected UpdateManager updateManager;

	public BackgroundUpdaterTaskListener(UpdateManager updateManager) {
		this.updateManager = updateManager;
	}

	@Override
	public void done(IJobChangeEvent event) {
		// if scheduled job
		if (event.getResult().isOK()) {
			executeUpdateJob();
		}
	}

	/**
	 * schedule a meta file reader job to check if there are updates
	 */
	private void executeUpdateJob() {
		Job readMetaFileJob = new UpdateMetaFileReaderJob(updateManager);
		readMetaFileJob.schedule();
		readMetaFileJob.addJobChangeListener(
				new UpdateMetaFileReaderJobListener(updateManager, ActiveTab.UPDATE_FEATURES, true));
	}

}

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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.PreferenceConstants;

/**
 * This is the background job that runs on the scheduled time by user to execute
 * the automatic updates.
 * 
 * once run, it will self reschedule it to run again in a day or a week
 * depending on user specification
 *
 */
public class BackgroundUpdateTaskJob extends Job {
	private boolean running = true;
	protected long repeatDayDelay = 86400000;
	protected long repeatWeekDelay = 604800000;
	protected long repeatTime = repeatDayDelay;

	public BackgroundUpdateTaskJob(String jobName, long repeatPeriod) {
		super(jobName);
	}

	protected IStatus run(IProgressMonitor monitor) {
		/**
		 * If the updater is scheduled daily schedule the next run in a day if
		 * not schedule the next run in a week.
		 */
		IPreferenceStore prefPage = PlatformUI.getPreferenceStore();
		String updateIntervalDay = prefPage.getString(PreferenceConstants.UPDATE_DATE_INTERVAL);
		if (updateIntervalDay == null || updateIntervalDay.isEmpty()) {
			updateIntervalDay = PreferenceConstants.DEFAULT_SUNDAY;
		}
		if (!updateIntervalDay.equals(PreferenceConstants.DAILY)) {
			repeatTime = repeatWeekDelay;
		}
		schedule(repeatTime);
		return Status.OK_STATUS;
	}

	public boolean shouldSchedule() {
		return running;
	}

	public void stop() {
		running = false;
	}
}

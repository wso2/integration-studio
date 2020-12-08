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
package org.wso2.developerstudio.eclipse.updater.job;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.updater.Messages;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;
import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;

public class UpdateCheckerJob extends Job {

	protected UpdateManager updateManager;

	protected static boolean isCurrentJobRunning = false;
	public synchronized static boolean isJobRunning() {
		return isCurrentJobRunning;
	}

	public synchronized static void setIsJobRunning(boolean isJobRunning) {
		isCurrentJobRunning = isJobRunning;
	}

	protected static IDeveloperStudioLog log = Logger.getLog(UpdaterPlugin.PLUGIN_ID);

	public UpdateCheckerJob(UpdateManager updateManager) {
		super(Messages.UpdateCheckerJob_0);
		this.updateManager = updateManager;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try {
			if (!isJobRunning()) {
				setIsJobRunning(true);
				SubMonitor progress = SubMonitor.convert(monitor, Messages.UpdateCheckerJob_1, 2);
				try {
				updateManager.checkForAvailableUpdates(progress.newChild(1));
				updateManager.checkForAvailableFeatures(progress.newChild(1));
				} catch (Exception e){
					log.error("Error occurred while checking for Integration Studio Updates.", e);
					setIsJobRunning(false);
					return Status.CANCEL_STATUS;
				}
				return Status.OK_STATUS;
			} else {
				Display.getDefault().syncExec(new Runnable() {
					@Override
					public void run() {
						try {
							MessageDialog dialog = new MessageDialog(Display.getDefault().getActiveShell(),
									"Updater Tool in Progress", null, "Updater tool is already in Progress",
									MessageDialog.INFORMATION, new String[] { "OK" }, 0);
							dialog.open();
						} catch (Exception e) {
							
						}
					}
					// pop up user message saying an updater job is already
					// running
				});
			}
		} catch (Exception e) {
			log.error(Messages.UpdateCheckerJob_2, e);
		}
		return Status.CANCEL_STATUS;
	}
	
	@Override
	protected void canceling() {
		setIsJobRunning(false);
		super.canceling();
	}
	
	

}

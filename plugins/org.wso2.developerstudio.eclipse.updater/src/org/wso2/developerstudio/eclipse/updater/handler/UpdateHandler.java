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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;
import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;
import org.wso2.developerstudio.eclipse.updater.ui.ProvisioningWindow;

public class UpdateHandler extends AbstractHandler {

	protected static IDeveloperStudioLog log = Logger
			.getLog(UpdaterPlugin.PLUGIN_ID);
			
	protected UpdateManager updateManager = new UpdateManager();

	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {	
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
		return null;
	}
	
	class UpdateJobCompletedHandler extends JobChangeAdapter{
		@Override
		public void done(IJobChangeEvent event) {
					Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				ProvisioningWindow provioningWindow;
				try {
					provioningWindow = new ProvisioningWindow(
							updateManager);
					provioningWindow.open();
				} catch (Exception e) {
					log.error(e);
				}
			}
		});
		}
	}

}

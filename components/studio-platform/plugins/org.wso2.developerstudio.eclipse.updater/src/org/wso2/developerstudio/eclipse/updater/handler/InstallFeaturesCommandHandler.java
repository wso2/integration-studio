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
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;
import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;
import org.wso2.developerstudio.eclipse.updater.job.UpdateCheckerJob;
import org.wso2.developerstudio.eclipse.updater.job.UpdateCheckerJobListener;
import org.wso2.developerstudio.eclipse.updater.ui.UpdaterDialog.ActiveTab;

public class InstallFeaturesCommandHandler extends AbstractHandler {

	protected static IDeveloperStudioLog log = Logger
			.getLog(UpdaterPlugin.PLUGIN_ID);

	protected UpdateManager updateManager = new UpdateManager();

	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {
		Job updateJob = new UpdateCheckerJob(updateManager);
		updateJob.schedule();
		updateJob.addJobChangeListener(new UpdateCheckerJobListener(
				updateManager, ActiveTab.ALL_FEATURES, false));
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().showView(IProgressConstants.PROGRESS_VIEW_ID);
		} catch (PartInitException e) {
			log.error(e);
		}
		return null;
	}
}

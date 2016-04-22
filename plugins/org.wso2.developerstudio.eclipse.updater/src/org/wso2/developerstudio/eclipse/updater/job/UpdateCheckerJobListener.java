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

import java.util.Date;

import javax.net.ssl.SSLEngineResult.Status;

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.swt.widgets.Display;
import org.osgi.service.prefs.Preferences;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.updater.Messages;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;
import org.wso2.developerstudio.eclipse.updater.core.Constants;
import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;
import org.wso2.developerstudio.eclipse.updater.ui.UpdaterDialog;
import org.wso2.developerstudio.eclipse.updater.ui.UpdaterDialog.ActiveTab;

public class UpdateCheckerJobListener extends JobChangeAdapter {

	protected static IDeveloperStudioLog log = Logger.getLog(UpdaterPlugin.PLUGIN_ID);

	protected UpdateManager updateManager;
	protected ActiveTab activeTab;
	protected boolean isAutomaticUpdater;

	public UpdateCheckerJobListener(UpdateManager updateManager, ActiveTab activeTab, boolean isAutomaticUpdater) {
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
						// Wait half a second to let progress reporting complete
						// FIXME: Find a proper fix
						Thread.sleep(500);
						// Set last check for Updates Time-stamp in OSGI bundle
						// prefs
						Preferences preferences = ConfigurationScope.INSTANCE.getNode(Constants.NODE_UPDATE_HANDER);
						preferences.putLong(Constants.PREF_LAST_PROMPT_FOR_UPDATES, new Date().getTime());
						preferences.flush();
						UpdateCheckerJob.setIsJobRunning(false);
						if (isAutomaticUpdater && !updateManager.hasPossibleUpdates()) {
							// no updates - no need to open the window
							return;
						}

						UpdaterDialog dialog = new UpdaterDialog(updateManager, activeTab);
						dialog.open();
					} catch (Exception e) {
						log.error(Messages.UpdateCheckerJobListener_0, e);
					}
				}
			});
		}
	}
}

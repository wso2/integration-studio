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

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.swt.widgets.Display;
import org.osgi.service.prefs.Preferences;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;
import org.wso2.developerstudio.eclipse.updater.core.Constants;
import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;
import org.wso2.developerstudio.eclipse.updater.ui.ProvisioningWindow;

public class UpdateCheckerJobListener extends  JobChangeAdapter{
	
	protected static IDeveloperStudioLog log = Logger
			.getLog(UpdaterPlugin.PLUGIN_ID);
	
	protected UpdateManager updateManager;

	public UpdateCheckerJobListener(UpdateManager updateManager) {
		this.updateManager = updateManager;
	}

	@Override
	public void done(IJobChangeEvent event) {
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				ProvisioningWindow provioningWindow;
				try {
					provioningWindow = new ProvisioningWindow(updateManager);

					// Set last check for Updates Timestamp
					Preferences preferences = ConfigurationScope.INSTANCE.getNode(Constants.NODE_UPDATE_HANDER);
					preferences.putLong(Constants.PREF_LAST_PROMPT_FOR_UPDATES, new Date().getTime());
					preferences.flush();

					provioningWindow.open();
				} catch (Exception e) {
					log.error(e);
				}
			}
		});
	}

}

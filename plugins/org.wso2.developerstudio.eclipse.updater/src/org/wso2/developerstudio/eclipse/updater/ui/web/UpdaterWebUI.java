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
package org.wso2.developerstudio.eclipse.updater.ui.web;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.FrameworkUtil;
import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;
import org.wso2.developerstudio.eclipse.updater.ui.UpdaterDialog.ActiveTab;
import org.wso2.developerstudio.eclipse.updater.ui.web.function.GetAvailableFeaturesFunction;
import org.wso2.developerstudio.eclipse.updater.ui.web.function.GetAvailableUpdatesFunction;
import org.wso2.developerstudio.eclipse.updater.ui.web.function.InstallSelectedFeaturesFunction;
import org.wso2.developerstudio.eclipse.updater.ui.web.function.InstallSelectedUpdatesFunction;
import org.wso2.developerstudio.eclipse.updater.ui.web.function.SetSelectedFeaturesFunction;
import org.wso2.developerstudio.eclipse.updater.ui.web.function.SetSelectedUpdatesFunction;
import org.wso2.developerstudio.eclipse.webui.core.window.WebWindow;

public class UpdaterWebUI extends WebWindow {
	
	protected UpdateManager updateManager;
	protected ActiveTab activeTab;

	public UpdaterWebUI(UpdateManager manager, ActiveTab activeTab) throws Exception {
		super(FileLocator.toFileURL(FileLocator.find(FrameworkUtil
				.getBundle(UpdaterWebUI.class), new Path(
				"WebInterface/updater/index.html"), null)));
		this.setSize(710, 812);
		this.updateManager = manager;
		this.activeTab = activeTab;
		new GetAvailableUpdatesFunction(this);
		new SetSelectedUpdatesFunction(this);
		new InstallSelectedUpdatesFunction(this);
		new GetAvailableFeaturesFunction(this);
		new SetSelectedFeaturesFunction(this);
		new InstallSelectedFeaturesFunction(this);
		shell.redraw();
	}

	public UpdateManager getUpdateManager() {
		return updateManager;
	}
}

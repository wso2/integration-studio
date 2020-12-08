/**
 * Copyright 2009-2018 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.templates.dashboard.web.view;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;

public class WebEngineUtils {

	private static final String XULRUNNER_FOLDER = "xulrunner";
	private static final String XUL_RUNNER_PATH = "org.eclipse.swt.browser.XULRunnerPath";

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static boolean isXULRunnerModeEnabled = false;
	private static final Object lock = new Object();

	static {
		resolveXULRunnerPath();
	}

	public static void resolveXULRunnerPath() {
		synchronized (lock) {
			if (Platform.getOS().equals(Platform.OS_WIN32)) {
				if (!isXULRunnerModeEnabled) {
					String mozillaPath = System.getProperty(XUL_RUNNER_PATH);
					if (mozillaPath == null || mozillaPath.isEmpty()) {
						URL eclipseHomeURL = Platform.getInstallLocation().getURL();
						URL eclipseHome;
						try {
							eclipseHome = FileLocator.toFileURL(eclipseHomeURL);
							mozillaPath = new File(eclipseHome.getFile()).getAbsolutePath() + File.separator
									+ XULRUNNER_FOLDER;
							if ((new File(mozillaPath)).exists()) {
								System.setProperty(XUL_RUNNER_PATH, mozillaPath);
								isXULRunnerModeEnabled = true;
							}
						} catch (IOException e) {
							log.error("Error while resolving XUL runner mode.", e);
						}
					}
				}
			}
		}
	}

	public static int getBrowserType() {
		synchronized (lock) {
			if (isXULRunnerModeEnabled) {
				return SWT.MOZILLA;
			} else {
				resolveXULRunnerPath();
				if (isXULRunnerModeEnabled) {
					return SWT.MOZILLA;
				}
			}
			return SWT.NONE;
		}
	}
}

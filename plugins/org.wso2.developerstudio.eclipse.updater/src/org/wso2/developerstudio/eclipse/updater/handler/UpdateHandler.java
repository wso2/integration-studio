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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.osgi.framework.FrameworkUtil;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;
import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;
import org.wso2.developerstudio.eclipse.updater.ui.ProvisioningWindow;

public class UpdateHandler extends AbstractHandler {

	protected static IDeveloperStudioLog log = Logger
			.getLog(UpdaterPlugin.PLUGIN_ID);

	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {
		try {
			IProgressService progressService = PlatformUI.getWorkbench()
					.getProgressService();
			final UpdateManager manager = new UpdateManager();
			try {
				progressService.runInUI(progressService,
						new IRunnableWithProgress() {

							@Override
							public void run(IProgressMonitor monitor)
									throws InvocationTargetException,
									InterruptedException {
								try {
									SubMonitor progress = SubMonitor.convert(
											monitor,
											"Checking for DevStudio updates.",
											2);
									manager.checkForAvailableUpdates(progress
											.newChild(1));
									manager.checkForAvailableFeatures(progress
											.newChild(1));
								} catch (Exception e) {
									log.error("Error while checking updates.",
											e);
									throw new InvocationTargetException(e);
								}

							}
						}, null);

			} catch (InvocationTargetException | InterruptedException e1) {
				log.error(e1);
			}

			ProvisioningWindow provioningWindow = new ProvisioningWindow(
					manager);
			provioningWindow.open();
		} catch (Exception ex) {
			log.error(ex);
		}
		return null;
	}

}

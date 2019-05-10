/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.carbonserver44microei.handlers;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PerspectiveAdapter;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.internal.IActionSetContributionItem;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.wso2.developerstudio.eclipse.carbonserver44microei.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * This is the early startup handler of the developer studio platform, all
 * methods that needs to run at eclipse startup should be implemented here and
 * called in early startup.
 *
 */
public class PlatformEarlyStartUpHandler implements IStartup {

	public static final String DEBUG_PROFILE_NAME = "Microei_Debug_Profile";
	public static final String RUN_PROFILE_NAME = "Microei_Run_Profile";
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	@Override
	public void earlyStartup() {
		// Create ESB mediation debug launch configuration in the EI tooling IDE
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		try {
			createESBDebugProfile(launchManager);
			createMicroIntegratorRunProfile(launchManager);
		} catch (CoreException e) {
			log.error("Exception occured while creating micro-integrator debug profile", e);
		}

        // The following section will remove the unwanted
        Display.getDefault().asyncExec(new Runnable() {
            public void run() {

                try {
                    @SuppressWarnings("restriction")
                    WorkbenchWindow workbenchWin = (WorkbenchWindow) PlatformUI.getWorkbench()
                            .getActiveWorkbenchWindow();
                    @SuppressWarnings("restriction")
                    MenuManager menuManager = workbenchWin.getMenuManager();
                    IContributionItem[] items = menuManager.getItems();

                    // The following code will delete selected entries under the Help menu
                    for (int i = 0; i < items.length; i++) {
                        if (items[i] instanceof IMenuManager) {
                            IMenuManager submenu = (IMenuManager) items[i];
                            // This removes Welcome
                            IContributionItem welcomeItem = submenu.find("intro");
                            if (welcomeItem != null) {
                                submenu.remove(welcomeItem);
                            }
                            // This removes Install New Software
                            IContributionItem installNewSoftwareItem = submenu
                                    .find("org.eclipse.equinox.p2.ui.sdk.install");
                            if (installNewSoftwareItem != null) {
                                submenu.remove(installNewSoftwareItem);
                            }
                            // This removes Update
                            IContributionItem updateItem = submenu.find("org.eclipse.equinox.p2.ui.sdk.update");
                            if (updateItem != null) {
                                submenu.remove(updateItem);
                            }
                            // This removes Update
                            IContributionItem v8CrhomeRunItem = submenu.find(
                                    "org.eclipse.wst.jsdt.chromium.debug.ui.actions.AddExceptionBreakpointAction");
                            if (v8CrhomeRunItem != null) {
                                submenu.remove(v8CrhomeRunItem);
                            }
                        }
                    }

                    final IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                    if (workbenchWindow != null) {

                        workbenchWindow.addPerspectiveListener(new PerspectiveAdapter() {
                            @Override
                            public void perspectiveActivated(IWorkbenchPage page,
                                    IPerspectiveDescriptor perspectiveDescriptor) {
                                super.perspectiveActivated(page, perspectiveDescriptor);
                                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                                        .hideActionSet("org.eclipse.ui.externaltools.ExternalToolsSet");
                            }
                        });

                        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                                .hideActionSet("org.eclipse.ui.externaltools.ExternalToolsSet");
                    }
                } catch (Exception e) {
                    log.error(e);
                }
            }
        });
    }

	private void createESBDebugProfile(ILaunchManager launchManager) throws CoreException {
		if (findLaunchConfigurationByName(launchManager, DEBUG_PROFILE_NAME) == null) {
			ILaunchConfigurationType debugESBLaunchType = launchManager
					.getLaunchConfigurationType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.launch");
			ILaunchConfigurationWorkingCopy debugESBLaunchConfig = debugESBLaunchType.newInstance(null,
					DebugPlugin.getDefault().getLaunchManager().generateLaunchConfigurationName(DEBUG_PROFILE_NAME));
			debugESBLaunchConfig.doSave();
		}
	}
	
    private void createMicroIntegratorRunProfile(ILaunchManager launchManager) throws CoreException {
        if (findLaunchConfigurationByName(launchManager, RUN_PROFILE_NAME) == null) {
            ILaunchConfigurationType debugESBLaunchType = launchManager
                    .getLaunchConfigurationType("org.wso2.developerstudio.eclipse.carbonserver44microei.launch");
            ILaunchConfigurationWorkingCopy debugESBLaunchConfig = debugESBLaunchType.newInstance(null,
                    DebugPlugin.getDefault().getLaunchManager().generateLaunchConfigurationName(RUN_PROFILE_NAME));
            debugESBLaunchConfig.doSave();
        }
    }	

	public static ILaunchConfiguration findLaunchConfigurationByName(ILaunchManager launchManager, String configName)
			throws CoreException {
		ILaunchConfiguration[] availableLauchConfigs = launchManager.getLaunchConfigurations();
		for (ILaunchConfiguration iLaunchConfig : availableLauchConfigs) {
			if (configName.equals(iLaunchConfig.getName())) {
				return iLaunchConfig;
			}
		}
		return null;
	}

}

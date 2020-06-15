/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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

package org.wso2.developerstudio.eclipse.carbonserver44microei12.wizard;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.Activator;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.register.product.servers.MicroIntegratorInstance;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import net.consensys.cava.toml.Toml;
import net.consensys.cava.toml.TomlParseResult;

public class ExportDistributionAndRunAction implements IActionDelegate {

    IStructuredSelection selection;
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public void run(IAction action) {
        if (selection != null) {
            CompositeApplicationArtifactUpdateWizard wizard = new CompositeApplicationArtifactUpdateWizard();
            wizard.init(PlatformUI.getWorkbench(), selection);
            WizardDialog exportWizardDialog = new WizardDialog(
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);

            int returnCode = exportWizardDialog.open();
            if (returnCode == Window.OK) {
                // restart embedded micro-integrator profile if it is not started already
                try {
                    MicroIntegratorInstance microIntegratorInstance = MicroIntegratorInstance.getInstance();
                    boolean isHotDeploymentEnabled = true;
                    String workspace = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
                    try {
                        String serverConfigDirectoryPath = workspace + File.separator + ".metadata" + File.separator
                                + "ServerConfigs";
                        File serverConfigurationDirectory = new File(serverConfigDirectoryPath);
                        String tomlFilePath = serverConfigDirectoryPath + File.separator + "deployment.toml";
                        File customizedTomlFile = new File(tomlFilePath);
                        if (serverConfigurationDirectory.exists() && customizedTomlFile.exists()) {
                        	TomlParseResult tomlResults = Toml.parse(Paths.get(tomlFilePath));
                            Object hotDeploymentObject = tomlResults.get("server.hot_deployment");
                            if ((hotDeploymentObject instanceof String && ((String) hotDeploymentObject).equals("false"))
                                    || (hotDeploymentObject instanceof Boolean && !((Boolean) hotDeploymentObject))) {
                            	isHotDeploymentEnabled = false;
                            }

                        } else {
                        	isHotDeploymentEnabled = microIntegratorInstance.isHotDeploymentEnabled();
                        }
                    } catch (IOException e) {
                        log.error("An error occured while backup default server configurations", e);
                    }

                    if (!isHotDeploymentEnabled || !microIntegratorInstance.isServerStarted()) {
                        microIntegratorInstance.restart();
                    }
                } catch (CoreException e) {
                    log.error("Error occured while restarting the micro-integrator", e);
                }
            }
        }
    }

    public void selectionChanged(IAction action, ISelection selection) {
        if (selection instanceof IStructuredSelection) {
            this.selection = (IStructuredSelection) selection;
        }
    }
}

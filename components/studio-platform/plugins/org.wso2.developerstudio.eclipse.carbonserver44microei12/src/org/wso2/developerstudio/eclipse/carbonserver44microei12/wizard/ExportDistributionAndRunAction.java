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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.Activator;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.register.product.servers.MicroIntegratorInstance;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.util.CarbonServer44eiUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

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

                    // hasEmbeddedConfigsChanged is called before checking server status and hot
                    // deployment to update the config.properties file
                    if (CarbonServer44eiUtils.hasEmbeddedConfigsChanged() || !microIntegratorInstance.isServerStarted()
                            || !CarbonServer44eiUtils.isHotDeploymentEnabled(microIntegratorInstance)) {
                        microIntegratorInstance.restart();
                    } else {
                        new Thread(new Runnable() {
                            public void run() {
                                CarbonServer44eiUtils.updateDeployedServices();
                            }
                        }).start();
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

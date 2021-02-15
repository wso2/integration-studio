/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.integrationstudio.artifact.registry.ui.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.wso2.integrationstudio.artifact.registry.Activator;
import org.wso2.integrationstudio.artifact.registry.ui.wizard.RegistryPropertiesCreationWizard;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;

/**
 * Class responsible for running the registry properties wizard.
 */
public class RegistryPropertiesRunAction implements IActionDelegate {

    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private IStructuredSelection selection;

    /**
     * Method of running ILauncher with maven dependencies.
     */
    public void run(IAction action) {
        RegistryPropertiesCreationWizard wizard = new RegistryPropertiesCreationWizard();
        wizard.init(PlatformUI.getWorkbench(), selection);
        WizardDialog testRunWizardDialog = new WizardDialog(
                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
        testRunWizardDialog.setHelpAvailable(false);
        testRunWizardDialog.open();

    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
        if (selection instanceof IStructuredSelection) {
            this.selection = (IStructuredSelection) selection;
        }
    }
}

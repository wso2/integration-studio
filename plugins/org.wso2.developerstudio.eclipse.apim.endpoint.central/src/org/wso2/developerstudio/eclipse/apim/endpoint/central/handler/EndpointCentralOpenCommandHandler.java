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
package org.wso2.developerstudio.eclipse.apim.endpoint.central.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.wizard.EndpointCentralWizard;

/**
 * This handler class open endpoint central wizard.
 */
public class EndpointCentralOpenCommandHandler extends AbstractHandler{

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        EndpointCentralWizard wizard = new EndpointCentralWizard();
        wizard.init(PlatformUI.getWorkbench(), null);
        WizardDialog exportWizardDialog = new WizardDialog(
                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
        exportWizardDialog.open();
        return null;
    }
}

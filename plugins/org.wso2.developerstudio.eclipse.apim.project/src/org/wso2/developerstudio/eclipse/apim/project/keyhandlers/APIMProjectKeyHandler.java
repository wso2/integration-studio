/*
 * Copyright 2020 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.apim.project.keyhandlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.eclipse.ui.wizards.IWizardRegistry;
import org.wso2.developerstudio.eclipse.apim.project.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class APIMProjectKeyHandler extends AbstractHandler {

	protected final IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String ERROR_MESSAGE = "Cannot open wizard, core exception";
	private static final String APIM_PROJECT_WIZARD = "org.wso2.developerstudio.eclipse.apim.neweapimproject";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		openWizard();
		return null;
	}

	/**
	 * Opens the APIM project wizard.
	 */
	private void openWizard() {
		IWizardRegistry registry = PlatformUI.getWorkbench().getNewWizardRegistry();
		registry.getPrimaryWizards().toString();
		IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(APIM_PROJECT_WIZARD);
		try {
			if (descriptor != null) {
				IWorkbenchWizard wizard = descriptor.createWizard();
				wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
				WizardDialog wd = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						wizard);
				wd.setTitle(wizard.getWindowTitle());
				wd.open();
			}
		} catch (CoreException e) {
			log.error(ERROR_MESSAGE, e);
		}
	}
}

/*
 * Copyright 2016 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.esb.project.keyhandlers;

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
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.esb.project.Activator;

public class ESBProjectKeyHandler extends AbstractHandler {
	
	protected final IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	private static final String NEW_ESB_CONFIG_PROJECT_COMMAND = "developerstudio.commands.new.esbConfigProject";
	private static final String NEW_ESB_SOLUTION_PROJECT_COMMAND ="developerstudio.commands.new.esbSolutionProject";
	private static final String NEW_MMM_PROJECT_COMMAND = "developerstudio.commands.new.mavenMultiModuleProject";
	private static final String ESB_CONFIG_WIZARD = "org.wso2.developerstudio.eclipse.artifact.newesbproject";
	private static final String ESB_SOLUTION_WIZARD="org.wso2.developerstudio.eclipse.artifact.newesbsolutionproject";
	private static final String MMM_WIZARD = "org.wso2.developerstudio.eclipse.platform.ui.mvn.wizard.MvnMultiModuleWizard";
	private static final String ERROR_MESSAGE = "Cannot open wizard, core exception";
	 
		@Override
		public Object execute(ExecutionEvent event) throws ExecutionException {
			//If the command id is equal then open the ESB config project wizard
			if (NEW_ESB_CONFIG_PROJECT_COMMAND.equals(event.getCommand().getId())) {
				openWizard(ESB_CONFIG_WIZARD);
			}if(NEW_ESB_SOLUTION_PROJECT_COMMAND.equals(event.getCommand().getId())){
				openWizard(ESB_SOLUTION_WIZARD);
			}
			if (NEW_MMM_PROJECT_COMMAND.equals(event.getCommand().getId())) {
			    openWizard(MMM_WIZARD);
			}
			return null;
		}
		
		/**
		 * Opens the ESB config project wizard
		 * @param id esb project id
		 */
		private void openWizard(String id) {
			IWizardRegistry registry = PlatformUI.getWorkbench().getNewWizardRegistry();
			registry.getPrimaryWizards().toString();
			IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(id);
			try {
				if (descriptor != null) {
					IWorkbenchWizard wizard = descriptor.createWizard();
					wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
					WizardDialog wd = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
					wd.setTitle(wizard.getWindowTitle());
					wd.open();
				}
			} catch (CoreException e) {
				log.error(ERROR_MESSAGE, e);
			}
		}
}


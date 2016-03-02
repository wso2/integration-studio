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

package org.wso2.developerstudio.eclipse.artifact.connector.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.artifact.connector.Activator;
import org.wso2.developerstudio.eclipse.artifact.connector.ui.wizard.AddRemoveConnectorWizard;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class AddRemoveConnectorMenuHandler extends AbstractHandler {

	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {
		Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		WizardDialog dialog = null;
		try {
			dialog = new WizardDialog(activeShell, new AddRemoveConnectorWizard());
		} catch (Exception e) {
			dialog = null;
			log.error("Error reading from project", e);
			IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage()); 
			ErrorDialog.openError(activeShell, "Error", "Error reading from project", editorStatus);
		}
		if (dialog != null) {
			dialog.open(); 
		}
		return null;
	}
}

/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.registry.manager.local.checkout.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.manager.local.Activator;
import org.wso2.developerstudio.eclipse.registry.manager.local.decorators.RegistryResourceDecorator;
import org.wso2.developerstudio.eclipse.registry.manager.local.utils.RegistryCheckInClientUtils;

public class ConflictResolveUsingServerAction extends ConflictAction {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * execute resolve conflict server action on file
	 */
	protected void execute(IFile file, IAction action) {
		if (!MessageDialog.openQuestion(Display.getCurrent().getActiveShell(),
										"Resolve Conflict",
										"You are about to resolve the conflict using the "+ 
										"server version of the resource '" +
										file.getName()+
										"'. Your local changes will be overwritten. "+ 
										"Do you wish to continue?")){
			return;
		}
		String conflictResourceServerCopy = RegistryCheckInClientUtils.getConflictResourceServerCopy(
																	file.getLocation().toOSString());
		IFile conflictFile = file.getWorkspace().getRoot().getFileForLocation(
																new Path(conflictResourceServerCopy));
		try {
			file.delete(true, new NullProgressMonitor());
			conflictFile.copy(file.getFullPath(), true,new NullProgressMonitor());
			conflictFile.delete(true, new NullProgressMonitor());
			String conflictResourceLocalCopy = RegistryCheckInClientUtils
									 .getConflictResourceLocalCopy(file.getLocation().toOSString());
			conflictFile = file.getWorkspace().getRoot().getFileForLocation(
																new Path(conflictResourceLocalCopy));
			conflictFile.delete(true, new NullProgressMonitor());
			RegistryResourceDecorator.refreshProjectResource(file.getProject());
		} catch (Exception e) {
			log.error(e);
		}
	}

}

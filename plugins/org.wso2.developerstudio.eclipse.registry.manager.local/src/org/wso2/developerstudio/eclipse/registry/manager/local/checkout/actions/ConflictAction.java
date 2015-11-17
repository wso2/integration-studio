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
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPart;
import org.wso2.developerstudio.eclipse.registry.manager.local.utils.RegistryCheckInClientUtils;

public abstract class ConflictAction extends BaseRegistryAction {

	public void setActivePart(IAction arg0, IWorkbenchPart arg1) {

	}

	/**
	 * execute File
	 */
	protected void executeFile(IFile file, IAction action) {
		execute(file, action);
	}

	/**
	 *execute Folder 
	 */
	protected void executeFolder(IFolder folder, IAction action) {
	}

	/**
	 * execute Resource
	 */
	protected void executeResource(IResource resource, IAction action) {
	}

	/**
	 * selected File
	 */
	protected void selectedFile(IFile file, IAction action) {
		action.setEnabled(RegistryCheckInClientUtils.getResourceState(
					file.getLocation().toOSString()) == RegistryCheckInClientUtils.RESOURCE_STATE_CONFLICT);
	}

	/**
	 * selected folder
	 */
	protected void selectedFolder(IFolder folder, IAction action) {
		action.setEnabled(false);
	}

	/**
	 * selected resource
	 */
	protected void selectedResource(IResource resource, IAction action) {
	}

	/**
	 * execute action
	 * @param file
	 * @param action
	 */
	protected abstract void execute(IFile file, IAction action);
}

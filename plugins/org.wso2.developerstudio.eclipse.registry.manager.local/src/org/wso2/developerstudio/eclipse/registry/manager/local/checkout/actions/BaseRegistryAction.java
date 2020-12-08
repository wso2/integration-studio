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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.SWTControlUtils;


public abstract class BaseRegistryAction implements IObjectActionDelegate {
	private Object selection;
	
	public void setActivePart(IAction arg0, IWorkbenchPart arg1) {

	}

	/**
	 * run method
	 * call different execute methods checking whether a file or folder
	 */
	public void run(IAction action) {
		Object selections = SWTControlUtils.deriveSelection(action);
		if (selections!=null && (selections instanceof IResource)) {
			IResource resource = (IResource) selections;
			executeResource(resource, action);
			if (resource instanceof IFolder){
				executeFolder((IFolder)resource, action);
			}
			else if (resource instanceof IFile){
				executeFile((IFile)resource, action);
			}
		}
	}
	

	/***
	 * selection changed
	 */
	public void selectionChanged(IAction action, ISelection arg1) {
		setSelection(arg1);
		Object selections = SWTControlUtils.deriveSelection(arg1);
		if (selections!=null && (selections instanceof IResource)) {
			IResource resource = (IResource) selections;
			selectedResource(resource, action);
			if (resource instanceof IFolder){
				selectedFolder((IFolder)resource, action);
			}
			else if (resource instanceof IFile){
				selectedFile((IFile)resource, action);
			}
		}
	}
	
	protected abstract void selectedResource(IResource resource,IAction action);
	protected abstract void selectedFolder(IFolder folder,IAction action);
	protected abstract void selectedFile(IFile file,IAction action);
	protected abstract void executeResource(IResource resource,IAction action);
	protected abstract void executeFile(IFile file,IAction action);
	protected abstract void executeFolder(IFolder folder,IAction action);

	/**
	 * set selection
	 * @param selection
	 */
	public void setSelection(Object selection) {
		this.selection = selection;
	}

	/**
	 * get selection
	 * @return
	 */
	public Object getSelection() {
		return selection;
	}


}

/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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


package org.wso2.developerstudio.esb.forgm.editors.article;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.*;
/**
 * @see IWorkbenchWindowActionDelegate
 */
public abstract class OpenFormEditorAction
		implements
			IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
/*
 * 
 */
	protected void openEditor(String inputName, String editorId) {
		openEditor(new FormEditorInput(inputName), editorId);
	}
	protected void openEditor(IEditorInput input, String editorId) {
		IWorkbenchPage page = window.getActivePage();
		try {
			page.openEditor(input, editorId);
		} catch (PartInitException e) {
			System.out.println(e);
		}
	}
	
	protected IWorkbenchWindow getWindow() {
		return window;
	}
	/**
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}
	/**
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}
	/**
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}

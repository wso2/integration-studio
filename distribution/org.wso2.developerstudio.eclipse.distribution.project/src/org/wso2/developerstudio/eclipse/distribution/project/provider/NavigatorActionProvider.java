/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.distribution.project.provider;


import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.distribution.project.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;


public class NavigatorActionProvider extends CommonActionProvider {
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);	
	private OpenEditorAction openEditorAction;
	String compositeAppNatureId = "org.wso2.developerstudio.eclipse.distribution.project.nature";
	
	@Override
	public void fillActionBars(IActionBars actionBars) {
		IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();
		if (selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) selection;
			Object firstElement = treeSelection.getFirstElement();
			if (firstElement instanceof IFile) {
				IFile file = (IFile) firstElement;
				
				try {
					if (file.getProject().getDescription().hasNature(compositeAppNatureId)) {
						openEditorAction.setSelection(file);
						actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, openEditorAction);
					}
					
				} catch (CoreException e) {
					/* ignore */
				}
			}
		}
	}

	@Override
	public void init(ICommonActionExtensionSite aSite) {
		super.init(aSite);
		openEditorAction = new OpenEditorAction();
	}

	private static class OpenEditorAction extends Action {

		private static final String DEVS_DISTRIBUTION_PROJECT_EDITOR = "org.wso2.developerstudio.eclipse.distribution.project.editor.DistProjectEditor";
		private IFile selection;

		@Override
		public void run() {
			IFile fileTobeOpen = null;
			String diagramFilePath = selection.getFullPath().toOSString();
			
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();

			try {
				if (selection.getWorkspace().getRoot().getFile(new Path(diagramFilePath)).exists()) {
					fileTobeOpen = selection.getWorkspace().getRoot().getFile(new Path(diagramFilePath));
					page.openEditor(new FileEditorInput(fileTobeOpen),DEVS_DISTRIBUTION_PROJECT_EDITOR);
				}
			}catch (Exception e) {
				log.error("Can't open " + fileTobeOpen, e);
			}
		}

		public void setSelection(IFile selection) {
			this.selection = selection;
		}
	}
}

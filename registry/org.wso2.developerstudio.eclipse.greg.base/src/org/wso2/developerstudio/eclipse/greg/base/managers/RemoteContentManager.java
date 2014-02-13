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

package org.wso2.developerstudio.eclipse.greg.base.managers;

import java.io.File;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.greg.base.Activator;
import org.wso2.developerstudio.eclipse.greg.base.editor.input.ResourceEditorInput;
import org.wso2.developerstudio.eclipse.greg.base.logger.ExceptionHandler;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.greg.base.ui.editor.RegistryResourceEditor;
import org.wso2.developerstudio.eclipse.greg.base.util.EditorConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class RemoteContentManager {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);


	/**
	 * get the editor input
	 * @param r - RegistryResourceNode
	 * @param isParent
	 * @return
	 */
	public static ResourceEditorInput getEditorInput(RegistryResourceNode r, 
													boolean isParent) {
		//if RegistryResourceNode is a collection
		if (isParent) {
			ResourceEditorInput resourceEditorInput = new ResourceEditorInput();
			resourceEditorInput.setParentResource(r);
			return resourceEditorInput;
		} else {
			if (r.getEditorInput() == null) {
				r.setEditorInput(new ResourceEditorInput());
				r.getEditorInput().setResource(r);
			}
			return r.getEditorInput();
		}
	}

	/**
	 * 
	 * @param r
	 * @return
	 */
	public static ResourceEditorInput getEditorInput(RegistryResourceNode r) {
		return getEditorInput(r, false);
	}

	/**
	 * open form editor according to the editor input
	 * @param editorInput
	 * @return
	 */
	public static RegistryResourceEditor openFormEditor(IEditorInput editorInput) {
		IWorkbenchPage activePage = PlatformUI.getWorkbench()
									.getActiveWorkbenchWindow().getActivePage();
		try {
			IEditorPart openEditor = IDE.openEditor(activePage, 
													editorInput,
													EditorConstants.FORM_EDITOR_ID, 
													true);
			return (RegistryResourceEditor) openEditor;
		} catch (PartInitException e) {
			log.error(e);
		}
		return null;
	}

	/**
	 * open file in the relavent editor according to the content of the file
	 * @param fileToOpen
	 * @return
	 */
	public static IEditorPart openFile(File fileToOpen) {
		ExceptionHandler exeptionHandler = new ExceptionHandler();
		if (fileToOpen.exists() && fileToOpen.isFile()) {
			IFileStore fileStore = EFS.getLocalFileSystem().getStore(fileToOpen.toURI());
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			try {
				return IDE.openEditorOnFileStore(page, fileStore);
			} catch (PartInitException e) {
				exeptionHandler.showMessage(Display.getCurrent().getActiveShell(),
											"Could not open the file type in the editor");
			} catch (Exception e) {
				exeptionHandler.showMessage(Display.getCurrent().getActiveShell(),
											"Could not open the file type in the editor");
			}
		} else {
			// Do something if the file does not exist
		}
		return null;
	}
}

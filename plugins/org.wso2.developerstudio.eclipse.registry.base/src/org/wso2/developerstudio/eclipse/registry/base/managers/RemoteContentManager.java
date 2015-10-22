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

package org.wso2.developerstudio.eclipse.registry.base.managers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
//import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.developerstudio.eclipse.platform.ui.startup.ESBGraphicalEditor;
import org.wso2.developerstudio.eclipse.platform.ui.utils.UnrecogizedArtifactTypeException;
import org.wso2.developerstudio.eclipse.registry.base.Activator;
import org.wso2.developerstudio.eclipse.registry.base.editor.input.ResourceEditorInput;
import org.wso2.developerstudio.eclipse.registry.base.logger.ExceptionHandler;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.ui.editor.RegistryResourceEditor;
import org.wso2.developerstudio.eclipse.registry.base.util.EditorConstants;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;



public class RemoteContentManager {
	public static final String APIM_TEM_FILES = "apimTemFiles";
	public static final String ESB_REMOTE_TEMP_PROJECT_NATURE = "org.wso2.developerstudio.esb.remoteTempNature";
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
    private static IFile workspaceFIle;

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
	 * open file in the relevant editor according to the content of the file
	 * @param fileToOpen
	 * @return
	 */
	public static IEditorPart openFile(File fileToOpen) {
		ExceptionHandler exeptionHandler = new ExceptionHandler();
		if (fileToOpen.exists() && fileToOpen.isFile()) {

			IFileStore fileStore = EFS.getLocalFileSystem().getStore(fileToOpen.toURI());
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			try {	
				
				String parentFileName = fileToOpen.getParentFile().getName();
				IPath projLocation = new org.eclipse.core.runtime.Path(fileToOpen.getPath());
				String projPath = projLocation.removeLastSegments(2).toOSString() + File.separator + parentFileName;
				
				/*Adding dot character to start the project name to hide it in the project explorer since this is a temp project  */
				String tempProjectName = "."+ parentFileName;
				IWorkspace ws = ResourcesPlugin.getWorkspace();
			   
				IProject project = ws.getRoot().getProject(tempProjectName);
				IProjectDescription description = ws.newProjectDescription(tempProjectName);				
				String[] naturesIds = new String[] { ESB_REMOTE_TEMP_PROJECT_NATURE };
				description.setNatureIds(naturesIds);
				description.setLocation(new org.eclipse.core.runtime.Path(projPath));
				if (!project.exists()) {
					project.create(description, IProject.FORCE, new NullProgressMonitor());
				}
				if (!project.isOpen()) {
					project.open(new NullProgressMonitor());
				}
				
				IFile workspaceFile = project.getFile(fileToOpen.getName());

				
				String source = FileUtils.getContentAsString(fileToOpen);
				InputStream is = new ByteArrayInputStream(source.getBytes());
                if(workspaceFile.exists()){
                	workspaceFile.setContents(is, IFile.FORCE, new NullProgressMonitor());
                }else{
                	workspaceFile.create(is, true, new NullProgressMonitor());
                }
			    is.close();
				Openable openable = ESBGraphicalEditor.getOpenable();
				///ArtifactType artifactType = (ArtifactType) openable.artifactTypeResolver(source);
				
				IEditorPart editorOpen = openable.editorOpen(null,source,workspaceFile);
				setWorkspaceFile(workspaceFile);
				return editorOpen;

			} catch (UnrecogizedArtifactTypeException e) {
				try {
					log.warn("Not an ESB artifact");
					return IDE.openEditorOnFileStore(page, fileStore);
				} catch (PartInitException e1) {
					log.error("Non ESB artifact coudn't open"+e.getMessage(),e);
					exeptionHandler.showMessage(Display.getCurrent().getActiveShell(),
							"Could not open the file type in the editor");
				}

			} catch (Exception e) {
				log.error("ESB artifact coudn't open"+e.getMessage(),e);
				exeptionHandler.showMessage(Display.getCurrent().getActiveShell(),
						"Could not open the file type in the editor");
			}
		} else {
			exeptionHandler.showMessage(Display.getCurrent().getActiveShell(),
					"File cannot be open");
		}
		return null;
	}

	public static IFile getWorkspaceFile() {
		return workspaceFIle;
	}

	public static void setWorkspaceFile(IFile fullpath) {
		RemoteContentManager.workspaceFIle = fullpath;
	}

}

/*
 * Copyright 2013 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;


public class MessageProcessorMesageStorePropertyDescriptor extends DevSProjectArtifactsListPropertyDescriptor{
	
	protected static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	public MessageProcessorMesageStorePropertyDescriptor(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		super(object, itemPropertyDescriptor);
	}
	
	@Override
	protected ArrayList<String> getAvailableArtifactListFromProject(Composite parent) {
		
		String synapseArtifcatCategory = "synapse/message-store";
		String comboBoxDefaultValue = "Select From Message Stores";
		ArrayList<String> availableList = new ArrayList<String>();	
		availableList.add(comboBoxDefaultValue);
		File projectPath = null;
		final Shell shell=(Shell)parent.getShell();
		final IEditorPart editor=(IEditorPart) ((WorkbenchWindow)shell.getDisplay().getActiveShell().getData()).getActivePage().getActiveEditor();
		if (editor != null) {
			//IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
			//IFile file = input.getFile();
			//IProject workspaceProject = file.getProject();
						
			//Fixing TOOLS-2322
			IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
			for (IProject workspaceProject : projects) {			
				try {
					if (workspaceProject.hasNature("org.wso2.developerstudio.eclipse.esb.project.nature")) {
						ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
						projectPath = workspaceProject.getLocation().toFile();
						try {
							esbProjectArtifact.fromFile(workspaceProject.getFile("artifact.xml").getLocation().toFile());
							List<ESBArtifact> allESBArtifacts = esbProjectArtifact.getAllESBArtifacts();
							for (ESBArtifact esbArtifact : allESBArtifacts) {
							if (synapseArtifcatCategory.equals(esbArtifact.getType())) {
									File artifact = new File(projectPath, esbArtifact.getFile());
									availableList.add(artifact.getName().replaceAll("[.]xml$", ""));
								}
							}
						} catch (Exception e) {
							log.error("Error occured while scanning the project for " + synapseArtifcatCategory + " artifacts", e);
							ErrorDialog.openError(shell,"Error occured while scanning the project for " + synapseArtifcatCategory + " artifacts", e.getMessage(), null);
						}
					}
				} catch (CoreException e) {
					log.error("Error occured while scanning the project", e);
					ErrorDialog.openError(shell, "Error occured while scanning the project", e.getMessage(), null);
				}
			}
		}
		return availableList;
	}

}



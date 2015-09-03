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

package org.wso2.developerstudio.eclipse.artifact.cep.ui.wizard;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.wso2.developerstudio.eclipse.artifact.cep.model.CEPModel;
import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPImageUtils;
import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPProjectArtifact;
import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPProjectUtils;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class CEPProjectCreationWizard extends AbstractWSO2ProjectCreationWizard {
	private static final String CEP_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.artifact.cep.project.nature";
	private CEPModel cepProjectModel;
	private static final String CEP_WIZARD_WINDOW_TITLE = "New Analytic Project";
	private IProject project;
	//private File openFile = null;
	private File pomfile;
	private Map<File,String> fileList = new HashMap<File,String>();	

	public CEPProjectCreationWizard() {
		this.cepProjectModel = new CEPModel();
		setModel(this.cepProjectModel);
		setWindowTitle(CEP_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(CEPImageUtils.getInstance()
				.getImageDescriptor("analytics-64x64.png"));
	}

	public boolean performFinish() {
		
		try {
			Map<File,String> cepArtiList = new HashMap<File,String>();	 
			if (cepProjectModel.getSelectedOption().equals("import.cepproject")) {
				cepArtiList = CEPProjectUtils.cepProjectFolderContentProcessing(cepProjectModel.getCepProjectLocation().getPath());
			}
			project = createNewProject();
			pomfile = project.getFile("pom.xml").getLocation().toFile();
			createPOM(pomfile,"pom");
			ProjectUtils.addNatureToProject(project,
											false,
			                                CEP_PROJECT_NATURE);
			MavenUtils
			.updateWithMavenEclipsePlugin(
					pomfile,
					new String[] { },
					new String[] { CEP_PROJECT_NATURE });
			
			//Creating the metadata file artifact.xml while creating the CEP project. It will be hidden and users won't be able to see it via Eclipse.
			CEPProjectArtifact artifact=new CEPProjectArtifact();
			IFile file = project.getFile("artifact.xml");
			artifact.setSource(file.getLocation().toFile());
			artifact.toFile();
			getModel().addToWorkingSet(project);
			//Refresh the project to show the changes. But still won't see the newly created project.
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			refreshDistProjects();
			//Setting the created file to be hidden so that users won't see it.
			if(file.exists()){
				file.setHidden(true);
			}
			String groupId = getMavenGroupId(pomfile);
			if (cepProjectModel.getSelectedOption().equals("new.cepproject")) {				
				CEPProjectUtils.updatePom(project);
				project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				refreshDistProjects();
			}else if(cepProjectModel.getSelectedOption().equals("import.cepproject")){
				CEPProjectUtils.createCEPArtifacts(cepArtiList,project,pomfile,fileList,groupId);
				
				CEPProjectUtils.updatePom(project);
				project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				refreshDistProjects();
				if (!fileList.isEmpty()) {
		            if (MessageDialog.openQuestion(getShell(), "Open file(s) in the Editor",
		                                           "Do you like to open the file(s) in Developer Studio?")) {
			            for (File artifactFile : fileList.keySet()) {
			            	super.openEditor(artifactFile);
			            }
		            }
	            }
			}
		}catch (Exception e) {
			MessageDialog.openError(getShell(), "Error while creating the project",
                    e.getMessage());
			return false;

		}
	return true;
	}
		

		public CEPModel getCepProjectModel() {
			return cepProjectModel;
		}

		public void setCepProjectModel(CEPModel cepProjectModel) {
			this.cepProjectModel = cepProjectModel;
		}
		
		public IResource getCreatedResource() {
			return project;
		}
		
		public void setCurrentSelection(ISelection currentSelection) {
			// TODO Auto-generated method stub
			super.setCurrentSelection(currentSelection);
		}		
		
}

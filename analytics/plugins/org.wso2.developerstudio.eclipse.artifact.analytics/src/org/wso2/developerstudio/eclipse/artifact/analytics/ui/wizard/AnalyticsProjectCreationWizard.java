/*
*  Copyright (c) 2005-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.developerstudio.eclipse.artifact.analytics.ui.wizard;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.wso2.developerstudio.eclipse.artifact.analytics.model.AnalyticsModel;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsEntryTypes;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsImageUtils;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsProjectArtifactCreator;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsProjectUtils;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsConstants;

public class AnalyticsProjectCreationWizard extends AbstractWSO2ProjectCreationWizard {
	private AnalyticsModel analyticsProjectModel;
	private IProject analyticsProject;
	private File pomfile;
	private Map<File,AnalyticsEntryTypes> artifactList = new HashMap<File,AnalyticsEntryTypes>();//TODO: add as enum 

	public AnalyticsProjectCreationWizard() {
		this.analyticsProjectModel = new AnalyticsModel();
		setModel(this.analyticsProjectModel);
		setWindowTitle(AnalyticsConstants.WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(AnalyticsImageUtils.getInstance()
				.getImageDescriptor("analytics-64x64.png"));
	}

	public boolean performFinish() {
		
		try { 
			analyticsProject = createNewProject();
			pomfile = analyticsProject.getFile("pom.xml").getLocation().toFile();
			createPOM(pomfile,"pom");
			ProjectUtils.addNatureToProject(analyticsProject,false,AnalyticsConstants.ANALYTICS_PROJECT_NATURE);
			MavenUtils.updateWithMavenEclipsePlugin(pomfile,new String[] { },new String[] {AnalyticsConstants.ANALYTICS_PROJECT_NATURE });
			
			//Creating the metadata file artifact.xml while creating the Analytics project. 
			//It will be hidden and users won't be able to see it via Eclipse.
			AnalyticsProjectArtifactCreator artifact=new AnalyticsProjectArtifactCreator();
			IFile aritifactFile = analyticsProject.getFile("artifact.xml");
			artifact.setArtifactFile(aritifactFile.getLocation().toFile());
			artifact.toFile();
			getModel().addToWorkingSet(analyticsProject);
			
			//Refresh the project to show the changes. But still won't see the newly created project.
			analyticsProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			refreshDistProjects();
			
			//Setting the created file to be hidden so that users won't see it.
			if(aritifactFile.exists()){
				aritifactFile.setHidden(true);
			}
			String groupId = getMavenGroupId(pomfile);
			if (analyticsProjectModel.getSelectedOption().equals(AnalyticsConstants.WIZARD_OPTION_NEW_ANALYTICS_PROJECT)) {				
				analyticsProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				refreshDistProjects();
			}else if(analyticsProjectModel.getSelectedOption().equals(AnalyticsConstants.WIZARD_OPTION_IMPORT_ANALYTICS_PROJECT)){
				Map<File,AnalyticsEntryTypes> selectedArtifactList = new HashMap<File,AnalyticsEntryTypes>();
				selectedArtifactList = AnalyticsProjectUtils.deploymentServerContentProcessing(analyticsProjectModel.getAnalyticsProjectLocation().getPath());
				AnalyticsProjectUtils.createAnalyticsArtifacts(selectedArtifactList,analyticsProject,pomfile,artifactList,groupId);
				analyticsProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				refreshDistProjects();
				if (!artifactList.isEmpty()) {
		            if (MessageDialog.openQuestion(getShell(), "Open file(s) in the Editor",
		                                           "Do you like to open the file(s) in Developer Studio?")) {
			            for (File artifactFromList : artifactList.keySet()) {
			            	super.openEditor(artifactFromList);
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
		
	public AnalyticsModel getAnalyticsProjectModel() {
		return analyticsProjectModel;
	}

	public void setCepProjectModel(AnalyticsModel cepProjectModel) {
		this.analyticsProjectModel = cepProjectModel;
	}
		
	public IResource getCreatedResource() {
		return analyticsProject;
	}

}

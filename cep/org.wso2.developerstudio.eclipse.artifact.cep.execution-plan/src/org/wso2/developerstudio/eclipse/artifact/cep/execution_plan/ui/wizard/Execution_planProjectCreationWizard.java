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

package org.wso2.developerstudio.eclipse.artifact.cep.execution_plan.ui.wizard;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.model.Repository;
import org.apache.maven.model.RepositoryPolicy;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.artifact.cep.execution_plan.Activator;
import org.wso2.developerstudio.eclipse.artifact.cep.execution_plan.model.Execution_planModel;
import org.wso2.developerstudio.eclipse.artifact.cep.execution_plan.utils.Execution_PlanImageUtils;
import org.wso2.developerstudio.eclipse.artifact.cep.execution_plan.validators.Execution_planProjectFilter;
import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPArtifact;
import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPProjectArtifact;
import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPTemplateUtils;
import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;


public class Execution_planProjectCreationWizard extends AbstractWSO2ProjectCreationWizard {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private Execution_planModel rModel;
	private static final String CEP_RECEIVER_WIZARD_WINDOW_TITLE = "New Execution-plan Artifact";
	private CEPProjectArtifact cepProjectArtifact;
	private List<File> fileList = new ArrayList<File>();
	private IProject project;
	
	private String version="1.0.0";
	
	public void setProject(IProject project) {
		this.project = project;
	}
	
	public void setModel(ProjectDataModel model) {
		super.setModel(model);
	}

	public Execution_planProjectCreationWizard() {
		this.rModel = new Execution_planModel();
		setModel(this.rModel);
		setWindowTitle(CEP_RECEIVER_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(Execution_PlanImageUtils.getInstance()
				.getImageDescriptor("execution_plan-64x64.png"));
	}

	public boolean performFinish() {
		try {
			rModel = (Execution_planModel) getModel();
			project = rModel.getExecution_planSaveLocation().getProject();
			
			if(!createExecution_planArtifact(project,rModel)){
					return false;
			}
			
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			if(fileList.size()>0){
				openEditor(fileList.get(0));
			}
			
			
		} catch (CoreException e) {
			log.error("CoreException has occurred", e);
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}
		return true;
	}
		
	public void openEditor(File file){
		try {
				
				IFile dbsFile  = ResourcesPlugin
				.getWorkspace()
				.getRoot()
				.getFileForLocation(
				Path.fromOSString(file.getAbsolutePath()));
				IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),dbsFile);

			} catch (Exception e) { 
				log.error("cannot open editor",e);
			}
		}
	
	@Override
	public boolean performCancel() {
		Execution_planProjectFilter.setShowGeneralProjects(false);
		return super.performCancel();
	}
	
	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
		return super.getPreviousPage(page);
	}
	
	public void updatePom() throws Exception{
		File mavenProjectPomLocation = project.getFile("pom.xml").getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		
		boolean pluginExists = MavenUtils.checkOldPluginEntry(mavenProject,
				"org.wso2.maven", "wso2-cep-execution-plan-plugin",
				MavenConstants.WSO2_CEP_EXECUTIONPLAN_VERSION);
		if(pluginExists){
			return ;
		}
		
		Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-cep-execution-plan-plugin", MavenConstants.WSO2_CEP_EXECUTIONPLAN_VERSION, true);
		
		PluginExecution pluginExecution = new PluginExecution();
		pluginExecution.addGoal("pom-gen");
		pluginExecution.setPhase("process-resources");
		pluginExecution.setId("execution-plan-point");
		
		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
		Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
		artifactLocationNode.setValue(".");
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
		typeListNode.setValue("${artifact.types}");
		pluginExecution.setConfiguration(configurationNode);
		
		plugin.addExecution(pluginExecution);
		Repository repo = new Repository();
		repo.setUrl("http://maven.wso2.org/nexus/content/groups/wso2-public/");
		repo.setId("wso2-nexus");
		
		RepositoryPolicy releasePolicy=new RepositoryPolicy();
		releasePolicy.setEnabled(true);
		releasePolicy.setUpdatePolicy("daily");
		releasePolicy.setChecksumPolicy("ignore");
		
		repo.setReleases(releasePolicy);
		
		if (!mavenProject.getRepositories().contains(repo)) {
	        mavenProject.getModel().addRepository(repo);
	        mavenProject.getModel().addPluginRepository(repo);
        }

		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}
	
	
	public boolean createExecution_planArtifact(IProject prj,Execution_planModel rModel) throws Exception {
        boolean isNewArtifact =true;
        IContainer location = project.getFolder("src" + File.separator + "main" + File.separator
				+ "execution-plan");

		// Adding the metadata about the sequence to the metadata store.
		cepProjectArtifact = new CEPProjectArtifact();
		cepProjectArtifact.fromFile(project.getFile("artifact.xml")
				.getLocation().toFile());
		
		File pomfile = project.getFile("pom.xml").getLocation().toFile();
		getModel().getMavenInfo().setPackageName("execution-plan");
		if (!pomfile.exists()) {
			createPOM(pomfile);
		}

		updatePom();
		project.refreshLocal(IResource.DEPTH_INFINITE,
				new NullProgressMonitor());
		String groupId = getMavenGroupId(pomfile);
		groupId += ".execution-plan";

		if (getModel().getSelectedOption().equals("import.execution-plan")) {
			IFile execution_plan = location.getFile(new Path(getModel().getImportFile().getName()));
			if(execution_plan.exists()){
				if(!MessageDialog.openQuestion(getShell(), "WARNING", "Do you like to override exsiting project in the workspace")){
					return false;	
				}
				isNewArtifact = false;
			} 	
			copyImportFile(location,isNewArtifact,groupId);
		} else {
			File cepTemplateFile = new CEPTemplateUtils().getResourceFile("templates" + File.separator
					+ "execution_plan.siddhiql");
			String templateContent = FileUtils.getContentAsString(cepTemplateFile);
			String content = templateContent.replaceAll("<execution-plan.name>", rModel.getExecution_planName());
			File destFile = new File(location.getLocation().toFile(),
					rModel.getExecution_planName() + ".siddhiql");
			FileUtils.createFile(destFile, content);
			fileList.add(destFile);
			
			
			
			CEPArtifact artifact = new CEPArtifact();
			artifact.setName(rModel.getExecution_planName());
			artifact.setVersion(version);
			artifact.setType("event/execution-plan");
			artifact.setServerRole("ComplexEventProcessor");
			artifact.setGroupId(groupId);
			artifact.setFile(FileUtils.getRelativePath(project.getLocation()
					.toFile(), new File(location.getLocation().toFile(),
					rModel.getExecution_planName() + ".siddhiql")).replaceAll(Pattern.quote(File.separator), "/"));
			cepProjectArtifact.addCEPArtifact(artifact);
		}
		cepProjectArtifact.toFile();
		project.refreshLocal(IResource.DEPTH_INFINITE,
				new NullProgressMonitor());
		return true;
	}
	

	public void copyImportFile(IContainer importLocation,boolean isNewAritfact, String groupId) throws IOException {
		File importFile = getModel().getImportFile();
		File destFile = null;
		List<OMElement> selectedReveiverList = ((Execution_planModel)getModel()).getSelectedExecution_planList();
		if(selectedReveiverList != null && selectedReveiverList.size() >0 ){
			for (OMElement element : selectedReveiverList) {
				String name = element.getAttributeValue(new QName("name"));
				destFile = new File(importLocation.getLocation().toFile(), name + ".xml");
				FileUtils.createFile(destFile, element.toString());
				fileList.add(destFile);
				if(isNewAritfact){
					CEPArtifact artifact=new CEPArtifact();
					artifact.setName(name);
					artifact.setVersion(version);
					artifact.setType("event/execution-plan");
					artifact.setServerRole("ComplexEventProcessor");
					artifact.setGroupId(groupId);
					artifact.setFile(FileUtils.getRelativePath(importLocation.getProject().getLocation().toFile(),
							new File(importLocation.getLocation().toFile(), name + ".xml")).replaceAll(
							Pattern.quote(File.separator), "/"));
					cepProjectArtifact.addCEPArtifact(artifact);
				}
			} 
			
		}else{
			destFile = new File(importLocation.getLocation().toFile(), importFile.getName());
			FileUtils.copy(importFile, destFile);
			fileList.add(destFile);
			String name = importFile.getName().replaceAll(".xml$","");
			if(isNewAritfact){
				CEPArtifact artifact=new CEPArtifact();
				artifact.setName(name);
				artifact.setVersion(version);
				artifact.setType("event/execution-plan");
				artifact.setServerRole("ComplexEventProcessor");
				artifact.setGroupId(groupId);
				artifact.setFile(FileUtils.getRelativePath(importLocation.getProject().getLocation().toFile(),
						new File(importLocation.getLocation().toFile(), name + ".xml")).replaceAll(
						Pattern.quote(File.separator), "/"));
				cepProjectArtifact.addCEPArtifact(artifact);
			}
		}
	}
	
	
	public IResource getCreatedResource() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Execution_planModel getCepEventexecution_planProjectModel() {
		return rModel;
	}

	public void setCepProjectModel(Execution_planModel cepProjectModel) {
		this.rModel = cepProjectModel;
	}
		
		
	public void setCurrentSelection(ISelection currentSelection) {
		// TODO Auto-generated method stub
		super.setCurrentSelection(currentSelection);
	}	
			
		
		
}

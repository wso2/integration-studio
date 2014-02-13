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

package org.wso2.developerstudio.eclipse.artifact.dataservice.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.artifact.dataservice.Activator;
import org.wso2.developerstudio.eclipse.artifact.dataservice.model.DataServiceModel;
import org.wso2.developerstudio.eclipse.artifact.dataservice.utils.DataServiceImageUtils;
import org.wso2.developerstudio.eclipse.artifact.dataservice.utils.DataServiceTemplateUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.utils.XMLUtil;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.MavenDetailsPage;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.ProjectOptionsDataPage;
import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class DataServiceProjectCreationWizard extends AbstractWSO2ProjectCreationWizard {
	private static final String DS_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.ds.project.nature";
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	private final DataServiceModel dsModel;
	private static final String DS_WIZARD_WINDOW_TITLE = "Create New Data Service Project";
	private IProject project;
	private NewDataSourceWizardPage newDataSourcepage;
	private IWizardPage[] pages;

	public DataServiceProjectCreationWizard() {
		this.dsModel = new DataServiceModel();
		setModel(this.dsModel);
		setWindowTitle(DS_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(DataServiceImageUtils.getInstance().getImageDescriptor("ds-wizard.png"));
	}

	
	public boolean performFinish() {
		try {
			File openFile =null;
			if (getModel().getSelectedOption().equals("import.dsproject")) {
				IProject exproject = ResourcesPlugin.getWorkspace().getRoot().getProject(dsModel.getProjectName());
				if(exproject.exists()){
					if(!MessageDialog.openQuestion(getShell(), "WARNING", "Do you like to override exsiting project in the workspace")){
						return false;	
					}
				} 
				project = createNewProject();
				openFile = copyImportFile(project);
			}

			if (getModel().getSelectedOption().equals("new.dsproject")) {
				project = createNewProject();
				openFile = addDSTemplate(project);
			}

			File pomfile = project.getFile("pom.xml").getLocation().toFile();
			getModel().getMavenInfo().setPackageName("service/dataservice");
			createPOM(pomfile);
			ProjectUtils.addNatureToProject(project,
											false,
			                                DS_PROJECT_NATURE);
			MavenUtils
			.updateWithMavenEclipsePlugin(
					pomfile,
					new String[] {  },
					new String[] { DS_PROJECT_NATURE});
			getModel().addToWorkingSet(project);
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			try {
				refreshDistProjects();
				IFile dbsFile  = ResourcesPlugin
					.getWorkspace()
					.getRoot()
					.getFileForLocation(
						Path.fromOSString(openFile.getAbsolutePath()));
				IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),dbsFile);
			} catch (Exception e) {
				log.error("Cannot open file in editor", e);
				}
		} catch (CoreException e) {
			log.error("CoreException has occurred", e);
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}

		return true;
	}

	public File copyImportFile(IProject importProject) throws IOException {
		File importFile = getModel().getImportFile();
		IFolder dsResourceFolder =
		        ProjectUtils.getWorkspaceFolder(importProject, "src", "main", "dataservice");
		File dsResourceFile =
		        new File(dsResourceFolder.getLocation().toFile(), importFile.getName());
		FileUtils.copy(importFile, dsResourceFile);
		return dsResourceFile;
	}

	private File addDSTemplate(IProject project) throws Exception {
		String eol = System.getProperty("line.separator"); 
		ITemporaryFileTag dsTempTag = FileUtils.createNewTempTag();
		StringBuffer sb=new StringBuffer();
		File dsTemplateFile = new DataServiceTemplateUtils().getResourceFile("templates/Dataservice1.dbs");
		String templateContent = FileUtils.getContentAsString(dsTemplateFile);
		templateContent = templateContent.replaceAll("\\{", "<");
		templateContent = templateContent.replaceAll("\\}", ">");
		templateContent = templateContent.replaceAll("<service.name>", dsModel.getServiceName());
		templateContent = templateContent.replaceAll("<service.group>",dsModel.getServiceGroup());
		templateContent = templateContent.replaceAll("<service.NS>",dsModel.getServiceNS());
		templateContent = templateContent.replaceAll("<service.description>",dsModel.getServiceDescription());
		templateContent = templateContent.replaceAll("<config.id>",dsModel.getDataSourceId());
		
		LinkedHashMap<String,String> config = dsModel.getDataSourceConfig().getConfig();
		Iterator<String> iterator = config.keySet().iterator();
		    while (iterator.hasNext()) {
		      String key = (String) iterator.next();
		      sb.append("<property name=\"").append(key).append("\">").append(config.get(key)).append("</property>\n");
		    }
		templateContent = templateContent.replaceAll("<config.properties>",sb.toString());    
		
		IFolder dsfolder = project.getFolder("src/main/dataservice");
		File template = new File(dsfolder.getLocation().toFile(), dsModel.getServiceName()+ ".dbs");
		templateContent = XMLUtil.prettify(templateContent);
		templateContent = templateContent.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>","");
		templateContent = templateContent.replaceAll("^"+eol,"");
		FileUtils.createFile(template,templateContent);
		dsTempTag.clearAndEnd();
		return template;
	}

	
	public IResource getCreatedResource() {
		return project;
	}
	
	
	public void addPages() {
		newDataSourcepage = new NewDataSourceWizardPage();
		super.addPages();
		addPage(newDataSourcepage);
		pages = getPages();
	}
	
	
	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = super.getNextPage(page);
		if(page instanceof ProjectOptionsDataPage ){
				if(getModel().getSelectedOption().equalsIgnoreCase("new.dsproject")){
					nextPage = newDataSourcepage;
				}
		}
		if(page instanceof NewDataSourceWizardPage){
			nextPage = pages[2];
		}
		if(page instanceof MavenDetailsPage ){
				nextPage=null;

		}
		return nextPage;
	}

	
	public IWizardPage getPreviousPage(IWizardPage page) {
		IWizardPage previousPage = super.getNextPage(page);
		if(page instanceof MavenDetailsPage ){
			if(getModel().getSelectedOption().equalsIgnoreCase("new.dsproject")){
				previousPage = newDataSourcepage;
			}
		}
		if(page instanceof NewDataSourceWizardPage){
			previousPage = pages[1];
		}
		return previousPage;
	}
	
	
	public boolean canFinish() {
		if(getContainer().getCurrentPage() instanceof ProjectOptionsDataPage){
			if(getModel().getSelectedOption().equalsIgnoreCase("new.dsproject")){
				return false;
			}
			else{
				return dsModel.getImportFile().exists();
			}
		} else if(getContainer().getCurrentPage() instanceof MavenDetailsPage) {
			return true;
		}
		return super.canFinish();
	}
	

}

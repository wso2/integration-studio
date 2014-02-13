/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.webapp.ui.wizard;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.artifact.webapp.model.WebAppModel;
import org.wso2.developerstudio.eclipse.artifact.webapp.model.WebXMLModel;
import org.wso2.developerstudio.eclipse.artifact.webapp.utils.WebAppImageUtils;
import org.wso2.developerstudio.eclipse.artifact.webapp.utils.WebAppTemplateUtils;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;
import org.wso2.developerstudio.eclipse.utils.wst.WebUtils;

public class WebAppCreationWizard extends AbstractWSO2ProjectCreationWizard {
	private static final String WEBAPP_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.webapp.project.nature";
	private WebAppModel webAppModel;
	private IProject project;

	public WebAppCreationWizard() {
		setWebAppModel(new WebAppModel());
		setModel(getWebAppModel());
		setWindowTitle("Create New Web Application");
		setDefaultPageImageDescriptor(WebAppImageUtils.getInstance().getImageDescriptor("war-wizard.png"));
	}
	
	public void setProjectLocation(IStructuredSelection selection){
		if (selection != null && (selection instanceof TreeSelection)) {
			TreeSelection tree = (TreeSelection) selection;
			Object firstElement = tree.getFirstElement();
			if (firstElement instanceof IResource) {
				if(firstElement  instanceof IFile) {
					File file = ((IResource) firstElement).getParent().getLocation().toFile();
					webAppModel.setSaveLocation(file);	 
				}
				else {
					File file = ((IResource) firstElement).getLocation().toFile();
					webAppModel.setSaveLocation(file);
				}
			} else {
				webAppModel.setSaveLocation(ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile());
			}
		}
		if (webAppModel.getSaveLocation() == null) {
			webAppModel.setSaveLocation(ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile());
		}
	}
 

	public boolean performFinish() {
		try {
			if (getModel().getSelectedOption().equals("import.webapp")) {
				IProject exproject = ResourcesPlugin.getWorkspace().getRoot().getProject(webAppModel.getProjectName());
				if(exproject.exists()){
					if(!MessageDialog.openQuestion(getShell(), "WARNING", "Do you like to override exsiting project in the workspace")){
						return false;	
					}
				} 
				project = createNewProject();
				extractImportFile(project);
				
			} else if (getModel().getSelectedOption().equals("new.webapp")) {
				project = createNewProject();
				IFolder webappFolder =
				        ProjectUtils.getWorkspaceFolder(project, "src", "main", "webapp");
				ITemporaryFileTag warTempTag = FileUtils.createNewTempTag();
				File webappTemplateArchive =
				        new WebAppTemplateUtils().getResourceFile("templates/webapp-template.war");
				WebUtils.extractWAR(webappFolder, webappTemplateArchive);
				warTempTag.clearAndEnd();
			}
			IFile webXmlLocation = WebUtils.getWEBXmlLocation(project);
			updateWebContextRoot(webXmlLocation, webAppModel.getWebContextRoot());
			File pomfile = project.getFile("pom.xml").getLocation().toFile();
			getModel().getMavenInfo().setPackageName("war");
			createPOM(pomfile);
			ProjectUtils.addNatureToProject(project,
											false,
			                                WEBAPP_PROJECT_NATURE);
			MavenUtils
			.updateWithMavenEclipsePlugin(
					pomfile,
					new String[] { JDT_BUILD_COMMAND },
					new String[] {
							WEBAPP_PROJECT_NATURE,
							JDT_PROJECT_NATURE });
			getModel().addToWorkingSet(project);
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			try {
				refreshDistProjects();
				IFile activatorClassForProject = getIndexFileForProject(project);
				IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),activatorClassForProject);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}
	
	private IFile getIndexFileForProject(IProject project){
		List<File> indexFileList = new ArrayList<File>();
		File[] indexFiles = FileUtils.getAllExactMatchingFiles(project.getLocation().toString(), "index", null, indexFileList);
		for (File index : indexFiles) {
			String relativePath = FileUtils.getRelativePath(project.getLocation().toFile(), index);
			IFile sourceFile = project.getFile(relativePath);
			return sourceFile;
		}
		return null;
	}

	public void setWebAppModel(WebAppModel webAppModel) {
		this.webAppModel = webAppModel;
	}

	public WebAppModel getWebAppModel() {
		return webAppModel;
	}

	public void extractImportFile(IProject importProject) throws IOException, CoreException {
		File importFile = getModel().getImportFile();
		String[] folderList = new String[] { "src", "main", "webapp" };
		IFolder webappFolder = ProjectUtils.getWorkspaceFolder(importProject, folderList);
		WebUtils.extractWAR(webappFolder, importFile);
	}

	public String getProjectRelativePath() {
		String path =
		        getModel().getLocation().getPath().substring(
		                                                     ResourcesPlugin.getWorkspace()
		                                                             .getRoot().getLocation()
		                                                             .toOSString().length());
		return path;
	}

	private void updateWebContextRoot(IFile webXMLFile, String webcontextRoot) {
		WebXMLModel webXMLModel;
		try {
			webXMLModel = new WebXMLModel();
			webXMLModel.deserialize(webXMLFile.getContents());
			webXMLModel.setDisplayName(webcontextRoot);
			webXMLFile.setContents(new ByteArrayInputStream(webXMLModel.toString().getBytes()),
			                       IResource.FORCE, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public IResource getCreatedResource() {
		return project;
	}
}

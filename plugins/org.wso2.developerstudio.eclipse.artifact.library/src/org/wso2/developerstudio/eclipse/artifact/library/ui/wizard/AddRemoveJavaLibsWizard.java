/*
 * Copyright (c) 2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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


package org.wso2.developerstudio.eclipse.artifact.library.ui.wizard;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.artifact.library.Activator;
import org.wso2.developerstudio.eclipse.artifact.library.model.LibraryArtifactModel;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;

public class AddRemoveJavaLibsWizard extends AbstractWSO2ProjectCreationWizard {

	private LibraryArtifactModel libraryModel;
	private NewJavaLibraryWizardPage wizardPage;
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	private MavenProject mavenProject;
	
	public AddRemoveJavaLibsWizard() throws Exception {

		super();
		setNeedsProgressMonitor(false);
		
		IPath path = null;
		IProject project = null;
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	    if (window != null)
	    {
	        IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection();
	        Object firstElement = selection.getFirstElement();
	        if (firstElement instanceof IAdaptable)
	        {
	            project = (IProject)((IAdaptable)firstElement).getAdapter(IProject.class);
	            path = project.getFullPath();
	        }
	    }
	    
	    if (path != null & project != null) {
	    	File pomfile = project.getFile("pom.xml").getLocation().toFile();
	    	mavenProject = MavenUtils.getMavenProject(pomfile);
			
	    	libraryModel = new LibraryArtifactModel();
			libraryModel.setProjectName(path.lastSegment());
			File projectFile = pomfile.getParentFile();
			libraryModel.setLocation(projectFile);
			
			for (Object obj : mavenProject.getDependencies()) {
				
				Dependency dependency = (Dependency)obj;
				String artifact = dependency.getArtifactId();
				String groupID = dependency.getGroupId();
				if (groupID.equals("dummy.groupid")){
					libraryModel.getLibraries().add(new File(projectFile.getPath() + File.separator + artifact));
				}else if (groupID.startsWith("org.wso2.carbon.")){
					IResource resource = ResourcesPlugin.getWorkspace().getRoot().getProject(artifact);
					libraryModel.getLibraries().add(resource);
				}
			} 
			
			String fragmentHostBundleName = "";
			for (Plugin pluginDom : mavenProject.getBuild().getPlugins()){
				String artifact = pluginDom.getArtifactId();
				if (artifact.equals("maven-bundle-plugin")) {
					Object configuration = pluginDom.getConfiguration();
					if(configuration instanceof Xpp3Dom){
						Xpp3Dom configDom = (Xpp3Dom)configuration;
						Xpp3Dom fragmentHostNode = configDom.getChild("instructions").getChild("Fragment-Host");
						if (fragmentHostNode != null){
							fragmentHostBundleName = fragmentHostNode.getValue();
						}
						}
				}
			}
			
			if (!fragmentHostBundleName.isEmpty()) {
				libraryModel.setFragmentHostBundle(true);
				libraryModel.setFragmentHostBundleName(fragmentHostBundleName);
			}
				
			wizardPage = new NewJavaLibraryWizardPage(true);
			super.setModel(libraryModel);
	    }
	}
	
	@Override
	public void addPages() {
		addPage(wizardPage);
	}

	@Override
	public boolean canFinish() {
		if (wizardPage != null){
			return wizardPage.isValid();
		} else {
		return true;
		}
	}
	
	@Override
	public IResource getCreatedResource() {
		return null;
	}
	
	public LibraryArtifactModel getLibraryModel() {
		return libraryModel;
	}
	
	public boolean performFinish() {
		try {
			
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(libraryModel.getProjectName());
			List<Dependency> dependencyList = new ArrayList<Dependency>();
			List<String> exportedPackages = LibraryArtifactCreationWizard.fillDependencyList(project, libraryModel, dependencyList);
			StringBuffer sb = new StringBuffer();
			for(String exportedpackage : exportedPackages) {
				sb.append(exportedpackage.trim()).append(",");
			}
			String exportPackageNodeValue = sb.toString().trim().replaceAll(",$","");
			
			mavenProject.getDependencies().clear();
			MavenUtils.addMavenDependency(mavenProject, dependencyList);
			
			for (Plugin pluginDom : mavenProject.getBuild().getPlugins()){
				String artifact = pluginDom.getArtifactId();
				if (artifact.equals("maven-bundle-plugin")) {
					Object configuration = pluginDom.getConfiguration();
					if(configuration instanceof Xpp3Dom){
						Xpp3Dom configDom = (Xpp3Dom)configuration;
						Xpp3Dom instructionNode = configDom.getChild("instructions");
						Xpp3Dom exportedValueNode = instructionNode.getChild("Export-Package");
						exportedValueNode.setValue(exportPackageNodeValue);
						
						Xpp3Dom fragmentBundleNode = instructionNode.getChild("Fragment-Host");
						if (libraryModel.isFragmentHostBundle()) {
							if (fragmentBundleNode != null){
								fragmentBundleNode.setValue(libraryModel.getFragmentHostBundleName());
							} else {
								fragmentBundleNode = new Xpp3Dom("Fragment-Host");
								fragmentBundleNode.setValue(libraryModel.getFragmentHostBundleName());
								instructionNode.addChild(fragmentBundleNode);
							}
						} else {
							if (fragmentBundleNode != null){
								int fragmentBundleNodeIndex = 4;
								int nodeIndex = 0;
								for (Xpp3Dom childNode : instructionNode.getChildren()){
									if (childNode.getValue().equals("Fragment-Host")) {
										fragmentBundleNodeIndex = nodeIndex;
										break;
									}
									nodeIndex++;
								}
								instructionNode.removeChild(fragmentBundleNodeIndex);
							}
						}
						
						}
				}
			}
			
			File pomfile = project.getFile("pom.xml").getLocation().toFile();
			try {
				MavenUtils.saveMavenProject(mavenProject, pomfile);
			} catch (Exception e) {
				log.error("The 'pom.xml' file is missing or malformed.", e);
				IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage()); 
				ErrorDialog.openError(getShell(), "Error", "The 'pom.xml' file is missing or malformed.", editorStatus);
			}
			
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			refreshDistProjects();
		} catch (Exception e) {
			log.warn("An Unspecified Error has occurred", e);
		}

		return true;
	}
}
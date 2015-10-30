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

package org.wso2.developerstudio.eclipse.artifact.analytics.stream.ui.wizard;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.artifact.analytics.stream.Activator;
import org.wso2.developerstudio.eclipse.artifact.analytics.stream.model.StreamModel;
import org.wso2.developerstudio.eclipse.artifact.analytics.stream.utils.StreamImageUtils;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsArtifactModel;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsConstants;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsMavenConstants;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsProjectArtifactCreator;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsTemplateUtils;
import org.wso2.developerstudio.eclipse.artifact.analytics.stream.utils.StreamConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;


public class StreamProjectCreationWizard extends AbstractWSO2ProjectCreationWizard {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private StreamModel streamModel;
	private AnalyticsProjectArtifactCreator analyticsProjectArtifact;
	private List<File> fileList = new ArrayList<File>();
	private IProject project;
	
	public StreamProjectCreationWizard() {
		streamModel = new StreamModel();
		setModel(streamModel);
		setWindowTitle(StreamConstants.WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(StreamImageUtils.getInstance()
				.getImageDescriptor("stream-64x64.png"));
	}
	
	protected boolean isRequireProjectLocationSection() {
		return false;
	}
	
	protected boolean isRequiredWorkingSet() {
	  return false;
	}

	public boolean performFinish() {
		try {
			streamModel = (StreamModel) getModel();
			project = streamModel.getStreamSaveLocation().getProject();
			if(!createStreamArtifact()){
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
	
	public void updatePom() throws Exception{
		File mavenProjectPomLocation = project.getFile("pom.xml").getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		
		boolean pluginExists = MavenUtils.checkOldPluginEntry(mavenProject,
				"org.wso2.maven", "analytics-stream-maven-plugin",
				AnalyticsMavenConstants.WSO2_ANALYTICS_STREAM_VERSION);
		if(pluginExists){
			return ;
		}
		
		Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "analytics-stream-maven-plugin", AnalyticsMavenConstants.WSO2_ANALYTICS_STREAM_VERSION, true);
		
		PluginExecution pluginExecution = new PluginExecution();
		pluginExecution.addGoal("pom-gen");
		pluginExecution.setPhase("process-resources");
		pluginExecution.setId("stream");
		
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
	
	public String getProjectVersion(File pomLocation) {
		String version = "1.0.0";
		if (pomLocation != null && pomLocation.exists()) {
			try {
				MavenProject mavenProject = MavenUtils.getMavenProject(pomLocation);
				version = mavenProject.getVersion();
			} catch (Exception e) {
				log.error("error reading pom file", e);
			}
		}
		return version;
	}
	
	public boolean createStreamArtifact() throws Exception {
        boolean isNewArtifact =true;
        IContainer location = project.getFolder("src" + File.separator + "main" + File.separator
				+ AnalyticsConstants.ANALYTICS_STREAM_DIR);

		// Adding the metadata about the sequence to the metadata store.
		analyticsProjectArtifact = new AnalyticsProjectArtifactCreator();
		analyticsProjectArtifact.fromFile(project.getFile("artifact.xml")
				.getLocation().toFile());
		
		File pomfile = project.getFile("pom.xml").getLocation().toFile();
		getModel().getMavenInfo().setPackageName(AnalyticsConstants.ANALYTICS_STREAM_DIR);
		if (!pomfile.exists()) {
			createPOM(pomfile);
		}

		updatePom();
		project.refreshLocal(IResource.DEPTH_INFINITE,
				new NullProgressMonitor());
		String groupId = getMavenGroupId(pomfile);
		groupId += "."+ AnalyticsConstants.ANALYTICS_STREAM_DIR;
		String version = getProjectVersion(pomfile);

		if (getModel().getSelectedOption().equals(StreamConstants.WIZARD_OPTION_IMPORT_STREAM_PROJECT)) {
			IFile stream = location.getFile(new Path(getModel().getImportFile().getName()));
			if(stream.exists()){
				if(!MessageDialog.openQuestion(getShell(), "WARNING", "Do you like to override exsiting project in the workspace")){
					return false;	
				}
				isNewArtifact = false;
			} 	
			copyImportFile(location,isNewArtifact,groupId,version);
		} else {
			File analyticsTemplateFile = new AnalyticsTemplateUtils().getResourceFile("templates" + File.separator
					+ AnalyticsConstants.TEMPLATE_STREAM);
			String templateContent = FileUtils.getContentAsString(analyticsTemplateFile);
			String content = templateContent.replaceAll(AnalyticsConstants.NAMETAG_STREAM_TEMPLATE, streamModel.getProjectName());
			File destFile = new File(location.getLocation().toFile(),
					streamModel.getProjectName() + "."+AnalyticsConstants.EXTENTION_STREAM);
			FileUtils.createFile(destFile, content);
			fileList.add(destFile);

			AnalyticsArtifactModel artifact = new AnalyticsArtifactModel();
			artifact.setName(streamModel.getProjectName());
			artifact.setVersion(version);
			artifact.setType(AnalyticsConstants.ARTIFACT_TYPE_STREAM);
			artifact.setServerRole(AnalyticsConstants.ANALYTICS_SERVER_NAME);
			artifact.setGroupId(groupId);
			artifact.setFile(FileUtils.getRelativePath(project.getLocation()
					.toFile(), new File(location.getLocation().toFile(),
							streamModel.getProjectName() + "."+AnalyticsConstants.EXTENTION_STREAM)).replaceAll(Pattern.quote(File.separator), "/"));
			analyticsProjectArtifact.addAnalyticsArtifact(artifact);
		}
		analyticsProjectArtifact.toFile();
		project.refreshLocal(IResource.DEPTH_INFINITE,
				new NullProgressMonitor());
		return true;
	}
	

	public void copyImportFile(IContainer importLocation,boolean isNewAritfact, String groupId, String version) throws IOException {
		File importFile = getModel().getImportFile();
		File destFile = null;
		destFile = new File(importLocation.getLocation().toFile(), importFile.getName());
		FileUtils.copy(importFile, destFile);
		fileList.add(destFile);
		String name = importFile.getName().replaceAll("."+AnalyticsConstants.EXTENTION_STREAM+"$","");
		if(isNewAritfact){
			AnalyticsArtifactModel artifact=new AnalyticsArtifactModel();
			artifact.setName(name);
			artifact.setVersion(version);
			artifact.setType(AnalyticsConstants.ARTIFACT_TYPE_STREAM);
			artifact.setServerRole(AnalyticsConstants.ANALYTICS_SERVER_NAME);
			artifact.setGroupId(groupId);
			artifact.setFile(FileUtils.getRelativePath(importLocation.getProject().getLocation().toFile(),
			new File(importLocation.getLocation().toFile(), name + "."+AnalyticsConstants.EXTENTION_STREAM)).replaceAll(
			Pattern.quote(File.separator), "/"));
			analyticsProjectArtifact.addAnalyticsArtifact(artifact);
		}
	}
	
	public IResource getCreatedResource() {
		return null;
	}
		
}

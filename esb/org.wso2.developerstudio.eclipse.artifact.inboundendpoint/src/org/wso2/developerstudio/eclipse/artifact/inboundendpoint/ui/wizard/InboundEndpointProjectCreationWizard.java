/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.inboundendpoint.ui.wizard;

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
import org.apache.synapse.config.xml.inbound.InboundEndpointSerializer;
import org.apache.synapse.inbound.InboundEndpoint;
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
import org.wso2.developerstudio.eclipse.artifact.inboundendpoint.Activator;
import org.wso2.developerstudio.eclipse.artifact.inboundendpoint.model.InboundEndpointModel;
import org.wso2.developerstudio.eclipse.artifact.inboundendpoint.utils.InboundEndpointArtifactProperties;
import org.wso2.developerstudio.eclipse.artifact.inboundendpoint.utils.InboundEndpointImageUtils;
import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.developerstudio.eclipse.platform.ui.startup.ESBGraphicalEditor;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class InboundEndpointProjectCreationWizard extends AbstractWSO2ProjectCreationWizard {
	
	private static final String XML_EXTENSION = ".xml";

	private InboundEndpointModel inboundEndpointModel;
	private IFile inboundEndpointFile;
	private InboundEndpointModel ieModel;
	private ESBProjectArtifact esbProjectArtifact;
	private List<File> fileList = new ArrayList<File>();
	private IProject esbProject;
	private String version = "1.0.0";
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	public InboundEndpointProjectCreationWizard() {
		this.inboundEndpointModel = new InboundEndpointModel();
		setModel(this.inboundEndpointModel);
		setWindowTitle(InboundEndpointArtifactProperties.ieWizardWindowTitle);
		setDefaultPageImageDescriptor(InboundEndpointImageUtils.getInstance().getImageDescriptor("inbound-endpoint.png"));
	}
	
	
	public IResource getCreatedResource() {
		return inboundEndpointFile;
	}
	
	protected boolean isRequireProjectLocationSection() {
		return false;
	}
	
	public boolean createInboundEndpointArtifact(InboundEndpointModel inboundEndpointModel) throws Exception {
		ieModel=inboundEndpointModel;
		boolean isNewArtifact =true;
		IContainer location = esbProject.getFolder("src" + File.separator + "main" + File.separator
				+ "synapse-config" + File.separator + "inbound-endpoints");
		
		updatePom();
		esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		File pomLocation = esbProject.getFile("pom.xml").getLocation().toFile();
		String groupId = getMavenGroupId(pomLocation);
		groupId += ".inbound-endpoint";

		// Adding the metadata about the inboundEndpoint to the metadata store.
		esbProjectArtifact = new ESBProjectArtifact();
		esbProjectArtifact.fromFile(esbProject.getFile("artifact.xml").getLocation().toFile());

		if (getModel().getSelectedOption().equals(
				InboundEndpointArtifactProperties.wizardOptionImportOption)) {
			inboundEndpointFile = location.getFile(new Path(getModel().getImportFile().getName()));
			if (inboundEndpointFile.exists()) {
				if (!MessageDialog.openQuestion(getShell(), "WARNING",
						"Do you like to override exsiting project in the workspace")) {
					return false;
				}
				isNewArtifact = false;
			}
			copyImportFile(location, isNewArtifact, groupId);

		} else {
			File inboundEndpointFile = new File(location.getLocation().toFile(),
					inboundEndpointModel.getName() + XML_EXTENSION);
			writeTemplete(inboundEndpointFile);

			ESBArtifact artifact = new ESBArtifact();
			artifact.setName(inboundEndpointModel.getName());
			artifact.setVersion(version);
			artifact.setType("synapse/inbound-endpoint");
			artifact.setServerRole("EnterpriseServiceBus");
			artifact.setGroupId(groupId);
			artifact.setFile(FileUtils.getRelativePath(
					esbProject.getLocation().toFile(),
					new File(location.getLocation().toFile(), inboundEndpointModel.getName()
							+ XML_EXTENSION)).replaceAll(Pattern.quote(File.separator), "/"));
			esbProjectArtifact.addESBArtifact(artifact);
		}
		File pomfile = esbProject.getFile("pom.xml").getLocation().toFile();
		getModel().getMavenInfo().setPackageName("synapse/inbound-endpoint");
		if (!pomfile.exists()) {
			createPOM(pomfile);
		}

		esbProjectArtifact.toFile();
		esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		return true;
	}

	public boolean performFinish() {
		try {
			ieModel = (InboundEndpointModel)getModel();
			esbProject =  ieModel.getInboundEndpointSaveLocation().getProject();
			createInboundEndpointArtifact(ieModel);
			
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
	
	public void updatePom() throws Exception{
		File mavenProjectPomLocation = esbProject.getFile("pom.xml").getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		 version = mavenProject.getVersion();
		boolean pluginExists = MavenUtils.checkOldPluginEntry(mavenProject,
				"org.wso2.maven", "wso2-esb-inboundendpoint-plugin",
				MavenConstants.WSO2_ESB_INBOUND_ENDPOINT_VERSION);
		if(pluginExists){
			return ;
		}
		
		Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-inboundendpoint-plugin", MavenConstants.WSO2_ESB_INBOUND_ENDPOINT_VERSION, true);
		
		PluginExecution pluginExecution = new PluginExecution();
		pluginExecution.addGoal("pom-gen");
		pluginExecution.setPhase("process-resources");
		pluginExecution.setId("inboundendpoint");
		
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
	
	protected boolean isRequiredWorkingSet() {
		return false;
	}
	
	private void writeTemplete(File inboundEndpointFile){
		try {
			InboundEndpoint inboundEndpoint= new InboundEndpoint();
			inboundEndpoint.setName(ieModel.getName());
			inboundEndpoint.setProtocol(ieModel.getProtocol());
			inboundEndpoint.setInjectingSeq(ieModel.getInjectingSequence());
			inboundEndpoint.setOnErrorSeq(ieModel.getOnErrorSequence());
			
			OMElement inboundEndpointOmElement = InboundEndpointSerializer.serializeInboundEndpoint(inboundEndpoint);
			FileUtils.writeContent(inboundEndpointFile, inboundEndpointOmElement.toString());
			fileList.add(inboundEndpointFile);
		} catch (IOException e) {
			log.error("I/O Error has occurred", e);
		}
	}
	
	public void copyImportFile(IContainer importLocation,boolean isNewArtifact,String groupId) throws IOException {
		File importFile = getModel().getImportFile();
		List<OMElement> selectedLEList = ieModel.getSelectedLEList();
		File destFile = null;
		if(selectedLEList != null && selectedLEList.size() >0 ){
			for (OMElement element : selectedLEList) {
				String key = element.getAttributeValue(new QName("key"));
				destFile  = new File(importLocation.getLocation().toFile(), key + XML_EXTENSION);
				FileUtils.createFile(destFile, element.toString());
				fileList.add(destFile);
				if(isNewArtifact){
				ESBArtifact artifact=new ESBArtifact();
				artifact.setName(key);
				artifact.setVersion(version);
				artifact.setType("synapse/local-entry");
				artifact.setServerRole("EnterpriseServiceBus");
				artifact.setGroupId(groupId);
				artifact.setFile(FileUtils.getRelativePath(importLocation.getProject().getLocation().toFile(), new File(importLocation.getLocation().toFile(),key+XML_EXTENSION)));
				esbProjectArtifact.addESBArtifact(artifact);
				}
			}
			
		}else{
			destFile = new File(importLocation.getLocation().toFile(), importFile.getName());
			FileUtils.copy(importFile, destFile);
			fileList.add(destFile);
			String key = importFile.getName().replaceAll(".xml$", "");
			if(isNewArtifact){
			ESBArtifact artifact=new ESBArtifact();
			artifact.setName(key);
			artifact.setVersion(version);
			artifact.setType("synapse/local-entry");
			artifact.setServerRole("EnterpriseServiceBus");
			artifact.setFile(groupId);
			artifact.setFile(FileUtils.getRelativePath(importLocation.getProject().getLocation().toFile(), new File(importLocation.getLocation().toFile(),key+XML_EXTENSION)));
			esbProjectArtifact.addESBArtifact(artifact);
			}
		}
	}
	
	public void openEditor(File file) {
		try{
		refreshDistProjects();
		IFile dbsFile  = ResourcesPlugin
		.getWorkspace()
		.getRoot()
		.getFileForLocation(
				Path.fromOSString(file.getAbsolutePath()));
		String path = dbsFile.getParent().getFullPath()+"/";
		String source = FileUtils.getContentAsString(file);
		Openable openable = ESBGraphicalEditor.getOpenable();
		openable.editorOpen(file.getName(),ArtifactType.INBOUND_ENDPOINT.getLiteral(),path, source);
		}catch(Exception e){
			log.error("Cannot open the editor", e);
		}
	}
	
	public void setProject(IProject project) {
		this.esbProject = project;
	}

}

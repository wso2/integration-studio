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
import org.apache.maven.project.MavenProject;
import org.apache.synapse.config.xml.inbound.InboundEndpointSerializer;
import org.apache.synapse.inbound.InboundEndpoint;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
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
import org.wso2.developerstudio.eclipse.esb.core.ESBMavenConstants;
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
	
	private static final String RABBITMQ_EXCHANGE_NAME = "rabbitmq.exchange.name";
	private static final String RABBITMQ_QUEUE_NAME = "rabbitmq.queue.name";
	private static final String RABBITMQ_SERVER_PASSWORD = "rabbitmq.server.password";
	private static final String RABBITMQ_SERVER_USER_NAME = "rabbitmq.server.user.name";
	private static final String RABBITMQ_SERVER_PORT = "rabbitmq.server.port";
	private static final String RABBITMQ_SERVER_HOST_NAME = "rabbitmq.server.host.name";
	private static final String RABBITMQ_CONNECTION_FACTORY = "rabbitmq.connection.factory";
	private static final String RABBITMQ = "rabbitmq";
	private static final String INTERVAL = "interval";
	private static final String TOPICS = "topics";
	private static final String KAFKA_GROUP_ID = "group.id";
	private static final String ZOOKEEPER_CONNECT = "zookeeper.connect";
	private static final String KAFKA = "kafka";
	private static final String XML_EXTENSION = ".xml";
	private static final String SRC_FOLDER ="src";
	private static final String MAIN_FOLDER="main";
	private static final String SYNAPSE_FOLDER= "synapse-config";
	private static final String INBOUND_EP_FOLDER="inbound-endpoints";
	private static final String POM_FILE ="pom.xml";
	private static final String GROUP_ID =".inbound-endpoint";	
	private static final String ARTIFACT_XML_FILE = "artifact.xml";
	private static final String TYPE ="synapse/inbound-endpoint"; 
	private static final String SERVER_ROLE ="EnterpriseServiceBus";
	private static final String MAVEN_ID = "org.wso2.maven";
	private static final String INBOUND_EP_PLUGIN_ID= "wso2-esb-inboundendpoint-plugin";
	private static final String PLUGIN_GOAL = "pom-gen";
	private static final String PLUGIN_PHASE = "process-resources";
	private static final String PLUGIN_ID = "inboundendpoint";
	private static final String ARTIFACT_LOCATION ="artifactLocation";
	private static final String TYPE_LIST ="typeList";
	private static final String CUSTOM = "custom";
	private static final String KEY ="key";
	
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
		IContainer location = esbProject.getFolder(SRC_FOLDER + File.separator + MAIN_FOLDER+ File.separator
				+ SYNAPSE_FOLDER + File.separator + INBOUND_EP_FOLDER);
		
		updatePom();
		esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		File pomLocation = esbProject.getFile(POM_FILE).getLocation().toFile();
		String groupId = getMavenGroupId(pomLocation);
		groupId += GROUP_ID;

		// Adding the metadata about the inboundEndpoint to the metadata store.
		esbProjectArtifact = new ESBProjectArtifact();
		esbProjectArtifact.fromFile(esbProject.getFile(ARTIFACT_XML_FILE).getLocation().toFile());

		if (getModel().getSelectedOption().equals(
				InboundEndpointArtifactProperties.wizardOptionImportOption)) {
			inboundEndpointFile = location.getFile(new Path(getModel().getImportFile().getName()));
			if (inboundEndpointFile.exists()) {
				if (!MessageDialog.openQuestion(getShell(), "WARNING",
						InboundEndpointArtifactProperties.msgOverrideProject)) {
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
			artifact.setType(TYPE);
			artifact.setServerRole(SERVER_ROLE);
			artifact.setGroupId(groupId);
			artifact.setFile(FileUtils.getRelativePath(
					esbProject.getLocation().toFile(),
					new File(location.getLocation().toFile(), inboundEndpointModel.getName()
							+ XML_EXTENSION)).replaceAll(Pattern.quote(File.separator), "/"));
			esbProjectArtifact.addESBArtifact(artifact);
		}
		File pomfile = esbProject.getFile(POM_FILE).getLocation().toFile();
		getModel().getMavenInfo().setPackageName(TYPE);
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
			log.error(InboundEndpointArtifactProperties.errorCoreException, e);
		} catch (Exception e) {
			log.error(InboundEndpointArtifactProperties.errorUnexpectedError, e);
		}
		return true;
	}
	
	public void updatePom() throws IOException, XmlPullParserException {
		File mavenProjectPomLocation = esbProject.getFile(POM_FILE).getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		version = mavenProject.getVersion();

		// Skip changing the pom file if group ID and artifact ID are matched
		if (MavenUtils.checkOldPluginEntry(mavenProject, MAVEN_ID, INBOUND_EP_PLUGIN_ID)) {
			return;
		}

		Plugin plugin = MavenUtils.createPluginEntry(mavenProject, MAVEN_ID, INBOUND_EP_PLUGIN_ID,
				ESBMavenConstants.WSO2_ESB_INBOUND_ENDPOINT_VERSION, true);
		PluginExecution pluginExecution = new PluginExecution();
		pluginExecution.addGoal(PLUGIN_GOAL);
		pluginExecution.setPhase(PLUGIN_PHASE);
		pluginExecution.setId(PLUGIN_ID);

		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
		Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, ARTIFACT_LOCATION);
		artifactLocationNode.setValue(".");
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, TYPE_LIST);
		typeListNode.setValue("${artifact.types}");
		pluginExecution.setConfiguration(configurationNode);
		plugin.addExecution(pluginExecution);
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}
	
	protected boolean isRequiredWorkingSet() {
		return false;
	}
	
	private void writeTemplete(File inboundEndpointFile){
		try {
			
			InboundEndpoint inboundEndpoint= new InboundEndpoint();
			inboundEndpoint.setName(ieModel.getName());
			
			if(ieModel.getProtocol().equals(CUSTOM)){
				inboundEndpoint.setClassImpl("org.wso2.sample.inbound.CustomClass");
			} else {
				inboundEndpoint.setProtocol(ieModel.getProtocol());
				if(ieModel.getProtocol().equals(KAFKA)){
					inboundEndpoint.addParameter(ZOOKEEPER_CONNECT, "localhost:2181");
					inboundEndpoint.addParameter(KAFKA_GROUP_ID, "sampleGroupID");
					inboundEndpoint.addParameter(TOPICS, "sampleTopic");
					inboundEndpoint.addParameter(INTERVAL, "1000");
				}
				if(ieModel.getProtocol().equals(RABBITMQ)){
					inboundEndpoint.addParameter(RABBITMQ_CONNECTION_FACTORY, "connection_factory");
					inboundEndpoint.addParameter(RABBITMQ_SERVER_HOST_NAME, "loclahost");
					inboundEndpoint.addParameter(RABBITMQ_SERVER_PORT, "5672");
					inboundEndpoint.addParameter(RABBITMQ_SERVER_USER_NAME, "guest");
					inboundEndpoint.addParameter(RABBITMQ_SERVER_PASSWORD, "guest");
					inboundEndpoint.addParameter(RABBITMQ_QUEUE_NAME, "queue_name");
					inboundEndpoint.addParameter(RABBITMQ_EXCHANGE_NAME, "excahnge_name");
				}
			}
			
			//Sets an empty string value for sequence and onerror sequence
			inboundEndpoint.setInjectingSeq("");
			inboundEndpoint.setOnErrorSeq("");
			
			OMElement inboundEndpointOmElement = InboundEndpointSerializer.serializeInboundEndpoint(inboundEndpoint);
			FileUtils.writeContent(inboundEndpointFile, inboundEndpointOmElement.toString());
			fileList.add(inboundEndpointFile);
		} catch (IOException e) {
			log.error(InboundEndpointArtifactProperties.errorIOException, e);
		}
	}
	
	public void copyImportFile(IContainer importLocation,boolean isNewArtifact,String groupId) throws IOException {
		File importFile = getModel().getImportFile();
		List<OMElement> selectedLEList = ieModel.getSelectedLEList();
		File destFile = null;
		if(selectedLEList != null && selectedLEList.size() >0 ){
			for (OMElement element : selectedLEList) {
				String key = element.getAttributeValue(new QName(KEY));
				destFile  = new File(importLocation.getLocation().toFile(), key + XML_EXTENSION);
				FileUtils.createFile(destFile, element.toString());
				fileList.add(destFile);
				if(isNewArtifact){
				ESBArtifact artifact=new ESBArtifact();
				artifact.setName(key);
				artifact.setVersion(version);
				artifact.setType(TYPE);
				artifact.setServerRole(SERVER_ROLE);
				artifact.setGroupId(groupId);
					artifact.setFile(FileUtils.getRelativePath(importLocation.getProject().getLocation().toFile(),
							new File(importLocation.getLocation().toFile(), key + XML_EXTENSION)).replaceAll(
							Pattern.quote(File.separator), "/"));
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
			artifact.setType(TYPE);
			artifact.setServerRole(SERVER_ROLE);
			artifact.setGroupId(groupId);
				artifact.setFile(FileUtils.getRelativePath(importLocation.getProject().getLocation().toFile(),
						new File(importLocation.getLocation().toFile(), key + XML_EXTENSION)).replaceAll(
						Pattern.quote(File.separator), "/"));
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
			log.error(InboundEndpointArtifactProperties.errorOpenEditor, e);
		}
	}
	
	public void setProject(IProject project) {
		this.esbProject = project;
	}

}

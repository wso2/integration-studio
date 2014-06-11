/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.messagestore.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;

import org.wso2.developerstudio.eclipse.artifact.messagestore.Activator;
import org.wso2.developerstudio.eclipse.artifact.messagestore.model.MessageStoreModel;
import org.wso2.developerstudio.eclipse.artifact.messagestore.provider.MessageStoreTypeList.MessageStoreType;
import org.wso2.developerstudio.eclipse.artifact.messagestore.util.MessageStoreImageUtils;
import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.developerstudio.eclipse.platform.ui.startup.ESBGraphicalEditor;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;

import static org.wso2.developerstudio.eclipse.artifact.messagestore.Constants.*;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.model.Repository;
import org.apache.maven.project.MavenProject;
import org.apache.synapse.config.xml.MessageStoreSerializer;
import org.apache.synapse.message.store.MessageStore;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.message.store.impl.memory.InMemoryStore;

/**
 * WSO2 message-store creation wizard class
 */
public class MessageStoreCreationWizard extends AbstractWSO2ProjectCreationWizard {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	private final MessageStoreModel messageStoreModel;
	private ESBProjectArtifact esbProjectArtifact;
	private IProject esbProject;
	private IFile artifactFile;
	private List<File> fileLst = new ArrayList<File>();

	private String version = "1.0.0";
	
	public MessageStoreCreationWizard() {
		messageStoreModel = new MessageStoreModel();
		setModel(messageStoreModel);
		setWindowTitle("New Message Store");
		setDefaultPageImageDescriptor(MessageStoreImageUtils.getInstance().getImageDescriptor("message-store.png"));
	}

	@Override
	public IResource getCreatedResource() {
		return null;
	}

	@Override
	public boolean performFinish() {
		try {
			boolean isNewArtifact =true;
			esbProject = messageStoreModel.getSaveLocation().getProject();
			IContainer location = esbProject.getFolder("src/main/synapse-config/message-stores");
			File pomfile = esbProject.getFile("pom.xml").getLocation().toFile();
			if (!pomfile.exists()) {
				createPOM(pomfile);
			}
			esbProjectArtifact = new ESBProjectArtifact();
			esbProjectArtifact.fromFile(esbProject.getFile("artifact.xml").getLocation().toFile());
			updatePom();
			esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			String groupId = getMavenGroupId(pomfile) + ".message-store";
            if(getModel().getSelectedOption().equals(FIELD_IMPORT_STORE)){
            	IFile task = location.getFile(new Path(getModel().getImportFile().getName()));
				if(task.exists()){
					if(!MessageDialog.openQuestion(getShell(), "WARNING", "Do you like to override exsiting project in the workspace")){
						return false;	
					}
					isNewArtifact = false;
				} 	
				copyImportFile(location,isNewArtifact,groupId);
            }else{
			artifactFile = location.getFile(new Path(messageStoreModel.getStoreName() + ".xml"));
			File destFile = artifactFile.getLocation().toFile();
			FileUtils.createFile(destFile, getTemplateContent());
			fileLst.add(destFile);
			String relativePath = FileUtils.getRelativePath(esbProject.getLocation().toFile(),
					new File(location.getLocation().toFile(), messageStoreModel.getStoreName() + ".xml"))
					.replaceAll(Pattern.quote(File.separator), "/");
			esbProjectArtifact.addESBArtifact(createArtifact(messageStoreModel.getStoreName(), groupId,
					version, relativePath));
			esbProjectArtifact.toFile();
            }
			esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            
			for (File file : fileLst) {
				if (file.exists()) {
					openEditor(file);
				}
			}
		} catch (CoreException e) {
			log.error("CoreException has occurred", e);
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}
		return true;
	}
	
	protected boolean isRequireProjectLocationSection() {
		return false;
	}

	protected boolean isRequiredWorkingSet() {
		return false;
	}
	
	private ESBArtifact createArtifact(String name,String groupId,String version,String path){
		ESBArtifact artifact=new ESBArtifact();
		artifact.setName(name);
		artifact.setVersion(version);
		artifact.setType("synapse/message-store");
		artifact.setServerRole("EnterpriseServiceBus");
		artifact.setGroupId(groupId);
		artifact.setFile(path);
		return artifact;
	}
	
	private String getTemplateContent(){
		Map<String,Object> parameters = new HashMap<String,Object>();
		// Fixing TOOLS-2026.
		//String className = "org.apache.synapse.message.store.InMemoryMessageStore";
		//String className = "org.apache.synapse.message.store.impl.memory.InMemoryStore";
		String className = null;
		MessageStore store = new InMemoryStore();
		store.setName(messageStoreModel.getStoreName());
		String lineSeparator = System.getProperty("line.separator","\n");
		
		if(messageStoreModel.getMessageStoreType()==MessageStoreType.CUSTOM){
			className = messageStoreModel.getCustomProviderClass();
			for (Entry<String, String> param : messageStoreModel
					.getCustomParameters().entrySet()) {
				if(!StringUtils.isBlank(param.getKey()) && !StringUtils.isBlank(param.getValue())){
					parameters.put(param.getKey(), param.getValue().toString());
				}
			}
		} else if(messageStoreModel.getMessageStoreType()==MessageStoreType.JMS){
			// Fixing TOOLS-2026.
			//className = "org.wso2.carbon.message.store.persistence.jms.JMSMessageStore";
			className = "org.apache.synapse.message.store.impl.jms.JmsStore";
			if(!StringUtils.isBlank(messageStoreModel.getJmsContextFactory())){
				parameters.put("java.naming.factory.initial", messageStoreModel.getJmsContextFactory());
			}
			if(!StringUtils.isBlank(messageStoreModel.getJmsProviderUrl())){
				parameters.put("java.naming.provider.url", messageStoreModel.getJmsProviderUrl());
			}
			if(!StringUtils.isBlank(messageStoreModel.getJmsQueueName())){
				parameters.put("store.jms.destination", messageStoreModel.getJmsQueueName());
			}
			if(!StringUtils.isBlank(messageStoreModel.getJmsConnectionFactory())){
				parameters.put("store.jms.connection.factory", messageStoreModel.getJmsConnectionFactory());
			}
			if(!StringUtils.isBlank(messageStoreModel.getJmsUsername())){
				parameters.put("store.jms.username", messageStoreModel.getJmsUsername());
			}
			if(!StringUtils.isBlank(messageStoreModel.getJmsPassword())){
				parameters.put("store.jms.password", messageStoreModel.getJmsPassword());
			}
			if(!StringUtils.isBlank(messageStoreModel.getJmsApiVersion())){
				parameters.put("store.jms.JMSSpecVersion", messageStoreModel.getJmsApiVersion());
			}
			parameters.put("store.jms.cache.connection", ((Boolean)messageStoreModel.getJmsEnableCaching()).toString());
			parameters.put("store.jms.ConsumerReceiveTimeOut", ((Integer)messageStoreModel.getJmsTimeout()).toString());

		} 
		store.setParameters(parameters);
		
		OMElement messageStoreElement = MessageStoreSerializer.serializeMessageStore(null, store);
		OMAttribute classAttr = messageStoreElement.getAttribute(new QName("class"));
		if(classAttr!=null){
			classAttr.setAttributeValue(className);
		} else if (!StringUtils.isBlank(className)) {
			messageStoreElement.addAttribute("class", className, null);
		} else{
			/**
			 * Class attribute is optional for In-Memory Store.
			 * If class name is not defined it will be considered as an 
			 * In-Memory store by default.
			 */
			//messageStoreElement.addAttribute("class", className, null);
		}
		return messageStoreElement.toString().replace("><", ">" + lineSeparator + "<");
	}
	
	public void updatePom() throws Exception {
		File mavenProjectPomLocation = esbProject.getFile("pom.xml")
				.getLocation().toFile();
		MavenProject mavenProject = MavenUtils
				.getMavenProject(mavenProjectPomLocation);
		 version  = mavenProject.getVersion();
		 version  = version.replaceAll("-SNAPSHOT$", "");
		boolean pluginExists = MavenUtils.checkOldPluginEntry(mavenProject,
				"org.wso2.maven", "wso2-esb-messagestore-plugin",
				MavenConstants.WSO2_ESB_MESSAGE_STORE_PLUGIN_VERSION);
		if (pluginExists) {
			return;
		}

		Plugin plugin = MavenUtils.createPluginEntry(mavenProject,
				"org.wso2.maven", "wso2-esb-messagestore-plugin",
				MavenConstants.WSO2_ESB_MESSAGE_STORE_PLUGIN_VERSION, true);

		PluginExecution pluginExecution = new PluginExecution();
		pluginExecution.addGoal("pom-gen");
		pluginExecution.setPhase("process-resources");
		pluginExecution.setId("task");

		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
		Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(
				configurationNode, "artifactLocation");
		artifactLocationNode.setValue(".");
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode,
				"typeList");
		typeListNode.setValue("${artifact.types}");
		pluginExecution.setConfiguration(configurationNode);

		plugin.addExecution(pluginExecution);

		String disableWSO2Repo = Platform.getPreferencesService().getString(
				"org.wso2.developerstudio.eclipse.platform.ui",
				DISABLE_WSO2_REPOSITORY, null, null);
		if (disableWSO2Repo == null) {
			MavenUtils.updateMavenRepo(mavenProject);
		}
		Repository globalRepositoryFromPreference = getGlobalRepositoryFromPreference();

		if (globalRepositoryFromPreference != null) {
			mavenProject.getModel().addRepository(
					globalRepositoryFromPreference);
			mavenProject.getModel().addPluginRepository(
					globalRepositoryFromPreference);
		}

		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}

	@Override
		public void openEditor(File file) {
		try{
		refreshDistProjects();
		IFile resource  = ResourcesPlugin
		.getWorkspace()
		.getRoot()
		.getFileForLocation(
				Path.fromOSString(file.getAbsolutePath()));
			String path = resource.getParent().getFullPath() + "/";
			String source = FileUtils.getContentAsString(file);
			Openable openable = ESBGraphicalEditor.getOpenable();
			openable.editorOpen(file.getName(), "messageStore", path + "messageStore_", source);
		}catch(Exception e){
			log.error("Cannot open the editor", e);
		}
	}
	
	public void copyImportFile(IContainer importLocation,boolean isNewAritfact, String groupId) throws IOException {
		File importFile = getModel().getImportFile();
		File destFile = null;
		List<OMElement> selectedList = ((MessageStoreModel)getModel()).getSelectedStoresList();
		if(selectedList != null && selectedList.size() >0 ){
			for (OMElement element : selectedList) {
				String name = element.getAttributeValue(new QName("name"));
				destFile = new File(importLocation.getLocation().toFile(), name + ".xml");
				FileUtils.createFile(destFile, element.toString());
				fileLst.add(destFile);
				if(isNewAritfact){
					String relativePath = FileUtils.getRelativePath(importLocation.getProject()
							.getLocation().toFile(), new File(importLocation.getLocation().toFile(),
							name + ".xml"));
					esbProjectArtifact.addESBArtifact(createArtifact(name, groupId,
							version, relativePath));
				}
			} 
			
		}else{
			destFile = new File(importLocation.getLocation().toFile(), importFile.getName());
			FileUtils.copy(importFile, destFile);
			fileLst.add(destFile);
			String name = importFile.getName().replaceAll(".xml$","");
			if(isNewAritfact){
				String relativePath = FileUtils.getRelativePath(importLocation.getProject()
						.getLocation().toFile(), new File(importLocation.getLocation().toFile(),
						name + ".xml"));
				esbProjectArtifact.addESBArtifact(createArtifact(name, groupId,
						version, relativePath));
			}
		}
		try {
			esbProjectArtifact.toFile();
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

}

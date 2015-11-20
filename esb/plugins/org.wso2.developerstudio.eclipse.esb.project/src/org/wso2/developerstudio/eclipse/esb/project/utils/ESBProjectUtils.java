/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.esb.project.utils;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;
import javax.xml.stream.FactoryConfigurationError;

import org.apache.axiom.om.OMElement;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.wso2.developerstudio.eclipse.esb.core.ESBMavenConstants;
import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.esb.project.ui.wizard.ESBProjectWizard;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class ESBProjectUtils {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	public static IProject createESBProject(Shell shell,File location){
		IWizardDescriptor wizardDesc = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard("org.wso2.developerstudio.eclipse.artifact.newesbproject");
		if (wizardDesc!=null) {
			try {
				IProject esbProject = null;
				ESBProjectWizard esbProjectWizard = (ESBProjectWizard) wizardDesc.createWizard();
				IStructuredSelection selection = (IStructuredSelection) PlatformUI
												.getWorkbench().getActiveWorkbenchWindow()
												.getSelectionService().getSelection();
				esbProjectWizard.init(PlatformUI.getWorkbench(), selection);
				WizardDialog dialog = new WizardDialog(shell, esbProjectWizard);
				esbProjectWizard.getModel().setLocation(location);
				dialog.create();
				if(dialog.open() ==Dialog.OK){
					String projectName = esbProjectWizard.getModel().getProjectName();
					esbProject = ResourcesPlugin.getWorkspace().getRoot()
							.getProject(projectName);
				}
				return esbProject;
			} catch (CoreException e) {
				log.error("CoreException has occurred",e);
			}
		}
		return null;
	}
	
	
	public static boolean artifactExists(IProject project, String artifactName) throws Exception {
		ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
		esbProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());
		List<ESBArtifact> allArtifacts = esbProjectArtifact.getAllESBArtifacts();
		for (ESBArtifact artifact : allArtifacts) {
			if (artifactName.equalsIgnoreCase(artifact.getName()))
				return true;
		}
		return false;
	}
	
	public static void createESBArtifacts(List<OMElement> selectedElementsList,IProject project,File pomfile,Map<File,String> fileList,
			String groupId) throws FactoryConfigurationError, Exception {
		if (selectedElementsList != null) {

			for (OMElement element : selectedElementsList) {

				String localName = element.getLocalName();
				String qName = element.getAttributeValue(new QName("name"));
				if (("".equals(qName)) || (qName == null)) {
					qName = element.getAttributeValue(new QName("key"));
					if (("".equals(qName)) || (qName == null)) {
						continue;
					}
				}
				//esbProjectModel.setName(qName);
				String commonESBPath = "src" + File.separator + "main"
						+ File.separator + "synapse-config" + File.separator;
				if (localName.equalsIgnoreCase("sequence")) {
					File baseDir = project
							.getFolder(commonESBPath + "sequences")
							.getLocation().toFile();
					File destFile = new File(baseDir, qName + ".xml");
					FileUtils.createFile(destFile, element.toString());
					MavenProject mavenProject = MavenUtils
							.getMavenProject(pomfile);
					addPluginEntry(mavenProject, "org.wso2.maven",
							"wso2-esb-sequence-plugin",
							ESBMavenConstants.WSO2_ESB_SEQUENCE_VERSION,
							"sequence");
					MavenUtils.saveMavenProject(mavenProject, pomfile);
					
					// Fixing TOOLS-1981.
					if (qName != null && qName.equalsIgnoreCase("main")) {
						fileList.put(destFile, "main_sequence");
					} else {
						fileList.put(destFile, "sequence");
					}
					createArtifactMetaDataEntry(qName, "synapse/sequence",
							baseDir, groupId + ".sequence",project);
				} else if (localName.equalsIgnoreCase("endpoint")) {
					File baseDir = project
							.getFolder(commonESBPath + "endpoints")
							.getLocation().toFile();
					File destFile = new File(baseDir, qName + ".xml");
					FileUtils.createFile(destFile, element.toString());
					MavenProject mavenProject = MavenUtils
							.getMavenProject(pomfile);
					addPluginEntry(mavenProject, "org.wso2.maven",
							"wso2-esb-endpoint-plugin",
							ESBMavenConstants.WSO2_ESB_ENDPOINT_VERSION,
							"endpoint");
					MavenUtils.saveMavenProject(mavenProject, pomfile);
					fileList.put(destFile, "endpoint");
					createArtifactMetaDataEntry(qName, "synapse/endpoint",
							baseDir, groupId + ".endpoint",project);
				} else if (localName.equalsIgnoreCase("proxy")) {
					File baseDir = project
							.getFolder(commonESBPath + "proxy-services")
							.getLocation().toFile();
					File destFile = new File(baseDir, qName + ".xml");
					FileUtils.createFile(destFile, element.toString());
					MavenProject mavenProject = MavenUtils
							.getMavenProject(pomfile);
					addPluginEntry(mavenProject, "org.wso2.maven",
							"wso2-esb-proxy-plugin",
							ESBMavenConstants.WSO2_ESB_PROXY_VERSION, "proxy");
					MavenUtils.saveMavenProject(mavenProject, pomfile);
					fileList.put(destFile, "proxy");
					createArtifactMetaDataEntry(qName, "synapse/proxy-service",
							baseDir, groupId + ".proxy-service",project);
				} else if (localName.equalsIgnoreCase("localEntry")) {
					File baseDir = project
							.getFolder(commonESBPath + "local-entries")
							.getLocation().toFile();
					File destFile = new File(baseDir, qName + ".xml");
					FileUtils.createFile(destFile, element.toString());
					MavenProject mavenProject = MavenUtils
							.getMavenProject(pomfile);
					addPluginEntry(mavenProject, "org.wso2.maven",
							"wso2-esb-localentry-plugin",
							ESBMavenConstants.WSO2_ESB_LOCAL_ENTRY_VERSION,
							"localentry");
					MavenUtils.saveMavenProject(mavenProject, pomfile);
					fileList.put(destFile, "localEntry");
					createArtifactMetaDataEntry(qName, "synapse/local-entry",
							baseDir, groupId + ".local-entry",project);
				} else if (localName.equalsIgnoreCase("task")) {
					File baseDir = project.getFolder(commonESBPath + "task")
							.getLocation().toFile();
					File destFile = new File(baseDir, qName + ".xml");
					FileUtils.createFile(destFile, element.toString());
					MavenProject mavenProject = MavenUtils
							.getMavenProject(pomfile);
					addPluginEntry(mavenProject, "org.wso2.maven",
							"wso2-esb-task-plugin",
							ESBMavenConstants.WSO2_ESB_TASK_VERSION, "task");
					MavenUtils.saveMavenProject(mavenProject, pomfile);
					fileList.put(destFile, "task");
					createArtifactMetaDataEntry(qName, "synapse/task", baseDir,
							groupId + ".task",project);
				} else if (localName.equalsIgnoreCase("api")) {
					File baseDir = project.getFolder(commonESBPath + "api")
							.getLocation().toFile();
					File destFile = new File(baseDir, qName + ".xml");
					FileUtils.createFile(destFile, element.toString());
					MavenProject mavenProject = MavenUtils
							.getMavenProject(pomfile);
					addPluginEntry(mavenProject, "org.wso2.maven",
							"wso2-esb-api-plugin",
							ESBMavenConstants.WSO2_ESB_API_VERSION, "api");
					MavenUtils.saveMavenProject(mavenProject, pomfile);
					fileList.put(destFile, "api");
					createArtifactMetaDataEntry(qName, "synapse/api", baseDir,
							groupId + ".api",project);
				} else if (localName.equalsIgnoreCase("messageStore")) {
					File baseDir = project.getFolder(commonESBPath + "message-stores")
							.getLocation().toFile();
					File destFile = new File(baseDir, qName + ".xml");
					FileUtils.createFile(destFile, element.toString());
					MavenProject mavenProject = MavenUtils
							.getMavenProject(pomfile);
					addPluginEntry(mavenProject, "org.wso2.maven",
							"wso2-esb-messagestore-plugin",
							ESBMavenConstants.WSO2_ESB_MESSAGE_STORE_PLUGIN_VERSION, "message-store");
					MavenUtils.saveMavenProject(mavenProject, pomfile);
					fileList.put(destFile, localName);
					createArtifactMetaDataEntry(qName, "synapse/message-store", baseDir,
							groupId + ".message-store",project);
				} else if (localName.equalsIgnoreCase("messageProcessor")) {
					File baseDir = project.getFolder(commonESBPath + "message-processors")
							.getLocation().toFile();
					File destFile = new File(baseDir, qName + ".xml");
					FileUtils.createFile(destFile, element.toString());
					MavenProject mavenProject = MavenUtils
							.getMavenProject(pomfile);
					addPluginEntry(mavenProject, "org.wso2.maven",
							"wso2-esb-messageprocessor-plugin",
							ESBMavenConstants.WSO2_ESB_MESSAGE_PROCESSOR_PLUGIN_VERSION, "message-processor");
					MavenUtils.saveMavenProject(mavenProject, pomfile);
					fileList.put(destFile, localName);
					createArtifactMetaDataEntry(qName, "synapse/message-processors", baseDir,
							groupId + ".message-processor",project);
				} else if (localName.equalsIgnoreCase("template")) {
					File baseDir = project.getFolder(commonESBPath + "templates")
							.getLocation().toFile();
					File destFile = new File(baseDir, qName + ".xml");
					
					if (element.getChildrenWithName(new QName("sequence")) != null
							&& element.getChildrenWithName(new QName("sequence")).hasNext()) {
						// Sequence template.
						FileUtils.createFile(destFile, element.toString());
						MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);
						addPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-template-plugin",
								ESBMavenConstants.WSO2_ESB_TEMPLATE_VERSION, "template");
						MavenUtils.saveMavenProject(mavenProject, pomfile);
						fileList.put(destFile, "template.sequence");
						createArtifactMetaDataEntry(qName, "synapse/sequenceTemplate", baseDir,
								groupId + ".template", project);
					} else if (element.getChildrenWithName(new QName("endpoint")) != null
							&& element.getChildrenWithName(new QName("endpoint")).hasNext()) {
						// Endpoint template.
						OMElement endpoint = (OMElement) element.getChildrenWithName(
								new QName("endpoint")).next();
						String endpointType = endpoint.getFirstElement().getLocalName();
						String templateType = "template.endpoint";
						
						if ("address".equals(endpointType)) {
							// Address endpoint template.
							templateType = templateType + "-1";
						} else if ("wsdl".equals(endpointType)) {
							// WSDL endpoint template.
							templateType = templateType + "-2";
						} else {
							// Default endpoint template. 
							templateType = templateType + "-0";
						}
						
						FileUtils.createFile(destFile, element.toString());
						MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);
						addPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-template-plugin",
								ESBMavenConstants.WSO2_ESB_TEMPLATE_VERSION, "template");
						MavenUtils.saveMavenProject(mavenProject, pomfile);
						fileList.put(destFile, templateType);
						createArtifactMetaDataEntry(qName, "synapse/endpointTemplate", baseDir,
								groupId + ".template", project);
					}
					
				}
			}
		}
	}
	
	public static void addPluginEntry(MavenProject mavenProject, String groupId, String artifactId, String version, String Id) {
	    List<Plugin> plugins = mavenProject.getBuild().getPlugins();
		for (Plugin plg : plugins) {
			if (plg.getGroupId().equalsIgnoreCase(groupId) && plg.getArtifactId().equalsIgnoreCase(artifactId)) {
				return;
			}
		}
		
		Plugin plugin = MavenUtils.createPluginEntry(mavenProject, groupId, artifactId, version, true);		
		PluginExecution pluginExecution = new PluginExecution();
		pluginExecution.addGoal("pom-gen");
		pluginExecution.setPhase("process-resources");
		pluginExecution.setId(Id);
		
		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
		Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
		artifactLocationNode.setValue(".");
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
		typeListNode.setValue("${artifact.types}");
		pluginExecution.setConfiguration(configurationNode);		
		plugin.addExecution(pluginExecution);
    }
	
	public static void createArtifactMetaDataEntry(String name, String type,
			File baseDir, String groupId,IProject project) throws FactoryConfigurationError,
			Exception {
		ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
		esbProjectArtifact.fromFile(project.getFile("artifact.xml")
				.getLocation().toFile());
		ESBArtifact artifact = new ESBArtifact();
		artifact.setName(name);
		artifact.setVersion("1.0.0");
		artifact.setType(type);
		artifact.setServerRole("EnterpriseServiceBus");
		artifact.setGroupId(groupId);
		artifact.setFile(FileUtils.getRelativePath(
				project.getLocation().toFile(),
				new File(baseDir, name + ".xml")).replaceAll(
				Pattern.quote(File.separator), "/"));
		esbProjectArtifact.addESBArtifact(artifact);
		esbProjectArtifact.toFile();
	}
	
	public static void updatePom(IProject project) throws Exception {

		File mavenProjectPomLocation = project.getFile("pom.xml").getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);

		addPluginEntry(mavenProject, "org.wso2.maven","wso2-esb-synapse-plugin", ESBMavenConstants.WSO2_ESB_SYNAPSE_VERSION,"synapse");
		
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	
	}	
	
	public static String getType(String dirName) {
		switch (dirName) {
		case "endpoints":
			return "endpoint";
		case "sequences":
			return "sequence";
		case "proxy-services":
			return "proxy-service";
		case "local-entries":
			return "local-entry";
		case "tasks":
			return "task";
		case "api":
			return "api";
		case "templates":
			return "sequenceTemplate";
		case "message-stores":
			return "message-store";
		case "message-processors":
			return "message-processors";	
		case "inbound-endpoints":
			return "inbound-endpoint";
		default:
			return "";
		}
	}
}

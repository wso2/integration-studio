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

package org.wso2.developerstudio.eclipse.integration.utils;

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
import org.wso2.developerstudio.eclipse.integration.core.IntegrationMavenConstants;
import org.wso2.developerstudio.eclipse.integration.project.Activator;
import org.wso2.developerstudio.eclipse.integration.project.artifact.IntegrationArtifact;
import org.wso2.developerstudio.eclipse.integration.project.artifact.IntegrationProjectArtifact;
import org.wso2.developerstudio.eclipse.integration.project.ui.wizard.IntegrationProjectWizard;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class IntegrationProjectUtils {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	public static IProject createIntegrationProject(Shell shell,File location){
		IWizardDescriptor wizardDesc = PlatformUI.getWorkbench().getNewWizardRegistry()
				.findWizard("org.wso2.developerstudio.eclipse.artifact.newintegrationproject"); //TODO
		if (wizardDesc!=null) {
			try {
				IProject esbProject = null;
				IntegrationProjectWizard esbProjectWizard = (IntegrationProjectWizard) wizardDesc.createWizard();
				IStructuredSelection selection = (IStructuredSelection) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getSelectionService().getSelection();
				esbProjectWizard.init(PlatformUI.getWorkbench(), selection);
				WizardDialog dialog = new WizardDialog(shell, esbProjectWizard);
				esbProjectWizard.getModel().setLocation(location);
				dialog.create();
				if(dialog.open() ==Dialog.OK){
					String projectName = esbProjectWizard.getModel().getProjectName();
					esbProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
				}
				return esbProject;
			} catch (CoreException e) {
				log.error("CoreException has occurred",e);
			}
		}
		return null;
	}
	
	
	public static boolean artifactExists(IProject project, String artifactName) throws Exception {
		IntegrationProjectArtifact esbProjectArtifact = new IntegrationProjectArtifact();
		esbProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());
		List<IntegrationArtifact> allArtifacts = esbProjectArtifact.getAllIntegrationArtifacts();
		for (IntegrationArtifact artifact : allArtifacts) {
			if (artifactName.equalsIgnoreCase(artifact.getName()))
				return true;
		}
		return false;
	}
	
	public static void createIntegrationArtifacts(List<OMElement> selectedElementsList,IProject project,
			File pomfile,Map<File,String> fileList,
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
				String commonIntegrationPath = "src" + File.separator + "main"
						+ File.separator + "integration-config" + File.separator;
				if (localName.equalsIgnoreCase("integration-template")) {
					File baseDir = project.getFolder(commonIntegrationPath + "integration-templates").getLocation().toFile();
					File destFile = new File(baseDir, qName + ".xml");
					FileUtils.createFile(destFile, element.toString());
					MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);
					addPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-integration-template-plugin",
							IntegrationMavenConstants.WSO2_INTEGRATION_INTEGRATION_TEMPLATE_VERSION,"integration-template");
					MavenUtils.saveMavenProject(mavenProject, pomfile);
					
//					// Fixing TOOLS-1981. TODO
//					if (qName != null && qName.equalsIgnoreCase("main")) {
//						fileList.put(destFile, "main_sequence");
//					} else {
//						fileList.put(destFile, "sequence");
//					}
					createArtifactMetaDataEntry(qName, "integration/integration-template", 
							baseDir, groupId + ".integration-template",project);
				} else if (localName.equalsIgnoreCase("connection")) {
					File baseDir = project.getFolder(commonIntegrationPath + "connections").getLocation().toFile();
					File destFile = new File(baseDir, qName + ".xml");
					FileUtils.createFile(destFile, element.toString());
					MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);
					addPluginEntry(mavenProject, "org.wso2.maven",
							"wso2-integration-connection-plugin",
							IntegrationMavenConstants.WSO2_INTEGRATION_CONNECTION_VERSION,
							"connection");
					MavenUtils.saveMavenProject(mavenProject, pomfile);
					fileList.put(destFile, "connection");
					createArtifactMetaDataEntry(qName, "integration/connection",baseDir, groupId + ".connection",project);
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
		IntegrationProjectArtifact integrationProjectArtifact = new IntegrationProjectArtifact();
		integrationProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());
		IntegrationArtifact artifact = new IntegrationArtifact();
		artifact.setName(name);
		artifact.setVersion("1.0.0");
		artifact.setType(type);
		artifact.setServerRole("EnterpriseServiceBus");//TODO
		artifact.setGroupId(groupId);
		artifact.setFile(FileUtils.getRelativePath(project.getLocation().toFile(),
				new File(baseDir, name + ".xml")).replaceAll(Pattern.quote(File.separator), "/"));
		integrationProjectArtifact.addIntegrationArtifact(artifact);
		integrationProjectArtifact.toFile();
	}
	
	public static void updatePom(IProject project) throws Exception {

		File mavenProjectPomLocation = project.getFile("pom.xml").getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);

		addPluginEntry(mavenProject, "org.wso2.maven","wso2-esb-integration-plugin", 
				IntegrationMavenConstants.WSO2_INTEGRATION_INTEGRATION_VERSION,"integration");
		
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	
	}	
	
	public static String getType(String dirName) {
		switch (dirName) {
		case "integration-templates":
			return "integration";
		case "connections":
			return "connection";
		default:
			return "";
		}
	}
}

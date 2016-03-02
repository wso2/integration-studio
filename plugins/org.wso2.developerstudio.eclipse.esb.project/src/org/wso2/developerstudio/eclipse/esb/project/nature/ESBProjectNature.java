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

package org.wso2.developerstudio.eclipse.esb.project.nature;

import java.io.File;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.wso2.developerstudio.eclipse.esb.core.ESBMavenConstants;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.nature.AbstractWSO2ProjectNature;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class ESBProjectNature extends AbstractWSO2ProjectNature {
	private static final String CAPP_TYPE = "bpel/workflow=zip,lib/registry/filter=jar,webapp/jaxws=war,lib/library/bundle=jar,service/dataservice=dbs,synapse/local-entry=xml,synapse/proxy-service=xml,carbon/application=car,registry/resource=zip,lib/dataservice/validator=jar,synapse/endpoint=xml,web/application=war,lib/carbon/ui=jar,service/axis2=aar,synapse/sequence=xml,synapse/configuration=xml,wso2/gadget=dar,lib/registry/handlers=jar,lib/synapse/mediator=jar,synapse/task=xml,synapse/api=xml,synapse/template=xml,synapse/message-store=xml,synapse/message-processors=xml,synapse/inbound-endpoint=xml";
	
	public void configure() throws CoreException {
		String[] childrenList = { "endpoints", "proxy-services", "sequences", "local-entries",
				"tasks", "templates", "api", "message-stores", "message-processors", "inbound-endpoints"};
		IFolder parentFolder =
		        ProjectUtils.getWorkspaceFolder(getProject(), "src", "main", "synapse-config");
		ProjectUtils.createFolder(parentFolder);
		getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		for (String child : childrenList) {
			createChildren(parentFolder, child);
		}
		updatePom();
	}

	private void updatePom() {
		// TODO update the pom with the relavant packaging types & maven pligins
		File mavenProjectPomLocation = getProject().getFile("pom.xml").getLocation().toFile();
		try {
			MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
			//Adding typrLidt property
			MavenUtils.updateMavenProjectWithCAppType(mavenProject, CAPP_TYPE);
			//Setting the directory
			mavenProject.getBuild().setDirectory("target/capp");
//			Adding maven test skip property
			MavenUtils.updateMavenProjectWithSkipTests(mavenProject);
			
			//Adding maven exec plugin entry
			Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.codehaus.mojo", "exec-maven-plugin", "1.4.0", true);
		
			{
				PluginExecution pluginExecution = new PluginExecution();
				pluginExecution.setId(ESBMavenConstants.PACKAGE_PHASE);
				pluginExecution.addGoal(ESBMavenConstants.EXEC_GOAL);
				pluginExecution.setPhase(ESBMavenConstants.PACKAGE_PHASE);

				Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
				Xpp3Dom executableNode = MavenUtils.createXpp3Node(configurationNode, ESBMavenConstants.EXECUTABLE_TAG);
				executableNode.setValue(ESBMavenConstants.EXECUTABLE_VALUE);
				Xpp3Dom workingDirectoryNode = MavenUtils.createXpp3Node(configurationNode,
						ESBMavenConstants.WORKING_DIRECTORY_TAG);
				workingDirectoryNode.setValue(ESBMavenConstants.WORKING_DIRECTORY_VALUE);
				Xpp3Dom argumentsNode = MavenUtils.createXpp3Node(configurationNode, ESBMavenConstants.ARGUMENTS_TAG);
				Xpp3Dom cleanArgumentNode = MavenUtils.createXpp3Node(argumentsNode, ESBMavenConstants.ARGUMENT_TAG);
				cleanArgumentNode.setValue(ESBMavenConstants.ARGUMENT_VALUE_CLEAN);
				Xpp3Dom installArgumentNode = MavenUtils.createXpp3Node(argumentsNode, ESBMavenConstants.ARGUMENT_TAG);
				installArgumentNode.setValue(ESBMavenConstants.PACKAGE_PHASE);
				Xpp3Dom testSkipArgumentNode = MavenUtils.createXpp3Node(argumentsNode, ESBMavenConstants.ARGUMENT_TAG);
				testSkipArgumentNode.setValue(ESBMavenConstants.ARGUMENT_VALUE_SKIP_TESTS);

				pluginExecution.setConfiguration(configurationNode);

				plugin.addExecution(pluginExecution);
			}
			{
				PluginExecution pluginExecution = new PluginExecution();
				pluginExecution.setId(ESBMavenConstants.INSTALL_PHASE);
				pluginExecution.addGoal(ESBMavenConstants.EXEC_GOAL);
				pluginExecution.setPhase(ESBMavenConstants.INSTALL_PHASE);

				Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
				Xpp3Dom executableNode = MavenUtils.createXpp3Node(configurationNode, ESBMavenConstants.EXECUTABLE_TAG);
				executableNode.setValue(ESBMavenConstants.EXECUTABLE_VALUE);
				Xpp3Dom workingDirectoryNode = MavenUtils.createXpp3Node(configurationNode,
						ESBMavenConstants.WORKING_DIRECTORY_TAG);
				workingDirectoryNode.setValue(ESBMavenConstants.WORKING_DIRECTORY_VALUE);
				Xpp3Dom argumentsNode = MavenUtils.createXpp3Node(configurationNode, ESBMavenConstants.ARGUMENTS_TAG);
				Xpp3Dom cleanArgumentNode = MavenUtils.createXpp3Node(argumentsNode, ESBMavenConstants.ARGUMENT_TAG);
				cleanArgumentNode.setValue(ESBMavenConstants.ARGUMENT_VALUE_CLEAN);
				Xpp3Dom installArgumentNode = MavenUtils.createXpp3Node(argumentsNode, ESBMavenConstants.ARGUMENT_TAG);
				installArgumentNode.setValue(ESBMavenConstants.INSTALL_PHASE);
				Xpp3Dom testSkipArgumentNode = MavenUtils.createXpp3Node(argumentsNode, ESBMavenConstants.ARGUMENT_TAG);
				testSkipArgumentNode.setValue(ESBMavenConstants.ARGUMENT_VALUE_SKIP_TESTS);

				pluginExecution.setConfiguration(configurationNode);

				plugin.addExecution(pluginExecution);
			}
			{
				PluginExecution pluginExecution = new PluginExecution();
				pluginExecution.setId(ESBMavenConstants.DEPLOY_PHASE);
				pluginExecution.addGoal(ESBMavenConstants.EXEC_GOAL);
				pluginExecution.setPhase(ESBMavenConstants.DEPLOY_PHASE);

				Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
				Xpp3Dom executableNode = MavenUtils.createXpp3Node(configurationNode, ESBMavenConstants.EXECUTABLE_TAG);
				executableNode.setValue(ESBMavenConstants.EXECUTABLE_VALUE);
				Xpp3Dom workingDirectoryNode = MavenUtils.createXpp3Node(configurationNode,
						ESBMavenConstants.WORKING_DIRECTORY_TAG);
				workingDirectoryNode.setValue(ESBMavenConstants.WORKING_DIRECTORY_VALUE);
				Xpp3Dom argumentsNode = MavenUtils.createXpp3Node(configurationNode, ESBMavenConstants.ARGUMENTS_TAG);
				Xpp3Dom deployArgumentNode = MavenUtils.createXpp3Node(argumentsNode, ESBMavenConstants.ARGUMENT_TAG);
				deployArgumentNode.setValue(ESBMavenConstants.DEPLOY_PHASE);
				Xpp3Dom testSkipArgumentNode = MavenUtils.createXpp3Node(argumentsNode, ESBMavenConstants.ARGUMENT_TAG);
				testSkipArgumentNode.setValue(ESBMavenConstants.ARGUMENT_VALUE_SKIP_TESTS);

				pluginExecution.setConfiguration(configurationNode);

				plugin.addExecution(pluginExecution);
			}
			MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
			
		} catch (Exception e) {
			// TODO Handle this properly.
			e.printStackTrace();
		}
		
		try {
			getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Handle this properly.
			e.printStackTrace();
		}
	}

	public void createChildren(IFolder parent, String... children) throws CoreException {
		IFolder childFolder = ProjectUtils.getWorkspaceFolder(parent, children);
		ProjectUtils.createFolder(childFolder);
		getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

	}

	
	public void deconfigure() throws CoreException {
		// TODO Auto-generated method stub

	}
}

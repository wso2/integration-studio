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

package org.wso2.developerstudio.eclipse.artifact.connector.project.nature;

import java.io.File;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.wso2.developerstudio.eclipse.artifact.connector.Activator;
import org.wso2.developerstudio.eclipse.esb.core.ESBMavenConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.nature.AbstractWSO2ProjectNature;

public class ConnectorProjectNature extends AbstractWSO2ProjectNature {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String CAPP_TYPE = "synapse/lib";

	public void configure() {
		updatePom();
	}

	private void updatePom() {
		// TODO update the pom with the relavant packaging types & maven pligins
		File mavenProjectPomLocation = getProject().getFile("pom.xml").getLocation().toFile();
		try {
			MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
			// Adding typrLidt property
			MavenUtils.updateMavenProjectWithCAppType(mavenProject, CAPP_TYPE);
			// Setting the directory
			mavenProject.getBuild().setDirectory("target/capp");
			// Adding maven test skip property
			MavenUtils.updateMavenProjectWithSkipTests(mavenProject);

			// Adding maven exec plugin entry
			Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.codehaus.mojo", "exec-maven-plugin",
					"1.4.0", true);

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
			log.error(e);
		}

		try {
			getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			log.error(e);
		}
	}

	public void deconfigure() throws CoreException {
		
	}
}

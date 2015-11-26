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
package org.wso2.developerstudio.eclipse.artifact.analytics.project.nature;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.wso2.developerstudio.eclipse.artifact.analytics.Activator;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsConstants;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsMavenConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.nature.AbstractWSO2ProjectNature;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

import java.io.File;

public class AnalyticsProjectNature extends AbstractWSO2ProjectNature {

    private static final String CAPP_TYPE = "event/stream=json,event/publisher=xml,event/receiver=xml,event/execution-plan=siddhiql,bpel/workflow=zip,lib/registry/filter=jar,webapp/jaxws=war,lib/library/bundle=jar,service/dataservice=dbs,synapse/local-entry=xml,synapse/proxy-service=xml,carbon/application=car,registry/resource=zip,lib/dataservice/validator=jar,synapse/endpoint=xml,web/application=war,lib/carbon/ui=jar,service/axis2=aar,synapse/sequence=xml,synapse/configuration=xml,wso2/gadget=dar,lib/registry/handlers=jar,lib/synapse/mediator=jar,synapse/task=xml,synapse/api=xml,synapse/template=xml,synapse/message-store=xml,synapse/message-processors=xml,synapse/inbound-endpoint=xml";
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public void configure() throws CoreException {
        String[] childrenList = {AnalyticsConstants.ANALYTICS_STREAM_DIR, AnalyticsConstants.ANALYTICS_PUBLISHER_DIR,
                AnalyticsConstants.ANALYTICS_RECEIVER_DIR, AnalyticsConstants.ANALYTICS_EXECUTION_PLAN_DIR};
        IFolder parentFolder =
                ProjectUtils.getWorkspaceFolder(getProject(), "src", "main");
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
            Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.codehaus.mojo", "exec-maven-plugin", "1.2", true);
            {
                PluginExecution pluginExecution = new PluginExecution();
                pluginExecution.setId(AnalyticsMavenConstants.PACKAGE_PHASE);
                pluginExecution.addGoal(AnalyticsMavenConstants.EXEC_GOAL);
                pluginExecution.setPhase(AnalyticsMavenConstants.PACKAGE_PHASE);

                Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
                Xpp3Dom executableNode = MavenUtils.createXpp3Node(configurationNode, AnalyticsMavenConstants.EXECUTABLE_TAG);
                executableNode.setValue(AnalyticsMavenConstants.EXECUTABLE_VALUE);
                Xpp3Dom workingDirectoryNode = MavenUtils.createXpp3Node(configurationNode,
                		AnalyticsMavenConstants.WORKING_DIRECTORY_TAG);
                workingDirectoryNode.setValue(AnalyticsMavenConstants.WORKING_DIRECTORY_VALUE);
                Xpp3Dom argumentsNode = MavenUtils.createXpp3Node(configurationNode, AnalyticsMavenConstants.ARGUMENTS_TAG);
                Xpp3Dom cleanArgumentNode = MavenUtils.createXpp3Node(argumentsNode, AnalyticsMavenConstants.ARGUMENT_TAG);
                cleanArgumentNode.setValue(AnalyticsMavenConstants.ARGUMENT_VALUE_CLEAN);
                Xpp3Dom installArgumentNode = MavenUtils.createXpp3Node(argumentsNode, AnalyticsMavenConstants.ARGUMENT_TAG);
                installArgumentNode.setValue(AnalyticsMavenConstants.PACKAGE_PHASE);
                Xpp3Dom testSkipArgumentNode = MavenUtils.createXpp3Node(argumentsNode, AnalyticsMavenConstants.ARGUMENT_TAG);
                testSkipArgumentNode.setValue(AnalyticsMavenConstants.ARGUMENT_VALUE_SKIP_TESTS);

               pluginExecution.setConfiguration(configurationNode);

                plugin.addExecution(pluginExecution);
            }
            {
                PluginExecution pluginExecution = new PluginExecution();
                pluginExecution.setId(AnalyticsMavenConstants.INSTALL_PHASE);
                pluginExecution.addGoal(AnalyticsMavenConstants.EXEC_GOAL);
                pluginExecution.setPhase(AnalyticsMavenConstants.INSTALL_PHASE);

                Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
                Xpp3Dom executableNode = MavenUtils.createXpp3Node(configurationNode, AnalyticsMavenConstants.EXECUTABLE_TAG);
                executableNode.setValue(AnalyticsMavenConstants.EXECUTABLE_VALUE);
                Xpp3Dom workingDirectoryNode = MavenUtils.createXpp3Node(configurationNode,
                		AnalyticsMavenConstants.WORKING_DIRECTORY_TAG);
                workingDirectoryNode.setValue(AnalyticsMavenConstants.WORKING_DIRECTORY_VALUE);
                Xpp3Dom argumentsNode = MavenUtils.createXpp3Node(configurationNode, AnalyticsMavenConstants.ARGUMENTS_TAG);
                Xpp3Dom cleanArgumentNode = MavenUtils.createXpp3Node(argumentsNode, AnalyticsMavenConstants.ARGUMENT_TAG);
                cleanArgumentNode.setValue(AnalyticsMavenConstants.ARGUMENT_VALUE_CLEAN);
                Xpp3Dom installArgumentNode = MavenUtils.createXpp3Node(argumentsNode, AnalyticsMavenConstants.ARGUMENT_TAG);
                installArgumentNode.setValue(AnalyticsMavenConstants.INSTALL_PHASE);
                Xpp3Dom testSkipArgumentNode = MavenUtils.createXpp3Node(argumentsNode, AnalyticsMavenConstants.ARGUMENT_TAG);
                testSkipArgumentNode.setValue(AnalyticsMavenConstants.ARGUMENT_VALUE_SKIP_TESTS);

                pluginExecution.setConfiguration(configurationNode);

                plugin.addExecution(pluginExecution);
            }
            {
                PluginExecution pluginExecution = new PluginExecution();
                pluginExecution.setId(AnalyticsMavenConstants.DEPLOY_PHASE);
                pluginExecution.addGoal(AnalyticsMavenConstants.EXEC_GOAL);
                pluginExecution.setPhase(AnalyticsMavenConstants.DEPLOY_PHASE);

                Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
                Xpp3Dom executableNode = MavenUtils.createXpp3Node(configurationNode, AnalyticsMavenConstants.EXECUTABLE_TAG);
                executableNode.setValue(AnalyticsMavenConstants.EXECUTABLE_VALUE);
                Xpp3Dom workingDirectoryNode = MavenUtils.createXpp3Node(configurationNode,
                		AnalyticsMavenConstants.WORKING_DIRECTORY_TAG);
                workingDirectoryNode.setValue(AnalyticsMavenConstants.WORKING_DIRECTORY_VALUE);
                Xpp3Dom argumentsNode = MavenUtils.createXpp3Node(configurationNode, AnalyticsMavenConstants.ARGUMENTS_TAG);
                Xpp3Dom deployArgumentNode = MavenUtils.createXpp3Node(argumentsNode, AnalyticsMavenConstants.ARGUMENT_TAG);
                deployArgumentNode.setValue(AnalyticsMavenConstants.DEPLOY_PHASE);
                Xpp3Dom testSkipArgumentNode = MavenUtils.createXpp3Node(argumentsNode, AnalyticsMavenConstants.ARGUMENT_TAG);
                testSkipArgumentNode.setValue(AnalyticsMavenConstants.ARGUMENT_VALUE_SKIP_TESTS);

                pluginExecution.setConfiguration(configurationNode);

                plugin.addExecution(pluginExecution);
            }
            MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);

        } catch (Exception e) {
            log.error("Exception: " + e.getMessage(), e);
        }

        try {
            getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
        } catch (CoreException e) {
            log.error("Core Exception: " + e.getMessage(), e);
        }
    }

    public void createChildren(IFolder parent, String... children) throws CoreException {
        IFolder childFolder = ProjectUtils.getWorkspaceFolder(parent, children);
        ProjectUtils.createFolder(childFolder);
        getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

    }


    public void deconfigure() throws CoreException {

    }
}

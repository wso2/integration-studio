/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.dataserviceTemplate.wizard;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Util class to for sample template creation of DSS Projects.
 */
public class DSSProjectCreationUtil {

    public static final String PACKAGE_PHASE = "package";
    public static final String EXEC_GOAL = "exec";
    public static final String INSTALL_PHASE = "install";
    public static final String DEPLOY_PHASE = "deploy";
    public static final String EXECUTABLE_TAG = "executable";
    public static final String EXECUTABLE_VALUE = "mvn";
    public static final String WORKING_DIRECTORY_TAG = "workingDirectory";
    public static final String WORKING_DIRECTORY_VALUE = "${project.build.directory}";
    public static final String ARGUMENTS_TAG = "arguments";
    public static final String ARGUMENT_TAG = "argument";
    public static final String ARGUMENT_VALUE_CLEAN = "clean";
    public static final String ARGUMENT_VALUE_SKIP_TESTS = "-Dmaven.test.skip=${maven.test.skip}";
    private static final String CAPP_TYPE = "bpel/workflow=zip,lib/registry/filter=jar,webapp/jaxws=war,lib/library/bundle=jar,service/dataservice=dbs,synapse/local-entry=xml,synapse/proxy-service=xml,carbon/application=car,registry/resource=zip,lib/dataservice/validator=jar,synapse/endpoint=xml,web/application=war,lib/carbon/ui=jar,service/axis2=aar,synapse/sequence=xml,synapse/configuration=xml,wso2/gadget=dar,lib/registry/handlers=jar,lib/synapse/mediator=jar,synapse/task=xml,synapse/api=xml,synapse/template=xml,synapse/message-store=xml,synapse/message-processors=xml,synapse/inbound-endpoint=xml";

    /**
     * Update the pom file for DataService Project.
     *
     * @param mavenProjectPomLocation
     * @param project
     * @throws Exception
     */
    public static void updatePom(File mavenProjectPomLocation, IProject project) throws Exception {
        try {
            MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
            // Adding typrLidt property
            MavenUtils.updateMavenProjectWithCAppType(mavenProject, CAPP_TYPE);
            // Setting the directory
            mavenProject.getBuild().setDirectory("target/capp");
            // Adding maven test skip property
            MavenUtils.updateMavenProjectWithSkipTests(mavenProject);

            // Adding maven exec plugin entry
            Plugin plugin = MavenUtils
                    .createPluginEntry(mavenProject, "org.codehaus.mojo", "exec-maven-plugin", "1.4.0", true);

            {
                PluginExecution pluginExecution = new PluginExecution();
                pluginExecution.setId(PACKAGE_PHASE);
                pluginExecution.addGoal(EXEC_GOAL);
                pluginExecution.setPhase(PACKAGE_PHASE);

                Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
                Xpp3Dom executableNode = MavenUtils.createXpp3Node(configurationNode, EXECUTABLE_TAG);
                executableNode.setValue(EXECUTABLE_VALUE);
                Xpp3Dom workingDirectoryNode = MavenUtils.createXpp3Node(configurationNode, WORKING_DIRECTORY_TAG);
                workingDirectoryNode.setValue(WORKING_DIRECTORY_VALUE);
                Xpp3Dom argumentsNode = MavenUtils.createXpp3Node(configurationNode, ARGUMENTS_TAG);
                Xpp3Dom cleanArgumentNode = MavenUtils.createXpp3Node(argumentsNode, ARGUMENT_TAG);
                cleanArgumentNode.setValue(ARGUMENT_VALUE_CLEAN);
                Xpp3Dom installArgumentNode = MavenUtils.createXpp3Node(argumentsNode, ARGUMENT_TAG);
                installArgumentNode.setValue(PACKAGE_PHASE);
                Xpp3Dom testSkipArgumentNode = MavenUtils.createXpp3Node(argumentsNode, ARGUMENT_TAG);
                testSkipArgumentNode.setValue(ARGUMENT_VALUE_SKIP_TESTS);

                pluginExecution.setConfiguration(configurationNode);

                plugin.addExecution(pluginExecution);
            }
            {
                PluginExecution pluginExecution = new PluginExecution();
                pluginExecution.setId(INSTALL_PHASE);
                pluginExecution.addGoal(EXEC_GOAL);
                pluginExecution.setPhase(INSTALL_PHASE);

                Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
                Xpp3Dom executableNode = MavenUtils.createXpp3Node(configurationNode, EXECUTABLE_TAG);
                executableNode.setValue(EXECUTABLE_VALUE);
                Xpp3Dom workingDirectoryNode = MavenUtils.createXpp3Node(configurationNode, WORKING_DIRECTORY_TAG);
                workingDirectoryNode.setValue(WORKING_DIRECTORY_VALUE);
                Xpp3Dom argumentsNode = MavenUtils.createXpp3Node(configurationNode, ARGUMENTS_TAG);
                Xpp3Dom cleanArgumentNode = MavenUtils.createXpp3Node(argumentsNode, ARGUMENT_TAG);
                cleanArgumentNode.setValue(ARGUMENT_VALUE_CLEAN);
                Xpp3Dom installArgumentNode = MavenUtils.createXpp3Node(argumentsNode, ARGUMENT_TAG);
                installArgumentNode.setValue(INSTALL_PHASE);
                Xpp3Dom testSkipArgumentNode = MavenUtils.createXpp3Node(argumentsNode, ARGUMENT_TAG);
                testSkipArgumentNode.setValue(ARGUMENT_VALUE_SKIP_TESTS);

                pluginExecution.setConfiguration(configurationNode);

                plugin.addExecution(pluginExecution);
            }
            {
                PluginExecution pluginExecution = new PluginExecution();
                pluginExecution.setId(DEPLOY_PHASE);
                pluginExecution.addGoal(EXEC_GOAL);
                pluginExecution.setPhase(DEPLOY_PHASE);

                Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
                Xpp3Dom executableNode = MavenUtils.createXpp3Node(configurationNode, EXECUTABLE_TAG);
                executableNode.setValue(EXECUTABLE_VALUE);
                Xpp3Dom workingDirectoryNode = MavenUtils.createXpp3Node(configurationNode, WORKING_DIRECTORY_TAG);
                workingDirectoryNode.setValue(WORKING_DIRECTORY_VALUE);
                Xpp3Dom argumentsNode = MavenUtils.createXpp3Node(configurationNode, ARGUMENTS_TAG);
                Xpp3Dom deployArgumentNode = MavenUtils.createXpp3Node(argumentsNode, ARGUMENT_TAG);
                deployArgumentNode.setValue(DEPLOY_PHASE);
                Xpp3Dom testSkipArgumentNode = MavenUtils.createXpp3Node(argumentsNode, ARGUMENT_TAG);
                testSkipArgumentNode.setValue(ARGUMENT_VALUE_SKIP_TESTS);

                pluginExecution.setConfiguration(configurationNode);

                plugin.addExecution(pluginExecution);
            }
            MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
        } catch (Exception e) {
            // TODO 
        }

        try {
            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
        } catch (CoreException e) {
            // TODO 

        }
    }

    /**
     * Copy the DataService Artifacts.
     *
     * @param dssProject
     * @param sampleName
     * @param artifactName
     * @param dssProjectArtifact
     * @param groupID
     */
    public static void copyArtifact(IProject dssProject, String sampleName, String artifactName,
            DSSProjectArtifact dssProjectArtifact, String groupID) {

        IContainer location = dssProject.getFolder("dataservice");

        try {
            File importFile = ResourceTemplateUtils.getInstance().getResourceFile(
                    "Samples" + File.separator + sampleName + File.separator + "dataservice" + File.separator
                            + artifactName + ".dbs");
            IFile newArtifact = location.getFile(new Path(artifactName + ".dbs"));
            File destFile = newArtifact.getLocation().toFile();
            FileUtils.copy(importFile, destFile);
            updatePomForArtifact(dssProject, "dataservice");

            String relativePath = FileUtils.getRelativePath(location.getProject().getLocation().toFile(),
                    new File(location.getLocation().toFile(), artifactName + ".dbs"))
                    .replaceAll(Pattern.quote(File.separator), "/");

            dssProjectArtifact
                    .addDSSArtifact(createArtifact(artifactName, groupID, "1.0.0", relativePath, "dataservice"));
            dssProjectArtifact.toFile();
        } catch (Exception e) {
            // TODO 
        }

    }

    private static DSSArtifact createArtifact(String name, String groupId, String version, String path, String type) {
        DSSArtifact artifact = new DSSArtifact();
        artifact.setName(name);
        artifact.setVersion(version);
        artifact.setType("synapse/" + type);
        artifact.setServerRole("DataServicesServer");
        artifact.setGroupId(groupId);
        artifact.setFile(path);
        return artifact;
    }

    /**
     * @param project
     * @param type    - the name appended in artifact.xml file
     * @throws IOException
     * @throws XmlPullParserException
     */
    public static void updatePomForArtifact(IProject project, String type) throws IOException, XmlPullParserException {

        String pluginVersion = "2.1.0";
        String pluginName = "maven-" + type + "-plugin"; // corresponding plugin name in POM.

        File mavenProjectPomLocation = project.getFile("pom.xml").getLocation().toFile();
        MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);

        // Skip changing the pom file if group ID and artifact ID are matched
        if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", pluginName)) {
            return;
        }

        Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", pluginName, pluginVersion, true);
        PluginExecution pluginExecution = new PluginExecution();
        pluginExecution.addGoal("pom-gen");
        pluginExecution.setPhase("process-resources");
        pluginExecution.setId(type);

        Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
        Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
        artifactLocationNode.setValue(".");
        Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
        typeListNode.setValue("${artifact.types}");
        pluginExecution.setConfiguration(configurationNode);
        plugin.addExecution(pluginExecution);
        MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
    }

}

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

package org.wso2.developerstudio.eclipse.esb.dashboard.templates.wizard;

import java.io.File;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.model.Repository;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.wso2.developerstudio.eclipse.general.project.artifact.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.RegistryArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryElement;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryItem;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

/**
 * Util class to for sample template creation of Registry Resource Projects.
 */
public class RegistryProjectCreationUtil {

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

    /**
     * Copy the RegistryResource Artifacts related to Data mapper and update the Artifact.xml file
     */
    public static void copyArtifact(IProject registryProject, String sampleName, String artifactName,
            GeneralProjectArtifact registryArtifact, String groupID) {

        IContainer location = registryProject;
        String[] fileTypes = {
                "_inputSchema.json", "_outputSchema.json", ".dmc", ".datamapper_diagram", ".datamapper"
        };

        try {
            for (String fileType : fileTypes) {
                File importFile = ResourceUtils.getInstance().getResourceFile(
                        "Samples" + File.separator + sampleName + File.separator + artifactName + fileType);
                IFile newArtifact = location.getFile(new Path(artifactName + fileType));
                File destFile = newArtifact.getLocation().toFile();
                FileUtils.copy(importFile, destFile);

                if (fileType.contains(".json") || fileType.contains(".dmc")) {
                    updateArtifactXML(registryProject, artifactName + fileType, groupID + ".resource");
                }
            }
            registryProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
        } catch (Exception e) {
        }
    }

    /**
     * Update artifact.xml of registry resource for Data Mapper Resources.
     *
     * @param registryProject
     * @param artifactName
     * @param groupID
     * @throws Exception
     */
    private static void updateArtifactXML(IProject registryProject, String artifactName, String groupID)
            throws Exception {

        GeneralProjectArtifact generalProjectArtifact = new GeneralProjectArtifact();
        generalProjectArtifact.fromFile(registryProject.getFile("artifact.xml").getLocation().toFile());

        RegistryArtifact artifact = new RegistryArtifact();
        artifact.setName(artifactName.substring(0, artifactName.indexOf(".")));
        artifact.setVersion("1.0.0");
        artifact.setType("registry/resource");
        artifact.setServerRole("EnterpriseServiceBus");
        artifact.setGroupId(groupID);

        if (artifact.getType() == "registry/resource") {
            RegistryElement item = new RegistryItem();
            ((RegistryItem) item).setFile(artifactName);
            ((RegistryItem) item).setMediaType("text/plain");

            if (item != null) {
                item.setPath("/_system/governance/datamapper");
                artifact.addRegistryElement(item);
            }
        }
        generalProjectArtifact.addArtifact(artifact);
        generalProjectArtifact.toFile();
    }

    public static void updateRegistryResourcePOM(IProject registryResourceProject) throws Exception {
        MavenProject mavenProject;
        File mavenProjectPomLocation = registryResourceProject.getFile("pom.xml").getLocation().toFile();
        if (!mavenProjectPomLocation.exists()) {
            mavenProject = MavenUtils.createMavenProject("org.wso2.carbon." + registryResourceProject.getName(),
                    registryResourceProject.getName(), "1.0.0", "pom");
        } else {
            mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
        }

        // Skip changing the pom file if group ID and artifact ID are matched
        if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", "wso2-general-project-plugin")) {
            return;
        }

        Plugin plugin = MavenUtils
                .createPluginEntry(mavenProject, "org.wso2.maven", "wso2-general-project-plugin", "2.1.1", true);
        PluginExecution pluginExecution;
        pluginExecution = new PluginExecution();
        pluginExecution.addGoal("pom-gen");
        pluginExecution.setPhase("process-resources");
        pluginExecution.setId("registry");
        plugin.addExecution(pluginExecution);

        Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
        Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
        artifactLocationNode.setValue(".");
        Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
        typeListNode.setValue("${artifact.types}");
        pluginExecution.setConfiguration(configurationNode);

        Repository repo = new Repository();
        repo.setUrl("http://dist.wso2.org/maven2");
        repo.setId("wso2-maven2-repository-1");

        Repository repo1 = new Repository();
        repo1.setUrl("http://maven.wso2.org/nexus/content/groups/wso2-public/");
        repo1.setId("wso2-nexus-maven2-repository-1");

        mavenProject.getModel().addRepository(repo);
        mavenProject.getModel().addPluginRepository(repo);
        mavenProject.getModel().addRepository(repo1);
        mavenProject.getModel().addPluginRepository(repo1);
        MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);

    }
}

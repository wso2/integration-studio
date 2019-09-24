/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.docker.distribution.ui.wizard;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.Xpp3DomBuilder;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.distribution.project.util.ArtifactTypeMapping;
import org.wso2.developerstudio.eclipse.docker.distribution.Activator;
import org.wso2.developerstudio.eclipse.docker.distribution.model.DockerModel;
import org.wso2.developerstudio.eclipse.docker.distribution.utils.DockerImageUtils;
import org.wso2.developerstudio.eclipse.docker.distribution.utils.DockerProjectConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.MavenDetailsPage;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

/**
 * Wizard to create a new Docker project.
 */
public class ContainerProjectCreationWizard extends AbstractWSO2ProjectCreationWizard implements IExecutableExtension {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static final String POM_FILE = "pom.xml";
    private IProject project;
    private DockerModel dockerModel;

    public ContainerProjectCreationWizard() {
        this.dockerModel = new DockerModel();
        setModel(this.dockerModel);
        setWindowTitle(DockerProjectConstants.DS_WIZARD_WINDOW_TITLE);
        setDefaultPageImageDescriptor(DockerImageUtils.getInstance().getImageDescriptor("ds-wizard.png"));
    }

    private void createFolder(String folderName) throws CoreException {
        IFolder carbonAppsFolder = ProjectUtils.getWorkspaceFolder(project, folderName);
        if (!carbonAppsFolder.exists()) {
            // creates the CarbonAppsFolder
            ProjectUtils.createFolder(carbonAppsFolder);
        }
    }

    /**
     * Create new docker file in the project directory if not exists.
     * 
     * @throws IOException An error occurred while writing the file
     */
    private void copyDockerFile() throws IOException {
        IFile dockerFile = project.getFile(DockerProjectConstants.DOCKER_FILE_NAME);
        File newFile = new File(dockerFile.getLocationURI().getPath());
        if (!newFile.exists()) {
            // Creating the new docker file
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FROM ");
            
            String remoteRepository;
            String remoteTag;
            if (dockerModel.isContainerExporterProjectChecked() && dockerModel.isDockerContainerSelected()) {
                remoteRepository = dockerModel.getDockerRemoteRepository();
                remoteTag = dockerModel.getDockerRemoteTag();
            } else {
                remoteRepository = dockerModel.getKubeRemoteRepository();
                remoteTag = dockerModel.getKubeRemoteTag();
            }
            if (remoteRepository == null || remoteRepository.isEmpty()) {
                stringBuilder.append(DockerProjectConstants.DOCKER_DEFAULT_REPOSITORY + ":");
            } else {
                stringBuilder.append(remoteRepository + ":");
            }
            if (remoteTag == null || remoteTag.isEmpty()) {
                stringBuilder.append(DockerProjectConstants.DOCKER_DEFAULT_TAG);
            } else {
                stringBuilder.append(remoteTag);
            }
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append("COPY " + DockerProjectConstants.CARBON_APP_FOLDER + "/*.car "
                    + DockerProjectConstants.CARBON_APP_FOLDER_LOCATION);
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append("#COPY " + DockerProjectConstants.LIBS_FOLDER + "/*.jar "
                    + DockerProjectConstants.LIBS_FOLDER_LOCATION);

            if (newFile.createNewFile()) {
                InputStream inputStream = new ByteArrayInputStream(
                        stringBuilder.toString().getBytes(Charset.forName("UTF-8")));
                OutputStream outputStream = new FileOutputStream(newFile);
                IOUtils.copy(inputStream, outputStream);
            }
        }
    }
    
    /**
     * Create new kube crd yaml file in the project directory if not exists.
     * 
     * @throws IOException
     *             An error occurred while writing the file
     */
    private void copyKubeYamlFile() throws IOException {
        IFile kubeFile = project.getFile(DockerProjectConstants.KUBE_YAML_FILE_NAME);
        File newFile = new File(kubeFile.getLocationURI().getPath());
        if (!newFile.exists()) {
            // Creating the new yml file
            YAMLFactory yamlFactory = new YAMLFactory();
            File file = kubeFile.getLocation().toFile();
            String imagePath = dockerModel.getKubeTargetRepository() + ":" + dockerModel.getKubeTargetTag();
            try (FileWriter fw = new FileWriter(file);) {
                YAMLGenerator yamlGenerator = yamlFactory.createGenerator(fw);
                yamlGenerator.writeStartObject();

                yamlGenerator.writeObjectField("apiVersion", "integration.wso2.com/v1alpha1");
                yamlGenerator.writeObjectField("kind", "Integration");
                yamlGenerator.writeFieldName("metadata");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeObjectField("name", dockerModel.getKubeContainerName());
                yamlGenerator.writeEndObject();
                yamlGenerator.writeFieldName("spec");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeObjectField("replicas", Integer.parseInt(dockerModel.getKubeReplicsas()));
                yamlGenerator.writeObjectField("image", imagePath);
                yamlGenerator.writeObjectField("port", Integer.parseInt(dockerModel.getKubeExposePort()));

                // check whether there are ENV variables given by user and append to the yaml
                // file
                if (dockerModel.getCustomParameters().size() > 0) {
                    yamlGenerator.writeFieldName("env");
                    yamlGenerator.writeStartArray();

                    for (Map.Entry<String, String> envMap : dockerModel.getCustomParameters().entrySet()) {
                        yamlGenerator.writeStartObject();
                        yamlGenerator.writeObjectField("name", envMap.getKey());
                        yamlGenerator.writeObjectField("value", envMap.getValue());
                        yamlGenerator.writeEndObject();
                    }

                    yamlGenerator.writeEndArray();
                }

                yamlGenerator.writeEndObject();
                yamlGenerator.writeEndObject();
                yamlGenerator.flush();
                yamlGenerator.close();
            }
        }
    }

    /**
     * Create new kube.properties file in the project directory if not exists.
     * 
     * @throws IOException
     *             An error occurred while writing the file
     */
    private void copyKubePropertiesFile() throws IOException {
        IFile dockerFile = project.getFile(DockerProjectConstants.KUBE_PROPERTIES_FILE_NAME);
        File newFile = new File(dockerFile.getLocationURI().getPath());
        if (!newFile.exists()) {
            // Creating the new properties file
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("containerType=kubernetes");

            if (newFile.createNewFile()) {
                InputStream inputStream = new ByteArrayInputStream(
                        stringBuilder.toString().getBytes(Charset.forName("UTF-8")));
                OutputStream outputStream = new FileOutputStream(newFile);
                IOUtils.copy(inputStream, outputStream);
            }
        }
    }

    public boolean performFinish() {
        try {
            // check docker project created via project wizard
            if (this.getModel().getSelectedOption() != null
                    && this.getModel().getSelectedOption().equals(DockerProjectConstants.DOCKER_PROJECT_TYPE)) {
                dockerModel.setContainerExporterProjectChecked(true);
                dockerModel.setDockerContainerSelected(true);
            }

            // check kubernetes project created via project wizard
            if (this.getModel().getSelectedOption() != null
                    && this.getModel().getSelectedOption().equals(DockerProjectConstants.KUBERNETES_PROJECT_TYPE)) {
                dockerModel.setContainerExporterProjectChecked(true);
                dockerModel.setDockerContainerSelected(false);
            }
        	
            project = createNewProject();

            // Creating CarbonApps and Libs folders
            createFolder(DockerProjectConstants.CARBON_APP_FOLDER);
            createFolder(DockerProjectConstants.LIBS_FOLDER);

            // Copy docker file
            copyDockerFile();
            
            // Copy kubernetes CRD yml file and properties file to the project
            if (dockerModel.isContainerExporterProjectChecked() && !dockerModel.isDockerContainerSelected()) {
                copyKubeYamlFile();
                copyKubePropertiesFile();
            }
            
            File pomfile = project.getFile(POM_FILE).getLocation().toFile();
            createPOM(pomfile);
            ProjectUtils.addNatureToProject(project, false, DockerProjectConstants.DOCKER_NATURE);
            MavenUtils.updateWithMavenEclipsePlugin(pomfile, new String[] {},
                    new String[] { DockerProjectConstants.DOCKER_NATURE });
            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);

            // Adding maven-dependency plugin
            // This will copy the CAR files from .m2 to CarbonApps folder
            Plugin dependencyPlugin = MavenUtils.createPluginEntry(mavenProject, "org.apache.maven.plugins",
                    "maven-dependency-plugin", DockerProjectConstants.MAVEN_DEPENDENCY_PLUGIN_VERSION, true);
            PluginExecution dependencyPluginExecution = new PluginExecution();
            dependencyPluginExecution.addGoal("copy-dependencies");
            dependencyPluginExecution.setId("copy-dependencies");
            dependencyPluginExecution.setPhase("package");

            String pluginConfig = "<configuration>\n"
                    + "                <outputDirectory>${project.build.directory}/../CompositeApps</outputDirectory>\n"
                    + "                <overWriteReleases>false</overWriteReleases>\n"
                    + "                <overWriteSnapshots>false</overWriteSnapshots>\n"
                    + "                <overWriteIfNewer>true</overWriteIfNewer>\n"
                    + "                <excludeTransitive>true</excludeTransitive>\n" + "            </configuration>";
            Xpp3Dom dom = Xpp3DomBuilder.build(new ByteArrayInputStream(pluginConfig.getBytes()), "UTF-8");
            dependencyPluginExecution.setConfiguration(dom);
            dependencyPlugin.addExecution(dependencyPluginExecution);

            // Adding spotify docker plugin
            Plugin spotifyPlugin = MavenUtils.createPluginEntry(mavenProject, "com.spotify", "dockerfile-maven-plugin",
                    DockerProjectConstants.SPOTIFY_DOCKER_PLUGIN_VERSION, true);
            PluginExecution spotifyPluginExecution = new PluginExecution();
            spotifyPluginExecution.addGoal("build");
            spotifyPluginExecution.addGoal("push");
            spotifyPluginExecution.setId("default");

            String repository;
            String tag;
            if (dockerModel.isContainerExporterProjectChecked() && dockerModel.isDockerContainerSelected()) {
                repository = dockerModel.getDockerTargetRepository();
                tag = dockerModel.getDockerTargetTag();
            } else {
                repository = dockerModel.getKubeTargetRepository();
                tag = dockerModel.getKubeTargetTag();
            }

            String spotifyPluginConfig;
            if (dockerModel.isContainerExporterProjectChecked() && dockerModel.isDockerContainerSelected()) {
                spotifyPluginConfig = "<configuration>\n" + "<repository>" + repository + "</repository>\n" + "<tag>"
                        + tag + "</tag>\n" + "</configuration>";
            } else {
                spotifyPluginConfig = "<configuration>\n" + "<username>${username}</username>\n"
                        + "<password>${password}</password>\n" + "<repository>" + repository + "</repository>\n"
                        + "<tag>" + tag + "</tag>\n" + "</configuration>";
            }
			
			Xpp3Dom spotifyDom = Xpp3DomBuilder.build(new ByteArrayInputStream(spotifyPluginConfig.getBytes()),
					"UTF-8");
            spotifyPluginExecution.setConfiguration(spotifyDom);
            spotifyPlugin.addExecution(spotifyPluginExecution);

            // Adding dependencies
            List<Dependency> dependencyList = new ArrayList<Dependency>();
            MavenUtils.addMavenDependency(mavenProject, dependencyList);

            // Adding properties ( docker repository and tag )
            Properties properties = mavenProject.getModel().getProperties();
            ArtifactTypeMapping artifactTypeMapping = new ArtifactTypeMapping();
            properties.put("artifact.types", artifactTypeMapping.getArtifactTypes());
            mavenProject.getModel().setProperties(properties);

            MavenUtils.saveMavenProject(mavenProject, pomfile);
            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            openEditor();

        } catch (Exception e) {
            log.error("An error occurred generating a project: ", e);
            return false;
        }
        return true;
    }

    public IResource getCreatedResource() {
        return project;
    }

    public IWizardPage getNextPage(IWizardPage page) {
        IWizardPage nextPage = super.getNextPage(page);
        if (page instanceof MavenDetailsPage) {
            nextPage = null;

        }
        return nextPage;
    }

    public IWizardPage getPreviousPage(IWizardPage page) {
        IWizardPage previousPage = super.getNextPage(page);
        return previousPage;
    }

    public boolean canFinish() {
        if (getContainer().getCurrentPage() instanceof MavenDetailsPage) {
            return true;
        }
        return super.canFinish();
    }

    public DockerModel getModel() {
        return dockerModel;
    }

    public void setModel(DockerModel model) {
        this.dockerModel = model;
    }

    public void openEditor() {
        try {
            IFile pom = project.getFile("pom.xml");
            IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            IWorkbenchPage page = window.getActivePage();
            page.openEditor(new FileEditorInput(pom), DockerProjectConstants.DOCKER_EDITOR);
        } catch (Exception e) {
            /* ignore */}
    }

}

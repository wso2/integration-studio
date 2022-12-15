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

package org.wso2.integrationstudio.docker.distribution.ui.wizard;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.part.FileEditorInput;
import org.osgi.framework.Bundle;
import org.wso2.integrationstudio.distribution.project.util.ArtifactTypeMapping;
import org.wso2.integrationstudio.docker.distribution.Activator;
import org.wso2.integrationstudio.docker.distribution.model.DockerModel;
import org.wso2.integrationstudio.docker.distribution.resources.DockerUserGuideTemplate;
import org.wso2.integrationstudio.docker.distribution.resources.K8sUserGuideTemplate;
import org.wso2.integrationstudio.docker.distribution.utils.DockerImageUtils;
import org.wso2.integrationstudio.docker.distribution.utils.DockerProjectConstants;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.maven.util.MavenUtils;
import org.wso2.integrationstudio.platform.core.project.presentation.ProjectPresentation;
import org.wso2.integrationstudio.platform.core.utils.Constants;
import org.wso2.integrationstudio.platform.ui.utils.PlatformUIConstants;
import org.wso2.integrationstudio.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.integrationstudio.platform.ui.wizard.pages.MavenDetailsPage;
import org.wso2.integrationstudio.utils.file.FileUtils;
import org.wso2.integrationstudio.utils.project.ProjectUtils;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

/**
 * Wizard to create a new Docker project.
 */
public class ContainerProjectCreationWizard extends AbstractWSO2ProjectCreationWizard implements IExecutableExtension {

    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static final String POM_FILE = "pom.xml";
    private IProject project;
    private DockerModel dockerModel;
    private boolean openEditor = true;
    
    private static final String TOOLING_PATH_MAC = "/Applications/IntegrationStudio.app/Contents/Eclipse";
    private static final String EMPTY_STRING = "";
    private static final String MI_FOLDER = "runtime" + File.separator + "microesb";
    
    private static final String MI_SECURITY_DIR = getMicroIntegratorPath() + File.separator + "repository"
            + File.separator + "resources" + File.separator + "security";
    private static final String CONFIG_MAPPER_NAME_FOR_ENV = "env-data";

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
            stringBuilder.append("ARG BASE_IMAGE").append(System.lineSeparator());
            stringBuilder.append("FROM ${BASE_IMAGE}");
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append("COPY " + DockerProjectConstants.CARBON_APP_FOLDER + "/*.car "
                    + DockerProjectConstants.CARBON_APP_FOLDER_LOCATION);
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append("COPY " + DockerProjectConstants.RESOURCES_FOLDER + "/"
                    + DockerProjectConstants.DEFAULT_KEY_STORE_FILE + " "
                    + DockerProjectConstants.SECURITY_RESOURCES_FOLDER_LOCATION
                    + DockerProjectConstants.DEFAULT_KEY_STORE_FILE);
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append("COPY " + DockerProjectConstants.RESOURCES_FOLDER + "/"
                    + DockerProjectConstants.DEFAULT_TRUEST_STORE_FILE + " "
                    + DockerProjectConstants.SECURITY_RESOURCES_FOLDER_LOCATION
                    + DockerProjectConstants.DEFAULT_TRUEST_STORE_FILE);
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append("# COPY " + DockerProjectConstants.LIBS_FOLDER + "/*.jar "
                    + DockerProjectConstants.LIBS_FOLDER_LOCATION);
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append("# RUN " + DockerProjectConstants.EXTENSION_RUNNER_LOCATION);
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append("# COPY " + DockerProjectConstants.RESOURCES_FOLDER + "/"
                    + DockerProjectConstants.DOCKER_ENTRYPOINT_FILE + " "
                    + DockerProjectConstants.DOCKER_ENTRYPOINT_FILE_LOCATION);
            stringBuilder.append(System.lineSeparator());
            
            stringBuilder.append(System.lineSeparator());
            if (dockerModel.isDockerExporterProjectChecked() && dockerModel.getDockerEnvParameters().size() > 0) {
                stringBuilder.append("ENV ");
                for (Map.Entry<String, String> envMap : dockerModel.getDockerEnvParameters().entrySet()) {
                    stringBuilder.append(envMap.getKey() + "=" + envMap.getValue() + " ");
                }
                stringBuilder.append(System.lineSeparator());
            }
            
            if (newFile.createNewFile()) {
                InputStream inputStream = new ByteArrayInputStream(
                        stringBuilder.toString().getBytes(Charset.forName("UTF-8")));
                OutputStream outputStream = new FileOutputStream(newFile);
                IOUtils.copy(inputStream, outputStream);
            }
        }
    }
    
	/**
	 * Create new deployment.toml file in the project directory if not exists.
	 * 
	 * @throws IOException
	 *             An error occurred while writing the file
	 */
	private void copyDeploymentTomlFile() throws IOException {
		IFile tomlFile = project.getFile(DockerProjectConstants.DEPLOYMENT_TOML_FILE_NAME);
		File newFile = new File(tomlFile.getLocationURI().getPath());
		if (!newFile.exists()) {
			try {
				Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
				URL fileURL = bundle.getEntry(DockerProjectConstants.DEPLOYMENT_TOML_FILE_PATH);
				File deploymentFile = null;

				URL resolvedFileURL = FileLocator.toFileURL(fileURL);
				URI resolvedURI = new URI(resolvedFileURL.getProtocol(), resolvedFileURL.getPath(), null);
				deploymentFile = new File(resolvedURI);
				FileUtils.copy(deploymentFile, newFile);
			} catch (URISyntaxException e) {
				log.error("An error occurred generating a deployment.toml file: ", e);
			}
		}
	}

    /**
	 * Create new docker-entrypoint.sh file in the project directory if not exists.
	 * 
	 * @throws IOException
	 *             An error occurred while writing the file
	 */
	private void copyDockerEntryPointFile() throws IOException {
		IFile entryPointFile = project.getFile(DockerProjectConstants.RESOURCES_FOLDER + File.separator
                + DockerProjectConstants.DOCKER_ENTRYPOINT_FILE);
		File newFile = new File(entryPointFile.getLocationURI().getPath());
		if (!newFile.exists()) {
			try {
				Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
				URL fileURL = bundle.getEntry(DockerProjectConstants.DOCKER_ENTRYPOINT_FILE_PATH);
				File dockerEntryPointFile = null;

				URL resolvedFileURL = FileLocator.toFileURL(fileURL);
				URI resolvedURI = new URI(resolvedFileURL.getProtocol(), resolvedFileURL.getPath(), null);
				dockerEntryPointFile = new File(resolvedURI);
				FileUtils.copy(dockerEntryPointFile, newFile);
			} catch (URISyntaxException e) {
				log.error("An error occurred generating a docker-entrypoint.sh file: ", e);
			}
		}
	}
    
    /**
     * Create new integration crd yaml file in the project directory if not exists.
     * 
     * @throws IOException
     *             An error occurred while writing the file
     */
    private void copyKubeYamlFile() throws IOException {
    	IFolder descriptorFolder = ProjectUtils.getWorkspaceFolder(project, project.getName());
        File newFile = new File(descriptorFolder.getRawLocation().toOSString() + File.separator + 
                                DockerProjectConstants.KUBE_YAML_FILE_NAME);
        if (!newFile.exists()) {
            // Creating the new yml file
            YAMLFactory yamlFactory = new YAMLFactory();
            String dockerImageTag = dockerModel.getKubeTargetTag();
            if (dockerImageTag.equals("${project.version}")) {
                dockerImageTag = dockerModel.getMavenInfo().getVersion();
            }
            String imagePath = dockerModel.getKubeTargetRepository() + ":" + dockerImageTag;
            try (FileWriter fw = new FileWriter(newFile);) {
                YAMLGenerator yamlGenerator = yamlFactory.createGenerator(fw);
                yamlGenerator.writeStartObject();

                yamlGenerator.writeObjectField("apiVersion", "wso2.com/v1alpha2");
                yamlGenerator.writeObjectField("kind", "Integration");
                yamlGenerator.writeFieldName("metadata");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeObjectField("name", dockerModel.getKubeContainerName());
                yamlGenerator.writeEndObject();
                yamlGenerator.writeFieldName("spec");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeObjectField("image", imagePath);
                
                yamlGenerator.writeFieldName("deploySpec");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeObjectField("minReplicas", Integer.parseInt(dockerModel.getKubeReplicsas()));
                yamlGenerator.writeEndObject();
                
                // check whether there are Inbound Ports given by user and append to the yaml
                // file
                if (dockerModel.getKubernetesPortParameters().size() > 0) {
                    yamlGenerator.writeFieldName("expose");
                    yamlGenerator.writeStartObject();
                    yamlGenerator.writeFieldName("inboundPorts");
                    yamlGenerator.writeStartArray();

                    for (Map.Entry<String, String> envMap : dockerModel.getKubernetesPortParameters().entrySet()) {
                        yamlGenerator.writeObject(Integer.parseInt(envMap.getKey()));
                    }

                    yamlGenerator.writeEndArray();
                    yamlGenerator.writeEndObject();
                }

                // check whether there are ENV variables given by user and create a new data yaml
                if (dockerModel.getKubernetesEnvParameters().size() > 0) {
                	copyKubeDataYamlFile(dockerModel.getKubernetesEnvParameters().entrySet());
                	
                    //create config mapper reference for env data
                    yamlGenerator.writeFieldName("envFrom");
                    yamlGenerator.writeStartArray();
                    yamlGenerator.writeStartObject();
                    yamlGenerator.writeFieldName("configMapRef");
                    yamlGenerator.writeStartObject();
                    yamlGenerator.writeObjectField("name", "env-data");
                    yamlGenerator.writeEndObject();
                    yamlGenerator.writeEndObject();
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
     * Create new integration data yaml file for environment variables.
     * 
     * @throws IOException
     *             An error occurred while writing the file
     */
    private void copyKubeDataYamlFile(Set<Map.Entry<String, String>> envMapEntries) throws IOException {
    	IFolder descriptorFolder = ProjectUtils.getWorkspaceFolder(project, project.getName());
    	File newFile = new File(descriptorFolder.getRawLocation().toOSString() + File.separator + 
    	                        DockerProjectConstants.KUBE_DATA_YAML_FILE_NAME);
        if (!newFile.exists()) {
            // Creating the new yaml file
            YAMLFactory yamlFactory = new YAMLFactory();
            try (FileWriter fw = new FileWriter(newFile);) {
                YAMLGenerator yamlGenerator = yamlFactory.createGenerator(fw);
                yamlGenerator.writeStartObject();

                yamlGenerator.writeObjectField("apiVersion", "v1");
                yamlGenerator.writeObjectField("kind", "ConfigMap");
                yamlGenerator.writeFieldName("metadata");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeObjectField("name", CONFIG_MAPPER_NAME_FOR_ENV);
                yamlGenerator.writeEndObject();
                
                yamlGenerator.writeFieldName("data");
                yamlGenerator.writeStartObject();
                for (Map.Entry<String, String> envMap : envMapEntries) {
                	yamlGenerator.writeObjectField(envMap.getKey(), envMap.getValue());
                }
                yamlGenerator.writeEndObject();

                yamlGenerator.writeEndObject();
                yamlGenerator.flush();
                yamlGenerator.close();
            }
        }
    }
    
    /**
     * Create new deployment/service YAML file in the project directory if not exists.
     * 
     * @throws IOException
     *             An error occurred while writing the file
     */
    private void copyKubeDeploymentServiceYamlFile() throws IOException {
    	IFolder descriptorFolder = ProjectUtils.getWorkspaceFolder(project, project.getName());
        File newFile = new File(descriptorFolder.getRawLocation().toOSString() + File.separator + 
                 DockerProjectConstants.KUBE_YAML_K8S_FILE_NAME);
        if (!newFile.exists()) {
            // Creating the new yml file
            YAMLFactory yamlFactory = new YAMLFactory();
            String imagePath = dockerModel.getKubeTargetRepository() + ":" + dockerModel.getKubeTargetTag();
            try (FileWriter fw = new FileWriter(newFile);) {
                // append deployment kind
                YAMLGenerator yamlGenerator = yamlFactory.createGenerator(fw);
                yamlGenerator.writeStartObject();

                yamlGenerator.writeObjectField("apiVersion", "apps/v1");
                yamlGenerator.writeObjectField("kind", "Deployment");
                yamlGenerator.writeFieldName("metadata");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeObjectField("name", dockerModel.getKubeContainerName().toLowerCase() + "-deployment");
                yamlGenerator.writeEndObject();
                yamlGenerator.writeFieldName("spec");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeObjectField("replicas", Integer.parseInt(dockerModel.getKubeReplicsas()));
                yamlGenerator.writeFieldName("selector");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeFieldName("matchLabels");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeObjectField("app", "integration");
                yamlGenerator.writeEndObject();
                yamlGenerator.writeEndObject();
                yamlGenerator.writeFieldName("strategy");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeFieldName("rollingUpdate");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeObjectField("maxSurge", 2);
                yamlGenerator.writeObjectField("maxUnavailable", 0);
                yamlGenerator.writeEndObject();
                yamlGenerator.writeObjectField("type", "RollingUpdate");
                yamlGenerator.writeEndObject();
                yamlGenerator.writeFieldName("template");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeFieldName("metadata");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeFieldName("labels");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeObjectField("app", "integration");
                yamlGenerator.writeEndObject();
                yamlGenerator.writeEndObject();
                yamlGenerator.writeFieldName("spec");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeFieldName("containers");
                yamlGenerator.writeStartArray();
                yamlGenerator.writeStartObject();
                yamlGenerator.writeObjectField("name", "micro-integrator");
                yamlGenerator.writeObjectField("image", imagePath);
                yamlGenerator.writeObjectField("imagePullPolicy", "Always");

                // check whether there are Inbound Ports given by user and append to the yaml
                if (dockerModel.getKubernetesPortParameters().size() > 0) {
                    yamlGenerator.writeFieldName("ports");
                    yamlGenerator.writeStartArray();

                    for (Map.Entry<String, String> envMap : dockerModel.getKubernetesPortParameters().entrySet()) {
                        yamlGenerator.writeStartObject();
                        yamlGenerator.writeObjectField("containerPort", Integer.parseInt(envMap.getKey()));
                        yamlGenerator.writeObjectField("protocol", "TCP");
                        yamlGenerator.writeEndObject();
                    }

                    yamlGenerator.writeEndArray();
                }

                // check whether there are ENV variables given by user and create a new data yaml
                if (dockerModel.getKubernetesEnvParameters().size() > 0) {
                	copyKubeDataYamlFile(dockerModel.getKubernetesEnvParameters().entrySet());
                	
                	//create config mapper reference for env data
                    yamlGenerator.writeFieldName("envFrom");
                    yamlGenerator.writeStartArray();
                    yamlGenerator.writeStartObject();
                    yamlGenerator.writeFieldName("configMapRef");
                    yamlGenerator.writeStartObject();
                    yamlGenerator.writeObjectField("name", CONFIG_MAPPER_NAME_FOR_ENV);
                    yamlGenerator.writeEndObject();
                    yamlGenerator.writeEndObject();
                    yamlGenerator.writeEndArray();
                }
                yamlGenerator.writeEndObject();
                yamlGenerator.writeEndArray();
                yamlGenerator.writeEndObject();
                yamlGenerator.writeEndObject();

                yamlGenerator.writeEndObject();
                yamlGenerator.writeEndObject();
                yamlGenerator.flush();
                yamlGenerator.close();

            }
            
            // append service kind
            try (FileWriter fw = new FileWriter(newFile, true)) {
                YAMLGenerator yamlGenerator = yamlFactory.createGenerator(fw);
                yamlGenerator.writeStartObject();
                yamlGenerator.writeObjectField("apiVersion", "v1");
                yamlGenerator.writeObjectField("kind", "Service");
                yamlGenerator.writeFieldName("metadata");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeObjectField("name", dockerModel.getKubeContainerName().toLowerCase() + "-service");
                yamlGenerator.writeEndObject();
                yamlGenerator.writeFieldName("spec");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeObjectField("type", "ClusterIP");
                yamlGenerator.writeFieldName("selector");
                yamlGenerator.writeStartObject();
                yamlGenerator.writeObjectField("app", "integration");
                yamlGenerator.writeEndObject();
                dockerModel.getKubernetesPortParameters().put("8290", "8290");
                dockerModel.getKubernetesPortParameters().put("8253", "8253");
                dockerModel.getKubernetesPortParameters().put("9201", "9201");
                dockerModel.getKubernetesPortParameters().put("9164", "9164");
                // check whether there are Inbound Ports given by user and append to the yaml
                if (dockerModel.getKubernetesPortParameters().size() > 0) {
                    yamlGenerator.writeFieldName("ports");
                    yamlGenerator.writeStartArray();
                    for (Map.Entry<String, String> portMap : dockerModel.getKubernetesPortParameters().entrySet()) {
                        yamlGenerator.writeStartObject();
                        int port = Integer.parseInt(portMap.getKey());
                        if (port == 8290) {
                        	yamlGenerator.writeObjectField("name", 
                        	                             dockerModel.getKubeContainerName().toLowerCase() + "-pt-httpport");
                        } else if (port == 8253) {
                        	yamlGenerator.writeObjectField("name", 
                        	                               dockerModel.getKubeContainerName().toLowerCase() + "-pt-httpsport");
                        } else if (port == 9201) {
                        	yamlGenerator.writeObjectField("name", 
                        	                               dockerModel.getKubeContainerName().toLowerCase() + "-management-http-port");
                        } else if (port == 9164) {
                        	yamlGenerator.writeObjectField("name", 
                        	                               dockerModel.getKubeContainerName().toLowerCase() + "-management-https-port");
                        } else {
                        	yamlGenerator.writeObjectField("name", 
                        	                               dockerModel.getKubeContainerName().toLowerCase() + "-inboundport-" + port);
                        }
                        yamlGenerator.writeObjectField("port", port);
                        yamlGenerator.writeObjectField("targetPort", port);
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

    public boolean performFinish() {
        try {
            // check docker project created via project wizard
            if (this.getModel().getSelectedOption() != null
                    && this.getModel().getSelectedOption().equals(DockerProjectConstants.DOCKER_PROJECT_TYPE)) {
                dockerModel.setDockerExporterProjectChecked(true);
            }

            // check kubernetes project created via project wizard
            if (this.getModel().getSelectedOption() != null
                    && this.getModel().getSelectedOption().equals(DockerProjectConstants.KUBERNETES_PROJECT_TYPE)) {
                dockerModel.setKubernetesExporterProjectChecked(false);
            }
        	
            // To make sure that the createNewProject will go through createProjectInSelectionSpace method in
            // AbstractWSO2ProjectCreationWizard, isUserDefined is set to false and location is changed accordingly.
            // Method createProjectInSelectionSpace, adds the project to the maven multi module project if it is the
            // parent project
            if (this.getModel().isUserSet()) {
                String name = this.getModel().getProjectName();
                File projectLocation = new File(this.getModel().getLocation().getPath() + File.separator + name);
                this.getModel().setLocation(projectLocation);
                this.getModel().setIsUserDefine(false);
            }
            
            // Passing the project nature for creation.
            if (dockerModel.isKubernetesExporterProjectChecked()) {
                setProjectNature(Constants.KUBERNETES_EXPORTER_PROJECT_NATURE);
            } else if (dockerModel.isDockerExporterProjectChecked()) {
                setProjectNature(Constants.DOCKER_EXPORTER_PROJECT_NATURE);
            }
            project = createNewProject();

            // Creating CarbonApps and Libs and CarbonHome folders
            createFolder(DockerProjectConstants.CARBON_APP_FOLDER);
            createFolder(DockerProjectConstants.LIBS_FOLDER);
            createFolder(DockerProjectConstants.RESOURCES_FOLDER);
            createFolder(DockerProjectConstants.CARBON_HOME_FOLDER);
            // Create descriptor folder for Kubernetes exporter
            if (dockerModel.isKubernetesExporterProjectChecked()) {
                createFolder(project.getName());
            }
            

            // Copy docker file
            copyDockerFile();
            
            // Copy deployment.toml file
            copyDeploymentTomlFile();
            
            // Copy default jks files to Resources directory
            IFolder resourcesFolder = ProjectUtils.getWorkspaceFolder(project, DockerProjectConstants.RESOURCES_FOLDER);
            if (resourcesFolder.exists()) {
                org.apache.commons.io.FileUtils.copyFile(
                        new File(MI_SECURITY_DIR + File.separator + DockerProjectConstants.DEFAULT_KEY_STORE_FILE),
                        new File(resourcesFolder.getRawLocation().toOSString() + File.separator
                                + DockerProjectConstants.DEFAULT_KEY_STORE_FILE));
                org.apache.commons.io.FileUtils.copyFile(
                        new File(MI_SECURITY_DIR + File.separator + DockerProjectConstants.DEFAULT_TRUEST_STORE_FILE),
                        new File(resourcesFolder.getRawLocation().toOSString() + File.separator
                                + DockerProjectConstants.DEFAULT_TRUEST_STORE_FILE));
                
                // Copy docker-entrypoint.sh file
                copyDockerEntryPointFile();                    
            }
            
            File pomfile = project.getFile(POM_FILE).getLocation().toFile();
            createPOM(pomfile);
            
            if (dockerModel.isKubernetesExporterProjectChecked()) {
                if (dockerModel.isArtifactsForK8sEIOprator()) {
                    // Copy integration CR yml file and properties file to the project
                    copyKubeYamlFile();
                } else {
                    // Copy service and deployment yaml file to the project
                    copyKubeDeploymentServiceYamlFile();
                }
                
                ProjectUtils.addNatureToProject(project, false, Constants.KUBERNETES_EXPORTER_PROJECT_NATURE);
                MavenUtils.updateWithMavenEclipsePlugin(pomfile, new String[] {},
                        new String[] { Constants.KUBERNETES_EXPORTER_PROJECT_NATURE });
                
            } else if (dockerModel.isDockerExporterProjectChecked()) {
                ProjectUtils.addNatureToProject(project, false, Constants.DOCKER_EXPORTER_PROJECT_NATURE);
                MavenUtils.updateWithMavenEclipsePlugin(pomfile, new String[] {},
                        new String[] { Constants.DOCKER_EXPORTER_PROJECT_NATURE });
            }
            
            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);

            // Adding selected composite project if the project creation is based on composite right click
            if (dockerModel.isCompositeOnClickContainerCreation()) {
                IProject compositeProject = dockerModel.getSelectedCompositeProjectOnCreation();
                IFile compositePomFile = compositeProject.getFile(POM_FILE);
                MavenProject parentPrj = MavenUtils.getMavenProject(compositePomFile.getLocation().toFile());
                List<Dependency> dependencies = new ArrayList<>();
                dependencies.add(MavenUtils.createDependency(parentPrj.getGroupId(), parentPrj.getArtifactId(),
                        parentPrj.getVersion(), null, "car"));
                MavenUtils.addMavenDependency(mavenProject, dependencies);
            }
            
            // adding maven-clean-plugin to clear CompisiteApps directory before the build
            Plugin cleanPlugin = MavenUtils.createPluginEntry(mavenProject, "org.apache.maven.plugins",
                    "maven-clean-plugin", DockerProjectConstants.MAVEN_CLEAN_PLUGIN_VERSION, true);
            String cleanPluginConfig = "<configuration>\n"
                    + "                <filesets>\n"
                    + "                <fileset>\n"
                    + "                <directory>${basedir}/CompositeApps</directory>\n"
                    + "                </fileset>\n"
                    + "                </filesets>\n" + "            </configuration>";
            Xpp3Dom cleanDom = Xpp3DomBuilder.build(new ByteArrayInputStream(cleanPluginConfig.getBytes()), "UTF-8");
            cleanPlugin.setConfiguration(cleanDom);
            
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
            
            // Add deployment.toml execution plugin
            Plugin deploymentTomlPlugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven",
                    "mi-container-config-mapper", "5.2.35", true);
            PluginExecution deploymentTomlPluginExecution = new PluginExecution();
            deploymentTomlPluginExecution.addGoal("config-mapper-parser");
            deploymentTomlPluginExecution.setId("config-mapper-parser");
            
            //add default secure-vault properties
            mavenProject.getProperties().put("ciphertool.enable", "false");
            mavenProject.getProperties().put("keystore.name", DockerProjectConstants.DEFAULT_KEY_STORE_FILE);
            mavenProject.getProperties().put("keystore.password",
                    DockerProjectConstants.DEFAULT_KEY_STORE_ALIAS_PASSWORD);
            mavenProject.getProperties().put("keystore.type", "JKS");
            mavenProject.getProperties().put("keystore.alias", DockerProjectConstants.DEFAULT_KEY_STORE_ALIAS_PASSWORD);
            
            // Check base image contains deployment.toml and apply config-map plugin and other resources
            if (dockerModel.isDeploymentTomlEnabled()) {
                deploymentTomlPluginExecution.setPhase("package");          
            } else {
            	deploymentTomlPluginExecution.setPhase("none");  
            }
            String deploymentTomlPluginConfig = "<configuration>\n" + ""
                    + "                <miVersion>" + PlatformUIConstants.MI_DEPLOYMENT_TOML_TEMPLATE_VERSION + "</miVersion>\n" 
                    + "                <executeCipherTool>${ciphertool.enable}</executeCipherTool>\n" 
                    + "                <keystoreName>${keystore.name}</keystoreName>\n" 
                    + "                <keystoreAlias>${keystore.alias}</keystoreAlias>\n" 
                    + "                <keystoreType>${keystore.type}</keystoreType>\n" 
                    + "                <keystorePassword>${keystore.password}</keystorePassword>\n" 
                    + "                <projectLocation>${project.basedir}</projectLocation>\n" 
                    + "            </configuration>";
            Xpp3Dom tomlDom = Xpp3DomBuilder.build(new ByteArrayInputStream(deploymentTomlPluginConfig.getBytes()),
                    "UTF-8");
            deploymentTomlPluginExecution.setConfiguration(tomlDom);
            deploymentTomlPlugin.addExecution(deploymentTomlPluginExecution);

            // Adding spotify docker plugin - two executions for Docker build and push
            Plugin spotifyPlugin = MavenUtils.createPluginEntry(mavenProject, "com.spotify", "dockerfile-maven-plugin",
                    DockerProjectConstants.SPOTIFY_DOCKER_PLUGIN_VERSION, true);
            
            //Docker build execution section
            PluginExecution spotifyPluginDockerBuildExecution = new PluginExecution();
            spotifyPluginDockerBuildExecution.addGoal("build");
            spotifyPluginDockerBuildExecution.setId("docker-build");
            spotifyPluginDockerBuildExecution.setPhase("package");

            String repository;
            String tag;
            if (dockerModel.isDockerExporterProjectChecked()) {
                repository = dockerModel.getDockerTargetRepository();
                tag = dockerModel.getDockerTargetTag();
            } else {
                repository = dockerModel.getKubeTargetRepository();
                tag = dockerModel.getKubeTargetTag();
            }
            
            String remoteRepository;
            String remoteTag;
            if (dockerModel.isDockerExporterProjectChecked()) {
                remoteRepository = dockerModel.getDockerRemoteRepository();
                remoteTag = dockerModel.getDockerRemoteTag();
            } else {
                remoteRepository = dockerModel.getKubeRemoteRepository();
                remoteTag = dockerModel.getKubeRemoteTag();
            }
            if (remoteRepository == null || remoteRepository.isEmpty()) {
                remoteRepository = PlatformUIConstants.DOCKER_DEFAULT_BASE_REPOSITORY;
            } 
            if (remoteTag == null || remoteTag.isEmpty()) {
                remoteTag = PlatformUIConstants.DOCKER_DEFAULT_BASE_TAG;
            } 
            
            mavenProject.getProperties().put("dockerfile.base.image", remoteRepository + ":" + remoteTag);
            mavenProject.getProperties().put("dockerfile.repository", repository);
            mavenProject.getProperties().put("dockerfile.tag", tag);
            String spotifyPluginDockerBuildConfig = "<configuration>\n"
                    + "<dockerfile.repository>${dockerfile.repository}</dockerfile.repository>\n"
                    + "<dockerfile.tag>${dockerfile.tag}</dockerfile.tag>\n" 
                    + "<buildArgs><BASE_IMAGE>${dockerfile.base.image}</BASE_IMAGE></buildArgs></configuration>";
			
			Xpp3Dom spotifyDockerBuildDom = Xpp3DomBuilder.build(new ByteArrayInputStream(spotifyPluginDockerBuildConfig.getBytes()),
					"UTF-8");
			spotifyPluginDockerBuildExecution.setConfiguration(spotifyDockerBuildDom);
            spotifyPlugin.addExecution(spotifyPluginDockerBuildExecution);
            
            //Docker build execution section
            PluginExecution spotifyPluginDockerPushExecution = new PluginExecution();
            spotifyPluginDockerPushExecution.addGoal("push");
            spotifyPluginDockerPushExecution.setId("docker-push");
            spotifyPluginDockerPushExecution.setPhase("package");
            
            String spotifyPluginDockerPushConfig = "<configuration>\n"
                    + "<dockerfile.username>${dockerfile.username}</dockerfile.username>\n"
                    + "<dockerfile.password>${dockerfile.password}</dockerfile.password>\n"
                    + "<dockerfile.repository>${dockerfile.repository}</dockerfile.repository>\n"
                    + "<dockerfile.tag>${dockerfile.tag}</dockerfile.tag></configuration>";
            
            Xpp3Dom spotifyDockerPushDom = Xpp3DomBuilder.build(new ByteArrayInputStream(spotifyPluginDockerPushConfig.getBytes()),
					"UTF-8");
            spotifyPluginDockerPushExecution.setConfiguration(spotifyDockerPushDom);
            spotifyPlugin.addExecution(spotifyPluginDockerPushExecution);

            // Adding dependencies
            List<Dependency> dependencyList = new ArrayList<Dependency>();
            MavenUtils.addMavenDependency(mavenProject, dependencyList);

            // Adding properties ( docker repository and tag )
            Properties properties = mavenProject.getModel().getProperties();
            ArtifactTypeMapping artifactTypeMapping = new ArtifactTypeMapping();
            properties.put("artifact.types", artifactTypeMapping.getArtifactTypes());
            mavenProject.getModel().setProperties(properties);

            MavenUtils.saveMavenProject(mavenProject, pomfile);
            ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            if (openEditor) {
                openEditor();
            }
            setPerspective(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
        } catch (Exception e) {
            log.error("An error occurred generating a project: ", e);
            return false;
        }
        return true;
    }

    /**
     * Used to open the help content of the docker user guide.
     *
     * @param shell
     *            Eclipse shell reference
     * @param helpURL
     *            URL of the help html page
     */
    public static void openDockerHelper(Shell shell, URL helpURL) {
        shell.getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                try {
                    DockerUserGuideTemplate templateGuideView = (DockerUserGuideTemplate) PlatformUI.getWorkbench()
                            .getActiveWorkbenchWindow().getActivePage()
                            .showView(DockerUserGuideTemplate.TEMPLATE_GUIDE_VIEW_ID);
                    templateGuideView.setURL(helpURL);
                } catch (PartInitException e) {
                    MessageDialog.openError(shell, DockerUserGuideTemplate.ERROR_MESSAGE_OPENING_EDITOR,
                            e.getMessage());
                }
            }
        });
    }

    /**
     * Used to open the help content of the kubernetes user guide.
     *
     * @param shell
     *            Eclipse shell reference
     * @param helpURL
     *            URL of the help html page
     */
    public static void openK8sHelper(Shell shell, URL helpURL) {
        shell.getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                try {
                    K8sUserGuideTemplate templateGuideView = (K8sUserGuideTemplate) PlatformUI.getWorkbench()
                            .getActiveWorkbenchWindow().getActivePage()
                            .showView(K8sUserGuideTemplate.TEMPLATE_GUIDE_VIEW_ID);
                    templateGuideView.setURL(helpURL);
                } catch (PartInitException e) {
                    MessageDialog.openError(shell, DockerUserGuideTemplate.ERROR_MESSAGE_OPENING_EDITOR,
                            e.getMessage());
                }
            }
        });
    }

    /**
     * Get the UserGuideReadMe.html to the relevant project.
     *
     * @param project current project
     * @param guidePath user guide path
     * @param guideName user guide name
     * @return URL of the docker user guide html file
     */
    private URL getUserGuideURL(IProject project, String guidePath, String guideName) {
        URL url = null;
        IFile tomlFile = project.getFile(guideName);
        File newFile = new File(tomlFile.getLocationURI().getPath());
        if (!newFile.exists()) {
            try {
                Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
                URL fileURL = bundle.getEntry(guidePath);
                File guideHTML = null;

                URL resolvedFileURL = FileLocator.toFileURL(fileURL);
                URI resolvedURI = new URI(resolvedFileURL.getProtocol(), resolvedFileURL.getPath(), null);
                guideHTML = new File(resolvedURI);
                url = guideHTML.toURI().toURL();
            } catch (URISyntaxException | IOException e) {
                log.error("An error occurred generating a deployment.toml file: \n", e);
            }
        }

        return url;
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
    
    public void setOpenEditor(boolean openEditor) {
        this.openEditor = openEditor;
    }

    public void openEditor() {
        try {
            IFile pom = project.getFile("pom.xml");
            IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            IWorkbenchPage page = window.getActivePage();
            ((CommonNavigator) page.findViewReference(IPageLayout.ID_PROJECT_EXPLORER, null).getView(true)).setLinkingEnabled(true);
            page.openEditor(new FileEditorInput(pom), DockerProjectConstants.DOCKER_EDITOR);

            // open docker user guide
            if (dockerModel.isDockerExporterProjectChecked()) {
                openDockerHelper(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                        getUserGuideURL(project, DockerProjectConstants.DOCKER_USER_GUIDE_PATH,
                                DockerProjectConstants.DOCKER_USER_GUIDE_FILE));
            }

            // open kubernetes user guide
            if (dockerModel.isKubernetesExporterProjectChecked()) {
                openK8sHelper(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), getUserGuideURL(project,
                        DockerProjectConstants.K8S_USER_GUIDE_PATH, DockerProjectConstants.K8S_USER_GUIDE_FILE));
            }
        } catch (Exception e) {
            /* ignore */}
    }

    /**
     * This method sets the perspective to ESB
     *
     * @param shell shell object that should be switched to ESB perspective
     */
    public void setPerspective(Shell shell) {
        shell.getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                if (!DockerProjectConstants.ESB_GRAPHICAL_PERSPECTIVE.equals(window.getActivePage().getPerspective().getId())) {
                    try {
                        PlatformUI.getWorkbench().showPerspective(DockerProjectConstants.ESB_GRAPHICAL_PERSPECTIVE, window);
                        ProjectPresentation.setHierarchicalProjectPresentation();
                    } catch (Exception e) {
                        log.error("Cannot switch to ESB Graphical Perspective", e);
                    }
                }
            }
        });
    }

    /**
     * Method of getting MI path based on the OS type.
     * 
     * @return MI path
     */
    private static String getMicroIntegratorPath() {
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        String microInteratorPath;

        if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
            // check if EI Tooling is in Application folder for MAC
            boolean isRelativeToolingAppExists = false;
            File macOSRelativeToolingApp = null;
            try {
                macOSRelativeToolingApp = new File((new File(".").getCanonicalFile()).getParent().toString() 
                        + File.separator + "Eclipse");
                if (macOSRelativeToolingApp.exists()) {
                    isRelativeToolingAppExists = true;
                }
            } catch (IOException e) {}
            if (isRelativeToolingAppExists && macOSRelativeToolingApp != null) {
                microInteratorPath = macOSRelativeToolingApp.getAbsolutePath() + File.separator + MI_FOLDER;
            } else if (new File(TOOLING_PATH_MAC).exists()) {
                microInteratorPath = TOOLING_PATH_MAC + File.separator + MI_FOLDER;
            } else {
                java.nio.file.Path path = Paths.get(EMPTY_STRING);
                microInteratorPath = (path).toAbsolutePath().toString() + File.separator + MI_FOLDER;
            }
        } else {
            java.nio.file.Path path = Paths.get(EMPTY_STRING);
            microInteratorPath = (path).toAbsolutePath().toString() + File.separator + MI_FOLDER;
        }
        return microInteratorPath;
    }

}

/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *  http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.docker.distribution.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.docker.distribution.Activator;
import org.wso2.developerstudio.eclipse.docker.distribution.editor.CustomWizardDialog;
import org.wso2.developerstudio.eclipse.docker.distribution.editor.DockerHubLoginWizard;
import org.wso2.developerstudio.eclipse.docker.distribution.model.DockerHubAuth;
import org.wso2.developerstudio.eclipse.docker.distribution.utils.DockerProjectConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * Class responsible for handle generating Docker image from plugin.xml.
 */
public class DockerRunMavenAction implements IActionDelegate {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private static final String POM_FILE = "pom.xml";
    private String containerType;
    private IStructuredSelection selection;
    private File pomFile;

    /**
     * Method of running ILauncher with maven dependency.
     */
    public void run(IAction action) {
        Object element = selection.getFirstElement();
        IProject project = ((IResource) element).getProject();
        IFile pomIFile = project.getFile(POM_FILE);
        pomFile = pomIFile.getLocation().toFile();

        // check whether there are atleast one depenedency composite project to build a image
        List<String> dependencyProjectNames = DockerBuildActionUtil.getCompositeAppDependencyList(pomFile);
        if (dependencyProjectNames.size() == 0) {
            DockerBuildActionUtil.showMessageBox(DockerProjectConstants.MESSAGE_BOX_TITLE,
                    DockerProjectConstants.SUFFCIENT_DEPENDENCY_NOT_FOUND, SWT.ERROR);
            return;
        }

        // check the project type is kubernetes, if yes open the credentials wizard
        readContainerProjectNature(project);
        DockerHubAuth newConfiguration = null;
        if (getContainerType().equals(DockerProjectConstants.KUBERNETES_CONTAINER)) {
            newConfiguration = new DockerHubAuth();
            DockerHubLoginWizard wizard = new DockerHubLoginWizard(newConfiguration, pomIFile);
            IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            wizard.init(PlatformUI.getWorkbench(), null);
            CustomWizardDialog headerWizardDialog = new CustomWizardDialog(window.getShell(), wizard);
            headerWizardDialog.setHelpAvailable(false);
            headerWizardDialog.setPageSize(580, 200);
            headerWizardDialog.open();

            if (newConfiguration.getAuthUsername() == null && newConfiguration.getAuthPassword() == null) {
                return;
            }
            newConfiguration.setKubernetesProject(true);
        }

        // execute maven build and push jobs using project POM
        executeDockerBuildProcess(project, dependencyProjectNames, newConfiguration);
    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
        if (selection instanceof IStructuredSelection) {
            this.selection = (IStructuredSelection) selection;
        }
    }

    /**
     * Execute docker build and push maven jobs.
     * 
     * @param project container project
     * @param dependencyProjectNames CApp project name list in POM file
     * @param configuration auth connection data for docker push
     */
    private void executeDockerBuildProcess(IProject project, List<String> dependencyProjectNames,
            DockerHubAuth configuration) {
        String m2Directory = FileUtils.getUserDirectory().getPath() + File.separator + ".m2" + File.separator
                + "repository";
        try {
            DockerBuildActionUtil.exportCarbonAppsToTargetFolder(m2Directory, dependencyProjectNames);

            // check docker registry URL has changed, if yes append the private remote url to the target repository
            String targetRepository = DockerBuildActionUtil.readDockerImageDetailsFromPomPlugin(pomFile);
            String[] reposirotyTags = targetRepository.split(DockerProjectConstants.REPOSITORY_SEPERATOR);
            if (reposirotyTags.length == 3) {
                targetRepository = reposirotyTags[1] + DockerProjectConstants.REPOSITORY_SEPERATOR + reposirotyTags[2];
            }

            if (!configuration.isDockerRegistry()) {
                targetRepository = configuration.getRemoteRegistryURL() + DockerProjectConstants.REPOSITORY_SEPERATOR + targetRepository;
            }

            DockerBuildActionUtil.changeDockerImageDataInPOMPlugin(pomFile, targetRepository);
            DockerBuildActionUtil.runDockerBuildWithMavenProfile(project, DockerBuildActionUtil.MAVEN_BUILD_GOAL,
                    configuration);

        } catch (CoreException e) {
            log.error("CoreException in while executing the docker build process", e);
        }
    }

    /*
     * Reads project nature of the project to get the project type.
     */
    private void readContainerProjectNature(IProject project) {
        try {
            if (project.hasNature(DockerProjectConstants.KUBERNETES_NATURE)) {
                setContainerType(DockerProjectConstants.KUBERNETES_CONTAINER);
            } else {
                setContainerType(DockerProjectConstants.DOCKER_CONTAINER);
            }
        } catch (CoreException e) {
            log.error("CoreException while reading the project nature", e);
        }
    }
    
    /*
     * Get container type as kubernetes or docker.
     * 
     * @return project type
     */
    public String getContainerType() {
        return containerType;
    }

    /*
     * Set container type as kubernetes or docker.
     * 
     * @param project type
     */
    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }
}

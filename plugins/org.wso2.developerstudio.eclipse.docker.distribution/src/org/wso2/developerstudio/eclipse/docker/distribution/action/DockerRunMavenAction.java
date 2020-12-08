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
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.w3c.dom.Document;
import org.wso2.developerstudio.eclipse.docker.distribution.Activator;
import org.wso2.developerstudio.eclipse.docker.distribution.editor.CustomWizardDialog;
import org.wso2.developerstudio.eclipse.docker.distribution.editor.DockerHubLoginWizard;
import org.wso2.developerstudio.eclipse.docker.distribution.model.DockerHubAuth;
import org.wso2.developerstudio.eclipse.docker.distribution.utils.DockerProjectConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.xml.sax.SAXException;

/**
 * Class responsible for handle generating Docker image from plugin.xml.
 */
public class DockerRunMavenAction implements IActionDelegate, IExecutableExtension {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private static final String IS_DOCKER_PUSH_PARAM = "isDockerPushOnly";
    private static final String POM_FILE = "pom.xml";
    private String containerType;
    private IStructuredSelection selection;
    private File pomFile;
    private String isDockerPushOnly = null;
    
    @SuppressWarnings("unchecked")
    @Override 
    public void setInitializationData(IConfigurationElement config,
            String propertyName, Object data) throws CoreException {

        if (data instanceof Map) {
            isDockerPushOnly = ((Map<String, String>) data).get(IS_DOCKER_PUSH_PARAM);
        } 
    }

    /**
     * Method of running ILauncher with maven dependency.
     */
    public void run(IAction action) {
        // save all the existing ediros
        IWorkbenchPage[] pages = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages();
        if (pages != null) {
            for (IWorkbenchPage page : pages) {
                IEditorPart editor = page.getActiveEditor();
                if (editor != null) {
                    page.saveEditor(editor, true);
                }
            }
        }
        
        Object element = selection.getFirstElement();
        IProject project = ((IResource) element).getProject();
        IFile pomIFile = project.getFile(POM_FILE);
        pomFile = pomIFile.getLocation().toFile();
        boolean isThisOldContainerProject = false;
        
        try {
            // check whether pom is in old or new version
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(pomFile);

            // it checks buildArg parameter is there in docker plugin to verify whether this pom is a new one or not
            XPathExpression xpBuildArgs = XPathFactory.newInstance().newXPath()
                    .compile(DockerProjectConstants.DOCKER_SPOTIFY_PLUGIN_BUILD_ARG);
            if (xpBuildArgs.evaluate(doc).isEmpty()) {
                isThisOldContainerProject = true;
            }
        } catch (XPathExpressionException e) {
            log.error("XPathExpressionException while reading pomfile", e);
        } catch (ParserConfigurationException e) {
            log.error("ParserConfigurationException while reading pomfile", e);
        } catch (SAXException e) {
            log.error("SAXException while reading pomfile", e);
        } catch (IOException e) {
            log.error("IOException while reading pomfile", e);
        }

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
        if (getContainerType().equals(DockerProjectConstants.KUBERNETES_CONTAINER) || isDockerPushOnly != null) {
            newConfiguration = new DockerHubAuth();
            DockerHubLoginWizard wizard = new DockerHubLoginWizard(newConfiguration, pomIFile);
            IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            wizard.init(PlatformUI.getWorkbench(), null);
            CustomWizardDialog headerWizardDialog = new CustomWizardDialog(window.getShell(), wizard);
            headerWizardDialog.setHelpAvailable(false);
            headerWizardDialog.setPageSize(580, 230);
            headerWizardDialog.open();

            if (newConfiguration.getAuthUsername() == null && newConfiguration.getAuthPassword() == null) {
                return;
            }
            
            if (getContainerType().equals(DockerProjectConstants.KUBERNETES_CONTAINER)) {
                newConfiguration.setKubernetesProject(true);
            }
        }

        // execute maven build and push jobs using project POM
        try {
            if ((getContainerType().equals(DockerProjectConstants.KUBERNETES_CONTAINER))
                    || (getContainerType().equals(DockerProjectConstants.DOCKER_CONTAINER)
                            && isDockerPushOnly == null)) {
                executeDockerBuildProcess(project, dependencyProjectNames, newConfiguration, isThisOldContainerProject);
            } else {
                DockerBuildActionUtil.runDockerPushWithMavenProfile(project, newConfiguration, isThisOldContainerProject);
            }
        } catch (CoreException e) {
            log.error("CoreException while running the runDockerPushWithMavenProfile for Docker push action", e);
        } 
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
     * @param isThisOldContainerProject
     */
    private void executeDockerBuildProcess(IProject project, List<String> dependencyProjectNames,
            DockerHubAuth configuration, boolean isThisOldContainerProject) {
        String m2Directory = FileUtils.getUserDirectory().getPath() + File.separator + ".m2" + File.separator
                + "repository";
        try {
            DockerBuildActionUtil.exportCarbonAppsToTargetFolder(m2Directory, dependencyProjectNames);

            // check docker registry URL has changed, if yes append the private remote url to the target repository
            String targetRepository = DockerBuildActionUtil.readDockerImageDetailsFromPomPlugin(pomFile, isThisOldContainerProject);
            String[] reposirotyTags = targetRepository.split(DockerProjectConstants.REPOSITORY_SEPERATOR);
            if (reposirotyTags.length == 3) {
                targetRepository = reposirotyTags[1] + DockerProjectConstants.REPOSITORY_SEPERATOR + reposirotyTags[2];
            }

            if (configuration != null && !configuration.isDockerRegistry()) {
                targetRepository = configuration.getRemoteRegistryURL() + DockerProjectConstants.REPOSITORY_SEPERATOR + targetRepository;
            }

            DockerBuildActionUtil.changeDockerImageDataInPOMPlugin(pomFile, targetRepository, isThisOldContainerProject);
			DockerBuildActionUtil.runDockerBuildWithMavenProfile(project, DockerBuildActionUtil.MAVEN_BUILD_GOAL,
					configuration, isThisOldContainerProject);
        } catch (CoreException e) {
            log.error("CoreException in while executing the docker build process", e);
        }
    }

    /*
     * Reads project nature of the project to get the project type.
     */
    private void readContainerProjectNature(IProject project) {
        try {
            if (project.hasNature(Constants.KUBERNETES_EXPORTER_PROJECT_NATURE)) {
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

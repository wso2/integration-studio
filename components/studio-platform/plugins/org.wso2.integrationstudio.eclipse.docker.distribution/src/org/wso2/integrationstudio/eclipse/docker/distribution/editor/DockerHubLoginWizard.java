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

package org.wso2.integrationstudio.eclipse.docker.distribution.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.integrationstudio.eclipse.docker.distribution.model.DockerHubAuth;

/**
 * Class responsible for creation of wizard for get docker hub credentials.
 */
public class DockerHubLoginWizard extends Wizard implements IExportWizard {

    private final String WINDOW_TITLE = "Docker Registry Credentials";

    private DockerHubLoginPage dockerHubDetailPage;
    private boolean initError = false;
    private DockerHubAuth configuration;
    private IFile containerPomFile;

    public DockerHubLoginWizard(DockerHubAuth newConfiguration, IFile pomFile) {
        configuration = newConfiguration;
        containerPomFile = pomFile;
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle(WINDOW_TITLE);
        dockerHubDetailPage = new DockerHubLoginPage(workbench, selection, containerPomFile);
    }

    @Override
    public boolean performFinish() {
        configuration.setAuthUsername(dockerHubDetailPage.getUsernameValue());
        configuration.setAuthPassword(dockerHubDetailPage.getPasswordValue());
        
        if (dockerHubDetailPage.getSelectedRegistryType().equals(dockerHubDetailPage.DOCKERHUB_REGISTRY)) {
            configuration.setDockerRegistry(true);
        } else {
            configuration.setDockerRegistry(false);
            configuration.setRemoteRegistryURL(dockerHubDetailPage.getDockerHubOtherRegistryURL());
        }

        return true;
    }

    public void addPages() {
        if (!initError) {
            addPage(dockerHubDetailPage);
            super.addPages();
        }
    }
}

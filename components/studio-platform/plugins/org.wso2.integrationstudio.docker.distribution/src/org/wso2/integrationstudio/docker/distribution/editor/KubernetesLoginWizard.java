/*
 * Copyright (c) 2023, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.docker.distribution.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.integrationstudio.docker.distribution.model.DockerHubAuth;

/**
 * Class responsible for creation of wizard for get docker hub credentials.
 */
public class KubernetesLoginWizard extends Wizard implements IExportWizard {

	private final String WINDOW_TITLE = "Docker Registry Credentials";

	private KubernetesLoginPage kubernetesLoginPage;
	private boolean initError = false;
	private DockerHubAuth configuration;
	private IFile containerPomFile;

	public KubernetesLoginWizard(DockerHubAuth newConfiguration, IFile pomFile) {
		configuration = newConfiguration;
		containerPomFile = pomFile;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle(WINDOW_TITLE);
		kubernetesLoginPage = new KubernetesLoginPage(workbench, selection, containerPomFile);
	}

	@Override
	public boolean performFinish() {
		configuration.setAuthUsername(kubernetesLoginPage.getUsernameValue());
		configuration.setAuthPassword(kubernetesLoginPage.getPasswordValue());
		configuration.setPullAuthUsername(kubernetesLoginPage.getWso2DockerUsernameValue());
		configuration.setPullAuthPassword(kubernetesLoginPage.getWso2DockerPasswordValue());
		if (kubernetesLoginPage.getSelectedRegistryType().equals(kubernetesLoginPage.DOCKERHUB_REGISTRY)) {
			configuration.setDockerRegistry(true);
		} else {
			configuration.setDockerRegistry(false);
			configuration.setRemoteRegistryURL(kubernetesLoginPage.getDockerHubOtherRegistryURL());
		}

		return true;
	}

	public void addPages() {
		if (!initError) {
			addPage(kubernetesLoginPage);
			super.addPages();
		}
	}
}

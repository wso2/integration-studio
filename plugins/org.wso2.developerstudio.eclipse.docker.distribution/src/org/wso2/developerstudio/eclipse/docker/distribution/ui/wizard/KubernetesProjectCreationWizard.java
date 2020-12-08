/*
 * Copyright (c) 2019 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software He   
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.wso2.developerstudio.eclipse.docker.distribution.ui.wizard;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.docker.distribution.model.DockerModel;
import org.wso2.developerstudio.eclipse.docker.distribution.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.KubernetesDetailsPage;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.MavenDetailsPage;

/**
 * Class responsible for create a new kubernetes project alone.
 */
public class KubernetesProjectCreationWizard extends Wizard implements IExportWizard {

    private static final IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    
    private static final String WINDOW_TITLE = "New Kubernetes Exporter for K8s EI Operator";
    private boolean initError = false;
    private KubernetesDetailsPage kubernetesDetailPage;
    private MavenDetailsPage mavenDetailPage;
    private DockerModel dockerModel;
    
    public KubernetesProjectCreationWizard() {
        dockerModel = new DockerModel();
    }
    
    public KubernetesProjectCreationWizard(boolean isCompositeOnClickCreation) {
        dockerModel = new DockerModel();
        dockerModel.setCompositeOnClickContainerCreation(isCompositeOnClickCreation);
    }
    
    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle(WINDOW_TITLE);
        try {
            IProject project = getSelectedProject(selection);
            File location;
            if (project != null) {
                if (dockerModel.isCompositeOnClickContainerCreation()) {
                    location = new File(project.getLocation().toOSString().replace(project.getName(), ""));
                    dockerModel.setSelectedCompositeProjectOnCreation(project);
                } else {
                    location = project.getLocation().toFile();
                }
            } else {
                location = ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile();
            }
            dockerModel.setKubernetesExporterProjectChecked(true);
            dockerModel.setDirectContainerProjectCreation(true);
            dockerModel.setLocation(location);
            dockerModel.setIsUserDefine(true);
        } catch (ObserverFailedException e) {
            log.error("Failed to set isKubernetesProject property for the project", e);
        } catch (Exception e) {
            log.error("Exception while reading the selection values", e);
        }
        kubernetesDetailPage = new KubernetesDetailsPage(dockerModel);
        mavenDetailPage = new MavenDetailsPage(dockerModel);
    }
    
    @Override
    public boolean performFinish() {
        ContainerProjectCreationWizard dockerWizard = new ContainerProjectCreationWizard();
        dockerWizard.setModel(dockerModel);
        dockerWizard.performFinish();
  
        return true;
    }
    
    @Override
    public void addPages() {
        if (!initError) {
            addPage(kubernetesDetailPage);
            addPage(mavenDetailPage);
            super.addPages();
        }
    }
    
	@Override
	public boolean canFinish() {
		if ((getContainer().getCurrentPage() == kubernetesDetailPage
				&& getContainer().getCurrentPage().isPageComplete())
				|| (getContainer().getCurrentPage() == mavenDetailPage)) {
			return true;
		} else {
			return false;
		}
	}
    
    @Override
    public IWizardPage getNextPage(IWizardPage currentPage) {
        if (currentPage == kubernetesDetailPage) {
            return mavenDetailPage;
        }

        return null;
    }
    
    /**
     * Method for getting current project from IStructuredSelection.
     * 
     * @param obj
     *            IStructuredSelection as an object
     * @return IProject
     */
    public static IProject getSelectedProject(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }

        if (obj instanceof IResource) {
            return ((IResource) obj).getProject();
        } else if (obj instanceof IStructuredSelection) {
            return getSelectedProject(((IStructuredSelection) obj).getFirstElement());
        }

        return null;
    }
}

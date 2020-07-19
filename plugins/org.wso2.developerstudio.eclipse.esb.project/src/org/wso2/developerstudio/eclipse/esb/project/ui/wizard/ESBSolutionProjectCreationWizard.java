/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.esb.project.ui.wizard;

import java.io.File;
import java.util.Map;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.artifact.connector.model.ConnectorModel;
import org.wso2.developerstudio.eclipse.artifact.connector.ui.wizard.ConnectorCreationWizard;
import org.wso2.developerstudio.eclipse.distribution.project.model.DistributionProjectModel;
import org.wso2.developerstudio.eclipse.distribution.project.ui.wizard.DistributionProjectWizard;
import org.wso2.developerstudio.eclipse.docker.distribution.model.DockerModel;
import org.wso2.developerstudio.eclipse.docker.distribution.ui.wizard.ContainerProjectCreationWizard;
import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.wso2.developerstudio.eclipse.esb.project.model.ESBProjectModel;
import org.wso2.developerstudio.eclipse.esb.project.model.ESBSolutionProjectModel;
import org.wso2.developerstudio.eclipse.esb.project.utils.ESBImageUtils;
import org.wso2.developerstudio.eclipse.general.project.model.GeneralProjectModel;
import org.wso2.developerstudio.eclipse.general.project.ui.wizard.GeneralProjectWizard;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.multi.module.handlers.MvnMultiModuleModel;
import org.wso2.developerstudio.eclipse.maven.multi.module.handlers.MvnMultiModuleWizard;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.presentation.ProjectPresentation;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.DockerDetailsPage;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.KubernetesDetailsPage;

/**
 * This wizard class is to create ESB, Registry, Connector Exporter, Composite
 * projects as an ESB solution project
 * 
 */
public class ESBSolutionProjectCreationWizard extends AbstractWSO2ProjectCreationWizard {
	private static final String ESB_GRAPHICAL_PERSPECTIVE = "org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.perspective";

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private IProject project;
	private ESBSolutionProjectModel esbSolutionProjectModel;
	private File pomFile;
	private String PROJECT_WIZARD_TITLE = "New Integration Project";
	private DockerDetailsPage dockerDetailPage;
	private KubernetesDetailsPage kubernetesDetailPage;

	public ESBSolutionProjectCreationWizard() {
		setEsbSolutionProjectModel(new ESBSolutionProjectModel());
		setModel(esbSolutionProjectModel);
		setDefaultPageImageDescriptor(ESBImageUtils.getInstance().getImageDescriptor("esb-project-wizard.png"));
		setWindowTitle(PROJECT_WIZARD_TITLE);
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage currentPage) {
		if (currentPage == getMainWizardPage() && getModel().isDockerExporterProjectChecked()) {
			return dockerDetailPage;
		} else if ((currentPage == getMainWizardPage() && getModel().isKubernetesExporterProjectChecked())
				|| (currentPage == dockerDetailPage && getModel().isKubernetesExporterProjectChecked())) {
			return kubernetesDetailPage;
		} else {
			if (esbSolutionProjectModel.isMMMProjectChecked()) {
				this.getMavenDetailPage().updateArtifactId(esbSolutionProjectModel.getMMMProjectName());
			} else {
				this.getMavenDetailPage().updateArtifactId(esbSolutionProjectModel.getEsbProjectName());
			}
			return getMavenDetailPage();
		}
	}

	@Override
	public void addPages() {
		super.addPages();
		dockerDetailPage = new DockerDetailsPage(getModel());
		kubernetesDetailPage = new KubernetesDetailsPage(getModel());
		addPage(dockerDetailPage);
		addPage(kubernetesDetailPage);
	}

	@Override
	public boolean canFinish() {
		if (!this.getContainer().getCurrentPage().isPageComplete()) {
			return false;
		}
		if ((getContainer().getCurrentPage() == getMainWizardPage() && getModel().isDockerExporterProjectChecked())
				|| (getContainer().getCurrentPage() == getMainWizardPage()
						&& getModel().isKubernetesExporterProjectChecked())
				|| (getContainer().getCurrentPage() == dockerDetailPage && !dockerDetailPage.isPageComplete())
				|| (getContainer().getCurrentPage() == dockerDetailPage
						&& getModel().isKubernetesExporterProjectChecked())
				|| (getContainer().getCurrentPage() == kubernetesDetailPage
						&& !kubernetesDetailPage.isPageComplete())) {
			return false;
		}

		return true;
	}

	public boolean performFinish() {
		File location = new File(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());
		boolean isMMMChecked = esbSolutionProjectModel.isMMMProjectChecked();
		String projectRootPath = location.getAbsolutePath();
		String version = this.getMavenDetailPage().getMavenInformation().getVersion();
		if (version != null && !version.equals("")) {
			esbSolutionProjectModel.getMavenInfo().setVersion(version);
		}
		try {
			esbSolutionProjectModel.setGroupId(this.getMavenDetailPage().getMavenInformation().getGroupId());
		} catch (ObserverFailedException e) {
			log.error("Error while setting maven information.", e);
		}
		if (isMMMChecked) {
			// create MMM project
			MvnMultiModuleWizard mmmWizard = new MvnMultiModuleWizard();
			MvnMultiModuleModel mmmModel = mmmWizard.getMvnMultiModuleModel();
			String mmmProjectName = esbSolutionProjectModel.getMMMProjectName();
			try {
				mmmModel.setProjectName(mmmProjectName);
				mmmModel.setArtifactId(mmmProjectName);
				mmmModel.setVersion(version);
				mmmModel.setGroupId(esbSolutionProjectModel.getGroupId());
				mmmModel.setLocation(location);
				mmmModel.setMavenInfo(esbSolutionProjectModel.getMavenInfo());
				mmmModel.setIsUserDefine(esbSolutionProjectModel.isUserSet());
				mmmModel.setSelectedWorkingSets(esbSolutionProjectModel.getSelectedWorkingSets());
				mmmWizard.performFinish();
				projectRootPath = projectRootPath + File.separator + mmmProjectName;
				pomFile = mmmWizard.getPomFile();
			} catch (ObserverFailedException e) {
				log.error("Failed to set project name : " + mmmProjectName, e);
			}
		}
		
		if (esbSolutionProjectModel.isConfigProjectChecked()) {
			// Creating ESB config project
			ESBProjectWizard esbProjectWizard = new ESBProjectWizard();
			ESBProjectModel esbProjectModel = new ESBProjectModel();
			String esbProjectName = esbSolutionProjectModel.getEsbProjectName();
			try {
				esbProjectModel.setProjectName(esbProjectName);
			} catch (ObserverFailedException e) {
				log.error("Error while setting the configs project name.", e);
			}
			esbProjectModel.setLocation(
					new File(projectRootPath + File.separator + esbSolutionProjectModel.getEsbProjectName()));
			try {
				esbProjectModel.setGroupId(esbSolutionProjectModel.getGroupId());
			} catch (ObserverFailedException e) {
				log.error("Error while setting the configs project groupId.", e);
			}
			esbProjectModel.setMavenInfo(esbSolutionProjectModel.getMavenInfo());
			esbProjectModel.getMavenInfo().setArtifactId(esbProjectName);
			esbProjectModel.setIsUserDefine(esbSolutionProjectModel.isUserSet());
			esbProjectModel.setSelectedWorkingSets(esbSolutionProjectModel.getSelectedWorkingSets());
			esbProjectWizard.setEsbProjectModel(esbProjectModel);
			esbProjectWizard.setModel(esbProjectModel);
			esbProjectWizard.performFinish();
			if (!isMMMChecked) {
				pomFile = esbProjectWizard.getPomFile();
			}
			updateMavenInformation(pomFile, esbSolutionProjectModel.getEsbProjectName());
		}
		
		// Creating Registry Project
		if (esbSolutionProjectModel.isRegistryProjectChecked()) {
			GeneralProjectWizard generalProjectWizard = new GeneralProjectWizard();
			GeneralProjectModel generalProjectModel = new GeneralProjectModel();
			String registryProjectName = esbSolutionProjectModel.getRegistryProjectName();
			try {
				generalProjectModel.setProjectName(registryProjectName);
				generalProjectModel.setLocation(new File(projectRootPath + File.separator + registryProjectName));
				updateMavenInformation(pomFile, esbSolutionProjectModel.getRegistryProjectName());
				generalProjectModel.setGroupId(esbSolutionProjectModel.getGroupId());
				generalProjectModel.setMavenInfo(esbSolutionProjectModel.getMavenInfo());
				generalProjectModel.setIsUserDefine(esbSolutionProjectModel.isUserSet());
				generalProjectModel.setSelectedWorkingSets(esbSolutionProjectModel.getSelectedWorkingSets());
			} catch (ObserverFailedException e1) {
				log.error("Failed to set project name : " + registryProjectName, e1);
			}
			generalProjectWizard.setModel(generalProjectModel);
			generalProjectWizard.performFinish();
		}

		// Creating connector Exporter Project
		if (esbSolutionProjectModel.isConnectorExporterProjectChecked()) {
			ConnectorCreationWizard connectorWizard = new ConnectorCreationWizard();
			ConnectorModel connectorModel = new ConnectorModel();
			String connectorProjectName = esbSolutionProjectModel.getConnectorExporterProjectName();
			try {
				connectorModel.setProjectName(connectorProjectName);
				connectorModel.setLocation(new File(projectRootPath + File.separator + connectorProjectName));
				updateMavenInformation(pomFile, esbSolutionProjectModel.getConnectorExporterProjectName());
				connectorModel.setGroupId(esbSolutionProjectModel.getGroupId());
				connectorModel.setMavenInfo(esbSolutionProjectModel.getMavenInfo());
				connectorModel.setIsUserDefine(esbSolutionProjectModel.isUserSet());
				connectorModel.setSelectedWorkingSets(esbSolutionProjectModel.getSelectedWorkingSets());
			} catch (ObserverFailedException e1) {
				log.error("Failed to set project name : " + connectorProjectName, e1);
			}
			connectorWizard.setModel(connectorModel);
			connectorWizard.performFinish();
		}
		
        // Creating docker image exporter Project
		if (esbSolutionProjectModel.isDockerExporterProjectChecked()) {
			ContainerProjectCreationWizard dockerWizard = new ContainerProjectCreationWizard();
            DockerModel dockerModel = new DockerModel();
            String dockerProjectName = esbSolutionProjectModel.getDockerExporterProjectName();
            try {
                dockerModel.setProjectName(dockerProjectName);
                dockerModel.setLocation(new File(projectRootPath + File.separator + dockerProjectName));
                updateMavenInformation(pomFile, esbSolutionProjectModel.getDockerExporterProjectName());
                dockerModel.setGroupId(esbSolutionProjectModel.getGroupId());
                dockerModel.setMavenInfo(esbSolutionProjectModel.getMavenInfo());
                dockerModel.setIsUserDefine(esbSolutionProjectModel.isUserSet());
                dockerModel.setSelectedWorkingSets(esbSolutionProjectModel.getSelectedWorkingSets());
                dockerModel.setDockerRemoteRepository(esbSolutionProjectModel.getDockerRemoteRepository());
                dockerModel.setDockerRemoteTag(esbSolutionProjectModel.getDockerRemoteTag());
                dockerModel.setDockerTargetRepository(esbSolutionProjectModel.getDockerTargetRepository());
                dockerModel.setDockerTargetTag(esbSolutionProjectModel.getDockerTargetTag());
                dockerModel.setDockerExporterProjectChecked(
                        esbSolutionProjectModel.isDockerExporterProjectChecked());
                
                for (Map.Entry<String, String> item : esbSolutionProjectModel.getKubernetesEnvParameters().entrySet()) {
                    dockerModel.getDockerEnvParameters().put(item.getKey(), item.getValue());
                }
            } catch (ObserverFailedException e1) {
                log.error("Failed to set project name : " + dockerProjectName, e1);
            }
            dockerWizard.setOpenEditor(false);
            dockerWizard.setModel(dockerModel);
            dockerWizard.performFinish();
        }

		// Creating Kubernetes image exporter Project
		if (esbSolutionProjectModel.isKubernetesExporterProjectChecked()) {
			ContainerProjectCreationWizard containerWizard = new ContainerProjectCreationWizard();
			DockerModel kubeModel = new DockerModel();
			String kubeProjectName = esbSolutionProjectModel.getKubernetesExporterProjectName();
			try {
				kubeModel.setProjectName(kubeProjectName);
				kubeModel.setLocation(new File(projectRootPath + File.separator + kubeProjectName));
				updateMavenInformation(pomFile, esbSolutionProjectModel.getKubernetesExporterProjectName());
				kubeModel.setGroupId(esbSolutionProjectModel.getGroupId());
				kubeModel.setMavenInfo(esbSolutionProjectModel.getMavenInfo());
				kubeModel.setIsUserDefine(esbSolutionProjectModel.isUserSet());
				kubeModel.setSelectedWorkingSets(esbSolutionProjectModel.getSelectedWorkingSets());
				kubeModel.setKubeContainerName(esbSolutionProjectModel.getKubeContainerName());
				kubeModel.setKubeReplicsas(esbSolutionProjectModel.getKubeReplicsas());
				kubeModel.setKubeReplicsas(esbSolutionProjectModel.getKubeReplicsas());
				kubeModel.setKubeRemoteRepository(esbSolutionProjectModel.getKubeRemoteRepository());
				kubeModel.setKubeRemoteTag(esbSolutionProjectModel.getKubeRemoteTag());
				kubeModel.setKubeTargetRepository(esbSolutionProjectModel.getKubeTargetRepository());
				kubeModel.setKubeTargetTag(esbSolutionProjectModel.getKubeTargetTag());
				kubeModel.setKubernetesExporterProjectChecked(
						esbSolutionProjectModel.isKubernetesExporterProjectChecked());

				for (Map.Entry<String, String> item : esbSolutionProjectModel.getKubernetesPortParameters().entrySet()) {
					kubeModel.getKubernetesPortParameters().put(item.getKey(), item.getValue());
				}
				
				for (Map.Entry<String, String> item : esbSolutionProjectModel.getKubernetesEnvParameters().entrySet()) {
                    kubeModel.getKubernetesEnvParameters().put(item.getKey(), item.getValue());
                }
			} catch (ObserverFailedException e1) {
				log.error("Failed to set project name : " + kubeProjectName, e1);
			}
			containerWizard.setOpenEditor(false);
			containerWizard.setModel(kubeModel);
			containerWizard.performFinish();
		}

		// Creating Composite Project
		if (esbSolutionProjectModel.isCappProjectChecked()) {
			DistributionProjectWizard distributionProjectWizard = new DistributionProjectWizard();
			DistributionProjectModel distributionModel = new DistributionProjectModel();
			String distributionProjectName = esbSolutionProjectModel.getCompositeApplicationProjectName();
			try {
				distributionModel.setProjectName(distributionProjectName);
				distributionModel.setLocation(new File(projectRootPath + File.separator + distributionProjectName));
				distributionModel.setIsUserDefine(esbSolutionProjectModel.isUserSet());
				updateMavenInformation(pomFile, distributionProjectName);
				distributionModel.setGroupId(esbSolutionProjectModel.getGroupId());
				distributionModel.setMavenInfo(esbSolutionProjectModel.getMavenInfo());
				distributionModel.setSelectedOption(esbSolutionProjectModel.getSelectedOption());
				distributionModel.setSelectedWorkingSets(esbSolutionProjectModel.getSelectedWorkingSets());
			} catch (ObserverFailedException e) {
				log.error("Failed to set properties for project : " + distributionProjectName, e);
			}
			distributionProjectWizard.setModel(distributionModel);
			distributionProjectWizard.performFinish();
		}
		
        getShell().getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                if (!ESB_GRAPHICAL_PERSPECTIVE.equals(window.getActivePage().getPerspective().getId())) {
                    try {
                        PlatformUI.getWorkbench().showPerspective(ESB_GRAPHICAL_PERSPECTIVE, window);
                        ProjectPresentation.setHierarchicalProjectPresentation();
                    } catch (Exception e) {
                        log.error("Cannot switch to ESB Graphical Perspective", e);
                    }
                }
            }
        });
        return true;
	}

	private void updateMavenInformation(File pomLocation, String name) {
		MavenProject mavenProject = getMavenProject(pomLocation);
		esbSolutionProjectModel.getMavenInfo().setGroupId(mavenProject.getGroupId());
		esbSolutionProjectModel.getMavenInfo().setArtifactId(name);
		esbSolutionProjectModel.getMavenInfo().setVersion(mavenProject.getVersion());
	}

	public MavenProject getMavenProject(File pomLocation) {
		MavenProject mavenProject = null;
		if (pomLocation != null && pomLocation.exists()) {
			try {
				mavenProject = MavenUtils.getMavenProject(pomLocation);
			} catch (Exception e) {
				log.error("error reading pom file", e);
			}
		}
		return mavenProject;

	}

	public ESBSolutionProjectModel getEsbSolutionProjectModel() {
		return esbSolutionProjectModel;
	}

	public void setEsbSolutionProjectModel(ESBSolutionProjectModel esbProjectModel) {
		this.esbSolutionProjectModel = esbProjectModel;
	}

	public IResource getCreatedResource() {
		return project;
	}

	public void setCurrentSelection(ISelection currentSelection) {
		// TODO Auto-generated method stub
		super.setCurrentSelection(currentSelection);
	}

}
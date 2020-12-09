/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.esb.docker.wizard;

import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.esb.docker.Activator;
import org.wso2.developerstudio.eclipse.distribution.project.model.DependencyData;
import org.wso2.developerstudio.eclipse.esb.docker.wizard.CarExportDetailsWizardPage;
import org.wso2.developerstudio.eclipse.distribution.project.ui.wizard.DistributionProjectExportWizardPage;
import org.wso2.developerstudio.eclipse.distribution.project.util.ArtifactTypeMapping;
import org.wso2.developerstudio.eclipse.distribution.project.util.DistProjectUtils;
import org.wso2.developerstudio.eclipse.distribution.project.validator.ProjectList;
import org.wso2.developerstudio.eclipse.docker.distribution.job.GenerateDockerImageJob;
import org.wso2.developerstudio.eclipse.docker.distribution.model.MicroIntegratorDockerModel;
import org.wso2.developerstudio.eclipse.docker.distribution.resources.DockerGenConstants;
import org.wso2.developerstudio.eclipse.docker.distribution.resources.ExportImageWizardConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider.ListData;
import org.wso2.developerstudio.eclipse.platform.core.project.export.util.ExportUtil;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

/**
 * Wizard for docker image generation.
 *
 */
public class ExportAndGenerateDockerImageWizard extends Wizard implements IExportWizard {
    
    protected static final String CAPP_APPLICATION_SERVER = "capp/ApplicationServer";
    protected static final String ARTIFACT_TYPES = "capp/ApplicationServer";
    protected static final String POM_FILE_NAME = "pom.xml";
    protected static final String DOCKER_IMAGE_NAME_SESSION_PROPERTY_SUFFIX = "DIN";
    protected static final String DOCKER_IMAGE_TAG_SESSION_PROPERTY_SUFFIX = "DTN";

    private DistributionProjectExportWizardPage mainPage;
    private CarExportDetailsWizardPage detailsPage;
    private IFile pomFileRes;
    private File pomFile;
    private IProject selectedProject;
    private MavenProject parentPrj;
    private boolean initError = false;
    private GenerateDockerImageJob dockerJob;

    private Map<String, DependencyData> projectList = new HashMap<String, DependencyData>();
    private Map<String, Dependency> dependencyMap = new HashMap<String, Dependency>();
    private Map<String, String> serverRoleList = new HashMap<String, String>();
    private ArtifactTypeMapping artifactTypeMapping = new ArtifactTypeMapping();
    
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {

        try {
            detailsPage = new CarExportDetailsWizardPage(workbench, selection);
            selectedProject = getSelectedProject(selection);
            pomFileRes = selectedProject.getFile(POM_FILE_NAME);
            pomFile = pomFileRes.getLocation().toFile();

            if (!selectedProject.hasNature(Constants.DISTRIBUTION_PROJECT_NATURE)) {
                throw new Exception();
            }

            ProjectList projectListProvider = new ProjectList();
            List<ListData> projectListData = projectListProvider.getListData(null, null);

            for (ListData data : projectListData) {
                DependencyData dependencyData = (DependencyData) data.getData();
                projectList.put(data.getCaption(), dependencyData);
            }

            parentPrj = MavenUtils.getMavenProject(pomFile);

            for (Dependency dependency : (List<Dependency>) parentPrj.getDependencies()) {
                dependencyMap.put(DistProjectUtils.getArtifactInfoAsString(dependency), dependency);
                serverRoleList.put(DistProjectUtils.getArtifactInfoAsString(dependency),
                        DistProjectUtils.getServerRole(parentPrj, dependency));
            }

            mainPage = new DistributionProjectExportWizardPage(parentPrj);
            mainPage.setProjectList(projectList);
            mainPage.setDependencyList(dependencyMap);
            mainPage.setMissingDependencyList(
                    (Map<String, Dependency>) ((HashMap<String, Dependency>) mainPage.getDependencyList()).clone());
            mainPage.setServerRoleList(serverRoleList);

            detailsPage.setName(parentPrj.getModel().getArtifactId());
            detailsPage.setVersion(parentPrj.getModel().getVersion());

        } catch (Exception e) {
            initError = true;
            Display display = PlatformUI.getWorkbench().getDisplay();

            Shell shell = display.getActiveShell();
            openMessageBox(shell, ExportImageWizardConstants.DIALOG_TITLE_TEXT,
                    ExportImageWizardConstants.SELECT_VALID_CARBON_APP_MESSAGE, SWT.ICON_INFORMATION);
        }
    }

    @Override
    public boolean canFinish() {
        if (dependencyMap.size() == 0) {
            return false;
        }

        return super.canFinish();
    }

    @Override
    public boolean performFinish() {

        String finalFileName = String.format(ExportImageWizardConstants.CAR_FILE_NAME_PLACEHOLDER, detailsPage.getName()
                .replaceAll(ExportImageWizardConstants.CAR_FILE_SUFFIX, ExportImageWizardConstants.EMPTY_STRING),
                detailsPage.getVersion());

        String dockerDirPath = getWorkingDirectory() + File.separator
                + ExportImageWizardConstants.DOCKER_IMAGE_TEMPORARY_DIR_NAME;
        String eiDistributionSourcePath = getWorkingDirectory() + File.separator
                + ExportImageWizardConstants.MICRO_EI_DISTRIBUTION_REL_PATH;
        String eiDistrubitionDestinationPath = getWorkingDirectory() + File.separator
                + ExportImageWizardConstants.DOCKER_IMAGE_TEMPORARY_DIR_NAME + File.separator
                + ExportImageWizardConstants.EI_DISTRIBUTION_NAME;
        String deploymentPath = eiDistrubitionDestinationPath + File.separator + ExportImageWizardConstants.DEPLOYMENT_DIR_REL_PATH;

        try {
            File dockerDir = new File(dockerDirPath);

            if (dockerDir.exists()) {
                // Clear the temporary docker directory if exists
                org.apache.commons.io.FileUtils.cleanDirectory(new File(dockerDirPath));
            } else {
                // Create temporary docker directory
                FileUtils.createDirectory(dockerDirPath);
            }

            if (mainPage.isPageDirty() || detailsPage.isPageDirty()) {
                savePOM();
            }

            // Copy the exported car file to the docker directory
            File destFileName = new File(dockerDirPath, finalFileName);
            IResource carbonArchive = ExportUtil.buildCAppProject(selectedProject);
            FileUtils.copy(carbonArchive.getLocation().toFile(), destFileName);

            // Create a docker model
            MicroIntegratorDockerModel dockerModel = new MicroIntegratorDockerModel();
            dockerModel.setName(detailsPage.getImageName());
            dockerModel.setTag(detailsPage.getImageTag());
            dockerModel.setCommandArg(DockerGenConstants.ImageParamDefaults.EI_START_COMMAND);
            dockerModel.setPorts(DockerGenConstants.ImageParamDefaults.ports);
            dockerModel.setServerHome(eiDistrubitionDestinationPath);

            // Create and schedule a background job to generate the docker image
            dockerJob = new GenerateDockerImageJob(dockerDirPath, eiDistributionSourcePath,
                    eiDistrubitionDestinationPath, deploymentPath, detailsPage.getExportPath(),
                    destFileName, dockerModel);
            dockerJob.schedule();

        } catch (Exception e) {
            log.error(ExportImageWizardConstants.ERROR_CREATING_CAR_FILE_MSG, e);
            openMessageBox(getShell(), ExportImageWizardConstants.DIALOG_TITLE_TEXT,
                    ExportImageWizardConstants.ERROR_CREATING_CAR_FILE_MSG + " For more details view the log.\n",
                    SWT.ICON_ERROR);
        }

        setSessionProperty();

        return true;
    }

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

    private void savePOM() throws Exception {
        writeProperties();
        parentPrj.setDependencies(new ArrayList<Dependency>(mainPage.getDependencyList().values()));
        MavenUtils.saveMavenProject(parentPrj, pomFile);
        pomFileRes.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
    }

    private void writeProperties() {
        Properties properties = parentPrj.getModel().getProperties();
        identifyNonProjectProperties(properties);
        for (Dependency dependency : mainPage.getDependencyList().values()) {
            String artifactInfo = DistProjectUtils.getArtifactInfoAsString(dependency);

            if (mainPage.getServerRoleList().containsKey(artifactInfo)) {
                properties.put(artifactInfo, serverRoleList.get(artifactInfo));
            } else {
                properties.put(artifactInfo, CAPP_APPLICATION_SERVER);
            }
        }

        properties.put(ARTIFACT_TYPES, artifactTypeMapping.getArtifactTypes());
        parentPrj.getModel().setProperties(properties);
    }
    
    private Properties identifyNonProjectProperties(Properties properties) {
        Map<String, DependencyData> dependencies = projectList;

        for (Iterator<DependencyData> iterator = dependencies.values().iterator(); iterator.hasNext();) {
            DependencyData dependency = (DependencyData) iterator.next();
            String artifactInfoAsString = DistProjectUtils.getArtifactInfoAsString(dependency.getDependency());

            if (properties.containsKey(artifactInfoAsString)) {
                properties.remove(artifactInfoAsString);
            }
        }

        // Removing the artifact.type
        properties.remove(ARTIFACT_TYPES);

        return properties;
    }

    public void addPages() {
        if (!initError) {
            addPage(detailsPage);
            addPage(mainPage);
            super.addPages();
        }
    }

    private void setSessionProperty() {
        try {
            IProject selectedProject = detailsPage.getSelectedProject();
            selectedProject.setSessionProperty(new QualifiedName(ExportImageWizardConstants.EMPTY_STRING,
                    detailsPage.getSelectedProject().getName()), detailsPage.getTxtExportPathText().getText());
            selectedProject.setSessionProperty(
                    new QualifiedName(ExportImageWizardConstants.EMPTY_STRING,
                            detailsPage.getSelectedProject().getName() + DOCKER_IMAGE_NAME_SESSION_PROPERTY_SUFFIX),
                    detailsPage.getImageName());
            selectedProject.setSessionProperty(
                    new QualifiedName(ExportImageWizardConstants.EMPTY_STRING,
                            detailsPage.getSelectedProject().getName() + DOCKER_IMAGE_TAG_SESSION_PROPERTY_SUFFIX),
                    detailsPage.getImageTag());
        } catch (CoreException e) {
            log.error("Error geting session properties", e);
        }
    }

    private int openMessageBox(Shell shell, String title, String message, int style) {
        MessageBox exportMsg = new MessageBox(shell, style);
        exportMsg.setText(title);
        exportMsg.setMessage(message);

        return exportMsg.open();
    }

    private String getWorkingDirectory() {
        String workingDirectory = null;
        String OS = System.getProperty(ExportImageWizardConstants.OS_NAME,
                ExportImageWizardConstants.SYSTEM_PROPERTY_TYPE_GENERIC).toLowerCase(Locale.ENGLISH);

        if ((OS.indexOf(ExportImageWizardConstants.OS_TYPE_MAC) >= 0)
                || (OS.indexOf(ExportImageWizardConstants.OS_TYPE_DARWIN) >= 0)) {
            String eiToolingHomeForMac = ExportImageWizardConstants.EI_TOOLING_HOME_MACOS;
            File macOSEIToolingAppFile = new File(eiToolingHomeForMac);

            if (macOSEIToolingAppFile.exists()) {
                workingDirectory = eiToolingHomeForMac;
            } else {
                Path path = Paths.get(ExportImageWizardConstants.EMPTY_STRING);
                workingDirectory = (path).toAbsolutePath().toString();
            }

        } else {
            java.nio.file.Path path = Paths.get(ExportImageWizardConstants.EMPTY_STRING);
            workingDirectory = (path).toAbsolutePath().toString();
        }

        return workingDirectory;
    }

}

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
import org.wso2.developerstudio.eclipse.esb.docker.job.GenerateDockerImageJob;
import org.wso2.developerstudio.eclipse.distribution.project.model.DependencyData;
import org.wso2.developerstudio.eclipse.esb.docker.wizard.CarExportDetailsWizardPage;
import org.wso2.developerstudio.eclipse.distribution.project.ui.wizard.DistributionProjectExportWizardPage;
import org.wso2.developerstudio.eclipse.distribution.project.util.ArtifactTypeMapping;
import org.wso2.developerstudio.eclipse.distribution.project.util.DistProjectUtils;
import org.wso2.developerstudio.eclipse.distribution.project.validator.ProjectList;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider.ListData;
import org.wso2.developerstudio.eclipse.platform.core.project.export.util.ExportUtil;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class ExportAndGenerateDockerImageWizard extends Wizard implements IExportWizard {

    private static final String EI_TOOLING_HOME_MACOS = "/Applications/DeveloperStudio.app/Contents/MacOS";
    private static final String DOCKER_IMAGE_TEMPORARY_DIR_NAME = "dockerImageTemp";
    private static final String OS_TYPE_DARWIN = "darwin";
    private static final String OS_TYPE_MAC = "mac";
    private static final String SYSTEM_PROPERTY_TYPE_GENERIC = "generic";
    private static final String OS_NAME = "os.name";
    private DistributionProjectExportWizardPage mainPage;
    private CarExportDetailsWizardPage detailsPage;
    private IFile pomFileRes;
    private File pomFile;
    private IProject selectedProject;
    private MavenProject parentPrj;
    private boolean initError = false;
    private String deploymentFolderPath;
    private GenerateDockerImageJob dockerJob;

    private Map<String, DependencyData> projectList = new HashMap<String, DependencyData>();
    private Map<String, Dependency> dependencyMap = new HashMap<String, Dependency>();
    private Map<String, String> serverRoleList = new HashMap<String, String>();
    private ArtifactTypeMapping artifactTypeMapping = new ArtifactTypeMapping();
    
    private static final String DIALOG_TITLE_TEXT = "WSO2 Platform Distribution - Generate Docker Image";
    private static final String EMPTY_STRING = "";
    private static final String MICRO_EI_DISTRIBUTION_REL_PATH = "runtime" + File.separator + "microesb";
    private static final String MICRO_EI_HOME_REL_PATH = "wso2" + File.separator + "micro-integrator";
    private static final String DEPLOYMENT_DIR_REL_PATH = "repository" + File.separator + "deployment" + File.separator + "server" + File.separator + "carbonapps";

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    @Override
    @SuppressWarnings("unchecked")
    public void init(IWorkbench workbench, IStructuredSelection selection) {

        try {
            //deploymentFolderPath = MicroIntegratorInstance.getInstance().getServerHome() + File.separator + DEPLOYMENT_DIR_REL_PATH;
            detailsPage = new CarExportDetailsWizardPage(workbench, selection);
            selectedProject = getSelectedProject(selection);
            pomFileRes = selectedProject.getFile("pom.xml");
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
            mainPage.setMissingDependencyList((Map<String, Dependency>) ((HashMap<String, Dependency>) 
                    mainPage.getDependencyList()).clone());
            mainPage.setServerRoleList(serverRoleList);
            detailsPage.setName(parentPrj.getModel().getArtifactId());
            detailsPage.setVersion(parentPrj.getModel().getVersion());

        } catch (Exception e) {
            initError = true;
            Display display = PlatformUI.getWorkbench().getDisplay();
            Shell shell = display.getActiveShell();
            openMessageBox(shell, DIALOG_TITLE_TEXT, "Please select a valid carbon application project",
                    SWT.ICON_INFORMATION);
        }
    }

    public void savePOM() throws Exception {
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
                properties.put(artifactInfo, "capp/ApplicationServer");
            }
        }
        properties.put("artifact.types", artifactTypeMapping.getArtifactTypes());
        parentPrj.getModel().setProperties(properties);
    }

    private Properties identifyNonProjectProperties(Properties properties) {
        Map<String, DependencyData> dependencies = projectList;
        
        for (Iterator iterator = dependencies.values().iterator(); iterator.hasNext();) {
            DependencyData dependency = (DependencyData) iterator.next();
            String artifactInfoAsString = DistProjectUtils.getArtifactInfoAsString(dependency.getDependency());
            if (properties.containsKey(artifactInfoAsString)) {
                properties.remove(artifactInfoAsString);
            }
        }
        
        // Removing the artifact.type
        properties.remove("artifact.types");

        return properties;
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

    public void addPages() {
        if (!initError) {
            addPage(detailsPage);
            addPage(mainPage);
            super.addPages();
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

        String finalFileName = String.format("%s_%s.car", detailsPage.getName().replaceAll(".car$", ""),
                detailsPage.getVersion());
        
        String temporaryFolderPath = getWorkingDirectory() + File.separator + DOCKER_IMAGE_TEMPORARY_DIR_NAME;
        String eiDestributionAbsPath = getWorkingDirectory() + File.separator + MICRO_EI_DISTRIBUTION_REL_PATH;
        String eiHomeAbsPath = temporaryFolderPath + File.separator + MICRO_EI_HOME_REL_PATH;
        String deploymentAbsPath = eiHomeAbsPath + File.separator + DEPLOYMENT_DIR_REL_PATH;
        
        try {
            File destFileName = new File(temporaryFolderPath, finalFileName);

            if (mainPage.isPageDirty() || detailsPage.isPageDirty()) {
                savePOM();
            }
            
            FileUtils.createDirectory(temporaryFolderPath);

            IResource carbonArchive = ExportUtil.buildCAppProject(selectedProject);
            FileUtils.copy(carbonArchive.getLocation().toFile(), destFileName);
            
            dockerJob = new GenerateDockerImageJob(temporaryFolderPath, eiDestributionAbsPath, 
                    eiHomeAbsPath, deploymentAbsPath, detailsPage.getExportPath(), this, destFileName);
            dockerJob.schedule();

        } catch (Exception e) {
            log.error("An error occured while creating the carbon archive file", e);
            openMessageBox(getShell(), DIALOG_TITLE_TEXT,
                    "An error occured while creating the carbon archive file. For more details view the log.\n",
                    SWT.ICON_ERROR);
        }

        setSessionProperty();

        return true;
    }

    private void setSessionProperty() {
        try {
            detailsPage.getSelectedProject().setSessionProperty(
                    new QualifiedName(EMPTY_STRING, detailsPage.getSelectedProject().getName()),
                    detailsPage.getTxtExportPathText().getText());
        } catch (CoreException e) {
            log.error("Error geting session properties", e);
        }
    }

    protected int openMessageBox(Shell shell, String title, String message, int style) {
        MessageBox exportMsg = new MessageBox(shell, style);
        exportMsg.setText(title);
        exportMsg.setMessage(message);
        return exportMsg.open();
    }
    
    private String getWorkingDirectory() {
        String workingDirectory = null;
        String OS = System.getProperty(OS_NAME, SYSTEM_PROPERTY_TYPE_GENERIC).toLowerCase(Locale.ENGLISH);
        if ((OS.indexOf(OS_TYPE_MAC) >= 0) || (OS.indexOf(OS_TYPE_DARWIN) >= 0)) {
            String eiToolingHomeForMac = EI_TOOLING_HOME_MACOS;
            File macOSEIToolingAppFile = new File(eiToolingHomeForMac);
            if(macOSEIToolingAppFile.exists()) {
                workingDirectory = eiToolingHomeForMac;
            } else {
                java.nio.file.Path path = Paths.get(EMPTY_STRING);
                workingDirectory = (path).toAbsolutePath().toString();
            }
            
        } else {
            java.nio.file.Path path = Paths.get(EMPTY_STRING);
            workingDirectory = (path).toAbsolutePath().toString();
        }
        return workingDirectory;
    }

}

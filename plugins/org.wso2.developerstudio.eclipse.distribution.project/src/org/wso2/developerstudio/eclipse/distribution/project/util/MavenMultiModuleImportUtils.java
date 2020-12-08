/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.distribution.project.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.FileUtils;
import org.apache.maven.model.Profile;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.wizards.datatransfer.FileSystemStructureProvider;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.rauschig.jarchivelib.ArchiveFormat;
import org.rauschig.jarchivelib.Archiver;
import org.rauschig.jarchivelib.ArchiverFactory;
import org.w3c.dom.Document;
import org.wso2.developerstudio.eclipse.distribution.project.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.project.presentation.ProjectPresentation;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.xml.sax.SAXException;

public class MavenMultiModuleImportUtils {

    private static final IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private static final String DIR_DOT_METADATA = ".metadata";
    private static final String DIR_CONNECTORS = ".Connectors";
    private static final String ZIP_FILE_EXTENSION = ".zip";
    private static final String MMM_EDITOR_ID = "org.wso2.developerstudio.eclipse.maven.multi.module.editor.DistProjectEditor";
    public static IProject IMPORTED_ESB_PROJECT;
    public static IProject IMPORTED_DSS_PROJECT;
    public static IProject IMPORTED_DOCKER_PROJECT;
    public static IProject IMPORTED_K8S_PROJECT;
    public static boolean isProcessOfSampleCreating = false;
    
    public static boolean extractZipFile(File sourceFile, File destination) {
        Archiver archiver = ArchiverFactory.createArchiver(ArchiveFormat.ZIP);
        try {
            archiver.extract(sourceFile, destination);
        } catch (IOException e) {
            log.error("CError exception extracting archive file", e);
            return false;
        }
        return true;
    }

    public static boolean importMavenMultiModuleProjectToWorkspace(File importingMMMProject) {
        boolean isMavenMultiModuleCreatedSuccessfully = true;
        try {
            IWorkspace workspace = ResourcesPlugin.getWorkspace();
            File projectFile = new File(importingMMMProject.getAbsolutePath() + File.separator + ".project");
            String projectNature = MavenMultiModuleImportUtils.readProjectNatureFromProjectFile(projectFile);
            IProject mainProject = workspace.getRoot().getProject(importingMMMProject.getName());

            IProjectDescription newProjectDescription = workspace.newProjectDescription(importingMMMProject.getName());
            String[] natureIds = { projectNature };
            newProjectDescription.setNatureIds(natureIds);
            String mmmProject = workspace.getRoot().getLocation().toOSString() + File.separator
                    + importingMMMProject.getName();
            File mmmProjectFile = new File(mmmProject);
            URI mmmProjectURI = mmmProjectFile.toURI();
            newProjectDescription.setLocationURI(mmmProjectURI);

            mainProject.create(newProjectDescription, new NullProgressMonitor());
            ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            mainProject.open(IResource.BACKGROUND_REFRESH, new NullProgressMonitor());
            mainProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            // If this is not a maven project, try to import connectors
            MavenMultiModuleImportUtils.importConnectorsFromConnectorExporterProject(mainProject);
            // create sub projects/directories under the created parent project
            isMavenMultiModuleCreatedSuccessfully = createSubModulesInMMM(importingMMMProject, mainProject,
                    new NullProgressMonitor());
        } catch (CoreException e) {
            isMavenMultiModuleCreatedSuccessfully = false;
            log.error("CoreException exception while importing", e);
        } catch (Exception e) {
            isMavenMultiModuleCreatedSuccessfully = false;
            log.error("Error while importing project to selected MMM project", e);
        }

        return isMavenMultiModuleCreatedSuccessfully;
    }

    public static boolean createSubModulesInMMM(File sourceDirectory, IProject mainProject, IProgressMonitor monitor) {
        boolean isSubModulesSuccessfullyCreated = true;
        try {
            List filesToImport = FileSystemStructureProvider.INSTANCE.getChildren(sourceDirectory);
            for (Object resource : filesToImport) {
                File resourceFile = (File) resource;

                if (resourceFile.isDirectory()) {
                    IProjectDescription newSubProjectDescription = mainProject.getWorkspace()
                            .newProjectDescription(resourceFile.getName());
                    String subProject = mainProject.getLocation().toOSString() + File.separator
                            + resourceFile.getName();
                    File subProjectFile = new File(subProject);
                    URI subProjectURI = subProjectFile.toURI();
                    newSubProjectDescription.setLocationURI(subProjectURI);
                    File[] subProjectList = resourceFile.listFiles();
                    for (File file : subProjectList) {
                        if (file.getName().equals(".project")) {
                            String[] subNatureIds = {
                                    MavenMultiModuleImportUtils.readProjectNatureFromProjectFile(file) };
                            newSubProjectDescription.setNatureIds(subNatureIds);
                            break;
                        }
                    }
                    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
                    IProject subIProject = root.getProject(resourceFile.getName());
                    subIProject.create(newSubProjectDescription, new NullProgressMonitor());
                    subIProject.open(new NullProgressMonitor());
                    ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
                    
                    try {
                    	subIProject.create(newSubProjectDescription, new NullProgressMonitor());
                    } catch(Exception e) {}
                    
                    if (newSubProjectDescription.getNatureIds()[0].equals(Constants.ESB_PROJECT_NATURE)
                            && isProcessOfSampleCreating) {
                        IMPORTED_ESB_PROJECT = subIProject;
                    } else if (newSubProjectDescription.getNatureIds()[0].equals(Constants.DS_PROJECT_NATURE)
                            && isProcessOfSampleCreating) {
                        IMPORTED_DSS_PROJECT = subIProject;
                    } else if (newSubProjectDescription.getNatureIds()[0]
                            .equals(Constants.DOCKER_EXPORTER_PROJECT_NATURE) && isProcessOfSampleCreating) {
                        IMPORTED_DOCKER_PROJECT = subIProject;
                    } else if (newSubProjectDescription.getNatureIds()[0]
                            .equals(Constants.KUBERNETES_EXPORTER_PROJECT_NATURE) && isProcessOfSampleCreating) {
                        IMPORTED_K8S_PROJECT = subIProject;
                    }

                    IOverwriteQuery overwriteQuery = new IOverwriteQuery() {
                        public String queryOverwrite(String file) {
                            return ALL;
                        }
                    };

                    List subImportFiles = FileSystemStructureProvider.INSTANCE.getChildren(resourceFile);
                    ImportOperation operation = new ImportOperation(subIProject.getFullPath(), resourceFile,
                            FileSystemStructureProvider.INSTANCE, overwriteQuery, subImportFiles);
                    operation.setContext(getShell());
                    operation.setOverwriteResources(true);
                    operation.setCreateContainerStructure(false);
                    operation.run(monitor);
                    ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

                    // If this is a connector exporter project, import connectors.
                    MavenMultiModuleImportUtils.importConnectorsFromConnectorExporterProject(subIProject);
                } else {
                    Files.copy(resourceFile.toPath(),
                            (new File(mainProject.getLocation().toOSString() + File.separator + resourceFile.getName()))
                                    .toPath(),
                            StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (InvocationTargetException e) {
            log.error("InvocationTargetException exception while importing", e);
            isSubModulesSuccessfullyCreated = false;
        } catch (InterruptedException e) {
            log.error("InterruptedException exception while importing", e);
            isSubModulesSuccessfullyCreated = false;
        } catch (CoreException e) {
            log.error("CoreException exception while importing", e);
            isSubModulesSuccessfullyCreated = false;
        } catch (IOException e) {
            log.error("IOException exception while importing", e);
            isSubModulesSuccessfullyCreated = false;
        }

        return isSubModulesSuccessfullyCreated;
    }

    /**
     * This method import connectors inside a given connector project.
     * 
     * @param project project to import connectors
     */
    public static void importConnectorsFromConnectorExporterProject(IProject project) {
        try {
            if (project.hasNature(Constants.CONNECTOR_PROJECT_NATURE)) {
                List fileList = FileSystemStructureProvider.INSTANCE.getChildren(new File(project.getLocationURI()));
                String parentDirectoryPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString()
                        + File.separator + DIR_DOT_METADATA + File.separator + DIR_CONNECTORS;
                File parentDirectory = new File(parentDirectoryPath);
                if (!parentDirectory.exists()) {
                    parentDirectory.mkdir();
                }
                for (Object resource : fileList) {
                    File resourceFile = (File) resource;
                    String source = resourceFile.getAbsolutePath();
                    // Check if the file is a connector.
                    if ((source.length() > 4) && source.substring(source.length() - 4).equals(ZIP_FILE_EXTENSION)) {
                        // Copy zip file.
                        FileUtils.copyFileToDirectory(resourceFile, parentDirectory);

                        // Extract the zip file.
                        String[] segments = source.split(Pattern.quote(File.separator));
                        String zipFileName = segments[segments.length - 1].split(ZIP_FILE_EXTENSION)[0];
                        String zipDestination = parentDirectoryPath + File.separator + zipFileName;
                        Archiver archiver = ArchiverFactory.createArchiver(ArchiveFormat.ZIP);
                        archiver.extract(resourceFile, new File(zipDestination));

                        // Refresh the project.
                        project.refreshLocal(IResource.DEPTH_INFINITE, null);

                        // Set ConnectorAdded flag to true.
                        IEclipsePreferences rootNode = Platform.getPreferencesService().getRootNode();
                        rootNode.put("ConnectorAdded", String.valueOf(true));
                    }
                }
            }
        } catch (CoreException e) {
            log.error("Connector import : Failed to check project nature : ", e);
        } catch (IOException e) {
            log.error("Error while copying the connector file : ", e);
        }
    }

    public static String readProjectNatureFromProjectFile(File projectFile) {
        String nature = "";
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(projectFile);
            XPathExpression xpRepo = XPathFactory.newInstance().newXPath()
                    .compile("/projectDescription/natures/nature");
            nature = xpRepo.evaluate(doc);
        } catch (ParserConfigurationException e) {
            log.error("ParserConfigurationException exception while importing", e);
        } catch (XPathExpressionException e) {
            log.error("XPathExpressionException exception while importing", e);
        } catch (SAXException e) {
            log.error("SAXException exception while importing", e);
        } catch (IOException e) {
            log.error("IOException exception while importing", e);
        }
        return nature;
    }
    
    public static void addModuleToParentPOM(IProject mavenProjectNewModule) {
        try {
            IFile pomIFile = mavenProjectNewModule.getFile("pom.xml");
            File pomFile = new File(pomIFile.getLocationURI().getPath());
            MavenProject mavenProject = MavenUtils.getMavenProject(pomFile);
            Map<String, String> projectModules = new HashMap<>();
            
            //read modules with natures
            File mavenMMProject = new File(mavenProjectNewModule.getLocation().toOSString());
            File[] listOfModules = mavenMMProject.listFiles();
            for (File file : listOfModules) {
                if (file.isDirectory()) {
                    File[] subProjectList = file.listFiles();
                    for (File subFile : subProjectList) {
                        if (subFile.getName().equals(".project")) {
                            String subNatureId = MavenMultiModuleImportUtils.readProjectNatureFromProjectFile(subFile);
                            projectModules.put(file.getName(), subNatureId);
                            break;
                        }
                    }
                }
            }
            mavenProject.getModules().clear();
            List<String> sortedModules = sortProjectsInBuildOrder(projectModules);
            for (String module : sortedModules) {
                if (!mavenProject.getModules().contains(module)) {
                    mavenProject.getModules().add(module);
                }
            }
            createMavenProfiles(projectModules, mavenProject);
            MavenUtils.saveMavenProject(mavenProject, pomFile);
            pomIFile.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            Display.getDefault().syncExec(new Runnable() {
                public void run() {
                    try {
                        setPerspective(getShell());
                        IFile pom = mavenProjectNewModule.getFile("pom.xml");
                        IWorkbenchPage page = getWorkbenchWindow().getActivePage();
                        page.openEditor(new FileEditorInput(pom), MMM_EDITOR_ID);
                        IViewPart view = page.findView(IPageLayout.ID_PROJECT_EXPLORER);
                        ((ISetSelectionTarget) view).selectReveal(new StructuredSelection(pom));
                    } catch (Exception e) {
                        log.error("Error while loading MMM Editor", e);
                    }
                }
            });
        } catch (Exception e) {
            log.error("Error while reading MMM pomfile", e);
        }
    }
    
    /**
     * This methods sorts modules according to the order which they should be built.
     * 
     * @param modules modules to be sorted
     * @return sorted modules
     */
    private static List<String> sortProjectsInBuildOrder(Map<String, String> modules) {
        List<List<String>> moduleMap = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            moduleMap.add(new ArrayList<String>());
        }

        for (Map.Entry<String, String> moduleItem : modules.entrySet()) {
            String nature = moduleItem.getValue();
            String module = moduleItem.getKey();
            if (nature.equals(Constants.GENERAL_PROJECT_NATURE)) {
                moduleMap.get(1).add(module);
            } else if (nature.equals(Constants.CONNECTOR_PROJECT_NATURE)) {
                moduleMap.get(2).add(module);
            } else if (nature.equals(Constants.DATASOURCE_PROJECT_NATURE)) {
                moduleMap.get(3).add(module);
            } else if (nature.equals(Constants.DS_PROJECT_NATURE)) {
                moduleMap.get(4).add(module);
            } else if (nature.equals(Constants.MEDIATOR_PROJECT_NATURE)) {
                moduleMap.get(5).add(module);
            } else if (nature.equals(Constants.CARBON_UI_PROJECT_NATURE)) {
                moduleMap.get(6).add(module);
            } else if (nature.equals(Constants.ESB_PROJECT_NATURE)) {
                moduleMap.get(7).add(module);
            } else if (nature.equals(Constants.DISTRIBUTION_PROJECT_NATURE)) {
                moduleMap.get(8).add(module);
            } else if (!nature.equals(Constants.DOCKER_EXPORTER_PROJECT_NATURE)
                    && !nature.equals(Constants.KUBERNETES_EXPORTER_PROJECT_NATURE)) {
                moduleMap.get(0).add(module);
            }
        }

        List<String> sortedModules = new ArrayList<>();
        for (List<String> list : moduleMap) {
            sortedModules.addAll(list);
        }
        return sortedModules;
    }
    
    private static void createMavenProfiles(Map<String, String> modules, MavenProject mavenProject) {
        List<String> dockerModules = new ArrayList<>();
        List<String> kubernetesModules = new ArrayList<>();
        
        Profile dockerProfile = null;
        Profile kubernetesProfile = null;
        Profile defaultProfile = null;
        
        for (Map.Entry<String, String> moduleItem : modules.entrySet()) {
            String nature = moduleItem.getValue();
            String module = moduleItem.getKey();
            
            if (nature.equals(Constants.DOCKER_EXPORTER_PROJECT_NATURE)) {
                dockerModules.add(module);
            } else if (nature.equals(Constants.KUBERNETES_EXPORTER_PROJECT_NATURE)) {
                kubernetesModules.add(module);
            }
        }
        
        for (Profile profile : mavenProject.getModel().getProfiles()) {
            if (profile.getId().equals(Constants.DOCKER_PROFILE)) {
                dockerProfile = profile;
            } else if (profile.getId().equals(Constants.KUBERNETES_PROFILE)) {
                kubernetesProfile = profile;
            } else {
                defaultProfile = profile;
            }
        }
        
        dockerProfile.getModules().clear();
        kubernetesProfile.getModules().clear();
        defaultProfile.getModules().clear();

        for (String module : dockerModules) {
            if (!dockerProfile.getModules().contains(module)) {
                dockerProfile.getModules().add(module);
            }
            if (!defaultProfile.getModules().contains(module)) {
                defaultProfile.getModules().add(module);
            }
        }

        for (String module : kubernetesModules) {
            if (!kubernetesProfile.getModules().contains(module)) {
                kubernetesProfile.getModules().add(module);
                defaultProfile.getModules().add(module);
            }
            if (!defaultProfile.getModules().contains(module)) {
                defaultProfile.getModules().add(module);
            }
        }
    }
    
    private static Shell getShell() {
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (window == null) {
            IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
            if (windows.length > 0) {
                return windows[0].getShell();
            }
        } else {
            return window.getShell();
        }
        return null;
    }
    
    private static IWorkbenchWindow getWorkbenchWindow() {
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (window == null) {
            IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
            if (windows.length > 0) {
                return windows[0];
            }
        } else {
            return window;
        }
        return null;
    }
    
    /**
     * This method sets the perspective to ESB
     *
     * @param shell shell object that should be switched to ESB perspective
     */
    public static void setPerspective(Shell shell) {
        shell.getDisplay().syncExec(new Runnable() {
            @Override
            public void run() {
                IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                if ((!"org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.perspective"
                        .equals(window.getActivePage().getPerspective().getId())) && IMPORTED_DSS_PROJECT == null) {
                    try {
                        PlatformUI.getWorkbench().showPerspective(
                                "org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.perspective", window);
                    } catch (Exception e) {
                        log.error("Cannot switch to ESB Graphical Perspective", e);
                    }
                } else if ((!"org.wso2.developerstudio.eclipse.ds.presentation.custom.perspective"
                        .equals(window.getActivePage().getPerspective().getId())) && IMPORTED_DSS_PROJECT != null) {
                    try {
                        PlatformUI.getWorkbench().showPerspective(
                                "org.wso2.developerstudio.eclipse.ds.presentation.custom.perspective", window);
                    } catch (Exception e) {
                        log.error("Cannot switch to DSS Graphical Perspective", e);
                    }
                }
                ProjectPresentation.setHierarchicalProjectPresentation();
            }
        });
    }
}

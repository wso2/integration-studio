/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.dataserviceTemplate.wizard;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.model.Repository;
import org.apache.maven.model.RepositoryPolicy;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.templates.dashboard.help.TemplateGuideView;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Util class to for sample template creation.
 */
public class ProjectCreationUtil {

    private static String MAVEN_CAR_VERSION = "2.1.1";
    private static String MAVEN_CAR_DEPLOY_VERSION = "1.1.1";
    private static String version = "1.0.0";

    public static IProject createProject(String containerName, String natureID) throws CoreException {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject(containerName);
        if (project.exists()) {
            IStatus status = new Status(IStatus.ERROR, TemplateProjectConstants.PLUGIN_ID, IStatus.OK,
                    TemplateProjectConstants.THE_PROJECT_EXISTS_IN_THE_WORKSPACE_MESSAGE, null);
            throw new CoreException(status);
        } else {
            project.create(null);
            project.open(null);
        }

        IResource resource = root.findMember(new Path(containerName));
        if (!resource.exists() || !(resource instanceof IContainer)) {
            IStatus status = new Status(IStatus.ERROR, TemplateProjectConstants.PLUGIN_ID, IStatus.OK,
                    "Container \"" + containerName + "\" does not exist.", null);
            throw new CoreException(status);
        }
        return project;
    }

    public static void createProjectPOM(String groupID, File pomLocation, String projectName, String packaging)
            throws Exception {
        MavenProject mavenProjects = MavenUtils.createMavenProject(groupID, projectName, version, packaging);
        MavenUtils.updateMavenRepo(mavenProjects);
        MavenUtils.saveMavenProject(mavenProjects, pomLocation);
    }

    public static void createCarbonAppPOM(File pomLocation, String groupId, String containerName) throws Exception {

        String artifactID = containerName + "CarbonApplication";

        MavenProject mavenProject = MavenUtils.createMavenProject(groupId, artifactID, version, "carbon/application");

        Repository globalRepositoryFromPreference = getGlobalRepositoryFromPreference();
        mavenProject.getModel().addRepository(globalRepositoryFromPreference);
        mavenProject.getModel().addPluginRepository(globalRepositoryFromPreference);
        Plugin plugin = MavenUtils
                .createPluginEntry(mavenProject, "org.wso2.maven", "maven-car-plugin", MAVEN_CAR_VERSION, true);
        PluginExecution pluginExecution;
        pluginExecution = new PluginExecution();
        pluginExecution.addGoal("car");
        pluginExecution.setPhase("package");
        pluginExecution.setId("car");
        plugin.addExecution(pluginExecution);
        Plugin carDeployPlugin = MavenUtils
                .createPluginEntry(mavenProject, "org.wso2.maven", "maven-car-deploy-plugin", MAVEN_CAR_DEPLOY_VERSION,
                        true);
        Xpp3Dom carDeployConfElement = MavenUtils.createMainConfigurationNode(carDeployPlugin);
        Xpp3Dom serversElement = MavenUtils.createXpp3Node(carDeployConfElement, "carbonServers");
        Xpp3Dom carbonServer = MavenUtils.createXpp3Node(serversElement, "CarbonServer");
        Xpp3Dom trustStore = MavenUtils.createXpp3Node(carbonServer, "trustStorePath");
        trustStore.setValue("${basedir}/src/main/resources/security/wso2carbon.jks");
        Xpp3Dom trustStorePW = MavenUtils.createXpp3Node(carbonServer, "trustStorePassword");
        trustStorePW.setValue("wso2carbon");
        Xpp3Dom trustStoreType = MavenUtils.createXpp3Node(carbonServer, "trustStoreType");
        trustStoreType.setValue("JKS");
        Xpp3Dom serverUrl = MavenUtils.createXpp3Node(carbonServer, "serverUrl");
        serverUrl.setValue("https://localhost:9443");
        Xpp3Dom serverUserName = MavenUtils.createXpp3Node(carbonServer, "userName");
        serverUserName.setValue("admin");
        Xpp3Dom serverPW = MavenUtils.createXpp3Node(carbonServer, "password");
        serverPW.setValue("admin");
        Xpp3Dom serverOperation = MavenUtils.createXpp3Node(carbonServer, "operation");
        serverOperation.setValue("deploy");

        Repository repo = new Repository();
        repo.setUrl("http://dist.wso2.org/maven2");
        repo.setId("wso2-maven2-repository-1");

        Repository repo1 = new Repository();
        repo1.setUrl("http://maven.wso2.org/nexus/content/groups/wso2-public/");
        repo1.setId("wso2-nexus-repository-1");

        mavenProject.getModel().addRepository(repo);
        mavenProject.getModel().addPluginRepository(repo);

        mavenProject.getModel().addRepository(repo1);
        mavenProject.getModel().addPluginRepository(repo1);

        MavenUtils.saveMavenProject(mavenProject, pomLocation);
    }

    protected static Repository getGlobalRepositoryFromPreference() {

        String repoURL = "http://maven.wso2.org/nexus/content/groups/wso2-public/";
        String id = "wso2-nexus";
        Repository repo = new Repository();
        repo.setUrl(repoURL);
        repo.setId(id);

        RepositoryPolicy releasePolicy = new RepositoryPolicy();

        releasePolicy.setEnabled(true);
        releasePolicy.setUpdatePolicy("daily");
        releasePolicy.setChecksumPolicy("ignore");
        repo.setReleases(releasePolicy);
        return repo;
    }

    public static IProject carbonAppCreation(String projectName, String containerName, String groupId,
            String sampleName) {

        try {

            IProject CarbonAppProject = createNewProject(projectName);

            File pomfile = CarbonAppProject.getFile("pom.xml").getLocation().toFile();
            ProjectCreationUtil.createCarbonAppPOM(pomfile, groupId, containerName);
            ProjectUtils
                    .addNatureToProject(CarbonAppProject, false, TemplateProjectConstants.DISTRIBUTION_PROJECT_NATURE);

            MavenUtils.updateWithMavenEclipsePlugin(pomfile, new String[] {},
                    new String[] { TemplateProjectConstants.DISTRIBUTION_PROJECT_NATURE });
            CarbonAppProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            return CarbonAppProject;
        } catch (Exception e) {
            // TODO 
        }
        return null;

    }

    /**
     * Used to open the relevant artifact.
     *
     * @param shell    Eclipse shell reference
     * @param fileDesc IFile instance of the file to be opened
     * @param editorID ID of the editor which used to open this file
     */
    public static void openEditor(Shell shell, IFile fileDesc, String editorId, URL url) {
        final Shell shellV = shell;
        final IFile fileRef = fileDesc;
        final String editorID = editorId;
        final URL url1 = url;

        shellV.getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                try {
                    // Open Synapse Configuration and expand
                    IDE.openEditor(page, fileRef, editorID, true);
                    IViewPart view = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                            .findView(IPageLayout.ID_PROJECT_EXPLORER);
                    ((ISetSelectionTarget) view).selectReveal(new StructuredSelection(fileRef));
                    if (url1 != null) {
                        openHelp(shellV, url1);
                    }
                } catch (PartInitException e) {
                    MessageDialog
                            .openError(shellV, TemplateProjectConstants.ERROR_MESSAGE_OPENING_EDITOR, e.getMessage());
                }
            }
        });
    }

    /**
     * Used to open the help content of the relevant sample.
     *
     * @param shell   Eclipse shell reference
     * @param helpURL URL of the help html page
     */
    public static void openHelp(Shell shell, URL helpURL) {
        final Shell shellRef = shell;
        final URL helpUrl = helpURL;

        shellRef.getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                try {
                    TemplateGuideView templateGuideView = (TemplateGuideView) PlatformUI.getWorkbench()
                            .getActiveWorkbenchWindow().getActivePage()
                            .showView(TemplateProjectConstants.TEMPLATE_GUIDE_VIEW_ID);
                    templateGuideView.setURL(helpUrl);
                } catch (PartInitException e) {
                    MessageDialog
                            .openError(shellRef, TemplateProjectConstants.ERROR_MESSAGE_OPENING_EDITOR, e.getMessage());
                }
            }
        });
    }

    /**
     * Copy the ReadMe.html to the project.
     *
     * @param project
     * @param sampleName
     * @return
     * @throws IOException
     * @throws CoreException
     * @throws Exception
     */
    public static URL copyReadMe(IProject project, String sampleName) throws Exception {

        // copy html
        File importFile = null;
        try {
            importFile = ResourceTemplateUtils.getInstance()
                    .getResourceFile("Samples" + File.separator + sampleName + File.separator + "ReadMe.html");
        } catch (IOException e) {
            // If readme html is not present.
            return null;
        }

        IFile htmlFile = project.getFile(new Path("ReadMe.html"));
        File destFile = htmlFile.getLocation().toFile();
        FileUtils.copy(importFile, destFile);

        IFile fileDeschtml = project.getFile("ReadMe.html");
        File file = new File(fileDeschtml.getLocation().toString());
        URL url = file.toURI().toURL();
        project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

        return url;

    }

    /**
     * @param groupId
     * @param artifactName
     * @param type         - the name appended in carbon app dependency list. Inside <properties> tag
     *                     eg. values  endpoint , api , proxy-service , inbound-endpoint , sequence ,
     *                     message-store , message-processors , null for dataservice , task
     * @return
     */
    public static Dependency addDependencyForCAPP(String groupId, String artifactName, String type) {

        Dependency dependency = new Dependency();

        dependency.setArtifactId(artifactName);
        dependency.setVersion("1.0.0");

        if (type != null && !type.isEmpty()) {
            dependency.setGroupId(groupId + "." + type);
            dependency.setType("xml");
        } else {
            dependency.setGroupId(groupId);
            dependency.setType("synapse_dataservice");
        }
        if (artifactName.equals("salesforce-connector")) {
            dependency.setVersion("2.0.2");
            dependency.setType("zip");
        }
        return dependency;

    }

    public static String getArtifactInfoAsString(Dependency dep) {
        String suffix = "";

        String str = suffix.concat(dep.getGroupId().concat("_._").concat(dep.getArtifactId()));
        return str;
    }

    private static IProject createNewProject(String name) throws CoreException {

        IProject project = null;
        project = createProjectInDefaultWorkspace(name);
        return project;
    }

    private static IProject createProjectInDefaultWorkspace(String name) throws CoreException {

        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject(name);
        project.create(new NullProgressMonitor());
        project.open(new NullProgressMonitor());

        return project;
    }

}

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

package org.wso2.developerstudio.eclipse.esb.dashboard.templates.wizard;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.model.Repository;
import org.apache.maven.model.RepositoryPolicy;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.wso2.developerstudio.eclipse.esb.core.ESBMavenConstants;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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
        TemplateWizardUtil templateWizardUtil = new TemplateWizardUtil();
        if (project.exists()) {
            templateWizardUtil
                    .throwCoreException(TemplateProjectConstants.THE_PROJECT_EXISTS_IN_THE_WORKSPACE_MESSAGE, null);
        } else {
            project.create(null);
            project.open(null);
        }

        IResource resource = root.findMember(new Path(containerName));
        if (!resource.exists() || !(resource instanceof IContainer)) {
            templateWizardUtil.throwCoreException("Container \"" + containerName + "\" does not exist.", null);
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

    /**
     * Copies the relevant artifacts and add to artifact.xml file
     *
     * @param esbProject
     * @param groupId
     * @param sampleName
     * @param artifactName
     * @param esbProjectArtifact
     * @param type               - the containing folder name
     */
    public static void copyArtifact(IProject esbProject, String groupId, String sampleName, String artifactName,
            ESBProjectArtifact esbProjectArtifact, String type) {

        IContainer location = esbProject
                .getFolder("src" + File.separator + "main" + File.separator + "synapse-config" + File.separator + type);

        try {
            File importFile = getResourceFile(sampleName, artifactName, type);
            IFile proxyServiceFile = location.getFile(new Path(artifactName + ".xml"));
            File destFile = proxyServiceFile.getLocation().toFile();
            FileUtils.copy(importFile, destFile);

            String relativePath = FileUtils.getRelativePath(location.getProject().getLocation().toFile(),
                    new File(location.getLocation().toFile(), artifactName + ".xml"))
                    .replaceAll(Pattern.quote(File.separator), "/");

            String artifactType = type; // the name appended in artifact.xml file
            // api | proxy | endpoint | inbound-endpoint | sequence | message-store | message-processors ( same as folder name )
            //
            if (type.equals("proxy-services")) {
                artifactType = "proxy-service";
            } else if (type.equals("endpoints")) {
                artifactType = "endpoint";
            } else if (type.equals("inbound-endpoints")) {
                artifactType = "inbound-endpoint";
            } else if (type.equals("sequences")) {
                artifactType = "sequence";
            } else if (type.equals("message-stores")) {
                artifactType = "message-store";
            } else if (type.equals("tasks")) {
                artifactType = "task";
            }

            String grpID = groupId + "." + artifactType;

            esbProjectArtifact.addESBArtifact(createArtifact(artifactName, grpID, version, relativePath, artifactType));

            updatePomForArtifact(esbProject, artifactType);  //artifactIdForPomDependency);

        } catch (Exception e) {
            // TODO 
        }

    }

    /*WSO2_ESB_ENDPOINT_VERSION="2.1.0";
    WSO2_ESB_LOCAL_ENTRY_VERSION="2.1.0";
    WSO2_ESB_PROXY_VERSION="2.1.0";
    WSO2_ESB_SEQUENCE_VERSION="2.1.0";
    WSO2_ESB_SYNAPSE_VERSION="2.1.0";
    WSO2_ESB_API_VERSION="2.1.0";
    WSO2_ESB_TASK_VERSION="2.1.0";
    WSO2_ESB_TEMPLATE_VERSION="2.1.0";

    WSO2_ESB_INBOUND_ENDPOINT_VERSION="1.0.0";
    WSO2_ESB_CONNECTOR_VERSION="1.0.0";
    WSO2_GENERAL_PROJECT_VERSION="2.1.0";
    WSO2_ESB_MESSAGE_STORE_PLUGIN_VERSION="1.1.0";
    WSO2_ESB_MESSAGE_PROCESSOR_PLUGIN_VERSION="1.1.0";
   	 
   	<plugin>
        <groupId>org.wso2.maven</groupId>
        <artifactId>wso2-esb-proxy-plugin</artifactId>
        <version>2.1.0</version>
        <extensions>true</extensions>
        <executions>
          <execution>
            <id>proxy</id>
            <phase>process-resources</phase>
            <goals>
              <goal>pom-gen</goal>
            </goals>
            <configuration>
              <artifactLocation>.</artifactLocation>
              <typeList>${artifact.types}</typeList>
            </configuration>
          </execution>
        </executions>
        <configuration />
      </plugin>*/

    /**
     * @param project
     * @param type    - the name appended in artifact.xml file
     * @throws IOException
     * @throws XmlPullParserException
     */
    public static void updatePomForArtifact(IProject project, String type) throws IOException, XmlPullParserException {

        String artifactIdForPomDependency = type; // ID in project pom's plugin.
        String pluginVersion = "2.1.0";

        if (type.equals("proxy-service")) {
            artifactIdForPomDependency = "proxy";
        } else if (type.equals("inbound-endpoint")) {
            artifactIdForPomDependency = "inboundendpoint";
        } else if (type.equals("message-store") || type.equals("message-processors")) {
            artifactIdForPomDependency = "task";
            pluginVersion = "1.1.0";
        }

        if (type.equals("inboundendpoint")) {
            pluginVersion = "1.0.0";
        }

        String pluginName = "wso2-esb-" + artifactIdForPomDependency + "-plugin"; // corresponding plugin name in POM.

        if (type.equals("message-store")) {
            pluginName = "wso2-esb-messagestore-plugin";
        } else if (type.equals("message-processors")) {
            pluginName = "wso2-esb-messageprocessor-plugin";
        }

        File mavenProjectPomLocation = project.getFile("pom.xml").getLocation().toFile();
        MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);

        // Skip changing the pom file if group ID and artifact ID are matched
        if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", pluginName)) {
            return;
        }

        Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", pluginName, pluginVersion, true);
        PluginExecution pluginExecution = new PluginExecution();
        pluginExecution.addGoal("pom-gen");
        pluginExecution.setPhase("process-resources");
        pluginExecution.setId(artifactIdForPomDependency);

        Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
        Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
        artifactLocationNode.setValue(".");
        Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
        typeListNode.setValue("${artifact.types}");
        pluginExecution.setConfiguration(configurationNode);
        plugin.addExecution(pluginExecution);
        MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
    }

    protected static File getResourceFile(String samplename, String name, String type) throws IOException {

        String fileLocation = "Samples" + File.separator + samplename + File.separator + "src" + File.separator + "main"
                + File.separator + "synapse-config" + File.separator + type + File.separator + name + ".xml";

        return ResourceUtils.getInstance().getResourceFile(fileLocation);
    }

    private static ESBArtifact createArtifact(String name, String groupId, String version, String path, String type) {
        ESBArtifact artifact = new ESBArtifact();
        artifact.setName(name);
        artifact.setVersion(version);
        artifact.setType("synapse/" + type);
        artifact.setServerRole("EnterpriseServiceBus");
        artifact.setGroupId(groupId);
        artifact.setFile(path);
        return artifact;
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
     * Used to open the carbon app pom file with dist project nature.
     *
     * @param shell    Eclipse shell reference
     * @param fileDesc IFile instance of the file to be opened
     * @param editorID ID of the editor which used to open this file
     */
    public static void openEditor(Shell shell, IFile fileDesc, String editorId,  URL url) {
        final Shell shellV = shell;
        final IFile fileRef = fileDesc;
        final String editorID = editorId;
        final URL url1 = url;

        shellV.getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                try {
                    final IWebBrowser browser = PlatformUI.getWorkbench().getBrowserSupport().createBrowser( "Template" );
                    browser.openURL( url1 );
                    
                    IDE.openEditor(page, fileRef, editorID, true);
                    IViewPart view = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                            .findView(IPageLayout.ID_PROJECT_EXPLORER);
                    ((ISetSelectionTarget) view).selectReveal(new StructuredSelection(fileRef));
                   
                } catch (PartInitException e) {
                    MessageDialog
                            .openError(shellV, TemplateProjectConstants.ERROR_MESSAGE_OPENING_EDITOR, e.getMessage());
                }
            }
        });
    }
    
    
    public static URL  copyReadMe(IProject project , String sampleName) throws Exception {
	
	// copy html
        File importFile = ResourceUtils.getInstance().getResourceFile("Samples" + File.separator + sampleName + File.separator 
    	    + "ReadMe.html");
        
        IFile htmlFile = project.getFile(new Path( sampleName  + "_.html"));
        File destFile = htmlFile.getLocation().toFile();
        FileUtils.copy(importFile, destFile);
        
        
        // open html.
        IFile fileDeschtml = project.getFile(sampleName  + "_.html");
        File file = new File ( fileDeschtml.getLocation().toString());
        URL url = file.toURI().toURL();
        
	return url;
	
    }

    /**
     * Used to open the help content of the relevant sample.
     *
     * @param shell  Eclipse shell reference
     * @param helpId ID of the help which used to open this file
     */
    public static void openHelp(Shell shell, String helpId) {
        final Shell shellV = shell;
        final String helpID = helpId;
        shellV.getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                PlatformUI.getWorkbench().getHelpSystem().displayHelpResource(helpID);
            }
        });
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

            if (type.equals("resource")) {
                dependency.setType("zip");
            }

        } else {
            dependency.setGroupId(groupId);
            dependency.setType("synapse_dataservice");
        }

        if (artifactName.equals("salesforce-connector")) {
            dependency.setVersion("2.0.2");
            dependency.setType("zip");
        } else if (artifactName.equals("kafkaTransport-connector")) {
            dependency.setVersion("2.0.5");
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

    public static IProject createConnectorExporterProject(String groupID, String name) throws Exception {

        String connectorProjectName = name + "ConnectorExporter";

        IProject connectorProject = createNewProject(connectorProjectName);
        File pomfile = connectorProject.getFile("pom.xml").getLocation().toFile();
        createProjectPOM(groupID, pomfile, connectorProjectName, "pom");
        updateConnectorExporterProjectPom(connectorProject);

        ProjectUtils.addNatureToProject(connectorProject, false, TemplateProjectConstants.CONNECTOR_PROJECT_NATURE);
        MavenUtils.updateWithMavenEclipsePlugin(pomfile, new String[] {},
                new String[] { TemplateProjectConstants.CONNECTOR_PROJECT_NATURE });

        return connectorProject;

    }

    /**
     * Copy the relevant connector and artifact xml for the connector project.
     *
     * @param conenctorProject
     * @param connectorName
     * @throws Exception
     */
    public static void addConnectorToProject(IProject conenctorProject, String connectorName, String connectorVersion,
            String groupID) throws Exception {

        String connectorZIPName = connectorName + "-" + connectorVersion + ".zip";

        // copy the connector to the connector project
        File connectorFile = ResourceUtils.getInstance()
                .getResourceFile("Samples" + File.separator + "Connectors" + File.separator + connectorZIPName);
        File destFile = new File(conenctorProject.getLocation().toString() + File.separator + connectorZIPName);
        FileUtils.copy(connectorFile, destFile);

        // add the  connector to the artifact
        ESBProjectArtifact artifact = new ESBProjectArtifact();
        artifact.fromFile(conenctorProject.getFile("artifact.xml").getLocation().toFile());

        ESBArtifact connectorArtifact = new ESBArtifact();
        connectorArtifact.setName(connectorName);
        connectorArtifact.setVersion(connectorVersion);
        connectorArtifact.setType("synapse/lib");
        connectorArtifact.setServerRole("EnterpriseServiceBus");
        connectorArtifact.setGroupId(groupID + ".lib");
        connectorArtifact.setFile(connectorZIPName);

        artifact.addESBArtifact(connectorArtifact);
        artifact.toFile();

    }

    public static void updateConnectorExporterProjectPom(IProject project) throws IOException, XmlPullParserException {
        File mavenProjectPomLocation = project.getFile("pom.xml").getLocation().toFile();
        MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
        mavenProject.getModel().getProperties().put("CApp.type", "synapse/lib");

        // Skip changing the pom file if group ID and artifact ID are matched
        if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-connector-plugin")) {
            return;
        }

        Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-connector-plugin",
                ESBMavenConstants.WSO2_ESB_CONNECTOR_VERSION, true);
        PluginExecution pluginExecution = new PluginExecution();
        pluginExecution.addGoal("pom-gen");
        pluginExecution.setPhase("process-resources");
        pluginExecution.setId("connector");

        Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
        Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
        artifactLocationNode.setValue(".");
        Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
        typeListNode.setValue("${artifact.types}");
        pluginExecution.setConfiguration(configurationNode);
        plugin.addExecution(pluginExecution);
        MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
    }

    /**
     * Copy the connector to the workspace to get the connector in the design view.
     *
     * @param connectorName
     * @throws IOException
     */
    public static void addConnectorToWorkSpace(String connectorName) throws IOException {

        String workSpaceLocation = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();

        File conenctorLocation = new File(
                workSpaceLocation + File.separator + ".metadata" + File.separator + ".Connectors");

        String connectorZIPName = connectorName + ".zip";

        if (!new File(conenctorLocation + File.separator + connectorZIPName).exists()) {
            File connectorFile = ResourceUtils.getInstance()
                    .getResourceFile("Samples" + File.separator + "Connectors" + File.separator + connectorZIPName);
            File destFile = new File(conenctorLocation + File.separator + connectorZIPName);
            FileUtils.copy(connectorFile, destFile);
            unzip(destFile.toString(), conenctorLocation.toString() + File.separator + connectorName);
        }
    }

    /**
     * Extracts a zip file specified by the zipFilePath to a directory specified by
     * destDirectory (will be created if does not exists)
     *
     * @param zipFilePath
     * @param destDirectory
     * @throws IOException
     */
    public static void unzip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipIn.getNextEntry();
        // iterates over entries in the zip file
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                // if the entry is a file, extracts it
                extractFile(zipIn, filePath);
            } else {
                // if the entry is a directory, make the directory
                File dir = new File(filePath);
                dir.mkdir();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
    }

    /**
     * Extracts a zip entry (file entry)
     *
     * @param zipIn
     * @param filePath
     * @throws IOException
     */
    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        int BUFFER_SIZE = 4096;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
}

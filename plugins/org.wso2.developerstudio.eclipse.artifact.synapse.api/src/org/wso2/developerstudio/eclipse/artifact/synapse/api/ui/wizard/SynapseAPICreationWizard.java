/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.synapse.api.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.json.simple.JSONValue;
import org.wso2.carbon.rest.api.APIException;
import org.wso2.carbon.rest.api.service.RestApiAdmin;
import org.wso2.developerstudio.eclipse.artifact.synapse.api.Activator;
import org.wso2.developerstudio.eclipse.artifact.synapse.api.exceptions.SwaggerDefinitionProcessingException;
import org.wso2.developerstudio.eclipse.artifact.synapse.api.model.APIArtifactModel;
import org.wso2.developerstudio.eclipse.artifact.synapse.api.util.APIImageUtils;
import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants;
import org.wso2.developerstudio.eclipse.esb.core.ESBMavenConstants;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.RegistryArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryCollection;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryDump;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryElement;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryItem;
import org.wso2.developerstudio.eclipse.gmf.esb.APIVersionType;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.developerstudio.eclipse.platform.ui.startup.ESBGraphicalEditor;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.registry.core.utils.RegistryResourceInfo;
import org.wso2.developerstudio.eclipse.registry.core.utils.RegistryResourceInfoDoc;
import org.wso2.developerstudio.eclipse.registry.core.utils.RegistryResourceUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;
import org.yaml.snakeyaml.Yaml;

/**
 * WSO2 ESB API creation wizard class
 */
public class SynapseAPICreationWizard extends AbstractWSO2ProjectCreationWizard {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Synapse API";
    private final APIArtifactModel artifactModel;
    private IFile artifactFile;
    private ESBProjectArtifact esbProjectArtifact;
    private IProject esbProject;
    private List<File> fileLst = new ArrayList<File>();
    private static final int REGISTRY_RESOURCE = 0;
    private static final int REGISTRY_COLLECTION = 1;
    private static final int REGISTRY_DUMP = 2;
    private static final String REGISTRY_RESOURCE_PATH = "/_system/governance/swagger_files";
    private static final String EMPTY_STRING = "";

    private String version;

    public SynapseAPICreationWizard() {
        artifactModel = new APIArtifactModel();
        setModel(artifactModel);
        setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
        setDefaultPageImageDescriptor(APIImageUtils.getInstance().getImageDescriptor("synapseAPILarge.png"));
    }

    @Override
    public IResource getCreatedResource() {
        return artifactFile;
    }

    @Override
    public boolean canFinish() {
        // If it is options page, cannot finish.
        if (getContainer().getCurrentPage().getTitle().equals("API Artifact Creation Options")) {
            return false;
        }
        if (getModel().getSelectedOption().equals("create.api")
                && (artifactModel.getName().equals(EMPTY_STRING) || artifactModel.getContext().equals(EMPTY_STRING))) {
            // If option to create a new API is selected,
            // can finish only if both context and name is given.
            return false;
        } else if (getModel().getSelectedOption().equals("import.api")
                && getModel().getImportFile().getName().equals(EMPTY_STRING)) {
            // If option to import artifact is selected,
            // can finish only if artifact file is selected.
            return false;
        } else if (getModel().getSelectedOption().equals("create.swagger")
                && artifactModel.getSwaggerFile().getPath().equals(EMPTY_STRING)) {
            // If option to generate API from swagger definition is selected,
            // can finish only if swagger definition is selected.
            return false;
        }
        return true;
    }

    @Override
    public boolean performFinish() {
        try {
            boolean isNewArtifact = true;
            esbProject = artifactModel.getSaveLocation().getProject();
            IContainer location = esbProject.getFolder("src/main/synapse-config/api");
            File pomfile = esbProject.getFile("pom.xml").getLocation().toFile();
            if (!pomfile.exists()) {
                createPOM(pomfile);
            }
            esbProjectArtifact = new ESBProjectArtifact();
            esbProjectArtifact.fromFile(esbProject.getFile("artifact.xml").getLocation().toFile());
            updatePom();
            esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            String groupId = getMavenGroupId(pomfile) + ".api";
            if (getModel().getSelectedOption().equals("import.api")) {
                IFile api = location.getFile(new Path(getModel().getImportFile().getName()));
                if (api.exists()) {
                    if (!MessageDialog.openQuestion(getShell(), "WARNING",
                            "Do you like to override exsiting project in the workspace")) {
                        return false;
                    }
                    isNewArtifact = false;
                }
                copyImportFile(location, isNewArtifact, groupId);
            } else if (getModel().getSelectedOption().equals("create.swagger")) {
                String apiName = getAPINameFromSwagger(artifactModel.getSwaggerFile()).replaceAll(" ", "_");
                artifactModel.setName(apiName);
                artifactFile = location.getFile(new Path(apiName + ".xml"));
                File destFile = artifactFile.getLocation().toFile();
                FileUtils.createFile(destFile, getSynapseAPIFromSwagger(artifactModel.getSwaggerFile()));
                fileLst.add(destFile);
                String relativePath = FileUtils
                        .getRelativePath(esbProject.getLocation().toFile(),
                                new File(location.getLocation().toFile(), apiName + ".xml"))
                        .replaceAll(Pattern.quote(File.separator), "/");
                esbProjectArtifact.addESBArtifact(createArtifact(apiName, groupId, version, relativePath));
                esbProjectArtifact.toFile();
                // Copy swagger file to the registry
                createRegistryResource(artifactModel.getSwaggerRegistryLocation(), artifactModel.getSwaggerFile(),
                        REGISTRY_RESOURCE_PATH);
            } else {
                artifactFile = location.getFile(new Path(artifactModel.getName() + ".xml"));
                File destFile = artifactFile.getLocation().toFile();
                FileUtils.createFile(destFile, getTemplateContent());
                fileLst.add(destFile);
                String relativePath = FileUtils
                        .getRelativePath(esbProject.getLocation().toFile(),
                                new File(location.getLocation().toFile(), artifactModel.getName() + ".xml"))
                        .replaceAll(Pattern.quote(File.separator), "/");
                esbProjectArtifact
                        .addESBArtifact(createArtifact(artifactModel.getName(), groupId, version, relativePath));
                esbProjectArtifact.toFile();
            }
            esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            for (File file : fileLst) {
                if (file.exists()) {
                    openEditor(file);
                }
            }
        } catch (SwaggerDefinitionProcessingException e) {
            MessageDialog.openError(getShell(), "Error while creating the API", e.getMessage());
        } catch (CoreException e) {
            log.error("CoreException has occurred", e);
        } catch (Exception e) {
            log.error("An unexpected error has occurred", e);
        }
        return true;
    }

    protected boolean isRequireProjectLocationSection() {
        return false;
    }

    protected boolean isRequiredWorkingSet() {
        return false;
    }

    private String getTemplateContent() {
        StringBuilder content = new StringBuilder();
        /*
         * FIXME: use template extension-point instead of hard-coding template
         * content
         */
        content.append("<api xmlns=\"http://ws.apache.org/ns/synapse\" context=\"");
        if (artifactModel.getContext().startsWith("/")) {
            content.append(artifactModel.getContext());
        } else {
            content.append("/").append(artifactModel.getContext());
        }
        content.append("\" name=\"").append(artifactModel.getName()).append("\"");
        if (!artifactModel.getPublishSwagger().equals("")) {
            content.append(" publishSwagger=\"").append(artifactModel.getPublishSwagger()).append("\"");
        }
        if (artifactModel.getHostname() != null && artifactModel.getHostname().length() > 0) {
            content.append(" hostname=\"").append(artifactModel.getHostname()).append("\"");
        }
        if (artifactModel.getPort() > 0) {
            content.append(" port=\"").append(artifactModel.getPort()).append("\"");
        }
        if (!artifactModel.getVersionType().equalsIgnoreCase(APIVersionType.NONE.getLiteral())) {
            content.append(" version-type=\"").append(artifactModel.getVersionType()).append("\" version=\"")
                    .append(artifactModel.getVersion()).append("\"");
        }
        content.append(
                ">\n<resource methods=\"GET\"><inSequence/><outSequence/><faultSequence/>" + "</resource>\n</api>");
        return content.toString();
    }

    private String getSynapseAPIFromSwagger(File swaggerFile) throws SwaggerDefinitionProcessingException {
        RestApiAdmin restAPIAdmin = new RestApiAdmin();
        String swaggerJson = getSwaggerFileAsJSON(swaggerFile);

        String generatedAPI = "";
        try {
            generatedAPI = restAPIAdmin.generateAPIFromSwagger(swaggerJson);
            // Inject the publish swagger property to the synapse api artifact
            OMFactory fac = OMAbstractFactory.getOMFactory();
            OMElement element = AXIOMUtil.stringToOM(generatedAPI);
            element.addAttribute(fac.createOMAttribute("publishSwagger",
                    fac.createOMNamespace(XMLConfigConstants.NULL_NAMESPACE, ""),
                    REGISTRY_RESOURCE_PATH + "/" + artifactModel.getSwaggerFile().getName().replaceAll(" ", "_")));
            generatedAPI = element.toString();
        } catch (APIException | XMLStreamException e) {
            log.error("Exception occured while generating API using swagger file", e);
            throw new SwaggerDefinitionProcessingException("Failed to generate API from the definition.", e);
        }
        return generatedAPI;
    }

    private String getAPINameFromSwagger(File swaggerFile) throws SwaggerDefinitionProcessingException {
        String apiName = "";
        try {
            String swaggerJson = getSwaggerFileAsJSON(swaggerFile);
            JSONObject fullSwaggerJSON = new JSONObject(swaggerJson);
            JSONObject swaggerInfo = (JSONObject) fullSwaggerJSON.get("info");
            apiName = swaggerInfo.get("title").toString();
        } catch (Exception e) {
            log.error("Exception occured while extracting API name from the swagger file", e);
            throw new SwaggerDefinitionProcessingException("Invalid swagger definition.", e);
        }
        return apiName;
    }

    public void copyImportFile(IContainer importLocation, boolean isNewAritfact, String groupId) throws IOException {
        File importFile = getModel().getImportFile();
        File destFile = null;
        List<OMElement> selectedAPIsList = ((APIArtifactModel) getModel()).getSelectedAPIsList();
        if (selectedAPIsList != null && selectedAPIsList.size() > 0) {
            for (OMElement element : selectedAPIsList) {
                String name = element.getAttributeValue(new QName("name"));
                destFile = new File(importLocation.getLocation().toFile(), name + ".xml");
                FileUtils.createFile(destFile, element.toString());
                fileLst.add(destFile);
                if (isNewAritfact) {
                    String relativePath = FileUtils
                            .getRelativePath(importLocation.getProject().getLocation().toFile(),
                                    new File(importLocation.getLocation().toFile(), name + ".xml"))
                            .replaceAll(Pattern.quote(File.separator), "/");
                    esbProjectArtifact.addESBArtifact(createArtifact(name, groupId, version, relativePath));
                }
            }

        } else {
            destFile = new File(importLocation.getLocation().toFile(), importFile.getName());
            FileUtils.copy(importFile, destFile);
            fileLst.add(destFile);
            String name = importFile.getName().replaceAll(".xml$", "");
            if (isNewAritfact) {
                String relativePath = FileUtils
                        .getRelativePath(importLocation.getProject().getLocation().toFile(),
                                new File(importLocation.getLocation().toFile(), name + ".xml"))
                        .replaceAll(Pattern.quote(File.separator), "/");
                esbProjectArtifact.addESBArtifact(createArtifact(name, groupId, version, relativePath));
            }
        }
        try {
            esbProjectArtifact.toFile();
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private ESBArtifact createArtifact(String name, String groupId, String version, String path) {
        ESBArtifact artifact = new ESBArtifact();
        artifact.setName(name);
        artifact.setVersion(version);
        artifact.setType("synapse/api");
        artifact.setServerRole("EnterpriseServiceBus");
        artifact.setGroupId(groupId);
        artifact.setFile(path);
        return artifact;
    }

    /**
     * Converts a given YAML content to JSON.
     * 
     * @param yamlSource yaml content
     * @return converted JSON content
     */
    public static String convertYamlToJson(String yamlSource) {
        Yaml yaml = new Yaml();
        Object object = yaml.load(yamlSource);
        return JSONValue.toJSONString(object);
    }

    private String getSwaggerFileAsJSON(File swaggerFile) {
        String swaggerJson = "";
        String fileContent = "";
        try {
            fileContent = new String(Files.readAllBytes(Paths.get(swaggerFile.getAbsolutePath())));
            if (FilenameUtils.getExtension((swaggerFile).getAbsolutePath()).equals("yaml")) {
                // Convert to JSON if the file extension is yaml
                swaggerJson = convertYamlToJson(fileContent);
            } else if (FilenameUtils.getExtension(swaggerFile.getAbsolutePath()).equals("json")) {
                swaggerJson = fileContent;
            }
        } catch (IOException e) {
            log.error("Exception occured while reading swagger file", e);
        }
        return swaggerJson;
    }

    public void updatePom() throws IOException, XmlPullParserException {
        File mavenProjectPomLocation = esbProject.getFile("pom.xml").getLocation().toFile();
        MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
        version = mavenProject.getVersion();

        // Skip changing the pom file if group ID and artifact ID are matched
        if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-api-plugin")) {
            return;
        }

        Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-api-plugin",
                ESBMavenConstants.WSO2_ESB_API_VERSION, true);
        PluginExecution pluginExecution = new PluginExecution();
        pluginExecution.addGoal("pom-gen");
        pluginExecution.setPhase("process-resources");
        pluginExecution.setId("api");

        Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
        Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
        artifactLocationNode.setValue(".");
        Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
        typeListNode.setValue("${artifact.types}");
        pluginExecution.setConfiguration(configurationNode);
        plugin.addExecution(pluginExecution);
        MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
    }

    /*
     * This method will create a resource inside the given registry project
     * 
     * @param regProject the registry project
     * 
     * @param importFile the file that needs to add to the registry project
     * 
     * @param registryPath the path to the resource inside the registry project
     * 
     * @return the status of the operation
     */
    public boolean createRegistryResource(IContainer regProject, File importFile, String registryPath) {
        try {
            IProject project = regProject.getProject();
            RegistryResourceInfoDoc regResInfoDoc = new RegistryResourceInfoDoc();
            String resourceFileName = importFile.getName().replaceAll(" ", "_");
            IFile resourceFile = regProject.getFile(new Path(resourceFileName));
            File destFile = resourceFile.getLocation().toFile();
            FileUtils.copy(importFile, destFile);
            RegistryResourceUtils.createMetaDataForFolder(registryPath, destFile.getParentFile());
            RegistryResourceUtils.addRegistryResourceInfo(destFile, regResInfoDoc, regProject.getLocation().toFile(),
                    registryPath);

            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            getModel().getMavenInfo().setPackageName("registry/resource");
            updatePOM(project);
            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            File pomLocation = project.getFile("pom.xml").getLocation().toFile();
            String groupId = getMavenGroupId(pomLocation);
            groupId += ".resource";
            MavenProject mavenProject = MavenUtils.getMavenProject(pomLocation);
            String version = mavenProject.getVersion();
            // Adding the metadata about the endpoint to the metadata store.
            GeneralProjectArtifact generalProjectArtifact = new GeneralProjectArtifact();
            generalProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());

            RegistryArtifact artifact = new RegistryArtifact();
            artifact.setName(ProjectUtils.fileNameWithExtension(resourceFileName));
            artifact.setVersion(version);
            artifact.setType("registry/resource");
            artifact.setServerRole("EnterpriseIntegrator");
            artifact.setGroupId(groupId);

            List<RegistryResourceInfo> registryResources = regResInfoDoc.getRegistryResources();
            for (RegistryResourceInfo registryResourceInfo : registryResources) {
                RegistryElement item = null;
                if (registryResourceInfo.getType() == REGISTRY_RESOURCE) {
                    item = new RegistryItem();

                    ((RegistryItem) item).setFile(registryResourceInfo.getResourceBaseRelativePath()
                            .replaceAll(Pattern.quote(File.separator), "/"));
                    ((RegistryItem) item).setMediaType(registryResourceInfo.getMediaType());
                } else if (registryResourceInfo.getType() == REGISTRY_COLLECTION) {
                    item = new RegistryCollection();
                    ((RegistryCollection) item).setDirectory(registryResourceInfo.getResourceBaseRelativePath()
                            .replaceAll(Pattern.quote(File.separator), "/"));
                } else if (registryResourceInfo.getType() == REGISTRY_DUMP) {
                    item = new RegistryDump();
                    ((RegistryDump) item).setFile(registryResourceInfo.getResourceBaseRelativePath()
                            .replaceAll(Pattern.quote(File.separator), "/"));
                }
                if (item != null) {
                    item.setPath(registryResourceInfo.getDeployPath().replaceAll("/$", ""));
                    artifact.addRegistryElement(item);
                }
            }
            generalProjectArtifact.addArtifact(artifact);
            generalProjectArtifact.toFile();
            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            return true;

        } catch (IOException e) {
            log.error("Error occured while creating registry resource", e);
        } catch (CoreException e) {
            log.error("Error occured while creating registry resource", e);
        } catch (XmlPullParserException e) {
            log.error("Error occured while creating registry resource", e);
        } catch (FactoryConfigurationError e) {
            log.error("Error occured while creating registry resource", e);
        } catch (Exception e) {
            log.error("Error occured while creating registry resource", e);
        }

        return false;
    }

    private void updatePOM(IProject project) throws IOException, XmlPullParserException {
        MavenProject mavenProject;
        File mavenProjectPomLocation = project.getFile("pom.xml").getLocation().toFile();
        if (!mavenProjectPomLocation.exists()) {
            mavenProject = MavenUtils.createMavenProject("org.wso2.carbon." + project.getName(), project.getName(),
                    "1.0.0", "pom");
        } else {
            mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
        }

        // Skip changing the pom file if group ID and artifact ID are matched
        if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", "wso2-general-project-plugin")) {
            return;
        }

        Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-general-project-plugin",
                MavenConstants.WSO2_GENERAL_PROJECT_VERSION, true);
        PluginExecution pluginExecution;
        pluginExecution = new PluginExecution();
        pluginExecution.addGoal("pom-gen");
        pluginExecution.setPhase("process-resources");
        pluginExecution.setId("registry");
        plugin.addExecution(pluginExecution);

        Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
        Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
        artifactLocationNode.setValue(".");
        Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
        typeListNode.setValue("${artifact.types}");
        pluginExecution.setConfiguration(configurationNode);
        MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
    }

    @Override
    public void openEditor(File file) {
        try {
            refreshDistProjects();
            IFile dbsFile = ResourcesPlugin.getWorkspace().getRoot()
                    .getFileForLocation(Path.fromOSString(file.getAbsolutePath()));
            /* IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),dbsFile); */
            String path = dbsFile.getParent().getFullPath() + "/";
            String source = FileUtils.getContentAsString(file);
            Openable openable = ESBGraphicalEditor.getOpenable();
            openable.editorOpen(file.getName(), ArtifactType.API.getLiteral(), path, source);
        } catch (Exception e) {
            log.error("Cannot open the editor", e);
        }
    }

}

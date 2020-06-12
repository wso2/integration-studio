/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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
package org.wso2.developerstudio.eclipse.apim.endpoint.central.handler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.io.IOUtils;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.apache.synapse.config.xml.rest.APIFactory;
import org.apache.synapse.rest.API;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.wso2.carbon.rest.api.APIException;
import org.wso2.carbon.rest.api.service.RestApiAdmin;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.Activator;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.client.APIMCTLClient;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.client.APIMServiceClient;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.exceptions.APIMCTLException;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.exceptions.EndpointRegistryConnectException;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.exceptions.HttpClientException;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.exceptions.InvalidTokenException;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.model.APIArtifact;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.model.APIImportPayload;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.model.LoginPayload;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.model.ProjectData;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.model.RegistryEntry;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.model.UserSession;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.resources.EndpointCentralConstants;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.resources.EndpointCentralServletConstants;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.utils.JsonUtils;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.utils.UserSessionManager;
import org.wso2.developerstudio.eclipse.distribution.project.model.DependencyData;
import org.wso2.developerstudio.eclipse.distribution.project.validator.ProjectList;
import org.wso2.developerstudio.eclipse.esb.core.ESBMavenConstants;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider.ListData;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

/**
 * This class handle requests from endpoint central wizard.
 */
public class EndpointCentralServletRequestHandler {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /**
     * Handle login requests.
     * 
     * @param request servlet request
     * @param response servlet response
     */
    public static void login(HttpServletRequest request, HttpServletResponse response) {
        try {
            String payload = IOUtils.toString(request.getReader());
            LoginPayload loginPayload = JsonUtils.getLoginPayloadFromJson(payload);
            String username = loginPayload.getUsername();
            String password = loginPayload.getPassword();
            String hostUrl = loginPayload.getHost();
            String epVersion = loginPayload.getEndpointRegistryVersion();
            String crVersion = loginPayload.getClientRegistrationVersion();

            // Payload validation
            if (username.isEmpty() || password.isEmpty() || hostUrl.isEmpty() || epVersion.isEmpty()
                    || crVersion.isEmpty()) {
                throw new EndpointRegistryConnectException(
                        EndpointCentralServletConstants.ResponseMessages.LOGIN_DETAILS_MISSING);
            }

            APIMServiceClient.getInstance().register(username, password, hostUrl, epVersion, crVersion);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException | HttpClientException | URISyntaxException | EndpointRegistryConnectException
                | InvalidTokenException e) {
            setErrorMessage(e.getMessage(), response);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    /**
     * Handle check login status requests.
     * 
     * @param request servlet request
     * @param response servlet response
     */
    public static void checkLogin(HttpServletRequest request, HttpServletResponse response) {
        try {
            // If there is no valid session, this will throw an exception.
            UserSessionManager.getCurrentSession();
            Map<String, Object> data = new HashMap<>();
            data.put(EndpointCentralServletConstants.ResponseMessages.LOGGED,
                    EndpointCentralServletConstants.ResponseMessages.TRUE_STRING);
            setPayload(JsonUtils.getJsonFromMap(data), response);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (HttpClientException | URISyntaxException | EndpointRegistryConnectException
                | InvalidTokenException e) {
            setErrorMessage(EndpointCentralServletConstants.ResponseMessages.NOT_LOGGED, response);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    /**
     * Handle get profile data (user name, registry name....) requests.
     * 
     * @param request servlet request
     * @param response servlet response
     */
    public static void getProfileData(HttpServletRequest request, HttpServletResponse response) {
        try {
            UserSession userSession = UserSessionManager.getCurrentSession();
            String payload = JsonUtils.getJsonFromUserSession(userSession);
            setPayload(payload, response);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (HttpClientException | URISyntaxException | EndpointRegistryConnectException
                | InvalidTokenException e) {
            setErrorMessage(EndpointCentralServletConstants.ResponseMessages.NOT_LOGGED, response);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    /**
     * Retrieve and forward registry entries of a given registry.
     * 
     * @param request servlet request
     * @param response servlet response
     */
    public static void getRegistryEntries(HttpServletRequest request, HttpServletResponse response) {
        try {
            UserSession userSession = UserSessionManager.getCurrentSession();
            List<RegistryEntry> entries = APIMServiceClient.getInstance().getRegistryEntries(
                    userSession.getAccessToken(), userSession.getEndpointRegistryUrl(), userSession.getRegistryId());
            String payload = JsonUtils.getJsonArrayFromRegistryEntry(entries);
            setPayload(payload, response);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (InvalidTokenException | HttpClientException | URISyntaxException
                | EndpointRegistryConnectException e) {
            setErrorMessage(e.getMessage(), response);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    /**
     * Handle create registry entry (Export API) requests.
     * 
     * @param request servlet request
     * @param response servlet response
     */
    public static void createRegistryEntry(HttpServletRequest request, HttpServletResponse response) {
        try {
            UserSession userSession = UserSessionManager.getCurrentSession();
            String payload = IOUtils.toString(request.getReader());
            APIArtifact apiArtifact = JsonUtils.getAPIArtifactFromJson(payload);

            // Creating registry entry
            RegistryEntry registryEntry = new RegistryEntry();
            registryEntry.setEntryName(apiArtifact.getName());
            registryEntry.setServiceUrl(EndpointCentralConstants.DEFUALT_SERVICE_URL);
            registryEntry.setServiceType(EndpointCentralConstants.DEFAULT_SERVICE_TYPE);
            registryEntry.setDefinitionType(EndpointCentralConstants.DEFAULT_DEFINITION_TYPE);
            registryEntry.setServiceCategory(EndpointCentralConstants.DEFAULT_SERVICE_CATEGORY);
            registryEntry.setMetadata(EndpointCentralConstants.DEFAULT_METADATA);

            // Getting API definition
            String definitionFile = getSwaggerDefinitionFromAPIArtifact(apiArtifact);

            RegistryEntry returnedRegistryEntry = APIMServiceClient.getInstance().createRegistryEntry(
                    userSession.getAccessToken(), userSession.getEndpointRegistryUrl(), userSession.getRegistryId(),
                    registryEntry, definitionFile);
            setPayload(JsonUtils.getJsonFromRegistryEntry(returnedRegistryEntry), response);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (InvalidTokenException | HttpClientException | URISyntaxException | EndpointRegistryConnectException
                | IOException | CoreException | XMLStreamException | APIException e) {
            setErrorMessage(e.getMessage(), response);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    /**
     * Handle import API specification requests.
     * 
     * @param request servlet request
     * @param response servlet response
     */
    public static void importAPI(HttpServletRequest request, HttpServletResponse response) {
        try {
            UserSession userSession = UserSessionManager.getCurrentSession();
            String payload = IOUtils.toString(request.getReader());
            APIImportPayload apiArtifact = JsonUtils.getAPIImportPayloadFromJson(payload);

            // Getting swagger file
            String swaggerSource = APIMServiceClient.getInstance().getRegistryEntryAPIDefinition(
                    userSession.getAccessToken(), userSession.getEndpointRegistryUrl(), userSession.getRegistryId(),
                    apiArtifact.getId());

            IWorkspace workspace = ResourcesPlugin.getWorkspace();
            IWorkspaceRoot root = workspace.getRoot();
            IProject esbProject = root.getProject(apiArtifact.getProjectName());
            File mavenProjectPomLocation = esbProject.getFile(EndpointCentralConstants.POM_XML).getLocation().
                    toFile();
            MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
            String version = mavenProject.getVersion();
            String groupId = mavenProject.getGroupId() + EndpointCentralConstants.DOT + EndpointCentralConstants.API;
            updatePom(mavenProject, mavenProjectPomLocation);
            esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            // Creating new API artifact
            RestApiAdmin restAPIAdmin = new RestApiAdmin();
            String generatedAPI = restAPIAdmin.generateAPIFromSwagger(swaggerSource);
            String apiName = apiArtifact.getApiName();
            IContainer location = esbProject.getFolder(EndpointCentralConstants.SYNAPSE_API_PATH);
            IFile artifactFile = location.getFile(new Path(apiName + EndpointCentralConstants.XML));

            while (artifactFile.exists()) {
                apiName += "_new";
                artifactFile = location.getFile(new Path(apiName + EndpointCentralConstants.XML));
            }
            File destFile = artifactFile.getLocation().toFile();
            FileUtils.createFile(destFile, generatedAPI);
            String relativePath = FileUtils
                    .getRelativePath(esbProject.getLocation().toFile(),
                            new File(location.getLocation().toFile(), apiName + EndpointCentralConstants.XML))
                    .replaceAll(Pattern.quote(File.separator), EndpointCentralConstants.SLASH);

            // Update project artifact.xml file
            ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
            esbProjectArtifact
                    .fromFile(esbProject.getFile(EndpointCentralConstants.ARTIFACT_XML).getLocation().toFile());
            esbProjectArtifact.addESBArtifact(createArtifact(apiName, groupId, version, relativePath));
            esbProjectArtifact.toFile();
            esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            // EsbProjectArtifact -> fromFile method throws Exception
            setErrorMessage(e.getMessage(), response);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    /**
     * Handle get-projects requests. Respond with projects and their API artifacts.
     * 
     * @param request servlet request
     * @param response servlet response
     */
    public static void getProjects(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<ProjectData> projectList = getProjectList();
            String payload = JsonUtils.getJsonArrayFromProjectList(projectList);
            setPayload(payload, response);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (CoreException e) {
            setErrorMessage(e.getMessage(), response);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    /**
     * Handle logout requests. Remove existing session.
     * 
     * @param request servlet request
     * @param response servlet response
     */
    public static void logOutUser(HttpServletRequest request, HttpServletResponse response) {
        UserSessionManager.removeSession();
        response.setStatus(HttpServletResponse.SC_OK);
    }

    /**
     * Handle login to APIM CTL requests.
     * 
     * @param request servlet request
     * @param response servlet response
     */
    public static void loginToCTL(HttpServletRequest request, HttpServletResponse response) {
        try {
            String payload = IOUtils.toString(request.getReader());
            LoginPayload loginPayload = JsonUtils.getLoginPayloadFromJson(payload);
            String username = loginPayload.getUsername();
            String password = loginPayload.getPassword();
            String hostUrl = loginPayload.getHost();

            // Payload validation
            if (username.isEmpty() || password.isEmpty() || hostUrl.isEmpty()) {
                throw new APIMCTLException(EndpointCentralServletConstants.ResponseMessages.LOGIN_DETAILS_MISSING);
            }
            APIMCTLClient.getInstance().login(username, password, hostUrl);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException | APIMCTLException e) {
            setErrorMessage(e.getMessage(), response);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    /**
     * Handle push API requests.
     * 
     * @param request servlet request
     * @param response servlet response
     */
    public static void pushAPIThroughCTL(HttpServletRequest request, HttpServletResponse response) {
        try {
            String payload = IOUtils.toString(request.getReader());
            APIArtifact apiArtifact = JsonUtils.getAPIArtifactFromJson(payload);
            String definitionFile = getSwaggerDefinitionFromAPIArtifact(apiArtifact);
            APIMCTLClient.getInstance().pushAPI(definitionFile);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException | CoreException | XMLStreamException | APIException e) {
            setErrorMessage(e.getMessage(), response);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    /**
     * Update old project POM files with new plugin.
     * 
     * @param mavenProject
     * @param mavenProjectPomLocation
     * @throws IOException errors in saving pom file
     * @throws XmlPullParserException errors in processing pom file
     */
    private static void updatePom(MavenProject mavenProject, File mavenProjectPomLocation)
            throws IOException, XmlPullParserException {
        // Skip changing the pom file if group ID and artifact ID are matched
        if (MavenUtils.checkOldPluginEntry(mavenProject, EndpointCentralConstants.ORG_WSO2_MAVEN,
                EndpointCentralConstants.WSO2_API_PLUGIN)) {
            return;
        }

        Plugin plugin = MavenUtils.createPluginEntry(mavenProject, EndpointCentralConstants.ORG_WSO2_MAVEN,
                EndpointCentralConstants.WSO2_API_PLUGIN, ESBMavenConstants.WSO2_ESB_API_VERSION, true);
        PluginExecution pluginExecution = new PluginExecution();
        pluginExecution.addGoal("pom-gen");
        pluginExecution.setPhase("process-resources");
        pluginExecution.setId(EndpointCentralConstants.API);

        Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
        Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
        artifactLocationNode.setValue(EndpointCentralConstants.DOT);
        Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
        typeListNode.setValue("${artifact.types}");
        pluginExecution.setConfiguration(configurationNode);
        plugin.addExecution(pluginExecution);
        MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
    }

    /**
     * Create a new ESBArtifact instance.
     * 
     * @param name name of the artifact
     * @param groupId groupId of the artifact
     * @param version version of the artifact
     * @param path relative path of the relevant synapse config file
     * @return new ESBArtifact instance
     */
    private static ESBArtifact createArtifact(String name, String groupId, String version, String path) {
        ESBArtifact artifact = new ESBArtifact();
        artifact.setName(name);
        artifact.setVersion(version);
        artifact.setType(EndpointCentralConstants.SYNAPSE_API);
        artifact.setServerRole("EnterpriseServiceBus");
        artifact.setGroupId(groupId);
        artifact.setFile(path);
        return artifact;
    }

    /**
     * Returns ESB projects in the workspace and their API artifacts.
     * 
     * @return project list
     * @throws CoreException exception reading project data
     */
    private static List<ProjectData> getProjectList() throws CoreException {
        ProjectList projectListProvider = new ProjectList();
        List<ListData> projectListData = projectListProvider.getListData(null, null);
        Map<String, ProjectData> projects = new HashMap();

        for (ListData data : projectListData) {
            DependencyData dependencyData = (DependencyData) data.getData();
            Object parent = dependencyData.getParent();
            if (parent instanceof IProject) {
                IProject parentProject = (IProject) parent;

                // Filter only ESB config projects
                if (parentProject.hasNature(Constants.ESB_PROJECT_NATURE)) {
                    String parentProjectName = parentProject.getName();
                    ProjectData parentProjectData;

                    // Add project to project list if not exists
                    if (!projects.containsKey(parentProjectName)) {
                        projects.put(parentProjectName, getProjectDataFromProject(parentProject));
                    }

                    // Filter only api artifacts
                    if (dependencyData.getCApptype().equals(EndpointCentralConstants.SYNAPSE_API)) {
                        parentProjectData = projects.get(parentProjectName);
                        String path = (String) dependencyData.getSelf();
                        APIArtifact apiArtifact = new APIArtifact();
                        String[] parts = data.getCaption().split("_._");
                        String artifactName = parts[parts.length - 1];
                        apiArtifact.setName(artifactName);
                        apiArtifact.setParent(parentProjectName);
                        apiArtifact.setPath(path);
                        parentProjectData.getApis().add(apiArtifact);
                    }
                }
            }
        }

        // Adding ESB Project without any API artifacts
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot root = workspace.getRoot();
        for (IProject project : root.getProjects()) {
            String projectName = project.getName();
            if (project.hasNature(Constants.ESB_PROJECT_NATURE) && !projects.containsKey(projectName)) {
                projects.put(projectName, getProjectDataFromProject(project));
            }
        }

        List<ProjectData> projectDataList = new ArrayList<>();
        projectDataList.addAll(projects.values());
        return projectDataList;
    }

    private static String getSwaggerDefinitionFromAPIArtifact(APIArtifact apiArtifact)
            throws CoreException, IOException, XMLStreamException, APIException {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot root = workspace.getRoot();
        IProject parentProject = root.getProject(apiArtifact.getParent());
        try (InputStream inputStream = parentProject.getFile(apiArtifact.getPath()).getContents();
                Scanner scanner = new Scanner(inputStream);) {
            String source = scanner.useDelimiter("\\A").next();
            RestApiAdmin restAPIAdmin = new RestApiAdmin();
            OMElement element = AXIOMUtil.stringToOM(source);
            API api = APIFactory.createAPI(element);
            return restAPIAdmin.generateSwaggerFromSynapseAPI(api);
        } catch (IOException | XMLStreamException | APIException e) {
            throw e;
        }
    }

    /**
     * Extract only relevant data from project instance.
     * 
     * @param project eclipse project instance
     * @return project data
     */
    private static ProjectData getProjectDataFromProject(IProject project) {
        String projectName = project.getName();
        String projectPath = project.getLocation().toString();
        ProjectData projectData = new ProjectData();
        projectData.setProjectName(projectName);
        projectData.setProjectPath(projectPath);
        projectData.setApis(new ArrayList<APIArtifact>());
        return projectData;
    }

    /**
     * Write given error message to the response.
     * 
     * @param errorMessage message to set
     * @param response servlet response
     */
    private static void setErrorMessage(String errorMessage, HttpServletResponse response) {
        Map<String, Object> data = new HashMap<>();
        data.put(EndpointCentralServletConstants.ResponseMessages.ERROR, errorMessage);
        setPayload(JsonUtils.getJsonFromMap(data), response);
    }

    /**
     * Write payload to response.
     * 
     * @param payload json payliad
     * @param response servlet reponse
     */
    private static void setPayload(String payload, HttpServletResponse response) {
        response.setContentType(EndpointCentralServletConstants.RequestHeaders.APPLICATION_JSON);
        PrintWriter out;
        try {
            out = response.getWriter();
            out.println(payload);
        } catch (IOException exception) {
            log.error("Failed to set the payload in response: ", exception);
        }
    }
}

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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.ui.IStartup;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.Activator;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.model.UserSession;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.resources.EndpointCentralServletConstants;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.resources.EndpointRegistryServiceConstants;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.servlets.EndpointCentralServlet;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.utils.EncoderUtil;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.utils.UserSessionManager;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.templates.dashboard.handlers.JettyServerHandler;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.FunctionServerConstants;

/**
 * This startup handler will add the Endpoint central context handler to Jetty.
 */
public class APIMEarlyStartupHandler implements IStartup {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    @Override
    public void earlyStartup() {
    	
    	JettyServerHandler jettyServerHandler = JettyServerHandler.getInstance();
		if(!JettyServerHandler.serverStarted) {
			jettyServerHandler.startEmbeddedJetty(FunctionServerConstants.EMBEDDED_SERVER_PORT);
            JettyServerHandler.serverStarted = true;
        }

        // Registering servlet context handler of the DSS editor
        ServletContextHandler endpointCentralContext = new ServletContextHandler();

        endpointCentralContext.setContextPath(EndpointCentralServletConstants.Startup.ENDPOINT_CENTRAL_CONTEXT_PATH);
        String endpointCentralWebAppPath = EndpointCentralServletConstants.Startup.WEB_APP_LOCATION;

        // Get web app path from the bundle
        try {
            endpointCentralWebAppPath = getEndpointWebAppPath();
        } catch (URISyntaxException | IOException uriException) {
            log.error("Error resolving endpoint central web app path", uriException);
        }

        // Adding Default servlet and endpoint central servlet
        endpointCentralContext.addServlet(EndpointCentralServlet.class,
                EndpointCentralServletConstants.Startup.SERVLET_PATH);
        endpointCentralContext.addServlet(DefaultServlet.class, EndpointCentralServletConstants.Startup.ROOT_PATH);
        endpointCentralContext.setResourceBase(endpointCentralWebAppPath);

        // Registering the handler in the Jetty server
        jettyServerHandler.getHandlerCollection().addHandler(endpointCentralContext);

        try {
            endpointCentralContext.start();
        } catch (Exception e) {
            log.error("Error starting endpoint central context.", e);
        }
        readCredentials();
    }

    /**
     * Returns the web app path of the Endpoint central.
     * 
     * @return Web app path of the Endpoint central
     * @throws URISyntaxException error creating the URI
     * @throws IOException error locating the folder
     */
    public String getEndpointWebAppPath() throws URISyntaxException, IOException {
        URL webAppURL = Activator.getDefault().getBundle()
                .getEntry(EndpointCentralServletConstants.Startup.WEB_APP_LOCATION);
        URL resolvedFolderURL = FileLocator.toFileURL(webAppURL);
        URI resolvedFolderURI = new URI(resolvedFolderURL.getProtocol(), resolvedFolderURL.getPath(), null);
        File resolvedWebAppFolder = new File(resolvedFolderURI);
        return resolvedWebAppFolder.getAbsolutePath();
    }

    /**
     * Read and set the current session from credential file.
     */
    public static void readCredentials() {
        String credentialFilePath = getCredentialFilePath();
        File credentialFile = new File(credentialFilePath);

        // check if the file exists.
        if (credentialFile.exists()) {
            try (InputStream input = new FileInputStream(credentialFilePath)) {
                Properties prop = new Properties();
                prop.load(input);
                String encodedClientIdSecret = prop
                        .getProperty(EndpointRegistryServiceConstants.Credentials.ENDCODED_CLIENT_ID_SECRET);
                String refreshToken = prop.getProperty(EndpointRegistryServiceConstants.Credentials.REFRESH_TOKEN);
                String accessToken = prop.getProperty(EndpointRegistryServiceConstants.Credentials.ACCESS_TOKEN);
                String registryId = prop.getProperty(EndpointRegistryServiceConstants.Credentials.REGISTRY_ID);
                String endpointRegistryVersion = prop
                        .getProperty(EndpointRegistryServiceConstants.Credentials.ENDPOINT_REG_VERSION);
                String baseUrl = prop.getProperty(EndpointRegistryServiceConstants.Credentials.BASE_URL);
                String userName = prop.getProperty(EndpointRegistryServiceConstants.Credentials.USER_NAME);
                String registryName = prop.getProperty(EndpointRegistryServiceConstants.Credentials.REGISTRY_NAME);
                // check if values exist.
                if (!encodedClientIdSecret.isEmpty() && !refreshToken.isEmpty() && !accessToken.isEmpty()
                        && !registryId.isEmpty() && !endpointRegistryVersion.isEmpty() && !baseUrl.isEmpty()
                        && !userName.isEmpty() && !registryName.isEmpty()) {
                    accessToken = EncoderUtil.decode(accessToken);
                    refreshToken = EncoderUtil.decode(refreshToken);
                    registryId = EncoderUtil.decode(registryId);
                    UserSessionManager.createSession(userName, registryName, encodedClientIdSecret, refreshToken,
                            accessToken, registryId, endpointRegistryVersion, baseUrl);
                }
            } catch (IOException e) {
                log.error("Error reading endpoint credential file.", e);
            }
        }
    }

    /**
     * This methods build and returns the path to credential file.
     * 
     * @return path to credential file
     */
    private static String getCredentialFilePath() {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        File workspaceDirectory = workspace.getRoot().getLocation().toFile();
        return workspaceDirectory.getAbsolutePath() + 
                EndpointRegistryServiceConstants.Credentials.CREDENTIAL_FILE_PATH;
    }

    /**
     * This method writes given session to credentials file.
     * 
     * @param userSession object to set
     */
    public static void writeCredential(UserSession userSession) {
        String credentialFilePath = getCredentialFilePath();
        try (OutputStream output = new FileOutputStream(credentialFilePath)) {
            Properties prop = new Properties();
            prop.setProperty(EndpointRegistryServiceConstants.Credentials.ACCESS_TOKEN,
                    EncoderUtil.encode(userSession.getAccessToken()));
            prop.setProperty(EndpointRegistryServiceConstants.Credentials.BASE_URL, userSession.getBaseUrl());
            prop.setProperty(EndpointRegistryServiceConstants.Credentials.ENDCODED_CLIENT_ID_SECRET,
                    userSession.getEncodedClientIdSecret());
            prop.setProperty(EndpointRegistryServiceConstants.Credentials.ENDPOINT_REG_VERSION,
                    userSession.getEndpointRegistryVersion());
            prop.setProperty(EndpointRegistryServiceConstants.Credentials.REFRESH_TOKEN,
                    EncoderUtil.encode(userSession.getRefreshToken()));
            prop.setProperty(EndpointRegistryServiceConstants.Credentials.REGISTRY_ID,
                    EncoderUtil.encode(userSession.getRegistryId()));
            prop.setProperty(EndpointRegistryServiceConstants.Credentials.USER_NAME, userSession.getUserName());
            prop.setProperty(EndpointRegistryServiceConstants.Credentials.REGISTRY_NAME, 
                    userSession.getRegistryName());
            prop.store(output, null);
        } catch (IOException e) {
            log.error("Error saving endpoint credentials.", e);
        }
    }
}

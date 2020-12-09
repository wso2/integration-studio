/*
*  Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.developerstudio.eclipse.esb.project.store.handlers;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.ui.IStartup;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.wso2.developerstudio.eclipse.esb.project.servlets.ConnectorDownloadServlet;
import org.wso2.developerstudio.eclipse.esb.project.servlets.ConnectorRetrievalServlet;
import org.wso2.developerstudio.eclipse.esb.project.servlets.ConnectorSearchServlet;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.templates.dashboard.handlers.JettyServerHandler;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.FunctionServerConstants;

/**
 * Binds new servlets to paths of the jetty server
 * 
 */
public class ConnectorStoreEarlyStartupHandler implements IStartup {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static final String CONTEXT_PATH = "/project/connectors";
    private static final String CONNECTOR_RETRIEVAL_SERVLET_PATH = "/list";
    private static final String CONNECTOR_DOWNLOAD_SERVLET_PATH = "/download";
    private static final String CONNECTOR_SEARCH_SERVLET_PATH = "/search";
    private static final String WEB_APP_LOCATION = "HTMLPages";

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IStartup#earlyStartup()
     */
    @Override
    public void earlyStartup() {
    	
    	JettyServerHandler jettyServerHandler = JettyServerHandler.getInstance();
		if(!JettyServerHandler.serverStarted) {
			jettyServerHandler.startEmbeddedJetty(FunctionServerConstants.EMBEDDED_SERVER_PORT);
            JettyServerHandler.serverStarted = true;
        }

        // Registering servlet context handler of store connectors window
        ServletContextHandler connectorsContext = new ServletContextHandler();

        // Context path where static webpages are hosted
        String webAppPath = "";
        try {
            // Get web app path from current bundle
            webAppPath = getWebAppPath();
        } catch (URISyntaxException | IOException e) {
            log.error("Error resolving web app path", e);
        }
        connectorsContext.setContextPath(CONTEXT_PATH);

        // Adding Default servlet and Connector servlet
        connectorsContext.addServlet(ConnectorRetrievalServlet.class, CONNECTOR_RETRIEVAL_SERVLET_PATH);
        connectorsContext.addServlet(ConnectorDownloadServlet.class, CONNECTOR_DOWNLOAD_SERVLET_PATH);
        connectorsContext.addServlet(ConnectorSearchServlet.class, CONNECTOR_SEARCH_SERVLET_PATH);
        connectorsContext.addServlet(DefaultServlet.class, "/");
        connectorsContext.setResourceBase(webAppPath);

        // Registering the handler in the jetty server
        jettyServerHandler.getHandlerCollection().addHandler(connectorsContext);
        try {
            connectorsContext.start();
        } catch (Exception e) {
            log.error("Failed to start connectors context", e);
        }
    }

    /**
     * This method returns the current web app path(Which is inside the bundle)
     * 
     * @return web app folder absolute path
     * @throws URISyntaxException
     * @throws IOException
     */
    public String getWebAppPath() throws URISyntaxException, IOException {
        Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
        URL webAppURL = bundle.getEntry(WEB_APP_LOCATION);
        URL resolvedFolderURL = FileLocator.toFileURL(webAppURL);
        URI resolvedFolderURI = new URI(resolvedFolderURL.getProtocol(), resolvedFolderURL.getPath(), null);
        File resolvedWebAppFolder = new File(resolvedFolderURI);
        return resolvedWebAppFolder.getAbsolutePath();
    }

}
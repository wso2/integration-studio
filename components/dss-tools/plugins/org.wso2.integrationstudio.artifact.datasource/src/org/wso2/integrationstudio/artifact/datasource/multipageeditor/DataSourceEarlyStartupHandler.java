/*
* Copyright (c) 2022, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* WSO2 Inc. licenses this file to you under the Apache License,
* Version 2.0 (the "License"); you may not use this file except
* in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied. See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.integrationstudio.artifact.datasource.multipageeditor;

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
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.templates.dashboard.handlers.JettyServerHandler;
import org.wso2.integrationstudio.templates.dashboard.web.function.server.FunctionServerConstants;

/**
 * This startup handler will add the DSS context handler to Jetty.
 * handler collection.
 *
 */
public class DataSourceEarlyStartupHandler implements IStartup {

    public static final String PLUGIN_ID = "org.wso2.integrationstudio.artifact.datasource";
    private static final String DATASOURCE_BUNDLE = "org.wso2.integrationstudio.artifact.datasource.multipageeditor";
    private static final String WEB_APP_LOCATION = "DataSourceEditor";
    private static final String DATASOURCE_CONTEXT_PATH = "/datasourceeditor";
    private static final String SERVLET_PATH = "/service";
    private static final String ROOT_PATH = "/";

    private static IIntegrationStudioLog log = Logger.getLog(PLUGIN_ID);

    @Override
    public void earlyStartup() {
        JettyServerHandler jettyServerHandler = JettyServerHandler.getInstance();
        if (!JettyServerHandler.serverStarted) {
            jettyServerHandler.startEmbeddedJetty(FunctionServerConstants.EMBEDDED_SERVER_PORT);
            JettyServerHandler.serverStarted = true;
        }

        // Registering servlet context handler of the DSS editor
        ServletContextHandler dssEditorContext = new ServletContextHandler();

        dssEditorContext.setContextPath(DATASOURCE_CONTEXT_PATH);
        String dssEditorWebAppPath = WEB_APP_LOCATION;

        try {
            // Get web app path from the bundle
            dssEditorWebAppPath = getDataSourceWebAppPath();
        } catch (URISyntaxException uriException) {
            log.error("Error resolving web app path", uriException);
        } catch (IOException ioException) {
            log.error("Error resolving web app path", ioException);
        }

        // Adding Default servlet and Registry reader servlet
        dssEditorContext.addServlet(DataSourceEditorServlet.class, SERVLET_PATH);
        dssEditorContext.addServlet(DefaultServlet.class, ROOT_PATH);
        dssEditorContext.setResourceBase(dssEditorWebAppPath);

        // Registering the handler in the Jetty server
        jettyServerHandler.getHandlerCollection().addHandler(dssEditorContext);

        try {
            dssEditorContext.start();
        } catch (Exception e) {

        }
    }

    /**
     * Returns the web app path of the DSS editor
     * 
     * @return Web app path of the DSS editor
     * 
     * @throws URISyntaxException
     * @throws IOException
     */
    public String getDataSourceWebAppPath() throws URISyntaxException, IOException {
        URL webAppURL = DataSourceEditorPlugin.getPlugin().getBundle().getEntry(WEB_APP_LOCATION);
        URL resolvedFolderURL = FileLocator.toFileURL(webAppURL);
        URI resolvedFolderURI = new URI(resolvedFolderURL.getProtocol(), resolvedFolderURL.getPath(), null);
        File resolvedWebAppFolder = new File(resolvedFolderURI);

        return resolvedWebAppFolder.getAbsolutePath();
    }

}

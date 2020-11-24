/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.swagger;

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
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.templates.dashboard.handlers.JettyServerHandler;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.FunctionServerConstants;

/**
 * This startup handler will add the Swagger Editor context handler to Jetty.
 * handler collection.
 *
 */
public class SwaggerEditorEarlyStartup implements IStartup {

	private static final String WEB_APP_LOCATION = "swagger-editor";
	private static final String SWAGGER_CONTEXT_PATH = "/swagger-editor";
	private static final String SERVLET_PATH = "/service";
	private static final String ROOT_PATH = "/";
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	@Override
	public void earlyStartup() {
		
		JettyServerHandler jettyServerHandler = JettyServerHandler.getInstance();
		if(!JettyServerHandler.serverStarted) {
			jettyServerHandler.startEmbeddedJetty(FunctionServerConstants.EMBEDDED_SERVER_PORT);
            JettyServerHandler.serverStarted = true;
        } 

		// Registering servlet context handler of the Swagger editor
		ServletContextHandler swaggerEditorContext = new ServletContextHandler();

		swaggerEditorContext.setContextPath(SWAGGER_CONTEXT_PATH);
		String swaggerEditorWebAppPath = WEB_APP_LOCATION;

		try {
			// Get web app path from the bundle
			swaggerEditorWebAppPath = getSwaggerEditorWebAppPath();
		} catch (URISyntaxException uriException) {
			log.error("Error resolving web app path", uriException);
		} catch (IOException ioException) {
			log.error("Error resolving web app path", ioException);
		}

		// Adding Default servlet and Registry reader servlet
		swaggerEditorContext.addServlet(SwaggerEditorServlet.class, SERVLET_PATH);
		swaggerEditorContext.addServlet(DefaultServlet.class, ROOT_PATH);
		swaggerEditorContext.setResourceBase(swaggerEditorWebAppPath);

		// Registering the handler in the Jetty server
		jettyServerHandler.getHandlerCollection().addHandler(swaggerEditorContext);

		try {
			swaggerEditorContext.start();
		} catch (Exception e) {
			log.error("Error occured while starting swagger editor conntex in the jetty server", e);
		}
	}

	/**
	 * Returns the web app path of the Swagger editor
	 * 
	 * @return Web app path of the Swagger editor
	 * 
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public String getSwaggerEditorWebAppPath() throws URISyntaxException, IOException {
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		URL webAppURL = bundle.getEntry(WEB_APP_LOCATION);
		URL resolvedFolderURL = FileLocator.toFileURL(webAppURL);
		URI resolvedFolderURI = new URI(resolvedFolderURL.getProtocol(), resolvedFolderURL.getPath(), null);
		File resolvedWebAppFolder = new File(resolvedFolderURI);

		return resolvedWebAppFolder.getAbsolutePath();
	}

}
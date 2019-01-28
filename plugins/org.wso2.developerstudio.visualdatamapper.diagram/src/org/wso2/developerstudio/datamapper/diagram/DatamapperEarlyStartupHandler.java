/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.datamapper.diagram;

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
import org.wso2.developerstudio.datamapper.servlets.RegistryReaderServlet;
import org.wso2.developerstudio.eclipse.templates.dashboard.handlers.JettyServerHandler;

/**
 * This startup handler will add the datamapper context handler to the Jetty
 * handler collection.
 * 
 * @author lahiru
 *
 */
public class DatamapperEarlyStartupHandler implements IStartup {

	private static final String DATAMAPPER_BUNDLE = "org.wso2.developerstudio.visualdatamapper.diagram";
	private static final String SERVLET_PATH = "/getRegistryResources";
	private static final String WEB_APP_LOCATION = "HTMLPages";

	@Override
	public void earlyStartup() {

		// TODO Auto-generated method stub
		JettyServerHandler jettyServerHandler = JettyServerHandler.getInstance();

		// Registering servlet context handler of datamapper test window
		ServletContextHandler datamapperContext = new ServletContextHandler();

		// Context path where static webpages are hosted
		datamapperContext.setContextPath("/dataMapper");
		String dataMapperWebAppPath = WEB_APP_LOCATION;
		try {
			// Get web app path from current bundle
			dataMapperWebAppPath = getDatamapperWebAppPath();
		} catch (URISyntaxException uriException) {
			// log.error("Error resolving web app path", uriException);
		} catch (IOException ioException) {
			// log.error("Error resolving web app path", ioException);
		}

		// Adding Default servlet and Registry reader servlet
		datamapperContext.addServlet(RegistryReaderServlet.class, SERVLET_PATH);
		datamapperContext.addServlet(DefaultServlet.class, "/");
		datamapperContext.setResourceBase(dataMapperWebAppPath);
		// Registering the handler in the jetty server
		jettyServerHandler.getHandlerCollection().addHandler(datamapperContext);
		try {
			datamapperContext.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// get web app location for datamaper test window.
	public String getDatamapperWebAppPath() throws URISyntaxException, IOException {
		Bundle bundle = Platform.getBundle(DATAMAPPER_BUNDLE);
		if (bundle == null) {
			return null;
		}
		URL webAppURL = bundle.getEntry(WEB_APP_LOCATION);
		URL resolvedFolderURL = FileLocator.toFileURL(webAppURL);
		URI resolvedFolderURI = new URI(resolvedFolderURL.getProtocol(), resolvedFolderURL.getPath(), null);
		File resolvedWebAppFolder = new File(resolvedFolderURI);
		return resolvedWebAppFolder.getAbsolutePath();
	}

}

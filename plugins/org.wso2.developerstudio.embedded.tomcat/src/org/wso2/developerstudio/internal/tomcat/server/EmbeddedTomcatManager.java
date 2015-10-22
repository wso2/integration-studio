/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.internal.tomcat.server;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import javax.servlet.ServletException;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.internal.tomcat.EmbeddedTomcatPlugin;
import org.wso2.developerstudio.internal.tomcat.api.ITomcatServer;

public class EmbeddedTomcatManager implements ITomcatServer {

	private static final String WEB_APP_EXT_POINT_ID = "org.wso2.developerstudio.embedded.webapp";
	private static final String WEB_XML_REL_PATH = "/WEB-INF/web.xml";
	protected Tomcat tomcat;
	protected Map<String, String> deployedApps;
	protected Integer port;
	
	private static IDeveloperStudioLog log = Logger.getLog(EmbeddedTomcatPlugin.PLUGIN_ID);


	public EmbeddedTomcatManager() throws IOException {
		deployedApps = new HashMap<>();
		configureServer();
	}

	private void initWebApps() throws Exception {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IExtensionPoint ep = reg.getExtensionPoint(WEB_APP_EXT_POINT_ID);
		IExtension[] extensions = ep.getExtensions();
		for (IExtension ext : extensions) {
			String bundleName = ext.getContributor().getName();
			Bundle bundle = Platform.getBundle(bundleName);
			IConfigurationElement element = ext.getConfigurationElements()[0];
			String appID = element.getAttribute("appID");
			String relativePath = element.getAttribute("relativePath");
			String isStatic = element.getAttribute("isStatic");
			if (appID != null && relativePath != null) {
				URL webAppsURL = FileLocator.find(bundle,
						new Path(relativePath), null);
				URL fileURL = FileLocator.toFileURL(webAppsURL);
				addWebApp(appID, appID,
						new File(fileURL.toURI()).getAbsolutePath());
			}
		}
	}

	private void configureServer() throws IOException {
		tomcat = new Tomcat();
		try {
			port = getAvailablePort();
			tomcat.setPort(port);
		} catch (IOException e) {
			throw new IOException(
					"Error while configuring tomcat server of DevStudio.", e);
		}
	}

	@Override
	public void start() throws Exception {
		try {
			initWebApps();
			tomcat.getHost();
			tomcat.start();
		} catch (LifecycleException e) {
			throw new LifecycleException(
					"Error while starting tomcat server of DevStudio.", e);
		}
	}

	@Override
	public void stop() throws LifecycleException {
		try {
			tomcat.stop();
		} catch (LifecycleException e) {
			throw new LifecycleException(
					"Error while stopping embedded tomcat server of DevStudio.",
					e);
		}
	}

	@Override
	public void addWebApp(String appID, String context, String docBase)
			throws Exception {
		try {
			Context appContext = tomcat.addWebapp(context, docBase);
			File configFile = new File(docBase + WEB_XML_REL_PATH);
			if (configFile.exists()) {
				appContext.setConfigFile(configFile.toURI().toURL());
			}
			appContext.setParentClassLoader(Thread.currentThread()
					.getContextClassLoader());
			deployedApps.put(appID, getURLForContext(context));
			log.info("WebApp " + appID + " successfully deployed at " + deployedApps.get(appID));
			
		} catch (ServletException | MalformedURLException e) {
			throw new Exception("Error while adding web app: " + appID + " at "
					+ docBase + " to embedded tomcat server of DevStudio.", e);
		}
	}

	@Override
	public String getAppURL(String appID) {
		return deployedApps.get(appID);
	}
	
	public Integer getServerPort(){
		return port;
	}

	private String getURLForContext(String context) {
		return "http://localhost:" + port + "/" + context;
	}

	private Integer getAvailablePort() throws IOException {
		ServerSocket socket = new ServerSocket(0);
		Integer port = socket.getLocalPort();
		socket.close();
		return port;
	}

}

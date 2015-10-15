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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.wso2.developerstudio.internal.tomcat.api.ITomcatServer;

public class TomcatServerImpl implements ITomcatServer {

	private static final String WEB_XML_REL_PATH = "/WEB-INF/web.xml";
	protected Tomcat tomcat;
	protected Map<String, String> deployedApps;
	protected Integer port;
	protected File webAppRoot;
	protected Logger logger;

	public File getWebAppRoot() {
		return webAppRoot;
	}

	public void setWebAppRoot(File webAppRoot) {
		this.webAppRoot = webAppRoot;
	}

	public TomcatServerImpl() throws IOException {
		logger = Logger.getLogger("org.apache");
		logger.setLevel(Level.ALL);
		deployedApps = new HashMap<>();
		configureServer();
	}

	private void initWebApps() throws Exception {
		for (File file : webAppRoot.listFiles()) {
			if (file.isDirectory()) {
				addWebApp(file.getName(), "/" + file.getName(),
						file.getAbsolutePath());
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

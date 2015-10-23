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
package org.wso2.developerstudio.embedded.tomcat.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.servlet.ServletException;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
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
import org.wso2.developerstudio.embedded.tomcat.EmbeddedTomcatPlugin;
import org.wso2.developerstudio.embedded.tomcat.api.ITomcatServer;

public class EmbeddedTomcatServer implements ITomcatServer {

	private static final String TOMCAT_TMP = "DevSTomcat";
	private static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
	private static final String FOLDER_PREFIX = "tmp";
	private static final String WAR_EXT = "war";
	private static final String RELATIVE_PATH = "relativePath";
	private static final String CONTEXT = "context";
	private static final String APP_ID = "appID";
	private static final String HTTP_PROTOCOL = "http://";
	private static final String WEB_APP_EXT_POINT_ID = "org.wso2.developerstudio.embedded.webapp";
	private static final String WEB_XML_REL_PATH = "/WEB-INF/web.xml";

	protected Tomcat tomcat;
	protected Map<String, String> deployedApps;
	protected Integer port;
	protected String rootURL;
	
	private static IDeveloperStudioLog log = Logger.getLog(EmbeddedTomcatPlugin.PLUGIN_ID);

	public EmbeddedTomcatServer() {
		deployedApps = new HashMap<>();
	}

	public void start() throws Exception {
		try {
			initTomcat();
			initWebApps();
			tomcat.getHost();
			tomcat.start();
		} catch (LifecycleException e) {
			throw new LifecycleException(
					"Error while starting embedded tomcat server of DevStudio.", e);
		}
	}

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
			log.info("WebApp " + appID + " successfully added at " + deployedApps.get(appID));	
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
		return rootURL + context;
	}

	/**
	 * Read extensions to webapp extension point and deploy web apps
	 */
	private void initWebApps() {
		IExtensionRegistry extentionRegistry = Platform.getExtensionRegistry();
		IExtensionPoint webAppExtensionPoint = extentionRegistry
				.getExtensionPoint(WEB_APP_EXT_POINT_ID);
		IExtension[] webAppExtensions = webAppExtensionPoint.getExtensions();

		for (IExtension extensionConfig : webAppExtensions) {

			String contributingBundleID = extensionConfig.getContributor()
					.getName();
			Bundle contributingBundle = Platform
					.getBundle(contributingBundleID);
			IConfigurationElement webAppExtension = extensionConfig
					.getConfigurationElements()[0];

			String applicationID = webAppExtension.getAttribute(APP_ID);
			String relativePath = webAppExtension.getAttribute(RELATIVE_PATH);
			String context = webAppExtension.getAttribute(CONTEXT);

			if (applicationID != null && relativePath != null) {
				URL docBaseResource = FileLocator.find(contributingBundle,
						new Path(relativePath), null);
				File readableDocBase = null;
				String deployableDocBase = null;
				try {
					// resolve resource from bundle jar
					URL fileURL = FileLocator.toFileURL(docBaseResource);
					readableDocBase = new File(fileURL.toURI());
				} catch (IOException | URISyntaxException e) {
					log.error("Error while resolving webapp resources at "
							+ docBaseResource, e);
				}
				if (readableDocBase != null) {
					if (readableDocBase.isDirectory()) {
						// case 1 : this is an exploded web application
						deployableDocBase = readableDocBase.getAbsolutePath();
					} else if (WAR_EXT.equals(FilenameUtils
							.getExtension(readableDocBase.getAbsolutePath()))) {
						// case 2: this is a war file
						File extractDir = new File(
								readableDocBase.getParentFile(), FOLDER_PREFIX
										+ applicationID);
						if (!extractDir.exists()) {
							if (!extractDir.mkdirs()) {
								log.error("Error while creating destination folder "
										+ extractDir);
							}
						}
						try {
							extractWar(readableDocBase, extractDir);
							deployableDocBase = extractDir.getAbsolutePath();
						} catch (IOException e) {
							log.error("Error while extracting webapp from "
									+ readableDocBase.getPath() + " \nto "
									+ extractDir.getPath(), e);
						}
					}
				}
				if (deployableDocBase != null) {
					try {
						addWebApp(applicationID, context,
								deployableDocBase);
					} catch (Exception e) {
						log.error("Error deploying webapp. AppID: "
								+ applicationID + ", Contributing Bundle: "
								+ contributingBundleID, e);
					}
				} else {
					log.error("Error deploying webapp. AppID: " + applicationID
							+ ", Contributing Bundle: " + contributingBundleID);
				}
			}
		}
	}

	private void initTomcat() throws IOException {
		tomcat = new Tomcat();
		try {
			port = getAvailablePort();
			tomcat.setPort(port);
			tomcat.setBaseDir(System.getProperty(JAVA_IO_TMPDIR) + File.separator + TOMCAT_TMP);
			String hostName= InetAddress.getLocalHost().getHostName();
			tomcat.getHost().setName(hostName);
			rootURL = HTTP_PROTOCOL + hostName + ":" + port;
		} catch (IOException e) {
			throw new IOException(
					"Error while configuring tomcat server of DevStudio.", e);
		}
	}

	private Integer getAvailablePort() throws IOException {
		ServerSocket socket = new ServerSocket(0);
		Integer port = socket.getLocalPort();
		socket.close();
		return port;
	}

	private void extractWar(File webApp, File extractpath) throws IOException {
		ZipFile zipFile = new ZipFile(webApp);
		try {
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				File entryDestination = new File(extractpath, entry.getName());
				if (entry.isDirectory())
					entryDestination.mkdirs();
				else {
					entryDestination.getParentFile().mkdirs();
					InputStream in = zipFile.getInputStream(entry);
					OutputStream out = new FileOutputStream(entryDestination);
					IOUtils.copy(in, out);
					IOUtils.closeQuietly(in);
					out.close();
				}
			}
		} finally {
			zipFile.close();
		}
	}

}

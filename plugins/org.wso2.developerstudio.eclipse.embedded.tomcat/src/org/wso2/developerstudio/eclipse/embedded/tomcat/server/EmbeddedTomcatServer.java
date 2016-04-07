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
package org.wso2.developerstudio.eclipse.embedded.tomcat.server;

import static org.apache.commons.lang.StringUtils.isNotEmpty;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

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
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.embedded.tomcat.EmbeddedTomcatPlugin;
import org.wso2.developerstudio.eclipse.embedded.tomcat.Messages;
import org.wso2.developerstudio.eclipse.embedded.tomcat.exception.AppNotFoundException;
import org.wso2.developerstudio.eclipse.embedded.tomcat.exception.DuplicateAppIDException;
import org.wso2.developerstudio.eclipse.embedded.tomcat.exception.DuplicateContextException;
import org.wso2.developerstudio.eclipse.embedded.tomcat.exception.EmbeddedTomcatException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class EmbeddedTomcatServer{

	private static final String TOMCAT_TMP = "DevSTomcatTmp"; //$NON-NLS-1$
	private static final String JAVA_IO_TMPDIR = "java.io.tmpdir"; //$NON-NLS-1$
	private static final String FOLDER_PREFIX = "tmp"; //$NON-NLS-1$
	private static final String WAR_EXT = "war"; //$NON-NLS-1$
	private static final String RELATIVE_PATH = "relativePath"; //$NON-NLS-1$
	private static final String CONTEXT = "context"; //$NON-NLS-1$
	private static final String APP_ID = "appID"; //$NON-NLS-1$
	private static final String HTTP_PROTOCOL_PREFIX = "http://"; //$NON-NLS-1$
	private static final String WEB_APP_EXT_POINT_ID = "org.wso2.developerstudio.embedded.webapp"; //$NON-NLS-1$
	private static final String WEB_XML_REL_PATH = "/WEB-INF/web.xml"; //$NON-NLS-1$

	private static IDeveloperStudioLog log = Logger.getLog(EmbeddedTomcatPlugin.PLUGIN_ID);
	
	protected Tomcat tomcat;
	protected Integer port;
	protected String rootURL;
	protected Map<String, String> appIDToURLMap;
	protected Map<String, String> contextToAppIDMap;
	private boolean isStartupRequired;

	public EmbeddedTomcatServer() {
		appIDToURLMap = new HashMap<>();
		contextToAppIDMap = new HashMap<>();
	}

	/**
	 * Starts Embedded Tomcat server.
	 * 
	 * @throws EmbeddedTomcatException
	 */
	public void start() throws EmbeddedTomcatException {
		try {
			tomcat.getHost();
			tomcat.start();
		} catch (LifecycleException e) {
			throw new EmbeddedTomcatException(Messages.ERROR_TOMCAT_STARTUP_ERROR, e);
		}
	}

	/**
	 * Stops Embedded Tomcat server.
	 * 
	 * @throws EmbeddedTomcatException
	 */
	public void stop() throws EmbeddedTomcatException {
		try {
			tomcat.stop();
		} catch (LifecycleException e) {
			throw new EmbeddedTomcatException(Messages.ERROR_TOMCAT_SHUTDOWN_ERROR,
					e);
		}
	}

	/**
	 * Method to add a web application to server.
	 * 
	 * @param appID
	 *            A unique ID for the app.
	 * @param context
	 *            Deploying context.
	 * @param docBase
	 *            Root folder of the application.
	 * @throws Exception
	 */
	public void addWebApp(String appID, String context, String docBase)
			throws EmbeddedTomcatException {
		if (appIDToURLMap.containsKey(appID)) {
			throw new DuplicateAppIDException(appID, appIDToURLMap.get(appID));
		} else if (contextToAppIDMap.containsKey(context)) {
			throw new DuplicateContextException(context,
					contextToAppIDMap.get(context));
		}
		try {
			Context appContext = tomcat.addWebapp(context, docBase);
			File webXML = new File(docBase + WEB_XML_REL_PATH);
			if (webXML.exists()) {
				appContext.setConfigFile(webXML.toURI().toURL());
			}
			appContext.setParentClassLoader(Thread.currentThread()
					.getContextClassLoader());
			appIDToURLMap.put(appID, getURLForContext(context));
			contextToAppIDMap.put(context, appID);
			log.info(NLS.bind(Messages.INFO_APP_ADDED_SUCCESSFULLY, appID,
					appIDToURLMap.get(appID)));
		} catch (Exception e) {
			String errorMessage = NLS.bind(Messages.ERROR_ADDING_WEBAPP_FAILED,
					appID, docBase);
			throw new EmbeddedTomcatException(errorMessage, e);
		}
	}

	/**
	 * Method to get full URL to access a particular web application.
	 * 
	 * @param appID
	 *            Unique ID of the web application.
	 * 
	 * @return complete URL to access given web application.
	 */
	public String getAppURL(String appID) throws EmbeddedTomcatException {
		if(!appIDToURLMap.containsKey(appID)){
			throw new AppNotFoundException(appID);
		}
		return appIDToURLMap.get(appID);
	}

	/**
	 * Getter for configured port.
	 * 
	 * @return port used by Tomcat.
	 */
	public Integer getServerPort(){
		return port;
	}

	/**
	 * Constructs the complete URL for a particular context.
	 * 
	 * @param context relative context path.
	 * @return Full URL of the app.
	 */
	private String getURLForContext(String context) {
		return rootURL + context;
	}

	/**
	 * Read extensions to webapp extension point and deploy them.
	 */
	private void initWebAppExtensions() {

		// Fetch extensions to extension point from registry.
		IExtensionRegistry extentionRegistry = Platform.getExtensionRegistry();
		IExtensionPoint webAppExtensionPoint = extentionRegistry
				.getExtensionPoint(WEB_APP_EXT_POINT_ID);
		IExtension[] webAppExtensions = webAppExtensionPoint.getExtensions();
		
		// if there are any apps only, server should be started.
		if(webAppExtensions.length > 0){
			isStartupRequired = true;
		}

		// Iterate over all web extensions and deploy web apps.
		// IMPORTANT: Continue deploying other apps upon any failures.
		for (IExtension extensionConfig : webAppExtensions) {

			// Read extension point configuration.
			String contributingBundleID = extensionConfig.getContributor().getName();
			Bundle contributingBundle = Platform.getBundle(contributingBundleID);
			IConfigurationElement webAppExtension = extensionConfig
					.getConfigurationElements()[0];
			// Derive attributes of WebApp Extension
			String applicationID = webAppExtension.getAttribute(APP_ID);
			String relativePath = webAppExtension.getAttribute(RELATIVE_PATH);
			String context = webAppExtension.getAttribute(CONTEXT);
			
			// A common error message to display upon deployment error.
			String appDeploymentErrorMsg = NLS.bind(
					Messages.ERROR_APP_DEPLOYMENT_FAILED, applicationID,
					contributingBundleID);
			//TODO: is this necessary
			if (isNotEmpty(applicationID) && isNotEmpty(relativePath)
					&& isNotEmpty(context)) {
				URL docBaseResource = FileLocator.find(contributingBundle,
						new Path(relativePath), null);
				// FIXME: add a boolean to indicate success 
				File readableDocBase = null;
				String deployableDocBase = null;
				try {
					// resolve resource from bundle jar
					URL fileURL = FileLocator.toFileURL(docBaseResource);
					readableDocBase = new File(fileURL.toURI());
					// Fixme: seperate methods
				} catch (IOException | URISyntaxException e) {
					String errorMessage = NLS.bind(
							Messages.ERROR_RESOLVING_RESOURCES_FAILED,
							docBaseResource);
					log.error(errorMessage, e);
				}
				if (readableDocBase != null) {
					if (readableDocBase.isDirectory()) {
						// case 1 : this is an exploded web application
						deployableDocBase = readableDocBase.getAbsolutePath();
					} else if (WAR_EXT.equals(FilenameUtils
							.getExtension(readableDocBase.getAbsolutePath()))) {
						// case 2: this is a war file
						File extractDir = new File(
								readableDocBase.getParentFile(),
								FOLDER_PREFIX + applicationID);
						if (!extractDir.exists()) {
							if (!extractDir.mkdirs()) {
								String errorMessage = NLS.bind(
										Messages.ERROR_TMP_FILE_CREATION_FAILED,
										extractDir);
								log.error(errorMessage);
							}
						}
						try {
							extractWar(readableDocBase, extractDir);
							deployableDocBase = extractDir.getAbsolutePath();
						} catch (IOException e) {
							String errorMessage = NLS.bind(
									Messages.ERROR_WAR_EXTRACTION_FAILED,
									readableDocBase.getPath(),
									extractDir.getPath());
							log.error(errorMessage, e);
						}
					}
				}
				if (deployableDocBase != null) {
					try {
						addWebApp(applicationID, context,
								deployableDocBase);
					} catch (Exception e) {
						log.error(appDeploymentErrorMsg, e);
					}
				} else {
					log.error(appDeploymentErrorMsg);
				}
			} else {
				String errorMessage = NLS.bind(
						Messages.ERROR_MISSING_REQUIRED_CONFIG, new Object[] {
								applicationID, relativePath, context });
				log.error(errorMessage);
				log.error(appDeploymentErrorMsg);
			}
		}
	}

	/**
	 * Initialize Tomcat server.
	 * 
	 * @throws EmbeddedTomcatException
	 */
	public void init() throws EmbeddedTomcatException {
		tomcat = new Tomcat();
		try {
			port = getAvailablePort();
			tomcat.setPort(port);
			tomcat.setBaseDir(System.getProperty(JAVA_IO_TMPDIR)
					+ File.separator + TOMCAT_TMP);
			String hostName = InetAddress.getLocalHost().getHostName();
			tomcat.getHost().setName(hostName);
			rootURL = HTTP_PROTOCOL_PREFIX + hostName + ":" + port; //$NON-NLS-1$
			initWebAppExtensions();
		} catch (IOException e) {
			throw new EmbeddedTomcatException(
					Messages.ERROR_TOMCAT_INIT_ERROR, e);
		}
	}

	/**
	 * Finds a port which is currently not in use.
	 * 
	 * @return Available Port.
	 * 
	 * @throws IOException
	 */
	private Integer getAvailablePort() throws IOException {
		ServerSocket socket = new ServerSocket(0);
		Integer port = socket.getLocalPort();
		socket.close();
		return port;
	}

	/**
	 * Extracts a war file to a given directory.
	 * 
	 * @param warFile Source war file.
	 * @param extractpath Destination to extract.
	 * 
	 * @throws IOException
	 */
	private void extractWar(File warFile, File extractpath) throws IOException {
		ZipFile zipFile = new ZipFile(warFile);
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

	public boolean isStartupRequired() {
		return isStartupRequired;
	}

}

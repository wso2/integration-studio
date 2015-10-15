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
package org.wso2.developerstudio.internal.tomcat;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class EmbeddedTomcatPlugin implements BundleActivator {

	public static final String PLUGIN_ID = "org.wso2.developerstudio.internal.tomcat";

	private static final String LIBS_DIR = "libs";
	private static final String SERVER_CLASS = "org.wso2.developerstudio.internal.tomcat.server.TomcatServerImpl";
	private static final String METHOD_START = "start";
	private static final String METHOD_SET_WEB_ROOT = "setWebAppRoot";
	private static final String METHOD_STOP = "stop";
	private static final String WEBAPPS_DIR = "webapps";
	private static final String METHOD_GET_APP_URL = "getAppURL";
	private static final String METHOD_GET_SERVER_PORT = "getServerPort";

	private static BundleContext context;

	private static IDeveloperStudioLog log = Logger
			.getLog(EmbeddedTomcatPlugin.PLUGIN_ID);

	/** The shared plug-in instance */
	private static EmbeddedTomcatPlugin plugin;
	/** Tomcat instance */
	private Object serverInstance;

	public void start(BundleContext bundleContext) throws Exception {
		context = bundleContext;
		plugin = this;
		log.info("Starting embedded tomcat server of DevStudio.");
		// Start embedded Tomcat with a separate class loader
		Thread tomcatThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					final List<URL> classPath = new ArrayList<>();
					// Add root directory of the bundle to class-path
					final URL bundleURI = FileLocator.resolve(context
							.getBundle().getResource("."));
					classPath.add(bundleURI);

					// Add third party libs to class-path
					final URI libsURI = FileLocator.resolve(
							context.getBundle().getResource(LIBS_DIR)).toURI();
					final File libs = new File(libsURI);
					addJarsToClassPath(libs, classPath);

					ClassLoader tomcatClassLoader = new URLClassLoader(
							classPath.toArray(new URL[classPath.size()]));
					// Set the proper class loader for this thread.
					Thread.currentThread().setContextClassLoader(
							tomcatClassLoader);

					Class<?> serverClass = tomcatClassLoader
							.loadClass(SERVER_CLASS);
					serverInstance = serverClass.newInstance();

					// Set web application root
					File webAppRoot = new File(FileLocator.resolve(
							context.getBundle().getResource(WEBAPPS_DIR))
							.toURI());
					Method setWebRootMethod = serverInstance.getClass()
							.getMethod(METHOD_SET_WEB_ROOT, File.class);
					setWebRootMethod.invoke(serverInstance, webAppRoot);

					// Start the server
					Method startMethod = serverInstance.getClass().getMethod(
							METHOD_START, new Class[0]);
					startMethod.invoke(serverInstance, new Object[0]);

					// get server port
					Method getPortMethod = serverInstance.getClass().getMethod(
							METHOD_GET_SERVER_PORT, new Class[0]);
					Integer port = (Integer) getPortMethod.invoke(
							serverInstance, new Object[0]);
					log.info("Embedded tomcat server is suceessfully started on port "
							+ port);

				} catch (Exception ex) {
					log.error("Error while starting embedded tomcat server.",
							ex);
				}
			}
		});
		tomcatThread.start();
		// wait till server is started completely
		tomcatThread.join();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		plugin = null;
		context = null;
		try {
			// invoke stop method of the server
			Method m = serverInstance.getClass().getMethod(METHOD_STOP,
					new Class[0]);
			m.invoke(serverInstance, new Object[0]);
		} catch (Exception e) {
			log.error(
					"Error while stopping embedded tomcat server of DevStudio.",
					e);
		}
	}

	/**
	 * Access point for the singleton.
	 * 
	 * @return Singleton instance.
	 */
	public static EmbeddedTomcatPlugin getDefault() {
		return plugin;
	}

	/**
	 * Method to get the URL of a deployed web application.
	 * 
	 * @param appID
	 *            Unique ID for the web application.
	 * @return Complete URL to access a given web application.
	 * @throws Exception
	 */
	public String getAppURL(String appID) throws Exception {
		Method m = serverInstance.getClass().getMethod(METHOD_GET_APP_URL,
				String.class);
		Object result = m.invoke(serverInstance, appID);
		return result.toString();
	}

	/**
	 * Method to get bundle context.
	 * 
	 * @return Bundle context for EmbeddedTomcatPlugin.
	 */
	public static BundleContext getContext() {
		return context;
	}

	/**
	 * Method to capture URLs of jar files in a particular directory.
	 * 
	 * @param root
	 *            Directory to scan for jar files.
	 * @param classPath
	 *            List to put captured jar URLs.
	 * @throws MalformedURLException
	 */
	private static void addJarsToClassPath(File root, List<URL> classPath)
			throws MalformedURLException {
		File[] files = root.listFiles();
		if (files == null) {
			return;
		}
		for (File file : files) {
			if (file.isDirectory() && file.canRead()) {
				addJarsToClassPath(file, classPath);
			} else if (file.isFile() && file.canRead()
					&& file.getName().toLowerCase().endsWith(".jar")) {
				classPath.add(file.toURI().toURL());
			}
		}
	}
}

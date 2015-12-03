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
package org.wso2.developerstudio.eclipse.embedded.tomcat;

import org.eclipse.osgi.util.NLS;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.wso2.developerstudio.eclipse.embedded.tomcat.exception.EmbeddedTomcatException;
import org.wso2.developerstudio.eclipse.embedded.tomcat.server.EmbeddedTomcatServer;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class EmbeddedTomcatPlugin implements BundleActivator {

	public static final String PLUGIN_ID = "org.wso2.developerstudio.embedded.tomcat";//$NON-NLS-1$

	private static ClassLoader bundleCtxClassLoader;
	private static BundleContext context;
	private static EmbeddedTomcatPlugin plugin;
	private static IDeveloperStudioLog log = Logger.getLog(EmbeddedTomcatPlugin.PLUGIN_ID);

	/** Tomcat instance */
	private EmbeddedTomcatServer tomcatServer;

	public void start(BundleContext bundleContext) throws Exception {
		context = bundleContext;
		plugin = this;
        bundleCtxClassLoader = Thread.currentThread().getContextClassLoader();

		// Start embedded Tomcat with a separate class loader
		Thread tomcatThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.currentThread().setContextClassLoader(bundleCtxClassLoader);
					tomcatServer = new EmbeddedTomcatServer();
					tomcatServer.init();
					if(tomcatServer.isStartupRequired()){
						log.info(Messages.INFO_STARTING_TOMCAT);
						tomcatServer.start();
						Integer port = tomcatServer.getServerPort();
						log.info(NLS.bind(Messages.INFO_TOMCAT_STARTED, port));
					}
				} catch (EmbeddedTomcatException ex) {
					log.error(Messages.ERROR_TOMCAT_STARTUP_ERROR, ex);
				}
			}
		});
		tomcatThread.start();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		plugin = null;
		context = null;
		try {
			tomcatServer.stop();
		} catch (Exception e) {
			log.error(Messages.ERROR_TOMCAT_SHUTDOWN_ERROR, e);
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
	 * Method to get server instance
	 * 
	 * @return
	 * @throws EmbeddedTomcatException 
	 */
	public EmbeddedTomcatServer getServer() throws EmbeddedTomcatException{
		if(tomcatServer == null){
			throw new EmbeddedTomcatException(Messages.ERROR_SERVER_NOT_FOUND);
		}
		return  tomcatServer;
	}
	/**
	 * Method to get the URL of a deployed web application.
	 * 
	 * @param appID
	 *            Unique ID for the web application.
	 * @return Complete URL to access a given web application.
	 * @throws EmbeddedTomcatException 
	 */
	public String getAppURL(String appID) throws EmbeddedTomcatException{
		return tomcatServer.getAppURL(appID);
	}

	/**
	 * Method to get bundle context.
	 * 
	 * @return Bundle context for EmbeddedTomcatPlugin.
	 */
	public static BundleContext getContext() {
		return context;
	}

	public ClassLoader getContextClassLoader() {
		return bundleCtxClassLoader;
	}
}

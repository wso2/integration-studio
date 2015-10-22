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
package org.wso2.developerstudio.embedded.tomcat;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.embedded.tomcat.server.EmbeddedTomcatServer;

public class EmbeddedTomcatPlugin implements BundleActivator {

	public static final String PLUGIN_ID = "org.wso2.developerstudio.internal.tomcat";
	protected static ClassLoader bundleCtxtClassLoader;

	private static BundleContext context;

	private static IDeveloperStudioLog log = Logger
			.getLog(EmbeddedTomcatPlugin.PLUGIN_ID);

	/** The shared plug-in instance */
	private static EmbeddedTomcatPlugin plugin;
	/** Tomcat instance */
	private EmbeddedTomcatServer tomcatServer;

	public void start(BundleContext bundleContext) throws Exception {
		context = bundleContext;
		plugin = this;
        bundleCtxtClassLoader = Thread.currentThread().getContextClassLoader();

		// Start embedded Tomcat with a separate class loader
		Thread tomcatThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					log.info("Starting embedded tomcat server of DevStudio.");
					Thread.currentThread().setContextClassLoader(bundleCtxtClassLoader);
					tomcatServer = new EmbeddedTomcatServer();
					tomcatServer.start();
					Integer port = tomcatServer.getServerPort();
					log.info("Embedded tomcat server is suceessfully started on port "
							+ port);
					Thread.sleep(15000);
				} catch (Exception ex) {
					log.error("Error while starting embedded tomcat server.",
							ex);
				}
			}
		});
		tomcatThread.start();
		tomcatThread.join();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		plugin = null;
		context = null;
		try {
			tomcatServer.stop();
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
	 */
	public String getAppURL(String appID){
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
}

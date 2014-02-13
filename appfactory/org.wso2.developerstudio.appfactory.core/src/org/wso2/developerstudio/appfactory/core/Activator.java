/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.appfactory.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	
	// The plug-in ID
	public static final String PLUGIN_ID = "org.wso2.developerstudio.appfactory.core"; //$NON-NLS-1$

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		String jksPath = new String();
		FileOutputStream fos;
		try {
			jksPath = System.getProperty("java.io.tmpdir") + File.separator+ "wso2carbon.jks";
			InputStream keystoreStream = context.getBundle().getEntry("resources/wso2carbon.jks").openStream(); 
			fos = new FileOutputStream(jksPath);
			int count;
			byte[] buff = new byte[16 * 1024];
			while ((count = keystoreStream.read(buff)) != -1) {
				fos.write(buff, 0, count);
			}
			fos.close();
			keystoreStream.close();
			System.setProperty("javax.net.ssl.trustStore", jksPath);
	        System.setProperty("javax.net.ssl.trustStorePassword", "wso2carbon");
	        System.setProperty("javax.net.ssl.trustStoreType", "JKS");
		} catch (Exception e) {
			
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}

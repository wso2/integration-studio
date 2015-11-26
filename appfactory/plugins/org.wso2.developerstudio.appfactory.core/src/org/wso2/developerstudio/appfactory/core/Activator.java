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

import org.eclipse.jface.preference.IPreferenceStore;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.ClientTrustStorePreferencePage;


public class Activator implements BundleActivator {
	
	// The plug-in ID
	public static final String PLUGIN_ID = "org.wso2.developerstudio.appfactory.core"; //$NON-NLS-1$
	

	private static BundleContext context;

	private static Activator plugin;
	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		if(!loadJKSfromEclipsePrefernaces()){
		
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
		 
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}
	
	public static Activator getDefault() {
		return plugin;
	}
	
	private static boolean loadJKSfromEclipsePrefernaces(){
		
		try{

		IPreferenceStore preferenceStore = org.wso2.developerstudio.eclipse.platform.ui.Activator.getDefault()
					.getPreferenceStore();

		if(preferenceStore.getString(ClientTrustStorePreferencePage.TRUST_STORE_LOCATION).isEmpty()){
			return false;
		}
		if(preferenceStore.getString(ClientTrustStorePreferencePage.TRUST_STORE_PASSWORD).isEmpty()){
			return false;
		}
		if(preferenceStore.getString(ClientTrustStorePreferencePage.TRUST_STORE_TYPE).isEmpty()){
			return false;
		}
		
			System.setProperty("javax.net.ssl.trustStore",
					preferenceStore.getString(ClientTrustStorePreferencePage.TRUST_STORE_LOCATION));
			System.setProperty("javax.net.ssl.trustStorePassword",
					preferenceStore.getString(ClientTrustStorePreferencePage.TRUST_STORE_PASSWORD));
			System.setProperty("javax.net.ssl.trustStoreType",
					preferenceStore.getString(ClientTrustStorePreferencePage.TRUST_STORE_TYPE));		
		return true;
		
		}catch(Exception e){
			IDeveloperStudioLog log = Logger.getLog(org.wso2.developerstudio.eclipse.platform.ui.Activator.PLUGIN_ID);
			log.error("Cannot load values from Eclipse perfernces to read JKS"+e.getMessage(), e);
		}
		
		return false;
	}

}

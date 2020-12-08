/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.wso2.developerstudio.eclipse.platform.ui.manager.EclipseSWTTrustManager;
import org.wso2.developerstudio.eclipse.platform.ui.startup.Initializer;

import java.util.Hashtable;

import javax.net.ssl.TrustManager;

public class Activator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.wso2.developerstudio.eclipse.platform.ui";

	private static Activator plugin;

	public Activator() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		Initializer.start();
		Hashtable<String, Integer> properties = new Hashtable<String, Integer>(7);
		properties.put(org.osgi.framework.Constants.SERVICE_RANKING, new Integer(Integer.MAX_VALUE));
		EclipseSWTTrustManager trustManager = new EclipseSWTTrustManager();
		EclipseSWTTrustManager.initiate();
		context.registerService(TrustManager.class.getName(), trustManager, properties);
		System.setProperty("osgi.signedcontent.trust.engine", "CECKeyStoreTrustEngine");
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static Activator getDefault() {
		return plugin;
	}

}

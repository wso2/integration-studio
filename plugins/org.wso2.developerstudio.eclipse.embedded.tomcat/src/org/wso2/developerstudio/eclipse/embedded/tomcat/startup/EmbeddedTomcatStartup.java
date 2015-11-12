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
package org.wso2.developerstudio.eclipse.embedded.tomcat.startup;

import org.eclipse.ui.IStartup;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.wso2.developerstudio.eclipse.embedded.tomcat.EmbeddedTomcatPlugin;
import org.wso2.developerstudio.eclipse.embedded.tomcat.Messages;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class EmbeddedTomcatStartup implements IStartup {

	private static IDeveloperStudioLog log = Logger.getLog(EmbeddedTomcatPlugin.PLUGIN_ID);

	@Override
	public void earlyStartup() {
		BundleContext context = EmbeddedTomcatPlugin.getContext();
		Bundle bundle = context.getBundle();
		if (bundle.getState() != Bundle.ACTIVE) {
			try {
				bundle.start();
			} catch (BundleException e) {
				log.error(Messages.ERROR_EARLY_STARTUP_ERROR, e);
			}
		}
	}
}

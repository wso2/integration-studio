/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.dashboard.handlers;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.IStartup;
import org.wso2.developerstudio.eclipse.carbonserver.base.util.ServerExtensionsRegistryUtils;
import org.wso2.developerstudio.eclipse.carbonserver40.register.product.servers.DynamicServer40ExtensionGenerator;
import org.wso2.developerstudio.eclipse.carbonserver42.register.product.servers.DynamicServer42ExtensionGenerator;
import org.wso2.developerstudio.eclipse.carbonserver44.register.product.servers.DynamicServer44ExtensionGenerator;
import org.wso2.developerstudio.eclipse.carbonserver44ei.register.product.servers.DynamicServer44eiExtensionGenerator;

/**
 * This is the early startup handler of the developer studio platform, all
 * methods that needs to run at eclipse startup should be implemented here and
 * called in early startup.
 *
 */
public class PlatformEarlyStartUpHandler implements IStartup {


	/**
	 * This method queries all servers registered for developer studio and
	 * register them to be available on eclipse default server option.
	 */
	private void registerProductServers() {
		ServerExtensionsRegistryUtils serverExtensionsRegistryUtils = new ServerExtensionsRegistryUtils();
		IConfigurationElement[] registeredServers = serverExtensionsRegistryUtils.retrieveRegisteredProductServers();

		DynamicServer44eiExtensionGenerator dynamicEIServerExtensionGenerator = new DynamicServer44eiExtensionGenerator();
		dynamicEIServerExtensionGenerator.readProductServerExtensions(registeredServers, serverExtensionsRegistryUtils);
		
		DynamicServer44ExtensionGenerator dynamicServerExtensionGenerator = new DynamicServer44ExtensionGenerator();
		dynamicServerExtensionGenerator.readProductServerExtensions(registeredServers, serverExtensionsRegistryUtils);
		DynamicServer42ExtensionGenerator dynamicServer42ExtensionGenerator = new DynamicServer42ExtensionGenerator();
		dynamicServer42ExtensionGenerator.readProductServerExtensions(registeredServers, serverExtensionsRegistryUtils);
		DynamicServer40ExtensionGenerator dynamicServer40ExtensionGenerator = new DynamicServer40ExtensionGenerator();
		dynamicServer40ExtensionGenerator.readProductServerExtensions(registeredServers, serverExtensionsRegistryUtils);
	}

	@Override
	public void earlyStartup() {
		registerProductServers();
	}

}

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

package org.wso2.integrationstudio.dashboard.handlers;

import org.eclipse.core.runtime.IConfigurationElement;

import org.eclipse.ui.IStartup;
import org.wso2.integrationstudio.carbonserver.base.util.ServerExtensionsRegistryUtils;
import org.wso2.integrationstudio.carbonserver40.register.product.servers.DynamicServer40ExtensionGenerator;
import org.wso2.integrationstudio.carbonserver42.register.product.servers.DynamicServer42ExtensionGenerator;
import org.wso2.integrationstudio.carbonserver44.register.product.servers.DynamicServer44ExtensionGenerator;
import org.wso2.integrationstudio.carbonserver44ei.register.product.servers.DynamicServer44eiExtensionGenerator;
import org.wso2.integrationstudio.carbonserver44microei.register.product.servers.DynamicServer44MicroeiExtensionGenerator;
import org.wso2.integrationstudio.carbonserver44microei45.register.product.servers.MicroIntegratorInstance;
import org.wso2.integrationstudio.carbonserver44microei45.register.product.servers.DynamicServer44Microei45ExtensionGenerator;
import org.wso2.integrationstudio.carbonserver44microei44.register.product.servers.DynamicServer44Microei44ExtensionGenerator;
import org.wso2.integrationstudio.carbonserver44microei43.register.product.servers.DynamicServer44Microei43ExtensionGenerator;
import org.wso2.integrationstudio.carbonserver44microei42.register.product.servers.DynamicServer44Microei42ExtensionGenerator;
import org.wso2.integrationstudio.carbonserver44microei41.register.product.servers.DynamicServer44Microei41ExtensionGenerator;
import org.wso2.integrationstudio.carbonserver44microei40.register.product.servers.DynamicServer44Microei40ExtensionGenerator;
import org.wso2.integrationstudio.carbonserver44microei12.register.product.servers.DynamicServer44Microei12ExtensionGenerator;
import org.wso2.integrationstudio.carbonserver44microei11.register.product.servers.DynamicServer44Microei11ExtensionGenerator;


/**
 * This is the early startup handler of the Integration Studio platform, all
 * methods that needs to run at eclipse startup should be implemented here and
 * called in early startup.
 *
 */
public class PlatformEarlyStartUpHandler implements IStartup {


	/**
	 * This method queries all servers registered for Integration Studio and
	 * register them to be available on eclipse default server option.
	 */
	private void registerProductServers() {
		ServerExtensionsRegistryUtils serverExtensionsRegistryUtils = new ServerExtensionsRegistryUtils();
		IConfigurationElement[] registeredServers = serverExtensionsRegistryUtils.retrieveRegisteredProductServers();

		DynamicServer44eiExtensionGenerator dynamicEIServerExtensionGenerator = new DynamicServer44eiExtensionGenerator();
		dynamicEIServerExtensionGenerator.readProductServerExtensions(registeredServers, serverExtensionsRegistryUtils);
		
		DynamicServer44MicroeiExtensionGenerator dynamicMicroEIServerExtensionGenerator = new DynamicServer44MicroeiExtensionGenerator();
		dynamicMicroEIServerExtensionGenerator.readProductServerExtensions(registeredServers, serverExtensionsRegistryUtils);

		DynamicServer44Microei11ExtensionGenerator dynamicMicroEI11ServerExtensionGenerator = new DynamicServer44Microei11ExtensionGenerator();
		dynamicMicroEI11ServerExtensionGenerator.readProductServerExtensions(registeredServers, serverExtensionsRegistryUtils);
		
		DynamicServer44Microei12ExtensionGenerator dynamicMicroEI12ServerExtensionGenerator = new DynamicServer44Microei12ExtensionGenerator();
        dynamicMicroEI12ServerExtensionGenerator.readProductServerExtensions(registeredServers,
                serverExtensionsRegistryUtils);

        DynamicServer44Microei40ExtensionGenerator dynamicMicroEI40ServerExtensionGenerator = new DynamicServer44Microei40ExtensionGenerator();
        dynamicMicroEI40ServerExtensionGenerator.readProductServerExtensions(registeredServers,
                serverExtensionsRegistryUtils);
        
        DynamicServer44Microei41ExtensionGenerator dynamicMicroEI41ServerExtensionGenerator = new DynamicServer44Microei41ExtensionGenerator();
        dynamicMicroEI41ServerExtensionGenerator.readProductServerExtensions(registeredServers,
                serverExtensionsRegistryUtils);

		DynamicServer44Microei42ExtensionGenerator dynamicMicroEI42ServerExtensionGenerator = new DynamicServer44Microei42ExtensionGenerator();
		dynamicMicroEI42ServerExtensionGenerator.readProductServerExtensions(registeredServers,
				serverExtensionsRegistryUtils);

		DynamicServer44Microei43ExtensionGenerator dynamicMicroEI43ServerExtensionGenerator = new DynamicServer44Microei43ExtensionGenerator();
		dynamicMicroEI43ServerExtensionGenerator.readProductServerExtensions(registeredServers,
				serverExtensionsRegistryUtils);		

		DynamicServer44Microei44ExtensionGenerator dynamicMicroEI44ServerExtensionGenerator = new DynamicServer44Microei44ExtensionGenerator();
		dynamicMicroEI44ServerExtensionGenerator.readProductServerExtensions(registeredServers,
				serverExtensionsRegistryUtils);		

		DynamicServer44Microei45ExtensionGenerator dynamicMicroEI45ServerExtensionGenerator = new DynamicServer44Microei45ExtensionGenerator();
		dynamicMicroEI45ServerExtensionGenerator.readProductServerExtensions(registeredServers,
				serverExtensionsRegistryUtils);			

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
		MicroIntegratorInstance.getInstance();
	}

}

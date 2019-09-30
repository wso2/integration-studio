/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.carbonserver44microei11.register.product.servers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

import org.wso2.developerstudio.eclipse.carbonserver.base.util.ServerExtensionsRegistryUtils;
import org.wso2.developerstudio.eclipse.carbonserver44microei11.Activator;
import org.eclipse.core.internal.registry.ExtensionRegistry;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.spi.RegistryContributor;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class DynamicServer44Microei11ExtensionGenerator {
	private static final String MASTER_TOKEN = "masterToken";
	private static final String SERVER_44ei_STREAM_LOC = "resources/streams/server44microei11.xml";
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String SERVER_VERSION_CARBON = "carbon.server.44microei11";
	private static final String SERVER_DISPLAY_NAME = "server.display.name";
	private static final String CARBON_SERVER_VERSION = "carbon.server.version";

	@SuppressWarnings("restriction")
	public void readProductServerExtensions(IConfigurationElement[] registeredServers,
			ServerExtensionsRegistryUtils serverExtensionsRegistryUtils) {
		for (IConfigurationElement elem : registeredServers) {
			String displayName = elem.getAttribute(SERVER_DISPLAY_NAME);
			String serverVersion = elem.getAttribute(CARBON_SERVER_VERSION);
			if (serverVersion != null && serverVersion.equals(SERVER_VERSION_CARBON)) {
				Plugin plugin = Activator.getDefault();
				Bundle bundle = plugin.getBundle();
				try {
					InputStream inputStream = serverExtensionsRegistryUtils.generateInputStream(displayName, bundle,
							SERVER_44ei_STREAM_LOC);
					String bundleIdStr = String.valueOf(bundle.getBundleId());
					String bundleName = bundle.getSymbolicName();
					IContributor contributor = new RegistryContributor(bundleIdStr, bundleName, null, null);
					ExtensionRegistry extensionRegistry = (ExtensionRegistry) Platform.getExtensionRegistry();

					Field declaredField = ExtensionRegistry.class.getDeclaredField(MASTER_TOKEN);
					declaredField.setAccessible(true);
					Object masterToken = declaredField.get(extensionRegistry);

					extensionRegistry.addContribution(inputStream, contributor, false, bundleName, null, masterToken);
				} catch (IOException | NoSuchFieldException | SecurityException | IllegalArgumentException 
						| IllegalAccessException e) {
					log.error("Invalid Product Server Type, not registered to generate Dyunamic extension Point");
				}
			}
		}
	}
}

/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.capp.registry.connector.utils;

import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.wso2.developerstudio.eclipse.capp.registry.connector.handler.RegistryHandler;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryHandler;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryRequester;


public class RegistryExtensionPointHandler {
	private static String REGISTRY_HANDLER_REQUESTER_EXTENSION="org.wso2.developerstudio.eclipse.capp.registry.connector";
	
	public static void setRegistryArtifactHandlers(List<IRegistryHandler> registryHandlers){
		registryHandlers.clear();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(REGISTRY_HANDLER_REQUESTER_EXTENSION);
		for (IConfigurationElement e : config) {		
			try {
				IRegistryRequester hadlerReq = (IRegistryRequester)e.createExecutableExtension("class");
				hadlerReq.setRegistryHandler(new RegistryHandler());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}

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

package org.wso2.developerstudio.eclipse.capp.core.artifacts.manager;

import org.wso2.developerstudio.eclipse.capp.core.model.ServerRole;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryHandler;

public class CAppEnvironment {
	private static ICAppArtifactManager cAppManager;
	private static ServerRole defaultServerRole=new ServerRole("Default","Default Server Role");
	private static IRegistryHandler registryHandler;
	public static void setcAppManager(ICAppArtifactManager cAppManager) {
	    CAppEnvironment.cAppManager = cAppManager;
    }

	public static ICAppArtifactManager getcAppManager() {
	    return cAppManager;
    }

	public static ServerRole getDefaultServerRole() {
	    return defaultServerRole;
    }

	public static void setRegistryHandler(IRegistryHandler registryHandler) {
	    CAppEnvironment.registryHandler = registryHandler;
    }

	public static IRegistryHandler getRegistryHandler() {
	    return registryHandler;
    }
	
	public static boolean isRegistryHandlerPresent(){
		return (getRegistryHandler()!=null);
	}
	
	public static IServerRole createServerRole(String serverRoleName,String serverRoleDescription){
		return new ServerRole(serverRoleName, serverRoleDescription);
	}
	
	public static IServerRole createServerRole(String serverRoleName){
		return createServerRole(serverRoleName,"");
	}

}

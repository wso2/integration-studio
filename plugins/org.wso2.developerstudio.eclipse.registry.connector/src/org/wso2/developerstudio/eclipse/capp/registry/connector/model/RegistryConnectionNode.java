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

package org.wso2.developerstudio.eclipse.capp.registry.connector.model;

import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryConnection;

public class RegistryConnectionNode {
	private IRegistryConnection registryConnection;
	private RegistryConnectionsNode parent;
	
	public RegistryConnectionNode(RegistryConnectionsNode registryConnections, IRegistryConnection registryConnection) {
		parent=registryConnections;
		setRegistryConnection(registryConnection);
    }

	public RegistryConnectionsNode getParentRegistryConnections(){
		return parent;
	}
		
	public String getCaption(){
		String caption;
		if (registryConnection.getUsername()==null || registryConnection.getUsername().equals("")){
			caption = registryConnection.getURL().toString();
		}else{
			caption = registryConnection.getUsername()+"@"+registryConnection.getURL().toString();
		}
		caption = registryConnection.getConnectionName()+" ("+caption+")";
		return caption;
	}

	public void setRegistryConnection(IRegistryConnection registryConnection) {
	    this.registryConnection = registryConnection;
    }

	public IRegistryConnection getRegistryConnection() {
	    return registryConnection;
    }
}

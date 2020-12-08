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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.wso2.developerstudio.eclipse.capp.registry.connector.utils.RegistryHandlerUtils;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryConnection;


public class RegistryConnectionsNode {
	private List<RegistryConnectionNode> registryConnections;
	private Map<String,RegistryConnectionNode> registryConnectionsMap; 
	private IProject project;
	private boolean refresh;
	
	public RegistryConnectionsNode(IProject project) {
	    setProject(project);
    }
	
	public void setRegistryConnections(List<RegistryConnectionNode> registryConnections) {
	    this.registryConnections = registryConnections;
    }

	public List<RegistryConnectionNode> getRegistryConnections() {
//		if (registryConnections==null){
////			List<RegistryConnectionNode> connections=new ArrayList<RegistryConnectionNode>();
////			registryConnections=connections;
			refreshRegistryConnections();
//		}
	    return registryConnections;
    }

	private void refreshRegistryConnections(){
		if (registryConnections==null){
			registryConnections=new ArrayList<RegistryConnectionNode>();
		}
		List<IRegistryConnection> connections = RegistryHandlerUtils.getRegistryConnections(getProject());
		ArrayList<String> checkList = new ArrayList<String>(getRegistryConnectionsMap().keySet());
		for (IRegistryConnection connection : connections) {
			if (!checkList.contains(connection.getId())){
				RegistryConnectionNode registryConnection = new RegistryConnectionNode(this,connection);
				addRegistryConnection(connection.getId(),registryConnection);
			}else{
				checkList.remove(connection.getId());
			}
        }
		for(String id:checkList){
			removeRegistryConnection(id);
		}
		setRefresh(false);
	}
	
	private void addRegistryConnection(String id,RegistryConnectionNode connectionNode){
		registryConnections.add(connectionNode);
		getRegistryConnectionsMap().put(id, connectionNode);
	}
	
	private void removeRegistryConnection(String id){
		registryConnections.remove(getRegistryConnectionsMap().get(id));
		getRegistryConnectionsMap().remove(id);
	}
	public void setProject(IProject project) {
	    this.project = project;
    }

	public IProject getProject() {
	    return project;
    }

	public void setRefresh(boolean refresh) {
	    this.refresh = refresh;
    }

	public boolean isRefresh() {
	    return refresh;
    }
	
	public String getCaption(){
		return "Registry Connections";
	}

	public void setRegistryConnectionsMap(Map<String,RegistryConnectionNode> registryConnectionsMap) {
	    this.registryConnectionsMap = registryConnectionsMap;
    }

	public Map<String,RegistryConnectionNode> getRegistryConnectionsMap() {
		if (registryConnectionsMap==null){
			registryConnectionsMap=new HashMap<String, RegistryConnectionNode>();
		}
	    return registryConnectionsMap;
    }
}

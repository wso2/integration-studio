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

package org.wso2.developerstudio.eclipse.registry.base.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryURLInfo;

public class RegistryURLNode extends Observable {

	private List<RegistryNode> urlInfoList;
	private boolean refreshExisting = false;

	public RegistryURLNode() {
	}

	/**
	 * get remote registry url info list
	 * @return
	 */
	public List<RegistryNode> getUrlInfoList() {
		if (urlInfoList == null) {
			urlInfoList = new ArrayList<RegistryNode>();
		}
		return urlInfoList;
	}

	/**
	 * remove remote registry url from the list
	 * @param registryNode
	 */
	public void removeRegistry(RegistryNode registryNode) {
		if (getUrlInfoList().contains(registryNode)) {
			getUrlInfoList().remove(registryNode);
			refreshViewer(false);
		}
	}

	/**
	 * set remote registry url info list
	 * @param urlInfoList
	 */
	public void setUrlInfoList(List<RegistryNode> urlInfoList) {
		this.urlInfoList = urlInfoList;
	}

	/**
	 * add registry node instance to registry tree view
	 * add new registry url to UrlInfoList
	 * @param registryUrlInfo
	 * @param pwd
	 * @return RegistryNode instance
	 */
	public RegistryNode addRegistry(RegistryURLInfo registryUrlInfo, String pwd) {
		boolean urlAvailable = false;
		RegistryNode regNode = new RegistryNode(registryUrlInfo, pwd, this);
		List<RegistryNode> availableURLInfoList = getUrlInfoList();
		for (RegistryNode registryNode : availableURLInfoList) {
			
			String regNodeUrl = registryNode.getUrl().toString().trim();
			if(!regNodeUrl.endsWith("/")){
				regNodeUrl = regNodeUrl.concat("/");
			}
			
			String registryUrlInfoString = registryUrlInfo.getUrl().toString().trim();
			if(!registryUrlInfoString.endsWith("/")){
				registryUrlInfoString=registryUrlInfoString.concat("/");
			}
			
			if(regNodeUrl.equalsIgnoreCase(registryUrlInfoString) &&
					registryNode.getRegistryStartingPath().equals(registryUrlInfo.getPath()) &&
					registryNode.getUsername().equals(registryUrlInfo.getUsername())){
				urlAvailable = true;
			}
		}
		if(!urlAvailable){
			availableURLInfoList.add(regNode);
		}
		refreshViewer(false);
		return regNode;
	}

	/**
	 * 
	 * @param refreshExisting
	 */
	public void refreshViewer(boolean refreshExisting) {
		this.refreshExisting = refreshExisting;
		setChanged();
		notifyObservers();
	}

	/**
	 * 
	 * @return
	 */
	public boolean isRefreshExisting() {
		return refreshExisting;
	}

	/**
	 * 
	 * @param viewingDataChanged
	 */
	public void dataChanged(boolean viewingDataChanged) {
		refreshViewer(viewingDataChanged);
	}
}

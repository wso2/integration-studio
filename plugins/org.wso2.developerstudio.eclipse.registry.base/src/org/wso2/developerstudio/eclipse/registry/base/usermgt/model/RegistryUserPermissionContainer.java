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

package org.wso2.developerstudio.eclipse.registry.base.usermgt.model;

import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class RegistryUserPermissionContainer extends Observable{
		
	private List<RegistryResourceNode> registryContent;
	private boolean iterativeRefresh = false;

	public List<RegistryResourceNode> getRegistryContent() {
		if (registryContent == null)
			registryContent = new ArrayList<RegistryResourceNode>();
		return registryContent;
	}

	public String toString() {
		return getCaption();
	}

	public void addRegistryContent(RegistryResourceNode resourceContent) {
		getRegistryContent().add(resourceContent);
	}

	public String getCaption() {
		return "Repository";
	}

	public void setIterativeRefresh(boolean iterativeRefresh) {
		this.iterativeRefresh = iterativeRefresh;
		if (iterativeRefresh) {
			for (RegistryResourceNode r : getRegistryContent()) {
				r.setIterativeRefresh(true);
			}
		}
	}

	public boolean isIterativeRefresh() {
		return iterativeRefresh;
	}

}

/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.endpoint.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEndpointProvider;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEsbEndpoint;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioElement;
import org.wso2.developerstudio.eclipse.platform.core.utils.ResourceManager;

public class EndpointProvider implements IEndpointProvider {
	private List<IEndpointProvider> subProviders;
	
	public EndpointProvider() {
	}

	public IEndpointProvider[] getCategories(Map<String, List<String>> filters) {
		if (subProviders==null){
			subProviders=new ArrayList<IEndpointProvider>();
			IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
			try {
	            for (IProject project : projects) {
	            	if (project.isOpen() &&
	            		    project.hasNature("org.wso2.developerstudio.eclipse.esb.project.nature")){
	            		ProjectEndpointProvider projectEndpointProvider = new ProjectEndpointProvider(project);
	            		IEsbEndpoint[] endpoints = projectEndpointProvider.getEndpoints(filters);
	            		if (endpoints!=null && endpoints.length>0){
	            			subProviders.add(projectEndpointProvider);
	            		}
	            	}
	            }
            } catch (Exception ignored) {
				// ignored
			}
		}
		return subProviders.toArray(new IEndpointProvider[]{});
	}

	public IEsbEndpoint[] getEndpoints(Map<String, List<String>> filters) {
		return null;
	}

	public ImageDescriptor getIcon() {
		return ResourceManager.getImageDescriptor(this.getClass(),
        "/icons/application-registry-resource-icon.png");
	}

	public String getId() {
		return null;
	}

	public String getText() {
		return null;
	}

	public void refresh() {
		subProviders=null;
	}

	public IDeveloperStudioElement[] getElements(Map<String, List<String>> filters) {
		return getEndpoints(filters);
	}

}

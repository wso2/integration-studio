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

package org.wso2.developerstudio.eclipse.artifact.sequence.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEsbSequence;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.ISequenceProvider;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioElement;
import org.wso2.developerstudio.eclipse.platform.core.utils.ResourceManager;

public class SequenceProvider implements ISequenceProvider {
	private List<ISequenceProvider> subProviders;
	
	public SequenceProvider() {
	}

	public ISequenceProvider[] getCategories(Map<String, List<String>> filters) {
		if (subProviders==null){
			subProviders=new ArrayList<ISequenceProvider>();
			IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
			for (IProject project : projects) {
				try {
	                if (project.isOpen() &&
	                	    project.hasNature("org.wso2.developerstudio.eclipse.esb.project.nature")){
	                	ProjectSequenceProvider projectSequenceProvider = new ProjectSequenceProvider(project);
	                	IEsbSequence[] sequences = projectSequenceProvider.getSequences(filters);
	                	if (sequences!=null && sequences.length>0){
	                		subProviders.add(projectSequenceProvider);
	                	}
	                }
                } catch (Exception ignored) {
					// ignored
				}
			}
		}
		return subProviders.toArray(new ISequenceProvider[]{});
	}

	public IEsbSequence[] getSequences(Map<String, List<String>> filters) {
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
		return getSequences(filters);
	}

}

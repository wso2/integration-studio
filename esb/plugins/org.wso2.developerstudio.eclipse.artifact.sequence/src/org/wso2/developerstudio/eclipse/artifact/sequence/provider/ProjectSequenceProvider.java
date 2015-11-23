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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.wso2.developerstudio.eclipse.esb.core.configuration.impl.EsbSequenceImpl;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEsbSequence;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.ISequenceProvider;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioElement;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;
import org.wso2.developerstudio.eclipse.platform.core.utils.ResourceManager;

public class ProjectSequenceProvider implements ISequenceProvider {
	private IProject project;

	public ProjectSequenceProvider(IProject project) {
		setProject(project);
	}
	
	public ISequenceProvider[] getCategories(Map<String, List<String>> filters) {
		return null;
	}

	public IEsbSequence[] getSequences(Map<String, List<String>> filters) {
		if (project.isOpen()){
			List<IEsbSequence> sequences=new ArrayList<IEsbSequence>();
			ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
			try {
				esbProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());
				List<ESBArtifact> artifacts = esbProjectArtifact.getAllESBArtifacts();
				for (ESBArtifact artifact : artifacts) {
					if (artifact.getType().equals("synapse/sequence")) {
						IFile file = project.getFile(new Path(artifact.getFile()));
						boolean mediaTypeFilterPassed = DeveloperStudioProviderUtils.isMediaTypeFilterPassed(filters, file);
						if (mediaTypeFilterPassed) {
							EsbSequenceImpl esbSequence = new EsbSequenceImpl();
							esbSequence.setName(artifact.getName());
							esbSequence.setSource(file);
							esbSequence.setIcon(ResourceManager.getImageDescriptor(this.getClass(),
							                                                         "/icons/EsbModelFile.png"));
							sequences.add(esbSequence);
						}
					}
				}
			} catch (Exception ignored) {
				// ignored
			}
			return sequences.toArray(new IEsbSequence[]{});
		}
		return null;
	}

	public ImageDescriptor getIcon() {
		return ResourceManager.getImageDescriptor(this.getClass(), "/icons/projects.gif");
	}

	public String getId() {
		return null;
	}

	public String getText() {
		return project.getName();
	}

	public void refresh() {

	}

	public void setProject(IProject project) {
		this.project = project;
	}

	public IProject getProject() {
		return project;
	}

	public IDeveloperStudioElement[] getElements(Map<String, List<String>> filters) {
		return getSequences(filters);
	}


}

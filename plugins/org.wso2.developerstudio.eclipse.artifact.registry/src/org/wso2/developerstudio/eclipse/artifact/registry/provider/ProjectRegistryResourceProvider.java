/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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


package org.wso2.developerstudio.eclipse.artifact.registry.provider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryResource;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryResourceProvider;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioElement;
import org.wso2.developerstudio.eclipse.platform.core.utils.ResourceManager;

public class ProjectRegistryResourceProvider implements IRegistryResourceProvider{
	private IProject project;
	List<IRegistryResourceProvider> subProviders;

	public ProjectRegistryResourceProvider(IProject project) {
		setProject(project);
	}
	
	public IRegistryResourceProvider[] getCategories(Map<String, List<String>> filters) {
		if (project.isOpen()){
			if (subProviders==null){
				retrieveRegistryResources(filters);
			}
			return subProviders.toArray(new IRegistryResourceProvider[]{});
		}
		return null;
	}

	private void retrieveRegistryResources(Map<String, List<String>> filters) throws FactoryConfigurationError {
		subProviders=new ArrayList<IRegistryResourceProvider>();
		IFile artifactXMLFile = project.getFile("artifact.xml");
		if (artifactXMLFile.exists()) {
				try {
						XMLStreamReader parser = XMLInputFactory.newInstance()
								.createXMLStreamReader(artifactXMLFile.getContents());
						StAXOMBuilder builder = new StAXOMBuilder(parser);
						OMElement documentElement = builder.getDocumentElement();
						Iterator artifacts = documentElement.getChildren();
						while (artifacts.hasNext()) {
							Object o = artifacts.next();
							if (o instanceof OMElement) {
								OMElement artifact = (OMElement) o;
								if ("artifact".equals(artifact.getLocalName())) {
									ArtifactRegistryResourceProvider artifactResourceProvider = new ArtifactRegistryResourceProvider(getProject(),artifact);
									IRegistryResource[] resources = artifactResourceProvider.getResources(filters);
									if (resources.length>0){
										subProviders.add(artifactResourceProvider);
									}
								}
							}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		}
	}
	
	public ImageDescriptor getIcon() {
		return ResourceManager.getImageDescriptor(this.getClass(),"/icons/projects.gif");
	}

	public String getId() {
		return "project";
	}

	public IRegistryResource[] getResources(Map<String, List<String>> filters) {
		return null;
	}

	public String getText() {
		return getProject().getName();
	}
	public void setProject(IProject project) {
		this.project = project;
	}
	public IProject getProject() {
		return project;
	}

	public void refresh() {
		subProviders=null;
	}

	public IDeveloperStudioElement[] getElements(Map<String, List<String>> filters) {
		return getResources(filters);
	}

}

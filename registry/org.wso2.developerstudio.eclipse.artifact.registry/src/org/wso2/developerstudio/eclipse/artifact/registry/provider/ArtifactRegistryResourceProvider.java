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

import javax.xml.namespace.QName;
import javax.xml.stream.FactoryConfigurationError;

import org.apache.axiom.om.OMElement;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.resource.ImageDescriptor;

import org.wso2.developerstudio.eclipse.registry.core.RegistryManager;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryCollection;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryFile;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryResource;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryResourceProvider;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.RegistryCollectionImpl;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.RegistryFileImpl;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.RegistryResourceImpl;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioElement;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;
import org.wso2.developerstudio.eclipse.platform.core.utils.ResourceManager;

public class ArtifactRegistryResourceProvider implements IRegistryResourceProvider{
	private OMElement artifact;
	private List<IRegistryResource> resources;
	private IProject project;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String name;
	private String version; 
	private String type;

	public IProject getProject() {
		return project;
	}

	public void setProject(IProject project) {
		this.project = project;
	}

	public ArtifactRegistryResourceProvider(IProject project,OMElement artifact) {
		setArtifact(artifact);
		setProject(project);
		setName(artifact.getAttributeValue(new QName("name")));
		setVersion(artifact.getAttributeValue(new QName("version")));
		setType(artifact.getAttributeValue(new QName("type")));
	}
	
	public IRegistryResourceProvider[] getCategories(Map<String, List<String>> filters) {
		return null;
	}

	public ImageDescriptor getIcon() {
		return ResourceManager.getImageDescriptor(this.getClass(),"/icons/icon-artifact.png");
	}

	public String getId() {
		return null;
	}

	public IRegistryResource[] getResources(Map<String, List<String>> filters) {
		if (resources==null){
			scanAndCollectResources(filters);
		}
		return resources.toArray(new IRegistryResource[]{});
	}

	public String getText() {
		return getName();
	}

	public void setArtifact(OMElement artifact) {
		this.artifact = artifact;
	}

	public OMElement getArtifact() {
		return artifact;
	}

	private void scanAndCollectResources(Map<String, List<String>> filters) throws FactoryConfigurationError {
		resources=new ArrayList<IRegistryResource>();
		List<IRegistryFile> childrenFiles = new ArrayList<IRegistryFile>();
		List<IRegistryCollection> childrenCollections = new ArrayList<IRegistryCollection>();
		if ("registry/resource".equals(getType())) {
		Iterator items = artifact.getChildren();
		while (items.hasNext()) {
			Object obj = items.next();
			if (obj instanceof OMElement) {
				OMElement item = (OMElement) obj;
				RegistryResourceImpl registryResourceImpl;
				if ("item".equals(item.getLocalName())) {
					String fileName = item.getFirstChildWithName(new QName("file")).getText();
					IFile file = project.getFile(fileName);
					String path = item.getFirstChildWithName(new QName("path")).getText();
					
					registryResourceImpl = new RegistryFileImpl(null);
					IFile registryResource = getProject().getFile(fileName);
					boolean passed = RegistryManager.isMediaTypeFilterPassed(filters,
							registryResource);
					if (!passed){
						continue;
					}
					passed = DeveloperStudioProviderUtils.isInProjectFilterPassed(filters,
							registryResource);
					if (!passed){
						continue;
					}
					registryResourceImpl.setSource(registryResource);
					if(file.exists()){
						registryResourceImpl.setPath(path,file.getName());
					}else{
						registryResourceImpl.setPath(path,fileName);
					}
					childrenFiles.add((IRegistryFile)registryResourceImpl);
					registryResourceImpl.setName(fileName);
					
				} else if("collection".equals(item.getLocalName())){
					String fileName = item.getFirstChildWithName(new QName("directory")).getText();
					String path = item.getFirstChildWithName(new QName("path")).getText();
					
					registryResourceImpl = new RegistryCollectionImpl(null);
					IFolder registryResource = getProject().getFolder(fileName);
					registryResourceImpl.setSource(registryResource);
					boolean passed = DeveloperStudioProviderUtils.isInProjectFilterPassed(filters,
							registryResource);
					if (!passed){
						continue;
					}
					registryResourceImpl.setPath(path);
				
					if (registryResourceImpl.hasChildren(filters)) {
						childrenCollections
								.add((IRegistryCollection) registryResourceImpl);
					}
					registryResourceImpl.setName(fileName);
				}
			}
		}
		resources.addAll(childrenCollections);
		resources.addAll(childrenFiles);
	}
	}

	
	public void refresh() {
		resources=null;
	}

	public IDeveloperStudioElement[] getElements(Map<String, List<String>> filters) {
		return getResources(filters);
	}

}

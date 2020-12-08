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

package org.wso2.developerstudio.eclipse.registry.base.editor.input;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceType;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.ImageUtils;

public class ResourceEditorInput implements IEditorInput {
	private RegistryResourceNode parentResource;
	private RegistryResourceNode resource;
	private boolean validCollection;

	/**
	 * check whether the given resource is a collection
	 * @return
	 */
	public boolean isCollection() {
		return getResource() == null ? validCollection : 
								(getResource().getResourceType()==RegistryResourceType.COLLECTION);
	}
	
	/**
	 * check whether the selected item is a resource
	 * @return
	 */
	public boolean isResource() {
		return !isCollection();
	}

	/**
	 * 
	 * @param isCollection
	 */
	public void setCollection(boolean isCollection) {
		this.validCollection = isCollection;
	}

	public boolean exists() {
		return true;
	}

	/**
	 * get the image descriptor for the image of the action "add folder"
	 */
	public ImageDescriptor getImageDescriptor() {
		return ImageUtils.getImageDescriptor(ImageUtils.ACTION_ADD_FOLDER);
	}

	/**
	 * get the path of the resource. If the resource is null, get the path of the parent resource
	 */
	public String getName() {
		return (getResource() == null ? getParentResource().getRegistryResourcePath() : 
								        getResource().getRegistryResourcePath());
	}

	public IPersistableElement getPersistable() {
		return null;
	}

	/**
	 * Get the tooltip text
	 */
	public String getToolTipText() {
		return "New Collection";
	}

	public Object getAdapter(Class arg0) {
		return null;
	}

	/**
	 * set the parent resource
	 * @param parentResource
	 */
	public void setParentResource(RegistryResourceNode parentResource) {
		this.parentResource = parentResource;
	}

	/**
	 * get the parent resource
	 * @return
	 */
	public RegistryResourceNode getParentResource() {
		return (parentResource == null ? resource.getRegistryResourceNodeParent() : 
										 parentResource);
	}

	/**
	 * set the resource
	 * @param resource
	 */
	public void setResource(RegistryResourceNode resource) {
		this.resource = resource;
	}

	/**
	 * get the resource
	 * @return
	 */
	public RegistryResourceNode getResource() {
		return resource;
	}

}

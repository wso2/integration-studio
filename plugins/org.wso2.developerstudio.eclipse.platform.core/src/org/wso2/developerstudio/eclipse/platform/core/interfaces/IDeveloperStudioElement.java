/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.core.interfaces;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;

public interface IDeveloperStudioElement {

	/**
	 * Get the id for this element
	 * 
	 * @return
	 */
	public String getId();

	/**
	 * Get the name of this element
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * List displayable name
	 * 
	 * @return
	 */
	public String getText();

	/**
	 * Returns an IProject, IFolder, IFile, File or any other object
	 * representing physical resource
	 * 
	 * @return
	 */
	public Object getSource();

	/**
	 * Returns if the element needs to show its children
	 * 
	 * @return
	 */
	public boolean hasChildren(Map<String, List<String>> filters);

	/**
	 * Return the children list for this element
	 * 
	 * @return
	 */
	public Object[] getChildren(Map<String, List<String>> filters);

	/**
	 * Get icon for this resource
	 * 
	 * @return
	 */
	public ImageDescriptor getIcon();

	/**
	 * Returns the string which represents the element in the server environment
	 * 
	 * @return
	 */
	public String getKey();
}

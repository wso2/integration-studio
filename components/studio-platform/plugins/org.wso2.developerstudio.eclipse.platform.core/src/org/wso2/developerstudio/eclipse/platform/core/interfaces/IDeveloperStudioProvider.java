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

public interface IDeveloperStudioProvider {
	/**
	 * Get a unique id for this provider
	 * 
	 * @return
	 */
	public String getId();

	/**
	 * Get the display caption of this provider
	 * 
	 * @return
	 */
	public String getText();

	/**
	 * Get an image descriptor to represent an Icon for this provider
	 * 
	 * @return
	 */
	public ImageDescriptor getIcon();

	/**
	 * Get a sublist of providers for this provider
	 * 
	 * @return
	 */
	public IDeveloperStudioProvider[] getCategories(Map<String, List<String>> filters);

	/**
	 * Retrieves the elements provided by this provider
	 * 
	 * @return
	 */
	public IDeveloperStudioElement[] getElements(Map<String, List<String>> filters);

	/**
	 * Refresh if the lists are cached
	 */
	public void refresh();

}

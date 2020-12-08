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

package org.wso2.developerstudio.eclipse.utils.ui;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.osgi.framework.Bundle;

public abstract class ImageUtils {

	private Map<String, ImageDescriptor> ICONS;
	/**
	 * create ImageDescriptor 
	 * @param imgName
	 * @return
	 */
	private ImageDescriptor createImageDescriptor(String imgName) {
		if (imgName == null)
			return null;
		ImageDescriptor imageDescriptor = null;
		IPath path = new Path(getImageDirectoryName() + imgName);
		
		URL gifImageURL = FileLocator.find(getBundle(), path, null);
		if (gifImageURL != null){
			imageDescriptor = ImageDescriptor.createFromURL(gifImageURL);
		}
		return imageDescriptor;
	}

	protected String getImageDirectoryName() {
		return "icons/";
	}

	/**
	 * get image descriptor
	 * @param key
	 * @return
	 */
	public ImageDescriptor getImageDescriptor(String key) {
		if (ICONS == null) {
			ICONS = new HashMap<String, ImageDescriptor>();
		}
		if (!ICONS.containsKey(key)){
			ICONS.put(key, createImageDescriptor(key));
		}
		return ICONS.get(key);
	}
	
	public abstract Bundle getBundle();
	
}

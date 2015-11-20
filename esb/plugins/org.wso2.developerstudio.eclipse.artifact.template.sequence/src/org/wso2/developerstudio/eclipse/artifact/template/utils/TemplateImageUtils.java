/*
 * Copyright (c) 2011-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.artifact.template.utils;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.artifact.template.Activator;
import org.wso2.developerstudio.eclipse.utils.ui.ImageUtils;

public class TemplateImageUtils extends ImageUtils {

	private static ImageUtils instance;

	/**
	 * Returns an instance of TemplateImageUtils class
	 */
	public static ImageUtils getInstance() {
		if (instance == null) {
			instance = new TemplateImageUtils();
		}
		return instance;
	}

	/**
	 * Returns an instance of Bundle class for this module
	 */
	public Bundle getBundle() {
		return Platform.getBundle(Activator.PLUGIN_ID);
	}
}
 

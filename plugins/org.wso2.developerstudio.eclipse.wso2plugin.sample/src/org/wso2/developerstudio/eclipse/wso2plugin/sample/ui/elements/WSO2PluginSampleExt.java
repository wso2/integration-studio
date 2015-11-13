/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.wso2plugin.sample.ui.elements;

import org.eclipse.swt.graphics.Image;

/*
 * This is a WSO2 Plugin Element of which, the parameters should be defined when
 * a sample is added via the
 * provided extension point to the developer studio plugin samples.
 */
public class WSO2PluginSampleExt {

	String pluginName;
	String pluginDescription;
	String pluginArchive;
	String bundleID;
	Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public WSO2PluginSampleExt(String pluginName, String pluginArchive, String description,
	                           String pluginBundleID, Image image) {
		super();
		this.pluginName = pluginName;
		this.pluginArchive = pluginArchive;
		this.pluginDescription = description;
		this.bundleID = pluginBundleID;
		this.image = image;
	}

	public String getBundleID() {
		return bundleID;
	}

	public void setBundleID(String bundleID) {
		this.bundleID = bundleID;
	}

	@Override
	public String toString() {
		return pluginName;
	}

	public String getPluginDescription() {
		return pluginDescription;
	}

	public void setPluginDescription(String pluginDescription) {
		this.pluginDescription = pluginDescription;
	}

	public String getPluginName() {
		return pluginName;
	}

	public void setPluginName(String pluginName) {
		this.pluginName = pluginName;
	}

	public String getPluginArchive() {
		return pluginArchive;
	}

	public void setPluginArchive(String pluginArchive) {
		this.pluginArchive = pluginArchive;
	}
}

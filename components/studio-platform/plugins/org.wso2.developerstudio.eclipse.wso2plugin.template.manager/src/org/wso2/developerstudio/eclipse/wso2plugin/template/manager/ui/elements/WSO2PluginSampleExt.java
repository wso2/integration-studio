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
package org.wso2.developerstudio.eclipse.wso2plugin.template.manager.ui.elements;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.ui.wizard.WSO2PluginListSelectionPage;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.util.AbstractDefaultProjectTemplateManager;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.util.WSO2PluginConstants;

import com.google.gson.annotations.SerializedName;

/*
 * This is a WSO2 Plugin Element of which, the parameters should be defined when
 * a sample is added via the
 * provided extension point to the developer studio plugin samples.
 */
public class WSO2PluginSampleExt {

	@SerializedName("pluginName")
	String pluginName;

	@SerializedName("pluginDescription")
	String pluginDescription;

	@SerializedName("pluginArchive")
	String pluginArchive;

	String bundleID;

	Image image;

	@SerializedName("iconLoc")
	String iconLoc;

	@SerializedName("isUpdatedFromGit")
	String isUpdatedFromGit;
	
	@SerializedName("class")
	AbstractDefaultProjectTemplateManager projectTemplatemanager;

	public AbstractDefaultProjectTemplateManager getProjectTemplatemanager() {
		return projectTemplatemanager;
	}

	public void setProjectTemplatemanager(AbstractDefaultProjectTemplateManager projectTemplatemanager) {
		this.projectTemplatemanager = projectTemplatemanager;
	}

	@SerializedName("id")
	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsUpdatedFromGit() {
		return isUpdatedFromGit;
	}

	public void setIsUpdatedFromGit(String isUpdatedFromGit) {
		this.isUpdatedFromGit = isUpdatedFromGit;
	}

	public String getIconLoc() {
		return iconLoc;
	}

	public void setIconLoc(String iconLoc) {
		this.iconLoc = iconLoc;
	}

	public WSO2PluginSampleExt(String pluginName, String pluginArchive, String description, String pluginBundleID,
	                           String iconLoc, String isPluginUpdatedFromGit, String pluginId, AbstractDefaultProjectTemplateManager projectTempManager) {
		super();
		this.pluginName = pluginName;
		this.pluginArchive = pluginArchive;
		this.pluginDescription = description;
		this.bundleID = pluginBundleID;
		this.iconLoc = iconLoc;
		this.isUpdatedFromGit = isPluginUpdatedFromGit;
		this.id = pluginId;
		this.projectTemplatemanager = projectTempManager;
	}

	public Image getImage(String iconLocation, String id, String isFromGit) {
		ImageDescriptor imageDescriptor = null;
		if (!Boolean.parseBoolean(isFromGit)) {
			if (iconLocation != null && !iconLocation.isEmpty()) {
				imageDescriptor =
				                  ImageDescriptor.createFromURL(FileLocator.find(Platform.getBundle(bundleID),
				                                                                 new Path(iconLocation), null));
			} else {
				imageDescriptor =
				                  ImageDescriptor.createFromURL(FileLocator.find(Platform.getBundle(Activator.PLUGIN_ID),
				                                                                 new Path("icons/plugin-icon.png"),
				                                                                 null));
			}
			return imageDescriptor.createImage();
		} else {
			try {
				String gitIconLoc =
				                    WSO2PluginListSelectionPage.tempCloneDir + File.separator + id + File.separator +
				                            "icons" + File.separator + iconLocation;
				imageDescriptor =
				                  ImageDescriptor.createFromURL(new URL(WSO2PluginConstants.FILE_PROTOCOL + gitIconLoc));
				return imageDescriptor.createImage();
			} catch (MalformedURLException e) {
				// log image cannot be found at location
				return null;
			}
		}
	}

	public void setImage(Image image) {
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

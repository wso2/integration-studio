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

package org.wso2.developerstudio.eclipse.platform.core.templates;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class ArtifactTemplate {

	private String name;
	private String id;
	private String templateFileName;
	private Bundle templateBundle;
	private String mediaType;
	private String defaultExtension;
	private boolean custom;

	public ArtifactTemplate(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTemplateBundle(Bundle templateBundle) {
		this.templateBundle = templateBundle;
	}

	public Bundle getTemplateBundle() {
		return templateBundle;
	}

	public void setTemplateFileName(String templateFileName) {
		this.templateFileName = templateFileName;
	}

	public String getTemplateFileName() {
		return templateFileName;
	}

	public InputStream getTemplateDataStream() throws IOException {
		URL resource = getTemplateUrl();
		return resource.openStream();
	}

	public URL getTemplateUrl() {
		return getTemplateBundle().getResource(getTemplateFileName());
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setDefaultExtension(String defaultExtension) {
		this.defaultExtension = defaultExtension;
	}

	public String getDefaultExtension() {
		if (defaultExtension == null) {
			String[] filenamePath = getTemplateFileName().split("/");
			if (filenamePath == null || filenamePath.length < 2) {
				defaultExtension = FileUtils.getResourceFileNameExtension(getTemplateFileName());
			} else {
				defaultExtension = FileUtils.getResourceFileNameExtension(filenamePath[filenamePath.length - 1]);
			}
		}
		return defaultExtension;
	}

	public void setCustom(boolean custom) {
		this.custom = custom;
	}

	public boolean isCustom() {
		return custom;
	}

}

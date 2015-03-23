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

package org.wso2.maven.core.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public abstract class TemplateUtil {
	public String getResourceString(String filename) throws IOException{
		if (filename == null)
			return null;
		if (!filename.startsWith("/")){
			filename="/"+filename;
		}
		URL fileURL = getResourceURL(filename);
		return FileUtils.getContentAsString(fileURL);
	}

	public URL getResourceURL(String filename){
		return getTemplateClass().getResource(filename);
	}
	
	public File getResourceFile(String filename) throws IOException{
		URL resourceURL = getResourceURL(filename);
		File destinationFile=FileUtils.createTempFile();
		FileUtils.createFile(destinationFile, resourceURL.openStream());
		return destinationFile;
	}
	
	protected abstract Class<?> getTemplateClass();
}

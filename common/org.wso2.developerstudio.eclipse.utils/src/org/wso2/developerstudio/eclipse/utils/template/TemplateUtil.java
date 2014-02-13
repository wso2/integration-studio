/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.utils.template;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public abstract class TemplateUtil {
	public String getTemplateString(String filename) throws IOException {
		if (filename == null)
			return null;
		URL fileURL = getResourceURL("templates/"+filename);
		if(fileURL != null){
			return FileUtils.getContentAsString(fileURL);
		}else{
			return null;
		}
	}

	public URL getResourceURL(String filename) {
		return FileLocator.find(getBundle(), new Path(filename), null);
	}
	
	public URL getResourceURL(IPath path) {
		return FileLocator.find(getBundle(), path, null);
	}

	public File getResourceFile(String filename) throws IOException {
		URL resourceURL = getResourceURL(filename);
		File destinationFile = FileUtils.createTempFile();
		FileUtils.createFile(destinationFile, resourceURL.openStream());
		return destinationFile;
	}

	protected abstract Bundle getBundle();
}

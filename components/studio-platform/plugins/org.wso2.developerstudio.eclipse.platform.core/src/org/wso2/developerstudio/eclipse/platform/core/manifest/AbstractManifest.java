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

package org.wso2.developerstudio.eclipse.platform.core.manifest;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.Activator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

public abstract class AbstractManifest extends Observable {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public File toFile() throws Exception {
		try {
			File tmpFolder = FileUtils.createTempDirectory();
			return toFile(new File(tmpFolder, getDefaultName()));
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	public File toFile(File manifestFile) throws IOException {
		if (manifestFile.exists()) {
			manifestFile.delete();
		}
		FileUtils.createFile(manifestFile, toString());
		return manifestFile;
	}

	public IFile toFile(IFile file) throws CoreException {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(toString().getBytes());
		if (!file.exists()) {
			file.create(inputStream, IFile.FORCE, null);
		} else {
			file.setContents(inputStream, IFile.FORCE, null);
		}
		return file;
	}

	protected abstract String getDefaultName();
}

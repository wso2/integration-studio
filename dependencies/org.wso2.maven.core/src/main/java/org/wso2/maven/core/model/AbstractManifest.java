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

package org.wso2.maven.core.model;

import java.io.File;
import java.io.IOException;
import java.util.Observable;

import org.wso2.developerstudio.eclipse.utils.file.FileUtils;


public abstract class AbstractManifest extends Observable {

	public File toFile() throws Exception {
		try {
	        File tmpFolder = FileUtils.createTempDirectory();
	        return toFile(new File(tmpFolder,getDefaultName()));
        } catch (IOException e) {
	        throw e;
        }
    }

	public File toFile(File manifestFile) throws IOException {
		if (manifestFile.exists()){
			manifestFile.delete();
		}
	    FileUtils.createFile(manifestFile, toString());
	    return manifestFile;
    }
	
	protected abstract String getDefaultName();
}

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

public class SimpleJarManifest extends AbstractManifest {
	private String manifestVersion = "1.0";

	public String toString() {
		String manifest;
		manifest = appendLine(null, getManifestHeaderLine("Manifest-Version", getManifestVersion()));
		manifest = appendLine(manifest, "\n\n");
		return manifest;
	}

	protected String getDefaultName() {
		return "MANIFEST.MF";
	}

	protected String getManifestVersion() {
		return manifestVersion;
	}

	protected String getManifestHeaderLine(String name, String value) {
		return name + ": " + value;
	}

	protected String appendLine(String currentStr, String appendStr) {
		if (currentStr == null) {
			return appendStr;
		} else {
			return currentStr + "\n" + appendStr;
		}
	}

}

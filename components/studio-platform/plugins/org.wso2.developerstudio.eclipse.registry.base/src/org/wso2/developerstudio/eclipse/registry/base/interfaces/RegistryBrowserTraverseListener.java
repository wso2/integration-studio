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

package org.wso2.developerstudio.eclipse.registry.base.interfaces;

import java.util.Observable;

public class RegistryBrowserTraverseListener extends Observable {
	private String url;
	private String path;

	public void setData(String url, String path) {
		this.setUrl(url);
		this.setPath(path);
		setChanged();
		notifyObservers();
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}

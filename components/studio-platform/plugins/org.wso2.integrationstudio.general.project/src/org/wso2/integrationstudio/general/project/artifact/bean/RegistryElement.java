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

package org.wso2.integrationstudio.general.project.artifact.bean;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class RegistryElement {

	protected String path;
	private Map<String, String> properties = new HashMap<>();


	public void setPath(String path) {
	    this.path = path;
    }

	public String getPath() {
	    return path;
    }
	
	public Map<String, String> getProperties() {
        return Collections.unmodifiableMap(properties);
    }

    public void setProperties(Map<String, String> properties) {
        if (properties == null) {
            this.properties = new HashMap<>();
        } else {
            this.properties = properties;
        }
    }

    public void addProperty(String key, String value) {
        this.properties.put(key, value);
    }

    public void removeProperty(String key) {
        this.properties.remove(key);
    }
}

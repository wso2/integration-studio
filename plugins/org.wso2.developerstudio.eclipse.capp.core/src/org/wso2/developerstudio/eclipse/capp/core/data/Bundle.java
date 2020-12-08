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

package org.wso2.developerstudio.eclipse.capp.core.data;

public class Bundle {
	private String name;
	private String version;
	private boolean unpack;
	private String description;
	private String exportedPackegesList;
	
	public String getName() {
    	return name;
    }
	public void setName(String name) {
    	this.name = name;
    }
	public String getVersion() {
    	return version;
    }
	public void setVersion(String version) {
    	this.version = version;
    }
	public boolean isUnpack() {
    	return unpack;
    }
	public void setUnpack(boolean unpack) {
    	this.unpack = unpack;
    }
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExportedPackegesList() {
		return exportedPackegesList;
	}
	public void setExportedPackegesList(String exportedPackegesList) {
		this.exportedPackegesList = exportedPackegesList;
	}
}

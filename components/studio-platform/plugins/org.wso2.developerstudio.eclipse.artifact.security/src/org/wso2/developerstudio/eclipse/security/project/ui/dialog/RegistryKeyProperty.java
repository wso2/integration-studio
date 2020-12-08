/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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


package org.wso2.developerstudio.eclipse.security.project.ui.dialog;

import java.util.HashMap;
import java.util.Map;

import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryData;

public class RegistryKeyProperty {
	
	private String keyName;
	private String keyValue;
	private String prettyName;
	private IRegistryData registryData;
	private Map<String, String> filters;
	private String policyFileName;
	private String tempPolicyFilePath;

	public String getPolicyFileName() {
		return policyFileName;
	}

	public void setPolicyFileName(String policyFileName) {
		this.policyFileName = policyFileName;
	}

	public String getTempPolicyFilePath() {
		return tempPolicyFilePath;
	}

	public void setTempPolicyFilePath(String tempPolicyFilePath) {
		this.tempPolicyFilePath = tempPolicyFilePath;
	}
	
	public RegistryKeyProperty() {
		filters=new HashMap<String, String>();
	}
	
	public String getKeyName() {
		return keyName;
	}
	
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	
	public String getKeyValue() {
		return keyValue;
	}
	
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	
	public String getPrettyName() {
		return prettyName;
	}
	
	public void setPrettyName(String prettyName) {
		this.prettyName = prettyName;
	}
	
	public Map<String, String> getFilters() {
		return filters;
	}
	
	public void setFilters(Map<String, String> filters) {
		this.filters = filters;
	}
	
	public IRegistryData getRegistryData() {
		return registryData;
	}

	public void setRegistryData(IRegistryData registryData) {
		this.registryData = registryData;
	}
	

}

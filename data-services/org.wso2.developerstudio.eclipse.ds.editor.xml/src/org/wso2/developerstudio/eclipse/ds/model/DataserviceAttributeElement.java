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

package org.wso2.developerstudio.eclipse.ds.model;

public class DataserviceAttributeElement {
	private String name;
	private boolean required;

	public DataserviceAttributeElement(String name, boolean required) {
		setName(name);
		setRequired(required);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public boolean isOptional() {
		return !isRequired();
	}

	public boolean isRequired() {
		return required;
	}

	public String getAttributeName() {
		return getName();
	}

	public String getAttributeNameValueSeparator() {
		return "=";
	}

	public String getAttributeValueStart() {
		return "\"";
	}

	public String getAttributeValueString() {
		return "";
	}

	public String getAttributeValueEnd() {
		return "\"";
	}

	public String getAttributeValue() {
		return getAttributeValueStart() + getAttributeValueString() + getAttributeValueEnd();
	}

	public String getAttributeString() {
		return getAttributeName() + getAttributeNameValueSeparator() + getAttributeValue();
	}

}

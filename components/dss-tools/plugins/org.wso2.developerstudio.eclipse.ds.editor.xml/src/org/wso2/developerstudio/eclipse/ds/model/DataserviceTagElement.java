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

import java.util.ArrayList;
import java.util.List;

public class DataserviceTagElement {
	private List<DataserviceTagElement> subElements = new ArrayList<DataserviceTagElement>();
	private List<DataserviceAttributeElement> attributes =
	                                                       new ArrayList<DataserviceAttributeElement>();
	private String name;
	private DataserviceTagElement parentElement;
	private int minOccurances;
	private int maxOccurances;

	public DataserviceTagElement(DataserviceTagElement parentElement, String name) {
		setName(name);
		setParentElement(parentElement);
	}

	public List<DataserviceTagElement> getSubElements() {
		return subElements;
	}

	public List<DataserviceAttributeElement> getAttributes() {
		return attributes;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setParentElement(DataserviceTagElement parentElement) {
		this.parentElement = parentElement;
	}

	public DataserviceTagElement getParentElement() {
		return parentElement;
	}

	public DataserviceTagElement getSubElement(String name) {
		for (DataserviceTagElement child : getSubElements()) {
			if (child.getName().equals(name)) {
				return child;
			}
		}
		return null;
	}

	public DataserviceAttributeElement getAttrubute(String name) {
		for (DataserviceAttributeElement child : getAttributes()) {
			if (child.getName().equals(name)) {
				return child;
			}
		}
		return null;
	}

	public void setMinOccurances(int minOccurances) {
		this.minOccurances = minOccurances;
	}

	public int getMinOccurances() {
		return minOccurances;
	}

	public void setMaxOccurances(int maxOccurances) {
		this.maxOccurances = maxOccurances;
	}

	public int getMaxOccurances() {
		return maxOccurances;
	}

	public boolean isUpperLimitUnbound() {
		return getMaxOccurances() == -1;
	}
}

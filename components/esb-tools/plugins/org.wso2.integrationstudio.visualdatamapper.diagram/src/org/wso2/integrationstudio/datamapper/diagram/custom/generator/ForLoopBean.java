/*
 * Copyright 2016 WSO2, Inc. (http://wso2.com)
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
package org.wso2.integrationstudio.datamapper.diagram.custom.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.wso2.integrationstudio.datamapper.diagram.custom.util.ScriptGenerationUtil;

/**
 * This class represent a for loop object with operations and nested for loops
 * it contains
 *
 */
public class ForLoopBean {

	private String iterativeName;
	private String variableName;
	private List<Integer> nestedForLoopList;
	private List<Integer> operationList;
	private int parentIndex;
	private List<String> arrayVariableListToInstantiate;
	private List<String> objectVariableListToInstantiate;
	private Set<String> nullableVarialesList;

	public ForLoopBean(String iterativeName, String variableName) {
		nestedForLoopList = new ArrayList<>();
		operationList = new ArrayList<>();
		arrayVariableListToInstantiate = new ArrayList<>();
		objectVariableListToInstantiate = new ArrayList<>();
		nullableVarialesList = new HashSet<>();
		this.iterativeName = getValidIterateName(iterativeName + "_" + java.util.UUID.randomUUID());
		this.variableName = variableName;
	}

	public ForLoopBean(String iterativeName, String variableName, Set<String> nullableVariableList) {
		nestedForLoopList = new ArrayList<>();
		operationList = new ArrayList<>();
		arrayVariableListToInstantiate = new ArrayList<>();
		objectVariableListToInstantiate = new ArrayList<>();
		this.nullableVarialesList = nullableVariableList;
		this.iterativeName = getValidIterateName(iterativeName + "_" + java.util.UUID.randomUUID());
		this.variableName = variableName;
	}

	/**
	 * This method is to format the iterate variable name if it is not an valid
	 * variable name
	 * 
	 * @param iterativeName
	 * @return
	 */
	private String getValidIterateName(String iterativeName) {
		// Create a Pattern object
		Pattern pattern = Pattern.compile(ScriptGenerationUtil.VALID_VARIABLE_NAME_REGEX);
		// Now create matcher object.
		Matcher matcher = pattern.matcher(iterativeName);
		if (matcher.find()) {
			return iterativeName;
		} else {
			return iterativeName.replaceAll("\\W", "_");
		}
	}

	public List<String> getArrayVariableListToInstantiate() {
		return arrayVariableListToInstantiate;
	}

	public void setArrayVariableListToInstantiate(List<String> arrayVariableListToInstantiate) {
		this.arrayVariableListToInstantiate = arrayVariableListToInstantiate;
	}

	public List<String> getObjectVariableListToInstantiate() {
		return objectVariableListToInstantiate;
	}

	public void setObjectVariableListToInstantiate(List<String> objectVariableListToInstantiate) {
		this.objectVariableListToInstantiate = objectVariableListToInstantiate;
	}

	public String getIterativeName() {
		return iterativeName;
	}

	public void setIterativeName(String iterativeName) {
		this.iterativeName = iterativeName;
	}

	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public List<Integer> getNestedForLoopList() {
		return nestedForLoopList;
	}

	public void setNestedForLoopList(List<Integer> nestedForLoopList) {
		this.nestedForLoopList = nestedForLoopList;
	}

	public List<Integer> getOperationList() {
		Collections.sort(operationList);
		return operationList;
	}

	public void setOperationList(List<Integer> operationList) {
		this.operationList = operationList;
	}

	public int getParentIndex() {
		return parentIndex;
	}

	public void setParentIndex(int parentIndex) {
		this.parentIndex = parentIndex;
	}

	public Set<String> getNullableVarialesList() {
		return nullableVarialesList;
	}

	public void setNullableVarialesList(Set<String> nullableVarialesList) {
		this.nullableVarialesList = nullableVarialesList;
	}
}

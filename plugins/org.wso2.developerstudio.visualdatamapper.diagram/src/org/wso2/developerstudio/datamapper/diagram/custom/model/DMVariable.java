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
package org.wso2.developerstudio.datamapper.diagram.custom.model;

import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.diagram.custom.util.ScriptGenerationUtil;

/**
 * This class should represent variable elements of data-mapper
 *
 */
public class DMVariable {

	private String name;
	private String id;
	private int index = -1;
	private boolean visited;
	private DMVariableType type;
	private SchemaDataType schemaVariableType;
	private int parentVariableOrOperationIndex;
	private int mostChildVariableIndex;
	private String mappedInputVariableArrayElement;
	private String mappedInputVariableRootArrayElement;

	public DMVariable(String name, String id, DMVariableType type, SchemaDataType schemaVariableType, int index,
			int parentVariableIndex, String mappedInputVariableArrayElement, String mappedInputVariableRootArrayElement) {
		this.name = name;
		this.id = id;
		this.schemaVariableType = schemaVariableType;
		this.type = type;
		this.index = index;
		this.parentVariableOrOperationIndex = parentVariableIndex;
		this.setMappedInputVariableArrayElement(mappedInputVariableArrayElement);
		this.setMappedInputVariableRootArrayElement(mappedInputVariableRootArrayElement);
	}

	public DMVariable(String name, String id, DMVariableType type, SchemaDataType schemaVariableType, int index) {
		this.name = name;
		this.id = id;
		this.schemaVariableType = schemaVariableType;
		this.type = type;
		this.index = index;
		this.parentVariableOrOperationIndex = -1;
		this.setMappedInputVariableArrayElement(null);
	}

	public DMVariable(String name, String id, DMVariableType type, SchemaDataType schemaVariableType, int index,
			int parentVariableIndex) {
		this.name = name;
		this.id = id;
		this.schemaVariableType = schemaVariableType;
		this.type = type;
		this.index = index;
		this.parentVariableOrOperationIndex = parentVariableIndex;
		this.setMappedInputVariableArrayElement(null);
	}

	public String toString() {
		return "( name = " + name + " , " + "id = " + id + " , " + "type = " + type + " )";
	}

	public String getName() {
		return ScriptGenerationUtil.removeInvalidCharaters(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public DMVariableType getType() {
		return type;
	}

	public void setType(DMVariableType type) {
		this.type = type;
	}

	public SchemaDataType getSchemaVariableType() {
		return schemaVariableType;
	}

	public void setSchemaVariableType(SchemaDataType schemaVariableType) {
		this.schemaVariableType = schemaVariableType;
	}

	/**
	 * This method will return it's parent variable index if it is an input type
	 * or output type variable. It will return operation index if it is an
	 * intermediate variable
	 * 
	 * @return
	 */
	public int getparentVariableOrOperationIndex() {
		return parentVariableOrOperationIndex;
	}

	public void setparentVariableOrOperationIndex(int parentVariable) {
		this.parentVariableOrOperationIndex = parentVariable;
	}

	public int getMostChildVariableIndex() {
		return mostChildVariableIndex;
	}

	public void setMostChildVariableIndex(int mostChildVariableIndex) {
		this.mostChildVariableIndex = mostChildVariableIndex;
	}

	public String getMappedInputVariableArrayElement() {
		return mappedInputVariableArrayElement;
	}

	public void setMappedInputVariableArrayElement(String mappedInputVariableArrayElement) {
		this.mappedInputVariableArrayElement = mappedInputVariableArrayElement;
	}

	public String getMappedInputVariableRootArrayElement() {
		return mappedInputVariableRootArrayElement;
	}

	public void setMappedInputVariableRootArrayElement(String mappedInputVariableRootArrayElement) {
		this.mappedInputVariableRootArrayElement = mappedInputVariableRootArrayElement;
	}
}

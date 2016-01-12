/*
 * Copyright 2014 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.datamapper.diagram.custom.persistence;
import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.datamapper.diagram.custom.configuration.function.Function;
import org.wso2.developerstudio.datamapper.diagram.custom.persistence.util.FunctionBuilder;

public class DataMapperConfiguration {
	private List<Function> functionList;

	public DataMapperConfiguration() {
		functionList = new ArrayList<Function>();
	}

	public List<Function> getFunctionList() {
		return functionList;
	}

	public void setFunctionList(List<Function> functionList) {
		this.functionList = functionList;
	}

	public String getMappingConfiguration() {
		StringBuilder mappingConfiguration = new StringBuilder();
		for (Function function : functionList) {
			mappingConfiguration.append(FunctionBuilder.getInstance()
					.buildFunction(function));
		}

		return mappingConfiguration.toString();
	}
}

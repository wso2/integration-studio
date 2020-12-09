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

import java.util.List;
import java.util.Map;

import org.wso2.integrationstudio.datamapper.SchemaDataType;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.DMOperatorTransformerFactory;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.DMOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.exception.DataMapperException;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.DMVariable;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.DataMapperDiagramModel;

/**
 * This class extends absrtract class {@link AbstractMappingConfigGenerator} and
 * generates mapping configuration from a {@link DataMapperDiagramModel} for
 * simple same level record type schema's
 *
 */
public class SameLevelRecordMappingConfigGenerator extends AbstractMappingConfigGenerator {

	private static final int FIRST_ELEMENT_INDEX = 0;

	@Override
	public String generateMappingConfig(DataMapperDiagramModel model) throws DataMapperException {
		List<MappingOperation> mappingOperationList = populateOperationListFromModel(model);
		String mainFunction = generateMainFunction(mappingOperationList, model);
		return mainFunction;
	}

	@Override
	public boolean validate(DataMapperDiagramModel model) {
		// TODO Auto-generated method stub
		return false;
	}

	private String generateMainFunction(List<MappingOperation> mappingOperationList, DataMapperDiagramModel model) {
		String inRoot = model.getInputRootName();
		String outRoot = model.getOutputRootName();
		StringBuilder functionBuilder = new StringBuilder();
		String ouputVariableRootName = model.getVariablesArray().get(FIRST_ELEMENT_INDEX).getName();
		functionBuilder.append(getMainFunctionDefinition(inRoot, outRoot, ouputVariableRootName));
		for (MappingOperation mappingOperation : mappingOperationList) {
			functionBuilder.append(getJSCommandForOperation(mappingOperation, model.getVariableTypeMap()));
		}
		functionBuilder.append(getFunctionReturnString(ouputVariableRootName));
		return functionBuilder.toString();
	}

	private String getJSCommandForOperation(MappingOperation mappingOperation, Map<String, List<SchemaDataType>> map) {
		StringBuilder operationBuilder = new StringBuilder();
		List<DMVariable> outputVariables = mappingOperation.getOutputVariables();
		if (outputVariables.size() > 1) {
			operationBuilder.append("[ ");
		}
		int numOfOutputVariables = outputVariables.size();
		for (int variableIndex = 0; variableIndex < numOfOutputVariables; variableIndex++) {
			String variableName = outputVariables.get(variableIndex).getName();
			operationBuilder.append(variableName);
			if (variableIndex < (numOfOutputVariables - 1)) {
				operationBuilder.append(",");
			} else if (numOfOutputVariables > 1) {
				operationBuilder.append(" ] ");
			}
		}
		operationBuilder.append(" = ");
		DMOperatorTransformer operatorTransformer = DMOperatorTransformerFactory
				.getDMOperatorTransformer(mappingOperation.getOperation().getOperatorType());
		/*operationBuilder
				.append(operatorTransformer.generateScriptForOperation(SameLevelRecordMappingConfigGenerator.class,
						mappingOperation.getInputVariables(), null, map, null, mappingOperation.getOperation()));*/
		operationBuilder.append("\n");
		return operationBuilder.toString();
	}
}

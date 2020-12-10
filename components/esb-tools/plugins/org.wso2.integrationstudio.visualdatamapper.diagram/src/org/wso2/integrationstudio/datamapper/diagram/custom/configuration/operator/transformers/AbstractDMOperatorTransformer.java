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
package org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers;

import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.wso2.integrationstudio.datamapper.DataMapperOperatorType;
import org.wso2.integrationstudio.datamapper.SchemaDataType;
import org.wso2.integrationstudio.datamapper.diagram.custom.exception.DataMapperException;
import org.wso2.integrationstudio.datamapper.diagram.custom.generator.ForLoopBean;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.DMOperation;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.DMVariable;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.transformers.TransformerConstants;
import org.wso2.integrationstudio.datamapper.diagram.custom.util.ScriptGenerationUtil;

/**
 * This class implements interface {@link DMOperatorTransformer} and common
 * methods used in Data Mapper Transformers
 *
 */
public abstract class AbstractDMOperatorTransformer implements DMOperatorTransformer {

	protected String appendOutputVariable(DMOperation operation, List<DMVariable> outputVariables,
			Map<String, List<SchemaDataType>> map, Stack<ForLoopBean> tempForLoopBeanParentStack,
			List<ForLoopBean> forLoopBeanList, Map<String, Integer> outputArrayVariableForLoop, 
			Map<String, Integer> outputArrayRootVariableForLoop, List<String> unNamedVariables)
			throws DataMapperException {
		StringBuilder operationBuilder = new StringBuilder();
		int numOfOutputVariables = outputVariables.size();
		for (int variableIndex = 0; variableIndex < numOfOutputVariables; variableIndex++) {
			String prettyVariableName = null;
			// Instantiate operation does not need to have the ELEMVAL tag
			if (operation.getOperatorType().equals(DataMapperOperatorType.INSTANTIATE)) {
				prettyVariableName = ScriptGenerationUtil.getPrettyVariableNameInForOperation(
						outputVariables.get(variableIndex), map, tempForLoopBeanParentStack, false, forLoopBeanList,
						outputArrayVariableForLoop, outputArrayRootVariableForLoop,
						unNamedVariables);
				if (SchemaDataType.ARRAY.equals(operation.getProperty(TransformerConstants.VARIABLE_TYPE))) {
					prettyVariableName = prettyVariableName.substring(0, prettyVariableName.lastIndexOf('['));
				}
			} else {
				prettyVariableName = ScriptGenerationUtil.getPrettyVariableNameInForOperation(
						outputVariables.get(variableIndex), map, tempForLoopBeanParentStack, true, forLoopBeanList,
						outputArrayVariableForLoop, outputArrayRootVariableForLoop,
						unNamedVariables);
			}
			operationBuilder.append(prettyVariableName);
			if (variableIndex < (numOfOutputVariables - 1)) {
				operationBuilder.append(",");
			} else if (numOfOutputVariables > 1) {
				operationBuilder.append(" ] ");
			}
		}
		// If operation does not have output variables = sign is not needed.
		if (outputVariables.size() > 0) {
			operationBuilder.append(" = ");
		}
		return operationBuilder.toString();
	}
	
	protected SchemaDataType getOutputVariableType(List<DMVariable> outputVariables)
			throws DataMapperException {
		int numOfOutputVariables = outputVariables.size();
		SchemaDataType outputDataType = null;
		for (int variableIndex = 0; variableIndex < numOfOutputVariables; variableIndex++) {
			outputDataType = outputVariables.get(variableIndex).getSchemaVariableType();
		}
		return outputDataType;
	}

}

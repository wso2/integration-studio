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
package org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator.transformers;

import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.custom.generator.ForLoopBean;
import org.wso2.developerstudio.datamapper.diagram.custom.exception.DataMapperException;
import org.wso2.developerstudio.datamapper.diagram.custom.generator.DifferentLevelArrayMappingConfigGenerator;
import org.wso2.developerstudio.datamapper.diagram.custom.generator.SameLevelRecordMappingConfigGenerator;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMOperation;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariable;
import org.wso2.developerstudio.datamapper.diagram.custom.util.ScriptGenerationUtil;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * This class extended from the {@link AbstractDMOperatorTransformer} abstract
 * class and generate script for direct operation
 */
public class DirectOperatorTransformer extends AbstractDMOperatorTransformer {
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	@Override
	public String generateScriptForOperation(Class<?> generatorClass, List<DMVariable> inputVariables,
			List<DMVariable> outputVariables, Map<String, List<SchemaDataType>> variableTypeMap,
			Stack<ForLoopBean> parentForLoopBeanStack, DMOperation operator, List<ForLoopBean> forLoopBeanList,
			Map<String, Integer> outputArrayVariableForLoop,
			Map<String, Integer> outputArrayRootVariableForLoop, List<String> unNamedVariables)
			throws DataMapperException {
		StringBuilder operationBuilder = new StringBuilder();
		operationBuilder.append(appendOutputVariable(operator, outputVariables, variableTypeMap, parentForLoopBeanStack,
				forLoopBeanList, outputArrayVariableForLoop, outputArrayRootVariableForLoop,
				unNamedVariables));
		SchemaDataType outputDataType = getOutputVariableType(outputVariables);
		if (SameLevelRecordMappingConfigGenerator.class.equals(generatorClass)) {
			if (inputVariables.size() >= 1) {
				operationBuilder.append(inputVariables.get(0).getName() + ";");
			} else {
				operationBuilder.append("'';");
			}
		} else if (DifferentLevelArrayMappingConfigGenerator.class.equals(generatorClass)) {
			if (inputVariables.size() >= 1) {
				operationBuilder.append(this.appendTypeCorrectedInputVariable(operationBuilder, inputVariables, variableTypeMap, parentForLoopBeanStack,
						forLoopBeanList, outputArrayVariableForLoop,
						outputArrayRootVariableForLoop, outputDataType,
						unNamedVariables) + ";");
			} else {
				operationBuilder.append("'';");
			}
		} else {
			throw new IllegalArgumentException("Unknown MappingConfigGenerator type found : " + generatorClass);
		}
		return operationBuilder.toString();
	}
	
	private String appendTypeCorrectedInputVariable(StringBuilder operationBuilder, List<DMVariable> inputVariables,
			Map<String, List<SchemaDataType>> variableTypeMap, Stack<ForLoopBean> parentForLoopBeanStack,
			List<ForLoopBean> forLoopBeanList, Map<String, Integer> outputArrayVariableForLoop,
			Map<String, Integer> outputArrayRootVariableForLoop, SchemaDataType outputDataType,
			List<String> unNamedVariables) {

		try {
			String prettyVariable = ScriptGenerationUtil.getPrettyVariableNameInForOperation(inputVariables.get(0),
					variableTypeMap, parentForLoopBeanStack, true, forLoopBeanList, outputArrayVariableForLoop,
					outputArrayRootVariableForLoop, unNamedVariables);
			SchemaDataType inputDataType = inputVariables.get(0).getSchemaVariableType();
			String typeConvertedPrettyVariable = "";
			if (!outputDataType.equals(inputDataType)) {
				if (SchemaDataType.STRING.equals(inputDataType) && SchemaDataType.NUMBER.equals(outputDataType)) {
					typeConvertedPrettyVariable = "Number(" + prettyVariable + ")";
				} else if (SchemaDataType.STRING.equals(inputDataType)
						&& SchemaDataType.BOOLEAN.equals(outputDataType)) {
					typeConvertedPrettyVariable = "(" + prettyVariable + " == 'true')";
				} else if ((SchemaDataType.NUMBER.equals(inputDataType) || SchemaDataType.BOOLEAN.equals(inputDataType))
						&& SchemaDataType.STRING.equals(outputDataType)) {
					typeConvertedPrettyVariable = "(" + prettyVariable + ").toString()";
				} else {
					typeConvertedPrettyVariable = prettyVariable;
					log.warn("Unidentified type conversion was detected from " + outputDataType.toString() + " to "
							+ inputDataType.toString() + ".");
				}
			} else {
				typeConvertedPrettyVariable = prettyVariable;
			}
			return typeConvertedPrettyVariable;
		} catch (DataMapperException e) {
			throw new IllegalArgumentException("Unknown MappingConfigGenerator type found. " + e);
		}
	}
}

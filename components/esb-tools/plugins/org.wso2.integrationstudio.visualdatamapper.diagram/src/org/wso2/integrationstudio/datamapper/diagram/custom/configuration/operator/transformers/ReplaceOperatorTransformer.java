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

import static org.wso2.integrationstudio.datamapper.diagram.custom.model.transformers.TransformerConstants.JS_TO_STRING;

import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.codehaus.plexus.util.StringUtils;
import org.wso2.integrationstudio.datamapper.SchemaDataType;
import org.wso2.integrationstudio.datamapper.diagram.custom.exception.DataMapperException;
import org.wso2.integrationstudio.datamapper.diagram.custom.generator.DifferentLevelArrayMappingConfigGenerator;
import org.wso2.integrationstudio.datamapper.diagram.custom.generator.ForLoopBean;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.DMOperation;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.DMVariable;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.transformers.TransformerConstants;
import org.wso2.integrationstudio.datamapper.diagram.custom.util.ScriptGenerationUtil;

/**
 * This class extended from the {@link AbstractDMOperatorTransformer} abstract
 * class and generate script for Replace operation
 */
public class ReplaceOperatorTransformer extends AbstractDMOperatorTransformer {

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
		if (DifferentLevelArrayMappingConfigGenerator.class.equals(generatorClass)) {
			if (inputVariables.get(0) == null) {
				throw new IllegalArgumentException("Replace operator needs input string value to execute");
			}
			String replaceFromCustomInput = (String) operator.getProperty(TransformerConstants.TARGET_TAG);
			String replaceToCustomInput = (String) operator.getProperty(TransformerConstants.REPLACE_WITH_TAG);
			String replaceFromValue, replaceToValue;
			@SuppressWarnings("unchecked")
			Stack<ForLoopBean> tempParentForLoopBeanStack = (Stack<ForLoopBean>) parentForLoopBeanStack.clone();
			if (inputVariables.size() > 0) {
				operationBuilder.append("("
						+ ScriptGenerationUtil.getPrettyVariableNameInForOperation(inputVariables.get(0),
								variableTypeMap, parentForLoopBeanStack, true, forLoopBeanList,
								outputArrayVariableForLoop,
								outputArrayRootVariableForLoop, unNamedVariables)
						+ ")" + JS_TO_STRING + ".replace(");
			}

			if (replaceFromCustomInput.startsWith("{$")) {
				if (inputVariables.size() > 1 && inputVariables.get(1) != null) {
					replaceFromValue = ScriptGenerationUtil.getPrettyVariableNameInForOperation(inputVariables.get(1),
							variableTypeMap, tempParentForLoopBeanStack, true, forLoopBeanList,
							outputArrayVariableForLoop, outputArrayRootVariableForLoop,
							unNamedVariables);
				} else {
					throw new IllegalArgumentException(
							"Replace operator needs input element or configured value to Replace Target.");
				}
				replaceToValue = addReplaceToParamater(inputVariables, variableTypeMap, forLoopBeanList,
						outputArrayVariableForLoop, replaceToCustomInput, tempParentForLoopBeanStack,
						outputArrayRootVariableForLoop, unNamedVariables);

			} else {
				if (StringUtils.isNotEmpty(replaceFromCustomInput)) {
					replaceFromValue = "\"" + replaceFromCustomInput + "\"";
				} else {
					throw new IllegalArgumentException("Replace operator can not have empty string to Replace Target.");
				}
				replaceToValue = addReplaceToParamater(inputVariables, variableTypeMap, forLoopBeanList,
						outputArrayVariableForLoop, replaceToCustomInput, tempParentForLoopBeanStack,
						outputArrayRootVariableForLoop, unNamedVariables);
			}
			operationBuilder.append(replaceFromValue + "," + replaceToValue + ");");

		} else {
			throw new IllegalArgumentException("Unknown MappingConfigGenerator type found : " + generatorClass);
		}
		return operationBuilder.toString();
	}

	private String addReplaceToParamater(List<DMVariable> inputVariables,
			Map<String, List<SchemaDataType>> variableTypeMap, List<ForLoopBean> forLoopBeanList,
			Map<String, Integer> outputArrayVariableForLoop, String replaceToCustomInput,
			Stack<ForLoopBean> tempParentForLoopBeanStack, 
			Map<String, Integer> outputArrayRootVariableForLoop, List<String> unNamedVariables)
			throws DataMapperException {
		String replaceToValue;
		if (replaceToCustomInput.startsWith("{$")) {
			if (inputVariables.size() > 2 && inputVariables.get(2) != null) {
				replaceToValue = ScriptGenerationUtil.getPrettyVariableNameInForOperation(inputVariables.get(2),
						variableTypeMap, tempParentForLoopBeanStack, true, forLoopBeanList, outputArrayVariableForLoop,
						outputArrayRootVariableForLoop, unNamedVariables);
			} else {
				throw new IllegalArgumentException(
						"Replace operator needs input element" + " or configured value to Replace With.");
			}
		} else {
			if (StringUtils.isNotEmpty(replaceToCustomInput)) {
				replaceToValue = "\"" + replaceToCustomInput + "\"";
			} else {
				throw new IllegalArgumentException("Replace operator can not have empty string to Replace With.");
			}
		}
		return replaceToValue;
	}

}

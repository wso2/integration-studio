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

import org.apache.commons.lang.StringUtils;
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
 * class and generate script for StartsWith operation
 */
public class StartsWithOperatorTransformer extends AbstractDMOperatorTransformer {

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
				throw new IllegalArgumentException("StartsWith operator needs input string value to execute");
			}
			String inputMethod = (String) operator.getProperty(TransformerConstants.PATTERN_TAG);
			@SuppressWarnings("unchecked")
			Stack<ForLoopBean> tempParentForLoopBeanStack = (Stack<ForLoopBean>) parentForLoopBeanStack.clone();
			if (inputVariables.size() > 0) {
				operationBuilder
						.append("(" + ScriptGenerationUtil.getPrettyVariableNameInForOperation(inputVariables.get(0),
								variableTypeMap, parentForLoopBeanStack, true, forLoopBeanList,
								outputArrayVariableForLoop,
								outputArrayRootVariableForLoop,
								unNamedVariables) + ")");
			}
			if (inputMethod != null) {
				if (inputVariables.size() == 2 && inputMethod.startsWith("{$")) {
					operationBuilder.append(JS_TO_STRING + ".startsWith("
							+ ScriptGenerationUtil.getPrettyVariableNameInForOperation(inputVariables.get(1),
									variableTypeMap, tempParentForLoopBeanStack, true, forLoopBeanList,
									outputArrayVariableForLoop,
									outputArrayRootVariableForLoop,
									unNamedVariables)
							+ ")");
				} else {
					if (inputMethod.startsWith("{$")
							|| StringUtils.isEmpty((String) operator.getProperty(TransformerConstants.PATTERN_TAG))) {
						throw new IllegalArgumentException("StartsWith operator needs pattern to execute."
								+ " Link element to pattern connector or configure pattern string");
					}
					operationBuilder.append(JS_TO_STRING + ".startsWith(\""
							+ operator.getProperty(TransformerConstants.PATTERN_TAG) + "\")");
				}
			} else {
				operationBuilder.append(JS_TO_STRING + ".startsWith(\"\")");
			}

			operationBuilder.append(";");

		} else {
			throw new IllegalArgumentException("Unknown MappingConfigGenerator type found : " + generatorClass);
		}
		return operationBuilder.toString();
	}

}

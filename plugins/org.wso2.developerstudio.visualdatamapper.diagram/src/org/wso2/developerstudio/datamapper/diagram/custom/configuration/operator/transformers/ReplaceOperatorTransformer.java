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

import static org.wso2.developerstudio.datamapper.diagram.custom.model.transformers.TransformerConstants.JS_TO_STRING;

import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.diagram.custom.generator.DifferentLevelArrayMappingConfigGenerator;
import org.wso2.developerstudio.datamapper.diagram.custom.generator.ForLoopBean;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMOperation;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariable;
import org.wso2.developerstudio.datamapper.diagram.custom.model.transformers.TransformerConstants;
import org.wso2.developerstudio.datamapper.diagram.custom.util.ScriptGenerationUtil;

/**
 * This class extended from the {@link AbstractDMOperatorTransformer} abstract
 * class and generate script for Replace operation
 */
public class ReplaceOperatorTransformer extends AbstractDMOperatorTransformer {

	@Override
	public String generateScriptForOperation(Class<?> generatorClass, List<DMVariable> inputVariables,
			List<DMVariable> outputVariables, Map<String, List<SchemaDataType>> variableTypeMap,
			Stack<ForLoopBean> parentForLoopBeanStack, DMOperation operator, List<ForLoopBean> forLoopBeanList,
			Map<String, Integer> outputArrayVariableForLoop) {
		StringBuilder operationBuilder = new StringBuilder();
		operationBuilder.append(appendOutputVariable(operator, outputVariables, variableTypeMap, parentForLoopBeanStack,
				forLoopBeanList, outputArrayVariableForLoop));
		if (DifferentLevelArrayMappingConfigGenerator.class.equals(generatorClass)) {
			String replaceFromCustomInput = (String) operator.getProperty(TransformerConstants.TARGET_TAG);
			String replaceToCustomInput = (String) operator.getProperty(TransformerConstants.REPLACE_WITH_TAG);
			String replaceFromValue, replaceToValue;
			@SuppressWarnings("unchecked")
			Stack<ForLoopBean> tempParentForLoopBeanStack = (Stack<ForLoopBean>) parentForLoopBeanStack.clone();
			if (inputVariables.size() > 0) {
				operationBuilder
						.append("(" + ScriptGenerationUtil.getPrettyVariableNameInForOperation(inputVariables.get(0),
								variableTypeMap, parentForLoopBeanStack, true, forLoopBeanList,
								outputArrayVariableForLoop) + ")" + JS_TO_STRING + ".replace(");
			}

			if (replaceFromCustomInput.startsWith("{$") && inputVariables.size() > 1) {
				replaceFromValue = ScriptGenerationUtil.getPrettyVariableNameInForOperation(inputVariables.get(1),
						variableTypeMap, tempParentForLoopBeanStack, true, forLoopBeanList, outputArrayVariableForLoop);
				if (replaceToCustomInput.startsWith("{$") && inputVariables.size() > 2) {
					replaceToValue = ScriptGenerationUtil.getPrettyVariableNameInForOperation(inputVariables.get(2),
							variableTypeMap, tempParentForLoopBeanStack, true, forLoopBeanList,
							outputArrayVariableForLoop);
				} else {
					replaceToValue = "\"" + replaceToCustomInput + "\"";
				}

			} else {
				replaceFromValue = "\"" + replaceFromCustomInput + "\"";
				if (replaceToCustomInput.startsWith("{$") && inputVariables.size() > 1) {
					replaceToValue = ScriptGenerationUtil.getPrettyVariableNameInForOperation(inputVariables.get(1),
							variableTypeMap, tempParentForLoopBeanStack, true, forLoopBeanList,
							outputArrayVariableForLoop);
				} else {
					replaceToValue = "\"" + replaceToCustomInput + "\"";
				}
			}

			operationBuilder.append(replaceFromValue + "," + replaceToValue + ");");

		} else {
			throw new IllegalArgumentException("Unknown MappingConfigGenerator type found : " + generatorClass);
		}
		return operationBuilder.toString();
	}

}

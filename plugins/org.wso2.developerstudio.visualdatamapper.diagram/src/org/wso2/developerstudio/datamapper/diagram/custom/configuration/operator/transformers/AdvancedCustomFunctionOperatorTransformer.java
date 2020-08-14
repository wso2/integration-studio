/*
 * Copyright 2020 WSO2, Inc. (http://wso2.com)
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.diagram.custom.exception.DataMapperException;
import org.wso2.developerstudio.datamapper.diagram.custom.generator.DifferentLevelArrayMappingConfigGenerator;
import org.wso2.developerstudio.datamapper.diagram.custom.generator.ForLoopBean;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMOperation;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariable;
import org.wso2.developerstudio.datamapper.diagram.custom.model.transformers.TransformerConstants;
import org.wso2.developerstudio.datamapper.diagram.custom.util.ScriptGenerationUtil;

public class AdvancedCustomFunctionOperatorTransformer extends AbstractDMOperatorTransformer {

    @Override
    public String generateScriptForOperation(Class<?> generatorClass, List<DMVariable> inputVariables,
            List<DMVariable> outputVariables, Map<String, List<SchemaDataType>> variableTypeMap,
            Stack<ForLoopBean> parentForLoopBeanStack, DMOperation operator, List<ForLoopBean> forLoopBeanList,
            Map<String, Integer> outputArrayVariableForLoop, Map<String, Integer> outputArrayRootVariableForLoop,
            List<String> unNamedVariables) throws DataMapperException {
        StringBuilder operationBuilder = new StringBuilder();
        operationBuilder.append(appendOutputVariable(operator, outputVariables, variableTypeMap, parentForLoopBeanStack,
                forLoopBeanList, outputArrayVariableForLoop, outputArrayRootVariableForLoop, unNamedVariables));
        List<String> variableList = new ArrayList<>();
        @SuppressWarnings("unchecked")
        Stack<ForLoopBean> tempParentForLoopBeanStack = (Stack<ForLoopBean>) parentForLoopBeanStack.clone();
        for (DMVariable inputVariable : inputVariables) {
            variableList.add(ScriptGenerationUtil.getPrettyVariableNameInForOperation(inputVariable, variableTypeMap,
                    tempParentForLoopBeanStack, true, forLoopBeanList, outputArrayVariableForLoop,
                    outputArrayRootVariableForLoop, unNamedVariables));
        }
        if (DifferentLevelArrayMappingConfigGenerator.class.equals(generatorClass)) {
            operationBuilder.append(operator.getProperty(TransformerConstants.CUSTOM_FUNCTION_NAME) + "(");
            for (int i = 0; i < variableList.size(); i++) {
                operationBuilder.append(variableList.get(i));
                if (i < variableList.size() - 1) {
                    operationBuilder.append(",");
                }
            }
            operationBuilder.append(");");
        } else {
            throw new IllegalArgumentException("Unknown MappingConfigGenerator type found : " + generatorClass);
        }
        return operationBuilder.toString();
    }

}

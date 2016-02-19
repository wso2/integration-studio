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
import org.wso2.developerstudio.datamapper.diagram.custom.generator.ForLoopBean;
import org.wso2.developerstudio.datamapper.diagram.custom.generator.SameLevelArrayMappingConfigGenerator;
import org.wso2.developerstudio.datamapper.diagram.custom.generator.SameLevelRecordMappingConfigGenerator;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariable;

/**
 * This class extended from the {@link AbstractDMOperatorTransformer} abstract class and generate script for direct
 * operation
 */
public class DirectOperatorTransformer extends AbstractDMOperatorTransformer {

    @Override
    public String generateScriptForOperation(Class<?> generatorClass, List<DMVariable> inputVariables,
            Map<String, SchemaDataType> variableTypeMap, Stack<ForLoopBean> parentForLoopBeanStack) {
        StringBuilder operationBuilder = new StringBuilder();
        if (SameLevelRecordMappingConfigGenerator.class.equals(generatorClass)) {
            if (inputVariables.size() >= 1) {
                operationBuilder.append(inputVariables.get(0).getName() + ";");
            } else {
                operationBuilder.append("'';");
            }
        } else if (SameLevelArrayMappingConfigGenerator.class.equals(generatorClass)) {
            if (inputVariables.size() >= 1) {
                operationBuilder.append(getPrettyVariableNameInForOperation(inputVariables.get(0), variableTypeMap,
                        parentForLoopBeanStack) + ";");
            } else {
                operationBuilder.append("'';");
            }
        } else {
            throw new IllegalArgumentException("Unknown MappingConfigGenerator type found : " + generatorClass);
        }
        return operationBuilder.toString();
    }
}

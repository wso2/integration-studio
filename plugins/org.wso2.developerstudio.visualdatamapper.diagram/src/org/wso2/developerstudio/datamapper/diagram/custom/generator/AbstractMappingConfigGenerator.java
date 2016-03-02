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
package org.wso2.developerstudio.datamapper.diagram.custom.generator;

import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.datamapper.diagram.custom.model.DMOperation;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariable;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariableType;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DataMapperDiagramModel;

/**
 * This abstract class implements the common of functions and logic to generate JS mapping
 * configuration from {@link DataMapperDiagramModel}
 *
 */
public abstract class AbstractMappingConfigGenerator implements MappingConfigGenerator {

    protected List<MappingOperation> populateOperationListFromModel(DataMapperDiagramModel model) {
        ArrayList<MappingOperation> mappingOperationList = new ArrayList<>();
        List<Integer> executionSeq = model.getExecutionSequence();
        for (Integer operationIndex : executionSeq) {
            List<DMVariable> inputVariables = getVariablesFromModel(model, operationIndex, DMVariableType.INPUT);
            List<DMVariable> outputVariables = getVariablesFromModel(model, operationIndex, DMVariableType.OUTPUT);;
            DMOperation operation = model.getOperationsList().get(operationIndex);
            mappingOperationList.add(new MappingOperation(inputVariables, outputVariables, operation));
        }
        return mappingOperationList;
    }

    protected String getMainFunctionDefinition(String inRoot, String outRoot) {
        StringBuilder mainFunctionBuilder = new StringBuilder();
        mainFunctionBuilder.append("function map_S_");
        mainFunctionBuilder.append(inRoot);
        mainFunctionBuilder.append("_S_");
        mainFunctionBuilder.append(outRoot);
        mainFunctionBuilder.append("( input" + inRoot + ", output" + outRoot + ")");
        mainFunctionBuilder.append("{ ");
        mainFunctionBuilder.append("\n");
        return mainFunctionBuilder.toString();
    }

    protected String getFunctionReturnString(String outRoot) {
        StringBuilder functionBuilder = new StringBuilder();
        functionBuilder.append("return output" + outRoot);
        functionBuilder.append(";");
        functionBuilder.append("\n");
        functionBuilder.append("}");
        return functionBuilder.toString();
    }

    private List<DMVariable> getVariablesFromModel(DataMapperDiagramModel model, Integer operationIndex,
            DMVariableType type) {
        ArrayList<Integer> variableReferenceList;
        if (DMVariableType.INPUT.equals(type)) {
            variableReferenceList = model.getInputAdjList().get(operationIndex);
        } else if (DMVariableType.OUTPUT.equals(type)) {
            variableReferenceList = model.getOutputAdjList().get(operationIndex);
        } else {
            throw new IllegalArgumentException("Illegal Variable type for this operation : " + type);
        }
        List<DMVariable> variableList = new ArrayList<>();
        for (Integer variableIndex : variableReferenceList) {
            variableList.add(model.getVariablesArray().get(variableIndex));
        }
        return variableList;
    }
}

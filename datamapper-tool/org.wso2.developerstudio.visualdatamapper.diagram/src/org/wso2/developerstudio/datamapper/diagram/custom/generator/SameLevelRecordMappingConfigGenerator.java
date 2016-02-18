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

import org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator.DMOperatorTransformerFactory;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator.transformers.DMOperatorTransformer;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMOperation;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariable;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariableType;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DataMapperDiagramModel;

/**
 * This class implements interface {@link MappingConfigGenerator} and generates mapping configuration from a
 * {@link DataMapperDiagramModel} for simple same level record type schemas
 *
 */
public class SameLevelRecordMappingConfigGenerator implements MappingConfigGenerator {

    @Override
    public String generateMappingConfig(DataMapperDiagramModel model) {
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
        functionBuilder.append("function map_S_");
        functionBuilder.append(inRoot);
        functionBuilder.append("_S_");
        functionBuilder.append(outRoot);
        functionBuilder.append("( input" + inRoot + ", output" + outRoot + ")");
        functionBuilder.append("{ ");
        functionBuilder.append("\n");
        for (MappingOperation mappingOperation : mappingOperationList) {
            functionBuilder.append(getJSCommandForOperation(mappingOperation));
        }
        functionBuilder.append("\n");
        functionBuilder.append("return output" + outRoot);
        functionBuilder.append(";");
        functionBuilder.append("\n");
        functionBuilder.append("}");
        return functionBuilder.toString();
    }

    private String getJSCommandForOperation(MappingOperation mappingOperation) {
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
        operationBuilder.append(operatorTransformer.generateScriptForOperation(
                SameLevelRecordMappingConfigGenerator.class, mappingOperation.getInputVariables()));
        operationBuilder.append("\n");
        return operationBuilder.toString();
    }

    private List<MappingOperation> populateOperationListFromModel(DataMapperDiagramModel model) {
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

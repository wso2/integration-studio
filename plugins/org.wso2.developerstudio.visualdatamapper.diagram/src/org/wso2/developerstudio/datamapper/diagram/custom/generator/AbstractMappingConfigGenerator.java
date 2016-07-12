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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.wso2.developerstudio.datamapper.DataMapperOperatorType;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMOperation;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariable;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariableType;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DataMapperDiagramModel;
import org.wso2.developerstudio.datamapper.diagram.custom.model.transformers.TransformerConstants;
import org.wso2.developerstudio.datamapper.diagram.custom.util.ScriptGenerationUtil;

/**
 * This abstract class implements the common of functions and logic to generate
 * JS mapping configuration from {@link DataMapperDiagramModel}
 *
 */
public abstract class AbstractMappingConfigGenerator implements MappingConfigGenerator {

	protected static final String JS_FUNCTION_NAME = "function";
	private static final String OUTPUT_VARIABLE_NAME = "OUTPUT";

	protected List<MappingOperation> populateOperationListFromModel(DataMapperDiagramModel model) {
		ArrayList<MappingOperation> mappingOperationList = new ArrayList<>();
		List<Integer> executionSeq = model.getExecutionSequence();
		for (Integer operationIndex : executionSeq) {
			List<DMVariable> inputVariables = getVariablesFromModel(model, operationIndex, DMVariableType.INPUT);
			List<DMVariable> outputVariables = getVariablesFromModel(model, operationIndex, DMVariableType.OUTPUT);
			DMOperation operation = model.getOperationsList().get(operationIndex);
			mappingOperationList.add(new MappingOperation(inputVariables, outputVariables, operation, 0));
		}
		return sortMappingOperationList(mappingOperationList);
	}

	protected List<MappingOperation> sortMappingOperationList(List<MappingOperation> mappingOperationList) {
		ArrayList<MappingOperation> outputMappingOperationList = new ArrayList<>();
		ArrayList<MappingOperation> nonOutputMappingOperationList = new ArrayList<>();
		for (MappingOperation mappingOperation : mappingOperationList) {
			List<DMVariable> outputList = mappingOperation.getOutputVariables();
			if (outputList.size() == 1 && OUTPUT_VARIABLE_NAME.equals(outputList.get(0).getType().name())) {
				outputMappingOperationList.add(mappingOperation);
			} else {
				nonOutputMappingOperationList.add(mappingOperation);
			}
		}
		Collections.sort(outputMappingOperationList, new Comparator<MappingOperation>() {
			@Override
			public int compare(MappingOperation mappingOperation1, MappingOperation mappingOperation2) {
				return mappingOperation1.getOutputVariables().get(0).getIndex()
						- mappingOperation2.getOutputVariables().get(0).getIndex();
			}
		});
		for (MappingOperation mappingOperation : outputMappingOperationList) {
			nonOutputMappingOperationList.add(mappingOperation);
		}
		updateMappingOperationIndexes(nonOutputMappingOperationList);
		return nonOutputMappingOperationList;
	}

	private void updateMappingOperationIndexes(ArrayList<MappingOperation> nonOutputMappingOperationList) {
		int index = 0;
		for (MappingOperation mappingOperation : nonOutputMappingOperationList) {
			mappingOperation.setIndex(index);
			index++;
		}
	}

	protected String generateCustomFunctions(DataMapperDiagramModel model) {
		StringBuilder functionBuilder = new StringBuilder();
		for (DMOperation operation : model.getOperationsList()) {
			if (DataMapperOperatorType.CUSTOM_FUNCTION.equals(operation.getOperatorType())) {
				functionBuilder.append("\n");
				functionBuilder.append(operation.getProperty(TransformerConstants.CUSTOM_FUNCTION_NAME) + " = "
						+ addFunctionDefinition(operation));
			}
		}
		return functionBuilder.toString();
	}

	protected String addFunctionDefinition(DMOperation operation) {
		StringBuilder functionBuilder = new StringBuilder();
		functionBuilder.append("function");
		String functionDefinition = (String) operation.getProperty(TransformerConstants.CUSTOM_FUNCTION_DEFINITION);
		functionBuilder.append(functionDefinition.substring(functionDefinition.indexOf("(")));
		return functionBuilder.toString();
	}

	protected String getMainFunctionDefinition(String inRoot, String outRoot, String outputVariableRootName) {
		StringBuilder mainFunctionBuilder = new StringBuilder();
		mainFunctionBuilder.append("map_S_" + ScriptGenerationUtil.removeInvalidCharaters(inRoot));
		mainFunctionBuilder.append("_S_");
		mainFunctionBuilder.append(ScriptGenerationUtil.removeInvalidCharaters(outRoot) + " = " + JS_FUNCTION_NAME);
		mainFunctionBuilder.append("()");
		mainFunctionBuilder.append("{ ");
		mainFunctionBuilder.append("\n");
		mainFunctionBuilder
				.append("var " + ScriptGenerationUtil.removeInvalidCharaters(outputVariableRootName) + "={};");
		mainFunctionBuilder.append("\n");
		return mainFunctionBuilder.toString();
	}

	protected String getFunctionReturnString(String outRoot) {
		StringBuilder functionBuilder = new StringBuilder();
		functionBuilder.append("return " + ScriptGenerationUtil.removeInvalidCharaters(outRoot));
		functionBuilder.append(";");
		functionBuilder.append("\n");
		functionBuilder.append("};");
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
			if (variableIndex >= 0) {
				variableList.add(model.getVariablesArray().get(variableIndex));
			} else {
				variableList.add(null);
			}
		}
		return variableList;
	}
}

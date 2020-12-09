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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.apache.commons.lang.StringUtils;
import org.wso2.developerstudio.datamapper.DataMapperOperatorType;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator.DMOperatorTransformerFactory;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator.transformers.DMOperatorTransformer;
import org.wso2.developerstudio.datamapper.diagram.custom.exception.DataMapperException;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMOperation;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariable;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariableType;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DataMapperDiagramModel;
import org.wso2.developerstudio.datamapper.diagram.custom.model.transformers.TransformerConstants;
import org.wso2.developerstudio.datamapper.diagram.custom.util.ScriptGenerationUtil;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * This class extends abstract class {@link AbstractMappingConfigGenerator} and
 * generates mapping configuration from a {@link DataMapperDiagramModel} for
 * simple same level record and array type schema's
 *
 */
public class DifferentLevelArrayMappingConfigGenerator extends AbstractMappingConfigGenerator {

	private static final String ROOT_TAG = "root";
	private static final int FIRST_ELEMENT_INDEX = 0;

	private static final int VARIABLE_TYPE_INDEX = 0;
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * 
	 */
	private Map<String, Integer> forLoopBeanMap;

	/**
	 * forLoopBeanList contains the list of forLoopBeans in the generated script
	 */
	private List<ForLoopBean> forLoopBeanList;

	/**
	 * This is the root/parent bean and it will not be under a for loop in the
	 * generated script. Every operation and for loops should be under this
	 * rootBean
	 */
	private ForLoopBean rootBean;

	private Map<String, Integer> outputArrayVariableForLoopMap;
	private Map<String, Integer> outputObjectVariableForLoopMap;
	private Map<String, List<SchemaDataType>> variableMap;
	private Map<String, Integer> outputArrayRootVariableForLoop;
	boolean hasAdvancedFunction = false;
	String advancedFunctionDefinition;

	@Override
	public String generateMappingConfig(DataMapperDiagramModel model) throws DataMapperException {
		initializeAlgorithmFields();
		String globalVariables = instantiateGlobalVariables(model);
		List<MappingOperation> mappingOperationList = populateOperationListFromModel(model);
		String mainFunction = generateMainFunction(mappingOperationList, model);
		hasAdvancedFunction = false;
		String customFunctions = generateCustomFunctions(model);
		if (hasAdvancedFunction) {
		    mainFunction = generateAdvancedCustomFunctions(mainFunction, model);
		}
		return globalVariables + mainFunction + customFunctions;
	}

	private void populateOutputArrayRootVariableMap(DataMapperDiagramModel model) {
		if (!model.getInputVariablesArray().isEmpty()) {
			int indexOfFirstInput = model.getInputVariablesArray().get(0);
			for (int i = 0; i <= indexOfFirstInput; i++) {
				DMVariable outputVariable = model.getVariablesArray().get(i);
				if (SchemaDataType.ARRAY.equals(outputVariable.getSchemaVariableType())
						&& outputVariable.getMappedInputVariableArrayElement() != null) {
					if (outputVariable.getMappedInputVariableRootArrayElement() != null) {
						if (forLoopBeanMap.containsKey(ScriptGenerationUtil
								.removeInvalidCharaters(outputVariable.getMappedInputVariableRootArrayElement()))) {
							int rootArrayVariableForLoopIndex = forLoopBeanMap
									.get(outputVariable.getMappedInputVariableRootArrayElement());
							outputArrayRootVariableForLoop.put(outputVariable.getName(), rootArrayVariableForLoopIndex);
						} else {
							throw new IllegalArgumentException("forLoopBeanMap is not yet populated");
						}
					} else {
						outputArrayRootVariableForLoop.put(outputVariable.getName(), 0);
					}
				}
			}
		}
	}

	private String instantiateGlobalVariables(DataMapperDiagramModel model) {
		StringBuilder functionBuilder = new StringBuilder();
		for (DMOperation operation : model.getOperationsList()) {
			if (DataMapperOperatorType.GLOBAL_VARIABLE.equals(operation.getOperatorType())) {
				functionBuilder.append("var " + operation.getProperty(TransformerConstants.GLOBAL_VARIABLE_NAME) + " = "
						+ operation.getProperty(TransformerConstants.GLOBAL_VARIABLE_DEFAULT_VALUE));
				functionBuilder.append(";\n");
			}
		}
		return functionBuilder.toString();
	}

	protected String generateCustomFunctions(DataMapperDiagramModel model) {
		StringBuilder functionBuilder = new StringBuilder();
		for (DMOperation operation : model.getOperationsList()) {
			if (DataMapperOperatorType.CUSTOM_FUNCTION.equals(operation.getOperatorType())) {
				functionBuilder.append(operation.getProperty(TransformerConstants.CUSTOM_FUNCTION_NAME) + " = "
						+ addFunctionDefinition(operation));
			}
			if (DataMapperOperatorType.ADVANCED_CUSTOM_FUNCTION.equals(operation.getOperatorType())) {
                hasAdvancedFunction = true;
                advancedFunctionDefinition = TransformerConstants.ADVANCED_CUSTOM_FUNCTION_NAME + " = "
                        + addAdvancedFunctionDefinition(operation);
            }
			functionBuilder.append("\n");
		}
		return functionBuilder.toString();
	}
	
	protected String generateAdvancedCustomFunctions(String mainFunction, DataMapperDiagramModel model) {
		String start = mainFunction.substring(0, mainFunction.lastIndexOf("return"));
		String end = mainFunction.substring(mainFunction.lastIndexOf("return"));
		StringBuilder functionBuilder = new StringBuilder();
		String inputName = "", outputName = "";
		boolean setInput = false, setOutput = false;
		for (DMVariable dmVariable : model.getVariablesArray()) {
			if (!setInput && dmVariable.getType().equals(DMVariableType.INPUT)) {
				inputName = dmVariable.getName();
				setInput = true;
			} else if (!setOutput && dmVariable.getType().equals(DMVariableType.OUTPUT)) {
				outputName = dmVariable.getName();
				setOutput = true;
			}
		}
		functionBuilder.append(start).append("\n").append("endFunction(").append(inputName).append(",")
				.append(outputName).append(");").append("\n").append(end).append("\n\n")
				.append(advancedFunctionDefinition);
		return functionBuilder.toString();
	}
	
	protected String addAdvancedFunctionDefinition(DMOperation operation) {
		StringBuilder functionBuilder = new StringBuilder();
		functionBuilder.append("function");
		String functionDefinition = (String) operation
				.getProperty(TransformerConstants.ADVANCED_CUSTOM_FUNCTION_DEFINITION);
		functionBuilder.append(functionDefinition.substring(functionDefinition.indexOf("(")));
		return functionBuilder.toString();
	}

	protected String addFunctionDefinition(DMOperation operation) {
		StringBuilder functionBuilder = new StringBuilder();
		functionBuilder.append("function");
		String functionDefinition = (String) operation.getProperty(TransformerConstants.CUSTOM_FUNCTION_DEFINITION);
		functionBuilder.append(functionDefinition.substring(functionDefinition.indexOf("(")));
		return functionBuilder.toString();
	}

	private void initializeAlgorithmFields() {
		forLoopBeanMap = new HashMap<>();
		outputArrayVariableForLoopMap = new HashMap<>();
		outputArrayRootVariableForLoop = new HashMap<>();
		outputObjectVariableForLoopMap = new HashMap<>();
		forLoopBeanList = new ArrayList<>();
		rootBean = new ForLoopBean(ROOT_TAG, ROOT_TAG);
		rootBean.setParentIndex(-1);
		getForLoopBeanList().add(rootBean);
		getForLoopBeanMap().put(ROOT_TAG, 0);
	}

	private String generateMainFunction(List<MappingOperation> mappingOperationList, DataMapperDiagramModel model)
			throws DataMapperException {
		String inRoot = model.getInputRootName();
		String outRoot = model.getOutputRootName();
		StringBuilder functionBuilder = new StringBuilder();
		String ouputVariableRootName = model.getVariablesArray().get(FIRST_ELEMENT_INDEX).getName();
		functionBuilder.append(getMainFunctionDefinition(inRoot, outRoot, ouputVariableRootName));
		functionBuilder.append(getJSCommandsForOperations(mappingOperationList, model));
		functionBuilder.append(getFunctionReturnString(ouputVariableRootName));
		return functionBuilder.toString();
	}

	@SuppressWarnings("unchecked")
	private String getJSCommandsForOperations(List<MappingOperation> mappingOperationList, DataMapperDiagramModel model)
			throws DataMapperException {
		variableMap = model.getVariableTypeMap();
		StringBuilder functionBuilder = new StringBuilder();
		ArrayList<MappingOperation> unassignedMappingOperations = new ArrayList<>();
		List<MappingOperation> mappingOperationListTemp = (List<MappingOperation>) ((ArrayList<MappingOperation>) mappingOperationList)
				.clone();
		mappingOperationListTemp = configureForLoopsWithMappingOperations(model, variableMap, functionBuilder,
				unassignedMappingOperations, mappingOperationListTemp);
		// All operations are now assign to ForLoopBean map. Transform
		// forLoopBean map for JS script.
		functionBuilder
				.append(transformForLoopBeansToJS(getRootBean(), mappingOperationList, 
						model.getVariableTypeMap(), model.getUnNamedVariables()));
		return functionBuilder.toString();
	}

	@SuppressWarnings("unchecked")
	private List<MappingOperation> configureForLoopsWithMappingOperations(DataMapperDiagramModel model,
			Map<String, List<SchemaDataType>> variableMap, StringBuilder functionBuilder,
			ArrayList<MappingOperation> unassignedMappingOperations, List<MappingOperation> mappingOperationListTemp)
			throws DataMapperException {
		int unassignedOperationCount;
		do {
			unassignedOperationCount = unassignedMappingOperations.size();
			if (unassignedOperationCount > 0) {
				mappingOperationListTemp = (List<MappingOperation>) unassignedMappingOperations.clone();
				unassignedMappingOperations.clear();
			}
			for (MappingOperation mappingOperation : mappingOperationListTemp) {
				List<DMVariable> inputVariables = mappingOperation.getInputVariables();
				List<DMVariable> outputVariables = mappingOperation.getOutputVariables();
				List<Integer> operationForLoopBeansList = new ArrayList<>();
				List<String> operationLastArrayElementsParentList = new ArrayList<>();
				Set<String> operationNullableVariableList = new HashSet<>();
				if (!inputVariables.isEmpty()) {
					for (DMVariable dmVariable : inputVariables) {
						if (dmVariable != null) {
							String mostChildVariableName = "";
							int mostChildVariableIndex = -1;
							// getting most child variable index
							if (DMVariableType.INTERMEDIATE.equals(dmVariable.getType())
									|| DMVariableType.OUTPUT.equals(dmVariable.getType())) {
								List<DMVariable> variableArray = model.getVariablesArray();
								mostChildVariableIndex = getMostChildAssociatedVariableIndex(
										model.getInputAdjList().get(dmVariable.getparentVariableOrOperationIndex()),
										variableArray);
								if (mostChildVariableIndex >= 0) {
									mostChildVariableName = variableArray.get(mostChildVariableIndex).getName();
								} else {
									mostChildVariableIndex = model.getInputVariablesArray().get(0);
									mostChildVariableName = model.getVariablesArray().get(mostChildVariableIndex)
											.getName();
								}
								dmVariable.setMostChildVariableIndex(mostChildVariableIndex);
							} else {
								mostChildVariableName = dmVariable.getName();
								mostChildVariableIndex = dmVariable.getIndex();
							}
							if (mostChildVariableIndex >= 0) {
								String[] variableNameArray = mostChildVariableName.split("\\.");
								String variableName = "";
								String parentVariableName = "";
								String parentArrayVariable = "";
								boolean firstIteration = true;
								Set<String> nullableVariableList = new HashSet<>();
								for (String nextName : variableNameArray) {
									if (!firstIteration) {
										// remove "." from variable name
										parentVariableName = variableName.substring(0, variableName.length() - 1);
									}
									variableName += nextName;
									if (variableMap.containsKey(variableName)) {
										SchemaDataType variableType = variableMap.get(variableName)
												.get(VARIABLE_TYPE_INDEX);
										if (SchemaDataType.ARRAY.equals(variableType)) {
											if (forLoopBeanNotExist(variableName)) {
												int indexOfForLoopBean = addForLoopInToMap(variableName,
														new ForLoopBean("i_" + nextName, variableName,
																nullableVariableList));
												nullableVariableList = new HashSet<>();
												addForLoopBeanIndexToParent(variableName, indexOfForLoopBean,
														parentArrayVariable);
												parentArrayVariable = variableName;
											} else {
												parentArrayVariable = variableName;
											}
										} else if (ScriptGenerationUtil.isVariableTypePrimitive(variableType)) {
											// leaf variable element
										} else if (SchemaDataType.OBJECT.equals(variableType)) {
											if (variableMap.get(variableName).contains(SchemaDataType.NULL)) {
												nullableVariableList.add(variableName);
											}
										} else {
											throw new DataMapperException(
													"Unsupported schemaDataType in WSO2 Data Mapper found : "
															+ variableType);
										}
									} else {
										throw new IllegalArgumentException(
												"Unknown variable name found : " + variableName);
									}
									variableName += ".";
									firstIteration = false;
								}
								operationNullableVariableList.addAll(nullableVariableList);
								// add most parent array for
								// operationForLoopBeansList
								if (StringUtils.isEmpty(parentArrayVariable)) {
									// root bean value
									operationForLoopBeansList.add(0);
								} else {
									operationForLoopBeansList.add(getForLoopBeanMap().get(parentArrayVariable));
								}
								// add parent Element of the variable to
								// operationElementsParentList
								// Only array elements need to be checked
								// whether
								// from the same parent or not
								operationLastArrayElementsParentList.add(parentArrayVariable);
							}
						}
					}
				}

				// validate the for loop beans of the variables. They should be
				// in
				// one branch.
				int indexOfMostInnerForLoopBean = -1;
				if (isValidOperationWithInputVariables(operationLastArrayElementsParentList)) {
					indexOfMostInnerForLoopBean = getMostInnerForLoopBeanFromList(operationForLoopBeansList);
				}
				String mostChildArrayOutputVariable = "";
				for (DMVariable outputVariable : outputVariables) {
					if (DMVariableType.INTERMEDIATE.equals(outputVariable.getType())
							&& !outputVariable.getName().contains("{")) {
						//instantiate intermediate variables
						functionBuilder.append("var " + outputVariable.getName() + " = '';");
						functionBuilder.append("\n");
					} else if (DMVariableType.OUTPUT.equals(outputVariable.getType())) {
						mostChildArrayOutputVariable = updateOutputVariableForLoopMap(outputVariable, variableMap,
								indexOfMostInnerForLoopBean, operationForLoopBeansList, unassignedMappingOperations,
								mappingOperation);
					}
				}
				indexOfMostInnerForLoopBean = getMostInnerForLoopBeanFromList(operationForLoopBeansList);

				// find the most inner for loop bean to assign this operation
				if (indexOfMostInnerForLoopBean >= 0) {
					/*
					 * Instantiate operation of array type variables should go
					 * to previous object/array for loop bean and preference
					 * should go for mapped input variable for loop for the
					 * array object element instantiation
					 */
					if (DataMapperOperatorType.INSTANTIATE.equals(mappingOperation.getOperation().getOperatorType())) {
						if (SchemaDataType.ARRAY.equals(
								mappingOperation.getOperation().getProperty(TransformerConstants.VARIABLE_TYPE))) {
							String variableName = mappingOperation.getOutputVariables().get(0).getName();
							int lastSeperatorIndex = variableName.lastIndexOf(".");
							if (lastSeperatorIndex < 0) {
								indexOfMostInnerForLoopBean = 0;
							} else {
								variableName = variableName.substring(0, lastSeperatorIndex);
								if (outputArrayVariableForLoopMap.containsKey(variableName)) {
									indexOfMostInnerForLoopBean = outputArrayVariableForLoopMap.get(variableName);
								} else if (outputObjectVariableForLoopMap.containsKey(variableName)) {
									indexOfMostInnerForLoopBean = outputObjectVariableForLoopMap.get(variableName);
								} else {
									log.warn("Variable map doesn't contain variable : " + variableName);
								}
							}
						} else if (SchemaDataType.OBJECT
								.equals(mappingOperation.getOperation().getProperty(TransformerConstants.VARIABLE_TYPE))
								&& mappingOperation.getOperation().getProperties()
										.containsKey(TransformerConstants.INSTANTIATE_PARENT_VARIABLE)
								&& SchemaDataType.ARRAY.equals(mappingOperation.getOperation()
										.getProperty(TransformerConstants.INSTANTIATE_PARENT_VARIABLE))
								&& mappingOperation.getOutputVariables().get(0)
										.getMappedInputVariableArrayElement() != null) {
							// Object instantiate operation of a array element
							mappingOperation.setDoNotChangePosition(true);
							String mappedInputVariableArrayElement = mappingOperation.getOutputVariables().get(0)
									.getMappedInputVariableArrayElement();
							indexOfMostInnerForLoopBean = forLoopBeanList
									.indexOf(ScriptGenerationUtil.getForLoopFromMappedVariableArrayName(
											mappedInputVariableArrayElement, forLoopBeanList));
						}
					}
					if (indexOfMostInnerForLoopBean < 0) {
						/*
						 * When one to array mapping occurs for loop index of
						 * array instantiate operation goes to -1. It also
						 * should be in root for loop.
						 */
						indexOfMostInnerForLoopBean = 0;
					}
					// Should update the output variable for loop bean mapping.
					// Most child for loop should be assigned
					if (!mostChildArrayOutputVariable.isEmpty()
							&& indexOfMostInnerForLoopBean > outputArrayVariableForLoopMap
									.get(mostChildArrayOutputVariable)) {
						outputArrayVariableForLoopMap.put(mostChildArrayOutputVariable, indexOfMostInnerForLoopBean);
					}
					getForLoopBeanList().get(indexOfMostInnerForLoopBean).getOperationList()
							.add(mappingOperation.getIndex());
				}
				mappingOperation.setOptionalElementList(operationNullableVariableList);
			}
			if (unassignedOperationCount == unassignedMappingOperations.size()) {
				// If there are unassigned Constant operations, declare their output arrays.
				boolean changed = declareArraysForUnassignedConstantOperators(
						unassignedMappingOperations, variableMap);
				// If changed, some operations will be able to be assigned.
				if (!changed) {
					assignUnresolvableOperationsToRoot(
							unassignedMappingOperations);
				}
			}
		} while (!unassignedMappingOperations.isEmpty());
		populateOutputArrayRootVariableMap(model);
		return mappingOperationListTemp;
	}
	
	/**
	 * Checks for unassigned constant operators and declare their output arrays.
	 * 
	 * @param unassignedMappingOperations operation list to be checked
	 * @param variableMap map with all variables and their types
	 * @return whether any changed were made to OutputVariableForLoopMaps
	 * @throws DataMapperException throws when encountered an invalid elements
	 */
	private boolean declareArraysForUnassignedConstantOperators(
			List<MappingOperation> unassignedMappingOperations,
			Map<String, List<SchemaDataType>> variableMap)
			throws DataMapperException {
		boolean changed = false;
		for (MappingOperation mappingOperation : unassignedMappingOperations) {
			if (DataMapperOperatorType.CONSTANT.equals(
					mappingOperation.getOperation().getOperatorType())) {
				List<DMVariable> outputVariables = mappingOperation
						.getOutputVariables();
				for (DMVariable outputVariable : outputVariables) {
					if (DMVariableType.OUTPUT
							.equals(outputVariable.getType())) {
						boolean updated = updateOutputVariableForLoopMap(
								outputVariable, variableMap);
						changed = changed || updated;
					}
				}
			}
		}
		return changed;
	}

	private void assignUnresolvableOperationsToRoot(List<MappingOperation> unassignedMappingOperations) {
		for (MappingOperation mappingOperation : unassignedMappingOperations) {
			getForLoopBeanList().get(0).getOperationList().add(mappingOperation.getIndex());
		}
		unassignedMappingOperations.clear();
	}

	private String updateOutputVariableForLoopMap(DMVariable outputVariable,
			Map<String, List<SchemaDataType>> variableMap, int indexOfMostInnerForLoopBean,
			List<Integer> operationForLoopBeansList, List<MappingOperation> unassignedMappingOperations,
			MappingOperation mappingOperation) throws DataMapperException {
		String outputVariableName = outputVariable.getName();
		String[] variableNameArray = outputVariableName.split("\\.");
		String variableName = "";
		String parentVariableName = "";
		String parentArrayVariable = "";
		String lastArrayVariable = "";
		boolean firstIteration = true;
		boolean operationAddedToUnassignedOperations = false;
		int previousForLoopIndex = 0;
		int previousObjectForLoopIndex = 0;
		for (String nextName : variableNameArray) {
			if (!firstIteration) {
				parentVariableName = variableName.substring(0, variableName.length() - 1);
			}
			variableName += nextName;
			if (variableMap.containsKey(variableName)) {
				SchemaDataType variableType = variableMap.get(variableName).get(VARIABLE_TYPE_INDEX);
				if (SchemaDataType.ARRAY.equals(variableType)) {
					if (!outputArrayVariableForLoopMap.containsKey(variableName)) {
						int targetForLoopIndex = getParentForLoopBeanIndex(previousForLoopIndex,
								indexOfMostInnerForLoopBean);
						if (targetForLoopIndex < 0) {
							unassignedMappingOperations.add(mappingOperation);
							operationAddedToUnassignedOperations = true;
							break;
						} else {
							outputArrayVariableForLoopMap.put(variableName, targetForLoopIndex);
							getForLoopBeanList().get(targetForLoopIndex).getArrayVariableListToInstantiate()
									.add(variableName);
							previousForLoopIndex = targetForLoopIndex;
						}
					} else {
						previousForLoopIndex = outputArrayVariableForLoopMap.get(variableName);
					}
					parentArrayVariable = variableName;
					lastArrayVariable = variableName;
				} else if (ScriptGenerationUtil.isVariableTypePrimitive(variableType)) {
					// leaf variable element
				} else if (SchemaDataType.OBJECT.equals(variableType)) {
					if (!outputObjectVariableForLoopMap.containsKey(variableName)) {
						int targetForLoopIndex = previousForLoopIndex;
						outputObjectVariableForLoopMap.put(variableName, targetForLoopIndex);
						getForLoopBeanList().get(targetForLoopIndex).getObjectVariableListToInstantiate()
								.add(variableName);
						previousObjectForLoopIndex = targetForLoopIndex;
					} else {
						previousObjectForLoopIndex = outputObjectVariableForLoopMap.get(variableName);
					}
				} else {
					throw new DataMapperException("Unsupported schemaDataType found : " + variableType);
				}
			} else {
				throw new IllegalArgumentException("Unknown variable name found : " + variableName);
			}
			variableName += ".";
			firstIteration = false;
		}
		if (!operationAddedToUnassignedOperations) {
			operationForLoopBeansList.add(previousForLoopIndex);
		}
		return lastArrayVariable;
	}
	
	/**
	 * Given an outputvariable, if not exist, add its parents to OutputVariableForLoopMaps.
	 * 
	 * @param outputVariable variable to process
	 * @param variableMap map with all variables and their types
	 * @return whether any changed were made to OutputVariableForLoopMaps
	 * @throws DataMapperException throws when encountered an invalid elements
	 */
	private boolean updateOutputVariableForLoopMap(DMVariable outputVariable,
			Map<String, List<SchemaDataType>> variableMap)
			throws DataMapperException {
		boolean updated = false;
		String outputVariableName = outputVariable.getName();
		String[] variableNameArray = outputVariableName.split("\\.");
		String variableName = "";
		int previousForLoopIndex = 0;
		int previousObjectForLoopIndex = 0;
		for (String nextName : variableNameArray) {
			variableName += nextName;
			if (variableMap.containsKey(variableName)) {
				SchemaDataType variableType = variableMap.get(variableName)
						.get(VARIABLE_TYPE_INDEX);
				if (SchemaDataType.ARRAY.equals(variableType)) {
					if (!outputArrayVariableForLoopMap
							.containsKey(variableName)) {
						int targetForLoopIndex = getParentForLoopBeanIndex(
								previousForLoopIndex,
								previousObjectForLoopIndex);
						if (targetForLoopIndex < 0) {
							targetForLoopIndex = previousForLoopIndex;
						}
						outputArrayVariableForLoopMap.put(variableName,
								targetForLoopIndex);
						getForLoopBeanList().get(targetForLoopIndex)
								.getArrayVariableListToInstantiate()
								.add(variableName);
						previousForLoopIndex = targetForLoopIndex;
						updated = true;
					} else {
						previousForLoopIndex = outputArrayVariableForLoopMap
								.get(variableName);
					}
				} else if (SchemaDataType.OBJECT.equals(variableType)) {
					if (!outputObjectVariableForLoopMap
							.containsKey(variableName)) {
						int targetForLoopIndex = previousForLoopIndex;
						outputObjectVariableForLoopMap.put(variableName,
								targetForLoopIndex);
						getForLoopBeanList().get(targetForLoopIndex)
								.getObjectVariableListToInstantiate()
								.add(variableName);
						previousObjectForLoopIndex = targetForLoopIndex;
						updated = true;
					} else {
						previousObjectForLoopIndex = outputObjectVariableForLoopMap
								.get(variableName);
					}
				} else if (!ScriptGenerationUtil
						.isVariableTypePrimitive(variableType)) {
					// not even leaf variable element
					throw new DataMapperException(
							"Unsupported schemaDataType found : "
									+ variableType);
				}
			} else {
				throw new IllegalArgumentException(
						"Unknown variable name found : " + variableName);
			}
			variableName += ".";
		}
		return updated;
	}

	/**
	 * Method for retrieve the first child for loop of targetRootForLoopIndex
	 * which is a parent ForLoopBean of mostChildForLoopBean.
	 * 
	 * @param targetRootForLoopIndex
	 * @param mostChildForLoopBean
	 * @return
	 */
	private int getParentForLoopBeanIndex(int targetRootForLoopIndex, int mostChildForLoopBean) {
		if (targetRootForLoopIndex == mostChildForLoopBean) {
			return mostChildForLoopBean;
		}
		if (mostChildForLoopBean >= 0) {
			ForLoopBean childForLoopBean = getForLoopBeanList().get(mostChildForLoopBean);
			int forLoopBeanIndex = mostChildForLoopBean;
			while (childForLoopBean.getParentIndex() != targetRootForLoopIndex) {
				forLoopBeanIndex = childForLoopBean.getParentIndex();
				if (forLoopBeanIndex == rootBean.getParentIndex()) {
					// Doesn't exist a for loop bean which is a child of
					// targetRootForLoop and a parent of mostChildForLoop
					return -1;
				}
				childForLoopBean = getForLoopBeanList().get(forLoopBeanIndex);
			}
			return forLoopBeanIndex;
		}
		return -1;
	}

	private int getMostChildAssociatedVariableIndex(ArrayList<Integer> inputVariableIndexList,
			List<DMVariable> variableList) {
		String mostChildVariableName = "";
		int mostChildVariableIndex = -1;
		for (Integer variableIndex : inputVariableIndexList) {
			// If input variable index is -1 we should ignore it. It happens
			// when certain operator gets value from operator configuration.
			if (variableIndex >= 0) {
				DMVariable variable = variableList.get(variableIndex);
				String variableName = "";
				if (DMVariableType.INTERMEDIATE.equals(variable.getType())) {
					variableName = variableList.get(variable.getMostChildVariableIndex()).getName();
					if (mostChildVariableName.split("\\.").length < variableName.split("\\.").length) {
						mostChildVariableName = variableName;
						mostChildVariableIndex = variable.getMostChildVariableIndex();
					}
				} else {
					variableName = variableList.get(variableIndex).getName();
					if (mostChildVariableName.split("\\.").length < variableName.split("\\.").length) {
						mostChildVariableName = variableName;
						mostChildVariableIndex = variableIndex;
					}
				}
			}
		}
		return mostChildVariableIndex;
	}

	@SuppressWarnings("unchecked")
	private String transformForLoopBeansToJS(ForLoopBean forLoopBean, List<MappingOperation> mappingOperationList,
			Map<String, List<SchemaDataType>> map, List<String> unNamedVariables) 
			throws DataMapperException {
		StringBuilder functionBuilder = new StringBuilder();
		functionBuilder.append("\n");
		Stack<ForLoopBean> forLoopBeanParentStack = getParentForLoopBeanStack(forLoopBean);
		Stack<ForLoopBean> tempForLoopBeanParentStack = new Stack<ForLoopBean>();
		tempForLoopBeanParentStack = (Stack<ForLoopBean>) forLoopBeanParentStack.clone();
		boolean ifLoopCreated = false;
		if (!ROOT_TAG.equals(forLoopBean.getVariableName())) {
			// adding optional object element checks
			if (forLoopBean.getNullableVarialesList() != null && !forLoopBean.getNullableVarialesList().isEmpty()) {
				boolean firstElement = true;

				List<String> variableList = new ArrayList<>();
				variableList.addAll(forLoopBean.getNullableVarialesList());
				Collections.sort(variableList, new Comparator<String>() {
					public int compare(String s1, String s2) {
						int dist1 = Math.abs(s1.length());
						int dist2 = Math.abs(s2.length());
						return dist1 - dist2;
					}
				});
				for (String optionalVariable : variableList) {
					if (!isOptionalVariableCheckedBefore(optionalVariable,
							getForLoopBeanList().get(forLoopBean.getParentIndex()))) {
						ifLoopCreated = true;
						if (!firstElement) {
							functionBuilder.append(" && ");
						} else {
							functionBuilder.append("if( ");
							firstElement = false;
						}
						functionBuilder.append("(" + ScriptGenerationUtil.getPrettyVariableNameInForOperation(
								new DMVariable(optionalVariable, "", DMVariableType.INPUT, SchemaDataType.ARRAY, -1),
								map, tempForLoopBeanParentStack, false, null, null, 
								outputArrayRootVariableForLoop, 
								unNamedVariables) + ") ");
					}
				}
				if (ifLoopCreated) {
					functionBuilder.append("){");
					functionBuilder.append("\n");
				}
			}
			String forLoopVariableName = ScriptGenerationUtil.getPrettyVariableNameInForOperation(
					new DMVariable(forLoopBean.getVariableName(), "", DMVariableType.INPUT, SchemaDataType.ARRAY, -1),
					map, tempForLoopBeanParentStack, false, null, null, 
					outputArrayRootVariableForLoop, unNamedVariables);
			functionBuilder.append("for(" + forLoopBean.getIterativeName() + " in "
					+ forLoopVariableName.substring(0, forLoopVariableName.lastIndexOf("[")) + "){");
			functionBuilder.append("\n");
		}

		functionBuilder.append(
				ScriptGenerationUtil.instantiateForLoopCountVariables(forLoopBean, forLoopBean, getForLoopBeanList()));
		tempForLoopBeanParentStack = (Stack<ForLoopBean>) forLoopBeanParentStack.clone();
		// call operations and nested for loops
		List<Integer> operationsInForLoopList = forLoopBean.getOperationList();
		List<MappingOperation> forLoopBeanMappingOperations = new ArrayList<>();
		for (Integer index : operationsInForLoopList) {
			forLoopBeanMappingOperations.add(mappingOperationList.get(index));
		}
		forLoopBeanMappingOperations = sortMappingOperationList(forLoopBeanMappingOperations);
		for (MappingOperation mappingOperation : forLoopBeanMappingOperations) {
			// If output is not mapped to element of a operation, we do not need
			// it in the mapping configuration unless for global variables
			if (mappingOperation.getOutputVariables().isEmpty()
					&& !DataMapperOperatorType.GLOBAL_VARIABLE.equals(mappingOperation.getOperation())) {
				continue;
			}
			DMVariable outputVariable = mappingOperation.getOutputVariables().get(0);
			int outputMappedForLoop = 0;
			String mostChildArrayElement;
			try {
				mostChildArrayElement = ScriptGenerationUtil.getMostChildArrayElementName(outputVariable.getName(),
						variableMap);
				if (!mostChildArrayElement.isEmpty()
						&& outputArrayVariableForLoopMap.containsKey(mostChildArrayElement)) {
					outputMappedForLoop = outputArrayVariableForLoopMap.get(mostChildArrayElement);
				}
				ForLoopBean outputMappedForLoopBean;
				if (outputMappedForLoop >= 0 && !mappingOperation.isDoNotChangePosition()) {
					outputMappedForLoopBean = getForLoopBeanList().get(outputMappedForLoop);
					/*
					 * If this both output variable and mapping in the same for
					 * loop || array variable instantiate operation ||
					 * duplicating variable
					 */
					if ((outputMappedForLoop <= forLoopBean.getParentIndex())
							|| forLoopBean.equals(outputMappedForLoopBean)
							|| (DataMapperOperatorType.INSTANTIATE
									.equals(mappingOperation.getOperation().getOperatorType())
									&& SchemaDataType.ARRAY.equals(mappingOperation.getOperation()
											.getProperty(TransformerConstants.VARIABLE_TYPE)))) {
						functionBuilder.append(getJSCommandForOperation(mappingOperation, map,
								forLoopBean, unNamedVariables));
					} else {
						outputMappedForLoopBean.getOperationList().add(0,
								mappingOperationList.indexOf(mappingOperation));
					}
				} else {
					functionBuilder.append(getJSCommandForOperation(mappingOperation, map, 
							forLoopBean, unNamedVariables));
				}
			} catch (DataMapperException e) {
				log.warn(e);
			}
		}
		List<Integer> nestedForLoopList = forLoopBean.getNestedForLoopList();
		for (Integer nestedForLoopIndex : nestedForLoopList) {
			functionBuilder.append(
					transformForLoopBeansToJS(getForLoopBeanList().get(nestedForLoopIndex),
							mappingOperationList, map, unNamedVariables));
		}

		if (!ROOT_TAG.equals(forLoopBean.getVariableName())) {
			// incrementing for loop iterate variables
			ForLoopBean parentForLoop = forLoopBeanList.get(forLoopBean.getParentIndex());
			functionBuilder.append("\n");
			while (parentForLoop != null) {
				functionBuilder.append(ScriptGenerationUtil.getForLoopIterateName(forLoopBean, parentForLoop,
						getForLoopBeanList(), true) + "++;" + "\n");
				if (parentForLoop.getParentIndex() >= 0) {
					parentForLoop = forLoopBeanList.get(parentForLoop.getParentIndex());
				} else {
					break;
				}
			}
			functionBuilder.append("}");
			functionBuilder.append("\n");
			if (ifLoopCreated) {
				functionBuilder.append("}");
				functionBuilder.append("\n");
			}
		}
		return functionBuilder.toString();
	}

	@SuppressWarnings("unchecked")
	private String getJSCommandForOperation(MappingOperation mappingOperation, Map<String, List<SchemaDataType>> map,
			ForLoopBean forLoopBean, List<String> unNamedVariables) throws DataMapperException {
		StringBuilder operationBuilder = new StringBuilder();
		List<DMVariable> outputVariables = mappingOperation.getOutputVariables();
		if (outputVariables.size() > 1) {
			operationBuilder.append("[ ");
		} else if (outputVariables.size() == 1) {
			if ((DataMapperOperatorType.PROPERTIES.equals(mappingOperation.getOperation().getOperatorType())
					|| DataMapperOperatorType.CONSTANT.equals(mappingOperation.getOperation().getOperatorType()))
					&& DMVariableType.INTERMEDIATE.equals(outputVariables.get(0).getType())) {
				return "";
			}
		}
		Stack<ForLoopBean> forLoopBeanParentStack = getParentForLoopBeanStack(forLoopBean);
		Stack<ForLoopBean> tempForLoopBeanParentStack = new Stack<ForLoopBean>();
		tempForLoopBeanParentStack = (Stack<ForLoopBean>) forLoopBeanParentStack.clone();
		boolean ifLoopCreated = false;
		if (mappingOperation.getOptionalElementList() != null && !mappingOperation.getOptionalElementList().isEmpty()) {
			boolean firstElement = true;

			List<String> variableList = new ArrayList<>();
			variableList.addAll(mappingOperation.getOptionalElementList());
			Collections.sort(variableList, new Comparator<String>() {
				public int compare(String s1, String s2) {
					int dist1 = Math.abs(s1.length());
					int dist2 = Math.abs(s2.length());
					return dist1 - dist2;
				}
			});
			for (String optionalVariable : variableList) {
				if (!isOptionalVariableCheckedBefore(optionalVariable, forLoopBean)) {
					ifLoopCreated = true;
					if (!firstElement) {
						operationBuilder.append(" && ");
					} else {
						operationBuilder.append("if( ");
						firstElement = false;
					}
					operationBuilder.append("(" + ScriptGenerationUtil.getPrettyVariableNameInForOperation(
							new DMVariable(optionalVariable, "", DMVariableType.INPUT, SchemaDataType.ARRAY, -1), map,
							tempForLoopBeanParentStack, false, null, null,
							outputArrayRootVariableForLoop, 
							unNamedVariables) + ") ");
				}
			}
			if (ifLoopCreated) {
				operationBuilder.append("){");
				operationBuilder.append("\n");
			}
		}

		DMOperatorTransformer operatorTransformer = DMOperatorTransformerFactory
				.getDMOperatorTransformer(mappingOperation.getOperation().getOperatorType());

		operationBuilder.append(operatorTransformer.generateScriptForOperation(
				DifferentLevelArrayMappingConfigGenerator.class, mappingOperation.getInputVariables(),
				mappingOperation.getOutputVariables(), map, forLoopBeanParentStack, mappingOperation.getOperation(),
				getForLoopBeanList(), outputArrayVariableForLoopMap,
				outputArrayRootVariableForLoop, unNamedVariables));
		operationBuilder.append("\n");
		if (ifLoopCreated) {
			operationBuilder.append("}");
			operationBuilder.append("\n");
		}
		return operationBuilder.toString();
	}

	private boolean isOptionalVariableCheckedBefore(String optionalVariable, ForLoopBean forLoopBean) {
		if (!"root".equals(forLoopBean.getVariableName())) {
			if (!forLoopBean.getNullableVarialesList().isEmpty()
					&& forLoopBean.getNullableVarialesList().contains(optionalVariable)) {
				return true;
			} else {
				if (forLoopBean.getParentIndex() > 0 && getForLoopBeanList().size() > forLoopBean.getParentIndex()) {
					return isOptionalVariableCheckedBefore(optionalVariable,
							getForLoopBeanList().get(forLoopBean.getParentIndex()));
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

	private Stack<ForLoopBean> getParentForLoopBeanStack(ForLoopBean forLoopBean) {
		Stack<ForLoopBean> parentForLoopStack = new Stack<>();
		if (forLoopBean.getParentIndex() < 0) {
			return parentForLoopStack;
		} else {
			parentForLoopStack = getParentForLoopBeanStack(getForLoopBeanList().get(forLoopBean.getParentIndex()));
			parentForLoopStack.push(forLoopBean);
			return parentForLoopStack;
		}
	}

	public ForLoopBean getRootBean() {
		return rootBean;
	}

	public void setRootBean(ForLoopBean rootBean) {
		this.rootBean = rootBean;
	}

	private boolean isValidOperationWithInputVariables(List<String> operationElementsParentList)
			throws DataMapperException {
		// parent variables should be in a same branch
		if (operationElementsParentList.isEmpty()) {
			return true;
		}
		String mostChildParentName = operationElementsParentList.get(0);
		for (int i = 1; i < operationElementsParentList.size(); i++) {
			String parentName = operationElementsParentList.get(i);
			if (mostChildParentName.length() > parentName.length()) {
				checkTwoParentsInTheSameBranch(mostChildParentName, parentName);
			} else {
				checkTwoParentsInTheSameBranch(parentName, mostChildParentName);
				mostChildParentName = parentName;
			}
		}
		return true;
	}

	private void checkTwoParentsInTheSameBranch(String mostChildParentName, String parentName)
			throws DataMapperException {
		if (!mostChildParentName.startsWith(parentName)) {
			throw new DataMapperException("Cannot use varibales in different types of objects to map."
					+ " Cannot find a unique identifier for the items mapped. Re-Evaluate your mappping.");
		}
	}

	private int getMostInnerForLoopBeanFromList(List<Integer> operationForLoopBeansList) {
		if (operationForLoopBeansList.isEmpty()) {
			return -1;
		}
		int mostChildForLoopIndex = operationForLoopBeansList.get(0);
		for (int i = 1; i < operationForLoopBeansList.size(); i++) {
			int thisForLoopBeanIndex = operationForLoopBeansList.get(i);
			if (getForLoopBeanList().get(mostChildForLoopIndex).getVariableName().length() < getForLoopBeanList()
					.get(thisForLoopBeanIndex).getVariableName().length()) {
				mostChildForLoopIndex = thisForLoopBeanIndex;
			}
		}
		return mostChildForLoopIndex;
	}

	private void addForLoopBeanIndexToParent(String variableName, int indexOfForLoopBean, String parentVariable) {
		if (!StringUtils.isEmpty(parentVariable)) {
			int parentIndex = getForLoopBeanMap().get(parentVariable);
			getForLoopBeanList().get(indexOfForLoopBean).setParentIndex(parentIndex);
			getForLoopBeanList().get(parentIndex).getNestedForLoopList().add(indexOfForLoopBean);
		} else {
			// root bean
			getForLoopBeanList().get(0).getNestedForLoopList().add(indexOfForLoopBean);
		}
	}

	private boolean forLoopBeanNotExist(String variableName) {
		return !getForLoopBeanMap().containsKey(variableName);
	}

	@Override
	public boolean validate(DataMapperDiagramModel model) {
		return true;
	}

	public Map<String, Integer> getForLoopBeanMap() {
		return forLoopBeanMap;
	}

	public void setForLoopBeanMap(Map<String, Integer> forLoopBeanMap) {
		this.forLoopBeanMap = forLoopBeanMap;
	}

	public List<ForLoopBean> getForLoopBeanList() {
		return forLoopBeanList;
	}

	public void setForLoopBeanList(List<ForLoopBean> forLoopBeanList) {
		this.forLoopBeanList = forLoopBeanList;
	}

	private int addForLoopInToMap(String variableName, ForLoopBean forLoopBean) {
		getForLoopBeanList().add(forLoopBean);
		int indexOfForLoopBean = getForLoopBeanList().size() - 1;
		forLoopBeanMap.put(variableName, indexOfForLoopBean);
		return indexOfForLoopBean;
	}

}

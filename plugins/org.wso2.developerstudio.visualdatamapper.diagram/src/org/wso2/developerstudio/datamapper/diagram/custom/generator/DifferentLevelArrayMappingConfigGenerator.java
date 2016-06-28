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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.apache.commons.lang.StringUtils;
import org.wso2.developerstudio.datamapper.DataMapperOperatorType;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator.DMOperatorTransformerFactory;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator.transformers.DMOperatorTransformer;
import org.wso2.developerstudio.datamapper.diagram.custom.exception.DataMapperException;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMOperation;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariable;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariableType;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DataMapperDiagramModel;
import org.wso2.developerstudio.datamapper.diagram.custom.model.transformers.TransformerConstants;
import org.wso2.developerstudio.datamapper.diagram.custom.util.ScriptGenerationUtil;

/**
 * This class extends abstract class {@link AbstractMappingConfigGenerator} and
 * generates mapping configuration from a {@link DataMapperDiagramModel} for
 * simple same level record and array type schema's
 *
 */
public class DifferentLevelArrayMappingConfigGenerator extends AbstractMappingConfigGenerator {

	private static final String ROOT_TAG = "root";
	private static final int FIRST_ELEMENT_INDEX = 0;

	private static final String SCHEMA_ATTRIBUTE_PREFIX = "@";
	private static final int VARIABLE_TYPE_INDEX = 0;

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

	@Override
	public String generateMappingConfig(DataMapperDiagramModel model) throws DataMapperException {
		initializeAlgorithmFields();
		List<MappingOperation> mappingOperationList = populateOperationListFromModel(model);
		String mainFunction = generateMainFunction(mappingOperationList, model);
		String customFunctions = generateCustomFunctions(model);
		return mainFunction + customFunctions;
	}

	protected String generateCustomFunctions(DataMapperDiagramModel model) {
		StringBuilder functionBuilder = new StringBuilder();
		for (DMOperation operation : model.getOperationsList()) {
			if (DataMapperOperatorType.CUSTOM_FUNCTION.equals(operation.getOperatorType())) {
				functionBuilder.append(operation.getProperty(TransformerConstants.CUSTOM_FUNCTION_NAME) + " = "
						+ addFunctionDefinition(operation));
			}
			functionBuilder.append("\n");
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

	private void initializeAlgorithmFields() {
		forLoopBeanMap = new HashMap<>();
		outputArrayVariableForLoopMap = new HashMap<>();
		outputObjectVariableForLoopMap = new HashMap<>();
		forLoopBeanList = new ArrayList<>();
		rootBean = new ForLoopBean(ROOT_TAG, ROOT_TAG, false);
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
		Map<String, List<SchemaDataType>> variableMap = model.getVariableTypeMap();
		StringBuilder functionBuilder = new StringBuilder();
		ArrayList<MappingOperation> unassignedMappingOperations = new ArrayList<>();
		int unassignedOperationCount = 0;
		List<MappingOperation> mappingOperationListTemp = (List<MappingOperation>) ((ArrayList<MappingOperation>) mappingOperationList)
				.clone();
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
				List<String> operationElementsParentList = new ArrayList<>();
				if (inputVariables.isEmpty()) {
					// Add 0 to operationForLoopBeanList when operation not have
					// input variables
					// operationForLoopBeansList.add(0);
				} else {
					for (DMVariable dmVariable : inputVariables) {
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
								mostChildVariableName = model.getVariablesArray().get(mostChildVariableIndex).getName();
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
											int indexOfForLoopBean = addForLoopInToMap(variableName, new ForLoopBean(
													"i_" + nextName, variableName,
													variableMap.get(variableName).contains(SchemaDataType.NULL)));
											addForLoopBeanIndexToParent(variableName, indexOfForLoopBean,
													parentArrayVariable);
											parentArrayVariable = variableName;
										} else {
											parentArrayVariable = variableName;
										}
									} else if (ScriptGenerationUtil.isVariableTypePrimitive(variableType)) {
										// leaf variable element
									} else if (SchemaDataType.OBJECT.equals(variableType)) {
										// record variable element
									} else {
										throw new DataMapperException(
												"Unsupported schemaDataType in WSO2 Data Mapper found : "
														+ variableType);
									}
								} else {
									throw new IllegalArgumentException("Unknown variable name found : " + variableName);
								}
								variableName += ".";
								firstIteration = false;
							}
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
							operationElementsParentList.add(parentVariableName);
						}
					}
				}

				// validate the for loop beans of the variables. They should be
				// in
				// one branch.
				int indexOfMostInnerForLoopBean = -1;
				if (isValidOperationWithInputVariables(operationElementsParentList)) {
					indexOfMostInnerForLoopBean = getMostInnerForLoopBeanFromList(operationForLoopBeansList);
				}
				for (DMVariable outputVariable : outputVariables) {
					if (DMVariableType.INTERMEDIATE.equals(outputVariable.getType())
							&& !outputVariable.getName().contains("{")) {
						functionBuilder.append("var " + outputVariable.getName() + " = [];");
						functionBuilder.append("\n");
					} else if (DMVariableType.OUTPUT.equals(outputVariable.getType())) {
						updateOutputVariableForLoopMap(outputVariable, variableMap, indexOfMostInnerForLoopBean,
								operationForLoopBeansList, unassignedMappingOperations, mappingOperation);
					}
				}
				indexOfMostInnerForLoopBean = getMostInnerForLoopBeanFromList(operationForLoopBeansList);

				// find the most inner for loop bean to assign this operation
				if (indexOfMostInnerForLoopBean >= 0) {
					// Instantiate operation of array type variables should go
					// to
					// parent
					// for loop bean
					if (DataMapperOperatorType.INSTANTIATE.equals(mappingOperation.getOperation().getOperatorType())
							&& SchemaDataType.ARRAY.equals(
									mappingOperation.getOperation().getProperty(TransformerConstants.VARIABLE_TYPE))) {
						indexOfMostInnerForLoopBean = getForLoopBeanList().get(indexOfMostInnerForLoopBean)
								.getParentIndex();
					}
					getForLoopBeanList().get(indexOfMostInnerForLoopBean).getOperationList()
							.add(mappingOperation.getIndex());
				}
			}
			if (unassignedOperationCount == unassignedMappingOperations.size()) {
				assignUnresolvableOperationsToRoot(unassignedMappingOperations);
			}
		} while (!unassignedMappingOperations.isEmpty());
		// All operations are now assign to ForLoopBean map. Transform
		// forLoopBean map for JS script.
		functionBuilder
				.append(transformForLoopBeansToJS(getRootBean(), mappingOperationList, model.getVariableTypeMap()));
		return functionBuilder.toString();
	}

	private void assignUnresolvableOperationsToRoot(List<MappingOperation> unassignedMappingOperations) {
		for (MappingOperation mappingOperation : unassignedMappingOperations) {
			getForLoopBeanList().get(0).getOperationList().add(mappingOperation.getIndex());
		}
		unassignedMappingOperations.clear();
	}

	private void updateOutputVariableForLoopMap(DMVariable outputVariable,
			Map<String, List<SchemaDataType>> variableMap, int indexOfMostInnerForLoopBean,
			List<Integer> operationForLoopBeansList, List<MappingOperation> unassignedMappingOperations,
			MappingOperation mappingOperation) throws DataMapperException {
		String outputVariableName = outputVariable.getName();
		String[] variableNameArray = outputVariableName.split("\\.");
		String variableName = "";
		String parentVariableName = "";
		String parentArrayVariable = "";
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
							// int indexOfForLoopBean =
							// addForLoopInToMap(variableName, new
							// ForLoopBean("i_" + nextName,
							// variableName,
							// variableMap.get(variableName).contains(SchemaDataType.NULL)));
							// addForLoopBeanIndexToParent(variableName,
							// indexOfForLoopBean,
							// getForLoopBeanList().get(previousForLoopIndex).getVariableName());
							// targetForLoopIndex = indexOfForLoopBean;
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
		return mostChildVariableIndex;
	}

	@SuppressWarnings("unchecked")
	private String transformForLoopBeansToJS(ForLoopBean forLoopBean, List<MappingOperation> mappingOperationList,
			Map<String, List<SchemaDataType>> map) {
		StringBuilder functionBuilder = new StringBuilder();
		functionBuilder.append("\n");
		Stack<ForLoopBean> forLoopBeanParentStack = getParentForLoopBeanStack(forLoopBean);
		Stack<ForLoopBean> tempForLoopBeanParentStack = new Stack<ForLoopBean>();
		tempForLoopBeanParentStack = (Stack<ForLoopBean>) forLoopBeanParentStack.clone();

		if (!ROOT_TAG.equals(forLoopBean.getVariableName())) {
			String forLoopVariableName = ScriptGenerationUtil.getPrettyVariableNameInForOperation(
					new DMVariable(forLoopBean.getVariableName(), "", DMVariableType.INPUT, SchemaDataType.ARRAY, -1),
					map, tempForLoopBeanParentStack, false);
			functionBuilder.append("for(" + forLoopBean.getIterativeName() + " in "
					+ forLoopVariableName.substring(0, forLoopVariableName.lastIndexOf("[")) + "){");
			functionBuilder.append("\n");
		}
		tempForLoopBeanParentStack = (Stack<ForLoopBean>) forLoopBeanParentStack.clone();
		// call operations and nested for loops
		List<Integer> operationsInForLoopList = forLoopBean.getOperationList();
		for (Integer operationIndex : operationsInForLoopList) {
			functionBuilder
					.append(getJSCommandForOperation(mappingOperationList.get(operationIndex), map, forLoopBean));
		}
		List<Integer> nestedForLoopList = forLoopBean.getNestedForLoopList();
		for (Integer nestedForLoopIndex : nestedForLoopList) {
			functionBuilder.append(
					transformForLoopBeansToJS(getForLoopBeanList().get(nestedForLoopIndex), mappingOperationList, map));
		}

		if (!ROOT_TAG.equals(forLoopBean.getVariableName())) {
			functionBuilder.append("\n");
			functionBuilder.append("}");
			functionBuilder.append("\n");
		}
		return functionBuilder.toString();
	}

	@SuppressWarnings("unchecked")
	private String getJSCommandForOperation(MappingOperation mappingOperation, Map<String, List<SchemaDataType>> map,
			ForLoopBean forLoopBean) {
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
		int numOfOutputVariables = outputVariables.size();
		for (int variableIndex = 0; variableIndex < numOfOutputVariables; variableIndex++) {
			String prettyVariableName = null;
			// Instantiate operation does not need to have the ELEMVAL tag
			if (mappingOperation.getOperation().getOperatorType().equals(DataMapperOperatorType.INSTANTIATE)) {
				prettyVariableName = ScriptGenerationUtil.getPrettyVariableNameInForOperation(
						outputVariables.get(variableIndex), map, tempForLoopBeanParentStack, false);
				if (SchemaDataType.ARRAY
						.equals(mappingOperation.getOperation().getProperty(TransformerConstants.VARIABLE_TYPE))) {
					prettyVariableName = prettyVariableName.substring(0, prettyVariableName.lastIndexOf('['));
				}
			} else {
				prettyVariableName = ScriptGenerationUtil.getPrettyVariableNameInForOperation(
						outputVariables.get(variableIndex), map, tempForLoopBeanParentStack, true);
			}
			operationBuilder.append(prettyVariableName);
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
				DifferentLevelArrayMappingConfigGenerator.class, mappingOperation.getInputVariables(), map,
				forLoopBeanParentStack, mappingOperation.getOperation()));
		operationBuilder.append("\n");
		return operationBuilder.toString();
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

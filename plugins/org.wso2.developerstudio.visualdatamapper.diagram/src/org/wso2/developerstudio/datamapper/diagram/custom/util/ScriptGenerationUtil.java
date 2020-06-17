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
package org.wso2.developerstudio.datamapper.diagram.custom.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.diagram.custom.exception.DataMapperException;
import org.wso2.developerstudio.datamapper.diagram.custom.generator.ForLoopBean;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariable;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariableType;

/**
 * This class contains common utility methods used by script generation
 * algorithms
 *
 */
public class ScriptGenerationUtil {

	private static final String DOT_REPRESENTATION = "_DOT_";
	private static final int VARIABLE_TYPE_INDEX = 0;
	private static final String HYPHEN_PREFIX = "_EnC0DeCHaRHyPh3n_";
	private static final String SQ_BRACKET_OPEN = "[";
	private static final String SQ_BRACKET_CLOSE = "]";
	public static final String VALID_VARIABLE_NAME_REGEX = "^[a-zA-Z][a-zA-Z_$0-9]*$";

	public static String getPrettyVariableNameInForOperation(DMVariable variable, Map<String, List<SchemaDataType>> map,
			Stack<ForLoopBean> parentForLoopBeanStackTemp, boolean isOperationVariable,
			List<ForLoopBean> forLoopBeanList, Map<String, Integer> outputArrayVariableForLoop,
			Map<String, Integer> outputRootArrayVariableForLoop, List<String> unNamedVariables) 
			throws DataMapperException {
		@SuppressWarnings("unchecked")
		Stack<ForLoopBean> parentForLoopBeanStack = (Stack<ForLoopBean>) parentForLoopBeanStackTemp.clone();
		// put index values for array type variables
		String prettyVariableName = "";
		String variableName = "";
		SchemaDataType variableType = null;
		if (DMVariableType.INTERMEDIATE.equals(variable.getType())) {
			variableName = variable.getName();
			if (variableName.startsWith("{")) {
				prettyVariableName = variableName.substring(1, variableName.length() - 1);
				if (SchemaDataType.STRING.equals(variable.getSchemaVariableType())) {
					prettyVariableName = "'" + prettyVariableName + "'";
				}
			} else {
				prettyVariableName = variable.getName();
			}
		} else if (DMVariableType.OUTPUT.equals(variable.getType())
				&& getArrayElementCount(variable.getName(), map) == 1) {
			// implement list to single mapping
			String[] variableNameArray = variable.getName().split("\\.");
			boolean isPerviousVariableTypePrimitive = false;
			for (String nextName : variableNameArray) {
				variableName += nextName;
				if (map.containsKey(variableName)) {
					variableType = map.get(variableName).get(VARIABLE_TYPE_INDEX);
					if (SchemaDataType.ARRAY.equals(variableType)) {
						if (!outputArrayVariableForLoop.containsKey(variableName)) {
							throw new DataMapperException("Unknown variable name found : " + variableName);
						}
						int forLoopIndex = outputArrayVariableForLoop.get(variableName);
						ForLoopBean tempForLoop = forLoopBeanList.get(forLoopIndex);
						String mostInnerArrayVariableName = getMostChildArrayElementName(variable.getName(),map);
						String iterateName;
						if (variable.getMappedInputVariableArrayElement() != null
								&& variableName.equals(mostInnerArrayVariableName)) {
							if (variable.getMappedInputVariableRootArrayElement() != null) {
								iterateName = getForLoopIterateName(
										getForLoopFromMappedVariableArrayName(
												variable.getMappedInputVariableArrayElement(), forLoopBeanList),
										getForLoopFromMappedVariableArrayName(
												variable.getMappedInputVariableRootArrayElement(), forLoopBeanList),
										forLoopBeanList, true);
							} else {
								tempForLoop = getForLoopFromMappedVariableArrayName(
										variable.getMappedInputVariableArrayElement(), forLoopBeanList);
								iterateName = getForLoopIterateName(tempForLoop, null, forLoopBeanList, true);
							}
						} else {
							int rootForLoopIndex = 0;
							ForLoopBean rootTempForLoop = null;
							if (outputRootArrayVariableForLoop.containsKey(variableName)) {
								rootForLoopIndex = outputRootArrayVariableForLoop.get(variableName);
								rootTempForLoop = forLoopBeanList.get(rootForLoopIndex);
							}
							if (rootTempForLoop != null) {
								iterateName = getForLoopIterateName(tempForLoop, rootTempForLoop, forLoopBeanList,
										true);
							} else if (tempForLoop.getParentIndex() >= 0) {
								iterateName = getForLoopIterateName(tempForLoop,
										forLoopBeanList.get(tempForLoop.getParentIndex()), forLoopBeanList, true);
							} else {
								iterateName = getForLoopIterateName(tempForLoop, null, forLoopBeanList, true);
							}
						}
						if (iterateName.isEmpty()) {
							iterateName = "0";
						}
						// Discard unnamed variables.
						if (unNamedVariables.contains(variableName)) {
							prettyVariableName += SQ_BRACKET_OPEN + iterateName +
									SQ_BRACKET_CLOSE;
						} else {
							prettyVariableName += getValidNextName(nextName) +
									SQ_BRACKET_OPEN + iterateName + SQ_BRACKET_CLOSE;
						}
					} else if (nextName.startsWith("@") && isPerviousVariableTypePrimitive) {
						prettyVariableName += "ATTR" + getValidNextName(nextName.replaceFirst("@", "attr_"));
					} else if (nextName.startsWith("@")) {
						prettyVariableName += getValidNextName(nextName.replaceFirst("@", "attr_"));
					} else {
						prettyVariableName += getValidNextName(nextName);
					}
					if (SchemaDataType.DOUBLE.equals(variableType) || SchemaDataType.INT.equals(variableType)
							|| SchemaDataType.BOOLEAN.equals(variableType)
							|| SchemaDataType.STRING.equals(variableType)) {
						isPerviousVariableTypePrimitive = true;
					} else {
						isPerviousVariableTypePrimitive = false;
					}
				} else {
					throw new DataMapperException(
							"Unregistered Variable name found : " + variableName + " in - [" + map.keySet() + "]");
				}
				variableName += ".";
			}
			prettyVariableName = prettyVariableName.substring(1);
		} else if (DMVariableType.OUTPUT.equals(variable.getType())) {
			String[] variableNameArray = variable.getName().split("\\.");
			boolean isPerviousVariableTypePrimitive = false;
			for (String nextName : variableNameArray) {
				variableName += nextName;
				if (map.containsKey(variableName)) {
					variableType = map.get(variableName).get(VARIABLE_TYPE_INDEX);
					if (SchemaDataType.ARRAY.equals(variableType)) {
						if (!outputArrayVariableForLoop.containsKey(variableName)) {
							throw new DataMapperException("Unknown variable name found : " + variableName);
						}
						int forLoopIndex = outputArrayVariableForLoop.get(variableName);
						ForLoopBean tempForLoop = forLoopBeanList.get(forLoopIndex);
						String mostInnerArrayVariableName = getMostChildArrayElementName(variable.getName(),map);
						String iterateName;
						if (variable.getMappedInputVariableArrayElement() != null
								&& variableName.equals(mostInnerArrayVariableName)) {
							if (variable.getMappedInputVariableRootArrayElement() != null) {
								iterateName = getForLoopIterateName(
										getForLoopFromMappedVariableArrayName(
												variable.getMappedInputVariableArrayElement(), forLoopBeanList),
										getForLoopFromMappedVariableArrayName(
												variable.getMappedInputVariableRootArrayElement(), forLoopBeanList),
										forLoopBeanList, true);
							} else {
								tempForLoop = getForLoopFromMappedVariableArrayName(
										variable.getMappedInputVariableArrayElement(), forLoopBeanList);
								iterateName = getForLoopIterateName(tempForLoop, null, forLoopBeanList, true);
							}
						} else {
							int rootForLoopIndex = 0;
							ForLoopBean rootTempForLoop = null;
							if (outputRootArrayVariableForLoop.containsKey(variableName)) {
								rootForLoopIndex = outputRootArrayVariableForLoop.get(variableName);
								rootTempForLoop = forLoopBeanList.get(rootForLoopIndex);
							}
							if (rootTempForLoop != null) {
								iterateName = getForLoopIterateName(tempForLoop, rootTempForLoop, forLoopBeanList,
										true);
							} else if (tempForLoop.getParentIndex() >= 0) {
								iterateName = getForLoopIterateName(tempForLoop,
										forLoopBeanList.get(tempForLoop.getParentIndex()), forLoopBeanList, true);
							} else {
								iterateName = getForLoopIterateName(tempForLoop, null, forLoopBeanList, true);
							}
						}

						if (iterateName.isEmpty()) {
							iterateName = "0";
						}
						// Discard unnamed variables.
						if (unNamedVariables.contains(variableName)) {
							prettyVariableName += SQ_BRACKET_OPEN + iterateName + 
									SQ_BRACKET_CLOSE;
						} else {
							prettyVariableName += getValidNextName(nextName) + 
									SQ_BRACKET_OPEN + iterateName + SQ_BRACKET_CLOSE;
						}
					} else if (nextName.startsWith("@") && isPerviousVariableTypePrimitive) {
						prettyVariableName += "ATTR" + getValidNextName(nextName.replaceFirst("@", "attr_"));
					} else if (nextName.startsWith("@")) {
						prettyVariableName += getValidNextName(nextName.replaceFirst("@", "attr_"));
					} else {
						prettyVariableName += getValidNextName(nextName);
					}
					if (SchemaDataType.DOUBLE.equals(variableType) || SchemaDataType.INT.equals(variableType)
							|| SchemaDataType.BOOLEAN.equals(variableType)
							|| SchemaDataType.STRING.equals(variableType)) {
						isPerviousVariableTypePrimitive = true;
					} else {
						isPerviousVariableTypePrimitive = false;
					}
				} else {
					throw new DataMapperException(
							"Unregistered Variable name found : " + variableName + " in - [" + map.keySet() + "]");
				}
				variableName += ".";
			}
			prettyVariableName = prettyVariableName.substring(1);
		} else {
			Stack<ForLoopBean> parentVariableBottomUpStack = getReversedStack(parentForLoopBeanStack);
			String[] variableNameArray = variable.getName().split("\\.");
			boolean isPerviousVariableTypePrimitive = false;
			for (String nextName : variableNameArray) {
				variableName += nextName;
				if (map.containsKey(variableName)) {
					variableType = map.get(variableName).get(VARIABLE_TYPE_INDEX);
					if (SchemaDataType.ARRAY.equals(variableType)) {
						String iterateName = "";
						if (parentVariableBottomUpStack.isEmpty()) {
							iterateName = "0";
						} else {
							iterateName = parentVariableBottomUpStack.pop().getIterativeName();
						}
						// Discard unnamed variables.
						if (unNamedVariables.contains(variableName)) {
							prettyVariableName += SQ_BRACKET_OPEN + iterateName +
									SQ_BRACKET_CLOSE;
						} else {
							prettyVariableName += getValidNextName(nextName) +
									SQ_BRACKET_OPEN + iterateName + SQ_BRACKET_CLOSE;
						}
					} else if (nextName.startsWith("@") && isPerviousVariableTypePrimitive) {
						prettyVariableName += "ATTR" + getValidNextName(nextName.replaceFirst("@", "attr_"));
					} else if (nextName.startsWith("@")) {
						prettyVariableName += getValidNextName(nextName.replaceFirst("@", "attr_"));
					} else {
						prettyVariableName += getValidNextName(nextName);
					}
					if (SchemaDataType.DOUBLE.equals(variableType) || SchemaDataType.INT.equals(variableType)
							|| SchemaDataType.BOOLEAN.equals(variableType)
							|| SchemaDataType.STRING.equals(variableType)) {
						isPerviousVariableTypePrimitive = true;
					} else {
						isPerviousVariableTypePrimitive = false;
					}
				} else {
					throw new DataMapperException(
							"Unregistered Variable name found : " + variableName + " in - [" + map.keySet() + "]");
				}
				variableName += ".";
			}
			prettyVariableName = prettyVariableName.substring(1);
		}
		// If the variable is a input or output for an operation and a type of
		// object or array and also holds a value,
		// the value is stored as a field named _ELEMVAl
		// And primitive arrays without attributes should not contain ._ELEMVAL
		if (isOperationVariable) {
			if (SchemaDataType.OBJECT.equals(variableType)
					|| (SchemaDataType.ARRAY.equals(variableType) && hasAttributeOrChild(variable.getName(), map))) {
				prettyVariableName += "._ELEMVAL";
			}
		}
		return prettyVariableName;
	}
	
	public static SchemaDataType getLastVariableTypeInForOperation(DMVariable variable, Map<String, List<SchemaDataType>> map)
			throws DataMapperException {
		SchemaDataType inputVariableType = null;
		String variableName = "";
		if (DMVariableType.INPUT.equals(variable.getType())) {
			String[] variableNameArray = variable.getName().split("\\.");
			for (String nextName : variableNameArray) {
				variableName += nextName;
				if (map.containsKey(variableName)) {
					inputVariableType = map.get(variableName).get(VARIABLE_TYPE_INDEX);
				}
			}
		}
		return inputVariableType;
	}

	public static ForLoopBean getForLoopFromMappedVariableArrayName(String mappedInputVariableArrayElement,
			List<ForLoopBean> forLoopBeanList) {
		for (ForLoopBean forLoopBean : forLoopBeanList) {
			if(forLoopBean.getVariableName().equals(removeInvalidCharaters(mappedInputVariableArrayElement))){
				return forLoopBean;
			}
		}
		throw new IllegalArgumentException(mappedInputVariableArrayElement + " could not be found in a for loop");
	}

	private static String getValidNextName(String nextName) {
		// Create a Pattern object
		Pattern pattern = Pattern.compile(VALID_VARIABLE_NAME_REGEX);
		// Now create matcher object.
		Matcher matcher = pattern.matcher(nextName);
		if (matcher.find() && !nextName.contains(DOT_REPRESENTATION)) {
			return "." + nextName;
		} else if (nextName.contains(DOT_REPRESENTATION)) {
		    return "['" + nextName.replace(DOT_REPRESENTATION, ".") + "']";
		} else {
			return "['" + nextName + "']";
		}
	}

	private static boolean hasAttributeOrChild(String name, Map<String, List<SchemaDataType>> map) {
		Set<String> variableSet = map.keySet();
		int numberOfVariables = 0;
		for (String variableName : variableSet) {
			if (variableName.contains(name)) {
				// if there are two variables which contains target name that
				// means it has a child or attribute
				if (numberOfVariables > 0) {
					return true;
				}
				numberOfVariables++;
			}
		}
		return false;
	}

	public static String removeInvalidCharaters(String variableName) {
		// If variable is an constant it will be as {constant_value}. We should
		// not remove any characters from constants
		if (variableName.startsWith("{")) {
			return variableName;
		}
		return variableName.replace(':', '_').replace(",", "_Separat0r_").replace('=', '_').replace("-", HYPHEN_PREFIX);
	}

	private static String getAccumulatedIterativeVariableString(Stack<ForLoopBean> parentForLoopBeanStack) {
		String accumulatedIterativeVariableString = "";
		while (parentForLoopBeanStack.size() > 0) {
			accumulatedIterativeVariableString += "parseInt(" + parentForLoopBeanStack.pop().getIterativeName() + ")";
			if (parentForLoopBeanStack.size() > 0) {
				accumulatedIterativeVariableString += "+";
			}
		}
		return accumulatedIterativeVariableString;
	}

	private static int getArrayElementCount(String name, Map<String, List<SchemaDataType>> map) {
		int arrayTypeVariableCount = 0;
		String[] variableNameArray = name.split("\\.");
		String variableName = "";
		for (String nextName : variableNameArray) {
			variableName += nextName;
			if (map.containsKey(variableName)) {
				SchemaDataType variableType = map.get(variableName).get(VARIABLE_TYPE_INDEX);
				if (SchemaDataType.ARRAY.equals(variableType)) {
					arrayTypeVariableCount++;
				}
			} else {
				throw new IllegalArgumentException(
						"Unregistered Variable name found : " + variableName + " in - [" + map.keySet() + "]");
			}
			variableName += ".";
		}
		return arrayTypeVariableCount;
	}

	private static Stack<ForLoopBean> getReversedStack(Stack<ForLoopBean> parentForLoopBeanStack) {
		@SuppressWarnings("unchecked")
		Stack<ForLoopBean> tempForLoopBean = (Stack<ForLoopBean>) parentForLoopBeanStack.clone();
		Stack<ForLoopBean> reversedParentForLoopBeanStack = new Stack<>();
		while (!tempForLoopBean.isEmpty()) {
			reversedParentForLoopBeanStack.push(tempForLoopBean.pop());
		}
		return reversedParentForLoopBeanStack;
	}

	public static boolean isVariableTypePrimitive(SchemaDataType variableType) {
		if (SchemaDataType.STRING.equals(variableType) || SchemaDataType.INT.equals(variableType)
				|| SchemaDataType.DOUBLE.equals(variableType) || SchemaDataType.BOOLEAN.equals(variableType)
				|| SchemaDataType.NUMBER.equals(variableType)) {
			return true;
		}
		return false;
	}

	public static String instantiateForLoopCountVariables(ForLoopBean forLoopBean, ForLoopBean rootForLoopBean,
			List<ForLoopBean> forLoopBeanList) {
		StringBuilder operationBuilder = new StringBuilder();
		if (forLoopBean.getParentIndex() != -1 && !rootForLoopBean.equals(forLoopBean)) {
			operationBuilder
					.append("var " + getForLoopIterateName(forLoopBean, rootForLoopBean, forLoopBeanList, true) + " = 0;" + "\n");
		}
		List<Integer> nestedForLoopList = forLoopBean.getNestedForLoopList();
		for (Iterator<Integer> iterator = nestedForLoopList.iterator(); iterator.hasNext();) {
			Integer index = (Integer) iterator.next();
			ForLoopBean tempForLoopBean = forLoopBeanList.get(index);
			operationBuilder.append(instantiateForLoopCountVariables(tempForLoopBean,rootForLoopBean, forLoopBeanList));
		}
		return operationBuilder.toString();
	}

	public static String getForLoopIterateName(ForLoopBean tempForLoopBean, ForLoopBean rootForLoopBean,
			List<ForLoopBean> forLoopBeanList, Boolean calledFromOutSide) {
		StringBuilder operationBuilder = new StringBuilder();
		if (null == rootForLoopBean || tempForLoopBean.getParentIndex() == -1
				|| (rootForLoopBean != null && rootForLoopBean.equals(tempForLoopBean))) {
			return operationBuilder.toString();
		}
		// Iterative name should only contain "count" in the front
		if (calledFromOutSide) {
			operationBuilder.append("count");
		}
		operationBuilder.append("_" + tempForLoopBean.getIterativeName() + getForLoopIterateName(
				forLoopBeanList.get(tempForLoopBean.getParentIndex()), rootForLoopBean, forLoopBeanList, false));
		return operationBuilder.toString();
	}
	
	public static String getMostChildArrayElementName(String fullVariableName,
			Map<String, List<SchemaDataType>> variableMap) throws DataMapperException {
		String[] variableNameArray = fullVariableName.split("\\.");
		String variableName = "";
		String lastArrayVariable = "";
		for (String nextName : variableNameArray) {
			variableName += nextName;
			if (variableMap.containsKey(variableName)) {
				SchemaDataType variableType = variableMap.get(variableName).get(VARIABLE_TYPE_INDEX);
				if (SchemaDataType.ARRAY.equals(variableType)) {
					lastArrayVariable = variableName;
				}
			} else {
				throw new DataMapperException("Unknown variable name found : " + variableName);
			}
			variableName += ".";
		}
		return lastArrayVariable;
	}
}

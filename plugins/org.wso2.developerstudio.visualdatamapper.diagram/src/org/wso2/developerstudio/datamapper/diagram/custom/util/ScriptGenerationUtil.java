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

import java.util.Map;
import java.util.Stack;

import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.diagram.custom.generator.ForLoopBean;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariable;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariableType;

/**
 * This class contains common utility methods used by script generation
 * algorithms
 *
 */
public class ScriptGenerationUtil {

    public static String getPrettyVariableNameInForOperation(DMVariable variable,
            Map<String, SchemaDataType> variableTypeMap, Stack<ForLoopBean> parentForLoopBeanStack) {
        // put index values for array type variables
        String prettyVariableName = "";
        String variableName = "";
        if (DMVariableType.INTERMEDIATE.equals(variable.getType())) {
            if (parentForLoopBeanStack.size() > 0) {
                prettyVariableName = variable.getName() + "[";
                prettyVariableName += (getForLoopIteratorNames(parentForLoopBeanStack)) + "]";
            } else {
                prettyVariableName = variable.getName();
            }
        } else if (DMVariableType.OUTPUT.equals(variable.getType())
                && getArrayElementCount(variable.getName(), variableTypeMap) == 1) {
            // implement list to single mapping
            String[] variableNameArray = variable.getName().split("\\.");
            for (String nextName : variableNameArray) {
                variableName += nextName;
                if (variableTypeMap.containsKey(variableName)) {
                    SchemaDataType variableType = variableTypeMap.get(variableName);
                    if (SchemaDataType.ARRAY.equals(variableType)) {
                        if (nextName.contains("Record")) {
                            prettyVariableName += "." + nextName.substring(0, nextName.indexOf("Record")) + "["
                                    + getAccumulatedIterativeVariableString(parentForLoopBeanStack) + "]";
                        } else {
                            prettyVariableName += "." + nextName + "["
                                    + getAccumulatedIterativeVariableString(parentForLoopBeanStack) + "]";
                        }
                    } else {
                        prettyVariableName += "." + nextName;
                    }
                } else {
                    throw new IllegalArgumentException("Unregistered Variable name found : " + variableName + " in - ["
                            + variableTypeMap.keySet() + "]");
                }
                variableName += ".";
            }
            prettyVariableName = prettyVariableName.substring(1);
        } else {
            Stack<ForLoopBean> parentVariableBottomUpStack = getReversedStack(parentForLoopBeanStack);
            String[] variableNameArray = variable.getName().split("\\.");
            for (String nextName : variableNameArray) {
                variableName += nextName;
                if (variableTypeMap.containsKey(variableName)) {
                    SchemaDataType variableType = variableTypeMap.get(variableName);
                    if (SchemaDataType.ARRAY.equals(variableType)) {
                        if (nextName.contains("Record")) {
                            prettyVariableName += "." + nextName.substring(0, nextName.indexOf("Record")) + "["
                                    + parentVariableBottomUpStack.pop().getIterativeName() + "]";
                        } else {
                            prettyVariableName += "." + nextName + "[i_" + nextName + "]";
                        }
                    } else {
                        prettyVariableName += "." + nextName;
                    }
                } else {
                    throw new IllegalArgumentException("Unregistered Variable name found : " + variableName + " in - ["
                            + variableTypeMap.keySet() + "]");
                }
                variableName += ".";
            }
            prettyVariableName = prettyVariableName.substring(1);
        }
        return prettyVariableName;
    }

    private static String getAccumulatedIterativeVariableString(Stack<ForLoopBean> parentForLoopBeanStack) {
        String accumulatedIterativeVariableString = "";
        while (parentForLoopBeanStack.size() > 0) {
            accumulatedIterativeVariableString += parentForLoopBeanStack.pop().getIterativeName();
            if (parentForLoopBeanStack.size() > 0) {
                accumulatedIterativeVariableString += "+";
            }
        }
        return accumulatedIterativeVariableString;
    }

    private static int getArrayElementCount(String name, Map<String, SchemaDataType> variableTypeMap) {
        int arrayTypeVariableCount = 0;
        String[] variableNameArray = name.split("\\.");
        String variableName = "";
        for (String nextName : variableNameArray) {
            variableName += nextName;
            if (variableTypeMap.containsKey(variableName)) {
                SchemaDataType variableType = variableTypeMap.get(variableName);
                if (SchemaDataType.ARRAY.equals(variableType)) {
                    arrayTypeVariableCount++;
                }
            } else {
                throw new IllegalArgumentException("Unregistered Variable name found : " + variableName + " in - ["
                        + variableTypeMap.keySet() + "]");
            }
            variableName += ".";
        }
        return arrayTypeVariableCount;
    }

    private static Stack<ForLoopBean> getReversedStack(Stack<ForLoopBean> parentForLoopBeanStack) {
        Stack<ForLoopBean> reversedParentForLoopBeanStack = new Stack<>();
        for (ForLoopBean forLoopBean : parentForLoopBeanStack) {
            reversedParentForLoopBeanStack.push(forLoopBean);
        }
        return reversedParentForLoopBeanStack;
    }

    private static String getForLoopIteratorNames(Stack<ForLoopBean> parentForLoopBeanStack) {
        int stackSize = parentForLoopBeanStack.size();
        String iterateNameList = "";
        for (int i = 0; i < stackSize; i++) {
            iterateNameList += parentForLoopBeanStack.pop().getIterativeName();
            if (i < stackSize - 1) {
                iterateNameList += "+";
            }
        }
        return iterateNameList;
    }
}

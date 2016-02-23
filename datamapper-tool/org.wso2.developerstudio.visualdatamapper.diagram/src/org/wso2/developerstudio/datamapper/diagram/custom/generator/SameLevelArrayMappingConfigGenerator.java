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
import java.util.Queue;
import java.util.Stack;

import org.apache.commons.lang.StringUtils;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator.DMOperatorTransformerFactory;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator.transformers.DMOperatorTransformer;
import org.wso2.developerstudio.datamapper.diagram.custom.exception.DataMapperException;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariable;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariableType;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DataMapperDiagramModel;

/**
 * This class extends abstract class {@link AbstractMappingConfigGenerator} and generates mapping configuration from a
 * {@link DataMapperDiagramModel} for simple same level record and array type schema's
 *
 */
public class SameLevelArrayMappingConfigGenerator extends AbstractMappingConfigGenerator {

    private Map<String, Integer> forLoopBeanMap;
    private List<ForLoopBean> forLoopBeanList;
    private ForLoopBean rootBean;

    @Override
    public String generateMappingConfig(DataMapperDiagramModel model) throws DataMapperException {
        initializeAlgorithmFields();
        List<MappingOperation> mappingOperationList = populateOperationListFromModel(model);
        String mainFunction = generateMainFunction(mappingOperationList, model);
        return mainFunction;
    }

    private void initializeAlgorithmFields() {
        forLoopBeanMap = new HashMap<>();
        forLoopBeanList = new ArrayList<>();
        rootBean = new ForLoopBean("root", "root");
        rootBean.setParentIndex(-1);
        getForLoopBeanList().add(rootBean);
        getForLoopBeanMap().put("root", 0);
    }

    private String generateMainFunction(List<MappingOperation> mappingOperationList, DataMapperDiagramModel model)
            throws DataMapperException {
        String inRoot = model.getInputRootName();
        String outRoot = model.getOutputRootName();
        StringBuilder functionBuilder = new StringBuilder();
        functionBuilder.append(getMainFunctionDefinition(inRoot, outRoot));
        functionBuilder.append(getJSCommandForOperation(mappingOperationList, model));
        functionBuilder.append(getFunctionReturnString(outRoot));
        return functionBuilder.toString();
    }

    private String getJSCommandForOperation(List<MappingOperation> mappingOperationList, DataMapperDiagramModel model)
            throws DataMapperException {
        Map<String, SchemaDataType> variableMap = model.getVariableTypeMap();
        int mappingOperationIndex = 0;
        for (MappingOperation mappingOperation : mappingOperationList) {
            List<DMVariable> inputVariables = mappingOperation.getInputVariables();
            List<Integer> operationForLoopBeansList = new ArrayList<>();
            List<String> operationElementsParentList = new ArrayList<>();
            for (DMVariable dmVariable : inputVariables) {
                String mostChildVariableName = "";
                if (DMVariableType.INTERMEDIATE.equals(dmVariable.getType())) {
                    mostChildVariableName = getMostChildAssociatedVariable(
                            model.getInputAdjList().get(dmVariable.getparentVariableOrOperationIndex()),
                            model.getVariablesArray());
                } else {
                    mostChildVariableName = dmVariable.getName();
                }
                String[] variableNameArray = mostChildVariableName.split("\\.");
                String variableName = "";
                String parentVariableName = "";
                String parentArrayVariable = "";
                boolean firstIteration = true;
                for (String nextName : variableNameArray) {
                    if (!firstIteration) {
                        parentVariableName = variableName.substring(0, variableName.length() - 1);
                    }
                    variableName += nextName;
                    if (variableMap.containsKey(variableName)) {
                        SchemaDataType variableType = variableMap.get(variableName);
                        if (SchemaDataType.ARRAY.equals(variableType)) {
                            if (forLoopBeanNotCreated(variableName)) {
                                int indexOfForLoopBean = addForLoopInToMap(variableName, new ForLoopBean("i_"
                                        + nextName, variableName));
                                addForLoopBeanIndexToParent(variableName, indexOfForLoopBean, parentArrayVariable);
                                parentArrayVariable = variableName;
                            } else {
                                parentArrayVariable = variableName;
                            }
                        } else if (SchemaDataType.STRING.equals(variableType)) {
                            // leaf variable element
                        } else if (SchemaDataType.RECORD.equals(variableType)) {
                            // record variable element
                        } else {
                            throw new DataMapperException("Unsupported schemaDataType in WSO2 Data Mapper found : "
                                    + variableType);
                        }
                    } else {
                        throw new IllegalArgumentException("Unknown variable name found : " + variableName);
                    }
                    variableName += ".";
                    firstIteration = false;
                }
                // add most parent array for operationForLoopBeansList
                if (StringUtils.isEmpty(parentArrayVariable)) {
                    // root bean value
                    operationForLoopBeansList.add(0);
                } else {
                    operationForLoopBeansList.add(getForLoopBeanMap().get(parentArrayVariable));
                }
                // add parent Element of the variable to operationElementsParentList
                operationElementsParentList.add(parentVariableName);
            }
            // validate the for loop beans of the variables. They should be in one branch.
            int indexOfMostInnerForLoopBean = -1;
            if (isValidOperationWithInputVariables(operationElementsParentList)) {
                indexOfMostInnerForLoopBean = getMostInnerForLoopBeanFromList(operationForLoopBeansList);
            }
            // find the most inner for loop bean to assign this operation
            getForLoopBeanList().get(indexOfMostInnerForLoopBean).getOperationList().add(mappingOperationIndex);
            mappingOperationIndex++;
        }
        // All operations are now assign to ForLoopBean map. Transform forLoopBean map for JS script.
        String scriptSegmentForOperations = transformForLoopBeansToJS(getRootBean(), mappingOperationList,
                model.getVariableTypeMap());
        return scriptSegmentForOperations;
    }

    private String getMostChildAssociatedVariable(ArrayList<Integer> inputVariableList, List<DMVariable> variableList) {
        String mostChildVariableName = "";
        for (Integer variableIndex : inputVariableList) {
            String variableName = variableList.get(variableIndex).getName();
            if (mostChildVariableName.split("\\.").length < variableName.split("\\.").length) {
                mostChildVariableName = variableName;
            }
        }
        return mostChildVariableName;
    }

    private String transformForLoopBeansToJS(ForLoopBean forLoopBean, List<MappingOperation> mappingOperationList,
            Map<String, SchemaDataType> variableTypeMap) {
        StringBuilder functionBuilder = new StringBuilder();
        functionBuilder.append("\n");
        if (!"root".equals(forLoopBean.getVariableName())) {
            functionBuilder.append("for(" + forLoopBean.getIterativeName() + " in "
                    + getPrettyVariableNameInForLoop(forLoopBean.getVariableName()) + "){");
            functionBuilder.append("\n");
            // define array type intermediate variables
            for (Integer mappingOperationIndex : forLoopBean.getOperationList()) {
                MappingOperation mappingOperation = mappingOperationList.get(mappingOperationIndex);
                for (DMVariable outputVariable : mappingOperation.getOutputVariables()) {
                    if (DMVariableType.INTERMEDIATE.equals(outputVariable.getType())) {
                        functionBuilder.append("var " + outputVariable.getName() + " = [];");
                        functionBuilder.append("\n");
                    }
                }
            }
        }
        // call operations and nested for loops
        List<Integer> operationsInForLoopList = forLoopBean.getOperationList();
        for (Integer operationIndex : operationsInForLoopList) {
            functionBuilder.append(getJSCommandForOperation(mappingOperationList.get(operationIndex), variableTypeMap,
                    forLoopBean));
        }
        List<Integer> nestedForLoopList = forLoopBean.getNestedForLoopList();
        for (Integer nestedForLoopIndex : nestedForLoopList) {
            functionBuilder.append(transformForLoopBeansToJS(getForLoopBeanList().get(nestedForLoopIndex),
                    mappingOperationList, variableTypeMap));
        }

        if (!"root".equals(forLoopBean.getVariableName())) {
            functionBuilder.append("\n");
            functionBuilder.append("}");
            functionBuilder.append("\n");
        }
        return functionBuilder.toString();
    }

    private String getJSCommandForOperation(MappingOperation mappingOperation,
            Map<String, SchemaDataType> variableTypeMap, ForLoopBean forLoopBean) {
        StringBuilder operationBuilder = new StringBuilder();
        List<DMVariable> outputVariables = mappingOperation.getOutputVariables();
        if (outputVariables.size() > 1) {
            operationBuilder.append("[ ");
        }
        Stack<ForLoopBean> forLoopBeanParentStack = getParentForLoopBeanStack(forLoopBean);
        int numOfOutputVariables = outputVariables.size();
        for (int variableIndex = 0; variableIndex < numOfOutputVariables; variableIndex++) {
            operationBuilder.append(getPrettyVariableNameInForOperation(outputVariables.get(variableIndex),
                    variableTypeMap, forLoopBeanParentStack));
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
                SameLevelArrayMappingConfigGenerator.class, mappingOperation.getInputVariables(), variableTypeMap,
                forLoopBeanParentStack));
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

    private String getPrettyVariableNameInForOperation(DMVariable variable,
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
        } else {
            Stack<ForLoopBean> parentVariableBottomUpStack = getReversedStack(parentForLoopBeanStack);
            String[] variableNameArray = variable.getName().split("\\.");
            for (String nextName : variableNameArray) {
                variableName += nextName;
                if (variableTypeMap.containsKey(variableName)) {
                    SchemaDataType variableType = variableTypeMap.get(variableName);
                    if (SchemaDataType.ARRAY.equals(variableType)) {
                        if (nextName.contains("Record")) {
                            prettyVariableName += "." + nextName.substring(0, nextName.indexOf("Record"))
                                    + "["+parentVariableBottomUpStack.pop().getIterativeName() + "]";
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

    private Stack<ForLoopBean> getReversedStack(Stack<ForLoopBean> parentForLoopBeanStack) {
        Stack<ForLoopBean> reversedParentForLoopBeanStack = new Stack<>();
        for (ForLoopBean forLoopBean : parentForLoopBeanStack) {
            reversedParentForLoopBeanStack.push(forLoopBean);
        }
        return reversedParentForLoopBeanStack;
    }

    private String getForLoopIteratorNames(Stack<ForLoopBean> parentForLoopBeanStack) {
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

    private String getPrettyVariableNameInForLoop(String variableName) {
        String prettyVariableName = variableName;
        if (variableName.endsWith("Record")) {
            prettyVariableName = variableName.substring(0, variableName.lastIndexOf("Record"));
        }
        return prettyVariableName;
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
            throw new DataMapperException("Cannot use varibales in different parent elements in different branches");
        }
    }

    private int getMostInnerForLoopBeanFromList(List<Integer> operationForLoopBeansList) {
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

    private boolean forLoopBeanNotCreated(String variableName) {
        return !getForLoopBeanMap().containsKey(variableName);
    }

    @Override
    public boolean validate(DataMapperDiagramModel model) {
        // TODO Auto-generated method stub
        return false;
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

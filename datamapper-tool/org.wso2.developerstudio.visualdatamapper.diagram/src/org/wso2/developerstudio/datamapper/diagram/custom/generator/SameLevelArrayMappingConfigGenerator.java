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

import org.apache.commons.lang.StringUtils;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.diagram.custom.exception.DataMapperException;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariable;
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
        getForLoopBeanList().add(rootBean);
        getForLoopBeanMap().put("root", 0);
    }

    private String generateMainFunction(List<MappingOperation> mappingOperationList, DataMapperDiagramModel model) throws DataMapperException {
        String inRoot = model.getInputRootName();
        String outRoot = model.getOutputRootName();
        StringBuilder functionBuilder = new StringBuilder();
        functionBuilder.append(getMainFunctionDefinition(inRoot, outRoot));
        functionBuilder.append(getJSCommandForOperation(mappingOperationList, model));
        functionBuilder.append(getFunctionReturnString(outRoot));
        return functionBuilder.toString();
    }

    private String getJSCommandForOperation(List<MappingOperation> mappingOperationList, DataMapperDiagramModel model) throws DataMapperException {
        Map<String, SchemaDataType> variableMap = model.getVariableTypeMap();
        for (MappingOperation mappingOperation : mappingOperationList) {
            List<DMVariable> inputVariables = mappingOperation.getInputVariables();
            List<Integer> operationForLoopBeansList = new ArrayList<>();
            List<Integer> operationElementsParentList = new ArrayList<>();
            for (DMVariable dmVariable : inputVariables) {
                String[] variableNameArray = dmVariable.getName().split("\\.");
                String variableName = "";
                String parentArrayVariable = "";
                for (String nextName : variableNameArray) {
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
                        } else {
                            throw new DataMapperException("Unsupported schemaDataType in WSO2 Data Mapper found : "
                                    + variableType);
                        }
                    } else {
                        throw new IllegalArgumentException("Unknown variable name found : " + variableName);
                    }
                    variableName += ".";
                }
                // add most parent array for operationForLoopBeansList
                if (StringUtils.isEmpty(parentArrayVariable)) {
                    // root bean value
                    operationForLoopBeansList.add(0);
                } else {
                    operationForLoopBeansList.add(getForLoopBeanMap().get(parentArrayVariable));
                }
            }
            // validate the for loop beans of the variables. They should be in one branch.
            System.out.println();
            int indexOfMostInnerForLoopBean = getMostInnerForLoopBeanFromList(operationForLoopBeansList);
            // find the most inner for loop bean to assign this operation

        }
        // All operations are now assign to ForLoopBean map. Transform forLoopBean map for JS script.

        return null;
    }

    private int getMostInnerForLoopBeanFromList(List<Integer> operationForLoopBeansList) {
        int mostChildForLoopIndex = 0;
        for (Integer forLoopBeanIndex : operationForLoopBeansList) {

        }
        return 0;
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

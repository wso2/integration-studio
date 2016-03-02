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
package org.wso2.developerstudio.datamapper.diagram.custom.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.datamapper.DataMapperLink;
import org.wso2.developerstudio.datamapper.DataMapperRoot;
import org.wso2.developerstudio.datamapper.Input;
import org.wso2.developerstudio.datamapper.OperatorLeftConnector;
import org.wso2.developerstudio.datamapper.OperatorRightConnector;
import org.wso2.developerstudio.datamapper.Output;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.impl.ConcatImpl;
import org.wso2.developerstudio.datamapper.impl.ConstantImpl;
import org.wso2.developerstudio.datamapper.impl.ElementImpl;
import org.wso2.developerstudio.datamapper.impl.LowerCaseImpl;
import org.wso2.developerstudio.datamapper.impl.OperatorImpl;
import org.wso2.developerstudio.datamapper.impl.OperatorRightConnectorImpl;
import org.wso2.developerstudio.datamapper.impl.SplitImpl;
import org.wso2.developerstudio.datamapper.impl.TreeNodeImpl;
import org.wso2.developerstudio.datamapper.impl.UpperCaseImpl;

/**
 * This class represent the object model of the Data-Mapper Diagram.
 */
public class DataMapperDiagramModel {

    private List<DMVariable> variablesArray = new ArrayList<>();
    private List<Integer> inputVariablesArray = new ArrayList<>();
    private List<Integer> outputVariablesArray = new ArrayList<>();
    private List<DMOperation> operationsList = new ArrayList<>();
    private List<Integer> resolvedVariableArray = new ArrayList<>();
    private List<Integer> resolvedOutputVariableArray = new ArrayList<>();
    private List<OperatorImpl> graphOperationElements = new ArrayList<>();

    private List<ArrayList<Integer>> inputAdjList = new ArrayList<>();
    private List<ArrayList<Integer>> outputAdjList = new ArrayList<>();
    private List<Integer> executionSeq = new ArrayList<>();
    private Map<String, SchemaDataType> variableTypeMap = new HashMap<>();
    private String inputRootName;
    private String outputRootName;

    public DataMapperDiagramModel(DataMapperRoot rootDiagram) {
        setInputAndOutputRootNames(rootDiagram);
        populateOutputVariables(rootDiagram.getOutput());
        populateInputVariables(rootDiagram.getInput());
        resetDiagramTraversalProperties();
        updateExecutionSequence();
    }

    private void setInputAndOutputRootNames(DataMapperRoot rootDiagram) {
        EObject inRootElement = rootDiagram.getInput().eContents().get(0);
        if (inRootElement instanceof TreeNodeImpl) {
            setInputRootName(((TreeNodeImpl) inRootElement).getName());
        } else {
            throw new IllegalArgumentException("Invalid Input root element found");
        }
        EObject outRootElement = rootDiagram.getOutput().eContents().get(0);
        if (outRootElement instanceof TreeNodeImpl) {
            setOutputRootName(((TreeNodeImpl) outRootElement).getName());
        } else {
            throw new IllegalArgumentException("Invalid Output root element found");
        }

    }

    private void updateExecutionSequence() {
        List<Integer> unexecutedOperationList = new ArrayList<>();
        List<Integer> tempUnexecutedOperationList = new ArrayList<>();
        int numberOfOperations = operationsList.size();
        for (int i = 0; i < numberOfOperations; i++) {
            unexecutedOperationList.add(i);
        }
        while (executionSeq.size() < numberOfOperations) {
            for (int index = 0; unexecutedOperationList.size() > index; ++index) {
                if (operationIsExecutable(unexecutedOperationList.get(index))) {
                    executionSeq.add(unexecutedOperationList.get(index));
                    addOutputsToResolvedVariables(unexecutedOperationList.get(index));
                } else {
                    tempUnexecutedOperationList.add(unexecutedOperationList.get(index));
                }
            }
            unexecutedOperationList = tempUnexecutedOperationList;
            tempUnexecutedOperationList = new ArrayList<>();
        }
    }

    private void addOutputsToResolvedVariables(Integer index) {
        ArrayList<Integer> outputVariables = outputAdjList.get(index);
        for (Integer operationOutputVariable : outputVariables) {
            if (outputVariablesArray.indexOf(operationOutputVariable) >= 0) {
                getResolvedOutputVariableArray().add(operationOutputVariable);
            } else {
                getResolvedVariableArray().add(operationOutputVariable);
            }
        }
    }

    /**
     * Checks whether all input variables for the operation in inputAdjList are
     * in the resolvedVariable list
     * 
     * @param index
     * @return
     */
    private boolean operationIsExecutable(Integer index) {
        ArrayList<Integer> inputVariables = inputAdjList.get(index);
        for (Integer inputVariableIndex : inputVariables) {
            if (getResolvedVariableArray().indexOf(inputVariableIndex) < 0
                    && getResolvedOutputVariableArray().indexOf(inputVariableIndex) < 0) {
                return false;
            }
        }
        return true;
    }

    private void resetDiagramTraversalProperties() {
        List<OperatorImpl> graphOperationElements = getGraphOperationElements();
        for (OperatorImpl operation : graphOperationElements) {
            operation.setVisited(false);
            operation.setMarked(false);
            operation.setIndex(-1);
            operation.setPortVariableIndex(new ArrayList<Integer>());
        }
        setGraphOperationElements(new ArrayList<OperatorImpl>());
    }

    private void populateInputVariables(Input input) {
        TreeIterator<EObject> variableIterator = input.eAllContents();
        Stack<EObject> parentVariableStack = new Stack<>();
        List<EObject> tempNodeArray = new ArrayList<>();
        for (Iterator<EObject> iterator = variableIterator; iterator.hasNext();) {
            EObject objectElement = (EObject) iterator.next();
            if (objectElement instanceof ElementImpl) {
                ElementImpl element = (ElementImpl) objectElement;
                if (element.getLevel() <= parentVariableStack.size()) {
                    while (parentVariableStack.size() >= element.getLevel()) {
                        parentVariableStack.pop();
                    }
                } else if (element.getLevel() > (parentVariableStack.size() + 1)) {
                    throw new IllegalArgumentException("Illegal element level detected : element level- "
                            + element.getLevel() + " , parents level- " + parentVariableStack.size());
                }
                int index = variablesArray.size();
                String variableName = getVariableName(DMVariableType.INPUT, parentVariableStack, element.getName());
                int parentVariableIndex = -1;
                if (!parentVariableStack.isEmpty()) {
                    TreeNodeImpl parent = (TreeNodeImpl) parentVariableStack.peek();
                    parentVariableIndex = parent.getIndex();
                }
                variablesArray.add(new DMVariable(variableName, getUniqueId(objectElement), DMVariableType.INPUT,
                        element.getSchemaDataType(), index, parentVariableIndex));
                addVariableTypeToMap(variableName, SchemaDataType.STRING);
                ((ElementImpl) objectElement).setIndex(index);
                getResolvedVariableArray().add(index);
                inputVariablesArray.add(index);
                tempNodeArray.add(element);
            } else if (objectElement instanceof TreeNodeImpl) {
                TreeNodeImpl treeNode = (TreeNodeImpl) objectElement;
                String variableName = getVariableName(DMVariableType.INPUT, parentVariableStack, treeNode.getName());
                SchemaDataType variableType = treeNode.getSchemaDataType();
                int parentVariableIndex = -1;
                if (!parentVariableStack.isEmpty()) {
                    TreeNodeImpl parent = (TreeNodeImpl) parentVariableStack.peek();
                    parentVariableIndex = parent.getIndex();
                }
                int index = variablesArray.size();
                variablesArray.add(new DMVariable(variableName, objectElement.toString(), DMVariableType.OUTPUT,
                        treeNode.getSchemaDataType(), index, parentVariableIndex));
                outputVariablesArray.add(index);
                treeNode.setIndex(index);
                addVariableTypeToMap(variableName, variableType);
                if (treeNode.getLevel() == parentVariableStack.size()) {
                    parentVariableStack.pop();
                    parentVariableStack.push(treeNode);
                } else if (treeNode.getLevel() > parentVariableStack.size()) {
                    parentVariableStack.push(treeNode);
                } else {
                    while (parentVariableStack.size() >= treeNode.getLevel()) {
                        parentVariableStack.pop();
                    }
                    parentVariableStack.push(treeNode);
                }
            }
        }
        populateAdjacencyLists(tempNodeArray);
    }

    private void populateAdjacencyLists(List<EObject> tempNodeArray) {
        while (tempNodeArray.size() > 0) {
            EObject nextElement = tempNodeArray.remove(0);
            if (nextElement instanceof ElementImpl) {
                EList<DataMapperLink> outgoingLinks = ((ElementImpl) nextElement).getOutNode().getOutgoingLink();
                for (DataMapperLink dataMapperLink : outgoingLinks) {
                    EObject linkedNode = getLinkedElement(dataMapperLink);
                    if (linkedNode instanceof ElementImpl) {
                        operationsList.add(new DMOperation(DMOperatorType.DIRECT, getUniqueDirectId(linkedNode,
                                operationsList.size()), operationsList.size()));
                        outputAdjList.add(new ArrayList<Integer>());
                        outputAdjList.get(operationsList.size() - 1).add(((ElementImpl) linkedNode).getIndex());
                        inputAdjList.add(new ArrayList<Integer>());
                        inputAdjList.get(operationsList.size() - 1).add(((ElementImpl) nextElement).getIndex());
                    } else if (linkedNode instanceof OperatorImpl && !((OperatorImpl) linkedNode).isMarked()) {
                        ((OperatorImpl) linkedNode).setMarked(true);
                        tempNodeArray.add(linkedNode);
                    }
                }
            } else if (nextElement instanceof OperatorImpl && !((OperatorImpl) nextElement).isVisited()) {
                int index = operationsList.size();
                OperatorImpl operatorElement = (OperatorImpl) nextElement;
                DMOperation operator = new DMOperation(getOperatorType(operatorElement), getUniqueId(operatorElement),
                        index);
                operationsList.add(operator);
                graphOperationElements.add(operatorElement);
                ((OperatorImpl) nextElement).setIndex(index);

                outputAdjList.add(new ArrayList<Integer>());
                inputAdjList.add(new ArrayList<Integer>());
                // populate outputAdjList
                List<DataMapperLink> outlinks = getOutLinksOfOperator(operatorElement);
                int indexOfConnector = 0;
                Map<OperatorRightConnectorImpl, DMVariable> visitedConnectorVariableMap = new HashMap<>();
                for (DataMapperLink dataMapperLink : outlinks) {
                    EObject linkedElement = getLinkedElement(dataMapperLink);
                    if (linkedElement instanceof ElementImpl) {
                        OperatorRightConnectorImpl rightConnector = getRightConnectorFromDMLink(dataMapperLink);
                        int variableIndex = ((ElementImpl) linkedElement).getIndex();
                        outputAdjList.get(operatorElement.getIndex()).add(variableIndex);
                        operatorElement.getPortVariableIndex().add(variableIndex);
                        visitedConnectorVariableMap.put(rightConnector, variablesArray.get(variableIndex));
                    } else if (linkedElement instanceof OperatorImpl) {
                        OperatorImpl operationElement = (OperatorImpl) linkedElement;
                        if (!operationElement.isMarked()) {
                            tempNodeArray.add(linkedElement);
                            operationElement.setMarked(true);
                        }
                        OperatorRightConnectorImpl rightConnector = getRightConnectorFromDMLink(dataMapperLink);
                        if (visitedConnectorVariableMap.containsKey(rightConnector)) {
                            int variableIndex = visitedConnectorVariableMap.get(rightConnector).getIndex();
                            if (operationElement.isVisited()) {
                                inputAdjList.get(operationElement.getIndex()).add(variableIndex);
                            }
                        } else {
                            indexOfConnector++;
                            String variablePrefix = operator.getOperatorType() + "_" + operator.getIndex() + "_"
                                    + indexOfConnector;
                            if (operatorElement.getPortVariableIndex().size() <= indexOfConnector) {
                                int variableIndex = variablesArray.size();
                                DMVariable tempVar = new DMVariable(variablePrefix, getUniqueDirectId(operatorElement,
                                        indexOfConnector), DMVariableType.INTERMEDIATE, SchemaDataType.STRING,
                                        variableIndex, index);
                                addVariableTypeToMap(tempVar.getName(), SchemaDataType.STRING);
                                variablesArray.add(tempVar);
                                operatorElement.getPortVariableIndex().add(variableIndex);
                                outputAdjList.get(operator.getIndex()).add(variableIndex);
                                if (operationElement.isVisited()) {
                                    inputAdjList.get(operationElement.getIndex()).add(variableIndex);
                                }
                                visitedConnectorVariableMap.put(rightConnector, tempVar);
                            }
                        }
                    }
                }
                // populate inputAdjList
                List<DataMapperLink> inlinks = getInLinksOfOperator(operatorElement);
                for (DataMapperLink dataMapperLink : inlinks) {
                    EObject linkedElement = getPreviousLinkedElement(dataMapperLink);
                    if (linkedElement instanceof ElementImpl) {
                        inputAdjList.get(operatorElement.getIndex()).add(((ElementImpl) linkedElement).getIndex());
                    } else if (linkedElement instanceof OperatorImpl) {
                        OperatorImpl sourceElement = (OperatorImpl) linkedElement;
                        if (!sourceElement.isMarked()) {
                            sourceElement.setMarked(true);
                            tempNodeArray.add(sourceElement);
                        } else if (sourceElement.isVisited()) {
                            int indexOfSourceRightContainer = getVaribleIndexInSourceElementWithLink(sourceElement,
                                    dataMapperLink);
                            inputAdjList.get(operator.getIndex()).add(
                                    sourceElement.getPortVariableIndex().get(indexOfSourceRightContainer));
                        }
                    }
                }
                operatorElement.setVisited(true);
            }
        }
    }

    private int getVaribleIndexInSourceElementWithLink(OperatorImpl sourceElement, DataMapperLink dataMapperLink) {
        EList<OperatorRightConnector> rightConnectors = sourceElement.getBasicContainer().getRightContainer()
                .getRightConnectors();
        for (int connectorIndex = 0; connectorIndex < rightConnectors.size(); connectorIndex++) {
            OperatorRightConnector rightConnector = rightConnectors.get(connectorIndex);
            if (rightConnector.getOutNode().getOutgoingLink().contains(dataMapperLink)) {
                return connectorIndex;
            }
        }
        throw new IllegalArgumentException("Cannot find given link in source element");
    }

    private OperatorRightConnectorImpl getRightConnectorFromDMLink(DataMapperLink dataMapperLink) {
        EObject rightConnector = dataMapperLink.eContainer().eContainer();
        if (rightConnector instanceof OperatorRightConnectorImpl) {
            return (OperatorRightConnectorImpl) rightConnector;
        } else {
            throw new IllegalArgumentException("Invalid out going link found : " + dataMapperLink);
        }
    }

    private EObject getPreviousLinkedElement(DataMapperLink dataMapperLink) {
        EObject element = dataMapperLink.eContainer().eContainer();
        if (element instanceof ElementImpl) {
            return element;
        } else {
            while (!(element instanceof OperatorImpl)) {
                element = element.eContainer();
            }
            return element;
        }
    }

    private List<DataMapperLink> getInLinksOfOperator(OperatorImpl operatorElement) {
        EList<OperatorLeftConnector> leftContainers = operatorElement.getBasicContainer().getLeftContainer()
                .getLeftConnectors();
        List<DataMapperLink> linkList = new ArrayList<>();
        for (OperatorLeftConnector operatorLeftConnector : leftContainers) {
            linkList.addAll(operatorLeftConnector.getInNode().getIncomingLink());
        }
        return linkList;
    }

    private List<DataMapperLink> getOutLinksOfOperator(OperatorImpl operatorElement) {
        EList<OperatorRightConnector> rightConnectors = operatorElement.getBasicContainer().getRightContainer()
                .getRightConnectors();
        List<DataMapperLink> linkList = new ArrayList<>();
        for (OperatorRightConnector operatorRightConnector : rightConnectors) {
            linkList.addAll(operatorRightConnector.getOutNode().getOutgoingLink());
        }
        return linkList;
    }

    private String getUniqueDirectId(EObject parent, int size) {
        return parent.toString() + " " + size;
    }

    private String getUniqueId(EObject nextElement) {
        return nextElement.toString();
    }

    private DMOperatorType getOperatorType(OperatorImpl nextElement) {
        if (nextElement instanceof ConcatImpl) {
            return DMOperatorType.CONCAT;
        } else if (nextElement instanceof SplitImpl) {
            return DMOperatorType.SPLIT;
        } else if (nextElement instanceof UpperCaseImpl) {
            return DMOperatorType.UPPERCASE;
        } else if (nextElement instanceof LowerCaseImpl) {
            return DMOperatorType.LOWERCASE;
        } else if (nextElement instanceof ConstantImpl) {
            return DMOperatorType.CONSTANT;
        } else {
            throw new IllegalArgumentException("Unknown operator detected : " + nextElement.toString());
        }
    }

    private EObject getLinkedElement(DataMapperLink dataMapperLink) {
        EObject element = dataMapperLink.getInNode().eContainer();
        if (element instanceof ElementImpl) {
            return element;
        } else {
            while (!(element instanceof OperatorImpl)) {
                element = element.eContainer();
            }
            return element;
        }
    }

    /**
     * This method will populate the outputVariables array field from diagram
     * output tree
     * 
     * @param output
     */
    private void populateOutputVariables(Output output) {
        TreeIterator<EObject> variableIterator = output.eAllContents();
        Stack<EObject> parentVariableStack = new Stack<EObject>();
        for (Iterator<EObject> iterator = variableIterator; iterator.hasNext();) {
            EObject objectElement = (EObject) iterator.next();
            if (objectElement instanceof ElementImpl) {
                ElementImpl element = (ElementImpl) objectElement;
                if (element.getLevel() <= parentVariableStack.size()) {
                    while (parentVariableStack.size() >= element.getLevel()) {
                        parentVariableStack.pop();
                    }
                } else if (element.getLevel() > (parentVariableStack.size() + 1)) {
                    throw new IllegalArgumentException("Illegal element level detected : element level- "
                            + element.getLevel() + " , parents level- " + parentVariableStack.size());
                }
                int index = variablesArray.size();
                String variableName = getVariableName(DMVariableType.OUTPUT, parentVariableStack, element.getName());
                int parentVariableIndex = -1;
                if (!parentVariableStack.isEmpty()) {
                    TreeNodeImpl parent = (TreeNodeImpl) parentVariableStack.peek();
                    parentVariableIndex = parent.getIndex();
                }
                variablesArray.add(new DMVariable(variableName, objectElement.toString(), DMVariableType.OUTPUT,
                        element.getSchemaDataType(), index, parentVariableIndex));
                outputVariablesArray.add(index);
                element.setIndex(index);
                addVariableTypeToMap(variableName, element.getSchemaDataType());
            } else if (objectElement instanceof TreeNodeImpl) {
                TreeNodeImpl treeNode = (TreeNodeImpl) objectElement;
                if (treeNode.getLevel() <= parentVariableStack.size()) {
                    while (parentVariableStack.size() >= treeNode.getLevel()) {
                        parentVariableStack.pop();
                    }
                } else if (treeNode.getLevel() > (parentVariableStack.size() + 1)) {
                    throw new IllegalArgumentException("Illegal element level detected : element level- "
                            + treeNode.getLevel() + " , parents level- " + parentVariableStack.size());
                }
                String variableName = getVariableName(DMVariableType.OUTPUT, parentVariableStack, treeNode.getName());
                SchemaDataType variableType = treeNode.getSchemaDataType();
                int parentVariableIndex = -1;
                if (!parentVariableStack.isEmpty()) {
                    TreeNodeImpl parent = (TreeNodeImpl) parentVariableStack.peek();
                    parentVariableIndex = parent.getIndex();
                }
                int index = variablesArray.size();
                variablesArray.add(new DMVariable(variableName, objectElement.toString(), DMVariableType.OUTPUT,
                        treeNode.getSchemaDataType(), index, parentVariableIndex));
                outputVariablesArray.add(index);
                treeNode.setIndex(index);
                addVariableTypeToMap(variableName, variableType);
                if (treeNode.getLevel() == parentVariableStack.size()) {
                    parentVariableStack.pop();
                    parentVariableStack.push(treeNode);
                } else if (treeNode.getLevel() > parentVariableStack.size()) {
                    parentVariableStack.push(treeNode);
                } else {
                    while (parentVariableStack.size() >= treeNode.getLevel()) {
                        parentVariableStack.pop();
                    }
                    parentVariableStack.push(treeNode);
                }
            }
        }
    }

    private String getVariableName(DMVariableType prefix, Stack<EObject> parentVariableStack, String name) {
        String variableName = prefix.toString().toLowerCase();
        for (EObject eObject : parentVariableStack) {
            if (eObject instanceof TreeNodeImpl) {
                variableName = variableName + ((TreeNodeImpl) eObject).getName() + ".";
            } else if (eObject instanceof ElementImpl) {
                variableName = variableName + ((ElementImpl) eObject).getName() + ".";
            } else {
                throw new IllegalArgumentException("Illegal element type found : " + eObject.toString());
            }
        }
        return variableName + name;
    }

    public List<Integer> getInputVariablesArray() {
        return inputVariablesArray;
    }

    public void setInputVariablesArray(List<Integer> inputVariablesArray) {
        this.inputVariablesArray = inputVariablesArray;
    }

    public String getInputRootName() {
        return inputRootName;
    }

    public void setInputRootName(String inputRootName) {
        this.inputRootName = inputRootName;
    }

    public String getOutputRootName() {
        return outputRootName;
    }

    public void setOutputRootName(String outputRootName) {
        this.outputRootName = outputRootName;
    }

    public List<DMOperation> getOperationsList() {
        return operationsList;
    }

    public void setOperationsArray(List<DMOperation> operationsArray) {
        this.operationsList = operationsArray;
    }

    private List<Integer> getResolvedVariableArray() {
        return resolvedVariableArray;
    }

    private List<Integer> getResolvedOutputVariableArray() {
        return resolvedOutputVariableArray;
    }

    public List<ArrayList<Integer>> getInputAdjList() {
        return inputAdjList;
    }

    public void setInputAdjList(List<ArrayList<Integer>> inputAdjList) {
        this.inputAdjList = inputAdjList;
    }

    public List<ArrayList<Integer>> getOutputAdjList() {
        return outputAdjList;
    }

    public void setOutputAdjList(List<ArrayList<Integer>> outputAdjList) {
        this.outputAdjList = outputAdjList;
    }

    private List<OperatorImpl> getGraphOperationElements() {
        return graphOperationElements;
    }

    private void setGraphOperationElements(List<OperatorImpl> graphOperationElements) {
        this.graphOperationElements = graphOperationElements;
    }

    public List<Integer> getExecutionSequence() {
        return executionSeq;
    }

    public void setExecutionSeq(List<Integer> executionSeq) {
        this.executionSeq = executionSeq;
    }

    public List<DMVariable> getVariablesArray() {
        return variablesArray;
    }

    public void setVariablesArray(List<DMVariable> variablesArray) {
        this.variablesArray = variablesArray;
    }

    public void setOperationsList(List<DMOperation> operationsList) {
        this.operationsList = operationsList;
    }

    public Map<String, SchemaDataType> getVariableTypeMap() {
        return variableTypeMap;
    }

    public void setVariableTypeMap(Map<String, SchemaDataType> variableTypeMap) {
        this.variableTypeMap = variableTypeMap;
    }

    private void addVariableTypeToMap(String variableName, SchemaDataType type) {
        getVariableTypeMap().put(variableName, type);
    }

}

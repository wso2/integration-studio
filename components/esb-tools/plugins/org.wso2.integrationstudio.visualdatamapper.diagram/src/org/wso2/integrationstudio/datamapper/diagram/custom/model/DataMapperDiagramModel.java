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
package org.wso2.integrationstudio.datamapper.diagram.custom.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.wso2.integrationstudio.datamapper.DataMapperLink;
import org.wso2.integrationstudio.datamapper.DataMapperOperatorType;
import org.wso2.integrationstudio.datamapper.DataMapperRoot;
import org.wso2.integrationstudio.datamapper.Input;
import org.wso2.integrationstudio.datamapper.Operator;
import org.wso2.integrationstudio.datamapper.OperatorLeftConnector;
import org.wso2.integrationstudio.datamapper.OperatorRightConnector;
import org.wso2.integrationstudio.datamapper.Output;
import org.wso2.integrationstudio.datamapper.PropertyKeyValuePair;
import org.wso2.integrationstudio.datamapper.SchemaDataType;
import org.wso2.integrationstudio.datamapper.TreeNode;
import org.wso2.integrationstudio.datamapper.diagram.custom.exception.DataMapperException;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.transformers.AdvancedCustomOperatorModelTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.transformers.ModelTransformerFactory;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.transformers.TransformerConstants;
import org.wso2.integrationstudio.datamapper.diagram.custom.util.ScriptGenerationUtil;
import org.wso2.integrationstudio.datamapper.impl.AdvancedCustomFunctionImpl;
import org.wso2.integrationstudio.datamapper.impl.ConstantImpl;
import org.wso2.integrationstudio.datamapper.impl.ElementImpl;
import org.wso2.integrationstudio.datamapper.impl.GlobalVariableImpl;
import org.wso2.integrationstudio.datamapper.impl.OperatorImpl;
import org.wso2.integrationstudio.datamapper.impl.OperatorRightConnectorImpl;
import org.wso2.integrationstudio.datamapper.impl.PropertiesImpl;
import org.wso2.integrationstudio.datamapper.impl.SplitImpl;
import org.wso2.integrationstudio.datamapper.impl.TreeNodeImpl;

/**
 * This class represent the object model of the Data-Mapping Diagram.
 */
public class DataMapperDiagramModel {

	private static final String TYPE = "type";
	private static final String ITEM_TYPE = "items_type";
	private static final String NAMESPACE_SEPERATOR = ":";
	private static final String JSON_SCHEMA_NULLABLE = "nullable";
	private static final String DOT_REPRESENTATION = "_DOT_";
	private static final String UNAMED = "unnamed";
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
	private Map<String, List<SchemaDataType>> variableTypeMap = new HashMap<>();
	private List<String> unNamedVariables = new ArrayList<>();
	private String inputRootName;
	private String outputRootName;

	public DataMapperDiagramModel(DataMapperRoot rootDiagram) throws DataMapperException {
		if (!rootDiagram.getOutput().eContents().isEmpty() && !rootDiagram.getInput().eContents().isEmpty()) {
			setInputAndOutputRootNames(rootDiagram);
			populateOutputVariablesDepthFirst(rootDiagram.getOutput());
			populateInputVariablesDepthFirst(rootDiagram.getInput());
			resetDiagramTraversalProperties();
			updateExecutionSequence();
			updateAdvancedFucntions(rootDiagram);
		} else {
			throw new DataMapperException("Both input and output message formats needed to generate mapping");
		}
	}

	private void updateAdvancedFucntions(DataMapperRoot rootDiagram) {
		EList<Operator> operators = rootDiagram.getOperators();
		for (Operator operator : operators) {
			if (operator instanceof AdvancedCustomFunctionImpl) {
				OperatorImpl operatorElement = (OperatorImpl) operator;
				DMOperation dmOperator = new AdvancedCustomOperatorModelTransformer().transform(operatorElement, -1);
				operationsList.add(dmOperator);
			}
		}
	}
	
	private void populateInputVariablesDepthFirst(Input input) {
		Stack<EObject> nodeStack = new Stack<>();
		nodeStack.addAll(input.getTreeNode());
		Stack<EObject> parentVariableStack = new Stack<EObject>();
		List<EObject> tempNodeArray = new ArrayList<>();
		while (!nodeStack.isEmpty()) {
			EObject currentNode = nodeStack.pop();
			if (currentNode instanceof TreeNodeImpl) {
				final TreeNodeImpl currentTreeNode = (TreeNodeImpl) currentNode;
				
				if (currentTreeNode.getName().contains(".")) {
					TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(currentTreeNode);
					domain.getCommandStack().execute(new RecordingCommand(domain) {
						protected void doExecute() {
							currentTreeNode.setName(replaceSpecialCharactersInAttribute(currentTreeNode.getName()));
						}
					});
				}
                
				if (currentTreeNode.getLevel() <= parentVariableStack.size()) {
					while (parentVariableStack.size() >= currentTreeNode.getLevel()) {
						parentVariableStack.pop();
					}
				} else if (currentTreeNode.getLevel() > (parentVariableStack.size() + 1)) {
					throw new IllegalArgumentException("Illegal element level detected : element level- "
							+ currentTreeNode.getLevel() + " , parents level- " + parentVariableStack.size());
				}
				String variableName = getVariableName(DMVariableType.INPUT, parentVariableStack,
						currentTreeNode.getName());
				SchemaDataType variableType = getSchemaDataType(getTreeNodeType(currentTreeNode));
				int parentVariableIndex = -1;
				if (!parentVariableStack.isEmpty()) {
					TreeNodeImpl parent = (TreeNodeImpl) parentVariableStack.peek();
					parentVariableIndex = parent.getIndex();
				}
				int index = variablesArray.size();
				DMVariable addedVariable = new DMVariable(variableName, currentTreeNode.toString(),
						DMVariableType.INPUT, variableType, index, parentVariableIndex);
				variablesArray.add(addedVariable);
				outputVariablesArray.add(index);
				currentTreeNode.setIndex(index);
				addVariableTypeToMap(addedVariable.getName(), variableType);
				if(isUnNamed(currentTreeNode)) {
					getUnNamedVariables().add(addedVariable.getName());
				}
				if (isTreeNodeElementNullable(currentNode)) {
					addVariableTypeToMap(addedVariable.getName(), SchemaDataType.NULL);
				}
				inputVariablesArray.add(index);
				if (isCurrentTreeNodeALeafNode(currentTreeNode)) {
					getResolvedVariableArray().add(index);
					tempNodeArray.add(currentTreeNode);
				}
				if (currentTreeNode.getLevel() == parentVariableStack.size()) {
					parentVariableStack.pop();
					parentVariableStack.push(currentTreeNode);
				} else if (currentTreeNode.getLevel() > parentVariableStack.size()) {
					parentVariableStack.push(currentTreeNode);
				} else {
					while (parentVariableStack.size() >= currentTreeNode.getLevel()) {
						parentVariableStack.pop();
					}
					parentVariableStack.push(currentTreeNode);
				}
			}
			nodeStack.addAll(((TreeNodeImpl) currentNode).getNode());
		}
		addOtherRootElemetsToNodeArray(tempNodeArray, input);
		populateAdjacencyLists(tempNodeArray);
	}
	
	/**
	 * Given a treenode, check if unnamed property is true.
	 * 
	 * @param currentTreeNode treenode to check
	 * @return unnamed value
	 */
	private boolean isUnNamed(TreeNodeImpl currentTreeNode) {
		for (PropertyKeyValuePair property: currentTreeNode.getProperties()) {
			if (UNAMED.equals(property.getKey())) {
				return Boolean.parseBoolean(property.getValue());
			}
		}
		return false;
	}

	private boolean isTreeNodeElementNullable(EObject currentTreeNode) {
		EList<PropertyKeyValuePair> propertyList = ((TreeNodeImpl) currentTreeNode).getProperties();
		for (PropertyKeyValuePair propertyKeyValuePair : propertyList) {
			if (JSON_SCHEMA_NULLABLE.equals(propertyKeyValuePair.getKey())) {
				return Boolean.parseBoolean(propertyKeyValuePair.getValue());
			}
		}
		return false;
	}

	private boolean isCurrentTreeNodeALeafNode(TreeNodeImpl currentTreeNode) {
		EList<DataMapperLink> outgoingLinks = currentTreeNode.getOutNode().getOutgoingLink();
		if (outgoingLinks.size() > 0) {
			return true;
		}
		return false;
	}

	private void addOtherRootElemetsToNodeArray(List<EObject> tempNodeArray, Input input) {
		EList<Operator> operators = ((DataMapperRoot) input.eContainer()).getOperators();
		for (Operator operator : operators) {
			if (isSourceOperator((OperatorImpl) operator)) {
				((OperatorImpl) operator).setMarked(true);
				tempNodeArray.add(operator);
			}
		}
	}

	private static boolean isSourceOperator(OperatorImpl operator) {
		if (operator instanceof ConstantImpl || operator instanceof PropertiesImpl
				|| operator instanceof GlobalVariableImpl) {
			return true;
		}
		return false;
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

	private void updateExecutionSequence() throws DataMapperException {
		List<Integer> unexecutedOperationList = new ArrayList<>();
		List<Integer> tempUnexecutedOperationList = new ArrayList<>();
		int numberOfOperations = operationsList.size();
		for (int i = 0; i < numberOfOperations; i++) {
			unexecutedOperationList.add(i);
		}
		boolean seqUpdated = false;
		while (executionSeq.size() < numberOfOperations) {
			seqUpdated = false;
			for (int index = 0; unexecutedOperationList.size() > index; ++index) {
				if (operationIsExecutable(unexecutedOperationList.get(index))) {
					executionSeq.add(unexecutedOperationList.get(index));
					addOutputsToResolvedVariables(unexecutedOperationList.get(index));
					seqUpdated = true;
				} else {
					tempUnexecutedOperationList.add(unexecutedOperationList.get(index));
				}
			}
			if (!seqUpdated && !tempUnexecutedOperationList.isEmpty()) {
				throw new DataMapperException("Unresolvable Mapping config detected");
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
			if (inputVariableIndex < 0) {
				continue;
			}
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

	/**
	 * This method updates the adjacency lists according to the drawn diagram
	 * 
	 * @param tempNodeArray
	 */
	private void populateAdjacencyLists(List<EObject> tempNodeArray) {
		// tempNodeArray contains both operators and elements
		while (tempNodeArray.size() > 0) {
			EObject currentElement = tempNodeArray.remove(0);
			if (currentElement instanceof TreeNodeImpl) {
				// current element is a tree node (input element)
				// get outgoing links of the input element
				EList<DataMapperLink> outgoingLinks = ((TreeNodeImpl) currentElement).getOutNode().getOutgoingLink();
				for (DataMapperLink dataMapperLink : outgoingLinks) {
					// get next linked node
					EObject linkedNode = getLinkedElement(dataMapperLink);
					if (linkedNode instanceof TreeNodeImpl) {
						// next linked element is an output element
						operationsList.add(new DMOperation(DataMapperOperatorType.DIRECT,
								getUniqueDirectId(linkedNode, operationsList.size()), operationsList.size()));
						outputAdjList.add(new ArrayList<Integer>());
						outputAdjList.get(operationsList.size() - 1).add(((TreeNodeImpl) linkedNode).getIndex());
						inputAdjList.add(new ArrayList<Integer>());
						inputAdjList.get(operationsList.size() - 1).add(((TreeNodeImpl) currentElement).getIndex());
					} else if (linkedNode instanceof OperatorImpl && !((OperatorImpl) linkedNode).isMarked()) {
						// next linked element is an operator and not marked(not
						// added to tempNodeArray)
						((OperatorImpl) linkedNode).setMarked(true);
						tempNodeArray.add(linkedNode);
					}
				}
			} else if (currentElement instanceof OperatorImpl && !((OperatorImpl) currentElement).isVisited()) {
				// current element is an operator
				int index = operationsList.size();
				OperatorImpl operatorElement = (OperatorImpl) currentElement;
				// check for split to introduce atomic operations
				if (operatorElement instanceof SplitImpl) {
					configureAdjListsForSplitOperation(tempNodeArray, currentElement, index, operatorElement);
				} else {
					DMOperation operator = ModelTransformerFactory
							.getModelTransformer(operatorElement.getOperatorType()).transform(operatorElement, index);
					operationsList.add(operator);
					graphOperationElements.add(operatorElement);
					((OperatorImpl) currentElement).setIndex(index);

					outputAdjList.add(new ArrayList<Integer>());
					inputAdjList.add(new ArrayList<Integer>());
					// populate outputAdjList
					populateOutputAdjList(tempNodeArray, index, operatorElement, operator);
					// populate inputAdjList
					List<DataMapperLink> inlinks = getInLinksOfOperator(operatorElement);
					populateInputAdjList(tempNodeArray, operatorElement, operator, inlinks);
				}
				operatorElement.setVisited(true);
			}
		}
	}

	private void configureAdjListsForSplitOperation(List<EObject> tempNodeArray, EObject currentElement, int index,
			OperatorImpl operatorElement) {
		int numberOfSplitOutputs = getOutputConnectorSize(operatorElement);
		// creating split operator
		DMOperation operator = ModelTransformerFactory.getModelTransformer(operatorElement.getOperatorType())
				.transform(operatorElement, index);
		operationsList.add(operator);
		graphOperationElements.add(operatorElement);
		((OperatorImpl) currentElement).setIndex(index);
		outputAdjList.add(new ArrayList<Integer>());
		inputAdjList.add(new ArrayList<Integer>());

		// populate inputAdjList
		List<DataMapperLink> inlinks = getInLinksOfOperator(operatorElement);
		populateInputAdjList(tempNodeArray, operatorElement, operator, inlinks);

		// Create new intermediate variable for output of the split
		// operation. This is the input variable for get operations
		String variablePrefix = operator.getOperatorType() + "_" + operator.getIndex() + "_" + 0;
		int splitOutputVariableIndex = variablesArray.size();
		DMVariable tempVar = new DMVariable(variablePrefix, getUniqueDirectId(operatorElement, 0),
				DMVariableType.INTERMEDIATE, SchemaDataType.STRING, splitOutputVariableIndex, index);
		addVariableTypeToMap(tempVar.getName(), SchemaDataType.STRING);
		variablesArray.add(tempVar);
		// set created output variable in the outputAdjList
		outputAdjList.get(operator.getIndex()).add(splitOutputVariableIndex);

		// Create get operations for each split outputs
		for (int splitOutIndex = 0; splitOutIndex < numberOfSplitOutputs; splitOutIndex++) {
			int splitGetOperationIndex = operationsList.size();
			DMOperation getOperator = new DMOperation(DataMapperOperatorType.GET,
					operatorElement.toString() + "GET" + splitGetOperationIndex, splitGetOperationIndex);
			getOperator.getProperties().put(TransformerConstants.GET_OPERATOR_INDEX, splitOutIndex);
			operationsList.add(getOperator);
			outputAdjList.add(new ArrayList<Integer>());
			inputAdjList.add(new ArrayList<Integer>());
			// set split output variable to get inputAdjList
			inputAdjList.get(splitGetOperationIndex).add(splitOutputVariableIndex);
			// populate outputAdjList
			List<DataMapperLink> outlinks = getOutLinksOfOperator(operatorElement, splitOutIndex);
			// This visitedConnectorVariableMap contains the created
			// intermediate variables
			Map<OperatorRightConnectorImpl, DMVariable> visitedConnectorVariableMap = new HashMap<>();
			for (DataMapperLink dataMapperLink : outlinks) {
				EObject linkedElement = getLinkedElement(dataMapperLink);
				if (linkedElement instanceof TreeNodeImpl) {
					// outgoing link goes to an output variable
					OperatorRightConnectorImpl rightConnector = getRightConnectorFromDMLink(dataMapperLink);
					int variableIndex = ((TreeNodeImpl) linkedElement).getIndex();
					outputAdjList.get(splitGetOperationIndex).add(variableIndex);
					operatorElement.getPortVariableIndex().add(variableIndex);
					visitedConnectorVariableMap.put(rightConnector, variablesArray.get(variableIndex));
				} else if (linkedElement instanceof OperatorImpl) {
					// outgoing link goes to an operator
					OperatorImpl linkedOperationElement = (OperatorImpl) linkedElement;
					// add to tempNodeArray if not marked
					if (!linkedOperationElement.isMarked()) {
						tempNodeArray.add(linkedElement);
						linkedOperationElement.setMarked(true);
					}
					OperatorRightConnectorImpl rightConnector = getRightConnectorFromDMLink(dataMapperLink);
					if (visitedConnectorVariableMap.containsKey(rightConnector)) {
						int variableIndex = visitedConnectorVariableMap.get(rightConnector).getIndex();
						// Check whether this linked element is
						// already
						// visited before
						if (linkedOperationElement.isVisited()) {
							if (inputAdjList.get(linkedOperationElement.getIndex()).size() <= dataMapperLink
									.getInputIndex()) {
								populateArrayListUpToAIndex(inputAdjList.get(linkedOperationElement.getIndex()),
										dataMapperLink.getInputIndex());
							}
							inputAdjList.get(linkedOperationElement.getIndex()).set(dataMapperLink.getInputIndex(),
									variableIndex);
						}
					} else {
						String getOutVariablePrefix = getOperator.getOperatorType() + "_" + operator.getIndex() + "_"
								+ splitOutIndex;
						int getOutVariableIndex = variablesArray.size();
						DMVariable tempOutVariable = new DMVariable(getOutVariablePrefix,
								getUniqueDirectId(operatorElement, splitOutIndex), DMVariableType.INTERMEDIATE,
								SchemaDataType.STRING, getOutVariableIndex, splitGetOperationIndex);
						addVariableTypeToMap(tempOutVariable.getName(), SchemaDataType.STRING);
						variablesArray.add(tempOutVariable);
						operatorElement.getPortVariableIndex().add(getOutVariableIndex);
						// get only have one output
						outputAdjList.get(getOperator.getIndex()).add(getOutVariableIndex);
						if (linkedOperationElement.isVisited()) {
							if (inputAdjList.get(linkedOperationElement.getIndex()).size() <= dataMapperLink
									.getInputIndex()) {
								populateArrayListUpToAIndex(inputAdjList.get(linkedOperationElement.getIndex()),
										dataMapperLink.getInputIndex());
							}
							inputAdjList.get(linkedOperationElement.getIndex()).set(dataMapperLink.getInputIndex(),
									getOutVariableIndex);
						}
					}
				}
			}
		}
	}

	private List<DataMapperLink> getOutLinksOfOperator(OperatorImpl operatorElement, int connectorIndex) {
		OperatorRightConnector rightConnector = operatorElement.getBasicContainer().getRightContainer()
				.getRightConnectors().get(connectorIndex);
		List<DataMapperLink> linkList = new ArrayList<>();
		EList<DataMapperLink> outLinks = rightConnector.getOutNode().getOutgoingLink();
		for (DataMapperLink dataMapperLink : outLinks) {
			dataMapperLink.setOutputIndex(connectorIndex);
		}
		linkList.addAll(outLinks);
		return linkList;
	}

	private void populateOutputAdjList(List<EObject> tempNodeArray, int index, OperatorImpl operatorElement,
			DMOperation operator) {
		Map<Integer, List<DataMapperLink>> outLinksMap = getOutLinksOfOperator(operatorElement);
		Set<Integer> conncetorKeyIndexes = outLinksMap.keySet();
		// This visitedConnectorVariableMap contains the created
		// intermediate variables
		Map<OperatorRightConnectorImpl, DMVariable> visitedConnectorVariableMap = new HashMap<>();

		// Iterate over output connectors of the operation
		for (Iterator<Integer> iterator = conncetorKeyIndexes.iterator(); iterator.hasNext();) {
			Integer integerKey = (Integer) iterator.next();
			List<DataMapperLink> outLinks = outLinksMap.get(integerKey);

			// Iterate over out links of the connector
			for (DataMapperLink dataMapperLink : outLinks) {
				EObject linkedElement = getLinkedElement(dataMapperLink);
				if (linkedElement instanceof TreeNodeImpl) {
					// outgoing link goes to an output variable

					if (outLinks.size() > 1) {
						// Need to create a intermediate variable and use a
						// direct mapping operation
						OperatorRightConnectorImpl rightConnector = getRightConnectorFromDMLink(dataMapperLink);
						if (!visitedConnectorVariableMap.containsKey(rightConnector)) {
							int variableIndex = variablesArray.size();
							DMVariable tempVar = null;
							if (DataMapperOperatorType.CONSTANT.equals(operator.getOperatorType())) {
								// If current operator is a constant operator
								tempVar = new DMVariable(
										"{" + operator.getProperty(TransformerConstants.CONSTANT_VALUE_TAG) + "}",
										getUniqueDirectId(operatorElement, dataMapperLink.getOutputIndex()),
										DMVariableType.INTERMEDIATE,
										(SchemaDataType) operator.getProperty(TransformerConstants.CONSTANT_TYPE_TAG),
										variableIndex, index);
								addVariableTypeToMap(tempVar.getName(),
										(SchemaDataType) operator.getProperty(TransformerConstants.CONSTANT_TYPE_TAG));
								variablesArray.add(tempVar);
								operatorElement.getPortVariableIndex().add(variableIndex);
							} else if (DataMapperOperatorType.PROPERTIES.equals(operator.getOperatorType())) {
								// If current operator is a properties operator
								tempVar = new DMVariable(
										"{" + TransformerConstants.PROPERTIES_PREFIX + "."
												+ operator.getProperty(TransformerConstants.PROPERTY_SCOPE_TAG) + "['"
												+ operator.getProperty(TransformerConstants.PROPERTY_NAME_TAG) + "']}",
										getUniqueDirectId(operatorElement, dataMapperLink.getOutputIndex()),
										DMVariableType.INTERMEDIATE, SchemaDataType.INT, variableIndex, index);
								if (operator.getProperties().containsKey(TransformerConstants.PROPERTY_TYPE_TAG)) {
									addVariableTypeToMap(tempVar.getName(), (SchemaDataType) operator
											.getProperty(TransformerConstants.PROPERTY_TYPE_TAG));
								} else {
									addVariableTypeToMap(tempVar.getName(), SchemaDataType.STRING);
								}
								variablesArray.add(tempVar);
								operatorElement.getPortVariableIndex().add(variableIndex);
							} else if (DataMapperOperatorType.GLOBAL_VARIABLE.equals(operator.getOperatorType())) {
								// If current operator is a global variable
								// operator
								tempVar = new DMVariable(
										"{" + operator.getProperty(TransformerConstants.GLOBAL_VARIABLE_NAME) + "}",
										getUniqueDirectId(operatorElement, dataMapperLink.getOutputIndex()),
										DMVariableType.INTERMEDIATE, SchemaDataType.INT, variableIndex, index);
								addVariableTypeToMap(tempVar.getName(), SchemaDataType.STRING);
								variablesArray.add(tempVar);
								operatorElement.getPortVariableIndex().add(variableIndex);
							} else {
								String variablePrefix = operator.getOperatorType() + "_" + operator.getIndex() + "_"
										+ dataMapperLink.getOutputIndex();
								// TODO understand the logic of if check here
								if (operatorElement.getPortVariableIndex().size() <= dataMapperLink.getOutputIndex()) {
									tempVar = new DMVariable(variablePrefix,
											getUniqueDirectId(operatorElement, dataMapperLink.getOutputIndex()),
											DMVariableType.INTERMEDIATE, SchemaDataType.STRING, variableIndex, index);
									addVariableTypeToMap(tempVar.getName(), SchemaDataType.STRING);
									variablesArray.add(tempVar);
									operatorElement.getPortVariableIndex().add(variableIndex);
								}
							}
							if (outputAdjList.get(operator.getIndex()).size() <= dataMapperLink.getOutputIndex()) {
								populateArrayListUpToAIndex(outputAdjList.get(operator.getIndex()),
										dataMapperLink.getOutputIndex());
							}
							outputAdjList.get(operator.getIndex()).set(dataMapperLink.getOutputIndex(), variableIndex);
							visitedConnectorVariableMap.put(rightConnector, tempVar);
							addDirectOperatorToMapIntermediateVariableWithOtherVariables(operatorElement, linkedElement,
									variableIndex);
						} else {
							int variableIndex = visitedConnectorVariableMap.get(rightConnector).getIndex();
							addDirectOperatorToMapIntermediateVariableWithOtherVariables(operatorElement, linkedElement,
									variableIndex);
						}
					} else {
						// Only one link mapped from this connector
						OperatorRightConnectorImpl rightConnector = getRightConnectorFromDMLink(dataMapperLink);
						int variableIndex = ((TreeNodeImpl) linkedElement).getIndex();
						if (outputAdjList.get(operatorElement.getIndex()).size() <= dataMapperLink.getOutputIndex()) {
							populateArrayListUpToAIndex(outputAdjList.get(operatorElement.getIndex()),
									dataMapperLink.getOutputIndex());
						}
						outputAdjList.get(operatorElement.getIndex()).set(dataMapperLink.getOutputIndex(),
								variableIndex);
						operatorElement.getPortVariableIndex().add(variableIndex);
						visitedConnectorVariableMap.put(rightConnector, variablesArray.get(variableIndex));
					}
				} else if (linkedElement instanceof OperatorImpl) {
					// outgoing link goes to an operator
					OperatorImpl linkedOperationElement = (OperatorImpl) linkedElement;
					// add to tempNodeArray if not marked
					if (!linkedOperationElement.isMarked()) {
						tempNodeArray.add(linkedElement);
						linkedOperationElement.setMarked(true);
					}
					OperatorRightConnectorImpl rightConnector = getRightConnectorFromDMLink(dataMapperLink);
					if (visitedConnectorVariableMap.containsKey(rightConnector)) {
						int variableIndex = visitedConnectorVariableMap.get(rightConnector).getIndex();
						// Check whether this linked element is already
						// visited before
						if (linkedOperationElement.isVisited()) {
							if (inputAdjList.get(linkedOperationElement.getIndex()).size() <= dataMapperLink
									.getInputIndex()) {
								populateArrayListUpToAIndex(inputAdjList.get(linkedOperationElement.getIndex()),
										dataMapperLink.getInputIndex());
							}
							inputAdjList.get(linkedOperationElement.getIndex()).set(dataMapperLink.getInputIndex(),
									variableIndex);
						}
					} else {
						if (DataMapperOperatorType.CONSTANT.equals(operator.getOperatorType())) {
							// If current operator is a constant operator
							configureOutAdjListForConstantOperator(index, operatorElement, operator,
									visitedConnectorVariableMap, dataMapperLink, linkedOperationElement,
									rightConnector);
						} else if (DataMapperOperatorType.PROPERTIES.equals(operator.getOperatorType())) {
							// If current operator is a properties operator
							configureOutAdjListForPropertiesOperator(index, operatorElement, operator,
									visitedConnectorVariableMap, dataMapperLink, linkedOperationElement,
									rightConnector);
						} else if (DataMapperOperatorType.GLOBAL_VARIABLE.equals(operator.getOperatorType())) {
							// If current operator is a global variable operator
							configureOutAdjListForGlobalVariableOperator(index, operatorElement, operator,
									visitedConnectorVariableMap, dataMapperLink, linkedOperationElement,
									rightConnector);
						} else {
							configureOutAdjListForOtherOperators(index, operatorElement, operator,
									visitedConnectorVariableMap, dataMapperLink, linkedOperationElement,
									rightConnector);
						}
					}
				}
			}
		}

	}

	private void addDirectOperatorToMapIntermediateVariableWithOtherVariables(OperatorImpl operatorElement,
			EObject linkedElement, int variableIndex) {
		// Add direct operator
		int addedDirectOperationIndex = operationsList.size();
		DMOperation directOperator = new DMOperation(DataMapperOperatorType.DIRECT,
				operatorElement.toString() + "DIRECT" + addedDirectOperationIndex, addedDirectOperationIndex);
		operationsList.add(directOperator);
		outputAdjList.add(new ArrayList<Integer>());
		inputAdjList.add(new ArrayList<Integer>());
		// set split output variable to get inputAdjList
		inputAdjList.get(addedDirectOperationIndex).add(variableIndex);
		outputAdjList.get(addedDirectOperationIndex).add(((TreeNodeImpl) linkedElement).getIndex());
	}

	private void configureOutAdjListForOtherOperators(int index, OperatorImpl operatorElement, DMOperation operator,
			Map<OperatorRightConnectorImpl, DMVariable> visitedConnectorVariableMap, DataMapperLink dataMapperLink,
			OperatorImpl linkedOperationElement, OperatorRightConnectorImpl rightConnector) {
		String variablePrefix = operator.getOperatorType() + "_" + operator.getIndex() + "_"
				+ dataMapperLink.getOutputIndex();
		if (operatorElement.getPortVariableIndex().size() <= dataMapperLink.getOutputIndex()) {
			int variableIndex = variablesArray.size();
			DMVariable tempVar = new DMVariable(variablePrefix,
					getUniqueDirectId(operatorElement, dataMapperLink.getOutputIndex()), DMVariableType.INTERMEDIATE,
					SchemaDataType.STRING, variableIndex, index);
			addVariableTypeToMap(tempVar.getName(), SchemaDataType.STRING);
			variablesArray.add(tempVar);
			operatorElement.getPortVariableIndex().add(variableIndex);
			if (outputAdjList.get(operator.getIndex()).size() <= dataMapperLink.getOutputIndex()) {
				populateArrayListUpToAIndex(outputAdjList.get(operator.getIndex()), dataMapperLink.getOutputIndex());
			}
			outputAdjList.get(operator.getIndex()).set(dataMapperLink.getOutputIndex(), variableIndex);
			if (linkedOperationElement.isVisited()) {
				if (inputAdjList.get(linkedOperationElement.getIndex()).size() <= dataMapperLink.getInputIndex()) {
					populateArrayListUpToAIndex(inputAdjList.get(linkedOperationElement.getIndex()),
							dataMapperLink.getInputIndex());
				}
				inputAdjList.get(linkedOperationElement.getIndex()).set(dataMapperLink.getInputIndex(), variableIndex);
			}
			visitedConnectorVariableMap.put(rightConnector, tempVar);
		}
	}

	private void configureOutAdjListForGlobalVariableOperator(int index, OperatorImpl operatorElement,
			DMOperation operator, Map<OperatorRightConnectorImpl, DMVariable> visitedConnectorVariableMap,
			DataMapperLink dataMapperLink, OperatorImpl linkedOperationElement,
			OperatorRightConnectorImpl rightConnector) {
		int variableIndex = variablesArray.size();
		DMVariable tempVar = new DMVariable("{" + operator.getProperty(TransformerConstants.GLOBAL_VARIABLE_NAME) + "}",
				getUniqueDirectId(operatorElement, dataMapperLink.getOutputIndex()), DMVariableType.INTERMEDIATE,
				SchemaDataType.INT, variableIndex, index);
		addVariableTypeToMap(tempVar.getName(), SchemaDataType.STRING);
		variablesArray.add(tempVar);
		operatorElement.getPortVariableIndex().add(variableIndex);
		if (outputAdjList.get(operator.getIndex()).size() <= dataMapperLink.getOutputIndex()) {
			populateArrayListUpToAIndex(outputAdjList.get(operator.getIndex()), dataMapperLink.getOutputIndex());
		}
		outputAdjList.get(operator.getIndex()).set(dataMapperLink.getOutputIndex(), variableIndex);
		if (linkedOperationElement.isVisited()) {
			if (inputAdjList.get(linkedOperationElement.getIndex()).size() <= dataMapperLink.getInputIndex()) {
				populateArrayListUpToAIndex(inputAdjList.get(linkedOperationElement.getIndex()),
						dataMapperLink.getInputIndex());
			}
			inputAdjList.get(linkedOperationElement.getIndex()).set(dataMapperLink.getInputIndex(), variableIndex);
		}
		visitedConnectorVariableMap.put(rightConnector, tempVar);
	}

	private void configureOutAdjListForPropertiesOperator(int index, OperatorImpl operatorElement, DMOperation operator,
			Map<OperatorRightConnectorImpl, DMVariable> visitedConnectorVariableMap, DataMapperLink dataMapperLink,
			OperatorImpl linkedOperationElement, OperatorRightConnectorImpl rightConnector) {
		int variableIndex = variablesArray.size();
		DMVariable tempVar = new DMVariable(
				"{" + TransformerConstants.PROPERTIES_PREFIX + "."
						+ operator.getProperty(TransformerConstants.PROPERTY_SCOPE_TAG) + "['"
						+ operator.getProperty(TransformerConstants.PROPERTY_NAME_TAG) + "']}",
				getUniqueDirectId(operatorElement, dataMapperLink.getOutputIndex()), DMVariableType.INTERMEDIATE,
				SchemaDataType.INT, variableIndex, index);
		if (operator.getProperties().containsKey(TransformerConstants.PROPERTY_TYPE_TAG)) {
			addVariableTypeToMap(tempVar.getName(),
					(SchemaDataType) operator.getProperty(TransformerConstants.PROPERTY_TYPE_TAG));
		} else {
			addVariableTypeToMap(tempVar.getName(), SchemaDataType.STRING);
		}
		variablesArray.add(tempVar);
		operatorElement.getPortVariableIndex().add(variableIndex);
		if (outputAdjList.get(operator.getIndex()).size() <= dataMapperLink.getOutputIndex()) {
			populateArrayListUpToAIndex(outputAdjList.get(operator.getIndex()), dataMapperLink.getOutputIndex());
		}
		outputAdjList.get(operator.getIndex()).set(dataMapperLink.getOutputIndex(), variableIndex);
		if (linkedOperationElement.isVisited()) {
			if (inputAdjList.get(linkedOperationElement.getIndex()).size() <= dataMapperLink.getInputIndex()) {
				populateArrayListUpToAIndex(inputAdjList.get(linkedOperationElement.getIndex()),
						dataMapperLink.getInputIndex());
			}
			inputAdjList.get(linkedOperationElement.getIndex()).set(dataMapperLink.getInputIndex(), variableIndex);
		}
		visitedConnectorVariableMap.put(rightConnector, tempVar);
	}

	private void configureOutAdjListForConstantOperator(int index, OperatorImpl operatorElement, DMOperation operator,
			Map<OperatorRightConnectorImpl, DMVariable> visitedConnectorVariableMap, DataMapperLink dataMapperLink,
			OperatorImpl linkedOperationElement, OperatorRightConnectorImpl rightConnector) {
		int variableIndex = variablesArray.size();
		DMVariable tempVar = new DMVariable("{" + operator.getProperty(TransformerConstants.CONSTANT_VALUE_TAG) + "}",
				getUniqueDirectId(operatorElement, dataMapperLink.getOutputIndex()), DMVariableType.INTERMEDIATE,
				(SchemaDataType) operator.getProperty(TransformerConstants.CONSTANT_TYPE_TAG), variableIndex, index);
		addVariableTypeToMap(tempVar.getName(),
				(SchemaDataType) operator.getProperty(TransformerConstants.CONSTANT_TYPE_TAG));
		variablesArray.add(tempVar);
		operatorElement.getPortVariableIndex().add(variableIndex);
		if (outputAdjList.get(operator.getIndex()).size() <= dataMapperLink.getOutputIndex()) {
			populateArrayListUpToAIndex(outputAdjList.get(operator.getIndex()), dataMapperLink.getOutputIndex());
		}
		outputAdjList.get(operator.getIndex()).set(dataMapperLink.getOutputIndex(), variableIndex);
		if (linkedOperationElement.isVisited()) {
			if (inputAdjList.get(linkedOperationElement.getIndex()).size() <= dataMapperLink.getInputIndex()) {
				populateArrayListUpToAIndex(inputAdjList.get(linkedOperationElement.getIndex()),
						dataMapperLink.getInputIndex());
			}
			inputAdjList.get(linkedOperationElement.getIndex()).set(dataMapperLink.getInputIndex(), variableIndex);
		}
		visitedConnectorVariableMap.put(rightConnector, tempVar);
	}

	private void populateInputAdjList(List<EObject> tempNodeArray, OperatorImpl operatorElement, DMOperation operator,
			List<DataMapperLink> inlinks) {
		for (DataMapperLink dataMapperLink : inlinks) {
			EObject linkedElement = getPreviousLinkedElement(dataMapperLink);
			if (linkedElement instanceof TreeNodeImpl) {
				if (inputAdjList.get(operatorElement.getIndex()).size() <= dataMapperLink.getInputIndex()) {
					populateArrayListUpToAIndex(inputAdjList.get(operatorElement.getIndex()),
							dataMapperLink.getInputIndex());
				}
				inputAdjList.get(operatorElement.getIndex()).set(dataMapperLink.getInputIndex(),
						((TreeNodeImpl) linkedElement).getIndex());
			} else if (linkedElement instanceof OperatorImpl) {
				OperatorImpl sourceElement = (OperatorImpl) linkedElement;
				if (!sourceElement.isMarked()) {
					sourceElement.setMarked(true);
					tempNodeArray.add(sourceElement);
				} else if (sourceElement.isVisited()) {
					int indexOfSourceRightContainer = getVaribleIndexInSourceElementWithLink(sourceElement,
							dataMapperLink);
					if (inputAdjList.get(operator.getIndex()).size() <= dataMapperLink.getInputIndex()) {
						populateArrayListUpToAIndex(inputAdjList.get(operator.getIndex()),
								dataMapperLink.getInputIndex());
					}
					inputAdjList.get(operator.getIndex()).set(dataMapperLink.getInputIndex(),
							sourceElement.getPortVariableIndex().get(indexOfSourceRightContainer));
				}
			}
		}
	}

	private int getOutputConnectorSize(OperatorImpl operatorElement) {
		return operatorElement.getBasicContainer().getRightContainer().getRightConnectors().size();
	}

	private void populateArrayListUpToAIndex(ArrayList<Integer> arrayList, int inputIndex) {
		int numberOfItemsToAdd = inputIndex - arrayList.size() + 1;
		for (int i = 0; i < numberOfItemsToAdd; i++) {
			arrayList.add(-1);
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
		if (element instanceof TreeNodeImpl) {
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
		int connectorIndex = 0;
		for (OperatorLeftConnector operatorLeftConnector : leftContainers) {
			EList<DataMapperLink> inLinks = operatorLeftConnector.getInNode().getIncomingLink();
			for (DataMapperLink dataMapperLink : inLinks) {
				dataMapperLink.setInputIndex(connectorIndex);
			}
			linkList.addAll(inLinks);
			connectorIndex++;
		}
		return linkList;
	}

	private Map<Integer, List<DataMapperLink>> getOutLinksOfOperator(OperatorImpl operatorElement) {
		EList<OperatorRightConnector> rightConnectors = operatorElement.getBasicContainer().getRightContainer()
				.getRightConnectors();
		Map<Integer, List<DataMapperLink>> linksMap = new HashMap<>();
		int connectorIndex = 0;
		for (OperatorRightConnector operatorRightConnector : rightConnectors) {
			linksMap.put(connectorIndex, new ArrayList<DataMapperLink>());
			EList<DataMapperLink> outLinks = operatorRightConnector.getOutNode().getOutgoingLink();
			for (DataMapperLink dataMapperLink : outLinks) {
				dataMapperLink.setOutputIndex(connectorIndex);
				linksMap.get(connectorIndex).add(dataMapperLink);
			}
			connectorIndex++;
		}
		return linksMap;
	}

	private String getUniqueDirectId(EObject parent, int size) {
		return parent.toString() + " " + size;
	}

	private EObject getLinkedElement(DataMapperLink dataMapperLink) {
		if (dataMapperLink.getInNode() != null) {
			EObject element = dataMapperLink.getInNode().eContainer();
			if (element instanceof TreeNodeImpl) {
				return element;
			} else {
				while (!(element instanceof OperatorImpl)) {
					element = element.eContainer();
				}
				return element;
			}
		}
		return null;
	}

	/**
	 * This method will populate the outputVariables array field from diagram
	 * output tree
	 * 
	 * @param output
	 */
	private void populateOutputVariablesDepthFirst(Output output) {
		Stack<EObject> nodeStack = new Stack<>();
		nodeStack.addAll(output.getTreeNode());
		Map<String, String> outputInputElementMapping = new HashMap<>();
		Map<String, String> outputInputRootElementMapping = new HashMap<>();
		Stack<EObject> parentVariableStack = new Stack<EObject>();
		while (!nodeStack.isEmpty()) {
			EObject currentNode = nodeStack.pop();
			if (currentNode instanceof TreeNodeImpl) {
				final TreeNodeImpl currentTreeNode = (TreeNodeImpl) currentNode;
				
				if (currentTreeNode.getName().contains(".")) {
					TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(currentTreeNode);
					domain.getCommandStack().execute(new RecordingCommand(domain) {
						protected void doExecute() {
							currentTreeNode.setName(replaceSpecialCharactersInAttribute(currentTreeNode.getName()));
						}
					});
				}
				
				if (currentTreeNode.getLevel() <= parentVariableStack.size()) {
					while (parentVariableStack.size() >= currentTreeNode.getLevel()) {
						parentVariableStack.pop();
					}
				} else if (currentTreeNode.getLevel() > (parentVariableStack.size() + 1)) {
					throw new IllegalArgumentException("Illegal element level detected : element level- "
							+ currentTreeNode.getLevel() + " , parents level- " + parentVariableStack.size());
				}
				int variableIndex = variablesArray.size();
				String variableName = getVariableName(DMVariableType.OUTPUT, parentVariableStack,
						currentTreeNode.getName());
				
				int parentVariableIndex = -1;
				if (!parentVariableStack.isEmpty()) {
					TreeNodeImpl parent = (TreeNodeImpl) parentVariableStack.peek();
					parentVariableIndex = parent.getIndex();
				}
				SchemaDataType variableType = getSchemaDataType(getTreeNodeType(currentTreeNode));
				if (SchemaDataType.OBJECT.equals(variableType)) {
					int operationIndex = operationsList.size();
					DMOperation instantiateOperator = new DMOperation(DataMapperOperatorType.INSTANTIATE,
							"INSTANTATIATE_" + operationIndex, operationIndex);
					instantiateOperator.addProperty(TransformerConstants.VARIABLE_TYPE, variableType);
					operationsList.add(instantiateOperator);
					outputAdjList.add(new ArrayList<Integer>());
					outputAdjList.get(operationsList.size() - 1).add(variableIndex);
					inputAdjList.add(new ArrayList<Integer>());
				} else if (SchemaDataType.ARRAY.equals(variableType)) {
					int operationIndex = operationsList.size();
					DMOperation instantiateOperator = new DMOperation(DataMapperOperatorType.INSTANTIATE,
							"INSTANTATIATE_" + operationIndex, operationIndex);
					instantiateOperator.addProperty(TransformerConstants.VARIABLE_TYPE, variableType);
					operationsList.add(instantiateOperator);
					outputAdjList.add(new ArrayList<Integer>());
					outputAdjList.get(operationsList.size() - 1).add(variableIndex);
					inputAdjList.add(new ArrayList<Integer>());
					if (getTreeNodeArrayItemType(currentTreeNode)
							.equalsIgnoreCase(SchemaDataType.OBJECT.getLiteral())) {
						operationIndex = operationsList.size();
						DMOperation instantiateObjectOperator = new DMOperation(DataMapperOperatorType.INSTANTIATE,
								"INSTANTATIATE_" + operationIndex, operationIndex);
						instantiateObjectOperator.addProperty(TransformerConstants.VARIABLE_TYPE,
								SchemaDataType.OBJECT);
						//This property is used to identify as a object of array elements 
						instantiateObjectOperator.addProperty(TransformerConstants.INSTANTIATE_PARENT_VARIABLE,
								SchemaDataType.ARRAY);
						operationsList.add(instantiateObjectOperator);
						outputAdjList.add(new ArrayList<Integer>());
						outputAdjList.get(operationsList.size() - 1).add(variableIndex);
						inputAdjList.add(new ArrayList<Integer>());
					}
				}
				String mappedInputElementName;
				String mappedInputRootArrayElementName;
				if (SchemaDataType.ARRAY.equals(variableType)) {
					mappedInputElementName = getMappedInputElement(currentTreeNode);
					outputInputElementMapping.put(variableName, mappedInputElementName);
					mappedInputRootArrayElementName = getMappedRootArrayInputElement(currentTreeNode);
					outputInputRootElementMapping.put(variableName, mappedInputRootArrayElementName);
				} else {
					mappedInputElementName = getMappedInputArrayFromMap(outputInputElementMapping,variableName);
					mappedInputRootArrayElementName = getMappedInputArrayFromMap(outputInputRootElementMapping,variableName);
				}
				variablesArray.add(new DMVariable(variableName, currentNode.toString(), DMVariableType.OUTPUT,
						variableType, variableIndex, parentVariableIndex,mappedInputElementName, mappedInputRootArrayElementName));
				outputVariablesArray.add(variableIndex);
				currentTreeNode.setIndex(variableIndex);
				addVariableTypeToMap(variableName, variableType);
				if (isUnNamed(currentTreeNode)) {
					getUnNamedVariables().add(variableName);
				}
				if (currentTreeNode.getLevel() == parentVariableStack.size()) {
					parentVariableStack.pop();
					parentVariableStack.push(currentTreeNode);
				} else if (currentTreeNode.getLevel() > parentVariableStack.size()) {
					parentVariableStack.push(currentTreeNode);
				} else {
					while (parentVariableStack.size() >= currentTreeNode.getLevel()) {
						parentVariableStack.pop();
					}
					parentVariableStack.push(currentTreeNode);
				}
				EList<TreeNode> nodeList = ((TreeNodeImpl) currentNode).getNode();
				ECollections.reverse(nodeList);
				nodeStack.addAll(nodeList);
				ECollections.reverse(nodeList);
			}
		}
	}

	private String getMappedRootArrayInputElement(TreeNodeImpl currentTreeNode) {
		EList<PropertyKeyValuePair> propertyList = currentTreeNode.getProperties();
		for (PropertyKeyValuePair propertyKeyValuePair : propertyList) {
			if ("arrayRootInterrelatedElement".equals(propertyKeyValuePair.getKey())) {
				return propertyKeyValuePair.getValue();
			}
		}
		return null;
	}

	private String getMappedInputArrayFromMap(Map<String, String> outputInputElementMapping, String variableName) {
		Set<String> outputArrayVariables = outputInputElementMapping.keySet();
		List<String> outputArrayVariablesList = new ArrayList<>();
		for (String string : outputArrayVariables) {
			outputArrayVariablesList.add(string);
		}
		Collections.sort(outputArrayVariablesList, new Comparator<String>() {

			@Override
			public int compare(String str1, String str2) {
				return -str1.length() + str2.length();
			}
		});
		for (String arrayName : outputArrayVariablesList) {
			if(variableName.startsWith(arrayName)){
				return outputInputElementMapping.get(arrayName);
			}
		}
		return null;
	}

	private String getMappedInputElement(TreeNodeImpl currentTreeNode) {
		EList<PropertyKeyValuePair> propertyList = currentTreeNode.getProperties();
		for (PropertyKeyValuePair propertyKeyValuePair : propertyList) {
			if ("arrayInterrelatedElement".equals(propertyKeyValuePair.getKey())) {
				return propertyKeyValuePair.getValue();
			}
		}
		return null;
	}

	private String getTreeNodeType(TreeNodeImpl currentTreeNode) {
		EList<PropertyKeyValuePair> propertyList = currentTreeNode.getProperties();
		for (PropertyKeyValuePair propertyKeyValuePair : propertyList) {
			if (TYPE.equals(propertyKeyValuePair.getKey())) {
				return propertyKeyValuePair.getValue();
			}
		}
		throw new IllegalArgumentException("Type field not found in treeNode");
	}

	private String getTreeNodeArrayItemType(TreeNodeImpl currentTreeNode) {
		EList<PropertyKeyValuePair> propertyList = currentTreeNode.getProperties();
		for (PropertyKeyValuePair propertyKeyValuePair : propertyList) {
			if (ITEM_TYPE.equals(propertyKeyValuePair.getKey())) {
				return propertyKeyValuePair.getValue();
			}
		}
		throw new IllegalArgumentException("Item Type field not found in treeNode");
	}

	private SchemaDataType getSchemaDataType(String type) {
		switch (type) {
		case "string":
			return SchemaDataType.STRING;
		case "object":
			return SchemaDataType.OBJECT;
		case "array":
			return SchemaDataType.ARRAY;
		case "boolean":
			return SchemaDataType.BOOLEAN;
		case "number":
			return SchemaDataType.NUMBER;
		case "integer":
			return SchemaDataType.NUMBER;
		case "null":
			return SchemaDataType.NULL;
		default:
			throw new IllegalArgumentException("Illegal schema data type found : " + type);
		}
	}

	private String getVariableName(DMVariableType prefix, Stack<EObject> parentVariableStack, String name) {
		String variableName = prefix.toString().toLowerCase();
		for (EObject eObject : parentVariableStack) {
			if (eObject instanceof TreeNodeImpl) {
				variableName = variableName
						+ ScriptGenerationUtil.removeInvalidCharaters(((TreeNodeImpl) eObject).getName()) + ".";
			} else if (eObject instanceof ElementImpl) {
				variableName = variableName
						+ ScriptGenerationUtil.removeInvalidCharaters(((ElementImpl) eObject).getName()) + ".";
			} else {
				throw new IllegalArgumentException("Illegal element type found : " + eObject.toString());
			}
		}
		return variableName + ScriptGenerationUtil.removeInvalidCharaters(name);
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
		// removing name-space prefix from the schema name and save it as root
		// name
		String[] rootNameArray = inputRootName.split(NAMESPACE_SEPERATOR);
		this.inputRootName = rootNameArray[rootNameArray.length - 1];
	}

	public String getOutputRootName() {
		return outputRootName;
	}

	public void setOutputRootName(String outputRootName) {
		// removing name-space prefix from the schema name and save it as root
		// name
		String[] rootNameArray = outputRootName.split(NAMESPACE_SEPERATOR);
		this.outputRootName = rootNameArray[rootNameArray.length - 1];
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

	public Map<String, List<SchemaDataType>> getVariableTypeMap() {
		return variableTypeMap;
	}

	public void setVariableTypeMap(Map<String, List<SchemaDataType>> variableTypeMap) {
		this.variableTypeMap = variableTypeMap;
	}

	private void addVariableTypeToMap(String variableName, SchemaDataType type) {
		if (!getVariableTypeMap().containsKey(variableName)) {
			getVariableTypeMap().put(variableName, new ArrayList<SchemaDataType>());
		}
		getVariableTypeMap().get(variableName).add(type);
	}
	
	private String replaceSpecialCharactersInAttribute(String attributeName) {
	    return attributeName.replace(".", DOT_REPRESENTATION);
	}

	public List<String> getUnNamedVariables() {
		return unNamedVariables;
	}

}

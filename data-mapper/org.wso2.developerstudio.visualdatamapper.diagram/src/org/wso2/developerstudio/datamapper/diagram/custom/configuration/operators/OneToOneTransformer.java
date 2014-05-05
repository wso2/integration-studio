/*
 * Copyright 2014 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.datamapper.diagram.custom.configuration.operators;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.Operator;
import org.wso2.developerstudio.datamapper.OperatorLeftConnector;
import org.wso2.developerstudio.datamapper.OperatorRightConnector;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.function.AssignmentStatement;

public class OneToOneTransformer implements OperatorsTransformer {

	private static final String INDEX = "[i]";

	@Override
	public AssignmentStatement transform(Operator operator) {

		return null;
	}

	@Override
	public TreeNode getOutputElementParent(Operator operator) {
		EObject outputObject = getOutputObject(operator);
		EObject inputObject = getInputObject(operator);

		Element outputElement;
		TreeNode outputParent;
		Element inputElement;

		if (inputObject instanceof Element && outputObject instanceof Element) {
			outputElement = (Element) outputObject;
			outputParent = outputElement.getFieldParent();
			inputElement = (Element) inputObject;

			outputParent = getOutputArrayParent(inputElement, outputParent);
			return outputParent;
		}

		else if (inputObject instanceof Element && outputObject instanceof OperatorLeftConnector) {
			Operator nextOperator = (Operator) getOperator(outputObject);
			inputElement = (Element) inputObject;
			OperatorsTransformer transformer = DataMapperTransformerRegistry.getInstance().getTransformer(nextOperator);
			outputParent = transformer.getOutputElementParent(nextOperator);
			outputParent = getOutputArrayParent(inputElement, outputParent);
			return outputParent;
		} else if (inputObject instanceof OperatorRightConnector && outputObject instanceof OperatorLeftConnector) {
			Operator nextOperator = (Operator) getOperator(outputObject);
			OperatorsTransformer transformer = DataMapperTransformerRegistry.getInstance().getTransformer(nextOperator);
			outputParent = transformer.getOutputElementParent(nextOperator);

			return outputParent;
		}

		else if (inputObject instanceof OperatorRightConnector && outputObject instanceof Element) {
			outputElement = (Element) outputObject;
			outputParent = outputElement.getFieldParent();
			return outputParent;
		}
		return null;
	}

	/**
	 * when input is an element of array treenode, the outputparent treenode
	 * also need to be an array
	 * 
	 * @param inputElement
	 *            input schema element
	 * @param outputParent
	 * @return
	 */
	private TreeNode getOutputArrayParent(Element inputElement, TreeNode outputParent) {
		if (inputElement.getFieldParent().getSchemaDataType().equals(SchemaDataType.ARRAY) && !(outputParent.getSchemaDataType().equals(SchemaDataType.ARRAY))) {
			while (outputParent.getFieldParent() != null && !(outputParent.getSchemaDataType().equals(SchemaDataType.ARRAY))) {
				outputParent = outputParent.getFieldParent();
			}
		}

		return outputParent;
	}

	@Override
	public TreeNode getInputElementParent(Operator operator) {
		return getInputElement(operator).getFieldParent();
	}

	/**
	 * traverse up from a given treeNode to given root treenode and build path
	 * 
	 * @param tree
	 *            given treenode
	 * @param parent
	 *            given root treenode
	 * @return path to root treeNode from given treeNode
	 */
	protected String getTreeHierarchy(TreeNode tree, TreeNode parent) {
		StringBuilder hierarchy = new StringBuilder();

		while (!(tree.equals(parent))) {
			hierarchy.insert(0, tree.getName());
			hierarchy.insert(0, ".");
			tree = tree.getFieldParent();
		}

		if (tree.getSchemaDataType().equals(SchemaDataType.ARRAY)) {
			hierarchy.insert(0, (tree.getName() + getIndex()));
		} else {
			hierarchy.insert(0, tree.getName());
		}

		return hierarchy.toString();

	}

	/**
	 * retrieve mapped element from output schema
	 * 
	 * @param operator
	 *            this operator
	 * @return mapped element from output schema
	 */
	protected Element getOutputElement(Operator operator) {
		return operator.getBasicContainer().getRightContainer().getRightConnectors().get(0).getOutNode().getOutgoingLink().get(0).getInNode().getElementParent();
	}

	/**
	 * retrieve mapped element from input schema
	 * 
	 * @param operator
	 *            this operator
	 * @return mapped element from input schema
	 */
	private Element getInputElement(Operator operator) {
		return operator.getBasicContainer().getLeftContainer().getLeftConnectors().get(0).getInNode().getIncomingLink().get(0).getOutNode().getElementParent();
	}

	/**
	 * retrieve mapped object to input connector of operator
	 * 
	 * @param operator
	 *            this operator
	 * @return mapped object to input connector of operator
	 */
	protected EObject getInputObject(Operator operator) {
		EList<OperatorLeftConnector> leftConnectors = operator.getBasicContainer().getLeftContainer().getLeftConnectors();
		EObject inputObject = leftConnectors.get(0).getInNode().getIncomingLink().get(0).getOutNode().eContainer();
		return inputObject;
	}

	/**
	 * retrieve mapped object to output connector of operator
	 * 
	 * @param operator
	 *            this operator
	 * @return mapped object to output connector of operator
	 */
	public EObject getOutputObject(Operator operator) {
		EList<OperatorRightConnector> rightConnectors = operator.getBasicContainer().getRightContainer().getRightConnectors();
		return rightConnectors.get(0).getOutNode().getOutgoingLink().get(0).getInNode().eContainer();
	}

	public static String getIndex() {
		return INDEX;
	}

	/**
	 * in three econtainers of a eobject would be an operator. it would be easy
	 * to declare it a class
	 * 
	 * @param connector
	 *            in or put node eobject
	 * @return operator which connected to in/out node
	 */
	public Operator getOperator(EObject connector) {
		return (Operator) connector.eContainer().eContainer().eContainer();
	}

	@Override
	public String trasnform(String statement, Operator operator, Operator nextOperator) {
		// TODO Auto-generated method stub
		return null;
	}

}

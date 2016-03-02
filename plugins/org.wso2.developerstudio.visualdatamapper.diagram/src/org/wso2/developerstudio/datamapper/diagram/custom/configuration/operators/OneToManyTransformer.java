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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.Operator;
import org.wso2.developerstudio.datamapper.OperatorRightConnector;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.function.AssignmentStatement;

public class OneToManyTransformer implements OperatorsTransformer {
	private static final String INDEX = "[i]";

	@Override
	public AssignmentStatement transform(Operator operator) {

		return null;
	}

	@Override
	public TreeNode getOutputElementParent(Operator operator) {
		ArrayList<Element> elements = getOutputElements(operator);
		TreeNode highestParent = null;
		for (Element element : elements) {
			if (element != null) {
				if (highestParent != null) {
					if (highestParent.getLevel() >= element.getFieldParent().getLevel()) {
						highestParent = element.getFieldParent();
					}
				} else {
					highestParent = element.getFieldParent();
				}
			}
		}

		if (getInputElement(operator).getFieldParent().getSchemaDataType().equals(SchemaDataType.ARRAY) && !(highestParent.getSchemaDataType().equals(SchemaDataType.ARRAY))) {
			while (highestParent.getFieldParent() != null && !(highestParent.getSchemaDataType().equals(SchemaDataType.ARRAY))) {
				highestParent = highestParent.getFieldParent();
			}
		}

		return highestParent;
	}

	/**
	 * mapped output elements needs for create map statements
	 * 
	 * @param operator
	 *            split operator
	 * @return output elements which split results mapped
	 */
	protected ArrayList<Element> getOutputElements(Operator operator) {
		EList<OperatorRightConnector> rightConnectors = operator.getBasicContainer().getRightContainer().getRightConnectors();
		ArrayList<Element> elementList = new ArrayList<Element>();
		for (OperatorRightConnector connector : rightConnectors) {
			if (connector.getOutNode().getOutgoingLink().size() != 0) {
				elementList.add(connector.getOutNode().getOutgoingLink().get(0).getInNode().getElementParent());
			} else {
				elementList.add(null);
			}
		}
		return elementList;
	}

	/**
	 * mapped input element needs for create map statements
	 * 
	 * @param operator
	 *            split operator
	 * @return input element for split
	 */
	protected Element getInputElement(Operator operator) {
		return operator.getBasicContainer().getLeftContainer().getLeftConnectors().get(0).getInNode().getIncomingLink().get(0).getOutNode().getElementParent();
	}

	@Override
	public String trasnform(String statement, Operator operator, Operator nextOperator) {
		// TODO Auto-generated method stub
		return null;
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
	public String getTreeHierarchy(TreeNode tree, TreeNode parent) {
		StringBuilder hierarchy = new StringBuilder();

		while (!(tree.equals(parent))) {
			hierarchy.insert(0, tree.getName());
			hierarchy.insert(0, ".");
			tree = tree.getFieldParent();
		}

		if (tree.getSchemaDataType().equals(SchemaDataType.ARRAY)) {
			hierarchy.insert(0, (tree.getName() + INDEX));
		} else {
			hierarchy.insert(0, tree.getName());
		}

		return hierarchy.toString();

	}

	/**
	 * retrieve mapped objects to output connector of operator
	 * @param operator this operator
	 * @return mapped object to output connector of operator
	 */
	public List<EObject> getOutputEObjects(Operator operator) {
		EList<OperatorRightConnector> rightConnectors = operator.getBasicContainer().getRightContainer().getRightConnectors();
		ArrayList<EObject> eObjectList = new ArrayList<EObject>();
		for (OperatorRightConnector connector : rightConnectors) {
			if (connector.getOutNode().getOutgoingLink().size() != 0) {
				eObjectList.add(connector.getOutNode().getOutgoingLink().get(0).getInNode().eContainer());
			} else {
				eObjectList.add(null);
			}
		}
		return eObjectList;
	}

	@Override
	public TreeNode getInputElementParent(Operator operator) {
		return getInputElement(operator).getFieldParent();
	}
}

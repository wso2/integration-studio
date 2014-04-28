/*
 * Copyright 2005,2014 WSO2, Inc. http://www.wso2.org
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

package dataMapper.diagram.custom.generator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.visualdatamapper.diagram.Activator;

import dataMapper.DataMapperLink;
import dataMapper.DataMapperRoot;
import dataMapper.Element;
import dataMapper.SchemaDataType;
import dataMapper.TreeNode;
import dataMapper.diagram.custom.persistence.OperatorConfigurationUtil;
import dataMapper.impl.OperatorImpl;

/**
 * Navigate through mapping model and generate configuration based on the
 * mapping links.
 */
public class MappingModelNavigator {

	private static MappingModelNavigator instance;

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private MappingModelNavigator() {

	}

	/**
	 * Get singleton instance of MappingModelNavigator.
	 * 
	 * @return
	 */
	public static MappingModelNavigator getInstance() {
		if (instance == null) {
			instance = new MappingModelNavigator();
		}

		return instance;
	}

	/**
	 * Generate mapping configuration of the given data mapping model.
	 * 
	 * @param rootDiagram
	 * @return
	 */
	public String getMappingConfig(DataMapperRoot rootDiagram) {
		List<Operator> operations = new ArrayList<Operator>();
		traverseInputTree(rootDiagram.getInput().getTreeNode().get(0), operations);

		String inputRoot = rootDiagram.getInput().getTreeNode().get(0).getName();
		String outputRoot = rootDiagram.getOutput().getTreeNode().get(0).getName();

		JavaScriptGenerator scriptGenerator = new JavaScriptGenerator(operations, inputRoot,
				outputRoot);

		String source = "";
		try {
			scriptGenerator.generate();
		} catch (Exception e) {
			log.error("Data mapper config generation failed.", e);
		}

		try {
			source = scriptGenerator.printConfig();
		} catch (Exception e) {
			log.error("Data mapper config generation failed.", e);
		}

		return source;
	}

	/**
	 * Traverse input schema tree.
	 * 
	 * @param treeNode
	 * @param operations
	 */
	private void traverseInputTree(TreeNode treeNode, List<Operator> operations) {

		// Iterator over each element and check whether elements are mapped.
		for (Element element : treeNode.getElement()) {
			if (OperatorConfigurationUtil.isMaped(element)) {
				// Create operators related to the mapping.
				EList<DataMapperLink> elementLinkList = element.getOutNode().getOutgoingLink();

				for (DataMapperLink mappingLink : elementLinkList) {
					Operator operator = null;
					if (isDirectMapping(mappingLink)) {
						// Link is directly connected with output element.
						operator = createAssignOperator(element, mappingLink);
					} else if (isOperatorMapping(mappingLink)) {
						// Link is connected through operator(s).
					}

					if (operator != null) {
						operations.add(operator);
					}
				}
			}
		}

		// Traverse through child trees.
		if (treeNode.getNode() != null) {
			for (TreeNode childTree : treeNode.getNode()) {
				traverseInputTree(childTree, operations);
			}
		}
	}

	/**
	 * Check whether link is directly connected with output element.
	 * 
	 * @param mappingLink
	 * @return
	 */
	private boolean isDirectMapping(DataMapperLink mappingLink) {
		if (mappingLink.getInNode() != null && mappingLink.getInNode().getElementParent() != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check whether link is connected with output element through any operator.
	 * 
	 * @param mappingLink
	 * @return
	 */
	private boolean isOperatorMapping(DataMapperLink mappingLink) {
		if (mappingLink.getInNode() != null
				&& mappingLink.getInNode().eContainer().eContainer().eContainer().eContainer() instanceof OperatorImpl) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Create OperatorName.ASSIGNE operator
	 * 
	 * @param mappedInputElement
	 * @param mappingLink
	 * @return
	 */
	private Operator createAssignOperator(Element mappedInputElement, DataMapperLink mappingLink) {
		Operator assignOperator = new Operator(OperatorName.ASSIGNE);

		String inputMappingStatement = getElementHierarchy(mappedInputElement);
		assignOperator.getInputs().put(1, inputMappingStatement);

		Element outputElement = mappingLink.getInNode().getElementParent();
		String outputMappingStatement = getElementHierarchy(outputElement);
		assignOperator.getOutputs().put(1, outputMappingStatement);

		return assignOperator;
	}

	/*
	 * private Operator createOperator(Element mappedInputElement,
	 * DataMapperLink mappingLink) { Operator operator = null;
	 * 
	 * return operator; }
	 */

	/**
	 * Get element hierarchy from root element.
	 * 
	 * @param mappedElement
	 * @return
	 */
	private static String getElementHierarchy(Element mappedElement) {
		TreeNode immediateParent = mappedElement.getFieldParent();
		StringBuilder elementHierarchy = new StringBuilder("");
		String arraySymbol = "[]";

		String name = "";
		if (immediateParent.getSchemaDataType().equals(SchemaDataType.ARRAY)) {
			name = immediateParent.getName() + arraySymbol + "." + mappedElement.getName();
		} else {
			name = immediateParent.getName() + "." + mappedElement.getName();
		}

		immediateParent = immediateParent.getFieldParent();

		if (immediateParent != null) {
			elementHierarchy.append(name);
			while (immediateParent.getFieldParent() != null) {
				if (immediateParent.getSchemaDataType().equals(SchemaDataType.ARRAY)) {
					name = immediateParent.getName() + arraySymbol;
				} else {
					name = immediateParent.getName();
				}
				elementHierarchy.insert(0, name + ".");
				immediateParent = immediateParent.getFieldParent();
			}
		} else {
			elementHierarchy.append(name);
		}

		if (immediateParent != null) {
			// Append name of the root node.
			elementHierarchy.insert(0, immediateParent.getName() + ".");
		}

		return elementHierarchy.toString();
	}
}

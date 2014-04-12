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

package dataMapper.diagram.custom.persistence;

import java.util.ArrayList;
import java.util.List;

import dataMapper.DataMapperRoot;
import dataMapper.Element;
import dataMapper.SchemaDataType;
import dataMapper.TreeNode;
import dataMapper.diagram.custom.configuration.function.AssignmentStatement;
import dataMapper.diagram.custom.configuration.function.Function;
import dataMapper.diagram.custom.configuration.function.FunctionBody;

public class MappingModelTraverser {

	private static MappingModelTraverser instance;

	private MappingModelTraverser() {
		
	}

	public static MappingModelTraverser getInstance() {
		if (instance == null) {
			instance = new MappingModelTraverser();
		}

		return instance;
	}

	public void traverse(DataMapperRoot rootDiagram,DataMapperConfiguration mappingConfig) {
		 Function mainFunction = createMainFunction(rootDiagram.getInput()
		 .getTreeNode().get(0), rootDiagram.getOutput().getTreeNode()
		 .get(0));
		//
		// if (mainFunction != null) {
		// mappingConfig.getFunctionList().add(mainFunction);
		// traverse(rootDiagram.getInput()
		// .getTreeNode().get(0));
		// }
//		mappingConfig = new DataMapperConfiguration();
//		mappingConfig.setFunctionList(new ArrayList<>());
		 mappingConfig.getFunctionList().add(mainFunction);
		traverse(rootDiagram.getInput().getTreeNode().get(0), mappingConfig, mainFunction);

	}

	/**
	 * @param inputTreeNode 	main input tree
	 * @param outputTreeNode	main output tree
	 * @return
	 */
	private Function createMainFunction(TreeNode inputTreeNode,TreeNode outputTreeNode) {
		Function mainFunction = null;
		if (OperatorConfigurationUtil.isChildrenMaped(inputTreeNode)) {
			mainFunction = new Function();

			mainFunction.setInputParameter(inputTreeNode);
			mainFunction.setOutputParameter(outputTreeNode);
			mainFunction.setSingle(true);

		}

		return mainFunction;
	}

	/**
	 * @param tree 				tree element which would be travers
	 * @param config			full configuration 
	 * @param parentFunction	function which would be the function call statement set
	 */
	private static void traverse(TreeNode tree, DataMapperConfiguration config, Function parentFunction) {
		List<Function> functionListForTree = new ArrayList<Function>();

		
		
		for(Element element : tree.getElement()){
			if(OperatorConfigurationUtil.isMaped(element)){
				Function functionForElement = new Function();
				functionForElement.setInputParameter(tree);
				if(tree.getSchemaDataType().equals(SchemaDataType.ARRAY)){
					//FIXME
				}
				else{
					if(OperatorConfigurationUtil.isSimpleMap(element)){
						String mapAssignmennt = OperatorConfigurationUtil.getSimpleMappingStatement(element);
						AssignmentStatement assign = new AssignmentStatement();
						assign.setStatement(mapAssignmennt);
						
						functionForElement.setOutputParameter(OperatorConfigurationUtil.getSimpleMapOutputElement(element).getFieldParent());
						functionForElement.setSingle(true);
						Function oldFunction = OperatorConfigurationUtil.isFunctionExisit(functionForElement , functionListForTree);
						
						if( oldFunction == null){
							ArrayList<AssignmentStatement> assignmentList = new ArrayList<AssignmentStatement>();
							FunctionBody body = new FunctionBody();
							assignmentList.add(assign);
							body.setAssignmentStatements(assignmentList);
							functionForElement.setFunctionBody(body);
							functionListForTree.add(functionForElement);
						}
						else {
							oldFunction.getFunctionBody().getAssignmentStatements().add(assign);
						}
						
					}
					else {
							//FIXME add operation
					}
				}
			}
		}//for element end
	
		
		if(!functionListForTree.isEmpty()){
			config.getFunctionList().addAll(functionListForTree);
			for (Function function : functionListForTree) {
				function.setParentFunction(parentFunction);
				parentFunction.getFunctionBody().getAssignmentStatements().add(function.getFunctionCall());
			}
		}

		if(tree.getNode() != null){
			for(TreeNode childTree : tree.getNode()){
				if(OperatorConfigurationUtil.isChildrenElementMaped(childTree)){
					if(functionListForTree.size() != 0){
						traverse(childTree , config, functionListForTree.get(0));						
					}
					
				}
				traverse(childTree, config, parentFunction);
			}
		}
		
	}

}

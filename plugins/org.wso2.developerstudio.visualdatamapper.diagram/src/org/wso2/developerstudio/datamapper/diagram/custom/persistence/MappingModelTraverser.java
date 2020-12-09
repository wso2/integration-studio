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

package org.wso2.developerstudio.datamapper.diagram.custom.persistence;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.datamapper.Constant;
import org.wso2.developerstudio.datamapper.DataMapperRoot;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.Operator;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.function.AssignmentStatement;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.function.ForLoop;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.function.Function;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.function.FunctionBody;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.operators.DataMapperTransformerRegistry;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.operators.OperatorsTransformer;


public class MappingModelTraverser {

	private static MappingModelTraverser instance;
	private static List<Integer> operatorsList;

	private MappingModelTraverser() {
		
	}

	public static MappingModelTraverser getInstance() {
		if (instance == null) {
			instance = new MappingModelTraverser();
		}

		return instance;
	}

	/**
	 * public traverser method will build the main config function and functions which describe the mapping 
	 * @param rootDiagram	parent model object of graphical representation
	 * @param mappingConfig configuration model of mapping
	 */
	public void traverse(DataMapperRoot rootDiagram,DataMapperConfiguration mappingConfig) {
		 Function mainFunction = createMainFunction(rootDiagram.getInput()
		 .getTreeNode().get(0), rootDiagram.getOutput().getTreeNode()
		 .get(0));

		 mappingConfig.getFunctionList().add(mainFunction);
		 operatorsList = new ArrayList<Integer>();
		 traverse(rootDiagram.getInput().getTreeNode().get(0), mappingConfig, mainFunction);
		 //traverse 0:1 operators
		 traverse(rootDiagram, mainFunction);
	}


	/**
	 * main function is a special case. 
	 * it needs to handle with more details
	 * @param inputTreeNode 	main input tree
	 * @param outputTreeNode	main output tree
	 * @return	Main function for configuration
	 */
	private Function createMainFunction(TreeNode inputTreeNode,TreeNode outputTreeNode) {
		Function mainFunction = new Function();

			mainFunction.setInputParameter(inputTreeNode);
			mainFunction.setOutputParameter(outputTreeNode);
			mainFunction.setSingle(true);
			mainFunction.setMainFunction(true);

		

		return mainFunction;
	}

	/**
	 * Recursive traverser method, would build function for describe mappings.
	 * 
	 * @param tree 				tree element which would be traverse
	 * @param config			full configuration 
	 * @param parentFunction	function which would be the function call statement execute
	 */
	private static void traverse(TreeNode tree, DataMapperConfiguration config, Function parentFunction) {
		List<Function> functionListForTree = new ArrayList<Function>();
		
		/*if (parentFunction.isMainFunction()) {
			functionListForTree.add(parentFunction);
		}*/

		for(Element element : tree.getElement()){
			if(OperatorConfigurationUtil.isMaped(element)){
				Function functionForElement = new Function();
				functionForElement.setInputParameter(tree);
				if(tree.getSchemaDataType().equals(SchemaDataType.ARRAY)){
					
					if(OperatorConfigurationUtil.isSimpleMap(element)){
						String mapAssignmennt = OperatorConfigurationUtil.getSimpleArrayMappingStatement(element);
						AssignmentStatement assign = new AssignmentStatement();
						assign.setStatement(mapAssignmennt);
						
						functionForElement.setOutputParameter(OperatorConfigurationUtil.getSimpleArrayMapOutputParent(element));
						functionForElement.setSingle(false);
						Function oldFunction = OperatorConfigurationUtil.isFunctionExist(functionForElement , functionListForTree);
						
						if( oldFunction == null){
							ArrayList<AssignmentStatement> assignmentList = new ArrayList<AssignmentStatement>();
							assignmentList.add(assign);
							FunctionBody body = new FunctionBody();
							ForLoop loop = new ForLoop();
							loop.setArrayTree(tree);
							loop.setAssignmentStatements(assignmentList);
							ArrayList<ForLoop> forLoop = new ArrayList<ForLoop>();
							forLoop.add(loop);
							body.setForLoop(forLoop);
							functionForElement.setFunctionBody(body);
							functionListForTree.add(functionForElement);
						}
						else {
							oldFunction.getFunctionBody().getForLoop().get(0).getAssignmentStatements().add(assign);
						}
						
					}
					// array type element map with operators
					else {
						EObject eObjectoperator = OperatorConfigurationUtil.getOperatorClass(element);
						Operator operator = (Operator) eObjectoperator;
						if (operator != null) {
							if(!operatorsList.contains(System.identityHashCode(operator))){
								operatorsList.add(System.identityHashCode(operator));
								OperatorsTransformer transformer = DataMapperTransformerRegistry.getInstance().getTransformer(operator);
								AssignmentStatement assign = transformer.transform(operator); //FIXME wrong assignment get for array. should handle in each operator class
								functionForElement.setOutputParameter(transformer.getOutputElementParent(operator));
								functionForElement.setInputParameter(transformer.getInputElementParent(operator));
								functionForElement.setSingle(false);
								Function oldFunction = OperatorConfigurationUtil.isFunctionExist(functionForElement , functionListForTree);
								
								if( oldFunction == null){
									ArrayList<AssignmentStatement> assignmentList = new ArrayList<AssignmentStatement>();
									FunctionBody body = new FunctionBody();
									assignmentList.add(assign);
									ForLoop loop = new ForLoop();
									loop.setArrayTree(tree);
									loop.setAssignmentStatements(assignmentList);
									ArrayList<ForLoop> forLoop = new ArrayList<ForLoop>();
									forLoop.add(loop);
									body.setForLoop(forLoop);

									functionForElement.setFunctionBody(body);
									functionListForTree.add(functionForElement);
								}
								else {
									oldFunction.getFunctionBody().getForLoop().get(0).getAssignmentStatements().add(assign);
								}
							}
						}	
					}
				}
				//Record type mapping
				else{
					//record type one to one mapping
					if(OperatorConfigurationUtil.isSimpleMap(element)){
						String mapAssignmennt = OperatorConfigurationUtil.getSimpleMappingStatement(element);
						AssignmentStatement assign = new AssignmentStatement();
						assign.setStatement(mapAssignmennt);
						
						functionForElement.setOutputParameter(OperatorConfigurationUtil.getSimpleMapOutputElement(element).getFieldParent());
						functionForElement.setSingle(true);
						Function oldFunction = OperatorConfigurationUtil.isFunctionExist(functionForElement , functionListForTree);
						
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
					//record type with operator mapping
					else {
						EObject eObjectoperator = OperatorConfigurationUtil.getOperatorClass(element);
						Operator operator = (Operator) eObjectoperator;
						if(!operatorsList.contains(System.identityHashCode(operator))){
							operatorsList.add(System.identityHashCode(operator));
							
							OperatorsTransformer transformer = DataMapperTransformerRegistry.getInstance().getTransformer(operator);
							AssignmentStatement assign = transformer.transform(operator);
							functionForElement.setOutputParameter(transformer.getOutputElementParent(operator));
							functionForElement.setInputParameter(transformer.getInputElementParent(operator));
							functionForElement.setSingle(true);
							Function oldFunction = OperatorConfigurationUtil.isFunctionExist(functionForElement , functionListForTree);
							
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
					}
				}
			}
		}//for element end
	
		//all functions for the current tree node should copy to DataMapperConfiguration
		if(!functionListForTree.isEmpty()){
			config.getFunctionList().addAll(functionListForTree);
			for (Function function : functionListForTree) {
				function.setParentFunction(parentFunction);
				//set function call statement for appropriate parent function
					TreeNode parentFunctionInTree = parentFunction.getInputParameter();
					
					/*
					 * when the parent function is array and array child being a call statement,
					 * the arguments of method call statements should be with indexed
					 */
					if(parentFunctionInTree.getSchemaDataType().equals(SchemaDataType.ARRAY)){
						ForLoop callStatmentLoop ;
						
						//if there are for loops exist already set function call statement to it
						if(OperatorConfigurationUtil.isForLoopCreated(parentFunction.getFunctionBody().getForLoop(), parentFunctionInTree) != null){
							callStatmentLoop = OperatorConfigurationUtil.isForLoopCreated(parentFunction.getFunctionBody().getForLoop(), parentFunctionInTree);
							callStatmentLoop.getFunctionCall().add(function.getFunctionCall(parentFunction));
						}
						else {
							callStatmentLoop = new ForLoop();
							callStatmentLoop.setArrayTree(parentFunctionInTree);
							callStatmentLoop.getFunctionCall().add(function.getFunctionCall(parentFunction));
							parentFunction.getFunctionBody().getForLoop().add(callStatmentLoop);
						}
					}
					else{						
						parentFunction.getFunctionBody().getFunctionCallStatements().add(function.getFunctionCall());
					}
				
			}
		}

		//iterate in child trees
		if(tree.getNode() != null){
			for(TreeNode childTree : tree.getNode()){
				if(OperatorConfigurationUtil.isChildrenElementMaped(childTree)){
					if(functionListForTree.size() != 0){
						traverse(childTree , config, functionListForTree.get(0));						
					}
					else {
						traverse(childTree, config, parentFunction);
					}
				}
				else{
					traverse(childTree, config, parentFunction);
				}
			}
		}
		
	}

	/**
	 * directly connected operators to output schema tree may not serialized due to they are out of traversing path of input schema.
	 * overloaded traverse method will filter the untraversed operators an build here config
	 * @param rootDiagram	root mapping object model 
	 * @param mainFunction  main function for the map config
	 */
	private void traverse(DataMapperRoot rootDiagram, Function mainFunction) {
		for(Operator operator : rootDiagram.getOperators()){
			if(operator instanceof Constant && !operatorsList.contains(System.identityHashCode(operator))){
				OperatorsTransformer transformer = DataMapperTransformerRegistry.getInstance().getTransformer(operator);
				AssignmentStatement assign = transformer.transform(operator);
				mainFunction.getFunctionBody().getAssignmentStatements().add(assign);
			}
		}
	}

}

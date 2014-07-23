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

import org.wso2.developerstudio.datamapper.Constant;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.Operator;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.function.AssignmentStatement;

public class ConstantTransformer implements OperatorsTransformer {

	private static final String INDEX = "[i]";
	
	@Override
	public AssignmentStatement transform(Operator operator) {
		StringBuilder assign = new StringBuilder();
		Constant constant = (Constant) operator;
		assign.append(getTreeHierarchy(getOutputElementParent(operator), getOutputRoot(operator))).append(".").append(getOutpuElement(operator).getName()).append(" = \"").append(constant.getConstantValue()).append("\";\n");                                           
		AssignmentStatement statment = new AssignmentStatement();
		statment.setStatement(assign.toString());
		return statment;
	}

	@Override
	public TreeNode getOutputElementParent(Operator operator) {
		if(getOutpuElement(operator) != null){
			return getOutpuElement(operator).getFieldParent();
		}
		
		return null;
	}
	
	private Element getOutpuElement(Operator operator) {
		if(operator.getBasicContainer().getRightContainer().getRightConnectors().size() !=0){
			return operator.getBasicContainer().getRightContainer().getRightConnectors().get(0).getOutNode().getOutgoingLink().get(0).getInNode().getElementParent();
		}
		return null;
	}

	@Override
	public TreeNode getInputElementParent(Operator operator) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String getTreeHierarchy(TreeNode tree, TreeNode parent) {
		StringBuilder hierarchy = new StringBuilder();

		while (!(tree.equals(parent))) {
			if(tree.getSchemaDataType().equals(SchemaDataType.ARRAY)){
				hierarchy.insert(0, (tree.getName()+INDEX));
			}else{
				
				hierarchy.insert(0, tree.getName());
			}
			hierarchy.insert(0, ".");
			tree = tree.getFieldParent();
		}
		
		if(tree.getSchemaDataType().equals(SchemaDataType.ARRAY)){
			hierarchy.insert(0, (tree.getName()+INDEX));
		}
		else {
			hierarchy.insert(0, tree.getName());
		}

		return hierarchy.toString();

	}
	
	
	private TreeNode getOutputRoot(Operator operator){
		TreeNode tree = getOutputElementParent(operator);
		while(tree.getFieldParent() != null){
			tree = tree.getFieldParent();
		}
		
		return tree;
	}



	@Override
	public String trasnform(String statement, Operator operator, Operator nextOperator) {
		// TODO Auto-generated method stub
		return null;
	}

}

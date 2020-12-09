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

import org.apache.commons.lang.WordUtils;
import org.eclipse.emf.common.util.EList;
import org.wso2.developerstudio.datamapper.Concat;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.Operator;
import org.wso2.developerstudio.datamapper.OperatorLeftConnector;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.function.AssignmentStatement;

public class ConcatTransformer extends ManyToOneTransformer{

	private static final String INDEX = "[i]";
	
	@Override
	public AssignmentStatement transform(Operator operator) {
		Concat concat = (Concat) operator;
		ArrayList<Element> concatInput = getInputElements(operator);
		String index = "";
		if(concatInput.get(0).getFieldParent().getSchemaDataType().equals(SchemaDataType.ARRAY)){
			index = INDEX;
		}
		TreeNode inputRootForMap = getInputElementParent(operator);
		AssignmentStatement assign = new AssignmentStatement();
		
		String outputParentName = getOutputElementParent(operator).getName();
		String inputParentName = inputRootForMap.getName();
		
		/*
		 * If input parameter and output parameter names are identical,
		 * append term 'output' to the output parameter as a convention.
		 */
		if (outputParentName.equals(inputParentName)) {
			outputParentName = "output" + WordUtils.capitalize(outputParentName);
		}
		
		StringBuilder statement = new StringBuilder(outputParentName + index + "." + getOutputElement(operator).getName() + "=");
		statement.append(getTreeHierarchy(concatInput.get(0).getFieldParent(), inputRootForMap)+ "." + concatInput.get(0).getName());
		concatInput.remove(0);
		
		for(Element element : concatInput){
			if(concat.getDelimiter() != null && !concat.getDelimiter().equalsIgnoreCase("")){
				statement.append(".concat("+"\""+concat.getDelimiter()+"\"+"+getTreeHierarchy(element.getFieldParent(), inputRootForMap)+"."+element.getName()+")");
			}else{				
				statement.append(".concat("+getTreeHierarchy(element.getFieldParent(), inputRootForMap)+"."+element.getName()+")");
			}
		}
		statement.append(";");
		assign.setStatement(statement.toString());
		return assign;
	}
	
	/**
	 * to complete assignment statement output element needs to be find
	 * @param operator concat operator object
	 * @return out put element of output tree which have mapped 
	 */
	private Element getOutputElement( Operator operator) {
		return operator.getBasicContainer().getRightContainer().getRightConnectors().get(0).getOutNode().getOutgoingLink().get(0).getInNode().getElementParent();
	}
	
	@Override
	public TreeNode getOutputElementParent(Operator operator) {
		return getOutputElement(operator).getFieldParent();
	}
	
	@Override
	public TreeNode getInputElementParent(Operator operator){
		ArrayList<Element> inputElements = getInputElements(operator);
		TreeNode highestParent = null;
		for (Element element : inputElements){
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
		
		if(getOutputElement(operator).getFieldParent().getSchemaDataType().equals(SchemaDataType.ARRAY) && !(highestParent.getSchemaDataType().equals(SchemaDataType.ARRAY))){
			while(highestParent.getFieldParent() != null && !(highestParent.getSchemaDataType().equals(SchemaDataType.ARRAY))){
				highestParent = highestParent.getFieldParent();
			}
		}
		
		return highestParent;
		
	}
	
	/**
	 * list of input elements needs to create assignment statements 
	 * @param operator concat operator object
	 * @return input elements of input tree which have mapped to concat 
	 */
	private ArrayList<Element> getInputElements(Operator operator) {
		EList<OperatorLeftConnector> leftConnectors = operator.getBasicContainer().getLeftContainer().getLeftConnectors();
		ArrayList<Element> elementList = new ArrayList<Element>();
		for(OperatorLeftConnector connector : leftConnectors){
			if(connector.getInNode().getIncomingLink().size() != 0){
				elementList.add(connector.getInNode().getIncomingLink().get(0).getOutNode().getElementParent());
			}
		}
		return elementList;
	}
	
	
	private String getTreeHierarchy(TreeNode tree, TreeNode parent) {
		StringBuilder hierarchy = new StringBuilder();

		while (!(tree.equals(parent))) {
			hierarchy.insert(0, tree.getName());
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



}

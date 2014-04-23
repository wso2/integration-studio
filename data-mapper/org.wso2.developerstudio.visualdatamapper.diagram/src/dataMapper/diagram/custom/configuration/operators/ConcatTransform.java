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

package dataMapper.diagram.custom.configuration.operators;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;

import dataMapper.Concat;
import dataMapper.Element;
import dataMapper.Operator;
import dataMapper.OperatorLeftConnector;
import dataMapper.SchemaDataType;
import dataMapper.TreeNode;
import dataMapper.diagram.custom.configuration.function.AssignmentStatement;

public class ConcatTransform implements OperatorsTransformer{

	private static final String INDEX = "[i]";
	
	@Override
	public AssignmentStatement transform(Operator operator) {
		ArrayList<Element> concatInput = getInputElements(operator);
		String index = "";
		if(concatInput.get(0).getFieldParent().getSchemaDataType().equals(SchemaDataType.ARRAY)){
			index = INDEX;
		}
		
		AssignmentStatement assign = new AssignmentStatement();
		StringBuilder statement = new StringBuilder(getOutputElementParent(operator).getName()+index+"."+getOutputElement(operator).getName()+"=");
		statement.append(concatInput.get(0).getFieldParent().getName()+index+"."+concatInput.get(0).getName());
		concatInput.remove(0);
		Concat concat = (Concat) operator;
		
		for(Element element : concatInput){
			if(concat.getDelimiter() != null && concat.getDelimiter().equalsIgnoreCase("")){
				statement.append(".concat("+"\""+concat.getDelimiter()+"\"+"+element.getFieldParent().getName()+index+"."+element.getName()+")");
			}else{				
				statement.append(".concat("+element.getFieldParent().getName()+index+"."+element.getName()+")");
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
	
	/**
	 * list of input elements needs to create assignment statements 
	 * @param operator concat operator object
	 * @return input elements of input tree which have mapped to concat 
	 */
	private ArrayList<Element> getInputElements(Operator operator) {
		EList<OperatorLeftConnector> leftConnectors = operator.getBasicContainer().getLeftContainer().getLeftConnectors();
		ArrayList<Element> elementList = new ArrayList<Element>();
		for(OperatorLeftConnector connector : leftConnectors){
			elementList.add(connector.getInNode().getIncomingLink().get(0).getOutNode().getElementParent());
		}
		return elementList;
	}


}

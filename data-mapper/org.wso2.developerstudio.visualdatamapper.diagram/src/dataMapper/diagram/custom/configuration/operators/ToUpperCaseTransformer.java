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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import dataMapper.Element;
import dataMapper.Operator;
import dataMapper.OperatorLeftConnector;
import dataMapper.OperatorRightConnector;
import dataMapper.SchemaDataType;
import dataMapper.TreeNode;
import dataMapper.diagram.custom.configuration.function.AssignmentStatement;

public class ToUpperCaseTransformer implements OperatorsTransformer{

	private static final String INDEX = "[i]"; 
	@Override
	public AssignmentStatement transform(Operator operator) {
	EObject upperCaseInput = getInputObject(operator);
		
		
		if(upperCaseInput instanceof Element){
			Element inputElement = (Element) upperCaseInput;
			if(inputElement.getFieldParent().getSchemaDataType().equals(SchemaDataType.ARRAY)){
				String index = INDEX;
				return getSimpleOperatorMapping(operator, inputElement, index);
			}
			
			return getSimpleOperatorMapping(operator, inputElement);
			
		}
		else if(upperCaseInput instanceof OperatorRightConnector){
			//FIXME implementation of operator chaining 
		}
		

		return null;
	}
	
	private Element getOutputElement( Operator operator) {
		return operator.getBasicContainer().getRightContainer().getRightConnectors().get(0).getOutNode().getOutgoingLink().get(0).getInNode().getElementParent();
	}
	@Override
	public TreeNode getOutputElementParent(Operator operator) {
		return getOutputElement(operator).getFieldParent();
	}
	
	private EObject getInputObject(Operator operator) {
		EList<OperatorLeftConnector> leftConnectors = operator.getBasicContainer().getLeftContainer().getLeftConnectors();
		EObject inputObject = leftConnectors.get(0).getInNode().getIncomingLink().get(0).getOutNode().eContainer();
		return inputObject;
	}
	
	private Operator getInputOperator(EObject in){
		return (Operator)in.eContainer().eContainer().eContainer();
	}
	
	private AssignmentStatement getSimpleOperatorMapping(Operator operator, Element inputElement, String index){
		String assign = getOutputElementParent(operator).getName()+index+"."+getOutputElement(operator).getName()+" = "+inputElement.getFieldParent().getName()+index+"."+inputElement.getName()+".toUpperCase();";
		AssignmentStatement statement = new AssignmentStatement();
		statement.setStatement(assign);
		return statement;
	}
	
	private AssignmentStatement getSimpleOperatorMapping(Operator operator, Element inputElement){
		String assign = getOutputElementParent(operator).getName()+"."+getOutputElement(operator).getName()+" = "+inputElement.getFieldParent().getName()+"."+inputElement.getName()+".toUpperCase();";
		AssignmentStatement statement = new AssignmentStatement();
		statement.setStatement(assign);
		return statement;
	}

}

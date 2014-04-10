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

import dataMapper.Element;
import dataMapper.Operator;
import dataMapper.OperatorLeftConnector;
import dataMapper.TreeNode;
import dataMapper.diagram.custom.configuration.function.AssignmentStatement;

public class ConcatTransform implements OperatorsTransformer{

	@Override
	public AssignmentStatement transform(Operator operator) {
		AssignmentStatement assign = new AssignmentStatement();
		StringBuilder statement = new StringBuilder(getElementParent(operator).getName()+"."+getOutputElement(operator).getName()+"=");
		ArrayList<Element> concatInput = getInputElements(operator);
		statement.append(concatInput.get(0).getFieldParent().getName()+"."+concatInput.get(0).getName());
		concatInput.remove(0);
		for(Element element : concatInput){
			statement.append(".concat("+element.getFieldParent().getName()+"."+element.getName()+")");
		}
		statement.append(";");
//		String action = getOutputElement(operator).getName()+"."+getOutputElement(operator).getName()+"="+operator.get
		assign.setStatement(statement.toString());;
		return assign;
	}
	
	private Element getOutputElement( Operator operator) {
		return operator.getBasicContainer().getRightContainer().getRightConnectors().get(0).getOutNode().getOutgoingLink().get(0).getInNode().getElementParent();
	}
	
	private TreeNode getElementParent(Operator operator) {
		return getOutputElement(operator).getFieldParent();
	}
	
	private ArrayList<Element> getInputElements(Operator operator) {
		EList<OperatorLeftConnector> leftConnectors = operator.getBasicContainer().getLeftContainer().getLeftConnectors();
		ArrayList<Element> elementList = new ArrayList<Element>();
		for(OperatorLeftConnector connector : leftConnectors){
			elementList.add(connector.getInNode().getIncomingLink().get(0).getOutNode().getElementParent());
		}
		return elementList;
	}

}

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

public class ToLowerCaseTransformer extends OneToOneTransformer {

	private final String OPERATOR_FUNCTION = ".toLowerCase()";

	@Override
	public AssignmentStatement transform(Operator operator) {
		EObject operatorInput = getInputObject(operator);
		EObject operatorOutput = getOutputObject(operator);

		if (operatorInput instanceof Element && operatorOutput instanceof Element) {
			Element inputElement = (Element) operatorInput;
			return getSimpleOperatorMapping(operator, inputElement);

		} else if (operatorInput instanceof OperatorRightConnector && operatorOutput instanceof Element) {
			// FIXME implementation of operator chaining
		}

		else if (operatorInput instanceof Element && operatorOutput instanceof OperatorLeftConnector) {
			Operator nextOperator = (Operator)getOperator(operatorOutput);
			//create ___ = me ____ and pass
			String subAssign = createSubAssignment((Element)operatorInput);
			
			OperatorsTransformer transformer = DataMapperTransformerRegistry.getInstance().getTransformer(nextOperator);
			String assign = transformer.trasnform(subAssign, operator, nextOperator);
			AssignmentStatement statement = new AssignmentStatement();
			statement.setStatement(assign);
			
			return statement;

			
		} else {
			// if operator middle of operators
		}

		return null;
	}

	
	private String createSubAssignment(Element operatorInput) {
		String assign = " = " + operatorInput.getFieldParent().getName()+"."+operatorInput.getName()+getOperatorFunction();
		return assign;
	}
	
	private AssignmentStatement getSimpleOperatorMapping(Operator operator, Element inputElement, String index) {
		String assign = getOutputElementParent(operator).getName() + index + "." + getOutputElement(operator).getName() + " = " + inputElement.getFieldParent().getName() + index + "." + inputElement.getName() + ".toLowerCase();";
		AssignmentStatement statement = new AssignmentStatement();
		statement.setStatement(assign);
		return statement;
	}

	private AssignmentStatement getSimpleOperatorMapping(Operator operator, Element inputElement) {
		Element outputElement = getOutputElement(operator);
		TreeNode outputParent = getOutputElementParent(operator);

		String index = "";
		if (inputElement.getFieldParent().getSchemaDataType().equals(SchemaDataType.ARRAY))
			index = getIndex();
		String assign = getTreeHierarchy(outputElement.getFieldParent(), outputParent) + "." + outputElement.getName() + " = " + inputElement.getFieldParent().getName() + index + "." + inputElement.getName() + ".toLowerCase();";

		AssignmentStatement statement = new AssignmentStatement();
		statement.setStatement(assign);
		return statement;
	}

	@Override
	public String trasnform(String subStatement, Operator previousOperator, Operator operator) {
		EObject operatorOutput = getOutputObject(operator);

		StringBuilder builder = new StringBuilder();
		builder.append(subStatement);
		if (operatorOutput instanceof Element) {
			//fill the blank
			Element outputElement = (Element)operatorOutput;
			builder.insert(0,outputElement.getFieldParent().getName()+"."+outputElement.getName());
			builder.append(getOperatorFunction()).append(";");
			return builder.toString();
		}
		return null;
	}

	public String getOperatorFunction() {
		return OPERATOR_FUNCTION;
	}


}

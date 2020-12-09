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

import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.Operator;
import org.wso2.developerstudio.datamapper.OperatorLeftConnector;
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

		}
		else if (operatorInput instanceof Element && operatorOutput instanceof OperatorLeftConnector) {
			Operator nextOperator = (Operator) getOperator(operatorOutput);
			// create ___ = me ____ and pass
			String subAssign = createSubAssignment((Element) operatorInput);

			OperatorsTransformer transformer = DataMapperTransformerRegistry.getInstance().getTransformer(nextOperator);
			String assign = transformer.trasnform(subAssign, operator, nextOperator);
			AssignmentStatement statement = new AssignmentStatement();
			statement.setStatement(assign);

			return statement;

		}

		return null;
	}

	/**
	 * config generation in operator chaining is partial. This method provide partial config for complete ful assignment.
	 * @param operatorInput element map from input schema tree
	 * @return partial of config
	 */
	private String createSubAssignment(Element operatorInput) {
		StringBuilder builder = new StringBuilder();
		builder.append(" = ").append(operatorInput.getFieldParent().getName()).append(".").append(operatorInput.getName()).append(getOperatorFunction());
		return builder.toString();
	}

	/**
	 * config generation for 'element -- operator -- element' mapping scenario stright forwerd and this method provide assignment for this operator
	 * @param operator		this operator
	 * @param inputElement  element map from input schema tree
	 * @return	assignment statement for map
	 */
	private AssignmentStatement getSimpleOperatorMapping(Operator operator, Element inputElement) {
		Element outputElement = getOutputElement(operator);
		TreeNode outputParent = getOutputElementParent(operator);

		String index = "";
		if (inputElement.getFieldParent().getSchemaDataType().equals(SchemaDataType.ARRAY)){
			index = getIndex();
		}

		StringBuilder builder = new StringBuilder();
		builder.append(getTreeHierarchy(outputElement.getFieldParent(), outputParent)).append(".").append(outputElement.getName()).append(" = ").append(inputElement.getFieldParent().getName()).append(index).append(".").append(inputElement.getName()).append(getOperatorFunction()).append(";");

		AssignmentStatement statement = new AssignmentStatement();
		statement.setStatement(builder.toString());
		return statement;
	}

	@Override
	public String trasnform(String subStatement, Operator previousOperator, Operator operator) {
		EObject operatorOutput = getOutputObject(operator);

		StringBuilder builder = new StringBuilder();
		builder.append(subStatement);
		if (operatorOutput instanceof Element) {
			Element outputElement = (Element) operatorOutput;
			builder.insert(0, outputElement.getFieldParent().getName() + "." + outputElement.getName());
			builder.append(getOperatorFunction()).append(";");
			return builder.toString();
		} else if (operatorOutput instanceof OperatorLeftConnector) {
			Operator nextOperator = (Operator) getOperator(operatorOutput);
			builder.append(getOperatorFunction());

			OperatorsTransformer transformer = DataMapperTransformerRegistry.getInstance().getTransformer(nextOperator);
			String assign = transformer.trasnform(builder.toString(), operator, nextOperator);

			return assign;

		}
		return null;
	}

	public String getOperatorFunction() {
		return OPERATOR_FUNCTION;
	}

}

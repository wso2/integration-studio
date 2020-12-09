/*
 * Copyright 2016 WSO2, Inc. (http://wso2.com)
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
package org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator;

import org.wso2.integrationstudio.datamapper.DataMapperOperatorType;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.AbsoluteValueOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.AddOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.AdvancedCustomFunctionOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.CeilOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.CompareOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.ConcatOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.ConstantOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.CustomFunctionOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.DMOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.DirectOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.DivideOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.EndsWithOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.FloorOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.GetOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.GlobalVariableOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.IfElseOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.InstantiateOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.MatchOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.MaxOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.MinOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.MultiplyOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.RoundOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.SetPrecisionOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.SplitOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.StartsWithOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.StringLengthOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.StringToBlooeanOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.StringToNumberOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.SubstringOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.SubtractOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.ToLowerCaseOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.ToStringOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.ToUpperCaseOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.TrimOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.ANDOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.OROperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.PropertiesOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.ReplaceOperatorTransformer;
import org.wso2.integrationstudio.datamapper.diagram.custom.configuration.operator.transformers.NOTOperatorTransformer;

/**
 * This class act as a factory to provide corresponding DMOperatorTransformer
 *
 */
public class DMOperatorTransformerFactory {

	/**
	 * This private constructor added to hide the implicit public constructor
	 */
	private DMOperatorTransformerFactory() {

	}

	/**
	 * This method provide the corresponding {@link DMOperatorTransformer} for the given {@link DMOperatorType}
	 * 
	 * @param type
	 *            of the operator
	 * @return the corresponding {@link DMOperatorTransformer}
	 */
	public static DMOperatorTransformer getDMOperatorTransformer(DataMapperOperatorType type) {

		switch (type.getOperatorCategory()) {
		case ARITHMATIC_OPERATION:
			return getArithmaticOperatorTransformer(type);
		case STRING_OPERATION:
			return getStringOperatorTransformer(type);
		case COMMON_OPERATION:
			return getCommonOperatorTransformer(type);
		case BOOLEAN_OPERATION:
			return getBooleanOperatorTransformer(type);
		case CONDITIONAL_OPERATION:
			return getConditionalOperatorTransformer(type);
		case TYPE_CONVERSION_OPERATION:
			return getTypeConversionOperatorTransformer(type);
		default:
			throw new IllegalArgumentException(
					"Unknown operator category found for tranform in DMOperatorTransformerFactory : " + type);
		}
	}

	private static DMOperatorTransformer getTypeConversionOperatorTransformer(DataMapperOperatorType type) {
		switch (type) {
		case STRING_TO_BOOLEAN:
			return new StringToBlooeanOperatorTransformer();
		case STRING_TO_NUMBER:
			return new StringToNumberOperatorTransformer();
		case TO_STRING:
			return new ToStringOperatorTransformer();
		default:
			throw new IllegalArgumentException(
					"Unknown Type Convertion operator type found for tranform in DMOperatorTransformerFactory : " + type);
		}
	}

	private static DMOperatorTransformer getConditionalOperatorTransformer(DataMapperOperatorType type) {
		switch (type) {
		case IF_ELSE:
			return new IfElseOperatorTransformer();
		default:
			throw new IllegalArgumentException(
					"Unknown Conditional operator type found for tranform in DMOperatorTransformerFactory : " + type);
		}
	}

	private static DMOperatorTransformer getBooleanOperatorTransformer(DataMapperOperatorType type) {
		switch (type) {
		case AND:
			return new ANDOperatorTransformer();
		case OR:
			return new OROperatorTransformer();
		case NOT:
			return new NOTOperatorTransformer();
		default:
			throw new IllegalArgumentException(
					"Unknown Boolean operator type found for tranform in DMOperatorTransformerFactory : " + type);
		}
	}

	private static DMOperatorTransformer getCommonOperatorTransformer(DataMapperOperatorType type) {
		switch (type) {
		case DIRECT:
			return new DirectOperatorTransformer();
		case INSTANTIATE:
			return new InstantiateOperatorTransformer();
		case CONSTANT:
			return new ConstantOperatorTransformer();
		case COMPARE:
			return new CompareOperatorTransformer();
		case CUSTOM_FUNCTION:
			return new CustomFunctionOperatorTransformer();
		case PROPERTIES:
			return new PropertiesOperatorTransformer();
		case GET:
			return new GetOperatorTransformer();
		case GLOBAL_VARIABLE:
			return new GlobalVariableOperatorTransformer();
		case ADVANCED_CUSTOM_FUNCTION:
			return new AdvancedCustomFunctionOperatorTransformer();
		default:
			throw new IllegalArgumentException(
					"Unknown Common operator type found for tranform in DMOperatorTransformerFactory : " + type);
		}
	}

	private static DMOperatorTransformer getStringOperatorTransformer(DataMapperOperatorType type) {
		switch (type) {
		case CONCAT:
			return new ConcatOperatorTransformer();
		case UPPERCASE:
			return new ToUpperCaseOperatorTransformer();
		case LOWERCASE:
			return new ToLowerCaseOperatorTransformer();
		case SPLIT:
			return new SplitOperatorTransformer();
		case STARTS_WITH:
			return new StartsWithOperatorTransformer();
		case STRING_LENGTH:
			return new StringLengthOperatorTransformer();
		case SUBSTRING:
			return new SubstringOperatorTransformer();
		case ENDS_WITH:
			return new EndsWithOperatorTransformer();
		case TRIM:
			return new TrimOperatorTransformer();
		case REPLACE:
			return new ReplaceOperatorTransformer();
		case MATCH:
			return new MatchOperatorTransformer();
		default:
			throw new IllegalArgumentException(
					"Unknown String operator type found for tranform in DMOperatorTransformerFactory : " + type);
		}
	}

	private static DMOperatorTransformer getArithmaticOperatorTransformer(DataMapperOperatorType type) {
		switch (type) {
		case ADD:
			return new AddOperatorTransformer();
		case SUBTRACT:
			return new SubtractOperatorTransformer();
		case MULTIPLY:
			return new MultiplyOperatorTransformer();
		case DIVIDE:
			return new DivideOperatorTransformer();
		case ABSOLUTE:
			return new AbsoluteValueOperatorTransformer();
		case ROUND:
			return new RoundOperatorTransformer();
		case SET_PRECISION:
			return new SetPrecisionOperatorTransformer();
		case CEILING:
			return new CeilOperatorTransformer();
		case FLOOR:
			return new FloorOperatorTransformer();
		case MAX:
			return new MaxOperatorTransformer();
		case MIN:
			return new MinOperatorTransformer();
		default:
			throw new IllegalArgumentException(
					"Unknown Arithmatic operator type found for tranform in DMOperatorTransformerFactory : " + type);
		}
	}
}

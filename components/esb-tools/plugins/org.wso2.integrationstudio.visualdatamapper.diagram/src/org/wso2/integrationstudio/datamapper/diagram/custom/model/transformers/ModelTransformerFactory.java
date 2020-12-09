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
package org.wso2.integrationstudio.datamapper.diagram.custom.model.transformers;

import org.wso2.integrationstudio.datamapper.DataMapperOperatorType;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.IModelTransformer;

public class ModelTransformerFactory {

	public static IModelTransformer getModelTransformer(DataMapperOperatorType type) {
		switch (type.getOperatorCategory()) {
		case ARITHMATIC_OPERATION:
			return getArithmaticOperatorModelTransformer(type);
		case STRING_OPERATION:
			return getStringOperatorModelTransformer(type);
		case COMMON_OPERATION:
			return getCommonOperatorModelTransformer(type);
		case BOOLEAN_OPERATION:
			return getBooleanOperatorModelTransformer(type);
		case CONDITIONAL_OPERATION:
			return getConditionalOperatorModelTransformer(type);
		case TYPE_CONVERSION_OPERATION:
			return getTypeConvertionOperatorModelTransformer(type);
		default:
			throw new IllegalArgumentException(
					"Unknown operator category found for tranform in ModelTransformerFactory : " + type);
		}
	}

	private static IModelTransformer getTypeConvertionOperatorModelTransformer(DataMapperOperatorType type) {
		switch (type) {
		case STRING_TO_BOOLEAN:
			return new StringToBooleanModelTransformer();
		case STRING_TO_NUMBER:
			return new StringToNumberModelTransformer();
		case TO_STRING:
			return new ToStringModelTransformer();
		default:
			throw new IllegalArgumentException(
					"Unable to find type convertion operator model transformer to operator type in ModelTransformerFactory: "
							+ type);
		}
	}

	private static IModelTransformer getConditionalOperatorModelTransformer(DataMapperOperatorType type) {
		switch (type) {
		case IF_ELSE:
			return new IfElseModelTransformer();
		default:
			throw new IllegalArgumentException(
					"Unable to find conditionl operator model transformer to operator type in ModelTransformerFactory: "
							+ type);
		}
	}

	private static IModelTransformer getBooleanOperatorModelTransformer(DataMapperOperatorType type) {
		switch (type) {
		case AND:
			return new ANDModelTransformer();
		case NOT:
			return new NOTModelTransformer();
		case OR:
			return new ORModelTransformer();
		default:
			throw new IllegalArgumentException(
					"Unable to find boolean operator model transformer to operator type in ModelTransformerFactory: "
							+ type);
		}
	}

	private static IModelTransformer getCommonOperatorModelTransformer(DataMapperOperatorType type) {
		switch (type) {
		case CONSTANT:
			return new ConstantModelTransformer();
		case COMPARE:
			return new CompareModelTransformer();
		case CUSTOM_FUNCTION:
			return new CustomOperatorModelTransformer();
		case PROPERTIES:
			return new PropertiesModelTransformer();
		case GLOBAL_VARIABLE:
			return new GlobalVariableModelTransformer();
		default:
			throw new IllegalArgumentException(
					"Unable to find common operator model transformer to operator type in ModelTransformerFactory: "
							+ type);
		}
	}

	private static IModelTransformer getStringOperatorModelTransformer(DataMapperOperatorType type) {
		switch (type) {
		case CONCAT:
			return new ConcatModelTransformer();
		case SPLIT:
			return new SplitModelTransformer();
		case UPPERCASE:
			return new ToUpperCaseModelTransformer();
		case LOWERCASE:
			return new ToLowerCaseModelTransformer();
		case STRING_LENGTH:
			return new StringLengthModelTransformer();
		case SUBSTRING:
			return new SubstringModelTransformer();
		case STARTS_WITH:
			return new StartsWithModelTransformer();
		case ENDS_WITH:
			return new EndsWithModelTransformer();
		case TRIM:
			return new TrimModelTransformer();
		case REPLACE:
			return new ReplaceModelTransformer();
		case MATCH:
			return new MatchModelTransformer();
		default:
			throw new IllegalArgumentException(
					"Unable to find string operator model transformer to operator type in ModelTransformerFactory: "
							+ type);
		}
	}

	private static IModelTransformer getArithmaticOperatorModelTransformer(DataMapperOperatorType type) {
		switch (type) {
		case ADD:
			return new AddModelTransformer();
		case SUBTRACT:
			return new SubtractModelTransformer();
		case MULTIPLY:
			return new MultiplyModelTransformer();
		case DIVIDE:
			return new DivideModelTransformer();
		case ABSOLUTE:
			return new AbsoluteModelTransformer();
		case FLOOR:
			return new FloorModelTransformer();
		case CEILING:
			return new CeilingModelTransformer();
		case SET_PRECISION:
			return new SetPrecisionModelTransformer();
		case ROUND:
			return new RoundModelTransformer();
		case MIN:
			return new MinModelTransformer();
		case MAX:
			return new MaxModelTransformer();
		default:
			throw new IllegalArgumentException(
					"Unable to find arithmatic model transformer to operator type in ModelTransformerFactory: " + type);
		}
	}
}

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
package org.wso2.developerstudio.datamapper.diagram.custom.model.transformers;

import org.wso2.developerstudio.datamapper.DataMapperOperatorType;
import org.wso2.developerstudio.datamapper.diagram.custom.model.IModelTransformer;

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
		default:
			throw new IllegalArgumentException(
					"Unknown operator category found for tranform in ModelTransformerFactory : " + type);
		}
	}

	private static IModelTransformer getConditionalOperatorModelTransformer(DataMapperOperatorType type) {
		switch (type) {
		default:
			throw new IllegalArgumentException(
					"Unable to find conditionl operator model transformer to operator type in ModelTransformerFactory: "
							+ type);
		}
	}

	private static IModelTransformer getBooleanOperatorModelTransformer(DataMapperOperatorType type) {
		switch (type) {
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
		default:
			throw new IllegalArgumentException(
					"Unable to find string operator model transformer to operator type in ModelTransformerFactory: "
							+ type);
		}
	}

	private static IModelTransformer getArithmaticOperatorModelTransformer(DataMapperOperatorType type) {
		switch (type) {
		default:
			throw new IllegalArgumentException(
					"Unable to find arithmatic model transformer to operator type in ModelTransformerFactory: " + type);
		}
	}
}

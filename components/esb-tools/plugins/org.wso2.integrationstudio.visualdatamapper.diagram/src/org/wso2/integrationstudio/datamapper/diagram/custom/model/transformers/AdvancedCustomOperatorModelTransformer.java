/*
 * Copyright 2020 WSO2, Inc. (http://wso2.com)
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
import org.wso2.integrationstudio.datamapper.diagram.custom.model.DMOperation;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.IModelTransformer;
import org.wso2.integrationstudio.datamapper.impl.AdvancedCustomFunctionImpl;
import org.wso2.integrationstudio.datamapper.impl.OperatorImpl;

public class AdvancedCustomOperatorModelTransformer implements IModelTransformer {

    @Override
    public DMOperation transform(OperatorImpl operator, int index) {
        if (operator instanceof AdvancedCustomFunctionImpl) {
            AdvancedCustomFunctionImpl customOperator = (AdvancedCustomFunctionImpl) operator;
            DMOperation customFunctionOperatorModel = new DMOperation(DataMapperOperatorType.ADVANCED_CUSTOM_FUNCTION,
                    operator.toString(), index);
            customFunctionOperatorModel.addProperty(TransformerConstants.ADVANCED_CUSTOM_FUNCTION_NAME,
                    customOperator.getFunctionName());
            customFunctionOperatorModel.addProperty(TransformerConstants.ADVANCED_CUSTOM_FUNCTION_DEFINITION,
                    customOperator.getFunctionDefinition());
            return customFunctionOperatorModel;
        }
        throw new IllegalArgumentException("CustomFunctionImpl operator expected. Found : " + operator.toString());
    }
}

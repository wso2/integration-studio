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

import static org.wso2.integrationstudio.datamapper.diagram.custom.model.transformers.TransformerConstants.DELIMITER_TAG;

import org.wso2.integrationstudio.datamapper.DataMapperOperatorType;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.DMOperation;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.IModelTransformer;
import org.wso2.integrationstudio.datamapper.impl.OperatorImpl;
import org.wso2.integrationstudio.datamapper.impl.SplitImpl;

public class SplitModelTransformer implements IModelTransformer{

    @Override
    public DMOperation transform(OperatorImpl operator, int index) {
        if (operator instanceof SplitImpl) {
            SplitImpl splitOperator = (SplitImpl) operator;
            DMOperation splitOperatorModel = new DMOperation(DataMapperOperatorType.SPLIT, operator.toString(), index);
            splitOperatorModel.addProperty(DELIMITER_TAG, splitOperator.getDelimiter());
            return splitOperatorModel;
        }
        throw new IllegalArgumentException("SplitImpl operator expected. Found : " + operator.toString());
    }

}

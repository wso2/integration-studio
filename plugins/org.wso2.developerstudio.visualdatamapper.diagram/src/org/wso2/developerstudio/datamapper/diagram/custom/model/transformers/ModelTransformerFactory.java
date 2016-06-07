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
        switch (type) {
        case CONCAT:
            return new ConcatModelTransformer();
        case SPLIT:
            return new SplitModelTransformer();
        case UPPERCASE:
            return new ToUpperCaseModelTransformer();
        case LOWERCASE:
            return new ToLowerCaseModelTransformer();
        case CONSTANT:
            return new ConstantModelTransformer();
        default:
            throw new IllegalArgumentException("Unable to find transformer to operator type : " + type);
        }
    }
}

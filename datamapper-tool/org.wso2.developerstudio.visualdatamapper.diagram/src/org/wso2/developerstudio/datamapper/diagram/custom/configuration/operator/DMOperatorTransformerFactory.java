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
package org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator;

import org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator.transformers.ConcatOperatorTransformer;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator.transformers.DMOperatorTransformer;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator.transformers.DirectOperatorTransformer;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator.transformers.SplitOperatorTransformer;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator.transformers.ToLowerCaseOperatorTransformer;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator.transformers.ToUpperCaseOperatorTransformer;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMOperatorType;

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
     * @param type of the operator
     * @return the corresponding {@link DMOperatorTransformer}
     */
    public static DMOperatorTransformer getDMOperatorTransformer(DMOperatorType type) {
        switch (type) {
        case CONCAT:
            return new ConcatOperatorTransformer();
        case DIRECT:
            return new DirectOperatorTransformer();
        case UPPERCASE:
            return new ToUpperCaseOperatorTransformer();
        case LOWERCASE:
            return new ToLowerCaseOperatorTransformer();
        case SPLIT:
            return new SplitOperatorTransformer();
        default:
            throw new IllegalArgumentException("Unknown operator type found for tranform : " + type);
        }
    }
}

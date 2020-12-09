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
package org.wso2.integrationstudio.datamapper.diagram.custom.generator;

import org.wso2.integrationstudio.datamapper.diagram.custom.exception.DataMapperException;
import org.wso2.integrationstudio.datamapper.diagram.custom.model.DataMapperDiagramModel;

/**
 * This interface should be implemented by algorithm implementations of functions and logic to generate JS mapping
 * configuration from {@link DataMapperDiagramModel}
 *
 */
public interface MappingConfigGenerator {

    /**
     * This method will generate mapping configuration JS function list from {@link DataMapperDiagramModel}
     * 
     * @param model
     * @return
     * @throws DataMapperException
     */
    String generateMappingConfig(DataMapperDiagramModel model)
            throws DataMapperException;

    /**
     * This method checks whether the mapping model is valid to be solved by the mapping configuration generating
     * algorithm provided
     * 
     * @param model
     * @return
     */
    boolean validate(DataMapperDiagramModel model);
}

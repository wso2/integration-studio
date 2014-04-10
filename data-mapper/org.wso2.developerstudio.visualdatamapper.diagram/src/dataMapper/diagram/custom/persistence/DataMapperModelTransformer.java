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
package dataMapper.diagram.custom.persistence;

import dataMapper.DataMapperRoot;

/**
 * Transform mapping model into mapping 
 * configuration. 
 *
 */
public class DataMapperModelTransformer {
	
	private static DataMapperModelTransformer instance;
	
	private DataMapperModelTransformer(){
		
	}
	
	public static DataMapperModelTransformer getInstance() {
		if (instance == null) {
			instance = new DataMapperModelTransformer();
		}
		return instance;
	}
	
	public DataMapperConfiguration transform(DataMapperRoot rootDiagram) {
		DataMapperConfiguration mappingConfig = null;
		MappingModelTraverser.getInstance().traverse(rootDiagram, mappingConfig);
		
		return mappingConfig;
	}
}

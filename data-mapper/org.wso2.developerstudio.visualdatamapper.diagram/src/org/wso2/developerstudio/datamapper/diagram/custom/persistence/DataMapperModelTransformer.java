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
package org.wso2.developerstudio.datamapper.diagram.custom.persistence;

import org.wso2.developerstudio.datamapper.DataMapperRoot;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.function.Function;

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

	/**
	 * traverse in datamapper map model and generate DataMapperConfigurtion config  
	 * @param rootDiagram datamapper graphical model root
	 * @return complete configuration of mapping
	 */
	public String transform(DataMapperRoot rootDiagram) {
		DataMapperConfiguration mappingConfig = new DataMapperConfiguration();
		MappingModelTraverser.getInstance().traverse(rootDiagram, mappingConfig);

		StringBuilder result = new StringBuilder();
		if(mappingConfig.getFunctionList().get(0) != null){
			
			for(Function function : mappingConfig.getFunctionList()){
				result.append(function.toString());
			}
			return result.toString();
		}

		return result.toString();
		}
}

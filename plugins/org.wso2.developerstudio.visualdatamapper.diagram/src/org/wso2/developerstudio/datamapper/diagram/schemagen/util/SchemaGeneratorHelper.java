/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.datamapper.diagram.schemagen.util;

import java.io.IOException;

import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * TODO
 *
 */
public class SchemaGeneratorHelper {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	// Implement loading the schema from the workspace.
	/**
	 * This method returns the generated schema as a string. It will load the
	 * schema generator class depending on the file type of the file and pass
	 * the file to the schema generator class which would generate the schema.
	 * 
	 * @param option
	 * @param filePath
	 * @return
	 */
	public String getSchemaContent(FileType option, String filePath, String delimiter) {

		SchemaGeneratorFactory schemaGenFactory = new SchemaGeneratorFactory();
		ISchemaGenerator schemaGenerator = schemaGenFactory.getSchemaGenerator(option);

		if (schemaGenerator instanceof SchemaGeneratorForXSD) {
			try {
				return schemaGenerator.getSchemaContent(filePath, option, null);
			} catch (IOException e) {
				log.error("Error while generating schema", e);
			}
		} else {
			try {
				return schemaGenerator.getSchemaResourcePath(filePath, option, delimiter);
			} catch (IOException e) {
				log.error("Error while generating schema", e);
			}
		}
		
		return null;

	}

}

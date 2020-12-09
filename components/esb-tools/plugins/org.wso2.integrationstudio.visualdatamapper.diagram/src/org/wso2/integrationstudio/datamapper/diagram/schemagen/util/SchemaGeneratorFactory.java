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

package org.wso2.integrationstudio.datamapper.diagram.schemagen.util;
//TODO add a default case and remove the unreachable null return
public class SchemaGeneratorFactory {
	
	@SuppressWarnings("incomplete-switch")
	public ISchemaGenerator getSchemaGenerator(FileType fileType) {
		switch(fileType) {
		case JSONSCHEMA:
			return new AbstractSchemaGenerator();
		case XSD:
			return new SchemaGeneratorForXSD();
		case XML:
			return new SchemaGeneratorForXML();
		case JSON:
			return new SchemaGeneratorForJSON();
		case CSV:
			return new SchemaGeneratorForCSV();
		
	}
		return null;

	}
}
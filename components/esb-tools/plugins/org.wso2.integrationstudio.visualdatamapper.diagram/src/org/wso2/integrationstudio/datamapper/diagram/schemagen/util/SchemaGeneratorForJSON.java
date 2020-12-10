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

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class SchemaGeneratorForJSON extends AbstractSchemaGenerator implements ISchemaGenerator {

	@Override
	public String getSchemaResourcePath(String filePath, FileType type, String delimiter) throws IOException {
		String entireFileText = FileUtils.readFileToString(new File(filePath));
		return  getSchemaContent(entireFileText, type, null);
	}

	@Override
	public String getSchemaContent(String fileText, FileType type, String delimiter) throws IOException {
		SchemaBuilderWithNamepaces sb = new SchemaBuilderWithNamepaces();
		String jsonSchema = sb.createSchema(fileText, type);
		return  jsonSchema;
	}

}

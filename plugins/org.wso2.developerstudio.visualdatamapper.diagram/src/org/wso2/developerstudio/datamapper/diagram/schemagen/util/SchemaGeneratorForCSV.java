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

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class SchemaGeneratorForCSV extends AbstractSchemaGenerator implements ISchemaGenerator {

	@Override
	public String getSchemaResourcePath(String filePath, FileType type, String delimiter) throws IOException {
		String entireFileText = FileUtils.readFileToString(new File(filePath));
		return getSchemaContent(entireFileText, type, delimiter);
	}

	@Override
	public String getSchemaContent(String fileText, FileType type, String delimiter) throws IOException {
		List<Map<String, String>> data = readObjectsFromCsv(fileText, delimiter);
		String value = writeAsJson(data);
		SchemaBuilderWithNamepaces sb = new SchemaBuilderWithNamepaces();
		String jsonSchema = sb.createSchema(value, type);
		return jsonSchema;
	}

	/**
	 * Read objects from CSV
	 * 
	 * @param content
	 * @return
	 * @throws IOException
	 */
	public List<Map<String, String>> readObjectsFromCsv(String content, String delimiter) throws IOException {
		CsvMapper mapper = new CsvMapper();
		char delimiterChar =',';
		if (!delimiter.isEmpty()) {
			delimiterChar = delimiter.charAt(0);
		}
		CsvSchema schema = CsvSchema.emptySchema().withHeader().withColumnSeparator(delimiterChar);
		MappingIterator<Map<String, String>> it = mapper.readerFor(Map.class).with(schema).readValues(content);
		return it.readAll();
	}

	/**
	 * get the json string
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public String writeAsJson(List<Map<String, String>> data) throws IOException {
		String value = null;
		ObjectMapper mapper = new ObjectMapper();
		if(data != null){
		value = mapper.writeValueAsString(data);
		}
		return value;

	}
}

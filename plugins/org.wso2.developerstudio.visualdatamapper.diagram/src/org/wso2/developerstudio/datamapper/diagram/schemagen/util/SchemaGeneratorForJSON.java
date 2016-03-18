package org.wso2.developerstudio.datamapper.diagram.schemagen.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class SchemaGeneratorForJSON extends AbstractSchemaGenerator implements ISchemaGenerator {

	@Override
	public String getSchemaResourcePath(String filePath) throws IOException {
		String entireFileText = FileUtils.readFileToString(new File(filePath));
		return  getSchemaContent(entireFileText);
	}

	@Override
	public String getSchemaContent(String fileText) throws IOException {
		SchemaBuilder sb = new SchemaBuilder();
		String jsonSchema = sb.createSchema(fileText);
		return  jsonSchema;
	}

}

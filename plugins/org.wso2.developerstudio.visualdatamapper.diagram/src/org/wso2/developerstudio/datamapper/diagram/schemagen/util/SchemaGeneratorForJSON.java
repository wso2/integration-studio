package org.wso2.developerstudio.datamapper.diagram.schemagen.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class SchemaGeneratorForJSON extends AbstractSchemaGenerator implements ISchemaGenerator {

	@Override
	public String getSchemaResourcePath(String filePath, FileType type) throws IOException {
		String entireFileText = FileUtils.readFileToString(new File(filePath));
		return  getSchemaContent(entireFileText, type);
	}

	@Override
	public String getSchemaContent(String fileText, FileType type) throws IOException {
		SchemaBuilderWithNamepaces sb = new SchemaBuilderWithNamepaces();
		String jsonSchema = sb.createSchema(fileText, type);
		return  jsonSchema;
	}

}

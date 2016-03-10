package org.wso2.developerstudio.datamapper.diagram.schemagen.util;

public class SchemaGeneratorFactory {
	
	public ISchemaGenerator getSchemaGenerator(FileType fileType) {
		switch(fileType) {
		case AVRO:
			return new AbstractSchemaGenerator();
		case XSD:
			return new SchemaGeneratorForXSD();
		case XML:
			return new SchemaGeneratorForXML();
		case JSON:
			return new AbstractSchemaGenerator();
		
	}
		return null;

	}
}
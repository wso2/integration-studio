package org.wso2.developerstudio.datamapper.diagram.schemagen.util;

import java.io.IOException;

import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.visualdatamapper.diagram.avro.generators.XSDtoAvroGen;

public class SchemaGeneratorForXSD extends AbstractSchemaGenerator implements ISchemaGenerator{
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	@Override
	public String getSchemaContent(String filePath) throws IOException {
		XSDtoAvroGen convertXSDtoAvro = new XSDtoAvroGen();
		String avroContent = convertXSDtoAvro.generateAVRO(filePath);
		if (avroContent == null || avroContent.isEmpty()) {
			log.error("Error Generating Avro content from the fgiven XSD file.");
		}
		return super.getSchemaContent(avroContent);
		
	}

}

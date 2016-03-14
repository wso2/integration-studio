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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.inst2xsd.Inst2XsdOptions;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.wso2.developerstudio.visualdatamapper.diagram.jsonschema.generator.JSONSchemaGeneratorforXSD;

public class SchemaGeneratorForXML extends SchemaGeneratorForXSD implements ISchemaGenerator {
	private static final String TEMP_AVRO_GEN_LOCATION = "tempXSDGenLocation";
	private static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
	private static final String TEMP_OUTPUT = System.getProperty(JAVA_IO_TMPDIR) + File.separator + TEMP_AVRO_GEN_LOCATION;
	
	@Override
	public String getSchemaContent(String filePath) throws IOException {
		File xsdFile = null;
		try {
			xsdFile = generateXSDfromXML(filePath);
		} catch (XmlException e) {
			throw new IOException(e.getMessage());
		}
		 
		return super.getSchemaContent(xsdFile.getAbsolutePath());
	}

	private File generateXSDfromXML(String filePath) throws IOException, XmlException {
		
		File outputDirectory = new File(TEMP_OUTPUT);
		if (!outputDirectory.exists()) {
			outputDirectory.mkdir();
		}
		File outputFile = new File(TEMP_OUTPUT  + File.separator + "temp.xsd");
		if (outputFile.exists()) {
			outputFile.delete();
		}
		
	    Inst2XsdOptions options = new Inst2XsdOptions();
        options.setDesign(Inst2XsdOptions.DESIGN_RUSSIAN_DOLL);
        options.setSimpleContentTypes(Inst2XsdOptions.SIMPLE_CONTENT_TYPES_STRING);
        options.setUseEnumerations(Inst2XsdOptions.ENUMERATION_NEVER);
        Reader[] xmlInstance = {new BufferedReader(new FileReader(filePath))};
        SchemaDocument[] xsds = org.apache.xmlbeans.impl.inst2xsd.Inst2Xsd.inst2xsd(xmlInstance, options);
		if(xsds != null && xsds.length > 0) {
			xsds[0].save(outputFile, new  XmlOptions().setSavePrettyPrint());
		}
		 
		return outputFile;
	}
	

	@Override
	public String getSchemaResourcePath(String filePath) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}

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
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.avro.Schema;

public class AvroSchemaGeneratorForXML extends AvroSchemaGeneratorForXSD {
	@Override
	public Schema getAvroSchema(String filePath) throws IOException {
		File avscFile = generateXSDfromXML(filePath);
		return super.getAvroSchema(avscFile.getAbsolutePath());
	}

	private File generateXSDfromXML(String filePath) throws FileNotFoundException {
		/*
		 * Inst2XsdOptions options = new Inst2XsdOptions();
		 * options.setDesign(Inst2XsdOptions.DESIGN_RUSSIAN_DOLL);
		 * options.setSimpleContentTypes
		 * (Inst2XsdOptions.SIMPLE_CONTENT_TYPES_STRING);
		 * options.setUseEnumerations(Inst2XsdOptions.ENUMERATION_NEVER);
		 * Reader[] xmlInstance = {new BufferedReader(new
		 * FileReader(filePath))}; SchemaDocument[] xsds =
		 * org.apache.xmlbeans.impl.inst2xsd.Inst2Xsd.inst2xsd(xmlInstance,
		 * options); xsds[0].save(new
		 * File("/home/susinda/workspaceLunaPP/xmltoxsd/output2.xsd"), new
		 * XmlOptions().setSavePrettyPrint());
		 */
		return new File(filePath);
	}
}

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

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

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.custom.action.Messages;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class SchemaGeneratorForFile {

	private static final String INPUT_SCHEMA_FILE = Messages.SchemaKeyEditorDialog_InputSchemaFile;
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	//TODO add a hashmap with file extensions for the 
	public static String getSchemaContent(FileType option) {

		String title = INPUT_SCHEMA_FILE;
		SchemaGeneratorFactory schemaGenFactory = new SchemaGeneratorFactory();
		ISchemaGenerator schemaGenerator = schemaGenFactory.getSchemaGenerator(option);
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		FileDialog fid = new FileDialog(shell);
		fid.setFilterExtensions(new String[] {fileExtensionForFileType(option)});
		fid.setText(title);
		String filePath = fid.open();
		if (filePath == null) {
			return null;
		}
		String schemaContent = null;
		if (schemaGenerator instanceof SchemaGeneratorForXSD) {
			try {
				schemaContent = schemaGenerator.getSchemaContent(filePath);
			} catch (IOException e) {
				log.error("Error while generating avro schema", e);
			}
		} else {
			try {
				schemaContent = schemaGenerator.getSchemaResourcePath(filePath);
			} catch (IOException e) {
				log.error("Error while generating avro schema", e);
			}
		}
		
		return schemaContent;
	}
	
	private static String fileExtensionForFileType(FileType fileType){
		switch(fileType) {
		case AVRO:
			return "*.avsc";
		case XSD:
			return "*.xsd";
		case XML:
			return "*.xml";
		case JSON:
			return "*.json";
		
	}
		return "";
		
	}
}

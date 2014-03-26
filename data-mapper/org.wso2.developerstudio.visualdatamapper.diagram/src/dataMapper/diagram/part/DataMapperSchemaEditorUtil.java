/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package dataMapper.diagram.part;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.CAppEnvironment;
import org.wso2.developerstudio.eclipse.greg.core.interfaces.IRegistryData;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.visualdatamapper.diagram.Activator;

import dataMapper.diagram.custom.util.EditorUtils;

public class DataMapperSchemaEditorUtil {

	IFile graphicalFile;
	IProject project;
	
	File inputSchemaFile; 
	IFile inputSchemaIFile;
	
	File outputSchemaFile; 
	IFile outputSchemaIFile;
	
	static String SCHEMA_FILE_EXTENSION = ".avsc";
	static String INPUT_SCHEMA_FILE_SUFFIX = "_input_schema";
	static String OUTPUT_SCHEMA_FILE_SUFFIX = "_output_schema";

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	public DataMapperSchemaEditorUtil(IFile graphicalFile){
		this.graphicalFile = graphicalFile;
		this.project = graphicalFile.getProject();
		
		String configFileName = graphicalFile.getName().substring(0, graphicalFile.getName().indexOf(EditorUtils.DIAGRAM_FILE_EXTENSION));
		String graphicalFileDirPath = graphicalFile.getParent().getProjectRelativePath().toString();
		if(graphicalFileDirPath != null && !"".equals(graphicalFileDirPath)){
			graphicalFileDirPath += File.separator;
		}
		//graphicalFileDirPath = graphicalFileDirPath.substring(graphicalFileDirPath.indexOf(File.separator), graphicalFileDirPath.length()-1);
		String newInputFilePath = graphicalFileDirPath + configFileName + INPUT_SCHEMA_FILE_SUFFIX + SCHEMA_FILE_EXTENSION;
		String newOutputFilePath = graphicalFileDirPath + configFileName + OUTPUT_SCHEMA_FILE_SUFFIX + SCHEMA_FILE_EXTENSION;

		inputSchemaIFile = project.getFile(newInputFilePath);
		outputSchemaIFile = project.getFile(newOutputFilePath);
	}
	
	public String createDiagram(Object schemaData, String fileType) {
		
		try {
			if("input".equals(fileType)){

				if(!inputSchemaIFile.exists()){
					byte[] bytes = "".getBytes();
					InputStream source = new ByteArrayInputStream(bytes);
					inputSchemaIFile.create(source, IResource.NONE, null);
				}
				inputSchemaFile = inputSchemaIFile.getRawLocation().makeAbsolute().toFile();
				
				if(schemaData instanceof IRegistryData){
					CAppEnvironment.getRegistryHandler().importRegistryResourceToFileSystem( (IRegistryData)schemaData, inputSchemaFile);
				}
				return inputSchemaFile.getAbsolutePath();
				
			}else if("output".equals(fileType)){
				
				if(!outputSchemaIFile.exists()){
					byte[] bytes = "".getBytes();
					InputStream source = new ByteArrayInputStream(bytes);
					outputSchemaIFile.create(source, IResource.NONE, null);
				}
				outputSchemaFile = outputSchemaIFile.getRawLocation().makeAbsolute().toFile();
				
				if(schemaData instanceof IRegistryData){
					CAppEnvironment.getRegistryHandler().importRegistryResourceToFileSystem( (IRegistryData)schemaData, outputSchemaFile);
				}
				return outputSchemaFile.getAbsolutePath();
				
			}
			
		} catch (CoreException e) {
			log.error("Error occured while creating the schema file", e);
		} catch (Exception e) {
			log.error("Error occured while creating the schema file", e);
		}	
		
		return null;
		
	}
}

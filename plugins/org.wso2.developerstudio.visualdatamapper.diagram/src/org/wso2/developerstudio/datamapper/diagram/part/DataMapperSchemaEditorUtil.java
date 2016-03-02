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

package org.wso2.developerstudio.datamapper.diagram.part;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.datamapper.diagram.custom.action.Messages;
import org.wso2.developerstudio.datamapper.diagram.custom.util.EditorUtils;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.CAppEnvironment;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryData;

public class DataMapperSchemaEditorUtil {

	private IProject project;
	private File inputSchemaFile;
	private IFile inputSchemaIFile;
	private File outputSchemaFile;
	private IFile outputSchemaIFile;

	private static final String SCHEMA_FILE_EXTENSION = ".avsc";
	private static final String INPUT_SCHEMA_FILE_SUFFIX = "_inputSchema";
	private static final String OUTPUT_SCHEMA_FILE_SUFFIX = "_outputSchema";

	public DataMapperSchemaEditorUtil(IFile graphicalFile) {
		this.project = graphicalFile.getProject();

		String configFileName = graphicalFile.getName().substring(0,
				graphicalFile.getName().indexOf(EditorUtils.DIAGRAM_FILE_EXTENSION));
		String graphicalFileDirPath = graphicalFile.getParent().getProjectRelativePath().toString();
		if (graphicalFileDirPath != null && !"".equals(graphicalFileDirPath)) {
			graphicalFileDirPath += File.separator;
		}

		String newInputFilePath = graphicalFileDirPath + configFileName + INPUT_SCHEMA_FILE_SUFFIX
				+ SCHEMA_FILE_EXTENSION;
		String newOutputFilePath = graphicalFileDirPath + configFileName
				+ OUTPUT_SCHEMA_FILE_SUFFIX + SCHEMA_FILE_EXTENSION;

		inputSchemaIFile = project.getFile(newInputFilePath);
		outputSchemaIFile = project.getFile(newOutputFilePath);
	}

	public String createDiagram(Object schemaData, String fileType) throws Exception {

		if (Messages.LoadInputSchemaAction_SchemaTypeInput.equals(fileType)) {

			// Check whether input schema file already exists
			if (!inputSchemaIFile.exists()) {
				byte[] bytes = "".getBytes();
				InputStream source = new ByteArrayInputStream(bytes);
				inputSchemaIFile.create(source, IResource.NONE, null);
			}
			inputSchemaFile = inputSchemaIFile.getRawLocation().makeAbsolute().toFile();

			// case: Browse from registry
			if (schemaData instanceof IRegistryData) {
				CAppEnvironment.getRegistryHandler().importRegistryResourceToFileSystem(
						(IRegistryData) schemaData, inputSchemaFile);
			}

			// case: Browse from file system
			else if (schemaData instanceof String) {
				FileUtils.writeStringToFile(inputSchemaFile, (String) schemaData);
			}

			return inputSchemaFile.getAbsolutePath();

		} else if (Messages.LoadOutputSchemaAction_SchemaTypeOutput.equals(fileType)) {

			// Check whether output schema file already exists
			if (!outputSchemaIFile.exists()) {
				byte[] bytes = "".getBytes();
				InputStream source = new ByteArrayInputStream(bytes);
				outputSchemaIFile.create(source, IResource.NONE, null);
			}
			outputSchemaFile = outputSchemaIFile.getRawLocation().makeAbsolute().toFile();

			// case: Browse from registry
			if (schemaData instanceof IRegistryData) {
				CAppEnvironment.getRegistryHandler().importRegistryResourceToFileSystem(
						(IRegistryData) schemaData, outputSchemaFile);
			}

			// case: Browse from file system
			else if (schemaData instanceof String) {
				FileUtils.writeStringToFile(outputSchemaFile, (String) schemaData);
			}

			return outputSchemaFile.getAbsolutePath();

		}

		return null;
	}
}

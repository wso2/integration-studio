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

package org.wso2.developerstudio.datamapper.diagram.tree.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.impl.TreeNodeImpl;

public class SchemaTransformer implements ISchemaTransformer {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static String ERROR_TEXT = "File cannot be found ";
	private static final String ERROR_WRITING_SCHEMA_FILE = "Error writing to schema file";

	private String name;
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void setName(String name){
		this.name = name;
	}
	
	@Override
	public void setPropertyValues(String content) {
        setName(content);
	}

	@Override
	public String getPropertyValues() {
		return null;
	}

	@Override
	public String getSchemaContentFromFile(String path) {
		File avsc = new File(path);
		String entireFileText = null;
		try {
			entireFileText = new Scanner(avsc).useDelimiter("\\A").next();
		} catch (FileNotFoundException e) {
			log.error(ERROR_TEXT, e);
		}
		return entireFileText;
	}

	@Override
	public String getSchemaContentFromModel(TreeNodeImpl treeNodeModel) {
		String name = null;

		if (StringUtils.isNotEmpty(treeNodeModel.getName())) {
			name = treeNodeModel.getName();
		}
		return name;

	}

	@Override
	public void updateSchemaFile(String content, File file) {
		try {
			FileUtils.writeStringToFile(file, content);
		} catch (IOException e) {
			log.error(ERROR_WRITING_SCHEMA_FILE + file.getName(), e);
			return;
		}
	}

}

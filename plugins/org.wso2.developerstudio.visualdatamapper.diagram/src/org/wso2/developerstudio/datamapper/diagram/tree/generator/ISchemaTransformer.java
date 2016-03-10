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

import org.wso2.developerstudio.datamapper.impl.TreeNodeImpl;

public interface ISchemaTransformer {

	/**
	 * Sets property values
	 * 
	 * @param content
	 *            fileContent
	 */
	public void setPropertyValues(String content);

	/**
	 * Gets the property values
	 * 
	 * @return
	 */
	public String getPropertyValues();

	/**
	 * Gets the schema content from the file
	 * 
	 * @param path
	 *            file path
	 * @return schema content as a String
	 */
	public String getSchemaContentFromFile(String path);

	/**
	 * Gets the content to the file
	 * 
	 * @param treeNodeModel
	 *            treeNodeImpl
	 * @param schemaFile
	 *            file
	 */
	public String getSchemaContentFromModel(TreeNodeImpl treeNodeModel);

	/**
	 * Updates the schema file
	 * 
	 * @param content
	 *            content
	 * @param file
	 *            file
	 */
	public void updateSchemaFile(String content, File file);

	public void setName(String name);
	
	public String getName();
}

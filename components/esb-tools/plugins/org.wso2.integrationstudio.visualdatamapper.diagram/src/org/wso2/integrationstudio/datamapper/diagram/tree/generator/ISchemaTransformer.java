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

package org.wso2.integrationstudio.datamapper.diagram.tree.generator;

import java.io.File;
import java.io.IOException;

import org.wso2.integrationstudio.datamapper.TreeNode;
import org.wso2.integrationstudio.datamapper.impl.TreeNodeImpl;
import org.wso2.integrationstudio.datamapper.diagram.tree.model.Tree;

public interface ISchemaTransformer {

	/**
	 * Generate the tree
	 * 
	 * @param inputRootTreeNode
	 * @param content
	 * 
	 * @return
	 */
	public TreeNode generateTree(String content, TreeNode treeNode) throws NullPointerException,
			IllegalArgumentException, IOException;

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
	public String getSchemaContentFromModel(TreeNodeImpl treeNodeModel, File schemaFile);
	
	/**
	 * Gets the content to the file
	 * 
	 * @param treeNodeModel
	 *            treeNodeImpl
	 * @param schemaFile
	 *            file
	 * @param isInput
	 *            is this the input schema
	 * @param type
	 *            type of input/output
	 */
	public String getSchemaContentFromModel(TreeNodeImpl treeNodeModel, File schemaFile, boolean isInput, String type);

	/**
	 * Updates the schema file
	 * 
	 * @param content
	 *            content
	 * @param file
	 *            file
	 */
	public void updateSchemaFile(String content, File file);

	public Tree generateTreeFromFile(String path);

}

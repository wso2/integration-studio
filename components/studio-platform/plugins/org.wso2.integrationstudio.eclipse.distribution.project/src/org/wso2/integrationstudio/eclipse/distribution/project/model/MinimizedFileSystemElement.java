/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.eclipse.distribution.project.model;

import java.util.Iterator;
import java.util.List;

import org.eclipse.ui.dialogs.FileSystemElement;
import org.eclipse.ui.model.AdaptableList;
import org.eclipse.ui.wizards.datatransfer.IImportStructureProvider;

/**
 * The <code>MinimizedFileSystemElement</code> is a
 * <code>FileSystemElement</code> that knows if it has been populated or not.
 */
public class MinimizedFileSystemElement extends FileSystemElement {
	private boolean populated = false;

	/**
	 * Create a <code>MinimizedFileSystemElement</code> with the supplied name and
	 * parent.
	 * 
	 * @param name
	 *            the name of the file element this represents
	 * @param parent
	 *            the containing parent
	 * @param isDirectory
	 *            indicated if this could have children or not
	 */
	public MinimizedFileSystemElement(String name, FileSystemElement parent, boolean isDirectory) {
		super(name, parent, isDirectory);
	}

	/**
	 * Returns a list of the files that are immediate children. Use the supplied
	 * provider if it needs to be populated. of this folder.
	 */
	public AdaptableList getFiles(IImportStructureProvider provider) {
		if (!populated) {
			populate(provider);
		}
		return super.getFiles();
	}

	/**
	 * Returns a list of the folders that are immediate children. Use the supplied
	 * provider if it needs to be populated. of this folder.
	 */
	public AdaptableList getFolders(IImportStructureProvider provider) {
		if (!populated) {
			populate(provider);
		}
		return super.getFolders();
	}

	/**
	 * Return whether or not population has happened for the receiver.
	 */
	public boolean isPopulated() {
		return this.populated;
	}

	/**
	 * Populate the files and folders of the receiver using the supplied structure
	 * provider.
	 * 
	 * @param provider
	 *            org.eclipse.ui.wizards.datatransfer.IImportStructureProvider
	 */
	private void populate(IImportStructureProvider provider) {

		Object fileSystemObject = getFileSystemObject();

		List children = provider.getChildren(fileSystemObject);
		if (children != null) {
			Iterator childrenEnum = children.iterator();
			while (childrenEnum.hasNext()) {
				Object child = childrenEnum.next();

				String elementLabel = provider.getLabel(child);
				// Create one level below
				MinimizedFileSystemElement result = new MinimizedFileSystemElement(elementLabel, this,
						provider.isFolder(child));
				result.setFileSystemObject(child);
			}
		}
		setPopulated();
	}

	/**
	 * Set whether or not population has happened for the receiver to true.
	 */
	public void setPopulated() {
		this.populated = true;
	}
}

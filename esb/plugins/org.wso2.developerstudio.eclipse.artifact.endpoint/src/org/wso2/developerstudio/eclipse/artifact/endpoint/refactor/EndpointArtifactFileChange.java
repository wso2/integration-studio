/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.endpoint.refactor;

import org.eclipse.core.resources.IFile;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.wso2.developerstudio.eclipse.artifact.endpoint.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EndpointArtifactFileChange extends TextFileChange {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private IFile endpointFile;
	private String newName;
	private String originalName;

	public EndpointArtifactFileChange(String name, IFile file, String originalName, String newName) {
		super(name, file);
		endpointFile = file;
		this.originalName = originalName;
		this.newName = newName;
		addTextEdits();
	}

	private void addTextEdits() {
		MultiTextEdit multiTextEdit = new MultiTextEdit();
		setEdit(multiTextEdit);
		setSaveMode(FORCE_SAVE);

		try {
			if (endpointFile.exists()) {
				identifyReplaces();
			}
		} catch (IOException e) {
			log.error("Encountered an IO Error trying to manipulate the file", e);
		}
	}

	private void identifyReplaces() throws IOException {
		int fullIndex = 0;
		FileReader fileReader = new FileReader(endpointFile.getLocation().toFile());
		BufferedReader reader = new BufferedReader(fileReader);
		String case1String = "\"" + originalName + "\"";
		String nameElement = "name=";
		String line = reader.readLine();
		while (line != null) {
			String[] stringArray = line.trim().split(" ");
			if (line.contains(case1String)) {
				int getArrayIndexWithString = getArrayIndexWithString(nameElement, stringArray);
				if (getArrayIndexWithString != -1) {
					if (stringArray[getArrayIndexWithString].equalsIgnoreCase(nameElement +
					                                                          case1String) ||
					    stringArray[getArrayIndexWithString].equalsIgnoreCase(nameElement +
					                                                          case1String + ">") ||
					    stringArray[getArrayIndexWithString].equalsIgnoreCase(nameElement +
					                                                          case1String + "/>")) {
						int case1LineIndex = line.indexOf(case1String) + 1;
						addEdit(new ReplaceEdit(fullIndex + case1LineIndex, originalName.length(),
						                        newName));
					}

				} else {
					String keyElement = "key=";
					int localEntryArrayIndex = getArrayIndexWithString(keyElement, stringArray);
					if (localEntryArrayIndex != -1) {
						if (stringArray[localEntryArrayIndex].startsWith(keyElement + case1String) ||
						    stringArray[localEntryArrayIndex].startsWith(keyElement + case1String +
						                                                 ">") ||
						    stringArray[localEntryArrayIndex].startsWith(keyElement + case1String +
						                                                 "/>")) {
							int case1LineIndex = line.indexOf(case1String) + 1;
							addEdit(new ReplaceEdit(fullIndex + case1LineIndex,
							                        originalName.length(), newName));
						}
					}
				}
			}
			fullIndex += charsOnTheLine(line);
			line = reader.readLine();
		}
		fileReader.close();
		reader.close();
	}

	private int charsOnTheLine(String line) {
		// Here we need to add one to represent the newline character
		return line.length() + 1;
	}

	private int getArrayIndexWithString(String stringToSearch, String[] array) {
		int index = 0;
		for (String string : array) {
			if (string.startsWith(stringToSearch)) {
				return index;
			}
			index++;
		}
		return -1;
	}
}

/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.ds.refactor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;

public class DataServiceMetaDataFileChange extends TextFileChange {
	private static final String ARTIFACT_XML_FILE = "artifact.xml";

	private IFile metaDataFile;
	private String originalFileFullName;
	private String changedFileFullName;
	private String originalFileName;
	private String changedFileName;

	public DataServiceMetaDataFileChange(String fileChangeIdentifier, IFile file, String originalFileFullName,
			String changedFileFullName) throws IOException {
		super(fileChangeIdentifier, file);
		this.metaDataFile = file;
		this.originalFileFullName = originalFileFullName;
		this.changedFileFullName = changedFileFullName;
		this.originalFileName = originalFileFullName.substring(0, originalFileFullName.lastIndexOf(".")); //$NON-NLS-1$
		this.changedFileName = changedFileFullName.substring(0, changedFileFullName.lastIndexOf(".")); //$NON-NLS-1$		
		addTextEdits();
	}

	private void addTextEdits() throws IOException {
		if (metaDataFile.getName().equalsIgnoreCase(ARTIFACT_XML_FILE)) {
			setEdit(new MultiTextEdit());
			int fullIndex = 0;
			BufferedReader reader = new BufferedReader(new FileReader(metaDataFile.getLocation().toFile()));

			String case1OriginalString = "name=\"" + originalFileName + "\"";
			String case1ReplaceString = "name=\"" + changedFileName + "\"";

			String case2OriginalString = originalFileFullName + "</file>";
			String case2ReplaceString = changedFileFullName + "</file>";

			String line = reader.readLine();
			while (line != null) {
				/*
				 * Replace element appears only twice in artifact.xml file. <artifact name="dser1"
				 * groupId="com.example.das.dataservice" version="1.0.0" type="service/dataservice"
				 * serverRole="DataServicesServer"> and <file>dataservice/dser.dbs</file>
				 */
				if (isMatchFound(line, case1OriginalString)) {
					int replaceStringLineIndex = line.indexOf(case1OriginalString);
					addEdit(new ReplaceEdit(fullIndex + replaceStringLineIndex, case1OriginalString.length(),
							case1ReplaceString));
				} else if (isMatchFound(line, case2OriginalString)) {
					int replaceStringLineIndex = line.indexOf(case2OriginalString);
					addEdit(new ReplaceEdit(fullIndex + replaceStringLineIndex, case2OriginalString.length(),
							case2ReplaceString));
				}
				// Add line length and newline length to index
				fullIndex += (line + System.lineSeparator()).length();
				line = reader.readLine();
			}
			reader.close();
		}
	}

	private boolean isMatchFound(String line, String matchString) {
		String[] spacedElementsArray = line.split(" ");
		for (String element : spacedElementsArray) {
			if (element.contains(matchString)) {
				return true;
			}
		}
		return false;
	}
}

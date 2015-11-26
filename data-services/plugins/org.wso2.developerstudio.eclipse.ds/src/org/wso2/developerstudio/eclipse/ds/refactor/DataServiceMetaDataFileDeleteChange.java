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

package org.wso2.developerstudio.eclipse.ds.refactor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.DeleteEdit;
import org.eclipse.text.edits.MultiTextEdit;

public class DataServiceMetaDataFileDeleteChange extends TextFileChange {
	private static final String ARTIFACT_XML_FILE = "artifact.xml";

	private IFile metaDataFile;
	private String originalFileName;

	public DataServiceMetaDataFileDeleteChange(String name, IFile file, String originalFileFullName) throws IOException {
		super(name, file);
		this.metaDataFile = file;
		this.originalFileName = originalFileFullName.substring(0, originalFileFullName.lastIndexOf(".")); //$NON-NLS-1$

		addTextEdits();
	}

	private void addTextEdits() throws IOException {
		if (metaDataFile.getName().equalsIgnoreCase(ARTIFACT_XML_FILE)) {
			setEdit(new MultiTextEdit());

			String artifactsStart = "<artifacts>";
			String artifactsEnd = "</artifacts>";
			String artifactStart = "<artifact";
			String artifactEnd = "</artifact>";
			String nameProperty = "name=\"";

			List<String> artifactEntry = new ArrayList<String>();
			boolean isArtifact = false;
			boolean isArtifacts = false;
			boolean isArtifactMatch = false;
			boolean isArtifactLine = false;

			int fullIndex = 0;
			int startIndex = 0;
			BufferedReader reader = new BufferedReader(new FileReader(metaDataFile.getLocation().toFile()));

			String line = reader.readLine();
			while (line != null) {
				if (!isArtifacts && line.contains(artifactsStart)) {
					isArtifacts = true;
				}

				if (isArtifacts && line.contains(artifactsEnd)) {
					isArtifacts = false;
				}

				if (isArtifacts) {
					isArtifactLine = false;
					if (!isArtifact && line.trim().startsWith(artifactStart)) {
						int artifactTagIndex = line.indexOf(artifactStart);
						startIndex = fullIndex + artifactTagIndex;
						if (line.contains(nameProperty + originalFileName + "\"")) {
							isArtifact = true;
							artifactEntry.add(line.substring(artifactTagIndex));
							isArtifactLine = true;
						} else {
							isArtifact = false;
							artifactEntry.clear();
							startIndex = 0;
						}
					}

					if (isArtifact) {
						if (!isArtifactLine && !artifactEntry.contains(line)) {
							artifactEntry.add(line);
						}
						if (line.trim().startsWith(artifactEnd)) {
							isArtifact = false;
							isArtifactMatch = true;
						}
					}

					if (isArtifactMatch) {
						int length = 0;
						for (String string : artifactEntry) {
							length += charsOnTheLine(string);
						}
						addEdit(new DeleteEdit(startIndex, length));
						break;
					}

				}

				fullIndex += charsOnTheLine(line);
				line = reader.readLine();
			}
			reader.close();
		}
	}

	private int charsOnTheLine(String line) {
		line += System.lineSeparator();
		return line.length();
	}

}
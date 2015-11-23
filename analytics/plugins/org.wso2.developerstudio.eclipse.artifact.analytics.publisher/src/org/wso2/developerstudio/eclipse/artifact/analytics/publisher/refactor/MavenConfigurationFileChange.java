/*
*  Copyright (c) 2005-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.developerstudio.eclipse.artifact.analytics.publisher.refactor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.wso2.developerstudio.eclipse.artifact.analytics.publisher.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MavenConfigurationFileChange extends TextFileChange {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private IFile pomFile;
	private String previousName;
	private IProject refactoringProject;
	private String previousLine = "";
	private String newName;

	MultiTextEdit multiEdit;

	public MavenConfigurationFileChange(String name, IFile file, String previousName,
	                                    IProject refactoringProject, String newName) {
		super(name, file);
		pomFile = file;

		this.previousName = previousName;
		this.refactoringProject = refactoringProject;
		this.newName = newName;
		addTextEdits();
	}

	private void addTextEdits() {

		multiEdit = new MultiTextEdit();
		setEdit(multiEdit);

		setSaveMode(FORCE_SAVE);

		if (refactoringProject.isOpen()) {

			try {
				if (pomFile.exists() &&
				    refactoringProject.hasNature("org.wso2.developerstudio.eclipse.distribution.project.nature")) {
					dependencyReplacement();
				}
			} catch (CoreException e) {
				log.error("Error occured while trying to generate the Refactoring", e);
			} catch (IOException e) {
				log.error("Error occured while trying to manipulate the file", e);
			}

		}
	}

	private int charsOnTheLine(String line) {
		// Here we need to add one to represent the newline character
		return line.length()+1;
	}

	private void dependencyReplacement() throws IOException {
		int fullIndex = 0;
		FileReader fileReader = new FileReader(pomFile.getLocation().toFile());
		BufferedReader reader = new BufferedReader(fileReader);
		String dependenciesStart = "<dependencies>";
		String dependenciesEnd = "</dependencies>";
		boolean isDependencies = false;
		String case1String = "<artifactId>";
		String case2String = "</artifactId>";
		String artifactId = previousName;
		String line = reader.readLine();
		while (line != null) {
			if (!isDependencies && line.contains(dependenciesStart)) {
				isDependencies = true;
			}

			if (isDependencies && line.contains(dependenciesEnd)) {
				isDependencies = false;
			}

			if (isDependencies && line.contains(artifactId)) {
				if (line.contains(case1String) ||
				    (previousLine.contains(case1String) && !previousLine.contains(case2String))) {
					int case1LineIndex = line.indexOf(artifactId);
					addEdit(new ReplaceEdit(fullIndex + case1LineIndex, artifactId.length(),
					                        newName));
					break;
				}
			}
			fullIndex += charsOnTheLine(line);
			previousLine = line;
			line = reader.readLine();
		}
		fileReader.close();
		reader.close();
	}
}

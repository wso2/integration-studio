/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.core.project.refactor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.Activator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/***
 * This class represents all the changes we need to perform when an artifact
 * project rename refactoring is executed.
 * For example, when a project is renamed, there are 2 things that we need to
 * perform on generic WSO2 Project.
 * 1. Update necessary fields in pom.xml of the project 2. Update pom.xml of
 * distribution projects.
 * This change is generating a composite change for that.
 * 
 */
public class MavenConfigurationFileChange extends TextFileChange {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private IFile pomFile;
	private String previousName;
	private IProject refactoringProject;
	private String previousLine = "";
	private String newName;

	MultiTextEdit multiEdit;

	public MavenConfigurationFileChange(String name, IFile file, String previousName, IProject refactoringProject,
	                                    String newName) {
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
				if (pomFile.exists()) {
					// This is for the requirement (1) indicated above where all
					// the artifacts projects
					// should update the pom.xml of their own project once the
					// refactoring is performed.
					// In this case they need to update the artifactId of the
					// pom.
					identifyIdArtifactReplacement();

					try {
						if (refactoringProject.hasNature("org.wso2.developerstudio.eclipse.distribution.project.nature")) {
							// If the project is a distribution project, then we
							// need to refactor the dependencies section as
							// well.
							dependencyReplacement();
						}
					} catch (Exception e) {
						log.error("Error occured while trying to generate the Refactoring.", e);
					}
				}

			} catch (IOException e) {
				log.error("Error occured while trying to manipulated the file.", e);
			}

		}
	}

	/**
	 * This method is used to identify and replace the value in the artifactId
	 * of the pom.xml
	 * 
	 * @throws IOException
	 */
	private void identifyIdArtifactReplacement() throws IOException {
		BufferedReader reader = null;
		FileReader fileReader = null;
		try {
			int fullIndex = 0;
			fileReader = new FileReader(pomFile.getLocation().toFile());
			reader = new BufferedReader(fileReader);
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

				// This is to check the artifact id of the pom.xml and it is
				// identified by not selecting the one in dependencies section.
				if (!isDependencies && line.contains(artifactId)) {
					if (line.contains(case1String) ||
					    (previousLine.contains(case1String) && !previousLine.contains(case2String))) {
						int case1LineIndex = line.indexOf(artifactId);
						addEdit(new ReplaceEdit(fullIndex + case1LineIndex, artifactId.length(), newName));
						break;

					}
				}
				fullIndex += ProjectRefactorUtils.charsOnTheLine(line);
				previousLine = line;
				line = reader.readLine();
			}
		} catch (MalformedTreeException e) {
			log.error("Cannot generate the change for the given edits", e);
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
			if (reader != null) {
				reader.close();
			}
		}
	}

	/**
	 * This method is used to check for the dependency which represents the
	 * deleted project and replace the current artifact id with new one
	 * 
	 * @throws IOException
	 */
	private void dependencyReplacement() throws IOException {
		int fullIndex = 0;
		BufferedReader reader = new BufferedReader(new FileReader(pomFile.getLocation().toFile()));
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
					addEdit(new ReplaceEdit(fullIndex + case1LineIndex, artifactId.length(), newName));
					break;
				}
			}
			fullIndex += ProjectRefactorUtils.charsOnTheLine(line);
			previousLine = line;
			line = reader.readLine();
		}
		reader.close();
	}
}

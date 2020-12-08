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

import org.apache.maven.model.Dependency;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.DeleteEdit;
import org.eclipse.text.edits.MultiTextEdit;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.Activator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/***
 * This class represent the changes that we need to perform when a project is
 * deleted.
 * These changes including deleting the dependency from distribution projects.
 * 
 */
public class MavenConfigurationFileDeleteChange extends TextFileChange {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private IProject deletingProject;
	private MultiTextEdit multiEdit;
	private IFile pomFile;

	public MavenConfigurationFileDeleteChange(String name, IFile file, IProject deletingProject) {
		super(name, file);
		pomFile = file;
		this.deletingProject = deletingProject;

		addTextEdits();
	}

	private void addTextEdits() {

		multiEdit = new MultiTextEdit();
		setEdit(multiEdit);
		setSaveMode(FORCE_SAVE);
		if (pomFile.exists()) {
			identifyDepenencyEntry();
		}
	}

	/**
	 * This method is checking for dependencies for the correct dependency.
	 */
	private void identifyDepenencyEntry() {
		FileReader fileReader = null;
		BufferedReader reader = null;
		try {
			int fullIndex = 0;
			int startIndex = 0;
			String dependenciesStart = "<dependencies>";
			String dependenciesEnd = "</dependencies>";
			String dependencyStart = "<dependency>";
			String dependencyEnd = "</dependency>";
			String groupIdStart = "<groupId>";
			String groupIdEnd = "</groupId>";
			String artifactIdStart = "<artifactId>";
			String artifactIdEnd = "</artifactId>";
			String versionStart = "<version>";
			String versionEnd = "</version>";
			boolean isDependencies = false;
			boolean isDependency = false;
			List<String> dependencyEntry = new ArrayList<String>();
			boolean isGroupMatch = false;
			boolean isArtifactMatch = false;
			boolean isVersionMatch = false;
			Dependency dependencyForTheProject = ProjectRefactorUtils.getDependencyForTheProject(deletingProject);

			if (dependencyForTheProject != null) {
				fileReader = new FileReader(pomFile.getLocation().toFile());
				reader = new BufferedReader(fileReader);
				String line = reader.readLine();
				while (line != null) {

					if (!isDependencies && line.contains(dependenciesStart)) {
						isDependencies = true;
					}

					if (isDependencies && line.contains(dependenciesEnd)) {
						isDependencies = false;
					}

					if (isDependencies) {
						if (line.contains(dependencyStart)) {
							isDependency = true;
							dependencyEntry.clear();
							int dependencyEntryindex = line.indexOf(dependencyStart);
							startIndex = fullIndex + dependencyEntryindex;
							if (dependencyEntryindex != -1) {
								dependencyEntry.add(line.substring(dependencyEntryindex));
							}
						}

						if (isDependency) {
							if (line.contains(groupIdStart) && line.contains(groupIdEnd)) {
								if (line.contains(dependencyForTheProject.getGroupId())) {
									int start = line.indexOf(groupIdStart);
									int end = line.indexOf(groupIdEnd);

									String groupId = line.substring(start + groupIdStart.length(), end);
									if (groupId.equalsIgnoreCase(dependencyForTheProject.getGroupId())) {
										isGroupMatch = true;
										if (!dependencyEntry.contains(line)) {
											dependencyEntry.add(line);
										}
									} else {
										isGroupMatch = false;
										dependencyEntry.clear();
									}
								}
							}

							if (isGroupMatch && line.contains(artifactIdStart) && line.contains(artifactIdEnd)) {
								if (line.contains(dependencyForTheProject.getArtifactId())) {
									int start = line.indexOf(artifactIdStart);
									int end = line.indexOf(artifactIdEnd);

									String artifactId = line.substring(start + artifactIdStart.length(), end);
									if (artifactId.equalsIgnoreCase(dependencyForTheProject.getArtifactId())) {
										isArtifactMatch = true;
										if (!dependencyEntry.contains(line)) {
											dependencyEntry.add(line);
										}
									} else {
										isArtifactMatch = false;
										dependencyEntry.clear();
									}
								}
							}

							if (isGroupMatch && isArtifactMatch && line.contains(versionStart) &&
							    line.contains(versionEnd)) {
								if (line.contains(dependencyForTheProject.getVersion())) {
									int start = line.indexOf(versionStart);
									int end = line.indexOf(versionEnd);

									String version = line.substring(start + versionStart.length(), end);
									if (version.equalsIgnoreCase(dependencyForTheProject.getVersion())) {
										isVersionMatch = true;
										if (!dependencyEntry.contains(line)) {
											dependencyEntry.add(line);
										}
									} else {
										isVersionMatch = false;
										dependencyEntry.clear();
									}
								}
							}

							if (isGroupMatch && isArtifactMatch && isVersionMatch) {
								if (line.contains(dependencyEnd)) {
									int end = line.indexOf(dependencyEnd) + dependencyEnd.length();
									String finalEntry = line.substring(0, end);
									if (!dependencyEntry.contains(finalEntry)) {
										dependencyEntry.add(finalEntry);
									}

									int length = 0;
									for (String string : dependencyEntry) {
										length += ProjectRefactorUtils.charsOnTheLine(string);
									}

									addEdit(new DeleteEdit(startIndex, length));

									dependencyEntry.clear();
									break;
								} else {
									if (!dependencyEntry.contains(line)) {
										dependencyEntry.add(line);
									}
								}
							}

						}

					}
					fullIndex += ProjectRefactorUtils.charsOnTheLine(line);
					line = reader.readLine();
				}
			}
		} catch (Exception e) {
			log.error("Error occured while trying to generate the Refactoring for the project", e);
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				log.error("Error occured while trying to close the file stream", e);
			}
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				log.error("Error occured while trying to close the file stream.", e);
			}
		}

	}

}

/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package org.wso2.developerstudio.eclipse.ds.refactor;

import org.apache.maven.model.Dependency;
import org.eclipse.core.resources.IFile;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.DeleteEdit;
import org.eclipse.text.edits.MultiTextEdit;
import org.wso2.developerstudio.eclipse.ds.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MavenConfigurationFileDeleteChange extends TextFileChange {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private MultiTextEdit multiEdit;
	private IFile pomFile;
	private Dependency deletingArtifactDependency;

	public MavenConfigurationFileDeleteChange(String name, IFile file, Dependency deletingArtifactDependency) {
		super(name, file);
		pomFile = file;
		this.deletingArtifactDependency = deletingArtifactDependency;

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

	private String getArtifactInfoAsString(Dependency dep) {
		String suffix = "";
		return suffix.concat(dep.getGroupId().concat("_._").concat(dep.getArtifactId()));
	}

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
			Dependency dependencyForTheProject = deletingArtifactDependency;
			String artifactProperty = getArtifactInfoAsString(dependencyForTheProject);
			fileReader = new FileReader(pomFile.getLocation().toFile());
			reader = new BufferedReader(fileReader);

			String line = reader.readLine();

			while (line != null) {

				if (line.contains(artifactProperty)) {
					String patternstr = "^(.)*(\\s)*(<){1}" + artifactProperty + "(>){1}(.)*(>)$";
					Pattern pattern = Pattern.compile(patternstr);
					Matcher matcher = pattern.matcher(line);

					if (matcher.find()) {
						String propertyStart = "<" + artifactProperty + ">";
						int start = fullIndex + line.indexOf(propertyStart);
						addEdit(new DeleteEdit(start, line.trim().length()));
					}
				}
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

						if (isGroupMatch && isArtifactMatch && line.contains(versionStart) && line.contains(versionEnd)) {
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
									length += string.length() + 1;
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
				fullIndex += line.length() + 1;
				line = reader.readLine();
			}
		} catch (Exception e) {
			log.error("Error occurred while trying to generate the Refactoring for the Registry Resource Artifact", e);
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				log.error("Error occurred while trying to close the file stream", e);
			}
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				log.error("Error occurred while trying to close the file stream.", e);
			}
		}

	}

}

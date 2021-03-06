/*
 * Copyright (c) 2012-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.esb.project.refactoring.delete;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.DeleteEdit;
import org.eclipse.text.edits.MultiTextEdit;
import org.wso2.integrationstudio.esb.project.Activator;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.maven.util.MavenUtils;
import org.wso2.integrationstudio.platform.core.utils.Constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ESBMetaDataFileDeleteChange extends TextFileChange {
	
    private static final String ARTIFACT_XML_FILE = "artifact.xml";
    private static final String LINE_SEPERATOR_PROPERTY = "line.separator";
	IIntegrationStudioLog log= Logger.getLog(Activator.PLUGIN_ID);
	
	private IFile metaDataFile;
	private IFile originalFile;

	public ESBMetaDataFileDeleteChange(String name, IFile file, IFile originalFile) {
		super(name, file);
		metaDataFile = file;
		this.originalFile = originalFile;

		addTextEdits();
		try {
			file.refreshLocal(0, new NullProgressMonitor());
			originalFile.refreshLocal(0, new NullProgressMonitor());
		} catch (CoreException ignrore) {
 
		}
	}

	public ESBMetaDataFileDeleteChange(String name, IFile file, List<IFile> fileList) {
		super(name, file);
		setEdit(new MultiTextEdit());
		for (IFile iFile : fileList) {
			metaDataFile = file;
			this.originalFile = iFile;
			addTextEdits();
			identyfyAndRemoveChangingItemFromCompositePOM(iFile);
		}

	}

	private void addTextEdits() {
		if (ARTIFACT_XML_FILE.equalsIgnoreCase(metaDataFile.getName())) {
			try {
				identifyReplaces();
			} catch (IOException e) {
				log.error("Error occurred while generating the Refactoring", e);
			}
		}
	}
	
	private void identyfyAndRemoveChangingItemFromCompositePOM(IFile changingFile) {
	    
	    try {
	        String changingFileName = changingFile.getName().substring(0, changingFile.getName().lastIndexOf('.'));
	        IFile pomIFile = changingFile.getProject().getFile("pom.xml");
	        pomIFile.refreshLocal(0, new NullProgressMonitor());
	        File pomFile = pomIFile.getLocation().toFile();
            MavenProject mvnProject = MavenUtils.getMavenProject(pomFile);
            String[] sections = changingFile.getFullPath().toOSString().split(File.separator);
            String artifactType = sections[sections.length - 2];
            if (artifactType.equalsIgnoreCase("local-entries")) {
                artifactType = "local-entry";
            } else if (!artifactType.equalsIgnoreCase("api") 
                    && !artifactType.equalsIgnoreCase("metadata")) {
                artifactType = artifactType.substring(0, artifactType.length() - 1);
            }
            String chandingFileGroupId = mvnProject.getGroupId() + "." + artifactType;
            
            IWorkspace workspace = ResourcesPlugin.getPlugin().getWorkspace();
            IProject [] projects = workspace.getRoot().getProjects();
            for (IProject project : projects) {
                if (project.hasNature(Constants.DISTRIBUTION_PROJECT_NATURE)) {
                    IFile compositePOMIFile = project.getFile("pom.xml");
                    compositePOMIFile.refreshLocal(0, new NullProgressMonitor());
                    File compositePOMFile = compositePOMIFile.getLocation().toFile();
                    MavenProject compositeMvnProject = MavenUtils.getMavenProject(compositePOMFile);
                    List<Dependency> dependencies = compositeMvnProject.getDependencies();
                    int dependencyIndex = -1;
                    for (int x = 0; x < dependencies.size(); x++) {
                        if (dependencies.get(x).getGroupId().equalsIgnoreCase(chandingFileGroupId) 
                                && dependencies.get(x).getArtifactId().equalsIgnoreCase(changingFileName)) {
                            dependencyIndex = x;
                            break;
                        }
                    }
                    if (dependencyIndex != -1) {
                        dependencies.remove(dependencyIndex);
                        compositeMvnProject.getProperties().remove(chandingFileGroupId.concat("_._").concat(changingFileName));
                        compositeMvnProject.setDependencies(dependencies);
                        MavenUtils.saveMavenProject(compositeMvnProject, compositePOMFile);
                    }
                }
            }
        } catch (Exception e) {
            //ignore
        } 
	}

	private void identifyReplaces() throws IOException {
		String artifactsStart = "<artifacts>";
		String artifactsEnd = "</artifacts>";
		String artifactStart = "<artifact";
		String artifactEnd = "</artifact>";
		String nameProperty = "name=\"";

		List<String> artifactEntry = new ArrayList<String>();
		boolean isArtifact = false;
		boolean isArtifacts = false;
		boolean isArtifactMatch = false;
		boolean isArtifactLine=false;

		int fullIndex = 0;
		int startIndex = 0;
		int spaceCount = 0;
		BufferedReader reader =
		                        new BufferedReader(new FileReader(metaDataFile.getLocation()
		                                                                      .toFile()));
		String line = reader.readLine();
		String fileName =
		                  originalFile.getName().substring(0,
		                                                   originalFile.getName().length() -
		                                                       originalFile.getFileExtension()
		                                                                   .length() - 1);
		while (line != null) {
			if (!isArtifacts && line.contains(artifactsStart)) {
				isArtifacts = true;
			}

			if (isArtifacts && line.contains(artifactsEnd)) {
				isArtifacts = false;
			}

			if (isArtifacts) {
				isArtifactLine = false;
				if (!isArtifact && line.trim().contains(artifactStart)) {
					int artifactTagIndex = line.indexOf(artifactStart);
					spaceCount = 0;
					for (int stringIndex = artifactTagIndex - 1; stringIndex >= 0; stringIndex--) {
						if (line.charAt(stringIndex) == ' ') {
							spaceCount++;
						} else {
							break;
						}
					}
					startIndex = fullIndex + artifactTagIndex - spaceCount;
					if (line.contains(nameProperty + fileName + "\"")) {
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
					addEdit(new DeleteEdit(startIndex, length + spaceCount));
					break;
				}

			}

			fullIndex += charsOnTheLine(line);
			line = reader.readLine();
		}
		reader.close();
	}

	private int charsOnTheLine(String line) {
		// Here we need to add one to represent the newline character
		String lineModified = line
				+ System.getProperty(LINE_SEPERATOR_PROPERTY);
		return lineModified.length();
	}

}

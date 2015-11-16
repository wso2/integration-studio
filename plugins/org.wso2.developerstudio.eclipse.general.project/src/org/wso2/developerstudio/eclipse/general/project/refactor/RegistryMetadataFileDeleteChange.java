/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.general.project.refactor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.DeleteEdit;
import org.eclipse.text.edits.MultiTextEdit;
import org.wso2.developerstudio.eclipse.general.project.Activator;
import org.wso2.developerstudio.eclipse.general.project.artifact.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.RegistryArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryCollection;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryDump;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryElement;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryItem;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;

public class RegistryMetadataFileDeleteChange extends  TextFileChange {
	IDeveloperStudioLog log= Logger.getLog(Activator.PLUGIN_ID);
	
	private IFile metaDataFile;
	private IResource originalResource;
	private String artifactName;
	private RegistryArtifactType artifactType;
	private boolean hasMultiple;

	public RegistryMetadataFileDeleteChange(String name, IFile file, IResource originalResource) {
		super(name, file);
		metaDataFile = file;
		this.originalResource = originalResource;

		addTextEdits();
	}

	private void addTextEdits() {
		if (metaDataFile.getName().equalsIgnoreCase("artifact.xml")) {
			setEdit(new MultiTextEdit());
			try {
				extractArtifactName();
				identifyReplaces();
			} catch (IOException e) {
				log.error("Error occured while generating the Refactoring", e);
			}
		}
	}
	
	private void extractArtifactName(){
		GeneralProjectArtifact artifact=new GeneralProjectArtifact();
		boolean hasFound=false;
		try {
			artifact.fromFile(metaDataFile.getLocation().toFile());
			
			List<RegistryArtifact> allArtifacts = artifact.getAllArtifacts();
			for (RegistryArtifact registryArtifact : allArtifacts) {
				List<RegistryElement> allRegistryItems = registryArtifact.getAllRegistryItems();
				for (RegistryElement registryElement : allRegistryItems) {
					if (registryElement instanceof RegistryItem) {
						String file = ((RegistryItem) registryElement).getFile();
						String fileName=file;
						if (file
									.lastIndexOf("/") != -1) {
							fileName = file.substring(file
									.lastIndexOf("/") + 1);
						}

						if(fileName.equalsIgnoreCase(getFileDeletedFileName())){
							artifactName=registryArtifact.getName();
							hasFound=true;
							if(allRegistryItems.size()>1){
								hasMultiple=true;
							}
							artifactType=RegistryArtifactType.Resource;
							break;
						}
					}else if(registryElement instanceof RegistryCollection){
						String directory = ((RegistryCollection) registryElement).getDirectory();
						String directoryName=directory;
						if (directory.lastIndexOf("/") != -1) {
							directoryName = directory
									.substring(directory
											.lastIndexOf("/") + 1);
						}
						if(directoryName.equalsIgnoreCase(getFileDeletedFileName())){
							artifactName=registryArtifact.getName();
							if(allRegistryItems.size()>1){
								hasMultiple=true;
							}
							artifactType=RegistryArtifactType.Collection;
							hasFound=true;
							break;
						}
					}else{
						String file = ((RegistryDump) registryElement).getFile();
						String fileName=file;
						if (file
									.lastIndexOf("/") != -1) {
							fileName = file.substring(file
									.lastIndexOf("/") + 1);
						}
						if (fileName.lastIndexOf(".")!= -1) {
							fileName = fileName.substring(0,
									fileName.lastIndexOf("."));
						}
						if(fileName.equalsIgnoreCase(getFileDeletedFileName())){
							artifactName=registryArtifact.getName();
							if(allRegistryItems.size()>1){
								hasMultiple=true;
							}
							artifactType=RegistryArtifactType.Resource;
							hasFound=true;
							break;
						}
					}
				}
				
				if(hasFound){
					break;
				}
			}
		} catch (FactoryConfigurationError e) {
			log.error("Error occured while parsing the Registry metadata file", e);
		} catch (Exception e) {
			log.error("Error occured while extracting Artifact Name for the registry resource "+e.getMessage(), e);
		}
		
	}

	private void identifyReplaces() throws IOException {
		String artifactsStart = "<artifacts>";
		String artifactsEnd = "</artifacts>";
		String artifactStart = "<artifact";
		String artifactEnd = "</artifact>";
		String nameProperty = "name=\"";
		String versionProperty = "version=\"";
		String itemStart = "<item>";
		String itemEnd = "</item>";
		String collectionStart = "<collection>";
		String collectionEnd = "</collection>";
		String resourceFileStart="<file>";
		String resourceFileEnd="</file>";
		String collectionDirectoryStart="<directory>";
		String collectionDirectoryEnd="</directory>";

		List<String> artifactEntry = new ArrayList<String>();
		boolean isArtifact = false;
		boolean isArtifacts = false;
		boolean isArtifactMatch = false;
		boolean isArtifactLine=false;
		boolean isItem=false;
		boolean isCollection=false;
		boolean isElementLine=false;
		boolean isElementMatch=false;

		int fullIndex = 0;
		int startIndex = 0;
		FileReader fileReader = new FileReader(metaDataFile.getLocation()
		                                              .toFile());
		BufferedReader reader =
		                        new BufferedReader(fileReader);
		String line = reader.readLine();
		while (line != null) {
			if (!isArtifacts && line.contains(artifactsStart)) {
				isArtifacts = true;
			}

			if (isArtifacts && line.contains(artifactsEnd)) {
				isArtifacts = false;
			}

			if (isArtifacts) {
				isArtifactLine=false;
				if (!isArtifact && line.trim().startsWith(artifactStart)) {
					int artifactTagIndex = line.indexOf(artifactStart);
					startIndex = fullIndex + artifactTagIndex;
					if (line.contains(nameProperty + artifactName + "\"")) {
						isArtifact = true;
						artifactEntry.add(line.substring(artifactTagIndex));
						isArtifactLine=true;
					} else {
						isArtifact = false;
						artifactEntry.clear();
						startIndex = 0;
					}
				}

				if (isArtifact) {
					if (artifactType==RegistryArtifactType.Resource) {
						if (line.trim().startsWith(itemStart)) {
							isItem = true;
							isElementLine=true;
							if(hasMultiple){
								int itemStartIndex = line.indexOf(itemStart);
								startIndex=fullIndex+itemStartIndex;
								artifactEntry.add(line.substring(itemStartIndex));
							}else{
								artifactEntry.add(line);
							}
						} else if (line.trim().startsWith(itemEnd)) {
							isItem = false;
							isElementLine=true;
							if (isElementMatch) {
								artifactEntry.add(line);
							}
						}else{
							isElementLine=false;
							if (!isArtifactLine) {
								artifactEntry.add(line);
							}
						}
						
					}else{
						if (line.trim().startsWith(collectionStart)) {
							isCollection = true;
							isElementLine=true;
							if(hasMultiple){
								int itemStartIndex = line.indexOf(collectionStart);
								startIndex=fullIndex+itemStartIndex;
								artifactEntry.add(line.substring(itemStartIndex));
							}else{
								artifactEntry.add(line);
							}
						} else if (line.trim().startsWith(collectionEnd)) {
							isCollection = false;
							isElementLine=true;
							if (isElementMatch) {
								artifactEntry.add(line);
							}
						}else{ 
							isElementLine=false;
							if (!isArtifactLine) {
								artifactEntry.add(line);
							}
						}
					}
					
					if(!isElementLine && isItem){
						if(line.trim().startsWith(resourceFileStart)){
							int itemStartIndex = line.indexOf(resourceFileStart);
							String filePath=line.substring(itemStartIndex+resourceFileStart.length(), line.indexOf(resourceFileEnd));
							String relPath = FileUtils.getRelativePath(metaDataFile.getProject().getLocation().toFile(), originalResource.getLocation().toFile());
							String relPathModified = relPath.replace(File.separator, "/"); // we have to do this since in the artifact.xml file it is listed as  <file>folder1/rr1.xml</file> format
							if(relPathModified.equalsIgnoreCase(filePath)){
								isElementMatch=true;
							}else{
								isElementMatch=false;
								startIndex=0;
							}
						}
					}
					
					if(!isElementLine && isCollection){
						if(line.trim().startsWith(collectionDirectoryStart)){
							int itemStartIndex = line.indexOf(collectionDirectoryStart);
							String filePath=line.substring(itemStartIndex+collectionDirectoryStart.length(), line.indexOf(collectionDirectoryEnd));
							if(FileUtils.getRelativePath(metaDataFile.getProject().getLocation().toFile(), originalResource.getLocation().toFile()).equalsIgnoreCase(filePath)){
								isElementMatch=true;
							}else{
								isElementMatch=false;
								startIndex=0;
							}
						}
					}
					
					if(hasMultiple && !isElementLine && !isElementMatch){
						artifactEntry.clear();
					}
					
					if(hasMultiple && isElementMatch && isElementLine){
						int length = 0;
						for (String string : artifactEntry) {
							length += charsOnTheLine(string);
						}
						addEdit(new DeleteEdit(startIndex, length));
						break;
					}
					
					if (!isArtifactLine && !hasMultiple && !artifactEntry.contains(line)) {
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
		fileReader.close();
		reader.close();
	}

	private String getFileDeletedFileName() {
		return originalResource.getName();
	}

	private int charsOnTheLine(String line) {
		// Here we need to add one to represent the newline character
		line+=System.getProperty( "line.separator" );
		return line.length();
	}
}
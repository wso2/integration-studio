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

import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.wso2.developerstudio.eclipse.general.project.Activator;
import org.wso2.developerstudio.eclipse.general.project.utils.GeneralProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class RegistryMetadataFileChange extends TextFileChange  {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	private IFile metaDataFile;
	private String newName;
	private IResource originalName;
	private RegistryArtifactType type;

	public RegistryMetadataFileChange(String name, IFile file,IResource originalName, String newName, RegistryArtifactType type) {
	    super(name, file);
		metaDataFile = file;
		this.originalName=originalName;
		this.newName=newName;
		this.type=type;

		addTextEdits();
    }
	
	private void addTextEdits() {
		if (metaDataFile.getName().equalsIgnoreCase("artifact.xml")) {
			setEdit(new MultiTextEdit());
			try {
	            identifyReplaces();
            } catch (IOException e) {
	            log.error("Error occured while trying to generate the refactoring", e);
            }
		}
	}
	
	// Here we implement the logic to identify the places to be replaced
	private void identifyReplaces() throws IOException {
		int fullIndex = 0;
		FileReader fileReader = new FileReader(metaDataFile.getLocation()
		                                              .toFile());
		BufferedReader reader =
		                        new BufferedReader(fileReader);
		String case1String = null;
		String originalResourceName = originalName.getName();
		String originalFileNameWOExt=GeneralProjectUtils.getFilenameWOExtension(originalResourceName);
		String newFileNameWOExt=GeneralProjectUtils.getFilenameWOExtension(newName);
		if (originalName instanceof IFile) {
			case1String = "\"" + originalFileNameWOExt + "\"";
		}else if(originalName instanceof IFolder){
			case1String = "\"" + originalResourceName+ "\"";
		}
		String nameElement = "name=";
		String line = reader.readLine();
		String case2String = originalResourceName;
		while (line != null) {
//				There can be only 2 occurrences. Pls have a look below.
//			    <artifact name="proxy1" version="1.0.0" type="synapse/proxy-service" serverRole="EnterpriseServiceBus">
//		        <file>src/main/synapse-config/proxy-services/proxy1.xml</file>
//		        </artifact>
			String[] stringArray = line.split(" ");
			if(line.contains(case1String) && stringArray[getarrayIndexWithString(nameElement, stringArray)].equals(nameElement+case1String)){
				//CASE 1 => <artifact name="proxy1" version="1.0.0" type="synapse/proxy-service" serverRole="EnterpriseServiceBus">
				//Swapping 1 element for "\""
				int case1LineIndex = line.indexOf(case1String)+1;
				addEdit(new ReplaceEdit(fullIndex+case1LineIndex,  originalFileNameWOExt.length(), newFileNameWOExt));
			} else {
	            if(type==RegistryArtifactType.Resource && line.contains(case2String) && line.endsWith(originalResourceName+"</file>")){
	            	//CASE 2 => <file>src/main/synapse-config/proxy-services/proxy1.xml</file>
	            	int case2LineIndex=line.indexOf(case2String);
	            	addEdit(new ReplaceEdit(fullIndex+case2LineIndex, originalResourceName.length(), newName));
	            	
	            } else {
					String directoryStart = "<directory>";
					String directoryEnd = "</directory>";
					if(type==RegistryArtifactType.Collection && line.trim().startsWith(directoryStart) && line.contains(case2String) && line.endsWith(originalResourceName+directoryEnd)){
						
						int directoryStartIndex = line.indexOf(directoryStart)+directoryStart.length();
						String directoryString = line.substring(directoryStartIndex, line.indexOf(directoryEnd));
						String[] array = directoryString.split(Pattern.quote(File.separator));
						int case2LineIndex=line.subSequence(0, directoryStartIndex).length()+generateString(array).length()+array[array.length-1].indexOf(case2String);
						addEdit(new ReplaceEdit(fullIndex+case2LineIndex, originalResourceName.length(), newName));
						
					} else {
						String pathStart = "<path>";
						String pathEnd = "</path>";
						if(type==RegistryArtifactType.Collection && line.trim().startsWith(pathStart) && line.contains(case2String) && line.endsWith(originalResourceName+pathEnd)){
							
							int pathStartIndex = line.indexOf(pathStart)+pathStart.length();
							String directoryString = line.substring(pathStartIndex, line.indexOf(pathEnd));
							String[] array = directoryString.split("/");
							int case2LineIndex=line.subSequence(0, pathStartIndex).length()+generateString(array).length()+array[array.length-1].indexOf(case2String);
							addEdit(new ReplaceEdit(fullIndex+case2LineIndex, originalResourceName.length(), newName));
						}
					}
				}
            }
			fullIndex+=charsOnTheLine(line);
			line = reader.readLine();
		}
		fileReader.close();
		reader.close();
	}
	
	private int charsOnTheLine(String line){
		//Here we need to add one to represent the newline character
		line+=System.getProperty( "line.separator" );
		return line.length();
	}
	
	private String generateString(String[] array){
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < array.length-1; i++) {
				sb.append(array[i]).append("/");
		}
		return sb.toString();
	}
	
	private int getarrayIndexWithString(String stringToSearch, String[] array){
		int index=0;
		for (String string : array) {
	        if(string.contains(stringToSearch)){
	        	return index;
	        }
	        index++;
        }
		return -1;
	}

}

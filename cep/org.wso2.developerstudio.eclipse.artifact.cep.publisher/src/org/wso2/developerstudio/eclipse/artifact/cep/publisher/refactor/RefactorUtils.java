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

package org.wso2.developerstudio.eclipse.artifact.cep.publisher.refactor;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.stream.FactoryConfigurationError;

import org.apache.commons.io.FilenameUtils;
import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.wso2.developerstudio.eclipse.artifact.cep.publisher.Activator;
import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPArtifact;
import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPProjectArtifact;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class RefactorUtils {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public static Dependency getDependencyForTheProject(IFile file) {
		IProject project=file.getProject();
		MavenProject mavenProject = getMavenProject(project);

		String groupId = mavenProject.getGroupId();
		String artifactId = mavenProject.getArtifactId();
		String version = mavenProject.getVersion();
		
		String filePath = file.getLocation().toOSString();
		int startIndex = (project.getLocation().toOSString()+File.separator+"src"+File.separator+"main"+File.separator).length();
		int endIndex = filePath.lastIndexOf(File.separator);
		
		String typeString;

		String typeStringFromPath = filePath.substring(startIndex,endIndex);
			if(typeStringFromPath.equalsIgnoreCase("execution-plan")){
				typeString="execution-plan";
			}else if(typeStringFromPath.equalsIgnoreCase("publisher")){
				typeString="publisher";
			}else if(typeStringFromPath.equalsIgnoreCase("receiver")){
				typeString="receiver";
			}else{
				typeString="stream";
			}	
		Dependency dependency = new Dependency();
		dependency.setGroupId(groupId+"."+typeString);
		dependency.setArtifactId(artifactId);
		dependency.setVersion(version);

		return dependency;
	}

	public static MavenProject getMavenProject(IProject project) {
		try {
			return MavenUtils.getMavenProject(project.getFile("pom.xml").getLocation().toFile());
		} catch (Exception e) {
			log.error("Failed to retrive the maven project for the given project", e);
		}
		return null;
	}

	public static boolean isDependenciesEqual(Dependency source, Dependency target) {
		return (source.getGroupId().equalsIgnoreCase(target.getGroupId()) &&
		        source.getArtifactId().equalsIgnoreCase(target.getArtifactId()) && source.getVersion()
		                                                                                 .equalsIgnoreCase(target.getVersion()));
	}
	
	public static int charsOnTheLine(String line) {
		// Here we need to add one to represent the newline character
		return line.length()+1;
	}
	
	public static CEPArtifact getCEPArtifactFromFile(IFile refactoredFile, String projectNatureFilter){
		IProject cepProject = refactoredFile.getProject();
		try {
			cepProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			
			if(cepProject.isOpen() && cepProject.hasNature(projectNatureFilter)){
				
				CEPProjectArtifact cepProjectArtifact = new CEPProjectArtifact();
					cepProjectArtifact.fromFile(cepProject.getFile("artifact.xml")
							.getLocation().toFile());
					List<CEPArtifact> allCEPArtifacts = cepProjectArtifact.getAllCEPArtifacts();
					
					String originalFileRelativePath = FileUtils.getRelativePath(cepProject.getLocation()
							.toFile(), refactoredFile.getLocation().toFile()).replaceAll(Pattern.quote(File.separator), "/");
					
					for (CEPArtifact cepArtifact : allCEPArtifacts) {
						if(cepArtifact.getFile().equals(originalFileRelativePath)){
							return cepArtifact;
						}
					}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String getFilenameWOExtension(String filename){
		String fileNameWOExt=null;
		if(FilenameUtils.indexOfExtension(filename)==-1){
			fileNameWOExt=filename;
		}else{
			fileNameWOExt=FilenameUtils.removeExtension(filename);
		}
		return fileNameWOExt;
	}
	
	public static String getFilenameExtension(String filename){
		String fileNameExt="";
		if(FilenameUtils.indexOfExtension(filename) != -1){
			fileNameExt=FilenameUtils.getExtension(filename);
		}
		return fileNameExt;
	}

}

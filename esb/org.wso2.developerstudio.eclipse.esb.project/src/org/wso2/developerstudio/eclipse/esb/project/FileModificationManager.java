/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.esb.project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseEntryType;
import org.wso2.developerstudio.eclipse.esb.project.artifact.Artifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.xml.sax.SAXException;


public class FileModificationManager implements IResourceChangeListener {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private IFolder folder;
	private IProject iProject;
	private String parentFolder = "synapse-config";
	private String path = "src/main/synapse-config/";
	
	protected int INTERESTING_CHANGES = IResourceDelta.CONTENT | 
										IResourceDelta.MOVED_FROM | 
										IResourceDelta.MOVED_TO	| 
										IResourceDelta.REPLACED;
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		try {
			          
			event.getDelta().accept(new IResourceDeltaVisitor() {
				public boolean visit(IResourceDelta delta) {
					IResource resource = delta.getResource();
					if (resource.getType() == IResource.ROOT) {
						return true;
					}else if (resource.getType() == IResource.PROJECT) {
						iProject  = (IProject)resource;

						try {
							if(iProject.hasNature("org.wso2.developerstudio.eclipse.esb.project.nature")){
								return true;								
								
							}
						} catch (CoreException e) {
							 log.error(e);
							 return false;
						}
						return false;
					}else if (resource.getType() == IResource.FILE) {
					     if (delta.getKind() == IResourceDelta.ADDED) {
					    	
							 try {
								 
						    	 IFile file  = (IFile)resource;
								 IPath location = file.getLocation();
								 IPath removeLastSegments = location.removeLastSegments(2);
								 String lastSegment = removeLastSegments.lastSegment();
								 
						    	 if(parentFolder.equals(lastSegment)){
						    		 
								 File arifact = iProject.getFile("artifact.xml").getLocation().toFile();
								 ESBProjectArtifact artifact = new ESBProjectArtifact();
																 
								 artifact.fromFile(arifact);
								 List<ESBArtifact> allESBArtifacts = artifact.getAllESBArtifacts();
								 ESBArtifact esbTempartifact=null;
								 for (ESBArtifact esbartifact : allESBArtifacts) {
									 String name = esbartifact.getName()+".xml";
									 if(name.equals(file.getName())){
										 return true;
									 }
									 esbTempartifact = esbartifact;
								  }
								 String version ="1.0.0";
								 String type = "synapse/"+getLocalTagName(folder.getName());
								 String groupId ="com.example.esb";
								 String name =file.getName().split("\\.")[0];
								 
								 if(esbTempartifact==null){
									 File pomLocation = iProject.getFile("pom.xml").getLocation().toFile();
									 MavenProject mavenProject = MavenUtils.getMavenProject(pomLocation);
									 version =mavenProject.getVersion();
									 groupId =mavenProject.getGroupId();
								 }else{
									 version =esbTempartifact.getVersion();
									 groupId =esbTempartifact.getGroupId();
								 }
								 								 
								 ESBArtifact esbArtifact = new ESBArtifact();
								 esbArtifact.setName(name);
								 esbArtifact.setVersion(version);
								 esbArtifact.setType(type);
								 esbArtifact.setServerRole("EnterpriseServiceBus");
								 esbArtifact.setGroupId(groupId);
								 esbArtifact.setFile(path+folder.getName()+"/"+file.getName());
								 artifact.addESBArtifact(esbArtifact);
								 artifact.toFile();

						    	 }

							} catch (Exception e) {
								log.error(e);
								return false;
							}
							return true;
						}  
					     return false;
					} else if (resource.getType() == IResource.FOLDER) {
						 folder = (IFolder)resource;
						 
						return true;
					}
					return false;
					 
				}
			});

		} catch (CoreException e) {
			log.error(e);
		}
		
	}

	private static String getLocalTagName(String type) {
		switch (type) {
		case "endpoints":
			return "endpoint";
		case "sequences":
			return "sequence";
		case "proxys":
			return "proxy";
		case "localEntrys":
			return "localEntry";
		case "tasks":
			return "task";
		case "apis":
			return "api";
		case "templates":
			return "template";
		case "messageStores":
			return "messageStore";
		case "messageProcessors":
			return "messageProcessor";	
		default:
			return "";
		}
	}
}

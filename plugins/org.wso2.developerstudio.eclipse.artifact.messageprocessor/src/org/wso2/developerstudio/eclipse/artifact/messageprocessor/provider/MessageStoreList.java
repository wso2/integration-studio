/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.messageprocessor.provider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.wso2.developerstudio.eclipse.artifact.messageprocessor.Activator;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;


public class MessageStoreList extends AbstractListDataProvider{
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	@Override
	public List<ListData> getListData(String modelProperty,ProjectDataModel model) {
		
		List<ListData> availableMessageStoreList = new ArrayList<ListData>();
		
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject workspaceProject : projects) {
			
				try {
					if (workspaceProject.isOpen() && workspaceProject.hasNature("org.wso2.developerstudio.eclipse.esb.project.nature")) {
					
 						
 						ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
 						try {
							esbProjectArtifact.fromFile(workspaceProject.getFile("artifact.xml").getLocation().toFile());
							
 							List<ESBArtifact> allESBArtifacts = esbProjectArtifact.getAllESBArtifacts();
 							for (ESBArtifact esbArtifact : allESBArtifacts) {
 								if(esbArtifact.getType().equals("synapse/message-store")){
 									String relativeFilePath = esbArtifact.getFile().replaceAll("/", (File.separatorChar=='/')?"/":"\\\\");
 									String fileName = new File((relativeFilePath)).getName().replaceAll(".xml$", "");
									availableMessageStoreList.add(createListData(fileName,fileName));
 								}
 							}
 						}
 						
 						catch (Exception e) {

 		 				} 
					}
				}
					catch (Exception e) {
 		 					log.error("Error occured while scanning the workspace for Message-Store artifacts", e);
 		 				} 
 					}
 		 		
 				return availableMessageStoreList;
 		 	}
 		 
 		 }
/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.sequence.validators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.artifact.sequence.Activator;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.RegistryArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryElement;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryItem;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class AvailableEPList extends AbstractListDataProvider {

	private static final String SYNAPSE_ENDPOINT_CAPP_TYPE = "synapse/endpoint";
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static List<String> skipList = new ArrayList<String>();

	static {
		skipList.add("target");
		skipList.add(".svn");
	}

	public List<ListData> getListData(String modelProperty, ProjectDataModel model) {
		List<ListData> list = new ArrayList<ListData>();
		list.add(createListData("", ""));
		try {
			List<String> availabledynamicEP = getAvailableDynamicEP();
			for (String filename : availabledynamicEP) {
				list.add(createListData(ProjectUtils.fileNameWithoutExtension(filename), filename));
			}
			List<File> availablestaticEP = getAvailableStaticEP();
			for (File file : availablestaticEP) {
				list.add(createListData(ProjectUtils.fileNameWithoutExtension(file.getName()), file));
			}
		} catch (CoreException e) {
			log.error("An unexpected error has occurred", e);
		} catch (IOException e) {
			log.error("I/O error has occurred", e);
		}
		return list;
	}

	public List getAvailableDynamicEP() throws CoreException, IOException {

		List<String> availableEPList = new ArrayList<String>();
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject workspaceProject : projects) {
			if (workspaceProject.isOpen() &&
			    workspaceProject.hasNature("org.wso2.developerstudio.eclipse.general.project.nature")) {
				GeneralProjectArtifact generalProjectArtifact = new GeneralProjectArtifact();
				try {
					generalProjectArtifact.fromFile(workspaceProject.getFile("artifact.xml").getLocation().toFile());
					List<RegistryArtifact> allGREGArtifacts = generalProjectArtifact.getAllArtifacts();
					for (RegistryArtifact registryArtifact : allGREGArtifacts) {
						if (registryArtifact.getType().equals("registry/resource")) {
							java.util.List<RegistryElement> elements = registryArtifact.getAllRegistryItems();
							for (RegistryElement registryElement : elements) {
								if (registryElement instanceof RegistryItem) {
									String mediaType = ((RegistryItem) registryElement).getMediaType();
									if (mediaType.equals("application/vnd.wso2.esb.endpoint")) {
										String path =
										              ((RegistryItem) registryElement).getPath() + "/" +
										                      ((RegistryItem) registryElement).getFile();
										if (path.startsWith("/_system/governance/")) {
											path =
											       String.format("gov:%s",
											                     path.substring("/_system/governance/".length()));
										} else if (path.startsWith("/_system/config/")) {
											path =
											       String.format("conf:%s", path.substring("/_system/config/".length()));
										}
										availableEPList.add(path);
									}
								}
							}
						}
					}
				} catch (Exception e) {
					log.error("Error occured while scanning the workspace for Sequence artifacts", e);
				}
			}

		}
		return availableEPList;
	}

	public List<File> getAvailableStaticEP() throws CoreException, IOException {

		List<File> availableEPList = new ArrayList<File>();
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject workspaceProject : projects) {
			if (workspaceProject.isOpen() &&
			    workspaceProject.hasNature("org.wso2.developerstudio.eclipse.esb.project.nature")) {
				ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
				File projectPath = workspaceProject.getLocation().toFile();
				try {
					esbProjectArtifact.fromFile(workspaceProject.getFile("artifact.xml").getLocation().toFile());
					List<ESBArtifact> allESBArtifacts = esbProjectArtifact.getAllESBArtifacts();
					for (ESBArtifact esbArtifact : allESBArtifacts) {
						if (esbArtifact.getType().equals(SYNAPSE_ENDPOINT_CAPP_TYPE)) {
							String relativeFilePath =
							                          esbArtifact.getFile()
							                                     .replaceAll("/",
							                                                 (File.separatorChar == '/') ? "/" : "\\\\");
							availableEPList.add(new File(projectPath, relativeFilePath));
						}
					}
				} catch (Exception e) {
					log.error("Error occured while scanning the workspace for Sequence artifacts", e);
				}
			}
		}
		return availableEPList;
	}
}

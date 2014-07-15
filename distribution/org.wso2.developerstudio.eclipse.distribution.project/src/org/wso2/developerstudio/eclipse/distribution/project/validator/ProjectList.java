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

package org.wso2.developerstudio.eclipse.distribution.project.validator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.wso2.developerstudio.eclipse.distribution.project.Activator;
import org.wso2.developerstudio.eclipse.distribution.project.model.DependencyData;
import org.wso2.developerstudio.eclipse.distribution.project.util.ArtifactTypeMapping;
import org.wso2.developerstudio.eclipse.distribution.project.util.DistProjectUtils;
import org.wso2.developerstudio.eclipse.distribution.project.util.ServerRoleMapping;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;

public class ProjectList extends AbstractListDataProvider {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	public List<ListData> getListData(String modelProperty,ProjectDataModel model) {
		List<ListData> list = new ArrayList<ListData>();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject[] projects = root.getProjects();
		for (IProject project : projects) {
			try{
				if(project.isOpen()){
					if(project.hasNature(Constants.AXIS2_PROJECT_NATURE) ||
					   project.hasNature(Constants.BPEL_PROJECT_NATURE) ||
					   project.hasNature(Constants.DS_PROJECT_NATURE) ||
					   project.hasNature(Constants.DS_VALIDATOR_PROJECT_NATURE) ||
					   project.hasNature(Constants.ESB_PROJECT_NATURE) ||
					   project.hasNature(Constants.JAXWS_PROJECT_NATURE) ||
					   project.hasNature(Constants.JAXRS_PROJECT_NATURE) ||
					   project.hasNature(Constants.WEBAPP_PROJECT_NATURE) ||
					   project.hasNature(Constants.GADGET_PROJECT_NATURE) ||
					   project.hasNature(Constants.LIBRARY_PROJECT_NATURE) ||
					   project.hasNature(Constants.MEDIATOR_PROJECT_NATURE) ||
					   project.hasNature(Constants.REGISTRY_FILTER_PROJECT_NATURE) ||
					   project.hasNature(Constants.REGISTRY_HANDLER_PROJECT_NATURE) ||
					   project.hasNature(Constants.GENERAL_PROJECT_NATURE) ||
					   project.hasNature(Constants.CARBON_UI_PROJECT_NATURE)||
					   project.hasNature(Constants.CEP_PROJECT_NATURE)||
					   project.hasNature(Constants.BRS_PROJECT_NATURE)||
					   project.hasNature(Constants.JAGGERY_NATURE)||
					   project.hasNature(Constants.SERVICE_META_PROJECT_NATURE)){
						try {
							if (project.hasNature(Constants.ESB_PROJECT_NATURE) || project.hasNature(Constants.GENERAL_PROJECT_NATURE)) {
								IFile artifactXMLFile = project.getFile(Constants.ARTIFACT_XML);
								
								MavenProject mavenProject= DistProjectUtils.getMavenProject(project);
									
								if (artifactXMLFile.exists()) {
									ESBProjectArtifact artifactXMLDoc = new ESBProjectArtifact();
									try {
										artifactXMLDoc.fromFile(artifactXMLFile.getLocation().toFile());
										List<ESBArtifact> artifacts = artifactXMLDoc.getAllESBArtifacts();
										for (ESBArtifact artifact : artifacts) {
											Dependency dependency = new Dependency();
											dependency.setArtifactId(artifact.getName());
											if(artifact.getGroupId()!=null && !artifact.getGroupId().trim().isEmpty()){
												dependency.setGroupId(artifact.getGroupId());
											} else{
												dependency.setGroupId(mavenProject.getGroupId());
											}
											dependency.setVersion(artifact.getVersion());
										//	dependency.setVersion(mavenProject.getModel().getVersion()); //referring parent version
											dependency.setType(ArtifactTypeMapping.getType(artifact.getType()));
											
											DependencyData dependencyData = new DependencyData();
											dependencyData.setDependency(dependency);
											dependencyData.setParent(project);
											dependencyData.setSelf(artifact.getFile());
											if(("synapse/sequenceTemplate".equals(artifact.getType()))||("synapse/endpointTemplate".equals(artifact.getType()))){
												dependencyData.setCApptype("synapse/template");
											}else {
												dependencyData.setCApptype(artifact.getType());
											}
											
											dependencyData.setServerRole("capp/"+ artifact.getServerRole());
											list.add(createListData(
													DistProjectUtils
															.getArtifactInfoAsString(dependency,project.getName()),
															dependencyData));
										}
									} catch (FactoryConfigurationError ignored) {
										// ignored
									}
								}
							} else {
								String cAppType = "";
								MavenProject mavenProject = DistProjectUtils.getMavenProject(project);
								Dependency dependency = new Dependency();
								dependency.setArtifactId(mavenProject.getArtifactId());
								dependency.setGroupId(mavenProject.getGroupId());
								dependency.setVersion(mavenProject.getVersion());
								cAppType = mavenProject.getModel().getPackaging();
								if(cAppType==null || !ArtifactTypeMapping.isValidArtifactType(cAppType)) {
									if(mavenProject.getModel().getProperties().containsKey("CApp.type")) {
										cAppType = (String) mavenProject
												.getModel().getProperties()
												.get("CApp.type");
									}
								}
								dependency.setType(ArtifactTypeMapping.getType(cAppType));
								String serverRole = ServerRoleMapping.getServerRole(cAppType);
								
								DependencyData dependencyData = new DependencyData();
								dependencyData.setDependency(dependency);
								dependencyData.setSelf(project);
								dependencyData.setCApptype(cAppType);
								
								if(!"".equals(serverRole)) {
									dependencyData.setServerRole("capp/"+ serverRole);
									} else {
										dependencyData.setServerRole("capp/ApplicationServer");
									}
								
								list.add(createListData(DistProjectUtils
										.getArtifactInfoAsString(dependency),
										dependencyData));
							}
						} catch (Exception ignored) {
							// ignored
						}
				}
			}
			} catch (Exception e) {
				log.error("Error reading project list", e);
			}
		}
		return list;
	}
	
}

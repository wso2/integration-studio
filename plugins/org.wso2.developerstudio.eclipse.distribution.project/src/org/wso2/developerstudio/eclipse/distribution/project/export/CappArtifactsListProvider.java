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

package org.wso2.developerstudio.eclipse.distribution.project.export;

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
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.distribution.project.model.DependencyData;
import org.wso2.developerstudio.eclipse.distribution.project.model.GeneralArtifact;
import org.wso2.developerstudio.eclipse.distribution.project.model.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.distribution.project.util.ArtifactTypeMapping;
import org.wso2.developerstudio.eclipse.distribution.project.util.DistProjectUtils;
import org.wso2.developerstudio.eclipse.distribution.project.util.ServerRoleMapping;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider.ListData;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;

public class CappArtifactsListProvider extends AbstractListDataProvider{
	
	public List<ListData> getArtifactsListForCappExport() throws Exception {
		
		List<ListData> list = new ArrayList<ListData>();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject[] projects = root.getProjects();
				
		for (IProject project : projects) {
			if (project.isOpen() && isDevStudioSupportedProject(project)) {
				list.addAll(getArtifactsListForCappExport(project));
			}
		}
		
		return list;
	}
	
	public List<ListData> getArtifactsListForCappExport(IProject project) throws Exception{
		
		List<ListData> artifactsList = new ArrayList<ListData>();
		if (isMultipleArtifactProject(project)) {
			artifactsList.addAll(getArtifactsListForMultipleArtifactsProject(project));
		} else {
			artifactsList.addAll(getArtifactsListForSingleArtifactProject(project));
		}
		return artifactsList;
	}
	
	
	public List<ListData> getArtifactsListForMultipleArtifactsProject(IProject project) throws Exception {
		
		MavenProject mavenProject = DistProjectUtils.getMavenProject(project);
		List<ListData> projectArtifactsList = new ArrayList<ListData>();
		IFile artifactXMLFile = project.getFile(Constants.ARTIFACT_XML);
		if (artifactXMLFile.exists()) {
			GeneralProjectArtifact artifactXMLDoc = new GeneralProjectArtifact();
			artifactXMLDoc.fromFile(artifactXMLFile.getLocation().toFile());
			List<GeneralArtifact> artifacts = artifactXMLDoc.getAllESBArtifacts();
			for (GeneralArtifact artifact : artifacts) {
				projectArtifactsList.add(getListDataForArtifact(project, mavenProject, artifact));
			}
		}
		return projectArtifactsList;
	}

	public List<ListData> getArtifactsListForSingleArtifactProject(IProject project)	throws Exception {
		MavenProject mavenProject = DistProjectUtils.getMavenProject(project);
		ArtifactTypeMapping artifactTypeMapping = new ArtifactTypeMapping();
		List<ListData> singleProjectArtifactAsAList = new ArrayList<ListData>();
		Dependency dependency = new Dependency();
		dependency.setArtifactId(mavenProject.getArtifactId());
		dependency.setGroupId(mavenProject.getGroupId());
		dependency.setVersion(mavenProject.getVersion());
		String cAppType = mavenProject.getModel().getPackaging();
		if (cAppType == null || !artifactTypeMapping.isValidArtifactType(cAppType)) {
			if (mavenProject.getModel().getProperties().containsKey("CApp.type")) {
				cAppType = (String) mavenProject.getModel().getProperties().get("CApp.type");
			}
		}
		
		dependency.setType(artifactTypeMapping.getType(cAppType));
		ServerRoleMapping serverRoleMapping = new ServerRoleMapping();
		String serverRole = serverRoleMapping.getServerRole(cAppType);

		DependencyData dependencyData = new DependencyData();
		dependencyData.setDependency(dependency);
		dependencyData.setSelf(project);
		dependencyData.setCApptype(cAppType);
		dependencyData.setServerRole(getServerRole(serverRole));

		singleProjectArtifactAsAList.add(createListData(DistProjectUtils.getArtifactInfoAsString(dependency), dependencyData));
		return singleProjectArtifactAsAList;
	}

	private ListData getListDataForArtifact(IProject project, MavenProject mavenProject, GeneralArtifact artifact) {
		
		ListData artifactListData;
		ArtifactTypeMapping artifactTypeMapping = new ArtifactTypeMapping();
		Dependency dependency = new Dependency();
		dependency.setArtifactId(artifact.getName());
		if (artifact.getGroupId() != null && !artifact.getGroupId().trim().isEmpty()) {
			dependency.setGroupId(artifact.getGroupId());
		} else {
			dependency.setGroupId(mavenProject.getGroupId());
		}
		dependency.setVersion(artifact.getVersion());
		dependency.setType(artifactTypeMapping.getType(artifact.getType()));

		// Following artifact types should be changed to common template artifact type
		String artifactType;
		if ((Constants.SEQUENCE_TEMPLATE_TYPE.equals(artifact.getType()))
				|| (Constants.ENDPOINT_TEMPLATE_TYPE.equals(artifact.getType()))) {
			artifactType = Constants.COMMON_TEMPLATE_TYPE;
		} else {
			artifactType = artifact.getType();
		}

		DependencyData dependencyData = new DependencyData();
		dependencyData.setDependency(dependency);
		dependencyData.setParent(project);
		dependencyData.setSelf(artifact.getFile());
		dependencyData.setCApptype(artifactType);
		dependencyData.setServerRole(Constants.CAPP_PREFIX + artifact.getServerRole());
		artifactListData = createListData(DistProjectUtils.getArtifactInfoAsString(dependency, project.getName()), dependencyData);
		
		return artifactListData;
	}
	
	private boolean isMultipleArtifactDSSProject(IProject project) throws CoreException {
		return project.hasNature(Constants.DS_PROJECT_NATURE) &&
		       (project.getFile(Constants.ARTIFACT_XML) != null && project.getFile(Constants.ARTIFACT_XML).exists());
	}
	
	
	
	private boolean isMultipleArtifactProject(IProject project) {
		try {
			if (project.hasNature(Constants.ESB_PROJECT_NATURE)
				|| project.hasNature(Constants.GENERAL_PROJECT_NATURE)
			    || isMultipleArtifactDSSProject(project) 
			    || project.hasNature(Constants.CONNECTOR_PROJECT_NATURE)
			    || project.hasNature(Constants.ANALYTICS_PROJECT_NATURE)){
				return true;
			}
		} catch (CoreException e) {
		}
		return false;
	}
	
	private String getServerRole(String serverRole) {
		if (!"".equals(serverRole)) {
			return "capp/" + serverRole;
		} else {
			return"capp/ApplicationServer";
		}
	}


	@Override
	public List<ListData> getListData(String modelProperty, ProjectDataModel model) {
		return null;
	}
	
	private boolean isDevStudioSupportedProject(IProject project) {
		
		try {
			if (project.hasNature(Constants.AXIS2_PROJECT_NATURE)
				|| project.hasNature(Constants.BPEL_PROJECT_NATURE)
				|| project.hasNature(Constants.DS_PROJECT_NATURE)
				|| project.hasNature(Constants.DS_VALIDATOR_PROJECT_NATURE)
				|| project.hasNature(Constants.ESB_PROJECT_NATURE)
				|| project.hasNature(Constants.JAXWS_PROJECT_NATURE)
				|| project.hasNature(Constants.JAXRS_PROJECT_NATURE)
				|| project.hasNature(Constants.WEBAPP_PROJECT_NATURE)
				|| project.hasNature(Constants.GADGET_PROJECT_NATURE)
				|| project.hasNature(Constants.LIBRARY_PROJECT_NATURE)
				|| project.hasNature(Constants.MEDIATOR_PROJECT_NATURE)
				|| project.hasNature(Constants.REGISTRY_FILTER_PROJECT_NATURE)
				|| project.hasNature(Constants.REGISTRY_HANDLER_PROJECT_NATURE)
				|| project.hasNature(Constants.GENERAL_PROJECT_NATURE)
				|| project.hasNature(Constants.CARBON_UI_PROJECT_NATURE)
				|| project.hasNature(Constants.ANALYTICS_PROJECT_NATURE)
				|| project.hasNature(Constants.BRS_PROJECT_NATURE)
				|| project.hasNature(Constants.JAGGERY_NATURE)
				|| project.hasNature(Constants.SERVICE_META_PROJECT_NATURE)
				|| project.hasNature(Constants.CONNECTOR_PROJECT_NATURE)){
					return true;
				}
		} catch (CoreException e) {
			
		} 
		return false;
	}
	
}

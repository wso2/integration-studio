/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.capp.core.artifacts.manager;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.IArtifactSourcePath;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.ICAppArtifactHandler;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.configure.ICAppProjectSettings;
import org.wso2.developerstudio.eclipse.capp.core.manifest.Artifact;

public interface ICAppArtifactManager {

	public void init();
	
	public List<ICAppArtifactHandler> getArtifactHandlers();
	
	public void createDefaultArtifactPaths(IProject project);

	public void createArtifactPath(IProject project, String artifactId, IFolder newArtifactFolder) throws Exception;
	
	public ICAppProjectSettings getProjectSettings(IProject project);
	
	public List<Artifact> getArtifacts(IProject project);
	
	public Map<Artifact, IFolder> getArtifactList(IProject project);
	
	public boolean isFolderAnArtifactPath(IFolder folder);
	
	public boolean isCAppProject(IProject project);
	
	public List<IArtifactSourcePath> getArtifactPaths(IProject project, String artifactId);
	
	public ICAppArtifactHandler getArtifactHandler(String artifactId);
	
	public void createDefaultArtifactPaths(IProject project, List<ICAppArtifactHandler> artifactHandlers);
	
	public IServerRole[] getServerRoles(IProject project);
	
	public void addServerRole(IProject project, IServerRole serverRole);
	
	public void removeServerRole(IProject project, IServerRole serverRole);
	
	public boolean isServerRolePresent(IProject project, IServerRole serverRole);
	
	public boolean isServerRolePresent(IProject project, String serverRoleName);
	
	public void createArtifact(IFile file, Artifact artifact, File otherDataLocation) throws CoreException, IOException, Exception;
	
	public void createArtifact(IFile file, Artifact artifact, File otherDataLocation, boolean openResource) throws CoreException, IOException, Exception;
	 	
	public void createArtifact(IFile file, Artifact artifact) throws CoreException, IOException, Exception;

	public void createSuperArtifact(IProject project, Artifact artifact) throws CoreException, IOException;
	
	public Artifact getSuperArtifact(IResource resource)throws CoreException, IOException;
	
	public IFile getSuperArtifactFile(IResource resource);
	
	public Artifact getArtifact(IFolder folder)throws CoreException, IOException;

	public Artifact getArtifact(IFile file)throws CoreException, IOException;
	
	public ICAppArtifactHandler getArtifactHandler(Artifact artifact);
	
    public boolean isArtifactSignatureAlreadyExists(Artifact artifact, IProject project);

	public boolean isArtifactSignatureAlreadyExists(IProject project, String artifactName, String artifactVersion);
	
	public Artifact getArtifact(String name, String version, IProject project);
	
	public Artifact getArtifact(String name, String version, List<Artifact> artifacts);
	
	public List<Artifact> getArtifacts(IProject project, IServerRole serverRole);
	
	public List<Artifact> getArtifacts(IProject project, String serverRoleName);
	
	public List<IServerRole> getDefaultServerRolesForArtifacts();
	
	public String getServerRoleDescription(String serverRoleName);
	
	public String getServerRoleDescription(IServerRole serverRole);
	
	public IFolder getCAppArtifactsLocation(IProject project);
	
	public IFile getCAppBuilderMavenProjectLocation(IProject project);
	
	public IFile getJarBuilderMavenProjectLocation(IProject eclipseProject);
	
	public IFile getCAppParentBuilderMavenProjectLocation(IProject eclipseProject);
}


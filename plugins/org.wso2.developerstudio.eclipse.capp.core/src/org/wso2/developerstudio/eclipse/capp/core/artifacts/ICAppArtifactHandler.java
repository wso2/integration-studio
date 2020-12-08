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

package org.wso2.developerstudio.eclipse.capp.core.artifacts;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.configure.ICAppProjectSettings;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.ICAppArtifactManager;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.IServerRole;
import org.wso2.developerstudio.eclipse.capp.core.manifest.Artifact;
import org.wso2.developerstudio.eclipse.capp.core.ui.wizard.AbstractNewArtifactWizard;

public interface ICAppArtifactHandler {
	public String getName();
	public String getDescription();
	public String getID();
	public String getArtifactType();
	public void createArtifactDefaultPath(IProject project, ICAppProjectSettings projectSettings) throws Exception;
	public void createArtifactPath(IFolder folder, ICAppProjectSettings projectSettings) throws Exception;
	public void deleteArtifactPath(IFolder folder, ICAppProjectSettings projectSettings) throws Exception;
	public void detachArtifactPath(IFolder folder, ICAppProjectSettings projectSettings) throws Exception;
	public IArtifactSourcePath[] getArtifactPathModelsForCAppProjectContent(IProject project,ICAppProjectSettings projectSettings)throws Exception;
	public boolean isFolderArtifactPath(IFolder folder, ICAppProjectSettings projectSettings)throws Exception;
	public void setArtifactManager(ICAppArtifactManager artifactManager);
	public IArtifact[] getDeployableArtifacts(ICAppProjectSettings projectSettings, Object artifactPathModel);
	public ImageDescriptor getArtifactImage();
	public ImageDescriptor getArtifactIcon();
	public ImageDescriptor getArtifactOverlayIcon();
	public File getBundle(File location, Artifact artifact, String parentApplication) throws Exception;
	public Map<Artifact,File> createArtifactContent(File location, Artifact artifact, File artifactContentLocation) throws Exception;
	public AbstractNewArtifactWizard getNewArtifactWizard(IStructuredSelection selection);
	public String getGroupID();
	public boolean isStratosEnabled();
	public String[] getPossibleDependentArtifactTypes();
	public String[] getPossibleDependencyArtifactTypes();
	public List<IServerRole> getSupportingServerRoles();
	public IServerRole getDefaultServerRole();
	public String getArtifactGroup();
	public String getArtifactGroup(Artifact artifact);
	public IResource getArtifactContentResource(Artifact artifact);
}

/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package org.wso2.developerstudio.eclipse.general.project.capp.refactor;

import java.util.Iterator;
import java.util.List;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.DeleteParticipant;
import org.wso2.developerstudio.eclipse.general.project.Activator;
import org.wso2.developerstudio.eclipse.general.project.refactor.MavenConfigurationFileDeleteChange;
import org.wso2.developerstudio.eclipse.general.project.refactor.RefactorUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class RegistryResourceArtifactDeleteParticipant extends DeleteParticipant {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private IResource originalResource;

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor arg0, CheckConditionsContext arg1)
			throws OperationCanceledException {
		return RefactoringStatus.createInfoStatus("Update CApp if it's referred");
	}

	@Override
	public Change createPreChange(IProgressMonitor arg0) throws CoreException, OperationCanceledException {

		CompositeChange deleteChange = new CompositeChange("Update CApp pom.xml");
		deleteFromPOM(deleteChange);
		return deleteChange;
	}

	private void deleteFromPOM(CompositeChange deleteChange) throws CoreException {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		IFile pomFile =null;
		for (IProject project : projects) {
			if (project.isOpen() && project.hasNature("org.wso2.developerstudio.eclipse.distribution.project.nature")) {
				try {
					  pomFile = project.getFile("pom.xml");
					try {
						pomFile.refreshLocal(0, new NullProgressMonitor());
					} catch (Exception ignore) {

					}
					MavenProject mavenProject = RefactorUtils.getMavenProject(project);
					Dependency projectDependency = RefactorUtils.getDependencyForTheProject(originalResource
							.getProject());
					if (originalResource instanceof IFile) {
						projectDependency
								.setArtifactId(originalResource.getName().substring(
										0,
										originalResource.getName().length()
												- originalResource.getFileExtension().length() - 1));
					} else {
						projectDependency.setArtifactId(originalResource.getName());
					}
					List<?> dependencies = mavenProject.getDependencies();
					for (Iterator<?> iterator = dependencies.iterator(); iterator.hasNext();) {
						Dependency dependency = (Dependency) iterator.next();
						if (RefactorUtils.isDependenciesEqual(projectDependency, dependency)) {
							deleteChange.add(new MavenConfigurationFileDeleteChange(project.getName(), pomFile,
									projectDependency));
						}
					}
					
				} catch (Exception e) {
					log.error("Error occurred while trying to generate the Refactoring", e);
				}finally{
					  try {
						   if (pomFile != null) {
							pomFile.refreshLocal(0, new NullProgressMonitor());
						   }
					 } catch (Exception ignore) {

					 }
			    }
			}
		}
	}


	@Override
	public String getName() {
		return "Registry Resource Deletion";
	}

	@Override
	protected boolean initialize(Object arg0) {
		if (arg0 instanceof IResource) {
			originalResource = (IResource) arg0;
			return true;
		}
		return false;
	}

	@Override
	public Change createChange(IProgressMonitor arg0) throws CoreException, OperationCanceledException {
		return null;
	}
}

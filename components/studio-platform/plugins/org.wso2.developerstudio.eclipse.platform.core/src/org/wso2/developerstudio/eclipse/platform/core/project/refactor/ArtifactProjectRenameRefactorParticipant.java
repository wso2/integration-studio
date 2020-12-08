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

package org.wso2.developerstudio.eclipse.platform.core.project.refactor;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameArguments;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.Activator;

import java.util.Iterator;
import java.util.List;

/***
 * This class is used to provide refactoring support for Artifact projects when
 * the projects are renamed.
 * For example when a project is renamed we need to change the name artifact ids
 * of the project pom as well as update distribution
 * projects referring that same project.
 * 
 */
public class ArtifactProjectRenameRefactorParticipant extends RenameParticipant {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private IProject originalProject;
	private String latestName;

	/**
	 * This method is used to check the pre-conditions for the refactoring.
	 * This method can be used to communicate with user about refactoring about
	 * to happen such as
	 * if there is an fatal issue related to refactoring, you can create a
	 * Status with Fatal error, or
	 * you can create a warning status where user can be informed.
	 */
	@Override
	public RefactoringStatus checkConditions(IProgressMonitor arg0, CheckConditionsContext arg1)
	                                                                                            throws OperationCanceledException {
		return RefactoringStatus.createWarningStatus("You are about to rename your project and configuration from " +
		                                             originalProject.getName() + " to " + latestName);
	}

	/**
	 * This method gets executed before the refactoring gets executed on
	 * original file which means
	 * this method is executed before the actual project is deleted from the
	 * workspace.
	 * If you have any task need to run before the project is deleted, you need
	 * to generate Changes
	 * for those tasks in this method.
	 */
	@Override
	public Change createPreChange(IProgressMonitor arg0) throws CoreException, OperationCanceledException {

		IFile pomFile = originalProject.getFile("pom.xml");

		CompositeChange artifactChange = new CompositeChange("Maven Configuration Refactor");

		MavenConfigurationFileChange endpointArtifactFileChange =
		                                                          new MavenConfigurationFileChange(
		                                                                                           "HW",
		                                                                                           pomFile,
		                                                                                           originalProject.getName(),
		                                                                                           originalProject,
		                                                                                           latestName);
		artifactChange.add(endpointArtifactFileChange);

		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();

		for (int i = 0; i < projects.length; i++) {
			if (projects[i].isOpen() &&
			    projects[i].hasNature("org.wso2.developerstudio.eclipse.distribution.project.nature")) {
				try {
					MavenProject mavenProject =
					                            MavenUtils.getMavenProject(projects[i].getFile("pom.xml").getLocation()
					                                                                  .toFile());
					List<?> dependencies = mavenProject.getDependencies();
					for (Iterator<?> iterator = dependencies.iterator(); iterator.hasNext();) {
						Dependency dependency = (Dependency) iterator.next();
						if (originalProject.getName().equalsIgnoreCase(dependency.getArtifactId())) {
							artifactChange.add(new MavenConfigurationFileChange(projects[i].getName(),
							                                                    projects[i].getFile("pom.xml"),
							                                                    originalProject.getName(), projects[i],
							                                                    latestName));
						}
					}
				} catch (Exception e) {
					log.error("Error occured while trying to generate the Refactoring", e);
				}
			}
		}

		return artifactChange;
	}

	@Override
	public String getName() {
		return "Refactor Maven Configurations";
	}

	@Override
	protected boolean initialize(Object arg0) {
		if (arg0 instanceof IProject) {
			originalProject = (IProject) arg0;
			RenameArguments arguments = getArguments();
			latestName = arguments.getNewName();
			return true;
		}
		return false;
	}

	/**
	 * This method gets executed after performing the actual refactoring task.
	 * Normally this method is used
	 * for clean up tasks.
	 */
	@Override
	public Change createChange(IProgressMonitor arg0) throws CoreException, OperationCanceledException {
		return null;
	}

}

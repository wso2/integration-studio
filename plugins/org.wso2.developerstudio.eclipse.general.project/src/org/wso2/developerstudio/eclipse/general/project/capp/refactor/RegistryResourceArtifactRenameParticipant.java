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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.wso2.developerstudio.eclipse.general.project.Activator;
import org.wso2.developerstudio.eclipse.general.project.refactor.MavenConfigurationFileRenameChange;
import org.wso2.developerstudio.eclipse.general.project.refactor.RefactorUtils;
import org.wso2.developerstudio.eclipse.general.project.utils.GeneralProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class RegistryResourceArtifactRenameParticipant extends RenameParticipant {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private IFile originalFile;
	private IFolder originalFolder;
	private String changedFileName;
	private String changedFolderName;
	private IProject registryProject;
	private static List<String> skipList;

	public RefactoringStatus checkConditions(IProgressMonitor arg0, CheckConditionsContext arg1)
			throws OperationCanceledException {
		if (originalFile != null || originalFolder != null) {
			List<String> matchinFilesList = new ArrayList<String>();
			skipList = new ArrayList<String>();
			skipList.add("target");
			skipList.add("bin");
			skipList.add(".svn");

			String fileName = null;
			String ext = "";

			if (originalFile != null) {

				fileName = GeneralProjectUtils.getFilenameWOExtension(changedFileName);
				ext = GeneralProjectUtils.getFilenameExtension(changedFileName);

				FileUtils.getAllExactMatchingFiles(registryProject.getLocation().toOSString(), fileName, ext,
						matchinFilesList, skipList);
			} else {
				FileUtils.getAllExactMatchingFiles(registryProject.getLocation().toOSString(), changedFolderName, null,
						matchinFilesList, skipList);
			}
			if (!matchinFilesList.isEmpty()) {
				if (changedFileName != null) {
					return RefactoringStatus
							.createFatalErrorStatus("A Registry Artifact already exist with the same name "
									+ changedFileName + " in the project " + registryProject.getName());
				} else {
					return RefactoringStatus
							.createFatalErrorStatus("A Registry Artifact already exist with the same name "
									+ changedFolderName + " in the project " + registryProject.getName());
				}
			} else if (changedFileName != null && registryProject.getName().equalsIgnoreCase(fileName)) {
				return RefactoringStatus
						.createFatalErrorStatus("You are trying to rename your Registry Artifact to have the project name.");
			} else if (changedFolderName != null && changedFolderName.equalsIgnoreCase(registryProject.getName())) {
				return RefactoringStatus
						.createFatalErrorStatus("You are trying to rename your Registry Artifact to have the project name.");
			}

			if (originalFile != null) {
				return RefactoringStatus.createInfoStatus("Update CApp if it's referred");
			} else {
				return RefactoringStatus.createInfoStatus("You are about the rename your Registry Artifact "
						+ originalFolder.getName() + " to " + changedFolderName);
			}
		}

		return RefactoringStatus
				.createFatalErrorStatus("You are trying to rename a different entity than a collection or a resource");
	}

	private void deleteFromPOM(CompositeChange deleteChange) throws CoreException {
		IFile pomFile=null;
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		String changedNameWithoutExtention = FilenameUtils.removeExtension(changedFileName);
		String originalNameWithoutExtension = FilenameUtils.removeExtension(originalFile.getName());
		for (IProject project : projects) {
			if (project.isOpen() && project.hasNature("org.wso2.developerstudio.eclipse.distribution.project.nature")) {
				try {
					  pomFile = project.getFile("pom.xml");
					try {
						pomFile.refreshLocal(0, new NullProgressMonitor());
					} catch (Exception ignore) {

					}
					MavenProject mavenProject = RefactorUtils.getMavenProject(project);
					Dependency projectDependency = RefactorUtils.getDependencyForTheProject(originalFile.getProject());
					if (originalFile instanceof IFile) {
						projectDependency.setArtifactId(originalFile.getName().substring(0,
								originalFile.getName().length() - originalFile.getFileExtension().length() - 1));
					} else {
						projectDependency.setArtifactId(originalFile.getName());
					}
					List<?> dependencies = mavenProject.getDependencies();
					for (Iterator<?> iterator = dependencies.iterator(); iterator.hasNext();) {
						Dependency dependency = (Dependency) iterator.next();
						if (RefactorUtils.isDependenciesEqual(projectDependency, dependency)) {
							deleteChange.add(new MavenConfigurationFileRenameChange("updateCapp", pomFile,
									originalNameWithoutExtension, project, changedNameWithoutExtention, dependency));
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

	public String getName() {
		return "RegistryResourceArtifactRename";
	}

	protected boolean initialize(Object arg0) {
		// Similar to check initial conditions

		if (arg0 instanceof IFile) {
			originalFile = (IFile) arg0;
			registryProject = originalFile.getProject();
			changedFileName = getArguments().getNewName();
			return true;
		} else if (arg0 instanceof IFolder) {
			originalFolder = (IFolder) arg0;
			registryProject = originalFolder.getProject();
			changedFolderName = getArguments().getNewName();
			return true;
		}
		return false;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		CompositeChange change = new CompositeChange("Update CApp references");
		deleteFromPOM(change);
		return change;
	}

}

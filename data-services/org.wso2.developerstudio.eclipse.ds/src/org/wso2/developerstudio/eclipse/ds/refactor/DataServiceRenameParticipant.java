/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.ds.refactor;


import org.apache.commons.io.FilenameUtils;
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
import org.wso2.developerstudio.eclipse.ds.Activator;
import org.wso2.developerstudio.eclipse.ds.util.Messages;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataServiceRenameParticipant extends RenameParticipant {
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	private static final String PARTICIPANT_NAME = "DataServiceRename"; //$NON-NLS-1$
	private static final String ARTIFACT_XML_FILE = "artifact.xml"; //$NON-NLS-1$
	private static final List<String> SKIP_LIST = Arrays.asList("target", "bin", ".svn", ".git"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

	private IFile originalFile;
	private String originalFileFullName;
	private String changedFileFullName;
	private IProject dsProject;

	public RefactoringStatus checkConditions(IProgressMonitor monitor, CheckConditionsContext context)
			throws OperationCanceledException {
		/*
		 * Conditions to check: Newly renamed file cannot already exist in the project. Renamed file cannot be equal to
		 * the project name itself (to avoid maven build issues).
		 */
		if (originalFile != null) {
			List<String> matchingFilesList = new ArrayList<>();
			String fileName = changedFileFullName.substring(0, changedFileFullName.lastIndexOf(".")); //$NON-NLS-1$
			String fileExtension = changedFileFullName.substring(changedFileFullName.lastIndexOf(".") + 1); //$NON-NLS-1$
			FileUtils.getAllExactMatchingFiles(dsProject.getLocation().toOSString(), fileName, fileExtension,
					matchingFilesList, SKIP_LIST);

			if (!matchingFilesList.isEmpty()) {
				return RefactoringStatus.createFatalErrorStatus("\"" + changedFileFullName + "\"" //$NON-NLS-1$ //$NON-NLS-2$
						+ Messages.DataServiceRenameParticipant_DuplicateFileName);
			} else if (fileName.equalsIgnoreCase(dsProject.getName())) {
				return RefactoringStatus
						.createFatalErrorStatus(Messages.DataServiceRenameParticipant_EqualsToProjectName);
			}

			return RefactoringStatus.createInfoStatus(Messages.DataServiceRenameParticipant_RenameWarning
					+ changedFileFullName);
		} else {
			return RefactoringStatus.createFatalErrorStatus(Messages.DataServiceRenameParticipant_InvalidResourceType);
		}
	}
	

	public Change createPreChange(IProgressMonitor arg0) throws CoreException, OperationCanceledException {
		CompositeChange change = new CompositeChange(Messages.DataServiceRenameParticipant_DataServiceChange);
		try {
			change.add(new DataServiceFileChange(Messages.DataServiceRenameParticipant_DataServiceChange, originalFile,
					originalFileFullName, changedFileFullName));
			
		} catch (IOException e) {
			throw new OperationCanceledException(Messages.DataServiceRenameParticipant_DataServiceRenameFailed);
		}
		return change;
	}

	public Change createChange(IProgressMonitor arg0) throws CoreException, OperationCanceledException {
		CompositeChange change = new CompositeChange(Messages.DataServiceRenameParticipant_MetaDataChange);

		IFile artifactFile = dsProject.getFile(ARTIFACT_XML_FILE);
		try {
			change.add(new DataServiceMetaDataFileChange(Messages.DataServiceRenameParticipant_MetaDataChange,
					artifactFile, originalFileFullName, changedFileFullName));
			deleteFromPOM(change);
		} catch (IOException e) {
			throw new OperationCanceledException(Messages.DataServiceRenameParticipant_ArtifactXmlRenameFailed);
		}
		return change;
	}

	
	private void deleteFromPOM(CompositeChange deleteChange) throws CoreException {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		String changedNameWithoutExtention = FilenameUtils.removeExtension(changedFileFullName);
		String originalNameWithoutExtension = FilenameUtils.removeExtension(originalFileFullName);
		for (IProject project : projects) {
			if (project.isOpen() && project.hasNature("org.wso2.developerstudio.eclipse.distribution.project.nature")) {
				try {
					IFile pomFile = project.getFile("pom.xml");
					MavenProject mavenProject = MavenUtils.getMavenProject(project.getFile("pom.xml").getLocation().toFile());
					Dependency projectDependency =getDependencyForTheProject(originalFile.getProject());
					if (originalFile instanceof IFile) {
						projectDependency.setArtifactId(originalFile.getName().substring(0,
								originalFile.getName().length() - originalFile.getFileExtension().length() - 1));
					} else {
						projectDependency.setArtifactId(originalFile.getName());
					}
					List<?> dependencies = mavenProject.getDependencies();
					for (Iterator<?> iterator = dependencies.iterator(); iterator.hasNext();) {
						Dependency dependency = (Dependency) iterator.next();
						if (isDependenciesEqual(projectDependency, dependency)) {
							deleteChange.add(new MavenConfigurationFileRenameChange("updateCapp",pomFile,
									originalNameWithoutExtension,project,changedNameWithoutExtention,dependency));
						}
					}
				} catch (Exception e) {
					log.error("Error occurred while trying to generate the Refactoring", e);
				}
			}
		}
	}
	
	
	 private Dependency getDependencyForTheProject(IProject project) throws Exception {
		   
		   MavenProject mavenProject =  MavenUtils.getMavenProject(project.getFile("pom.xml").getLocation().toFile());
		   Dependency dependency = new Dependency();			
			if (mavenProject != null) {
				dependency.setGroupId(mavenProject.getGroupId() + ".dataservice");
				dependency.setArtifactId(mavenProject.getArtifactId());
				dependency.setVersion(mavenProject.getVersion());
			}
			return dependency;
		}

		
	 private boolean isDependenciesEqual(Dependency source, Dependency target) {
			return (source.getGroupId().equalsIgnoreCase(target.getGroupId()) &&
			        source.getArtifactId().equalsIgnoreCase(target.getArtifactId()) && source.getVersion()
			                                                                                 .equalsIgnoreCase(target.getVersion()));
		}
	
	
	public String getName() {
		return PARTICIPANT_NAME;
	}

	protected boolean initialize(Object initObject) {
		if (initObject instanceof IFile) {
			originalFile = (IFile) initObject;
			originalFileFullName = originalFile.getName();
			dsProject = originalFile.getProject();

			RenameArguments arguments = getArguments();
			changedFileFullName = arguments.getNewName();

			return true;
		}
		return false;
	}
}
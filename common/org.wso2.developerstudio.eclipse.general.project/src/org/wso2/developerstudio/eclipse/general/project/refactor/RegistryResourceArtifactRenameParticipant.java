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

package org.wso2.developerstudio.eclipse.general.project.refactor;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.om.OMXMLParserWrapper;
import org.apache.commons.io.FilenameUtils;
import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.wso2.developerstudio.eclipse.general.project.Activator;
import org.wso2.developerstudio.eclipse.general.project.utils.GeneralProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RegistryResourceArtifactRenameParticipant extends RenameParticipant {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String ESB_EXTENSION = ".esb";
	private static final String ESB_DIAGRAM_EXTENSION = ".esb_diagram";
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
				return RefactoringStatus.createInfoStatus("You are about the rename your Registry Artifact "
						+ originalFile.getName() + " to " + changedFileName);
			} else {
				return RefactoringStatus.createInfoStatus("You are about the rename your Registry Artifact "
						+ originalFolder.getName() + " to " + changedFolderName);
			}
		}

		return RefactoringStatus
				.createFatalErrorStatus("You are trying to rename a different entity than a collection or a resource");
	}

	public Change createPreChange(IProgressMonitor arg0) throws CoreException, OperationCanceledException {

		String changedNameWithoutExtention = FilenameUtils.removeExtension(changedFileName);
		String originalNameWithoutExtension = FilenameUtils.removeExtension(originalFile.getName());
		String prefix = getDirectoryPrefix();
		String originalEsbFileName = getESBFilePath(originalNameWithoutExtension, false, prefix);
		String originalEsbDiagramFileName = getESBFilePath(originalNameWithoutExtension, true, prefix);
		String changedEsbFileName = getESBFilePath(changedNameWithoutExtention, false, prefix);
		String changedEsbDiagramFileName = getESBFilePath(changedNameWithoutExtention, true, prefix);

		CompositeChange change = new CompositeChange("Registry Artifact Rename & Update references");

		RegistryResourceArtifactFileChange registryResourceArtifactFileChange = new RegistryResourceArtifactFileChange(
				"Changing original file content " + originalNameWithoutExtension, originalFile,
				originalNameWithoutExtension, changedNameWithoutExtention);
		
		
		change.add(registryResourceArtifactFileChange);
		
		
		
	

		if (originalFile != null) {
			change.add(new RegistryMetadataFileChange("Meta data file", registryProject.getFile("artifact.xml"),
					originalFile, changedFileName, RegistryArtifactType.Resource));
		} else {
			change.add(new RegistryMetadataFileChange("Meta data file", registryProject.getFile("artifact.xml"),
					originalFolder, changedFolderName, RegistryArtifactType.Collection));
		}

		/*
		 * Rename artifact_<name>.esb and artifact_<name>.esb_diagram
		 */
		IFile esbIFile = originalFile.getParent().getFile(new Path(originalEsbFileName));
		if (esbIFile.exists()) {
			RegistryResourceEsbFileChange esbFileChange = new RegistryResourceEsbFileChange(
					"Changing ESB file content", esbIFile, originalNameWithoutExtension, changedNameWithoutExtention);
			change.add(esbFileChange);
			RegistryResourceEsbFileRename esbFileRename = new RegistryResourceEsbFileRename(esbIFile,
					changedEsbFileName);
			change.add(esbFileRename);
		}

		IFile esbDiagramIFile = originalFile.getParent().getFile(new Path(originalEsbDiagramFileName));
		if (esbDiagramIFile.exists()) {
			RegistryResourceEsbFileChange esbDiagramFileChange = new RegistryResourceEsbFileChange(
					"Changing ESB diagram file content", esbDiagramIFile, originalNameWithoutExtension,
					changedNameWithoutExtention);
			change.add(esbDiagramFileChange);
			RegistryResourceEsbFileRename esbDiagramFileRename = new RegistryResourceEsbFileRename(esbDiagramIFile,
					changedEsbDiagramFileName);
			change.add(esbDiagramFileRename);
		}

		return change;
	}

	private void deleteFromPOM(CompositeChange deleteChange) throws CoreException {
		
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		String changedNameWithoutExtention = FilenameUtils.removeExtension(changedFileName);
		String originalNameWithoutExtension = FilenameUtils.removeExtension(originalFile.getName());
		for (IProject project : projects) {
			if (project.isOpen() && project.hasNature("org.wso2.developerstudio.eclipse.distribution.project.nature")) {
				try {
					IFile pomFile = project.getFile("pom.xml");
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
				}
			}
		}
		
	}

	private String getESBFilePath(String filename, boolean isDiagram, String prefix) {
		if (isDiagram) {
			return prefix + filename + ESB_DIAGRAM_EXTENSION;
		}
		return prefix + filename + ESB_EXTENSION;
	}

	private String getDirectoryPrefix() {

		String directoryPrefix = "";
		InputStream in = null;

		try {
			in = originalFile.getContents(true);
			OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(in);
			OMElement documentElement = builder.getDocumentElement();
			directoryPrefix = documentElement.getLocalName() + "_";
		} catch (Exception e) {
			log.info("File contains non-XML content.");
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					log.error("Error occurred while trying to close resource stream", e);
				}
			}
		}

		return directoryPrefix;
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

		return null;
	}

}

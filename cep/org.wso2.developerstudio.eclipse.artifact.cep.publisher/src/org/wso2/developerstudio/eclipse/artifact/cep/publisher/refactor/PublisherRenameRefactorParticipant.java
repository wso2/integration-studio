/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.cep.publisher.refactor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.wso2.developerstudio.eclipse.artifact.cep.publisher.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;

public class PublisherRenameRefactorParticipant extends RenameParticipant {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private IFile originalFile;
	private String changedFileName;
	private IProject cepProject;
	private static List<String> skipList;
	protected final static String EDITOR_ID =
	                                          "org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor";

	static {
		skipList = new ArrayList<String>();
		skipList.add("target");
		skipList.add("bin");
		skipList.add(".svn");
	}

	public RefactoringStatus checkConditions(IProgressMonitor arg0, CheckConditionsContext arg1)
	                                                                                            throws OperationCanceledException {
		String fileName=null;
		String ext="";
		if (originalFile != null) {
			List<String> matchinFilesList = new ArrayList<String>();
			fileName = RefactorUtils.getFilenameWOExtension(changedFileName);
			ext = RefactorUtils.getFilenameExtension(changedFileName);

			org.wso2.developerstudio.eclipse.utils.file.FileUtils.getAllExactMatchingFiles(cepProject.getLocation()
			                                                                                         .toOSString(),fileName,
			                                                                              ext,matchinFilesList,
			                                                                               skipList);

			if (!matchinFilesList.isEmpty()) {
				return RefactoringStatus.createFatalErrorStatus("An CEP Artifact already exists with the same name " +
				                                                changedFileName +
				                                                " in the project " +
				                                                cepProject.getName());
			} else if (cepProject.getName().equalsIgnoreCase(fileName)) {
				return RefactoringStatus.createFatalErrorStatus("You are trying to rename your CEP Artifact to have the project name.");
			}

			return RefactoringStatus.createInfoStatus("You are about to rename your CEP Artifact " +
			                                          originalFile.getName() + " to " +
			                                          changedFileName);
		}

		return RefactoringStatus.createFatalErrorStatus("You are trying to rename a different resource than a file");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant#
	 * createPreChange(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public Change createPreChange(IProgressMonitor arg0) throws CoreException,
	                                                    OperationCanceledException {

		String changedNameWithoutExtention = FilenameUtils.removeExtension(changedFileName);
		String originalNameWithoutExtension = FilenameUtils.removeExtension(originalFile.getName());
		CompositeChange compositeChange = new CompositeChange("CEP Artifact Rename");

		// Change content of the original file
		PublisherArtifactFileChange publisherArtifactFileChange =
		                                                        new PublisherArtifactFileChange(
		                                                                                       "Renaming CEP Artifact " +
		                                                                                               originalNameWithoutExtension,
		                                                                                       originalFile,
		                                                                                       originalNameWithoutExtension,
		                                                                                       changedNameWithoutExtention);
		compositeChange.add(publisherArtifactFileChange);

		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (int i = 0; i < projects.length; i++) {
			if (projects[i].isOpen() &&
			    projects[i].hasNature("org.wso2.developerstudio.eclipse.distribution.project.nature")) {
				try {
					MavenProject mavenProject =
					                            MavenUtils.getMavenProject(projects[i].getFile("pom.xml")
					                                                                  .getLocation()
					                                                                  .toFile());
					List<?> dependencies = mavenProject.getDependencies();
					for (Iterator<?> iterator = dependencies.iterator(); iterator.hasNext();) {
						Dependency dependency = (Dependency) iterator.next();
						if (originalNameWithoutExtension.equalsIgnoreCase(dependency.getArtifactId())) {
							compositeChange.add(new MavenConfigurationFileChange(
							                                                     projects[i].getName(),
							                                                     projects[i].getFile("pom.xml"),
							                                                     originalNameWithoutExtension,
							                                                     projects[i],
							                                                     changedNameWithoutExtention));
						}
					}
				} catch (Exception e) {
					log.error("Error occured while trying to generate the Refactoring.", e);
				}
			}
		}

		return compositeChange;
	}

	public String getName() {
		return "PublisherArtifactRenameParticipant";
	}

	protected boolean initialize(Object arg0) {
		if (arg0 instanceof IFile) {
			originalFile = (IFile) arg0;
			cepProject = originalFile.getProject();
			changedFileName = getArguments().getNewName();
			return true;
		}
		return false;
	}

	@Override
	public Change createChange(IProgressMonitor arg0) throws CoreException,
	                                                 OperationCanceledException {
		return null;
	}

}

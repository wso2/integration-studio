/*
*  Copyright (c) 2005-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.developerstudio.eclipse.artifact.analytics.publisher.refactor;

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
import org.wso2.developerstudio.eclipse.artifact.analytics.publisher.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class CommonRenameRefactorParticipant extends RenameParticipant {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private IFile originalFile;
	private String changedFileName;
	private IProject analyticsProject;
	private static List<String> skipList;
	
	static {
		skipList = new ArrayList<String>();
		skipList.add("target");
		skipList.add("bin");
		skipList.add(".svn");
	}

	public RefactoringStatus checkConditions(IProgressMonitor arg0, CheckConditionsContext arg1)throws OperationCanceledException {
		String fileName=null;
		String extention="";
		if (originalFile != null) {
			List<String> matchinFilesList = new ArrayList<String>();
			fileName = RefactorUtils.getFilenameWOExtension(changedFileName);
			extention = RefactorUtils.getFilenameExtension(changedFileName);

			FileUtils.getAllExactMatchingFiles(analyticsProject.getLocation().toOSString(),fileName,extention,matchinFilesList,skipList);

			if (!matchinFilesList.isEmpty()) {
				return RefactoringStatus.createFatalErrorStatus("An Analytics Artifact already exists with the same name "
						+ changedFileName +" in the project " + analyticsProject.getName());
			} else if (analyticsProject.getName().equalsIgnoreCase(fileName)) {
				return RefactoringStatus.createFatalErrorStatus("You are trying to rename your Analytics Artifact to have the project name.");
			}

			return RefactoringStatus.createInfoStatus("You are about to rename your Analytics Artifact " + originalFile.getName() + " to " + changedFileName);
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
		CompositeChange compositeChange = new CompositeChange("Analytics Artifact Rename");

		// Change content of the original file
		CommonArtifactFileChange artifactFileChange = new CommonArtifactFileChange("Renaming Analytics Artifact " + 
				originalNameWithoutExtension,originalFile,originalNameWithoutExtension,changedNameWithoutExtention);
		compositeChange.add(artifactFileChange);

		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (int i = 0; i < projects.length; i++) {
			if (projects[i].isOpen() &&
			    projects[i].hasNature("org.wso2.developerstudio.eclipse.distribution.project.nature")) {
				try {
					MavenProject mavenProject = MavenUtils.getMavenProject(projects[i].getFile("pom.xml").getLocation().toFile());
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
		return "Analytics Artifact Rename Participant";
	}

	protected boolean initialize(Object arg0) {
		if (arg0 instanceof IFile) {
			originalFile = (IFile) arg0;
			analyticsProject = originalFile.getProject();
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

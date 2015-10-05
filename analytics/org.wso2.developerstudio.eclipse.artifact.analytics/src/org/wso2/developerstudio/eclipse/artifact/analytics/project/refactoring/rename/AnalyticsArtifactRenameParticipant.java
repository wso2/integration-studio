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

package org.wso2.developerstudio.eclipse.artifact.analytics.project.refactoring.rename;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameArguments;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class AnalyticsArtifactRenameParticipant extends RenameParticipant {
	private IFile originalFile;
	private String changedFileName;
	private IProject analyticsProject;
	private static List<String> skipList;

	
	public RefactoringStatus checkConditions(IProgressMonitor arg0, CheckConditionsContext arg1)
	                                                                                            throws OperationCanceledException {
		// Conditions to check
		
		// 1. Newly renamed file cannot already exist in the project
		// 2. Renamed file cannot be equal to the project name itself (to avoid
		// maven build issues)

		if (originalFile != null) {
			List<String> matchinFilesList = new ArrayList<String>();			
			skipList=new ArrayList<String>();
			skipList.add("target");
			skipList.add("bin");
			skipList.add(".svn");
			
			FileUtils.getAllExactMatchingFiles(analyticsProject.getLocation().toOSString(),
			                                   changedFileName.substring(0,
			                                                             changedFileName.lastIndexOf(".")),
			                                   changedFileName.substring(changedFileName.lastIndexOf(".") + 1),
			                                   matchinFilesList,skipList);

			if (!matchinFilesList.isEmpty()) {
				return RefactoringStatus.createFatalErrorStatus("An Analytics Artifact already exist with the same name " +
				                                                changedFileName +
				                                                " in the project " +
				                                                analyticsProject.getName());
			} else if (changedFileName.substring(0, changedFileName.lastIndexOf("."))
			                          .equalsIgnoreCase(analyticsProject.getName())) {
				return RefactoringStatus.createFatalErrorStatus("Rename does not get effect as the new and old names of the your Analytics Artifact is same.");
			}

			return RefactoringStatus.createInfoStatus("You are about the rename your Analytics Artifact " +
			                                          originalFile.getName() +
			                                          " to " +
			                                          changedFileName);
		}

		return RefactoringStatus.createFatalErrorStatus("You are trying to rename a different resource than a file");
	}
	
	

	
	public Change createChange(IProgressMonitor arg0) throws CoreException,
	                                                 OperationCanceledException {
		CompositeChange change=new CompositeChange("Analytics Artifact Model Rename");
		String originalFileName = originalFile.getName();
		String extension = originalFile.getFileExtension();
		IFile artifactFile = analyticsProject.getFile("artifact.xml");
		change.add(new AnalyticsMetaDataFileChange("Meta data file", artifactFile, originalFileName, changedFileName,extension));
		return change;
	}

	
	public String getName() {
		return "AnalyticsArtifactRename";
	}

	
	protected boolean initialize(Object arg0) {
		// Similar to check initial conditions

		if (arg0 instanceof IFile) {
			originalFile = (IFile) arg0;
			analyticsProject = originalFile.getProject();
			RenameArguments arguments = getArguments();
			changedFileName = arguments.getNewName();
			return true;
		}
		return false;
	}

}

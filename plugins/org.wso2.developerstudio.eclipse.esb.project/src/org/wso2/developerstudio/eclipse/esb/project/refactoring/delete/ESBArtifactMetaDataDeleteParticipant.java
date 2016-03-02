/*
 * Copyright (c) 2012-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.esb.project.refactoring.delete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.DeleteParticipant;

public class ESBArtifactMetaDataDeleteParticipant extends DeleteParticipant {
	
	
	private static final String UPDATE_ESB_META_DATA_MODEL_STATUS_MESSAGE = "Update ESB meta-data model";
	private static final String ARTIFACT_XML_FILE = "artifact.xml";
	private static final String ESB_APRTIFACT_DELETE_CHANGE_OBJECT_NAME = "ESB Artifact Delete";
	private static final String UPDATE_ARTIFACT_XML_CHANGE_OBJECT_NAME = "Update arifact.xml";
	private IFile originalFile;
	private static int numOfFiles;
	private static int currentFileNum;
	private static Map<IProject, List<IFile>> changeFileList;
	private static List<IProject> projectList;

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor progressMonitor,
			CheckConditionsContext context) throws OperationCanceledException {
		return RefactoringStatus
				.createInfoStatus(UPDATE_ESB_META_DATA_MODEL_STATUS_MESSAGE);
	}

	@Override
	public Change createChange(IProgressMonitor progressMonitor)
			throws CoreException, OperationCanceledException {
		CompositeChange emptychange = new CompositeChange(
				ESB_APRTIFACT_DELETE_CHANGE_OBJECT_NAME);
		currentFileNum++;
		if (numOfFiles == currentFileNum) {
			CompositeChange change = new CompositeChange(
					UPDATE_ARTIFACT_XML_CHANGE_OBJECT_NAME);
			for (IProject project : projectList) {
				List<IFile> fileList = changeFileList.get(project);
				change.add(new ESBMetaDataFileDeleteChange(project.getName(),
						project.getFile(ARTIFACT_XML_FILE), fileList));
			}
			resetStaticVariables();
			return change;
		}
		return emptychange;
	}

	private void resetStaticVariables() {
		changeFileList.clear();
		projectList.clear();
		numOfFiles = 0;
		currentFileNum = 0;
	}

	@Override
	public String getName() {
		return "ESBArtifactDelete";
	}

	@Override
	protected boolean initialize(Object file) {
		if (file instanceof IFile) {
			numOfFiles++;
			originalFile = (IFile) file;
			if (numOfFiles == 1) {
				List<IFile> fileList = new ArrayList<>();
				projectList = new ArrayList<>();
				changeFileList = new HashMap<IProject, List<IFile>>();
				fileList.add(originalFile);
				projectList.add(originalFile.getProject());
				changeFileList.put(originalFile.getProject(), fileList);
			} else {
				if (changeFileList.containsKey(originalFile.getProject())) {
					changeFileList.get(originalFile.getProject()).add(
							originalFile);
				} else {
					List<IFile> fileList = new ArrayList<>();
					fileList.add(originalFile);
					projectList.add(originalFile.getProject());
					changeFileList.put(originalFile.getProject(), fileList);
				}
			}
			return true;
		}
		return false;
	}

}

/*
 * Copyright (c) 2012-2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import org.eclipse.ltk.core.refactoring.participants.ISharableParticipant;
import org.eclipse.ltk.core.refactoring.participants.RefactoringArguments;
import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class ESBArtifactMetaDataDeleteParticipant extends DeleteParticipant implements ISharableParticipant {

	private static final String COMPOSITE_MESSAGE = "Update arifact.xml of ESB projects.";
	private static final String PRE_MESSAGE = "Update ESB meta-data model";
	private static final String PARTICIPANT_NAME = "ESBArtifactDelete";
	private static final String ARTIFACT_XML = "artifact.xml";

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	protected List<IFile> listOfFilesToBeRemoved;

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor arg0, CheckConditionsContext arg1)
			throws OperationCanceledException {
		return RefactoringStatus.createInfoStatus(PRE_MESSAGE);
	}

	@Override
	public Change createChange(IProgressMonitor arg0) throws CoreException, OperationCanceledException {

		Map<IProject, List<IFile>> artifactsByProject = new HashMap<IProject, List<IFile>>();
		for (IFile artifact : listOfFilesToBeRemoved) {
			if (!artifactsByProject.containsKey(artifact.getProject())) {
				artifactsByProject.put(artifact.getProject(), new ArrayList<IFile>());
			}
			artifactsByProject.get(artifact.getProject()).add(artifact);
		}

		if (!artifactsByProject.isEmpty()) {
			CompositeChange change = new CompositeChange(COMPOSITE_MESSAGE);
			Iterator<Entry<IProject, List<IFile>>> iterator = artifactsByProject.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<IProject, List<IFile>> next = iterator.next();
				change.add(new ESBMetaDataFileDeleteChange(next.getKey().getName(), next.getKey().getFile(ARTIFACT_XML),
						next.getValue()));
			}
			return change;
		}
		return null;
	}

	@Override
	public String getName() {
		return PARTICIPANT_NAME;
	}

	@Override
	protected boolean initialize(Object artifact) {
		if (artifact instanceof IFile) {
			if (listOfFilesToBeRemoved == null) {
				listOfFilesToBeRemoved = new ArrayList<IFile>();
			}
			listOfFilesToBeRemoved.add((IFile) artifact);
			return true;
		}
		return false;
	}

	@Override
	public void addElement(Object artifact, RefactoringArguments arguments) {
		if (artifact instanceof IFile) {
			if (listOfFilesToBeRemoved == null) {
				listOfFilesToBeRemoved = new ArrayList<IFile>();
			}
			listOfFilesToBeRemoved.add((IFile) artifact);
		}
	}
}
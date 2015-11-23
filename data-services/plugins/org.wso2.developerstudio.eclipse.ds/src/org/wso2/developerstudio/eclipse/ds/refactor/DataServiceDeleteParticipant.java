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

import java.io.IOException;

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
import org.wso2.developerstudio.eclipse.ds.Activator;
import org.wso2.developerstudio.eclipse.ds.util.Messages;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;


public class DataServiceDeleteParticipant extends DeleteParticipant {
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	private static final String PARTICIPANT_NAME = "DataServiceDelete"; //$NON-NLS-1$
	private static final String ARTIFACT_XML_FILE = "artifact.xml"; //$NON-NLS-1$

	private String originalFileFullName;
	private IProject dsProject;
	private IFile originalFile;

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor arg0, CheckConditionsContext arg1)
			throws OperationCanceledException {
		return RefactoringStatus.createInfoStatus("Update Data Service meta-data model");
	}

	@Override
	public String getName() {
		return PARTICIPANT_NAME;
	}

	@Override
	protected boolean initialize(Object initObject) {
		if (initObject instanceof IFile) {
			originalFile = (IFile) initObject;
			originalFileFullName = originalFile.getName();
			dsProject = originalFile.getProject();
			 
			return true;
		}
		return false;
	}

	@Override
	public Change createPreChange(IProgressMonitor arg0) throws CoreException, OperationCanceledException {
		CompositeChange change = new CompositeChange(Messages.DataServiceDeleteParticipant_DataServiceDelete);
		IFile artifactFile = dsProject.getFile(ARTIFACT_XML_FILE);
		try {
			change.add(new DataServiceMetaDataFileDeleteChange(Messages.DataServiceRenameParticipant_MetaDataChange,
					artifactFile, originalFileFullName));
			
		} catch (IOException e) {
			throw new OperationCanceledException(Messages.DataServiceDeleteParticipant_ArtifactXmlDeleteChangeFailed);
		}
		return change;
	}
	
@Override
public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
	// TODO Auto-generated method stub
	return null;
}

}
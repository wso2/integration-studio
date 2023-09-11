/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.artifact.datasourceProject.refactor;

import java.io.IOException;

import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
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
import org.wso2.integrationstudio.artifact.datasourceProject.Activator;
import org.wso2.integrationstudio.artifact.datasourceProject.utils.DataSourceProjectConstants;
import org.wso2.integrationstudio.esb.core.utils.SynapseConstants;
import org.wso2.integrationstudio.esb.core.utils.SynapseUtils;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;

public class DataSourceDeleteParticipant extends DeleteParticipant {

    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private static final String PARTICIPANT_NAME = "DataSourceDelete"; //$NON-NLS-1$
    private static final String ARTIFACT_XML_FILE = "artifact.xml"; //$NON-NLS-1$

    private String originalFileFullName;
    private IProject dsProject;
    private IFile originalFile;

    @Override
    public RefactoringStatus checkConditions(IProgressMonitor arg0, CheckConditionsContext arg1)
            throws OperationCanceledException {
        return RefactoringStatus.createInfoStatus("Update Data Source meta-data model");
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
        CompositeChange change = new CompositeChange(
                DataSourceProjectConstants.DataSourceDeleteParticipant_DataSourceDelete);
        IFile artifactFile = dsProject.getFile(ARTIFACT_XML_FILE);
        try {
            change.add(new DataSourceMetaDataFileDeleteChange(
                    DataSourceProjectConstants.DataSourceRenameParticipant_MetaDataChange, artifactFile,
                    originalFileFullName));
            deleteBuildAritfacts(artifactFile);

        } catch (IOException e) {
            throw new OperationCanceledException(
                    DataSourceProjectConstants.DataSourceDeleteParticipant_ArtifactXmlDeleteChangeFailed);
        }
        return change;
    }

    private void deleteBuildAritfacts(IFile file) {
        int substringLength = originalFileFullName.lastIndexOf(".");
        if (substringLength < 0) {
            substringLength = originalFileFullName.length();
        }
        String originalFileName = originalFileFullName.substring(0, substringLength);
        try {
            SynapseUtils.removeDataSourceBuildArtifacts(file.getProject().getFolder(SynapseConstants.BUILD_ARTIFACTS_FOLDER),
                    SynapseConstants.DATA_SOURCE_FOLDER, originalFileName);
        } catch (CoreException | IOException | XmlPullParserException e) {
            throw new OperationCanceledException("Error while deleting the build artifacts for "
                    + originalFileName + " in datasources");
        }
    }

    @Override
    public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
        // TODO Auto-generated method stub
        return null;
    }

}

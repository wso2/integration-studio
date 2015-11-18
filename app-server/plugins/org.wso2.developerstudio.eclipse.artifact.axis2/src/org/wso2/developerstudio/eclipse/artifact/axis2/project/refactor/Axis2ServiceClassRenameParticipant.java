/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.artifact.axis2.project.refactor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.wso2.developerstudio.eclipse.artifact.axis2.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

/**
 * Class used to support rename operation of Axis2 service classes.
 * For example, when the Axis2 service class name is changed, we have to update corresponding services.xml file with the new class name.
 * This class implements methods from RenameParticipant class
 */
public class Axis2ServiceClassRenameParticipant extends RenameParticipant {
    private static final IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private IProject axis2Project;
    private IFile axis2ClassFile;
    private String previousClassName;
    private String newClassName;

    private static final String RENAME_PARTICIPANT_NAME = "Axis2ServiceClassRenameParticipant";
    private static final String TEXT_FILE_CHANGE_NAME = "Axis2ServiceClassRenameParticipantChange";
    private static final String COMPOSITE_CHANGE_NAME = "Axis2ServiceClassRenameParticipantChanges";
    private static final String JAVA_EXTENSION = "java";
    private static final String SRC_FOLDER = "src";
    private static final String MAIN_FOLDER = "main";
    private static final String RESOURCES_FOLDER = "resources";
    private static final String META_INF_FOLDER = "META-INF";
    private static final String SERVICES_XML_FILE = "services.xml";

    /**
     * This method initializes the participant with the selected element that to be refactored.
     * All the necessary values are getting initialized here.
     *
     * @param selectedResource Resource to be refactored
     */
    @Override
    protected boolean initialize(Object selectedResource) {
        if (selectedResource instanceof IFile) {
            axis2ClassFile = (IFile) selectedResource;
            if (!axis2ClassFile.getFileExtension().equals(JAVA_EXTENSION)) {
                //If the selected resource for renaming is not a Java file, then no need for initialization, so return 'false'
                return false;
            }
            axis2Project = axis2ClassFile.getProject();
            previousClassName = axis2ClassFile.getName();
            newClassName = getArguments().getNewName();
            return true;
        } else {
            log.error("Axis2ServiceClassRenameParticipant was called with an invalid selection, Selection : " + selectedResource.getClass()
                    + ", Expected type : " + IFile.class);
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return RENAME_PARTICIPANT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RefactoringStatus checkConditions(IProgressMonitor iProgressMonitor, CheckConditionsContext checkConditionsContext)
            throws OperationCanceledException {
        //There are no pre conditions to check before renaming, so default RefactoringStatus.OK will be resulted
        return new RefactoringStatus();
    }

    /**
     * This method creates a Change object that contains the workspace modifications of this participant
     * to be executed after the changes from the refactoring are executed.
     *
     * @param iProgressMonitor
     * @return Change Axis2ServicesXMLFileChange
     */
    @Override
    public Change createChange(IProgressMonitor iProgressMonitor) throws CoreException, OperationCanceledException {
        //There are no changes to be done after renaming, so returns null for Change
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Change createPreChange(IProgressMonitor iProgressMonitor) throws CoreException, OperationCanceledException {
        CompositeChange artifactChange = new CompositeChange(COMPOSITE_CHANGE_NAME);

        //Getting services.xml file for given Axis2 service project
        IFolder metaFolder = ProjectUtils.getWorkspaceFolder(axis2Project, SRC_FOLDER, MAIN_FOLDER, RESOURCES_FOLDER, META_INF_FOLDER);
        IFile servicesXMLFile = metaFolder.getFile(SERVICES_XML_FILE);

        Axis2ServicesXMLFileChange axis2ServicesXMLFileChange = new Axis2ServicesXMLFileChange(TEXT_FILE_CHANGE_NAME, servicesXMLFile,
                previousClassName, newClassName);
        axis2ServicesXMLFileChange.updateServicesXMLFile(servicesXMLFile);
        artifactChange.add(axis2ServicesXMLFileChange);
        return artifactChange;
    }
}

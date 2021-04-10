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

package org.wso2.integrationstudio.artifact.datasourceProject.capp.refactor;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.DeleteParticipant;
import org.wso2.integrationstudio.artifact.datasourceProject.Activator;
import org.wso2.integrationstudio.artifact.datasourceProject.utils.DataSourceProjectConstants;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.maven.util.MavenUtils;
import org.wso2.integrationstudio.platform.core.utils.Constants;

public class DataSourceDeleteParticipant extends DeleteParticipant {

    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private static final String PARTICIPANT_NAME = "DataSourceDelete"; //$NON-NLS-1$

    private String originalFileFullName;
    private IProject dsProject;
    private IFile originalFile;

    @Override
    public RefactoringStatus checkConditions(IProgressMonitor arg0, CheckConditionsContext arg1)
            throws OperationCanceledException {
        return RefactoringStatus.createInfoStatus("Update CApp if it's referred");
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
    public Change createChange(IProgressMonitor arg0) throws CoreException, OperationCanceledException {
        CompositeChange change = new CompositeChange(
                DataSourceProjectConstants.DataSourceDeleteParticipant_DataSourceDelete);
        try {
//            Change deleteFromPOM = deleteFromPOM();
//            change.add(deleteFromPOM);

        } catch (Exception e) {
            throw new OperationCanceledException(
                    DataSourceProjectConstants.DataSourceDeleteParticipant_ArtifactXmlDeleteChangeFailed);
        }
        try {
            identyfyAndRemoveChangingItemFromCompositePOM(originalFile);
        } catch (Exception e) {
            log.error("Error While updating CApp", e);
        }
        return change;
    }

    private Change deleteFromPOM() throws CoreException {
        IFile pomFile = null;
        IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
        CompositeChange deleteChange = new CompositeChange("Update CApp pom.xml");
        for (IProject project : projects) {
            if (project.isOpen() && project.hasNature(Constants.DISTRIBUTION_PROJECT_NATURE)) {
                try {
                    pomFile = project.getFile("pom.xml");
                    try {
                        pomFile.refreshLocal(0, new NullProgressMonitor());
                    } catch (Exception ignore) {
                    }

                    MavenProject mavenProject = MavenUtils
                            .getMavenProject(project.getFile("pom.xml").getLocation().toFile());
                    Dependency projectDependency = getDependencyForTheProject(originalFile.getProject());
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
                            deleteChange.add(new MavenConfigurationFileDeleteChange(project.getName(), pomFile,
                                    projectDependency));
                        }
                    }

                } catch (Exception e) {
                    log.error("Error occurred while trying to generate the Refactoring", e);
                } finally {
                    try {
                        if (pomFile != null) {
                            pomFile.refreshLocal(0, new NullProgressMonitor());
                        }
                    } catch (Exception ignore) {

                    }
                }
            }
        }
        return deleteChange;
    }
    
    private void identyfyAndRemoveChangingItemFromCompositePOM(IFile changingFile) {
        
        try {
            String changingFileName = changingFile.getName().substring(0, changingFile.getName().lastIndexOf('.'));
            IFile pomIFile = changingFile.getProject().getFile("pom.xml");
            File pomFile = pomIFile.getLocation().toFile();
            MavenProject mvnProject = MavenUtils.getMavenProject(pomFile);
            String[] sections = changingFile.getFullPath().toOSString().split(File.separator);
            String artifactType = sections[sections.length - 2];
            String chandingFileGroupId = mvnProject.getGroupId() + "." + artifactType;
            
            IWorkspace workspace = ResourcesPlugin.getPlugin().getWorkspace();
            IProject [] projects = workspace.getRoot().getProjects();
            for (IProject project : projects) {
                if (project.hasNature(Constants.DISTRIBUTION_PROJECT_NATURE)) {
                    IFile compositePOMIFile = project.getFile("pom.xml");
                    File compositePOMFile = compositePOMIFile.getLocation().toFile();
                    MavenProject compositeMvnProject = MavenUtils.getMavenProject(compositePOMFile);
                    List<Dependency> dependencies = compositeMvnProject.getDependencies();
                    int dependencyIndex = -1;
                    for (int x = 0; x < dependencies.size(); x++) {
                        if (dependencies.get(x).getGroupId().equalsIgnoreCase(chandingFileGroupId) 
                                && dependencies.get(x).getArtifactId().equalsIgnoreCase(changingFileName)) {
                            dependencyIndex = x;
                            break;
                        }
                    }
                    if (dependencyIndex != -1) {
                        dependencies.remove(dependencyIndex);
                        compositeMvnProject.getProperties().remove(chandingFileGroupId.concat("_._").concat(changingFileName));
                        compositeMvnProject.setDependencies(dependencies);
                        MavenUtils.saveMavenProject(compositeMvnProject, compositePOMFile);
                    }
                }
            }
        } catch (Exception e) {
            //ignore
        } 
    }

    private Dependency getDependencyForTheProject(IProject project) throws Exception {

        MavenProject mavenProject = MavenUtils.getMavenProject(project.getFile("pom.xml").getLocation().toFile());
        Dependency dependency = new Dependency();
        if (mavenProject != null) {
            dependency.setGroupId(mavenProject.getGroupId() + ".datasource");
            dependency.setArtifactId(mavenProject.getArtifactId());
            dependency.setVersion(mavenProject.getVersion());
        }
        return dependency;
    }

    private boolean isDependenciesEqual(Dependency source, Dependency target) {
        return (source.getGroupId().equalsIgnoreCase(target.getGroupId())
                && source.getArtifactId().equalsIgnoreCase(target.getArtifactId())
                && source.getVersion().equalsIgnoreCase(target.getVersion()));
    }
}

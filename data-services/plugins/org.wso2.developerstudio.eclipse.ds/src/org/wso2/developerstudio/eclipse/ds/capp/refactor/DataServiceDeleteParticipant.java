/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.ds.capp.refactor;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
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
import org.wso2.developerstudio.eclipse.ds.Activator;
import org.wso2.developerstudio.eclipse.ds.refactor.MavenConfigurationFileDeleteChange;
import org.wso2.developerstudio.eclipse.ds.util.Messages;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;

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
		CompositeChange change = new CompositeChange(Messages.DataServiceDeleteParticipant_DataServiceDelete);
		try {
			Change deleteFromPOM = deleteFromPOM();
			change.add(deleteFromPOM);

		} catch (Exception e) {
			throw new OperationCanceledException(Messages.DataServiceDeleteParticipant_ArtifactXmlDeleteChangeFailed);
		}
		try {

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
			if (project.isOpen() && project.hasNature("org.wso2.developerstudio.eclipse.distribution.project.nature")) {
				try {
					  pomFile = project.getFile("pom.xml");
					    try {
						       pomFile.refreshLocal(0, new NullProgressMonitor());
					        } catch (Exception ignore) {
					            }

					MavenProject mavenProject = MavenUtils.getMavenProject(project.getFile("pom.xml").getLocation().toFile());
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

	private Dependency getDependencyForTheProject(IProject project) throws Exception {

		MavenProject mavenProject = MavenUtils.getMavenProject(project.getFile("pom.xml").getLocation().toFile());
		Dependency dependency = new Dependency();
		if (mavenProject != null) {
			dependency.setGroupId(mavenProject.getGroupId() + ".dataservice");
			dependency.setArtifactId(mavenProject.getArtifactId());
			dependency.setVersion(mavenProject.getVersion());
		}
		return dependency;
	}

	private boolean isDependenciesEqual(Dependency source, Dependency target) {
		return (source.getGroupId().equalsIgnoreCase(target.getGroupId())
				&& source.getArtifactId().equalsIgnoreCase(target.getArtifactId()) && source.getVersion()
				.equalsIgnoreCase(target.getVersion()));
	}

	/*
	 * @Override public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException { //
	 * TODO Auto-generated method stub return null; }
	 */

}
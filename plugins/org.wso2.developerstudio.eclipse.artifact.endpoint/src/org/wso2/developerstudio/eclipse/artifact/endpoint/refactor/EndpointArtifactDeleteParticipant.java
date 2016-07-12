/*
 * Copyright (c) 2012-2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.artifact.endpoint.refactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import org.eclipse.ltk.core.refactoring.participants.ISharableParticipant;
import org.eclipse.ltk.core.refactoring.participants.RefactoringArguments;
import org.wso2.developerstudio.eclipse.artifact.endpoint.Activator;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class EndpointArtifactDeleteParticipant extends DeleteParticipant implements ISharableParticipant {

	private static final String ARTIFACT_XML = "artifact.xml";
	private static final String POM_XML = "pom.xml";
	private static final String ESB_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.esb.project.nature";
	private static final String CHANGE_INFO = "Update pom files in refferred CApps.";
	private static final String CAPP_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.distribution.project.nature";
	private static final String REFACTORING_STEP_INFO = "Update CApp projects which packs these ESB artifacts.";

	private static final IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	protected List<IFile> filesToBeRemoved;
	protected List<ESBArtifact> artifactsInRemovingProjects;
	protected Map<IProject, List<Dependency>> depsToBeRemovedByCApp;

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor arg0, CheckConditionsContext arg1)
			throws OperationCanceledException {
		return RefactoringStatus.createInfoStatus(REFACTORING_STEP_INFO);
	}

	@Override
	public Change createPreChange(IProgressMonitor arg0) throws CoreException, OperationCanceledException {

		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject project : projects) {
			if (project.isOpen() && project.hasNature(CAPP_PROJECT_NATURE)) {
				IFile pomFile = null;
				try {
					pomFile = project.getFile(POM_XML);
					try {
						pomFile.refreshLocal(0, new NullProgressMonitor());
					} catch (Exception warning) {
						log.warn("Error while refreshing " + pomFile.getLocation().toOSString(), warning);
					}

					MavenProject cappPOM = RefactorUtils.getMavenProject(project);
					resolveDepsForRemvoingFiles(project, cappPOM);
					resolveDepsForRemovingProjects(project, cappPOM);

				} catch (Exception e) {
					log.error("Error occurred while trying to prepare changes for delete operation.", e);
				} finally {
					try {
						if (pomFile != null) {
							pomFile.refreshLocal(0, new NullProgressMonitor());
						}
					} catch (Exception warning) {
						log.warn("Error while refreshing " + pomFile.getLocation().toOSString(), warning);
					}
				}
			}
		}
		if (depsToBeRemovedByCApp != null && !depsToBeRemovedByCApp.isEmpty()) {
			return populateChangeList(depsToBeRemovedByCApp);
		}
		return null;
	}

	@Override
	public String getName() {
		return "Removing ESB artifacts from CApps.";
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return null;
	}

	@Override
	public void addElement(Object element, RefactoringArguments arguments) {
		// if deleting the whole project
		if (element instanceof IProject) {
			IProject project = (IProject) element;
			resolveRemovingArtifactsFromProject(project);
			return;
		}
		if (element instanceof IFile) {
			filesToBeRemoved.add((IFile) element);
		}
	}

	@Override
	protected boolean initialize(Object resource) {
		// if deleting the whole project
		if (resource instanceof IProject) {
			IProject project = (IProject) resource;
			return resolveRemovingArtifactsFromProject(project);
		}
		if (resource instanceof IFile) {
			if (filesToBeRemoved == null) {
				filesToBeRemoved = new ArrayList<IFile>();
			}
			filesToBeRemoved.add((IFile) resource);
			return true;
		}
		return false;
	}

	private CompositeChange populateChangeList(Map<IProject, List<Dependency>> depsToRemoveByCApp) {
		CompositeChange changes = new CompositeChange(CHANGE_INFO);
		Iterator<Entry<IProject, List<Dependency>>> iterator = depsToRemoveByCApp.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<IProject, List<Dependency>> cappToUpdate = iterator.next();
			changes.add(new MavenConfigurationFileDeleteChange(cappToUpdate.getKey().getName(),
					cappToUpdate.getKey().getFile(POM_XML), cappToUpdate.getValue()));
		}
		return changes;
	}

	private boolean resolveRemovingArtifactsFromProject(IProject project) {
		IFile artifactXML = project.getFile(ARTIFACT_XML);
		if (artifactXML.exists()) {
			ESBProjectArtifact esbProject = new ESBProjectArtifact();
			try {
				esbProject.fromFile(artifactXML.getLocation().toFile());
				List<ESBArtifact> allArtifacts = esbProject.getAllESBArtifacts();
				if (allArtifacts != null && !allArtifacts.isEmpty()) {
					if (artifactsInRemovingProjects == null) {
						this.artifactsInRemovingProjects = new ArrayList<ESBArtifact>();
					}
					this.artifactsInRemovingProjects.addAll(allArtifacts);
				}
				return true;
			} catch (Exception e) {
				log.error("Error while parsing " + artifactXML.getLocation().toOSString(), e);
			}
		}
		return false;
	}

	private void resolveDepsForRemvoingFiles(IProject cappProject, MavenProject cappPOM) {
		if (filesToBeRemoved != null && !filesToBeRemoved.isEmpty()) {
			for (IFile deletingArtifact : filesToBeRemoved) {
				ESBArtifact esbArtifactFromFile = RefactorUtils.getESBArtifactFromFile(deletingArtifact,
						ESB_PROJECT_NATURE);
				Dependency caapDependency = null;
				if (esbArtifactFromFile != null) {
					caapDependency = new Dependency();
					caapDependency.setGroupId(esbArtifactFromFile.getGroupId());
					caapDependency.setArtifactId(deletingArtifact.getName().substring(0,
							deletingArtifact.getName().length() - deletingArtifact.getFileExtension().length() - 1));
					caapDependency.setVersion(esbArtifactFromFile.getVersion());
				} else {
					caapDependency = RefactorUtils.getDependencyForTheProject(deletingArtifact);
					caapDependency.setArtifactId(deletingArtifact.getName().substring(0,
							deletingArtifact.getName().length() - deletingArtifact.getFileExtension().length() - 1));
				}

				if (cappPOM != null) {
					List<?> dependencies = cappPOM.getDependencies();
					for (Iterator<?> iterator = dependencies.iterator(); iterator.hasNext();) {
						Dependency dependency = (Dependency) iterator.next();
						if (RefactorUtils.isDependenciesEqual(caapDependency, dependency)) {
							if (depsToBeRemovedByCApp == null) {
								depsToBeRemovedByCApp = new HashMap<IProject, List<Dependency>>();
							}
							if (!depsToBeRemovedByCApp.containsKey(cappProject)) {
								depsToBeRemovedByCApp.put(cappProject, new ArrayList<Dependency>());
							}
							depsToBeRemovedByCApp.get(cappProject).add(caapDependency);
						}
					}
				}
			}
		}
	}

	private void resolveDepsForRemovingProjects(IProject cappProject, MavenProject cappPOM) {
		if (artifactsInRemovingProjects != null && !artifactsInRemovingProjects.isEmpty()) {
			for (ESBArtifact esbArtifact : artifactsInRemovingProjects) {
				Dependency esbDependency = RefactorUtils.getDependencyForArtifact(esbArtifact);
				if (cappPOM != null) {
					List<?> dependencies = cappPOM.getDependencies();
					for (Iterator<?> iterator = dependencies.iterator(); iterator.hasNext();) {
						Dependency dependency = (Dependency) iterator.next();
						if (RefactorUtils.isDependenciesEqual(esbDependency, dependency)) {
							if (depsToBeRemovedByCApp == null) {
								depsToBeRemovedByCApp = new HashMap<IProject, List<Dependency>>();
							}
							if (!depsToBeRemovedByCApp.containsKey(cappProject)) {
								depsToBeRemovedByCApp.put(cappProject, new ArrayList<Dependency>());
							}
							depsToBeRemovedByCApp.get(cappProject).add(esbDependency);
						}
					}
				}
			}
		}
	}

}
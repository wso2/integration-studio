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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import org.eclipse.ltk.core.refactoring.participants.DeleteParticipant;
import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.utils.RefactorUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class ESBArtifactMetaDataDeleteParticipant extends DeleteParticipant {
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	private IFile originalFile;
	private static int numOfFiles;
	private static int currentFileNum;
	private static Map<IProject, List<IFile>> changeFileList;
	private static List<IProject> projectList;

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor arg0, CheckConditionsContext arg1)
			throws OperationCanceledException {
		String msg ="[warning] - Only the CApp(pom.xml) & project meta data file(arifact.xml) will be updated, but If any other references,"
				+ "those will be remain unchanged";
		return RefactoringStatus.createWarningStatus(msg);
	}

	@Override
	public Change createChange(IProgressMonitor arg0) throws CoreException, OperationCanceledException {
		CompositeChange emptychange = new CompositeChange("ESB Artifact Delete");
		currentFileNum++;
		if (numOfFiles == currentFileNum) {
			CompositeChange change = new CompositeChange("ESB Artifact.xml file Delete");
			for (IProject project : projectList) {
				List<IFile> fileList = changeFileList.get(project);
				change.add(new ESBMetaDataFileDeleteChange(project.getName(), project.getFile("artifact.xml"), fileList));
			}
			resetStaticVariables();
			change.add(createChangeCApp());
			return change;
		}
		return emptychange;
	}

	
	private Change createChangeCApp() throws CoreException, OperationCanceledException {

		CompositeChange deleteChange = new CompositeChange("Delete from CApp");

		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();

		for (IProject project : projects) {
			if (project.isOpen() && project.hasNature("org.wso2.developerstudio.eclipse.distribution.project.nature")) {
				try {
					IFile pomFile = project.getFile("pom.xml");
					MavenProject mavenProject = RefactorUtils.getMavenProject(project);

					ESBArtifact esbArtifactFromFile = RefactorUtils.getESBArtifactFromFile(originalFile,
							"org.wso2.developerstudio.eclipse.esb.project.nature");
					Dependency projectDependency = null;

					if (esbArtifactFromFile != null) {
						projectDependency = new Dependency();
						projectDependency.setGroupId(esbArtifactFromFile.getGroupId());
						projectDependency.setArtifactId(originalFile.getName().substring(0,
								originalFile.getName().length() - originalFile.getFileExtension().length() - 1));
						projectDependency.setVersion(esbArtifactFromFile.getVersion());
					} else {
						projectDependency = RefactorUtils.getDependencyForTheProject(originalFile);
						projectDependency.setArtifactId(originalFile.getName().substring(0,
								originalFile.getName().length() - originalFile.getFileExtension().length() - 1));
					}

					if (mavenProject != null) {
						List<?> dependencies = mavenProject.getDependencies();
						for (Iterator<?> iterator = dependencies.iterator(); iterator.hasNext();) {
							Dependency dependency = (Dependency) iterator.next();
							if (RefactorUtils.isDependenciesEqual(projectDependency, dependency)) {
								deleteChange.add(new MavenConfigurationFileDeleteChange(project.getName(), pomFile,
										projectDependency));
							}
						}
					}
				} catch (Exception e) {
					log.error("Error while refactoring in CApp pom.xml", e);
				}
			}
		}

		return deleteChange;
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
	protected boolean initialize(Object arg0) {
		if (arg0 instanceof IFile) {
			numOfFiles++;
			originalFile = (IFile) arg0;
			if (numOfFiles == 1) {
				List<IFile> fileList = new ArrayList<>();
				projectList = new ArrayList<>();
				changeFileList = new HashMap<IProject, List<IFile>>();
				fileList.add(originalFile);
				projectList.add(originalFile.getProject());
				changeFileList.put(originalFile.getProject(), fileList);
			} else {
				if (changeFileList.containsKey(originalFile.getProject())) {
					changeFileList.get(originalFile.getProject()).add(originalFile);
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

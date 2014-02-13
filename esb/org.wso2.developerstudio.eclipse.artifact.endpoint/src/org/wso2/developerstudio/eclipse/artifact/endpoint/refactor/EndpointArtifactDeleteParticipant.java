/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.endpoint.refactor;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.DeleteParticipant;
import org.eclipse.ltk.core.refactoring.resource.DeleteResourceChange;
import org.wso2.developerstudio.eclipse.artifact.endpoint.Activator;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.stream.FactoryConfigurationError;

public class EndpointArtifactDeleteParticipant extends DeleteParticipant{
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private IFile originalFile;

	@Override
    public RefactoringStatus checkConditions(IProgressMonitor arg0, CheckConditionsContext arg1)
                                                                                                throws OperationCanceledException {
	    return RefactoringStatus.createWarningStatus("You are about to delete an ESB Artifact");
    }

	@Override
    public Change createPreChange(IProgressMonitor arg0) throws CoreException,
                                                     OperationCanceledException {
		
		CompositeChange deleteChange=new CompositeChange("Delete ESB Artifact");
		
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		
		for (IProject project : projects) {
	        if(project.isOpen() && project.hasNature("org.wso2.developerstudio.eclipse.distribution.project.nature")){
	        	try {
					IFile pomFile = project.getFile("pom.xml");
					MavenProject mavenProject = RefactorUtils.getMavenProject(project);
					
					ESBArtifact esbArtifactFromFile = RefactorUtils.getESBArtifactFromFile(originalFile, "org.wso2.developerstudio.eclipse.esb.project.nature");
					Dependency projectDependency = null;
					
					if(esbArtifactFromFile != null){
						projectDependency = new Dependency();
						projectDependency.setGroupId(esbArtifactFromFile.getGroupId());
						projectDependency.setArtifactId(originalFile.getName().substring(0,originalFile.getName().length()-originalFile.getFileExtension().length()-1));
						projectDependency.setVersion(esbArtifactFromFile.getVersion());
					}else{
						projectDependency = RefactorUtils.getDependencyForTheProject(originalFile);
						projectDependency.setArtifactId(originalFile.getName().substring(0,originalFile.getName().length()-originalFile.getFileExtension().length()-1));
					}
					
					if (mavenProject != null) {
						List<?> dependencies = mavenProject.getDependencies();
						for (Iterator<?> iterator = dependencies.iterator(); iterator
								.hasNext();) {
							Dependency dependency = (Dependency) iterator
									.next();
							if (RefactorUtils.isDependenciesEqual(
									projectDependency, dependency)) {
								deleteChange
										.add(new MavenConfigurationFileDeleteChange(
												project.getName(), pomFile,
												projectDependency));
							}
						}
					}
				} catch (Exception e) {
					log.error("Error occured while trying to generate the Refactoring", e);
				}
	        }
        }
		
	    return deleteChange;
    }

	@Override
    public String getName() {
	    return "ESB Artifact Deletion";
    }

	@Override
    protected boolean initialize(Object arg0) {
		if (arg0 instanceof IFile) {
			originalFile = (IFile) arg0;
			return true;
		}
		return false;
    }

	@Override
    public Change createChange(IProgressMonitor arg0) throws CoreException,
                                                     OperationCanceledException {
		CompositeChange deleteChange=new CompositeChange("Delete ESB Graphical Artifact Metadata");
		
		IProject esbProject = originalFile.getProject();
		esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		
		ESBArtifact esbArtifact = RefactorUtils.getESBArtifactFromFile(originalFile, "org.wso2.developerstudio.eclipse.esb.project.nature");
		
		if(esbArtifact != null){
			String type=esbArtifact.getType().substring("synapse/".length());
			String path=type;
			String prefix=type;
			if(type.equalsIgnoreCase("proxy-service")){
				path="proxy-services";
				prefix="proxy";
			}else if(type.equalsIgnoreCase("local-entry")){
				prefix="localentry";
				path="local-entries";
			}else if(type.equalsIgnoreCase("sequence")){
				path="sequences";
			}else if(type.equalsIgnoreCase("task")){
				path="tasks";
			}else if(type.equalsIgnoreCase("template")){
				path="templates";
			}else if(type.equalsIgnoreCase("endpoint")){
				path="endpoints";
			}
			
			IFolder graphicalArtifactFolder = esbProject.getFolder("src").getFolder("main").getFolder("graphical-synapse-config");
			if (graphicalArtifactFolder.exists()) {
				IFile file = graphicalArtifactFolder.getFolder(path).getFile(
						prefix
								+ "_"
								+ originalFile.getName().substring(0,
										originalFile.getName().length() - 3)
								+ "esb_diagram");
				IFile file2 = graphicalArtifactFolder.getFolder(path).getFile(
						prefix
								+ "_"
								+ originalFile.getName().substring(0,
										originalFile.getName().length() - 3)
								+ "esb");
				if (file.exists()) {
					DeleteResourceChange deleteResourceChange = new DeleteResourceChange(
							file.getFullPath(), true, true);
					deleteChange.add(deleteResourceChange);
				}
				if (file2.exists()) {
					DeleteResourceChange deleteResourceChange1 = new DeleteResourceChange(
							file2.getFullPath(), true, true);
					deleteChange.add(deleteResourceChange1);
				}
			}
		}
		
		return deleteChange;
    }

}

/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.core.project.refactor;

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
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.Activator;

import java.util.Iterator;
import java.util.List;

/**
 * This class is used to provide refactoring support for Artifact Project
 * Deletion. When an user is trying to delete an artifact project from
 * workspace, we need to remove that project and its artifacts from Distribution
 * projects. This Delete Participant extension point is providing support for
 * that. Changes we initiate in this class are shown as preview in the project.
 */
public class ArtifactProjectDeleteParticipant extends DeleteParticipant {
	private static final String POM_XML = "pom.xml";

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private IProject originalProject;

	/**
	 * This method is used to check the pre-conditions for the refactoring. This
	 * method can be used to communicate with user about refactoring about to
	 * happen such as if there is an fatal issue related to refactoring, you can
	 * create a Status with Fatal error, or you can create a warning status
	 * where user can be informed.
	 */
	@Override
	public RefactoringStatus checkConditions(IProgressMonitor arg0, CheckConditionsContext arg1)
	                                                                                            throws OperationCanceledException {
		return RefactoringStatus.createWarningStatus("You are about to delete your Artifact project");
	}

	/**
	 * This method gets executed before the refactoring gets executed on
	 * original file which means this method is executed before the actual
	 * project is deleted from the workspace. If you have any task need to run
	 * before the project is deleted, you need to generate Changes for those
	 * tasks in this method.
	 */
	@Override
	public Change createPreChange(IProgressMonitor arg0) throws CoreException, OperationCanceledException {

		CompositeChange deleteChange = new CompositeChange("Delete Artifact Project");

		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();

		for (IProject project : projects) {
			if (project.isOpen() && project.hasNature("org.wso2.developerstudio.eclipse.distribution.project.nature")) {
				try {
					IFile pomFile = project.getFile(POM_XML);
					MavenProject mavenProject = ProjectRefactorUtils.getMavenProject(project);
					Dependency projectDependency = ProjectRefactorUtils.getDependencyForTheProject(originalProject);
					if (mavenProject != null) {
						List<?> dependencies = mavenProject.getDependencies();
						if (projectDependency != null) {
							for (Iterator<?> iterator = dependencies.iterator(); iterator.hasNext();) {
								Dependency dependency = (Dependency) iterator.next();
								if (ProjectRefactorUtils.isDependenciesEqual(projectDependency, dependency)) {
									deleteChange.add(new MavenConfigurationFileDeleteChange(project.getName(), pomFile,
									                                                        originalProject));
								}
							}
						}
					}
				} catch (Exception e) {
					log.error("Error occured while trying to generate the Refactoring", e);
				}
			}
		}
		
		// remove related active editors
        Display.getDefault().asyncExec(new Runnable() {
            public void run() {
                try {
                    IWorkbenchPage[] pages = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages();
                    if (pages != null) {
                        for (IWorkbenchPage page : pages) {
                            IEditorReference[] editorRefs = page.getEditorReferences();
                            for (IEditorReference ref : editorRefs) {
                                IEditorPart editor = ref.getEditor(true);
                                if (editor != null) {
                                    IEditorInput input = editor.getEditorInput();
                                    IFile file = (IFile) input.getAdapter(IFile.class);

                                    String projectLocation = originalProject.getLocation().toOSString();
                                    if (file != null) {
                                        String fileLocation = file.getLocation().toOSString();
                                        if (fileLocation.contains(projectLocation)) {
                                            page.closeEditor(editor, true);
                                        }
                                    } else {
                                        try {
                                            IFile filePath = ((IFileEditorInput) input).getFile();
                                            if (filePath != null) {
                                                String fileLocation = filePath.getLocation().toOSString();
                                                if (fileLocation.contains(projectLocation)) {
                                                    page.closeEditor(editor, true);
                                                }
                                            }
                                        } catch (Exception e) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    // TODO Auto-generated method stub
                }
            }
        });

        return deleteChange;
    }

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean initialize(Object arg0) {
		if (arg0 instanceof IProject) {
			originalProject = (IProject) arg0;
			return true;
		}
		return false;
	}

	/**
	 * This method gets executed after performing the actual refactoring task.
	 * Normally this method is used for clean up tasks.
	 */
	@Override
	public Change createChange(IProgressMonitor arg0) throws CoreException, OperationCanceledException {
		// TODO Auto-generated method stub
		return null;
	}

}
/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.general.project.ui.wizard;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.general.project.Activator;
import org.wso2.developerstudio.eclipse.general.project.artifact.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.model.GeneralProjectModel;
import org.wso2.developerstudio.eclipse.general.project.utils.GeneralProjectImageUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.project.presentation.ProjectPresentation;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class GeneralProjectWizard extends AbstractWSO2ProjectCreationWizard {
	private static final String GENERAL_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.general.project.nature";
	private static final String ESB_GRAPHICAL_PERSPECTIVE = "org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.perspective";

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    
	private IProject project;

	public GeneralProjectWizard() {
		setModel(new GeneralProjectModel());
		setDefaultPageImageDescriptor(GeneralProjectImageUtils.getInstance().getImageDescriptor("general-project-wizard.png"));
	}

	
	public boolean performFinish() {
		try {
//			setProjectNature(GENERAL_PROJECT_NATURE);
			project = createNewProject();
			JavaUtils.addJavaNature(project,false);
			
			File pomfile = project.getFile("pom.xml").getLocation().toFile();
			createPOM(pomfile,"pom");
			
			ProjectUtils.addNatureToProject(project,
			                                false, GENERAL_PROJECT_NATURE);
			MavenUtils
			.updateWithMavenEclipsePlugin(
					pomfile,
					new String[] { JDT_BUILD_COMMAND },
					new String[] {
							GENERAL_PROJECT_NATURE,
							JDT_PROJECT_NATURE });

			//Creating the metadata file artifact.xml while creating the ESB project. It will be hidden and users won't be able to see it via Eclipse.
			GeneralProjectArtifact artifact=new GeneralProjectArtifact();
			IFile file = project.getFile("artifact.xml");
			artifact.setSource(file.getLocation().toFile());
			artifact.toFile();
			//Refresh the project to show the changes. But still won't see the newly created project.
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			refreshDistProjects();
			//Setting the created file to be hidden so that users won't see it.
			if(file.exists()){
				file.setHidden(true);
			}
			
			
		} catch (CoreException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
		
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				if (!ESB_GRAPHICAL_PERSPECTIVE.equals(window.getActivePage().getPerspective().getId())) {
					try {
						PlatformUI.getWorkbench().showPerspective(ESB_GRAPHICAL_PERSPECTIVE, window);
						ProjectPresentation.setHierarchicalProjectPresentation();
					} catch (Exception e) {
						log.error("Cannot switch to ESB Graphical Perspective", e);
					}
				}
			}
		});
		return true;
	}

	
	public IResource getCreatedResource() {
		return project;
	}
}

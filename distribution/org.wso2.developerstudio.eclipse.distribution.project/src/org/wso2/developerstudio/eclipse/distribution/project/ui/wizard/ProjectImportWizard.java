/*
 * Copyright (c) 2012-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.distribution.project.ui.wizard;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.datatransfer.ExternalProjectImportWizard;
import org.wso2.developerstudio.eclipse.distribution.project.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class ProjectImportWizard extends ExternalProjectImportWizard {
	private ProjectsImportPage importMainPage;
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	@Override
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		super.init(workbench, currentSelection);
	}

	@Override
	public boolean performFinish() {
		boolean created = importMainPage.createProjects();
		List<IProject> createdProjects = importMainPage.getCreatedProjects();
		for (IProject resource : createdProjects) {
			searchAndRemoveGraphicalSynapseCongif(resource);
		}
		return created;
	}

	@Override
	public void addPages() {
		importMainPage = new ProjectsImportPage();
		addPage(importMainPage);	
	}

	public boolean performCancel() {
		importMainPage.performCancel();
		return true;
	}
	
	/**
	 * Before Developer Studio 3.8.0 version, there were graphical metadata files to persist graphical information for a
	 * particular config file. These meta files are stored in graphical-synapse-config directory. Graphical files are no
	 * longer needed and this will search and remove graphical-synapse-config directory and its content while the
	 * project import.
	 * 
	 * @param project
	 */
	private void searchAndRemoveGraphicalSynapseCongif(IProject project) {
		try {
			if (project.hasNature("org.wso2.developerstudio.eclipse.esb.project.nature")) {
				deleteGraphicalSynapseConfigDir(project);
			}
		} catch (CoreException e) {
			log.error("Error while deleting graphical-synapse-config directory in " + project);
		}
	}

	private void deleteGraphicalSynapseConfigDir(IProject project) throws CoreException {
		IFolder grapicalSynapseConfigFolder = project.getFolder("src" + File.separator + "main" + File.separator + "graphical-synapse-config");
		if (grapicalSynapseConfigFolder != null) {
			grapicalSynapseConfigFolder.delete(true, false, new NullProgressMonitor());
		}
	}
	
}

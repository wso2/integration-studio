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

package org.wso2.developerstudio.eclipse.platform.ui.action;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;

/**
 * This action will be executed on selection of
 * Maven-->'Upgrade Plugin Versions in pom.xml' context menu
 * item of developer studio project.
 *
 */
public class UpgradePluginVersionsAction implements IObjectActionDelegate {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private IProject project;
	private IFile mavenProjectFile;

	@Override
	public void run(IAction action) {
		MavenProject mavenProject;
		try {
			String message = "This will upgrade the WSO2 maven plugin versions in pom.xml. Do you want to continue?";
			boolean okPressed = MessageDialog.open(MessageDialog.QUESTION, Display.getCurrent().getActiveShell(),
			                                       "Upgrading Plugin Versions", message, SWT.NONE);
			if (okPressed) {
				mavenProject = MavenUtils.getMavenProject(mavenProjectFile.getLocation().toFile());
				MavenUtils.upgradePluginVersions(project, mavenProject);
				MavenUtils.saveMavenProject(mavenProject, mavenProjectFile.getLocation().toFile());

				project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			}
		} catch (Exception e) {
			log.error("Error occured while updating the pom.xml of " + project.getName(), e);
		}

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) selection;
			if (treeSelection.getFirstElement() instanceof IProject) {
				IProject project = (IProject) treeSelection.getFirstElement();
				action.setEnabled(project.isOpen());
				this.project = project;
				mavenProjectFile = project.getFile("pom.xml");
				if (mavenProjectFile.exists()) {
					action.setText("Upgrade Plugin Versions in pom.xml");
				}
			} else {
				action.setEnabled(false);
			}
		}

	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub

	}

}
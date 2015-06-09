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

package org.wso2.developerstudio.eclipse.distribution.project.publisher;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.wst.server.core.IServer;
import org.wso2.developerstudio.eclipse.artifact.webapp.project.export.WebAppArtfactExportHandler;
import org.wso2.developerstudio.eclipse.carbonserver.base.interfaces.ICarbonServerModulePublisher;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerManager;

public class WebAppProjectPublisher implements ICarbonServerModulePublisher {

	private IResource resource;
	private static final String DEPLOYMENT_DIR_PATH = "repository" + File.separator + "deployment" + File.separator
			+ "server" + File.separator + "webapps";

	private final class WarPublisher implements Runnable {
		private final File deployLocation;
		private final IProject project;
		private boolean done = false;
		private Exception exception;
		private IServer server;

		private WarPublisher(File deployLocation, IProject project, IServer server) {
			this.deployLocation = deployLocation;
			this.project = project;
			this.server = server;
		}

		public void run() {
			File repoLocation = deployLocation;
			String repoPath = "webapps";
			repoLocation = new File(repoLocation, repoPath);

			try {

				String deploymentDirPath = CarbonServerManager.getServerHome(server) + File.separator
						+ DEPLOYMENT_DIR_PATH;
				File deploymentFile = new File(deploymentDirPath + File.separator + project.getName());

				WebAppArtfactExportHandler handler = new WebAppArtfactExportHandler();
				File explodedWebapp = handler.createExplodedWebapp(project);
				FileUtils.copyDirectory(explodedWebapp, deploymentFile, true);
			} catch (Exception e) {
				setException(e);
			}
			setDone(true);
		}

		private void setDone(boolean done) {
			this.done = done;
		}

		private void setException(Exception exception) {
			this.exception = exception;
		}

		public Exception getException() {
			return exception;
		}
	}

	@Override
	public void publish(IProject project, IServer server, File serverHome, File deployLocation) throws Exception {
		if (project.hasNature("org.wso2.developerstudio.eclipse.webapp.project.nature")) {
			final WarPublisher runnable = new WarPublisher(deployLocation, project, server);
			runnable.run();
			if (runnable.getException() != null) {
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error while creating WAR",
								"An error occured while creating or publishing the war for more details view the log. \n"
										+ runnable.getException().getMessage());
					}

				});
			}
		}
	}

	@Override
	public void unpublish(IProject project, IServer server, File serverHome, File deployLocation) throws Exception {

		File webapp = new File(CarbonServerManager.getServerHome(server) + File.separator + DEPLOYMENT_DIR_PATH
				+ File.separator + project.getName());
		if (webapp != null) {
			FileUtils.deleteDirectory(webapp);
		}
	}

	@Override
	public void hotUpdate(IProject project, IServer server, File serverHome, File deployLocation) throws Exception {

		String deploymentDirPath = CarbonServerManager.getServerHome(server) + File.separator + DEPLOYMENT_DIR_PATH;
		String resPath;
		String tempPath;
		File sourceFile;
		File destinationFile;

		if (resource != null) {
			if (resource.getFileExtension().equals("class")) {
				resPath = resource.getProjectRelativePath().toString();
				tempPath = resPath.split("target")[1];
				sourceFile = new File(resource.getLocation().toFile().getPath());
				destinationFile = new File(deploymentDirPath + File.separator + project.getName() + File.separator
						+ "WEB-INF" + File.separator + "classes" + tempPath);
				FileUtils.copyFile(sourceFile, destinationFile, true);

			} else if (!resource.getFileExtension().equals("java")) {
				resPath = resource.getProjectRelativePath().toString();
				tempPath = resPath.split("WebContent")[1];
				sourceFile = new File(resource.getLocation().toFile().getPath());
				destinationFile = new File(deploymentDirPath + File.separator + project.getName() + tempPath);
				FileUtils.copyFile(sourceFile, destinationFile, true);
			}

		}
	}
		
	/**
	 * set the updated resource
	 */
	@Override
	public void setUpdatedResource(IResource updatedResource) {
		resource = updatedResource;
	}

}

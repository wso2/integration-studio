/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.wso2plugin.template.manager.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Collection;

import org.apache.commons.io.IOUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.utils.MessageDialogUtils;
import org.wso2.developerstudio.eclipse.utils.archive.ArchiveManipulator;
import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.Activator;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.project.WSO2PluginProjectModel;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.ui.elements.WSO2PluginSampleExt;

public abstract class AbstractDefaultProjectTemplateManager implements IProjectTemplateManager{
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	public boolean executeSelectedProjectTemplate(WSO2PluginSampleExt element, String projectName) {
		boolean isFromGit = Boolean.parseBoolean(element.getIsUpdatedFromGit());
		String projectArchiveLoc = element.getPluginArchive();
		String pluginID = element.getBundleID();
		return openZipArchive(projectArchiveLoc, projectName, pluginID, isFromGit);
	}

	public boolean openZipArchive(String projectArchiveLoc, String projectName, String pluginBundleID,
	                               boolean isFromLocalFileSys) {
		ITemporaryFileTag sampleTempTag = FileUtils.createNewTempTag();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProjectDescription newProjectDescription = workspace.newProjectDescription(projectName);
		IProject newProject = workspace.getRoot().getProject(projectName);
		try {
			newProject.create(newProjectDescription, null);

			newProject.open(null);
			URL zipLocationURL = null;
			if (isFromLocalFileSys) {
				zipLocationURL = new URL(WSO2PluginConstants.FILE_PROTOCOL + projectArchiveLoc);
			} else {
				zipLocationURL =
				                 FileLocator.find(Platform.getBundle(pluginBundleID), new Path(projectArchiveLoc), null);
			}
			File destinationFile = FileUtils.createTempFile();
			FileUtils.createFile(destinationFile, zipLocationURL.openStream());
			File resourceFile = destinationFile;

			File tempDir = FileUtils.createTempDirectory();
			File target = newProject.getLocation().toFile();
			File projectTempLocation = new File(tempDir, newProject.getName());

			ArchiveManipulator archiveManipulator = new ArchiveManipulator();
			archiveManipulator.extract(resourceFile, tempDir);
			File[] listFiles = tempDir.listFiles();
			String[] extensionArray = { "java" , "MF"};
			Collection<File> listofFiles = org.apache.commons.io.FileUtils.listFiles(tempDir, extensionArray, true);
			File[] fileArray = listofFiles.toArray(new File[listofFiles.size()]);
			for (File javaFile : fileArray) {
				if (javaFile.getName().contains("Activator.java") || javaFile.getName().contains("MANIFEST.MF")) {
					// read the file and change the plugin ID
					String content = IOUtils.toString(new FileInputStream(javaFile.getPath()), "UTF-8");
					content = content.replaceAll("plugin_id_to_be_renamed", newProject.getName());
					IOUtils.write(content, new FileOutputStream(javaFile.getPath()), "UTF-8");
				}
			}
			String sampleName = listFiles[0].getName();
			File sampleProjectTempLocation = new File(tempDir, sampleName);

			File projectDesc = new File(sampleProjectTempLocation, ".project");
			if (!sampleName.equals(newProject.getName())) {
				if (projectDesc.exists() && projectDesc.isFile()) {
					String parameterValue = newProject.getName();
					updateWithParameterData(projectDesc, parameterValue);
				}
			}
			FileUtils.copyDirectoryContents(sampleProjectTempLocation, projectTempLocation);
			FileUtils.copyDirectoryContents(projectTempLocation, target);
			newProject.refreshLocal(IResource.DEPTH_INFINITE, null);
			newProject.close(new NullProgressMonitor());
			newProject.refreshLocal(IResource.DEPTH_INFINITE, null);
			newProject.open(new NullProgressMonitor());
			newProject.refreshLocal(IResource.DEPTH_INFINITE, null);
			sampleTempTag.clearAndEnd();
			return true;
		} catch (CoreException | IOException e) {
			try {
				newProject.delete(true, null);
			} catch (CoreException e1) {
				log.error("An Exception was thrown in deleting the new project  : " + newProject.getName() +
				          ", with the selected sample : " + projectArchiveLoc, e);
			}
			log.error("An Exception was thrown in creating the new project  : " + projectName +
			          ", with the selected sample : " + projectArchiveLoc, e);
			MultiStatus status =
			                     MessageDialogUtils.createMultiStatus(e.getLocalizedMessage(), e,
			                                                          WSO2PluginConstants.PACKAGE_ID);
			// show error dialog
			/*ErrorDialog.openError(this.getShell(), WSO2PluginConstants.ERROR_DIALOG_TITLE,
			                      "An Error Occurred in creating the specifid plugin. ", status);*/
			return false;
		}
	}
	
	protected void updateWithParameterData(File projectDesc, String parameterValue) throws IOException {
		String content = FileUtils.getContentAsString(projectDesc);
		content = MessageFormat.format(content, parameterValue);
		projectDesc.delete();
		FileUtils.writeContent(projectDesc, content);
	}
}

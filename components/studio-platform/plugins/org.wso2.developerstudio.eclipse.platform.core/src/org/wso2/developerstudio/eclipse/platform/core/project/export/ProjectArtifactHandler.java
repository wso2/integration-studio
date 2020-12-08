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

package org.wso2.developerstudio.eclipse.platform.core.project.export;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.storagemanager.StorageManager;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.Activator;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.wso2.developerstudio.eclipse.utils.file.TempFileUtils;

public abstract class ProjectArtifactHandler {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private NullProgressMonitor nullProgressMonitor = new NullProgressMonitor();

	public abstract List<IResource> exportArtifact(IProject projecmessaget) throws Exception;

	protected NullProgressMonitor getProgressMonitor() {
		return nullProgressMonitor;
	}

	protected File createTempProject() throws Exception {
		File tempProject = TempFileUtils.createTempFile("temp", Long.toString(System.currentTimeMillis()), null);
		tempProject.delete();
		tempProject.mkdir();
		return tempProject;
	}

	protected IPath getOutputPath(IJavaProject project) throws Exception {
		return ResourcesPlugin.getWorkspace().getRoot().getFolder(project.getOutputLocation()).getLocation();
	}

	protected IPath getResourcePath(IProject project) throws Exception {
		return project.getFolder("src" + File.separator + "main" + File.separator + "resources").getLocation();
	}

	protected IFile getTargetArchive(IProject project, String ext) throws Exception {
		String finalName = String.format("%s.%s", project.getName(), ext);
		IFolder binaries = project.getFolder("target");
		if (!binaries.exists()) {
			binaries.create(true, true, getProgressMonitor());
			binaries.setHidden(true);
		}
		IFile archive = project.getFile("target" + File.separator + finalName);
		return archive;
	}

	protected IFile getTargetArchive(IProject project, String version, String ext) throws Exception {
		String finalName = String.format("%s.%s", project.getName() + "_" + version, ext);
		IFolder binaries = project.getFolder("target");
		if (!binaries.exists()) {
			binaries.create(true, true, getProgressMonitor());
			binaries.setHidden(true);
		}
		IFile archive = project.getFile("target" + File.separator + finalName);
		return archive;
	}

	protected void clearTarget(IProject project) {
		try {
			project.build(IncrementalProjectBuilder.CLEAN_BUILD, getProgressMonitor());
			File target = project.getFolder("target").getLocation().toFile();
			
			if (null != target && target.exists()) {
				FileUtils.cleanDirectory(target);
			}
		
		} catch (Exception e) {
			log.error("Error while cleaning the target directory", e);
		}
	}

	protected IFolder getTempDirInWorksapce(String projectName, String dirName) {
		String dir = String.format("%s_%s", projectName, dirName);
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(".tmp");
		if (project.exists()) {
			IFolder tmpDir = project.getFolder(dir);
			if (!tmpDir.exists()) {
				try {
					tmpDir.create(false, true, null);
					return tmpDir;
				} catch (CoreException e) {
					return null;
				}
			} else {
				return tmpDir;
			}

		} else {
			try {
				project.create(null);
				return getTempDirInWorksapce(projectName, dir);
			} catch (Exception e) {
				return null;
			}
		}
	}

	protected void clearTempDirInWorksapce(String projectName, String dirName) {
		String dir = String.format("%s_%s", projectName, dirName);
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(".tmp");
		if (project.exists()) {
			IFolder tmpDir = project.getFolder(dir);
			if (tmpDir.exists()) {
				try {
					tmpDir.delete(true, null);
				} catch (CoreException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}

	/**
	 * create new StorageManager
	 * 
	 * @param project
	 * @return new StorageManager
	 */
	protected StorageManager createStorageManager(IProject project) {
		return new StorageManager(project.getLocation().toFile(), "false");
	}

	protected File createTempDir(File project, String name) throws Exception {
		File dir = TempFileUtils.createTempFile(name, null, project);
		dir.delete();
		dir.mkdir();
		return dir;
	}

	/**
	 * 
	 * @param project
	 * @return
	 * @throws Exception
	 */
	protected IPath buildJavaProject(IProject project) throws Exception {
		project.build(IncrementalProjectBuilder.CLEAN_BUILD, getProgressMonitor());
		project.build(IncrementalProjectBuilder.FULL_BUILD, getProgressMonitor());
		IJavaProject javaProject = JavaCore.create(project);
		return getOutputPath(javaProject);
	}

	protected void clearProject(IProject project) {
		try {
			project.delete(true, nullProgressMonitor);
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
		}
	}

}

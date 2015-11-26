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

package org.wso2.developerstudio.eclipse.artifact.registry.filter.project.export;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.storagemanager.StorageManager;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.manifest.BundleManifest;
import org.wso2.developerstudio.eclipse.platform.core.project.export.ProjectArtifactHandler;
import org.wso2.developerstudio.eclipse.utils.archive.ArchiveManipulator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class RegistryFilterArtifactHandler extends ProjectArtifactHandler {

	public List<IResource> exportArtifact(IProject project) {
		List<IResource> exportResources = new ArrayList<IResource>();
		List<String> exportedPackageList = new ArrayList<String>();
		if (!project.isOpen()) {
			return exportResources;
		}

		try {
			ArchiveManipulator archiveManipulator = new ArchiveManipulator();
			NullProgressMonitor nullProgressMonitor = new NullProgressMonitor();
			//cleaning target directory 
			clearTarget(project);
			//getting maven details
			MavenProject mavenProject = MavenUtils.getMavenProject(project.getFile("pom.xml")
					.getLocation().toFile());

			// First compile the code
			project.build(IncrementalProjectBuilder.FULL_BUILD, nullProgressMonitor);

			// Get the output location
			IJavaProject javaProject = JavaCore.create(project);
			IPath outPutPath = ResourcesPlugin.getWorkspace().getRoot().getFolder(
					javaProject.getOutputLocation()).getLocation();

			// get resource location
			IPath resources = project.getFolder(
					"src" + File.separator + "main" + File.separator + "resources").getLocation();

			// getting export packages
			for (IPackageFragment pkg : javaProject.getPackageFragments()) {
				if (pkg.getKind() == IPackageFragmentRoot.K_SOURCE) {
					if (pkg.hasChildren()) {
						exportedPackageList.add(pkg.getElementName());
					}
				}
			}

			IProject tempProject = ResourcesPlugin.getWorkspace().getRoot().getProject(
					".temp" + System.currentTimeMillis());
			tempProject.create(nullProgressMonitor);
			tempProject.open(nullProgressMonitor);
			tempProject.setHidden(true);

			org.eclipse.osgi.storagemanager.StorageManager manager = new StorageManager(tempProject
					.getLocation().toFile(), "false");

			File filterResources = manager.createTempFile("filter_resources");
			filterResources.delete();
			filterResources.mkdir();

			FileUtils.copyDirectoryContents(outPutPath.toFile(), filterResources); // copy binaries
			if (resources.toFile().exists()) {
				FileUtils.copyDirectoryContents(resources.toFile(), filterResources); // copy resources
			}

			/* writing manifest */
			BundleManifest manifest = new BundleManifest();
			manifest.setBundleName(project.getName());
			manifest.setBundleSymbolicName(project.getName());
			if (null != mavenProject.getModel().getDescription()
					&& !"".equals(mavenProject.getModel().getDescription())) {
				manifest.setBundleDescription(mavenProject.getModel().getDescription());
			} else {
				manifest.setBundleDescription(project.getName());
			}
			if (null != mavenProject.getModel().getVersion()
					&& !"".equals(mavenProject.getDescription())) {
				manifest.setBundleVersion(mavenProject.getModel().getVersion());
			} else {
				manifest.setBundleVersion("1.0.0");
			}
			manifest.setExportPackagesList(exportedPackageList);
			File metaInfDir = new File(filterResources, "META-INF");
			if (!metaInfDir.exists())
				metaInfDir.mkdir();
			File manifestFile = new File(metaInfDir, "MANIFEST.MF");
			FileUtils.createFile(manifestFile, manifest.toString());

			File tmpArchive = new File(tempProject.getLocation().toFile(), project.getName()
					.concat(".jar"));
			archiveManipulator.archiveDir(tmpArchive.toString(), filterResources.toString());
			IFolder binaries = project.getFolder("target");
			if (!binaries.exists()) {
				binaries.create(true, false, nullProgressMonitor);
				binaries.setHidden(true);
			}
			IFile bundleArchive = project.getFile("target/" + project.getName().concat(".jar"));
			FileUtils.copy(tmpArchive, bundleArchive.getLocation().toFile());
			exportResources.add((IResource) bundleArchive);

			// cleaning temp project
			tempProject.delete(true, nullProgressMonitor);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return exportResources;

	}

}

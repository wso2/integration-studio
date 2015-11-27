/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.brs.export;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.wso2.developerstudio.eclipse.platform.core.manifest.BundleManifest;
import org.wso2.developerstudio.eclipse.platform.core.project.export.ProjectArtifactHandler;
import org.wso2.developerstudio.eclipse.utils.archive.ArchiveManipulator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.file.TempFileUtils;

public class BRSExportHandler extends ProjectArtifactHandler {

	@Override
	public List<IResource> exportArtifact(IProject project) throws Exception {
		List<IResource> exportResources = new ArrayList<IResource>();
		ArchiveManipulator archiveManipulator = new ArchiveManipulator();
		NullProgressMonitor nullProgressMonitor = new NullProgressMonitor();

		clearTarget(project);
		project.build(IncrementalProjectBuilder.FULL_BUILD, nullProgressMonitor);
		IJavaProject javaProject = JavaCore.create(project);
		List<String> exportPac = getExportPackages(javaProject);
		BundleManifest manifest = new BundleManifest();
		manifest.setBundleName(project.getName());
		manifest.setBundleVersion("1.0");

		manifest.setExportPackagesList(exportPac);
		IPath outPutPath = ResourcesPlugin.getWorkspace().getRoot()
		.getFolder(javaProject.getOutputLocation()).getLocation();
		IPath rslmetaData = project.getFolder(
				"src" + File.separator + "main" + File.separator
				+ "ruleservice").getLocation();
		File tempProject = createTempProject();
		File brsAarResources = createTempDir(tempProject, "aar_resources");
		File brsJarResources = createTempDir(tempProject, "jar_resources");

		if (rslmetaData.toFile().exists()) {

			FileUtils.copyDirectoryContents(rslmetaData.toFile(),
					brsAarResources);
		}

		FileUtils.copyDirectoryContents(outPutPath.toFile(), brsJarResources);
		File metainfPath = new File(brsJarResources, "META-INF");
		metainfPath.mkdir();
		File manifestFile = new File(metainfPath, "MANIFEST.MF");
		FileUtils.createFile(manifestFile, manifest.toString());
		File tmpArchivejar = new File(tempProject, project.getName().concat(
		".jar"));
		archiveManipulator.archiveDir(tmpArchivejar.toString(),
				brsJarResources.toString());
		IFolder binaries = project.getFolder("target");

		if (!binaries.exists()) {
			binaries.create(true, true, nullProgressMonitor);
			binaries.setHidden(true);
		}

		/*IFile serviceArchivejar = project.getFile("jarFolder" + File.separator
				+ "lib" + File.separator + project.getName().concat(".jar"));*/
		IFile jarFile = project.getFile("src" + File.separator + "main" + File.separator
				+ "ruleservice" + File.separator + "lib" +File.separator+ project.getName().concat(".jar"));
		/*IPath jarFile = project.getFolder(
				"src" + File.separator + "main" + File.separator
				+ "ruleservice" + File.separator + "lib" +File.separator+ project.getName().concat(".jar")).getLocation();*/
		/*File libFolder = serviceArchivejar.getParent().getLocation().toFile();*/
		File libFolder =jarFile.getParent().getLocation().toFile();
		/*FileUtils.copy(tmpArchivejar, serviceArchivejar.getLocation().toFile());*/
		FileUtils.copy(tmpArchivejar, jarFile.getLocation().toFile());
		FileUtils.copyDirectoryContents(libFolder.getParentFile(),
				brsAarResources);
		/*FileUtils.copyDirectoryContents(libFolder.getParentFile(),
				brsAarResources);*/
		File tmpArchive = new File(tempProject, project.getName()
				.concat(".aar"));
		archiveManipulator.archiveDir(tmpArchive.toString(),
				brsAarResources.toString());
		IFile serviceArchive = getTargetArchive(project, "aar");
		FileUtils.copy(tmpArchive, serviceArchive.getLocation().toFile());
		exportResources.add(serviceArchive);
		TempFileUtils.cleanUp();

		return exportResources;
	}

	private List<String> getExportPackages(IJavaProject iJavaProject)
	throws CoreException, JavaModelException, Exception {
		ArrayList<String> exportedPackagesList = new ArrayList<String>();
		IPackageFragment[] packages = iJavaProject.getPackageFragments();
		for (IPackageFragment iPackageFragment : packages) {
			iPackageFragment.getElementName();
			if (iPackageFragment.getKind() == IPackageFragmentRoot.K_SOURCE) {
				if (iPackageFragment.hasChildren()) {
					exportedPackagesList.add(iPackageFragment.getElementName());
				}
			}
		}
		return exportedPackagesList;
	}

}

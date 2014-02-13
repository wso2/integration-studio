/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.registry.handler.project.export;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.manifest.BundleManifest;
import org.wso2.developerstudio.eclipse.platform.core.project.export.ProjectArtifactHandler;
import org.wso2.developerstudio.eclipse.utils.archive.ArchiveManipulator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.file.TempFileUtils;

public class RegistryHandlerArtifactHandler extends ProjectArtifactHandler {
	private static final String ACTIVATOR_FQN= "org.osgi.framework.BundleActivator";
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	public List<IResource> exportArtifact(IProject project) throws Exception {
		List<IResource> exportResources = new ArrayList<IResource>();
		List<String> exportedPackageList = new ArrayList<String>();
		String activatorClass = new String();
		String existingActivatorClass = new String();

		ArchiveManipulator archiveManipulator = new ArchiveManipulator();

		// getting maven details
		MavenProject mavenProject =  MavenUtils.getMavenProject(project.getFile("pom.xml")
		                                                              .getLocation().toFile());

		// Get the output location
		IJavaProject javaProject = JavaCore.create(project);

		clearTarget(project);
		IPath outPutPath = buildJavaProject(project);

		// get resource location
		IPath resources = getResourcePath(project);

		// getting export packages
		for (IPackageFragment pkg : javaProject.getPackageFragments()) {
			if (pkg.getKind() == IPackageFragmentRoot.K_SOURCE) {
				if (pkg.hasChildren()) {
					exportedPackageList.add(pkg.getElementName());
					for (ICompilationUnit compilationUnit : pkg.getCompilationUnits()) {
						IType[] types = compilationUnit.getTypes();
						for (IType type : types) {
							if (type.getSuperInterfaceNames().length > 0 &&
							    Arrays.asList(type.getSuperInterfaceNames())
							          .contains("BundleActivator")) {
								activatorClass = type.getFullyQualifiedName();
							}
						}
					}
				}
			}
		}
		
		List<Plugin> plugins = mavenProject.getBuild().getPlugins();
		for (Plugin plugin : plugins) {
			if("maven-bundle-plugin".equalsIgnoreCase(plugin.getArtifactId())){
				Xpp3Dom configurationNode = (Xpp3Dom) plugin.getConfiguration();
				Xpp3Dom[] instructions = configurationNode.getChildren("instructions");
				if(instructions.length==1){
					Xpp3Dom[] exportPackage = instructions[0].getChildren("Export-Package");
					if(exportPackage.length==1){
						exportedPackageList.clear(); //clear default configuration (All packages by default)
						String packages = exportPackage[0].getValue();
						if(packages!=null){
							exportedPackageList.addAll(Arrays.asList(packages.split(",")));
						}
					} else{
						log.warn("Invalid configuration for <Export-Package> entry"
								+ " using default configuration for <Export-Package>");
					}
				} else{
					log.warn("Invalid instructions configuration for plugin : maven-bundle-plugin"
							+ " using default configuration for <Export-Package>");
				}
				break; //not considering multiple versions of the maven-bundle-plugin
			}
		}

		File tempProject = createTempProject();

		File bundleResources = createTempDir(tempProject, "bundle_resources");

		if (exportedPackageList.size() > 0) {
			FileUtils.copyDirectoryContents(outPutPath.toFile(), bundleResources); // copy
			                                                                       // binaries
		}

		if (resources.toFile().exists()) {
			FileUtils.copyDirectoryContents(resources.toFile(), bundleResources); // copy
																				  // resources
		}
			
		@SuppressWarnings("unchecked")
		List<Dependency> dependencies = mavenProject.getDependencies();
		Iterator<Dependency> iterator = dependencies.iterator();
		while (iterator.hasNext()) {
			Dependency dependency = iterator.next();
			if ("system".equals(dependency.getScope())) {
				String systemPath = dependency.getSystemPath();
				if (systemPath != null && !systemPath.trim().isEmpty()) {
					systemPath = systemPath.replaceAll("^".concat(Pattern.quote("${basedir}/")), "");
					IFile jarFile = project.getFile(systemPath);
					if (jarFile.exists()) {
						archiveManipulator.extract(jarFile.getLocation().toFile(), bundleResources);
						// getting export packages
						IPackageFragmentRoot rootPkg = JavaCore.createJarPackageFragmentRootFrom(jarFile);

						for (IJavaElement item : rootPkg.getChildren()) {
							if (item instanceof IPackageFragment) {
								IPackageFragment pkg = (IPackageFragment) item;
								if (pkg.hasChildren()) {
									exportedPackageList.add(pkg.getElementName());
									for (IClassFile clazz : pkg.getClassFiles()) {
										IType type = clazz.getType();
										if (type.getSuperInterfaceNames().length > 0 &&
										    Arrays.asList(type.getSuperInterfaceNames())
										          .contains(ACTIVATOR_FQN)) {
											existingActivatorClass = type.getFullyQualifiedName();
										}
									}
								}
							}
						}
					}
				}
			}

		}
			
		if (activatorClass.trim().isEmpty()) {
			activatorClass = existingActivatorClass;
		}

		/* writing manifest */
		BundleManifest manifest = new BundleManifest();
		manifest.setBundleName(project.getName());
		manifest.setBundleSymbolicName(project.getName());
		if (null != mavenProject.getModel().getDescription() &&
		    !"".equals(mavenProject.getModel().getDescription())) {
			manifest.setBundleDescription(mavenProject.getModel().getDescription());
		} else {
			manifest.setBundleDescription(project.getName());
		}
		if (null != mavenProject.getModel().getVersion() &&
		    !"".equals(mavenProject.getDescription())) {
			manifest.setBundleVersion(mavenProject.getModel().getVersion());
		} else {
			manifest.setBundleVersion("1.0.0");
		}
		manifest.setBundleActivatorName(activatorClass);
		manifest.setExportPackagesList(exportedPackageList);
		File metaInfDir = new File(bundleResources, "META-INF");
		if (!metaInfDir.exists())
			metaInfDir.mkdir();
		File manifestFile = new File(metaInfDir, "MANIFEST.MF");
		FileUtils.createFile(manifestFile, manifest.toString());

		File tmpArchive = new File(tempProject, project.getName().concat(".jar"));
		archiveManipulator.archiveDir(tmpArchive.toString(), bundleResources.toString());

		IFile bundleArchive = getTargetArchive(project, "jar");
		FileUtils.copy(tmpArchive, bundleArchive.getLocation().toFile());
		exportResources.add((IResource) bundleArchive);

		TempFileUtils.cleanUp();

		return exportResources;

	}

}

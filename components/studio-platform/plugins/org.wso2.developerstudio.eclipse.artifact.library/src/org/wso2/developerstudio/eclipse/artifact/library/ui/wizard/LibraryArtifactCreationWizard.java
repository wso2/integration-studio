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

package org.wso2.developerstudio.eclipse.artifact.library.ui.wizard;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.Repository;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.wizard.IWizardPage;
import org.wso2.developerstudio.eclipse.artifact.library.Activator;
import org.wso2.developerstudio.eclipse.artifact.library.model.LibraryArtifactModel;
import org.wso2.developerstudio.eclipse.artifact.library.util.Constants;
import org.wso2.developerstudio.eclipse.artifact.library.util.LibraryImageUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.bundle.BundlesDataInfo;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.MavenDetailsPage;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.ProjectOptionsDataPage;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaLibraryBean;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaLibraryUtil;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class LibraryArtifactCreationWizard extends
		AbstractWSO2ProjectCreationWizard {
	
	private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Library Artifact Project";
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	private LibraryArtifactModel libraryModel;
	private NewJavaLibraryWizardPage javaLibraryWizardPage;
	private IWizardPage[] pages;

	public LibraryArtifactCreationWizard() {
		libraryModel = new LibraryArtifactModel();
		setLibraryModel(libraryModel);
		setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
		setModel(getLibraryModel());
		setDefaultPageImageDescriptor(LibraryImageUtils.getInstance().getImageDescriptor("jar-wizard.png"));
	}

	public IResource getCreatedResource() {
		return null;
	}

	public boolean performFinish() {
		try {
			
			IProject project = createNewProject();
			List<Dependency> dependencyList = new ArrayList<Dependency>();
			
			List<String> exportedPackages = fillDependencyList(project, libraryModel, dependencyList);
			StringBuffer sb = new StringBuffer();
			for(String exportedpackage : exportedPackages) {
				sb.append(exportedpackage.trim()).append(",");
			}
			String exportPackageNodeValue = sb.toString().trim().replaceAll(",$","");

			File pomfile = project.getFile("pom.xml").getLocation().toFile();
			getModel().getMavenInfo().setPackageName("bundle");
			if (!pomfile.exists()) {
				createPOM(pomfile);
			}
			
			MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);

			mavenProject.getModel().getProperties().put("CApp.type","lib/library/bundle");
			
			Plugin plugin = MavenUtils.createPluginEntry(mavenProject,
					"org.apache.felix", "maven-bundle-plugin", "2.3.4",
					true);
			
			Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode(plugin);
			Xpp3Dom instructionNode = MavenUtils.createXpp3Node(configurationNode, "instructions");
			Xpp3Dom symbolicNameNode = MavenUtils.createXpp3Node(instructionNode, "Bundle-SymbolicName");
			symbolicNameNode.setValue(mavenProject.getArtifactId());
			Xpp3Dom bundleNameNode = MavenUtils.createXpp3Node(instructionNode, "Bundle-Name");
			bundleNameNode.setValue(mavenProject.getArtifactId());
			Xpp3Dom exportPackageNode = MavenUtils.createXpp3Node(instructionNode, "Export-Package");
			exportPackageNode.setValue(exportPackageNodeValue);
			Xpp3Dom dynamicImportNode = MavenUtils.createXpp3Node(instructionNode, "DynamicImport-Package");
			dynamicImportNode.setValue("*");
			if (libraryModel.isFragmentHostBundle()) {
				Xpp3Dom fragmentHostNode = MavenUtils.createXpp3Node(instructionNode, "Fragment-Host");
				fragmentHostNode.setValue(libraryModel.getFragmentHostBundleName());
			}
		

			Repository repo = new Repository();
			repo.setUrl("http://dist.wso2.org/maven2");
			repo.setId("wso2-maven2-repository-1");

			mavenProject.getModel().addRepository(repo);
			mavenProject.getModel().addPluginRepository(repo);		

			MavenUtils.addMavenDependency(mavenProject, dependencyList);
			MavenUtils.saveMavenProject(mavenProject, pomfile);
			
			
			ProjectUtils.addNatureToProject(project, false,
					Constants.LIBRARY_PROJECT_NATURE);
			MavenUtils
			.updateWithMavenEclipsePlugin(
					pomfile,
					new String[] { },
					new String[] { Constants.LIBRARY_PROJECT_NATURE });
			project.refreshLocal(IResource.DEPTH_INFINITE,
					new NullProgressMonitor());
			refreshDistProjects();

		} catch (Exception e) {
			log.warn("An Unspecified Error has occurred", e);
		}

		return true;
	}

	
	public void addPages() {
		javaLibraryWizardPage = new NewJavaLibraryWizardPage();
		super.addPages();
		addPage(javaLibraryWizardPage);
		pages = getPages();
	}

	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = super.getNextPage(page);
		if (page instanceof ProjectOptionsDataPage) {
			nextPage = javaLibraryWizardPage;
		}
		if (page instanceof NewJavaLibraryWizardPage) {
			nextPage = pages[1];
		}
		if (page instanceof MavenDetailsPage) {
			nextPage = null;

		}
		return nextPage;
	}

	public IWizardPage getPreviousPage(IWizardPage page) {
		IWizardPage previousPage = super.getNextPage(page);
		if (page instanceof MavenDetailsPage) {
			previousPage = javaLibraryWizardPage;
		}
		if (page instanceof NewJavaLibraryWizardPage) {
			previousPage = pages[0];
		}
		return previousPage;
	}

	public boolean canFinish() {
		if (getContainer().getCurrentPage() instanceof ProjectOptionsDataPage) {
			return false;
		}
		return super.canFinish();
	}

	public void setLibraryModel(LibraryArtifactModel libraryModel) {
		this.libraryModel = libraryModel;
	}

	public LibraryArtifactModel getLibraryModel() {
		return libraryModel;
	}
	
	public static List<String> fillDependencyList(IProject project, LibraryArtifactModel libraryModel, 
			List<Dependency> dependencyList) throws JavaModelException,
			Exception, CoreException, IOException {
		
		IFile bundlesDataFile = project.getFile("bundles-data.xml");
		List<String> exportedPackages = new ArrayList<String>();
		
		BundlesDataInfo bundleData = new BundlesDataInfo();
		if (libraryModel.isFragmentHostBundle()) {
			bundleData.setFragmentHost(libraryModel.getFragmentHostBundleName());
		}
		
		List<IProject> projects = new ArrayList<IProject>();
		for (Object resource : libraryModel.getLibraries()) {
			File libraryResource = null;
			if (resource instanceof File) {
				libraryResource = (File) resource;
			} else if (resource instanceof IFile) {
				libraryResource = new File(((IFile) resource).getLocation()
						.toOSString());
			} else if (resource instanceof IProject) {
				IProject workSpacePrj = (IProject) resource;
				projects.add(workSpacePrj);
				handleWorkspaceProjectResource(workSpacePrj);
			}
			if (libraryResource != null) {
				String dest = new File(project.getLocation().toFile(), libraryResource.getName()).toString();
				if (!libraryResource.toString().equals(dest)){
					FileUtils.copyFile(libraryResource.toString(), dest);
				}
			}
		}
		project.refreshLocal(IResource.DEPTH_INFINITE,
				new NullProgressMonitor());

		File[] jarsList = project.getLocation().toFile()
				.listFiles(new FilenameFilter() {

					public boolean accept(File file, String name) {
						return name.endsWith(".jar");
					}
				});
		
		Map<File, ArrayList<String>> exportedPackagesInfoMap = FileUtils.processJarList(jarsList);
		
		for (File jarFile : exportedPackagesInfoMap.keySet()) {
			if (isExistsInLibraryModel(jarFile, libraryModel)) {
			
				Path base = new Path(project.getLocation().toFile().toString());
				
				ArrayList<String> packages = exportedPackagesInfoMap.get(jarFile);
				exportedPackages.addAll(packages);
				bundleData.createJarElement(jarFile.getName(), exportedPackagesInfoMap.get(jarFile));
				
				Dependency dependency = new Dependency();
				dependency.setArtifactId(jarFile.getName());
				dependency.setGroupId("dummy.groupid");
				dependency.setVersion("1.0.0");
				dependency.setScope("system");
				dependency.setSystemPath("${basedir}/" + jarFile.toString().substring(base.toFile().getPath().length() + 1) );
				dependencyList.add(dependency);
			}
			else {
				try {
					jarFile.delete();
				} catch (Exception e) {
					log.warn("Failed to remove unused jar file(s)", e);
				}
			}
		}
		
		for (IProject prj : projects) {
			IFile pomFile = prj.getFile("pom.xml");
			if(pomFile.exists()) {
				try {
					MavenProject mavenProject = MavenUtils.getMavenProject(pomFile.getLocation().toFile());
					Dependency dependency = new Dependency();
					dependency.setArtifactId(mavenProject.getArtifactId());
					dependency.setGroupId(mavenProject.getGroupId());
					dependency.setVersion(mavenProject.getVersion());
					dependencyList.add(dependency);
				} catch (Exception e) {
					log.warn("Error reading "+ pomFile, e);
				}
			}
			bundleData.createProjectElement(prj, new ArrayList<String>());
			IJavaProject javaProject = JavaCore.create(prj);
			for (IPackageFragment pkg : javaProject.getPackageFragments()) {
				if (pkg.getKind() == IPackageFragmentRoot.K_SOURCE) {
					if (pkg.hasChildren()) {
						exportedPackages.add(pkg.getElementName());
					}
				}
			}
		}
		

		bundleData.toFile(bundlesDataFile);
		project.refreshLocal(IResource.DEPTH_INFINITE,
				new NullProgressMonitor());
		bundlesDataFile.setHidden(true);
		
		return exportedPackages;
	}

	private static void handleWorkspaceProjectResource(IProject workSpacePrj)
			throws JavaModelException, Exception, CoreException {
		File pomfile = workSpacePrj.getFile("pom.xml").getLocation().toFile();
		if (!pomfile.exists()) {
			String srcDir = "src";
			MavenProject mavenProject = MavenUtils.createMavenProject(
					"org.wso2.carbon." + workSpacePrj.getName(),
					workSpacePrj.getName(), "1.0.0", "jar");
			IJavaProject javaProject = JavaCore.create(workSpacePrj);
			IClasspathEntry[] classpath = javaProject.getRawClasspath();
			int entryCount = 0;
			for (IClasspathEntry classpathEntry : classpath) {
				if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
					if (entryCount == 0) {
						String entryPath = "";
						String[] pathSegments = classpathEntry.getPath().segments();
						if(pathSegments.length >1){
							for (int i = 1; i < pathSegments.length; i++) {
								if(i==1){
									entryPath = pathSegments[i];
								} else{
									entryPath += "/" + pathSegments[i];
								}
							}
							if(entryPath.length()>0){
								srcDir = entryPath;
								++entryCount;
							}
						}
					} else {
						log.warn("multiple source directories found, Considering '" + srcDir + "' as source directory");
						break;
					}
				}
			}
			if(entryCount==0){
				log.warn("No source directory specified, using default source directory.");
			}
			
			/* adding wso2 nexus repository */
			Repository nexusRepo = new Repository();
			nexusRepo.setUrl("http://maven.wso2.org/nexus/content/groups/wso2-public/");
			nexusRepo.setId("wso2-maven2-repository-1");
			mavenProject.getModel().addRepository(nexusRepo);
			mavenProject.getModel().addPluginRepository(nexusRepo);
			
			/* adding maven dependencies */
			List<Dependency> libList = new ArrayList<Dependency>();
			Map<String, JavaLibraryBean> dependencyMap = JavaLibraryUtil
					.getDependencyInfoMap(workSpacePrj);

			for (JavaLibraryBean bean : dependencyMap.values()) {
				Dependency dependency = new Dependency();
				dependency.setArtifactId(bean.getArtifactId());
				dependency.setGroupId(bean.getGroupId());
				dependency.setVersion(bean.getVersion());
				libList.add(dependency);
			}
			mavenProject.setDependencies(libList);
			
			mavenProject.getBuild().setSourceDirectory(srcDir);
			MavenUtils.saveMavenProject(mavenProject, pomfile);
		}
		workSpacePrj.refreshLocal(IResource.DEPTH_INFINITE,
				new NullProgressMonitor());
	}

	private static boolean isExistsInLibraryModel(File jarFile, LibraryArtifactModel libraryModel) {
		for (Object resource : libraryModel.getLibraries()) {
			File libraryResource = null;
			if (resource instanceof File) {
				libraryResource = (File) resource;
			} else if (resource instanceof IFile) {
				libraryResource = new File(((IFile) resource).getLocation().toOSString());
			}
			if (libraryResource != null){
				if (libraryResource.getName().equals(jarFile.getName())){
						return true;
				}
			}
		}
		return false;
	}
}

package org.wso2.developerstudio.eclipse.greg.registry.aspects.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.wso2.developerstudio.eclipse.greg.registry.aspects.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.maven.util.ProjectDependencyConstants;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaLibraryBean;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaLibraryUtil;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;

public class RegistryAspectMavenUtils {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static IProject aspectProject;
	private static MavenProject mavenProject;

	public static void initMavenConfiguration(IProject project) {
		aspectProject = project;

		IFile file = aspectProject.getFile("pom.xml");
		if (file.exists()) {
			try {
				mavenProject = MavenUtils.getMavenProject(file.getLocation().toFile());

				MavenUtils.updateMavenProjectWithWSO2Repository(mavenProject);
			} catch (Exception e) {
				log.error("Error occured while trying to generate the Maven Project from existing pom.xml",
				          e);
			}
		} else {
			generatePOM();
		}

		try {

			addProjectDependenciesToPom(project);

			MavenUtils.saveMavenProject(mavenProject, file.getLocation().toFile());

			aspectProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (Exception e) {
			log.error("Error occured while trying to generate the pom.xml for the project " +
			          aspectProject.getName(), e);
		}
	}

	private static void addProjectDependenciesToPom(IProject project) throws Exception {
	    List<Dependency> dependencyList = new ArrayList<Dependency>();

	    Map<String, JavaLibraryBean> dependencyInfoMap =
	                                                     JavaLibraryUtil.getDependencyInfoMap(project);
	    Map<String, String> map = ProjectDependencyConstants.DEPENDENCY_MAP;
	    for (JavaLibraryBean bean : dependencyInfoMap.values()) {
	    	if (bean.getVersion().contains("${")) {
	    		for (String path : map.keySet()) {
	    			bean.setVersion(bean.getVersion().replace(path, map.get(path)));
	    		}
	    	}
	    	Dependency dependency = new Dependency();
	    	dependency.setArtifactId(bean.getArtifactId());
	    	dependency.setGroupId(bean.getGroupId());
	    	dependency.setVersion(bean.getVersion());
	    	dependencyList.add(dependency);
	    }
	    MavenUtils.addMavenDependency(mavenProject, dependencyList);
    }

	private static void generatePOM() {
		mavenProject =
		               MavenUtils.createMavenProject("org.wso2.maven", aspectProject.getName(),
		                                             "1.0.0", "jar");

		MavenUtils.addMavenCompilerPlugin(mavenProject);

		MavenUtils.addMavenJarPlugin(mavenProject);

		MavenUtils.updateMavenProjectWithWSO2Repository(mavenProject);

		addSourceDirectory();
	}

	private static void addSourceDirectory() {
		IPackageFragmentRoot[] sourceFoldersForProject;
		try {
			sourceFoldersForProject = JavaUtils.getSourceFoldersForProject(aspectProject);
			String relativePath =
			                      FileUtils.getRelativePath(aspectProject.getLocation().toFile(),
			                                                sourceFoldersForProject[0].getResource()
			                                                                          .getLocation()
			                                                                          .toFile());
			MavenUtils.setSourceFolder(mavenProject, relativePath);
		} catch (JavaModelException e) {
			log.error("Errorr occured while trying to set the maven source directory", e);
		}
	}

}

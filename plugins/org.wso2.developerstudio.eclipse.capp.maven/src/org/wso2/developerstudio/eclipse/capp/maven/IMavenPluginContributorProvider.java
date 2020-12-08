package org.wso2.developerstudio.eclipse.capp.maven;

import java.util.Map;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IProject;

public interface IMavenPluginContributorProvider {
	public boolean addMavenPlugin(MavenProject mavenProject, IProject eclipseProject, Map<String,String> artifactTypeExtensionMap);
	public boolean updateMavenPlugin(MavenProject mavenProject, IProject eclipseProject, Map<String,String> artifactTypeExtensionMap);
}

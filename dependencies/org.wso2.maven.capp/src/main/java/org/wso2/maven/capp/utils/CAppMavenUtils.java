package org.wso2.maven.capp.utils;

import org.apache.maven.project.MavenProject;
import org.wso2.maven.capp.model.Artifact;
import org.wso2.maven.core.utils.MavenUtils;

public class CAppMavenUtils extends MavenUtils{
	public static final String CAPP_SCOPE_PREFIX = "capp";
	public static final String REPLACER_DEFAULT_DELIMETER = "${}";
	
	public static MavenProject createMavenProject(Artifact artifact, String groupId, String packagingType){
		String artifactId = artifact.getName();
		String version = artifact.getVersion();
		return createMavenProject(groupId, artifactId, version, packagingType);
	}

}

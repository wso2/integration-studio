package org.wso2.maven.capp.utils;

import org.apache.maven.project.MavenProject;
import org.wso2.maven.capp.model.Artifact;
import org.wso2.maven.core.utils.MavenUtils;

public class CAppMavenUtils extends MavenUtils{
	public static final String CAPP_SCOPE_PREFIX = "capp";
	public static final String REPLACER_DEFAULT_DELIMETER = "${}";
	public static final String XML_DEPENDENCY_TYPE = "xml";
	public static final String ZIP_DEPENDENCY_TYPE = "zip";
	public static final String POM_FILE_NAME = "pom.xml";
	public static final String RESOURCES_DIR_NAME = "resources";
	public static final String TARGET_DIR_NAME = "target";
	public static final String REGISTRY_INFO_FILE_NAME = "registry-info.xml";
	
	public static MavenProject createMavenProject(Artifact artifact, String groupId, String packagingType){
		String artifactId = artifact.getName();
		String version = artifact.getVersion();
		return createMavenProject(groupId, artifactId, version, packagingType);
	}

}

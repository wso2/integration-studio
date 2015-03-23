package org.wso2.maven.plugin.dataservice;

import java.io.File;
import java.io.IOException;

import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.codehaus.plexus.util.FileUtils;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.wso2.maven.capp.model.Artifact;
import org.wso2.maven.capp.mojo.AbstractPOMGenMojo;
import org.wso2.maven.capp.utils.CAppMavenUtils;
import org.wso2.maven.capp.utils.WSO2MavenPluginConstantants;

/**
 * This is the Maven Mojo used for generating a pom for a dataservice artifact
 * from the old CApp project structure
 *
 * @goal pom-gen
 *
 */
public class DataServicePOMGenMojo extends AbstractPOMGenMojo  {


	/**
	 * @parameter default-value="${project}"
	 */
	public MavenProject project;

	/**
	 * Maven ProjectHelper.
	 *
	 * @component
	 */
	public MavenProjectHelper projectHelper;

	/**
	 * The path of the location to output the pom
	 *
	 * @parameter expression="${project.build.directory}/artifacts"
	 */
	public File outputLocation;

	/**
	 * The resulting extension of the file
	 *
	 * @parameter
	 */
	public File artifactLocation;

	/**
	 * POM location for the module project
	 *
	 * @parameter expression="${project.build.directory}/pom.xml"
	 */
	public File moduleProject;

	/**
	 * Group id to use for the generated pom
	 *
	 * @parameter
	 */
	public String groupId;

	/**
	 * Comma separated list of "artifact_type=extension" to be used when creating dependencies for other capp artifacts
	 *
	 * @parameter
	 */
	public String typeList;


	private static final String ARTIFACT_TYPE="service/dataservice";


	protected void copyResources(MavenProject project, File projectLocation, Artifact artifact)throws IOException {
		File jaxWSArtifact = artifact.getFile();
		FileUtils.copyFile(jaxWSArtifact, new File(projectLocation, jaxWSArtifact.getName()));
	}
	protected void addPlugins(MavenProject artifactMavenProject, Artifact artifact) {
		Plugin plugin = CAppMavenUtils.createPluginEntry(artifactMavenProject,"org.wso2.maven","maven-dataservice-plugin",WSO2MavenPluginConstantants.MAVEN_DATA_SERVICE_PLUGIN_VERSION,true);
		Xpp3Dom configuration = (Xpp3Dom)plugin.getConfiguration();
		//add configuration
		Xpp3Dom aritfact = CAppMavenUtils.createConfigurationNode(configuration,"artifact");
		aritfact.setValue(artifact.getFile().getName());
	}

	protected String getArtifactType() {
		return ARTIFACT_TYPE;
	}


}

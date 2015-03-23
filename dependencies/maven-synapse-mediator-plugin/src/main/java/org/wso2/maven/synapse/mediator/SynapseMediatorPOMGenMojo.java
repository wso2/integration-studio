package org.wso2.maven.synapse.mediator;

import java.io.File;
import java.util.List;

import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactResolver;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.wso2.maven.capp.bundleartifact.AbstractBundlePOMGenMojo;
import org.wso2.maven.capp.model.Artifact;

/**
 * This is the Maven Mojo used for generating a pom for a synapse custome mediator artifact 
 * from the old CApp project structure
 * 
 * @goal pom-gen
 * 
 */
public class SynapseMediatorPOMGenMojo extends AbstractBundlePOMGenMojo {
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

	/**
	 * A list of projects in eclipse workspace which can be referred using maven groupid, artifactid, version
	 * 
	 * @parameter
	 */
	private List<String> projects;

    /**
     * @component
     */
    public ArtifactFactory artifactFactory;

    /**
     * @component
     */
    public ArtifactResolver resolver;

    /**
     * @parameter default-value="${localRepository}"
     */
    public ArtifactRepository localRepository;

    /**
     * @parameter default-value="${project.remoteArtifactRepositories}"
     */
    public List<?> remoteRepositories;


	private static final String ARTIFACT_TYPE="lib/synapse/mediator";

	protected String getArtifactType() {
		return ARTIFACT_TYPE;
	}

	protected String getBundleActivatorClass() {
		return null;
	}

	protected List<String> getProjectMapStrings() {
		return projects;
	}

	public ArtifactFactory getArtifactFactory() {
		return artifactFactory;
	}

	public ArtifactResolver getResolver() {
		return resolver;
	}

	public ArtifactRepository getLocalRepository() {
		return localRepository;
	}

	public List<?> getRemoteRepositories() {
		return remoteRepositories;
	}

	protected String getBundleActivatorClass(Artifact artifact) {
		return null;
	}
	
	protected void addPlugins(MavenProject artifactMavenProject,Artifact artifact) {
		addMavenBundlePlugin(artifactMavenProject, artifact);
	}

}

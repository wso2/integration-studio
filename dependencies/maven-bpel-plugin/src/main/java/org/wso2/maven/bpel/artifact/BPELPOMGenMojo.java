/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.maven.bpel.artifact;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;

import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactResolver;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.codehaus.plexus.util.FileUtils;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.wso2.maven.capp.bundleartifact.AbstractBundlePOMGenMojo;
import org.wso2.maven.capp.model.Artifact;
import org.wso2.maven.capp.model.BundlesDataInfo;
import org.wso2.maven.capp.mojo.AbstractPOMGenMojo;
import org.wso2.maven.capp.utils.CAppMavenUtils;
import org.wso2.maven.capp.utils.WSO2MavenPluginConstantants;

/**
 * This is the Maven Mojo used for generating a pom for a BPEL artifact from the
 * old CApp project structure
 *
 * @goal pom-gen
 *
 */
public class BPELPOMGenMojo extends AbstractBundlePOMGenMojo {
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
	 * Comma separated list of "artifact_type=extension" to be used when
	 * creating dependencies for other capp artifacts
	 *
	 * @parameter
	 */
	public String typeList;

	/**
	 * A list of projects in eclipse workspace which can be referred using maven
	 * groupid, artifactid, version
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

	private static final String ARTIFACT_TYPE = "bpel/workflow";

	private BundlesDataInfo bundlesDataInfo;

	private List<String> artifactProjects;

	protected String getArtifactType() {
		return ARTIFACT_TYPE;
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

	protected void addPlugins(MavenProject artifactMavenProject, Artifact artifact) {
		Plugin pluginAxis2 =
		                     CAppMavenUtils.createPluginEntry(artifactMavenProject,
		                                                      "org.wso2.maven",
		                                                      "maven-bpel-plugin",
		                                                      WSO2MavenPluginConstantants.MAVEN_BPEL_PLUGIN_VERSION,
		                                                      true);
		PluginExecution executionAxis2 = new PluginExecution();
		executionAxis2.setId("package-bpel");
		executionAxis2.setPhase("package");
		List goalsAxis2 = new ArrayList<String>();
		goalsAxis2.add("package-bpel");
		executionAxis2.setGoals(goalsAxis2);
		pluginAxis2.addExecution(executionAxis2);

		Xpp3Dom config = (Xpp3Dom) pluginAxis2.getConfiguration();
		Xpp3Dom artifactItems = CAppMavenUtils.createConfigurationNode(config, "artifact");
//		String relativePath =
//		                      org.wso2.developerstudio.eclipse.utils.file.FileUtils.getRelativePath(new File(
//		                                                                                                  artifact.getFile()
//		                                                                                                          .getParentFile()
//		                                                                                                          .getParentFile()
//		                                                                                                          .getParentFile()
//		                                                                                                          .getParentFile()
//		                                                                                                          .getParentFile()
//		                                                                                                          .getPath() +
//		                                                                                                          File.separator +
//		                                                                                                          "target" +
//		                                                                                                          File.separator +
//		                                                                                                          "capp" +
//		                                                                                                          File.separator +
//		                                                                                                          "artifacts" +
//		                                                                                                          File.separator +
//		                                                                                                          artifactMavenProject.getArtifactId()),
//		                                                                                         artifact.getFile());
		String relativePath=artifact.getFile().getName();
		artifactItems.setValue(relativePath);
	}

	protected BundlesDataInfo getBundlesDataInfo(File targetProjectLocation, Artifact artifact)
			throws FactoryConfigurationError {
		if (bundlesDataInfo == null) {
			try {
				bundlesDataInfo = new BundlesDataInfo();
				bundlesDataInfo.setProjects(getProjectMappings());
				List<String> artifactProjects = getArtifactProjects();
				for (String artifactProject : artifactProjects) {
					String[] artifactProjectData = artifactProject.split(":");
					if (artifactProjectData.length == 2 && artifactProjectData[0].equals(artifact.getName())) {
						String[] projectNames = artifactProjectData[1].split(",");
						for (String projectName : projectNames) {
							bundlesDataInfo.addProjectToList(projectName, null);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bundlesDataInfo;
	}

	public List<String> getArtifactProjects() {
		if (artifactProjects == null) {
			artifactProjects = new ArrayList<String>();
		}
		return artifactProjects;
	}
//
//	public void execute() throws MojoExecutionException, MojoFailureException {
//		// Nothing to do. No need to generate a pom.
//	}
	
	protected MavenProject createMavenProjectForCappArtifact(Artifact artifact,
	                                                         List<Artifact> artifacts,
	                                                         File projectLocation)
	                                                                              throws MojoExecutionException {
		if (artifact.getFile().getPath().endsWith(".zip")) {
	        MavenProject artifactMavenProject =
	                                            CAppMavenUtils.createMavenProject(artifact,
	                                                                              getGroupId(),
	                                                                              getArtifactType());
	        addDependencies(artifactMavenProject, artifact, projectLocation);
	        // Adding & configuring the plugin section
	        addPlugins(artifactMavenProject, artifact);
	        addMavenDependencies(artifactMavenProject, artifact, artifacts);
	        return artifactMavenProject;
        }else{
        	return null;
        }
	}
	
	protected void copyResources(MavenProject project, File projectLocation,
	                 			Artifact artifact) throws IOException {
		super.copyResources(project, projectLocation, artifact);
    	File bpelFileOriginal=artifact.getFile();
    	File bpelFileDest=new File(projectLocation+File.separator+bpelFileOriginal.getName());
    	
    	FileUtils.copyFile(bpelFileOriginal, bpelFileDest);
	}

}

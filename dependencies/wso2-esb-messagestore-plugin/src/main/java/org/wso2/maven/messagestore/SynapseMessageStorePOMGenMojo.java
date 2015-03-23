/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.maven.messagestore;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.model.Plugin;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.codehaus.plexus.util.FileUtils;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.wso2.maven.capp.model.Artifact;
import org.wso2.maven.capp.mojo.AbstractPOMGenMojo;
import org.wso2.maven.capp.utils.CAppMavenUtils;
import org.wso2.maven.capp.utils.WSO2MavenPluginConstantants;
import org.wso2.maven.esb.ESBArtifact;
import org.wso2.maven.esb.utils.ESBMavenUtils;

/**
 * This is the Maven Mojo used for generating a pom for a message-store artifact 
 * from the old CApp project structure
 * 
 * @goal pom-gen
 * 
 */
public class SynapseMessageStorePOMGenMojo extends AbstractPOMGenMojo {

	/**
	 * @parameter default-value="${project}"
	 */
	private MavenProject project;

	/**
	 * Maven ProjectHelper.
	 * 
	 * @component
	 */
	private MavenProjectHelper projectHelper;

	/**
	 * The path of the location to output the pom
	 * 
	 * @parameter expression="${project.build.directory}/artifacts"
	 */
	private File outputLocation;

	/**
	 * The resulting extension of the file
	 * 
	 * @parameter
	 */
	private File artifactLocation;
	
	/**
	 * POM location for the module project
	 * 
	 * @parameter expression="${project.build.directory}/pom.xml"
	 */
	private File moduleProject;
	
	/**
	 * Group id to use for the generated pom
	 * 
	 * @parameter
	 */
	private String groupId;
	
	/**
	 * Comma separated list of "artifact_type=extension" to be used when creating dependencies for other capp artifacts
	 * 
	 * @parameter
	 */
	public String typeList;
	
	private MavenProject mavenModuleProject;

	private static final String ARTIFACT_TYPE="synapse/message-store";
	
	private List<ESBArtifact> retrieveArtifacts() {
		return ESBMavenUtils.retrieveArtifacts(getArtifactLocation());
	}
	
	public void execute() throws MojoExecutionException, MojoFailureException {
		//Retrieving all the existing ESB Artifacts for the given Maven project 
		List<ESBArtifact> artifacts = retrieveArtifacts();
		
		//Artifact list
		List<Artifact> mappedArtifacts=new ArrayList<Artifact>();
		
		//Mapping ESBArtifacts to C-App artifacts so that we can reuse the maven-endpoint-plugin
		for (ESBArtifact esbArtifact : artifacts) {
	        Artifact artifact=new Artifact();
	        artifact.setName(esbArtifact.getName());
	        artifact.setVersion(esbArtifact.getVersion());
	        artifact.setType(esbArtifact.getType());
	        artifact.setServerRole(esbArtifact.getServerRole());
	        artifact.setFile(esbArtifact.getFile());
	        artifact.setSource(new File(getArtifactLocation(),"artifact.xml"));
	        mappedArtifacts.add(artifact);
        }
		//Calling the process artifacts method of super type to continue the sequence.
		super.processArtifacts(mappedArtifacts);

	}
	
	
	protected void copyResources(MavenProject project, File projectLocation, Artifact artifact)throws IOException {
		File sequenceArtifact = artifact.getFile();
		FileUtils.copyFile(sequenceArtifact, new File(projectLocation, sequenceArtifact.getName()));
	}
	
	protected void addPlugins(MavenProject artifactMavenProject, Artifact artifact) {
		Plugin plugin = CAppMavenUtils.createPluginEntry(artifactMavenProject,
				"org.wso2.maven", "wso2-esb-messagestore-plugin",
				WSO2MavenPluginConstantants.WSO2_ESB_MESSAGE_STORE_PLUGIN_VERSION,true);
		Xpp3Dom configuration = (Xpp3Dom)plugin.getConfiguration();
		//add configuration
		Xpp3Dom aritfact = CAppMavenUtils.createConfigurationNode(configuration,"artifact");
		aritfact.setValue(artifact.getFile().getName());
	}

	protected String getArtifactType() {
		return ARTIFACT_TYPE;
	}

	
}

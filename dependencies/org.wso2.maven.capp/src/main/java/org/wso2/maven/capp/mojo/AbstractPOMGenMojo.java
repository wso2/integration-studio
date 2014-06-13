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

package org.wso2.maven.capp.mojo;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Parent;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.wso2.maven.capp.model.Artifact;
import org.wso2.maven.capp.model.ArtifactDependency;
import org.wso2.maven.capp.utils.CAppMavenUtils;
import org.wso2.maven.capp.utils.CAppUtils;
import org.apache.maven.model.Repository;

public abstract class AbstractPOMGenMojo extends AbstractMojo {
	private static final String SYNAPSE_TYPE="synapse/configuration";

	/**
	 * @parameter default-value="${project}"
	 */
	public MavenProject project;

	/**
	 * @component
	 */
	public MavenProjectHelper projectHelper;

	public File outputLocation;

	public File artifactLocation;
	
	public File moduleProject;
	
	public String groupId;
	
	public String typeList;
	
	private MavenProject mavenModuleProject;

	private File projectLocation;

	public void execute() throws MojoExecutionException, MojoFailureException {
	
		List<Artifact> artifacts = retrieveArtifacts();
		
		processArtifacts(artifacts);

	}

	protected abstract String getArtifactType();
	
	private String getArtifactPostFix(){
		if (SYNAPSE_TYPE.equalsIgnoreCase(getArtifactType())) {
			return getArtifactType().substring(0,getArtifactType().indexOf("/"));
		}else{
			return getArtifactType().substring(getArtifactType().indexOf("/")+1);
		}
	}
	
	protected void processArtifacts(List<Artifact> artifacts)
			throws MojoExecutionException {
		if (artifacts.isEmpty()) {
			if(getLog().isDebugEnabled()){
				getLog().debug(System.currentTimeMillis()+" Artifacts list is empty. Nothing to process");
			}
			File projectLocation = new File(getOutputLocation() + "");

			projectLocation.mkdirs();
			setProjectLocation(projectLocation);
			getMavenModuleProject();
		} else {
			if(getLog().isDebugEnabled()){
				getLog().info(new Time(System.currentTimeMillis())+" Artifacts list is not empty. Start processing");
			}
			for (Artifact artifact : artifacts) {
				if (artifact.getType().equalsIgnoreCase(getArtifactType())) {
					
					if(getLog().isDebugEnabled()){
						getLog().debug(new Time(System.currentTimeMillis())+" Creating maven project for artifact ");
					}
					
					getLog().info("Creating maven project for artifact "
									+ artifact.getName() + ":"
									+ artifact.getVersion() + "...");
					
					if(getLog().isDebugEnabled()){
						getLog().debug(new Time(System.currentTimeMillis())+" Trying to generate the Maven Project...");
					}
					
					getLog().info("\tgenerating maven project...");

					File projectLocation = new File(getOutputLocation()
							+ File.separator + getArtifactPostFix(),
							artifact.getName());

					projectLocation.mkdirs();
					setProjectLocation(projectLocation);

					// This will be null if the artifact is referencing to a
					// workspace project.
					MavenProject artifactMavenProject = createMavenProjectForCappArtifact(
							artifact, artifacts, projectLocation);
					artifactMavenProject.setDistributionManagement(project.getDistributionManagement());
					
					if(getLog().isDebugEnabled()){
						getLog().debug(new Time(System.currentTimeMillis())+" Maven Project generation completed");
					}

					if (artifactMavenProject != null) {
						if(getLog().isDebugEnabled()){
							getLog().debug(new Time(System.currentTimeMillis())+" Generated Maven project is not null");
						}
						
						try {
							if(getLog().isDebugEnabled()){
								getLog().debug(new Time(System.currentTimeMillis())+" copying resources...");
							}
							
							getLog().info("\tcopying resources...");
							String artifactAsMavenModule = CAppMavenUtils
									.getMavenModuleRelativePath(
											getModuleProject(),
											projectLocation);
							List existingModules = getMavenModuleProject().getModules();
							if (!existingModules.contains(artifactAsMavenModule)) {
								existingModules.add(
										artifactAsMavenModule);
							}
							
							if(getLog().isDebugEnabled()){
								getLog().debug(new Time(System.currentTimeMillis())+" Module list is updated with new module.");
							}
//							Repository repo = new Repository();
//							repo.setUrl("http://dist.wso2.org/maven2");
//							repo.setId("wso2-maven2-repository-1");
//							artifactMavenProject.getModel().addRepository(repo);
//							artifactMavenProject.getModel()
//									.addPluginRepository(repo);
							
							//Add repositories defined in the parent project to the generated poms.
							List repositories = project.getRepositories();
							artifactMavenProject.getModel().getRepositories().addAll(repositories);
							artifactMavenProject.getModel().getPluginRepositories().addAll(repositories);
							
							if(getLog().isDebugEnabled()){
								getLog().debug(new Time(System.currentTimeMillis())+" Maven project successfully updated with Repositories");
							}
							
							CAppMavenUtils.saveMavenProject(
									artifactMavenProject, new File(
											projectLocation, "pom.xml"));
							CAppMavenUtils
									.saveMavenProject(getMavenModuleProject(),
											getModuleProject());
							
							if(getLog().isDebugEnabled()){
								getLog().debug(new Time(System.currentTimeMillis())+" Maven projects successfully saved");
							}
							
							copyResources(artifactMavenProject,
									projectLocation, artifact);
						} catch (Exception e) {
							throw new MojoExecutionException(
									"Error creating maven project for artifact '"
											+ artifact.getName() + "'", e);
						}
					}
				}
			}
		}
	}

	protected abstract void copyResources(MavenProject project, File projectLocation, Artifact artifact)throws IOException;

	protected MavenProject createMavenProjectForCappArtifact(Artifact artifact, List<Artifact> artifacts, File projectLocation)
			throws MojoExecutionException {
		MavenProject artifactMavenProject = CAppMavenUtils.createMavenProject(artifact, getGroupId()+"."+getArtifactPostFix(),getArtifactType());
		addDependencies(artifactMavenProject, artifact,projectLocation);

		//Adding & configuring the plugin section
		addPlugins(artifactMavenProject, artifact);
		
		addMavenDependencies(artifactMavenProject, artifact, artifacts);
		
		return artifactMavenProject;
	}

	protected void addMavenDependencies(MavenProject artifactMavenProject,
			Artifact artifact, List<Artifact> artifacts)
			throws MojoExecutionException {
		List<ArtifactDependency> dependencies = artifact.getDependencies();
		for (ArtifactDependency dependency : dependencies) {
			String dGroupId=getGroupId();
			String dArtifactId = dependency.getName();
			String dVersion = dependency.getVersion();
			String scope = CAppMavenUtils.CAPP_SCOPE_PREFIX;
			String type = getExtensionOfDependency(artifacts, dependency);
			addMavenDependency(artifactMavenProject, dGroupId, dArtifactId,
					dVersion, scope, type);
		}
	}

	protected void addMavenDependency(MavenProject artifactMavenProject,
			String dGroupId, String dArtifactId, String dVersion, String scope,
			String type) {
		Dependency mavenDependency = new Dependency();
		mavenDependency.setGroupId(dGroupId);
		mavenDependency.setArtifactId(dArtifactId);
		mavenDependency.setVersion(dVersion);
		mavenDependency.setScope(scope);
		if (type!=null) {
			mavenDependency.setType(type);
		}
		artifactMavenProject.getDependencies().add(mavenDependency);
	}
	
	protected void addDependencies(MavenProject artifactMavenProject, Artifact artifact, File projectLocation) {
		
	}
	
	protected String getExtensionOfDependency(List<Artifact> artifacts,
			ArtifactDependency dependency) {
		String type = null;
		String artifactType = null;
		for (Artifact existingArtifact : artifacts) {
			if (existingArtifact.getName().equals(dependency.getName()) && existingArtifact.getVersion().equals(dependency.getVersion())){
				artifactType=existingArtifact.getType();
			}
		}
		if (artifactType!=null && getTypeList().containsKey(artifactType)){
			type = getTypeList().get(artifactType);
		}
		return type;
	}

	protected abstract void addPlugins(MavenProject artifactMavenProject, Artifact artifact);

	private List<Artifact> retrieveArtifacts() {
		return CAppUtils.retrieveArtifacts(getArtifactLocation());
	}

	private MavenProject getMavenModuleProject() throws MojoExecutionException{
		if (mavenModuleProject==null) {
			try {
				if (!getModuleProject().exists()) {
					if (groupId==null){
						groupId=project.getGroupId();
					}
					mavenModuleProject = CAppMavenUtils.createMavenProject(groupId,
							getProject().getArtifactId() + "_module", getProject()
									.getVersion(), "pom");
					
					mavenModuleProject.getModel().setDistributionManagement(project.getDistributionManagement());
					CAppMavenUtils.saveMavenProject(mavenModuleProject, getModuleProject());
				}
				mavenModuleProject=CAppMavenUtils.getMavenProject(getModuleProject());
			} catch (Exception e) {
				throw new MojoExecutionException(
						"Error retrieving module parent project: "
								+ getModuleProject().toString(), e);
			}
		}
		return mavenModuleProject;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupId() throws MojoExecutionException {
		if (groupId==null){
			groupId=getMavenModuleProject().getGroupId();
		}
		return groupId;
	}

	public void setModuleProject(File moduleProject) {
		this.moduleProject = moduleProject;
	}

	public File getModuleProject() {
		if (!moduleProject.getName().equalsIgnoreCase("pom.xml")){
			moduleProject=new File(moduleProject,"pom.xml");
		}
		return moduleProject;
	}

	public void setArtifactLocation(File artifactLocation) {
		this.artifactLocation = artifactLocation;
	}

	public File getArtifactLocation() {
		return artifactLocation;
	}

	public void setOutputLocation(File outputLocation) {
		this.outputLocation = outputLocation;
	}

	public File getOutputLocation() {
		if (!outputLocation.exists()) {
			outputLocation.mkdirs();
		}
		return outputLocation;
	}
	public void setProject(MavenProject project) {
		this.project = project;
	}
	public MavenProject getProject() {
		return project;
	}

	public void setTypeList(String typeList) {
		this.typeList = typeList;
	}

	public Map<String,String> getTypeList() {
		Map<String,String> types=new HashMap<String, String>();
		if (typeList!=null) {
			String[] typeSet = typeList.split(",");
			for (String type : typeSet) {
				String[] typeData = type.split("=");
				types.put(typeData[0], typeData[1]);
			}
		}
		return types;
	}


	public void setProjectLocation(File projectLocation) {
		this.projectLocation = projectLocation;
	}

	public File getProjectLocation() {
		return projectLocation;
	}	
	
	protected File processTokenReplacement(Artifact artifact){
		return null;
		//Do nothing. Implementations should be done by impplementations
	}
	
	/**
	 * Replace artifact tokens with maven properties.
	 * @param content
	 * @param mavenProperties
	 * @return
	 */
	public String replaceTokens(String content, Properties mavenProperties) {
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile("\\$\\{(.*?)\\}");
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			String match = matcher.group(0).replaceAll("^\\$\\{", "");
			match = match.replaceAll("\\}$", "");
			String value = (String) mavenProperties.get(match);
			if(value != null && !value.trim().equals("")){
				matcher.appendReplacement(sb, value);
				getLog().info("Replacing the token: "+match+" with value: "+value);
			}		
		}
		matcher.appendTail(sb);
		return sb.toString();
	}
}

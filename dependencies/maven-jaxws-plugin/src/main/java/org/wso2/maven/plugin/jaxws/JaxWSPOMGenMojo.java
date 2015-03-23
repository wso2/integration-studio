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

package org.wso2.maven.plugin.jaxws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.stream.FactoryConfigurationError;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.codehaus.plexus.util.FileUtils;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.wso2.maven.capp.model.Artifact;
import org.wso2.maven.capp.mojo.AbstractPOMGenMojo;
import org.wso2.maven.capp.utils.CAppMavenUtils;
import org.wso2.maven.capp.utils.CAppUtils;
import org.wso2.maven.capp.utils.WSO2MavenPluginConstantants;
import org.wso2.maven.capp.model.BundlesDataInfo;
import org.wso2.maven.capp.model.ProjectMapping;
import org.wso2.maven.core.utils.MavenUtils;
/**
 * This is the Maven Mojo used for generating a pom for a JAX-WS artifact
 * from the old CApp project structure
 *
 * @goal pom-gen
 *
 */
public class JaxWSPOMGenMojo extends AbstractPOMGenMojo {

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
	 * A list of projects in eclipse workspace which is refered to by the registry handler configuration
	 * 
	 * @parameter
	 */
    private List<String> artifactProjects;


	private static final String ARTIFACT_TYPE="service/jaxws";
	
	private BundlesDataInfo bundlesDataInfo;

	protected BundlesDataInfo getBundlesDataInfo(File targetProjectLocation, Artifact artifact)throws FactoryConfigurationError {
		if (bundlesDataInfo==null) {
			try {
				bundlesDataInfo = new BundlesDataInfo();
				bundlesDataInfo.setProjects(getProjectMappings());
				List<String> artifactProjects = getArtifactProjects();
				for (String artifactProject : artifactProjects) {
					String[] artifactProjectData = artifactProject.split(":");
					if (artifactProjectData.length==2 && artifactProjectData[0].equals(artifact.getName())){
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
	
	protected List<String> getProjectMapStrings() {
		return projects;
	}
	
	public List<String> getArtifactProjects() {
		if (artifactProjects==null){
			artifactProjects=new ArrayList<String>();
		}
		return artifactProjects;
	}
	
	protected List<ProjectMapping> getProjectMappings() throws Exception{
		List<String> projects = getProjectMapStrings();
		List<ProjectMapping> projectMappings=new ArrayList<ProjectMapping>();
		if (projects!=null) {
			for (String project : projects) {
				projectMappings.add(ProjectMapping.getMapping(project));
			}
		}
		return projectMappings;
	}
	
	protected void copyResources(MavenProject project, File projectLocation, Artifact artifact)throws IOException {
		File jaxWSArtifact = artifact.getFile();
		FileUtils.copyFile(jaxWSArtifact, new File(projectLocation, jaxWSArtifact.getName()));
	}
	protected void addPlugins(MavenProject artifactMavenProject, Artifact artifact) {
		if (artifact.getFile().getPath().endsWith(".jar")) {
			Plugin plugin = CAppMavenUtils.createPluginEntry(artifactMavenProject,"org.wso2.maven","maven-jaxws-plugin",WSO2MavenPluginConstantants.MAVEN_JAXWS_PLUGIN_VERSION,true);
		//	Plugin plugin = CAppMavenUtils.createPluginEntry(artifactMavenProject,"org.apache.maven.plugins","maven-jar-plugin","2.3.1",true);
			Xpp3Dom configuration = (Xpp3Dom)plugin.getConfiguration();
			//add configuration
			Xpp3Dom aritfact = CAppMavenUtils.createConfigurationNode(configuration,"artifact");
			aritfact.setValue(artifact.getFile().getName());
		}else{
			artifactMavenProject.setPackaging("jar");
			artifactMavenProject.getModel().addProperty(CAppUtils.PROPERTY_CAPP_TYPE, getArtifactType());
			 getLog().info("Adding JAXWS reated plugins");
			 
		        Plugin plugin = CAppMavenUtils.createPluginEntry(artifactMavenProject,
		                                                         "org.apache.maven.plugins",
		                                                         "maven-dependency-plugin", "2.2", true);
		        PluginExecution execution = new PluginExecution();
		        execution.setId("unpack");
		        execution.setPhase("package");
		        List<String> goals = new ArrayList<String>();
		        goals.add("unpack");
		        execution.setGoals(goals);
		        plugin.addExecution(execution);
		        Xpp3Dom config = (Xpp3Dom) plugin.getConfiguration();
		        Xpp3Dom artifactItems = CAppMavenUtils.createConfigurationNode(config, "artifactItems");
		        Xpp3Dom artifactItem =
		                               CAppMavenUtils.createConfigurationNode(artifactItems,
		                                                                      "artifactItem");
		        List<ProjectMapping> projectMappings;
		        String serviceProject = null;
		        Properties properties = new Properties();
		        try {
			        properties.load(new FileInputStream(artifact.getFile()));
			        serviceProject = properties.getProperty("Projects");
		        } catch (FileNotFoundException e1) {
			        e1.printStackTrace();
		        } catch (IOException e1) {
			        e1.printStackTrace();
		        }
		        try {
			        projectMappings = getProjectMappings();

			        for (int i = 0; i < projectMappings.size(); i++) {
				        ProjectMapping projectMapping = projectMappings.get(i);

				        if (projectMapping.projectName.equalsIgnoreCase(serviceProject)) {
					        Xpp3Dom groupId =
					                          CAppMavenUtils.createConfigurationNode(artifactItem,
					                                                                 "groupId");
					        groupId.setValue(projectMapping.getGroupId());
					        Xpp3Dom artifactId =
					                             CAppMavenUtils.createConfigurationNode(artifactItem,
					                                                                    "artifactId");
					        artifactId.setValue(projectMapping.getArtifactId());
					        Xpp3Dom version =
					                          CAppMavenUtils.createConfigurationNode(artifactItem,
					                                                                 "version");
					        version.setValue(projectMapping.getVersion());
					        Xpp3Dom type = CAppMavenUtils.createConfigurationNode(artifactItem, "type");
					        type.setValue("jar");
					        Xpp3Dom overWrite =
					                            CAppMavenUtils.createConfigurationNode(artifactItem,
					                                                                   "overWrite");
					        overWrite.setValue("true");
					        Xpp3Dom outputDirectory =
					                                  CAppMavenUtils.createConfigurationNode(artifactItem,
					                                                                         "outputDirectory");
					        outputDirectory.setValue("target" + File.separator + "jar");
				        }
			        }
		        } catch (Exception e) {
			        getLog().error(e);
		        }
		        //Adding Jar plugin entry to build section
		        Plugin pluginJaxWs =
		                             CAppMavenUtils.createPluginEntry(artifactMavenProject,
		                                                              "org.apache.maven.plugins",
		                                                              "maven-jar-plugin",
		                                                              "2.3.1",
		                                                              true);
		        PluginExecution executionJaxWs = new PluginExecution();
		        executionJaxWs.setId("jar");
		        executionJaxWs.setPhase("package");
		        List<String> goalsJaxWs = new ArrayList<String>();
		        goalsJaxWs.add("jar");
		        executionJaxWs.setGoals(goalsJaxWs);
		        Xpp3Dom mainNode = MavenUtils.createMainConfigurationNode();
		        pluginJaxWs.setConfiguration(mainNode);
		        Xpp3Dom classDirNode =MavenUtils.createConfigurationNode(mainNode,"classesDirectory");
		        classDirNode.setValue("target" + File.separator + "jar");
		        Xpp3Dom includes =MavenUtils.createConfigurationNode(mainNode,"includes");
		        Xpp3Dom include = MavenUtils.createConfigurationNode(includes,"include");
		        include.setValue("**/*.class");
		        Xpp3Dom forceCreation = MavenUtils.createConfigurationNode(mainNode,"forceCreation");
		        forceCreation.setValue("true");
		        pluginJaxWs.setConfiguration(mainNode);
		        pluginJaxWs.addExecution(executionJaxWs);
		}
	}

	protected String getArtifactType() {
		return ARTIFACT_TYPE;
	}

}

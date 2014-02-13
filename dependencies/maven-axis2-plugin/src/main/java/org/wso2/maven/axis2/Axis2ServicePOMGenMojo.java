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

package org.wso2.maven.axis2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.stream.FactoryConfigurationError;

import org.apache.commons.io.FileUtils;
import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactResolver;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.wso2.maven.capp.model.Artifact;
import org.wso2.maven.capp.model.BundlesDataInfo;
import org.wso2.maven.capp.model.ProjectMapping;
import org.wso2.maven.capp.utils.CAppMavenUtils;
import org.wso2.maven.capp.utils.WSO2MavenPluginConstantants;
import org.wso2.maven.capp.bundleartifact.AbstractBundlePOMGenMojo;

/**
 * This is the Maven Mojo used for generating a pom for a Axis2 Service artifact 
 * from the old CApp project structure
 * 
 * @goal pom-gen
 * 
 */
public class Axis2ServicePOMGenMojo extends AbstractBundlePOMGenMojo {
	
	/**
	 * @parameter expression="${project}"
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

	/**
	 * A list of projects in eclipse workspace which is refered to by the registry handler configuration
	 * 
	 * @parameter
	 */
    private List<String> artifactProjects;
    
	private static final String ARTIFACT_TYPE="service/axis2";

	private BundlesDataInfo bundlesDataInfo;
	
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
	
	public List<String> getArtifactProjects() {
		if (artifactProjects==null){
			artifactProjects=new ArrayList<String>();
		}
		return artifactProjects;
	}

	/* (non-Javadoc)
     * @see org.wso2.maven.capp.bundleartifact.AbstractBundlePOMGenMojo#getBundleActivatorClass(org.wso2.maven.capp.model.Artifact)
     */
    protected String getBundleActivatorClass(Artifact artifact) {
	    return null;
    }
    
	protected void copyResources(MavenProject project, File projectLocation,
			Artifact artifact) throws IOException {
		super.copyResources(project, projectLocation, artifact);
		//If the user has created the service by using a service class.
		if (!artifact.getFile().getPath().endsWith(".aar")) {
	        File file =
	                    new File(projectLocation + File.separator + "src" + File.separator +
	                             "main" + File.separator + "resources" + File.separator +
	                             "META-INF");
	        if (!file.exists()) {
		        file.mkdirs();
	        }
	        File serviceFile = new File(file, "services.xml");
	        File metaFile = new File(file, "MANIFEST.MF");
	        File resourcesLocation =
	                                 new File(artifact.getFile().getParent() + File.separator +
	                                          "resources" + File.separator + "META-INF");
	        File serviceFileOriginal =
	                                   new File(resourcesLocation + File.separator + "services.xml");
	        File metaFileOriginal = new File(resourcesLocation + File.separator + "MANIFEST.MF");
	        FileUtils.copyFile(serviceFileOriginal, serviceFile);
	        FileUtils.copyFile(metaFileOriginal, metaFile);
	        
	        org.wso2.developerstudio.eclipse.utils.file.FileUtils.copyDirectoryContents(resourcesLocation, file);
        }else{
        	//If the artifact is created by pointing an aar file.
        	File aarFileOriginal=artifact.getFile();
        	File aarFileDest=new File(projectLocation+File.separator+aarFileOriginal.getName());
        	
        	FileUtils.copyFile(aarFileOriginal, aarFileDest);
        }
	}
    
	protected void addPlugins(MavenProject artifactMavenProject,Artifact artifact) {
		//This is if the user has created the Axis2 service using the source.
		if (!artifact.getFile().getPath().endsWith(".aar")) {
	        getLog().info("Adding Axis2 reated plugins");
	        Plugin plugin =
	                        CAppMavenUtils.createPluginEntry(artifactMavenProject,
	                                                         "org.apache.maven.plugins",
	                                                         "maven-dependency-plugin", "2.2", true);
	        PluginExecution execution = new PluginExecution();
	        execution.setId("unpack");
	        execution.setPhase("package");
	        List goals = new ArrayList<String>();
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
				        outputDirectory.setValue("target" + File.separator + "aar");
			        }
		        }
	        } catch (Exception e) {
		        getLog().error(e);
	        }
	        //Adding Axis2 plugin entry to build section
	        Plugin pluginAxis2 =
	                             CAppMavenUtils.createPluginEntry(artifactMavenProject,
	                                                              "org.wso2.maven",
	                                                              "maven-axis2-plugin",
	                                                              WSO2MavenPluginConstantants.MAVEN_AXIS2_PLUGIN_VERSION,
	                                                              true);
	        PluginExecution executionAxis2 = new PluginExecution();
	        executionAxis2.setId("aar");
	        executionAxis2.setPhase("package");
	        List goalsAxis2 = new ArrayList<String>();
	        goalsAxis2.add("aar");
	        executionAxis2.setGoals(goalsAxis2);
	        pluginAxis2.addExecution(executionAxis2);
        }else{
        	//If the user has created the project by pointing to existing aar service.
        	//Adding Axis2 plugin entry to build section
	        Plugin pluginAxis2 =
	                             CAppMavenUtils.createPluginEntry(artifactMavenProject,
	                                                              "org.wso2.maven",
	                                                              "maven-axis2-plugin",
	                                                              WSO2MavenPluginConstantants.MAVEN_AXIS2_PLUGIN_VERSION,
	                                                              true);
	        PluginExecution executionAxis2 = new PluginExecution();
	        executionAxis2.setId("package-aar");
	        executionAxis2.setPhase("package");
	        List goalsAxis2 = new ArrayList<String>();
	        goalsAxis2.add("package-aar");
	        executionAxis2.setGoals(goalsAxis2);
	        pluginAxis2.addExecution(executionAxis2);
	        
	        Xpp3Dom config = (Xpp3Dom) pluginAxis2.getConfiguration();
	        Xpp3Dom artifactItems = CAppMavenUtils.createConfigurationNode(config, "artifact");
//	        String relativePath=org.wso2.developerstudio.eclipse.utils.file.FileUtils.getRelativePath(new File(artifact.getFile().getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().getPath()+File.separator+"target"+File.separator+"capp"+File.separator+"artifacts"+File.separator+artifactMavenProject.getArtifactId()), artifact.getFile());
	        String relativePath=artifact.getFile().getName();
	        artifactItems.setValue(relativePath);
        }
		
		
	}
	
}

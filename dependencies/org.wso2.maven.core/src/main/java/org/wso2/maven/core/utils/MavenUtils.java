/*
* Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.maven.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactNotFoundException;
import org.apache.maven.artifact.resolver.ArtifactResolutionException;
import org.apache.maven.artifact.resolver.ArtifactResolver;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class MavenUtils {
	public static final String BUNDLE_PACKAGING_TYPE = "bundle";
	public static final String WAR_PACKAGING_TYPE = "war";
	public static final String POM_PACKAGING_TYPE = "pom";
	public static final String JAR_PACKAGING_TYPE = "jar";

	public static void addMavenDependency(MavenProject mavenProject,
			List<Dependency> dependencies) {
		addMavenDependency(mavenProject,dependencies.toArray(new Dependency[]{}));
	}

	public static void addMavenDependency(MavenProject mavenProject, Dependency...dependencies){
		List<String> dependencyStrings=new ArrayList<String>();
		List<Dependency> currentDependencyList = mavenProject.getDependencies();
		for (Dependency dependency : currentDependencyList) {
			String ds = getDependencyString(dependency);
			dependencyStrings.add(ds);
		}
		for (Dependency dependency : dependencies) {
			String dependencyString = getDependencyString(dependency);
			if (!dependencyStrings.contains(dependencyString)){
				mavenProject.getDependencies().add(dependency);
				dependencyStrings.add(dependencyString);
			}
		}
	}
	
	public static Dependency createDependency(String groupId, String artifactId){
		return createDependency(groupId, artifactId, null);
	}

	public static Dependency createDependency(String groupId, String artifactId,
			String version){
		return createDependency(groupId, artifactId, version, null);
	}

	
	public static Dependency createDependency(String groupId, String artifactId,
			String version, String scope){
		return createDependency(groupId, artifactId, version, scope, null);
	}

	public static Dependency createDependency(String groupId, String artifactId,
			String version, String scope, String type){
		return createDependency(groupId, artifactId, version, scope, type, null);
	}
	
	public static MavenProject addProperty(MavenProject mavenProject, Dependency dependency){
		mavenProject.getProperties().put(dependency.getGroupId()+":"+dependency.getArtifactId()+":"+dependency.getVersion(), dependency.getScope());
		dependency.setScope(null);
		return mavenProject;
	}
	
	public static Dependency createDependency(String groupId, String artifactId,
			String version, String scope, String type, String systemPath) {
		Dependency dependency = new Dependency();
		dependency.setGroupId(groupId);
		dependency.setArtifactId(artifactId);
		if (version!=null) {
			dependency.setVersion(version);
		}
		if (scope!=null) {
			dependency.setScope(scope);
		}
		if (systemPath!=null) {
			dependency.setSystemPath(systemPath);
		}
		if (type!=null) {
			dependency.setType(type);
		}
		return dependency;
	}
	
	private static String getDependencyString(Dependency dependency) {
		String ds=dependency.getGroupId()+":"+dependency.getArtifactId()+":"+dependency.getVersion()+":"+dependency.getType()+":";
		return ds;
	}

	
	public static MavenProject getMavenProject(File file) throws MojoExecutionException{
		try {
			MavenXpp3Reader mavenXpp3Reader = new MavenXpp3Reader();
			Model model;
			model = mavenXpp3Reader.read(new FileInputStream(file));
			return new MavenProject(model);
		} catch (Exception e) {
			throw new MojoExecutionException("Error loading maven project",e);
		}
	}
	
	public static void saveMavenProject(MavenProject project, File file) throws Exception{
		MavenXpp3Writer mavenXpp3writer = new MavenXpp3Writer();
		mavenXpp3writer.write(new FileWriter(file), project.getModel());
	}

	public static MavenProject createMavenProject(String groupId, String artifactId, String version, String packagingType) {
		Model model = new Model();
		model.setGroupId(groupId);
		model.setArtifactId(artifactId);
		model.setVersion(version);
		model.setModelVersion("4.0.0");
		model.setName(artifactId);
		model.setDescription(artifactId);
		if (packagingType!=null){
			model.setPackaging(packagingType);
		}
		return new MavenProject(model);
	}
	
	public static Xpp3Dom createMainConfigurationNode(Plugin plugin) {
		String tagName = "configuration";
		Xpp3Dom configuration = createConfigurationNode(tagName);
		plugin.setConfiguration(configuration);
		return configuration;
	}
	
	public static Xpp3Dom createMainConfigurationNode() {
		String tagName = "configuration";
		return createConfigurationNode(tagName);
	}

	public static Xpp3Dom createConfigurationNode(Xpp3Dom parent,String tagName) {
		Xpp3Dom node = createConfigurationNode(tagName);
		parent.addChild(node);
		return node;
	}

	
	public static Xpp3Dom createConfigurationNode(String tagName) {
		Xpp3Dom node = new Xpp3Dom(tagName);
		return node;
	}

	public static Plugin createPluginEntry(MavenProject project, String groupId, String artifactId, String version,boolean isExtension){
		Plugin plugin = new Plugin();
		plugin.setGroupId(groupId);
		plugin.setArtifactId(artifactId);
		plugin.setVersion(version);
		if (isExtension){
			plugin.setExtensions(true);
		}
		MavenUtils.createMainConfigurationNode(plugin);
		project.getBuild().addPlugin(plugin);
		return plugin;
	}
	
	public static String getMavenModuleRelativePath(File mavenModuleProject, File mavenProject){
		File mavenModuleLocation=mavenModuleProject;
		if (mavenModuleProject.getName().equalsIgnoreCase("pom.xml")){
			mavenModuleLocation=mavenModuleProject.getParentFile();
		}
		
		File mavenLocation=mavenProject;
		if (mavenProject.getName().equalsIgnoreCase("pom.xml")){
			mavenLocation=mavenProject.getParentFile();
		}
		
		return FileUtils.getRelativePath(mavenModuleLocation, mavenLocation);
	}
	
	
    private static ArtifactFactory artifactFactory;

    private static ArtifactResolver resolver;

    private static ArtifactRepository localRepository;

    private static List<?> remoteRepositories;

	public static Artifact getResolvedArtifact(Dependency dependency, ArtifactFactory artifactFactory,
			List<?> remoteRepositories, ArtifactRepository localRepository, ArtifactResolver resolver, String scope,
			String artifactSystemPath) throws MojoExecutionException {
		String groupId = dependency.getGroupId();
		String artifactId = dependency.getArtifactId();
		String version = dependency.getVersion();
		String type = dependency.getType();

		if (null != artifactSystemPath) {
			return getResolvedArtifact(groupId, artifactId, version, type, scope, new File(artifactSystemPath),
					artifactFactory, remoteRepositories, localRepository, resolver);
		} else {
			return getResolvedArtifact(groupId, artifactId, version, type, scope, null, artifactFactory,
					remoteRepositories, localRepository, resolver);
		}
	}

	/**
	 * Resolve a maven artifact from specified repositories only
	 * 
	 * @param groupId
	 * @param artifactId
	 * @param version
	 * @param type
	 * @param scope
	 * @param artifactFactory
	 * @param remoteRepositories
	 * @param localRepository
	 * @param resolver
	 * @return resolved artifact
	 * @throws MojoExecutionException
	 */
	public static Artifact getResolvedArtifact(String groupId, String artifactId, String version, String type,
			String scope, ArtifactFactory artifactFactory, List<?> remoteRepositories,
			ArtifactRepository localRepository, ArtifactResolver resolver) throws MojoExecutionException {
		return getResolvedArtifact(groupId, artifactId, version, type, scope, null, artifactFactory,
				remoteRepositories, localRepository, resolver);
	}

	/**
	 * Resolve a maven artifact from specified repositories and the system path
	 * 
	 * @param groupId
	 * @param artifactId
	 * @param version
	 * @param type
	 * @param scope
	 * @param file
	 * @param artifactFactory
	 * @param remoteRepositories
	 * @param localRepository
	 * @param resolver
	 * @return resolved artifact
	 * @throws MojoExecutionException
	 */
	public static Artifact getResolvedArtifact(String groupId, String artifactId, String version, String type,
			String scope, File file, ArtifactFactory artifactFactory, List<?> remoteRepositories,
			ArtifactRepository localRepository, ArtifactResolver resolver) throws MojoExecutionException {
		Artifact artifact = artifactFactory.createArtifact(groupId, artifactId, version, scope, type);

		if (null != file) {
			artifact.setFile(file);
		}

		try {
			resolver.resolve(artifact, remoteRepositories, localRepository);
		} catch (ArtifactResolutionException | ArtifactNotFoundException e) {
			throw new MojoExecutionException("Failed to resolve dependency in system path or specified repositories.",
					e);
		}
		return artifact;
	}

	public static Artifact getResolvedArtifact(String groupId, String artifactId, String version,
			String type, String scope) throws MojoExecutionException {
		Artifact artifact = MavenUtils.artifactFactory.createArtifact(groupId,artifactId,version,scope,type);
		try {
			MavenUtils.resolver.resolve(artifact,MavenUtils.remoteRepositories,MavenUtils.localRepository);
		} catch (ArtifactResolutionException e) {
			throw new MojoExecutionException("ERROR",e); 
		} catch (ArtifactNotFoundException e) {
			throw new MojoExecutionException("ERROR",e); 
		}
		return artifact;
	}

	/**
	 * Resolve maven POM of the given artifact
	 * 
	 * @param dependency
	 * @param artifactFactory
	 * @param remoteRepositories
	 * @param localRepository
	 * @param resolver
	 * @return resolved POM artifact
	 * @throws MojoExecutionException
	 */
	public static Artifact getResolvedArtifactPom(Dependency dependency, ArtifactFactory artifactFactory,
			List<?> remoteRepositories, ArtifactRepository localRepository, ArtifactResolver resolver)
			throws MojoExecutionException {
		Artifact artifact = artifactFactory.createProjectArtifact(dependency.getGroupId(), dependency.getArtifactId(),
				dependency.getVersion());
		if (null != dependency.getScope()) {
			artifact.setScope(dependency.getScope());
		}
		if (null != dependency.getSystemPath()) {
			artifact.setFile(new File(dependency.getSystemPath()));
		}

		try {
			resolver.resolve(artifact, remoteRepositories, localRepository);
		} catch (ArtifactResolutionException | ArtifactNotFoundException e) {
			throw new MojoExecutionException("Failed to resolve artifacts in specified repositories.", e);
		}
		return artifact;
	}
	
	public static void main(String[] args) {
		
	}

	public static void setArtifactFactory(ArtifactFactory artifactFactory) {
		MavenUtils.artifactFactory = artifactFactory;
	}

	public static ArtifactFactory getArtifactFactory() {
		return artifactFactory;
	}

	public static void setResolver(ArtifactResolver resolver) {
		MavenUtils.resolver = resolver;
	}

	public static ArtifactResolver getResolver() {
		return resolver;
	}

	public static void setLocalRepository(ArtifactRepository localRepository) {
		MavenUtils.localRepository = localRepository;
	}

	public static ArtifactRepository getLocalRepository() {
		return localRepository;
	}

	public static void setRemoteRepositories(List<?> remoteRepositories) {
		MavenUtils.remoteRepositories = remoteRepositories;
	}

	public static List<?> getRemoteRepositories() {
		return remoteRepositories;
	}
	
	
	public static void setMavenMetadata(ArtifactFactory artifactFactory, ArtifactResolver resolver, ArtifactRepository localRepository, List<?> remoteRepositories) {
		MavenUtils.artifactFactory = artifactFactory;
		MavenUtils.resolver = resolver;
		MavenUtils.localRepository = localRepository;
		MavenUtils.remoteRepositories = remoteRepositories;
	}
}

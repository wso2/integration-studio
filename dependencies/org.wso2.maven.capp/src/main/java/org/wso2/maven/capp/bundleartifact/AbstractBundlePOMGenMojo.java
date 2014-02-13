package org.wso2.maven.capp.bundleartifact;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;

import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactResolver;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.maven.capp.model.Artifact;
import org.wso2.maven.capp.model.BundlesDataInfo;
import org.wso2.maven.capp.model.LibraryArtifact;
import org.wso2.maven.capp.model.ProjectMapping;
import org.wso2.maven.capp.mojo.AbstractPOMGenMojo;
import org.wso2.maven.capp.utils.CAppMavenUtils;
import org.wso2.maven.capp.utils.CAppUtils;

/**
 * This is the abstract Maven Mojo used for generating a pom for a bundle creation 
 * from the old CApp project structure
 * 
 */
public abstract class AbstractBundlePOMGenMojo extends AbstractPOMGenMojo {

	public MavenProject project;

	public MavenProjectHelper projectHelper;

	public File outputLocation;

	public File artifactLocation;
	
	public File moduleProject;
	
	public String groupId;

	public String typeList;

	public void execute() throws MojoExecutionException, MojoFailureException {
		CAppMavenUtils.setMavenMetadata(getArtifactFactory(), getResolver(), getLocalRepository(), getRemoteRepositories());
		super.execute();
	}
	
	protected void addPlugins(MavenProject artifactMavenProject,Artifact artifact) {
//		addMavenBundlePlugin(artifactMavenProject, artifact);
		
	}

	protected void addMavenBundlePlugin(MavenProject artifactMavenProject,
			Artifact artifact) throws FactoryConfigurationError {
		artifactMavenProject.setPackaging(CAppMavenUtils.BUNDLE_PACKAGING_TYPE);
		artifactMavenProject.getModel().addProperty(CAppUtils.PROPERTY_CAPP_TYPE, getArtifactType());
		Plugin plugin = CAppMavenUtils.createPluginEntry(artifactMavenProject, "org.apache.felix", "maven-bundle-plugin", "2.3.4", true);
		Xpp3Dom config=(Xpp3Dom)plugin.getConfiguration();
		Xpp3Dom instructionNode = CAppMavenUtils.createConfigurationNode(config, "instructions");
		Xpp3Dom symbolicNameNode = CAppMavenUtils.createConfigurationNode(instructionNode, "Bundle-SymbolicName");
		symbolicNameNode.setValue(artifact.getName());
		Xpp3Dom bundleNameNode = CAppMavenUtils.createConfigurationNode(instructionNode, "Bundle-Name");
		bundleNameNode.setValue(artifact.getName());
		String bundleActivatorClass = getBundleActivatorClass(artifact);
		if (bundleActivatorClass!=null){
			Xpp3Dom activatorClassNode = CAppMavenUtils.createConfigurationNode(instructionNode, "Bundle-Activator");
			activatorClassNode.setValue(bundleActivatorClass);
		}
		
		//Embed dependencies
//		Xpp3Dom embedDependencyNode = CAppMavenUtils.createConfigurationNode(instructionNode, "Embed-Dependency");
//		String embedDependencyString=null;
//		List<LibraryArtifact> libraries = getBundlesDataInfo(null, artifact).getLibraries();
//		for (LibraryArtifact libraryArtifact : libraries) {
//			if (embedDependencyString==null){
//				embedDependencyString="";
//			}else{
//				embedDependencyString+=",";
//			}
//			embedDependencyString+=libraryArtifact.getArtifactId()+";scope=compile|runtime;inline=false;";
//		}
//		embedDependencyNode.setValue(embedDependencyString);
		Xpp3Dom exportPackageNode = CAppMavenUtils.createConfigurationNode(instructionNode, "Export-Package");
		exportPackageNode.setValue(getBundlesDataInfo(null, artifact).getAllPackagesString());
		Xpp3Dom dynamicImportNode = CAppMavenUtils.createConfigurationNode(instructionNode, "DynamicImport-Package");
		dynamicImportNode.setValue("*");
	}
	
	protected void addRestrictedMavenBundlePlugin(MavenProject artifactMavenProject,
			Artifact artifact) throws FactoryConfigurationError {
		artifactMavenProject.setPackaging(CAppMavenUtils.BUNDLE_PACKAGING_TYPE);
		artifactMavenProject.getModel().addProperty(CAppUtils.PROPERTY_CAPP_TYPE, getArtifactType());
		Plugin plugin = CAppMavenUtils.createPluginEntry(artifactMavenProject, "org.apache.felix", "maven-bundle-plugin", "2.3.4", true);
		Xpp3Dom config=(Xpp3Dom)plugin.getConfiguration();
		Xpp3Dom instructionNode = CAppMavenUtils.createConfigurationNode(config, "instructions");
		Xpp3Dom symbolicNameNode = CAppMavenUtils.createConfigurationNode(instructionNode, "Bundle-SymbolicName");
		symbolicNameNode.setValue(artifact.getName());
		Xpp3Dom bundleNameNode = CAppMavenUtils.createConfigurationNode(instructionNode, "Bundle-Name");
		bundleNameNode.setValue(artifact.getName());
		String bundleActivatorClass = getBundleActivatorClass(artifact);
		if (bundleActivatorClass!=null){
			Xpp3Dom activatorClassNode = CAppMavenUtils.createConfigurationNode(instructionNode, "Bundle-Activator");
			activatorClassNode.setValue(bundleActivatorClass);
		}
		
		//Embed dependencies
//		Xpp3Dom embedDependencyNode = CAppMavenUtils.createConfigurationNode(instructionNode, "Embed-Dependency");
//		String embedDependencyString=null;
//		List<LibraryArtifact> libraries = getBundlesDataInfo(null, artifact).getLibraries();
//		for (LibraryArtifact libraryArtifact : libraries) {
//			if (embedDependencyString==null){
//				embedDependencyString="";
//			}else{
//				embedDependencyString+=",";
//			}
//			embedDependencyString+=libraryArtifact.getArtifactId()+";scope=compile|runtime;inline=false;";
//		}
//		embedDependencyNode.setValue(embedDependencyString);
		Xpp3Dom exportPackageNode = CAppMavenUtils.createConfigurationNode(instructionNode, "Export-Package");
		exportPackageNode.setValue(getBundlesDataInfo(null, artifact).getAllPackagesString());
		Xpp3Dom dynamicImportNode = CAppMavenUtils.createConfigurationNode(instructionNode, "DynamicImport-Package");
		dynamicImportNode.setValue("*");
		Xpp3Dom importPackageNode = CAppMavenUtils.createConfigurationNode(instructionNode, "Import-Package");
		importPackageNode.setValue("!javax.xml.namespace,javax.xml.namespace; version=0.0.0,*");
	}

	protected void addDependencies(MavenProject artifactMavenProject, Artifact artifact, File projectLocation) {
		getBundlesDataInfo(projectLocation, artifact);
		List<LibraryArtifact> libraries = getBundlesDataInfo(null, artifact).getLibraries();
		for (LibraryArtifact libraryArtifact : libraries) {
			try {
				String groupId = libraryArtifact.getGroupId();
				String artifactId = libraryArtifact.getArtifactId();
				String version = libraryArtifact.getVersion();
				String scope = null;
				String systemPath = null;
				String type = null;
				if (libraryArtifact.isLocal()){
					scope = libraryArtifact.getScope();
					systemPath = "${basedir}/"+FileUtils.getRelativePath(getProjectLocation(), libraryArtifact.getArtifactFile());
				}
				Dependency dependency = CAppMavenUtils.createDependency(groupId, artifactId,
						version, scope, type, systemPath);
				artifactMavenProject.getModel().addDependency(dependency);
			} catch (MojoExecutionException e) {
				getLog().error(e);
				break;
			}
		}
	}

	protected void copyResources(MavenProject project, File projectLocation,
			Artifact artifact) throws IOException {
		setProjectLocation(projectLocation);
		getBundlesDataInfo(projectLocation, artifact);
	}
	
	private BundlesDataInfo bundlesDataInfo;

	protected BundlesDataInfo getBundlesDataInfo(File targetProjectLocation, Artifact artifact)
			throws FactoryConfigurationError {
		if (bundlesDataInfo==null) {
			try {
				bundlesDataInfo = new BundlesDataInfo();
				bundlesDataInfo.setProjects(getProjectMappings());
				bundlesDataInfo.loadFromFile(artifact.getFile());
				List<LibraryArtifact> libraries = bundlesDataInfo
						.getLibraries();
				if (targetProjectLocation!=null) {
					File libFolder = new File(targetProjectLocation, "src"
							+ File.separator + "main" + File.separator
							+ "resources" + File.separator + "lib");
					for (LibraryArtifact libraryArtifact : libraries) {
						if (libraryArtifact.isLocal()) {
							libFolder.mkdirs();
							File artifactFile = libraryArtifact
									.getArtifactFile();
							File file = new File(libFolder, artifactFile
									.getName());
							FileUtils.copy(artifactFile, file);
							libraryArtifact.setArtifactFile(file);
						}
					}
				}
			} catch (Exception e) {
				getLog().error(e);
			}
		}
		return bundlesDataInfo;
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
	
	protected abstract String getBundleActivatorClass(Artifact artifact); 
	protected abstract List<String> getProjectMapStrings();

	public abstract ArtifactFactory getArtifactFactory();

	public abstract ArtifactResolver getResolver();

	public abstract ArtifactRepository getLocalRepository();

	public abstract List<?> getRemoteRepositories();

}

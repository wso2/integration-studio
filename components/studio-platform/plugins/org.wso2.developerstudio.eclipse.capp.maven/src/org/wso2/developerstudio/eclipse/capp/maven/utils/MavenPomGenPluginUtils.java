package org.wso2.developerstudio.eclipse.capp.maven.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.maven.model.Parent;
import org.apache.maven.model.Repository;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.CAppEnvironment;
import org.wso2.developerstudio.eclipse.capp.maven.Activator;
import org.wso2.developerstudio.eclipse.capp.maven.IMavenPluginContributorProvider;
import org.wso2.developerstudio.eclipse.capp.maven.MavenPluginContributor;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class MavenPomGenPluginUtils {
	
	private static final String POM = "pom";
	private static final String JAR_DIRECTORY = "/jar";
	private static final String CAPP_DIRECTORY = "/capp";
	private static final String VERSION = "1.0.0";
	private static final String WSO2_DIST_REPO = "http://dist.wso2.org/maven2";
	private static final String CLASS = "class";
	private static final String EXTENSION = "extension";
	private static final String TYPE = "type";
	private static final String ID = "id";
	private static final String PLUGIN = "plugin";
	private static final String TARGET = "target";
	private static final String MAVEN_DEFINITION_HANDLER_EXTENSION = "org.wso2.developerstudio.eclipse.capp.maven.artifact.mavenplugin.generator";

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	private static Map<String, MavenPluginContributor> archeTypeDefinitions;

	static {
		loadMavenDefinitionExtensionPoint();
	}

	public static Map<String, String> getArtifactTypeExtensionMap() {
		Map<String, MavenPluginContributor> pluginContributors=getPluginContributors();
		Map<String, String> artifactTypeExtensionMap = new HashMap<String, String>();
		for (MavenPluginContributor contributor : pluginContributors.values()) {
			artifactTypeExtensionMap.put(contributor.getArtifactType(),
					contributor.getExtension());
		}
		return artifactTypeExtensionMap;
	}
	
	public static Map<String, MavenPluginContributor> getPluginContributors() {
		if (archeTypeDefinitions == null) {
			archeTypeDefinitions = new HashMap<String, MavenPluginContributor>();
		}
		return archeTypeDefinitions;
	}

	private static void loadMavenDefinitionExtensionPoint() {
		getPluginContributors().clear();
		IConfigurationElement[] config = Platform
				.getExtensionRegistry()
				.getConfigurationElementsFor(MAVEN_DEFINITION_HANDLER_EXTENSION);
		for (IConfigurationElement e : config) {
			try {
				if (e.getName().equals(PLUGIN)) {
					MavenPluginContributor mavenPluginContributor = new MavenPluginContributor();

					String id = e.getAttribute(ID);
					String type = e.getAttribute(TYPE);
					String extension = e.getAttribute(EXTENSION);
					IMavenPluginContributorProvider provider = (IMavenPluginContributorProvider) e
							.createExecutableExtension(CLASS);

					mavenPluginContributor.setArtifactType(type);
					mavenPluginContributor.setExtension(extension);
					mavenPluginContributor.setId(id);
					mavenPluginContributor.setProvider(provider);

					getPluginContributors().put(type, mavenPluginContributor);
				}
			} catch (Exception ex) {
				log.error("Error loading extension point element: " + e.getName(), ex);
			}
		}
	}

	public static void updateAndSaveMavenCAppProject(MavenProject cappBuildMavenProject,IProject eclipseProject, File projectPOM, String parentPomArtifactId) throws Exception{
		//Buid the CAR
		Repository repo = new Repository();
		repo.setUrl(WSO2_DIST_REPO);
		repo.setId("wso2-maven2-repository-1");
		cappBuildMavenProject.getModel().addRepository(repo);
		// Modified the name to different value to support maven 3
		Repository repo1 = new Repository();
		repo1.setUrl(WSO2_DIST_REPO);
		repo1.setId("wso2-maven2-plugin-repository-1");
		cappBuildMavenProject.getModel().addPluginRepository(repo1);
		Map<String, MavenPluginContributor> pluginContributors = MavenPomGenPluginUtils.getPluginContributors();
		Map<String, String> artifactTypeExtensionMap = MavenPomGenPluginUtils.getArtifactTypeExtensionMap();
		for (MavenPluginContributor contributor : pluginContributors.values()) {
			contributor.getProvider().addMavenPlugin(cappBuildMavenProject,
					eclipseProject, artifactTypeExtensionMap);
		}
		File cAppBuilderMavenProjectLocation = CAppEnvironment.getcAppManager().getCAppBuilderMavenProjectLocation(eclipseProject).getLocation().toFile();
		
		//Build the JAR 
		File mavenProjectSaveLocation=CAppEnvironment.getcAppManager().getJarBuilderMavenProjectLocation(eclipseProject).getLocation().toFile();
		mavenProjectSaveLocation.getParentFile().mkdirs();
		MavenProject jarBuildMavenProject;
		if (mavenProjectSaveLocation.exists()){
			jarBuildMavenProject = MavenUtils.updateMavenProjectWithJarBuilderPlugin(eclipseProject, MavenUtils.getMavenProject(mavenProjectSaveLocation), mavenProjectSaveLocation);
		}else{
			jarBuildMavenProject = MavenUtils.updateMavenProjectWithJarBuilderPlugin(eclipseProject, cappBuildMavenProject.getGroupId(), eclipseProject.getName()+".jarbuilder", VERSION, mavenProjectSaveLocation);
		}

		//Build the parent 
		File mavenRootPomSaveLocation = CAppEnvironment.getcAppManager().getCAppParentBuilderMavenProjectLocation(eclipseProject).getLocation().toFile();
		MavenProject rootMavenProject=null;
		if(!mavenRootPomSaveLocation.exists()){
			rootMavenProject = MavenUtils.createMavenProject(cappBuildMavenProject.getGroupId(), parentPomArtifactId, VERSION, POM);
		}else{
			rootMavenProject = MavenUtils.getMavenProject(mavenRootPomSaveLocation);
		}
		MavenUtils.addMavenModulesToMavenProject(rootMavenProject, mavenRootPomSaveLocation, new File[] {cAppBuilderMavenProjectLocation, mavenProjectSaveLocation});

		//Set parent pom & target directories
		File parentTargetDir = new File(mavenRootPomSaveLocation.getParentFile(), TARGET);
		
		Parent parent = new Parent();
		parent.setGroupId(rootMavenProject.getGroupId());
		parent.setArtifactId(rootMavenProject.getArtifactId());
		parent.setVersion(rootMavenProject.getVersion());
		
		cappBuildMavenProject.getModel().setParent(parent);
		cappBuildMavenProject.getBuild().setDirectory(FileUtils.getRelativePath(cAppBuilderMavenProjectLocation.getParentFile(),parentTargetDir)+ CAPP_DIRECTORY);
		
		jarBuildMavenProject.getModel().setParent(parent);
		jarBuildMavenProject.getBuild().setDirectory(FileUtils.getRelativePath(mavenProjectSaveLocation.getParentFile(),parentTargetDir)+ JAR_DIRECTORY);
		
		MavenUtils.saveMavenProject(cappBuildMavenProject, cAppBuilderMavenProjectLocation);
		MavenUtils.saveMavenProject(jarBuildMavenProject, mavenProjectSaveLocation);
		
		
		MavenUtils.saveMavenProject(rootMavenProject, mavenRootPomSaveLocation);
		
		eclipseProject.refreshLocal(IResource.DEPTH_INFINITE,
				new NullProgressMonitor());
	}

	public static MavenProject createMavenCAppProject(String groupId, String artifactId, String version,String packagingType,IProject eclipseProject,File projectPOM, String parentPomArtifactId) throws CoreException, Exception{
		MavenProject selectedProject= MavenUtils.createMavenProject(groupId, artifactId, version, packagingType);
		updateAndSaveMavenCAppProject(selectedProject, eclipseProject, projectPOM, parentPomArtifactId);
		return selectedProject;
	}
}

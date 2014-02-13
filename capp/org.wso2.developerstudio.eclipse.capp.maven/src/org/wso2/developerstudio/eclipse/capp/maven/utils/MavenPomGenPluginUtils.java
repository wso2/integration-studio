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
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static final String MAVEN_DEFINITION_HANDLER_EXTENSION = "org.wso2.developerstudio.eclipse.capp.maven.artifact.mavenplugin.generator";

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
				if (e.getName().equals("plugin")) {
					MavenPluginContributor mavenPluginContributor = new MavenPluginContributor();

					String id = e.getAttribute("id");
					String type = e.getAttribute("type");
					String extension = e.getAttribute("extension");
					IMavenPluginContributorProvider provider = (IMavenPluginContributorProvider) e
							.createExecutableExtension("class");

					mavenPluginContributor.setArtifactType(type);
					mavenPluginContributor.setExtension(extension);
					mavenPluginContributor.setId(id);
					mavenPluginContributor.setProvider(provider);

					getPluginContributors().put(type, mavenPluginContributor);
				}
			} catch (Exception ex) {
				log.error("Error loading extension point element: "
						+ e.getName(), ex);
			}
		}
	}

	public static void updateAndSaveMavenCAppProject(MavenProject cappBuildMavenProject,IProject eclipseProject, File projectPOM, String parentPomArtifactId) throws Exception{
		//Buid the CAR
		Repository repo = new Repository();
		repo.setUrl("http://dist.wso2.org/maven2");
		repo.setId("wso2-maven2-repository-1");
		cappBuildMavenProject.getModel().addRepository(repo);
		// Modified the name to different value to support maven 3
		Repository repo1 = new Repository();
		repo1.setUrl("http://dist.wso2.org/maven2");
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
			jarBuildMavenProject = MavenUtils.updateMavenProjectWithJarBuilderPlugin(eclipseProject, cappBuildMavenProject.getGroupId(), eclipseProject.getName()+".jarbuilder", "1.0.0", mavenProjectSaveLocation);
		}

		//Build the parent 
		File mavenRootPomSaveLocation = CAppEnvironment.getcAppManager().getCAppParentBuilderMavenProjectLocation(eclipseProject).getLocation().toFile();
		MavenProject rootMavenProject=null;
		if(!mavenRootPomSaveLocation.exists()){
			rootMavenProject = MavenUtils.createMavenProject(cappBuildMavenProject.getGroupId(), parentPomArtifactId, "1.0.0", "pom");
		}else{
			rootMavenProject = MavenUtils.getMavenProject(mavenRootPomSaveLocation);
		}
		MavenUtils.addMavenModulesToMavenProject(rootMavenProject, mavenRootPomSaveLocation, new File[] {cAppBuilderMavenProjectLocation, mavenProjectSaveLocation});

		//Set parent pom & target directories
		File parentTargetDir = new File(mavenRootPomSaveLocation.getParentFile(),"target");
		
		Parent parent = new Parent();
		parent.setGroupId(rootMavenProject.getGroupId());
		parent.setArtifactId(rootMavenProject.getArtifactId());
		parent.setVersion(rootMavenProject.getVersion());
		
		cappBuildMavenProject.getModel().setParent(parent);
		cappBuildMavenProject.getBuild().setDirectory(FileUtils.getRelativePath(cAppBuilderMavenProjectLocation.getParentFile(),parentTargetDir)+"/capp");
		
		jarBuildMavenProject.getModel().setParent(parent);
		jarBuildMavenProject.getBuild().setDirectory(FileUtils.getRelativePath(mavenProjectSaveLocation.getParentFile(),parentTargetDir)+"/jar");
		
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

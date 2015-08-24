package org.wso2.developerstudio.eclipse.maven.util;

import org.apache.maven.model.Build;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.model.Repository;
import org.apache.maven.model.RepositoryPolicy;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaLibraryBean;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaLibraryUtil;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

public class MavenUtils {
	private static final String GROUP_ID_ORG_WSO2_MAVEN = "org.wso2.maven";
	private static final String ARTIFACT_ID_MAVEN_BPEL_PLUGIN = "maven-bpel-plugin";
	public static final String CAPP_SCOPE_PREFIX = "capp";
	public static final String PROPERTY_CAPP_TYPE = "CApp.type";
	
	public static MavenProject getMavenProject(File file) throws IOException, XmlPullParserException  {
		MavenXpp3Reader mavenXpp3Reader = new MavenXpp3Reader();
		Model model;
		final FileInputStream stream = new FileInputStream(file);
		model = mavenXpp3Reader.read(stream);
		try {
			if (stream != null) {
				stream.close();
			}
		} catch (IOException e) {
			// ignore, stream is already closed
		}
		return new MavenProject(model);
	}
	
	public static MavenProject getMavenProject(InputStream input) throws Exception {
		MavenXpp3Reader mavenXpp3Reader = new MavenXpp3Reader();
		Model model;
		model = mavenXpp3Reader.read(input);
		return new MavenProject(model);
	}
	
	public static void saveMavenProject(MavenProject project, File file) throws IOException {
		if (file.getParentFile()!=null){
			file.getParentFile().mkdirs();
		}
		MavenXpp3Writer mavenXpp3writer = new MavenXpp3Writer();
		FileWriter fileWriter = new FileWriter(file);
		mavenXpp3writer.write(fileWriter, project.getModel());
		fileWriter.close();
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
		Xpp3Dom configuration = createXpp3Node(tagName);
		plugin.setConfiguration(configuration);
		return configuration;
	}
	
	public static Xpp3Dom createMainConfigurationNode() {
		String tagName = "configuration";
		return createXpp3Node(tagName);
	}
	
	public static Xpp3Dom createMainGoalsNode(Plugin plugin) {
		String tagName = "goals";
		Xpp3Dom configuration = createXpp3Node(tagName);
		plugin.setGoals(configuration);
		return configuration;
	}
	
	public static Xpp3Dom createMainGoalsNode() {
		String tagName = "goals";
		return createXpp3Node(tagName);
	}

	public static Xpp3Dom createXpp3Node(Xpp3Dom parent,String tagName) {
		Xpp3Dom node = createXpp3Node(tagName);
		parent.addChild(node);
		return node;
	}

	public static boolean removeXpp3Node(Xpp3Dom parent,Xpp3Dom child) {
		int removeIndex=-1;
		for(int i=0;i<parent.getChildCount();i++){
			if (parent.getChild(i)==child){
				removeIndex=i;
				break;
			}
		}
		if (removeIndex==-1){
			return false;
		}else{
			parent.removeChild(removeIndex);
			return true;
		}
	}
	
	public static Xpp3Dom createXpp3Node(String tagName) {
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
	
	/**
	 * Checks if a plugin entry already exists with given details
	 * 
	 * @param project
	 * @param groupId
	 * @param artifactId
	 * @param version
	 * @return
	 */
	public static boolean checkOldPluginEntry(MavenProject project, String groupId,
			String artifactId, String version) {
		List<Plugin> plugins = project.getBuild().getPlugins();
		Iterator<Plugin> iterator = plugins.iterator();
		boolean exists = false;
		while (iterator.hasNext()) {
			Plugin plugin = iterator.next();
			if (plugin.getGroupId().equals(groupId) && plugin.getArtifactId().equals(artifactId)) {
				exists = true;
				if (!version.equalsIgnoreCase(plugin.getVersion())) {
					iterator.remove();
					exists = false;
				}
			}
		}
		return exists;
	}
	
	/**
	 * Checks if a plugin entry already exists with given details
	 * 
	 * @param project
	 * @param groupId
	 * @param artifactId
	 * @return
	 */
	public static boolean checkOldPluginEntry(MavenProject project, String groupId, String artifactId) {
		List<Plugin> plugins = project.getBuild().getPlugins();
		Iterator<Plugin> iterator = plugins.iterator();
		while (iterator.hasNext()) {
			Plugin plugin = iterator.next();
			if (plugin.getGroupId().equals(groupId) && plugin.getArtifactId().equals(artifactId)) {
				return true;
			}
		}
		return false;
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
	
	public static MavenProject updateMavenProjectWithJarBuilderPlugin(IProject project, String grpupID, String artifactID, String version, File mavenProjectSaveLocation) throws Exception{
		MavenProject mavenProject = createMavenProject(grpupID, artifactID, version, "jar");
		return updateMavenProjectWithJarBuilderPlugin(project, mavenProject,
				mavenProjectSaveLocation);
	}
	
	public static MavenProject updateMavenProjectWithBundleBuilderPlugin(IProject project, String grpupID, String artifactID, String version, File mavenProjectSaveLocation) throws Exception{
		MavenProject mavenProject = createMavenProject(grpupID, artifactID, version, "bundle");
		return updateMavenProjectWithBundleBuilderPlugin(project, mavenProject,
				mavenProjectSaveLocation);
	}
	
	public static MavenProject updateMavenProjectWithWarBuilderPlugin(IProject project, String grpupID, String artifactID, String version, File mavenProjectSaveLocation) throws Exception{
		MavenProject mavenProject = createMavenProject(grpupID, artifactID, version, "war");
		return updateMavenProjectWithWarBuilderPlugin(project, mavenProject,
				mavenProjectSaveLocation);
	}
	
	public static MavenProject updateMavenProjectWithBpelBuilderPlugin(IProject project, String grpupID, String artifactID, String version, File mavenProjectSaveLocation) throws Exception{
		MavenProject mavenProject = createMavenProject(grpupID, artifactID, version, "bpel/workflow");
		return updateMavenProjectWithBpelBuilderPlugin(project, mavenProject,
				mavenProjectSaveLocation);
	}

	public static MavenProject updateMavenProjectWithJarBuilderPlugin(IProject project,
			MavenProject mavenProject, File mavenProjectSaveLocation)
			throws Exception {
		initializeBuildModel(mavenProject);
		//TODO check if the configurations are already present 
		//before trying to add again
		updateDependecyList(project, mavenProject);
		updateSourceFolder(project, mavenProject,mavenProjectSaveLocation);
//		updateMavenRepo(mavenProject);
		addMavenJarPlugin(mavenProject);
		addMavenCompilerPlugin(mavenProject);
		return mavenProject;
	}
	
	public static MavenProject updateMavenProjectWithBundleBuilderPlugin(IProject project,
	                                                                  MavenProject mavenProject,
	                                                                  File mavenProjectSaveLocation)
	                                                                                                throws Exception {
		initializeBuildModel(mavenProject);
		// TODO check if the configurations are already present
		// before trying to add again
		updateDependecyList(project, mavenProject);
		updateSourceFolder(project, mavenProject, mavenProjectSaveLocation);
//		updateMavenRepo(mavenProject);
		addMavenBundlePluginForCarbonUI(mavenProject,project);
		addMavenCompilerPlugin(mavenProject);
		addMavenDependency(mavenProject, createDependency("org.eclipse.osgi", "org.eclipse.osgi", "3.5.2.R35x_v20100126"));
		return mavenProject;
	}
	
	public static void updateMavenProjectWithCAppType(MavenProject mavenProject,String cappType){
		mavenProject.getModel().addProperty(PROPERTY_CAPP_TYPE, cappType);
	}
	
	public static void updateMavenProjectWithSkipTests(MavenProject mavenProject){
		mavenProject.getModel().addProperty("maven.test.skip","false");
	}
	
	public static MavenProject updateMavenProjectWithWarBuilderPlugin(IProject project,
	                                                                  MavenProject mavenProject,
	                                                                  File mavenProjectSaveLocation)
	                                                                                                throws Exception {
		initializeBuildModel(mavenProject);
		// TODO check if the configurations are already present
		// before trying to add again
		updateDependecyList(project, mavenProject);
		updateSourceFolder(project, mavenProject, mavenProjectSaveLocation);
//		updateMavenRepo(mavenProject);
		addMavenWarPlugin(mavenProject);
		addMavenCompilerPlugin(mavenProject);
		return mavenProject;
	}
	
	public static MavenProject updateMavenProjectWithBpelBuilderPlugin(IProject project,
	                                                                  MavenProject mavenProject,
	                                                                  File mavenProjectSaveLocation)
	                                                                                                throws Exception {
		initializeBuildModel(mavenProject);
		// TODO check if the configurations are already present
		// before trying to add again
	//	updateDependecyList(project, mavenProject);
    //	updateSourceFolder(project, mavenProject, mavenProjectSaveLocation);
//		updateMavenRepo(mavenProject);
		addMavenBpelPlugin(mavenProject);
//		addMavenCompilerPlugin(mavenProject);
		return mavenProject;
	}
	
	public static void updateMavenRepo(MavenProject mavenProject){
		
		List<Repository> newList=mavenProject.getModel().getRepositories();
		List<Repository> existingRepositories = new ArrayList<Repository>();
		for (Repository repository : newList) {
	        existingRepositories.add(repository);
        }
		Repository repo = new Repository();
		repo.setUrl("http://maven.wso2.org/nexus/content/groups/wso2-public/");
		repo.setId("wso2-nexus");
		
		RepositoryPolicy releasePolicy=new RepositoryPolicy();
		releasePolicy.setEnabled(true);
		releasePolicy.setUpdatePolicy("daily");
		releasePolicy.setChecksumPolicy("ignore");
		
		repo.setReleases(releasePolicy);
		
		if(!existingRepositories.isEmpty()){
			for (Repository repository : existingRepositories) {
				if(!repository.getUrl().equalsIgnoreCase(repo.getUrl())){
					mavenProject.getModel().addRepository(repo);
					mavenProject.getModel().addPluginRepository(repo);
				}
			}
		}else{
			mavenProject.getModel().addRepository(repo);
			mavenProject.getModel().addPluginRepository(repo);
		}
		
		
	}

	private static void updateSourceFolder(IProject project, MavenProject mavenProject, File mavenProjectSaveLocation) throws JavaModelException{
		Plugin sourcePluginEntry = createPluginEntry(mavenProject, "org.codehaus.mojo", "build-helper-maven-plugin", "1.8", false);
		PluginExecution pluginExecution=new PluginExecution();
		IPackageFragmentRoot[] sourceFoldersForProject =
		                                                 JavaUtils.getSourceFoldersForProject(project);
		if (sourceFoldersForProject.length > 0) {
			String sourceFolder =
			                      FileUtils.getRelativePath(mavenProjectSaveLocation.getParentFile(),
			                                                sourceFoldersForProject[0].getResource()
			                                                                          .getLocation()
			                                                                          .toFile()).replaceAll(Pattern.quote(File.separator), "/");
			mavenProject.getModel().getBuild().setSourceDirectory(sourceFolder);
			Xpp3Dom configurationNode = createMainConfigurationNode();
			pluginExecution.setConfiguration(configurationNode);
			Xpp3Dom sourcesNode = createXpp3Node(configurationNode, "sources");
			for (int i = 1; i < sourceFoldersForProject.length; i++) {
				IPackageFragmentRoot packageFragmentRoot = sourceFoldersForProject[i];
				File sourceDirectory = packageFragmentRoot.getResource().getLocation().toFile();
				String relativePath =
				                      FileUtils.getRelativePath(mavenProjectSaveLocation.getParentFile(),
				                                                sourceDirectory).replaceAll(Pattern.quote(File.separator), "/");
				Xpp3Dom sourceNode = createXpp3Node(sourcesNode, "source");
				sourceNode.setValue(relativePath);
			}
			sourcePluginEntry.addExecution(pluginExecution);
        }
		
	}
	
	public static void updateDependecyList(IProject project, MavenProject mavenProject) throws Exception {
		List<Dependency> existingDependencies = mavenProject.getModel().getDependencies();
//		List<String> newDependencyStrings=new ArrayList<String>();
//		List<String> existingDependencyStrings=new ArrayList<String>();
		List<Dependency> newDependencyList = new ArrayList<Dependency>();
		
		Map<String, JavaLibraryBean> dependencyInfoMap = JavaLibraryUtil.getDependencyInfoMap(project);
		Map<String, String> map = ProjectDependencyConstants.DEPENDENCY_MAP;
		for (JavaLibraryBean bean : dependencyInfoMap.values()) {
			if (bean.getVersion().contains("${")){
				for(String path: map.keySet()) {
					bean.setVersion(bean.getVersion().replace(path, map.get(path)));
				}
			}
			Dependency dependency = new Dependency();
			dependency.setArtifactId(bean.getArtifactId());
			dependency.setGroupId(bean.getGroupId());
			dependency.setVersion(bean.getVersion());
//			String dependencyString = getDependencyString(dependency);
//			newDependencyStrings.add(dependencyString);
			newDependencyList.add(dependency);
//			if(!dependencies.contains(dependency)){
//				dependencies.add(dependency);
//			}
		}
		
//		for (Dependency dependency : existingDependencies) {
//			String dependencyString = getDependencyString(dependency);
//			existingDependencyStrings.add(dependencyString);
//		}
		
		for (Dependency newDependency : newDependencyList) {
			boolean found=false;
			for (Dependency existingDependency : existingDependencies) {
				if(newDependency.getArtifactId().equals(existingDependency.getArtifactId()) &&
						newDependency.getGroupId().equals(existingDependency.getGroupId()) &&
						newDependency.getVersion().equals(existingDependency.getVersion())){
					found = true;
				}
			}
			if(!found){
				existingDependencies.add(newDependency);
			}
		}
		
//		for (Dependency dependency : newDependencyList) {
//			String dependencyString = getDependencyString(dependency);
//			if (!newDependencyStrings.contains(dependencyString)){
//				existingDependencies.add(dependency);
//			}
//		}
		addMavenDependency(mavenProject, existingDependencies);
	}

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

	private static String getDependencyString(Dependency dependency) {
		String ds=dependency.getGroupId()+":"+dependency.getArtifactId()+":"+dependency.getVersion()+":"+dependency.getType()+":";
		return ds;
	}
	
	public static void addMavenJarPlugin(MavenProject mavenProject){
		Plugin plugin;
		PluginExecution pluginExecution;
		plugin = MavenUtils.createPluginEntry(mavenProject, "org.apache.maven.plugins", "maven-jar-plugin", "2.4", false);
		pluginExecution=new PluginExecution();
		pluginExecution.addGoal("jar");
		pluginExecution.setPhase("package");
		pluginExecution.setId("jar-create-execution");
		plugin.addExecution(pluginExecution);		
	}
	
	public static void updateWithMavenEclipsePlugin(File pomLocation, String[] buildCommands, String[] projectNatures) throws Exception{
		Plugin plugin;
		MavenProject mavenProject = MavenUtils.getMavenProject(pomLocation);
		plugin = MavenUtils.createPluginEntry(mavenProject, "org.apache.maven.plugins", "maven-eclipse-plugin", "2.9", false);
		Xpp3Dom configurationNode = createMainConfigurationNode();
		Xpp3Dom buildCommandsNode = createXpp3Node(configurationNode, "buildcommands");
		for (String string : buildCommands) {
			Xpp3Dom buildCommand = createXpp3Node(buildCommandsNode, "buildcommand");
			buildCommand.setValue(string);
		}
		Xpp3Dom projectNaturesNode = createXpp3Node(configurationNode, "projectnatures");
		for (String string : projectNatures) {
			Xpp3Dom projectNature = createXpp3Node(projectNaturesNode, "projectnature");
			projectNature.setValue(string);
		}
		plugin.setConfiguration(configurationNode);	
		MavenUtils.saveMavenProject(mavenProject, pomLocation);
	}
	
	public static void addMavenBundlePluginForCarbonUI(MavenProject mavenProject, IProject eclipseProject){
//		Plugin plugin;
//		PluginExecution pluginExecution;
//		plugin = MavenUtils.createPluginEntry(mavenProject, "org.apache.maven.plugins", "maven-jar-plugin", "2.2", false);
//		pluginExecution=new PluginExecution();
//		pluginExecution.addGoal("jar");
//		pluginExecution.setPhase("package");
//		pluginExecution.setId("jar-create-execution");
//		plugin.addExecution(pluginExecution);
		IFile manifestFile=eclipseProject.getFile("META-INF"+File.separator+"MANIFEST.MF");
		
		Properties properties=new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream(manifestFile.getLocation().toFile());
			properties.load(fileInputStream);
		
		
			Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.apache.felix", "maven-bundle-plugin", "2.3.7", true);
			Xpp3Dom config=(Xpp3Dom)plugin.getConfiguration();
			Xpp3Dom instructionNode = MavenUtils.createXpp3Node(config, "instructions");
			Xpp3Dom symbolicNameNode = MavenUtils.createXpp3Node(instructionNode, "Bundle-SymbolicName");
			symbolicNameNode.setValue(properties.getProperty("Bundle-SymbolicName"));
			Xpp3Dom bundleNameNode = MavenUtils.createXpp3Node(instructionNode, "Bundle-Name");
			bundleNameNode.setValue(properties.getProperty("Bundle-Name"));
			Xpp3Dom activatorClassNode = MavenUtils.createXpp3Node(instructionNode, "Bundle-Activator");
			activatorClassNode.setValue(properties.getProperty("Bundle-Activator"));
		
			Xpp3Dom includeNode = MavenUtils.createXpp3Node(instructionNode, "_include");
			includeNode.setValue("META-INF/MANIFEST.MF");
			Xpp3Dom exportPackageNode = MavenUtils.createXpp3Node(instructionNode, "Export-Package");
			exportPackageNode.setValue(properties.getProperty("Export-Package",""));
			Xpp3Dom dynamicImportNode = MavenUtils.createXpp3Node(instructionNode, "DynamicImport-Package");
			dynamicImportNode.setValue("*");
			Xpp3Dom includeResourceNode = MavenUtils.createXpp3Node(instructionNode, "Include-Resource");
			includeResourceNode.setValue("META-INF/component.xml = META-INF/component.xml,web = web");
		
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addMavenWarPlugin(MavenProject mavenProject){
		Plugin plugin;
		
		PluginExecution pluginExecution;
		plugin = MavenUtils.createPluginEntry(mavenProject, "org.apache.maven.plugins", "maven-war-plugin", "2.4", false);
		pluginExecution=new PluginExecution();
		pluginExecution.addGoal("war");
		pluginExecution.setPhase("package");
		pluginExecution.setId("war");
		plugin.addExecution(pluginExecution);	
		
		Xpp3Dom config=(Xpp3Dom)plugin.getConfiguration();
		
		Xpp3Dom warSourceDir=createXpp3Node(config, "warSourceDirectory");
		warSourceDir.setValue("WebContent");
		
		mavenProject.getModel().addProperty(PROPERTY_CAPP_TYPE, "web/application");
	}
	
	public static void addMavenBpelPlugin(MavenProject mavenProject){
		Plugin plugin;
		
		PluginExecution pluginExecution;
		plugin = MavenUtils.createPluginEntry(mavenProject, GROUP_ID_ORG_WSO2_MAVEN, ARTIFACT_ID_MAVEN_BPEL_PLUGIN,
				WSO2MavenPluginVersions.getPluginVersion(ARTIFACT_ID_MAVEN_BPEL_PLUGIN), true);
		// FIXME : remove hard-coded version value (cannot use
		// org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants
		// due to cyclic reference)
//		pluginExecution=new PluginExecution();
//		pluginExecution.addGoal("bpel");
//		pluginExecution.setPhase("package");
//		pluginExecution.setId("bpel");
//		plugin.addExecution(pluginExecution)
		
		mavenProject.getModel().addProperty(PROPERTY_CAPP_TYPE, "bpel/workflow");
	}
	
	public static void addMavenCompilerPlugin(MavenProject mavenProject){
		Plugin plugin;
		plugin = MavenUtils.createPluginEntry(mavenProject, "org.apache.maven.plugins", "maven-compiler-plugin", "3.1" , false);
		Xpp3Dom configurationNode = createMainConfigurationNode();
		Xpp3Dom sourceNode = createXpp3Node(configurationNode, "source");
		sourceNode.setValue("1.5");
		Xpp3Dom targetNode = createXpp3Node(configurationNode, "target");
		targetNode.setValue("1.5");
		plugin.setConfiguration(configurationNode);		
	}
	
	public static MavenProject addMavenModulesToMavenProject(MavenProject mavenProject, File mavenProjectLocation, File[] moduleProjectLocations) throws Exception{
		if(mavenProjectLocation.exists() && mavenProjectLocation.isDirectory()){
			mavenProjectLocation = new File(mavenProjectLocation, "pom.xml");
		}
		initializeBuildModel(mavenProject);
		updateModules(mavenProject, mavenProjectLocation, moduleProjectLocations);
//		saveMavenProject(mavenProject,mavenProjectLocation);
		return mavenProject;
	}

	private static void initializeBuildModel(MavenProject mavenProject) {
		Model model = mavenProject.getModel();
		if (model.getBuild()!=null) {
			model.setBuild(new Build());
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

	private static void updateModules(MavenProject mavenProject, File mavenProjectLocation, File[] moduleProjectLocations) {
		String relativePath;
		for (File moduleLocation : moduleProjectLocations) {
			relativePath = FileUtils.getRelativePath(mavenProjectLocation.getParentFile(), moduleLocation.getParentFile());
			if(!mavenProject.getModel().getModules().contains(relativePath)){
				mavenProject.getModel().getModules().add(relativePath);
			}
		}
		
	}
	
	public static void updateMavenProjectWithWSO2Repository(MavenProject mavenProject){
		Repository repo = new Repository();
		repo.setUrl("http://maven.wso2.org/nexus/content/groups/wso2-public/");
		repo.setId("wso2-maven2-repository-1");

		mavenProject.getModel().addRepository(repo);
		mavenProject.getModel().addPluginRepository(repo);
	}
	
	public static void setSourceFolder(MavenProject mavenProject, String sourceDir){
		mavenProject.getBuild().setSourceDirectory(sourceDir);
	}
	
	/**
	 * Upgrade the plugin versions of the given maven project. 
	 * This will change the maven plugin versions of Developer Studio projects 
	 * according to the working version of Developer Studio. 
	 * @param project
	 * @param mavenProject
	 */
	public static void upgradePluginVersions(IProject project, MavenProject mavenProject) {
		List<Plugin> plugins = mavenProject.getBuildPlugins();
		
		for(Plugin plugin : plugins) {
			if (GROUP_ID_ORG_WSO2_MAVEN.equals(plugin.getGroupId())) {
				String newVersion = WSO2MavenPluginVersions.getPluginVersion(plugin.getArtifactId());
				if (newVersion != null && !plugin.getVersion().equals(newVersion)) {
					// Update the plugin version.
					plugin.setVersion(newVersion);
				}
			}
		}
	}
}

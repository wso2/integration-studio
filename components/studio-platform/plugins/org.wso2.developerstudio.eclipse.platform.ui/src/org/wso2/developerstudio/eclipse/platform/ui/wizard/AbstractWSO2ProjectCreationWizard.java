/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.maven.model.Parent;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.Profile;
import org.apache.maven.model.Repository;
import org.apache.maven.model.RepositoryPolicy;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.Activator;
import org.wso2.developerstudio.eclipse.platform.core.model.MavenInfo;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectWizardSettings;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Refreshable;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.MavenDetailsPage;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.ProjectOptionsDataPage;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.ProjectOptionsPage;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public abstract class AbstractWSO2ProjectCreationWizard extends Wizard implements INewWizard, IExecutableExtension {
	protected static final String SNAPSHOTS_UPDATE_POLICY = "SNAPSHOTS_UPDATE_POLICY";
	protected static final String SNAPSHOTS_CHECKSUM_POLICY = "SNAPSHOTS_CHECKSUM_POLICY";
	protected static final String SNAPSHOTS_ENABLED = "SNAPSHOTS_ENABLED";
	protected static final String RELEASES_UPDATE_POLICY = "RELEASES_UPDATE_POLICY";
	protected static final String RELEASES_CHECKSUM_POLICY = "RELEASES_CHECKSUM_POLICY";
	protected static final String RELEASES_ENABLED = "RELEASES_ENABLED";
	protected static final String GLOBAL_REPOSITORY_ID = "GLOBAL_REPOSITORY_ID";
	protected static final String GLOBAL_REPOSITORY_URL = "GLOBAL_REPOSITORY_URL";
	protected static final String DISABLE_WSO2_REPOSITORY = "DISABLE_WSO2_REPOSITORY";
	private static final String GLOBAL_MAVEN_VERSION = "MAVEN_VERSION";
	private static final String GLOBAL_MAVEN_GROUP_ID = "MAVEN_GROUPID";

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private ProjectDataModel model;
	protected IConfigurationElement configElement;
	private ISelection currentSelection;
	private boolean customPageRequired;
	private WizardPage customPage;

	protected final static String DIST_EDITOR_ID =
	                                               "org.wso2.developerstudio.eclipse.distribution.project.editor.DistProjectEditor";
	protected final static String MMM_EDITOR_ID = "org.wso2.developerstudio.eclipse.maven.multi.module.editor.DistProjectEditor";
	protected final static String JDT_BUILD_COMMAND = "org.eclipse.jdt.core.javabuilder";
	protected final static String JDT_PROJECT_NATURE = "org.eclipse.jdt.core.javanature";
	private Map<String, Text> map = new HashMap<String, Text>();
	private IPreferencesService preferencesService = Platform.getPreferencesService();
	private ProjectOptionsDataPage mainWizardPage;
	private MavenDetailsPage mavenDetailPage;
	private String projectNature;
	
	/**
	 * Allows to set the project nature.
	 * 
	 * @param projectNature nature of the project
	 */
	public void setProjectNature(String projectNature) {
		this.projectNature = projectNature;
	}

	public void setMap(String label, Text txt) {
		map.put(label, txt);
	}

	public Map<String, Text> getMap() {
		return map;
	}

	public void addPages() {
		URL resource = getWizardManifest();
		try {
			ProjectWizardSettings settings = new ProjectWizardSettings(resource.openStream(), configElement);
			if (settings.getProjectOptions().size() == 1) {
				getModel().setSelectedOption(settings.getProjectOptions().get(0).getId());
			} else {
				addPage(new ProjectOptionsPage(settings, getModel()));
			}
			
			mainWizardPage = new ProjectOptionsDataPage(settings, getModel(), getCurrentSelection(),
					isRequireProjectLocationSection(), isRequiredWorkingSet(), isRequiredWorkspaceLocation());
			
			addPage(mainWizardPage);
			if (isCustomPageRequired()) {
				addPage(getCustomPage());
			}

			if (isProjectWizard()) {
				mavenDetailPage = new MavenDetailsPage(getModel());
				addPage(mavenDetailPage);
			}
		} catch (Exception e) {
			log.error("error adding pages", e);
		}
	}

	protected Repository getGlobalRepositoryFromPreference() {

		String repoURL =
		                 preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
		                                              GLOBAL_REPOSITORY_URL, null, null);
		if (repoURL != null) {
			Repository repo = new Repository();
			repo.setUrl(repoURL);
			repo.setId(preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
			                                        GLOBAL_REPOSITORY_ID, null, null));
			RepositoryPolicy releasePolicy = new RepositoryPolicy();
			String releaseEnabled =
			                        preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
			                                                     RELEASES_ENABLED, null, null);
			releasePolicy.setEnabled(releaseEnabled != null);
			releasePolicy.setUpdatePolicy(preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
			                                                           RELEASES_UPDATE_POLICY, null, null));
			releasePolicy.setChecksumPolicy(preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
			                                                             RELEASES_CHECKSUM_POLICY, null, null));
			repo.setReleases(releasePolicy);

			RepositoryPolicy snapshotPolicy = new RepositoryPolicy();
			String snapshotsEnabled =
			                          preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
			                                                       SNAPSHOTS_ENABLED, null, null);
			snapshotPolicy.setEnabled(snapshotsEnabled != null);
			snapshotPolicy.setUpdatePolicy(preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
			                                                            SNAPSHOTS_UPDATE_POLICY, null, null));
			snapshotPolicy.setChecksumPolicy(preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
			                                                              SNAPSHOTS_CHECKSUM_POLICY, null, null));
			repo.setSnapshots(snapshotPolicy);

			return repo;
		}
		return null;
	}

	protected boolean isProjectWizard() {
		String projectAttr = configElement.getAttribute("project");
		return projectAttr != null && projectAttr.equals("true");
	}

	protected boolean isRequireProjectLocationSection() {
		return true;
	}

	protected boolean isRequiredWorkingSet() {
		return true;
	}

	protected boolean isRequiredWorkspaceLocation() {
		return false;
	}

	protected boolean isCustomPageRequired() {
		return customPageRequired;
	}

	protected WizardPage getCustomPage() {
		return customPage;
	}

	public void setCustomPage(WizardPage customPage) {
		this.customPage = customPage;
	}

	public void setCustomPage(boolean customPage) {
		this.customPageRequired = customPage;
	}

	public void setInitializationData(IConfigurationElement configElement, String arg1, Object arg2)
	                                                                                                throws CoreException {
		this.configElement = configElement;

	}

	protected URL getWizardManifest() {
		if (configElement != null) {
			String wizardManifestPath = configElement.getAttribute("wizardManifest");
			return Platform.getBundle(configElement.getContributor().getName()).getResource(wizardManifestPath);
		}
		return null;
	}

	public void init(IWorkbench arg0, IStructuredSelection selection) {
		setCurrentSelection(selection);
	}

	public void setModel(ProjectDataModel model) {
		this.model = model;
	}

	public ProjectDataModel getModel() {
		return model;
	}

	/**
	 * There are 3 locations to create project as follows Create project in the
	 * workspace - no validation Create project in the userDefine location - no
	 * validation required Create a project in the selection - Validation
	 * required
	 * 
	 * @return
	 * @throws CoreException
	 */
	public IProject createNewProject() throws CoreException {

		IProject project = null;
		String name = getModel().getProjectName();
		File location = getModel().getLocation();
		String rootWorkspaceLocation =
		                               ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();

		if (rootWorkspaceLocation.equals(location.getPath())) {
			project = createProjectInDefaultWorkspace(name);
		} else if (getModel().isUserSet()) {
			project = createProjectInUserDefineSpace(name, location);
		} else {
			project = createProjectInSelectionSpace(name, location, rootWorkspaceLocation);
		}

		return project;
	}

	private IProject createProjectInUserDefineSpace(String name, File location) throws CoreException {

		location = new File(location.getPath() + File.separator + name);
		getModel().setLocation(location);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(name);
		IProjectDescription newProjectDescription = project.getWorkspace().newProjectDescription(name);
		newProjectDescription.setLocationURI(location.toURI());
		project.create(newProjectDescription, new NullProgressMonitor());
		project.open(new NullProgressMonitor());

		return project;
	}

	private IProject createProjectInSelectionSpace(String name, File location, String rootWorkspaceLocation)
	                                                                                                        throws CoreException {

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(name);
		IProject parentProject = null;

		/*
		 * Parent project selection process may be failed due to some reason but
		 * still project creation process can be
		 * proceed that's why this exception handled and logged
		 */
		try {
			File parentFile = location.getParentFile();
			String parentName = parentFile.getName();
			parentProject = root.getProject(parentName);
			
			boolean parentIsWorkspace = rootWorkspaceLocation != null && rootWorkspaceLocation.equals(parentFile.getPath());

			// Check the selected project is MMM or not
			if (!parentIsWorkspace && parentProject != null && parentProject.hasNature(Constants.MAVEN_MULTI_MODULE_PROJECT_NATURE)) {
				String newLocation = parentFile.getAbsolutePath() + File.separator + name;
				location = new File(newLocation);
				getModel().setLocation(location);
			} else {
				// Create the project in default workspace ignoring the selected parent project
				// type (not a MMM)
				return createProjectInDefaultWorkspace(name);
			}
		} catch (CoreException e) {
			// Create any kind of project in default workspace
			log.warn("Create the project in default workspace location ", e);
			return createProjectInDefaultWorkspace(name);
		}

		//Proceed for the MMM Project Creation
		IProjectDescription newProjectDescription = project.getWorkspace().newProjectDescription(name);
		newProjectDescription.setLocationURI(location.toURI());
		project.create(newProjectDescription, new NullProgressMonitor());
		project.open(new NullProgressMonitor());
		if (null != projectNature) {
			ProjectUtils.addNatureToProject(project, false, projectNature);
		}

		try {
			updateMMMPModuleList(name, parentProject);
		} catch (IOException e) {
			log.error("Error occured while adding " + name + "  to  module list.", e);
		} catch (XmlPullParserException e) {
			log.error("Error occured while adding " + name + "  to  module list. due to parent pom file parser issue",
					e);
		}
		
		return project;
	}

	private IProject createProjectInDefaultWorkspace(String name) throws CoreException {

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(name);
		project.create(new NullProgressMonitor());
		project.open(new NullProgressMonitor());

		return project;
	}

	/**
	 * This method is used to update the module list of Maven multi module
	 * project upon a project creation under MMM project. Fixed TOOLS-1492
	 * 
	 * @param name
	 * @param location
	 * @param root
	 * @throws CoreException
	 * @throws IOException
	 * @throws XmlPullParserException
	 * @throws Exception
	 */
	private void updateMMMPModuleList(String name, IProject parentProject) throws CoreException, IOException,
	                                                                      XmlPullParserException {
		IFile pomFile = parentProject.getFile("pom.xml");
		if (pomFile.exists()) {
			MavenProject mavenProject = MavenUtils.getMavenProject(pomFile.getLocation().toFile());
			mavenProject.getModules().add(name);
			List<String> modules = new ArrayList<>();
			for (String module : mavenProject.getModules()) {
				modules.add(module);
			}
			for (Profile profile : mavenProject.getModel().getProfiles()) {
				for (String module : profile.getModules()) {
					if (!modules.contains(module)) {
						modules.add(module);
					}
				}
			}

			// Add profile to POM if not exits
			updatePOMToProfiles(mavenProject);

			Profile dockerProfile = getMavenProfile(mavenProject,
					Constants.DOCKER_PROFILE);
			Profile kubernetesProfile = getMavenProfile(mavenProject,
					Constants.KUBERNETES_PROFILE);
			Profile defaultProfile = getMavenProfile(mavenProject,
					Constants.DEFAULT_PROFILE);

			mavenProject.getModules().clear();
			dockerProfile.getModules().clear();
			kubernetesProfile.getModules().clear();
			defaultProfile.getModules().clear();

			List<IProject> projectList = new ArrayList<IProject>();
			List<String> nonProjectModuleList = new ArrayList<String>();
			List<String> sortedModuleList = new ArrayList<String>();
			for (String string : modules) {
				IProject projectFromModule = getProjectFromModule(string);
				if (projectFromModule != null) {
					projectList.add(projectFromModule);
				} else {
					nonProjectModuleList.add(string);
				}
			}

			// Add projects to Docker and K8S profile according to nature
			for (IProject iProject : sortProjects(projectList)) {
				String relativePath = FileUtils
						.getRelativePath(parentProject.getLocation().toFile(),
								iProject.getLocation().toFile())
						.replaceAll(Pattern.quote(File.separator), "/");
				if (iProject
						.hasNature(Constants.DOCKER_EXPORTER_PROJECT_NATURE)) {
					dockerProfile.getModules().add(relativePath);
					defaultProfile.getModules().add(relativePath);
				} else if (iProject.hasNature(
						Constants.KUBERNETES_EXPORTER_PROJECT_NATURE)) {
					kubernetesProfile.getModules().add(relativePath);
					defaultProfile.getModules().add(relativePath);
				} else {
					sortedModuleList.add(relativePath);
				}
			}

			sortedModuleList.addAll(nonProjectModuleList);
			mavenProject.getModules().addAll(sortedModuleList);
			
			MavenUtils.saveMavenProject(mavenProject, pomFile.getLocation().toFile());
			parentProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		}
	}

	/**
	 * This method adds profile to the POM file if not exits.
	 * 
	 * @param mavenProject project to which profiles to be added
	 */
	private void updatePOMToProfiles(MavenProject mavenProject) {
		// Checking if profiles exits
		if (mavenProject.getModel().getProfiles().size() != Constants
				.getAllMavenMultiModuleProfiles().size()) {
			for (String profileName : Constants
					.getAllMavenMultiModuleProfiles()) {
				if (profileName.equals(Constants.DEFAULT_PROFILE)) {
					MavenUtils.createProfileEntry(mavenProject, profileName,
							true);
				} else {
					MavenUtils.createProfileEntry(mavenProject, profileName,
							false);
				}
			}
		}
		
		// Moving existing build sections from root to inside the profiles.
		while (!mavenProject.getBuild().getPlugins().isEmpty()) {
			Plugin plugin = mavenProject.getBuild().getPlugins().get(0);
			for (Profile profile : mavenProject.getModel().getProfiles()) {
				profile.getBuild().addPlugin(plugin);
			}
			mavenProject.getBuild().getPlugins().remove(plugin);
		}
	}

	private List<String> getSortedModuleList(List<String> moduleList, IProject parentProject) {
		List<IProject> projectList = new ArrayList<IProject>();
		List<String> nonProjectModuleList = new ArrayList<String>();
		List<String> sortedModuleList = new ArrayList<String>();
		for (String string : moduleList) {
			IProject projectFromModule = getProjectFromModule(string);
			if (projectFromModule != null) {
				projectList.add(projectFromModule);
			} else {
				nonProjectModuleList.add(string);
			}
		}
		projectList = sortProjects(projectList);
		for (IProject iProject : projectList) {
			if (iProject != null && iProject.exists() && iProject.isOpen()) {
				String relativePath =
				                      FileUtils.getRelativePath(parentProject.getLocation().toFile(),
				                                                iProject.getLocation().toFile())
				                               .replaceAll(Pattern.quote(File.separator), "/");
				sortedModuleList.add(relativePath);
			}
		}
		sortedModuleList.addAll(nonProjectModuleList);
		return sortedModuleList;

	}

	private IProject getProjectFromModule(String moduleName) {
		String[] split = moduleName.split(Pattern.quote("/"));
		return ResourcesPlugin.getWorkspace().getRoot().getProject(split[split.length - 1]);
	}
	
	public void createPOM(File pomLocation) throws Exception {
		MavenInfo mavenInfo = getModel().getMavenInfo();

		String customGroupId = preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
		                                                    GLOBAL_MAVEN_GROUP_ID, null, null);
		String customVersion = preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
		                                                    GLOBAL_MAVEN_VERSION, null, null);

		MavenProject mavenProject = MavenUtils.createMavenProject(customGroupId != null ? customGroupId
		                                                                               : mavenInfo.getGroupId(),
		                                                          mavenInfo.getArtifactId(),
		                                                          customVersion != null ? customVersion
		                                                                               : mavenInfo.getVersion(),
		                                                          mavenInfo.getPackageName());
		Parent parentProject = getModel().getMavenInfo().getParentProject();
		if (parentProject != null) {
			mavenProject.getModel().setParent(parentProject);
		}
		String disableWSO2Repo = preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
		                                                      DISABLE_WSO2_REPOSITORY, null, null);
		if (disableWSO2Repo == null) {
			MavenUtils.updateMavenRepo(mavenProject);
		}
		Repository globalRepositoryFromPreference = getGlobalRepositoryFromPreference();

		if (globalRepositoryFromPreference != null) {
			mavenProject.getModel().addRepository(globalRepositoryFromPreference);
			mavenProject.getModel().addPluginRepository(globalRepositoryFromPreference);
		}

		MavenUtils.saveMavenProject(mavenProject, pomLocation);
	}

	public void createPOM(File pomLocation, String packagingType) throws Exception {
		MavenInfo mavenInfo = getModel().getMavenInfo();

		String customGroupId =
		                       preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
		                                                    GLOBAL_MAVEN_GROUP_ID, null, null);
		String customVersion =
		                       preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
		                                                    GLOBAL_MAVEN_VERSION, null, null);

		MavenProject mavenProject =
		                            MavenUtils.createMavenProject(customGroupId != null ? customGroupId
		                                                                               : mavenInfo.getGroupId(),
		                                                          mavenInfo.getArtifactId(),
		                                                          customVersion != null ? customVersion
		                                                                               : mavenInfo.getVersion(),
		                                                          packagingType);

		Parent parentProject = getModel().getMavenInfo().getParentProject();
		if (parentProject != null) {
			mavenProject.getModel().setParent(parentProject);
		}
		String disableWSO2Repo = preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
		                                                      DISABLE_WSO2_REPOSITORY, null, null);
		if (disableWSO2Repo == null) {
			MavenUtils.updateMavenRepo(mavenProject);
		}
		Repository globalRepositoryFromPreference = getGlobalRepositoryFromPreference();

		if (globalRepositoryFromPreference != null) {
			mavenProject.getModel().addRepository(globalRepositoryFromPreference);
			mavenProject.getModel().addPluginRepository(globalRepositoryFromPreference);
		}
		MavenUtils.saveMavenProject(mavenProject, pomLocation);
	}

	public String getMavenGroupId(File pomLocation) {
		String groupId = "org.wso2.carbon";
		if (pomLocation != null && pomLocation.exists()) {
			try {
				MavenProject mavenProject = MavenUtils.getMavenProject(pomLocation);
				groupId = mavenProject.getGroupId();
			} catch (Exception e) {
				log.error("error reading pom file", e);
			}
		}
		return groupId;
	}

	public void refreshDistProjects() {
		try {
			IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
			                                                .getEditorReferences();
			for (IEditorReference reference : editorReferences) {
				// Update referred Maven Multi module project editors and Composite project editors
				if (DIST_EDITOR_ID.equals(reference.getId()) || MMM_EDITOR_ID.equals(reference.getId())) {
					IEditorPart editor = reference.getEditor(false);
					if (editor instanceof Refreshable) {
						Refreshable refreshable = (Refreshable) editor;
						refreshable.refresh();
					}
				}
			}
		} catch (Exception e) {
			log.warn("Cannot refresh Carbon application project list", e);
		}
	}

	public void openEditor(File file) {
		IFile artifact = null;
		if (file != null) {
			try {
				refreshDistProjects();
				artifact = ResourcesPlugin.getWorkspace().getRoot()
				                          .getFileForLocation(Path.fromOSString(file.getAbsolutePath()));
				IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), artifact);
			} catch (Exception e) {
				log.warn("Cannot open resource '" + file.getName() + "' in it's associated editor", e);
			}
		}
	}

	public void setCurrentSelection(ISelection currentSelection) {
		this.currentSelection = currentSelection;
	}

	public ISelection getCurrentSelection() {
		return currentSelection;
	}

	public abstract IResource getCreatedResource();

	/**
	 * This method sort given projects according to their order in which they
	 * should be built.
	 * 
	 * @param projects projects to be sorted
	 * @return sorted projects
	 */
	protected List<IProject> sortProjects(List<IProject> projects) {
		try {
			List<List<IProject>> projectMap = new ArrayList<>();

			for (int i = 0; i < 9; i++) {
				projectMap.add(new ArrayList<IProject>());
			}

			for (IProject iProject : projects) {
				if (iProject.hasNature(Constants.GENERAL_PROJECT_NATURE)) {
					projectMap.get(1).add(iProject);
				} else if (iProject
						.hasNature(Constants.CONNECTOR_PROJECT_NATURE)) {
					projectMap.get(2).add(iProject);
				} else if (iProject
						.hasNature(Constants.DATASOURCE_PROJECT_NATURE)) {
					projectMap.get(3).add(iProject);
				} else if (iProject.hasNature(Constants.DS_PROJECT_NATURE)) {
					projectMap.get(4).add(iProject);
				} else if (iProject
						.hasNature(Constants.MEDIATOR_PROJECT_NATURE)) {
					projectMap.get(5).add(iProject);
				} else if (iProject
						.hasNature(Constants.CARBON_UI_PROJECT_NATURE)) {
					projectMap.get(6).add(iProject);
				} else if (iProject.hasNature(Constants.ESB_PROJECT_NATURE)) {
					projectMap.get(7).add(iProject);
				} else if (iProject
						.hasNature(Constants.DISTRIBUTION_PROJECT_NATURE)) {
					projectMap.get(8).add(iProject);
				} else {
					projectMap.get(0).add(iProject);
				}
			}

			List<IProject> sortedProjects = new ArrayList<>();
			for (List<IProject> list : projectMap) {
				sortedProjects.addAll(list);
			}
			return sortedProjects;
		    
		} catch (CoreException e) {
			log.warn("Project list cannot be sorted", e);
		}
		return projects;
	}
	
	/**
	 * The method find and return a required maven profile.
	 * 
	 * @param project projects in which the profile resides
	 * @param id Id of the profile to be found
	 * @return
	 */
	protected Profile getMavenProfile(MavenProject project, String id) {
		for (Profile profile : project.getModel().getProfiles()) {
			if (profile.getId().equals(id)) {
				return profile;
			}
		}
		return null;
	}
	
	public MavenDetailsPage getMavenDetailPage() {
		return mavenDetailPage;
	}

	public ProjectOptionsDataPage getMainWizardPage() {
		return mainWizardPage;
	}
}

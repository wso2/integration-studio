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

package org.wso2.developerstudio.eclipse.platform.ui.mvn.wizard;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.maven.model.Parent;
import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider.ListData;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;
import org.wso2.developerstudio.eclipse.platform.ui.mvn.util.MavenMultiModuleProjectImageUtils;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class MvnMultiModuleWizard extends AbstractWSO2ProjectCreationWizard {
	private static final String MAVEN_ECLIPSE_PLUGIN = "org.apache.maven.plugins:maven-eclipse-plugin:2.9";
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private MvnMultiModuleModel moduleModel;
	private IProject project;
	private IProject multiModuleProject;

	public MvnMultiModuleWizard() {
		moduleModel = new MvnMultiModuleModel();
		setModel(moduleModel);
		setWindowTitle("Maven Modules Creation Wizard");
		setDefaultPageImageDescriptor(MavenMultiModuleProjectImageUtils.getInstance()
		                                                               .getImageDescriptor("maven-24x24.png"));
		getCurrentSelection();
	}

	public void init() {

		if (multiModuleProject != null) {
			IFile pomFile = multiModuleProject.getFile("pom.xml");
			if (pomFile.exists()) {
				// Parse the pom and see the packaging type
				try {
					moduleModel.setUpdateMode(true);
					MavenProject mavenProject2 = MavenUtils.getMavenProject(pomFile.getLocation().toFile());
					Parent parent = mavenProject2.getModel().getParent();
					if (parent != null) {
						moduleModel.setRequiredParent(true);
						moduleModel.setParentArtifact(parent.getArtifactId());
						moduleModel.setParentGroup(parent.getGroupId());
						moduleModel.setParentVersion(parent.getVersion());
						moduleModel.setRelativePath(parent.getRelativePath());
					}
					setMavenProperty(mavenProject2.getGroupId(), mavenProject2.getArtifactId(),
					                 mavenProject2.getVersion());
					List<String> modules = mavenProject2.getModules();
					MvnMultiModuleProjectList projectListProvider = new MvnMultiModuleProjectList();
					List<ListData> listData = projectListProvider.getListData(null, moduleModel);

					for (ListData data : listData) {
						IProject moduleProject = (IProject) data.getData();
						String relativePath =
						                      FileUtils.getRelativePath(multiModuleProject.getLocation().toFile(),
						                                                moduleProject.getLocation().toFile())
						                               .replaceAll(Pattern.quote(File.separator), "/");
						if (modules.contains(relativePath)) {
							moduleModel.getSelectedProjects().add(moduleProject);
						}
					}

				} catch (Exception e) {
					log.error("Error occured while trying to create the Maven Project", e);
				}
			} else {
				setMavenProperty("com.example", multiModuleProject.getName(), "1.0.0");
			}
		}
	}

	/**
	 * @throws ObserverFailedException
	 */
	private void setMavenProperty(String groupId, String artifactId, String version) {
		try {
			moduleModel.setModelPropertyValue("group.id", groupId);
			moduleModel.setModelPropertyValue("project.name", artifactId);
			moduleModel.setModelPropertyValue("version.id", version);
		} catch (ObserverFailedException e) {
			log.error("Error occured while trying to inject values to the Project Model", e);
		}
	}

	public boolean performFinish() {
		// If the multiModuleProject is not empty, then this is thru UI. Just
		// generate the POM
		MavenProject mavenProject =
		                            MavenUtils.createMavenProject(moduleModel.getGroupId(),
		                                                          moduleModel.getArtifactId(),
		                                                          moduleModel.getVersion(), "pom");

		if (moduleModel.isRequiredParent()) {
			Parent parent = new Parent();
			parent.setArtifactId(moduleModel.getParentArtifact());
			parent.setGroupId(moduleModel.getParentGroup());
			parent.setVersion(moduleModel.getParentVersion());
			String relativePath = moduleModel.getRelativePath();
			if (relativePath != null && !relativePath.trim().isEmpty()) {
				parent.setRelativePath(relativePath);
			}
			mavenProject.getModel().setParent(parent);
		} else {
			mavenProject.getModel().setParent(null);
		}

		List modules = mavenProject.getModules();

		List<IProject> selectedProjects = moduleModel.getSelectedProjects();

		selectedProjects = sortProjects(selectedProjects);

		if (multiModuleProject != null) {
			IFile pomFile = multiModuleProject.getFile("pom.xml");
			if (pomFile.exists()) {
				// Parse the pom and see the packaging type
				try {
					MavenProject mavenProject2 = MavenUtils.getMavenProject(pomFile.getLocation().toFile());
					String packaging = mavenProject2.getPackaging();
					if (!"pom".equalsIgnoreCase(packaging)) {
						addMavenModules(multiModuleProject, mavenProject, modules, selectedProjects, pomFile);
					} else {
						modules = mavenProject2.getModules();
						mavenProject2.setGroupId(moduleModel.getGroupId());
						mavenProject2.setArtifactId(moduleModel.getArtifactId());
						mavenProject2.setVersion(moduleModel.getVersion());
						mavenProject2.getModel().setParent(mavenProject.getModel().getParent());
						addMavenModules(multiModuleProject, mavenProject2, modules, selectedProjects, pomFile);
					}

				} catch (Exception e) {
					log.error("Error occured while trying to generate the Maven Project for the Project Pom", e);
				}

			} else {
				// Since pom is not there, just create the new pom with all the
				// necessary things
				addMavenModules(multiModuleProject, mavenProject, modules, selectedProjects, pomFile);
			}
			// Adding Maven Multi Module Nature to POM generated Project
			addMavenMultiModuleProjectNature(multiModuleProject);

		} else {
			try {
				moduleModel.setProjectName(moduleModel.getArtifactId());
				project = createNewProject();

				addMavenMultiModuleProjectNature(project);

				addMavenModules(project, mavenProject, modules, selectedProjects, project.getFile("pom.xml"));

			} catch (CoreException e) {
				log.error("Error occured while creating the new Maven Multi Module Project", e);
			} catch (ObserverFailedException e) {
				log.error("Error occured while trying to inject values to the Project Model", e);
			}
		}
		return true;
	}

	private void addMavenMultiModuleProjectNature(IProject projectToAdddNature) {
		try {
			ProjectUtils.addNatureToProject(projectToAdddNature, false, Constants.MAVEN_MULTI_MODULE_PROJECT_NATURE);
			projectToAdddNature.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			log.error("Error occured while adding the Maven Multi Module Nature to Project", e);
		}
	}

	/**
	 * @param mavenProject
	 * @param modules
	 * @param selectedProjects
	 * @param pomFile
	 */
	private void addMavenModules(IProject selectedProject, MavenProject mavenProject, List modules,
	                             List<IProject> selectedProjects, IFile pomFile) {
		modules.clear();
		for (IProject iProject : selectedProjects) {
			String relativePath =
			                      FileUtils.getRelativePath(selectedProject.getLocation().toFile(),
			                                                iProject.getLocation().toFile())
			                               .replaceAll(Pattern.quote(File.separator), "/");
			if (!modules.contains(relativePath)) {
				modules.add(relativePath);
			}
		}

		try {
			MavenUtils.saveMavenProject(mavenProject, pomFile.getLocation().toFile());
			selectedProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (Exception e) {
			log.error("Error occured while trying to save the maven project", e);
		}

		try {
			MavenProject mproject = MavenUtils.getMavenProject(pomFile.getLocation().toFile());
			List<Plugin> buildPlugins = mproject.getBuildPlugins();
			if (buildPlugins.isEmpty()) {
				MavenUtils.updateWithMavenEclipsePlugin(pomFile.getLocation().toFile(), new String[] {},
				                                        new String[] { Constants.MAVEN_MULTI_MODULE_PROJECT_NATURE });
			} else {
				for (Plugin plugin : buildPlugins) {
					if (MAVEN_ECLIPSE_PLUGIN.equals(plugin.getId())) {
						break;// Since plugin is already in the pom no need to
						      // add it again
					} else {
						MavenUtils.updateWithMavenEclipsePlugin(pomFile.getLocation().toFile(),
						                                        new String[] {},
						                                        new String[] { Constants.MAVEN_MULTI_MODULE_PROJECT_NATURE });
					}
				}
			}
			selectedProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (Exception e) {
			log.error("Error occured while trying to update the maven project with Eclipse Maven plugin.", e);
		}
	}

	@Override
	public IResource getCreatedResource() {
		return project;
	}

	@Override
	protected boolean isProjectWizard() {
		return false;
	}

	public void setMultiModuleProject(IProject multiModuleProject) {
		this.multiModuleProject = multiModuleProject;
	}

	public IProject getMultiModuleProject() {
		return multiModuleProject;
	}

}

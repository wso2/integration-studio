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
package org.wso2.developerstudio.eclipse.platform.core.project.model;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.Activator;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.model.MavenInfo;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public abstract class ProjectDataModel extends Observable {
	private static IDeveloperStudioLog logger = Logger.getLog(Activator.PLUGIN_ID);
	private String projectName;
	private File location;
	private MavenInfo mavenInfo;
	protected File importFile;
	private IWorkingSet[] selectedWorkingSets;
	private String selectedOption;
	private String groupId = "com.example";
	private boolean isUserSet;
	private boolean isDockerExporterProjectChecked = false;
	private boolean isKubernetesExporterProjectChecked = false;
	private boolean isDirectContainerProjectCreation = false;
	private boolean isCompositeOnClickContainerCreation = false;
	private boolean isDeploymentTomlEnabled = true;
	private String dockerRemoteRepository;
	private IProject selectedCompositeProjectOnCreation;
	private String dockerRemoteTag;
	private String dockerTargetRepository;
	private String dockerTargetTag;
	private String kubeContainerName;
	private String kubeReplicsas;
	private String kubeRemoteRepository;
	private String kubeRemoteTag;
	private String kubeTargetRepository;
	private String kubeTargetTag;
	private Map<String, String> dockerEnvParameters = new HashMap<String, String>();
	private Map<String, String> kubernetesEnvParameters = new HashMap<String, String>();
	private Map<String, String> kubernetesPortParameters = new HashMap<String, String>();

	public IProject getSelectedCompositeProjectOnCreation() {
		return selectedCompositeProjectOnCreation;
	}

	public void setSelectedCompositeProjectOnCreation(IProject selectedCompositeProjectOnCreation) {
		this.selectedCompositeProjectOnCreation = selectedCompositeProjectOnCreation;
	}

	public boolean isCompositeOnClickContainerCreation() {
		return isCompositeOnClickContainerCreation;
	}

	public void setCompositeOnClickContainerCreation(boolean isCompositeOnClickContainerCreation) {
		this.isCompositeOnClickContainerCreation = isCompositeOnClickContainerCreation;
	}

	public boolean isDirectContainerProjectCreation() {
		return isDirectContainerProjectCreation;
	}

	public void setDirectContainerProjectCreation(boolean isDirectContainerProjectCreation) {
		this.isDirectContainerProjectCreation = isDirectContainerProjectCreation;
	}

	public Map<String, String> getKubernetesEnvParameters() {
		return kubernetesEnvParameters;
	}

	public Map<String, String> getKubernetesPortParameters() {
		return kubernetesPortParameters;
	}

	public Map<String, String> getDockerEnvParameters() {
		return dockerEnvParameters;
	}

	public String getKubeRemoteTag() {
		return kubeRemoteTag;
	}

	public void setKubeRemoteTag(String kubeRemoteTag) {
		this.kubeRemoteTag = kubeRemoteTag;
	}

	public String getKubeTargetRepository() {
		return kubeTargetRepository;
	}

	public void setKubeTargetRepository(String kubeTargetRepository) {
		this.kubeTargetRepository = kubeTargetRepository;
	}

	public String getKubeTargetTag() {
		return kubeTargetTag;
	}

	public void setKubeTargetTag(String kubeTargetTag) {
		this.kubeTargetTag = kubeTargetTag;
	}

	public String getKubeContainerName() {
		return kubeContainerName;
	}

	public void setKubeContainerName(String kubeContainerName) {
		this.kubeContainerName = kubeContainerName;
	}

	public String getKubeReplicsas() {
		return kubeReplicsas;
	}

	public void setKubeReplicsas(String kubeReplicsas) {
		this.kubeReplicsas = kubeReplicsas;
	}

	public String getKubeRemoteRepository() {
		return kubeRemoteRepository;
	}

	public void setKubeRemoteRepository(String kubeRemoteRepository) {
		this.kubeRemoteRepository = kubeRemoteRepository;
	}

	public String getDockerRemoteRepository() {
	    return dockerRemoteRepository;
	}

	public void setDockerRemoteRepository(String dockerRemoteRepository) {
		this.dockerRemoteRepository = dockerRemoteRepository;
	}

	public String getDockerRemoteTag() {
	    return dockerRemoteTag;
	}

	public void setDockerRemoteTag(String dockerRemoteTag) {
	    this.dockerRemoteTag = dockerRemoteTag;
	}

	public String getDockerTargetRepository() {
	    return dockerTargetRepository;
	}

	public void setDockerTargetRepository(String dockerTargetRepository) {
	    this.dockerTargetRepository = dockerTargetRepository;
	}

	public String getDockerTargetTag() {
	    return dockerTargetTag;
	}

	public void setDockerTargetTag(String dockerTargetTag) {
	    this.dockerTargetTag = dockerTargetTag;
	}

	public boolean isDockerExporterProjectChecked() {
		return isDockerExporterProjectChecked;
	}

	public boolean isKubernetesExporterProjectChecked() {
		return isKubernetesExporterProjectChecked;
	}

	public void setDockerExporterProjectChecked(boolean dockerExporterProjectChecked) throws ObserverFailedException {
		this.isDockerExporterProjectChecked = dockerExporterProjectChecked;
		trigger();
	}

	public void setKubernetesExporterProjectChecked(boolean kubernetesExporterProjectChecked)
			throws ObserverFailedException {
		this.isKubernetesExporterProjectChecked = kubernetesExporterProjectChecked;
		trigger();
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) throws ObserverFailedException {
		if ((projectName != null) && (!projectName.equals(this.projectName))) {
			this.projectName = projectName;
			trigger();
		}
	}

	public void setGroupId(String groupId) throws ObserverFailedException {
		if (!this.groupId.equals(groupId) && (groupId != null) && (!"".equals(groupId))) {
			this.groupId = groupId;
			trigger();
		}
	}

	public String getGroupId() {
		return groupId;
	}

	public File getLocation() {
		return location;
	}

	public void setLocation(File location) {
		this.location = location;
	}

	public boolean isUserSet() {
		return isUserSet;
	}

	public void setIsUserDefine(boolean isUserSet) {
		this.isUserSet = isUserSet;
	}

	public MavenInfo getMavenInfo() {
		if (mavenInfo == null) {
			mavenInfo = new MavenInfo(getGroupId(), getProjectName(), "1.0.0");
		}
		return mavenInfo;
	}

	public void setMavenInfo(MavenInfo mavenInfo) {

		this.mavenInfo = mavenInfo;
	}

	public void setSelectedOption(String selectedOption) throws ObserverFailedException {
		if (!selectedOption.equals(this.selectedOption)) {
			this.selectedOption = selectedOption;
			trigger();
		}
	}

	public boolean isDeploymentTomlEnabled() {
		return isDeploymentTomlEnabled;
	}

	public void setDeploymentTomlEnabled(boolean isDeploymentTomlEnabled) {
		this.isDeploymentTomlEnabled = isDeploymentTomlEnabled;
	}

	protected void trigger() throws ObserverFailedException {
		try {
			setChanged();
			notifyObservers();
		} catch (Exception e) {
			throw new ObserverFailedException(e);
		}
	}

	public String getSelectedOption() {
		return selectedOption;
	}

	/**
	 * return model data from the property key
	 * 
	 * @param key
	 *            - model property key
	 * @return
	 */
	public Object getModelPropertyValue(String key) {
		if (key.equalsIgnoreCase("project.name")) {
			return getProjectName();
		} else if (key.equalsIgnoreCase("import.file")) {
			return getImportFile();
		}
		return null;
	}

	/**
	 * set model data through property key
	 * 
	 * 
	 * @param key
	 *            - model property key
	 * @param data
	 *            - model data value
	 * 
	 * @return - if true - update the UI control with the value of the model if
	 *         false - only the model will be updated
	 * @throws ObserverFailedException
	 */
	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		if (key.equalsIgnoreCase("project.name")) {
			setProjectName(data.toString());
		} else if (key.equalsIgnoreCase("import.file")) {
			setImportFile((File) data);
		}
		return false;
	}

	public void setImportFile(File importFile) {
		this.importFile = importFile;
		if (importFile.exists()) {
			try {
				setProjectName(ProjectUtils.fileNameWithoutExtension(importFile.getName()));
			} catch (ObserverFailedException e) {
				logger.error("ObserverFailed", e);
			}
		}
	}

	public File getImportFile() {
		return importFile;
	}

	public void setSelectedWorkingSets(IWorkingSet[] selectedWorkingSets) {
		this.selectedWorkingSets = selectedWorkingSets;
	}

	public IWorkingSet[] getSelectedWorkingSets() {
		return selectedWorkingSets;
	}

	public void addToWorkingSet(IProject project) {
		if ((getSelectedWorkingSets() != null) && (project != null)) {
			IWorkingSetManager workingSetManager = PlatformUI.getWorkbench().getWorkingSetManager();
			workingSetManager.addToWorkingSets(project, getSelectedWorkingSets());
		}
	}

	public static IContainer getContainer(File absolutionPath, String projectNature) {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		int length = 0;
		IProject currentSelection = null;
		for (IProject project : projects) {
			try {
				if (project.isOpen() && project.hasNature(projectNature)) {
					File projectLocation = project.getLocation().toFile();
					int projectLocationLength = projectLocation.toString().length();
					if (projectLocationLength > length && projectLocationLength <= absolutionPath.toString().length()) {
						if (absolutionPath.toString().startsWith(projectLocation.toString())) {
							length = projectLocationLength;
							currentSelection = project;
						}
					}
				}
			} catch (CoreException e) {
				logger.error("ObserverFailed ", e);
			}
		}
		IContainer saveLocation = null;
		if (currentSelection != null) {
			String path = absolutionPath.toString()
					.substring(currentSelection.getLocation().toFile().toString().length());

			if (path.equals("")) {
				saveLocation = currentSelection;
			} else {
				saveLocation = currentSelection.getFolder(path);
			}
		}
		return saveLocation;
	}

}

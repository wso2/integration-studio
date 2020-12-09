/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.task.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import static org.wso2.developerstudio.eclipse.artifact.task.util.ArtifactConstants.*;
import static org.wso2.developerstudio.eclipse.platform.core.utils.Constants.ESB_PROJECT_NATURE;

import org.wso2.developerstudio.eclipse.artifact.task.Activator;
import org.wso2.developerstudio.eclipse.artifact.task.validator.TriggerTypeList.TriggerType;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseEntryType;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseFileUtils;
import org.wso2.developerstudio.eclipse.esb.project.utils.ESBProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

/**
 * The model class for task artifact wizard specific objects.
 */
public class TaskModel  extends ProjectDataModel {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	private String name;
	private String group = "synapse.simple.quartz";
	private String taskImplementation = "org.apache.synapse.startup.tasks.MessageInjector";
	private TriggerType triggerType = TriggerType.SIMPLE;
	private int count=1;
	private long interval;
	private String cron;
	private String pinnedServers;
	private IContainer saveLocation;
	private List<OMElement> availableTaskslist;
	private List<OMElement> selectedTasksList;
	
	public TaskModel() {
		availableTaskslist = new ArrayList<OMElement>();
		selectedTasksList = new ArrayList<OMElement>();
	}

	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setSaveLocation(IContainer saveLocation) {
		this.saveLocation = saveLocation;
	}
	public IContainer getSaveLocation() {
		return saveLocation;
	}
	public void setTriggerType(TriggerType triggerType) {
		this.triggerType = triggerType;
	}
	public TriggerType getTriggerType() {
		return triggerType;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getTaskImplementation() {
		return taskImplementation;
	}
	public void setTaskImplementation(String taskImplementation) {
		this.taskImplementation = taskImplementation;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getPinnedServers() {
		return pinnedServers;
	}
	public void setPinnedServers(String pinnedServers) {
		this.pinnedServers = pinnedServers;
	}
	public long getInterval() {
		return interval;
	}
	public void setInterval(long interval) {
		this.interval = interval;
	}
	public String getCron() {
		return cron;
	}
	public void setCron(String cron) {
		this.cron = cron;
	}
	
	@Override
	public Object getModelPropertyValue(String key) {
		Object value = super.getModelPropertyValue(key);
		if (key.equals(Task_Trigger_Type)) {
			value = getTriggerType();
		} else if(key.equals(Task_Name)){
			value = getName();
		} else if(key.equals(Task_Group)){
			value = getGroup();
		} else if(key.equals(Task_Implementation)){
			value = getTaskImplementation();
		} else if(key.equals(Task_Trigger_Count)){
			value = getCount();
		} else if(key.equals(Task_Trigger_Interval)){
			value = getInterval();
		} else if(key.equals(Task_Cron)){
			value = getCron();
		} else if(key.equals(Task_Pinned_Servers)){
			value = getPinnedServers();
		} else if (key.equals(Task_Save_location)) {
			IContainer container= getSaveLocation();
			if(container != null && container instanceof IFolder){
				IFolder templatesFolder = container.getProject().getFolder("src").getFolder("main").getFolder("synapse-config").getFolder("tasks");
				value = templatesFolder;
			}else{
				value = container;
			}
		} else if(key.equals("available.tasks")){
			if(selectedTasksList!=null){
			value = selectedTasksList.toArray();
				}
		}
		return value;
	}
	
	@Override
	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean result = super.setModelPropertyValue(key, data);
		if (key.equals(Task_Trigger_Type)) {
			setTriggerType((TriggerType) data);
		}if (key.equals("import.file")) {
			if (getImportFile() != null && !getImportFile().toString().equals("")) {
				try {
					List<OMElement> availableAPIs = new ArrayList<OMElement>();
					if (SynapseFileUtils.isSynapseConfGiven(getImportFile(),
					                                        SynapseEntryType.TASK)) {
						availableAPIs =
						        SynapseFileUtils.synapseFileProcessing(getImportFile().getPath(),
						                                               SynapseEntryType.TASK);
						setAvailableTaskslist(availableAPIs);
					} else {
						setAvailableTaskslist(new ArrayList<OMElement>());
					}
					result = false;
				} catch (OMException e) {
					log.error("Error reading object model", e);
				} catch (XMLStreamException e) {
					log.error("XML stream error", e);
				} catch (IOException e) {
					log.error("I/O error has occurred", e);
				} catch (Exception e) {
					log.error("An unexpected error has occurred", e);
				}
			}
		}else if(key.equals("available.tasks")){
			Object[] selectedTasks = (Object[])data;
			selectedTasksList.clear();
			for (Object object : selectedTasks) {
				if(object instanceof OMElement){
					if(!selectedTasksList.contains((OMElement)object)){
						selectedTasksList.add((OMElement)object);
					}
				}
			}
		}else if(key.equals(Task_Name)){
			setName(data.toString());
		} else if(key.equals(Task_Group)){
			setGroup(data.toString());
		} else if(key.equals(Task_Implementation)){
			setTaskImplementation(data.toString());
		} else if(key.equals(Task_Trigger_Count)){
			try {
				setCount(Integer.parseInt(data.toString()));
			} catch (NumberFormatException e) {
				/*ignore*/
			}
		} else if(key.equals(Task_Trigger_Interval)){
			try {
				setInterval(Long.parseLong(data.toString()));
			} catch (NumberFormatException e) {
				/*ignore*/
			}
		} else if(key.equals(Task_Cron)){
			setCron(data.toString());
		} else if(key.equals(Task_Pinned_Servers)){
			setPinnedServers(data.toString());
		} else if (key.equals(Task_Save_location)) {
			IContainer container=(IContainer) data;
			if(container != null && container instanceof IFolder){
				IFolder taskFolder = container.getProject().getFolder("src").getFolder("main").getFolder("synapse-config").getFolder("tasks");
				setSaveLocation(taskFolder);
			}else{
				setSaveLocation(container);
			}
		} else if (key.contains(Task_Create_Project)){
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			IProject esbProject = ESBProjectUtils.createESBProject(shell,getLocation());
			if(esbProject!=null){
				setSaveLocation(esbProject);
			}
		}
		return result;
	}
	
	@Override
	public void setLocation(File location) {
		super.setLocation(location);
		File absolutionPath = getLocation();
		if (getSaveLocation() == null && absolutionPath != null) {
			IContainer newSaveLocation =
			        getContainer(absolutionPath, ESB_PROJECT_NATURE);
			setSaveLocation(newSaveLocation);
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
					if (projectLocationLength > length &&
					    projectLocationLength <= absolutionPath.toString().length()) {
						if (absolutionPath.toString().startsWith(projectLocation.toString())) {
							length = projectLocationLength;
							currentSelection = project;
						}
					}
				}
			} catch (CoreException e) {
				log.error("An unexpected error has occurred", e);
			}
		}
		IContainer newTasksSaveLocation = null;
		if (currentSelection != null) {
			String path =
			        absolutionPath.toString().substring(
			                                            currentSelection.getLocation().toFile()
			                                                    .toString().length());

			if (path.equals("")) {
				newTasksSaveLocation = currentSelection;
			} else {
				newTasksSaveLocation = currentSelection.getFolder(path);
			}
		}
		return newTasksSaveLocation;
	}

	public void setAvailableTaskslist(List<OMElement> availableTaskslist) {
		this.availableTaskslist = availableTaskslist;
	}
	public List<OMElement> getAvailableTaskslist() {
		return availableTaskslist;
	}
	public void setSelectedTasksList(List<OMElement> selectedTasksList) {
		this.selectedTasksList = selectedTasksList;
	}
	public List<OMElement> getSelectedTasksList() {
		return selectedTasksList;
	}

}

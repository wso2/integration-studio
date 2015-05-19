/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.synapse.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.artifact.synapse.Activator;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseEntryType;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseFileUtils;
import org.wso2.developerstudio.eclipse.esb.project.utils.ESBProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class SynapseModel extends ProjectDataModel {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	private String name;
	private IContainer esbProject;
	private List<OMElement> availablePLESList;
	private List<OMElement> selectedArtifacts=new ArrayList<OMElement>();

	
 	public Object getModelPropertyValue(String key) {
	  Object modelPropertyValue = super.getModelPropertyValue(key);
	  if(key.equals("config.name")){
			modelPropertyValue = getName();
		}else if(key.equals("save.file")){
			modelPropertyValue = getEsbProject();
		}else if(key.equals("available.af")){
			if(getSelectedArtifacts()!=null){
				modelPropertyValue = getSelectedArtifacts().toArray();
			}
		}
	  return modelPropertyValue;
	} 
	
	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean isUiControlUpdated = super.setModelPropertyValue(key, data);
		if("config.name".equals(key)){
			setName(data.toString());
		}else if ("save.file".equals(key)){
			setEsbProject((IContainer)data);
		}else if("create.esb.prj".equals(key)){
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			IProject esbProject = ESBProjectUtils.createESBProject(shell,getLocation());
			if(esbProject!=null){
				setEsbProject(esbProject);
			}
		}else if ("import.file".equals(key)) {
			if (getImportFile() != null && !getImportFile().toString().equals("")) {
				try {
					 List<OMElement> availablePELSlist = new ArrayList<OMElement>();
					 if (SynapseFileUtils.isSynapseConfGiven(getImportFile(),SynapseEntryType.ALL)) {
						 availablePELSlist =SynapseFileUtils.synapseFileProcessing(getImportFile().getPath(),
						                                               SynapseEntryType.ALL);
						 setAvailablePLESList(availablePELSlist);
					} else {
						setAvailablePLESList(new ArrayList<OMElement>());
					}
					 isUiControlUpdated = false;
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
		} else if (key.equals("available.af")){
			Object[] selectedEPs = (Object[])data;
			if(selectedArtifacts!=null ) selectedArtifacts.clear();
			for (Object object : selectedEPs) {
				if(object instanceof OMElement){
					selectedArtifacts.add((OMElement)object);
				}
			}
			setSelectedArtifacts(selectedArtifacts);
		}
		return isUiControlUpdated;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEsbProject(IContainer esbProject) {
		this.esbProject = esbProject;
	}
	
	public void setEsbProject(String esbProject) {
		this.esbProject = ResourcesPlugin.getWorkspace().getRoot()
        .getContainerForLocation(new Path(esbProject));
	}

	public IContainer getEsbProject() {
		return esbProject;
	}
	

	public void setLocation(File location) {
		super.setLocation(location);
		File absolutionPath = getLocation();
		if (getEsbProject() == null && absolutionPath != null) {
			IContainer newEndpointSaveLocation =
			        getContainer(absolutionPath, "org.wso2.developerstudio.eclipse.esb.project.nature");
			setEsbProject(newEndpointSaveLocation);
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
		IContainer newLocalEntrySaveLocation = null;
		if (currentSelection != null) {
			String path =
			        absolutionPath.toString().substring(
			                                            currentSelection.getLocation().toFile()
			                                                    .toString().length());

			if (path.equals("")) {
				newLocalEntrySaveLocation = currentSelection;
			} else {
				newLocalEntrySaveLocation = currentSelection.getFolder(path);
			}
		}
		return newLocalEntrySaveLocation;
	}
 
	public List<OMElement> getAvailablePLESList() {
		return availablePLESList;
	}

	public void setAvailablePLESList(List<OMElement> availablePLESList) {
		this.availablePLESList = availablePLESList;
	}

	public void setSelectedArtifacts(List<OMElement> selectedArtifacts) {
		this.selectedArtifacts = selectedArtifacts;
	}

	public List<OMElement> getSelectedArtifacts() {
		return selectedArtifacts;
	}

}
